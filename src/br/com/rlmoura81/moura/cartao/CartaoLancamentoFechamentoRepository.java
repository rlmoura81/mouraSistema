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
import java.util.Calendar;
import javax.swing.JOptionPane;

public class CartaoLancamentoFechamentoRepository implements IPadraoRepository{
    
    String sql = "";    
    CartaoRepository cartaor = new CartaoRepository();    
    DespesaRepository despesar = new DespesaRepository();    
    CategoriaRepository categoriar = new CategoriaRepository();
    Utilidade util = new Utilidade();

    /**
     * <p><strong>EN:</strong> Inserts a card closing (CartaoLancamentoFechamento) by copying records from open transactions (cartaolanc) for a given card and user.</p>
     *
     * <p><strong>IT:</strong> Inserisce una chiusura di carta (CartaoLancamentoFechamento) copiando i record dalle transazioni aperte (cartaolanc) per una determinata carta e utente.</p>
     *
     * <p><strong>PT-BR:</strong> Insere um fechamento de cartão (CartaoLancamentoFechamento) copiando os registros de lançamentos abertos (cartaolanc) para um determinado cartão e usuário.</p>
     *
     * @param o EN: CartaoLancamentoFechamento object | IT: Oggetto CartaoLancamentoFechamento | PT-BR: Objeto CartaoLancamentoFechamento
     * @since 1.0.0
     */
    @Override
    public void inserir(Object o) {
        CartaoLancamentoFechamento clf = (CartaoLancamentoFechamento) o;
        try{
            sql = "INSERT INTO cartaolancf (cd_cartaolanc, ds_despesa, nm_valor, nm_parcela, dt_despesa, cd_despesa, cd_categoria, cd_cartao, cd_usuario)" +
                  "    (SELECT cartaolanc.cd_cartaolanc, cartaolanc.ds_despesa, cartaolanc.nm_valor, cartaolanc.nm_parcela, cartaolanc.dt_despesa, cartaolanc.cd_despesa, cartaolanc.cd_categoria, cartaolanc.cd_cartao, cartaolanc.cd_usuario\n" +
                  "       FROM cartaolanc " +
                  "      WHERE cd_cartao = ? " +
                  "        AND cd_usuario = ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, clf.getCartao().getCd_cartao());
            ps.setInt(2, clf.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Fatura fechada.", "Cartão Lançamento Fechamento", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro a fechar a fatura:\n" +
                    ex.getMessage(), "Cartão Lançamento Fechamento", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Inserts a card closing (CartaoLancamentoFechamento) without showing messages.  
     * Same logic as inserir(Object o), but exceptions are propagated.</p>
     *
     * <p><strong>IT:</strong> Inserisce una chiusura di carta (CartaoLancamentoFechamento) senza mostrare messaggi.  
     * Stessa logica di inserir(Object o), ma le eccezioni vengono propagate.</p>
     *
     * <p><strong>PT-BR:</strong> Insere um fechamento de cartão (CartaoLancamentoFechamento) sem exibir mensagens.  
     * Mesma lógica do inserir(Object o), mas as exceções são propagadas.</p>
     *
     * @param o EN: CartaoLancamentoFechamento object | IT: Oggetto CartaoLancamentoFechamento | PT-BR: Objeto CartaoLancamentoFechamento
     * @throws SQLException EN: if a database error occurs | IT: se si verifica un errore di database | PT-BR: se ocorrer um erro de banco de dados
     * @since 1.0.0
     */    
    public void inserirFechamento(Object o) throws SQLException{
        CartaoLancamentoFechamento clf = (CartaoLancamentoFechamento) o;
            sql = "INSERT INTO cartaolancf (cd_cartaolanc, ds_despesa, nm_valor, nm_parcela, dt_despesa, cd_despesa, cd_categoria, cd_cartao, cd_usuario)" +
                  "    (SELECT cartaolanc.cd_cartaolanc, cartaolanc.ds_despesa, cartaolanc.nm_valor, cartaolanc.nm_parcela, cartaolanc.dt_despesa, cartaolanc.cd_despesa, cartaolanc.cd_categoria, cartaolanc.cd_cartao, cartaolanc.cd_usuario\n" +
                  "       FROM cartaolanc " +
                  "      WHERE cd_cartao = ? " +
                  "        AND cd_usuario = ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, clf.getCartao().getCd_cartao());
            ps.setInt(2, clf.getCd_usuario());
            ps.execute();
            ps.close();
    }
    
    /**
     * EM TESTE - COLOCAR COMENTARIO
     * INSERIR FECHAMENTO STATUS PAGAMENTO
     */

    public void inserirFechamentoSt(Object o) throws SQLException{
        CartaoLancamentoFechamento clf = (CartaoLancamentoFechamento) o;
            sql = "INSERT INTO cartaofechst (cd_cartaolancf, dt_fechamento, st_pagamento, cd_cartao, cd_usuario)" +
                  "       VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, clf.getCd_cartaolancf());
            ps.setString(2, Utilidade.formatoData.format(clf.getDt_fechamento().getTime()));
            ps.setInt(3, clf.getSt_pagamento());
            ps.setInt(4, clf.getCartao().getCd_cartao());
            ps.setInt(5, clf.getCd_usuario());
            ps.execute();
            ps.close();
    }
    
    /**
     * <p><strong>EN:</strong> Updates a card closing (CartaoLancamentoFechamento), setting the closing ID and date for the selected card and user.</p>
     *
     * <p><strong>IT:</strong> Aggiorna una chiusura di carta (CartaoLancamentoFechamento), impostando ID e data di chiusura per la carta e l'utente selezionati.</p>
     *
     * <p><strong>PT-BR:</strong> Atualiza um fechamento de cartão (CartaoLancamentoFechamento), definindo o ID e a data de fechamento para o cartão e usuário selecionados.</p>
     *
     * @param o EN: CartaoLancamentoFechamento object | IT: Oggetto CartaoLancamentoFechamento | PT-BR: Objeto CartaoLancamentoFechamento
     * @since 1.0.0
     */    
    @Override
    public void alterar(Object o) {
        CartaoLancamentoFechamento clf = (CartaoLancamentoFechamento) o;
        try{
            sql = "UPDATE cartaolancf " +
                  "   SET cd_cartaolancf = ?, " +
                  "       dt_fechamento = ?" +
                  " WHERE cd_cartaolancf is null " +
                  "   AND cd_cartao = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, clf.getCd_cartaolancf());
            ps.setString(2, Utilidade.formatoData.format(clf.getDt_fechamento().getTime()));
            ps.setInt(3, clf.getCartao().getCd_cartao());
            ps.setInt(4, clf.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Fatura alterada.", "Cartão Lançamento Fechamento", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Cartão Lançamento Fechamento", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Updates a card closing (CartaoLancamentoFechamento) without showing messages.  
     * Same logic as alterar(Object o), but exceptions are propagated.</p>
     *
     * <p><strong>IT:</strong> Aggiorna una chiusura di carta (CartaoLancamentoFechamento) senza mostrare messaggi.  
     * Stessa logica di alterar(Object o), ma le eccezioni vengono propagate.</p>
     *
     * <p><strong>PT-BR:</strong> Atualiza um fechamento de cartão (CartaoLancamentoFechamento) sem exibir mensagens.  
     * Mesma lógica do alterar(Object o), mas as exceções são propagadas.</p>
     *
     * @param o EN: CartaoLancamentoFechamento object | IT: Oggetto CartaoLancamentoFechamento | PT-BR: Objeto CartaoLancamentoFechamento
     * @throws SQLException EN: if a database error occurs | IT: se si verifica un errore di database | PT-BR: se ocorrer um erro de banco de dados
     * @since 1.0.0
     */    
    public void alterarFechamento(Object o) throws SQLException{
        CartaoLancamentoFechamento clf = (CartaoLancamentoFechamento) o;
            sql = "UPDATE cartaolancf " +
                  "   SET cd_cartaolancf = ?, " +
                  "       dt_fechamento = ?" +
                  " WHERE cd_cartaolancf is null " +
                  "   AND cd_cartao = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, clf.getCd_cartaolancf());
            ps.setString(2, Utilidade.formatoData.format(clf.getDt_fechamento().getTime()));
            ps.setInt(3, clf.getCartao().getCd_cartao());
            ps.setInt(4, clf.getCd_usuario());
            ps.execute();
            ps.close();
    }    

    /*
    *EM TESTE - COLOCAR COMENTARIO
    *ALTERA STATUS DO PAGAMENTO
    */    
    public void alterarStPagamento(Object o) {
        CartaoLancamentoFechamento clf = (CartaoLancamentoFechamento) o;
        System.out.println(clf);
        try{
            sql = "UPDATE cartaofechst " +
                  "   SET st_pagamento = 1 " +
                  " WHERE cd_cartaolancf = ? " +
                  "   AND cd_cartao = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, clf.getCd_cartaolancf());
            ps.setInt(2, clf.getCartao().getCd_cartao());
            ps.setInt(3, clf.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Fatura paga.", "Cartão Lançamento Fechamento", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao pagar:\n" +
                    ex.getMessage(), "Cartão Lançamento Fechamento", JOptionPane.ERROR_MESSAGE);
        }
    }
        
    /**
     * <p><strong>EN:</strong> Deletes all card transactions (CartaoLancamento) for the given card and user.</p>
     *
     * <p><strong>IT:</strong> Elimina tutte le transazioni di carta (CartaoLancamento) per la carta e l'utente indicati.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui todos os lançamentos de cartão (CartaoLancamento) para o cartão e usuário informados.</p>
     *
     * @param o EN: CartaoLancamento object | IT: Oggetto CartaoLancamento | PT-BR: Objeto CartaoLancamento
     * @since 1.0.0
     */
    @Override
    public void excluir(Object o) {
        CartaoLancamento cl = (CartaoLancamento) o;
        try{
            sql = "DELETE FROM cartaolanc" +
                  " WHERE cd_cartao = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cl.getCartao().getCd_cartao());
            ps.setInt(2, cl.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido", "Cartão Lançamento Fechamento", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Cartão Lançamento Fechamento", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Deletes all card transactions (CartaoLancamento) for the given card and user without showing messages.  
     * Exceptions are propagated.</p>
     *
     * <p><strong>IT:</strong> Elimina tutte le transazioni di carta (CartaoLancamento) per la carta e l'utente indicati senza mostrare messaggi.  
     * Le eccezioni vengono propagate.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui todos os lançamentos de cartão (CartaoLancamento) para o cartão e usuário informados sem exibir mensagens.  
     * As exceções são propagadas.</p>
     *
     * @param o EN: CartaoLancamento object | IT: Oggetto CartaoLancamento | PT-BR: Objeto CartaoLancamento
     * @throws SQLException EN: if a database error occurs | IT: se si verifica un errore di database | PT-BR: se ocorrer um erro de banco de dados
     * @since 1.0.0
     */    
    public void excluirFechamento(Object o) throws SQLException{
        CartaoLancamento cl = (CartaoLancamento) o;
            sql = "DELETE FROM cartaolanc" +
                  " WHERE cd_cartao = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cl.getCartao().getCd_cartao());
            ps.setInt(2, cl.getCd_usuario());
            ps.execute();
            ps.close();
    }    

    /**
     * <p><strong>EN:</strong> Retrieves all card closing records (CartaoLancamentoFechamento) for the logged-in user.</p>
     *
     * <p><strong>IT:</strong> Recupera tutti i record di chiusura carta (CartaoLancamentoFechamento) per l'utente connesso.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera todos os registros de fechamento de cartão (CartaoLancamentoFechamento) para o usuário logado.</p>
     *
     * @return EN: list of CartaoLancamentoFechamento objects | IT: elenco di oggetti CartaoLancamentoFechamento | PT-BR: lista de objetos CartaoLancamentoFechamento
     * @since 1.0.0
     */
    @Override
    public ArrayList getLista() {
        ArrayList clancf = new ArrayList();
        try{
            sql = "SELECT cd_cartaolancf, to_char(dt_fechamento,'dd/MM/yyyy'), cd_cartaolanc, ds_despesa, nm_valor, nm_parcela, to_char(dt_despesa,'dd/MM/yyyy'), cd_despesa, cd_categoria, cd_cartao, cd_usuario" +
                  "  FROM cartaolancf" +
                  " WHERE cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                CartaoLancamentoFechamento clf = new CartaoLancamentoFechamento(
                        rs.getInt("cd_cartaolancf"),
                        util.recebeData(rs.getString("to_char(dt_fechamento,'dd/MM/yyyy')")),
                        rs.getInt("cd_cartaolanc"),
                        rs.getString("ds_despesa"),
                        rs.getBigDecimal("nm_valor"),
                        rs.getInt("nm_parcela"),
                        util.recebeData(rs.getString("to_char(dt_despesa,'dd/MM/yyyy')")),
                        (Despesa)despesar.getById(rs.getInt("cd_despesa")),
                        (Categoria)categoriar.getById(rs.getInt("cd_categoria")),
                        (Cartao)cartaor.getById(rs.getInt("cd_cartao")),
                        rs.getInt("cd_usuario"));
                clancf.add(clf);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Cartão Lançamentos Fechamento:\n" +
                   ex.getMessage(), "Cartão Lançamento Fechamento", JOptionPane.ERROR_MESSAGE);
        }
        return clancf;
    }

    /**
     * <p><strong>EN:</strong> Retrieves all card closing records (CartaoLancamentoFechamento) for a given date, card, and user.</p>
     *
     * <p><strong>IT:</strong> Recupera tutti i record di chiusura carta (CartaoLancamentoFechamento) per una data, carta e utente specifici.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera todos os registros de fechamento de cartão (CartaoLancamentoFechamento) para uma data, cartão e usuário específicos.</p>
     *
     * @param data EN: closing date to filter | IT: data di chiusura per filtrare | PT-BR: data de fechamento para filtrar
     * @param cd_cartao EN: card identifier | IT: identificatore della carta | PT-BR: identificador do cartão
     * @return EN: list of CartaoLancamentoFechamento objects | IT: elenco di oggetti CartaoLancamentoFechamento | PT-BR: lista de objetos CartaoLancamentoFechamento
     * @since 1.0.0
     */
    public ArrayList getLista(Calendar data, int cd_cartao) {
        ArrayList clancf = new ArrayList();
        try{
            sql = "SELECT cd_cartaolancf, to_char(dt_fechamento,'dd/MM/yyyy'), cd_cartaolanc, ds_despesa, nm_valor, nm_parcela, to_char(dt_despesa,'dd/MM/yyyy'), cd_despesa, cd_categoria, cd_cartao, cd_usuario" +
                  "  FROM cartaolancf" +
                  " WHERE dt_fechamento = ? " +
                  "   AND cd_cartao = ? " +
                  "   AND cd_usuario = ?" +
                  " ORDER BY dt_despesa, ds_despesa";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, Utilidade.formatoData.format(data.getTime()));
            ps.setInt(2, cd_cartao);
            ps.setInt(3, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                CartaoLancamentoFechamento clf = new CartaoLancamentoFechamento(
                        rs.getInt("cd_cartaolancf"),
                        util.recebeData(rs.getString("to_char(dt_fechamento,'dd/MM/yyyy')")),
                        rs.getInt("cd_cartaolanc"),
                        rs.getString("ds_despesa"),
                        rs.getBigDecimal("nm_valor"),
                        rs.getInt("nm_parcela"),
                        util.recebeData(rs.getString("to_char(dt_despesa,'dd/MM/yyyy')")),
                        (Despesa)despesar.getById(rs.getInt("cd_despesa")),
                        (Categoria)categoriar.getById(rs.getInt("cd_categoria")),
                        (Cartao)cartaor.getById(rs.getInt("cd_cartao")),
                        rs.getInt("cd_usuario"));
                clancf.add(clf);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Cartão Lançamentos Fechamento:\n" +
                    ex.getMessage(), "Cartão Lançamento Fechamento", JOptionPane.ERROR_MESSAGE);
        }
        return clancf;
    }

    /**
     * <p><strong>EN:</strong> Retrieves grouped closing records for a given card and user, counting the number of closings per date.</p>
     *
     * <p><strong>IT:</strong> Recupera i record di chiusura raggruppati per una determinata carta e utente, contando il numero di chiusure per data.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera os registros de fechamento agrupados para um determinado cartão e usuário, contando o número de fechamentos por data.</p>
     *
     * @param cd_cartao EN: card identifier | IT: identificatore della carta | PT-BR: identificador do cartão
     * @return EN: list of CartaoLancamentoFechamento objects with count and date | IT: elenco di oggetti CartaoLancamentoFechamento con conteggio e data | PT-BR: lista de objetos CartaoLancamentoFechamento com quantidade e data
     * @since 1.0.0
     */    
    public ArrayList getListaFechamento(int cd_cartao) {
        ArrayList clancf = new ArrayList();
        try{
            sql = "SELECT COUNT(cd_cartaolancf), to_char(dt_fechamento,'dd/MM/yyyy')" +
                  "  FROM cartaolancf" +
                  " WHERE cd_cartao = ? " +
                  "   AND cd_usuario = ?" +
                  " GROUP BY dt_fechamento" +
                  " ORDER BY dt_fechamento DESC";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_cartao);
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                CartaoLancamentoFechamento clf = new CartaoLancamentoFechamento(
                        rs.getInt("COUNT(cd_cartaolancf)"),
                        util.recebeData(rs.getString("to_char(dt_fechamento,'dd/MM/yyyy')")));
                clancf.add(clf);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Faturas Fechadas:\n" +
                    ex.getMessage(), "Cartão Lançamento Fechamento", JOptionPane.ERROR_MESSAGE);
        }
        return clancf;
    }
    
    /**
     * EM TESTE - COLOCAR COMENTARIO
     * LISTA DO STATUS DO FECHAMENTO
     */    
    public ArrayList<CartaoLancamentoFechamento> getListaStFechamento(int cd_cartao, int st_pagamento) {
        ArrayList<CartaoLancamentoFechamento> clancf = new ArrayList<>();
        try{
            sql = "SELECT cd_cartaolancf, to_char(dt_fechamento,'dd/MM/yyyy') AS dt_stpagamento, st_pagamento, cd_cartao, cd_usuario" +
                  "  FROM cartaofechst" +
                  " WHERE st_pagamento = ?" +
                  "   AND cd_cartao = ? " +
                  "   AND cd_usuario = ?" +
                  " ORDER BY dt_fechamento DESC";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, st_pagamento);
            ps.setInt(2, cd_cartao);
            ps.setInt(3, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                CartaoLancamentoFechamento clf = new CartaoLancamentoFechamento(
                        rs.getInt("cd_cartaolancf"),
                        util.recebeData(rs.getString("dt_stpagamento")),
                        rs.getInt("st_pagamento"),
                        (Cartao)cartaor.getById(rs.getInt("cd_cartao")),
                        rs.getInt("cd_usuario"));
                clancf.add(clf);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Faturas Fechadas de Status de Pagamento:\n" +
                    ex.getMessage(), "Cartão Lançamento Fechamento", JOptionPane.ERROR_MESSAGE);
        }
        return clancf;
    }

    /**
     * <p><strong>EN:</strong> Gets a card closing (CartaoLancamentoFechamento) by its ID.</p>
     *
     * <p><strong>IT:</strong> Recupera una chiusura di carta (CartaoLancamentoFechamento) tramite il suo ID.</p>
     *
     * <p><strong>PT-BR:</strong> Obtém um fechamento de cartão (CartaoLancamentoFechamento) pelo seu ID.</p>
     *
     * @param id EN: unique identifier of the closing | IT: identificatore univoco della chiusura | PT-BR: identificador único do fechamento
     * @return EN: CartaoLancamentoFechamento object if found, otherwise null | IT: Oggetto CartaoLancamentoFechamento se trovato, altrimenti null | PT-BR: Objeto CartaoLancamentoFechamento se encontrado, caso contrário null
     * @since 1.0.0
     */
    @Override
    public Object getById(int id) {
        CartaoLancamentoFechamento clancf = null;
        try{
            sql = "SELECT cd_cartaolancf, to_char(dt_fechamento,'dd/MM/yyyy'), cd_cartaolanc, ds_despesa, nm_valor, nm_parcela, to_char(dt_despesa,'dd/MM/yyyy'), cd_despesa, cd_categoria, cd_cartao, cd_usuario" +
                  "  FROM cartaolancf" +
                  " WHERE cd_cartaolancf = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                clancf = new CartaoLancamentoFechamento(
                        rs.getInt("cd_cartaolancf"),
                        util.recebeData(rs.getString("to_char(dt_fechamento,'dd/MM/yyyy')")),
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
            JOptionPane.showMessageDialog(null, "Erro de getById em Cartão Lançamentos Fechamento:\n" +
                    ex.getMessage(), "Cartão Lançamento Fechamento", JOptionPane.ERROR_MESSAGE);
        }
        return clancf;
    }

    /**
     * <p><strong>EN:</strong> Retrieves the last card closing (CartaoLancamentoFechamento) for a given user, ordered by ID descending.</p>
     *
     * <p><strong>IT:</strong> Recupera l'ultima chiusura di carta (CartaoLancamentoFechamento) per un determinato utente, ordinata per ID decrescente.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera o último fechamento de cartão (CartaoLancamentoFechamento) para um determinado usuário, ordenado por ID decrescente.</p>
     *
     * @param cd_usuario EN: user identifier | IT: identificatore dell'utente | PT-BR: identificador do usuário
     * @return EN: last CartaoLancamentoFechamento object if found, otherwise null | IT: ultimo oggetto CartaoLancamentoFechamento se trovato, altrimenti null | PT-BR: último objeto CartaoLancamentoFechamento se encontrado, caso contrário null
     * @since 1.0.0
     */    
    public Object ultimoRegistro(int cd_usuario) {
        CartaoLancamentoFechamento clancf = null;
        try{
            sql = "SELECT cd_cartaolancf, to_char(dt_fechamento,'dd/MM/yyyy'), cd_cartaolanc, ds_despesa, nm_valor, nm_parcela, to_char(dt_despesa,'dd/MM/yyyy'), cd_despesa, cd_categoria, cd_cartao, cd_usuario" +
                  "  FROM cartaolancf" +
                  " WHERE cd_usuario = ?" +
                  " ORDER BY cd_cartaolancf DESC";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_usuario);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                clancf = new CartaoLancamentoFechamento(
                        rs.getInt("cd_cartaolancf"),
                        util.recebeData(rs.getString("to_char(dt_fechamento,'dd/MM/yyyy')")),
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
            JOptionPane.showMessageDialog(null, "Erro de ultimoRegistro em Cartão Lançamentos Fechamento:\n" +
                    ex.getMessage(), "Cartão Lançamento Fechamento", JOptionPane.ERROR_MESSAGE);
        }
        return clancf;
    } 

}
