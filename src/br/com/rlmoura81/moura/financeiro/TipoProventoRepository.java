package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TipoProventoRepository{

    String sql = "";

    public ArrayList getLista() {
        ArrayList tpprovento = new ArrayList();
        try{
            sql = "SELECT cd_tpprovento, ds_tpprovento " +
                  "  FROM tpprovento";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                TipoProvento tpp = new TipoProvento(
                    rs.getInt("cd_tpprovento"),
                    rs.getString("ds_tpprovento"));
                    tpprovento.add(tpp);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de tipo de provento:\n" +
                    ex.getMessage());
        }
        return tpprovento;
    }

    public ArrayList getListaTpProvAcao() {
        ArrayList tpprovento = new ArrayList();
        try{
            sql = "SELECT DISTINCT tpprovento.cd_tpprovento, ds_tpprovento" +
                  "  FROM tpprovento, acaoprov" +
                  " WHERE tpprovento.cd_tpprovento = acaoprov.cd_tpprovento";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                TipoProvento tpp = new TipoProvento(
                    rs.getInt("cd_tpprovento"),
                    rs.getString("ds_tpprovento"));
                    tpprovento.add(tpp);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de tipo de provento:\n" +
                    ex.getMessage());
        }
        return tpprovento;
    }
    
        public ArrayList getListaTpProvFII() {
        ArrayList tpprovento = new ArrayList();
        try{
            sql = "SELECT DISTINCT tpprovento.cd_tpprovento, ds_tpprovento" +
                  "  FROM tpprovento, fdimprov" +
                  " WHERE tpprovento.cd_tpprovento = fdimprov.cd_tpprovento";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                TipoProvento tpp = new TipoProvento(
                    rs.getInt("cd_tpprovento"),
                    rs.getString("ds_tpprovento"));
                    tpprovento.add(tpp);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de tipo de provento:\n" +
                    ex.getMessage());
        }
        return tpprovento;
    }

    public Object getById(int id) {
        TipoProvento tpp = null;
        try{
            sql = "SELECT cd_tpprovento, ds_tpprovento " +
                  "  FROM tpprovento" +
                  " WHERE cd_tpprovento = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                tpp = new TipoProvento(
                    rs.getInt("cd_tpprovento"),
                    rs.getString("ds_tpprovento"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em tipo de provento:\n" +
                    ex.getMessage());
        }
        return tpp;
    }
 
}
