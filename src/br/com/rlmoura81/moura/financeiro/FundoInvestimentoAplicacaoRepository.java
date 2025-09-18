package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FundoInvestimentoAplicacaoRepository implements IPadraoRepository{
    
    String sql = "";    
    FundoInvestimentoRepository fdinvestr = new FundoInvestimentoRepository();    
    ContaRepository contar = new ContaRepository();

    /**
     * <p><strong>EN:</strong> Inserts an investment fund application into the database table <code>fdinvestaplic</code>.</p>
     *
     * <p><strong>IT:</strong> Inserisce un'applicazione di fondo d'investimento nella tabella <code>fdinvestaplic</code>.</p>
     *
     * <p><strong>PT-BR:</strong> Insere uma aplicação de fundo de investimento na tabela <code>fdinvestaplic</code>.</p>
     *
     * @param fia EN: object to be inserted | IT: oggetto da inserire | PT-BR: objeto a ser inserido
     * @return EN: created record in the investment fund application table | IT: record creato nella tabella delle applicazioni di fondi | PT-BR: registro criado na tabela de aplicações de fundos
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco
     * @since 1.0.0
     */
    @Override
    public void inserir(Object o) {
        FundoInvestimentoAplicacao fia = (FundoInvestimentoAplicacao) o;
        try{
            sql = "INSERT INTO fdinvestaplic (cd_fdinvestaplic, vl_saldo, cd_fdinvest, cd_conta, cd_usuario)" +
                  "     VALUES(sq_fdinvestaplic.nextval, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setBigDecimal(1, fia.getVl_saldo());
            ps.setInt(2, fia.getFdinvest().getCd_fdinvest());
            ps.setInt(3, fia.getConta().getCd_conta());
            ps.setInt(4, fia.getCd_usuario());
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao inserir Fundo Investimento Aplicacao:\n" +
                    ex.getMessage());
        }
    }

    @Override
    public void alterar(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * <p><strong>EN:</strong> Retrieves all investment fund applications for the logged-in user.</p>
     *
     * <p><strong>IT:</strong> Recupera tutte le applicazioni di fondi d'investimento per l'utente connesso.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera todas as aplicações de fundos de investimento do usuário logado.</p>
     *
     * @return EN: list of investment fund applications | IT: elenco delle applicazioni di fondi d'investimento | PT-BR: lista de aplicações de fundos de investimento
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco
     * @since 1.0.0
     */
    @Override
    public ArrayList getLista() {
        ArrayList fdinvap = new ArrayList();
        try{
            sql = "SELECT cd_fdinvestaplic, vl_saldo, cd_fdinvest, cd_conta, cd_usuario" +
                  "  FROM fdinvestaplic" + 
                  " WHERE cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                FundoInvestimentoAplicacao fia = new FundoInvestimentoAplicacao(
                        rs.getInt("cd_fdinvestaplic"),
                        rs.getBigDecimal("vl_saldo"),
                        (FundoInvestimento)fdinvestr.getById(rs.getInt("cd_fdinvest")),
                        (Conta)contar.getById(rs.getInt("cd_conta")),
                        rs.getInt("cd_usuario"));
                fdinvap.add(fia);
            }
            ps.close();
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Aplicações de Fundos de Investimentos:\n" +
                        ex.getMessage());
        }
        return fdinvap;
    }

    /**
     * <p><strong>EN:</strong> Retrieves investment fund applications filtered by account.</p>
     *
     * <p><strong>IT:</strong> Recupera applicazioni di fondi d'investimento filtrate per conto.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera aplicações de fundos de investimento filtradas por conta.</p>
     *
     * @param conta EN: account identifier to filter by | IT: identificatore del conto per il filtro | PT-BR: identificador da conta para filtragem
     * @return EN: list of applications for the specified account | IT: elenco delle applicazioni per il conto specificato | PT-BR: lista de aplicações para a conta especificada
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco
     * @since 1.0.0
     */
    public ArrayList getListaFundoInvest(int conta) {
        ArrayList fdinvap = new ArrayList();
        try{
            sql = "SELECT cd_fdinvestaplic, vl_saldo, cd_fdinvest, cd_conta, cd_usuario" +
                  "  FROM fdinvestaplic" + 
                  " WHERE cd_conta = ?" +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, conta);
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                FundoInvestimentoAplicacao fia = new FundoInvestimentoAplicacao(
                        rs.getInt("cd_fdinvestaplic"),
                        rs.getBigDecimal("vl_saldo"),
                        (FundoInvestimento)fdinvestr.getById(rs.getInt("cd_fdinvest")),
                        (Conta)contar.getById(rs.getInt("cd_conta")),
                        rs.getInt("cd_usuario"));
                fdinvap.add(fia);
            }
            ps.close();
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Aplicações de Fundos de Investimentos:\n" +
                        ex.getMessage());
        }
        return fdinvap;
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves an investment fund application by its identifier.</p>
     *
     * <p><strong>IT:</strong> Recupera un'applicazione di fondo d'investimento per identificatore.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera uma aplicação de fundo de investimento pelo identificador.</p>
     *
     * @param id EN: identifier of the application | IT: identificatore dell'applicazione | PT-BR: identificador da aplicação
     * @return EN: matching application record or <code>null</code> if none | IT: record corrispondente o <code>null</code> se assente | PT-BR: registro correspondente ou <code>null</code> se inexistente
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco
     * @since 1.0.0
     */
    @Override
    public Object getById(int id) {
        FundoInvestimentoAplicacao fdinvap = null;
        try{
            sql = "SELECT cd_fdinvestaplic, vl_saldo, cd_fdinvest, cd_conta, cd_usuario" +
                  "  FROM fdinvestaplic" + 
                  " WHERE cd_fdinvestaplic = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                fdinvap = new FundoInvestimentoAplicacao(
                        rs.getInt("cd_fdinvestaplic"),
                        rs.getBigDecimal("vl_saldo"),
                        (FundoInvestimento)fdinvestr.getById(rs.getInt("cd_fdinvest")),
                        (Conta)contar.getById(rs.getInt("cd_conta")),
                        rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro de getById em Aplicação de Fundo de Investimentos:\n" +
                        ex.getMessage());
        }
        return fdinvap;
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves the most recently created investment fund application.</p>
     *
     * <p><strong>IT:</strong> Recupera l'ultima applicazione di fondo d'investimento creata.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera a aplicação de fundo de investimento mais recente.</p>
     *
     * @return EN: last created application record or <code>null</code> | IT: ultimo record creato o <code>null</code> | PT-BR: último registro criado ou <code>null</code>
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco
     * @since 1.0.0
     */
    public Object ultimoRegistro() {
        FundoInvestimentoAplicacao fdinvap = null;
        try{
            sql = "SELECT cd_fdinvestaplic, vl_saldo, cd_fdinvest, cd_conta, cd_usuario" +
                  "  FROM fdinvestaplic" + 
                  " ORDER BY cd_fdinvestaplic DESC";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                fdinvap = new FundoInvestimentoAplicacao(
                        rs.getInt("cd_fdinvestaplic"),
                        rs.getBigDecimal("vl_saldo"),
                        (FundoInvestimento)fdinvestr.getById(rs.getInt("cd_fdinvest")),
                        (Conta)contar.getById(rs.getInt("cd_conta")),
                        rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro de getById em Aplicação de Fundo de Investimentos:\n" +
                        ex.getMessage());
        }
        return fdinvap;
    }
    
    /**
     * <p><strong>EN:</strong> Updates the balance (<code>vl_saldo</code>) of an existing investment fund application.</p>
     *
     * <p><strong>IT:</strong> Aggiorna il saldo (<code>vl_saldo</code>) di un'applicazione di fondo d'investimento esistente.</p>
     *
     * <p><strong>PT-BR:</strong> Atualiza o saldo (<code>vl_saldo</code>) de uma aplicação de fundo de investimento existente.</p>
     *
     * @param fia EN: object containing the new balance and identifiers | IT: oggetto contenente il nuovo saldo e gli identificatori | PT-BR: objeto contendo o novo saldo e identificadores
     * @return EN: updated record with the new balance | IT: record aggiornato con il nuovo saldo | PT-BR: registro atualizado com o novo saldo
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco
     * @since 1.0.0
     */
    public void atualizaSaldo(Object o){
        FundoInvestimentoAplicacao fia = (FundoInvestimentoAplicacao) o;
        try{
            sql = "UPDATE fdinvestaplic " +
                  "   SET vl_saldo = ?" +
                  " WHERE cd_fdinvestaplic = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setBigDecimal(1, fia.getVl_saldo());
            ps.setInt(2, fia.getCd_fdinvestaplic());
            ps.setInt(3, fia.getCd_usuario());
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar saldo:\n" +
                    ex.getMessage());
        }
    }
    
}
