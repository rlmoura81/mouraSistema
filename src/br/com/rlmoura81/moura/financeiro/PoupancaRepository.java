package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.conexao.ConexaoPersistencia;
import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PoupancaRepository implements IPadraoRepository{

    Connection conn = ConexaoPersistencia.getConnection();
    String sql = "";
    
    ContaRepository contar = new ContaRepository();
        
    @Override
    public void inserir(Object o) {
        Poupanca p = (Poupanca) o;
        try{
            sql = "INSERT INTO poupanca (cd_poupanca, nm_variacao, vl_saldo, cd_conta, cd_usuario)" +
                  "       VALUES (sq_poupanca.nextval, ?, ?, ?, ?)";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getNm_variaca());
            ps.setBigDecimal(2, p.getVl_saldo());
            ps.setInt(3, p.getConta().getCd_conta());
            ps.setInt(4, p.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Poupança", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Poupança", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void alterar(Object o) {
        Poupanca p = (Poupanca) o;
        try{
            sql = "UPDATE poupanca SET nm_variacao = ?, cd_conta = ?" +
                  "   WHERE cd_poupanca = ? AND cd_usuario = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getNm_variaca());
            ps.setInt(2, p.getConta().getCd_conta());
            ps.setInt(3, p.getCd_poupanca());
            ps.setInt(4, p.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado.", "Poupança", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" + 
                    ex.getMessage(), "Poupança", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void excluir(Object o) {
        Poupanca p =(Poupanca) o;
        try{
            sql = "DELETE FROM poupanca WHERE cd_poupanca = ? AND cd_usuario = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, p.getCd_poupanca());
            ps.setInt(2, p.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Poupança", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Poupança", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public ArrayList getLista() {
        ArrayList poupanca = new ArrayList();
        try{
            sql = "SELECT cd_poupanca, nm_variacao, vl_saldo, cd_conta, cd_usuario" +
                  "   FROM poupanca" +
                  "   WHERE cd_usuario = ?" +
                  "   ORDER BY nm_variacao";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Poupanca p = new Poupanca(
                    rs.getInt("cd_poupanca"),
                    rs.getString("nm_variacao"),
                    rs.getBigDecimal("vl_saldo"),
                    (Conta)contar.getById(rs.getInt("cd_conta")),
                    rs.getInt("cd_usuario"));
                poupanca.add(p);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de poupanças." +
                    ex.getMessage(), "Poupança", JOptionPane.ERROR_MESSAGE);
        }
        return poupanca;
    }
    
    public ArrayList getLista(int cd_conta) {
        ArrayList poupanca = new ArrayList();
        try{
            sql = "SELECT cd_poupanca, nm_variacao, vl_saldo, cd_conta, cd_usuario" +
                  "   FROM poupanca" +
                  "   WHERE cd_usuario = ?" +
                  "     AND cd_conta = ?" +
                  "   ORDER BY nm_variacao";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ps.setInt(2, cd_conta);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Poupanca p = new Poupanca(
                    rs.getInt("cd_poupanca"),
                    rs.getString("nm_variacao"),
                    rs.getBigDecimal("vl_saldo"),
                    (Conta)contar.getById(rs.getInt("cd_conta")),
                    rs.getInt("cd_usuario"));
                poupanca.add(p);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de poupanças." +
                    ex.getMessage(), "Poupança", JOptionPane.ERROR_MESSAGE);
        }
        return poupanca;
    }
    
    @Override
    public Object getById(int id) {
        Poupanca p = null;
        try{
            sql = "SELECT cd_poupanca, nm_variacao, vl_saldo, cd_conta, cd_usuario" +
                  "   FROM poupanca" +
                  "   WHERE cd_poupanca = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                p = new Poupanca(
                    rs.getInt("cd_poupanca"),
                    rs.getString("nm_variacao"),
                    rs.getBigDecimal("vl_saldo"),
                    (Conta)contar.getById(rs.getInt("cd_conta")),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em poupanças." +
                    ex.getMessage(), "Poupança", JOptionPane.ERROR_MESSAGE);
        }
        return p;
    }
    
    public void atualizaSaldo(Object o) {
        Poupanca p = (Poupanca) o;
        try{
            sql = "UPDATE poupanca SET vl_saldo = ?" +
                  "   WHERE cd_poupanca = ? AND cd_usuario = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setBigDecimal(1, p.getVl_saldo());
            ps.setInt(2, p.getCd_poupanca());
            ps.setInt(3, p.getCd_usuario());
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar saldo:\n" + 
                    ex.getMessage());
        }
    }
}
