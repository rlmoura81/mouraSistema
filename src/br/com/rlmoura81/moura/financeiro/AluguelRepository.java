package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.imovel.Imovel;
import br.com.rlmoura81.moura.imovel.ImovelRepository;
import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalcadastro.PrestadorServico;
import br.com.rlmoura81.moura.principalcadastro.PrestadorServicoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AluguelRepository implements IPadraoRepository{

    String sql = "";
    
    Utilidade util = new Utilidade();
    
    ImovelRepository imovelr = new ImovelRepository();
    
    PrestadorServicoRepository presservr = new PrestadorServicoRepository();
    
    @Override
    public void inserir(Object o) {
        Aluguel a = (Aluguel) o;
        try{
            sql = "INSERT INTO aluguel (cd_aluguel, nm_contrato, nm_vlaluguel, nm_vladm, dt_deposito, dt_contratovenc, cd_imovel, cd_presserv, cd_usuario)" +
                  "     VALUES (sq_aluguel.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, a.getNm_contrato());
            ps.setBigDecimal(2, a.getNm_vlaluguel());
            ps.setBigDecimal(3, a.getNm_vladm());
            ps.setInt(4, a.getDt_deposito());
            ps.setString(5, Utilidade.formatoData.format(a.getDt_contratovenc().getTime()));
            ps.setInt(6, a.getImovel().getCd_imovel());
            ps.setInt(7, a.getPresserv().getCd_presserv());
            ps.setInt(8, a.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Aluguel", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao inserir:\n" +
                    ex.getMessage(), "Aluguel", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void alterar(Object o) {
        Aluguel a = (Aluguel) o;
        try{
            sql = "UPDATE aluguel " +
                  "   SET nm_contrato = ?, " +
                  "       nm_vlaluguel = ?, " +
                  "       nm_vladm = ?, " +
                  "       dt_deposito = ?, " +
                  "       dt_contratovenc = ?, " +
                  "       cd_imovel = ?, cd_presserv = ?" +
                  " WHERE cd_aluguel = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, a.getNm_contrato());
            ps.setBigDecimal(2, a.getNm_vlaluguel());
            ps.setBigDecimal(3, a.getNm_vladm());
            ps.setInt(4, a.getDt_deposito());
            ps.setString(5, Utilidade.formatoData.format(a.getDt_contratovenc().getTime()));
            ps.setInt(6, a.getImovel().getCd_imovel());
            ps.setInt(7, a.getPresserv().getCd_presserv());
            ps.setInt(8, a.getCd_aluguel());
            ps.setInt(9, a.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado.", "Aluguel", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Aluguel", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void excluir(Object o) {
        Aluguel a = (Aluguel) o;
        try{
            sql = "DELETE FROM aluguel " +
                  " WHERE cd_aluguel = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, a.getCd_aluguel());
            ps.setInt(2, a.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Aluguel", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Aluguel", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public ArrayList getLista() {
        ArrayList aluguel = new ArrayList();
        try{
            sql = "SELECT cd_aluguel, nm_contrato, nm_vlaluguel, nm_vladm, dt_deposito, to_char(dt_contratovenc,'dd/MM/yyyy'), cd_imovel, cd_presserv, cd_usuario" +
                  "  FROM aluguel " +
                  " WHERE cd_usuario = ?" +
                  " ORDER BY nm_contrato";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Aluguel a = new Aluguel(
                        rs.getInt("cd_aluguel"),
                        rs.getString("nm_contrato"),
                        rs.getBigDecimal("nm_vlaluguel"),
                        rs.getBigDecimal("nm_vladm"),
                        rs.getInt("dt_deposito"),
                        util.recebeData(rs.getString("to_char(dt_contratovenc,'dd/MM/yyyy')")),
                        (Imovel)imovelr.getById(rs.getInt("cd_imovel")),
                        (PrestadorServico)presservr.getById(rs.getInt("cd_presserv")),
                        rs.getInt("cd_usuario"));
                aluguel.add(a);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de alugueis:\n" +
                    ex.getMessage(), "Aluguel", JOptionPane.ERROR_MESSAGE);
        }
        return aluguel;
    }

    @Override
    public Object getById(int id) {
        Aluguel a = null;
        try{
            sql = "SELECT cd_aluguel, nm_contrato, nm_vlaluguel, nm_vladm, dt_deposito, to_char(dt_contratovenc,'dd/MM/yyyy'), cd_imovel, cd_presserv, cd_usuario" +
                  "  FROM aluguel " +
                  " WHERE cd_aluguel = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                a = new Aluguel(
                        rs.getInt("cd_aluguel"),
                        rs.getString("nm_contrato"),
                        rs.getBigDecimal("nm_vlaluguel"),
                        rs.getBigDecimal("nm_vladm"),
                        rs.getInt("dt_deposito"),
                        util.recebeData(rs.getString("to_char(dt_contratovenc,'dd/MM/yyyy')")),
                        (Imovel)imovelr.getById(rs.getInt("cd_imovel")),
                        (PrestadorServico)presservr.getById(rs.getInt("cd_presserv")),
                        rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em aluguel:\n" +
                    ex.getMessage(), "Aluguel", JOptionPane.ERROR_MESSAGE);
        }
        return a;
    }
    
}
