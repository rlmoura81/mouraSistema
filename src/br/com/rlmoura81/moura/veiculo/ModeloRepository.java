package br.com.rlmoura81.moura.veiculo;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ModeloRepository implements IPadraoRepository{

    String sql = "";    
    MarcaRepository marcar = new MarcaRepository();
    
    /**
     * <p><strong>EN:</strong> Inserts a new record into the <code>modelo</code> table, including the model description,
     * associated brand, and user code.</p>
     *
     * <p><strong>IT:</strong> Inserisce un nuovo record nella tabella <code>modelo</code>, includendo la descrizione del modello,
     * il marchio associato e il codice utente.</p>
     *
     * <p><strong>PT-BR:</strong> Insere um novo registro na tabela <code>modelo</code>, incluindo a descrição do modelo,
     * a marca associada e o código do usuário.</p>
     */
    @Override
    public void inserir(Object o) {       
        Modelo m = (Modelo) o;
        try{
            sql = "INSERT INTO modelo (cd_modelo, ds_modelo, cd_marca, cd_usuario)" +
                  "     VALUES (sq_modelo.nextval, ?, ?, ?)";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, m.getDs_modelo());
            ps.setInt(2, m.getMarca().getCd_marca());
            ps.setInt(3, m.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Modelo", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Modelo", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Updates an existing <code>modelo</code> record with a new description, brand, and user code.</p>
     *
     * <p><strong>IT:</strong> Aggiorna un record esistente di <code>modelo</code> con nuova descrizione, marchio e codice utente.</p>
     *
     * <p><strong>PT-BR:</strong> Atualiza um registro existente em <code>modelo</code> com nova descrição, marca e código do usuário.</p>
     */
    @Override
    public void alterar(Object o) {       
        Modelo m = (Modelo) o;        
        try{
            sql = "UPDATE modelo " +
                  "   SET ds_modelo = ?, " +
                  "       cd_marca = ?, " +
                  "       cd_usuario = ? " +
                  " WHERE cd_modelo = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, m.getDs_modelo());
            ps.setInt(2, m.getMarca().getCd_marca());
            ps.setInt(3, m.getCd_usuario());
            ps.setInt(4, m.getCd_modelo());
            ps.execute();
            ps.close();
            JOptionPane.showConfirmDialog(null, "Alterado.", "Modelo", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Modelo", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Deletes a record from the <code>modelo</code> table based on its unique identifier.</p>
     *
     * <p><strong>IT:</strong> Elimina un record dalla tabella <code>modelo</code> in base al suo identificatore univoco.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui um registro da tabela <code>modelo</code> com base em seu identificador único.</p>
     */
    @Override
    public void excluir(Object o) {        
        Modelo m = (Modelo) o;        
        try{
            sql = "DELETE FROM modelo " +
                  " WHERE cd_modelo = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, m.getCd_modelo());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido", "Modelo", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Modelo", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Retrieves a list of all <code>modelo</code> records, ordered by description.
     * Each item contains the model ID, description, associated brand, and user code.</p>
     *
     * <p><strong>IT:</strong> Recupera un elenco di tutti i record <code>modelo</code>, ordinati per descrizione.
     * Ogni elemento contiene l'ID del modello, la descrizione, il marchio associato e il codice utente.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera uma lista de todos os registros de <code>modelo</code>, ordenados pela descrição.
     * Cada item contém o ID do modelo, a descrição, a marca associada e o código do usuário.</p>
     */
    @Override
    public ArrayList getLista() {
        ArrayList modelo = new ArrayList();
        try{
            sql = "SELECT cd_modelo, ds_modelo, cd_marca, cd_usuario" +
                  "  FROM modelo" + 
                  " ORDER BY ds_modelo";                  
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Modelo m = new Modelo(
                    rs.getInt("cd_modelo"),
                    rs.getString("ds_modelo"),
                    (Marca)marcar.getById(rs.getInt("cd_marca")),
                    rs.getInt("cd_usuario"));
                modelo.add(m);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de modelos:\n" +
                    ex.getMessage(), "Modelo", JOptionPane.ERROR_MESSAGE);
        }        
        return modelo;
    }

    /**
     * <p><strong>EN:</strong> Retrieves a single <code>modelo</code> record by ID, including description,
     * associated brand, and user code.</p>
     *
     * <p><strong>IT:</strong> Recupera un singolo record <code>modelo</code> per ID, includendo la descrizione,
     * il marchio associato e il codice utente.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera um único registro de <code>modelo</code> pelo ID, incluindo a descrição,
     * a marca associada e o código do usuário.</p>
     */
    @Override
    public Object getById(int id) {
        Modelo m = null;
        try{
            sql = "SELECT cd_modelo, ds_modelo, cd_marca, cd_usuario" +
                  "  FROM modelo " + 
                  " WHERE cd_modelo = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                m = new Modelo(
                    rs.getInt("cd_modelo"),
                    rs.getString("ds_modelo"),
                    (Marca)marcar.getById(rs.getInt("cd_marca")),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em modelo:\n" +
                    ex.getMessage(), "Modelo", JOptionPane.ERROR_MESSAGE);
        }
        return m;
    }    
}
