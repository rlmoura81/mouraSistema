package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FundoInvestimentoRepository implements IPadraoRepository{

    String sql = "";
    GrupoFundoRepository gpfundor = new GrupoFundoRepository();
    
    /**
     * <p><strong>EN:</strong> Inserts an investment fund record.</p>
     *
     * <p><strong>IT:</strong> Inserisce un record di fondo di investimento.</p>
     *
     * <p><strong>PT-BR:</strong> Insere um registro de fundo de investimento.</p>
     *
     * @param o EN: object to insert (expected: FundoInvestimento) | IT: oggetto da inserire (atteso: FundoInvestimento) | PT-BR: objeto a ser inserido (esperado: FundoInvestimento)
     * @return EN: created record in the fdinvest table | IT: record creato nella tabella fdinvest | PT-BR: registro criado na tabela fdinvest
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco de dados
     * @since 1.0.0
     */
    @Override
    public void inserir(Object o) {
        FundoInvestimento fi = (FundoInvestimento) o;
        try{
            sql = "INSERT INTO fdinvest (cd_fdinvest, ds_fdinvest, cd_gpfundo, cd_usuario)" +
                  "     VALUES (sq_fdinvest.nextval, ?, ?, ?)";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, fi.getDs_fdinvest());
            ps.setInt(2, fi.getGpfundo().getCd_gpfundo());
            ps.setInt(3, fi.getCd_usuario());
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao inserir:\n" +
                    ex.getMessage());
        }
    }

    /**
     * <p><strong>EN:</strong> Updates an existing investment fund record.</p>
     *
     * <p><strong>IT:</strong> Aggiorna un record esistente di fondo di investimento.</p>
     *
     * <p><strong>PT-BR:</strong> Atualiza um registro existente de fundo de investimento.</p>
     *
     * @param o EN: object with updated data (expected: FundoInvestimento) | IT: oggetto con dati aggiornati (atteso: FundoInvestimento) | PT-BR: objeto com dados atualizados (esperado: FundoInvestimento)
     * @return EN: number of affected rows | IT: numero di righe interessate | PT-BR: número de linhas afetadas
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco de dados
     * @since 1.0.0
     */
    @Override
    public void alterar(Object o) {
        FundoInvestimento fi = (FundoInvestimento) o;
        try{
            sql = "UPDATE fdinvest " +
                  "   SET ds_fdinvest = ?, cd_gpfundo = ?, cd_usuario = ?" +
                  " WHERE cd_fdinvest = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, fi.getDs_fdinvest());
            ps.setInt(2, fi.getGpfundo().getCd_gpfundo());
            ps.setInt(3, fi.getCd_usuario());
            ps.setInt(4, fi.getCd_fdinvest());
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" + 
                    ex.getMessage());
        }
    }

    /**
     * <p><strong>EN:</strong> Deletes an investment fund record.</p>
     *
     * <p><strong>IT:</strong> Elimina un record di fondo di investimento.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui um registro de fundo de investimento.</p>
     *
     * @param o EN: object to delete (expected: FundoInvestimento with ID) | IT: oggetto da eliminare (atteso: FundoInvestimento con ID) | PT-BR: objeto a excluir (esperado: FundoInvestimento com ID)
     * @return EN: number of affected rows | IT: numero di righe interessate | PT-BR: número de linhas afetadas
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco de dados
     * @since 1.0.0
     */
    @Override
    public void excluir(Object o) {
        FundoInvestimento fi = (FundoInvestimento) o ;
        try{
            sql = "DELETE FROM fdinvest " + 
                  " WHERE cd_fdinvest = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, fi.getCd_fdinvest());
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage());
        }
    }

    /**
     * <p><strong>EN:</strong> Retrieves all investment funds.</p>
     *
     * <p><strong>IT:</strong> Recupera tutti i fondi di investimento.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera todos os fundos de investimento.</p>
     *
     * @return EN: list of FundoInvestimento | IT: elenco di FundoInvestimento | PT-BR: lista de FundoInvestimento
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco de dados
     * @since 1.0.0
     */
    @Override
    public ArrayList getLista() {
        ArrayList fdinvest = new ArrayList();
        try{
            sql = "SELECT cd_fdinvest, ds_fdinvest, cd_gpfundo, cd_usuario" + 
                  "  FROM fdinvest";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                FundoInvestimento fi = new FundoInvestimento(
                        rs.getInt("cd_fdinvest"),
                        rs.getString("ds_fdinvest"),
                        (GrupoFundo)gpfundor.getById(rs.getInt("cd_gpfundo")),
                        rs.getInt("cd_usuario"));
                fdinvest.add(fi);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de fundos de investimentos." +
                    ex.getMessage());
        }
        return fdinvest;
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves funds not yet applied to a given account.</p>
     *
     * <p><strong>IT:</strong> Recupera i fondi non ancora applicati a un determinato conto.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera fundos ainda não aplicados a uma determinada conta.</p>
     *
     * @param cd_conta EN: account ID to check exclusions against | IT: ID del conto per verificare le esclusioni | PT-BR: ID da conta para verificar exclusões
     * @return EN: list of available FundoInvestimento for the account | IT: elenco di FundoInvestimento disponibili per il conto | PT-BR: lista de FundoInvestimento disponíveis para a conta
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco de dados
     * @since 1.0.0
     */
    public ArrayList getListaFundoInvestAplic(int cd_conta) {
        ArrayList fdinvest = new ArrayList();
        try{
            sql = "SELECT cd_fdinvest, ds_fdinvest, cd_gpfundo, cd_usuario" + 
                  "  FROM fdinvest" +
                  " WHERE cd_fdinvest NOT IN (SELECT cd_fdinvest " +
                  "                             FROM fdinvestaplic " +
                  "                            WHERE cd_conta = ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_conta);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                FundoInvestimento fi = new FundoInvestimento(
                        rs.getInt("cd_fdinvest"),
                        rs.getString("ds_fdinvest"),
                        (GrupoFundo)gpfundor.getById(rs.getInt("cd_gpfundo")),
                        rs.getInt("cd_usuario"));
                fdinvest.add(fi);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de fundos de investimentos." +
                    ex.getMessage());
        }
        return fdinvest;
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves funds filtered by fund ID.</p>
     *
     * <p><strong>IT:</strong> Recupera i fondi filtrati per ID del fondo.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera fundos filtrados pelo ID do fundo.</p>
     *
     * @param cd_fdinvest EN: fund ID to filter by | IT: ID del fondo per filtrare | PT-BR: ID do fundo para filtrar
     * @return EN: list containing the matching FundoInvestimento | IT: elenco contenente il FundoInvestimento corrispondente | PT-BR: lista contendo o FundoInvestimento correspondente
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco de dados
     * @since 1.0.0
     */
    public ArrayList getListaFundoInvest(int cd_fdinvest) {
        ArrayList fdinvest = new ArrayList();
        try{
            sql = "SELECT cd_fdinvest, ds_fdinvest, cd_gpfundo, cd_usuario" + 
                  "  FROM fdinvest" +
                  " WHERE cd_fdinvest = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_fdinvest);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                FundoInvestimento fi = new FundoInvestimento(
                        rs.getInt("cd_fdinvest"),
                        rs.getString("ds_fdinvest"),
                        (GrupoFundo)gpfundor.getById(rs.getInt("cd_gpfundo")),
                        rs.getInt("cd_usuario"));
                fdinvest.add(fi);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de fundos de investimentos." +
                    ex.getMessage());
        }
        return fdinvest;
    }    
    
    /**
     * <p><strong>EN:</strong> Retrieves a fund by its ID.</p>
     *
     * <p><strong>IT:</strong> Recupera un fondo tramite il suo ID.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera um fundo pelo seu ID.</p>
     *
     * @param id EN: fund ID | IT: ID del fondo | PT-BR: ID do fundo
     * @return EN: FundoInvestimento instance or null if not found | IT: istanza di FundoInvestimento o null se non trovato | PT-BR: instância de FundoInvestimento ou null se não encontrado
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco de dados
     * @since 1.0.0
     */
    @Override
    public Object getById(int id) {
        FundoInvestimento fdinvest = null;
        try{
            sql = "SELECT cd_fdinvest, ds_fdinvest, cd_gpfundo, cd_usuario" + 
                  "  FROM fdinvest" +
                  " WHERE cd_fdinvest = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                fdinvest = new FundoInvestimento(
                        rs.getInt("cd_fdinvest"),
                        rs.getString("ds_fdinvest"),
                        (GrupoFundo)gpfundor.getById(rs.getInt("cd_gpfundo")),
                        rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em fundos de investimentos." +
                    ex.getMessage());
        }
        return fdinvest;
    }
}
