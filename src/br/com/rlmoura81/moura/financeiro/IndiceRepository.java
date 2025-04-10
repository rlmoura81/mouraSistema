package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class IndiceRepository{
    
    String sql = "";

    public ArrayList getLista() {
        ArrayList indice = new ArrayList();
        try{
            sql = "SELECT cd_indice, ds_indice " +
                  "  FROM indice";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Indice i = new Indice(
                    rs.getInt("cd_indice"),
                    rs.getString("ds_indice"));
                    indice.add(i);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de índices:\n" +
                    ex.getMessage(), "Índice", JOptionPane.ERROR_MESSAGE);
        }
        return indice;
    }

    public Object getById(int id) {
        Indice indice = null;
        try{
            sql = "SELECT cd_indice, ds_indice " +
                  "  FROM indice" +
                  " WHERE cd_indice = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                    indice = new Indice(
                    rs.getInt("cd_indice"),
                    rs.getString("ds_indice"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em índices:\n" +
                    ex.getMessage(), "Índice", JOptionPane.ERROR_MESSAGE);
        }
        return indice;
    }    
}
