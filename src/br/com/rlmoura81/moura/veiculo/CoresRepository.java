package br.com.rlmoura81.moura.veiculo;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CoresRepository{
    
    String sql = "";
    
    public ArrayList getLista() {
        ArrayList<Cores> cor = new ArrayList();
        try{
            sql = "SELECT cd_cor, ds_cor" +
                  "  FROM cores" +
                  " ORDER BY ds_cor";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Cores c = new Cores(
                    rs.getInt("cd_cor"),
                    rs.getString("ds_cor"));
                cor.add(c);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a listas de cores" + 
                    ex.getMessage(), "Cores", JOptionPane.ERROR_MESSAGE);
        }
        return cor;
    }
    
    public Object getById(int id) {
        Cores c = null;
        try{
            sql = "SELECT cd_cor, ds_cor" +
                  "  FROM cores" +
                  " WHERE cd_cor = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                c = new Cores(
                    rs.getInt("cd_cor"),
                    rs.getString("ds_cor"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em cor:\n" +
                    ex.getMessage(), "Cores", JOptionPane.ERROR_MESSAGE);
        }
        return c;
    }
    
}
