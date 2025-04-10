package br.com.rlmoura81.moura.veiculo;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CombustivelRepository {

    String sql = "";

    public ArrayList getLista() {
        ArrayList combustivel = new ArrayList();
        try{
            sql = "SELECT cd_combustivel, ds_combustivel" +
                  "  FROM combustivel" +
                  " ORDER BY ds_combustivel";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Combustivel c = new Combustivel(
                    rs.getInt("cd_combustivel"),
                    rs.getString("ds_combustivel"));
                combustivel.add(c);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de combustiveis:\n" +
                    ex.getMessage(), "Combustivel", JOptionPane.ERROR_MESSAGE);
        }
        return combustivel;
    }

    public Object getById(int id) {
        Combustivel c = null;
        try{
            sql = "SELECT cd_combustivel, ds_combustivel" +
                  "  FROM combustivel" +
                  " WHERE cd_combustivel = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                c = new Combustivel(
                    rs.getInt("cd_combustivel"),
                    rs.getString("ds_combustivel"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em combustivel:\n" + 
                    ex.getMessage(), "Combustivel", JOptionPane.ERROR_MESSAGE);
        }
        return c;
    }    
}
