package br.com.rlmoura81.moura.principalcadastro;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CidadeRepository {

    String sql = "";    
    EstadoRepository estador = new EstadoRepository();
    
    /**
     * <p><strong>EN:</strong> Inserts a new City record into the database.
     * Saves the city with its name and associated State.</p>
     *
     * <p><strong>IT:</strong> Inserisce un nuovo record di Città nel database.
     * Salva la città con il suo nome e lo Stato associato.</p>
     *
     * <p><strong>PT-BR:</strong> Insere um novo registro de Cidade no banco de dados.
     * Salva a cidade com seu nome e o Estado associado.</p>
     */
    public void inserir(Object o){        
        Cidade c = (Cidade) o;        
        try{
            sql = "INSERT INTO cidade (cd_cidade, cd_estado, ds_cidade) " + 
                  "     VALUES (sq_cidade.nextval, ?, ?)";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, c.getEstado().getCd_estado());
            ps.setString(2, c.getDs_Cidade());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Cidade", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Cidade", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * <p><strong>EN:</strong> Updates an existing City record in the database.
     * Modifies the city name and associated State based on its ID.</p>
     *
     * <p><strong>IT:</strong> Aggiorna un record esistente di Città nel database.
     * Modifica il nome della città e lo Stato associato in base al suo ID.</p>
     *
     * <p><strong>PT-BR:</strong> Atualiza um registro existente de Cidade no banco de dados.
     * Altera o nome da cidade e o Estado associado com base no seu ID.</p>
     */
    public void alterar(Object o){        
        Cidade c = (Cidade) o;        
        try{
            sql = "UPDATE cidade " +
                  "   SET ds_cidade = ?, " +
                  "       cd_estado = ?" + 
                  " WHERE cd_cidade = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, c.getDs_Cidade());
            ps.setInt(2, c.getEstado().getCd_estado());
            ps.setInt(3, c.getCd_Cidade());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado", "Cidade", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Cidade", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * <p><strong>EN:</strong> Deletes a City record from the database.
     * Removes the city using its ID as a reference.</p>
     *
     * <p><strong>IT:</strong> Elimina un record di Città dal database.
     * Rimuove la città utilizzando il suo ID come riferimento.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui um registro de Cidade do banco de dados.
     * Remove a cidade utilizando seu ID como referência.</p>
     */
    public void excluir(Object o){
        Cidade c = (Cidade) o;
        try{
            sql = "DELETE FROM cidade " +
                  " WHERE cd_cidade = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, c.getCd_Cidade());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido", "Cidade", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao deletar:\n" +
                    ex.getMessage(), "Cidade", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Retrieves all City records from the database.
     * Returns a list of cities ordered by their name.</p>
     *
     * <p><strong>IT:</strong> Recupera tutti i record di Città dal database.
     * Restituisce un elenco di città ordinate per nome.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera todos os registros de Cidade do banco de dados.
     * Retorna uma lista de cidades ordenadas por nome.</p>
     */
    public ArrayList getLista(){
        ArrayList cidades = new ArrayList();        
        try{
            sql = "SELECT cd_cidade, ds_cidade, cd_estado" + 
                  "  FROM cidade" +
                  " ORDER BY ds_cidade";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){            
                Cidade c = new Cidade(
                    rs.getInt("cd_cidade"),
                    rs.getString("ds_cidade"),
                    (Estado)estador.getById(rs.getInt("cd_estado")));
                cidades.add(c);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de cidades:\n" +
                    ex.getMessage(), "Cidade", JOptionPane.ERROR_MESSAGE);
        }    
        return cidades;
    } 
    
    /**
     * <p><strong>EN:</strong> Fetches a specific City record by its ID.
     * Returns the City object with its name and associated State.</p>
     *
     * <p><strong>IT:</strong> Recupera un record specifico di Città tramite il suo ID.
     * Restituisce l’oggetto Città con il suo nome e lo Stato associato.</p>
     *
     * <p><strong>PT-BR:</strong> Busca um registro específico de Cidade pelo seu ID.
     * Retorna o objeto Cidade com seu nome e Estado associado.</p>
     */
    public Object getById(int id){        
    Cidade c = null;        
        try{
            sql = "SELECT cd_cidade, ds_cidade, cd_estado" +
                  "  FROM cidade " +
                  " WHERE cd_cidade = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                c = new Cidade(
                    rs.getInt("cd_cidade"),
                    rs.getString("ds_cidade"),
                    (Estado)estador.getById(rs.getInt("cd_estado")));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em cidade:\n" + 
                    ex.getMessage(), "Cidade", JOptionPane.ERROR_MESSAGE);
        }
        return c;
    }
}
