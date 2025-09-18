package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TipoRendaRepository{

    String sql = "";

    /**
     * <p><strong>EN:</strong> Retrieves a list of all income types (TipoRenda) from the database.</p>
     * <p><strong>IT:</strong> Recupera un elenco di tutti i tipi di reddito (TipoRenda) dal database.</p>
     * <p><strong>PT-BR:</strong> Retorna uma lista com todos os tipos de renda (TipoRenda) do banco de dados.</p>
     *
     * @return EN: List of income types | IT: Elenco dei tipi di reddito | PT-BR: Lista de tipos de renda
     * @since 1.0.0
     */
    public ArrayList getLista() {
        ArrayList tprenda = new ArrayList();
        try {
            sql = "SELECT cd_tprenda, ds_tprenda " +
                  "  FROM tprenda";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                TipoRenda tr = new TipoRenda(
                    rs.getInt("cd_tprenda"),
                    rs.getString("ds_tprenda"));
                    tprenda.add(tr);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Tipo de Renda:\n" +
                    ex);
        }
        return tprenda;
    }

    /**
     * <p><strong>EN:</strong> Retrieves a specific income type (TipoRenda) by its ID.</p>
     * <p><strong>IT:</strong> Recupera un tipo di reddito (TipoRenda) specifico tramite il suo ID.</p>
     * <p><strong>PT-BR:</strong> Retorna um tipo de renda (TipoRenda) específico pelo seu ID.</p>
     *
     * @param id EN: Income type identifier | IT: Identificatore del tipo di reddito | PT-BR: Identificador do tipo de renda
     * @return EN: Income type object or null if not found | IT: Oggetto TipoRenda o null se non trovato | PT-BR: Objeto TipoRenda ou null se não encontrado
     * @since 1.0.0
     */
    public Object getById(int id) {
        TipoRenda tprenda = null;
        try {
            sql = "SELECT cd_tprenda, ds_tprenda " +
                  "  FROM tprenda" +
                  " WHERE cd_tprenda = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                tprenda = new TipoRenda(
                    rs.getInt("cd_tprenda"),
                    rs.getString("ds_tprenda"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em Tipo de Renda:\n" +
                    ex);
        }
        return tprenda;
    }
    
}
