package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MoedaValorRepository implements IPadraoRepository{

    String sql = "";    
    Utilidade util = new Utilidade();    
    MoedaRepository moedar = new MoedaRepository();

    /**
     * <p><strong>EN:</strong> Inserts a currency value record into the database.</p>
     *
     * <p><strong>IT:</strong> Inserisce un record di valore della valuta nel database.</p>
     *
     * <p><strong>PT-BR:</strong> Insere um registro de valor da moeda no banco de dados.</p>
     *
     * @param o EN: object representing the currency value | IT: oggetto che rappresenta il valore della valuta | PT-BR: objeto que representa o valor da moeda
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer um erro de acesso ao banco
     * @since 1.0.0
     */
    @Override
    public void inserir(Object o) {
        MoedaValor mv = (MoedaValor) o;        
        try{
            sql = "INSERT INTO moedavalor (cd_moedavl, vl_moeda, dt_valor, cd_moeda, cd_usuario)" +
                  "     VALUES (sq_moedavl.nextval, ?, ?, ?, ?)";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setBigDecimal(1, mv.getVl_moeda());
            ps.setString(2, Utilidade.formatoData.format(mv.getDt_valor().getTime()));
            ps.setInt(3, mv.getMoeda().getCd_moeda());
            ps.setInt(4, mv.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Moeda Valor", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Moeda Valor", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Updates a currency value record in the database.</p>
     *
     * <p><strong>IT:</strong> Aggiorna un record di valore della valuta nel database.</p>
     *
     * <p><strong>PT-BR:</strong> Atualiza um registro de valor da moeda no banco de dados.</p>
     *
     * @param o EN: object representing the currency value to update | IT: oggetto che rappresenta il valore della valuta da aggiornare | PT-BR: objeto que representa o valor da moeda a ser atualizado
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer um erro de acesso ao banco
     * @since 1.0.0
     */
    @Override
    public void alterar(Object o) {
        MoedaValor mv = (MoedaValor) o;        
        try{
            sql = "UPDATE moedavalor " +
                  "   SET vl_moeda = ?, " +
                  "       dt_valor = ?, " +
                  "       cd_moeda = ?, " +
                  "       cd_usuario = ?" +
                  " WHERE cd_moedavl = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setBigDecimal(1, mv.getVl_moeda());
            ps.setString(2, Utilidade.formatoData.format(mv.getDt_valor().getTime()));
            ps.setInt(3, mv.getMoeda().getCd_moeda());
            ps.setInt(4, mv.getCd_usuario());
            ps.setInt(5, mv.getCd_moedavl());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado.", "Moeda Valor", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Moeda Valor", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Deletes a currency value record from the database.</p>
     *
     * <p><strong>IT:</strong> Elimina un record di valore della valuta dal database.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui um registro de valor da moeda do banco de dados.</p>
     *
     * @param o EN: object representing the currency value to delete | IT: oggetto che rappresenta il valore della valuta da eliminare | PT-BR: objeto que representa o valor da moeda a ser excluído
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer um erro de acesso ao banco
     * @since 1.0.0
     */
    @Override
    public void excluir(Object o) {
        MoedaValor mv = (MoedaValor) o;
        try{
            sql = "DELETE FROM moedavalor " +
                  " WHERE cd_moedavl = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, mv.getCd_moedavl());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Moeda Valor", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Moeda Valor", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Retrieves a list of all currency value records.</p>
     *
     * <p><strong>IT:</strong> Recupera un elenco di tutti i record dei valori delle valute.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera uma lista de todos os registros de valores de moedas.</p>
     *
     * @return EN: list of currency value objects | IT: elenco di oggetti valore valuta | PT-BR: lista de objetos de valores de moedas
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer um erro de acesso ao banco
     * @since 1.0.0
     */
    @Override
    public ArrayList getLista() {
        ArrayList moedavalores = new ArrayList();
        try{
            sql = "SELECT cd_moedavl, vl_moeda, to_char(dt_valor,'dd/MM/yyyy'), cd_moeda, cd_usuario" +
                  "  FROM moedavalor";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                MoedaValor mv = new MoedaValor(
                    rs.getInt("cd_moedavl"),
                    rs.getBigDecimal("vl_moeda"),
                    util.recebeData(rs.getString("to_char(dt_valor,'dd/MM/yyyy')")),
                    (Moeda)moedar.getById(rs.getInt("cd_moeda")),
                    rs.getInt("cd_usuario"));
                moedavalores.add(mv);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de cotação:\n" +
                    ex.getMessage(), "Moeda Valor", JOptionPane.ERROR_MESSAGE);
        }
        return moedavalores;
    }

    /**
     * <p><strong>EN:</strong> Retrieves a currency value record by its ID.</p>
     *
     * <p><strong>IT:</strong> Recupera un record di valore della valuta tramite il suo ID.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera um registro de valor da moeda pelo seu ID.</p>
     *
     * @param id EN: currency value ID | IT: ID del valore della valuta | PT-BR: ID do valor da moeda
     * @return EN: currency value object | IT: oggetto valore valuta | PT-BR: objeto de valor da moeda
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer um erro de acesso ao banco
     * @since 1.0.0
     */
    @Override
    public Object getById(int id) {
        MoedaValor mv = null;
        try{
            sql = "SELECT cd_moedavl, vl_moeda, to_char(dt_valor,'dd/MM/yyyy'), cd_moeda, cd_usuario" +
                  "  FROM moedavalor" +
                  " WHERE cd_moedavl = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                mv = new MoedaValor(
                    rs.getInt("cd_moedavl"),
                    rs.getBigDecimal("vl_moeda"),
                    util.recebeData(rs.getString("to_char(dt_valor,'dd/MM/yyyy')")),
                    (Moeda)moedar.getById(rs.getInt("cd_moeda")),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em cotação:\n" +
                    ex.getMessage(), "Moeda Valor", JOptionPane.ERROR_MESSAGE);
        }
        return mv;
    }
}
