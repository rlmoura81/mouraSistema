package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FundoImobiliarioProventoRepository implements IPadraoRepository{

    String sql = "";    
    AtivoRepository ativor = new AtivoRepository();    
    TipoProventoRepository tppr = new TipoProventoRepository();    
    Utilidade util = new Utilidade();

    /**
     * <p><strong>EN:</strong> Inserts a new real estate fund income record using the provided entity fields (asset, pay date, amount, base-price date, base value, income type, user).</p>
     * <p><strong>IT:</strong> Inserisce un nuovo record di provento per fondo immobiliare utilizzando i campi dell’entità fornita (attivo, data pagamento, importo, data prezzo base, valore base, tipo provento, utente).</p>
     * <p><strong>PT-BR:</strong> Insere um novo registro de provento de fundo imobiliário com os dados informados (ativo, data de pagamento, valor, data do preço base, valor base, tipo de provento, usuário).</p>
     */
    @Override
    public void inserir(Object o) {
        FundoImobiliarioProvento fimobr = (FundoImobiliarioProvento) o;
        try{
            sql = "INSERT INTO fdimprov (cd_fdimprov, cd_ativo, dt_pagamento, vl_provento, dt_precobase, vl_database, cd_tpprovento, cd_usuario)" +
                  "     VALUES (sq_fdimprov.nextval, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, fimobr.getAtivo().getCd_ativo());
            ps.setString(2, Utilidade.formatoData.format(fimobr.getDt_pagamento().getTime()));
            ps.setBigDecimal(3, fimobr.getVl_provento());
            ps.setString(4, Utilidade.formatoData.format(fimobr.getDt_precobase().getTime()));
            ps.setBigDecimal(5, fimobr.getVl_database());
            ps.setInt(6, fimobr.getTipoprovento().getCd_tpprovento());
            ps.setInt(7, fimobr.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Fundo Imobiliário Provento", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Fundo Imobiliário Provento", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void alterar(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * <p><strong>EN:</strong> Removes a specific real estate fund dividend record identified by its primary key.</p>
     * <p><strong>IT:</strong> Rimuove un determinato record di provento di fondo immobiliare identificato dalla chiave primaria.</p>
     * <p><strong>PT-BR:</strong> Remove um registro de provento de fundo imobiliário específico identificado pela chave primária.</p>
     *
     * @param o EN: object carrying the provento id to delete | IT: oggetto con l’id del provento da eliminare | PT-BR: objeto com o id do provento a excluir
     */
    @Override
    public void excluir(Object o) {
        FundoImobiliarioProvento fimobr = (FundoImobiliarioProvento) o;
        try{
            sql = "DELETE FROM fdimprov " +
                  " WHERE cd_fdimprov = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, fimobr.getCd_fdimprov());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Fundo Imobiliário Provento", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Fundo Imobiliário Provento", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Retrieves all real estate fund dividend records, joining lookups to build full objects and ordering by asset and payment date.</p>
     * <p><strong>IT:</strong> Recupera tutti i proventi dei fondi immobiliari, con join per comporre gli oggetti completi e ordinamento per asset e data di pagamento.</p>
     * <p><strong>PT-BR:</strong> Busca todos os proventos de fundos imobiliários, realizando consultas auxiliares para montar os objetos e ordenando por ativo e data de pagamento.</p>
     *
     * @return EN: list of FII provento records | IT: elenco di record di proventi FII | PT-BR: lista de registros de proventos de FII
     */
    @Override
    public ArrayList getLista() {
        ArrayList fimobr = new ArrayList();
        try{
            sql = "SELECT cd_fdimprov, cd_ativo, to_char(dt_pagamento,'dd/MM/yyyy'), vl_provento, to_char(dt_precobase,'dd/MM/yyyy'), vl_database, cd_tpprovento, cd_usuario" +
                  "  FROM fdimprov" +
                  " ORDER BY cd_ativo, dt_pagamento";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                FundoImobiliarioProvento fir = new FundoImobiliarioProvento(
                    rs.getInt("cd_fdimprov"),
                    (Ativo)ativor.getById(rs.getInt("cd_ativo")),
                    util.recebeData(rs.getString("to_char(dt_pagamento,'dd/MM/yyyy')")),
                    util.recebeData(rs.getString("to_char(dt_precobase,'dd/MM/yyyy')")),
                    rs.getBigDecimal("vl_provento"),    
                    rs.getBigDecimal("vl_database"),
                    (TipoProvento)tppr.getById(rs.getInt("cd_tpprovento")),
                    rs.getInt("cd_usuario"));
                fimobr.add(fir);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Fundos Imobiliários Provento:\n" +
                    ex.getMessage(), "Fundo Imobiliário Provento", JOptionPane.ERROR_MESSAGE);
        }
        return fimobr;
    }

    /**
     * <p><strong>EN:</strong> Retrieves a single real estate fund dividend record by its id.</p>
     * <p><strong>IT:</strong> Recupera un singolo provento di fondo immobiliare tramite il suo id.</p>
     * <p><strong>PT-BR:</strong> Obtém um único registro de provento de fundo imobiliário pelo seu id.</p>
     *
     * @param id EN: primary key of the provento | IT: chiave primaria del provento | PT-BR: chave primária do provento
     * @return EN: matching FII provento or null | IT: provento corrispondente o null | PT-BR: provento correspondente ou null
     */
    @Override
    public Object getById(int id) {
        FundoImobiliarioProvento fimobr = null;
        try{
            sql = "SELECT cd_fdimprov, cd_ativo, dt_pagamento, vl_provento, dt_precobase, vl_database, cd_tpprovento, cd_usuario" +
                  "  FROM fdimprov" +
                  " WHERE cd_fdimprov = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                fimobr = new FundoImobiliarioProvento(
                    rs.getInt("cd_fdimprov"),
                    (Ativo)ativor.getById(rs.getInt("cd_ativo")),
                    util.recebeData(rs.getString("dt_pagamento")),
                    util.recebeData(rs.getString("dt_precobase")),
                    rs.getBigDecimal("vl_provento"),    
                    rs.getBigDecimal("vl_database"),
                    (TipoProvento)tppr.getById(rs.getInt("cd_tpprovento")),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em Fundo Imobiliário Provento:\n" +
                    ex.getMessage(), "Fundo Imobiliário Provento", JOptionPane.ERROR_MESSAGE);
        }
        return fimobr;
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves the most recent provento for a given asset, returning the record with the latest payment date for that asset.</p>
     * <p><strong>IT:</strong> Recupera il provento più recente per un determinato asset, restituendo il record con la data di pagamento più recente per quell’asset.</p>
     * <p><strong>PT-BR:</strong> Busca o provento mais recente de um ativo, retornando o registro com a última data de pagamento para esse ativo.</p>
     *
     * @param id EN: asset id to look up latest provento | IT: id dell’asset per cercare l’ultimo provento | PT-BR: id do ativo para consultar o último provento
     * @return EN: latest provento for the asset or null | IT: ultimo provento per l’asset o null | PT-BR: último provento do ativo ou null
     */
    public Object getByIdProvento(int id) {
        FundoImobiliarioProvento fimobr = null;
        try{
            sql = "SELECT cd_fdimprov, fdimprov.cd_ativo, ds_ativo, to_char(dt_pagamento,'dd/MM/yyyy'), vl_provento, to_char(dt_precobase,'dd/MM/yyyy'), vl_database, fdimprov.cd_tpprovento,fdimprov.cd_usuario" +
                  "  FROM fdimprov, ativo, tpprovento" +
                  " WHERE fdimprov.cd_ativo = ativo.cd_ativo" +
                  "   AND fdimprov.cd_tpprovento = tpprovento.cd_tpprovento" +
                  "   AND ativo.cd_ativo = ?" +
                  "   AND dt_pagamento = (SELECT MAX(dt_pagamento)" +
                  "                         FROM fdimprov, ativo" +
                  "                        WHERE fdimprov.cd_ativo = ativo.cd_ativo" +
                  "                          AND ativo.cd_ativo = ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                fimobr = new FundoImobiliarioProvento(
                    rs.getInt("cd_fdimprov"),
                    (Ativo)ativor.getById(rs.getInt("cd_ativo")),
                    util.recebeData(rs.getString("to_char(dt_pagamento,'dd/MM/yyyy')")),
                    util.recebeData(rs.getString("to_char(dt_precobase,'dd/MM/yyyy')")),
                    rs.getBigDecimal("vl_provento"),    
                    rs.getBigDecimal("vl_database"),
                    (TipoProvento)tppr.getById(rs.getInt("cd_tpprovento")),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getByIdProvento em Fundos Imobiliário Renda:\n" +
                    ex.getMessage());
        }
        return fimobr;
    }    
}
