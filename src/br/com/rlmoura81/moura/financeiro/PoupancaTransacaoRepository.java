package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PoupancaTransacaoRepository implements IPadraoRepository{

    String sql = "";
    
    GrupoTransacaoRepository gptransr = new GrupoTransacaoRepository();
    
    PoupancaRepository poupancar = new PoupancaRepository();
        
    Utilidade util = new Utilidade();

    @Override
    public void inserir(Object o) {
        PoupancaTransacao pouptr = (PoupancaTransacao) o;
        try{
            sql = "INSERT INTO pouptrans (cd_pouptrans, vl_transacao, dt_transacao, cd_gptrans, cd_poupanca, cd_usuario) " +
                  "     VALUES (sq_pouptrans.nextval, ?, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setBigDecimal(1, pouptr.getVl_transacao());
            ps.setString(2, Utilidade.formatoData.format(pouptr.getDt_transacao().getTime()));
            ps.setInt(3, pouptr.getGptrans().getCd_gptrans());
            ps.setInt(4, pouptr.getPoupanca().getCd_poupanca());
            ps.setInt(5, pouptr.getCd_usuario());
            ps.execute();
            ps.close();            
            JOptionPane.showMessageDialog(null, "Transação efetuada.", "Poupança Transação", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao executar transação:\n" +
                    ex.getMessage(), "Poupança Transação", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void alterar(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Object o) {
        PoupancaTransacao pouptr = (PoupancaTransacao) o;
        try{
            sql = "DELETE FROM pouptrans " +
                  " WHERE cd_pouptrans = ? " +
                  "   AND cd_poupanca = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, pouptr.getCd_poupaplic());
            ps.setInt(2, pouptr.getPoupanca().getCd_poupanca());
            ps.setInt(3, pouptr.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Poupança Transação", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Poupança Transação", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public ArrayList getLista() {
        ArrayList pouptr = new ArrayList();
        try{
            sql = "SELECT cd_pouptrans, vl_transacao, to_char(dt_transacao,'dd/MM/yyyy'), cd_gptrans, cd_poupanca, cd_usuario" +
                  "  FROM pouptrans" +
                  " WHERE cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                PoupancaTransacao ptr = new PoupancaTransacao(
                    rs.getInt("cd_pouptrans"),
                    rs.getBigDecimal("vl_transacao"),
                    util.recebeData(rs.getString("to_char(dt_transacao,'dd/MM/yyyy')")),
                    (GrupoTransacao)gptransr.getById(rs.getInt("cd_gptrans")),    
                    (Poupanca)poupancar.getById(rs.getInt("cd_poupanca")),
                    rs.getInt("cd_usuario"));
                pouptr.add(ptr);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Transações da Poupança:\n" +
                    ex.getMessage(), "Poupança Transação", JOptionPane.ERROR_MESSAGE);
        }
        return pouptr;
    }

    @Override
    public Object getById(int id) {
        PoupancaTransacao pouptr = null;
        try{
            sql = "SELECT cd_pouptrans, vl_transacao, to_char(dt_transacao,'dd/MM/yyyy'), cd_gptrans, cd_poupanca, cd_usuario" +
                  "  FROM pouptrans" +
                  " WHERE cd_pouptrans = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                pouptr = new PoupancaTransacao(
                    rs.getInt("cd_pouptrans"),
                    rs.getBigDecimal("vl_transacao"),
                    util.recebeData(rs.getString("to_char(dt_transacao,'dd/MM/yyyy')")),
                    (GrupoTransacao)gptransr.getById(rs.getInt("cd_gptrans")),
                    (Poupanca)poupancar.getById(rs.getInt("cd_poupanca")),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em Aplicação Poupança:\n" +
                    ex.getMessage(), "Poupança Transação", JOptionPane.ERROR_MESSAGE);
        }
        return pouptr;
    }
}
