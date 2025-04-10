package br.com.rlmoura81.moura.principal;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UsuarioRepository {

    String sql = "";
    
    PessoaFisicaRepository pessoafisicar = new PessoaFisicaRepository();
    
    public void inserir(Object o){        
        Usuario user = (Usuario) o;        
        try{        
            sql =  "INSERT INTO usuario (cd_usuario, ds_login, ds_senha, cd_pessoafisica)" + 
                   "     VALUES(sq_usuario.nextval, ?, ?, ?)";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, user.getDs_login());
            ps.setString(2, user.getDs_senha());
            ps.setInt(3, user.getPessoa().getCd_Pessoa());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Usuario", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Usuario", JOptionPane.ERROR_MESSAGE);
        }    
    }
    
    public void alterar(Object o){        
        Usuario user = (Usuario) o;
        try{
            sql = "UPDATE usuario " +
                  "   SET ds_senha = ?, " +
                  "       cd_pessoafisica = ?" +
                  " WHERE cd_usuario = ?";                  
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, user.getDs_senha());
            ps.setInt(2, user.getPessoa().getCd_Pessoa());
            ps.setInt(3, user.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado.", "Usuario", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Usuario", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void excluir(Object o){        
        Usuario user = (Usuario) o;
        try{
            sql = "DELETE FROM usuario " +
                  " WHERE cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, user.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido", "Usuario", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Usuario", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ArrayList getLista(){        
        ArrayList usuarios = new ArrayList();         
        try{
            sql = "SELECT cd_usuario, ds_login, ds_senha, cd_pessoafisica " +
                  "  FROM usuario " +
                  " ORDER BY ds_login";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while (rs.next()) {            
                Usuario user = new Usuario(
                        rs.getInt("cd_usuario"),
                        rs.getString("ds_login"),
                        rs.getString("ds_senha"),
                        (PessoaFisica)pessoafisicar.getById(rs.getInt("cd_pessoafisica")));
                usuarios.add(user);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de usuários:\n" +
                    ex.getMessage(), "Usuario", JOptionPane.ERROR_MESSAGE);
        }
        return usuarios;
    }

    public Object getById(int id){        
        Usuario user = null;        
        try{
            sql = "SELECT cd_usuario, ds_login, ds_senha, cd_pessoafisica " +
                  "  FROM usuario " +
                  " WHERE cd_usuario = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ps.setInt(1, user.getCd_usuario());
            if(rs.next()){
                user = new Usuario(
                        rs.getInt("cd_usuario"),
                        rs.getString("ds_login"),
                        rs.getString("ds_senha"),
                        (PessoaFisica)pessoafisicar.getById(rs.getInt("cd_pessoafisica")));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em usuario:\n" +
                    ex.getMessage(), "Usuario", JOptionPane.ERROR_MESSAGE);
        }
        return user;
    }
}
