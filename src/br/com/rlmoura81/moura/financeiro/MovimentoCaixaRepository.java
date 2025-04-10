package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalcadastro.Categoria;
import br.com.rlmoura81.moura.principalcadastro.CategoriaRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MovimentoCaixaRepository implements IPadraoRepository{

    String sql = "";
    
    RendaRepository rendar = new RendaRepository();
    
    DespesaRepository despesar = new DespesaRepository();
    
    CategoriaRepository categoriar = new CategoriaRepository();
    
    TipoTransacaoRepository tptransr = new TipoTransacaoRepository();
    
    ContaRepository contar = new ContaRepository();
    
    Utilidade util = new Utilidade();

    @Override
    public void inserir(Object o) {
        MovimentoCaixa movcx = (MovimentoCaixa) o;
        try{
            sql = "INSERT INTO movcx (cd_movcx, dt_transacao, ds_descricao, vl_credito, vl_debito, nm_documento, cd_renda, cd_despesa, cd_categoria, cd_tptrans, cd_conta, cd_usuario)" +
                  "     VALUES (sq_movcx.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, Utilidade.formatoData.format(movcx.getDt_transacao().getTime()));
            ps.setString(2, movcx.getDs_descricao());
            ps.setBigDecimal(3, movcx.getVl_credito());
            ps.setBigDecimal(4, movcx.getVl_debito());
            ps.setString(5, movcx.getNm_documento());
            ps.setInt(6, movcx.getRenda().getCd_renda());
            ps.setInt(7, movcx.getDespesa().getCd_despesa());
            ps.setInt(8, movcx.getCategoria().getCd_Categoria());
            ps.setInt(9, movcx.getTipotransacao().getCd_tptrans());
            ps.setInt(10, movcx.getConta().getCd_conta());
            ps.setInt(11, movcx.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Movimento Caixa", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Movimento Caixa", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void alterar(Object o) {
        MovimentoCaixa movcx = (MovimentoCaixa) o;
        try{
            sql = "UPDATE movcx " +
                  "   SET dt_transacao = ?," +
                  "       ds_descricao = ?," +
                  "       vl_credito = ?," +
                  "       vl_debito = ?," +
                  "       nm_documento = ?," +
                  "       cd_categoria = ?," +
                  "       cd_tptrans = ?" +
                  " WHERE cd_movcx = ?" +
                  "   AND cd_conta = ?" +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, Utilidade.formatoData.format(movcx.getDt_transacao().getTime()));
            ps.setString(2, movcx.getDs_descricao());
            ps.setBigDecimal(3, movcx.getVl_credito());
            ps.setBigDecimal(4, movcx.getVl_debito());
            ps.setString(5, movcx.getNm_documento());
            ps.setInt(6, movcx.getCategoria().getCd_Categoria());
            ps.setInt(7, movcx.getTipotransacao().getCd_tptrans());
            ps.setInt(8, movcx.getCd_movcx());
            ps.setInt(9, movcx.getConta().getCd_conta());
            ps.setInt(10, movcx.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado.", "Movimento Caixa", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Movimento Caixa", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void excluir(Object o) {
        MovimentoCaixa movcx = (MovimentoCaixa) o;
        try{
            sql = "DELETE FROM movcx " +
                  " WHERE cd_movcx = ? " +
                  "   AND cd_conta =  ?" +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, movcx.getCd_movcx());
            ps.setInt(2, movcx.getConta().getCd_conta());
            ps.setInt(3, movcx.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Movimento Caixa", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Movimento Caixa", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public ArrayList getLista() {
        ArrayList movcx = new ArrayList();
        try{
            sql = "SELECT cd_movcx, to_char(dt_transacao,'dd/MM/yyyy'), ds_descricao, nvl(vl_credito,'0,00'), nvl(vl_debito,'0,00'), nm_documento, cd_renda, cd_despesa, cd_categoria, cd_tptrans, cd_conta, cd_usuario" +
                  "  FROM movcx" +
                  " WHERE cd_usuario = ?" +
                  " ORDER BY dt_transacao";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                MovimentoCaixa mc = new MovimentoCaixa(
                    rs.getInt("cd_movcx"),
                    util.recebeData(rs.getString("to_char(dt_transacao,'dd/MM/yyyy')")),
                    rs.getString("ds_descricao"),
                    rs.getBigDecimal("nvl(vl_credito,'0,00')"),
                    rs.getBigDecimal("nvl(vl_debito,'0,00')"),
                    rs.getString("nm_documento"),
                    (Renda)rendar.getById(rs.getInt("cd_renda")),
                    (Despesa)despesar.getById(rs.getInt("cd_despesa")),
                    (Categoria)categoriar.getById(rs.getInt("cd_categoria")),
                    (TipoTransacao)tptransr.getById(rs.getInt("cd_tptrans")),
                    (Conta)contar.getById(rs.getInt("cd_conta")),
                    rs.getInt("cd_usuario"));
                movcx.add(mc);
            }
            ps.close();            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Movimento Caixa:\n" +
                    ex.getMessage(), "Movimento Caixa", JOptionPane.ERROR_MESSAGE);
        }
        return movcx;
    }
    
    public ArrayList getLista(int cd_conta) {
        ArrayList movcx = new ArrayList();
        try{
            sql = "SELECT cd_movcx, to_char(dt_transacao,'dd/MM/yyyy'), ds_descricao, nvl(vl_credito,'0,00'), nvl(vl_debito,'0,00'), nm_documento, cd_renda, cd_despesa, cd_categoria, cd_tptrans, cd_conta, cd_usuario" +
                  "  FROM movcx" +
                  " WHERE cd_conta = ?" +
                  "   AND cd_usuario = ?" +
                  " ORDER BY dt_transacao";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_conta);
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                MovimentoCaixa mc = new MovimentoCaixa(
                    rs.getInt("cd_movcx"),
                    util.recebeData(rs.getString("to_char(dt_transacao,'dd/MM/yyyy')")),
                    rs.getString("ds_descricao"),
                    rs.getBigDecimal("nvl(vl_credito,'0,00')"),
                    rs.getBigDecimal("nvl(vl_debito,'0,00')"),
                    rs.getString("nm_documento"),
                    (Renda)rendar.getById(rs.getInt("cd_renda")),
                    (Despesa)despesar.getById(rs.getInt("cd_despesa")),
                    (Categoria)categoriar.getById(rs.getInt("cd_categoria")),
                    (TipoTransacao)tptransr.getById(rs.getInt("cd_tptrans")),
                    (Conta)contar.getById(rs.getInt("cd_conta")),
                    rs.getInt("cd_usuario"));
                movcx.add(mc);
            }
            ps.close();            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Movimento Caixa da conta:\n" +
                    ex.getMessage(), "Movimento Caixa", JOptionPane.ERROR_MESSAGE);
        }
        return movcx;
    }
    
    public ArrayList getLista(int cd_conta, String dt_inicio, String dt_final) {
        ArrayList movcx = new ArrayList();
        try{
            sql = "SELECT cd_movcx, to_char(dt_transacao,'dd/MM/yyyy'), ds_descricao, nvl(vl_credito,'0,00'), nvl(vl_debito,'0,00'), nm_documento, cd_renda, cd_despesa, cd_categoria, cd_tptrans, cd_conta, cd_usuario" +
                  "  FROM movcx" +
                  " WHERE cd_conta = ?" +
                  "   AND dt_transacao BETWEEN ? AND ?" +
                  "   AND cd_usuario = ?" +
                  " ORDER BY dt_transacao";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_conta);
            ps.setString(2, dt_inicio);
            ps.setString(3, dt_final);
            ps.setInt(4, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                MovimentoCaixa mc = new MovimentoCaixa(
                    rs.getInt("cd_movcx"),
                    util.recebeData(rs.getString("to_char(dt_transacao,'dd/MM/yyyy')")),
                    rs.getString("ds_descricao"),
                    rs.getBigDecimal("nvl(vl_credito,'0,00')"),
                    rs.getBigDecimal("nvl(vl_debito,'0,00')"),
                    rs.getString("nm_documento"),
                    (Renda)rendar.getById(rs.getInt("cd_renda")),
                    (Despesa)despesar.getById(rs.getInt("cd_despesa")),
                    (Categoria)categoriar.getById(rs.getInt("cd_categoria")),
                    (TipoTransacao)tptransr.getById(rs.getInt("cd_tptrans")),
                    (Conta)contar.getById(rs.getInt("cd_conta")),
                    rs.getInt("cd_usuario"));
                movcx.add(mc);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Movimento Caixa da pesquisa:\n" +
                    ex.getMessage(), "Movimento Caixa", JOptionPane.ERROR_MESSAGE);
        }
        return movcx;
    }    
    
    public ArrayList getListaMes(int cd_conta) {
        ArrayList movcx = new ArrayList();
        try{
            sql = "SELECT cd_movcx, to_char(dt_transacao,'dd/MM/yyyy'), ds_descricao, nvl(vl_credito,'0,00'), nvl(vl_debito,'0,00'), nm_documento, cd_renda, cd_despesa, cd_categoria, cd_tptrans, cd_conta, cd_usuario" +
                  "  FROM movcx" +
                  " WHERE cd_conta = ?" +
                  "   AND dt_transacao BETWEEN (SELECT trunc(SYSDATE,'MM') FROM DUAL) AND (SELECT trunc(LAST_DAY(SYSDATE)) FROM DUAL)" +
                  "   AND cd_usuario = ?" +
                  " ORDER BY dt_transacao";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_conta);
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                MovimentoCaixa mc = new MovimentoCaixa(
                    rs.getInt("cd_movcx"),
                    util.recebeData(rs.getString("to_char(dt_transacao,'dd/MM/yyyy')")),
                    rs.getString("ds_descricao"),
                    rs.getBigDecimal("nvl(vl_credito,'0,00')"),
                    rs.getBigDecimal("nvl(vl_debito,'0,00')"),
                    rs.getString("nm_documento"),
                    (Renda)rendar.getById(rs.getInt("cd_renda")),
                    (Despesa)despesar.getById(rs.getInt("cd_despesa")),
                    (Categoria)categoriar.getById(rs.getInt("cd_categoria")),
                    (TipoTransacao)tptransr.getById(rs.getInt("cd_tptrans")),
                    (Conta)contar.getById(rs.getInt("cd_conta")),
                    rs.getInt("cd_usuario"));
                movcx.add(mc);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Movimento Caixa do mês:\n" +
                    ex.getMessage(), "Movimento Caixa", JOptionPane.ERROR_MESSAGE);
        }
        return movcx;
    }   
    
    @Override
    public Object getById(int id) {
        MovimentoCaixa movcx = null;
        try{
            sql = "SELECT cd_movcx, to_char(dt_transacao,'dd/MM/yyyy'), ds_descricao, nvl(vl_credito,'0,00'), nvl(vl_debito,'0,00'), nm_documento, cd_renda, cd_despesa, cd_categoria, cd_tptrans, cd_conta, cd_usuario" +
                  "  FROM movcx" +
                  " WHERE cd_movcx = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                movcx = new MovimentoCaixa(
                    rs.getInt("cd_movcx"),
                    util.recebeData(rs.getString("to_char(dt_transacao,'dd/MM/yyyy')")),
                    rs.getString("ds_descricao"),
                    rs.getBigDecimal("nvl(vl_credito,'0,00')"),
                    rs.getBigDecimal("nvl(vl_debito,'0,00')"),
                    rs.getString("nm_documento"),
                    (Renda)rendar.getById(rs.getInt("cd_renda")),
                    (Despesa)despesar.getById(rs.getInt("cd_despesa")),
                    (Categoria)categoriar.getById(rs.getInt("cd_categoria")),
                    (TipoTransacao)tptransr.getById(rs.getInt("cd_tptrans")),
                    (Conta)contar.getById(rs.getInt("cd_conta")),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em Movimento Caixa:\n" +
                    ex.getMessage(), "Movimento Caixa", JOptionPane.ERROR_MESSAGE);
        }
        return movcx;
    } 
    
    public Object getSaldoMesAnterior(int id) {
        MovimentoCaixa movcx = null;
        try{
            sql = "SELECT SUM(vl_credito), SUM(vl_debito), SUM(vl_credito)-SUM(vl_debito)" +
                  "  FROM movcx " +
                  " WHERE dt_transacao BETWEEN (SELECT add_months(trunc(sysdate,'mm'),-1) FROM dual) AND (SELECT last_day(add_months(trunc(sysdate,'mm'),-1)) FROM dual)\n" +
                  "   AND cd_conta = ?" + 
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                movcx = new MovimentoCaixa(
                    rs.getBigDecimal("SUM(vl_credito)"),
                    rs.getBigDecimal("SUM(vl_debito)"),
                    rs.getBigDecimal("SUM(vl_credito)-SUM(vl_debito)"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getSaldoMesAnterior em Movimento Caixa:\n" +
                    ex.getMessage(), "Movimento Caixa", JOptionPane.ERROR_MESSAGE);
        }
        return movcx;
    }     
    
//MOVIMENTO CAIXA LANCAMENTO    
    public void inserirLanc(Object o) {
        MovimentoCaixa movcx = (MovimentoCaixa) o;
        try{
            sql = "INSERT INTO movcxl (cd_movcxl, dt_transacao, ds_descricao, vl_credito, vl_debito, nm_documento, cd_renda, cd_despesa, cd_categoria, cd_tptrans, cd_conta, cd_usuario)" +
                  "     VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, movcx.getCd_movcx());
            ps.setString(2, Utilidade.formatoData.format(movcx.getDt_transacao().getTime()));
            ps.setString(3, movcx.getDs_descricao());
            ps.setBigDecimal(4, movcx.getVl_credito());
            ps.setBigDecimal(5, movcx.getVl_debito());
            ps.setString(6, movcx.getNm_documento());
            ps.setInt(7, movcx.getRenda().getCd_renda());
            ps.setInt(8, movcx.getDespesa().getCd_despesa());
            ps.setInt(9, movcx.getCategoria().getCd_Categoria());
            ps.setInt(10, movcx.getTipotransacao().getCd_tptrans());
            ps.setInt(11, movcx.getConta().getCd_conta());
            ps.setInt(12, movcx.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Movimento Caixa Lançamento Futuro", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Movimento Caixa Lançamento Futuro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void alterarLanc(Object o) {
        MovimentoCaixa movcx = (MovimentoCaixa) o;
        try{
            sql = "UPDATE movcxl " +
                  "   SET dt_transacao = ?," +
                  "       ds_descricao = ?," +
                  "       vl_credito = ?," +
                  "       vl_debito = ?," +
                  "       nm_documento = ?," +
                  "       cd_categoria = ?," +
                  "       cd_tptrans = ?" +
                  " WHERE cd_movcxl = ?" +
                  "   AND cd_conta = ?" +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, Utilidade.formatoData.format(movcx.getDt_transacao().getTime()));
            ps.setString(2, movcx.getDs_descricao());
            ps.setBigDecimal(3, movcx.getVl_credito());
            ps.setBigDecimal(4, movcx.getVl_debito());
            ps.setString(5, movcx.getNm_documento());
            ps.setInt(6, movcx.getCategoria().getCd_Categoria());
            ps.setInt(7, movcx.getTipotransacao().getCd_tptrans());
            ps.setInt(8, movcx.getCd_movcx());
            ps.setInt(9, movcx.getConta().getCd_conta());
            ps.setInt(10, movcx.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado.", "Movimento Caixa Lançamento Futuro", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Movimento Caixa Lançamento Futuro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void excluirLanc(Object o) {
        MovimentoCaixa movcx = (MovimentoCaixa) o;
        try{
            sql = "DELETE FROM movcxl " +
                  " WHERE cd_movcxl = ? " +
                  "   AND cd_conta = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, movcx.getCd_movcx());
            ps.setInt(2, movcx.getConta().getCd_conta());
            ps.setInt(3, movcx.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Movimento Caixa Lançamento Futuro", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Movimento Caixa Lançamento Futuro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList getListaContaLanc(int cd_conta) {
        ArrayList movcxl = new ArrayList();
        try{
            sql = "SELECT cd_movcxl, to_char(dt_transacao,'dd/MM/yyyy'), ds_descricao, nvl(vl_credito,'0,00'), nvl(vl_debito,'0,00'), nm_documento, cd_renda, cd_despesa, cd_categoria, cd_tptrans, cd_conta, cd_usuario" +
                  "  FROM movcxl" +
                  " WHERE cd_conta = ?" +
                  "   AND cd_usuario = ?" +
                  " ORDER BY dt_transacao";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_conta);
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                MovimentoCaixa mc = new MovimentoCaixa(
                    rs.getInt("cd_movcxl"),
                    util.recebeData(rs.getString("to_char(dt_transacao,'dd/MM/yyyy')")),
                    rs.getString("ds_descricao"),
                    rs.getBigDecimal("nvl(vl_credito,'0,00')"),
                    rs.getBigDecimal("nvl(vl_debito,'0,00')"),
                    rs.getString("nm_documento"),
                    (Renda)rendar.getById(rs.getInt("cd_renda")),
                    (Despesa)despesar.getById(rs.getInt("cd_despesa")),
                    (Categoria)categoriar.getById(rs.getInt("cd_categoria")),
                    (TipoTransacao)tptransr.getById(rs.getInt("cd_tptrans")),
                    (Conta)contar.getById(rs.getInt("cd_conta")),
                    rs.getInt("cd_usuario"));
                movcxl.add(mc);
            }
            ps.close();            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Movimento Caixa Lançamento Futuro:\n" +
                    ex.getMessage());
        }
        return movcxl;
    } 
    
    public Object getByIdLanc(int id) {
        MovimentoCaixa movcxl = null;
        try{
            sql = "SELECT cd_movcxl, to_char(dt_transacao,'dd/MM/yyyy'), ds_descricao, nvl(vl_credito,'0,00'), nvl(vl_debito,'0,00'), nm_documento, cd_renda, cd_despesa, cd_categoria, cd_tptrans, cd_conta, cd_usuario" +
                  "  FROM movcxl" +
                  " WHERE cd_movcxl = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                movcxl = new MovimentoCaixa(
                    rs.getInt("cd_movcxl"),
                    util.recebeData(rs.getString("to_char(dt_transacao,'dd/MM/yyyy')")),
                    rs.getString("ds_descricao"),
                    rs.getBigDecimal("nvl(vl_credito,'0,00')"),
                    rs.getBigDecimal("nvl(vl_debito,'0,00')"),
                    rs.getString("nm_documento"),
                    (Renda)rendar.getById(rs.getInt("cd_renda")),
                    (Despesa)despesar.getById(rs.getInt("cd_despesa")),
                    (Categoria)categoriar.getById(rs.getInt("cd_categoria")),
                    (TipoTransacao)tptransr.getById(rs.getInt("cd_tptrans")),
                    (Conta)contar.getById(rs.getInt("cd_conta")),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em Movimento Caixa Lançamento Futuro:\n" +
                    ex.getMessage());
        }
        return movcxl;
    }
    
    public Object ultimoRegistroLanc(int cd_usuario) {
        MovimentoCaixa movcxl = null;
        try{
            sql = "SELECT cd_movcxl, to_char(dt_transacao,'dd/MM/yyyy'), ds_descricao, nvl(vl_credito,'0,00'), nvl(vl_debito,'0,00'), nm_documento, cd_renda, cd_despesa, cd_categoria, cd_tptrans, cd_conta, cd_usuario" +
                  "  FROM movcxl" +
                  " WHERE cd_usuario = ?" +
                  " ORDER BY cd_movcxl DESC";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_usuario);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                movcxl = new MovimentoCaixa(
                    rs.getInt("cd_movcxl"),
                    util.recebeData(rs.getString("to_char(dt_transacao,'dd/MM/yyyy')")),
                    rs.getString("ds_descricao"),
                    rs.getBigDecimal("nvl(vl_credito,'0,00')"),
                    rs.getBigDecimal("nvl(vl_debito,'0,00')"),
                    rs.getString("nm_documento"),
                    (Renda)rendar.getById(rs.getInt("cd_renda")),
                    (Despesa)despesar.getById(rs.getInt("cd_despesa")),
                    (Categoria)categoriar.getById(rs.getInt("cd_categoria")),
                    (TipoTransacao)tptransr.getById(rs.getInt("cd_tptrans")),
                    (Conta)contar.getById(rs.getInt("cd_conta")),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de ultimoRegistro em Movimento Caixa Lançamento Futuro:\n" +
                    ex.getMessage());
        }
        return movcxl;
    }
}