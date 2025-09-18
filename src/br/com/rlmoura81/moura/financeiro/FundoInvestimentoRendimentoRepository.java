package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FundoInvestimentoRendimentoRepository implements IPadraoRepository{

    String sql = "";    
    FundoInvestimentoAplicacaoRepository fiar = new FundoInvestimentoAplicacaoRepository();    
    Utilidade util = new Utilidade();

    /**
     * <p><strong>EN:</strong> Inserts a <em>FundoInvestimentoRendimento</em> record into the database.</p>
     *
     * <p><strong>IT:</strong> Inserisce un record di <em>FundoInvestimentoRendimento</em> nel database.</p>
     *
     * <p><strong>PT-BR:</strong> Insere um registro de <em>FundoInvestimentoRendimento</em> no banco de dados.</p>
     *
     * @param o EN: object to insert (expects FundoInvestimentoRendimento) | IT: oggetto da inserire (atteso FundoInvestimentoRendimento) | PT-BR: objeto a ser inserido (espera FundoInvestimentoRendimento)
     * @return EN: no direct return; persists data | IT: nessun valore restituito; persiste i dati | PT-BR: sem retorno direto; persiste os dados
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco
     * @since 1.0.0
     */
    @Override
    public void inserir(Object o) {
        FundoInvestimentoRendimento fir = (FundoInvestimentoRendimento) o;
        try{
            sql = "INSERT INTO fdinvestrend (cd_fdinvestrend, vl_rendimento, dt_rendimento, cd_fdinvestaplic, cd_usuario)" +
                  "     VALUES (sq_fdinvestrend.nextval, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setBigDecimal(1, fir.getVl_rendimento());
            ps.setString(2, Utilidade.formatoData.format(fir.getDt_rendimento().getTime()));
            ps.setInt(3, fir.getFdinvap().getCd_fdinvestaplic());
            ps.setInt(4, fir.getCd_usuario());
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao inserir Fundo Investimento Rendimento:\n" +
                    ex.getMessage());
        }
        
    }

    @Override
    public void alterar(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * <p><strong>EN:</strong> Retrieves all <em>FundoInvestimentoRendimento</em> records for the logged-in user.</p>
     *
     * <p><strong>IT:</strong> Recupera tutti i record di <em>FundoInvestimentoRendimento</em> per l'utente connesso.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera todos os registros de <em>FundoInvestimentoRendimento</em> do usuário logado.</p>
     *
     * @return EN: list of yields | IT: elenco dei rendimenti | PT-BR: lista de rendimentos
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco
     * @since 1.0.0
     */
    @Override
    public ArrayList getLista() {
        ArrayList fdinvrd = new ArrayList();
        try{
            sql = "SELECT cd_fdinvestrend, vl_rendimento, to_char(dt_rendimento,'dd/MM/yyyy'), cd_fdinvestaplic, cd_usuario" +
                  "  FROM fdinvestrend" +
                  " WHERE cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                FundoInvestimentoRendimento fir = new FundoInvestimentoRendimento(
                        rs.getInt("cd_fdinvestrend"),
                        rs.getBigDecimal("vl_rendimento"),
                        util.recebeData(rs.getString("to_char(dt_rendimento,'dd/MM/yyyy')")),
                        (FundoInvestimentoAplicacao)fiar.getById(rs.getInt("cd_fdinvestaplic")),
                        rs.getInt("cd_usuario"));
                fdinvrd.add(fir);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Rendimentos de Fundos de Investimentos:\n" +
                    ex.getMessage());
        }
        return fdinvrd;
    }
     
    /**
     * <p><strong>EN:</strong> Retrieves all <em>FundoInvestimentoRendimento</em> records tied to a specific application.</p>
     *
     * <p><strong>IT:</strong> Recupera tutti i record di <em>FundoInvestimentoRendimento</em> associati a una specifica applicazione.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera todos os registros de <em>FundoInvestimentoRendimento</em> vinculados a uma aplicação específica.</p>
     *
     * @param cd_fdinvestaplic EN: application identifier | IT: identificatore dell'applicazione | PT-BR: identificador da aplicação
     * @return EN: list of yields for the given application | IT: elenco dei rendimenti per l'applicazione indicata | PT-BR: lista de rendimentos da aplicação informada
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco
     * @since 1.0.0
     */
    public ArrayList getListaRendimento(int cd_fdinvestaplic) {
        ArrayList fdinvrd = new ArrayList();
        try{
            sql = "SELECT cd_fdinvestrend, vl_rendimento, to_char(dt_rendimento,'dd/MM/yyyy'), cd_fdinvestaplic, cd_usuario" +
                  "  FROM fdinvestrend" +
                  " WHERE cd_fdinvestaplic = ?" +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_fdinvestaplic);
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                FundoInvestimentoRendimento fir = new FundoInvestimentoRendimento(
                        rs.getInt("cd_fdinvestrend"),
                        rs.getBigDecimal("vl_rendimento"),
                        util.recebeData(rs.getString("to_char(dt_rendimento,'dd/MM/yyyy')")),
                        (FundoInvestimentoAplicacao)fiar.getById(rs.getInt("cd_fdinvestaplic")),
                        rs.getInt("cd_usuario"));
                fdinvrd.add(fir);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Rendimentos de Fundos de Investimentos:\n" +
                    ex.getMessage());
        }
        return fdinvrd;
    }

    /**
     * <p><strong>EN:</strong> Retrieves a <em>FundoInvestimentoRendimento</em> record by its identifier.</p>
     *
     * <p><strong>IT:</strong> Recupera un record di <em>FundoInvestimentoRendimento</em> tramite il suo identificatore.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera um registro de <em>FundoInvestimentoRendimento</em> pelo seu identificador.</p>
     *
     * @param id EN: yield identifier | IT: identificatore del rendimento | PT-BR: identificador do rendimento
     * @return EN: the found record or <code>null</code> if not found | IT: il record trovato o <code>null</code> se non trovato | PT-BR: o registro encontrado ou <code>null</code> se não encontrado
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco
     * @since 1.0.0
     */
    @Override
    public Object getById(int id) {
        FundoInvestimentoRendimento fdinvrd = null;
        try{
            sql = "SELECT cd_fdinvestrend, vl_rendimento, to_char(dt_rendimento,'dd/MM/yyyy'), cd_fdinvestaplic, cd_usuario" +
                  "  FROM fdinvestrend" +
                  " WHERE cd_fdinvestrend = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                FundoInvestimentoRendimento fir = new FundoInvestimentoRendimento(
                        rs.getInt("cd_fdinvestrend"),
                        rs.getBigDecimal("vl_rendimento"),
                        util.recebeData(rs.getString("to_char(dt_rendimento,'dd/MM/yyyy')")),
                        (FundoInvestimentoAplicacao)fiar.getById(rs.getInt("cd_fdinvestaplic")),
                        rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em Rendimentos de Fundos de Investimentos:\n" +
                    ex.getMessage());            
        }
        return fdinvrd;
    }
    
}
