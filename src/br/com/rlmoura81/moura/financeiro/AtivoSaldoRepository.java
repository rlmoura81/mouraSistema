package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AtivoSaldoRepository implements IPadraoRepository{

    String sql = "";    
    AtivoRepository ativor = new AtivoRepository();    
    
    /**
     * <p><strong>EN:</strong> Inserts a new asset balance (AtivoSaldo) into the database.</p>
     * <p><strong>IT:</strong> Inserisce un nuovo saldo attivo (AtivoSaldo) nel database.</p>
     * <p><strong>PT-BR:</strong> Insere um novo saldo de ativo (AtivoSaldo) no banco de dados.</p>
     *
     * @param o EN: AtivoSaldo instance to insert | IT: Istanza di AtivoSaldo da inserire | PT-BR: Instância de AtivoSaldo a inserir
     */
    @Override
    public void inserir(Object o) {
        AtivoSaldo asaldo = (AtivoSaldo) o;
        try{
            sql = "INSERT INTO ativosaldo (cd_ativo, nm_qtde, cd_usuario)" +
                  "     VALUES (?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, asaldo.getAtivo().getCd_ativo());
            ps.setInt(2, asaldo.getNm_qtde());
            ps.setInt(3, asaldo.getCd_usuario());
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao inserir:\n" +
                    ex.getMessage(), "Ativo Saldo", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Updates the quantity of an existing asset balance (AtivoSaldo) identified by asset and user.</p>
     * <p><strong>IT:</strong> Aggiorna la quantità di un saldo attivo (AtivoSaldo) esistente, identificato da attivo e utente.</p>
     * <p><strong>PT-BR:</strong> Atualiza a quantidade de um saldo de ativo (AtivoSaldo) existente, identificado por ativo e usuário.</p>
     *
     * @param o EN: AtivoSaldo instance with updated data | IT: Istanza di AtivoSaldo con dati aggiornati | PT-BR: Instância de AtivoSaldo com dados atualizados
     */
    @Override
    public void alterar(Object o) {
        AtivoSaldo asaldo = (AtivoSaldo) o;
        try{
            sql = "UPDATE ativosaldo " +
                  "   SET nm_qtde = ?" +
                  " WHERE cd_ativo = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, asaldo.getNm_qtde());
            ps.setInt(2, asaldo.getAtivo().getCd_ativo());
            ps.setInt(3, asaldo.getCd_usuario());
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Ativo Saldo", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void excluir(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * <p><strong>EN:</strong> Retrieves all asset balances (AtivoSaldo) for the logged-in user.</p>
     * <p><strong>IT:</strong> Recupera tutti i saldi attivi (AtivoSaldo) dell’utente connesso.</p>
     * <p><strong>PT-BR:</strong> Recupera todos os saldos de ativos (AtivoSaldo) do usuário logado.</p>
     *
     * @return EN: List of AtivoSaldo objects | IT: Elenco di oggetti AtivoSaldo | PT-BR: Lista de objetos AtivoSaldo
     */
    @Override
    public ArrayList getLista() {
        ArrayList asaldo = new ArrayList();
        try{
            sql = "SELECT cd_ativo, nm_qtde, cd_usuario" +
                  "  FROM ativosaldo" +
                  " WHERE cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                AtivoSaldo as = new AtivoSaldo(
                        (Ativo)ativor.getById(rs.getInt("cd_ativo")),
                        rs.getInt("nm_qtde"),
                        rs.getInt("cd_usuario"));
                asaldo.add(as);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Ativos Saldo:\n" +
                    ex.getMessage(), "Ativo Saldo", JOptionPane.ERROR_MESSAGE);
        }
        return asaldo;
    }

    /**
     * <p><strong>EN:</strong> Retrieves asset balances (AtivoSaldo) filtered by asset type.</p>
     * <p><strong>IT:</strong> Recupera i saldi attivi (AtivoSaldo) filtrati per tipo di attivo.</p>
     * <p><strong>PT-BR:</strong> Recupera saldos de ativos (AtivoSaldo) filtrados por tipo de ativo.</p>
     *
     * @param cd_tpativo EN: asset type ID filter | IT: ID del tipo di attivo | PT-BR: ID do tipo de ativo
     * @return EN: List of AtivoSaldo objects | IT: Elenco di oggetti AtivoSaldo | PT-BR: Lista de objetos AtivoSaldo
     */
    public ArrayList getLista(int cd_tpativo) {
        ArrayList asaldo = new ArrayList();
        try{
            sql = "SELECT ativosaldo.cd_ativo, nm_qtde, ativosaldo.cd_usuario" +
                  "  FROM ativosaldo, ativo" +
                  " WHERE ativosaldo.cd_ativo = ativo.cd_ativo" +
                  "   AND ativo.cd_tpativo = ?" +
                  "   AND ativosaldo.cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_tpativo);
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                AtivoSaldo as = new AtivoSaldo(
                        (Ativo)ativor.getById(rs.getInt("cd_ativo")),
                        rs.getInt("nm_qtde"),
                        rs.getInt("cd_usuario"));
                asaldo.add(as);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Ativos Saldo:\n" +
                    ex.getMessage(), "Ativo Saldo", JOptionPane.ERROR_MESSAGE);
        }
        return asaldo;
    }
         
    /**
     * <p><strong>EN:</strong> Retrieves a specific asset balance (AtivoSaldo) by asset ID.</p>
     * <p><strong>IT:</strong> Recupera un saldo attivo (AtivoSaldo) specifico tramite l’ID dell’attivo.</p>
     * <p><strong>PT-BR:</strong> Recupera um saldo de ativo (AtivoSaldo) específico pelo ID do ativo.</p>
     *
     * @param id EN: asset ID | IT: ID dell’attivo | PT-BR: ID do ativo
     * @return EN: AtivoSaldo object if found, otherwise null | IT: Oggetto AtivoSaldo se trovato, altrimenti null | PT-BR: Objeto AtivoSaldo se encontrado, caso contrário null
     */
    @Override
    public Object getById(int id) {
        AtivoSaldo asaldo = null;
        try{
            sql = "SELECT cd_ativo, nm_qtde, cd_usuario" +
                  "  FROM ativosaldo" +
                  " WHERE cd_ativo = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                asaldo = new AtivoSaldo(
                        (Ativo)ativor.getById(rs.getInt("cd_ativo")),
                        rs.getInt("nm_qtde"),
                        rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em Ativos Saldo:\n" +
                    ex.getMessage(), "Ativo Saldo", JOptionPane.ERROR_MESSAGE);
        }
        return asaldo;
    }
    
    public Object getById(int id, int cd_usuario) {
        AtivoSaldo asaldo = null;
        try{
            sql = "SELECT cd_ativo, nm_qtde, cd_usuario" +
                  "  FROM ativosaldo" +
                  " WHERE cd_ativo = ?" +
                  "   AND cd_usuario = ?"  ;
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, cd_usuario);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                asaldo = new AtivoSaldo(
                        (Ativo)ativor.getById(rs.getInt("cd_ativo")),
                        rs.getInt("nm_qtde"),
                        rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em Ativos Saldo:\n" +
                    ex.getMessage(), "Ativo Saldo", JOptionPane.ERROR_MESSAGE);
        }
        return asaldo;
    }    
}
