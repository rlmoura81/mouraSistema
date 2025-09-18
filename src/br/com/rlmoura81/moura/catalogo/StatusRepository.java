package br.com.rlmoura81.moura.catalogo;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class StatusRepository{

    String sql = "";

    /**
     * <p><strong>EN:</strong> Retrieves all status records from the database, ordered by description.</p>
     *
     * <p><strong>IT:</strong> Recupera tutti i record di stato dal database, ordinati per descrizione.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera todos os registros de status do banco de dados, ordenados pela descrição.</p>
     *
     * @return EN: list of Status objects | IT: elenco di oggetti Status | PT-BR: lista de objetos Status
     * @since 1.0.0
     */
    public ArrayList getLista() {    
        ArrayList status = new ArrayList();        
        try{
            sql = "SELECT cd_status, ds_status " +
                  "  FROM status" +
                  " ORDER BY ds_status";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while (rs.next()){
                Status st = new Status(
                    rs.getInt("cd_status"),
                    rs.getString("ds_status"));
                status.add(st);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de status:\n" +
                    ex.getMessage());
        }
        return status;
    }

    /**
     * <p><strong>EN:</strong> Retrieves a specific status by its ID.</p>
     *
     * <p><strong>IT:</strong> Recupera uno stato specifico tramite il suo ID.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera um status específico pelo seu ID.</p>
     *
     * @param id EN: unique identifier of the status | IT: identificatore univoco dello stato | PT-BR: identificador único do status
     * @return EN: Status object if found, otherwise null | IT: Oggetto Status se trovato, altrimenti null | PT-BR: Objeto Status se encontrado, caso contrário null
     * @since 1.0.0
     */
    public Object getById(int id) {        
        Status st = null;        
        try{
            sql = "SELECT cd_status, ds_status " +
                  "  FROM status" +
                  " WHERE cd_status = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if (rs.next()){
                st = new Status(
                    rs.getInt("cd_status"),
                    rs.getString("ds_status"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em status:\n" +
                    ex.getMessage());
        }
        return st;
    }   
}
