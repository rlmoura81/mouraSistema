package br.com.rlmoura81.moura.principalcadastro;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class GrupoRepository{

    String sql = "";
    
    public void inserir(Object o){
        Grupo g = (Grupo) o;
        try{
            sql = "INSERT INTO grupo (cd_grupo, ds_grupo, cd_usuario) " +
                  "     VALUES (sq_grupo.nextval, ?, ?)";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, g.getDs_grupo());
            ps.setInt(2, g.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Grupo", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Grupo", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void aterar(Object o){
        Grupo g = (Grupo) o;
        try{
            sql = "UPDATE grupo " +
                  "   SET ds_grupo = ? " +
                  " WHERE cd_grupo = ? " +
                  "   AND cd_usuario = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, g.getDs_grupo());
            ps.setInt(2, g.getCd_grupo());
            ps.setInt(3, g.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado.", "Grupo", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Grupo", JOptionPane.ERROR_MESSAGE);
        }    
    }
    
    public void excluir(Object o){
        Grupo g = (Grupo) o;
        try{
            sql = "DELETE FROM grupo " +
                  " WHERE cd_grupo = ? " +
                  "   AND cd_usuario = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, g.getCd_grupo());
            ps.setInt(2, g.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido", "Grupo", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Grupo", JOptionPane.ERROR_MESSAGE);
        }        
    }

    public ArrayList getLista(){        
        ArrayList grupo = new ArrayList();        
        try{
            sql = "SELECT cd_grupo, ds_grupo, cd_usuario " +
                  "  FROM grupo " +
                  " WHERE cd_usuario = ?" +
                  " ORDER BY ds_grupo";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while (rs.next()){
                Grupo g = new Grupo(
                        rs.getInt("cd_grupo"),
                        rs.getString("ds_grupo"),
                        rs.getInt("cd_usuario"));
                grupo.add(g);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de grupos:\n" +
                    ex.getMessage(), "Grupo", JOptionPane.ERROR_MESSAGE);
        }
        return grupo;
    }
    
    public Object getById(int id){
        Grupo g = null;
        try {
            sql = "SELECT cd_grupo, ds_grupo, cd_usuario"
                + "  FROM grupo"
                + " WHERE cd_grupo = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                g = new Grupo(
                        rs.getInt("cd_grupo"),
                        rs.getString("ds_grupo"),
                        rs.getInt("cd_usuario"));
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Categoria.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro de getById em grupo:\n" +
                    ex.getMessage(), "Grupo", JOptionPane.ERROR_MESSAGE);
        }
        return g;
    }    
}
