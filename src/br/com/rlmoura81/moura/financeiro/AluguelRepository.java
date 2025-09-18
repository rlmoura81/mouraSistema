package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.imovel.Imovel;
import br.com.rlmoura81.moura.imovel.ImovelRepository;
import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalcadastro.PrestadorServico;
import br.com.rlmoura81.moura.principalcadastro.PrestadorServicoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AluguelRepository implements IPadraoRepository{

    String sql = "";    
    Utilidade util = new Utilidade();    
    ImovelRepository imovelr = new ImovelRepository();    
    PrestadorServicoRepository presservr = new PrestadorServicoRepository();
    
    /**
     * <p><strong>EN:</strong> Inserts a new rental (Aluguel) record into the database.  
     * Persists contract name, rent amount, admin fee, deposit day, contract due date, property, provider, and user.</p>
     *
     * <p><strong>IT:</strong> Inserisce un nuovo record di affitto (Aluguel) nel database.  
     * Salva nome del contratto, canone, tassa amministrativa, giorno del deposito, scadenza del contratto, immobile, fornitore e utente.</p>
     *
     * <p><strong>PT-BR:</strong> Insere um novo registro de aluguel no banco de dados.  
     * Persiste nome do contrato, valor do aluguel, taxa administrativa, dia do depósito, vencimento do contrato, imóvel, prestador e usuário.</p>
     *
     * @param o EN: instance of Aluguel to insert | IT: istanza di Aluguel da inserire | PT-BR: instância de Aluguel a inserir
     */
    @Override
    public void inserir(Object o) {
        Aluguel a = (Aluguel) o;
        try{
            sql = "INSERT INTO aluguel (cd_aluguel, nm_contrato, nm_vlaluguel, nm_vladm, dt_deposito, dt_contratovenc, cd_imovel, cd_presserv, cd_usuario)" +
                  "     VALUES (sq_aluguel.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, a.getNm_contrato());
            ps.setBigDecimal(2, a.getNm_vlaluguel());
            ps.setBigDecimal(3, a.getNm_vladm());
            ps.setInt(4, a.getDt_deposito());
            ps.setString(5, Utilidade.formatoData.format(a.getDt_contratovenc().getTime()));
            ps.setInt(6, a.getImovel().getCd_imovel());
            ps.setInt(7, a.getPresserv().getCd_presserv());
            ps.setInt(8, a.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Aluguel", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao inserir:\n" +
                    ex.getMessage(), "Aluguel", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Updates an existing rental (Aluguel) record.  
     * Applies new values for contract, amounts, deposit day, due date, property, and provider, constrained by ID and user.</p>
     *
     * <p><strong>IT:</strong> Aggiorna un record di affitto (Aluguel) esistente.  
     * Applica nuovi valori per contratto, importi, giorno del deposito, scadenza, immobile e fornitore, vincolato da ID e utente.</p>
     *
     * <p><strong>PT-BR:</strong> Atualiza um registro de aluguel (Aluguel) existente.  
     * Aplica novos valores de contrato, valores, dia do depósito, vencimento, imóvel e prestador, restrito por ID e usuário.</p>
     *
     * @param o EN: instance of Aluguel with updated data | IT: istanza di Aluguel con dati aggiornati | PT-BR: instância de Aluguel com dados atualizados
     */
    @Override
    public void alterar(Object o) {
        Aluguel a = (Aluguel) o;
        try{
            sql = "UPDATE aluguel " +
                  "   SET nm_contrato = ?, " +
                  "       nm_vlaluguel = ?, " +
                  "       nm_vladm = ?, " +
                  "       dt_deposito = ?, " +
                  "       dt_contratovenc = ?, " +
                  "       cd_imovel = ?, cd_presserv = ?" +
                  " WHERE cd_aluguel = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, a.getNm_contrato());
            ps.setBigDecimal(2, a.getNm_vlaluguel());
            ps.setBigDecimal(3, a.getNm_vladm());
            ps.setInt(4, a.getDt_deposito());
            ps.setString(5, Utilidade.formatoData.format(a.getDt_contratovenc().getTime()));
            ps.setInt(6, a.getImovel().getCd_imovel());
            ps.setInt(7, a.getPresserv().getCd_presserv());
            ps.setInt(8, a.getCd_aluguel());
            ps.setInt(9, a.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado.", "Aluguel", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Aluguel", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Deletes a rental (Aluguel) record from the database using its ID and user.</p>
     *
     * <p><strong>IT:</strong> Elimina un record di affitto (Aluguel) dal database utilizzando il suo ID e l'utente.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui um registro de aluguel (Aluguel) do banco de dados usando seu ID e usuário.</p>
     *
     * @param o EN: instance of Aluguel identifying the record to delete | IT: istanza di Aluguel che identifica il record da eliminare | PT-BR: instância de Aluguel que identifica o registro a excluir
     */
    @Override
    public void excluir(Object o) {
        Aluguel a = (Aluguel) o;
        try{
            sql = "DELETE FROM aluguel " +
                  " WHERE cd_aluguel = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, a.getCd_aluguel());
            ps.setInt(2, a.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Aluguel", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Aluguel", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Retrieves all rental (Aluguel) records for the logged-in user,  
     * including contract name, amounts, deposit day, contract due date, property, and provider; ordered by contract.</p>
     *
     * <p><strong>IT:</strong> Recupera tutti i record di affitto (Aluguel) per l'utente connesso,  
     * includendo nome del contratto, importi, giorno del deposito, scadenza del contratto, immobile e fornitore; ordinati per contratto.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera todos os registros de aluguel (Aluguel) do usuário logado,  
     * incluindo nome do contrato, valores, dia do depósito, vencimento do contrato, imóvel e prestador; ordenados por contrato.</p>
     *
     * @return EN: list of Aluguel objects | IT: elenco di oggetti Aluguel | PT-BR: lista de objetos Aluguel
     */
    @Override
    public ArrayList getLista() {
        ArrayList aluguel = new ArrayList();
        try{
            sql = "SELECT cd_aluguel, nm_contrato, nm_vlaluguel, nm_vladm, dt_deposito, to_char(dt_contratovenc,'dd/MM/yyyy'), cd_imovel, cd_presserv, cd_usuario" +
                  "  FROM aluguel " +
                  " WHERE cd_usuario = ?" +
                  " ORDER BY nm_contrato";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Aluguel a = new Aluguel(
                        rs.getInt("cd_aluguel"),
                        rs.getString("nm_contrato"),
                        rs.getBigDecimal("nm_vlaluguel"),
                        rs.getBigDecimal("nm_vladm"),
                        rs.getInt("dt_deposito"),
                        util.recebeData(rs.getString("to_char(dt_contratovenc,'dd/MM/yyyy')")),
                        (Imovel)imovelr.getById(rs.getInt("cd_imovel")),
                        (PrestadorServico)presservr.getById(rs.getInt("cd_presserv")),
                        rs.getInt("cd_usuario"));
                aluguel.add(a);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de alugueis:\n" +
                    ex.getMessage(), "Aluguel", JOptionPane.ERROR_MESSAGE);
        }
        return aluguel;
    }

    /**
     * <p><strong>EN:</strong> Retrieves a rental (Aluguel) record by its ID,  
     * mapping contract details, amounts, deposit day, due date, property, provider, and user.</p>
     *
     * <p><strong>IT:</strong> Recupera un record di affitto (Aluguel) tramite il suo ID,  
     * mappando dettagli del contratto, importi, giorno del deposito, scadenza, immobile, fornitore e utente.</p>
     *
     * <p><strong>PT-BR:</strong> Obtém um registro de aluguel (Aluguel) pelo seu ID,  
     * mapeando detalhes do contrato, valores, dia do depósito, vencimento, imóvel, prestador e usuário.</p>
     *
     * @param id EN: unique identifier of the rental | IT: identificatore univoco dell’affitto | PT-BR: identificador único do aluguel
     * @return EN: Aluguel object if found, otherwise null | IT: Oggetto Aluguel se trovato, altrimenti null | PT-BR: Objeto Aluguel se encontrado, caso contrário null
     */
    @Override
    public Object getById(int id) {
        Aluguel a = null;
        try{
            sql = "SELECT cd_aluguel, nm_contrato, nm_vlaluguel, nm_vladm, dt_deposito, to_char(dt_contratovenc,'dd/MM/yyyy'), cd_imovel, cd_presserv, cd_usuario" +
                  "  FROM aluguel " +
                  " WHERE cd_aluguel = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                a = new Aluguel(
                        rs.getInt("cd_aluguel"),
                        rs.getString("nm_contrato"),
                        rs.getBigDecimal("nm_vlaluguel"),
                        rs.getBigDecimal("nm_vladm"),
                        rs.getInt("dt_deposito"),
                        util.recebeData(rs.getString("to_char(dt_contratovenc,'dd/MM/yyyy')")),
                        (Imovel)imovelr.getById(rs.getInt("cd_imovel")),
                        (PrestadorServico)presservr.getById(rs.getInt("cd_presserv")),
                        rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em aluguel:\n" +
                    ex.getMessage(), "Aluguel", JOptionPane.ERROR_MESSAGE);
        }
        return a;
    }
    
}
