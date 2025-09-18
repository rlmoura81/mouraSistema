package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class RendaRepository implements IPadraoRepository{
    
    String sql = "";    
    TipoRendaRepository tprendar = new TipoRendaRepository();        
    Utilidade util = new Utilidade();

    /**
     * <p><strong>EN:</strong> Inserts a new Income record into the database.</p>
     * <p><strong>IT:</strong> Inserisce un nuovo record di Reddito nel database.</p>
     * <p><strong>PT-BR:</strong> Insere um novo registro de Renda no banco de dados.</p>
     *
     * @param o EN: Income object to be saved |
     *          IT: Oggetto Renda da salvare |
     *          PT-BR: Objeto Renda a ser salvo
     * @since 1.0.0
     */
    @Override
    public void inserir(Object o) {
        Renda r = (Renda) o;
        try{
            sql = "INSERT INTO renda (cd_renda, dt_renda, ds_renda, nm_valor, cd_tprenda, cd_usuario)" +
                  "     VALUES (sq_renda.nextval, ?, ?, ?, ?, ?)";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, Utilidade.formatoData.format(r.getDt_renda().getTime()));
            ps.setString(2, r.getDs_renda());
            ps.setBigDecimal(3, r.getNm_valor());
            ps.setInt(4, r.getTprenda().getCd_tprenda());
            ps.setInt(5, r.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Renda", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Renda", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void alterar(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * <p><strong>EN:</strong> Deletes an Income record from the database.</p>
     * <p><strong>IT:</strong> Elimina un record di Reddito dal database.</p>
     * <p><strong>PT-BR:</strong> Exclui um registro de Renda do banco de dados.</p>
     *
     * @param o EN: Income object to be deleted |
     *          IT: Oggetto Renda da eliminare |
     *          PT-BR: Objeto Renda a ser excluído
     * @since 1.0.0
     */
    @Override
    public void excluir(Object o) {
        Renda r = (Renda) o;
        try{
            sql = "DELETE FROM renda " +
                  " WHERE cd_renda = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, r.getCd_renda());
            ps.setInt(2, r.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Renda", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Excluir:\n" +
                    ex.getMessage(), "Renda", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Retrieves all income records for the logged-in user.</p>
     * <p><strong>IT:</strong> Recupera tutti i record di reddito per l'utente connesso.</p>
     * <p><strong>PT-BR:</strong> Recupera todos os registros de renda do usuário logado.</p>
     *
     * @return EN: list of income records | IT: elenco di record di reddito | PT-BR: lista de registros de renda
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco de dados
     * @since 1.0.0
     */
    @Override
    public ArrayList getLista() {
        ArrayList renda = new ArrayList();
        try{
            sql = "SELECT cd_renda, to_char(dt_renda,'dd/MM/yyyy'), ds_renda, nm_valor, cd_tprenda, cd_usuario" +
                  "  FROM renda" +
                  " WHERE cd_usuario = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Renda r = new Renda(
                    rs.getInt("cd_renda"),
                    util.recebeData(rs.getString("to_char(dt_renda,'dd/MM/yyyy')")),
                    rs.getString("ds_renda"),
                    rs.getBigDecimal("nm_valor"),
                    (TipoRenda)tprendar.getById(rs.getInt("cd_tprenda")),
                    rs.getInt("cd_usuario"));
                renda.add(r);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Renda:\n" +
                    ex.getMessage(), "Renda", JOptionPane.ERROR_MESSAGE);
        }
        return renda;
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves income records filtered by income type.</p>
     * <p><strong>IT:</strong> Recupera i record di reddito filtrati per tipo di reddito.</p>
     * <p><strong>PT-BR:</strong> Recupera registros de renda filtrados por tipo de renda.</p>
     *
     * @param cd_tprenda EN: income type ID filter | IT: ID del tipo di reddito | PT-BR: ID do tipo de renda
     * @return EN: list of matching income records | IT: elenco dei record corrispondenti | PT-BR: lista de registros correspondentes
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco de dados
     * @since 1.0.0
     */
    public ArrayList getLista(int cd_tprenda) {
        ArrayList renda = new ArrayList();
        try{
            sql = "SELECT cd_renda, to_char(dt_renda,'dd/MM/yyyy'), ds_renda, nm_valor, cd_tprenda, cd_usuario" +
                  "  FROM renda" +
                  " WHERE cd_tprenda = ?" +
                  "   AND cd_usuario = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_tprenda);
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Renda r = new Renda(
                    rs.getInt("cd_renda"),
                    util.recebeData(rs.getString("to_char(dt_renda,'dd/MM/yyyy')")),
                    rs.getString("ds_renda"),
                    rs.getBigDecimal("nm_valor"),
                    (TipoRenda)tprendar.getById(rs.getInt("cd_tprenda")),
                    rs.getInt("cd_usuario"));
                renda.add(r);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Renda:\n" +
                    ex.getMessage(), "Renda", JOptionPane.ERROR_MESSAGE);
        }
        return renda;
    }

    /**
     * <p><strong>EN:</strong> Retrieves income records within a date range (inclusive).</p>
     * <p><strong>IT:</strong> Recupera i record di reddito entro un intervallo di date (inclusivo).</p>
     * <p><strong>PT-BR:</strong> Recupera registros de renda dentro de um intervalo de datas (inclusivo).</p>
     *
     * @param dtInicial EN: start date (inclusive) | IT: data iniziale (inclusiva) | PT-BR: data inicial (inclusiva)
     * @param dtFinal EN: end date (inclusive) | IT: data finale (inclusiva) | PT-BR: data final (inclusiva)
     * @return EN: list of income records in the given range | IT: elenco dei record di reddito nell'intervallo | PT-BR: lista de registros de renda no intervalo
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco de dados
     * @since 1.0.0
     */
    public ArrayList getLista(Object dtInicial, Object dtFinal) {
        ArrayList renda = new ArrayList();
        try{
            sql = "SELECT cd_renda, to_char(dt_renda,'dd/MM/yyyy'), ds_renda, nm_valor, cd_tprenda, cd_usuario" +
                  "  FROM renda" +
                  " WHERE cd_usuario = ?" +
                  "   AND dt_renda BETWEEN ? AND ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ps.setObject(2, dtInicial);
            ps.setObject(3, dtFinal);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Renda r = new Renda(
                    rs.getInt("cd_renda"),
                    util.recebeData(rs.getString("to_char(dt_renda,'dd/MM/yyyy')")),
                    rs.getString("ds_renda"),
                    rs.getBigDecimal("nm_valor"),
                    (TipoRenda)tprendar.getById(rs.getInt("cd_tprenda")),
                    rs.getInt("cd_usuario"));
                renda.add(r);
            }
            ps.close();            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Renda mensal:\n" +
                    ex.getMessage(), "Renda", JOptionPane.ERROR_MESSAGE);
        }
        return renda;
    }
        
    /**
     * <p><strong>EN:</strong> Retrieves a single income record by its ID.</p>
     * <p><strong>IT:</strong> Recupera un singolo record di reddito tramite il suo ID.</p>
     * <p><strong>PT-BR:</strong> Recupera um único registro de renda pelo seu ID.</p>
     *
     * @param id EN: income ID | IT: ID del reddito | PT-BR: ID da renda
     * @return EN: income record or null if not found | IT: record di reddito o null se non trovato | PT-BR: registro de renda ou null se não encontrado
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco de dados
     * @since 1.0.0
     */
    @Override
    public Object getById(int id) {
        Renda renda = null;
        try{
            sql = "SELECT cd_renda, to_char(dt_renda,'dd/MM/yyyy'), ds_renda, nm_valor, cd_tprenda, cd_usuario" +
                  "  FROM renda" +
                  " WHERE cd_renda = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                renda = new Renda(
                    rs.getInt("cd_renda"),
                    util.recebeData(rs.getString("to_char(dt_renda,'dd/MM/yyyy')")),                        
                    rs.getString("ds_renda"),
                    rs.getBigDecimal("nm_valor"),
                    (TipoRenda)tprendar.getById(rs.getInt("cd_tprenda")),
                    rs.getInt("cd_usuario"));
            }
            ps.close();            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em Renda:\n" +
                    ex.getMessage(), "Renda", JOptionPane.ERROR_MESSAGE);
        }
        return renda;
    }
    
}
