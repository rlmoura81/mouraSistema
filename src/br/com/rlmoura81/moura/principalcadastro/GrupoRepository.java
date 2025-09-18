package br.com.rlmoura81.moura.principalcadastro;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class GrupoRepository{

    String sql = "";
    
    /**
     * <p><strong>EN:</strong> Inserts a new Group into the database.
     * Uses the sequence <code>sq_grupo</code> to generate the identifier.</p>
     *
     * <p><strong>IT:</strong> Inserisce un nuovo Gruppo nel database.
     * Utilizza la sequenza <code>sq_grupo</code> per generare l’identificativo.</p>
     *
     * <p><strong>PT-BR:</strong> Insere um novo Grupo no banco de dados.
     * Usa a sequência <code>sq_grupo</code> para gerar o identificador.</p>
     */
    public void inserir(Object o){
        Grupo g = (Grupo) o;
        try{
            sql = "INSERT INTO grupo (cd_grupo, ds_grupo, cd_usuario) " +
                  "     VALUES (sq_grupo.nextval, ?, ?)";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, g.getDs_grupo());
            ps.setInt(2, g.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Grupo", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Grupo", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * <p><strong>EN:</strong> Updates an existing Group’s data in the database
     * (name and user reference).</p>
     *
     * <p><strong>IT:</strong> Aggiorna i dati di un Gruppo esistente nel database
     * (nome e riferimento utente).</p>
     *
     * <p><strong>PT-BR:</strong> Atualiza os dados de um Grupo existente no banco de dados
     * (nome e referência do usuário).</p>
     */
    public void aterar(Object o){
        Grupo g = (Grupo) o;
        try{
            sql = "UPDATE grupo " +
                  "   SET ds_grupo = ? " +
                  " WHERE cd_grupo = ? " +
                  "   AND cd_usuario = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, g.getDs_grupo());
            ps.setInt(2, g.getCd_grupo());
            ps.setInt(3, g.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado.", "Grupo", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Grupo", JOptionPane.ERROR_MESSAGE);
        }    
    }
    
    /**
     * <p><strong>EN:</strong> Deletes a Group from the database 
     * using its ID and user reference.</p>
     *
     * <p><strong>IT:</strong> Elimina un Gruppo dal database 
     * utilizzando il suo ID e il riferimento utente.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui um Grupo do banco de dados 
     * utilizando seu ID e referência do usuário.</p>
     */
    public void excluir(Object o){
        Grupo g = (Grupo) o;
        try{
            sql = "DELETE FROM grupo " +
                  " WHERE cd_grupo = ? " +
                  "   AND cd_usuario = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, g.getCd_grupo());
            ps.setInt(2, g.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido", "Grupo", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Grupo", JOptionPane.ERROR_MESSAGE);
        }        
    }

    /**
     * <p><strong>EN:</strong> Retrieves a list of Groups registered for the logged user.
     * The results are ordered by group description.</p>
     *
     * <p><strong>IT:</strong> Recupera un elenco di Gruppi registrati per l’utente loggato.
     * I risultati sono ordinati per descrizione del gruppo.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera a lista de Grupos cadastrados para o usuário logado.
     * Os resultados são ordenados pela descrição do grupo.</p>
     */
    public ArrayList getLista(){        
        ArrayList grupo = new ArrayList();        
        try{
            sql = "SELECT cd_grupo, ds_grupo, cd_usuario " +
                  "  FROM grupo " +
                  " WHERE cd_usuario = ?" +
                  " ORDER BY ds_grupo";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while (rs.next()){
                Grupo g = new Grupo(
                        rs.getInt("cd_grupo"),
                        rs.getString("ds_grupo"),
                        rs.getInt("cd_usuario"));
                grupo.add(g);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de grupos:\n" +
                    ex.getMessage(), "Grupo", JOptionPane.ERROR_MESSAGE);
        }
        return grupo;
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves a Group object from the database by its ID.</p>
     *
     * <p><strong>IT:</strong> Recupera un oggetto Gruppo dal database tramite il suo ID.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera um objeto Grupo no banco de dados através do seu ID.</p>
     */
    public Object getById(int id){
        Grupo g = null;
        try {
            sql = "SELECT cd_grupo, ds_grupo, cd_usuario"
                + "  FROM grupo"
                + " WHERE cd_grupo = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                g = new Grupo(
                        rs.getInt("cd_grupo"),
                        rs.getString("ds_grupo"),
                        rs.getInt("cd_usuario"));
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Categoria.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro de getById em grupo:\n" +
                    ex.getMessage(), "Grupo", JOptionPane.ERROR_MESSAGE);
        }
        return g;
    }    
}
