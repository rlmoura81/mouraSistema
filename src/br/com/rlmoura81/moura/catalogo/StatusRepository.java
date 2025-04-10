package br.com.rlmoura81.moura.catalogo;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class StatusRepository{

    String sql = "";

    public ArrayList getLista() {    
        ArrayList status = new ArrayList();        
        try{
            sql = "SELECT cd_status, ds_status " +
                  "  FROM status" +
                  " ORDER BY ds_status";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while (rs.next()){
                Status st = new Status(
                    rs.getInt("cd_status"),
                    rs.getString("ds_status"));
                status.add(st);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de status:\n" +
                    ex.getMessage());
        }
        return status;
    }

    public Object getById(int id) {        
        Status st = null;        
        try{
            sql = "SELECT cd_status, ds_status " +
                  "  FROM status" +
                  " WHERE cd_status = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if (rs.next()){
                st = new Status(
                    rs.getInt("cd_status"),
                    rs.getString("ds_status"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em status:\n" +
                    ex.getMessage());
        }
        return st;
    }   
}
