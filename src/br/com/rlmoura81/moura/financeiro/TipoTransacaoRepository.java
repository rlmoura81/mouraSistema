package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TipoTransacaoRepository{

    String sql = "";
    
    GrupoTransacaoRepository gptransr = new GrupoTransacaoRepository();

    public ArrayList getLista() {
        ArrayList tptrans = new ArrayList();
        try{
            sql = "SELECT cd_tptrans, ds_tptrans, cd_gptrans " +
                  "  FROM tptrans";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                TipoTransacao tp = new TipoTransacao(
                    rs.getInt("cd_tptrans"),
                    rs.getString("ds_tptrans"),
                    (GrupoTransacao)gptransr.getById(rs.getInt("cd_gptrans")));
                    tptrans.add(tp);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de tipos de transações:\n" +
                    ex.getMessage());
        }
        return tptrans;
    }
    
    public ArrayList getLista(int cd_gptrans) {
        ArrayList tptrans = new ArrayList();
        try{
            sql = "SELECT cd_tptrans, ds_tptrans, cd_gptrans" + 
                  "  FROM tptrans" + 
                  " WHERE cd_gptrans = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_gptrans);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                TipoTransacao tp = new TipoTransacao(
                    rs.getInt("cd_tptrans"),
                    rs.getString("ds_tptrans"),
                    (GrupoTransacao)gptransr.getById(rs.getInt("cd_gptrans")));
                    tptrans.add(tp);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de tipos de transações:\n" +
                    ex.getMessage(), "Tipo Transação", JOptionPane.ERROR_MESSAGE);
        }
        return tptrans;
    }

    public Object getById(int id) {
        TipoTransacao tptrans = null;
        try{
            sql = "SELECT cd_tptrans, ds_tptrans, cd_gptrans " +
                  "  FROM tptrans" +
                  " WHERE cd_tptrans = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                    tptrans = new TipoTransacao(
                    rs.getInt("cd_tptrans"),
                    rs.getString("ds_tptrans"),
                    (GrupoTransacao)gptransr.getById(rs.getInt("cd_gptrans")));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em tipos de transações:\n" +
                    ex.getMessage(), "Tipo Transação", JOptionPane.ERROR_MESSAGE);
        }
        return tptrans;
    }
}
