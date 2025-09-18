package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class BancoRepository implements IPadraoRepository{

    String sql = "";

    /**
     * <p><strong>EN:</strong> Inserts a new bank into the database using the provided entity fields
     * (name/description, bank code/number, and user ID). Shows a success or error message.</p>
     * <p><strong>IT:</strong> Inserisce una nuova banca nel database utilizzando i campi dell’entità
     * (nome/descrizione, codice/numero banca e ID utente). Mostra un messaggio di successo o errore.</p>
     * <p><strong>PT-BR:</strong> Insere um novo banco no banco de dados utilizando os campos da entidade
     * (nome/descrição, código/número do banco e ID do usuário). Exibe mensagem de sucesso ou erro.</p>
     *
     * @param o EN: bank entity to insert | IT: entità banca da inserire | PT-BR: entidade banco a ser inserida
     */
    @Override
    public void inserir(Object o) {
       Banco b = (Banco) o;
       try{
           sql = "INSERT INTO banco (cd_banco, ds_banco, nm_banco, cd_usuario)" +
                 "     VALUES (sq_banco.nextval, ?, ?, ?)";
           PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
           ps.setString(1, b.getDs_banco());
           ps.setInt(2, b.getNm_banco());
           ps.setInt(3, b.getCd_usuario());
           ps.execute();
           ps.close();
           JOptionPane.showMessageDialog(null, "Salvo.", "Banco", JOptionPane.INFORMATION_MESSAGE);
       }catch(SQLException ex){
           JOptionPane.showMessageDialog(null, "Erro ao slvar:\n" +
                ex.getMessage(), "Banco", JOptionPane.ERROR_MESSAGE);
       }
    }

    /**
     * <p><strong>EN:</strong> Updates an existing bank in the database (description, bank number, user ID)
     * identified by its ID. Shows a success or error message.</p>
     * <p><strong>IT:</strong> Aggiorna una banca esistente nel database (descrizione, numero banca, ID utente)
     * identificata dal suo ID. Mostra un messaggio di successo o errore.</p>
     * <p><strong>PT-BR:</strong> Altera um banco existente no banco de dados (descrição, número do banco, ID do usuário)
     * identificado pelo seu ID. Exibe mensagem de sucesso ou erro.</p>
     *
     * @param o EN: bank entity with updated data and existing ID | IT: entità banca con dati aggiornati e ID esistente | PT-BR: entidade banco com dados atualizados e ID existente
     */
    @Override
    public void alterar(Object o) {
        Banco b = (Banco) o;
        try{
            sql = "UPDATE banco " +
                  "   SET ds_banco = ?, " +
                  "       nm_banco = ?, " +
                  "       cd_usuario = ? " +
                  " WHERE cd_banco = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, b.getDs_banco());
            ps.setInt(2, b.getNm_banco());
            ps.setInt(3, b.getCd_usuario());
            ps.setInt(4, b.getCd_banco());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado.", "Banco", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" + 
                    ex.getMessage(), "Banco", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Deletes a bank from the database by its ID. Shows a success or error message.</p>
     * <p><strong>IT:</strong> Elimina una banca dal database tramite il suo ID. Mostra un messaggio di successo o errore.</p>
     * <p><strong>PT-BR:</strong> Exclui um banco do banco de dados pelo seu ID. Exibe mensagem de sucesso ou erro.</p>
     *
     * @param o EN: bank entity containing the ID to delete | IT: entità banca contenente l’ID da eliminare | PT-BR: entidade banco contendo o ID a ser excluído
     */
    @Override
    public void excluir(Object o) {
        Banco b = (Banco) o;
        try{
            sql = "DELETE FROM banco " +
                  " WHERE cd_banco = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, b.getCd_banco());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Banco", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" + 
                    ex.getMessage(), "Banco", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Retrieves all banks ordered by name/description and returns them as a list.</p>
     * <p><strong>IT:</strong> Recupera tutte le banche ordinate per nome/descrizione e le restituisce come elenco.</p>
     * <p><strong>PT-BR:</strong> Recupera todos os bancos ordenados por nome/descrição e retorna em uma lista.</p>
     *
     * @return EN: list of bank entities | IT: elenco di entità banca | PT-BR: lista de entidades banco
     */
    @Override
    public ArrayList getLista() {
        ArrayList bancos = new ArrayList();
        try{
            sql = "SELECT cd_banco, ds_banco, nm_banco, cd_usuario" +
                  "  FROM banco" +
                  " ORDER BY ds_banco";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Banco b = new Banco(
                        rs.getInt("cd_banco"),
                        rs.getString("ds_banco"),
                        rs.getInt("nm_banco"),
                        rs.getInt("cd_usuario"));
                        bancos.add(b);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de bancos:\n" + 
                    ex.getMessage(), "Banco", JOptionPane.ERROR_MESSAGE);
        }
        return bancos;
    }

    /**
     * <p><strong>EN:</strong> Retrieves a single bank by its ID and returns the corresponding entity.</p>
     * <p><strong>IT:</strong> Recupera una singola banca tramite il suo ID e restituisce l’entità corrispondente.</p>
     * <p><strong>PT-BR:</strong> Recupera um banco pelo seu ID e retorna a entidade correspondente.</p>
     *
     * @param id EN: bank ID to look up | IT: ID della banca da cercare | PT-BR: ID do banco a consultar
     * @return EN: bank entity or null if not found | IT: entità banca o null se non trovata | PT-BR: entidade banco ou null se não encontrada
     */
    @Override
    public Object getById(int id) {
        Banco b = null;
        try{
            sql = "SELECT cd_banco, ds_banco, nm_banco, cd_usuario" +
                  "  FROM banco" +
                  " WHERE cd_banco = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                b =  new Banco(
                    rs.getInt("cd_banco"),
                    rs.getString("ds_banco"),
                    rs.getInt("nm_banco"),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em banco:\n" +
                ex.getMessage(), "Banco", JOptionPane.ERROR_MESSAGE);
        }
        return b;
    }
}
