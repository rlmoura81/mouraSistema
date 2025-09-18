package br.com.rlmoura81.moura.animal;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProdutoRepository implements IPadraoRepository{

    String sql = "";
    
    /**
     * <p><strong>EN:</strong> Inserts a product (Produto) into the database.</p>
     *
     * <p><strong>IT:</strong> Inserisce un prodotto (Produto) nel database.</p>
     *
     * <p><strong>PT-BR:</strong> Insere um produto (Produto) no banco de dados.</p>
     *
     * @param o EN: Product object to insert | IT: Oggetto Product da inserire | PT-BR: Objeto Produto a ser inserido
     * @since 1.0.0
     */
    @Override
    public void inserir(Object o) {
        Produto p = (Produto) o;
        try{
            sql = "INSERT INTO produto (cd_produto, ds_produto, nm_peso, cd_usuario)" +
                  "     VALUES (sq_produto.nextval, ?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, p.getDs_produto());
            ps.setBigDecimal(2, p.getNm_peso());
            ps.setInt(3, p.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Produto", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Produto", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Updates an existing product (Produto) in the database.</p>
     *
     * <p><strong>IT:</strong> Aggiorna un prodotto (Produto) esistente nel database.</p>
     *
     * <p><strong>PT-BR:</strong> Atualiza um produto (Produto) existente no banco de dados.</p>
     *
     * @param o EN: Product object with updated values | IT: Oggetto Product con valori aggiornati | PT-BR: Objeto Produto com valores atualizados
     * @since 1.0.0
     */
    @Override
    public void alterar(Object o) {
        Produto p = (Produto) o;
        try{
            sql = "UPDATE produto " +
                  "   SET ds_produto = ?, " +
                  "       nm_peso = ?, " +
                  "       cd_usuario = ?" +
                  " WHERE cd_produto = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, p.getDs_produto());
            ps.setBigDecimal(2, p.getNm_peso());
            ps.setInt(3, p.getCd_usuario());
            ps.setInt(4, p.getCd_produto());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado.", "Produto", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Produto", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Deletes a product (Produto) from the database by its ID.</p>
     *
     * <p><strong>IT:</strong> Elimina un prodotto (Produto) dal database tramite il suo ID.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui um produto (Produto) do banco de dados pelo seu ID.</p>
     *
     * @param o EN: Product object containing the identifier for deletion | IT: Oggetto Product contenente l'identificatore da eliminare | PT-BR: Objeto Produto contendo o identificador para exclusão
     * @since 1.0.0
     */
    @Override
    public void excluir(Object o) {
        Produto p = (Produto) o;
        try{
            sql = "DELETE FROM produto " +
                  " WHERE cd_produto = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, p.getCd_produto());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Produto", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Produto", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Retrieves the list of all products from the database, ordered by name.</p>
     *
     * <p><strong>IT:</strong> Recupera l'elenco di tutti i prodotti dal database, ordinati per nome.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera a lista de todos os produtos do banco de dados, ordenados por nome.</p>
     *
     * @return EN: list of Product objects | IT: Elenco di oggetti Product | PT-BR: Lista de objetos Produto
     * @since 1.0.0
     */
    @Override
    public ArrayList getLista() {
        ArrayList produto = new ArrayList();
        try{
            sql = "SELECT cd_produto, ds_produto, nm_peso, cd_usuario" +
                  "  FROM produto" +
                  "  ORDER BY ds_produto";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Produto p = new Produto(
                    rs.getInt("cd_produto"),
                    rs.getString("ds_produto"),
                    rs.getBigDecimal("nm_peso"),
                    rs.getInt("cd_usuario"));
                produto.add(p);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de produtos:\n" +
                    ex.getMessage(), "Produto", JOptionPane.ERROR_MESSAGE);
        }
        return produto;
    }

    /**
     * <p><strong>EN:</strong> Gets a product (Produto) from the database by its ID.</p>
     *
     * <p><strong>IT:</strong> Recupera un prodotto (Produto) dal database tramite il suo ID.</p>
     *
     * <p><strong>PT-BR:</strong> Obtém um produto (Produto) do banco de dados pelo seu ID.</p>
     *
     * @param id EN: unique identifier of the product | IT: Identificatore univoco del prodotto | PT-BR: Identificador único do produto
     * @return EN: Product object if found, otherwise null | IT: Oggetto Product se trovato, altrimenti null | PT-BR: Objeto Produto se encontrado, caso contrário null
     * @since 1.0.0
     */
    @Override
    public Object getById(int id) {
        Produto produto = null;
        try{
            sql = "SELECT cd_produto, ds_produto, nm_peso, cd_usuario" +
                  "  FROM produto" +
                  "  WHERE cd_produto = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                produto = new Produto(
                    rs.getInt("cd_produto"),
                    rs.getString("ds_produto"),
                    rs.getBigDecimal("nm_peso"),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em produto:\n" +
                    ex.getMessage(), "Produto", JOptionPane.ERROR_MESSAGE);
        }
        return produto;
    }
}
