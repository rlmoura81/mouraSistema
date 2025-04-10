package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FundoInvestimentoRendimentoRepository implements IPadraoRepository{

    String sql = "";
    
    FundoInvestimentoAplicacaoRepository fiar = new FundoInvestimentoAplicacaoRepository();
    
    Utilidade util = new Utilidade();

    @Override
    public void inserir(Object o) {
        FundoInvestimentoRendimento fir = (FundoInvestimentoRendimento) o;
        try{
            sql = "INSERT INTO fdinvestrend (cd_fdinvestrend, vl_rendimento, dt_rendimento, cd_fdinvestaplic, cd_usuario)" +
                  "     VALUES (sq_fdinvestrend.nextval, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setBigDecimal(1, fir.getVl_rendimento());
            ps.setString(2, Utilidade.formatoData.format(fir.getDt_rendimento().getTime()));
            ps.setInt(3, fir.getFdinvap().getCd_fdinvestaplic());
            ps.setInt(4, fir.getCd_usuario());
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao inserir Fundo Investimento Rendimento:\n" +
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
        ArrayList fdinvrd = new ArrayList();
        try{
            sql = "SELECT cd_fdinvestrend, vl_rendimento, to_char(dt_rendimento,'dd/MM/yyyy'), cd_fdinvestaplic, cd_usuario" +
                  "  FROM fdinvestrend" +
                  " WHERE cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                FundoInvestimentoRendimento fir = new FundoInvestimentoRendimento(
                        rs.getInt("cd_fdinvestrend"),
                        rs.getBigDecimal("vl_rendimento"),
                        util.recebeData(rs.getString("to_char(dt_rendimento,'dd/MM/yyyy')")),
                        (FundoInvestimentoAplicacao)fiar.getById(rs.getInt("cd_fdinvestaplic")),
                        rs.getInt("cd_usuario"));
                fdinvrd.add(fir);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Rendimentos de Fundos de Investimentos:\n" +
                    ex.getMessage());
        }
        return fdinvrd;
    }
        
    public ArrayList getListaRendimento(int cd_fdinvestaplic) {
        ArrayList fdinvrd = new ArrayList();
        try{
            sql = "SELECT cd_fdinvestrend, vl_rendimento, to_char(dt_rendimento,'dd/MM/yyyy'), cd_fdinvestaplic, cd_usuario" +
                  "  FROM fdinvestrend" +
                  " WHERE cd_fdinvestaplic = ?" +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_fdinvestaplic);
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                FundoInvestimentoRendimento fir = new FundoInvestimentoRendimento(
                        rs.getInt("cd_fdinvestrend"),
                        rs.getBigDecimal("vl_rendimento"),
                        util.recebeData(rs.getString("to_char(dt_rendimento,'dd/MM/yyyy')")),
                        (FundoInvestimentoAplicacao)fiar.getById(rs.getInt("cd_fdinvestaplic")),
                        rs.getInt("cd_usuario"));
                fdinvrd.add(fir);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Rendimentos de Fundos de Investimentos:\n" +
                    ex.getMessage());
        }
        return fdinvrd;
    }

    @Override
    public Object getById(int id) {
        FundoInvestimentoRendimento fdinvrd = null;
        try{
            sql = "SELECT cd_fdinvestrend, vl_rendimento, to_char(dt_rendimento,'dd/MM/yyyy'), cd_fdinvestaplic, cd_usuario" +
                  "  FROM fdinvestrend" +
                  " WHERE cd_fdinvestrend = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                FundoInvestimentoRendimento fir = new FundoInvestimentoRendimento(
                        rs.getInt("cd_fdinvestrend"),
                        rs.getBigDecimal("vl_rendimento"),
                        util.recebeData(rs.getString("to_char(dt_rendimento,'dd/MM/yyyy')")),
                        (FundoInvestimentoAplicacao)fiar.getById(rs.getInt("cd_fdinvestaplic")),
                        rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em Rendimentos de Fundos de Investimentos:\n" +
                    ex.getMessage());            
        }
        return fdinvrd;
    }
    
}
