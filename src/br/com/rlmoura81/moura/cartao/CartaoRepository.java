package br.com.rlmoura81.moura.cartao;

import br.com.rlmoura81.moura.financeiro.Banco;
import br.com.rlmoura81.moura.financeiro.BancoRepository;
import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CartaoRepository implements IPadraoRepository{

    String sql = "";
    
    Utilidade util = new Utilidade();
    
    CartaoBandeiraRepository cartaobandeirar = new CartaoBandeiraRepository();
    
    BancoRepository bancor = new BancoRepository();

    @Override
    public void inserir(Object o) {
        Cartao c = (Cartao) o;        
        try{
            sql = "INSERT INTO cartao (cd_cartao, nm_cartao, nm_limite, dt_validade, cd_cartaobandeira, cd_banco, cd_usuario)" +
                  "     VALUES (sq_cartao.nextval, ?, ?, ?, ?, ?, ?)";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, c.getNm_cartao());
            ps.setBigDecimal(2, c.getNm_limite());
            ps.setString(3, Utilidade.formatoData.format(c.getDt_vencimento().getTime()));
            ps.setInt(4, c.getCartaobandeira().getCd_cartaobandeira());
            ps.setInt(5, c.getBanco().getCd_banco());
            ps.setInt(6, c.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Cartão", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Cartão", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void alterar(Object o) {
        Cartao c = (Cartao) o;        
        try{
            sql = "UPDATE cartao " +
                  "   SET nm_cartao = ?, " +
                  "       nm_limite = ?, " +
                  "       dt_validade = ?, " +
                  "       cd_cartaobandeira = ?, " +
                  "       cd_banco = ? " +
                  " WHERE cd_cartao = ? " +
                  "   AND cd_usuario = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, c.getNm_cartao());
            ps.setBigDecimal(2, c.getNm_limite());
            ps.setString(3, Utilidade.formatoData.format(c.getDt_vencimento().getTime()));
            ps.setInt(4, c.getCartaobandeira().getCd_cartaobandeira());
            ps.setInt(5, c.getBanco().getCd_banco());
            ps.setInt(6, c.getCd_cartao());
            ps.setInt(7, c.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado.", "Cartão", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Cartão", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void excluir(Object o) {
        Cartao c = (Cartao) o;
        try{
            sql = "DELETE FROM cartao " +
                  " WHERE cd_cartao = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, c.getCd_cartao());
            ps.setInt(2, c.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Cartão", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Cartão", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public ArrayList getLista() {
        ArrayList cartoes = new ArrayList();
        try{
            sql = "SELECT cd_cartao, nm_cartao, nm_limite, to_char(dt_validade,'dd/MM/yyyy'), cd_cartaobandeira, cd_banco, cd_usuario " +
                  "  FROM cartao " + 
                  " WHERE cd_usuario = ?" +
                  " ORDER BY nm_cartao";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Cartao c = new Cartao(
                    rs.getInt("cd_cartao"),
                    rs.getString("nm_cartao"),
                    rs.getBigDecimal("nm_limite"),
                    util.recebeData(rs.getString("to_char(dt_validade,'dd/MM/yyyy')")),
                    (CartaoBandeira)cartaobandeirar.getById(rs.getInt("cd_cartaobandeira")),
                    (Banco)bancor.getById(rs.getInt("cd_banco")),
                    rs.getInt("cd_usuario"));
                cartoes.add(c);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de cartões:\n" + 
                    ex.getMessage(), "Cartão", JOptionPane.ERROR_MESSAGE);
        }
        return cartoes;
    }
    
    public ArrayList getLista(int cd_banco) {
        ArrayList cartoes = new ArrayList();
        try{
            sql = "SELECT cd_cartao, nm_cartao, nm_limite, to_char(dt_validade,'dd/MM/yyyy'), cd_cartaobandeira, cd_banco, cd_usuario " +
                  "  FROM cartao " + 
                  " WHERE cd_banco = ?" +
                  "   AND cd_usuario = ?" +
                  " ORDER BY nm_cartao";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_banco);
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Cartao c = new Cartao(
                    rs.getInt("cd_cartao"),
                    rs.getString("nm_cartao"),
                    rs.getBigDecimal("nm_limite"),
                    util.recebeData(rs.getString("to_char(dt_validade,'dd/MM/yyyy')")),
                    (CartaoBandeira)cartaobandeirar.getById(rs.getInt("cd_cartaobandeira")),
                    (Banco)bancor.getById(rs.getInt("cd_banco")),
                    rs.getInt("cd_usuario"));
                cartoes.add(c);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de cartões:\n" + 
                    ex.getMessage(), "Cartão", JOptionPane.ERROR_MESSAGE);
        }
        return cartoes;
    }
    
    @Override
    public Object getById(int id) {        
        Cartao c = null;        
        try{
            sql = "SELECT cd_cartao, nm_cartao, nm_limite, to_char(dt_validade,'dd/MM/yyyy'), cd_cartaobandeira, cd_banco, cd_usuario" +
                  "  FROM cartao " + 
                  " WHERE cd_cartao = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                c = new Cartao(
                    rs.getInt("cd_cartao"),
                    rs.getString("nm_cartao"),
                    rs.getBigDecimal("nm_limite"),
                    util.recebeData(rs.getString("to_char(dt_validade,'dd/MM/yyyy')")),
                    (CartaoBandeira)cartaobandeirar.getById(rs.getInt("cd_cartaobandeira")),
                    (Banco)bancor.getById(rs.getInt("cd_banco")),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Erro de getById em cartão:\n" + 
                    ex.getMessage(), "Cartão", JOptionPane.ERROR_MESSAGE);                 
        }
        return c;
    }

}
