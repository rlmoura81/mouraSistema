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

public class CartaoParcelamentoRepository implements IPadraoRepository{
    
    CartaoRepository cartaor = new CartaoRepository();
    
    DespesaRepository despesar = new DespesaRepository();
    
    CategoriaRepository categoriar = new CategoriaRepository();
       
    String sql = "";
    
    Utilidade util = new Utilidade();

    public void inserirParcela(Object o) throws SQLException{
        CartaoParcelamento cp = (CartaoParcelamento) o;
            sql = "INSERT INTO cartaoparc (cd_parcela, dt_parcela, nm_parcelapag, cd_cartaolanc, ds_despesa, nm_valor, nm_parcela, dt_despesa, cd_despesa, cd_categoria, cd_cartao, cd_usuario)" +
                  "     VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cp.getCd_parcela());
            ps.setString(2, Utilidade.formatoData.format(cp.getDt_parcela().getTime()));
            ps.setInt(3, cp.getNm_parcelapag());
            ps.setInt(4, cp.getCd_cartaolanc());
            ps.setString(5, cp.getDs_despesa());
            ps.setBigDecimal(6, cp.getNm_valor());
            ps.setInt(7, cp.getNm_parcela());
            ps.setString(8, Utilidade.formatoData.format(cp.getDt_despesa().getTime()));
            ps.setInt(9, cp.getDespesa().getCd_despesa());
            ps.setInt(10, cp.getCategoria().getCd_Categoria());
            ps.setInt(11, cp.getCartao().getCd_cartao());
            ps.setInt(12, cp.getCd_usuario());
            ps.execute();
            ps.close();
    }
    
    @Override
    public void inserir(Object o) {
        CartaoParcelamento cp = (CartaoParcelamento) o;
        try{
            sql = "INSERT INTO cartaoparc (cd_parcela, dt_parcela, nm_parcelapag, cd_cartaolanc, ds_despesa, nm_valor, nm_parcela, dt_despesa, cd_despesa, cd_categoria, cd_cartao, cd_usuario)" +
                  "     VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cp.getCd_parcela());
            ps.setString(2, Utilidade.formatoData.format(cp.getDt_parcela().getTime()));
            ps.setInt(3, cp.getNm_parcelapag());
            ps.setInt(4, cp.getCd_cartaolanc());
            ps.setString(5, cp.getDs_despesa());
            ps.setBigDecimal(6, cp.getNm_valor());
            ps.setInt(7, cp.getNm_parcela());
            ps.setString(8, Utilidade.formatoData.format(cp.getDt_despesa().getTime()));
            ps.setInt(9, cp.getDespesa().getCd_despesa());
            ps.setInt(10, cp.getCategoria().getCd_Categoria());
            ps.setInt(11, cp.getCartao().getCd_cartao());
            ps.setInt(12, cp.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Cartão Parcelamento", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Cartão Parcelamento", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public void alterar(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void excluir(Object o) {
        
    }
    
    public void excluirParcelas(Object o){
        CartaoParcelamento cp = (CartaoParcelamento) o;
        try{
            sql = "DELETE FROM cartaoparc " +
                  " WHERE dt_parcela = ? " +
                  "   AND cd_parcela = ? " +
                  "   AND cd_cartao = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, Utilidade.formatoData.format(cp.getDt_parcela().getTime()));
            ps.setInt(2, cp.getCd_parcela());
            ps.setInt(3, cp.getCartao().getCd_cartao());
            ps.setInt(4, cp.getCd_usuario());
            ps.execute();
            ps.close();
            //JOptionPane.showMessageDialog(null, "Excluido.", "Cartão Parcelamento", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir parcela:\n" +
                    ex.getMessage(), "Cartão Parcelamento", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public ArrayList getLista() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public ArrayList getLista(int cd_cartao) {
        ArrayList cartaop = new ArrayList();
        try{
            sql = "SELECT cd_parcela, to_char(dt_parcela,'dd/MM/yyyy'), nm_parcelapag, cd_cartaolanc, ds_despesa, nm_valor, nm_parcela, to_char(dt_despesa,'dd/MM/yyyy'), cd_despesa, cd_categoria, cd_cartao, cd_usuario" +
                  "  FROM cartaoparc" +
                  " WHERE cd_cartao = ? " +
                  "   AND cd_usuario = ?" +
                  " ORDER BY cd_parcela, nm_parcelapag";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_cartao);
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                CartaoParcelamento cp = new CartaoParcelamento(
                        rs.getInt("cd_parcela"),
                        util.recebeData(rs.getString("to_char(dt_parcela,'dd/MM/yyyy')")),
                        rs.getInt("nm_parcelapag"),
                        rs.getInt("cd_cartaolanc"),
                        rs.getString("ds_despesa"),
                        rs.getBigDecimal("nm_valor"),
                        rs.getInt("nm_parcela"),
                        util.recebeData(rs.getString("to_char(dt_despesa,'dd/MM/yyyy')")),
                        (Despesa)despesar.getById(rs.getInt("cd_despesa")),
                        (Categoria)categoriar.getById(rs.getInt("cd_categoria")),
                        (Cartao)cartaor.getById(rs.getInt("cd_cartao")),
                        rs.getInt("cd_usuario"));
                cartaop.add(cp);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Cartão Parcelamento:\n" +
                    ex.getMessage(), "Cartão Parcelamento", JOptionPane.ERROR_MESSAGE);
        }
        return cartaop;
    }

    @Override
    public Object getById(int id) {
        CartaoParcelamento cartaop = null;
        try{
            sql = "SELECT cd_parcela, to_char(dt_parcela,'dd/MM/yyyy'), nm_parcelapag, cd_cartaolanc, ds_despesa, nm_valor, nm_parcela, to_char(dt_despesa,'dd/MM/yyyy'), cd_despesa, cd_categoria, cd_cartao, cd_usuario" +
                  "  FROM cartaoparc" +
                  " WHERE cd_parcela = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                cartaop = new CartaoParcelamento(
                        rs.getInt("cd_parcela"),
                        util.recebeData(rs.getString("to_char(dt_parcela,'dd/MM/yyyy')")),
                        rs.getInt("nm_parcelapag"),
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
            JOptionPane.showMessageDialog(null, "Erro de getById em Cartão Parcelamento:\n" +
                    ex.getMessage(), "Cartão Parcelamento", JOptionPane.ERROR_MESSAGE);
        }
        return cartaop;
    }
    
    public Object ultimoRegistro(int id) {
         CartaoParcelamento cartaop = null;
        try{
            sql = "SELECT cd_parcela, to_char(dt_parcela,'dd/MM/yyyy'), nm_parcelapag, cd_cartaolanc, ds_despesa, nm_valor, nm_parcela, to_char(dt_despesa,'dd/MM/yyyy'), cd_despesa, cd_categoria, cd_cartao, cd_usuario" +
                  "  FROM cartaoparc" +
                  " WHERE cd_usuario = ?" +
                  " ORDER BY cd_parcela DESC";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                cartaop = new CartaoParcelamento(
                        rs.getInt("cd_parcela"),
                        util.recebeData(rs.getString("to_char(dt_parcela,'dd/MM/yyyy')")),
                        rs.getInt("nm_parcelapag"),
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
            JOptionPane.showMessageDialog(null, "Erro de utimoRegistro em Cartão Parcelamento:\n" +
                    ex.getMessage(), "Cartão Parcelamento", JOptionPane.ERROR_MESSAGE);
        }
        return cartaop;
    }


}
