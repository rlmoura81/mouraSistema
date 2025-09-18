package br.com.rlmoura81.moura.principalcadastro;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EstadoRepository {
    
    String sql = "";
         
    /**
     * <p><strong>EN:</strong> Inserts a new State record into the database.
     * Uses a sequence to generate the primary key and persists the provided State data.</p>
     *
     * <p><strong>IT:</strong> Inserisce un nuovo record di Stato nel database.
     * Utilizza una sequenza per generare la chiave primaria e salva i dati forniti dello Stato.</p>
     *
     * <p><strong>PT-BR:</strong> Insere um novo registro de Estado no banco de dados.
     * Utiliza uma sequência para gerar a chave primária e persiste os dados informados do Estado.</p>
     */
    public void inserir(Object o){        
        Estado e = (Estado) o;        
        try{
            sql = "INSERT INTO estado (cd_estado, ds_estado, ds_siglaestado) " +
                  "     VALUES (sq_estado.nextval, ?, ?)";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, e.getDs_estado());
            ps.setString(2, e.getDs_siglaEstado());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Estado", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Estado", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * <p><strong>EN:</strong> Updates an existing State record.
     * Modifies the state name and abbreviation based on its ID.</p>
     *
     * <p><strong>IT:</strong> Aggiorna un record di Stato esistente.
     * Modifica il nome e la sigla dello stato in base al suo ID.</p>
     *
     * <p><strong>PT-BR:</strong> Atualiza um registro existente de Estado.
     * Altera o nome e a sigla do estado com base no seu ID.</p>
     */
    public void alterar(Object o){        
        Estado e = (Estado) o;        
        try{
            sql = "UPDATE estado " +
                  "   SET ds_estado = ?, " +
                  "       ds_siglaestado = ?" +
                  " WHERE cd_estado = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, e.getDs_estado());
            ps.setString(2, e.getDs_siglaEstado());
            ps.setInt(3, e.getCd_estado());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado.", "Estado", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Estado", JOptionPane.ERROR_MESSAGE);
        }    
    }
    
    /**
     * <p><strong>EN:</strong> Deletes a State record from the database.
     * The deletion is based on the provided State ID.</p>
     *
     * <p><strong>IT:</strong> Elimina un record di Stato dal database.
     * L’eliminazione avviene in base all’ID dello Stato fornito.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui um registro de Estado do banco de dados.
     * A exclusão é feita com base no ID do Estado informado.</p>
     */
    public void excluir(Object o){        
        Estado e = (Estado) o;        
        try{
            sql = "DELETE FROM estado " +
                  " WHERE cd_estado = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, e.getCd_estado());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido", "Estado", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao deletar:\n" +
                    ex.getMessage(), "Estado", JOptionPane.ERROR_MESSAGE);
        }    
    }

    /**
     * <p><strong>EN:</strong> Retrieves a list of all States from the database.
     * The results are ordered alphabetically by the state name.</p>
     *
     * <p><strong>IT:</strong> Recupera un elenco di tutti gli Stati dal database.
     * I risultati sono ordinati alfabeticamente per nome dello stato.</p>
     *
     * <p><strong>PT-BR:</strong> Retorna uma lista de todos os Estados do banco de dados.
     * Os resultados são ordenados alfabeticamente pelo nome do estado.</p>
     */
    public ArrayList getLista(){        
        ArrayList estados = new ArrayList();
        try {
            sql = "SELECT cd_estado, ds_estado, ds_siglaestado " +
                  "  FROM estado" +
                  " ORDER BY ds_estado";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();        
            while (rs.next()){
                Estado e = new Estado(
                    rs.getInt("cd_estado"),
                    rs.getString("ds_estado"),
                    rs.getString("ds_siglaestado"));
                estados.add(e);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de estados:\n" +
                    ex.getMessage(), "Estado", JOptionPane.ERROR_MESSAGE);
        }
        return estados;
    }
    
    /**
     * <p><strong>EN:</strong> Fetches a specific State by its ID.
     * Returns the matching State object if found, otherwise null.</p>
     *
     * <p><strong>IT:</strong> Recupera uno Stato specifico in base al suo ID.
     * Restituisce l’oggetto Stato corrispondente se trovato, altrimenti null.</p>
     *
     * <p><strong>PT-BR:</strong> Busca um Estado específico pelo seu ID.
     * Retorna o objeto Estado correspondente, ou null caso não seja encontrado.</p>
     */
    public Object getById(int id){        
        Estado e = null;        
        try{
            String sql = "SELECT cd_estado, ds_estado, ds_siglaestado" +
                         "  FROM estado " +
                         " WHERE cd_estado = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                e = new Estado(
                    rs.getInt("cd_estado"),
                    rs.getString("ds_estado"),
                    rs.getString("ds_siglaestado"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em estado:\n" + 
                    ex.getMessage(), "Estado", JOptionPane.ERROR_MESSAGE);
        }
        return e;
    }
}
