package br.com.rlmoura81.moura.animal;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProdutoRepository implements IPadraoRepository{

    String sql = "";
    
    @Override
    public void inserir(Object o) {
        Produto p = (Produto) o;
        try{
            sql = "INSERT INTO produto (cd_produto, ds_produto, nm_peso, cd_usuario)" +
                  "     VALUES (sq_produto.nextval, ?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, p.getDs_produto());
            ps.setBigDecimal(2, p.getNm_peso());
            ps.setInt(3, p.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Produto", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Produto", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void alterar(Object o) {
        Produto p = (Produto) o;
        try{
            sql = "UPDATE produto " +
                  "   SET ds_produto = ?, " +
                  "       nm_peso = ?, " +
                  "       cd_usuario = ?" +
                  " WHERE cd_produto = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, p.getDs_produto());
            ps.setBigDecimal(2, p.getNm_peso());
            ps.setInt(3, p.getCd_usuario());
            ps.setInt(4, p.getCd_produto());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado.", "Produto", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Produto", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void excluir(Object o) {
        Produto p = (Produto) o;
        try{
            sql = "DELETE FROM produto " +
                  " WHERE cd_produto = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, p.getCd_produto());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Produto", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Produto", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public ArrayList getLista() {
        ArrayList produto = new ArrayList();
        try{
            sql = "SELECT cd_produto, ds_produto, nm_peso, cd_usuario" +
                  "  FROM produto" +
                  "  ORDER BY ds_produto";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Produto p = new Produto(
                    rs.getInt("cd_produto"),
                    rs.getString("ds_produto"),
                    rs.getBigDecimal("nm_peso"),
                    rs.getInt("cd_usuario"));
                produto.add(p);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de produtos:\n" +
                    ex.getMessage(), "Produto", JOptionPane.ERROR_MESSAGE);
        }
        return produto;
    }

    @Override
    public Object getById(int id) {
        Produto produto = null;
        try{
            sql = "SELECT cd_produto, ds_produto, nm_peso, cd_usuario" +
                  "  FROM produto" +
                  "  WHERE cd_produto = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                produto = new Produto(
                    rs.getInt("cd_produto"),
                    rs.getString("ds_produto"),
                    rs.getBigDecimal("nm_peso"),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em produto:\n" +
                    ex.getMessage(), "Produto", JOptionPane.ERROR_MESSAGE);
        }
        return produto;
    }
}
