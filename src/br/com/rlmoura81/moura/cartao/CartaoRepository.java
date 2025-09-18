package br.com.rlmoura81.moura.cartao;

import br.com.rlmoura81.moura.financeiro.Banco;
import br.com.rlmoura81.moura.financeiro.BancoRepository;
import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CartaoRepository implements IPadraoRepository{

    String sql = "";    
    Utilidade util = new Utilidade();    
    CartaoBandeiraRepository cartaobandeirar = new CartaoBandeiraRepository();    
    BancoRepository bancor = new BancoRepository();

    /**
     * <p><strong>EN:</strong> Inserts a card (Cartao) into the database.</p>
     *
     * <p><strong>IT:</strong> Inserisce una carta (Cartao) nel database.</p>
     *
     * <p><strong>PT-BR:</strong> Insere um cartão (Cartao) no banco de dados.</p>
     *
     * @param o EN: Cartao object to insert | IT: Oggetto Cartao da inserire | PT-BR: Objeto Cartao a ser inserido
     * @since 1.0.0
     */
    @Override
    public void inserir(Object o) {
        Cartao c = (Cartao) o;        
        try{
            sql = "INSERT INTO cartao (cd_cartao, nm_cartao, nm_limite, dt_validade, cd_cartaobandeira, cd_banco, cd_usuario)" +
                  "     VALUES (sq_cartao.nextval, ?, ?, ?, ?, ?, ?)";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, c.getNm_cartao());
            ps.setBigDecimal(2, c.getNm_limite());
            ps.setString(3, Utilidade.formatoData.format(c.getDt_vencimento().getTime()));
            ps.setInt(4, c.getCartaobandeira().getCd_cartaobandeira());
            ps.setInt(5, c.getBanco().getCd_banco());
            ps.setInt(6, c.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Cartão", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Cartão", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Updates an existing card (Cartao) in the database.</p>
     *
     * <p><strong>IT:</strong> Aggiorna una carta (Cartao) esistente nel database.</p>
     *
     * <p><strong>PT-BR:</strong> Atualiza um cartão (Cartao) existente no banco de dados.</p>
     *
     * @param o EN: Cartao object with updated values | IT: Oggetto Cartao con valori aggiornati | PT-BR: Objeto Cartao com valores atualizados
     * @since 1.0.0
     */
    @Override
    public void alterar(Object o) {
        Cartao c = (Cartao) o;        
        try{
            sql = "UPDATE cartao " +
                  "   SET nm_cartao = ?, " +
                  "       nm_limite = ?, " +
                  "       dt_validade = ?, " +
                  "       cd_cartaobandeira = ?, " +
                  "       cd_banco = ? " +
                  " WHERE cd_cartao = ? " +
                  "   AND cd_usuario = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, c.getNm_cartao());
            ps.setBigDecimal(2, c.getNm_limite());
            ps.setString(3, Utilidade.formatoData.format(c.getDt_vencimento().getTime()));
            ps.setInt(4, c.getCartaobandeira().getCd_cartaobandeira());
            ps.setInt(5, c.getBanco().getCd_banco());
            ps.setInt(6, c.getCd_cartao());
            ps.setInt(7, c.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado.", "Cartão", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Cartão", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Deletes a card (Cartao) from the database by its ID and user.</p>
     *
     * <p><strong>IT:</strong> Elimina una carta (Cartao) dal database tramite il suo ID e utente.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui um cartão (Cartao) do banco de dados pelo seu ID e usuário.</p>
     *
     * @param o EN: Cartao object containing identifiers for deletion | IT: Oggetto Cartao con gli identificatori per l'eliminazione | PT-BR: Objeto Cartao com os identificadores para exclusão
     * @since 1.0.0
     */
    @Override
    public void excluir(Object o) {
        Cartao c = (Cartao) o;
        try{
            sql = "DELETE FROM cartao " +
                  " WHERE cd_cartao = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, c.getCd_cartao());
            ps.setInt(2, c.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Cartão", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Cartão", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Retrieves all cards (Cartao) for the logged-in user, ordered by name.</p>
     *
     * <p><strong>IT:</strong> Recupera tutte le carte (Cartao) per l'utente connesso, ordinate per nome.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera todos os cartões (Cartao) do usuário logado, ordenados por nome.</p>
     *
     * @return EN: list of Cartao objects | IT: elenco di oggetti Cartao | PT-BR: lista de objetos Cartao
     * @since 1.0.0
     */
    @Override
    public ArrayList getLista() {
        ArrayList cartoes = new ArrayList();
        try{
            sql = "SELECT cd_cartao, nm_cartao, nm_limite, to_char(dt_validade,'dd/MM/yyyy'), cd_cartaobandeira, cd_banco, cd_usuario " +
                  "  FROM cartao " + 
                  " WHERE cd_usuario = ?" +
                  " ORDER BY nm_cartao";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Cartao c = new Cartao(
                    rs.getInt("cd_cartao"),
                    rs.getString("nm_cartao"),
                    rs.getBigDecimal("nm_limite"),
                    util.recebeData(rs.getString("to_char(dt_validade,'dd/MM/yyyy')")),
                    (CartaoBandeira)cartaobandeirar.getById(rs.getInt("cd_cartaobandeira")),
                    (Banco)bancor.getById(rs.getInt("cd_banco")),
                    rs.getInt("cd_usuario"));
                cartoes.add(c);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de cartões:\n" + 
                    ex.getMessage(), "Cartão", JOptionPane.ERROR_MESSAGE);
        }
        return cartoes;
    }

    /**
     * <p><strong>EN:</strong> Retrieves all cards (Cartao) for the specified bank and logged-in user, ordered by name.</p>
     *
     * <p><strong>IT:</strong> Recupera tutte le carte (Cartao) per la banca specificata e l'utente connesso, ordinate per nome.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera todos os cartões (Cartao) do banco informado para o usuário logado, ordenados por nome.</p>
     *
     * @param cd_banco EN: bank identifier | IT: identificatore della banca | PT-BR: identificador do banco
     * @return EN: list of Cartao objects | IT: elenco di oggetti Cartao | PT-BR: lista de objetos Cartao
     * @since 1.0.0
     */    
    public ArrayList getLista(int cd_banco) {
        ArrayList cartoes = new ArrayList();
        try{
            sql = "SELECT cd_cartao, nm_cartao, nm_limite, to_char(dt_validade,'dd/MM/yyyy'), cd_cartaobandeira, cd_banco, cd_usuario " +
                  "  FROM cartao " + 
                  " WHERE cd_banco = ?" +
                  "   AND cd_usuario = ?" +
                  " ORDER BY nm_cartao";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_banco);
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Cartao c = new Cartao(
                    rs.getInt("cd_cartao"),
                    rs.getString("nm_cartao"),
                    rs.getBigDecimal("nm_limite"),
                    util.recebeData(rs.getString("to_char(dt_validade,'dd/MM/yyyy')")),
                    (CartaoBandeira)cartaobandeirar.getById(rs.getInt("cd_cartaobandeira")),
                    (Banco)bancor.getById(rs.getInt("cd_banco")),
                    rs.getInt("cd_usuario"));
                cartoes.add(c);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de cartões:\n" + 
                    ex.getMessage(), "Cartão", JOptionPane.ERROR_MESSAGE);
        }
        return cartoes;
    }

    /**
     * <p><strong>EN:</strong> Gets a card (Cartao) from the database by its ID.</p>
     *
     * <p><strong>IT:</strong> Recupera una carta (Cartao) dal database tramite il suo ID.</p>
     *
     * <p><strong>PT-BR:</strong> Obtém um cartão (Cartao) do banco de dados pelo seu ID.</p>
     *
     * @param id EN: unique identifier of the card | IT: identificatore univoco della carta | PT-BR: identificador único do cartão
     * @return EN: Cartao object if found, otherwise null | IT: Oggetto Cartao se trovato, altrimenti null | PT-BR: Objeto Cartao se encontrado, caso contrário null
     * @since 1.0.0
     */    
    @Override
    public Object getById(int id) {        
        Cartao c = null;        
        try{
            sql = "SELECT cd_cartao, nm_cartao, nm_limite, to_char(dt_validade,'dd/MM/yyyy'), cd_cartaobandeira, cd_banco, cd_usuario" +
                  "  FROM cartao " + 
                  " WHERE cd_cartao = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                c = new Cartao(
                    rs.getInt("cd_cartao"),
                    rs.getString("nm_cartao"),
                    rs.getBigDecimal("nm_limite"),
                    util.recebeData(rs.getString("to_char(dt_validade,'dd/MM/yyyy')")),
                    (CartaoBandeira)cartaobandeirar.getById(rs.getInt("cd_cartaobandeira")),
                    (Banco)bancor.getById(rs.getInt("cd_banco")),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Erro de getById em cartão:\n" + 
                    ex.getMessage(), "Cartão", JOptionPane.ERROR_MESSAGE);                 
        }
        return c;
    }
}
