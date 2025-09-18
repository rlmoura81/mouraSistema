package br.com.rlmoura81.moura.catalogo;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EditoraRepository implements IPadraoRepository{

    String sql = "";

    /**
     * <p><strong>EN:</strong> Inserts a new publisher (Editora) into the database.</p>
     *
     * <p><strong>IT:</strong> Inserisce un nuovo editore (Editora) nel database.</p>
     *
     * <p><strong>PT-BR:</strong> Insere uma nova editora (Editora) no banco de dados.</p>
     *
     * @param o EN: Editora object to insert | IT: Oggetto Editora da inserire | PT-BR: Objeto Editora a ser inserido
     * @since 1.0.0
     */
    @Override
    public void inserir(Object o) {        
        Editora e = (Editora) o;        
        try {
            sql = "INSERT INTO editora (cd_editora, ds_nome, cd_usuario)" +
                  "     VALUES (sq_editora.nextval, ?, ?)";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, e.getDs_nome());
            ps.setInt(2, e.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Editora", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" + 
                    ex.getMessage(), "Editora", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Updates an existing publisher (Editora) with the provided data.</p>
     *
     * <p><strong>IT:</strong> Aggiorna un editore (Editora) esistente con i dati forniti.</p>
     *
     * <p><strong>PT-BR:</strong> Atualiza uma editora (Editora) existente com os dados informados.</p>
     *
     * @param o EN: Editora object with updated values | IT: Oggetto Editora con valori aggiornati | PT-BR: Objeto Editora com valores atualizados
     * @since 1.0.0
     */
    @Override
    public void alterar(Object o) {        
        Editora e = (Editora) o;        
        try{
            sql = "UPDATE editora " +
                  "   SET ds_nome = ?, " +
                  "       cd_usuario = ?" +
                  " WHERE cd_editora = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, e.getDs_nome());
            ps.setInt(2, e.getCd_usuario());
            ps.setInt(3, e.getCd_editora());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado.", "Editora", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" + 
                    ex.getMessage(), "Editora", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    /**
     * <p><strong>EN:</strong> Deletes a publisher (Editora) by its identifier.</p>
     *
     * <p><strong>IT:</strong> Elimina un editore (Editora) tramite il suo identificatore.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui uma editora (Editora) pelo seu identificador.</p>
     *
     * @param o EN: Editora object containing the ID to delete | IT: Oggetto Editora contenente l'ID da eliminare | PT-BR: Objeto Editora contendo o ID para exclusão
     * @since 1.0.0
     */
    @Override
    public void excluir(Object o) {        
        Editora e = (Editora) o;        
        try{
            sql = "DELETE FROM editora " +
                  " WHERE cd_editora = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, e.getCd_editora());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Editora", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" + 
                    ex.getMessage(), "Editora", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Retrieves all publishers (Editora), ordered by name.</p>
     *
     * <p><strong>IT:</strong> Recupera tutti gli editori (Editora), ordinati per nome.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera todas as editoras (Editora), ordenadas por nome.</p>
     *
     * @return EN: list of Editora objects | IT: elenco di oggetti Editora | PT-BR: lista de objetos Editora
     * @since 1.0.0
     */
    @Override
    public ArrayList getLista() {       
        ArrayList editoras = new ArrayList();        
        try{
            sql = "SELECT cd_editora, ds_nome, cd_usuario " +
                  "  FROM editora" +
                  " ORDER BY ds_nome";   
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Editora e = new Editora(
                rs.getInt("cd_editora"),
                rs.getString("ds_nome"),
                rs.getInt("cd_usuario"));
                editoras.add(e);
            }
            ps.close();
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de editoras:\n" + 
                    ex.getMessage(), "Editora", JOptionPane.ERROR_MESSAGE);
        }
        return editoras;
    }

    /**
     * <p><strong>EN:</strong> Gets a publisher (Editora) by its ID.</p>
     *
     * <p><strong>IT:</strong> Recupera un editore (Editora) tramite il suo ID.</p>
     *
     * <p><strong>PT-BR:</strong> Obtém uma editora (Editora) pelo seu ID.</p>
     *
     * @param id EN: unique identifier of the publisher | IT: identificatore univoco dell'editore | PT-BR: identificador único da editora
     * @return EN: Editora object if found, otherwise null | IT: Oggetto Editora se trovato, altrimenti null | PT-BR: Objeto Editora se encontrado, caso contrário null
     * @since 1.0.0
     */
    @Override
    public Object getById(int id) {        
        Editora e = null;        
        try {
            sql = "SELECT cd_editora, ds_nome, cd_usuario "+
                  "  FROM editora " +
                  " WHERE cd_editora = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                e = new Editora(
                    rs.getInt("cd_editora"),
                    rs.getString("ds_nome"),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em editora:\n" +
                    ex.getMessage(), "Editora", JOptionPane.ERROR_MESSAGE);
        } 
        return e;    
    }
}
