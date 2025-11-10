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

public class CartaoParcelamentoRepository implements IPadraoRepository{
    
    CartaoRepository cartaor = new CartaoRepository();    
    DespesaRepository despesar = new DespesaRepository();    
    CategoriaRepository categoriar = new CategoriaRepository();       
    String sql = "";    
    Utilidade util = new Utilidade();

    /**
     * <p><strong>EN:</strong> Inserts a new installment (CartaoParcelamento) into the database.</p>
     *
     * <p><strong>IT:</strong> Inserisce una nuova rata (CartaoParcelamento) nel database.</p>
     *
     * <p><strong>PT-BR:</strong> Insere uma nova parcela (CartaoParcelamento) no banco de dados.</p>
     *
     * @param o EN: CartaoParcelamento object to insert | IT: Oggetto CartaoParcelamento da inserire | PT-BR: Objeto CartaoParcelamento a ser inserido
     * @throws SQLException EN: if a database error occurs | IT: se si verifica un errore di database | PT-BR: se ocorrer um erro de banco de dados
     * @since 1.0.0
     */
    public void inserirParcela(Object o) throws SQLException{
        CartaoParcelamento cp = (CartaoParcelamento) o;
            sql = "INSERT INTO cartaoparc (cd_parcela, dt_parcela, nm_parcelapag, cd_cartaolanc, ds_despesa, nm_valor, nm_parcela, dt_despesa, cd_despesa, cd_categoria, cd_cartao, cd_usuario)" +
                  "     VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cp.getCd_parcela());
            ps.setString(2, Utilidade.formatoData.format(cp.getDt_parcela().getTime()));
            ps.setInt(3, cp.getNm_parcelapag());
            ps.setInt(4, cp.getCd_cartaolanc());
            ps.setString(5, cp.getDs_despesa());
            ps.setBigDecimal(6, cp.getNm_valor());
            ps.setInt(7, cp.getNm_parcela());
            ps.setString(8, Utilidade.formatoData.format(cp.getDt_despesa().getTime()));
            ps.setInt(9, cp.getDespesa().getCd_despesa());
            ps.setInt(10, cp.getCategoria().getCd_Categoria());
            ps.setInt(11, cp.getCartao().getCd_cartao());
            ps.setInt(12, cp.getCd_usuario());
            ps.execute();
            ps.close();
    }
 
