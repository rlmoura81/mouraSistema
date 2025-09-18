    package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalcadastro.Categoria;
import br.com.rlmoura81.moura.principalcadastro.CategoriaRepository;
import br.com.rlmoura81.moura.principalcadastro.PrestadorServico;
import br.com.rlmoura81.moura.principalcadastro.PrestadorServicoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DespesaRepository implements IPadraoRepository {
    
    String sql = "";    
    CategoriaRepository categoriar = new CategoriaRepository();    
    PrestadorServicoRepository presservr = new PrestadorServicoRepository();

    /**
     * <p><strong>EN:</strong> Inserts a new expense record into the database using the data from the provided object.</p>
     * <p><strong>IT:</strong> Inserisce un nuovo record di spesa nel database utilizzando i dati dell’oggetto fornito.</p>
     * <p><strong>PT-BR:</strong> Insere um novo registro de despesa no banco de dados usando os dados do objeto informado.</p>
     *
     * @param o EN: expense object to be saved | IT: oggetto spesa da salvare | PT-BR: objeto de despesa a ser salvo
     */
    @Override
    public void inserir(Object o) {
        Despesa d = (Despesa) o;
        try{
            sql = "INSERT INTO despesa (cd_despesa, ds_despesa, nm_valor, cd_categoria, cd_presserv, cd_usuario)"
                + "     VALUES (sq_despesa.nextval, ?, ?, ?, ?, ?)";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, d.getDs_despesa());
            ps.setBigDecimal(2, d.getNm_valor());
            ps.setInt(3, d.getCategoria().getCd_Categoria());
            ps.setInt(4, d.getPresserv().getCd_presserv());
            ps.setInt(5, d.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Despesa.", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                ex.getMessage(), "Despesa", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Updates an existing expense record in the database with the values from the provided object.</p>
     * <p><strong>IT:</strong> Aggiorna un record di spesa esistente nel database con i valori dell’oggetto fornito.</p>
     * <p><strong>PT-BR:</strong> Atualiza um registro de despesa existente no banco de dados com os valores do objeto informado.</p>
     *
     * @param o EN: expense object containing the new values | IT: oggetto spesa con i nuovi valori | PT-BR: objeto de despesa com os novos valores
     */
    @Override
    public void alterar(Object o) {
        Despesa d = (Despesa) o;
        try{
            sql = "UPDATE despesa " +
                  "   SET ds_despesa = ?, " +
                  "       nm_valor = ?, " +
                  "       cd_categoria = ?, " +
                  "       cd_presserv = ? " +
                  " WHERE cd_despesa = ? " +
                  "   AND cd_usuario = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, d.getDs_despesa());
            ps.setBigDecimal(2, d.getNm_valor());
            ps.setInt(3, d.getCategoria().getCd_Categoria());
            ps.setInt(4, d.getPresserv().getCd_presserv());
            ps.setInt(5, d.getCd_despesa());
            ps.setInt(6, d.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado.", "Despesa", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                ex.getMessage(), "Despesa", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Deletes an expense record from the database, matching by expense code and user. Shows a confirmation or an error dialog.</p>
     * <p><strong>IT:</strong> Elimina un record di spesa dal database, corrispondente per codice spesa e utente. Mostra una conferma o un messaggio di errore.</p>
     * <p><strong>PT-BR:</strong> Exclui um registro de despesa do banco de dados, conforme código da despesa e usuário. Exibe confirmação ou mensagem de erro.</p>
     *
     * @param o EN: expense object indicating which record to remove | IT: oggetto spesa che indica quale record rimuovere | PT-BR: objeto de despesa que indica qual registro remover
     */
    @Override
    public void excluir(Object o) {
        Despesa d = (Despesa) o;
        try{
            sql = "DELETE FROM despesa " +
                  " WHERE cd_despesa = ? "+
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, d.getCd_despesa());
            ps.setInt(2, d.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Despesa", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Excluir:\n" +
                    ex.getMessage(), "Despesa", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Retrieves all expenses for the logged-in user, ordered by description, and maps each row to a domain object.</p>
     * <p><strong>IT:</strong> Recupera tutte le spese per l’utente connesso, ordinate per descrizione, mappando ogni riga in un oggetto di dominio.</p>
     * <p><strong>PT-BR:</strong> Recupera todas as despesas do usuário logado, ordenadas pela descrição, mapeando cada linha para um objeto de domínio.</p>
     *
     * @return EN: list of expenses | IT: elenco delle spese | PT-BR: lista de despesas
     */
    @Override
    public ArrayList getLista() {
        ArrayList despesas = new ArrayList();
        try{
            sql = "SELECT cd_despesa, ds_despesa, nm_valor, cd_categoria, cd_presserv, cd_usuario" +
                  "  FROM despesa" +
                  " WHERE cd_usuario = ? " +
                  " ORDER BY ds_despesa";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Despesa d = new Despesa(
                    rs.getInt("cd_despesa"),
                    rs.getString("ds_despesa"),
                    rs.getBigDecimal("nm_valor"),
                    (Categoria)categoriar.getById(rs.getInt("cd_categoria")),
                    (PrestadorServico)presservr.getById(rs.getInt("cd_presserv")),
                    rs.getInt("cd_usuario"));
                    despesas.add(d);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de despesa:\n" + 
                    ex.getMessage());
        }
        return despesas;
    }

    /**
     * <p><strong>EN:</strong> Retrieves all expenses for the given group and current user, joining related tables, sorted by description.</p>
     * <p><strong>IT:</strong> Recupera tutte le spese per il gruppo indicato e l’utente corrente, con join delle tabelle correlate, ordinate per descrizione.</p>
     * <p><strong>PT-BR:</strong> Busca todas as despesas do grupo informado e do usuário atual, realizando joins necessários, ordenadas pela descrição.</p>
     *
     * @param grupo EN: group identifier to filter expenses | IT: identificativo del gruppo per filtrare le spese | PT-BR: identificador do grupo para filtrar as despesas
     * @return EN: list of expenses for the group | IT: elenco delle spese del gruppo | PT-BR: lista de despesas do grupo
     */
    public ArrayList getLista(int grupo) {
        ArrayList despesas = new ArrayList();
        try{
            sql = "SELECT cd_despesa, ds_despesa, nm_valor, categoria.cd_categoria, cd_presserv, despesa.cd_usuario" +
                  "  FROM despesa, grupo, categoria" +
                  " WHERE categoria.cd_grupo = grupo.cd_grupo" +
                  "   AND grupo.cd_grupo = ?" +
                  "   AND categoria.cd_categoria = despesa.cd_categoria" +
                  "   AND despesa.cd_usuario = ?" +
                  " ORDER BY ds_despesa";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, grupo);
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Despesa d = new Despesa(
                    rs.getInt("cd_despesa"),
                    rs.getString("ds_despesa"),
                    rs.getBigDecimal("nm_valor"),
                    (Categoria)categoriar.getById(rs.getInt("cd_categoria")),
                    (PrestadorServico)presservr.getById(rs.getInt("cd_presserv")),
                    rs.getInt("cd_usuario"));
                    despesas.add(d);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de despesa por grupo:\n" + 
                    ex.getMessage());
        }
        return despesas;
    }    

    /**
     * <p><strong>EN:</strong> Retrieves a single expense by its code, building the corresponding domain object from the result set.</p>
     * <p><strong>IT:</strong> Recupera una singola spesa tramite il suo codice, costruendo l’oggetto di dominio dai risultati.</p>
     * <p><strong>PT-BR:</strong> Recupera uma única despesa pelo seu código, montando o objeto de domínio a partir do resultado.</p>
     *
     * @param id EN: expense code to search | IT: codice della spesa da cercare | PT-BR: código da despesa a pesquisar
     * @return EN: the found expense or null if not found | IT: la spesa trovata o null se non trovata | PT-BR: a despesa encontrada ou null se não existir
     */
    @Override
    public Object getById(int id) {
        Despesa d = null;
        try{
            sql = "SELECT cd_despesa, ds_despesa, nm_valor, cd_categoria, cd_presserv, cd_usuario" +
                  "  FROM despesa" +
                  " WHERE cd_despesa = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Categoria categoria = new Categoria();
                categoria.setCd_Categoria(rs.getInt("cd_categoria"));                
                PrestadorServico presserv = new PrestadorServico();
                presserv.setCd_presserv(rs.getInt("cd_presserv"));                
                d = new Despesa(
                    rs.getInt("cd_despesa"),
                    rs.getString("ds_despesa"),
                    rs.getBigDecimal("nm_valor"),
                    categoria,
                    presserv,
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em despesa:\n" +
                    ex.getMessage());
        }
        return d;
    }
    
}
