package br.com.rlmoura81.moura.principalcadastro;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PrestadorServicoRepository {

    String sql = "";
        
    public void inserir(Object o){
        PrestadorServico presserv = (PrestadorServico) o;
        try{
            sql = "INSERT INTO presserv (cd_presserv, ds_presserv, ds_razaosocial, nm_documento, cd_usuario)" +
                  "     VALUES (sq_presserv.nextval,?, ?, ?, ?)";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, presserv.getDs_presserv());
            ps.setString(2, presserv.getDs_razaosocial());
            ps.setString(3, presserv.getNm_documento());
            ps.setInt(4, presserv.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Prestador de Serviço", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Prestador de Serviço", JOptionPane.ERROR_MESSAGE);
        }    
    }
    
    public void alterar(Object o){
        PrestadorServico presserv = (PrestadorServico) o;
        try{
            sql = "UPDATE presserv " +
                  "   SET ds_presserv = ?, " +
                  "       ds_razaosocial = ?, " +
                  "       nm_documento = ?" +
                  " WHERE cd_presserv = ? " +
                  "   AND cd_usuario = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, presserv.getDs_presserv());
            ps.setString(2, presserv.getDs_razaosocial());
            ps.setString(3, presserv.getNm_documento());
            ps.setInt(4, presserv.getCd_presserv());
            ps.setInt(5, presserv.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Prestador de Serviço", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Prestador de Serviço", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void excluir(Object o){
        PrestadorServico presserv = (PrestadorServico) o;
        try{
            sql = "DELETE FROM presserv " +
                  " WHERE cd_presserv = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, presserv.getCd_presserv());
            ps.setInt(2, presserv.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido", "Prestador de Serviço", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Prestador de Serviço", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList getLista(){        
        ArrayList presservlista = new ArrayList();
        try{
            sql = "SELECT cd_presserv, ds_presserv, ds_razaosocial, nm_documento, cd_usuario" +
                  "  FROM presserv" +
                  " WHERE cd_usuario = ?" +
                  " ORDER BY ds_presserv";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();        
            while(rs.next()){          
                PrestadorServico presserv = new PrestadorServico(
                    rs.getInt("cd_presserv"),
                    rs.getString("ds_presserv"),
                    rs.getString("ds_razaosocial"),
                    rs.getString("nm_documento"),
                    rs.getInt("cd_usuario"));
                presservlista.add(presserv);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de prestadores de serviços:\n" +
                    ex.getMessage(), "Prestador de Serviço", JOptionPane.ERROR_MESSAGE);
        }
        return presservlista;
    }

    public ArrayList getLista(int cd_modulo){       
        ArrayList presservlista = new ArrayList();
        try{
            sql = "SELECT presserv.cd_presserv, ds_presserv, ds_razaosocial, nm_documento, presserv.cd_usuario" +
                  "  FROM presserv, modulo, presservmod" +
                  " WHERE presserv.cd_usuario = ?" +
                  "   AND modulo.cd_modulo = ?" +
                  "   AND modulo.cd_modulo = presservmod.cd_modulo" +
                  "   AND presserv.cd_presserv = presservmod.cd_presserv" +
                  " ORDER BY ds_presserv";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ps.setInt(2, cd_modulo);
            ResultSet rs = ps.executeQuery();        
            while(rs.next()){          
                PrestadorServico presserv = new PrestadorServico(
                    rs.getInt("cd_presserv"),
                    rs.getString("ds_presserv"),
                    rs.getString("ds_razaosocial"),
                    rs.getString("nm_documento"),
                    rs.getInt("cd_usuario"));
                presservlista.add(presserv);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de prestadores de serviços:\n" +
                    ex.getMessage(), "Prestador de Serviços", JOptionPane.ERROR_MESSAGE);
        }
        return presservlista;
    }
        
    public Object getById(int id){
        PrestadorServico p = null;
        try {
            sql = "SELECT cd_presserv, ds_presserv, ds_razaosocial, nm_documento, cd_usuario"
                + "  FROM presserv"
                + " WHERE cd_presserv = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                PrestadorServico presserv = new PrestadorServico();
                presserv.setCd_presserv(rs.getInt("cd_presserv"));
                p = new PrestadorServico(
                    rs.getInt("cd_presserv"),
                    rs.getString("ds_presserv"),
                    rs.getString("ds_razaosocial"),
                    rs.getString("nm_documento"),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de getById em Prestador de Servico" +
                    ex.getMessage(), "Prestador de Serviços", JOptionPane.ERROR_MESSAGE);
        }        
        return p;        
    }
}
