package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PoupancaAplicacaoRepository implements IPadraoRepository{

    String sql = "";    
    PoupancaRepository poupr = new PoupancaRepository();        
    Utilidade util = new Utilidade();

    /**
     * <p><strong>EN:</strong> Inserts a savings application record into the <code>poupaplic</code> table.</p>
     *
     * <p><strong>IT:</strong> Inserisce un record di applicazione del risparmio nella tabella <code>poupaplic</code>.</p>
     *
     * <p><strong>PT-BR:</strong> Insere um registro de aplicação de poupança na tabela <code>poupaplic</code>.</p>
     *
     * @param o EN: object to be inserted (PoupancaAplicacao) | IT: oggetto da inserire (PoupancaAplicacao) | PT-BR: objeto a ser inserido (PoupancaAplicacao)
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco
     * @since 1.0.0
     */
    @Override
    public void inserir(Object o) {
        PoupancaAplicacao poupap = (PoupancaAplicacao) o;
        try{
            sql = "INSERT INTO poupaplic (cd_poupaplic, vl_saldo, dt_saldo, cd_poupanca, cd_usuario) " +
                  "     VALUES (sq_poupaplic.nextval, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setBigDecimal(1, poupap.getVl_saldo());
            ps.setString(2, Utilidade.formatoData.format(poupap.getDt_saldo().getTime()));
            ps.setInt(3, poupap.getPoupanca().getCd_poupanca());
            ps.setInt(4, poupap.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Aplicado.", "Poupança Aplicação", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao aplicar:\n" +
                    ex.getMessage(), "Poupança Aplicação", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void alterar(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * <p><strong>EN:</strong> Deletes a savings application record from the <code>poupaplic</code> table.</p>
     *
     * <p><strong>IT:</strong> Elimina un record di applicazione del risparmio dalla tabella <code>poupaplic</code>.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui um registro de aplicação de poupança da tabela <code>poupaplic</code>.</p>
     *
     * @param o EN: object to be deleted (PoupancaAplicacao) | IT: oggetto da eliminare (PoupancaAplicacao) | PT-BR: objeto a ser excluído (PoupancaAplicacao)
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco
     * @since 1.0.0
     */
    @Override
    public void excluir(Object o) {
        PoupancaAplicacao poupap = (PoupancaAplicacao) o;
        try{
            sql = "DELETE FROM poupaplic " +
                  " WHERE cd_poupaplic = ? " +
                  "   AND cd_poupanca = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, poupap.getCd_poupaplic());
            ps.setInt(2, poupap.getPoupanca().getCd_poupanca());
            ps.setInt(3, poupap.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Poupança Aplicação", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Poupança Aplicação", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Lists all savings applications for the logged-in user from <code>poupaplic</code>.</p>
     *
     * <p><strong>IT:</strong> Elenca tutte le applicazioni di risparmio per l'utente connesso da <code>poupaplic</code>.</p>
     *
     * <p><strong>PT-BR:</strong> Lista todas as aplicações de poupança do usuário logado a partir de <code>poupaplic</code>.</p>
     *
     * @return EN: list of savings applications (ArrayList&lt;PoupancaAplicacao&gt;) | IT: elenco delle applicazioni di risparmio (ArrayList&lt;PoupancaAplicacao&gt;) | PT-BR: lista de aplicações de poupança (ArrayList&lt;PoupancaAplicacao&gt;)
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco
     * @since 1.0.0
     */
    @Override
    public ArrayList getLista() {
        ArrayList poupap = new ArrayList();
        try{
            sql = "SELECT cd_poupaplic, vl_saldo, to_char(dt_saldo,'dd/MM/yyyy'), cd_poupanca, cd_usuario" +
                  "  FROM poupaplic" +
                  " WHERE cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PoupancaAplicacao pap = new PoupancaAplicacao(
                    rs.getInt("cd_poupaplic"),
                    rs.getBigDecimal("vl_saldo"),
                    util.recebeData(rs.getString("to_char(dt_saldo,'dd/MM/yyyy')")),    
                    (Poupanca)poupr.getById(rs.getInt("cd_poupanca")),
                    rs.getInt("cd_usuario"));
                poupap.add(pap);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Aplicação Poupança:\n" +
                    ex.getMessage(), "Poupança Aplicação", JOptionPane.ERROR_MESSAGE);
        }
        return poupap;
    }
    
    /**
     * <p><strong>EN:</strong> Lists savings applications filtered by savings account from <code>poupaplic</code>.</p>
     *
     * <p><strong>IT:</strong> Elenca le applicazioni di risparmio filtrate per conto di risparmio da <code>poupaplic</code>.</p>
     *
     * <p><strong>PT-BR:</strong> Lista aplicações de poupança filtradas por conta de poupança a partir de <code>poupaplic</code>.</p>
     *
     * @param cd_poupanca EN: savings account ID filter | IT: filtro ID del conto di risparmio | PT-BR: filtro de ID da conta de poupança
     * @return EN: filtered list of savings applications (ArrayList&lt;PoupancaAplicacao&gt;) | IT: elenco filtrato delle applicazioni di risparmio (ArrayList&lt;PoupancaAplicacao&gt;) | PT-BR: lista filtrada de aplicações de poupança (ArrayList&lt;PoupancaAplicacao&gt;)
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco
     * @since 1.0.0
     */
    public ArrayList getLista(int cd_poupanca) {
        ArrayList poupap = new ArrayList();
        try{
            sql = "SELECT cd_poupaplic, vl_saldo, to_char(dt_saldo,'dd/MM/yyyy'), cd_poupanca, cd_usuario" +
                  "  FROM poupaplic" +
                  " WHERE cd_poupanca = ?" +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_poupanca);
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                PoupancaAplicacao pap = new PoupancaAplicacao(
                    rs.getInt("cd_poupaplic"),
                    rs.getBigDecimal("vl_saldo"),
                    util.recebeData(rs.getString("to_char(dt_saldo,'dd/MM/yyyy')")),    
                    (Poupanca)poupr.getById(rs.getInt("cd_poupanca")),
                    rs.getInt("cd_usuario"));
                poupap.add(pap);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Aplicação Poupança:\n" +
                    ex.getMessage(), "Poupança Aplicação", JOptionPane.ERROR_MESSAGE);
        }
        return poupap;
    }

    /**
     * <p><strong>EN:</strong> Retrieves a savings application by its identifier from <code>poupaplic</code>.</p>
     *
     * <p><strong>IT:</strong> Recupera un'applicazione di risparmio per identificativo da <code>poupaplic</code>.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera uma aplicação de poupança pelo identificador em <code>poupaplic</code>.</p>
     *
     * @param id EN: savings application ID | IT: ID dell'applicazione di risparmio | PT-BR: ID da aplicação de poupança
     * @return EN: savings application or null if not found (PoupancaAplicacao) | IT: applicazione di risparmio o null se non trovata (PoupancaAplicacao) | PT-BR: aplicação de poupança ou null se não encontrada (PoupancaAplicacao)
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco
     * @since 1.0.0
     */
    @Override
    public Object getById(int id) {
        PoupancaAplicacao poupap = null;
        try{
            sql = "SELECT cd_poupaplic, vl_saldo, to_char(dt_saldo,'dd/MM/yyyy'), cd_poupanca, cd_usuario" +
                  "  FROM poupaplic" +
                  " WHERE cd_poupaplic = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                poupap = new PoupancaAplicacao(
                    rs.getInt("cd_poupaplic"),
                    rs.getBigDecimal("vl_saldo"),
                    util.recebeData(rs.getString("to_char(dt_saldo,'dd/MM/yyyy')")),
                    (Poupanca)poupr.getById(rs.getInt("cd_poupanca")),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em Aplicação Poupança:\n" +
                    ex.getMessage(), "Poupança Aplicação", JOptionPane.ERROR_MESSAGE);
        }
        return poupap;
    }

}
