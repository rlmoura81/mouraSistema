package br.com.rlmoura81.moura.principal;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UsuarioRepository {

    String sql = "";    
    PessoaFisicaRepository pessoafisicar = new PessoaFisicaRepository();
    
    /**
     * <p><strong>EN:</strong> Inserts a new <code>Usuario</code> into the database.
     * Persists login, password, and the linked <code>PessoaFisica</code>; shows a confirmation dialog on success.</p>
     *
     * <p><strong>IT:</strong> Inserisce un nuovo <code>Usuario</code> nel database.
     * Salva login, password e la <code>PessoaFisica</code> associata; mostra una conferma in caso di successo.</p>
     *
     * <p><strong>PT-BR:</strong> Insere um novo <code>Usuario</code> no banco de dados.
     * Grava login, senha e a <code>PessoaFisica</code> vinculada; exibe confirmação em caso de sucesso.</p>
     */
    public void inserir(Object o){        
        Usuario user = (Usuario) o;        
        try{        
            sql =  "INSERT INTO usuario (cd_usuario, ds_login, ds_senha, cd_pessoafisica)" + 
                   "     VALUES(sq_usuario.nextval, ?, ?, ?)";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, user.getDs_login());
            ps.setString(2, user.getDs_senha());
            ps.setInt(3, user.getPessoa().getCd_Pessoa());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Usuario", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Usuario", JOptionPane.ERROR_MESSAGE);
        }    
    }
    
    /**
     * <p><strong>EN:</strong> Updates an existing <code>Usuario</code>.
     * Modifies the password and the associated <code>PessoaFisica</code> based on the user ID.</p>
     *
     * <p><strong>IT:</strong> Aggiorna un <code>Usuario</code> esistente.
     * Modifica la password e la <code>PessoaFisica</code> associata in base all’ID utente.</p>
     *
     * <p><strong>PT-BR:</strong> Atualiza um <code>Usuario</code> existente.
     * Altera a senha e a <code>PessoaFisica</code> associada com base no ID do usuário.</p>
     */
    public void alterar(Object o){        
        Usuario user = (Usuario) o;
        try{
            sql = "UPDATE usuario " +
                  "   SET ds_senha = ?, " +
                  "       cd_pessoafisica = ?" +
                  " WHERE cd_usuario = ?";                  
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, user.getDs_senha());
            ps.setInt(2, user.getPessoa().getCd_Pessoa());
            ps.setInt(3, user.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado.", "Usuario", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Usuario", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * <p><strong>EN:</strong> Deletes the specified <code>Usuario</code> by ID.
     * Executes a removal and shows a confirmation dialog upon success.</p>
     *
     * <p><strong>IT:</strong> Elimina il <code>Usuario</code> specificato per ID.
     * Esegue la rimozione e mostra un messaggio di conferma in caso di successo.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui o <code>Usuario</code> informado pelo ID.
     * Realiza a remoção e exibe mensagem de confirmação ao concluir.</p>
     */
    public void excluir(Object o){        
        Usuario user = (Usuario) o;
        try{
            sql = "DELETE FROM usuario " +
                  " WHERE cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, user.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido", "Usuario", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Usuario", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Retrieves all <code>Usuario</code> records.
     * Queries the database ordered by login and maps each row to a <code>Usuario</code> object.</p>
     *
     * <p><strong>IT:</strong> Recupera tutti i record di <code>Usuario</code>.
     * Interroga il database ordinando per login e mappa ogni riga a un oggetto <code>Usuario</code>.</p>
     *
     * <p><strong>PT-BR:</strong> Busca todos os registros de <code>Usuario</code>.
     * Consulta o banco de dados ordenando por login e mapeia cada linha para um objeto <code>Usuario</code>.</p>
     */
    public ArrayList getLista(){        
        ArrayList usuarios = new ArrayList();         
        try{
            sql = "SELECT cd_usuario, ds_login, ds_senha, cd_pessoafisica " +
                  "  FROM usuario " +
                  " ORDER BY ds_login";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while (rs.next()) {            
                Usuario user = new Usuario(
                        rs.getInt("cd_usuario"),
                        rs.getString("ds_login"),
                        rs.getString("ds_senha"),
                        (PessoaFisica)pessoafisicar.getById(rs.getInt("cd_pessoafisica")));
                usuarios.add(user);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de usuários:\n" +
                    ex.getMessage(), "Usuario", JOptionPane.ERROR_MESSAGE);
        }
        return usuarios;
    }

    /**
     * <p><strong>EN:</strong> Retrieves a single <code>Usuario</code> by its ID.
     * Executes a parameterized query and returns the mapped <code>Usuario</code> if found.</p>
     *
     * <p><strong>IT:</strong> Recupera un singolo <code>Usuario</code> tramite il suo ID.
     * Esegue una query parametrizzata e restituisce il <code>Usuario</code> mappato se trovato.</p>
     *
     * <p><strong>PT-BR:</strong> Obtém um único <code>Usuario</code> pelo seu ID.
     * Executa uma consulta parametrizada e retorna o <code>Usuario</code> mapeado se encontrado.</p>
     */
    public Object getById(int id){        
        Usuario user = null;        
        try{
            sql = "SELECT cd_usuario, ds_login, ds_senha, cd_pessoafisica " +
                  "  FROM usuario " +
                  " WHERE cd_usuario = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ps.setInt(1, user.getCd_usuario());
            if(rs.next()){
                user = new Usuario(
                        rs.getInt("cd_usuario"),
                        rs.getString("ds_login"),
                        rs.getString("ds_senha"),
                        (PessoaFisica)pessoafisicar.getById(rs.getInt("cd_pessoafisica")));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em usuario:\n" +
                    ex.getMessage(), "Usuario", JOptionPane.ERROR_MESSAGE);
        }
        return user;
    }
}
