package br.com.rlmoura81.moura.animal;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TipoRepository{
    
    String sql = "";

    /**
     * <p><strong>EN:</strong> Retrieves the list of types (Tipo) from the database.</p>
     *
     * <p><strong>IT:</strong> Recupera l'elenco dei tipi (Tipo) dal database.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera a lista de tipos (Tipo) do banco de dados.</p>
     *
     * @return EN: list of Tipo objects | IT: elenco di oggetti Tipo | PT-BR: lista de objetos Tipo
     * @since 1.0.0
     */
    public ArrayList getLista() {
        ArrayList tipo = new ArrayList();
        try{
            sql = "SELECT cd_tipo, ds_tipo " +
                  "  FROM tphist";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Tipo tp = new Tipo(
                    rs.getInt("cd_tipo"),
                    rs.getString("ds_tipo"));
                tipo.add(tp);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de tipos:\n" +
                    ex.getMessage(), "Tipo", JOptionPane.ERROR_MESSAGE);
        }
        return tipo;
    }
    
    /**
     * <p><strong>EN:</strong> Gets a type (Tipo) from the database by its ID.</p>
     *
     * <p><strong>IT:</strong> Recupera un tipo (Tipo) dal database tramite il suo ID.</p>
     *
     * <p><strong>PT-BR:</strong> Obtém um tipo (Tipo) do banco de dados pelo seu ID.</p>
     *
     * @param id EN: unique identifier of the type | IT: identificatore univoco del tipo | PT-BR: identificador único do tipo
     * @return EN: Tipo object if found, otherwise null | IT: oggetto Tipo se trovato, altrimenti null | PT-BR: objeto Tipo se encontrado, caso contrário null
     * @since 1.0.0
     */
    public Object getById(int id) {
        Tipo t = null;
        try{
            sql = "SELECT cd_tipo, ds_tipo" +
                  "  FROM tphist" +
                  " WHERE cd_tipo = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                t = new Tipo(
                    rs.getInt("cd_tipo"),
                    rs.getString("ds_tipo"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em Tipo:\n" +
                    ex.getMessage(), "Tipo", JOptionPane.ERROR_MESSAGE);
        }
        return t;
    }
    
}
