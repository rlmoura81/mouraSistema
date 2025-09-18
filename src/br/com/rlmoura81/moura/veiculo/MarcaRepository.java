package br.com.rlmoura81.moura.veiculo;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MarcaRepository{
    
    String sql = "";

    /**
     * <p><strong>EN:</strong> Retrieves all brand records from the <em>marca</em> table,
     * ordered by description, maps them to <code>Marca</code> objects, and returns the list.</p>
     *
     * <p><strong>IT:</strong> Recupera tutti i record dei marchi dalla tabella <em>marca</em>,
     * ordinati per descrizione, li mappa in oggetti <code>Marca</code> e restituisce la lista.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera todos os registros de marcas da tabela <em>marca</em>,
     * ordenados pela descrição, mapeia para objetos <code>Marca</code> e retorna a lista.</p>
     */
    public ArrayList getLista() {
        ArrayList marcas = new ArrayList();
        try{
            sql = "SELECT cd_marca, ds_marca" +
                  "  FROM marca " +
                  " ORDER BY ds_marca";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while (rs.next()){
                Marca m = new Marca(
                    rs.getInt("cd_marca"),
                    rs.getString("ds_marca"));
                    marcas.add(m);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de marcas:\n" +
                    ex.getMessage(), "Marca", JOptionPane.ERROR_MESSAGE);
        }
        return marcas;
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves a brand record by its unique identifier (<code>cd_marca</code>)
     * from the <em>marca</em> table and returns the corresponding <code>Marca</code> object, or <code>null</code> if not found.</p>
     *
     * <p><strong>IT:</strong> Recupera un record di marchio tramite il suo identificatore univoco (<code>cd_marca</code>)
     * dalla tabella <em>marca</em> e restituisce l'oggetto <code>Marca</code> corrispondente, oppure <code>null</code> se non trovato.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera um registro de marca pelo identificador único (<code>cd_marca</code>)
     * na tabela <em>marca</em> e retorna o objeto <code>Marca</code> correspondente, ou <code>null</code> se não encontrado.</p>
     */
    public Object getById(int id) {
        Marca m = null;        
        try{
            sql = "SELECT cd_marca, ds_marca" +
                  "  FROM marca " +
                  " WHERE cd_marca = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                m = new Marca(
                    rs.getInt("cd_marca"),
                    rs.getString("ds_marca"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em marca:\n" + 
                    ex.getMessage(), "Marca", JOptionPane.ERROR_MESSAGE);
        }
        return m;
    }
}
