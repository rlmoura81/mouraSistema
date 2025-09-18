package br.com.rlmoura81.moura.principal;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ModuloRepository {

    String sql = "";

    /**
     * <p><strong>EN:</strong> Retrieves the complete list of modules from the database.
     * Executes a query on the modulo table and returns a collection of Modulo objects 
     * with ID and description.</p>
     *
     * <p><strong>IT:</strong> Recupera l’elenco completo dei moduli dal database.
     * Esegue una query sulla tabella modulo e restituisce una collezione di oggetti Modulo 
     * con ID e descrizione.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera a lista completa de módulos do banco de dados.
     * Executa uma consulta na tabela modulo e retorna uma coleção de objetos Modulo 
     * com ID e descrição.</p>
     */
    public ArrayList getLista() {
        ArrayList modulo = new ArrayList();
        try{
            sql = "SELECT cd_modulo, ds_modulo " +
                  "  FROM modulo";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Modulo m = new Modulo(
                    rs.getInt("cd_modulo"),
                    rs.getString("ds_modulo"));
                    modulo.add(m);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de modulos:\n" +
                    ex.getMessage(), "Modulo", JOptionPane.ERROR_MESSAGE);
        }
        return modulo;
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves a specific module by its unique identifier.
     * Runs a parameterized query on the modulo table and returns the corresponding Modulo object.</p>
     *
     * <p><strong>IT:</strong> Recupera un modulo specifico tramite il suo identificatore univoco.
     * Esegue una query parametrizzata sulla tabella modulo e restituisce l’oggetto Modulo corrispondente.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera um módulo específico pelo seu identificador único.
     * Executa uma consulta parametrizada na tabela modulo e retorna o objeto Modulo correspondente.</p>
     */
    public Object getById(int id) {
        Modulo modulo = null;
        try{
            sql = "SELECT cd_modulo, ds_modulo " +
                  "  FROM modulo" +
                  " WHERE cd_modulo = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                    modulo = new Modulo(
                    rs.getInt("cd_modulo"),
                    rs.getString("ds_modulo"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em modulo:\n" +
                    ex.getMessage(), "Modulo", JOptionPane.ERROR_MESSAGE);
        }
        return modulo;
    }    
}
