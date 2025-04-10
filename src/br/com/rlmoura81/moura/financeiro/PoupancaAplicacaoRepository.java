package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PoupancaAplicacaoRepository implements IPadraoRepository{

    String sql = "";
    
    PoupancaRepository poupr = new PoupancaRepository();
        
    Utilidade util = new Utilidade();

    @Override
    public void inserir(Object o) {
        PoupancaAplicacao poupap = (PoupancaAplicacao) o;
        try{
            sql = "INSERT INTO poupaplic (cd_poupaplic, vl_saldo, dt_saldo, cd_poupanca, cd_usuario) " +
                  "     VALUES (sq_poupaplic.nextval, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setBigDecimal(1, poupap.getVl_saldo());
            ps.setString(2, Utilidade.formatoData.format(poupap.getDt_saldo().getTime()));
            ps.setInt(3, poupap.getPoupanca().getCd_poupanca());
            ps.setInt(4, poupap.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Aplicado.", "Poupança Aplicação", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao aplicar:\n" +
                    ex.getMessage(), "Poupança Aplicação", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void alterar(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Object o) {
        PoupancaAplicacao poupap = (PoupancaAplicacao) o;
        try{
            sql = "DELETE FROM poupaplic " +
                  " WHERE cd_poupaplic = ? " +
                  "   AND cd_poupanca = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, poupap.getCd_poupaplic());
            ps.setInt(2, poupap.getPoupanca().getCd_poupanca());
            ps.setInt(3, poupap.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Poupança Aplicação", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Poupança Aplicação", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public ArrayList getLista() {
        ArrayList poupap = new ArrayList();
        try{
            sql = "SELECT cd_poupaplic, vl_saldo, to_char(dt_saldo,'dd/MM/yyyy'), cd_poupanca, cd_usuario" +
                  "  FROM poupaplic" +
                  " WHERE cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PoupancaAplicacao pap = new PoupancaAplicacao(
                    rs.getInt("cd_poupaplic"),
                    rs.getBigDecimal("vl_saldo"),
                    util.recebeData(rs.getString("to_char(dt_saldo,'dd/MM/yyyy')")),    
                    (Poupanca)poupr.getById(rs.getInt("cd_poupanca")),
                    rs.getInt("cd_usuario"));
                poupap.add(pap);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Aplicação Poupança:\n" +
                    ex.getMessage(), "Poupança Aplicação", JOptionPane.ERROR_MESSAGE);
        }
        return poupap;
    }
    
    public ArrayList getLista(int cd_poupanca) {
        ArrayList poupap = new ArrayList();
        try{
            sql = "SELECT cd_poupaplic, vl_saldo, to_char(dt_saldo,'dd/MM/yyyy'), cd_poupanca, cd_usuario" +
                  "  FROM poupaplic" +
                  " WHERE cd_poupanca = ?" +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_poupanca);
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                PoupancaAplicacao pap = new PoupancaAplicacao(
                    rs.getInt("cd_poupaplic"),
                    rs.getBigDecimal("vl_saldo"),
                    util.recebeData(rs.getString("to_char(dt_saldo,'dd/MM/yyyy')")),    
                    (Poupanca)poupr.getById(rs.getInt("cd_poupanca")),
                    rs.getInt("cd_usuario"));
                poupap.add(pap);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Aplicação Poupança:\n" +
                    ex.getMessage(), "Poupança Aplicação", JOptionPane.ERROR_MESSAGE);
        }
        return poupap;
    }

    @Override
    public Object getById(int id) {
        PoupancaAplicacao poupap = null;
        try{
            sql = "SELECT cd_poupaplic, vl_saldo, to_char(dt_saldo,'dd/MM/yyyy'), cd_poupanca, cd_usuario" +
                  "  FROM poupaplic" +
                  " WHERE cd_poupaplic = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                poupap = new PoupancaAplicacao(
                    rs.getInt("cd_poupaplic"),
                    rs.getBigDecimal("vl_saldo"),
                    util.recebeData(rs.getString("to_char(dt_saldo,'dd/MM/yyyy')")),
                    (Poupanca)poupr.getById(rs.getInt("cd_poupanca")),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em Aplicação Poupança:\n" +
                    ex.getMessage(), "Poupança Aplicação", JOptionPane.ERROR_MESSAGE);
        }
        return poupap;
    }

}
