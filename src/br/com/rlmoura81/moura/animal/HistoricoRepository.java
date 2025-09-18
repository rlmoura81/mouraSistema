package br.com.rlmoura81.moura.animal;

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

public class HistoricoRepository implements IPadraoRepository{
    
    AnimalRepository animalr = new AnimalRepository();    
    PrestadorServicoRepository presservr = new PrestadorServicoRepository();        
    TipoRepository tipor = new TipoRepository();    
    Utilidade util = new Utilidade();    
    String sql = "";
    
    /**
     * <p><strong>EN:</strong> Inserts a history record (Historico) into the database.</p>
     *
     * <p><strong>IT:</strong> Inserisce un record di storico (Historico) nel database.</p>
     *
     * <p><strong>PT-BR:</strong> Insere um registro de histórico (Historico) no banco de dados.</p>
     *
     * @param o EN: Historico object to insert | IT: oggetto Historico da inserire | PT-BR: objeto Historico a ser inserido
     * @since 1.0.0
     * @implNote EN: Handles SQL exceptions by showing a dialog; does not rethrow. 
     * IT: Gestisce le eccezioni SQL con una finestra di dialogo; non rilancia. 
     * PT-BR: Trata exceções SQL exibindo um diálogo; não relança.
     */
    @Override
    public void inserir(Object o) {
        Historico h = (Historico) o;
        try{
            sql = "INSERT INTO historico (cd_historico, dt_historico, ds_historico, cd_presserv, cd_animal, cd_tipo, cd_usuario)" +
                  "     VALUES (sq_historico.nextval, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, Utilidade.formatoData.format(h.getDt_historico().getTime()));
            ps.setString(2, h.getDs_historico());
            ps.setInt(3, h.getPresserv().getCd_presserv());
            ps.setInt(4, h.getAnimal().getCd_animal());
            ps.setInt(5, h.getTipo().getCd_tipo());
            ps.setInt(6, h.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Historico", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao inserir:\n" +
                    ex.getMessage(), "Historico", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Updates an existing history record (Historico).</p>
     *
     * <p><strong>IT:</strong> Aggiorna un record di storico (Historico) esistente.</p>
     *
     * <p><strong>PT-BR:</strong> Atualiza um registro de histórico (Historico) existente.</p>
     *
     * @param o EN: Historico object with the updated data | IT: oggetto Historico con i dati aggiornati | PT-BR: objeto Historico com os dados atualizados
     * @since 1.0.0
     * @implNote EN: Record is matched by cd_historico, cd_animal, and cd_usuario; SQL errors are handled via dialog. 
     * IT: Il record è individuato da cd_historico, cd_animal e cd_usuario; errori SQL gestiti tramite dialog. 
     * PT-BR: O registro é identificado por cd_historico, cd_animal e cd_usuario; erros SQL são tratados via diálogo.
     */
    @Override
    public void alterar(Object o) {
        Historico h = (Historico) o;
        try{
            sql = "UPDATE historico " +
                  "   SET dt_historico = ?, " +
                  "       ds_historico = ?, " +
                  "       cd_presserv = ?, " +
                  "       cd_tipo = ?" +
                  " WHERE cd_historico = ? " +
                  "   AND cd_animal = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, Utilidade.formatoData.format(h.getDt_historico().getTime()));
            ps.setString(2, h.getDs_historico());
            ps.setInt(3, h.getPresserv().getCd_presserv());
            ps.setInt(4, h.getTipo().getCd_tipo());
            ps.setInt(5, h.getCd_historico());
            ps.setInt(6, h.getAnimal().getCd_animal());
            ps.setInt(7, h.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Historico", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Historico", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Deletes a history record (Historico) by its ID and user.</p>
     *
     * <p><strong>IT:</strong> Elimina un record di storico (Historico) per ID e utente.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui um registro de histórico (Historico) pelo seu ID e usuário.</p>
     *
     * @param o EN: Historico object containing the identifier(s) for deletion | IT: oggetto Historico con gli identificatori per l'eliminazione | PT-BR: objeto Historico contendo os identificadores para exclusão
     * @since 1.0.0
     * @implNote EN: Shows a confirmation/info dialog; SQL errors are handled via dialog. 
     * IT: Mostra una finestra informativa; errori SQL gestiti tramite dialog. 
     * PT-BR: Exibe diálogo informativo; erros SQL são tratados via diálogo.
     */
    @Override
    public void excluir(Object o) {
        Historico h = (Historico) o;
        try{
            sql = "DELETE FROM historico " +
                  " WHERE cd_historico = ? " + 
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, h.getCd_historico());
            ps.setInt(2, h.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido", "Historico", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Historico", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public ArrayList getLista() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves the list of history records (Historico) for the given animal and current user, ordered by date.</p>
     *
     * <p><strong>IT:</strong> Recupera l'elenco dei record di storico (Historico) per l'animale indicato e l'utente corrente, ordinati per data.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera a lista de registros de histórico (Historico) para o animal informado e o usuário atual, ordenados por data.</p>
     *
     * @param cd_animal EN: animal identifier to filter records | IT: identificatore dell'animale per filtrare i record | PT-BR: identificador do animal para filtrar os registros
     * @return EN: list of Historico objects | IT: elenco di oggetti Historico | PT-BR: lista de objetos Historico
     * @since 1.0.0
     * @implNote EN: SQL errors are handled via dialog; results are user-scoped (cd_usuario). 
     * IT: Errori SQL gestiti tramite dialog; risultati limitati all'utente (cd_usuario). 
     * PT-BR: Erros SQL tratados via diálogo; resultados restritos ao usuário (cd_usuario).
     */
    public ArrayList getLista(int cd_animal) {
        ArrayList historico = new ArrayList();
        try{
            sql = "SELECT cd_historico, to_char(dt_historico,'dd/MM/yyyy'), ds_historico, cd_presserv, cd_animal, cd_tipo, cd_usuario" +
                  "  FROM historico" +
                  " WHERE cd_animal = ? " +
                  "   AND cd_usuario = ?" +
                  " ORDER BY dt_historico";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_animal);
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Historico h = new Historico(
                    rs.getInt("cd_historico"),
                    util.recebeData(rs.getString("to_char(dt_historico,'dd/MM/yyyy')")),
                    rs.getString("ds_historico"),
                    (PrestadorServico)presservr.getById(rs.getInt("cd_presserv")),
                    (Animal)animalr.getById(rs.getInt("cd_animal")),
                    (Tipo)tipor.getById(rs.getInt("cd_tipo")),
                    rs.getInt("cd_usuario"));
                historico.add(h);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar o historico:\n" +
                    ex.getMessage(), "Historico", JOptionPane.ERROR_MESSAGE);
        }
        return historico;
    }

    /**
     * <p><strong>EN:</strong> Gets a history record (Historico) by its ID for the current user.</p>
     *
     * <p><strong>IT:</strong> Recupera un record di storico (Historico) per ID per l'utente corrente.</p>
     *
     * <p><strong>PT-BR:</strong> Obtém um registro de histórico (Historico) pelo ID para o usuário atual.</p>
     *
     * @param id EN: unique identifier of the history record | IT: identificatore univoco del record di storico | PT-BR: identificador único do registro de histórico
     * @return EN: Historico object if found, otherwise null | IT: oggetto Historico se trovato, altrimenti null | PT-BR: objeto Historico se encontrado, caso contrário null
     * @since 1.0.0
     * @implNote EN: SQL errors are handled via dialog; query is user-scoped (cd_usuario). 
     * IT: Errori SQL gestiti tramite dialog; query limitata all'utente (cd_usuario). 
     * PT-BR: Erros SQL tratados via diálogo; consulta restrita ao usuário (cd_usuario).
     */
    @Override
    public Object getById(int id) {
        Historico h = null;
        try{
            sql = "SELECT cd_historico, to_char(dt_historico,'dd/MM/yyyy'), ds_historico, cd_presserv, cd_animal, cd_tipo, cd_usuario" +
                  "  FROM historico" +
                  " WHERE cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                h = new Historico(
                    rs.getInt("cd_historico"),
                    util.recebeData(rs.getString("to_char(dt_historico,'dd/MM/yyyy')")),
                    rs.getString("ds_historico"),
                    (PrestadorServico)presservr.getById(rs.getInt("cd_presserv")),
                    (Animal)animalr.getById(rs.getInt("cd_animal")),
                    (Tipo)tipor.getById(rs.getInt("cd_tipo")),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em Historico:\n" +
                    ex.getMessage(), "Historico", JOptionPane.ERROR_MESSAGE);
        }
        return h;
    }
}
