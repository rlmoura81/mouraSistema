package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AtivoRepository implements IPadraoRepository{

    String sql = "";
    
    TipoAtivoRepository tpativor = new TipoAtivoRepository();
        
    @Override
    public void inserir(Object o) {
        Ativo ativo = (Ativo) o;        
        try{
            sql = "INSERT INTO ativo (cd_ativo, ds_ativo, ds_sgativo, nm_cnpj, cd_tpativo, cd_usuario)" +
                  "     VALUES (sq_ativo.nextval, ?, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, ativo.getDs_ativo());
            ps.setString(2, ativo.getDs_sgativo());
            ps.setString(3, ativo.getNm_cnpj());
            ps.setInt(4, ativo.getTpativo().getCd_tpativo());
            ps.setInt(5, ativo.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Ativo.", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Ativo", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void alterar(Object o) {
        Ativo ativo = (Ativo) o;        
        try{
            sql = "UPDATE ativo " +
                  "   SET ds_ativo = ?, " +
                  "       ds_sgativo = ?, " +
                  "       nm_cnpj = ?, " +
                  "       cd_tpativo = ?, " +
                  "       cd_usuario = ? " +
                  " WHERE cd_ativo = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, ativo.getDs_ativo());
            ps.setString(2, ativo.getDs_sgativo());
            ps.setString(3, ativo.getNm_cnpj());
            ps.setInt(4, ativo.getTpativo().getCd_tpativo());
            ps.setInt(5, ativo.getCd_usuario());
            ps.setInt(6, ativo.getCd_ativo());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado.", "Ativo", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Ativo", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void excluir(Object o) {
        Ativo ativo = (Ativo) o;        
        try{
            sql = "DELETE FROM ativo " +
                  " WHERE cd_ativo = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, ativo.getCd_ativo());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Ativo", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Ativo", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public ArrayList getLista() {
        ArrayList ativo = new ArrayList();
        try{
            sql = "SELECT cd_ativo, ds_ativo, ds_sgativo, nm_cnpj, cd_tpativo, cd_usuario" +
                  "  FROM ativo" +
                  " ORDER BY ds_sgativo";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Ativo atv = new Ativo(
                    rs.getInt("cd_ativo"),
                    rs.getString("ds_ativo"),
                    rs.getString("ds_sgativo"),
                    rs.getString("nm_cnpj"),
                    (TipoAtivo)tpativor.getById(rs.getInt("cd_tpativo")),
                    rs.getInt("cd_usuario"));
                ativo.add(atv);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de ativos:\n" +
                    ex.getMessage(), "Ativo", JOptionPane.ERROR_MESSAGE);
        }
        return ativo;
    }

    public ArrayList getListaAcao() {
        ArrayList ativo = new ArrayList();
        try{
            sql = "SELECT cd_ativo, ds_ativo, ds_sgativo, nm_cnpj, cd_tpativo, cd_usuario" +
                  "  FROM ativo" +
                  " WHERE cd_tpativo = 1" +
                  " ORDER BY ds_sgativo";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Ativo atv = new Ativo(
                    rs.getInt("cd_ativo"),
                    rs.getString("ds_ativo"),
                    rs.getString("ds_sgativo"),
                    rs.getString("nm_cnpj"),
                    (TipoAtivo)tpativor.getById(rs.getInt("cd_tpativo")),
                    rs.getInt("cd_usuario"));
                ativo.add(atv);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de ativos de Ações:\n" +
                    ex.getMessage(), "Ativo", JOptionPane.ERROR_MESSAGE);
        }
        return ativo;
    }
    
    public ArrayList getListaAcaoProv(int cd_tpprovento) {
        ArrayList ativo = new ArrayList();
        try{
            sql = "SELECT DISTINCT ativo.cd_ativo, ds_ativo, ds_sgativo, nm_cnpj, cd_tpativo, ativo.cd_usuario" +
                  "  FROM ativo, acaoprov" +
                  "  HERE acaoprov.cd_ativo = ativo.cd_ativo" +
                  "   AND acaoprov.cd_tpprovento = ?" +
                  " ORDER BY ds_sgativo";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_tpprovento);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Ativo atv = new Ativo(
                    rs.getInt("cd_ativo"),
                    rs.getString("ds_ativo"),
                    rs.getString("ds_sgativo"),
                    rs.getString("nm_cnpj"),
                    (TipoAtivo)tpativor.getById(rs.getInt("cd_tpativo")),
                    rs.getInt("cd_usuario"));
                ativo.add(atv);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de ativos de Ações:\n" +
                    ex.getMessage(), "Ativo", JOptionPane.ERROR_MESSAGE);
        }
        return ativo;
    }
    
    public ArrayList getListaAcaoSaldo() {
        ArrayList ativo = new ArrayList();
        try{
            sql = "SELECT ativo.cd_ativo, ds_ativo, ds_sgativo, nm_cnpj, cd_tpativo, ativo.cd_usuario" +
                  "  FROM ativo, ativosaldo" +
                  " WHERE cd_tpativo = 1" +
                  "   AND nm_qtde > 0" +
                  "   AND ativo.cd_ativo = ativosaldo.cd_ativo" +
                  " ORDER BY ds_sgativo";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Ativo atv = new Ativo(
                    rs.getInt("cd_ativo"),
                    rs.getString("ds_ativo"),
                    rs.getString("ds_sgativo"),
                    rs.getString("nm_cnpj"),
                    (TipoAtivo)tpativor.getById(rs.getInt("cd_tpativo")),
                    rs.getInt("cd_usuario"));
                ativo.add(atv);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de ativos de Ações:\n" +
                    ex.getMessage(), "Ativo", JOptionPane.ERROR_MESSAGE);
        }
        return ativo;
    }
    
    public ArrayList getListaAcaoSaldoTpProv(int num) {
        ArrayList ativo = new ArrayList();
        try{
            sql = "SELECT DISTINCT ativo.cd_ativo, ds_ativo, ds_sgativo, nm_cnpj, cd_tpativo, ativo.cd_usuario" +
                  "  FROM ativo, ativosaldo, acaoprov" +
                  " WHERE cd_tpativo = 1" +
                  "   AND nm_qtde > 0" +
                  "   AND ativo.cd_ativo = ativosaldo.cd_ativo" +
                  "   AND ativo.cd_ativo = acaoprov.cd_ativo" +
                  "   AND acaoprov.cd_tpprovento = ?" +
                  " ORDER BY ds_sgativo";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, num);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Ativo atv = new Ativo(
                    rs.getInt("cd_ativo"),
                    rs.getString("ds_ativo"),
                    rs.getString("ds_sgativo"),
                    rs.getString("nm_cnpj"),
                    (TipoAtivo)tpativor.getById(rs.getInt("cd_tpativo")),
                    rs.getInt("cd_usuario"));
                ativo.add(atv);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de ativos de Ações:\n" +
                    ex.getMessage(), "Ativo", JOptionPane.ERROR_MESSAGE);
        }
        return ativo;
    }    
    
    public ArrayList getListaFII() {
        ArrayList ativo = new ArrayList();
        try{
            sql = "SELECT cd_ativo, ds_ativo, ds_sgativo, nm_cnpj, cd_tpativo, cd_usuario" +
                  "  FROM ativo" +
                  " WHERE cd_tpativo = 2" +
                  " ORDER BY ds_sgativo";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Ativo atv = new Ativo(
                    rs.getInt("cd_ativo"),
                    rs.getString("ds_ativo"),
                    rs.getString("ds_sgativo"),
                    rs.getString("nm_cnpj"),
                    (TipoAtivo)tpativor.getById(rs.getInt("cd_tpativo")),
                    rs.getInt("cd_usuario"));
                ativo.add(atv);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de ativos de FII:\n" +
                    ex.getMessage(), "Ativo", JOptionPane.ERROR_MESSAGE);
        }
        return ativo;
    }
    
    public ArrayList getListaFIIProv(int num) {
        ArrayList ativo = new ArrayList();
        try{
            sql = "SELECT DISTINCT ativo.cd_ativo, ds_ativo, ds_sgativo, nm_cnpj, cd_tpativo, ativo.cd_usuario" +
                  "  FROM ativo, fdimprov" +
                  " WHERE fdimprov.cd_ativo = ativo.cd_ativo" +
                  "   AND fdimprov.cd_tpprovento = ?" +
                  " ORDER BY ds_sgativo";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, num);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Ativo atv = new Ativo(
                    rs.getInt("cd_ativo"),
                    rs.getString("ds_ativo"),
                    rs.getString("ds_sgativo"),
                    rs.getString("nm_cnpj"),
                    (TipoAtivo)tpativor.getById(rs.getInt("cd_tpativo")),
                    rs.getInt("cd_usuario"));
                ativo.add(atv);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de ativos de Ações:\n" +
                    ex.getMessage(), "Ativo", JOptionPane.ERROR_MESSAGE);
        }
        return ativo;
    }
    
    public ArrayList getListaFIISaldo() {
        ArrayList ativo = new ArrayList();
        try{
            sql = "SELECT ativo.cd_ativo, ds_ativo, ds_sgativo, nm_cnpj, cd_tpativo, ativo.cd_usuario" +
                  "  FROM ativo, ativosaldo" +
                  " WHERE cd_tpativo = 2" +
                  "   AND nm_qtde > 0" +
                  "   AND ativo.cd_ativo = ativosaldo.cd_ativo" +  
                  " ORDER BY ds_sgativo";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Ativo atv = new Ativo(
                    rs.getInt("cd_ativo"),
                    rs.getString("ds_ativo"),
                    rs.getString("ds_sgativo"),
                    rs.getString("nm_cnpj"),
                    (TipoAtivo)tpativor.getById(rs.getInt("cd_tpativo")),
                    rs.getInt("cd_usuario"));
                ativo.add(atv);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de ativos de FII:\n" +
                    ex.getMessage(), "Ativo", JOptionPane.ERROR_MESSAGE);
        }
        return ativo;
    }
    
    public ArrayList getListaFIISaldoTpProv(int num) {
        ArrayList ativo = new ArrayList();
        try{
            sql = "SELECT DISTINCT ativo.cd_ativo, ds_ativo, ds_sgativo, nm_cnpj, cd_tpativo, ativo.cd_usuario" +
                  "  FROM ativo, ativosaldo, fdimprov" +
                  " WHERE cd_tpativo = 2" +
                  "   AND nm_qtde > 0" +
                  "   AND ativo.cd_ativo = ativosaldo.cd_ativo" +
                  "   AND ativo.cd_ativo = fdimprov.cd_ativo" +
                  "   AND fdimprov.cd_tpprovento = ?" +
                  " ORDER BY ds_sgativo";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, num);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Ativo atv = new Ativo(
                    rs.getInt("cd_ativo"),
                    rs.getString("ds_ativo"),
                    rs.getString("ds_sgativo"),
                    rs.getString("nm_cnpj"),
                    (TipoAtivo)tpativor.getById(rs.getInt("cd_tpativo")),
                    rs.getInt("cd_usuario"));
                ativo.add(atv);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de ativos de FII:\n" +
                    ex.getMessage(), "Ativo", JOptionPane.ERROR_MESSAGE);
        }
        return ativo;
    }
    
    @Override
    public Object getById(int id) {
        Ativo ativo = null;
        try{
            sql = "SELECT cd_ativo, ds_ativo, ds_sgativo, nm_cnpj, cd_tpativo, cd_usuario" +
                  "  FROM ativo" +
                  " WHERE cd_ativo = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                ativo = new Ativo(rs.getInt("cd_ativo"),
                    rs.getString("ds_ativo"),
                    rs.getString("ds_sgativo"),
                    rs.getString("nm_cnpj"),
                    (TipoAtivo)tpativor.getById(rs.getInt("cd_tpativo")),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em ativos:\n" +
                    ex.getMessage(), "Ativo", JOptionPane.ERROR_MESSAGE);
        }
        return ativo;
    }
     
}
