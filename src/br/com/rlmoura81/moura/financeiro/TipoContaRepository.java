package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TipoContaRepository{

    String sql = "";

    /**
     * <p><strong>EN:</strong> Retrieves a list of all account types from the database.</p>
     * <p><strong>IT:</strong> Recupera un elenco di tutti i tipi di conto dal database.</p>
     * <p><strong>PT-BR:</strong> Retorna uma lista de todos os tipos de conta do banco de dados.</p>
     *
     * @return EN: List of account types | IT: Elenco dei tipi di conto | PT-BR: Lista de tipos de conta
     * @since 1.0.0
     */
    public ArrayList getLista() {
        ArrayList tipoconta = new ArrayList();
        try{
            sql = "SELECT cd_tpconta, ds_tpconta " +
                  "  FROM tipoconta";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();             
            while(rs.next()){
                TipoConta tpc = new TipoConta(
                    rs.getInt("cd_tpconta"),
                    rs.getString("ds_tpconta"));
                    tipoconta.add(tpc);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de tipo de contas:\n" + 
                    ex.getMessage(), "Tipo de conta", JOptionPane.ERROR_MESSAGE);
        }
        return tipoconta;
    }

    /**
     * <p><strong>EN:</strong> Retrieves an account type by its identifier.</p>
     * <p><strong>IT:</strong> Recupera un tipo di conto in base al suo identificatore.</p>
     * <p><strong>PT-BR:</strong> Retorna um tipo de conta pelo seu identificador.</p>
     *
     * @param id EN: Account type ID | IT: ID del tipo di conto | PT-BR: ID do tipo de conta
     * @return EN: Account type object or null if not found | IT: Oggetto TipoConto o null se non trovato | PT-BR: Objeto TipoConta ou null se não encontrado
     * @since 1.0.0
     */
    public Object getById(int id) {
        TipoConta tpc = null;
        try{
            sql = "SELECT cd_tpconta, ds_tpconta " +
                  "  FROM tipoconta" +
                  " WHERE cd_tpconta = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                tpc = new TipoConta(
                rs.getInt("cd_tpconta"),
                rs.getString("ds_tpconta"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em tipo de contas:\n" + 
                    ex.getMessage(), "Tipo de conta", JOptionPane.ERROR_MESSAGE);
        }
        return tpc;
    }
    
}
