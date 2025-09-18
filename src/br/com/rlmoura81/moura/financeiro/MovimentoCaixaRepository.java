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

    /**
     * <p><strong>EN:</strong> Inserts a cash movement record.</p>
     *
     * <p><strong>IT:</strong> Inserisce un record di movimento di cassa.</p>
     *
     * <p><strong>PT-BR:</strong> Insere um registro de movimento de caixa.</p>
     *
     * @param o EN: object (MovimentoCaixa) to be inserted | IT: oggetto (MovimentoCaixa) da inserire | PT-BR: objeto (MovimentoCaixa) a ser inserido
     * @return EN: none | IT: nessuno | PT-BR: nenhum
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco de dados
     * @since 1.0.0
     */
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

    /**
     * <p><strong>EN:</strong> Updates an existing cash movement record.</p>
     *
     * <p><strong>IT:</strong> Aggiorna un record esistente di movimento di cassa.</p>
     *
     * <p><strong>PT-BR:</strong> Atualiza um registro existente de movimento de caixa.</p>
     *
     * @param o EN: object (MovimentoCaixa) with updated fields | IT: oggetto (MovimentoCaixa) con campi aggiornati | PT-BR: objeto (MovimentoCaixa) com campos atualizados
     * @return EN: none | IT: nessuno | PT-BR: nenhum
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco de dados
     * @since 1.0.0
     */
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

    /**
     * <p><strong>EN:</strong> Deletes a cash movement record.</p>
     *
     * <p><strong>IT:</strong> Elimina un record di movimento di cassa.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui um registro de movimento de caixa.</p>
     *
     * @param o EN: object (MovimentoCaixa) identifying the record to delete | IT: oggetto (MovimentoCaixa) che identifica il record da eliminare | PT-BR: objeto (MovimentoCaixa) que identifica o registro a excluir
     * @return EN: none | IT: nessuno | PT-BR: nenhum
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco de dados
     * @since 1.0.0
     */
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

    /**
     * <p><strong>EN:</strong> Retrieves all cash movement records for the logged-in user.</p>
     *
     * <p><strong>IT:</strong> Recupera tutti i movimenti di cassa per l'utente connesso.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera todos os movimentos de caixa do usuário logado.</p>
     *
     * @return EN: list of MovimentoCaixa records | IT: elenco di record MovimentoCaixa | PT-BR: lista de registros MovimentoCaixa
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco de dados
     * @since 1.0.0
     */
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
 
    /**
     * <p><strong>EN:</strong> Retrieves cash movement records by account.</p>
     *
     * <p><strong>IT:</strong> Recupera i movimenti di cassa per conto.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera os movimentos de caixa por conta.</p>
     *
     * @param cd_conta EN: account ID | IT: ID conto | PT-BR: ID da conta
     * @return EN: list of MovimentoCaixa records for the account | IT: elenco dei record MovimentoCaixa per il conto | PT-BR: lista de registros MovimentoCaixa da conta
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco de dados
     * @since 1.0.0
     */
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
    
    /**
     * <p><strong>EN:</strong> Retrieves cash movement records by account within a date range.</p>
     *
     * <p><strong>IT:</strong> Recupera i movimenti di cassa per conto in un intervallo di date.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera movimentos de caixa por conta em um período.</p>
     *
     * @param cd_conta EN: account ID | IT: ID conto | PT-BR: ID da conta
     * @param dt_inicio EN: start date (dd/MM/yyyy) | IT: data di inizio (dd/MM/yyyy) | PT-BR: data inicial (dd/MM/yyyy)
     * @param dt_final EN: end date (dd/MM/yyyy) | IT: data di fine (dd/MM/yyyy) | PT-BR: data final (dd/MM/yyyy)
     * @return EN: filtered list of MovimentoCaixa records | IT: elenco filtrato di record MovimentoCaixa | PT-BR: lista filtrada de registros MovimentoCaixa
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco de dados
     * @since 1.0.0
     */
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
    
    /**
     * <p><strong>EN:</strong> Retrieves cash movement records for the current month for a given account.</p>
     *
     * <p><strong>IT:</strong> Recupera i movimenti di cassa del mese corrente per un dato conto.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera os movimentos de caixa do mês corrente para uma conta.</p>
     *
     * @param cd_conta EN: account ID | IT: ID conto | PT-BR: ID da conta
     * @return EN: list of current-month MovimentoCaixa records | IT: elenco dei record MovimentoCaixa del mese corrente | PT-BR: lista de registros MovimentoCaixa do mês corrente
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco de dados
     * @since 1.0.0
     */
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
    
    /**
     * <p><strong>EN:</strong> Retrieves a cash movement record by its ID.</p>
     *
     * <p><strong>IT:</strong> Recupera un movimento di cassa per ID.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera um movimento de caixa pelo seu ID.</p>
     *
     * @param id EN: cash movement ID | IT: ID del movimento di cassa | PT-BR: ID do movimento de caixa
     * @return EN: MovimentoCaixa record if found; otherwise null | IT: record MovimentoCaixa se trovato; altrimenti null | PT-BR: registro MovimentoCaixa se encontrado; caso contrário null
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco de dados
     * @since 1.0.0
     */
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
    
    /**
     * <p><strong>EN:</strong> Calculates previous month's totals (credit, debit, and net) for an account.</p>
     *
     * <p><strong>IT:</strong> Calcola i totali del mese precedente (credito, debito e netto) per un conto.</p>
     *
     * <p><strong>PT-BR:</strong> Calcula os totais do mês anterior (crédito, débito e líquido) de uma conta.</p>
     *
     * @param id EN: account ID | IT: ID conto | PT-BR: ID da conta
     * @return EN: MovimentoCaixa with summed credit, debit and net values | IT: MovimentoCaixa con somme di credito, debito e netto | PT-BR: MovimentoCaixa com somatórios de crédito, débito e líquido
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco de dados
     * @since 1.0.0
     */
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
    
    /**
     * <p><strong>EN:</strong> Inserts a scheduled (future) cash movement record.</p>
     *
     * <p><strong>IT:</strong> Inserisce un movimento di cassa pianificato (futuro).</p>
     *
     * <p><strong>PT-BR:</strong> Insere um lançamento de caixa programado (futuro).</p>
     *
     * @param o EN: object (MovimentoCaixa) to be scheduled | IT: oggetto (MovimentoCaixa) da pianificare | PT-BR: objeto (MovimentoCaixa) a ser programado
     * @return EN: none | IT: nessuno | PT-BR: nenhum
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco de dados
     * @since 1.0.0
     */   
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

    /**
     * <p><strong>EN:</strong> Updates a scheduled (future) cash movement record.</p>
     *
     * <p><strong>IT:</strong> Aggiorna un movimento di cassa pianificato (futuro).</p>
     *
     * <p><strong>PT-BR:</strong> Atualiza um lançamento de caixa programado (futuro).</p>
     *
     * @param o EN: object (MovimentoCaixa) with updated future entry data | IT: oggetto (MovimentoCaixa) con dati aggiornati della registrazione futura | PT-BR: objeto (MovimentoCaixa) com dados atualizados do lançamento futuro
     * @return EN: none | IT: nessuno | PT-BR: nenhum
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco de dados
     * @since 1.0.0
     */
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

    /**
     * <p><strong>EN:</strong> Deletes a scheduled (future) cash movement record.</p>
     *
     * <p><strong>IT:</strong> Elimina un movimento di cassa pianificato (futuro).</p>
     *
     * <p><strong>PT-BR:</strong> Exclui um lançamento de caixa programado (futuro).</p>
     *
     * @param o EN: object (MovimentoCaixa) identifying the scheduled entry to delete | IT: oggetto (MovimentoCaixa) che identifica la registrazione futura da eliminare | PT-BR: objeto (MovimentoCaixa) que identifica o lançamento futuro a excluir
     * @return EN: none | IT: nessuno | PT-BR: nenhum
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco de dados
     * @since 1.0.0
     */
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
    
    /**
     * <p><strong>EN:</strong> Retrieves scheduled cash movements by account for the logged-in user.</p>
     *
     * <p><strong>IT:</strong> Recupera i movimenti di cassa pianificati per conto per l'utente connesso.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera os lançamentos de caixa programados por conta do usuário logado.</p>
     *
     * @param cd_conta EN: account ID | IT: ID conto | PT-BR: ID da conta
     * @return EN: list of scheduled MovimentoCaixa records | IT: elenco di record MovimentoCaixa pianificati | PT-BR: lista de registros MovimentoCaixa programados
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco de dados
     * @since 1.0.0
     */
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
    
    /**
     * <p><strong>EN:</strong> Retrieves a scheduled (future) cash movement record by its ID.</p>
     *
     * <p><strong>IT:</strong> Recupera un movimento di cassa pianificato (futuro) per ID.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera um lançamento de caixa programado (futuro) pelo seu ID.</p>
     *
     * @param id EN: scheduled cash movement ID | IT: ID del movimento di cassa pianificato | PT-BR: ID do lançamento futuro de caixa
     * @return EN: MovimentoCaixa future entry if found; otherwise null | IT: registrazione futura MovimentoCaixa se trovata; altrimenti null | PT-BR: lançamento futuro MovimentoCaixa se encontrado; caso contrário null
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco de dados
     * @since 1.0.0
     */
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
    
    /**
     * <p><strong>EN:</strong> Retrieves the most recent scheduled (future) cash movement for a user.</p>
     *
     * <p><strong>IT:</strong> Recupera l'ultimo movimento di cassa pianificato (futuro) per un utente.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera o último lançamento de caixa programado (futuro) de um usuário.</p>
     *
     * @param cd_usuario EN: user ID | IT: ID utente | PT-BR: ID do usuário
     * @return EN: latest MovimentoCaixa future entry, or null if none | IT: ultima registrazione futura MovimentoCaixa, o null se assente | PT-BR: último lançamento futuro MovimentoCaixa, ou null se inexistente
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco de dados
     * @since 1.0.0
     */
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