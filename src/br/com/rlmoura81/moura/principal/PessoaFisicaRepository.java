package br.com.rlmoura81.moura.principal;

import br.com.rlmoura81.moura.principalcadastro.Cidade;
import br.com.rlmoura81.moura.principalcadastro.CidadeRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PessoaFisicaRepository {
    
    String sql = "";    
    CidadeRepository cidader = new CidadeRepository();    
    Utilidade util = new Utilidade();
        
    /**
     * <p><strong>EN:</strong> Inserts a new <code>PessoaFisica</code> record into the database.
     * Prepares an INSERT statement, binds person fields (name, birth date, CPF, CNH, RG, city),
     * executes it, and shows a confirmation dialog.</p>
     *
     * <p><strong>IT:</strong> Inserisce un nuovo record di <code>PessoaFisica</code> nel database.
     * Prepara un’istruzione INSERT, associa i campi (nome, data di nascita, CPF, CNH, RG, città),
     * la esegue e mostra una finestra di conferma.</p>
     *
     * <p><strong>PT-BR:</strong> Insere um novo registro de <code>PessoaFisica</code> no banco de dados.
     * Prepara o INSERT, vincula os campos (nome, nascimento, CPF, CNH, RG, cidade),
     * executa e exibe uma mensagem de confirmação.</p>
     */
    public void inserir(Object o){        
        PessoaFisica pf = (PessoaFisica) o;              
        try{
            sql = "INSERT INTO pessoafisica (cd_pessoafisica, ds_nome, dt_nascimento, nm_cpf, nm_cnh, nm_rg, cd_cidade)" +
                  "     VALUES (sq_pessoafisica.nextval, ?, ?, ?, ?, ?, ?)";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, pf.getDs_Nome());
            ps.setString(2, Utilidade.formatoData.format(pf.getDt_Nascimento().getTime()));
            ps.setString(3, pf.getNm_Cpf());
            ps.setString(4, pf.getNm_Cnh());
            ps.setString(5, pf.getNm_Rg());
            ps.setInt(6, pf.getCidade().getCd_Cidade());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Pessoa Física", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Pessoa Física", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * <p><strong>EN:</strong> Updates an existing <code>PessoaFisica</code> record.
     * Builds an UPDATE statement with name, birth date, CPF, CNH, RG, city and filters by ID;
     * executes it and displays a success message.</p>
     *
     * <p><strong>IT:</strong> Aggiorna un record esistente di <code>PessoaFisica</code>.
     * Crea un’istruzione UPDATE con nome, data di nascita, CPF, CNH, RG, città e filtra per ID;
     * la esegue e mostra un messaggio di successo.</p>
     *
     * <p><strong>PT-BR:</strong> Atualiza um registro existente de <code>PessoaFisica</code>.
     * Monta o UPDATE com nome, nascimento, CPF, CNH, RG, cidade e filtra pelo ID;
     * executa e exibe mensagem de sucesso.</p>
     */
    public void alterar(Object o){        
        PessoaFisica pf = (PessoaFisica) o;               
        try{
            sql = "UPDATE pessoafisica " +
                  "   SET ds_nome = ?," +
                  "       dt_nascimento = ?, " +
                  "       nm_cpf = ?, " +
                  "       nm_cnh = ?, " +
                  "       nm_rg = ?, " +
                  "       cd_cidade = ? " +
                  " WHERE cd_pessoafisica = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, pf.getDs_Nome());
            ps.setString(2, Utilidade.formatoData.format(pf.getDt_Nascimento().getTime()));
            ps.setString(3, pf.getNm_Cpf());
            ps.setString(4, pf.getNm_Cnh());
            ps.setString(5, pf.getNm_Rg());
            ps.setInt(6, pf.getCidade().getCd_Cidade());
            ps.setInt(7, pf.getCd_Pessoa());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado.", "Pessoa Física", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Pessoa Física", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * <p><strong>EN:</strong> Deletes a <code>PessoaFisica</code> record by its ID.
     * Prepares a DELETE statement filtered by the person identifier, executes it,
     * and shows a confirmation dialog.</p>
     *
     * <p><strong>IT:</strong> Elimina un record di <code>PessoaFisica</code> tramite ID.
     * Prepara un’istruzione DELETE filtrata per identificatore, la esegue
     * e mostra una finestra di conferma.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui um registro de <code>PessoaFisica</code> pelo ID.
     * Prepara o DELETE filtrando pelo identificador, executa
     * e exibe uma confirmação.</p>
     */
    public void excluir(Object o){        
        PessoaFisica pf = (PessoaFisica) o;        
        try{
            sql = "DELETE FROM pessoafisica " +
                  " WHERE cd_pessoafisica = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, pf.getCd_Pessoa());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido", "Pessia Física", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Pessoa Física", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Retrieves a list of all <code>PessoaFisica</code> records.
     * Executes a SELECT ordered by name, converts date strings to <code>Calendar</code>,
     * maps city IDs to <code>Cidade</code> objects, and returns an <code>ArrayList</code> of people.</p>
     *
     * <p><strong>IT:</strong> Recupera l’elenco di tutti i record di <code>PessoaFisica</code>.
     * Esegue un SELECT ordinato per nome, converte le date in <code>Calendar</code>,
     * mappa gli ID città in oggetti <code>Cidade</code> e restituisce un <code>ArrayList</code>.</p>
     *
     * <p><strong>PT-BR:</strong> Obtém a lista de todas as <code>PessoaFisica</code>.
     * Executa um SELECT ordenado por nome, converte datas para <code>Calendar</code>,
     * mapeia os IDs de cidade para <code>Cidade</code> e retorna um <code>ArrayList</code> de pessoas.</p>
     */
    public ArrayList getListaPessoaFisica(){        
        ArrayList pessoasfisicas = new ArrayList();          
        try{
            sql = "SELECT cd_pessoafisica, ds_nome, to_char(dt_nascimento,'dd/MM/yyyy'), nm_cpf, nm_cnh, nm_rg, cd_cidade" +
                  "  FROM pessoafisica" +
                  " ORDER BY ds_nome";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){            
                PessoaFisica pf = new PessoaFisica(
                        rs.getInt("cd_pessoafisica"),
                        rs.getString("ds_nome"),
                        util.recebeData(rs.getString("to_char(dt_nascimento,'dd/MM/yyyy')")),
                        rs.getString("nm_cpf"),
                        rs.getString("nm_cnh"),
                        rs.getString("nm_rg"),
                        (Cidade)cidader.getById(rs.getInt("cd_cidade")));
                pessoasfisicas.add(pf);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de pessoas:\n" +
                    ex.getMessage(), "Pessoa Física", JOptionPane.ERROR_MESSAGE);
        }
        return pessoasfisicas;
    }
    
    /**
     * <p><strong>EN:</strong> Fetches a single <code>PessoaFisica</code> by ID.
     * Runs a SELECT with date formatting, rebuilds the domain object including the related <code>Cidade</code>,
     * and returns it or <code>null</code> if not found.</p>
     *
     * <p><strong>IT:</strong> Recupera una singola <code>PessoaFisica</code> tramite ID.
     * Esegue un SELECT con formattazione della data, ricostruisce l’oggetto dominio inclusa la <code>Cidade</code> correlata
     * e lo restituisce o <code>null</code> se non trovato.</p>
     *
     * <p><strong>PT-BR:</strong> Busca uma <code>PessoaFisica</code> pelo ID.
     * Executa um SELECT com formatação de data, reconstrói o objeto incluindo a <code>Cidade</code> relacionada
     * e retorna o objeto ou <code>null</code> se não encontrado.</p>
     */
    public Object getById(int id){
        PessoaFisica pf = null;
        try{
            sql = "SELECT cd_pessoafisica, ds_nome, to_char(dt_nascimento,'dd/MM/yyyy'), nm_cpf, nm_rg, nm_cnh, cd_cidade" +
                  "  FROM pessoafisica" +
                  " WHERE cd_pessoafisica = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                pf = new PessoaFisica(
                    rs.getInt("cd_pessoafisica"),
                    rs.getString("ds_nome"),
                    util.recebeData(rs.getString("to_char(dt_nascimento,'dd/MM/yyyy')")),
                    rs.getString("nm_cpf"),
                    rs.getString("nm_rg"),
                    rs.getString("nm_cnh"),
                    (Cidade)cidader.getById(rs.getInt("cd_cidade")));
            }    
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em pessoa fisica:\n" + 
                    ex.getMessage(), "Pessoa Física", JOptionPane.ERROR_MESSAGE);
        }
        return pf;
    }
}
