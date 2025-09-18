package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AtivoRepository implements IPadraoRepository{

    String sql = "";    
    TipoAtivoRepository tpativor = new TipoAtivoRepository();
        
    /**
     * <p><strong>EN:</strong> Inserts a new asset (Ativo) into the database with name, ticker, CNPJ, type, and user.</p>
     * <p><strong>IT:</strong> Inserisce un nuovo attivo (Ativo) nel database con nome, ticker, CNPJ, tipo e utente.</p>
     * <p><strong>PT-BR:</strong> Insere um novo ativo no banco de dados com nome, ticker, CNPJ, tipo e usuário.</p>
     *
     * @param o EN: instance of Ativo to insert | IT: istanza di Ativo da inserire | PT-BR: instância de Ativo a inserir
     */
    @Override
    public void inserir(Object o) {
        Ativo ativo = (Ativo) o;        
        try{
            sql = "INSERT INTO ativo (cd_ativo, ds_ativo, ds_sgativo, nm_cnpj, cd_tpativo, cd_usuario)" +
                  "     VALUES (sq_ativo.nextval, ?, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, ativo.getDs_ativo());
            ps.setString(2, ativo.getDs_sgativo());
            ps.setString(3, ativo.getNm_cnpj());
            ps.setInt(4, ativo.getTpativo().getCd_tpativo());
            ps.setInt(5, ativo.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Ativo.", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Ativo", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Updates an existing asset (Ativo) by ID, changing name, ticker, CNPJ, type, and user.</p>
     * <p><strong>IT:</strong> Aggiorna un attivo (Ativo) esistente per ID, modificando nome, ticker, CNPJ, tipo e utente.</p>
     * <p><strong>PT-BR:</strong> Atualiza um ativo (Ativo) existente pelo ID, alterando nome, ticker, CNPJ, tipo e usuário.</p>
     *
     * @param o EN: instance of Ativo with updated data | IT: istanza di Ativo con dati aggiornati | PT-BR: instância de Ativo com dados atualizados
     */
    @Override
    public void alterar(Object o) {
        Ativo ativo = (Ativo) o;        
        try{
            sql = "UPDATE ativo " +
                  "   SET ds_ativo = ?, " +
                  "       ds_sgativo = ?, " +
                  "       nm_cnpj = ?, " +
                  "       cd_tpativo = ?, " +
                  "       cd_usuario = ? " +
                  " WHERE cd_ativo = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, ativo.getDs_ativo());
            ps.setString(2, ativo.getDs_sgativo());
            ps.setString(3, ativo.getNm_cnpj());
            ps.setInt(4, ativo.getTpativo().getCd_tpativo());
            ps.setInt(5, ativo.getCd_usuario());
            ps.setInt(6, ativo.getCd_ativo());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado.", "Ativo", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Ativo", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Deletes an asset (Ativo) from the database using its ID.</p>
     * <p><strong>IT:</strong> Elimina un attivo (Ativo) dal database utilizzando il suo ID.</p>
     * <p><strong>PT-BR:</strong> Exclui um ativo (Ativo) do banco de dados usando seu ID.</p>
     *
     * @param o EN: instance of Ativo identifying the record to delete | IT: istanza di Ativo che identifica il record da eliminare | PT-BR: instância de Ativo que identifica o registro a excluir
     */
    @Override
    public void excluir(Object o) {
        Ativo ativo = (Ativo) o;        
        try{
            sql = "DELETE FROM ativo " +
                  " WHERE cd_ativo = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, ativo.getCd_ativo());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Ativo", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Ativo", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Retrieves all assets (Ativo), ordered by ticker (ds_sgativo).</p>
     * <p><strong>IT:</strong> Recupera tutti gli attivi (Ativo), ordinati per ticker (ds_sgativo).</p>
     * <p><strong>PT-BR:</strong> Recupera todos os ativos (Ativo), ordenados pelo ticker (ds_sgativo).</p>
     *
     * @return EN: list of Ativo objects | IT: elenco di oggetti Ativo | PT-BR: lista de objetos Ativo
     */
    @Override
    public ArrayList getLista() {
        ArrayList ativo = new ArrayList();
        try{
            sql = "SELECT cd_ativo, ds_ativo, ds_sgativo, nm_cnpj, cd_tpativo, cd_usuario" +
                  "  FROM ativo" +
                  " ORDER BY ds_sgativo";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Ativo atv = new Ativo(
                    rs.getInt("cd_ativo"),
                    rs.getString("ds_ativo"),
                    rs.getString("ds_sgativo"),
                    rs.getString("nm_cnpj"),
                    (TipoAtivo)tpativor.getById(rs.getInt("cd_tpativo")),
                    rs.getInt("cd_usuario"));
                ativo.add(atv);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de ativos:\n" +
                    ex.getMessage(), "Ativo", JOptionPane.ERROR_MESSAGE);
        }
        return ativo;
    }

    /**
     * <p><strong>EN:</strong> Retrieves only stock-type assets (cd_tpativo = 1), ordered by ticker.</p>
     * <p><strong>IT:</strong> Recupera solo gli attivi di tipo azione (cd_tpativo = 1), ordinati per ticker.</p>
     * <p><strong>PT-BR:</strong> Recupera apenas ativos do tipo ação (cd_tpativo = 1), ordenados pelo ticker.</p>
     *
     * @return EN: list of Ativo objects | IT: elenco di oggetti Ativo | PT-BR: lista de objetos Ativo
     */
    public ArrayList getListaAcao() {
        ArrayList ativo = new ArrayList();
        try{
            sql = "SELECT cd_ativo, ds_ativo, ds_sgativo, nm_cnpj, cd_tpativo, cd_usuario" +
                  "  FROM ativo" +
                  " WHERE cd_tpativo = 1" +
                  " ORDER BY ds_sgativo";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Ativo atv = new Ativo(
                    rs.getInt("cd_ativo"),
                    rs.getString("ds_ativo"),
                    rs.getString("ds_sgativo"),
                    rs.getString("nm_cnpj"),
                    (TipoAtivo)tpativor.getById(rs.getInt("cd_tpativo")),
                    rs.getInt("cd_usuario"));
                ativo.add(atv);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de ativos de Ações:\n" +
                    ex.getMessage(), "Ativo", JOptionPane.ERROR_MESSAGE);
        }
        return ativo;
    }
 
    /**
     * <p><strong>EN:</strong> Retrieves distinct stock assets that have corporate actions of a given type (cd_tpprovento), ordered by ticker.</p>
     * <p><strong>IT:</strong> Recupera titoli azionari distinti che hanno eventi societari di un dato tipo (cd_tpprovento), ordinati per ticker.</p>
     * <p><strong>PT-BR:</strong> Recupera ações distintas que possuem proventos de um tipo específico (cd_tpprovento), ordenadas pelo ticker.</p>
     *
     * @param cd_tpprovento EN: corporate action type ID | IT: ID del tipo di provento | PT-BR: ID do tipo de provento
     * @return EN: list of Ativo objects | IT: elenco di oggetti Ativo | PT-BR: lista de objetos Ativo
     */
    public ArrayList getListaAcaoProv(int cd_tpprovento) {
        ArrayList ativo = new ArrayList();
        try{
            sql = "SELECT DISTINCT ativo.cd_ativo, ds_ativo, ds_sgativo, nm_cnpj, cd_tpativo, ativo.cd_usuario" +
                  "  FROM ativo, acaoprov" +
                  "  HERE acaoprov.cd_ativo = ativo.cd_ativo" +
                  "   AND acaoprov.cd_tpprovento = ?" +
                  " ORDER BY ds_sgativo";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_tpprovento);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Ativo atv = new Ativo(
                    rs.getInt("cd_ativo"),
                    rs.getString("ds_ativo"),
                    rs.getString("ds_sgativo"),
                    rs.getString("nm_cnpj"),
                    (TipoAtivo)tpativor.getById(rs.getInt("cd_tpativo")),
                    rs.getInt("cd_usuario"));
                ativo.add(atv);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de ativos de Ações:\n" +
                    ex.getMessage(), "Ativo", JOptionPane.ERROR_MESSAGE);
        }
        return ativo;
    }

    /**
     * <p><strong>EN:</strong> Retrieves stock assets that currently have a positive balance (joins with ativosaldo), ordered by ticker.</p>
     * <p><strong>IT:</strong> Recupera titoli azionari con saldo positivo (join con ativosaldo), ordinati per ticker.</p>
     * <p><strong>PT-BR:</strong> Recupera ações com saldo positivo (junção com ativosaldo), ordenadas pelo ticker.</p>
     *
     * @return EN: list of Ativo objects | IT: elenco di oggetti Ativo | PT-BR: lista de objetos Ativo
     */    
    public ArrayList getListaAcaoSaldo() {
        ArrayList ativo = new ArrayList();
        try{
            sql = "SELECT ativo.cd_ativo, ds_ativo, ds_sgativo, nm_cnpj, cd_tpativo, ativo.cd_usuario" +
                  "  FROM ativo, ativosaldo" +
                  " WHERE cd_tpativo = 1" +
                  "   AND nm_qtde > 0" +
                  "   AND ativo.cd_ativo = ativosaldo.cd_ativo" +
                  " ORDER BY ds_sgativo";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Ativo atv = new Ativo(
                    rs.getInt("cd_ativo"),
                    rs.getString("ds_ativo"),
                    rs.getString("ds_sgativo"),
                    rs.getString("nm_cnpj"),
                    (TipoAtivo)tpativor.getById(rs.getInt("cd_tpativo")),
                    rs.getInt("cd_usuario"));
                ativo.add(atv);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de ativos de Ações:\n" +
                    ex.getMessage(), "Ativo", JOptionPane.ERROR_MESSAGE);
        }
        return ativo;
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves distinct stock assets with positive balance and with corporate actions of a given type, ordered by ticker.</p>
     * <p><strong>IT:</strong> Recupera titoli azionari distinti con saldo positivo e con proventi di un tipo specifico, ordinati per ticker.</p>
     * <p><strong>PT-BR:</strong> Recupera ações distintas com saldo positivo e com proventos de um tipo específico, ordenadas pelo ticker.</p>
     *
     * @param num EN: corporate action type ID filter | IT: filtro ID tipo di provento | PT-BR: filtro de ID do tipo de provento
     * @return EN: list of Ativo objects | IT: elenco di oggetti Ativo | PT-BR: lista de objetos Ativo
     */
    public ArrayList getListaAcaoSaldoTpProv(int num) {
        ArrayList ativo = new ArrayList();
        try{
            sql = "SELECT DISTINCT ativo.cd_ativo, ds_ativo, ds_sgativo, nm_cnpj, cd_tpativo, ativo.cd_usuario" +
                  "  FROM ativo, ativosaldo, acaoprov" +
                  " WHERE cd_tpativo = 1" +
                  "   AND nm_qtde > 0" +
                  "   AND ativo.cd_ativo = ativosaldo.cd_ativo" +
                  "   AND ativo.cd_ativo = acaoprov.cd_ativo" +
                  "   AND acaoprov.cd_tpprovento = ?" +
                  " ORDER BY ds_sgativo";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, num);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Ativo atv = new Ativo(
                    rs.getInt("cd_ativo"),
                    rs.getString("ds_ativo"),
                    rs.getString("ds_sgativo"),
                    rs.getString("nm_cnpj"),
                    (TipoAtivo)tpativor.getById(rs.getInt("cd_tpativo")),
                    rs.getInt("cd_usuario"));
                ativo.add(atv);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de ativos de Ações:\n" +
                    ex.getMessage(), "Ativo", JOptionPane.ERROR_MESSAGE);
        }
        return ativo;
    }    
    
    /**
     * <p><strong>EN:</strong> Retrieves only REIT/FII-type assets (cd_tpativo = 2), ordered by ticker.</p>
     * <p><strong>IT:</strong> Recupera solo gli attivi di tipo FII/REIT (cd_tpativo = 2), ordinati per ticker.</p>
     * <p><strong>PT-BR:</strong> Recupera apenas ativos do tipo FII (cd_tpativo = 2), ordenados pelo ticker.</p>
     *
     * @return EN: list of Ativo objects | IT: elenco di oggetti Ativo | PT-BR: lista de objetos Ativo
     */
    public ArrayList getListaFII() {
        ArrayList ativo = new ArrayList();
        try{
            sql = "SELECT cd_ativo, ds_ativo, ds_sgativo, nm_cnpj, cd_tpativo, cd_usuario" +
                  "  FROM ativo" +
                  " WHERE cd_tpativo = 2" +
                  " ORDER BY ds_sgativo";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Ativo atv = new Ativo(
                    rs.getInt("cd_ativo"),
                    rs.getString("ds_ativo"),
                    rs.getString("ds_sgativo"),
                    rs.getString("nm_cnpj"),
                    (TipoAtivo)tpativor.getById(rs.getInt("cd_tpativo")),
                    rs.getInt("cd_usuario"));
                ativo.add(atv);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de ativos de FII:\n" +
                    ex.getMessage(), "Ativo", JOptionPane.ERROR_MESSAGE);
        }
        return ativo;
    }
   
    /**
     * <p><strong>EN:</strong> Retrieves distinct FII assets that have corporate actions of a given type, ordered by ticker.</p>
     * <p><strong>IT:</strong> Recupera FII distinti che hanno proventi di un tipo specifico, ordinati per ticker.</p>
     * <p><strong>PT-BR:</strong> Recupera FIIs distintos que possuem proventos de um tipo específico, ordenados pelo ticker.</p>
     *
     * @param num EN: corporate action type ID | IT: ID del tipo di provento | PT-BR: ID do tipo de provento
     * @return EN: list of Ativo objects | IT: elenco di oggetti Ativo | PT-BR: lista de objetos Ativo
     */
    public ArrayList getListaFIIProv(int num) {
        ArrayList ativo = new ArrayList();
        try{
            sql = "SELECT DISTINCT ativo.cd_ativo, ds_ativo, ds_sgativo, nm_cnpj, cd_tpativo, ativo.cd_usuario" +
                  "  FROM ativo, fdimprov" +
                  " WHERE fdimprov.cd_ativo = ativo.cd_ativo" +
                  "   AND fdimprov.cd_tpprovento = ?" +
                  " ORDER BY ds_sgativo";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, num);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Ativo atv = new Ativo(
                    rs.getInt("cd_ativo"),
                    rs.getString("ds_ativo"),
                    rs.getString("ds_sgativo"),
                    rs.getString("nm_cnpj"),
                    (TipoAtivo)tpativor.getById(rs.getInt("cd_tpativo")),
                    rs.getInt("cd_usuario"));
                ativo.add(atv);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de ativos de Ações:\n" +
                    ex.getMessage(), "Ativo", JOptionPane.ERROR_MESSAGE);
        }
        return ativo;
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves distinct FII assets with positive balance and with corporate actions of a given type, ordered by ticker.</p>
     * <p><strong>IT:</strong> Recupera FII distinti con saldo positivo e con proventi di un tipo specifico, ordinati per ticker.</p>
     * <p><strong>PT-BR:</strong> Recupera FIIs distintos com saldo positivo e com proventos de um tipo específico, ordenados pelo ticker.</p>
     *
     * @param num EN: corporate action type ID filter | IT: filtro ID tipo di provento | PT-BR: filtro de ID do tipo de provento
     * @return EN: list of Ativo objects | IT: elenco di oggetti Ativo | PT-BR: lista de objetos Ativo
     */
    public ArrayList getListaFIISaldo() {
        ArrayList ativo = new ArrayList();
        try{
            sql = "SELECT ativo.cd_ativo, ds_ativo, ds_sgativo, nm_cnpj, cd_tpativo, ativo.cd_usuario" +
                  "  FROM ativo, ativosaldo" +
                  " WHERE cd_tpativo = 2" +
                  "   AND nm_qtde > 0" +
                  "   AND ativo.cd_ativo = ativosaldo.cd_ativo" +  
                  " ORDER BY ds_sgativo";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Ativo atv = new Ativo(
                    rs.getInt("cd_ativo"),
                    rs.getString("ds_ativo"),
                    rs.getString("ds_sgativo"),
                    rs.getString("nm_cnpj"),
                    (TipoAtivo)tpativor.getById(rs.getInt("cd_tpativo")),
                    rs.getInt("cd_usuario"));
                ativo.add(atv);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de ativos de FII:\n" +
                    ex.getMessage(), "Ativo", JOptionPane.ERROR_MESSAGE);
        }
        return ativo;
    }
    
    /**
     * <p><strong>EN:</strong> Finds an asset (Ativo) by its ID and maps the database row to an Ativo object.</p>
     * <p><strong>IT:</strong> Trova un attivo (Ativo) tramite il suo ID e mappa la riga del database in un oggetto Ativo.</p>
     * <p><strong>PT-BR:</strong> Busca um ativo (Ativo) pelo seu ID e mapeia a linha do banco em um objeto Ativo.</p>
     *
     * @param id EN: asset ID | IT: ID dell’attivo | PT-BR: ID do ativo
     * @return EN: Ativo object or null if not found | IT: Oggetto Ativo o null se non trovato | PT-BR: Objeto Ativo ou null se não encontrado
     */
    public ArrayList getListaFIISaldoTpProv(int num) {
        ArrayList ativo = new ArrayList();
        try{
            sql = "SELECT DISTINCT ativo.cd_ativo, ds_ativo, ds_sgativo, nm_cnpj, cd_tpativo, ativo.cd_usuario" +
                  "  FROM ativo, ativosaldo, fdimprov" +
                  " WHERE cd_tpativo = 2" +
                  "   AND nm_qtde > 0" +
                  "   AND ativo.cd_ativo = ativosaldo.cd_ativo" +
                  "   AND ativo.cd_ativo = fdimprov.cd_ativo" +
                  "   AND fdimprov.cd_tpprovento = ?" +
                  " ORDER BY ds_sgativo";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, num);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Ativo atv = new Ativo(
                    rs.getInt("cd_ativo"),
                    rs.getString("ds_ativo"),
                    rs.getString("ds_sgativo"),
                    rs.getString("nm_cnpj"),
                    (TipoAtivo)tpativor.getById(rs.getInt("cd_tpativo")),
                    rs.getInt("cd_usuario"));
                ativo.add(atv);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de ativos de FII:\n" +
                    ex.getMessage(), "Ativo", JOptionPane.ERROR_MESSAGE);
        }
        return ativo;
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves an asset (Ativo) from the database by its ID.</p>
     * <p><strong>IT:</strong> Recupera un attivo (Ativo) dal database tramite il suo ID.</p>
     * <p><strong>PT-BR:</strong> Recupera um ativo (Ativo) do banco de dados pelo seu ID.</p>
     *
     * @param id EN: asset ID to search for | IT: ID dell’attivo da cercare | PT-BR: ID do ativo a ser pesquisado
     * @return EN: Ativo object if found, otherwise null | IT: Oggetto Ativo se trovato, altrimenti null | PT-BR: Objeto Ativo se encontrado, caso contrário null
     */
    @Override
    public Object getById(int id) {
        Ativo ativo = null;
        try{
            sql = "SELECT cd_ativo, ds_ativo, ds_sgativo, nm_cnpj, cd_tpativo, cd_usuario" +
                  "  FROM ativo" +
                  " WHERE cd_ativo = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                ativo = new Ativo(rs.getInt("cd_ativo"),
                    rs.getString("ds_ativo"),
                    rs.getString("ds_sgativo"),
                    rs.getString("nm_cnpj"),
                    (TipoAtivo)tpativor.getById(rs.getInt("cd_tpativo")),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em ativos:\n" +
                    ex.getMessage(), "Ativo", JOptionPane.ERROR_MESSAGE);
        }
        return ativo;
    }
     
}
