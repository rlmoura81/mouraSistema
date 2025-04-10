package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TipoRendaRepository{

    String sql = "";

    public ArrayList getLista() {
        ArrayList tprenda = new ArrayList();
        try {
            sql = "SELECT cd_tprenda, ds_tprenda " +
                  "  FROM tprenda";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                TipoRenda tr = new TipoRenda(
                    rs.getInt("cd_tprenda"),
                    rs.getString("ds_tprenda"));
                    tprenda.add(tr);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Tipo de Renda:\n" +
                    ex);
        }
        return tprenda;
    }

    public Object getById(int id) {
        TipoRenda tprenda = null;
        try {
            sql = "SELECT cd_tprenda, ds_tprenda " +
                  "  FROM tprenda" +
                  " WHERE cd_tprenda = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                tprenda = new TipoRenda(
                    rs.getInt("cd_tprenda"),
                    rs.getString("ds_tprenda"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em Tipo de Renda:\n" +
                    ex);
        }
        return tprenda;
    }
    
}
