package br.com.rlmoura81.moura.animal;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class RacaRepository implements IPadraoRepository{

    String sql = "";    
    EspecieRepository especier = new EspecieRepository();

    /**
     * <p><strong>EN:</strong> Inserts a breed (Raca) into the database.</p>
     *
     * <p><strong>IT:</strong> Inserisce una razza (Raca) nel database.</p>
     *
     * <p><strong>PT-BR:</strong> Insere uma raça (Raca) no banco de dados.</p>
     *
     * @param o EN: Raca object to insert | IT: Oggetto Raca da inserire | PT-BR: Objeto Raca a ser inserido
     * @since 1.0.0
     */
    @Override
    public void inserir(Object o) {        
        Raca r = (Raca) o;        
        try{
            sql = "INSERT INTO raca (cd_raca, ds_raca, cd_especie, cd_usuario)" +
                  "     VALUES (sq_raca.nextval, ?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, r.getDs_raca());
            ps.setInt(2, r.getEspecie().getCd_especie());
            ps.setInt(3, r.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Raça", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Raça", JOptionPane.ERROR);
        }
    }

    /**
     * <p><strong>EN:</strong> Updates an existing breed (Raca) in the database.</p>
     *
     * <p><strong>IT:</strong> Aggiorna una razza (Raca) esistente nel database.</p>
     *
     * <p><strong>PT-BR:</strong> Atualiza uma raça (Raca) existente no banco de dados.</p>
     *
     * @param o EN: Raca object with updated values | IT: Oggetto Raca con valori aggiornati | PT-BR: Objeto Raca com valores atualizados
     * @since 1.0.0
     */
    @Override
    public void alterar(Object o) {        
        Raca r = (Raca) o;        
        try{
            sql = "UPDATE raca " +
                  "   SET ds_raca = ?, " +
                  "       cd_especie = ?," +
                  "       cd_usuario = ?" + 
                  " WHERE cd_raca = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, r.getDs_raca());
            ps.setInt(2, r.getEspecie().getCd_especie());
            ps.setInt(3, r.getCd_usuario());
            ps.setInt(4, r.getCd_raca());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado.", "Raça", JOptionPane.INFORMATION_MESSAGE);            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Raça", JOptionPane.ERROR);
        }
    }

    /**
     * <p><strong>EN:</strong> Deletes a breed (Raca) from the database by its ID.</p>
     *
     * <p><strong>IT:</strong> Elimina una razza (Raca) dal database tramite il suo ID.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui uma raça (Raca) do banco de dados pelo seu ID.</p>
     *
     * @param o EN: Raca object containing the identifier for deletion | IT: Oggetto Raca contenente l'identificatore da eliminare | PT-BR: Objeto Raca contendo o identificador para exclusão
     * @since 1.0.0
     */
    @Override
    public void excluir(Object o) {        
        Raca r = (Raca) o;         
        try{
            sql = "DELETE FROM raca " +
                  " WHERE cd_raca = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, r.getCd_raca());
            ps.execute();        
            JOptionPane.showMessageDialog(null, "Excluido.", "Raça", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){    
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Raça", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Retrieves the list of breeds (Raca) from the database, ordered by name.</p>
     *
     * <p><strong>IT:</strong> Recupera l'elenco delle razze (Raca) dal database, ordinate per nome.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera a lista de raças (Raca) do banco de dados, ordenadas por nome.</p>
     *
     * @return EN: list of Raca objects | IT: Elenco di oggetti Raca | PT-BR: Lista de objetos Raca
     * @since 1.0.0
     */
    @Override
    public ArrayList getLista() {        
        ArrayList racas = new ArrayList();        
        try{
            sql = "SELECT cd_raca, ds_raca, cd_especie, cd_usuario" + 
                  "  FROM raca" +
                  " ORDER BY ds_raca";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while (rs.next()){
                Raca r = new Raca(
                    rs.getInt("cd_raca"),
                    rs.getString("ds_raca"),
                    (Especie)especier.getById(rs.getInt("cd_especie")),
                    rs.getInt("cd_usuario"));
                racas.add(r);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Raça:\n" +
                    ex.getMessage(), "Raça", JOptionPane.ERROR_MESSAGE);
        }
        return racas;
    }

    /**
     * <p><strong>EN:</strong> Gets a breed (Raca) from the database by its ID.</p>
     *
     * <p><strong>IT:</strong> Recupera una razza (Raca) dal database tramite il suo ID.</p>
     *
     * <p><strong>PT-BR:</strong> Obtém uma raça (Raca) do banco de dados pelo seu ID.</p>
     *
     * @param id EN: unique identifier of the breed | IT: Identificatore univoco della razza | PT-BR: Identificador único da raça
     * @return EN: Raca object if found, otherwise null | IT: Oggetto Raca se trovato, altrimenti null | PT-BR: Objeto Raca se encontrado, caso contrário null
     * @since 1.0.0
     */
    @Override
    public Object getById(int id) {        
        Raca r = null;        
        try{
            sql = "SELECT cd_raca, ds_raca, cd_especie, cd_usuario " +
                  "  FROM raca " +
                  " WHERE cd_raca = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                r = new Raca(
                    rs.getInt("cd_raca"),
                    rs.getString("ds_raca"),
                    (Especie)especier.getById(rs.getInt("cd_especie")),
                    rs.getInt("cd_usuario")
                );
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em Raça:\n" + 
            ex.getMessage(), "Raça", JOptionPane.ERROR_MESSAGE);
        }
        return r;
    }    
}
