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

    /**
     * <p><strong>EN:</strong> Inserts a new bank account into the database using the provided entity fields
     * (branch/agency, account number, bank, user, and account type). Shows a success or error message.</p>
     * <p><strong>IT:</strong> Inserisce un nuovo conto bancario nel database utilizzando i campi dell’entità
     * (agenzia, numero di conto, banca, utente e tipo di conto). Mostra un messaggio di successo o errore.</p>
     * <p><strong>PT-BR:</strong> Insere uma nova conta bancária no banco de dados usando os campos da entidade
     * (agência, número da conta, banco, usuário e tipo de conta). Exibe mensagem de sucesso ou erro.</p>
     *
     * @param o EN: account entity to be persisted | IT: entità del conto da salvare | PT-BR: entidade da conta a ser salva
     */
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

    /**
     * <p><strong>EN:</strong> Updates an existing bank account’s core fields (agency, account number, bank,
     * and account type) identified by its ID and user. Shows a success or error message.</p>
     * <p><strong>IT:</strong> Aggiorna i campi principali di un conto bancario esistente (agenzia, numero di conto,
     * banca e tipo di conto) identificato da ID e utente. Mostra un messaggio di successo o errore.</p>
     * <p><strong>PT-BR:</strong> Atualiza os campos principais de uma conta bancária existente (agência, número da conta,
     * banco e tipo de conta), identificada pelo ID e usuário. Exibe mensagem de sucesso ou erro.</p>
     *
     * @param o EN: account entity with updated data | IT: entità del conto con dati aggiornati | PT-BR: entidade da conta com dados atualizados
     */
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

    /**
     * <p><strong>EN:</strong> Deletes a bank account by its ID for the given user. Shows a success or error message.</p>
     * <p><strong>IT:</strong> Elimina un conto bancario tramite ID per l’utente indicato. Mostra un messaggio di successo o errore.</p>
     * <p><strong>PT-BR:</strong> Exclui uma conta bancária pelo seu ID para o usuário informado. Exibe mensagem de sucesso ou erro.</p>
     *
     * @param o EN: account entity to delete (must contain ID and user) | IT: entità del conto da eliminare (con ID e utente) | PT-BR: entidade da conta a excluir (com ID e usuário)
     */
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

    /**
     * <p><strong>EN:</strong> Retrieves all bank accounts for the currently logged-in user,
     * ordered by account number/name, and returns them as a list.</p>
     * <p><strong>IT:</strong> Recupera tutti i conti bancari per l’utente attualmente connesso,
     * ordinati per numero/nome del conto, restituendoli come lista.</p>
     * <p><strong>PT-BR:</strong> Recupera todas as contas bancárias do usuário logado,
     * ordenadas pelo número/nome da conta, retornando-as em uma lista.</p>
     *
     * @return EN: list of accounts | IT: elenco dei conti | PT-BR: lista de contas
     */
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

    /**
     * <p><strong>EN:</strong> Fetches a specific bank account by its ID, including related bank and account-type data.</p>
     * <p><strong>IT:</strong> Recupera un conto bancario specifico tramite ID, includendo i dati di banca e tipo di conto.</p>
     * <p><strong>PT-BR:</strong> Busca uma conta bancária específica pelo ID, incluindo os dados de banco e tipo de conta.</p>
     *
     * @param id EN: account ID to search | IT: ID del conto da cercare | PT-BR: ID da conta a buscar
     * @return EN: the account found or null if not found | IT: il conto trovato o null se assente | PT-BR: a conta encontrada ou null se não existir
     */
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
    
    /**
     * <p><strong>EN:</strong> Retrieves the most recently created bank account for a given user
     * (latest by account ID) and returns its complete data.</p>
     * <p><strong>IT:</strong> Recupera l’ultimo conto bancario creato per un determinato utente
     * (più recente per ID del conto) e ne restituisce i dati completi.</p>
     * <p><strong>PT-BR:</strong> Recupera a conta bancária mais recente criada para um usuário
     * (mais recente pelo ID da conta) e retorna seus dados completos.</p>
     *
     * @param id EN: user ID whose latest account is desired | IT: ID utente di cui recuperare l’ultimo conto | PT-BR: ID do usuário para obter a conta mais recente
     * @return EN: the latest account or null if none exists | IT: l’ultimo conto o null se non esiste | PT-BR: a conta mais recente ou null se não existir
     */
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
