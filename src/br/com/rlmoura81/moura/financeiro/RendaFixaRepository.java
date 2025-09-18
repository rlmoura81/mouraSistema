package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class RendaFixaRepository implements IPadraoRepository{

    String sql = "";    
    Utilidade util = new Utilidade();    
    IndiceRepository indicer = new IndiceRepository();    
    TipoAtivoRepository tpativor = new TipoAtivoRepository();
    
    /**
     * <p><strong>EN:</strong> Inserts a new fixed income record into the database.</p>
     * <p><strong>IT:</strong> Inserisce un nuovo record di reddito fisso nel database.</p>
     * <p><strong>PT-BR:</strong> Insere um novo registro de renda fixa no banco de dados.</p>
     *
     * @param o EN: RendaFixa object with data to save |
     *          IT: Oggetto RendaFixa con i dati da salvare |
     *          PT-BR: Objeto RendaFixa com os dados a serem salvos
     * @since 1.0.0
     */
    @Override
    public void inserir(Object o) {
        RendaFixa rf = (RendaFixa) o;        
        try{
            sql = "INSERT INTO rendafixa (cd_rendafixa, ds_rendafixa, vl_aplicado, vl_taxa, dt_aplicacao, dt_vencimento, cd_indice, cd_tpativo, cd_usuario)" +
                  "     VALUES (sq_rendafixa.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, rf.getDs_rendafixa());
            ps.setBigDecimal(2, rf.getVl_aplicado());
            ps.setBigDecimal(3, rf.getVl_taxa());
            ps.setString(4, Utilidade.formatoData.format(rf.getDt_aplicacao().getTime()));
            ps.setString(5, Utilidade.formatoData.format(rf.getDt_vencimento().getTime()));
            ps.setInt(6, rf.getIndice().getCd_indice());
            ps.setInt(7, rf.getTipoativo().getCd_tpativo());
            ps.setInt(8, rf.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Renda Fixa", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao inserir:\n" +
                    ex.getMessage(), "Renda Fixa", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Updates an existing fixed income record in the database.</p>
     * <p><strong>IT:</strong> Aggiorna un record di reddito fisso esistente nel database.</p>
     * <p><strong>PT-BR:</strong> Altera um registro existente de renda fixa no banco de dados.</p>
     *
     * @param o EN: RendaFixa object with updated data |
     *          IT: Oggetto RendaFixa con dati aggiornati |
     *          PT-BR: Objeto RendaFixa com os dados atualizados
     * @since 1.0.0
     */
    @Override
    public void alterar(Object o) {
        RendaFixa rf = (RendaFixa) o;
        try{
            sql = "UPDATE rendafixa " +
                  "   SET ds_rendafixa = ?, " +
                  "       vl_aplicado = ?, " +
                  "       vl_taxa = ?, " +
                  "       dt_aplicacao = ?, " +
                  "       dt_vencimento = ?, " +
                  "       cd_indice = ?, " +
                  "       cd_tpativo = ? " +
                  " WHERE cd_rendafixa = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, rf.getDs_rendafixa());
            ps.setBigDecimal(2, rf.getVl_aplicado());
            ps.setBigDecimal(3, rf.getVl_taxa());
            ps.setString(4, Utilidade.formatoData.format(rf.getDt_aplicacao().getTime()));
            ps.setString(5, Utilidade.formatoData.format(rf.getDt_vencimento().getTime()));
            ps.setInt(6, rf.getIndice().getCd_indice());
            ps.setInt(7, rf.getTipoativo().getCd_tpativo());
            ps.setInt(8, rf.getCd_rendafixa());
            ps.setInt(9, rf.getCd_usuario());
            ps.execute();
            ps.close();    
            JOptionPane.showMessageDialog(null, "Alterado.", "Renda Fixa", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Renda Fixa", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Deletes a fixed income record from the database.</p>
     * <p><strong>IT:</strong> Elimina un record di reddito fisso dal database.</p>
     * <p><strong>PT-BR:</strong> Exclui um registro de renda fixa do banco de dados.</p>
     *
     * @param o EN: RendaFixa object to be deleted |
     *          IT: Oggetto RendaFixa da eliminare |
     *          PT-BR: Objeto RendaFixa a ser excluído
     * @since 1.0.0
     */
    @Override
    public void excluir(Object o) {
        RendaFixa rf = (RendaFixa) o;
        try{
            sql = "DELETE FROM rendafixa " +
                  " WHERE cd_rendafixa = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, rf.getCd_rendafixa());
            ps.setInt(2, rf.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Renda Fixa", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" + 
                    ex.getMessage(), "Renda Fixa", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Retrieves all fixed income records of the logged-in user.</p>
     * <p><strong>IT:</strong> Recupera tutti i record di reddito fisso dell'utente connesso.</p>
     * <p><strong>PT-BR:</strong> Recupera todos os registros de renda fixa do usuário logado.</p>
     *
     * @return EN: List of fixed income records |
     *         IT: Lista di record di reddito fisso |
     *         PT-BR: Lista de registros de renda fixa
     * @since 1.0.0
     */
    @Override
    public ArrayList getLista() {
        ArrayList rendafixa = new ArrayList();
        try{
            sql = "SELECT cd_rendafixa, ds_rendafixa, vl_aplicado, vl_taxa, to_char(dt_aplicacao, 'dd/MM/yyyy'), to_char(dt_vencimento,'dd/MM/yyyy'), cd_indice, cd_tpativo, cd_usuario" +
                  "  FROM rendafixa " +
                  " WHERE cd_usuario = ?" +
                  " ORDER BY ds_rendafixa";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                RendaFixa rf = new RendaFixa(
                    rs.getInt("cd_rendafixa"),
                    rs.getString("ds_rendafixa"),
                    rs.getBigDecimal("vl_aplicado"),
                    rs.getBigDecimal("vl_taxa"),
                    util.recebeData(rs.getString("to_char(dt_aplicacao,'dd/MM/yyyy')")),
                    util.recebeData(rs.getString("to_char(dt_vencimento,'dd/MM/yyyy')")),
                    (Indice)indicer.getById(rs.getInt("cd_indice")),
                    (TipoAtivo)tpativor.getById(rs.getInt("cd_tpativo")),
                    rs.getInt("cd_usuario"));
                rendafixa.add(rf);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de rendas fixas:\n" +
                    ex.getMessage(), "Renda Fixa", JOptionPane.ERROR_MESSAGE);
        }
        return rendafixa;
    }

    /**
     * <p><strong>EN:</strong> Retrieves a fixed income record by its ID.</p>
     * <p><strong>IT:</strong> Recupera un record di reddito fisso tramite il suo ID.</p>
     * <p><strong>PT-BR:</strong> Recupera um registro de renda fixa pelo seu ID.</p>
     *
     * @param id EN: Fixed income record ID |
     *           IT: ID del record di reddito fisso |
     *           PT-BR: ID do registro de renda fixa
     * @return EN: RendaFixa object if found, otherwise null |
     *         IT: Oggetto RendaFixa se trovato, altrimenti null |
     *         PT-BR: Objeto RendaFixa se encontrado, senão null
     * @since 1.0.0
     */
    @Override
    public Object getById(int id) {
        RendaFixa rf = null;
        try{
            sql = "SELECT cd_rendafixa, ds_rendafixa, vl_aplicado, vl_taxa, to_char(dt_aplicacao, 'dd/MM/yyyy'), to_char(dt_vencimento,'dd/MM/yyyy'), cd_ativo, cd_usuario" +
                  "  FROM rendafixa " +
                  " WHERE cd_rendafixa = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                rf = new RendaFixa(
                    rs.getInt("cd_rendafixa"),
                    rs.getString("ds_rendafixa"),
                    rs.getBigDecimal("vl_aplicado"),
                    rs.getBigDecimal("vl_taxa"),
                    util.recebeData(rs.getString("to_char(dt_aplicacao,'dd/MM/yyyy')")),
                    util.recebeData(rs.getString("to_char(dt_vencimento,'dd/MM/yyyy')")),
                    (Indice)indicer.getById(rs.getInt("cd_indice")),
                    (TipoAtivo)tpativor.getById(rs.getInt("cd_tpativo")),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em rendas fixas:\n" +
                    ex.getMessage(), "Renda Fixa", JOptionPane.ERROR_MESSAGE);
        }
        return rf;
    }
    
}
