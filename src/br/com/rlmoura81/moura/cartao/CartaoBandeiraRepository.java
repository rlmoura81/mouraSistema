package br.com.rlmoura81.moura.cartao;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CartaoBandeiraRepository{
    
    String sql = "";

    /**
     * <p><strong>EN:</strong> Retrieves the list of all card brands (CartaoBandeira) from the database.</p>
     *
     * <p><strong>IT:</strong> Recupera l'elenco di tutte le bandiere di carte (CartaoBandeira) dal database.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera a lista de todas as bandeiras de cartão (CartaoBandeira) do banco de dados.</p>
     *
     * @return EN: list of CartaoBandeira objects | IT: elenco di oggetti CartaoBandeira | PT-BR: lista de objetos CartaoBandeira
     * @since 1.0.0
     */
    public ArrayList getLista() {
        ArrayList cartaobandeira = new ArrayList();
        try{
            sql = "SELECT cd_cartaobandeira, ds_cartaobandeira " +
                  "  FROM cartaobandeira";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                CartaoBandeira cb = new CartaoBandeira(
                    rs.getInt("cd_cartaobandeira"),
                    rs.getString("ds_cartaobandeira"));
                    cartaobandeira.add(cb);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de bandeiras de cartão." + 
                    ex.getMessage(), "Cartão Bandeira", JOptionPane.ERROR_MESSAGE);
        }
        return cartaobandeira;
    }

    /**
     * <p><strong>EN:</strong> Gets a card brand (CartaoBandeira) from the database by its ID.</p>
     *
     * <p><strong>IT:</strong> Recupera una bandiera di carta (CartaoBandeira) dal database tramite il suo ID.</p>
     *
     * <p><strong>PT-BR:</strong> Obtém uma bandeira de cartão (CartaoBandeira) do banco de dados pelo seu ID.</p>
     *
     * @param id EN: unique identifier of the card brand | IT: identificatore univoco della bandiera di carta | PT-BR: identificador único da bandeira de cartão
     * @return EN: CartaoBandeira object if found, otherwise null | IT: oggetto CartaoBandeira se trovato, altrimenti null | PT-BR: objeto CartaoBandeira se encontrado, caso contrário null
     * @since 1.0.0
     */
    public Object getById(int id) {
        CartaoBandeira cb = null;
        try{
            sql = "SELECT cd_cartaobandeira, ds_cartaobandeira " +
                  "  FROM cartaobandeira" +
                  " WHERE cd_cartaobandeira = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                cb = new CartaoBandeira(
                    rs.getInt("cd_cartaobandeira"),
                    rs.getString("ds_cartaobandeira"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em cartao bandeira." + 
                    ex.getMessage(), "Cartão Bandeira", JOptionPane.ERROR_MESSAGE);
        }
        return cb;
    }
}
