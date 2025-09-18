package br.com.rlmoura81.moura.animal;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EspecieRepository{

    String sql = "";

    /**
     * <p><strong>EN:</strong> Retrieves a list of species from the database, ordered by name.</p>
     *
     * <p><strong>IT:</strong> Recupera un elenco di specie dal database, ordinato per nome.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera uma lista de espécies do banco de dados, ordenada por nome.</p>
     *
     * @return EN: list of Especie objects | IT: elenco di oggetti Especie | PT-BR: lista de objetos Especie
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco
     * @since 1.0.0
     */
    public ArrayList getLista() {        
        ArrayList especies = new ArrayList();
        try{
            sql = "SELECT cd_especie, ds_especie " +
                  "  FROM especie" +
                  " ORDER BY ds_especie";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while (rs.next()){
                Especie e = new Especie(
                rs.getInt("cd_especie"),
                rs.getString("ds_especie"));
                especies.add(e);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de especies:" +
                    ex.getMessage(), "Especie", JOptionPane.ERROR_MESSAGE);
        }
        return especies;
    }

    /**
     * <p><strong>EN:</strong> Gets a species from the database by its ID.</p>
     *
     * <p><strong>IT:</strong> Recupera una specie dal database tramite il suo ID.</p>
     *
     * <p><strong>PT-BR:</strong> Obtém uma espécie do banco de dados pelo seu ID.</p>
     *
     * @param id EN: unique identifier of the species | IT: identificatore univoco della specie | PT-BR: identificador único da espécie
     * @return EN: Especie object if found, otherwise null | IT: Oggetto Especie se trovato, altrimenti null | PT-BR: Objeto Especie se encontrado, caso contrário null
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco
     * @since 1.0.0
     */
    public Object getById(int id) {
        Especie e = null;
        try{
            sql = "SELECT cd_especie, ds_especie " +
                  "  FROM especie " +
                  " WHERE cd_especie = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                e = new Especie(
                    rs.getInt("cd_especie"),
                    rs.getString("ds_especie"));
            }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em especie:\n" +
                    ex.getMessage(), "Especie", JOptionPane.ERROR_MESSAGE);
            ex.getMessage();
        }
        return e;
    }
    
}
