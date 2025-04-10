package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class RendaRepository implements IPadraoRepository{
    
    String sql = "";
    
    TipoRendaRepository tprendar = new TipoRendaRepository();
        
    Utilidade util = new Utilidade();

    @Override
    public void inserir(Object o) {
        Renda r = (Renda) o;
        try{
            sql = "INSERT INTO renda (cd_renda, dt_renda, ds_renda, nm_valor, cd_tprenda, cd_usuario)" +
                  "     VALUES (sq_renda.nextval, ?, ?, ?, ?, ?)";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, Utilidade.formatoData.format(r.getDt_renda().getTime()));
            ps.setString(2, r.getDs_renda());
            ps.setBigDecimal(3, r.getNm_valor());
            ps.setInt(4, r.getTprenda().getCd_tprenda());
            ps.setInt(5, r.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Renda", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Renda", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void alterar(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Object o) {
        Renda r = (Renda) o;
        try{
            sql = "DELETE FROM renda " +
                  " WHERE cd_renda = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, r.getCd_renda());
            ps.setInt(2, r.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Renda", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Excluir:\n" +
                    ex.getMessage(), "Renda", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public ArrayList getLista() {
        ArrayList renda = new ArrayList();
        try{
            sql = "SELECT cd_renda, to_char(dt_renda,'dd/MM/yyyy'), ds_renda, nm_valor, cd_tprenda, cd_usuario" +
                  "  FROM renda" +
                  " WHERE cd_usuario = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Renda r = new Renda(
                    rs.getInt("cd_renda"),
                    util.recebeData(rs.getString("to_char(dt_renda,'dd/MM/yyyy')")),
                    rs.getString("ds_renda"),
                    rs.getBigDecimal("nm_valor"),
                    (TipoRenda)tprendar.getById(rs.getInt("cd_tprenda")),
                    rs.getInt("cd_usuario"));
                renda.add(r);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Renda:\n" +
                    ex.getMessage(), "Renda", JOptionPane.ERROR_MESSAGE);
        }
        return renda;
    }
    
    public ArrayList getLista(int cd_tprenda) {
        ArrayList renda = new ArrayList();
        try{
            sql = "SELECT cd_renda, to_char(dt_renda,'dd/MM/yyyy'), ds_renda, nm_valor, cd_tprenda, cd_usuario" +
                  "  FROM renda" +
                  " WHERE cd_tprenda = ?" +
                  "   AND cd_usuario = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_tprenda);
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Renda r = new Renda(
                    rs.getInt("cd_renda"),
                    util.recebeData(rs.getString("to_char(dt_renda,'dd/MM/yyyy')")),
                    rs.getString("ds_renda"),
                    rs.getBigDecimal("nm_valor"),
                    (TipoRenda)tprendar.getById(rs.getInt("cd_tprenda")),
                    rs.getInt("cd_usuario"));
                renda.add(r);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Renda:\n" +
                    ex.getMessage(), "Renda", JOptionPane.ERROR_MESSAGE);
        }
        return renda;
    }

    public ArrayList getLista(Object dtInicial, Object dtFinal) {
        ArrayList renda = new ArrayList();
        try{
            sql = "SELECT cd_renda, to_char(dt_renda,'dd/MM/yyyy'), ds_renda, nm_valor, cd_tprenda, cd_usuario" +
                  "  FROM renda" +
                  " WHERE cd_usuario = ?" +
                  "   AND dt_renda BETWEEN ? AND ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ps.setObject(2, dtInicial);
            ps.setObject(3, dtFinal);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Renda r = new Renda(
                    rs.getInt("cd_renda"),
                    util.recebeData(rs.getString("to_char(dt_renda,'dd/MM/yyyy')")),
                    rs.getString("ds_renda"),
                    rs.getBigDecimal("nm_valor"),
                    (TipoRenda)tprendar.getById(rs.getInt("cd_tprenda")),
                    rs.getInt("cd_usuario"));
                renda.add(r);
            }
            ps.close();            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Renda mensal:\n" +
                    ex.getMessage(), "Renda", JOptionPane.ERROR_MESSAGE);
        }
        return renda;
    }
        
    @Override
    public Object getById(int id) {
        Renda renda = null;
        try{
            sql = "SELECT cd_renda, to_char(dt_renda,'dd/MM/yyyy'), ds_renda, nm_valor, cd_tprenda, cd_usuario" +
                  "  FROM renda" +
                  " WHERE cd_renda = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                renda = new Renda(
                    rs.getInt("cd_renda"),
                    util.recebeData(rs.getString("to_char(dt_renda,'dd/MM/yyyy')")),                        
                    rs.getString("ds_renda"),
                    rs.getBigDecimal("nm_valor"),
                    (TipoRenda)tprendar.getById(rs.getInt("cd_tprenda")),
                    rs.getInt("cd_usuario"));
            }
            ps.close();            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em Renda:\n" +
                    ex.getMessage(), "Renda", JOptionPane.ERROR_MESSAGE);
        }
        return renda;
    }
    
}
