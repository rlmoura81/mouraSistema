package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AtivoSaldoRepository implements IPadraoRepository{

    String sql = "";
    
    AtivoRepository ativor = new AtivoRepository();    
    
    @Override
    public void inserir(Object o) {
        AtivoSaldo asaldo = (AtivoSaldo) o;
        try{
            sql = "INSERT INTO ativosaldo (cd_ativo, nm_qtde, cd_usuario)" +
                  "     VALUES (?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, asaldo.getAtivo().getCd_ativo());
            ps.setInt(2, asaldo.getNm_qtde());
            ps.setInt(3, asaldo.getCd_usuario());
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao inserir:\n" +
                    ex.getMessage(), "Ativo Saldo", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void alterar(Object o) {
        AtivoSaldo asaldo = (AtivoSaldo) o;
        try{
            sql = "UPDATE ativosaldo " +
                  "   SET nm_qtde = ?" +
                  " WHERE cd_ativo = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, asaldo.getNm_qtde());
            ps.setInt(2, asaldo.getAtivo().getCd_ativo());
            ps.setInt(3, asaldo.getCd_usuario());
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Ativo Saldo", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void excluir(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList getLista() {
        ArrayList asaldo = new ArrayList();
        try{
            sql = "SELECT cd_ativo, nm_qtde, cd_usuario" +
                  "  FROM ativosaldo" +
                  " WHERE cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                AtivoSaldo as = new AtivoSaldo(
                        (Ativo)ativor.getById(rs.getInt("cd_ativo")),
                        rs.getInt("nm_qtde"),
                        rs.getInt("cd_usuario"));
                asaldo.add(as);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Ativos Saldo:\n" +
                    ex.getMessage(), "Ativo Saldo", JOptionPane.ERROR_MESSAGE);
        }
        return asaldo;
    }

    public ArrayList getLista(int cd_tpativo) {
        ArrayList asaldo = new ArrayList();
        try{
            sql = "SELECT ativosaldo.cd_ativo, nm_qtde, ativosaldo.cd_usuario" +
                  "  FROM ativosaldo, ativo" +
                  " WHERE ativosaldo.cd_ativo = ativo.cd_ativo" +
                  "   AND ativo.cd_tpativo = ?" +
                  "   AND ativosaldo.cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_tpativo);
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                AtivoSaldo as = new AtivoSaldo(
                        (Ativo)ativor.getById(rs.getInt("cd_ativo")),
                        rs.getInt("nm_qtde"),
                        rs.getInt("cd_usuario"));
                asaldo.add(as);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Ativos Saldo:\n" +
                    ex.getMessage(), "Ativo Saldo", JOptionPane.ERROR_MESSAGE);
        }
        return asaldo;
    }
            
    @Override
    public Object getById(int id) {
        AtivoSaldo asaldo = null;
        try{
            sql = "SELECT cd_ativo, nm_qtde, cd_usuario" +
                  "  FROM ativosaldo" +
                  " WHERE cd_ativo = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                asaldo = new AtivoSaldo(
                        (Ativo)ativor.getById(rs.getInt("cd_ativo")),
                        rs.getInt("nm_qtde"),
                        rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em Ativos Saldo:\n" +
                    ex.getMessage(), "Ativo Saldo", JOptionPane.ERROR_MESSAGE);
        }
        return asaldo;
    }    
}