    /**
     * <p><strong>EN:</strong> Inserts a new installment (CartaoParcelamento) into the database and shows a confirmation dialog.</p>
     *
     * <p><strong>IT:</strong> Inserisce una nuova rata (CartaoParcelamento) nel database e mostra una finestra di conferma.</p>
     *
     * <p><strong>PT-BR:</strong> Insere uma nova parcela (CartaoParcelamento) no banco de dados e exibe uma mensagem de confirmação.</p>
     *
     * @param o EN: CartaoParcelamento object to insert | IT: Oggetto CartaoParcelamento da inserire | PT-BR: Objeto CartaoParcelamento a ser inserido
     * @since 1.0.0
     */
    @Override
    public void inserir(Object o) {
        CartaoParcelamento cp = (CartaoParcelamento) o;
        try{
            sql = "INSERT INTO cartaoparc (cd_parcela, dt_parcela, nm_parcelapag, cd_cartaolanc, ds_despesa, nm_valor, nm_parcela, dt_despesa, cd_despesa, cd_categoria, cd_cartao, cd_usuario)" +
                  "     VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cp.getCd_parcela());
            ps.setString(2, Utilidade.formatoData.format(cp.getDt_parcela().getTime()));
            ps.setInt(3, cp.getNm_parcelapag());
            ps.setInt(4, cp.getCd_cartaolanc());
            ps.setString(5, cp.getDs_despesa());
            ps.setBigDecimal(6, cp.getNm_valor());
            ps.setInt(7, cp.getNm_parcela());
            ps.setString(8, Utilidade.formatoData.format(cp.getDt_despesa().getTime()));
            ps.setInt(9, cp.getDespesa().getCd_despesa());
            ps.setInt(10, cp.getCategoria().getCd_Categoria());
            ps.setInt(11, cp.getCartao().getCd_cartao());
            ps.setInt(12, cp.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Cartão Parcelamento", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Cartão Parcelamento", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public void alterar(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void excluir(Object o) {
        
    }
    
    /**
     * <p><strong>EN:</strong> Deletes an installment (CartaoParcelamento) from the database by date, installment code, card, and user.</p>
     *
     * <p><strong>IT:</strong> Elimina una rata (CartaoParcelamento) dal database tramite data, codice rata, carta e utente.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui uma parcela (CartaoParcelamento) do banco de dados pela data, código da parcela, cartão e usuário.</p>
     *
     * @param o EN: CartaoParcelamento object with identifiers for deletion | IT: Oggetto CartaoParcelamento con identificatori per l'eliminazione | PT-BR: Objeto CartaoParcelamento com identificadores para exclusão
     * @since 1.0.0
     */    
    public void excluirParcelas(Object o){
        CartaoParcelamento cp = (CartaoParcelamento) o;
        try{
            sql = "DELETE FROM cartaoparc " +
                  " WHERE dt_parcela = ? " +
                  "   AND cd_parcela = ? " +
                  "   AND cd_cartao = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, Utilidade.formatoData.format(cp.getDt_parcela().getTime()));
            ps.setInt(2, cp.getCd_parcela());
            ps.setInt(3, cp.getCartao().getCd_cartao());
            ps.setInt(4, cp.getCd_usuario());
            ps.execute();
            ps.close();
            //JOptionPane.showMessageDialog(null, "Excluido.", "Cartão Parcelamento", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir parcela:\n" +
                    ex.getMessage(), "Cartão Parcelamento", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public ArrayList getLista() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * <p><strong>EN:</strong> Retrieves all installments (CartaoParcelamento) for the specified card and user, ordered by installment code and payment number.</p>
     *
     * <p><strong>IT:</strong> Recupera tutte le rate (CartaoParcelamento) per la carta e l'utente specificati, ordinate per codice rata e numero pagamento.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera todas as parcelas (CartaoParcelamento) para o cartão e usuário informados, ordenadas por código da parcela e número do pagamento.</p>
     *
     * @param cd_cartao EN: card identifier | IT: identificatore della carta | PT-BR: identificador do cartão
     * @return EN: list of CartaoParcelamento objects | IT: elenco di oggetti CartaoParcelamento | PT-BR: lista de objetos CartaoParcelamento
     * @since 1.0.0
     */    
    public ArrayList getLista(int cd_cartao) {
        ArrayList cartaop = new ArrayList();
        try{
            sql = "SELECT cd_parcela, to_char(dt_parcela,'dd/MM/yyyy'), nm_parcelapag, cd_cartaolanc, ds_despesa, nm_valor, nm_parcela, to_char(dt_despesa,'dd/MM/yyyy'), cd_despesa, cd_categoria, cd_cartao, cd_usuario" +
                  "  FROM cartaoparc" +
                  " WHERE cd_cartao = ? " +
                  "   AND cd_usuario = ?" +
                  " ORDER BY cd_parcela, nm_parcelapag";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_cartao);
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                CartaoParcelamento cp = new CartaoParcelamento(
                        rs.getInt("cd_parcela"),
                        util.recebeData(rs.getString("to_char(dt_parcela,'dd/MM/yyyy')")),
                        rs.getInt("nm_parcelapag"),
                        rs.getInt("cd_cartaolanc"),
                        rs.getString("ds_despesa"),
                        rs.getBigDecimal("nm_valor"),
                        rs.getInt("nm_parcela"),
                        util.recebeData(rs.getString("to_char(dt_despesa,'dd/MM/yyyy')")),
                        (Despesa)despesar.getById(rs.getInt("cd_despesa")),
                        (Categoria)categoriar.getById(rs.getInt("cd_categoria")),
                        (Cartao)cartaor.getById(rs.getInt("cd_cartao")),
                        rs.getInt("cd_usuario"));
                cartaop.add(cp);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Cartão Parcelamento:\n" +
                    ex.getMessage(), "Cartão Parcelamento", JOptionPane.ERROR_MESSAGE);
        }
        return cartaop;
    }

    //TESTANDO - COLOCAR COMENTARIO
    public ArrayList getLista(int cd_parcela, int cd_cartao) {
        ArrayList cartaop = new ArrayList();
        try{
            sql = "SELECT cd_parcela, to_char(dt_parcela,'dd/MM/yyyy'), nm_parcelapag, cd_cartaolanc, ds_despesa, nm_valor, nm_parcela, to_char(dt_despesa,'dd/MM/yyyy'), cd_despesa, cd_categoria, cd_cartao, cd_usuario" +
                  "  FROM cartaoparc" +
                  " WHERE cd_parcela = ? AND cd_cartao = ?" +
                  "   AND cd_usuario = ?" +
                  " ORDER BY cd_parcela, nm_parcelapag";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_parcela);
            ps.setInt(2, cd_cartao);
            ps.setInt(3, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                CartaoParcelamento cp = new CartaoParcelamento(
                        rs.getInt("cd_parcela"),
                        util.recebeData(rs.getString("to_char(dt_parcela,'dd/MM/yyyy')")),
                        rs.getInt("nm_parcelapag"),
                        rs.getInt("cd_cartaolanc"),
                        rs.getString("ds_despesa"),
                        rs.getBigDecimal("nm_valor"),
                        rs.getInt("nm_parcela"),
                        util.recebeData(rs.getString("to_char(dt_despesa,'dd/MM/yyyy')")),
                        (Despesa)despesar.getById(rs.getInt("cd_despesa")),
                        (Categoria)categoriar.getById(rs.getInt("cd_categoria")),
                        (Cartao)cartaor.getById(rs.getInt("cd_cartao")),
                        rs.getInt("cd_usuario"));
                cartaop.add(cp);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Cartão Parcelamento:\n" +
                    ex.getMessage(), "Cartão Parcelamento", JOptionPane.ERROR_MESSAGE);
        }
        return cartaop;
    }
        
    /*TESTANDO - COLOCAR COMENTARIO
    *LISTA DE PARCELAS POR GRUPO
    */
    public ArrayList<CartaoParcelamento> getListaParcela(int cd_cartao) {
        ArrayList<CartaoParcelamento> cartaop = new ArrayList();
        try{
            sql = "SELECT cd_parcela, ds_despesa" +
                  "  FROM cartaoparc" +
                  " WHERE cd_cartao = ? " +
                  "   AND cd_usuario = ?" +
                  " GROUP BY cd_parcela, ds_despesa" +  
                  " ORDER BY ds_despesa";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_cartao);
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                CartaoParcelamento cp = new CartaoParcelamento(
                        rs.getInt("cd_parcela"),
                        rs.getString("ds_despesa"));
                cartaop.add(cp);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista agrupada de Cartão Parcelamento:\n" +
                    ex.getMessage(), "Cartão Parcelamento", JOptionPane.ERROR_MESSAGE);
        }
        return cartaop;
    }
    
    /**
     * <p><strong>EN:</strong> Gets an installment (CartaoParcelamento) from the database by its ID.</p>
     *
     * <p><strong>IT:</strong> Recupera una rata (CartaoParcelamento) dal database tramite il suo ID.</p>
     *
     * <p><strong>PT-BR:</strong> Obtém uma parcela (CartaoParcelamento) do banco de dados pelo seu ID.</p>
     *
     * @param id EN: unique identifier of the installment | IT: identificatore univoco della rata | PT-BR: identificador único da parcela
     * @return EN: CartaoParcelamento object if found, otherwise null | IT: Oggetto CartaoParcelamento se trovato, altrimenti null | PT-BR: Objeto CartaoParcelamento se encontrado, caso contrário null
     * @since 1.0.0
     */
    @Override
    public Object getById(int id) {
        CartaoParcelamento cartaop = null;
        try{
            sql = "SELECT cd_parcela, to_char(dt_parcela,'dd/MM/yyyy'), nm_parcelapag, cd_cartaolanc, ds_despesa, nm_valor, nm_parcela, to_char(dt_despesa,'dd/MM/yyyy'), cd_despesa, cd_categoria, cd_cartao, cd_usuario" +
                  "  FROM cartaoparc" +
                  " WHERE cd_parcela = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                cartaop = new CartaoParcelamento(
                        rs.getInt("cd_parcela"),
                        util.recebeData(rs.getString("to_char(dt_parcela,'dd/MM/yyyy')")),
                        rs.getInt("nm_parcelapag"),
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
            JOptionPane.showMessageDialog(null, "Erro de getById em Cartão Parcelamento:\n" +
                    ex.getMessage(), "Cartão Parcelamento", JOptionPane.ERROR_MESSAGE);
        }
        return cartaop;
    }

    /**
     * <p><strong>EN:</strong> Retrieves the last installment (CartaoParcelamento) for the given user, ordered by installment code descending.</p>
     *
     * <p><strong>IT:</strong> Recupera l'ultima rata (CartaoParcelamento) per l'utente specificato, ordinata per codice rata decrescente.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera a última parcela (CartaoParcelamento) para o usuário informado, ordenada por código da parcela decrescente.</p>
     *
     * @param id EN: user identifier | IT: identificatore dell'utente | PT-BR: identificador do usuário
     * @return EN: last CartaoParcelamento object if found, otherwise null | IT: ultimo oggetto CartaoParcelamento se trovato, altrimenti null | PT-BR: último objeto CartaoParcelamento se encontrado, caso contrário null
     * @since 1.0.0
     */    
    public Object ultimoRegistro(int id) {
         CartaoParcelamento cartaop = null;
        try{
            sql = "SELECT cd_parcela, to_char(dt_parcela,'dd/MM/yyyy'), nm_parcelapag, cd_cartaolanc, ds_despesa, nm_valor, nm_parcela, to_char(dt_despesa,'dd/MM/yyyy'), cd_despesa, cd_categoria, cd_cartao, cd_usuario" +
                  "  FROM cartaoparc" +
                  " WHERE cd_usuario = ?" +
                  " ORDER BY cd_parcela DESC";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                cartaop = new CartaoParcelamento(
                        rs.getInt("cd_parcela"),
                        util.recebeData(rs.getString("to_char(dt_parcela,'dd/MM/yyyy')")),
                        rs.getInt("nm_parcelapag"),
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
            JOptionPane.showMessageDialog(null, "Erro de utimoRegistro em Cartão Parcelamento:\n" +
                    ex.getMessage(), "Cartão Parcelamento", JOptionPane.ERROR_MESSAGE);
        }
        return cartaop;
    }
}
