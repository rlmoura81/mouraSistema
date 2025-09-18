package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GrupoTransacaoRepository{

    String sql = "";

    /**
     * <p><strong>EN:</strong> Retrieves the list of transaction groups.</p>
     *
     * <p><strong>IT:</strong> Recupera l'elenco dei gruppi di transazioni.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera a lista de grupos de transações.</p>
     *
     * @return EN: list of transaction groups | IT: elenco dei gruppi di transazioni | PT-BR: lista de grupos de transações
     * @since 1.0.0
     */
    public ArrayList getLista() {
        ArrayList gptrans = new ArrayList();
        try{
            sql = "SELECT cd_gptrans, ds_gptrans " +
                  "  FROM gptrans";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                GrupoTransacao gt = new GrupoTransacao(
                    rs.getInt("cd_gptrans"),
                    rs.getString("ds_gptrans"));
                    gptrans.add(gt);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de grupo de transação:\n" +
                    ex.getMessage());
        }
        return gptrans;
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves the list of transaction groups filtered by buy and sell.</p>
     *
     * <p><strong>IT:</strong> Recupera l'elenco dei gruppi di transazioni filtrati per acquisto e vendita.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera a lista de grupos de transações filtrados por compra e venda.</p>
     *
     * @return EN: list of buy and sell transaction groups | IT: elenco dei gruppi di transazioni di acquisto e vendita | PT-BR: lista de grupos de transações de compra e venda
     * @since 1.0.0
     */
    public ArrayList getListaCompraVenda() {
        ArrayList gptrans = new ArrayList();
        try{
            sql = "SELECT cd_gptrans, ds_gptrans " +
                  "  FROM gptrans" + 
                  " WHERE cd_gptrans = 5 OR cd_gptrans = 6";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                GrupoTransacao gt = new GrupoTransacao(
                    rs.getInt("cd_gptrans"),
                    rs.getString("ds_gptrans"));
                    gptrans.add(gt);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de grupo de transação:\n" +
                    ex.getMessage());
        }
        return gptrans;
    }

    /**
     * <p><strong>EN:</strong> Retrieves a transaction group by its ID.</p>
     *
     * <p><strong>IT:</strong> Recupera un gruppo di transazione tramite il suo ID.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera um grupo de transação pelo seu ID.</p>
     *
     * @param id EN: transaction group ID | IT: ID del gruppo di transazione | PT-BR: ID do grupo de transação
     * @return EN: transaction group object | IT: oggetto gruppo di transazione | PT-BR: objeto grupo de transação
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer um erro de acesso ao banco
     * @since 1.0.0
     */
    public Object getById(int id) {
        GrupoTransacao gptrans = null;
        try{
            sql = "SELECT cd_gptrans, ds_gptrans " +
                  "  FROM gptrans" +
                  " WHERE cd_gptrans = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                    gptrans = new GrupoTransacao(
                    rs.getInt("cd_gptrans"),
                    rs.getString("ds_gptrans"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em Grupo Transação:\n" +
                    ex.getMessage());
        }
        return gptrans;
    }    
}
