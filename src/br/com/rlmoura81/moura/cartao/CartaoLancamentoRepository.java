package br.com.rlmoura81.moura.cartao;

import br.com.rlmoura81.moura.financeiro.Despesa;
import br.com.rlmoura81.moura.financeiro.DespesaRepository;
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

public class CartaoLancamentoRepository implements IPadraoRepository{
    
    String sql = "";    
    CartaoRepository cartaor = new CartaoRepository();    
    DespesaRepository despesar = new DespesaRepository();    
    CategoriaRepository categoriar = new CategoriaRepository();    
    Utilidade util = new Utilidade();

    /**
     * <p><strong>EN:</strong> Inserts a card transaction (CartaoLancamento) into the database.</p>
     *
     * <p><strong>IT:</strong> Inserisce una transazione carta (CartaoLancamento) nel database.</p>
     *
     * <p><strong>PT-BR:</strong> Insere um lançamento de cartão (CartaoLancamento) no banco de dados.</p>
     *
     * @param o EN: CartaoLancamento object to insert | IT: Oggetto CartaoLancamento da inserire | PT-BR: Objeto CartaoLancamento a ser inserido
     * @since 1.0.0
     */
    @Override
    public void inserir(Object o) {
        CartaoLancamento cl = (CartaoLancamento) o;
        try{
            sql = "INSERT INTO cartaolanc (ds_despesa, nm_valor, nm_parcela, dt_despesa, cd_despesa, cd_categoria, cd_cartao, cd_usuario, cd_cartaolanc)" +
                  "     VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, cl.getDs_despesa());
            ps.setBigDecimal(2, cl.getNm_valor());
            ps.setInt(3, cl.getNm_parcela());
            ps.setString(4, Utilidade.formatoData.format(cl.getDt_despesa().getTime()));
            ps.setInt(5, cl.getDespesa().getCd_despesa());
            ps.setInt(6, cl.getCategoria().getCd_Categoria());
            ps.setInt(7, cl.getCartao().getCd_cartao());
            ps.setInt(8, cl.getCd_usuario());
            ps.setInt(9, cl.getCd_cartaolanc());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Cartão Lançamento", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Cartão Lançamento", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Updates an existing card transaction (CartaoLancamento).</p>
     *
     * <p><strong>IT:</strong> Aggiorna una transazione carta (CartaoLancamento) esistente.</p>
     *
     * <p><strong>PT-BR:</strong> Atualiza um lançamento de cartão (CartaoLancamento) existente.</p>
     *
     * @param o EN: CartaoLancamento object with updated values | IT: Oggetto CartaoLancamento con valori aggiornati | PT-BR: Objeto CartaoLancamento com valores atualizados
     * @since 1.0.0
     */
    @Override
    public void alterar(Object o) {
        CartaoLancamento cl = (CartaoLancamento) o;
        try{
            sql = "UPDATE cartaolanc " +
                  "   SET ds_despesa = ?, " +
                  "       nm_valor = ?, " +
                  "       nm_parcela = ?," +
                  "       dt_despesa = ?, " +
                  "       cd_despesa = ?, " +
                  "       cd_categoria = ?" +
                  " WHERE cd_cartao = ?" +
                  "   AND cd_cartaolanc = ?" +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, cl.getDs_despesa());
            ps.setBigDecimal(2, cl.getNm_valor());
            ps.setInt(3, cl.getNm_parcela());
            ps.setString(4, Utilidade.formatoData.format(cl.getDt_despesa().getTime()));
            ps.setInt(5, cl.getDespesa().getCd_despesa());
            ps.setInt(6, cl.getCategoria().getCd_Categoria());
            ps.setInt(7, cl.getCartao().getCd_cartao());
            ps.setInt(8, cl.getCd_cartaolanc());
            ps.setInt(9, cl.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Aterado.", "Cartão Lançamento", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Cartão Lançamento", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Deletes a card transaction (CartaoLancamento) by card, transaction ID, and user.</p>
     *
     * <p><strong>IT:</strong> Elimina una transazione carta (CartaoLancamento) per carta, ID transazione e utente.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui um lançamento de cartão (CartaoLancamento) por cartão, ID do lançamento e usuário.</p>
     *
     * @param o EN: CartaoLancamento object containing identifiers for deletion | IT: Oggetto CartaoLancamento con gli identificatori per l'eliminazione | PT-BR: Objeto CartaoLancamento com identificadores para exclusão
     * @since 1.0.0
     */
    @Override
    public void excluir(Object o) {
        CartaoLancamento cl = (CartaoLancamento) o;
        try{
            sql = "DELETE FROM cartaolanc" +
                  " WHERE cd_cartao = ?" +
                  "   AND cd_cartaolanc = ?" +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cl.getCartao().getCd_cartao());
            ps.setInt(2, cl.getCd_cartaolanc());
            ps.setInt(3, cl.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Cartão Lançamento", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir." +
                    ex.getMessage(), "Cartão Lançamento", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Retrieves all card transactions (CartaoLancamento) for the logged-in user, ordered by expense date.</p>
     *
     * <p><strong>IT:</strong> Recupera tutte le transazioni carta (CartaoLancamento) per l'utente connesso, ordinate per data spesa.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera todos os lançamentos de cartão (CartaoLancamento) do usuário logado, ordenados por data da despesa.</p>
     *
     * @return EN: list of CartaoLancamento objects | IT: elenco di oggetti CartaoLancamento | PT-BR: lista de objetos CartaoLancamento
     * @since 1.0.0
     */
    @Override
    public ArrayList getLista() {
        ArrayList clanc = new ArrayList();
        try{
            sql = "SELECT cd_cartaolanc, ds_despesa, nm_valor, nm_parcela, to_char(dt_despesa,'dd/MM/yyyy'), cd_despesa, cd_categoria, cd_cartao, cd_usuario" +
                  "  FROM cartaolanc" +
                  " WHERE cd_usuario = ?" +
                  " ORDER BY dt_despesa";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                CartaoLancamento cl = new CartaoLancamento(
                        rs.getInt("cd_cartaolanc"),
                        rs.getString("ds_despesa"),
                        rs.getBigDecimal("nm_valor"),
                        rs.getInt("nm_parcela"),
                        util.recebeData(rs.getString("to_char(dt_despesa,'dd/MM/yyyy')")),
                        (Despesa)despesar.getById(rs.getInt("cd_despesa")),
                        (Categoria)categoriar.getById(rs.getInt("cd_categoria")),
                        (Cartao)cartaor.getById(rs.getInt("cd_cartao")),
                        rs.getInt("cd_usuario"));
                clanc.add(cl);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Cartão Lançamentos:\n" +
                    ex.getMessage(), "Cartão Lançamento", JOptionPane.ERROR_MESSAGE);
        }
        return clanc;
    }

    /**
     * <p><strong>EN:</strong> Retrieves all card transactions (CartaoLancamento) for the specified card and logged-in user, ordered by date and description.</p>
     *
     * <p><strong>IT:</strong> Recupera tutte le transazioni carta (CartaoLancamento) per la carta indicata e l'utente connesso, ordinate per data e descrizione.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera todos os lançamentos de cartão (CartaoLancamento) para o cartão informado e o usuário logado, ordenados por data e descrição.</p>
     *
     * @param cd_cartao EN: card identifier | IT: identificatore della carta | PT-BR: identificador do cartão
     * @return EN: list of CartaoLancamento objects | IT: elenco di oggetti CartaoLancamento | PT-BR: lista de objetos CartaoLancamento
     * @since 1.0.0
     */    
    public ArrayList getLista(int cd_cartao) {
        ArrayList clanc = new ArrayList();
        try{
            sql = "SELECT cd_cartaolanc, ds_despesa, nm_valor, nm_parcela, to_char(dt_despesa,'dd/MM/yyyy'), cd_despesa, cd_categoria, cd_cartao, cd_usuario" +
                  "  FROM cartaolanc" +
                  " WHERE cd_cartao = ?" +
                  "   AND cd_usuario = ?" +
                  " ORDER BY dt_despesa, ds_despesa";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_cartao);
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                CartaoLancamento cl = new CartaoLancamento(
                        rs.getInt("cd_cartaolanc"),
                        rs.getString("ds_despesa"),
                        rs.getBigDecimal("nm_valor"),
                        rs.getInt("nm_parcela"),
                        util.recebeData(rs.getString("to_char(dt_despesa,'dd/MM/yyyy')")),
                        (Despesa)despesar.getById(rs.getInt("cd_despesa")),
                        (Categoria)categoriar.getById(rs.getInt("cd_categoria")),
                        (Cartao)cartaor.getById(rs.getInt("cd_cartao")),
                        rs.getInt("cd_usuario"));
                clanc.add(cl);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Cartão Lançamentos:\n" +
                    ex.getMessage(), "Cartão Lançamento", JOptionPane.ERROR_MESSAGE);
        }
        return clanc;
    }

    /**
     * <p><strong>EN:</strong> Gets a card transaction (CartaoLancamento) by its ID.</p>
     *
     * <p><strong>IT:</strong> Recupera una transazione carta (CartaoLancamento) tramite il suo ID.</p>
     *
     * <p><strong>PT-BR:</strong> Obtém um lançamento de cartão (CartaoLancamento) pelo seu ID.</p>
     *
     * @param id EN: unique identifier of the transaction | IT: identificatore univoco della transazione | PT-BR: identificador único do lançamento
     * @return EN: CartaoLancamento object if found, otherwise null | IT: Oggetto CartaoLancamento se trovato, altrimenti null | PT-BR: Objeto CartaoLancamento se encontrado, caso contrário null
     * @since 1.0.0
     */
    @Override
    public Object getById(int id) {
        CartaoLancamento clanc = null;
        try{
            sql = "SELECT cd_cartaolanc, ds_despesa, nm_valor, nm_parcela, to_char(dt_despesa,'dd/MM/yyyy'), cd_despesa, cd_categoria, cd_cartao, cd_usuario" +
                  "  FROM cartaolanc" +
                  " WHERE cd_cartaolanc = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                clanc = new CartaoLancamento(
                        rs.getInt("cd_cartaolanc"),
                        rs.getString("ds_despesa"),
                        rs.getBigDecimal("nm_valor"),
                        rs.getInt("nm_parcela"),
                        util.recebeData(rs.getString("to_char(dt_despesa,'dd/MM/yyyy')")),
                        (Despesa)despesar.getById(rs.getInt("cd_despesa")),
                        (Categoria)categoriar.getById(rs.getInt("cd_categoria")),
                        (Cartao)cartaor.getById(rs.getInt("cd_cartao")),
                        rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em Cartão Lançamentos:\n" +
                    ex.getMessage(), "Cartão Lançamento", JOptionPane.ERROR_MESSAGE);
        }
        return clanc;
    }

    /**
     * <p><strong>EN:</strong> Retrieves the most recent card transaction (CartaoLancamento) for the given user, ordered by ID descending.</p>
     *
     * <p><strong>IT:</strong> Recupera la transazione carta (CartaoLancamento) più recente per l'utente indicato, ordinata per ID decrescente.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera o lançamento de cartão (CartaoLancamento) mais recente para o usuário informado, ordenado por ID decrescente.</p>
     *
     * @param id EN: user identifier | IT: identificatore dell'utente | PT-BR: identificador do usuário
     * @return EN: last CartaoLancamento object if found, otherwise null | IT: ultimo oggetto CartaoLancamento se trovato, altrimenti null | PT-BR: último objeto CartaoLancamento se encontrado, caso contrário null
     * @since 1.0.0
     */    
    public Object ultimoRegistro(int id) {
        CartaoLancamento clanc = null;
        try{
            sql = "SELECT cd_cartaolanc, ds_despesa, nm_valor, nm_parcela, to_char(dt_despesa,'dd/MM/yyyy'), cd_despesa, cd_categoria, cd_cartao, cd_usuario" +
                  "  FROM cartaolanc" +
                  " WHERE cd_usuario = ?" +
                  " ORDER BY cd_cartaolanc DESC";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                clanc = new CartaoLancamento(
                        rs.getInt("cd_cartaolanc"),
                        rs.getString("ds_despesa"),
                        rs.getBigDecimal("nm_valor"),
                        rs.getInt("nm_parcela"),
                        util.recebeData(rs.getString("to_char(dt_despesa,'dd/MM/yyyy')")),
                        (Despesa)despesar.getById(rs.getInt("cd_despesa")),
                        (Categoria)categoriar.getById(rs.getInt("cd_categoria")),
                        (Cartao)cartaor.getById(rs.getInt("cd_cartao")),
                        rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de ultimoRegistro em Cartão Lançamentos:\n" +
                    ex.getMessage(), "Cartão Lançamento", JOptionPane.ERROR_MESSAGE);
        }
        return clanc;
    }    
}
