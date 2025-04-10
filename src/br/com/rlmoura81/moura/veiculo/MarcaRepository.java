package br.com.rlmoura81.moura.veiculo;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MarcaRepository{
    
    String sql = "";

    public ArrayList getLista() {
        ArrayList marcas = new ArrayList();
        try{
            sql = "SELECT cd_marca, ds_marca" +
                  "  FROM marca " +
                  " ORDER BY ds_marca";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while (rs.next()){
                Marca m = new Marca(
                    rs.getInt("cd_marca"),
                    rs.getString("ds_marca"));
                    marcas.add(m);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de marcas:\n" +
                    ex.getMessage(), "Marca", JOptionPane.ERROR_MESSAGE);
        }
        return marcas;
    }
    
    public Object getById(int id) {
        Marca m = null;        
        try{
            sql = "SELECT cd_marca, ds_marca" +
                  "  FROM marca " +
                  " WHERE cd_marca = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                m = new Marca(
                    rs.getInt("cd_marca"),
                    rs.getString("ds_marca"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em marca:\n" + 
                    ex.getMessage(), "Marca", JOptionPane.ERROR_MESSAGE);
        }
        return m;
    }
}
