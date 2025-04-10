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
import javax.swing.JOptionPane;

public class CartaoLancamentoRepository implements IPadraoRepository{
    
    String sql = "";
    
    CartaoRepository cartaor = new CartaoRepository();
    
    DespesaRepository despesar = new DespesaRepository();
    
    CategoriaRepository categoriar = new CategoriaRepository();
    
    Utilidade util = new Utilidade();

    @Override
    public void inserir(Object o) {
        CartaoLancamento cl = (CartaoLancamento) o;
        try{
            sql = "INSERT INTO cartaolanc (ds_despesa, nm_valor, nm_parcela, dt_despesa, cd_despesa, cd_categoria, cd_cartao, cd_usuario, cd_cartaolanc)" +
                  "     VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, cl.getDs_despesa());
            ps.setBigDecimal(2, cl.getNm_valor());
            ps.setInt(3, cl.getNm_parcela());
            ps.setString(4, Utilidade.formatoData.format(cl.getDt_despesa().getTime()));
            ps.setInt(5, cl.getDespesa().getCd_despesa());
            ps.setInt(6, cl.getCategoria().getCd_Categoria());
            ps.setInt(7, cl.getCartao().getCd_cartao());
            ps.setInt(8, cl.getCd_usuario());
            ps.setInt(9, cl.getCd_cartaolanc());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Cartão Lançamento", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Cartão Lançamento", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void alterar(Object o) {
        CartaoLancamento cl = (CartaoLancamento) o;
        try{
            sql = "UPDATE cartaolanc " +
                  "   SET ds_despesa = ?, " +
                  "       nm_valor = ?, " +
                  "       nm_parcela = ?," +
                  "       dt_despesa = ?, " +
                  "       cd_despesa = ?, " +
                  "       cd_categoria = ?" +
                  " WHERE cd_cartao = ?" +
                  "   AND cd_cartaolanc = ?" +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, cl.getDs_despesa());
            ps.setBigDecimal(2, cl.getNm_valor());
            ps.setInt(3, cl.getNm_parcela());
            ps.setString(4, Utilidade.formatoData.format(cl.getDt_despesa().getTime()));
            ps.setInt(5, cl.getDespesa().getCd_despesa());
            ps.setInt(6, cl.getCategoria().getCd_Categoria());
            ps.setInt(7, cl.getCartao().getCd_cartao());
            ps.setInt(8, cl.getCd_cartaolanc());
            ps.setInt(9, cl.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Aterado.", "Cartão Lançamento", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Cartão Lançamento", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void excluir(Object o) {
        CartaoLancamento cl = (CartaoLancamento) o;
        try{
            sql = "DELETE FROM cartaolanc" +
                  " WHERE cd_cartao = ?" +
                  "   AND cd_cartaolanc = ?" +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cl.getCartao().getCd_cartao());
            ps.setInt(2, cl.getCd_cartaolanc());
            ps.setInt(3, cl.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Cartão Lançamento", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir." +
                    ex.getMessage(), "Cartão Lançamento", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public ArrayList getLista() {
        ArrayList clanc = new ArrayList();
        try{
            sql = "SELECT cd_cartaolanc, ds_despesa, nm_valor, nm_parcela, to_char(dt_despesa,'dd/MM/yyyy'), cd_despesa, cd_categoria, cd_cartao, cd_usuario" +
                  "  FROM cartaolanc" +
                  " WHERE cd_usuario = ?" +
                  " ORDER BY dt_despesa";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                CartaoLancamento cl = new CartaoLancamento(
                        rs.getInt("cd_cartaolanc"),
                        rs.getString("ds_despesa"),
                        rs.getBigDecimal("nm_valor"),
                        rs.getInt("nm_parcela"),
                        util.recebeData(rs.getString("to_char(dt_despesa,'dd/MM/yyyy')")),
                        (Despesa)despesar.getById(rs.getInt("cd_despesa")),
                        (Categoria)categoriar.getById(rs.getInt("cd_categoria")),
                        (Cartao)cartaor.getById(rs.getInt("cd_cartao")),
                        rs.getInt("cd_usuario"));
                clanc.add(cl);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Cartão Lançamentos:\n" +
                    ex.getMessage(), "Cartão Lançamento", JOptionPane.ERROR_MESSAGE);
        }
        return clanc;
    }
    
    public ArrayList getLista(int cd_cartao) {
        ArrayList clanc = new ArrayList();
        try{
            sql = "SELECT cd_cartaolanc, ds_despesa, nm_valor, nm_parcela, to_char(dt_despesa,'dd/MM/yyyy'), cd_despesa, cd_categoria, cd_cartao, cd_usuario" +
                  "  FROM cartaolanc" +
                  " WHERE cd_cartao = ?" +
                  "   AND cd_usuario = ?" +
                  " ORDER BY dt_despesa";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_cartao);
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                CartaoLancamento cl = new CartaoLancamento(
                        rs.getInt("cd_cartaolanc"),
                        rs.getString("ds_despesa"),
                        rs.getBigDecimal("nm_valor"),
                        rs.getInt("nm_parcela"),
                        util.recebeData(rs.getString("to_char(dt_despesa,'dd/MM/yyyy')")),
                        (Despesa)despesar.getById(rs.getInt("cd_despesa")),
                        (Categoria)categoriar.getById(rs.getInt("cd_categoria")),
                        (Cartao)cartaor.getById(rs.getInt("cd_cartao")),
                        rs.getInt("cd_usuario"));
                clanc.add(cl);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Cartão Lançamentos:\n" +
                    ex.getMessage(), "Cartão Lançamento", JOptionPane.ERROR_MESSAGE);
        }
        return clanc;
    }

    @Override
    public Object getById(int id) {
        CartaoLancamento clanc = null;
        try{
            sql = "SELECT cd_cartaolanc, ds_despesa, nm_valor, nm_parcela, to_char(dt_despesa,'dd/MM/yyyy'), cd_despesa, cd_categoria, cd_cartao, cd_usuario" +
                  "  FROM cartaolanc" +
                  " WHERE cd_cartaolanc = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                clanc = new CartaoLancamento(
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
            JOptionPane.showMessageDialog(null, "Erro de getById em Cartão Lançamentos:\n" +
                    ex.getMessage(), "Cartão Lançamento", JOptionPane.ERROR_MESSAGE);
        }
        return clanc;
    }
    
    public Object ultimoRegistro(int id) {
        CartaoLancamento clanc = null;
        try{
            sql = "SELECT cd_cartaolanc, ds_despesa, nm_valor, nm_parcela, to_char(dt_despesa,'dd/MM/yyyy'), cd_despesa, cd_categoria, cd_cartao, cd_usuario" +
                  "  FROM cartaolanc" +
                  " WHERE cd_usuario = ?" +
                  " ORDER BY cd_cartaolanc DESC";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                clanc = new CartaoLancamento(
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
            JOptionPane.showMessageDialog(null, "Erro de ultimoRegistro em Cartão Lançamentos:\n" +
                    ex.getMessage(), "Cartão Lançamento", JOptionPane.ERROR_MESSAGE);
        }
        return clanc;
    }
    
}
