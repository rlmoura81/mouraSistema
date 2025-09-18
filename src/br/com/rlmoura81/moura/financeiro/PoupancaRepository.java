package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.conexao.ConexaoPersistencia;
import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PoupancaRepository implements IPadraoRepository{

    Connection conn = ConexaoPersistencia.getConnection();
    String sql = "";    
    ContaRepository contar = new ContaRepository();
        
    /**
     * <p><strong>EN:</strong> Inserts a new savings account record into the database.</p>
     *
     * <p><strong>IT:</strong> Inserisce un nuovo record di conto di risparmio nel database.</p>
     *
     * <p><strong>PT-BR:</strong> Insere um novo registro de conta poupança no banco de dados.</p>
     *
     * @param o EN: Savings account object | IT: Oggetto conto di risparmio | PT-BR: Objeto da conta poupança
     * @since 1.0.0
     */
    @Override
    public void inserir(Object o) {
        Poupanca p = (Poupanca) o;
        try{
            sql = "INSERT INTO poupanca (cd_poupanca, nm_variacao, vl_saldo, cd_conta, cd_usuario)" +
                  "       VALUES (sq_poupanca.nextval, ?, ?, ?, ?)";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getNm_variaca());
            ps.setBigDecimal(2, p.getVl_saldo());
            ps.setInt(3, p.getConta().getCd_conta());
            ps.setInt(4, p.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Poupança", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Poupança", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Updates an existing savings account record.</p>
     *
     * <p><strong>IT:</strong> Aggiorna un record esistente di conto di risparmio.</p>
     *
     * <p><strong>PT-BR:</strong> Atualiza um registro existente de conta poupança.</p>
     *
     * @param o EN: Savings account object with updated data | IT: Oggetto conto di risparmio con dati aggiornati | PT-BR: Objeto da conta poupança com dados atualizados
     * @since 1.0.0
     */
    @Override
    public void alterar(Object o) {
        Poupanca p = (Poupanca) o;
        try{
            sql = "UPDATE poupanca SET nm_variacao = ?, cd_conta = ?" +
                  "   WHERE cd_poupanca = ? AND cd_usuario = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getNm_variaca());
            ps.setInt(2, p.getConta().getCd_conta());
            ps.setInt(3, p.getCd_poupanca());
            ps.setInt(4, p.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado.", "Poupança", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" + 
                    ex.getMessage(), "Poupança", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Deletes a savings account record from the database.</p>
     *
     * <p><strong>IT:</strong> Elimina un record di conto di risparmio dal database.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui um registro de poupança do banco de dados.</p>
     *
     * @param o EN: Poupanca object to be deleted | IT: Oggetto Poupanca da eliminare | PT-BR: Objeto Poupanca a ser excluído
     * @since 1.0.0
     */
    @Override
    public void excluir(Object o) {
        Poupanca p =(Poupanca) o;
        try{
            sql = "DELETE FROM poupanca WHERE cd_poupanca = ? AND cd_usuario = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, p.getCd_poupanca());
            ps.setInt(2, p.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Poupança", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Poupança", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Retrieves the list of all savings accounts of the logged user.</p>
     *
     * <p><strong>IT:</strong> Recupera l'elenco di tutti i conti di risparmio dell'utente loggato.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera a lista de todas as poupanças do usuário logado.</p>
     *
     * @return EN: list of savings accounts | IT: elenco dei conti di risparmio | PT-BR: lista de poupanças
     * @since 1.0.0
     */
    @Override
    public ArrayList getLista() {
        ArrayList poupanca = new ArrayList();
        try{
            sql = "SELECT cd_poupanca, nm_variacao, vl_saldo, cd_conta, cd_usuario" +
                  "   FROM poupanca" +
                  "   WHERE cd_usuario = ?" +
                  "   ORDER BY nm_variacao";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Poupanca p = new Poupanca(
                    rs.getInt("cd_poupanca"),
                    rs.getString("nm_variacao"),
                    rs.getBigDecimal("vl_saldo"),
                    (Conta)contar.getById(rs.getInt("cd_conta")),
                    rs.getInt("cd_usuario"));
                poupanca.add(p);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de poupanças." +
                    ex.getMessage(), "Poupança", JOptionPane.ERROR_MESSAGE);
        }
        return poupanca;
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves the list of savings accounts for a specific bank account.</p>
     *
     * <p><strong>IT:</strong> Recupera l'elenco di conti di risparmio per un conto bancario specifico.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera a lista de poupanças para uma conta bancária específica.</p>
     *
     * @param cd_conta EN: account ID | IT: ID del conto | PT-BR: ID da conta
     * @return EN: list of savings accounts linked to the account | IT: elenco dei conti di risparmio legati al conto | PT-BR: lista de poupanças vinculadas à conta
     * @since 1.0.0
     */
    public ArrayList getLista(int cd_conta) {
        ArrayList poupanca = new ArrayList();
        try{
            sql = "SELECT cd_poupanca, nm_variacao, vl_saldo, cd_conta, cd_usuario" +
                  "   FROM poupanca" +
                  "   WHERE cd_usuario = ?" +
                  "     AND cd_conta = ?" +
                  "   ORDER BY nm_variacao";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ps.setInt(2, cd_conta);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Poupanca p = new Poupanca(
                    rs.getInt("cd_poupanca"),
                    rs.getString("nm_variacao"),
                    rs.getBigDecimal("vl_saldo"),
                    (Conta)contar.getById(rs.getInt("cd_conta")),
                    rs.getInt("cd_usuario"));
                poupanca.add(p);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de poupanças." +
                    ex.getMessage(), "Poupança", JOptionPane.ERROR_MESSAGE);
        }
        return poupanca;
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves a savings account by its ID.</p>
     *
     * <p><strong>IT:</strong> Recupera un conto di risparmio tramite il suo ID.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera uma poupança pelo seu ID.</p>
     *
     * @param id EN: savings account ID | IT: ID del conto di risparmio | PT-BR: ID da poupança
     * @return EN: savings account object | IT: oggetto conto di risparmio | PT-BR: objeto poupança
     * @since 1.0.0
     */
    @Override
    public Object getById(int id) {
        Poupanca p = null;
        try{
            sql = "SELECT cd_poupanca, nm_variacao, vl_saldo, cd_conta, cd_usuario" +
                  "   FROM poupanca" +
                  "   WHERE cd_poupanca = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                p = new Poupanca(
                    rs.getInt("cd_poupanca"),
                    rs.getString("nm_variacao"),
                    rs.getBigDecimal("vl_saldo"),
                    (Conta)contar.getById(rs.getInt("cd_conta")),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em poupanças." +
                    ex.getMessage(), "Poupança", JOptionPane.ERROR_MESSAGE);
        }
        return p;
    }
    
    /**
     * <p><strong>EN:</strong> Updates the balance of a savings account.</p>
     *
     * <p><strong>IT:</strong> Aggiorna il saldo di un conto di risparmio.</p>
     *
     * <p><strong>PT-BR:</strong> Atualiza o saldo de uma poupança.</p>
     *
     * @param o EN: Poupanca object with updated balance | IT: Oggetto Poupanca con saldo aggiornato | PT-BR: Objeto Poupanca com saldo atualizado
     * @since 1.0.0
     */
    public void atualizaSaldo(Object o) {
        Poupanca p = (Poupanca) o;
        try{
            sql = "UPDATE poupanca SET vl_saldo = ?" +
                  "   WHERE cd_poupanca = ? AND cd_usuario = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setBigDecimal(1, p.getVl_saldo());
            ps.setInt(2, p.getCd_poupanca());
            ps.setInt(3, p.getCd_usuario());
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar saldo:\n" + 
                    ex.getMessage());
        }
    }
}
