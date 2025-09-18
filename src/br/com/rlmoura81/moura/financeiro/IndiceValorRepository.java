package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class IndiceValorRepository implements IPadraoRepository{
    
    String sql = "";    
    Utilidade util = new Utilidade();    
    IndiceRepository indicer = new IndiceRepository();

    /**
     * <p><strong>EN:</strong> Inserts an index value record into the database.</p>
     *
     * <p><strong>IT:</strong> Inserisce un record di valore indice nel database.</p>
     *
     * <p><strong>PT-BR:</strong> Insere um registro de valor de índice no banco de dados.</p>
     *
     * @param o EN: index value object to be inserted | IT: oggetto valore indice da inserire | PT-BR: objeto valor índice a ser inserido
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco
     * @since 1.0.0
     */
    @Override
    public void inserir(Object o) {
        IndiceValor iv = (IndiceValor) o;        
        try{
            sql = "INSERT INTO indicevalor (cd_indicevl, dt_vlatualizado, vl_mes, cd_indice, cd_usuario)" +
                  "     VALUES (sq_indicevl.nextval, ?, ?, ?, ?)";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, Utilidade.formatoData.format(iv.getDt_vlatualizado().getTime()));
            ps.setBigDecimal(2, iv.getVl_mes());
            ps.setInt(3, iv.getIndice().getCd_indice());
            ps.setInt(4, iv.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Índice Valor", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" + 
                    ex.getMessage(), "Índicie Valor", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void alterar(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * <p><strong>EN:</strong> Deletes an index value record from the database.</p>
     *
     * <p><strong>IT:</strong> Elimina un record di valore indice dal database.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui um registro de valor de índice do banco de dados.</p>
     *
     * @param o EN: index value object to be deleted | IT: oggetto valore indice da eliminare | PT-BR: objeto valor índice a ser excluído
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco
     * @since 1.0.0
     */
    @Override
    public void excluir(Object o) {
        IndiceValor iv = (IndiceValor) o;
        try{
            sql = "DELETE FROM indicevalor " +
                  " WHERE cd_indicevl = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, iv.getCd_indicevl());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Índice Valor", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Índice Valor", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Retrieves the list of all index values from the database.</p>
     *
     * <p><strong>IT:</strong> Recupera l'elenco di tutti i valori indice dal database.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera a lista de todos os valores de índice do banco de dados.</p>
     *
     * @return EN: list of index value objects | IT: elenco di oggetti valore indice | PT-BR: lista de objetos de valores de índice
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco
     * @since 1.0.0
     */
    @Override
    public ArrayList getLista() {
        ArrayList indicevalores = new ArrayList();
        try{
            sql = "SELECT cd_indicevl, to_char(dt_vlatualizado,'dd/MM/yyyy'), vl_mes, cd_indice, cd_usuario " +
                  "  FROM indicevalor " +
                  " ORDER BY cd_indice, dt_vlatualizado";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                IndiceValor iv = new IndiceValor(
                    rs.getInt("cd_indicevl"),
                    rs.getBigDecimal("vl_mes"),
                    util.recebeData(rs.getString("to_char(dt_vlatualizado,'dd/MM/yyyy')")),    
                    (Indice)indicer.getById(rs.getInt("cd_indice")),
                    rs.getInt("cd_usuario"));
                indicevalores.add(iv);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Indice de Valores:\n" +
                    ex.getMessage(), "Índice Valor", JOptionPane.ERROR_MESSAGE);
        }
        return indicevalores;
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves the list of index values for a specific index.</p>
     *
     * <p><strong>IT:</strong> Recupera l'elenco dei valori indice per un indice specifico.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera a lista de valores de índice para um índice específico.</p>
     *
     * @param cd_indice EN: index identifier | IT: identificatore indice | PT-BR: identificador do índice
     * @return EN: list of index value objects | IT: elenco di oggetti valore indice | PT-BR: lista de objetos de valores de índice
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco
     * @since 1.0.0
     */
    public ArrayList getLista(int cd_indice) {
        ArrayList indicevalores = new ArrayList();
        try{
            sql = "SELECT cd_indicevl, to_char(dt_vlatualizado,'dd/MM/yyyy'), vl_mes, cd_indice, cd_usuario " +
                  "   FROM indicevalor " +
                  "   WHERE cd_indice = ?" +
                  "   ORDER BY cd_indice, dt_vlatualizado";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_indice);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                IndiceValor iv = new IndiceValor(
                    rs.getInt("cd_indicevl"),
                    rs.getBigDecimal("vl_mes"),
                    util.recebeData(rs.getString("to_char(dt_vlatualizado,'dd/MM/yyyy')")),    
                    (Indice)indicer.getById(rs.getInt("cd_indice")),
                    rs.getInt("cd_usuario"));
                indicevalores.add(iv);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Indice de Valores:\n" +
                    ex.getMessage(), "Índice Valor", JOptionPane.ERROR_MESSAGE);
        }
        return indicevalores;
    }

    /**
     * <p><strong>EN:</strong> Retrieves an index value record by its identifier.</p>
     *
     * <p><strong>IT:</strong> Recupera un record di valore indice tramite identificatore.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera um registro de valor de índice pelo seu identificador.</p>
     *
     * @param id EN: index value identifier | IT: identificatore valore indice | PT-BR: identificador do valor índice
     * @return EN: index value object | IT: oggetto valore indice | PT-BR: objeto valor índice
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco
     * @since 1.0.0
     */
    @Override
    public Object getById(int id) {
        IndiceValor iv = null;
        try{
            sql = "SELECT cd_indicevl, to_char(dt_vlatualizado,'dd/MM/yyyy'), vl_mes, cd_indice, cd_usuario " +
                  "  FROM indicevalor " +
                  " WHERE cd_indicevl = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                iv = new IndiceValor(
                rs.getInt("cd_indicevl"),
                rs.getBigDecimal("vl_mes"),
                util.recebeData(rs.getString("to_char(dt_vlatualizado,'dd/MM/yyyy')")),    
                (Indice)indicer.getById(rs.getInt("cd_indice")),
                rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em Indice de Valores:\n" +
                    ex.getMessage(), "Índice Valor", JOptionPane.ERROR_MESSAGE);
        }
        return iv;
    }
   
    /**
     * <p><strong>EN:</strong> Retrieves the latest value for a specific index.</p>
     *
     * <p><strong>IT:</strong> Recupera l'ultimo valore per un indice specifico.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera o último valor para um índice específico.</p>
     *
     * @param cd_indice EN: index identifier | IT: identificatore indice | PT-BR: identificador do índice
     * @return EN: latest index value object | IT: ultimo oggetto valore indice | PT-BR: último objeto de valor de índice
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco
     * @since 1.0.0
     */
    public Object getValorIndice(int cd_indice) {
        IndiceValor iv = null;
        try{
            sql = "SELECT cd_indicevl, to_char(dt_vlatualizado,'dd/MM/yyyy'), vl_mes, cd_indice, cd_usuario " +
                  "  FROM indicevalor " +
                  " WHERE cd_indice = ?" + 
                  " ORDER BY dt_vlatualizado DESC";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_indice);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                iv = new IndiceValor(
                rs.getInt("cd_indicevl"),
                rs.getBigDecimal("vl_mes"),
                util.recebeData(rs.getString("to_char(dt_vlatualizado,'dd/MM/yyyy')")),    
                (Indice)indicer.getById(rs.getInt("cd_indice")),
                rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getByValorIndice em Indice de Valores:\n" +
                    ex.getMessage());
        }
        return iv;
    }
}    

