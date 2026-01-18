package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class NotaCorretagemRepository implements IPadraoRepository{
    
    String sql = "";    
    ContaRepository contar = new ContaRepository();    
    Utilidade util = new Utilidade();

    /**
     * <p><strong>EN:</strong> Inserts a brokerage note into the database.</p>
     *
     * <p><strong>IT:</strong> Inserisce una nota di intermediazione nel database.</p>
     *
     * <p><strong>PT-BR:</strong> Insere uma nota de corretagem no banco de dados.</p>
     *
     * @param o EN: object to insert (NotaCorretagem) | IT: oggetto da inserire (NotaCorretagem) | PT-BR: objeto a ser inserido (NotaCorretagem)
     * @return EN: none | IT: nessuno | PT-BR: nenhum
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco de dados
     * @since 1.0.0
     */
    @Override
    public void inserir(Object o) {
        NotaCorretagem nc = (NotaCorretagem) o;
        try{
            sql = "INSERT INTO notacorretagem (cd_nota, nm_nota, dt_nota, cd_conta, cd_usuario)" + 
                  "     VALUES (sq_notacorretagem.nextval, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, nc.getNm_nota());
            ps.setString(2, Utilidade.formatoData.format(nc.getDt_nota().getTime()));
            ps.setInt(3, nc.getConta().getCd_conta());
            ps.setInt(4, nc.getCd_usuario());
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao inserir Nota de Corretagem:\n" +
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
     * <p><strong>EN:</strong> Retrieves all brokerage notes for the logged-in user.</p>
     *
     * <p><strong>IT:</strong> Recupera tutte le note di intermediazione per l'utente connesso.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera todas as notas de corretagem do usuário logado.</p>
     *
     * @return EN: list of brokerage notes (ArrayList&lt;NotaCorretagem&gt;) | IT: elenco di note di intermediazione (ArrayList&lt;NotaCorretagem&gt;) | PT-BR: lista de notas de corretagem (ArrayList&lt;NotaCorretagem&gt;)
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco de dados
     * @since 1.0.0
     */
    @Override
    public ArrayList getLista() {
        ArrayList notac = new ArrayList();
        try{
            sql = "SELECT cd_nota, nm_nota, to_char(dt_nota,'dd/MM/yyyy'), cd_conta, cd_usuario" +
                  "  FROM notacorretagem" + 
                  " WHERE cd_usuario = ?" +
                  " ORDER BY cd_nota DESC";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                NotaCorretagem nc = new NotaCorretagem(
                        rs.getInt("cd_nota"),
                        rs.getInt("nm_nota"),
                        util.recebeData(rs.getString("to_char(dt_nota,'dd/MM/yyyy')")),
                        (Conta)contar.getById(rs.getInt("cd_conta")),
                        rs.getInt("cd_usuario"));
                notac.add(nc);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Notas de Corretagens:\n" +
                    ex.getMessage());
        }
        return notac;
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves brokerage notes for a specific account.</p>
     *
     * <p><strong>IT:</strong> Recupera le note di intermediazione per un conto specifico.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera as notas de corretagem de uma conta específica.</p>
     *
     * @param cd_conta EN: account ID to filter | IT: ID del conto per filtrare | PT-BR: ID da conta para filtrar
     * @return EN: filtered list of brokerage notes (ArrayList&lt;NotaCorretagem&gt;) | IT: elenco filtrato di note (ArrayList&lt;NotaCorretagem&gt;) | PT-BR: lista filtrada de notas (ArrayList&lt;NotaCorretagem&gt;)
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco de dados
     * @since 1.0.0
     */
    public ArrayList getLista(int cd_conta) {
        ArrayList notac = new ArrayList();
        try{
            sql = "SELECT cd_nota, nm_nota, to_char(dt_nota,'dd/MM/yyyy'), cd_conta, cd_usuario" +
                  "  FROM notacorretagem" + 
                  " WHERE cd_conta = ?" +
                  "   AND cd_usuario = ?" +
                  " ORDER BY cd_nota DESC";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_conta);
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                NotaCorretagem nc = new NotaCorretagem(
                        rs.getInt("cd_nota"),
                        rs.getInt("nm_nota"),
                        util.recebeData(rs.getString("to_char(dt_nota,'dd/MM/yyyy')")),
                        (Conta)contar.getById(rs.getInt("cd_conta")),
                        rs.getInt("cd_usuario"));
                notac.add(nc);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Notas de Corretagens:\n" +
                    ex.getMessage());
        }
        return notac;
    }

    /**
     * <p><strong>EN:</strong> Retrieves a brokerage note by its ID.</p>
     *
     * <p><strong>IT:</strong> Recupera una nota di intermediazione tramite il suo ID.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera uma nota de corretagem pelo seu ID.</p>
     *
     * @param id EN: brokerage note ID to search | IT: ID della nota da cercare | PT-BR: ID da nota a pesquisar
     * @return EN: brokerage note found or null (NotaCorretagem) | IT: nota trovata oppure null (NotaCorretagem) | PT-BR: nota encontrada ou null (NotaCorretagem)
     * @since 1.0.0
     */
    @Override
    public Object getById(int id) {
        NotaCorretagem notac = null;
        try{
            sql = "SELECT cd_nota, nm_nota, to_char(dt_nota,'dd/MM/yyyy'), cd_conta, cd_usuario" +
                  "  FROM notacorretagem" + 
                  " WHERE cd_nota = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                notac = new NotaCorretagem(
                        rs.getInt("cd_nota"),
                        rs.getInt("nm_nota"),
                        util.recebeData(rs.getString("to_char(dt_nota,'dd/MM/yyyy')")),
                        (Conta)contar.getById(rs.getInt("cd_conta")),
                        rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em Notas de Corretagens:\n" +
                    ex.getMessage());
        }
        return notac;
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves the most recent brokerage note.</p>
     *
     * <p><strong>IT:</strong> Recupera l'ultima nota di intermediazione inserita.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera a nota de corretagem mais recente.</p>
     *
     * @return EN: latest brokerage note or null (NotaCorretagem) | IT: ultima nota oppure null (NotaCorretagem) | PT-BR: última nota ou null (NotaCorretagem)
     * @since 1.0.0
     */
    public Object getByCodNota() {
        NotaCorretagem notac = null;
        try{
            sql = "SELECT cd_nota, nm_nota, to_char(dt_nota,'dd/MM/yyyy'), cd_conta, cd_usuario" +
                  "  FROM notacorretagem" +
                  " ORDER BY cd_nota DESC";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                notac = new NotaCorretagem(
                        rs.getInt("cd_nota"),
                        rs.getInt("nm_nota"),
                        util.recebeData(rs.getString("to_char(dt_nota,'dd/MM/yyyy')")),
                        (Conta)contar.getById(rs.getInt("cd_conta")),
                        rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getByCodNota em Notas de Corretagens:\n" +
                    ex.getMessage());
        }
        return notac;
    }    
}
