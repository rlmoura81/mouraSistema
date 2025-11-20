package br.com.rlmoura81.moura.principalcadastro;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CategoriaRepository {
    
    String sql = "";    
    GrupoRepository grupor = new GrupoRepository();
    
    /**
     * <p><strong>EN:</strong> Inserts a new Category into the database.
     * Uses a sequence for the primary key and binds name, group, and user fields; shows a success/error dialog.</p>
     *
     * <p><strong>IT:</strong> Inserisce una nuova Categoria nel database.
     * Usa una sequenza per la chiave primaria e associa nome, gruppo e utente; mostra un dialogo di successo/errore.</p>
     *
     * <p><strong>PT-BR:</strong> Insere uma nova Categoria no banco de dados.
     * Utiliza uma sequência para a chave primária e vincula nome, grupo e usuário; exibe diálogo de sucesso/erro.</p>
     */
    public void inserir(Object o){
        Categoria c = (Categoria) o;
        try{
            sql = "INSERT INTO categoria (cd_categoria, ds_categoria, cd_grupo, cd_usuario) " +
                  "     VALUES (sq_categoria.nextval, ?, ?, ?)";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, c.getDs_Categoria());
            ps.setInt(2, c.getGrupo().getCd_grupo());
            ps.setInt(3, c.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Categoria", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao inserir:\n" +
                    ex.getMessage(), "Categoria", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * <p><strong>EN:</strong> Updates an existing Category by ID and user.
     * Sets the category name and group; confirms with a dialog or shows an error on failure.</p>
     *
     * <p><strong>IT:</strong> Aggiorna una Categoria esistente per ID e utente.
     * Imposta nome e gruppo della categoria; conferma con un dialogo o mostra un errore in caso di fallimento.</p>
     *
     * <p><strong>PT-BR:</strong> Altera uma Categoria existente por ID e usuário.
     * Define o nome e o grupo; confirma com um diálogo ou exibe erro em caso de falha.</p>
     */
    public void aterar(Object o){
        Categoria c = (Categoria) o;
        try{
            sql = "UPDATE categoria " +
                  "   SET ds_categoria = ?, " +
                  "       cd_grupo = ?" +
                  " WHERE cd_categoria = ? " +
                  "   AND cd_usuario = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, c.getDs_Categoria());
            ps.setInt(2, c.getGrupo().getCd_grupo());
            ps.setInt(3, c.getCd_Categoria());
            ps.setInt(4, c.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado", "Categoria", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Categoria", JOptionPane.ERROR_MESSAGE);
        }    
    }
    
    /**
     * <p><strong>EN:</strong> Deletes a Category by ID for the given user.
     * Executes a parameterized DELETE and shows a success/error dialog.</p>
     *
     * <p><strong>IT:</strong> Elimina una Categoria per ID dell’utente indicato.
     * Esegue un DELETE parametrizzato e mostra un dialogo di successo/errore.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui uma Categoria pelo ID do usuário informado.
     * Executa um DELETE parametrizado e exibe diálogo de sucesso/erro.</p>
     */
    public void excluir(Object o){
        Categoria c = (Categoria) o;
        try{
            sql = "DELETE FROM categoria " +
                  " WHERE cd_categoria = ? " +
                  "   AND cd_usuario = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, c.getCd_Categoria());
            ps.setInt(2, c.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido", "Categoria", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Categoria", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    /**
     * <p><strong>EN:</strong> Retrieves all Categories for the logged-in user.
     * Returns a list ordered by category name, mapping each row to a Category object with its Group.</p>
     *
     * <p><strong>IT:</strong> Recupera tutte le Categorie per l’utente loggato.
     * Restituisce un elenco ordinato per nome, mappando ogni riga in un oggetto Categoria con il suo Gruppo.</p>
     *
     * <p><strong>PT-BR:</strong> Busca todas as Categorias do usuário logado.
     * Retorna uma lista ordenada por nome, mapeando cada linha para um objeto Categoria com seu Grupo.</p>
     */
    public ArrayList<Categoria> getLista(){        
        ArrayList<Categoria> categoria = new ArrayList();        
        try{
            sql = "SELECT cd_categoria, ds_categoria, cd_grupo, cd_usuario " +
                  "  FROM categoria " +
                  " WHERE cd_usuario = ?" +
                  " ORDER BY ds_categoria";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while (rs.next()){
                Categoria c = new Categoria(
                        rs.getInt("cd_categoria"),
                        rs.getString("ds_categoria"),
                        (Grupo)grupor.getById(rs.getInt("cd_grupo")),
                        rs.getInt("cd_usuario"));
                categoria.add(c);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de categorias:\n" +
                    ex.getMessage(), "Categoria", JOptionPane.ERROR_MESSAGE);
        }
        return categoria;
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves a single Category by its ID.
     * Loads fields (name, group, user) and returns a populated Category or <code>null</code> if not found.</p>
     *
     * <p><strong>IT:</strong> Recupera una singola Categoria tramite ID.
     * Carica i campi (nome, gruppo, utente) e restituisce una Categoria popolata o <code>null</code> se non trovata.</p>
     *
     * <p><strong>PT-BR:</strong> Obtém uma Categoria pelo seu ID.
     * Carrega os campos (nome, grupo, usuário) e retorna a Categoria preenchida ou <code>null</code> se não encontrada.</p>
     */
    public Object getById(int id){
        Categoria c = null;
        try {
            sql = "SELECT cd_categoria, ds_categoria, cd_grupo, cd_usuario"
                + "  FROM categoria"
                + " WHERE cd_categoria = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                c = new Categoria(
                        rs.getInt("cd_categoria"),
                        rs.getString("ds_categoria"),
                        (Grupo)grupor.getById(rs.getInt("cd_grupo")),
                        rs.getInt("cd_usuario"));
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Categoria.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro de getById em categoria:\n" +
                    ex.getMessage(), "Categoria", JOptionPane.ERROR_MESSAGE);
        }
        return c;
    }
}
