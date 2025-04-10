package br.com.rlmoura81.moura.principalcadastro;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AssinaturaRepository implements IPadraoRepository{
        
    String sql = "";
    
    PrestadorServicoRepository presservr = new PrestadorServicoRepository();
    
    Utilidade util = new Utilidade();
    
    @Override
    public void inserir(Object o) {
        Assinatura a = (Assinatura) o;
        try{
            sql = "INSERT INTO assinatura (cd_assinatura, ds_servico, ds_login, ds_senha, nm_valor, tp_assinatura, dt_validade, cd_presserv, cd_usuario)" +
                  "     VALUES (sq_assinatura.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, a.getDs_servico());
            ps.setString(2, a.getDs_login());
            ps.setString(3, a.getDs_senha());
            ps.setBigDecimal(4, a.getNm_valor());
            ps.setInt(5, a.getTp_assinatura());
            ps.setString(6, Utilidade.formatoData.format(a.getDt_validade().getTime()));
            ps.setInt(7, a.getPresserv().getCd_presserv());
            ps.setInt(8, a.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Assinatura", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao inserir:\n" +
                    ex.getMessage(), "Assinatura", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void alterar(Object o) {
        Assinatura a = (Assinatura) o;
        try{
            sql = "UPDATE assinatura " +
                  "   SET ds_servico = ?, " +
                  "       ds_login = ?, " +
                  "       ds_senha = ?, " +
                  "       nm_valor = ?, " +
                  "       tp_assinatura = ?, " +
                  "       dt_validade = ?, " +
                  "       cd_presserv = ?" +
                  " WHERE cd_assinatura = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, a.getDs_servico());
            ps.setString(2, a.getDs_login());
            ps.setString(3, a.getDs_senha());
            ps.setBigDecimal(4, a.getNm_valor());
            ps.setInt(5, a.getTp_assinatura());
            ps.setString(6, Utilidade.formatoData.format(a.getDt_validade().getTime()));
            ps.setInt(7, a.getPresserv().getCd_presserv());
            ps.setInt(8, a.getCd_assinatura());
            ps.setInt(9, a.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Assinatura", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Assinatura", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void excluir(Object o) {
        Assinatura a = (Assinatura) o;
        try{
            sql = "DELETE FROM assinatura " +
                  " WHERE cd_assinatura = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, a.getCd_assinatura());
            ps.setInt(2, a.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Assinatura", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Assinatura", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public ArrayList getLista() {
        ArrayList assinatura = new ArrayList();
        try{
            sql = "SELECT cd_assinatura, ds_servico, ds_login, ds_senha, nm_valor, tp_assinatura, to_char(dt_validade,'dd/MM/yyyy'), cd_presserv, cd_usuario" +
                  "  FROM assinatura" +
                  " WHERE cd_usuario = ?" +
                  " ORDER BY ds_servico";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Assinatura a = new Assinatura(
                    rs.getInt("cd_assinatura"),
                    rs.getString("ds_servico"),
                    rs.getString("ds_login"),
                    rs.getString("ds_senha"),
                    rs.getBigDecimal("nm_valor"),
                    rs.getInt("tp_assinatura"),
                    util.recebeData(rs.getString("to_char(dt_validade,'dd/MM/yyyy')")),
                    (PrestadorServico)presservr.getById(rs.getInt("cd_presserv")),
                    rs.getInt("cd_usuario"));
                assinatura.add(a);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de assinaturas:\n" +
                    ex.getMessage(), "Assinatura", JOptionPane.ERROR_MESSAGE);
        }
        return assinatura;
    }
    
    public ArrayList getLista(String ds_servico) {
        ArrayList assinatura = new ArrayList();
        try{
            sql = "SELECT cd_assinatura, ds_servico, ds_login, ds_senha, nm_valor, tp_assinatura, to_char(dt_validade,'dd/MM/yyyy'), cd_presserv, cd_usuario" +
                  "  FROM assinatura" +
                  " WHERE upper(ds_servico) LIKE ? OR lower(ds_servico) LIKE ?" +
                  "   AND cd_usuario = ?" +  
                  " ORDER BY ds_servico";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, "%"+ds_servico+"%");
            ps.setString(2, "%"+ds_servico+"%");
            ps.setInt(3, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Assinatura a = new Assinatura(
                    rs.getInt("cd_assinatura"),
                    rs.getString("ds_servico"),
                    rs.getString("ds_login"),
                    rs.getString("ds_senha"),
                    rs.getBigDecimal("nm_valor"),
                    rs.getInt("tp_assinatura"),
                    util.recebeData(rs.getString("to_char(dt_validade,'dd/MM/yyyy')")),
                    (PrestadorServico)presservr.getById(rs.getInt("cd_presserv")),
                    rs.getInt("cd_usuario"));
                assinatura.add(a);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de assinaturas:\n" +
                    ex.getMessage(), "Assinatura", JOptionPane.ERROR_MESSAGE);
        }
        return assinatura;
    }
    
    @Override
    public Object getById(int id) {
        Assinatura assinatura = null;
        try{
            sql = "SELECT cd_assinatura, ds_servico, ds_login, ds_senha, nm_valor, tp_assinatura, to_char(dt_validade,'dd/MM/yyyy'), cd_presserv, cd_usuario" +
                  "  FROM assinatura" +
                  " WHERE cd_assinatura = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                assinatura = new Assinatura(
                    rs.getInt("cd_assinatura"),
                    rs.getString("ds_servico"),
                    rs.getString("ds_login"),
                    rs.getString("ds_senha"),
                    rs.getBigDecimal("nm_valor"),
                    rs.getInt("tp_assinatura"),
                    util.recebeData(rs.getString("to_char(dt_validade,'dd/MM/yyyy')")),
                    (PrestadorServico)presservr.getById(rs.getInt("cd_presserv")),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em Assinatura:\n" +
                    ex.getMessage(), "Assinatura", JOptionPane.ERROR_MESSAGE);
        }
        return assinatura;
    }
    
}
