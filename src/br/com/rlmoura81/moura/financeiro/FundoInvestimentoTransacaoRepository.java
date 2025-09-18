package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FundoInvestimentoTransacaoRepository implements IPadraoRepository{

    String sql = "";    
    GrupoTransacaoRepository gptransr = new GrupoTransacaoRepository();    
    FundoInvestimentoAplicacaoRepository fiar = new FundoInvestimentoAplicacaoRepository();    
    ContaRepository contar = new ContaRepository();    
    Utilidade util = new Utilidade();

    /**
     * <p><strong>EN:</strong> Inserts a fund investment transaction record.</p>
     *
     * <p><strong>IT:</strong> Inserisce un record di transazione di fondo di investimento.</p>
     *
     * <p><strong>PT-BR:</strong> Insere um registro de transação de fundo de investimento.</p>
     *
     * @param o EN: object to insert (expected: FundoInvestimentoTransacao) | IT: oggetto da inserire (atteso: FundoInvestimentoTransacao) | PT-BR: objeto a ser inserido (esperado: FundoInvestimentoTransacao)
     * @return EN: created record in the fdinvesttrans table | IT: record creato nella tabella fdinvesttrans | PT-BR: registro criado na tabela fdinvesttrans
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco de dados
     * @since 1.0.0
     */
    @Override
    public void inserir(Object o) {
        FundoInvestimentoTransacao fit = (FundoInvestimentoTransacao) o;
        try{
            sql = "INSERT INTO fdinvesttrans (cd_fdinvesttrans, vl_transacao, dt_transacao, cd_gptrans, cd_fdinvestaplic, cd_conta, cd_usuario)" +
                  "     VALUES (sq_fdinvesttrans.nextval, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setBigDecimal(1, fit.getVl_transacao());
            ps.setString(2, Utilidade.formatoData.format(fit.getDt_transacao().getTime()));
            ps.setInt(3, fit.getGptrans().getCd_gptrans());
            ps.setInt(4, fit.getFdinvestap().getCd_fdinvestaplic());
            ps.setInt(5, fit.getConta().getCd_conta());
            ps.setInt(6, fit.getCd_usuario());
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao inserir Fundo Investimento Transacao:\n" +
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
     * <p><strong>EN:</strong> Retrieves all fund investment transactions for the logged user.</p>
     *
     * <p><strong>IT:</strong> Recupera tutte le transazioni di fondi di investimento per l'utente loggato.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera todas as transações de fundos de investimento do usuário logado.</p>
     *
     * @return EN: list of FundoInvestimentoTransacao | IT: elenco di FundoInvestimentoTransacao | PT-BR: lista de FundoInvestimentoTransacao
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco de dados
     * @since 1.0.0
     */
    @Override
    public ArrayList getLista() {
        ArrayList fdinvtr = new ArrayList();
        try{
            sql = "SELECT cd_fdinvesttrans, vl_transacao, to_char(dt_transacao,'dd/MM/yyyy'), cd_gptrans, cd_fdinvestaplic, cd_conta, cd_usuario" +
                  "  FROM fdinvesttrans" +
                  " WHERE cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                FundoInvestimentoTransacao fit = new FundoInvestimentoTransacao(
                        rs.getInt("cd_fdinvesttrans"),
                        rs.getBigDecimal("vl_transacao"),
                        util.recebeData(rs.getString("to_char(dt_transacao,'dd/MM/yyyy')")), 
                        (GrupoTransacao)gptransr.getById(rs.getInt("cd_gptrans")),
                        (FundoInvestimentoAplicacao)fiar.getById(rs.getInt("cd_fdinvestaplic")),
                        (Conta)contar.getById(rs.getInt("cd_conta")),
                        rs.getInt("cd_usuario"));
                fdinvtr.add(fit);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Transações de Fundos de Investimentos:\n" +
                    ex.getMessage());
        }
        return fdinvtr;
    }

    /**
     * <p><strong>EN:</strong> Retrieves fund investment transactions by application and account.</p>
     *
     * <p><strong>IT:</strong> Recupera le transazioni di fondi di investimento per applicazione e conto.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera transações de fundos de investimento por aplicação e conta.</p>
     *
     * @param fdinvestaplic EN: investment application ID | IT: ID dell'applicazione di investimento | PT-BR: ID da aplicação de investimento
     * @param conta EN: account ID | IT: ID del conto | PT-BR: ID da conta
     * @return EN: list of FundoInvestimentoTransacao | IT: elenco di FundoInvestimentoTransacao | PT-BR: lista de FundoInvestimentoTransacao
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco de dados
     * @since 1.0.0
     */
    public ArrayList getListaFdInvestTrans(int fdinvestaplic, int conta) {
        ArrayList fdinvtr = new ArrayList();
        try{
            sql = "SELECT cd_fdinvesttrans, vl_transacao, to_char(dt_transacao,'dd/MM/yyyy'), cd_gptrans, cd_fdinvestaplic, cd_conta, cd_usuario" +
                  "  FROM fdinvesttrans" +
                  " WHERE cd_fdinvestaplic = ?" +
                  "   AND cd_conta = ?" +
                  "   AND cd_usuario = ?" + 
                  " ORDER BY dt_transacao DESC";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, fdinvestaplic);
            ps.setInt(2, conta);
            ps.setInt(3, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                FundoInvestimentoTransacao fit = new FundoInvestimentoTransacao(
                        rs.getInt("cd_fdinvesttrans"),
                        rs.getBigDecimal("vl_transacao"),
                        util.recebeData(rs.getString("to_char(dt_transacao,'dd/MM/yyyy')")), 
                        (GrupoTransacao)gptransr.getById(rs.getInt("cd_gptrans")),
                        (FundoInvestimentoAplicacao)fiar.getById(rs.getInt("cd_fdinvestaplic")),
                        (Conta)contar.getById(rs.getInt("cd_conta")),
                        rs.getInt("cd_usuario"));
                fdinvtr.add(fit);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Transações de Fundos de Investimentos:\n" +
                    ex.getMessage());
        }
        return fdinvtr;
    }
        
    /**
     * <p><strong>EN:</strong> Retrieves a fund investment transaction by ID.</p>
     *
     * <p><strong>IT:</strong> Recupera una transazione di fondo di investimento tramite ID.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera uma transação de fundo de investimento pelo ID.</p>
     *
     * @param id EN: transaction ID | IT: ID della transazione | PT-BR: ID da transação
     * @return EN: FundoInvestimentoTransacao instance or null if not found | IT: istanza di FundoInvestimentoTransacao o null se non trovata | PT-BR: instância de FundoInvestimentoTransacao ou null se não encontrada
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco de dados
     * @since 1.0.0
     */
    @Override
    public Object getById(int id) {
        FundoInvestimentoTransacao fdinvtr = null;
        try{
            sql = "SELECT cd_fdinvesttrans, vl_transacao, to_char(dt_transacao,'dd/MM/yyyy), cd_gptrans, cd_fdinvestaplic, cd_conta, cd_usuario" +
                  "  FROM fdinvesttrans" +
                  " WHERE cd_fdinvesttrans = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                FundoInvestimentoTransacao fit = new FundoInvestimentoTransacao(
                        rs.getInt("cd_fdinvesttrans"),
                        rs.getBigDecimal("vl_transacao"),
                        util.recebeData(rs.getString("to_char(dt_transacao,'dd/MM/yyyy)")), 
                        (GrupoTransacao)gptransr.getById(rs.getInt("cd_gptrans")),
                        (FundoInvestimentoAplicacao)fiar.getById(rs.getInt("cd_fdinvestaplic")),
                        (Conta)contar.getById(rs.getInt("cd_conta")),
                        rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em Transações de Fundos de Investimentos:\n" +
                    ex.getMessage());
        }
        return fdinvtr;
    }
    
}
