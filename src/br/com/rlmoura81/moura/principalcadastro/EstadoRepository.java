package br.com.rlmoura81.moura.principalcadastro;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EstadoRepository {
    
    String sql = "";
         
    public void inserir(Object o){        
        Estado e = (Estado) o;        
        try{
            sql = "INSERT INTO estado (cd_estado, ds_estado, ds_siglaestado) " +
                  "     VALUES (sq_estado.nextval, ?, ?)";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, e.getDs_estado());
            ps.setString(2, e.getDs_siglaEstado());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Estado", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Estado", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void alterar(Object o){        
        Estado e = (Estado) o;        
        try{
            sql = "UPDATE estado " +
                  "   SET ds_estado = ?, " +
                  "       ds_siglaestado = ?" +
                  " WHERE cd_estado = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, e.getDs_estado());
            ps.setString(2, e.getDs_siglaEstado());
            ps.setInt(3, e.getCd_estado());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado.", "Estado", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Estado", JOptionPane.ERROR_MESSAGE);
        }    
    }
    
    public void excluir(Object o){        
        Estado e = (Estado) o;        
        try{
            sql = "DELETE FROM estado " +
                  " WHERE cd_estado = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, e.getCd_estado());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido", "Estado", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao deletar:\n" +
                    ex.getMessage(), "Estado", JOptionPane.ERROR_MESSAGE);
        }    
    }

    public ArrayList getLista(){        
        ArrayList estados = new ArrayList();
        try {
            sql = "SELECT cd_estado, ds_estado, ds_siglaestado " +
                  "  FROM estado" +
                  " ORDER BY ds_estado";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();        
            while (rs.next()){
                Estado e = new Estado(
                    rs.getInt("cd_estado"),
                    rs.getString("ds_estado"),
                    rs.getString("ds_siglaestado"));
                estados.add(e);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de estados:\n" +
                    ex.getMessage(), "Estado", JOptionPane.ERROR_MESSAGE);
        }
        return estados;
    }
    
    public Object getById(int id){        
        Estado e = null;        
        try{
            String sql = "SELECT cd_estado, ds_estado, ds_siglaestado" +
                         "  FROM estado " +
                         " WHERE cd_estado = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                e = new Estado(
                    rs.getInt("cd_estado"),
                    rs.getString("ds_estado"),
                    rs.getString("ds_siglaestado"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em estado:\n" + 
                    ex.getMessage(), "Estado", JOptionPane.ERROR_MESSAGE);
        }
        return e;
    }
}
