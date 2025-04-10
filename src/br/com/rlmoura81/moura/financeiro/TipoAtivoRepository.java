package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TipoAtivoRepository{

    String sql = "";

    public ArrayList getLista() {
        ArrayList tpfundimob = new ArrayList();
        try{
            sql = "SELECT cd_tpativo, ds_tpativo " +
                  "  FROM tpativo " +
                  " ORDER BY ds_tpativo";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                TipoAtivo tpativo = new TipoAtivo(
                    rs.getInt("cd_tpativo"),
                    rs.getString("ds_tpativo"));
                tpfundimob.add(tpativo);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de tipo de ativos:\n" + 
                    ex.getMessage());
        }
        return tpfundimob;
    }
    
    public ArrayList getListaTipoRendaFixa() {
        ArrayList tpfundimob = new ArrayList();
        try{
            sql = "SELECT cd_tpativo, ds_tpativo " +
                  "  FROM tpativo" +
                  " WHERE cd_tpativo = 3 OR cd_tpativo = 4" +
                  " ORDER BY ds_tpativo";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                TipoAtivo tpativo = new TipoAtivo(
                    rs.getInt("cd_tpativo"),
                    rs.getString("ds_tpativo"));
                tpfundimob.add(tpativo);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de tipo de ativos:\n" + 
                    ex.getMessage());
        }
        return tpfundimob;
    }
    
    //Lista Tipo de Ativo por Ação ou FII.
    public ArrayList getListaTipoAtivoAcaoFII() {
        ArrayList tpfundimob = new ArrayList();
        try{
            sql = "SELECT cd_tpativo, ds_tpativo " +
                  "  FROM tpativo" +
                  " WHERE cd_tpativo = 1 OR cd_tpativo = 2" +
                  " ORDER BY ds_tpativo";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                TipoAtivo tpativo = new TipoAtivo(
                    rs.getInt("cd_tpativo"),
                    rs.getString("ds_tpativo"));
                tpfundimob.add(tpativo);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de tipo de ativos:\n" + 
                    ex.getMessage());
        }
        return tpfundimob;
    }

    public Object getById(int id) {
        TipoAtivo tpativo = null;
        try{
            sql = "SELECT cd_tpativo, ds_tpativo " +
                  "  FROM tpativo " +
                  " WHERE cd_tpativo = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                tpativo = new TipoAtivo(
                    rs.getInt("cd_tpativo"),
                    rs.getString("ds_tpativo"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em tipo de ativos:\n" + 
                    ex.getMessage());
        }
        return tpativo;
    }
}
