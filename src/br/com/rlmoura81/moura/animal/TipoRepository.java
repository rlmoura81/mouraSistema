package br.com.rlmoura81.moura.animal;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TipoRepository{
    
    String sql = "";

    public ArrayList getLista() {
        ArrayList tipo = new ArrayList();
        try{
            sql = "SELECT cd_tipo, ds_tipo " +
                  "  FROM tphist";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Tipo tp = new Tipo(
                    rs.getInt("cd_tipo"),
                    rs.getString("ds_tipo"));
                tipo.add(tp);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de tipos:\n" +
                    ex.getMessage(), "Tipo", JOptionPane.ERROR_MESSAGE);
        }
        return tipo;
    }

    public Object getById(int id) {
        Tipo t = null;
        try{
            sql = "SELECT cd_tipo, ds_tipo" +
                  "  FROM tphist" +
                  " WHERE cd_tipo = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                t = new Tipo(
                    rs.getInt("cd_tipo"),
                    rs.getString("ds_tipo"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em Tipo:\n" +
                    ex.getMessage(), "Tipo", JOptionPane.ERROR_MESSAGE);
        }
        return t;
    }
    
}
