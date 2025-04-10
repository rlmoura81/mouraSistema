package br.com.rlmoura81.moura.cartao;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CartaoBandeiraRepository{
    
    String sql = "";

    public ArrayList getLista() {
        ArrayList cartaobandeira = new ArrayList();
        try{
            sql = "SELECT cd_cartaobandeira, ds_cartaobandeira " +
                  "  FROM cartaobandeira";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                CartaoBandeira cb = new CartaoBandeira(
                    rs.getInt("cd_cartaobandeira"),
                    rs.getString("ds_cartaobandeira"));
                    cartaobandeira.add(cb);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de bandeiras de cartão." + 
                    ex.getMessage(), "Cartão Bandeira", JOptionPane.ERROR_MESSAGE);
        }
        return cartaobandeira;
    }

    public Object getById(int id) {
        CartaoBandeira cb = null;
        try{
            sql = "SELECT cd_cartaobandeira, ds_cartaobandeira " +
                  "  FROM cartaobandeira" +
                  " WHERE cd_cartaobandeira = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                cb = new CartaoBandeira(
                    rs.getInt("cd_cartaobandeira"),
                    rs.getString("ds_cartaobandeira"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em cartao bandeira." + 
                    ex.getMessage(), "Cartão Bandeira", JOptionPane.ERROR_MESSAGE);
        }
        return cb;
    }
}
