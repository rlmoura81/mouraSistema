package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GrupoFundoRepository{

    String sql = "";

    public ArrayList getLista() {
        ArrayList gpfundo = new ArrayList();
        try{
            sql = "SELECT cd_gpfundo, ds_gpfundo " +
                  "  FROM gpfundo";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                GrupoFundo gf = new GrupoFundo(
                    rs.getInt("cd_gpfundo"),
                    rs.getString("ds_gpfundo"));
                    gpfundo.add(gf);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de grupo de fundos:\n" +
                    ex.getMessage());
        }
        return gpfundo;
    }
    
    public Object getById(int id) {
        GrupoFundo gf = null;
        try{
            sql = "SELECT cd_gpfundo, ds_gpfundo " +
                  "  FROM gpfundo" +
                  " WHERE cd_gpfundo = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                gf = new GrupoFundo(
                    rs.getInt("cd_gpfundo"),
                    rs.getString("ds_gpfundo"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em grupo de fundos:\n" +
                    ex.getMessage());
        }
        return gf;
    }
}
