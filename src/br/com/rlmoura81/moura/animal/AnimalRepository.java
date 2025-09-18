package br.com.rlmoura81.moura.animal;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AnimalRepository implements IPadraoRepository{

    String sql = "";
    RacaRepository racar = new RacaRepository();    
    Utilidade util = new Utilidade();
    
    /**
     * <p><strong>EN:</strong> Inserts object into the animal table.</p>
     *
     * <p><strong>IT:</strong> Inserisce oggetto nella tabella animale.</p>
     *
     * <p><strong>PT-BR:</strong> Insere objeto na tabela animal.</p>
     *
     * @param animal EN: object to be inserted | IT: oggetto da inserire | PT-BR: objeto a ser inserido
     * @return EN: created record in the animal table | IT: record creato nella tabella animale | PT-BR: registro criado na tabela animal
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco
     * @since 1.0.0
     */    
    @Override
    public void inserir(Object o) {    
        Animal a = (Animal) o;        
        try{
            sql = "INSERT INTO animal (cd_animal, ds_nome, dt_nasc, ds_sexo, cd_raca, cd_usuario)" +
                  "     VALUES (sq_animal.nextval, ?, ?, ?, ?, ?)";            
                PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
                ps.setString(1, a.getDs_nome());
                ps.setString(2, Utilidade.formatoData.format(a.getDt_nasc().getTime()));
                ps.setString(3, a.getDs_sexo());
                ps.setInt(4, a.getRaca().getCd_raca());
                ps.setInt(5, a.getCd_usuario());
                ps.execute();
                ps.close();
                JOptionPane.showMessageDialog(null, "Salvo.", "Animal", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Animal", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * <p><strong>EN:</strong> Updates existing object in the animal table.</p>
     *
     * <p><strong>IT:</strong> Aggiorna oggetto esistente nella tabella animale.</p>
     *
     * <p><strong>PT-BR:</strong> Atualiza objeto existente na tabela animal.</p>
     *
     * @param animal EN: object to be updated | IT: oggetto da aggiornare | PT-BR: objeto a ser atualizado
     * @return EN: updated record in the animal table | IT: record aggiornato nella tabella animale | PT-BR: registro atualizado na tabela animal
     * @throws SQLException EN: if not found or database error occurs | IT: se non trovato o se si verifica un errore del database | PT-BR: se não encontrar ou ocorrer erro no banco
     * @since 1.0.0
     */    
    @Override
    public void alterar(Object o) {    
        Animal a = (Animal) o;              
        try{
            sql = "UPDATE animal " +
                  "   SET ds_nome = ?, " +
                  "       dt_nasc = ?, " +
                  "       ds_sexo = ?, " +  
                  "       cd_raca = ?" +
                  " WHERE cd_animal = ? " +
                  "   AND cd_usuario = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, a.getDs_nome());
            ps.setString(2, Utilidade.formatoData.format(a.getDt_nasc()));
            ps.setString(3, a.getDs_sexo());
            ps.setInt(4, a.getRaca().getCd_raca());
            ps.setInt(5, a.getCd_animal());
            ps.setInt(6, a.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado.", "Animal", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Animal", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * <p><strong>EN:</strong> Deletes object from the animal table by ID.</p>
     *
     * <p><strong>IT:</strong> Elimina oggetto dalla tabella animale per ID.</p>
     *
     * <p><strong>PT-BR:</strong> Remove objeto da tabela animal pelo ID.</p>
     *
     * @param id EN: unique identifier of the animal | IT: identificatore univoco dell'animale | PT-BR: identificador único do animal
     * @return EN: true if deletion was successful | IT: vero se l'eliminazione ha avuto successo | PT-BR: verdadeiro se a exclusão foi bem-sucedida
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco
     * @since 1.0.0
     */
    @Override
    public void excluir(Object o) {    
        Animal a = (Animal) o;        
        try{
            sql = "DELETE FROM animal "   +
                  " WHERE cd_animal = ? " +
                  "   AND cd_usuario = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, a.getCd_animal());
            ps.setInt(2, a.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Animal", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Animal", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Retrieves a list of animals from the database for the logged-in user.</p>
     *
     * <p><strong>IT:</strong> Recupera un elenco di animali dal database per l'utente connesso.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera uma lista de animais do banco de dados para o usuário logado.</p>
     *
     * @return EN: list of Animal objects | IT: elenco di oggetti Animal | PT-BR: lista de objetos Animal
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco
     * @since 1.0.0
     */
    @Override
    public ArrayList getLista() {        
        ArrayList animais = new ArrayList();        
        try{
            sql = "SELECT cd_animal, ds_nome, to_char(dt_nasc,'dd/MM/yyyy'), ds_sexo, cd_raca, cd_usuario" +
                  "  FROM animal" +
                  " WHERE cd_usuario = ?" +
                  " ORDER BY ds_nome";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while (rs.next()){
                Animal a = new Animal(
                    rs.getInt("cd_animal"),
                    rs.getString("ds_nome"),
                    util.recebeData(rs.getString("to_char(dt_nasc,'dd/MM/yyyy')")),
                    rs.getString("ds_sexo"),
                    (Raca)racar.getById(rs.getInt("cd_raca")),
                    rs.getInt("cd_usuario"));
                animais.add(a);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de animais:\n" +
                    ex.getMessage(), "Animal", JOptionPane.ERROR_MESSAGE);
        }
        return animais;
    }

    /**
     * <p><strong>EN:</strong> Gets an Animal from the database by its ID.</p>
     *
     * <p><strong>IT:</strong> Recupera un oggetto Animal dal database tramite il suo ID.</p>
     *
     * <p><strong>PT-BR:</strong> Obtém um objeto Animal do banco de dados pelo seu ID.</p>
     *
     * @param id EN: unique identifier of the animal | IT: identificatore univoco dell'animale | PT-BR: identificador único do animal
     * @return EN: Animal object if found, otherwise null | IT: Oggetto Animal se trovato, altrimenti null | PT-BR: Objeto Animal se encontrado, caso contrário null
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco
     * @since 1.0.0
     */
    @Override
    public Object getById(int id) {        
        Animal a = null;        
        try{
            sql = "SELECT cd_animal, ds_nome, to_char(dt_nasc,'dd/MM/yyyy'), ds_sexo, cd_raca, cd_usuario" +
                  "  FROM animal" +
                  " WHERE cd_animal = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                a = new Animal(
                    rs.getInt("cd_animal"),
                    rs.getString("ds_nome"),
                    util.recebeData(rs.getString("to_char(dt_nasc,'dd/MM/yyyy')")),
                    rs.getString("ds_sexo"),
                    (Raca)racar.getById(rs.getInt("cd_raca")),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em animal:\n"  +  
                    ex.getMessage(), "Animal", JOptionPane.ERROR_MESSAGE);
        }
        return a;
    }    
}
