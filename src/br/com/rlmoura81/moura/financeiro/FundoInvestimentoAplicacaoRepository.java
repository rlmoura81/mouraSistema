package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FundoInvestimentoAplicacaoRepository implements IPadraoRepository{
    
    String sql = "";
    
    FundoInvestimentoRepository fdinvestr = new FundoInvestimentoRepository();
    
    ContaRepository contar = new ContaRepository();

    @Override
    public void inserir(Object o) {
        FundoInvestimentoAplicacao fia = (FundoInvestimentoAplicacao) o;
        try{
            sql = "INSERT INTO fdinvestaplic (cd_fdinvestaplic, vl_saldo, cd_fdinvest, cd_conta, cd_usuario)" +
                  "     VALUES(sq_fdinvestaplic.nextval, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setBigDecimal(1, fia.getVl_saldo());
            ps.setInt(2, fia.getFdinvest().getCd_fdinvest());
            ps.setInt(3, fia.getConta().getCd_conta());
            ps.setInt(4, fia.getCd_usuario());
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao inserir Fundo Investimento Aplicacao:\n" +
                    ex.getMessage());
        }
    }

    @Override
    public void alterar(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList getLista() {
        ArrayList fdinvap = new ArrayList();
        try{
            sql = "SELECT cd_fdinvestaplic, vl_saldo, cd_fdinvest, cd_conta, cd_usuario" +
                  "  FROM fdinvestaplic" + 
                  " WHERE cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                FundoInvestimentoAplicacao fia = new FundoInvestimentoAplicacao(
                        rs.getInt("cd_fdinvestaplic"),
                        rs.getBigDecimal("vl_saldo"),
                        (FundoInvestimento)fdinvestr.getById(rs.getInt("cd_fdinvest")),
                        (Conta)contar.getById(rs.getInt("cd_conta")),
                        rs.getInt("cd_usuario"));
                fdinvap.add(fia);
            }
            ps.close();
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Aplicações de Fundos de Investimentos:\n" +
                        ex.getMessage());
        }
        return fdinvap;
    }

    public ArrayList getListaFundoInvest(int conta) {
        ArrayList fdinvap = new ArrayList();
        try{
            sql = "SELECT cd_fdinvestaplic, vl_saldo, cd_fdinvest, cd_conta, cd_usuario" +
                  "  FROM fdinvestaplic" + 
                  " WHERE cd_conta = ?" +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, conta);
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                FundoInvestimentoAplicacao fia = new FundoInvestimentoAplicacao(
                        rs.getInt("cd_fdinvestaplic"),
                        rs.getBigDecimal("vl_saldo"),
                        (FundoInvestimento)fdinvestr.getById(rs.getInt("cd_fdinvest")),
                        (Conta)contar.getById(rs.getInt("cd_conta")),
                        rs.getInt("cd_usuario"));
                fdinvap.add(fia);
            }
            ps.close();
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Aplicações de Fundos de Investimentos:\n" +
                        ex.getMessage());
        }
        return fdinvap;
    }
    
    @Override
    public Object getById(int id) {
        FundoInvestimentoAplicacao fdinvap = null;
        try{
            sql = "SELECT cd_fdinvestaplic, vl_saldo, cd_fdinvest, cd_conta, cd_usuario" +
                  "  FROM fdinvestaplic" + 
                  " WHERE cd_fdinvestaplic = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                fdinvap = new FundoInvestimentoAplicacao(
                        rs.getInt("cd_fdinvestaplic"),
                        rs.getBigDecimal("vl_saldo"),
                        (FundoInvestimento)fdinvestr.getById(rs.getInt("cd_fdinvest")),
                        (Conta)contar.getById(rs.getInt("cd_conta")),
                        rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro de getById em Aplicação de Fundo de Investimentos:\n" +
                        ex.getMessage());
        }
        return fdinvap;
    }
    
    public Object ultimoRegistro() {
        FundoInvestimentoAplicacao fdinvap = null;
        try{
            sql = "SELECT cd_fdinvestaplic, vl_saldo, cd_fdinvest, cd_conta, cd_usuario" +
                  "  FROM fdinvestaplic" + 
                  " ORDER BY cd_fdinvestaplic DESC";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                fdinvap = new FundoInvestimentoAplicacao(
                        rs.getInt("cd_fdinvestaplic"),
                        rs.getBigDecimal("vl_saldo"),
                        (FundoInvestimento)fdinvestr.getById(rs.getInt("cd_fdinvest")),
                        (Conta)contar.getById(rs.getInt("cd_conta")),
                        rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro de getById em Aplicação de Fundo de Investimentos:\n" +
                        ex.getMessage());
        }
        return fdinvap;
    }
    
    public void atualizaSaldo(Object o){
        FundoInvestimentoAplicacao fia = (FundoInvestimentoAplicacao) o;
        try{
            sql = "UPDATE fdinvestaplic " +
                  "   SET vl_saldo = ?" +
                  " WHERE cd_fdinvestaplic = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setBigDecimal(1, fia.getVl_saldo());
            ps.setInt(2, fia.getCd_fdinvestaplic());
            ps.setInt(3, fia.getCd_usuario());
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar saldo:\n" +
                    ex.getMessage());
        }
    }
    
}
