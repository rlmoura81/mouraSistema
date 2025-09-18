package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GrupoFundoRepository{

    String sql = "";

    /**
     * <p><strong>EN:</strong> Retrieves the list of all investment fund groups from the database.</p>
     *
     * <p><strong>IT:</strong> Recupera l'elenco di tutti i gruppi di fondi di investimento dal database.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera a lista de todos os grupos de fundos de investimento do banco de dados.</p>
     *
     * @return EN: list of investment fund groups | IT: elenco dei gruppi di fondi di investimento | PT-BR: lista de grupos de fundos de investimento
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco de dados
     * @since 1.0.0
     */
    public ArrayList getLista() {
        ArrayList gpfundo = new ArrayList();
        try{
            sql = "SELECT cd_gpfundo, ds_gpfundo " +
                  "  FROM gpfundo";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                GrupoFundo gf = new GrupoFundo(
                    rs.getInt("cd_gpfundo"),
                    rs.getString("ds_gpfundo"));
                    gpfundo.add(gf);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de grupo de fundos:\n" +
                    ex.getMessage());
        }
        return gpfundo;
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves an investment fund group by its ID.</p>
     *
     * <p><strong>IT:</strong> Recupera un gruppo di fondi di investimento tramite il suo ID.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera um grupo de fundos de investimento pelo seu ID.</p>
     *
     * @param id EN: investment fund group identifier | IT: identificatore del gruppo di fondi di investimento | PT-BR: identificador do grupo de fundos de investimento
     * @return EN: investment fund group object or null if not found | IT: oggetto gruppo fondi o null se non trovato | PT-BR: objeto grupo de fundos ou null se não encontrado
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco de dados
     * @since 1.0.0
     */
    public Object getById(int id) {
        GrupoFundo gf = null;
        try{
            sql = "SELECT cd_gpfundo, ds_gpfundo " +
                  "  FROM gpfundo" +
                  " WHERE cd_gpfundo = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                gf = new GrupoFundo(
                    rs.getInt("cd_gpfundo"),
                    rs.getString("ds_gpfundo"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em grupo de fundos:\n" +
                    ex.getMessage());
        }
        return gf;
    }
}
