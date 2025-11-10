package br.com.rlmoura81.moura.principalcadastro;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TipoEmpresaRepository {
    
    String sql = "";
    
    /*
    *EM TESTE - COLOCAR COMENTARIO
    *LISTA DO TIPO DE EMPRESAS
    */
    public ArrayList<TipoEmpresa> getLista(){
        ArrayList<TipoEmpresa> tpempresa = new ArrayList();
        try{
            sql = "SELECT cd_tpempresa, ds_tpempresa" +
                  "  FROM tpempresa";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                TipoEmpresa tpe = new TipoEmpresa(
                    rs.getInt("cd_tpempresa"),
                    rs.getString("ds_tpempresa"));
                tpempresa.add(tpe);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Tipo de Empresa:\n" + 
                    ex.getMessage(), "Tipo Empresa", JOptionPane.ERROR_MESSAGE);
        }
        return tpempresa;
    }
    
    public Object getById (int id){
        TipoEmpresa tpempresa = null;
        try{
            sql = "SELECT cd_tpempresa, ds_tpempresa" +
                  "  FROM tpempresa" + 
                  " WHERE cd_tpempresa = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                tpempresa = new TipoEmpresa(
                    rs.getInt("cd_tpempresa"),
                    rs.getString("ds_tpempresa"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em Tipo de Empresa:\n" + 
                    ex.getMessage(), "Tipo Empresa", JOptionPane.ERROR_MESSAGE);
        }
        return tpempresa;
    }
}
