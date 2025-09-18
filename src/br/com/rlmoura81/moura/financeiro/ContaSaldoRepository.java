package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ContaSaldoRepository implements IPadraoRepository{

    String sql = "";    
    ContaRepository contar = new ContaRepository();
        
    /**
     * <p><strong>EN:</strong> Inserts a new account balance record (account, amount, user) into the database. Shows an error dialog on failure.</p>
     * <p><strong>IT:</strong> Inserisce nel database un nuovo saldo di conto (conto, importo, utente). Mostra un messaggio di errore in caso di fallimento.</p>
     * <p><strong>PT-BR:</strong> Insere no banco de dados um novo registro de saldo da conta (conta, valor, usuário). Exibe erro em caso de falha.</p>
     *
     * @param o EN: balance entity to persist | IT: entità saldo da salvare | PT-BR: entidade de saldo a ser salva
     */
    @Override
    public void inserir(Object o) {
        ContaSaldo csaldo = (ContaSaldo) o;
        try{
            sql = "INSERT INTO contasaldo (cd_conta, vl_saldo, cd_usuario)" +
                  "     VALUES (?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, csaldo.getConta().getCd_conta());
            ps.setBigDecimal(2, csaldo.getVl_saldo());
            ps.setInt(3, csaldo.getCd_usuario());
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao inserir Saldo:\n" +
                    ex.getMessage());
        }
    }

    /**
     * <p><strong>EN:</strong> Updates the stored balance value for a specific account and user.</p>
     * <p><strong>IT:</strong> Aggiorna il valore del saldo memorizzato per uno specifico conto e utente.</p>
     * <p><strong>PT-BR:</strong> Atualiza o valor do saldo armazenado para uma conta e usuário específicos.</p>
     *
     * @param o EN: balance entity with new amount | IT: entità saldo con nuovo importo | PT-BR: entidade de saldo com novo valor
     */
    @Override
    public void alterar(Object o) {
        ContaSaldo csaldo = (ContaSaldo) o;
        try{
            sql = "UPDATE contasaldo " +
                  "   SET vl_saldo = ?" +
                  " WHERE cd_conta = ?" +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setBigDecimal(1, csaldo.getVl_saldo());
            ps.setInt(2, csaldo.getConta().getCd_conta());
            ps.setInt(3, csaldo.getCd_usuario());
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar saldo:\n" +
                    ex.getMessage());
        }
    }

    /**
     * <p><strong>EN:</strong> Deletes the balance record of the given account for the specified user.</p>
     * <p><strong>IT:</strong> Elimina il record di saldo del conto indicato per lo specifico utente.</p>
     * <p><strong>PT-BR:</strong> Exclui o registro de saldo da conta informada para o usuário especificado.</p>
     *
     * @param o EN: balance entity to delete (must include account and user) | IT: entità saldo da eliminare (deve includere conto e utente) | PT-BR: entidade de saldo a excluir (deve incluir conta e usuário)
     */
    @Override
    public void excluir(Object o) {
        ContaSaldo csaldo = (ContaSaldo) o;
        try{
            sql = "DELETE FROM contasaldo" +
                  " WHERE cd_conta = ?" +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, csaldo.getConta().getCd_conta());
            ps.setInt(2, csaldo.getCd_usuario());
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir saldo da conta:\n" +
                    ex.getMessage());
        }
    }

    /**
     * <p><strong>EN:</strong> Retrieves all balance records for the logged-in user and returns them as a list.</p>
     * <p><strong>IT:</strong> Recupera tutti i saldi per l’utente connesso e li restituisce come elenco.</p>
     * <p><strong>PT-BR:</strong> Recupera todos os saldos do usuário logado e os retorna em uma lista.</p>
     *
     * @return EN: list of balances | IT: elenco dei saldi | PT-BR: lista de saldos
     */
    @Override
    public ArrayList getLista() {
        ArrayList csaldo = new ArrayList();
        try{
            sql = "SELECT cd_conta, vl_saldo, cd_usuario" +
                  "  FROM contasaldo" +
                  " WHERE cd_usuario = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                ContaSaldo cs = new ContaSaldo(
                        (Conta)contar.getById(rs.getInt("cd_conta")),
                        rs.getBigDecimal("vl_saldo"),
                        rs.getInt("cd_usuario"));
                        csaldo.add(cs);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Conta Saldo:\n" +
                    ex);
        }
        return csaldo;
    }
    
    /**
     * <p><strong>EN:</strong> Fetches a balance record by account ID, including the related account entity.</p>
     * <p><strong>IT:</strong> Recupera un saldo tramite ID del conto, includendo l’entità del conto correlata.</p>
     * <p><strong>PT-BR:</strong> Busca um saldo pelo ID da conta, incluindo a entidade de conta relacionada.</p>
     *
     * @param id EN: account ID to look up | IT: ID del conto da cercare | PT-BR: ID da conta a consultar
     * @return EN: balance found or null | IT: saldo trovato o null | PT-BR: saldo encontrado ou null
     */
    @Override
    public Object getById(int id) {
        ContaSaldo csaldo = null;
        try{
            sql = "SELECT cd_conta, vl_saldo, cd_usuario" +
                  "  FROM contasaldo" +
                  " WHERE cd_conta = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                csaldo = new ContaSaldo(
                        (Conta)contar.getById(rs.getInt("cd_conta")),
                        rs.getBigDecimal("vl_saldo"),
                        rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em Conta Saldo:\n" +
                    ex.getMessage());
        }
        return csaldo;
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves the balance for a specific account ID (alias method), returning the associated account and amount.</p>
     * <p><strong>IT:</strong> Recupera il saldo per uno specifico ID conto (metodo alias), restituendo conto associato e importo.</p>
     * <p><strong>PT-BR:</strong> Recupera o saldo para um ID de conta específico (método atalho), retornando a conta associada e o valor.</p>
     *
     * @param id EN: account ID to query | IT: ID del conto da interrogare | PT-BR: ID da conta a consultar
     * @return EN: balance found or null | IT: saldo trovato o null | PT-BR: saldo encontrado ou null
     */
    public Object getContaSaldo(int id) {
        ContaSaldo csaldo = null;
        try{
            sql = "SELECT cd_conta, vl_saldo, cd_usuario" +
                  "  FROM contasaldo" +
                  " WHERE cd_conta = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                csaldo = new ContaSaldo(
                        (Conta)contar.getById(rs.getInt("cd_conta")),
                        rs.getBigDecimal("vl_saldo"),
                        rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getContaSaldo em Conta Saldo:\n" +
                    ex.getMessage());
        }
        return csaldo;
    }    
}
