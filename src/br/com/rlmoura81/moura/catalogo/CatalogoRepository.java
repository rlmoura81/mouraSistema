package br.com.rlmoura81.moura.catalogo;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CatalogoRepository implements IPadraoRepository{

    String sql = "";    
    ArrayList<Catalogo> catalogo = new ArrayList<>();    
    TipoMidiaRepository tmr = new TipoMidiaRepository();
    EditoraRepository er = new EditoraRepository();
    StatusRepository str = new StatusRepository();

    /**
     * <p><strong>EN:</strong> Inserts a new catalog record (Catalogo) into the database.</p>
     *
     * <p><strong>IT:</strong> Inserisce un nuovo record di catalogo (Catalogo) nel database.</p>
     *
     * <p><strong>PT-BR:</strong> Insere um novo registro de catálogo (Catalogo) no banco de dados.</p>
     *
     * @param o EN: Catalogo object to insert | IT: Oggetto Catalogo da inserire | PT-BR: Objeto Catalogo a ser inserido
     * @since 1.0.0
     */
    @Override
    public void inserir(Object o) {        
        Catalogo c = (Catalogo) o;
        try{
            sql = "INSERT INTO catalogo (cd_catalogo, ds_titulo, nm_numero, nm_volume, nm_edicao, ds_observacao, cd_tipomidia, cd_editora, cd_status, cd_usuario)" +
                  "     VALUES (sq_catalogo.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, c.getDs_titulo());
            ps.setInt(2, c.getNm_numero());
            ps.setInt(3, c.getNm_volume());
            ps.setInt(4, c.getNm_edicao());
            ps.setString(5, c.getDs_observacao());
            ps.setInt(6, c.getTipomidia().getCd_midia());
            ps.setInt(7, c.getEditora().getCd_editora());
            ps.setInt(8, c.getStatus().getCd_status());
            ps.setInt(9, c.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Catalogo", JOptionPane.INFORMATION_MESSAGE);
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" + 
                    ex.getMessage(), "Catalogo", JOptionPane.ERROR_MESSAGE);
        }        
    }

    /**
     * <p><strong>EN:</strong> Updates an existing catalog record (Catalogo) with the provided data.</p>
     *
     * <p><strong>IT:</strong> Aggiorna un record di catalogo (Catalogo) esistente con i dati forniti.</p>
     *
     * <p><strong>PT-BR:</strong> Atualiza um registro de catálogo (Catalogo) existente com os dados informados.</p>
     *
     * @param o EN: Catalogo object with updated values | IT: Oggetto Catalogo con valori aggiornati | PT-BR: Objeto Catalogo com valores atualizados
     * @since 1.0.0
     */
    @Override
    public void alterar(Object o) {        
        Catalogo c = (Catalogo) o;        
        try{
            sql = "UPDATE catalogo " +
                  "   SET ds_titulo = ?, " +
                  "       nm_numero = ?, " +
                  "       nm_volume = ?, " +
                  "       nm_edicao = ?, " +
                  "       ds_observacao = ?," +
                  "       cd_tipomidia = ?, " +
                  "       cd_editora = ?, " +
                  "       cd_status = ?" +
                  " WHERE cd_catalogo = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, c.getDs_titulo());
            ps.setInt(2, c.getNm_numero());
            ps.setInt(3, c.getNm_volume());
            ps.setInt(4, c.getNm_edicao());
            ps.setString(5, c.getDs_observacao());
            ps.setInt(6, c.getTipomidia().getCd_midia());
            ps.setInt(7, c.getEditora().getCd_editora());
            ps.setInt(8, c.getStatus().getCd_status());
            ps.setInt(9, c.getCd_catalogo());
            ps.setInt(10, c.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado.", "Catalogo", JOptionPane.INFORMATION_MESSAGE);
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" + 
                    ex.getMessage(), "Catalogo", JOptionPane.ERROR_MESSAGE);
        }        
    }

    /**
     * <p><strong>EN:</strong> Deletes a catalog record (Catalogo) by its ID and user.</p>
     *
     * <p><strong>IT:</strong> Elimina un record di catalogo (Catalogo) tramite il suo ID e utente.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui um registro de catálogo (Catalogo) pelo seu ID e usuário.</p>
     *
     * @param o EN: Catalogo object containing identifiers for deletion | IT: Oggetto Catalogo con gli identificatori per l'eliminazione | PT-BR: Objeto Catalogo com os identificadores para exclusão
     * @since 1.0.0
     */
    @Override
    public void excluir(Object o) {
        Catalogo c = (Catalogo) o;
        try{
            sql = "DELETE FROM catalogo " +
                  " WHERE cd_catalogo = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, c.getCd_catalogo());
            ps.setInt(2, c.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido", "Catalogo", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" + 
                    ex.getMessage(), "Catalogo", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Retrieves all catalog records (Catalogo) for the logged-in user, joining media type, publisher, and status.</p>
     *
     * <p><strong>IT:</strong> Recupera tutti i record di catalogo (Catalogo) per l'utente connesso, includendo tipo di media, editore e stato.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera todos os registros de catálogo (Catalogo) do usuário logado, incluindo tipo de mídia, editora e status.</p>
     *
     * @return EN: list of Catalogo objects | IT: elenco di oggetti Catalogo | PT-BR: lista de objetos Catalogo
     * @since 1.0.0
     */
    @Override
    public ArrayList getLista() {
        catalogo.clear();
        try{
            sql = "SELECT catalogo.cd_catalogo, catalogo.ds_titulo, catalogo.nm_numero, catalogo.nm_volume, catalogo.nm_edicao, catalogo.ds_observacao, " +
                  "       tipomidia.cd_tipomidia, editora.cd_editora, status.cd_status, catalogo.cd_usuario" +
                  "  FROM catalogo, tipomidia, editora, status" +
                  " WHERE catalogo.cd_tipomidia = tipomidia.cd_tipomidia " +
                  "   AND catalogo.cd_editora = editora.cd_editora " +
                  "   AND catalogo.cd_status = status.cd_status " +
                  "   AND catalogo.cd_usuario = ?" +
                  " ORDER BY catalogo.ds_titulo, catalogo.nm_numero";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while (rs.next()){
                Catalogo c = new Catalogo(
                    rs.getInt("cd_catalogo"),
                    rs.getString("ds_titulo"),
                    rs.getInt("nm_numero"),
                    rs.getInt("nm_volume"),
                    rs.getInt("nm_edicao"),
                    rs.getString("ds_observacao"),
                    (TipoMidia)tmr.getById(rs.getInt("cd_tipomidia")),
                    (Editora)er.getById(rs.getInt("cd_editora")),
                    (Status)str.getById(rs.getInt("cd_status")),
                    rs.getInt("cd_usuario"));
                catalogo.add(c);
            }    
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar o catalogo:\n" + 
                    ex.getMessage(), "Catalogo", JOptionPane.ERROR_MESSAGE);
        } return catalogo;
    }

    /**
     * <p><strong>EN:</strong> Retrieves catalog records (Catalogo) filtered by a title fragment for the logged-in user.</p>
     *
     * <p><strong>IT:</strong> Recupera i record di catalogo (Catalogo) filtrati per una porzione del titolo per l'utente connesso.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera registros de catálogo (Catalogo) filtrados por trecho do título para o usuário logado.</p>
     *
     * @param ds_titulo EN: title fragment to search | IT: parte del titolo da cercare | PT-BR: trecho do título para pesquisa
     * @return EN: list of Catalogo objects | IT: elenco di oggetti Catalogo | PT-BR: lista de objetos Catalogo
     * @since 1.0.0
     */
    public ArrayList getLista(String ds_titulo){
        catalogo.clear();
        try{
            sql = "SELECT cd_catalogo, ds_titulo, nm_numero, nm_volume, nm_edicao, ds_observacao, " +
                  "       cd_tipomidia, cd_editora, cd_status, cd_usuario" +
                  "  FROM catalogo" +
                  " WHERE upper(ds_titulo) LIKE ? OR lower(ds_titulo) LIKE ?" +
                  "   AND cd_usuario = ?" +  
                  " ORDER BY ds_titulo, nm_numero";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, "%"+ds_titulo+"%");
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while (rs.next()){
                Catalogo c = new Catalogo(
                    rs.getInt("cd_catalogo"),
                    rs.getString("ds_titulo"),
                    rs.getInt("nm_numero"),
                    rs.getInt("nm_volume"),
                    rs.getInt("nm_edicao"),
                    rs.getString("ds_observacao"),
                    (TipoMidia)tmr.getById(rs.getInt("cd_tipomidia")),
                    (Editora)er.getById(rs.getInt("cd_editora")),
                    (Status)str.getById(rs.getInt("cd_status")),
                    rs.getInt("cd_usuario"));
                catalogo.add(c);
            }
            ps.close();
        } catch(SQLException ex){
            Logger.getLogger(TipoMidiaRepository.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao carregar o catalogo pesquisado:\n" + 
                    ex.getMessage(), "Catalogo", JOptionPane.ERROR_MESSAGE);
        } return catalogo;    
    }
    
    /**
     * <p><strong>EN:</strong> Gets a catalog record (Catalogo) by its ID.</p>
     *
     * <p><strong>IT:</strong> Recupera un record di catalogo (Catalogo) tramite il suo ID.</p>
     *
     * <p><strong>PT-BR:</strong> Obtém um registro de catálogo (Catalogo) pelo seu ID.</p>
     *
     * @param id EN: unique identifier of the catalog record | IT: identificatore univoco del record di catalogo | PT-BR: identificador único do registro de catálogo
     * @return EN: Catalogo object if found, otherwise null | IT: Oggetto Catalogo se trovato, altrimenti null | PT-BR: Objeto Catalogo se encontrado, caso contrário null
     * @since 1.0.0
     */
    @Override
    public Object getById(int id) {       
        Catalogo c = null;        
        try{
            sql = "SELECT cd_catalogo, ds_titulo, nm_numero, nm_volume, nm_edicao, nm_edicao, ds_observacao " +
                  "       cd_tipomidia, cd_editora, cd_status, cd_usuario" +
                  "  FROM catalogo " +
                  " WHERE cd_catalogo = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                c = new Catalogo(
                    rs.getInt("cd_catalogo"),
                    rs.getString("ds_titulo"),
                    rs.getInt("nm_numero"),
                    rs.getInt("nm_volume"),
                    rs.getInt("nm_edicao"),
                    rs.getString("ds_observacao"),
                    (TipoMidia)tmr.getById(rs.getInt("cd_tipomidia")),
                    (Editora)er.getById(rs.getInt("cd_editora")),
                    (Status)str.getById(rs.getInt("cd_status")),
                    rs.getInt("cd_usuario"));
            }   
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em catalgo:\n" +
                    ex.getMessage(), "Catalogo", JOptionPane.ERROR_MESSAGE);
        }
        return c;  
    }   
}
