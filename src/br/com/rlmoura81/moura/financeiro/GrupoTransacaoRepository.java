package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GrupoTransacaoRepository{

    String sql = "";

    public ArrayList getLista() {
        ArrayList gptrans = new ArrayList();
        try{
            sql = "SELECT cd_gptrans, ds_gptrans " +
                  "  FROM gptrans";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                GrupoTransacao gt = new GrupoTransacao(
                    rs.getInt("cd_gptrans"),
                    rs.getString("ds_gptrans"));
                    gptrans.add(gt);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de grupo de transação:\n" +
                    ex.getMessage());
        }
        return gptrans;
    }
    
    public ArrayList getListaCompraVenda() {
        ArrayList gptrans = new ArrayList();
        try{
            sql = "SELECT cd_gptrans, ds_gptrans " +
                  "  FROM gptrans" + 
                  " WHERE cd_gptrans = 5 OR cd_gptrans = 6";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                GrupoTransacao gt = new GrupoTransacao(
                    rs.getInt("cd_gptrans"),
                    rs.getString("ds_gptrans"));
                    gptrans.add(gt);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de grupo de transação:\n" +
                    ex.getMessage());
        }
        return gptrans;
    }

    public Object getById(int id) {
        GrupoTransacao gptrans = null;
        try{
            sql = "SELECT cd_gptrans, ds_gptrans " +
                  "  FROM gptrans" +
                  " WHERE cd_gptrans = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                    gptrans = new GrupoTransacao(
                    rs.getInt("cd_gptrans"),
                    rs.getString("ds_gptrans"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em Grupo Transação:\n" +
                    ex.getMessage());
        }
        return gptrans;
    }    
}
