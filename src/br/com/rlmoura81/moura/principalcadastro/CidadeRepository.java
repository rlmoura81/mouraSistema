package br.com.rlmoura81.moura.principalcadastro;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CidadeRepository {

    String sql = "";
    
    EstadoRepository estador = new EstadoRepository();
    
    public void inserir(Object o){        
        Cidade c = (Cidade) o;        
        try{
            sql = "INSERT INTO cidade (cd_cidade, cd_estado, ds_cidade) " + 
                  "     VALUES (sq_cidade.nextval, ?, ?)";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, c.getEstado().getCd_estado());
            ps.setString(2, c.getDs_Cidade());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Cidade", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Cidade", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void alterar(Object o){        
        Cidade c = (Cidade) o;        
        try{
            sql = "UPDATE cidade " +
                  "   SET ds_cidade = ?, " +
                  "       cd_estado = ?" + 
                  " WHERE cd_cidade = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, c.getDs_Cidade());
            ps.setInt(2, c.getEstado().getCd_estado());
            ps.setInt(3, c.getCd_Cidade());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado", "Cidade", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Cidade", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void excluir(Object o){
        Cidade c = (Cidade) o;
        try{
            sql = "DELETE FROM cidade " +
                  " WHERE cd_cidade = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, c.getCd_Cidade());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido", "Cidade", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao deletar:\n" +
                    ex.getMessage(), "Cidade", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ArrayList getLista(){
        ArrayList cidades = new ArrayList();        
        try{
            sql = "SELECT cd_cidade, ds_cidade, cd_estado" + 
                  "  FROM cidade" +
                  " ORDER BY ds_cidade";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){            
                Cidade c = new Cidade(
                    rs.getInt("cd_cidade"),
                    rs.getString("ds_cidade"),
                    (Estado)estador.getById(rs.getInt("cd_estado")));
                cidades.add(c);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de cidades:\n" +
                    ex.getMessage(), "Cidade", JOptionPane.ERROR_MESSAGE);
        }    
        return cidades;
    } 
    
    public Object getById(int id){        
    Cidade c = null;        
        try{
            sql = "SELECT cd_cidade, ds_cidade, cd_estado" +
                  "  FROM cidade " +
                  " WHERE cd_cidade = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                c = new Cidade(
                    rs.getInt("cd_cidade"),
                    rs.getString("ds_cidade"),
                    (Estado)estador.getById(rs.getInt("cd_estado")));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em cidade:\n" + 
                    ex.getMessage(), "Cidade", JOptionPane.ERROR_MESSAGE);
        }
        return c;
    }
}
