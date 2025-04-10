package br.com.rlmoura81.moura.cartao;

import br.com.rlmoura81.moura.financeiro.Despesa;
import br.com.rlmoura81.moura.financeiro.DespesaRepository;
import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalcadastro.Categoria;
import br.com.rlmoura81.moura.principalcadastro.CategoriaRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class CartaoLancamentoFechamentoRepository implements IPadraoRepository{
    
    String sql = "";
    
    CartaoRepository cartaor = new CartaoRepository();    
    DespesaRepository despesar = new DespesaRepository();    
    CategoriaRepository categoriar = new CategoriaRepository();    
        
    Utilidade util = new Utilidade();

    @Override
    public void inserir(Object o) {
        CartaoLancamentoFechamento clf = (CartaoLancamentoFechamento) o;
        try{
            sql = "INSERT INTO cartaolancf (cd_cartaolanc, ds_despesa, nm_valor, nm_parcela, dt_despesa, cd_despesa, cd_categoria, cd_cartao, cd_usuario)" +
                  "    (SELECT cartaolanc.cd_cartaolanc, cartaolanc.ds_despesa, cartaolanc.nm_valor, cartaolanc.nm_parcela, cartaolanc.dt_despesa, cartaolanc.cd_despesa, cartaolanc.cd_categoria, cartaolanc.cd_cartao, cartaolanc.cd_usuario\n" +
                  "       FROM cartaolanc " +
                  "      WHERE cd_cartao = ? " +
                  "        AND cd_usuario = ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, clf.getCartao().getCd_cartao());
            ps.setInt(2, clf.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Fatura fechada.", "Cartão Lançamento Fechamento", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro a fechar a fatura:\n" +
                    ex.getMessage(), "Cartão Lançamento Fechamento", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void inserirFechamento(Object o) throws SQLException{
        CartaoLancamentoFechamento clf = (CartaoLancamentoFechamento) o;
            sql = "INSERT INTO cartaolancf (cd_cartaolanc, ds_despesa, nm_valor, nm_parcela, dt_despesa, cd_despesa, cd_categoria, cd_cartao, cd_usuario)" +
                  "    (SELECT cartaolanc.cd_cartaolanc, cartaolanc.ds_despesa, cartaolanc.nm_valor, cartaolanc.nm_parcela, cartaolanc.dt_despesa, cartaolanc.cd_despesa, cartaolanc.cd_categoria, cartaolanc.cd_cartao, cartaolanc.cd_usuario\n" +
                  "       FROM cartaolanc " +
                  "      WHERE cd_cartao = ? " +
                  "        AND cd_usuario = ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, clf.getCartao().getCd_cartao());
            ps.setInt(2, clf.getCd_usuario());
            ps.execute();
            ps.close();
    }
    
    @Override
    public void alterar(Object o) {
        CartaoLancamentoFechamento clf = (CartaoLancamentoFechamento) o;
        try{
            sql = "UPDATE cartaolancf " +
                  "   SET cd_cartaolancf = ?, " +
                  "       dt_fechamento = ?" +
                  " WHERE cd_cartaolancf is null " +
                  "   AND cd_cartao = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, clf.getCd_cartaolancf());
            ps.setString(2, Utilidade.formatoData.format(clf.getDt_fechamento().getTime()));
            ps.setInt(3, clf.getCartao().getCd_cartao());
            ps.setInt(4, clf.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Fatura alterada.", "Cartão Lançamento Fechamento", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Cartão Lançamento Fechamento", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void alterarFechamento(Object o) throws SQLException{
        CartaoLancamentoFechamento clf = (CartaoLancamentoFechamento) o;
            sql = "UPDATE cartaolancf " +
                  "   SET cd_cartaolancf = ?, " +
                  "       dt_fechamento = ?" +
                  " WHERE cd_cartaolancf is null " +
                  "   AND cd_cartao = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, clf.getCd_cartaolancf());
            ps.setString(2, Utilidade.formatoData.format(clf.getDt_fechamento().getTime()));
            ps.setInt(3, clf.getCartao().getCd_cartao());
            ps.setInt(4, clf.getCd_usuario());
            ps.execute();
            ps.close();
    }    

    @Override
    public void excluir(Object o) {
        CartaoLancamento cl = (CartaoLancamento) o;
        try{
            sql = "DELETE FROM cartaolanc" +
                  " WHERE cd_cartao = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cl.getCartao().getCd_cartao());
            ps.setInt(2, cl.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido", "Cartão Lançamento Fechamento", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Cartão Lançamento Fechamento", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void excluirFechamento(Object o) throws SQLException{
        CartaoLancamento cl = (CartaoLancamento) o;
            sql = "DELETE FROM cartaolanc" +
                  " WHERE cd_cartao = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cl.getCartao().getCd_cartao());
            ps.setInt(2, cl.getCd_usuario());
            ps.execute();
            ps.close();
    }    

    @Override
    public ArrayList getLista() {
        ArrayList clancf = new ArrayList();
        try{
            sql = "SELECT cd_cartaolancf, to_char(dt_fechamento,'dd/MM/yyyy'), cd_cartaolanc, ds_despesa, nm_valor, nm_parcela, to_char(dt_despesa,'dd/MM/yyyy'), cd_despesa, cd_categoria, cd_cartao, cd_usuario" +
                  "  FROM cartaolancf" +
                  " WHERE cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                CartaoLancamentoFechamento clf = new CartaoLancamentoFechamento(
                        rs.getInt("cd_cartaolancf"),
                        util.recebeData(rs.getString("to_char(dt_fechamento,'dd/MM/yyyy')")),
                        rs.getInt("cd_cartaolanc"),
                        rs.getString("ds_despesa"),
                        rs.getBigDecimal("nm_valor"),
                        rs.getInt("nm_parcela"),
                        util.recebeData(rs.getString("to_char(dt_despesa,'dd/MM/yyyy')")),
                        (Despesa)despesar.getById(rs.getInt("cd_despesa")),
                        (Categoria)categoriar.getById(rs.getInt("cd_categoria")),
                        (Cartao)cartaor.getById(rs.getInt("cd_cartao")),
                        rs.getInt("cd_usuario"));
                clancf.add(clf);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Cartão Lançamentos Fechamento:\n" +
                   ex.getMessage(), "Cartão Lançamento Fechamento", JOptionPane.ERROR_MESSAGE);
        }
        return clancf;
    }

    public ArrayList getLista(Calendar data, int cd_cartao) {
        ArrayList clancf = new ArrayList();
        try{
            sql = "SELECT cd_cartaolancf, to_char(dt_fechamento,'dd/MM/yyyy'), cd_cartaolanc, ds_despesa, nm_valor, nm_parcela, to_char(dt_despesa,'dd/MM/yyyy'), cd_despesa, cd_categoria, cd_cartao, cd_usuario" +
                  "  FROM cartaolancf" +
                  " WHERE dt_fechamento = ? " +
                  "   AND cd_cartao = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, Utilidade.formatoData.format(data.getTime()));
            ps.setInt(2, cd_cartao);
            ps.setInt(3, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                CartaoLancamentoFechamento clf = new CartaoLancamentoFechamento(
                        rs.getInt("cd_cartaolancf"),
                        util.recebeData(rs.getString("to_char(dt_fechamento,'dd/MM/yyyy')")),
                        rs.getInt("cd_cartaolanc"),
                        rs.getString("ds_despesa"),
                        rs.getBigDecimal("nm_valor"),
                        rs.getInt("nm_parcela"),
                        util.recebeData(rs.getString("to_char(dt_despesa,'dd/MM/yyyy')")),
                        (Despesa)despesar.getById(rs.getInt("cd_despesa")),
                        (Categoria)categoriar.getById(rs.getInt("cd_categoria")),
                        (Cartao)cartaor.getById(rs.getInt("cd_cartao")),
                        rs.getInt("cd_usuario"));
                clancf.add(clf);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Cartão Lançamentos Fechamento:\n" +
                    ex.getMessage(), "Cartão Lançamento Fechamento", JOptionPane.ERROR_MESSAGE);
        }
        return clancf;
    }
    
    public ArrayList getLista(int cd_cartao) {
        ArrayList clancf = new ArrayList();
        try{
            sql = "SELECT COUNT(cd_cartaolancf), to_char(dt_fechamento,'dd/MM/yyyy')" +
                  "  FROM cartaolancf" +
                  " WHERE cd_cartao = ? " +
                  "   AND cd_usuario = ?" +
                  " GROUP BY dt_fechamento" +
                  " ORDER BY dt_fechamento";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_cartao);
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                CartaoLancamentoFechamento clf = new CartaoLancamentoFechamento(
                        rs.getInt("COUNT(cd_cartaolancf)"),
                        util.recebeData(rs.getString("to_char(dt_fechamento,'dd/MM/yyyy')")));
                clancf.add(clf);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Faturas Fechadas:\n" +
                    ex.getMessage(), "Cartão Lançamento Fechamento", JOptionPane.ERROR_MESSAGE);
        }
        return clancf;
    }

    @Override
    public Object getById(int id) {
        CartaoLancamentoFechamento clancf = null;
        try{
            sql = "SELECT cd_cartaolancf, to_char(dt_fechamento,'dd/MM/yyyy'), cd_cartaolanc, ds_despesa, nm_valor, nm_parcela, to_char(dt_despesa,'dd/MM/yyyy'), cd_despesa, cd_categoria, cd_cartao, cd_usuario" +
                  "  FROM cartaolancf" +
                  " WHERE cd_cartaolancf = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                clancf = new CartaoLancamentoFechamento(
                        rs.getInt("cd_cartaolancf"),
                        util.recebeData(rs.getString("to_char(dt_fechamento,'dd/MM/yyyy')")),
                        rs.getInt("cd_cartaolanc"),
                        rs.getString("ds_despesa"),
                        rs.getBigDecimal("nm_valor"),
                        rs.getInt("nm_parcela"),
                        util.recebeData(rs.getString("to_char(dt_despesa,'dd/MM/yyyy')")),
                        (Despesa)despesar.getById(rs.getInt("cd_despesa")),
                        (Categoria)categoriar.getById(rs.getInt("cd_categoria")),
                        (Cartao)cartaor.getById(rs.getInt("cd_cartao")),
                        rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em Cartão Lançamentos Fechamento:\n" +
                    ex.getMessage(), "Cartão Lançamento Fechamento", JOptionPane.ERROR_MESSAGE);
        }
        return clancf;
    }
    
    public Object ultimoRegistro(int cd_usuario) {
        CartaoLancamentoFechamento clancf = null;
        try{
            sql = "SELECT cd_cartaolancf, to_char(dt_fechamento,'dd/MM/yyyy'), cd_cartaolanc, ds_despesa, nm_valor, nm_parcela, to_char(dt_despesa,'dd/MM/yyyy'), cd_despesa, cd_categoria, cd_cartao, cd_usuario" +
                  "  FROM cartaolancf" +
                  " WHERE cd_usuario = ?" +
                  " ORDER BY cd_cartaolancf DESC";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_usuario);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                clancf = new CartaoLancamentoFechamento(
                        rs.getInt("cd_cartaolancf"),
                        util.recebeData(rs.getString("to_char(dt_fechamento,'dd/MM/yyyy')")),
                        rs.getInt("cd_cartaolanc"),
                        rs.getString("ds_despesa"),
                        rs.getBigDecimal("nm_valor"),
                        rs.getInt("nm_parcela"),
                        util.recebeData(rs.getString("to_char(dt_despesa,'dd/MM/yyyy')")),
                        (Despesa)despesar.getById(rs.getInt("cd_despesa")),
                        (Categoria)categoriar.getById(rs.getInt("cd_categoria")),
                        (Cartao)cartaor.getById(rs.getInt("cd_cartao")),
                        rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de ultimoRegistro em Cartão Lançamentos Fechamento:\n" +
                    ex.getMessage(), "Cartão Lançamento Fechamento", JOptionPane.ERROR_MESSAGE);
        }
        return clancf;
    }    

}
