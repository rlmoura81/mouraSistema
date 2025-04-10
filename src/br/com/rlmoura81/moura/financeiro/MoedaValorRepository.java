package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MoedaValorRepository implements IPadraoRepository{

    String sql = "";
    
    Utilidade util = new Utilidade();
    
    MoedaRepository moedar = new MoedaRepository();

    @Override
    public void inserir(Object o) {
        MoedaValor mv = (MoedaValor) o;        
        try{
            sql = "INSERT INTO moedavalor (cd_moedavl, vl_moeda, dt_valor, cd_moeda, cd_usuario)" +
                  "     VALUES (sq_moedavl.nextval, ?, ?, ?, ?)";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setBigDecimal(1, mv.getVl_moeda());
            ps.setString(2, Utilidade.formatoData.format(mv.getDt_valor().getTime()));
            ps.setInt(3, mv.getMoeda().getCd_moeda());
            ps.setInt(4, mv.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Moeda Valor", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Moeda Valor", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void alterar(Object o) {
        MoedaValor mv = (MoedaValor) o;        
        try{
            sql = "UPDATE moedavalor " +
                  "   SET vl_moeda = ?, " +
                  "       dt_valor = ?, " +
                  "       cd_moeda = ?, " +
                  "       cd_usuario = ?" +
                  " WHERE cd_moedavl = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setBigDecimal(1, mv.getVl_moeda());
            ps.setString(2, Utilidade.formatoData.format(mv.getDt_valor().getTime()));
            ps.setInt(3, mv.getMoeda().getCd_moeda());
            ps.setInt(4, mv.getCd_usuario());
            ps.setInt(5, mv.getCd_moedavl());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado.", "Moeda Valor", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Moeda Valor", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void excluir(Object o) {
        MoedaValor mv = (MoedaValor) o;
        try{
            sql = "DELETE FROM moedavalor " +
                  " WHERE cd_moedavl = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, mv.getCd_moedavl());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Moeda Valor", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Moeda Valor", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public ArrayList getLista() {
        ArrayList moedavalores = new ArrayList();
        try{
            sql = "SELECT cd_moedavl, vl_moeda, to_char(dt_valor,'dd/MM/yyyy'), cd_moeda, cd_usuario" +
                  "  FROM moedavalor";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                MoedaValor mv = new MoedaValor(
                    rs.getInt("cd_moedavl"),
                    rs.getBigDecimal("vl_moeda"),
                    util.recebeData(rs.getString("to_char(dt_valor,'dd/MM/yyyy')")),
                    (Moeda)moedar.getById(rs.getInt("cd_moeda")),
                    rs.getInt("cd_usuario"));
                moedavalores.add(mv);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de cotação:\n" +
                    ex.getMessage(), "Moeda Valor", JOptionPane.ERROR_MESSAGE);
        }
        return moedavalores;
    }

    @Override
    public Object getById(int id) {
        MoedaValor mv = null;
        try{
            sql = "SELECT cd_moedavl, vl_moeda, to_char(dt_valor,'dd/MM/yyyy'), cd_moeda, cd_usuario" +
                  "  FROM moedavalor" +
                  " WHERE cd_moedavl = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                mv = new MoedaValor(
                    rs.getInt("cd_moedavl"),
                    rs.getBigDecimal("vl_moeda"),
                    util.recebeData(rs.getString("to_char(dt_valor,'dd/MM/yyyy')")),
                    (Moeda)moedar.getById(rs.getInt("cd_moeda")),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em cotação:\n" +
                    ex.getMessage(), "Moeda Valor", JOptionPane.ERROR_MESSAGE);
        }
        return mv;
    }
}
