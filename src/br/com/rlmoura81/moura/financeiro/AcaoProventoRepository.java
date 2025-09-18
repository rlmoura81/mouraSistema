package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AcaoProventoRepository implements IPadraoRepository{

    String sql = "";    
    AtivoRepository ativor = new AtivoRepository();    
    TipoProventoRepository tpproventor = new TipoProventoRepository();
    Utilidade util = new Utilidade();
    
    /**
     * <p><strong>EN:</strong> Inserts a new dividend record (Ação Provento) into the database.  
     * Fills the fields with data from the given object and saves it.  
     * Shows a confirmation or error dialog after execution.</p>
     *
     * <p><strong>IT:</strong> Inserisce un nuovo record di dividendo (Azione Provento) nel database.  
     * Compila i campi con i dati dell'oggetto fornito e li salva.  
     * Mostra una finestra di conferma o di errore dopo l'esecuzione.</p>
     *
     * <p><strong>PT-BR:</strong> Insere um novo registro de provento de ação no banco de dados.  
     * Preenche os campos com os dados do objeto fornecido e salva.  
     * Exibe uma janela de confirmação ou erro após a execução.</p>
     *
     * @param o Object expected to be an instance of AcaoProvento
     */
    @Override
    public void inserir(Object o) {
        AcaoProvento acaoprov = (AcaoProvento) o;
        try{
            sql = "INSERT INTO acaoprov (cd_acaoprov, cd_ativo, dt_pagamento, vl_provento, dt_precobase, vl_database, cd_tpprovento, cd_usuario)" +
                  "     VALUES (sq_acaoprov.nextval, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, acaoprov.getAtivo().getCd_ativo());
            ps.setString(2, Utilidade.formatoData.format(acaoprov.getDt_pagamento().getTime()));
            ps.setBigDecimal(3, acaoprov.getVl_provento());
            ps.setString(4, Utilidade.formatoData.format(acaoprov.getDt_precobase().getTime()));
            ps.setBigDecimal(5, acaoprov.getVl_database());
            ps.setInt(6, acaoprov.getTpprovento().getCd_tpprovento());
            ps.setInt(7, acaoprov.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Ação Provento", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Ação Provento", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void alterar(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * <p><strong>EN:</strong> Deletes a dividend record (Ação Provento) from the database.  
     * Uses the record’s primary key (cd_acaoprov) to perform deletion.  
     * Shows a confirmation or error dialog.</p>
     *
     * <p><strong>IT:</strong> Elimina un record di dividendo (Azione Provento) dal database.  
     * Utilizza la chiave primaria (cd_acaoprov) per l'eliminazione.  
     * Mostra una finestra di conferma o di errore.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui um registro de provento de ação do banco de dados.  
     * Usa a chave primária (cd_acaoprov) para realizar a exclusão.  
     * Exibe uma janela de confirmação ou erro.</p>
     *
     * @param o Object expected to be an instance of AcaoProvento
     */
    @Override
    public void excluir(Object o) {
        AcaoProvento acaoprov = (AcaoProvento) o;
        try{
            sql = "DELETE FROM acaoprov " +
                  " WHERE cd_acaoprov = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, acaoprov.getCd_acaoprov());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Ação Provento", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Ação Provento", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Retrieves the complete list of dividend records (Ação Provento).  
     * Joins related entities (Ativo, TipoProvento) and orders the results.  
     * Returns a list of AcaoProvento objects.</p>
     *
     * <p><strong>IT:</strong> Recupera l'elenco completo dei record di dividendi (Azione Provento).  
     * Collega le entità correlate (Ativo, TipoProvento) e ordina i risultati.  
     * Restituisce una lista di oggetti AcaoProvento.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera a lista completa de registros de proventos de ações.  
     * Faz junções com entidades relacionadas (Ativo, TipoProvento) e ordena os resultados.  
     * Retorna uma lista de objetos AcaoProvento.</p>
     *
     * @return ArrayList with AcaoProvento objects
     */
    @Override
    public ArrayList getLista() {
        ArrayList acao = new ArrayList();
        try{
            sql = "SELECT cd_acaoprov, cd_ativo, to_char(dt_pagamento,'dd/MM/yyyy'), vl_provento, to_char(dt_precobase,'dd/MM/yyyy'), vl_database, cd_tpprovento, cd_usuario" +
                  "  FROM acaoprov" +
                  " ORDER BY cd_ativo, dt_pagamento";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                AcaoProvento acaoprov = new AcaoProvento(
                    rs.getInt("cd_acaoprov"),
                    (Ativo)ativor.getById(rs.getInt("cd_ativo")),
                    util.recebeData(rs.getString("to_char(dt_pagamento,'dd/MM/yyyy')")),
                    util.recebeData(rs.getString("to_char(dt_precobase,'dd/MM/yyyy')")),
                    rs.getBigDecimal("vl_provento"),
                    rs.getBigDecimal("vl_database"),
                    (TipoProvento)tpproventor.getById(rs.getInt("cd_tpprovento")),
                    rs.getInt("cd_usuario"));
                acao.add(acaoprov);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de ações:\n" +
                    ex.getMessage(), "Ação Provento", JOptionPane.ERROR_MESSAGE);
        }
        return acao;
    }

    /**
     * <p><strong>EN:</strong> Finds a dividend record (Ação Provento) by its ID.  
     * Retrieves data from the database and maps it to an AcaoProvento object.</p>
     *
     * <p><strong>IT:</strong> Trova un record di dividendo (Azione Provento) tramite il suo ID.  
     * Recupera i dati dal database e li mappa in un oggetto AcaoProvento.</p>
     *
     * <p><strong>PT-BR:</strong> Busca um registro de provento de ação pelo seu ID.  
     * Recupera os dados do banco e os mapeia em um objeto AcaoProvento.</p>
     *
     * @param id Primary key of the record
     * @return AcaoProvento object or null if not found
     */
    @Override
    public Object getById(int id) {
        AcaoProvento acaoprov = null;
        try{
            sql = "SELECT cd_acaoprov, cd_ativo, to_char(dt_pagamento,'dd/MM/yyyy'), vl_provento, to_char(dt_precobase,'dd/MM/yyyy'), vl_database, cd_tpprovento, cd_usuario" +
                  "  FROM acaoprov" +
                  " WHERE cd_acaoprov = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                acaoprov = new AcaoProvento(
                    rs.getInt("cd_acaoprov"),
                    (Ativo)ativor.getById(rs.getInt("cd_ativo")),
                    util.recebeData(rs.getString("to_char(dt_pagamento,'dd/MM/yyyy')")),
                    util.recebeData(rs.getString("to_char(dt_precobase,'dd/MM/yyyy')")),
                    rs.getBigDecimal("vl_provento"),
                    rs.getBigDecimal("vl_database"),
                    (TipoProvento)tpproventor.getById(rs.getInt("cd_tpprovento")),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em Ação Provento:\n" +
                    ex.getMessage());
        }
        return acaoprov;
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves the latest dividend record (Ação Provento) for a given stock (Ativo).  
     * Performs a query to return the record with the most recent payment date.  
     * Useful to know the last dividend paid by a stock.</p>
     *
     * <p><strong>IT:</strong> Recupera l'ultimo record di dividendo (Azione Provento) per un dato titolo (Ativo).  
     * Esegue una query per restituire il record con la data di pagamento più recente.  
     * Utile per conoscere l'ultimo dividendo pagato da un titolo.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera o último registro de provento de ação para um ativo específico.  
     * Executa uma consulta que retorna o registro com a data de pagamento mais recente.  
     * Útil para saber o último dividendo pago por uma ação.</p>
     *
     * @param id Stock (Ativo) identifier
     * @return AcaoProvento object or null if not found
     */
    public Object getByIdProvento(int id) {
        AcaoProvento acaoprov = null;
        try{
            sql = "SELECT cd_acaoprov, acaoprov.cd_ativo, ds_ativo, to_char(dt_pagamento,'dd/MM/yyyy'), vl_provento, to_char(dt_precobase,'dd/MM/yyyy'), vl_database, acaoprov.cd_tpprovento, acaoprov.cd_usuario" +
                  "  FROM acaoprov, ativo, tpprovento" +
                  " WHERE acaoprov.cd_acaoprov = ativo.cd_ativo" +
                  "   AND acaoprov.cd_tpprovento = tpprovento.cd_tpprovento" +
                  "   AND dt_pagamento = (SELECT MAX(dt_pagamento)" +
                  "                         FROM acaoprov, ativo" +
                  "                        WHERE acaoprov.cd_ativo = ativo.cd_ativo" +
                  "                          AND ativo.cd_ativo = ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                acaoprov = new AcaoProvento(
                    rs.getInt("cd_acaoprov"),
                    (Ativo)ativor.getById(rs.getInt("cd_ativo")),
                    util.recebeData(rs.getString("to_char(dt_pagamento,'dd/MM/yyyy')")),
                    util.recebeData(rs.getString("to_char(dt_precobase,'dd/MM/yyyy')")),
                    rs.getBigDecimal("vl_provento"),
                    rs.getBigDecimal("vl_database"),
                    (TipoProvento)tpproventor.getById(rs.getInt("cd_tpprovento")),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getByIdProvento em Ação Provento:\n" +
                    ex.getMessage(), "Ação Provento", JOptionPane.ERROR_MESSAGE);
        }
        return acaoprov;
    }    
}
