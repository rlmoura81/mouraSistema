package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FundoInvestimentoTransacaoRepository implements IPadraoRepository{

    String sql = "";
    
    GrupoTransacaoRepository gptransr = new GrupoTransacaoRepository();
    
    FundoInvestimentoAplicacaoRepository fiar = new FundoInvestimentoAplicacaoRepository();
    
    ContaRepository contar = new ContaRepository();
    
    Utilidade util = new Utilidade();

    @Override
    public void inserir(Object o) {
        FundoInvestimentoTransacao fit = (FundoInvestimentoTransacao) o;
        try{
            sql = "INSERT INTO fdinvesttrans (cd_fdinvesttrans, vl_transacao, dt_transacao, cd_gptrans, cd_fdinvestaplic, cd_conta, cd_usuario)" +
                  "     VALUES (sq_fdinvesttrans.nextval, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setBigDecimal(1, fit.getVl_transacao());
            ps.setString(2, Utilidade.formatoData.format(fit.getDt_transacao().getTime()));
            ps.setInt(3, fit.getGptrans().getCd_gptrans());
            ps.setInt(4, fit.getFdinvestap().getCd_fdinvestaplic());
            ps.setInt(5, fit.getConta().getCd_conta());
            ps.setInt(6, fit.getCd_usuario());
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao inserir Fundo Investimento Transacao:\n" +
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
        ArrayList fdinvtr = new ArrayList();
        try{
            sql = "SELECT cd_fdinvesttrans, vl_transacao, to_char(dt_transacao,'dd/MM/yyyy'), cd_gptrans, cd_fdinvestaplic, cd_conta, cd_usuario" +
                  "  FROM fdinvesttrans" +
                  " WHERE cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                FundoInvestimentoTransacao fit = new FundoInvestimentoTransacao(
                        rs.getInt("cd_fdinvesttrans"),
                        rs.getBigDecimal("vl_transacao"),
                        util.recebeData(rs.getString("to_char(dt_transacao,'dd/MM/yyyy')")), 
                        (GrupoTransacao)gptransr.getById(rs.getInt("cd_gptrans")),
                        (FundoInvestimentoAplicacao)fiar.getById(rs.getInt("cd_fdinvestaplic")),
                        (Conta)contar.getById(rs.getInt("cd_conta")),
                        rs.getInt("cd_usuario"));
                fdinvtr.add(fit);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Transações de Fundos de Investimentos:\n" +
                    ex.getMessage());
        }
        return fdinvtr;
    }

    public ArrayList getListaFdInvestTrans(int fdinvestaplic, int conta) {
        ArrayList fdinvtr = new ArrayList();
        try{
            sql = "SELECT cd_fdinvesttrans, vl_transacao, to_char(dt_transacao,'dd/MM/yyyy'), cd_gptrans, cd_fdinvestaplic, cd_conta, cd_usuario" +
                  "  FROM fdinvesttrans" +
                  " WHERE cd_fdinvestaplic = ?" +
                  "   AND cd_conta = ?" +
                  "   AND cd_usuario = ?" + 
                  " ORDER BY dt_transacao DESC";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, fdinvestaplic);
            ps.setInt(2, conta);
            ps.setInt(3, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                FundoInvestimentoTransacao fit = new FundoInvestimentoTransacao(
                        rs.getInt("cd_fdinvesttrans"),
                        rs.getBigDecimal("vl_transacao"),
                        util.recebeData(rs.getString("to_char(dt_transacao,'dd/MM/yyyy')")), 
                        (GrupoTransacao)gptransr.getById(rs.getInt("cd_gptrans")),
                        (FundoInvestimentoAplicacao)fiar.getById(rs.getInt("cd_fdinvestaplic")),
                        (Conta)contar.getById(rs.getInt("cd_conta")),
                        rs.getInt("cd_usuario"));
                fdinvtr.add(fit);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Transações de Fundos de Investimentos:\n" +
                    ex.getMessage());
        }
        return fdinvtr;
    }
        
    @Override
    public Object getById(int id) {
        FundoInvestimentoTransacao fdinvtr = null;
        try{
            sql = "SELECT cd_fdinvesttrans, vl_transacao, to_char(dt_transacao,'dd/MM/yyyy), cd_gptrans, cd_fdinvestaplic, cd_conta, cd_usuario" +
                  "  FROM fdinvesttrans" +
                  " WHERE cd_fdinvesttrans = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                FundoInvestimentoTransacao fit = new FundoInvestimentoTransacao(
                        rs.getInt("cd_fdinvesttrans"),
                        rs.getBigDecimal("vl_transacao"),
                        util.recebeData(rs.getString("to_char(dt_transacao,'dd/MM/yyyy)")), 
                        (GrupoTransacao)gptransr.getById(rs.getInt("cd_gptrans")),
                        (FundoInvestimentoAplicacao)fiar.getById(rs.getInt("cd_fdinvestaplic")),
                        (Conta)contar.getById(rs.getInt("cd_conta")),
                        rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em Transações de Fundos de Investimentos:\n" +
                    ex.getMessage());
        }
        return fdinvtr;
    }
    
}
