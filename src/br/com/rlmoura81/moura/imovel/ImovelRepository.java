package br.com.rlmoura81.moura.imovel;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalcadastro.Cidade;
import br.com.rlmoura81.moura.principalcadastro.CidadeRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ImovelRepository implements IPadraoRepository{
    
    String sql = "";    
    TipoImovelRepository tpimovelr = new TipoImovelRepository();    
    CidadeRepository cidader = new CidadeRepository();

    /**
     * <p><strong>EN:</strong> Inserts a new {@link Imovel} into the database using a prepared statement
     * (sequence-generated primary key), then shows a confirmation dialog.</p>
     * <p><strong>IT:</strong> Inserisce un nuovo {@link Imovel} nel database usando un prepared statement
     * (chiave primaria generata da sequenza), quindi mostra una finestra di conferma.</p>
     * <p><strong>PT-BR:</strong> Insere um novo {@link Imovel} no banco de dados usando <em>prepared statement</em>
     * (chave primária gerada por sequência) e exibe um diálogo de confirmação.</p>
     */
    @Override
    public void inserir(Object o) {
        Imovel i = (Imovel) o;
        try{
            sql = "INSERT INTO imovel (cd_imovel, nm_matricula, nm_metragem, nm_valor, ds_descricao, cd_tpimovel, cd_cidade, cd_usuario)" +
                  "     VALUES (sq_imovel.nextval, ?, ?, ?, ?, ?, ?, ?)";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, i.getNm_matricula());
            ps.setBigDecimal(2, i.getNm_metragem());
            ps.setBigDecimal(3, i.getNm_valorMatricula());
            ps.setString(4, i.getDs_descricao());
            ps.setInt(5, i.getTpimovel().getCd_tpimovel());
            ps.setInt(6, i.getCidade().getCd_Cidade());
            ps.setInt(7, i.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Imovel", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Imovel", JOptionPane.ERROR_MESSAGE); 
        }
    }

    /**
     * <p><strong>EN:</strong> Updates the selected {@link Imovel} by setting matricula, size, value,
     * description, type ({@link TipoImovel}) and city ({@link Cidade}). Filters by <code>cd_imovel</code> and user.</p>
     * <p><strong>IT:</strong> Aggiorna l’{@link Imovel} selezionato impostando matricola, metratura, valore,
     * descrizione, tipo ({@link TipoImovel}) e città ({@link Cidade}). Filtra per <code>cd_imovel</code> e utente.</p>
     * <p><strong>PT-BR:</strong> Atualiza o {@link Imovel} selecionado definindo matrícula, metragem, valor,
     * descrição, tipo ({@link TipoImovel}) e cidade ({@link Cidade}). Restringe por <code>cd_imovel</code> e usuário.</p>
     */
    @Override
    public void alterar(Object o) {
        Imovel i = (Imovel) o;
        try{
            sql = "UPDATE imovel " +
                  "   SET nm_matricula = ?, " + 
                  "       nm_metragem = ?, " +
                  "       nm_valor = ?, " +
                  "       ds_descricao = ?, " +
                  "       cd_tpimovel = ?, " +
                  "       cd_cidade = ? " +
                  " WHERE cd_imovel = ? " +
                  "   AND cd_usuario = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, i.getNm_matricula());
            ps.setBigDecimal(2, i.getNm_metragem());
            ps.setBigDecimal(3, i.getNm_valorMatricula());
            ps.setString(4, i.getDs_descricao());
            ps.setInt(5, i.getTpimovel().getCd_tpimovel());
            ps.setInt(6, i.getCidade().getCd_Cidade());
            ps.setInt(7, i.getCd_imovel());
            ps.setInt(8, i.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Imovel", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Imovel", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Deletes an {@link Imovel} by its identifier and user code,
     * then shows a confirmation dialog.</p>
     * <p><strong>IT:</strong> Elimina un {@link Imovel} tramite identificatore e codice utente,
     * quindi mostra una finestra di conferma.</p>
     * <p><strong>PT-BR:</strong> Exclui um {@link Imovel} pelo seu identificador e código do usuário,
     * em seguida exibe um diálogo de confirmação.</p>
     */
    @Override
    public void excluir(Object o) {
        Imovel i = (Imovel) o;
        try{
            sql = "DELETE FROM imovel " +
                  " WHERE cd_imovel = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, i.getCd_imovel());
            ps.setInt(2, i.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Imovel", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Imovel", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Retrieves all {@link Imovel} records for the logged-in user,
     * joining related {@link TipoImovel} and {@link Cidade}, ordered by <em>nm_matricula</em>.</p>
     * <p><strong>IT:</strong> Recupera tutti gli {@link Imovel} dell’utente connesso,
     * includendo {@link TipoImovel} e {@link Cidade}, ordinati per <em>nm_matricula</em>.</p>
     * <p><strong>PT-BR:</strong> Busca todos os {@link Imovel} do usuário logado,
     * com {@link TipoImovel} e {@link Cidade}, ordenados por <em>nm_matricula</em>.</p>
     */
    @Override
    public ArrayList getLista() {
         ArrayList imovel = new ArrayList();
        try{
            sql = "SELECT cd_imovel, nm_matricula, nm_metragem, nm_valor, ds_descricao, cd_tpimovel, cd_cidade, cd_usuario" +
                  "  FROM imovel " + 
                  " WHERE cd_usuario = ?" +
                  " ORDER BY nm_matricula";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Imovel i = new Imovel(
                rs.getInt("cd_imovel"),
                rs.getString("nm_matricula"),
                rs.getBigDecimal("nm_metragem"),
                rs.getBigDecimal("nm_valor"),
                rs.getString("ds_descricao"),
                (TipoImovel)tpimovelr.getById(rs.getInt("cd_tpimovel")),
                (Cidade)cidader.getById(rs.getInt("cd_cidade")),
                rs.getInt("cd_usuario"));
                imovel.add(i);
            }
            ps.close();
        }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de imoveis:\n" +
                       ex.getMessage(), "Imovel", JOptionPane.ERROR_MESSAGE);
                    }
        return imovel;
    }

    /**
     * <p><strong>EN:</strong> Retrieves a single {@link Imovel} by its ID, loading its type
     * ({@link TipoImovel}) and city ({@link Cidade}). Returns <code>null</code> when not found.</p>
     * <p><strong>IT:</strong> Recupera un singolo {@link Imovel} per ID, caricando tipo
     * ({@link TipoImovel}) e città ({@link Cidade}). Restituisce <code>null</code> se non trovato.</p>
     * <p><strong>PT-BR:</strong> Recupera um {@link Imovel} pelo ID, carregando o tipo
     * ({@link TipoImovel}) e a cidade ({@link Cidade}). Retorna <code>null</code> se não encontrado.</p>
     */
    @Override
    public Object getById(int id) {
        Imovel i = null;
        try{
            sql = "SELECT cd_imovel, nm_matricula, nm_metragem, nm_valor, ds_descricao, cd_tpimovel, cd_cidade, cd_usuario" +
                  "  FROM imovel " + 
                  " WHERE cd_imovel = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                i = new Imovel(
                    rs.getInt("cd_imovel"),
                    rs.getString("nm_matricula"),
                    rs.getBigDecimal("nm_metragem"),
                    rs.getBigDecimal("nm_valor"),
                    rs.getString("ds_descricao"),
                    (TipoImovel)tpimovelr.getById(rs.getInt("cd_tpimovel")),
                    (Cidade)cidader.getById(rs.getInt("cd_cidade")),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em imovel:\n" +
                    ex.getMessage(), "Imovel", JOptionPane.ERROR_MESSAGE);
        }
        return i;
    }
}
