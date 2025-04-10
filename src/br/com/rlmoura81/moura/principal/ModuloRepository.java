package br.com.rlmoura81.moura.principal;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ModuloRepository {

    String sql = "";

    public ArrayList getLista() {
        ArrayList modulo = new ArrayList();
        try{
            sql = "SELECT cd_modulo, ds_modulo " +
                  "  FROM modulo";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Modulo m = new Modulo(
                    rs.getInt("cd_modulo"),
                    rs.getString("ds_modulo"));
                    modulo.add(m);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de modulos:\n" +
                    ex.getMessage(), "Modulo", JOptionPane.ERROR_MESSAGE);
        }
        return modulo;
    }

    public Object getById(int id) {
        Modulo modulo = null;
        try{
            sql = "SELECT cd_modulo, ds_modulo " +
                  "  FROM modulo" +
                  " WHERE cd_modulo = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                    modulo = new Modulo(
                    rs.getInt("cd_modulo"),
                    rs.getString("ds_modulo"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em modulo:\n" +
                    ex.getMessage(), "Modulo", JOptionPane.ERROR_MESSAGE);
        }
        return modulo;
    }    
}
