package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class BancoRepository implements IPadraoRepository{

    String sql = "";

    @Override
    public void inserir(Object o) {
       Banco b = (Banco) o;
       try{
           sql = "INSERT INTO banco (cd_banco, ds_banco, nm_banco, cd_usuario)" +
                 "     VALUES (sq_banco.nextval, ?, ?, ?)";
           PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
           ps.setString(1, b.getDs_banco());
           ps.setInt(2, b.getNm_banco());
           ps.setInt(3, b.getCd_usuario());
           ps.execute();
           ps.close();
           JOptionPane.showMessageDialog(null, "Salvo.", "Banco", JOptionPane.INFORMATION_MESSAGE);
       }catch(SQLException ex){
           JOptionPane.showMessageDialog(null, "Erro ao slvar:\n" +
                ex.getMessage(), "Banco", JOptionPane.ERROR_MESSAGE);
       }
    }

    @Override
    public void alterar(Object o) {
        Banco b = (Banco) o;
        try{
            sql = "UPDATE banco " +
                  "   SET ds_banco = ?, " +
                  "       nm_banco = ?, " +
                  "       cd_usuario = ? " +
                  " WHERE cd_banco = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, b.getDs_banco());
            ps.setInt(2, b.getNm_banco());
            ps.setInt(3, b.getCd_usuario());
            ps.setInt(4, b.getCd_banco());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado.", "Banco", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" + 
                    ex.getMessage(), "Banco", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void excluir(Object o) {
        Banco b = (Banco) o;
        try{
            sql = "DELETE FROM banco " +
                  " WHERE cd_banco = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, b.getCd_banco());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Banco", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" + 
                    ex.getMessage(), "Banco", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public ArrayList getLista() {
        ArrayList bancos = new ArrayList();
        try{
            sql = "SELECT cd_banco, ds_banco, nm_banco, cd_usuario" +
                  "  FROM banco" +
                  " ORDER BY ds_banco";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Banco b = new Banco(
                        rs.getInt("cd_banco"),
                        rs.getString("ds_banco"),
                        rs.getInt("nm_banco"),
                        rs.getInt("cd_usuario"));
                        bancos.add(b);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de bancos:\n" + 
                    ex.getMessage(), "Banco", JOptionPane.ERROR_MESSAGE);
        }
        return bancos;
    }

    @Override
    public Object getById(int id) {
        Banco b = null;
        try{
            sql = "SELECT cd_banco, ds_banco, nm_banco, cd_usuario" +
                  "  FROM banco" +
                  " WHERE cd_banco = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                b =  new Banco(
                    rs.getInt("cd_banco"),
                    rs.getString("ds_banco"),
                    rs.getInt("nm_banco"),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em banco:\n" +
                ex.getMessage(), "Banco", JOptionPane.ERROR_MESSAGE);
        }
        return b;
    }
}
