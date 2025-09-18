package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MoedaRepository {

    String sql = "";

    /**
     * <p><strong>EN:</strong> Retrieves the list of all currencies from the database.</p>
     *
     * <p><strong>IT:</strong> Recupera l’elenco di tutte le valute dal database.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera a lista de todas as moedas do banco de dados.</p>
     *
     * @return EN: list of currencies | IT: elenco delle valute | PT-BR: lista de moedas
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco
     * @since 1.0.0
     */
    public ArrayList getLista() {
        ArrayList moeda = new ArrayList();
        try{
            sql = "SELECT cd_moeda, ds_moeda " +
                  "  FROM moeda";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Moeda m = new Moeda(
                        rs.getInt("cd_moeda"),
                        rs.getString("ds_moeda"));
                        moeda.add(m);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de moedas:\n" +
                    ex.getMessage(), "Moeda", JOptionPane.ERROR_MESSAGE);
        }
        return moeda;
    }

    /**
     * <p><strong>EN:</strong> Retrieves a currency by its identifier.</p>
     *
     * <p><strong>IT:</strong> Recupera una valuta tramite il suo identificatore.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera uma moeda pelo seu identificador.</p>
     *
     * @param id EN: currency identifier | IT: identificatore della valuta | PT-BR: identificador da moeda
     * @return EN: currency object or null if not found | IT: oggetto valuta o null se non trovato | PT-BR: objeto moeda ou null se não encontrado
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco
     * @since 1.0.0
     */
    public Object getById(int id) {
        Moeda moeda = null;
        try{
            sql = "SELECT cd_moeda, ds_moeda " +
                  "  FROM moeda" +
                  " WHERE cd_moeda = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                        moeda = new Moeda(
                        rs.getInt("cd_moeda"),
                        rs.getString("ds_moeda"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em moeda:\n" +
                    ex.getMessage(), "Moeda", JOptionPane.ERROR_MESSAGE);
        }
        return moeda;
    }
    
}
