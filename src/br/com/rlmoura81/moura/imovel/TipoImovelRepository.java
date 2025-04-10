package br.com.rlmoura81.moura.imovel;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TipoImovelRepository{

    String sql = "";

    public ArrayList getLista() {
        ArrayList tpimovel = new ArrayList();
        try{
            sql = "SELECT cd_tpimovel, ds_tpimovel " +
                  "  FROM tipoimovel";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                TipoImovel tpi = new TipoImovel(
                    rs.getInt("cd_tpimovel"),
                    rs.getString("ds_tpimovel"));
                tpimovel.add(tpi);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de tipo de imoveis:\n" +
                    ex.getMessage(), "Tipo", JOptionPane.ERROR_MESSAGE);
        }
        return tpimovel;
    }

    public Object getById(int id) {
        TipoImovel tpi = null;
        try{
            sql = "SELECT cd_tpimovel, ds_tpimovel " +
                  "  FROM tipoimovel" +
                  " WHERE cd_tpimovel = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                tpi = new TipoImovel(
                    rs.getInt("cd_tpimovel"),
                    rs.getString("ds_tpimovel"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em tipo de imovel:\n" + 
                    ex.getMessage(), "Tipo", JOptionPane.ERROR_MESSAGE);
        }
        return tpi;
    }    
}
