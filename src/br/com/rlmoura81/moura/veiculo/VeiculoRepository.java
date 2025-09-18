package br.com.rlmoura81.moura.veiculo;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VeiculoRepository implements IPadraoRepository{
    
    String sql = "";       
    ModeloRepository modelor = new ModeloRepository();    
    CombustivelRepository combustivelr = new CombustivelRepository();    
    CoresRepository corr = new CoresRepository();

    /**
     * <p><strong>EN:</strong> Inserts a new <code>Veiculo</code> record into the database.
     * Persists year of manufacture/model, RENAVAM, plate, power, fuel, color, model,
     * and user ID; shows a success message or an error dialog on failure.</p>
     *
     * <p><strong>IT:</strong> Inserisce un nuovo record di <code>Veiculo</code> nel database.
     * Salva anno di fabbricazione/modello, RENAVAM, targa, potenza, carburante, colore,
     * modello e ID utente; mostra un messaggio di successo o un errore in caso di problemi.</p>
     *
     * <p><strong>PT-BR:</strong> Insere um novo registro de <code>Veiculo</code> no banco.
     * Grava ano de fabricação/modelo, RENAVAM, placa, potência, combustível, cor,
     * modelo e ID do usuário; exibe mensagem de sucesso ou erro ao falhar.</p>
     */
    @Override
    public void inserir(Object o) {
        Veiculo v = (Veiculo) o;
        try{
            sql = "INSERT INTO veiculo (cd_veiculo, dt_anofab, dt_anomod, nm_renavam, nm_placa, nm_potencia, cd_combustivel, cd_cor, cd_modelo, cd_usuario)" +
                  "     VALUES (sq_veiculo.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, v.getDt_anofab());
            ps.setInt(2, v.getDt_anomod());
            ps.setString(3, v.getNm_renavam());
            ps.setString(4, v.getNm_placa());
            ps.setInt(5, v.getNm_potencia());
            ps.setInt(6, v.getCombustivel().getCd_combustivel());
            ps.setInt(7, v.getCor().getCd_cor());
            ps.setInt(8, v.getModelo().getCd_modelo());
            ps.setInt(9, v.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Veiculo", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" + 
                    ex.getMessage(), "Veiculo", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
    * <p><strong>EN:</strong> Updates an existing <code>Veiculo</code> record.
    * Sets manufacture/model year, RENAVAM, plate, power, fuel, color, and model.
    * Filters by vehicle ID and user ID; shows success or error feedback.</p>
    *
    * <p><strong>IT:</strong> Aggiorna un record esistente di <code>Veiculo</code>.
    * Imposta anno fabbricazione/modello, RENAVAM, targa, potenza, carburante, colore e modello.
    * Filtra per ID veicolo e ID utente; mostra conferma o errore.</p>
    *
    * <p><strong>PT-BR:</strong> Altera um registro existente de <code>Veiculo</code>.
    * Atualiza ano fab./modelo, RENAVAM, placa, potência, combustível, cor e modelo.
    * Filtra por ID do veículo e ID do usuário; exibe sucesso ou erro.</p>
    */
    @Override
    public void alterar(Object o) {
        Veiculo v = (Veiculo) o;
        try{
            sql = "UPDATE veiculo " +
                  "   SET dt_anofab = ?, " +
                  "       dt_anomod = ?, " +
                  "       nm_renavam = ?, " +
                  "       nm_placa = ?, " +
                  "       nm_potencia = ?, " +
                  "       cd_combustivel = ?, " +
                  "       cd_cor = ?, " +
                  "       cd_modelo = ?" + 
                  " WHERE cd_veiculo = ? " +
                  "   AND cd_usuario = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, v.getDt_anofab());
            ps.setInt(2, v.getDt_anomod());
            ps.setString(3, v.getNm_renavam());
            ps.setString(4, v.getNm_placa());
            ps.setInt(5, v.getNm_potencia());
            ps.setInt(6, v.getCombustivel().getCd_combustivel());
            ps.setInt(7, v.getCor().getCd_cor());
            ps.setInt(8, v.getModelo().getCd_modelo());
            ps.setInt(9, v.getCd_veiculo());
            ps.setInt(10, v.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado", "Veiculo", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Veiculo", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Deletes a <code>Veiculo</code> record from the database,
     * using the vehicle ID and user ID as criteria; shows success or error dialogs.</p>
     *
     * <p><strong>IT:</strong> Elimina un record di <code>Veiculo</code> dal database,
     * utilizzando ID veicolo e ID utente come criteri; mostra conferma o errore.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui um registro de <code>Veiculo</code> do banco,
     * com base no ID do veículo e ID do usuário; exibe confirmação ou erro.</p>
     */
    @Override
    public void excluir(Object o) {
        Veiculo v = (Veiculo) o;
        try{
            sql = "DELETE FROM veiculo " +
                  " WHERE cd_veiculo = ? " +
                  "   AND cd_usuario = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, v.getCd_veiculo());
            ps.setInt(2, v.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido", "Veiculo", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Veiculo", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Retrieves all <code>Veiculo</code> records for the current user,
     * ordered by license plate. Each item includes related fuel, color, and model objects.</p>
     *
     * <p><strong>IT:</strong> Recupera tutti i record <code>Veiculo</code> dell’utente corrente,
     * ordinati per targa. Ogni elemento include carburante, colore e modello associati.</p>
     *
     * <p><strong>PT-BR:</strong> Busca todos os <code>Veiculo</code> do usuário atual,
     * ordenados pela placa. Cada item inclui combustível, cor e modelo relacionados.</p>
     */
    @Override
    public ArrayList getLista() {        
        ArrayList veiculo = new ArrayList();        
        try{
            sql = "SELECT cd_veiculo, dt_anofab, dt_anomod, nm_renavam, nm_placa, nm_potencia, cd_combustivel, cd_cor, cd_modelo, cd_usuario" +
                  "  FROM veiculo " +
                  " WHERE cd_usuario = ?" +
                  " ORDER BY nm_placa";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Veiculo v = new Veiculo(
                    rs.getInt("cd_veiculo"),
                    rs.getInt("dt_anofab"),
                    rs.getInt("dt_anomod"),
                    rs.getString("nm_renavam"),
                    rs.getString("nm_placa"),
                    rs.getInt("nm_potencia"),
                    (Combustivel)combustivelr.getById(rs.getInt("cd_combustivel")),
                    (Cores)corr.getById(rs.getInt("cd_cor")),
                    (Modelo)modelor.getById(rs.getInt("cd_modelo")),
                    rs.getInt("cd_usuario"));
                veiculo.add(v);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregara lista de veiculos." +
                    ex.getMessage(), "Veiculo", JOptionPane.ERROR_MESSAGE);
        }
        return veiculo;
    }

    /**
     * <p><strong>EN:</strong> Fetches a single <code>Veiculo</code> by its ID,
     * including linked fuel, color, and model entities; returns <code>null</code> if not found.</p>
     *
     * <p><strong>IT:</strong> Recupera un singolo <code>Veiculo</code> per ID,
     * includendo carburante, colore e modello associati; restituisce <code>null</code> se assente.</p>
     *
     * <p><strong>PT-BR:</strong> Obtém um <code>Veiculo</code> pelo seu ID,
     * incluindo combustível, cor e modelo vinculados; retorna <code>null</code> se não existir.</p>
     */
    @Override
    public Object getById(int id) {
        Veiculo v = null;        
        try{
            sql = "SELECT cd_veiculo, dt_anofab, dt_anomod, nm_renavam, nm_placa, nm_potencia, cd_combustivel, cd_cor, cd_modelo, cd_usuario" +
                  "  FROM veiculo " +
                  " WHERE cd_veiculo = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                v = new Veiculo(rs.getInt("cd_veiculo"),
                    rs.getInt("dt_anofab"),
                    rs.getInt("dt_anomod"),
                    rs.getString("nm_renavam"),
                    rs.getString("nm_placa"),
                    rs.getInt("nm_potencia"),
                    (Combustivel)combustivelr.getById(rs.getInt("cd_combustivel")),
                    (Cores)corr.getById(rs.getInt("cd_cor")),
                    (Modelo)modelor.getById(rs.getInt("cd_modelo")),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro de getById em veiculo:\n" + 
                    ex.getMessage(), "Veiculo", JOptionPane.ERROR_MESSAGE);
        }
        return v;
    }    
}
