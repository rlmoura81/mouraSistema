    package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalcadastro.Categoria;
import br.com.rlmoura81.moura.principalcadastro.CategoriaRepository;
import br.com.rlmoura81.moura.principalcadastro.PrestadorServico;
import br.com.rlmoura81.moura.principalcadastro.PrestadorServicoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DespesaRepository implements IPadraoRepository {
    
    String sql = "";
    
    CategoriaRepository categoriar = new CategoriaRepository();
    
    PrestadorServicoRepository presservr = new PrestadorServicoRepository();

    @Override
    public void inserir(Object o) {
        Despesa d = (Despesa) o;
        try{
            sql = "INSERT INTO despesa (cd_despesa, ds_despesa, nm_valor, cd_categoria, cd_presserv, cd_usuario)"
                + "     VALUES (sq_despesa.nextval, ?, ?, ?, ?, ?)";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, d.getDs_despesa());
            ps.setBigDecimal(2, d.getNm_valor());
            ps.setInt(3, d.getCategoria().getCd_Categoria());
            ps.setInt(4, d.getPresserv().getCd_presserv());
            ps.setInt(5, d.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Despesa.", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                ex.getMessage(), "Despesa", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void alterar(Object o) {
        Despesa d = (Despesa) o;
        try{
            sql = "UPDATE despesa " +
                  "   SET ds_despesa = ?, " +
                  "       nm_valor = ?, " +
                  "       cd_categoria = ?, " +
                  "       cd_presserv = ? " +
                  " WHERE cd_despesa = ? " +
                  "   AND cd_usuario = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, d.getDs_despesa());
            ps.setBigDecimal(2, d.getNm_valor());
            ps.setInt(3, d.getCategoria().getCd_Categoria());
            ps.setInt(4, d.getPresserv().getCd_presserv());
            ps.setInt(5, d.getCd_despesa());
            ps.setInt(6, d.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado.", "Despesa", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                ex.getMessage(), "Despesa", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void excluir(Object o) {
        Despesa d = (Despesa) o;
        try{
            sql = "DELETE FROM despesa " +
                  " WHERE cd_despesa = ? "+
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, d.getCd_despesa());
            ps.setInt(2, d.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Despesa", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Excluir:\n" +
                    ex.getMessage(), "Despesa", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public ArrayList getLista() {
        ArrayList despesas = new ArrayList();
        try{
            sql = "SELECT cd_despesa, ds_despesa, nm_valor, cd_categoria, cd_presserv, cd_usuario" +
                  "  FROM despesa" +
                  " WHERE cd_usuario = ? " +
                  " ORDER BY ds_despesa";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Despesa d = new Despesa(
                    rs.getInt("cd_despesa"),
                    rs.getString("ds_despesa"),
                    rs.getBigDecimal("nm_valor"),
                    (Categoria)categoriar.getById(rs.getInt("cd_categoria")),
                    (PrestadorServico)presservr.getById(rs.getInt("cd_presserv")),
                    rs.getInt("cd_usuario"));
                    despesas.add(d);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de despesa:\n" + 
                    ex.getMessage());
        }
        return despesas;
    }

    public ArrayList getLista(int grupo) {
        ArrayList despesas = new ArrayList();
        try{
            sql = "SELECT cd_despesa, ds_despesa, nm_valor, categoria.cd_categoria, cd_presserv, despesa.cd_usuario" +
                  "  FROM despesa, grupo, categoria" +
                  " WHERE categoria.cd_grupo = grupo.cd_grupo" +
                  "   AND grupo.cd_grupo = ?" +
                  "   AND categoria.cd_categoria = despesa.cd_categoria" +
                  "   AND despesa.cd_usuario = ?" +
                  " ORDER BY ds_despesa";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, grupo);
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Despesa d = new Despesa(
                    rs.getInt("cd_despesa"),
                    rs.getString("ds_despesa"),
                    rs.getBigDecimal("nm_valor"),
                    (Categoria)categoriar.getById(rs.getInt("cd_categoria")),
                    (PrestadorServico)presservr.getById(rs.getInt("cd_presserv")),
                    rs.getInt("cd_usuario"));
                    despesas.add(d);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de despesa por grupo:\n" + 
                    ex.getMessage());
        }
        return despesas;
    }    

    @Override
    public Object getById(int id) {
        Despesa d = null;
        try{
            sql = "SELECT cd_despesa, ds_despesa, nm_valor, cd_categoria, cd_presserv, cd_usuario" +
                  "  FROM despesa" +
                  " WHERE cd_despesa = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Categoria categoria = new Categoria();
                categoria.setCd_Categoria(rs.getInt("cd_categoria"));                
                PrestadorServico presserv = new PrestadorServico();
                presserv.setCd_presserv(rs.getInt("cd_presserv"));                
                d = new Despesa(
                    rs.getInt("cd_despesa"),
                    rs.getString("ds_despesa"),
                    rs.getBigDecimal("nm_valor"),
                    categoria,
                    presserv,
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em despesa:\n" +
                    ex.getMessage());
        }
        return d;
    }
    
}
