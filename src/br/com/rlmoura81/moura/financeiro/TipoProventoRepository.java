package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TipoProventoRepository{

    String sql = "";

    /**
     * <p><strong>EN:</strong> Retrieves the full list of income types.</p>
     * <p><strong>IT:</strong> Recupera l’elenco completo dei tipi di provento.</p>
     * <p><strong>PT-BR:</strong> Recupera a lista completa de tipos de provento.</p>
     *
     * @return EN: List of income types | IT: Elenco dei tipi di provento | PT-BR: Lista de tipos de provento
     * @since 1.0.0
     */
    public ArrayList getLista() {
        ArrayList tpprovento = new ArrayList();
        try{
            sql = "SELECT cd_tpprovento, ds_tpprovento " +
                  "  FROM tpprovento";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                TipoProvento tpp = new TipoProvento(
                    rs.getInt("cd_tpprovento"),
                    rs.getString("ds_tpprovento"));
                    tpprovento.add(tpp);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de tipo de provento:\n" +
                    ex.getMessage());
        }
        return tpprovento;
    }

    /**
     * <p><strong>EN:</strong> Retrieves the list of income types linked to stocks (Ações).</p>
     * <p><strong>IT:</strong> Recupera l’elenco dei tipi di provento collegati alle azioni.</p>
     * <p><strong>PT-BR:</strong> Recupera a lista de tipos de provento vinculados às ações.</p>
     *
     * @return EN: List of stock income types | IT: Elenco dei tipi di provento azionari | PT-BR: Lista de tipos de provento de ações
     * @since 1.0.0
     */
    public ArrayList getListaTpProvAcao() {
        ArrayList tpprovento = new ArrayList();
        try{
            sql = "SELECT DISTINCT tpprovento.cd_tpprovento, ds_tpprovento" +
                  "  FROM tpprovento, acaoprov" +
                  " WHERE tpprovento.cd_tpprovento = acaoprov.cd_tpprovento";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                TipoProvento tpp = new TipoProvento(
                    rs.getInt("cd_tpprovento"),
                    rs.getString("ds_tpprovento"));
                    tpprovento.add(tpp);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de tipo de provento:\n" +
                    ex.getMessage());
        }
        return tpprovento;
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves the list of income types linked to FIIs (Real Estate Investment Funds).</p>
     * <p><strong>IT:</strong> Recupera l’elenco dei tipi di provento collegati ai fondi immobiliari (FII).</p>
     * <p><strong>PT-BR:</strong> Recupera a lista de tipos de provento vinculados aos FIIs.</p>
     *
     * @return EN: List of FII income types | IT: Elenco dei tipi di provento FII | PT-BR: Lista de tipos de provento de FIIs
     * @since 1.0.0
     */
    public ArrayList getListaTpProvFII() {
        ArrayList tpprovento = new ArrayList();
        try{
            sql = "SELECT DISTINCT tpprovento.cd_tpprovento, ds_tpprovento" +
                  "  FROM tpprovento, fdimprov" +
                  " WHERE tpprovento.cd_tpprovento = fdimprov.cd_tpprovento";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                TipoProvento tpp = new TipoProvento(
                    rs.getInt("cd_tpprovento"),
                    rs.getString("ds_tpprovento"));
                    tpprovento.add(tpp);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de tipo de provento:\n" +
                    ex.getMessage());
        }
        return tpprovento;
    }

    /**
     * <p><strong>EN:</strong> Retrieves a specific income type by its identifier.</p>
     * <p><strong>IT:</strong> Recupera un tipo di provento specifico tramite il suo identificatore.</p>
     * <p><strong>PT-BR:</strong> Recupera um tipo de provento específico pelo seu identificador.</p>
     *
     * @param id EN: Income type ID | IT: ID del tipo di provento | PT-BR: ID do tipo de provento
     * @return EN: Income type object or null if not found | IT: Oggetto tipo di provento o null se non trovato | PT-BR: Objeto tipo de provento ou null se não encontrado
     * @since 1.0.0
     */
    public Object getById(int id) {
        TipoProvento tpp = null;
        try{
            sql = "SELECT cd_tpprovento, ds_tpprovento " +
                  "  FROM tpprovento" +
                  " WHERE cd_tpprovento = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                tpp = new TipoProvento(
                    rs.getInt("cd_tpprovento"),
                    rs.getString("ds_tpprovento"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em tipo de provento:\n" +
                    ex.getMessage());
        }
        return tpp;
    }
 
}
