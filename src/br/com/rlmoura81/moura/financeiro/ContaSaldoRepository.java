package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ContaSaldoRepository implements IPadraoRepository{

    String sql = "";
    
    ContaRepository contar = new ContaRepository();
        
    @Override
    public void inserir(Object o) {
        ContaSaldo csaldo = (ContaSaldo) o;
        try{
            sql = "INSERT INTO contasaldo (cd_conta, vl_saldo, cd_usuario)" +
                  "     VALUES (?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, csaldo.getConta().getCd_conta());
            ps.setBigDecimal(2, csaldo.getVl_saldo());
            ps.setInt(3, csaldo.getCd_usuario());
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao inserir Saldo:\n" +
                    ex.getMessage());
        }
    }

    @Override
    public void alterar(Object o) {
        ContaSaldo csaldo = (ContaSaldo) o;
        try{
            sql = "UPDATE contasaldo " +
                  "   SET vl_saldo = ?" +
                  " WHERE cd_conta = ?" +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setBigDecimal(1, csaldo.getVl_saldo());
            ps.setInt(2, csaldo.getConta().getCd_conta());
            ps.setInt(3, csaldo.getCd_usuario());
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar saldo:\n" +
                    ex.getMessage());
        }
    }

    @Override
    public void excluir(Object o) {
        ContaSaldo csaldo = (ContaSaldo) o;
        try{
            sql = "DELETE FROM contasaldo" +
                  " WHERE cd_conta = ?" +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, csaldo.getConta().getCd_conta());
            ps.setInt(2, csaldo.getCd_usuario());
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir saldo da conta:\n" +
                    ex.getMessage());
        }
    }

    @Override
    public ArrayList getLista() {
        ArrayList csaldo = new ArrayList();
        try{
            sql = "SELECT cd_conta, vl_saldo, cd_usuario" +
                  "  FROM contasaldo" +
                  " WHERE cd_usuario = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                ContaSaldo cs = new ContaSaldo(
                        (Conta)contar.getById(rs.getInt("cd_conta")),
                        rs.getBigDecimal("vl_saldo"),
                        rs.getInt("cd_usuario"));
                        csaldo.add(cs);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Conta Saldo:\n" +
                    ex);
        }
        return csaldo;
    }
    
    @Override
    public Object getById(int id) {
        ContaSaldo csaldo = null;
        try{
            sql = "SELECT cd_conta, vl_saldo, cd_usuario" +
                  "  FROM contasaldo" +
                  " WHERE cd_conta = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                csaldo = new ContaSaldo(
                        (Conta)contar.getById(rs.getInt("cd_conta")),
                        rs.getBigDecimal("vl_saldo"),
                        rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em Conta Saldo:\n" +
                    ex.getMessage());
        }
        return csaldo;
    }
    
    public Object getContaSaldo(int id) {
        ContaSaldo csaldo = null;
        try{
            sql = "SELECT cd_conta, vl_saldo, cd_usuario" +
                  "  FROM contasaldo" +
                  " WHERE cd_conta = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                csaldo = new ContaSaldo(
                        (Conta)contar.getById(rs.getInt("cd_conta")),
                        rs.getBigDecimal("vl_saldo"),
                        rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getContaSaldo em Conta Saldo:\n" +
                    ex.getMessage());
        }
        return csaldo;
    }    
}
