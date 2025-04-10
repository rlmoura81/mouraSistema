package br.com.rlmoura81.moura.animal;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EspecieRepository{

    String sql = "";

    public ArrayList getLista() {        
        ArrayList especies = new ArrayList();
        try{
            sql = "SELECT cd_especie, ds_especie " +
                  "  FROM especie" +
                  " ORDER BY ds_especie";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while (rs.next()){
                Especie e = new Especie(
                rs.getInt("cd_especie"),
                rs.getString("ds_especie"));
                especies.add(e);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de especies:" +
                    ex.getMessage(), "Especie", JOptionPane.ERROR_MESSAGE);
        }
        return especies;
    }

    public Object getById(int id) {
        Especie e = null;
        try{
            sql = "SELECT cd_especie, ds_especie " +
                  "  FROM especie " +
                  " WHERE cd_especie = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                e = new Especie(
                    rs.getInt("cd_especie"),
                    rs.getString("ds_especie"));
            }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em especie:\n" +
                    ex.getMessage(), "Especie", JOptionPane.ERROR_MESSAGE);
            ex.getMessage();
        }
        return e;
    }
    
}
