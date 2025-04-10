package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MoedaRepository {

    String sql = "";

    public ArrayList getLista() {
        ArrayList moeda = new ArrayList();
        try{
            sql = "SELECT cd_moeda, ds_moeda " +
                  "  FROM moeda";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Moeda m = new Moeda(
                        rs.getInt("cd_moeda"),
                        rs.getString("ds_moeda"));
                        moeda.add(m);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de moedas:\n" +
                    ex.getMessage(), "Moeda", JOptionPane.ERROR_MESSAGE);
        }
        return moeda;
    }

    public Object getById(int id) {
        Moeda moeda = null;
        try{
            sql = "SELECT cd_moeda, ds_moeda " +
                  "  FROM moeda" +
                  " WHERE cd_moeda = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                        moeda = new Moeda(
                        rs.getInt("cd_moeda"),
                        rs.getString("ds_moeda"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em moeda:\n" +
                    ex.getMessage(), "Moeda", JOptionPane.ERROR_MESSAGE);
        }
        return moeda;
    }
    
}
