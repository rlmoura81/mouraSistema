package br.com.rlmoura81.moura.catalogo;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TipoMidiaRepository{
    
    String sql = "";

    public ArrayList getLista() {        
        ArrayList tipoMidias = new ArrayList();
        try {  
            sql = "SELECT cd_tipomidia, ds_tipomidia " +
                  "  FROM tipomidia" +
                  " ORDER BY cd_tipomidia";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while (rs.next()){
                TipoMidia tm = new TipoMidia(
                rs.getInt("cd_tipomidia"),
                rs.getString("ds_tipomidia"));
                tipoMidias.add(tm);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de midias:\n" + 
                    ex.getMessage(), "Tipo Mídia", JOptionPane.ERROR_MESSAGE);
        }
        return tipoMidias;  
    }

    public Object getById(int id) {        
        TipoMidia tm = null;        
        try{
            sql = "SELECT cd_tipomidia, ds_tipomidia " +
                  "  FROM tipomidia " +
                  " WHERE cd_tipomidia = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                tm = new TipoMidia(
                rs.getInt("cd_tipomidia"),
                rs.getString("ds_tipomidia"));                
            }
            ps.close();
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em tipo de mídia:\n" +
                ex.getMessage(), "Tipo Mídia", JOptionPane.ERROR_MESSAGE);
        }   
        return tm;
    }        
}
