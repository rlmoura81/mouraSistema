package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FundoInvestimentoRepository implements IPadraoRepository{

    String sql = "";

    GrupoFundoRepository gpfundor = new GrupoFundoRepository();
    
    @Override
    public void inserir(Object o) {
        FundoInvestimento fi = (FundoInvestimento) o;
        try{
            sql = "INSERT INTO fdinvest (cd_fdinvest, ds_fdinvest, cd_gpfundo, cd_usuario)" +
                  "     VALUES (sq_fdinvest.nextval, ?, ?, ?)";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, fi.getDs_fdinvest());
            ps.setInt(2, fi.getGpfundo().getCd_gpfundo());
            ps.setInt(3, fi.getCd_usuario());
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao inserir:\n" +
                    ex.getMessage());
        }
    }

    @Override
    public void alterar(Object o) {
        FundoInvestimento fi = (FundoInvestimento) o;
        try{
            sql = "UPDATE fdinvest " +
                  "   SET ds_fdinvest = ?, cd_gpfundo = ?, cd_usuario = ?" +
                  " WHERE cd_fdinvest = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, fi.getDs_fdinvest());
            ps.setInt(2, fi.getGpfundo().getCd_gpfundo());
            ps.setInt(3, fi.getCd_usuario());
            ps.setInt(4, fi.getCd_fdinvest());
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" + 
                    ex.getMessage());
        }
    }

    @Override
    public void excluir(Object o) {
        FundoInvestimento fi = (FundoInvestimento) o ;
        try{
            sql = "DELETE FROM fdinvest " + 
                  " WHERE cd_fdinvest = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, fi.getCd_fdinvest());
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage());
        }
    }

    @Override
    public ArrayList getLista() {
        ArrayList fdinvest = new ArrayList();
        try{
            sql = "SELECT cd_fdinvest, ds_fdinvest, cd_gpfundo, cd_usuario" + 
                  "  FROM fdinvest";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                FundoInvestimento fi = new FundoInvestimento(
                        rs.getInt("cd_fdinvest"),
                        rs.getString("ds_fdinvest"),
                        (GrupoFundo)gpfundor.getById(rs.getInt("cd_gpfundo")),
                        rs.getInt("cd_usuario"));
                fdinvest.add(fi);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de fundos de investimentos." +
                    ex.getMessage());
        }
        return fdinvest;
    }
    
    public ArrayList getListaFundoInvestAplic(int cd_conta) {
        ArrayList fdinvest = new ArrayList();
        try{
            sql = "SELECT cd_fdinvest, ds_fdinvest, cd_gpfundo, cd_usuario" + 
                  "  FROM fdinvest" +
                  " WHERE cd_fdinvest NOT IN (SELECT cd_fdinvest " +
                  "                             FROM fdinvestaplic " +
                  "                            WHERE cd_conta = ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_conta);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                FundoInvestimento fi = new FundoInvestimento(
                        rs.getInt("cd_fdinvest"),
                        rs.getString("ds_fdinvest"),
                        (GrupoFundo)gpfundor.getById(rs.getInt("cd_gpfundo")),
                        rs.getInt("cd_usuario"));
                fdinvest.add(fi);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de fundos de investimentos." +
                    ex.getMessage());
        }
        return fdinvest;
    }
    
    public ArrayList getListaFundoInvest(int cd_fdinvest) {
        ArrayList fdinvest = new ArrayList();
        try{
            sql = "SELECT cd_fdinvest, ds_fdinvest, cd_gpfundo, cd_usuario" + 
                  "  FROM fdinvest" +
                  " WHERE cd_fdinvest = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_fdinvest);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                FundoInvestimento fi = new FundoInvestimento(
                        rs.getInt("cd_fdinvest"),
                        rs.getString("ds_fdinvest"),
                        (GrupoFundo)gpfundor.getById(rs.getInt("cd_gpfundo")),
                        rs.getInt("cd_usuario"));
                fdinvest.add(fi);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de fundos de investimentos." +
                    ex.getMessage());
        }
        return fdinvest;
    }    
    
    @Override
    public Object getById(int id) {
        FundoInvestimento fdinvest = null;
        try{
            sql = "SELECT cd_fdinvest, ds_fdinvest, cd_gpfundo, cd_usuario" + 
                  "  FROM fdinvest" +
                  " WHERE cd_fdinvest = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                fdinvest = new FundoInvestimento(
                        rs.getInt("cd_fdinvest"),
                        rs.getString("ds_fdinvest"),
                        (GrupoFundo)gpfundor.getById(rs.getInt("cd_gpfundo")),
                        rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em fundos de investimentos." +
                    ex.getMessage());
        }
        return fdinvest;
    }
}
