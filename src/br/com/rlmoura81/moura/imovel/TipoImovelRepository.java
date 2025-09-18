package br.com.rlmoura81.moura.imovel;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TipoImovelRepository{

    String sql = "";

    /**
     * <p><strong>EN:</strong> Retrieves all records from the <code>tipoimovel</code> table,
     * mapping them into {@link TipoImovel} objects and returning them as a list.  
     * Displays an error dialog if the query fails.</p>
     *
     * <p><strong>IT:</strong> Recupera tutti i record dalla tabella <code>tipoimovel</code>,
     * mappandoli in oggetti {@link TipoImovel} e restituendoli come lista.  
     * Mostra un messaggio di errore in caso di fallimento della query.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera todos os registros da tabela <code>tipoimovel</code>,
     * convertendo-os em objetos {@link TipoImovel} e retornando-os em uma lista.  
     * Exibe uma mensagem de erro caso a consulta falhe.</p>
     */
    public ArrayList getLista() {
        ArrayList tpimovel = new ArrayList();
        try{
            sql = "SELECT cd_tpimovel, ds_tpimovel " +
                  "  FROM tipoimovel";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                TipoImovel tpi = new TipoImovel(
                    rs.getInt("cd_tpimovel"),
                    rs.getString("ds_tpimovel"));
                tpimovel.add(tpi);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de tipo de imoveis:\n" +
                    ex.getMessage(), "Tipo", JOptionPane.ERROR_MESSAGE);
        }
        return tpimovel;
    }

    /**
     * <p><strong>EN:</strong> Retrieves a single {@link TipoImovel} by its identifier
     * (<code>cd_tpimovel</code>) from the database.  
     * Returns <code>null</code> if no matching record is found.  
     * Shows an error dialog if the operation fails.</p>
     *
     * <p><strong>IT:</strong> Recupera un singolo {@link TipoImovel} tramite il suo identificativo
     * (<code>cd_tpimovel</code>) dal database.  
     * Restituisce <code>null</code> se non viene trovato alcun record corrispondente.  
     * Mostra un messaggio di errore in caso di fallimento dell’operazione.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera um único {@link TipoImovel} pelo seu identificador
     * (<code>cd_tpimovel</code>) no banco de dados.  
     * Retorna <code>null</code> se nenhum registro correspondente for encontrado.  
     * Exibe uma mensagem de erro caso a operação falhe.</p>
     */
    public Object getById(int id) {
        TipoImovel tpi = null;
        try{
            sql = "SELECT cd_tpimovel, ds_tpimovel " +
                  "  FROM tipoimovel" +
                  " WHERE cd_tpimovel = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                tpi = new TipoImovel(
                    rs.getInt("cd_tpimovel"),
                    rs.getString("ds_tpimovel"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em tipo de imovel:\n" + 
                    ex.getMessage(), "Tipo", JOptionPane.ERROR_MESSAGE);
        }
        return tpi;
    }    
}
