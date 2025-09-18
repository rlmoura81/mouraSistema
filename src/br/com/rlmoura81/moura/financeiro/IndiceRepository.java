package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class IndiceRepository{
    
    String sql = "";

    /**
     * <p><strong>EN:</strong> Retrieves the complete list of indices from the database.</p>
     *
     * <p><strong>IT:</strong> Recupera l'elenco completo degli indici dal database.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera a lista completa de índices do banco de dados.</p>
     *
     * @return EN: list of indices | IT: elenco degli indici | PT-BR: lista de índices
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer um erro de acesso ao banco de dados
     * @since 1.0.0
     */
    public ArrayList getLista() {
        ArrayList indice = new ArrayList();
        try{
            sql = "SELECT cd_indice, ds_indice " +
                  "  FROM indice";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Indice i = new Indice(
                    rs.getInt("cd_indice"),
                    rs.getString("ds_indice"));
                    indice.add(i);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de índices:\n" +
                    ex.getMessage(), "Índice", JOptionPane.ERROR_MESSAGE);
        }
        return indice;
    }

    /**
     * <p><strong>EN:</strong> Retrieves an index record by its ID.</p>
     *
     * <p><strong>IT:</strong> Recupera un record di indice tramite il suo ID.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera um registro de índice pelo seu ID.</p>
     *
     * @param id EN: index identifier | IT: identificatore dell'indice | PT-BR: identificador do índice
     * @return EN: index object matching the given ID | IT: oggetto indice corrispondente all'ID fornito | PT-BR: objeto índice correspondente ao ID informado
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer um erro de acesso ao banco de dados
     * @since 1.0.0
     */
    public Object getById(int id) {
        Indice indice = null;
        try{
            sql = "SELECT cd_indice, ds_indice " +
                  "  FROM indice" +
                  " WHERE cd_indice = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                    indice = new Indice(
                    rs.getInt("cd_indice"),
                    rs.getString("ds_indice"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em índices:\n" +
                    ex.getMessage(), "Índice", JOptionPane.ERROR_MESSAGE);
        }
        return indice;
    }    
}
