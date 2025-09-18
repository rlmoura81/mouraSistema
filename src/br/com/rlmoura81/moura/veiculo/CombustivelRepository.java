package br.com.rlmoura81.moura.veiculo;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CombustivelRepository {

    String sql = "";

    /**
     * <p><strong>EN:</strong> Retrieves the list of fuels from the database.
     * Executes a query on the table <code>combustivel</code> ordered by description
     * and returns the results as a list of <code>Combustivel</code> objects.</p>
     *
     * <p><strong>IT:</strong> Recupera l’elenco dei combustibili dal database.
     * Esegue una query sulla tabella <code>combustivel</code> ordinata per descrizione
     * e restituisce i risultati come lista di oggetti <code>Combustivel</code>.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera a lista de combustíveis do banco de dados.
     * Executa uma consulta na tabela <code>combustivel</code> ordenada pela descrição
     * e retorna os resultados como uma lista de objetos <code>Combustivel</code>.</p>
     */
    public ArrayList getLista() {
        ArrayList combustivel = new ArrayList();
        try{
            sql = "SELECT cd_combustivel, ds_combustivel" +
                  "  FROM combustivel" +
                  " ORDER BY ds_combustivel";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Combustivel c = new Combustivel(
                    rs.getInt("cd_combustivel"),
                    rs.getString("ds_combustivel"));
                combustivel.add(c);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de combustiveis:\n" +
                    ex.getMessage(), "Combustivel", JOptionPane.ERROR_MESSAGE);
        }
        return combustivel;
    }

    /**
     * <p><strong>EN:</strong> Retrieves a fuel record by its unique identifier.
     * Executes a query on the table <code>combustivel</code> using the provided ID
     * and returns the corresponding <code>Combustivel</code> object if found.</p>
     *
     * <p><strong>IT:</strong> Recupera un record di combustibile tramite il suo identificatore univoco.
     * Esegue una query sulla tabella <code>combustivel</code> utilizzando l’ID fornito
     * e restituisce l’oggetto <code>Combustivel</code> corrispondente, se trovato.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera um registro de combustível pelo seu identificador único.
     * Executa uma consulta na tabela <code>combustivel</code> utilizando o ID informado
     * e retorna o objeto <code>Combustivel</code> correspondente, se encontrado.</p>
     */
    public Object getById(int id) {
        Combustivel c = null;
        try{
            sql = "SELECT cd_combustivel, ds_combustivel" +
                  "  FROM combustivel" +
                  " WHERE cd_combustivel = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                c = new Combustivel(
                    rs.getInt("cd_combustivel"),
                    rs.getString("ds_combustivel"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em combustivel:\n" + 
                    ex.getMessage(), "Combustivel", JOptionPane.ERROR_MESSAGE);
        }
        return c;
    }    
}
