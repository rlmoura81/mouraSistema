package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TipoTransacaoRepository{

    String sql = "";    
    GrupoTransacaoRepository gptransr = new GrupoTransacaoRepository();

    /**
     * <p><strong>EN:</strong> Retrieves the complete list of transaction types (TipoTransacao) from the database.</p>
     * <p><strong>IT:</strong> Recupera l'elenco completo dei tipi di transazione (TipoTransacao) dal database.</p>
     * <p><strong>PT-BR:</strong> Recupera a lista completa de tipos de transação (TipoTransacao) do banco de dados.</p>
     *
     * @return EN: List of transaction types |
     *         IT: Elenco di tipi di transazione |
     *         PT-BR: Lista de tipos de transação
     */
    public ArrayList getLista() {
        ArrayList tptrans = new ArrayList();
        try{
            sql = "SELECT cd_tptrans, ds_tptrans, cd_gptrans " +
                  "  FROM tptrans";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                TipoTransacao tp = new TipoTransacao(
                    rs.getInt("cd_tptrans"),
                    rs.getString("ds_tptrans"),
                    (GrupoTransacao)gptransr.getById(rs.getInt("cd_gptrans")));
                    tptrans.add(tp);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de tipos de transações:\n" +
                    ex.getMessage());
        }
        return tptrans;
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves a filtered list of transaction types (TipoTransacao) for a specific transaction group.</p>
     * <p><strong>IT:</strong> Recupera un elenco filtrato di tipi di transazione (TipoTransacao) per un gruppo di transazioni specifico.</p>
     * <p><strong>PT-BR:</strong> Recupera uma lista filtrada de tipos de transação (TipoTransacao) para um grupo específico.</p>
     *
     * @param cd_gptrans EN: Transaction group ID |
     *                   IT: ID del gruppo di transazioni |
     *                   PT-BR: ID do grupo de transações
     * @return EN: Filtered list of transaction types |
     *         IT: Elenco filtrato di tipi di transazione |
     *         PT-BR: Lista filtrada de tipos de transação
     */
    public ArrayList getLista(int cd_gptrans) {
        ArrayList tptrans = new ArrayList();
        try{
            sql = "SELECT cd_tptrans, ds_tptrans, cd_gptrans" + 
                  "  FROM tptrans" + 
                  " WHERE cd_gptrans = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_gptrans);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                TipoTransacao tp = new TipoTransacao(
                    rs.getInt("cd_tptrans"),
                    rs.getString("ds_tptrans"),
                    (GrupoTransacao)gptransr.getById(rs.getInt("cd_gptrans")));
                    tptrans.add(tp);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de tipos de transações:\n" +
                    ex.getMessage(), "Tipo Transação", JOptionPane.ERROR_MESSAGE);
        }
        return tptrans;
    }

    /**
     * <p><strong>EN:</strong> Retrieves a transaction type (TipoTransacao) by its unique ID.</p>
     * <p><strong>IT:</strong> Recupera un tipo di transazione (TipoTransacao) tramite il suo ID univoco.</p>
     * <p><strong>PT-BR:</strong> Recupera um tipo de transação (TipoTransacao) pelo seu ID único.</p>
     *
     * @param id EN: Transaction type ID |
     *           IT: ID del tipo di transazione |
     *           PT-BR: ID do tipo de transação
     * @return EN: Transaction type object or null if not found |
     *         IT: Oggetto TipoTransacao o null se non trovato |
     *         PT-BR: Objeto TipoTransacao ou null se não encontrado
     */
    public Object getById(int id) {
        TipoTransacao tptrans = null;
        try{
            sql = "SELECT cd_tptrans, ds_tptrans, cd_gptrans " +
                  "  FROM tptrans" +
                  " WHERE cd_tptrans = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                    tptrans = new TipoTransacao(
                    rs.getInt("cd_tptrans"),
                    rs.getString("ds_tptrans"),
                    (GrupoTransacao)gptransr.getById(rs.getInt("cd_gptrans")));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em tipos de transações:\n" +
                    ex.getMessage(), "Tipo Transação", JOptionPane.ERROR_MESSAGE);
        }
        return tptrans;
    }
}
