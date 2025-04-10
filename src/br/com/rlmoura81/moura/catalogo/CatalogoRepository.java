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
