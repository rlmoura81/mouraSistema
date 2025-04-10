package br.com.rlmoura81.moura.principalcadastro;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CategoriaRepository {
    
    String sql = "";
    
    GrupoRepository grupor = new GrupoRepository();
    
    public void inserir(Object o){
        Categoria c = (Categoria) o;
        try{
            sql = "INSERT INTO categoria (cd_categoria, ds_categoria, cd_grupo, cd_usuario) " +
                  "     VALUES (sq_categoria.nextval, ?, ?, ?)";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, c.getDs_Categoria());
            ps.setInt(2, c.getGrupo().getCd_grupo());
            ps.setInt(3, c.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Categoria", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao inserir:\n" +
                    ex.getMessage(), "Categoria", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void aterar(Object o){
        Categoria c = (Categoria) o;
        try{
            sql = "UPDATE categoria " +
                  "   SET ds_categoria = ?, " +
                  "       cd_grupo = ?" +
                  " WHERE cd_categoria = ? " +
                  "   AND cd_usuario = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, c.getDs_Categoria());
            ps.setInt(2, c.getGrupo().getCd_grupo());
            ps.setInt(3, c.getCd_Categoria());
            ps.setInt(4, c.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado", "Categoria", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Categoria", JOptionPane.ERROR_MESSAGE);
        }    
    }
    
    public void excluir(Object o){
        Categoria c = (Categoria) o;
        try{
            sql = "DELETE FROM categoria " +
                  " WHERE cd_categoria = ? " +
                  "   AND cd_usuario = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, c.getCd_Categoria());
            ps.setInt(2, c.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido", "Categoria", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Categoria", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    public ArrayList getLista(){        
        ArrayList categorias = new ArrayList();        
        try{
            sql = "SELECT cd_categoria, ds_categoria, cd_grupo, cd_usuario " +
                  "  FROM categoria " +
                  " WHERE cd_usuario = ?" +
                  " ORDER BY ds_categoria";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while (rs.next()){
                Categoria c = new Categoria(
                        rs.getInt("cd_categoria"),
                        rs.getString("ds_categoria"),
                        (Grupo)grupor.getById(rs.getInt("cd_grupo")),
                        rs.getInt("cd_usuario"));
                categorias.add(c);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de categorias:\n" +
                    ex.getMessage(), "Categoria", JOptionPane.ERROR_MESSAGE);
        }
        return categorias;
    }
    
    public Object getById(int id){
        Categoria c = null;
        try {
            sql = "SELECT cd_categoria, ds_categoria, cd_grupo, cd_usuario"
                + "  FROM categoria"
                + " WHERE cd_categoria = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                c = new Categoria(
                        rs.getInt("cd_categoria"),
                        rs.getString("ds_categoria"),
                        (Grupo)grupor.getById(rs.getInt("cd_grupo")),
                        rs.getInt("cd_usuario"));
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Categoria.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro de getById em categoria:\n" +
                    ex.getMessage(), "Categoria", JOptionPane.ERROR_MESSAGE);
        }
        return c;
    }
}
