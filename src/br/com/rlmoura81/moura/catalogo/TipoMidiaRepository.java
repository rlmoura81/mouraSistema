package br.com.rlmoura81.moura.catalogo;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TipoMidiaRepository{
    
    String sql = "";

    /**
     * <p><strong>EN:</strong> Retrieves all media type records from the database, ordered by ID.</p>
     *
     * <p><strong>IT:</strong> Recupera tutti i record dei tipi di media dal database, ordinati per ID.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera todos os registros de tipos de mídia do banco de dados, ordenados pelo ID.</p>
     *
     * @return EN: list of TipoMidia objects | IT: elenco di oggetti TipoMidia | PT-BR: lista de objetos TipoMidia
     * @since 1.0.0
     */
    public ArrayList getLista() {        
        ArrayList tipoMidias = new ArrayList();
        try {  
            sql = "SELECT cd_tipomidia, ds_tipomidia " +
                  "  FROM tipomidia" +
                  " ORDER BY cd_tipomidia";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while (rs.next()){
                TipoMidia tm = new TipoMidia(
                rs.getInt("cd_tipomidia"),
                rs.getString("ds_tipomidia"));
                tipoMidias.add(tm);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de midias:\n" + 
                    ex.getMessage(), "Tipo Mídia", JOptionPane.ERROR_MESSAGE);
        }
        return tipoMidias;  
    }

    /**
     * <p><strong>EN:</strong> Retrieves a specific media type by its ID.</p>
     *
     * <p><strong>IT:</strong> Recupera un tipo di media specifico tramite il suo ID.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera um tipo de mídia específico pelo seu ID.</p>
     *
     * @param id EN: unique identifier of the media type | IT: identificatore univoco del tipo di media | PT-BR: identificador único do tipo de mídia
     * @return EN: TipoMidia object if found, otherwise null | IT: Oggetto TipoMidia se trovato, altrimenti null | PT-BR: Objeto TipoMidia se encontrado, caso contrário null
     * @since 1.0.0
     */
    public Object getById(int id) {        
        TipoMidia tm = null;        
        try{
            sql = "SELECT cd_tipomidia, ds_tipomidia " +
                  "  FROM tipomidia " +
                  " WHERE cd_tipomidia = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                tm = new TipoMidia(
                rs.getInt("cd_tipomidia"),
                rs.getString("ds_tipomidia"));                
            }
            ps.close();
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em tipo de mídia:\n" +
                ex.getMessage(), "Tipo Mídia", JOptionPane.ERROR_MESSAGE);
        }   
        return tm;
    }        
}
