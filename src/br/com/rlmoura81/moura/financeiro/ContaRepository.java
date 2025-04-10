package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ContaRepository implements IPadraoRepository{

    String sql = "";
    
    BancoRepository br = new BancoRepository();
    
    TipoContaRepository tpcr = new TipoContaRepository();

    @Override
    public void inserir(Object o) {
        Conta c = (Conta) o;
        try{
            sql = "INSERT INTO conta (cd_conta, nm_agencia, nm_conta, cd_banco, cd_usuario, cd_tpconta)" +
                  "     VALUES (sq_conta.nextval, ?, ?, ?, ?, ?)";            
                  PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
                  ps.setString(1, c.getNm_agencia());
                  ps.setString(2, c.getNm_conta());
                  ps.setInt(3, c.getBanco().getCd_banco());
                  ps.setInt(4, c.getCd_usuario());
                  ps.setInt(5, c.getTpconta().getCd_tpconta());
                  ps.execute();
                  ps.close();   
                  JOptionPane.showMessageDialog(null, "Salvo.", "Conta", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                ex.getMessage(), "Conta", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void alterar(Object o) {
        Conta c = (Conta) o;
        try{
            sql = "UPDATE conta " +
                  "   SET nm_agencia = ?, " +
                  "       nm_conta = ?, " +
                  "       cd_banco = ?, " +
                  "       cd_tpconta = ?" +
                  " WHERE cd_conta = ? " +
                  "   AND cd_usuario = ?";                  
                  PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
                  ps.setString(1, c.getNm_agencia());
                  ps.setString(2, c.getNm_conta());
                  ps.setInt(3, c.getBanco().getCd_banco());
                  ps.setInt(4, c.getTpconta().getCd_tpconta());
                  ps.setInt(5, c.getCd_conta());
                  ps.setInt(6, c.getCd_usuario());
                  ps.execute();
                  ps.close();
                  JOptionPane.showMessageDialog(null, "Alterado.", "Conta", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                ex.getMessage(), "Conta", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void excluir(Object o) {
        Conta c = (Conta) o;
        try{
            sql = "DELETE FROM conta " +
                  " WHERE cd_conta = ? " +
                  "   AND cd_usuario = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, c.getCd_conta());
            ps.setInt(2, c.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Conta", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Conta", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public ArrayList getLista() {
        ArrayList contas = new ArrayList();
        try{
            sql = "SELECT cd_conta, nm_agencia, nm_conta, cd_banco, cd_usuario, cd_tpconta" +
                  "  FROM conta" +
                  " WHERE cd_usuario = ? " + 
                  " ORDER BY nm_conta";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){                
                Conta c = new Conta(
                    rs.getInt("cd_conta"),
                    rs.getString("nm_agencia"),
                    rs.getString("nm_conta"),
                    (Banco)br.getById(rs.getInt("cd_banco")),
                    (TipoConta)tpcr.getById(rs.getInt("cd_tpconta")),
                    rs.getInt("cd_usuario"));
                    contas.add(c);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de contas:\n" + 
                    ex.getMessage(), "Conta", JOptionPane.ERROR_MESSAGE);
        }
        return contas;
    }

    @Override
    public Object getById(int id) {
        Conta c = null;
        try{
            sql = "SELECT cd_conta, nm_agencia, nm_conta, cd_banco, cd_usuario, cd_tpconta" +
                  "  FROM conta" +
                  " WHERE cd_conta = ?";                
                PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    c = new Conta(
                        rs.getInt("cd_conta"),
                        rs.getString("nm_agencia"),
                        rs.getString("nm_conta"),
                        (Banco)br.getById(rs.getInt("cd_banco")),
                        (TipoConta)tpcr.getById(rs.getInt("cd_tpconta")),    
                        rs.getInt("cd_usuario"));
                }
                ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em conta:\n" +
                ex.getMessage(), "Conta", JOptionPane.ERROR_MESSAGE);
        }
        return c;
    }
    
    public Object getByIdConta(int id) {
        Conta c = null;
        try{
            sql = "SELECT cd_conta, nm_agencia, nm_conta, cd_banco, cd_usuario, cd_tpconta" +
                  "  FROM conta" +
                  " WHERE cd_usuario = ?" +
                  " ORDER BY cd_conta DESC";                
                PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    c = new Conta(
                        rs.getInt("cd_conta"),
                        rs.getString("nm_agencia"),
                        rs.getString("nm_conta"),
                        (Banco)br.getById(rs.getInt("cd_banco")),
                        (TipoConta)tpcr.getById(rs.getInt("cd_tpconta")),    
                        rs.getInt("cd_usuario"));
                }        
                ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getByIdConta em conta:\n" +
                ex.getMessage(), "Conta", JOptionPane.ERROR_MESSAGE);
        }
        return c;
    }
}
