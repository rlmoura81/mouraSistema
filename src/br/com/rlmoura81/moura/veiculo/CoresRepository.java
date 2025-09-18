package br.com.rlmoura81.moura.veiculo;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CoresRepository{
    
    String sql = "";
    
    /**
     * <p><strong>EN:</strong> Retrieves all color records from the <em>cores</em> table,
     * ordered by description, maps them to <code>Cores</code> objects, and returns the list.</p>
     *
     * <p><strong>IT:</strong> Recupera tutti i record dei colori dalla tabella <em>cores</em>,
     * ordinati per descrizione, li mappa in oggetti <code>Cores</code> e restituisce la lista.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera todos os registros de cores da tabela <em>cores</em>,
     * ordenados pela descrição, mapeia para objetos <code>Cores</code> e retorna a lista.</p>
     */
    public ArrayList getLista() {
        ArrayList<Cores> cor = new ArrayList();
        try{
            sql = "SELECT cd_cor, ds_cor" +
                  "  FROM cores" +
                  " ORDER BY ds_cor";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Cores c = new Cores(
                    rs.getInt("cd_cor"),
                    rs.getString("ds_cor"));
                cor.add(c);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a listas de cores" + 
                    ex.getMessage(), "Cores", JOptionPane.ERROR_MESSAGE);
        }
        return cor;
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves a color record by its unique identifier (<code>cd_cor</code>)
     * from the <em>cores</em> table and returns the corresponding <code>Cores</code> object, or <code>null</code> if not found.</p>
     *
     * <p><strong>IT:</strong> Recupera un record di colore tramite il suo identificatore univoco (<code>cd_cor</code>)
     * dalla tabella <em>cores</em> e restituisce l'oggetto <code>Cores</code> corrispondente, oppure <code>null</code> se non trovato.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera um registro de cor pelo identificador único (<code>cd_cor</code>)
     * na tabela <em>cores</em> e retorna o objeto <code>Cores</code> correspondente, ou <code>null</code> se não encontrado.</p>
     */
    public Object getById(int id) {
        Cores c = null;
        try{
            sql = "SELECT cd_cor, ds_cor" +
                  "  FROM cores" +
                  " WHERE cd_cor = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                c = new Cores(
                    rs.getInt("cd_cor"),
                    rs.getString("ds_cor"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em cor:\n" +
                    ex.getMessage(), "Cores", JOptionPane.ERROR_MESSAGE);
        }
        return c;
    }
    
}
