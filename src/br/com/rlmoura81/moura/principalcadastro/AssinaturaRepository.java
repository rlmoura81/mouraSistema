package br.com.rlmoura81.moura.principalcadastro;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AssinaturaRepository implements IPadraoRepository{
        
    String sql = "";    
    EmpresaRepository empresar = new EmpresaRepository();    
    Utilidade util = new Utilidade();
    
    /**
     * <p><strong>EN:</strong> Inserts a new <code>Assinatura</code> (subscription) record into the database.
     * Persists service, credentials, price, type, validity date, provider, and user.</p>
     *
     * <p><strong>IT:</strong> Inserisce un nuovo record di <code>Assinatura</code> (abbonamento) nel database.
     * Salva servizio, credenziali, valore, tipo, data di validità, fornitore e utente.</p>
     *
     * <p><strong>PT-BR:</strong> Insere um novo registro de <code>Assinatura</code> no banco de dados.
     * Persiste serviço, credenciais, valor, tipo, validade, prestador e usuário.</p>
     */
    @Override
    public void inserir(Object o) {
        Assinatura a = (Assinatura) o;
        try{
            sql = "INSERT INTO assinatura (cd_assinatura, ds_servico, ds_login, ds_senha, nm_valor, tp_assinatura, dt_validade, cd_empresa, cd_usuario)" +
                  "     VALUES (sq_assinatura.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, a.getDs_servico());
            ps.setString(2, a.getDs_login());
            ps.setString(3, a.getDs_senha());
            ps.setBigDecimal(4, a.getNm_valor());
            ps.setInt(5, a.getTp_assinatura());
            ps.setString(6, Utilidade.formatoData.format(a.getDt_validade().getTime()));
            ps.setInt(7, a.getEmpresa().getCd_empresa());
            ps.setInt(8, a.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Assinatura", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao inserir:\n" +
                    ex.getMessage(), "Assinatura", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Updates an existing <code>Assinatura</code> record.
     * Changes service, credentials, price, type, validity date, and provider for the given id and user.</p>
     *
     * <p><strong>IT:</strong> Aggiorna un record esistente di <code>Assinatura</code>.
     * Modifica servizio, credenziali, valore, tipo, data di validità e fornitore per l’id e l’utente indicati.</p>
     *
     * <p><strong>PT-BR:</strong> Atualiza um registro existente de <code>Assinatura</code>.
     * Altera serviço, credenciais, valor, tipo, validade e prestador para o id e usuário informados.</p>
     */
    @Override
    public void alterar(Object o) {
        Assinatura a = (Assinatura) o;
        try{
            sql = "UPDATE assinatura " +
                  "   SET ds_servico = ?, " +
                  "       ds_login = ?, " +
                  "       ds_senha = ?, " +
                  "       nm_valor = ?, " +
                  "       tp_assinatura = ?, " +
                  "       dt_validade = ?, " +
                  "       cd_empresa = ?" +
                  " WHERE cd_assinatura = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, a.getDs_servico());
            ps.setString(2, a.getDs_login());
            ps.setString(3, a.getDs_senha());
            ps.setBigDecimal(4, a.getNm_valor());
            ps.setInt(5, a.getTp_assinatura());
            ps.setString(6, Utilidade.formatoData.format(a.getDt_validade().getTime()));
            ps.setInt(7, a.getEmpresa().getCd_empresa());
            ps.setInt(8, a.getCd_assinatura());
            ps.setInt(9, a.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Assinatura", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Assinatura", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Deletes an <code>Assinatura</code> record by its id and user.</p>
     *
     * <p><strong>IT:</strong> Elimina un record di <code>Assinatura</code> tramite id e utente.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui um registro de <code>Assinatura</code> pelo id e usuário.</p>
     */
    @Override
    public void excluir(Object o) {
        Assinatura a = (Assinatura) o;
        try{
            sql = "DELETE FROM assinatura " +
                  " WHERE cd_assinatura = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, a.getCd_assinatura());
            ps.setInt(2, a.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Assinatura", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Assinatura", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Retrieves all <code>Assinatura</code> records for the current user,
     * ordered by service name.</p>
     *
     * <p><strong>IT:</strong> Recupera tutti i record di <code>Assinatura</code> dell’utente corrente,
     * ordinati per nome del servizio.</p>
     *
     * <p><strong>PT-BR:</strong> Busca todas as <code>Assinaturas</code> do usuário atual,
     * ordenadas pelo nome do serviço.</p>
     */
    @Override
    public ArrayList getLista() {
        ArrayList assinatura = new ArrayList();
        try{
            sql = "SELECT cd_assinatura, ds_servico, ds_login, ds_senha, nm_valor, tp_assinatura, to_char(dt_validade,'dd/MM/yyyy'), cd_empresa, cd_usuario" +
                  "  FROM assinatura" +
                  " WHERE cd_usuario = ?" +
                  " ORDER BY ds_servico";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Assinatura a = new Assinatura(
                    rs.getInt("cd_assinatura"),
                    rs.getString("ds_servico"),
                    rs.getString("ds_login"),
                    rs.getString("ds_senha"),
                    rs.getBigDecimal("nm_valor"),
                    rs.getInt("tp_assinatura"),
                    util.recebeData(rs.getString("to_char(dt_validade,'dd/MM/yyyy')")),
                    (Empresa)empresar.getById(rs.getInt("cd_empresa")),
                    rs.getInt("cd_usuario"));
                assinatura.add(a);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de assinaturas:\n" +
                    ex.getMessage(), "Assinatura", JOptionPane.ERROR_MESSAGE);
        }
        return assinatura;
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves <code>Assinatura</code> records filtered by service name (case-insensitive)
     * for the current user, ordered by service.</p>
     *
     * <p><strong>IT:</strong> Recupera i record di <code>Assinatura</code> filtrati per nome del servizio (senza distinzione maiuscole/minuscole)
     * per l’utente corrente, ordinati per servizio.</p>
     *
     * <p><strong>PT-BR:</strong> Retorna registros de <code>Assinatura</code> filtrados pelo nome do serviço (sem diferenciar maiúsculas/minúsculas)
     * do usuário atual, ordenados pelo serviço.</p>
     */
    public ArrayList getLista(String ds_servico) {
        ArrayList assinatura = new ArrayList();
        try{
            sql = "SELECT cd_assinatura, ds_servico, ds_login, ds_senha, nm_valor, tp_assinatura, to_char(dt_validade,'dd/MM/yyyy'), cd_empresa, cd_usuario" +
                  "  FROM assinatura" +
                  " WHERE upper(ds_servico) LIKE ? OR lower(ds_servico) LIKE ?" +
                  "   AND cd_usuario = ?" +  
                  " ORDER BY ds_servico";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, "%"+ds_servico+"%");
            ps.setString(2, "%"+ds_servico+"%");
            ps.setInt(3, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Assinatura a = new Assinatura(
                    rs.getInt("cd_assinatura"),
                    rs.getString("ds_servico"),
                    rs.getString("ds_login"),
                    rs.getString("ds_senha"),
                    rs.getBigDecimal("nm_valor"),
                    rs.getInt("tp_assinatura"),
                    util.recebeData(rs.getString("to_char(dt_validade,'dd/MM/yyyy')")),
                    (Empresa)empresar.getById(rs.getInt("cd_empresa")),
                    rs.getInt("cd_usuario"));
                assinatura.add(a);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de assinaturas:\n" +
                    ex.getMessage(), "Assinatura", JOptionPane.ERROR_MESSAGE);
        }
        return assinatura;
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves a single <code>Assinatura</code> by its id.</p>
     *
     * <p><strong>IT:</strong> Recupera una singola <code>Assinatura</code> tramite il suo id.</p>
     *
     * <p><strong>PT-BR:</strong> Obtém uma <code>Assinatura</code> pelo seu id.</p>
     */
    @Override
    public Object getById(int id) {
        Assinatura assinatura = null;
        try{
            sql = "SELECT cd_assinatura, ds_servico, ds_login, ds_senha, nm_valor, tp_assinatura, to_char(dt_validade,'dd/MM/yyyy'), cd_empresa, cd_usuario" +
                  "  FROM assinatura" +
                  " WHERE cd_assinatura = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                assinatura = new Assinatura(
                    rs.getInt("cd_assinatura"),
                    rs.getString("ds_servico"),
                    rs.getString("ds_login"),
                    rs.getString("ds_senha"),
                    rs.getBigDecimal("nm_valor"),
                    rs.getInt("tp_assinatura"),
                    util.recebeData(rs.getString("to_char(dt_validade,'dd/MM/yyyy')")),
                    (Empresa)empresar.getById(rs.getInt("cd_empresa")),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em Assinatura:\n" +
                    ex.getMessage(), "Assinatura", JOptionPane.ERROR_MESSAGE);
        }
        return assinatura;
    }
    
}
