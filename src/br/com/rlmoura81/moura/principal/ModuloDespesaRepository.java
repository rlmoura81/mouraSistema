package br.com.rlmoura81.moura.principal;

import br.com.rlmoura81.moura.animal.Animal;
import br.com.rlmoura81.moura.animal.AnimalDespesa;
import br.com.rlmoura81.moura.animal.AnimalRepository;
import br.com.rlmoura81.moura.animal.Produto;
import br.com.rlmoura81.moura.animal.ProdutoRepository;
import br.com.rlmoura81.moura.imovel.Imovel;
import br.com.rlmoura81.moura.imovel.ImovelDespesa;
import br.com.rlmoura81.moura.imovel.ImovelRepository;
import br.com.rlmoura81.moura.principalcadastro.PrestadorServico;
import br.com.rlmoura81.moura.principalcadastro.PrestadorServicoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import br.com.rlmoura81.moura.veiculo.Veiculo;
import br.com.rlmoura81.moura.veiculo.VeiculoDespesa;
import br.com.rlmoura81.moura.veiculo.VeiculoRepository;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ModuloDespesaRepository{

    String sql = "";    
    AnimalDespesa animald = new AnimalDespesa();
    AnimalRepository animalr = new AnimalRepository();    
    VeiculoDespesa veiculod = new VeiculoDespesa();
    VeiculoRepository veiculor = new VeiculoRepository();    
    ImovelDespesa imoveld = new ImovelDespesa();
    ImovelRepository imovelr = new ImovelRepository();    
    PrestadorServicoRepository psr = new PrestadorServicoRepository();    
    ProdutoRepository produtor = new ProdutoRepository();    
    Utilidade util = new Utilidade();
    
    /**
     * <p><strong>EN:</strong> Inserts an expense record for Animal, Vehicle, or Property.
     * Detects the object type at runtime and writes into the corresponding table
     * (<code>animdesp</code>, <code>veicdesp</code>, or <code>imovdesp</code>), formatting dates
     * and binding all required fields.</p>
     *
     * <p><strong>IT:</strong> Inserisce una spesa per Animale, Veicolo o Immobile.
     * Rileva il tipo a runtime e scrive nella tabella corrispondente
     * (<code>animdesp</code>, <code>veicdesp</code> o <code>imovdesp</code>), formattando le date
     * e impostando i parametri necessari.</p>
     *
     * <p><strong>PT-BR:</strong> Insere um registro de despesa para Animal, Veículo ou Imóvel.
     * Identifica o tipo em tempo de execução e grava na tabela correspondente
     * (<code>animdesp</code>, <code>veicdesp</code> ou <code>imovdesp</code>), formatando datas
     * e vinculando todos os campos exigidos.</p>
     */
    public void inserir(Object o) {
        if(o.getClass().equals(animald.getClass())){
            AnimalDespesa ad = (AnimalDespesa) o;
            try{
                sql = "INSERT INTO animdesp (cd_despesa, dt_despesa, nm_nota, ds_descricao, nm_valor, nm_qtde, cd_presserv, cd_animal, cd_produto, cd_usuario)" +
                      "     VALUES (sq_animdesp.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
                ps.setString(1, Utilidade.formatoData.format(ad.getDt_despesa().getTime()));
                ps.setString(2, ad.getNm_nota());
                ps.setString(3, ad.getDs_descricao());
                ps.setBigDecimal(4, ad.getNm_valor());
                ps.setInt(5, ad.getNm_qtde());
                ps.setInt(6, ad.getPresserv().getCd_presserv());
                ps.setInt(7, ad.getAnimal().getCd_animal());
                ps.setInt(8, ad.getProduto().getCd_produto());
                ps.setInt(9, ad.getCd_usuario());
                ps.execute();
                ps.close();
                JOptionPane.showMessageDialog(null, "Salvo.", "Animal Despesa", JOptionPane.INFORMATION_MESSAGE);
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao salvo:\n" +
                        ex.getMessage(), "Animal Despesa", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(o.getClass().equals(veiculod.getClass())){
            VeiculoDespesa vd = (VeiculoDespesa) o;
            try{
                sql = "INSERT INTO veicdesp (cd_despesa, dt_despesa, nm_nota, ds_descricao, nm_valor, nm_qtde, cd_presserv, cd_veiculo, cd_usuario)" +
                      "     VALUES (sq_veicdesp.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
                ps.setString(1, Utilidade.formatoData.format(vd.getDt_despesa().getTime()));
                ps.setString(2, vd.getNm_nota());
                ps.setString(3, vd.getDs_descricao());
                ps.setBigDecimal(4, vd.getNm_valor());
                ps.setInt(5, vd.getNm_qtde());
                ps.setInt(6, vd.getPresserv().getCd_presserv());
                ps.setInt(7, vd.getVeiculo().getCd_veiculo());
                ps.setInt(8, vd.getCd_usuario());
                ps.execute();
                ps.close();
                JOptionPane.showMessageDialog(null, "Salvo.", "Veiculo Despesa", JOptionPane.INFORMATION_MESSAGE);
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao salvo:\n" +
                        ex.getMessage(), "Veiculo Despesa", JOptionPane.ERROR_MESSAGE);
            }            
        }
        if(o.getClass().equals(imoveld.getClass())){
            ImovelDespesa id = (ImovelDespesa) o;
            try{
                sql = "INSERT INTO imovdesp (cd_despesa, dt_despesa, nm_nota, ds_descricao, nm_valor, nm_qtde, cd_presserv, cd_imovel, cd_usuario)" +
                      "     VALUES (sq_imovdesp.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
                ps.setString(1, Utilidade.formatoData.format(id.getDt_despesa().getTime()));
                ps.setString(2, id.getNm_nota());
                ps.setString(3, id.getDs_descricao());
                ps.setBigDecimal(4, id.getNm_valor());
                ps.setInt(5, id.getNm_qtde());
                ps.setInt(6, id.getPresserv().getCd_presserv());
                ps.setInt(7, id.getImovel().getCd_imovel());
                ps.setInt(8, id.getCd_usuario());
                ps.execute();
                ps.close();
                JOptionPane.showMessageDialog(null, "Salvo.", "Imovel Despesa", JOptionPane.INFORMATION_MESSAGE);
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao salvo:\n" +
                        ex.getMessage(), "Imovel Despesa", JOptionPane.ERROR_MESSAGE);
            }            
        }        
    }

    /**
     * <p><strong>EN:</strong> Updates an expense for the given domain type (Animal, Vehicle, Property).
     * Applies changes to the appropriate table and row, using composite keys (entity id + user id)
     * where applicable.</p>
     *
     * <p><strong>IT:</strong> Aggiorna una spesa per il tipo di dominio indicato (Animale, Veicolo, Immobile).
     * Applica le modifiche alla tabella corretta usando chiavi composte (id entità + id utente)
     * quando necessario.</p>
     *
     * <p><strong>PT-BR:</strong> Atualiza uma despesa para o tipo informado (Animal, Veículo, Imóvel).
     * Aplica as alterações na tabela correta, utilizando chaves compostas (id da entidade + id do usuário)
     * quando aplicável.</p>
     */
    public void alterar(Object o) {
        if(o.getClass().equals(animald.getClass())){
            AnimalDespesa ad = (AnimalDespesa) o;
            try{
                sql = "UPDATE animdesp " +
                      "   SET dt_despesa = ?, " +
                      "       nm_nota = ?, " +
                      "       ds_descricao = ?, " +
                      "       nm_valor = ?, " +
                      "       nm_qtde = ?, " +
                      "       cd_presserv = ?, " +
                      "       cd_produto = ?" +
                      " WHERE cd_despesa = ?" +
                      "   AND cd_animal = ?" +
                      "   AND cd_usuario = ?";
                PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
                ps.setString(1, Utilidade.formatoData.format(ad.getDt_despesa().getTime()));
                ps.setString(2, ad.getNm_nota());
                ps.setString(3, ad.getDs_descricao());
                ps.setBigDecimal(4, ad.getNm_valor());
                ps.setInt(5, ad.getNm_qtde());
                ps.setInt(6, ad.getPresserv().getCd_presserv());
                ps.setInt(7, ad.getProduto().getCd_produto());
                ps.setInt(8, ad.getCd_despesa());
                ps.setInt(9, ad.getAnimal().getCd_animal());
                ps.setInt(10, ad.getCd_usuario());
                ps.execute();
                ps.close();                
                JOptionPane.showMessageDialog(null, "Alterado.", "Animal Despesa", JOptionPane.INFORMATION_MESSAGE);
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                        ex.getMessage(), "Animal Despesa", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(o.getClass().equals(veiculod.getClass())){
            VeiculoDespesa vd = (VeiculoDespesa) o;
            try{
                sql = "UPDATE veicdesp " +
                      "   SET dt_despesa = ?, " +
                      "       nm_nota = ?, " +
                      "       ds_descricao = ?, " +
                      "       nm_valor = ?, " +
                      "       nm_qtde = ?, " +
                      "       cd_presserv = ?" +
                      " WHERE cd_despesa = ?" +
                      "   AND cd_veiculo = ?" +
                      "   AND cd_usuario = ?";
                PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
                ps.setString(1, Utilidade.formatoData.format(vd.getDt_despesa().getTime()));
                ps.setString(2, vd.getNm_nota());
                ps.setString(3, vd.getDs_descricao());
                ps.setBigDecimal(4, vd.getNm_valor());
                ps.setInt(5, vd.getNm_qtde());
                ps.setInt(6, vd.getPresserv().getCd_presserv());
                ps.setInt(7, vd.getCd_despesa());
                ps.setInt(8, vd.getVeiculo().getCd_veiculo());
                ps.setInt(9, vd.getCd_usuario());
                ps.execute();
                ps.close();                
                JOptionPane.showMessageDialog(null, "Alterado", "Veiculo Despesa", JOptionPane.INFORMATION_MESSAGE);
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                        ex.getMessage(), "Veiculo Despesa", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(o.getClass().equals(imoveld.getClass())){
            ImovelDespesa id = (ImovelDespesa) o;
            try{
                sql = "UPDATE imovdesp " +
                      "   SET dt_despesa = ?, " +
                      "       nm_nota = ?, " +
                      "       ds_descricao = ?, " +
                      "       nm_valor = ?, " +
                      "       nm_qtde = ?, " +
                      "       cd_presserv = ?" +
                      " WHERE cd_despesa = ?" +
                      "   AND cd_imovel = ?" +
                      "   AND cd_usuario = ?";
                PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
                ps.setString(1, Utilidade.formatoData.format(id.getDt_despesa().getTime()));
                ps.setString(2, id.getNm_nota());
                ps.setString(3, id.getDs_descricao());
                ps.setBigDecimal(4, id.getNm_valor());
                ps.setInt(5, id.getNm_qtde());
                ps.setInt(6, id.getPresserv().getCd_presserv());
                ps.setInt(7, id.getCd_despesa());
                ps.setInt(8, id.getImovel().getCd_imovel());
                ps.setInt(9, id.getCd_usuario());
                ps.execute();
                ps.close();        
                JOptionPane.showMessageDialog(null, "Alterado.", "Imovel Despesa", JOptionPane.INFORMATION_MESSAGE);
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                        ex.getMessage(), "Imovel Despesa", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * <p><strong>EN:</strong> Deletes an expense entry for Animal, Vehicle, or Property.
     * Removes the row from the corresponding table using the entity id and user id to target
     * the exact record.</p>
     *
     * <p><strong>IT:</strong> Elimina una voce di spesa per Animale, Veicolo o Immobile.
     * Rimuove la riga dalla tabella corrispondente usando id entità e id utente per individuare
     * il record esatto.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui um lançamento de despesa de Animal, Veículo ou Imóvel.
     * Remove a linha da tabela correspondente usando o id da entidade e o id do usuário
     * para localizar o registro.</p>
     */
    public void excluir(Object o) {
        if(o.getClass().equals(animald.getClass())){
            AnimalDespesa ad = (AnimalDespesa) o;
            try{
                sql = "DELETE FROM animdesp" +
                      "   WHERE cd_despesa = ?" +
                      "     AND cd_animal = ?" +
                      "     AND cd_usuario = ?";
                PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
                ps.setInt(1, ad.getCd_despesa());
                ps.setInt(2, ad.getAnimal().getCd_animal());
                ps.setInt(3, ad.getCd_usuario());              
                ps.execute();
                ps.close();
                JOptionPane.showMessageDialog(null, "Excluido.", "Animal Despesa", JOptionPane.INFORMATION_MESSAGE);
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                        ex.getMessage(), "Animal Despesa", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(o.getClass().equals(veiculod.getClass())){
            VeiculoDespesa vd = (VeiculoDespesa) o;
            try{
                sql = "DELETE FROM veicdesp" +
                      " WHERE cd_despesa = ?" +
                      "   AND cd_veiculo = ?" +
                      "   AND cd_usuario = ?";
                PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
                ps.setInt(1, vd.getCd_despesa());
                ps.setInt(2, vd.getVeiculo().getCd_veiculo());
                ps.setInt(3, vd.getCd_usuario());              
                ps.execute();
                ps.close();
                JOptionPane.showMessageDialog(null, "Excluido.", "Veiculo Despesa", JOptionPane.INFORMATION_MESSAGE);
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                        ex.getMessage(), "Veiculo Despesa", JOptionPane.ERROR_MESSAGE);
            }
        }        
        if(o.getClass().equals(imoveld.getClass())){
            ImovelDespesa id = (ImovelDespesa) o;
            try{
                sql = "DELETE FROM imovdesp" +
                      " WHERE cd_despesa = ?" +
                      "   AND cd_imovel = ?" +
                      "   AND cd_usuario = ?";
                PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
                ps.setInt(1, id.getCd_despesa());
                ps.setInt(2, id.getImovel().getCd_imovel());
                ps.setInt(3, id.getCd_usuario());              
                ps.execute();
                ps.close();
                JOptionPane.showMessageDialog(null, "Excluido.", "Imovel Despesa", JOptionPane.INFORMATION_MESSAGE);
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                        ex.getMessage(), "Imovel Despesa", JOptionPane.ERROR_MESSAGE);
            }
        } 
    }

    /**
     * <p><strong>EN:</strong> Lists Animal expenses for the current month.
     * Filters by the provided Animal and current month period, ordering by expense date.</p>
     *
     * <p><strong>IT:</strong> Elenca le spese dell’Animale per il mese corrente.
     * Filtra per l’Animale fornito e per il periodo del mese corrente, ordinando per data.</p>
     *
     * <p><strong>PT-BR:</strong> Lista as despesas do Animal no mês atual.
     * Filtra pelo Animal informado e pelo período do mês corrente, ordenando por data.</p>
     */
    public ArrayList getListaAnimalDespesa(Animal a) {
        ArrayList animalistad = new ArrayList();
            try{
                sql = "SELECT cd_despesa, to_char(dt_despesa,'dd/MM/yyyy'), nm_nota, ds_descricao, nm_valor, nm_qtde, cd_presserv, cd_animal, cd_produto, cd_usuario" +
                      "  FROM animdesp" +
                      " WHERE cd_animal = ?" +
                      "   AND dt_despesa BETWEEN (SELECT trunc(SYSDATE,'MM') FROM DUAL) AND (SELECT trunc(LAST_DAY(SYSDATE)) FROM DUAL)" +
                      "   AND cd_usuario = ?" +
                      " ORDER BY dt_despesa";                
                PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
                ps.setInt(1, a.getCd_animal());
                ps.setInt(2, JPLogin.codloginuser);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    AnimalDespesa adespesa = new AnimalDespesa(
                            (Animal)animalr.getById(rs.getInt("cd_animal")),
                            (Produto)produtor.getById(rs.getInt("cd_produto")),
                            rs.getInt("cd_despesa"),
                            util.recebeData(rs.getString("to_char(dt_despesa,'dd/MM/yyyy')")),
                            rs.getString("nm_nota"),
                            rs.getString("ds_descricao"),
                            rs.getBigDecimal("nm_valor"),
                            rs.getInt("nm_qtde"),
                            (PrestadorServico)psr.getById(rs.getInt("cd_presserv")),
                            rs.getInt("cd_usuario"));
                    animalistad.add(adespesa);
                }
                ps.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Despesas de Animais:\n" +
                        ex.getMessage(), "Animal Despesa", JOptionPane.ERROR_MESSAGE);
            }
        return animalistad;
    }

    /**
     * <p><strong>EN:</strong> Lists Animal expenses within a custom date range.
     * Uses start/end dates (strings) to constrain results for the given Animal.</p>
     *
     * <p><strong>IT:</strong> Elenca le spese dell’Animale in un intervallo di date personalizzato.
     * Usa date di inizio/fine (stringhe) per limitare i risultati per l’Animale indicato.</p>
     *
     * <p><strong>PT-BR:</strong> Lista despesas do Animal em um intervalo de datas.
     * Utiliza datas inicial/final (strings) para limitar os resultados do Animal informado.</p>
     */
    public ArrayList getListaAnimalDespesa(Animal a, String dt_inicio, String dt_final) {
        ArrayList animalistad = new ArrayList();
            try{
                sql = "SELECT cd_despesa, to_char(dt_despesa,'dd/MM/yyyy'), nm_nota, ds_descricao, nm_valor, nm_qtde, cd_presserv, cd_animal, cd_produto, cd_usuario" +
                      "  FROM animdesp" +
                      " WHERE cd_animal = ?" +
                      "   AND dt_despesa BETWEEN ? AND ?" +
                      "   AND cd_usuario = ?" +
                      " ORDER BY dt_despesa";                
                PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
                ps.setInt(1, a.getCd_animal());
                ps.setString(2, dt_inicio);
                ps.setString(3, dt_final);
                ps.setInt(4, JPLogin.codloginuser);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    AnimalDespesa adespesa = new AnimalDespesa(
                            (Animal)animalr.getById(rs.getInt("cd_animal")),
                            (Produto)produtor.getById(rs.getInt("cd_produto")),
                            rs.getInt("cd_despesa"),
                            util.recebeData(rs.getString("to_char(dt_despesa,'dd/MM/yyyy')")),
                            rs.getString("nm_nota"),
                            rs.getString("ds_descricao"),
                            rs.getBigDecimal("nm_valor"),
                            rs.getInt("nm_qtde"),
                            (PrestadorServico)psr.getById(rs.getInt("cd_presserv")),
                            rs.getInt("cd_usuario"));
                    animalistad.add(adespesa);
                }
                ps.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Despesas de Animais:\n" +
                        ex.getMessage(), "Animal Despesa", JOptionPane.ERROR_MESSAGE);
            }
        return animalistad;
    }
        
    /**
     * <p><strong>EN:</strong> Gets a single Animal expense by its id.
     * Returns the hydrated domain object with related Animal, Product and Provider.</p>
     *
     * <p><strong>IT:</strong> Recupera una singola spesa dell’Animale per id.
     * Restituisce l’oggetto con riferimenti ad Animale, Prodotto e Prestador de Serviço.</p>
     *
     * <p><strong>PT-BR:</strong> Obtém uma despesa de Animal pelo id.
     * Retorna o objeto completo com Animal, Produto e Prestador vinculados.</p>
     */
    public Object getByIdAnimalDespesa(int id) {
        AnimalDespesa animalistad = null;
            try{
                sql = "SELECT cd_despesa, to_char(dt_despesa,'dd/MM/yyyy'), nm_nota, ds_descricao, nm_valor, nm_qtde, cd_presserv, cd_animal, cd_produto, cd_usuario" +
                      "  FROM animdesp" +
                      " WHERE cd_despesa = ?";                
                PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    animalistad = new AnimalDespesa(
                            (Animal)animalr.getById(rs.getInt("cd_animal")),
                            (Produto)produtor.getById(rs.getInt("cd_produto")),
                            rs.getInt("cd_despesa"),
                            util.recebeData(rs.getString("to_char(dt_despesa,'dd/MM/yyyy')")),
                            rs.getString("nm_nota"),
                            rs.getString("ds_descricao"),
                            rs.getBigDecimal("nm_valor"),
                            rs.getInt("nm_qtde"),
                            (PrestadorServico)psr.getById(rs.getInt("cd_presserv")),
                            rs.getInt("cd_usuario"));
                }
                ps.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro de getByIdAnimalDespesa em Despesas de Animais:\n" +
                        ex.getMessage(), "Animal Despesa", JOptionPane.ERROR_MESSAGE);
            }
        return animalistad;
    }

    /**
     * <p><strong>EN:</strong> Lists Vehicle expenses for the current month.
     * Filters by the provided Vehicle and current month, ordering by date.</p>
     *
     * <p><strong>IT:</strong> Elenca le spese del Veicolo per il mese corrente.
     * Filtra per Veicolo e mese corrente, ordinando per data.</p>
     *
     * <p><strong>PT-BR:</strong> Lista as despesas do Veículo no mês atual.
     * Filtra pelo Veículo e mês corrente, ordenando por data.</p>
     */
    public ArrayList getListaVeiculoDespesa(Veiculo v) {
        ArrayList veiculolistad = new ArrayList();
            try{
                sql = "SELECT cd_despesa, to_char(dt_despesa,'dd/MM/yyyy'), nm_nota, ds_descricao, nm_valor, nm_qtde, cd_presserv, cd_veiculo, cd_usuario" +
                      "  FROM veicdesp" +
                      " WHERE cd_veiculo = ?" +
                      "   AND dt_despesa BETWEEN (SELECT trunc(SYSDATE,'MM') FROM DUAL) AND (SELECT trunc(LAST_DAY(SYSDATE)) FROM DUAL)" +  
                      "   AND cd_usuario = ?" +
                      " ORDER BY dt_despesa";                
                PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
                ps.setInt(1, v.getCd_veiculo());
                ps.setInt(2, JPLogin.codloginuser);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    VeiculoDespesa vdespesa = new VeiculoDespesa(
                            (Veiculo)veiculor.getById(rs.getInt("cd_veiculo")),
                            rs.getInt("cd_despesa"),
                            util.recebeData(rs.getString("to_char(dt_despesa,'dd/MM/yyyy')")),
                            rs.getString("nm_nota"),
                            rs.getString("ds_descricao"),
                            rs.getBigDecimal("nm_valor"),
                            rs.getInt("nm_qtde"),
                            (PrestadorServico)psr.getById(rs.getInt("cd_presserv")),
                            rs.getInt("cd_usuario"));
                    veiculolistad.add(vdespesa);
                }
                ps.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Despesas de Veículos:\n" +
                        ex.getMessage(), "Veiculo Despesa", JOptionPane.ERROR_MESSAGE);
            }
        return veiculolistad;
    }

    /**
     * <p><strong>EN:</strong> Lists Vehicle expenses within a custom date range.
     * Applies the provided start/end dates to the selected Vehicle.</p>
     *
     * <p><strong>IT:</strong> Elenca le spese del Veicolo in un intervallo di date personalizzato.
     * Applica le date di inizio/fine al Veicolo selezionato.</p>
     *
     * <p><strong>PT-BR:</strong> Lista despesas do Veículo em intervalo de datas.
     * Aplica as datas inicial/final ao Veículo selecionado.</p>
     */
    public ArrayList getListaVeiculoDespesa(Veiculo v, String dt_inicio, String dt_final) {
        ArrayList veiculolistad = new ArrayList();
            try{
                sql = "SELECT cd_despesa, to_char(dt_despesa,'dd/MM/yyyy'), nm_nota, ds_descricao, nm_valor, nm_qtde, cd_presserv, cd_veiculo, cd_usuario" +
                      "  FROM veicdesp" +
                      " WHERE cd_veiculo = ?" +
                      "   AND dt_despesa BETWEEN ? AND ?" +  
                      "   AND cd_usuario = ?" +
                      " ORDER BY dt_despesa";                
                PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
                ps.setInt(1, v.getCd_veiculo());
                ps.setString(2, dt_inicio);
                ps.setString(3, dt_final);
                ps.setInt(4, JPLogin.codloginuser);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    VeiculoDespesa vdespesa = new VeiculoDespesa(
                            (Veiculo)veiculor.getById(rs.getInt("cd_veiculo")),
                            rs.getInt("cd_despesa"),
                            util.recebeData(rs.getString("to_char(dt_despesa,'dd/MM/yyyy')")),
                            rs.getString("nm_nota"),
                            rs.getString("ds_descricao"),
                            rs.getBigDecimal("nm_valor"),
                            rs.getInt("nm_qtde"),
                            (PrestadorServico)psr.getById(rs.getInt("cd_presserv")),
                            rs.getInt("cd_usuario"));
                    veiculolistad.add(vdespesa);
                }
                ps.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Despesas de Veículos:\n" +
                        ex.getMessage(), "Veiculo Despesa", JOptionPane.ERROR_MESSAGE);
            }
        return veiculolistad;
    }
        
    /**
     * <p><strong>EN:</strong> Gets a single Vehicle expense by id.
     * Returns the populated expense including Vehicle and Provider references.</p>
     *
     * <p><strong>IT:</strong> Recupera una singola spesa del Veicolo per id.
     * Restituisce la spesa con riferimenti a Veicolo e Prestador.</p>
     *
     * <p><strong>PT-BR:</strong> Obtém uma despesa de Veículo pelo id.
     * Retorna o registro com Veículo e Prestador associados.</p>
     */
    public Object getByIdVeiculoDespesa(int id) {
        VeiculoDespesa veiculolistad = null;
            try{
                sql = "SELECT cd_despesa, to_char(dt_despesa,'dd/MM/yyyy'), nm_nota, ds_descricao, nm_valor, nm_qtde, cd_presserv, cd_veiculo, cd_usuario" +
                      "  FROM veicdesp" +
                      " WHERE cd_despesa = ?";                
                PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    veiculolistad = new VeiculoDespesa(
                            (Veiculo)veiculor.getById(rs.getInt("cd_veiculo")),
                            rs.getInt("cd_despesa"),
                            util.recebeData(rs.getString("to_char(dt_despesa,'dd/MM/yyyy')")),
                            rs.getString("nm_nota"),
                            rs.getString("ds_descricao"),
                            rs.getBigDecimal("nm_valor"),
                            rs.getInt("nm_qtde"),
                            (PrestadorServico)psr.getById(rs.getInt("cd_presserv")),
                            rs.getInt("cd_usuario"));
                }
                ps.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro de getByIdVeiculoDespesa em Despesas de Veículos:\n" +
                        ex.getMessage(), "Veiculo Despesa", JOptionPane.ERROR_MESSAGE);
            }
        return veiculolistad;
    }    
    
    /**
     * <p><strong>EN:</strong> Lists Property (Real Estate) expenses.
     * Filters by the given Property and current user, ordering by date.</p>
     *
     * <p><strong>IT:</strong> Elenca le spese dell’Immobile.
     * Filtra per l’Immobile indicato e utente corrente, ordinando per data.</p>
     *
     * <p><strong>PT-BR:</strong> Lista as despesas do Imóvel.
     * Filtra pelo Imóvel informado e usuário atual, ordenando por data.</p>
     */
    public ArrayList getListaImovelDespesa(Imovel i) {
        ArrayList imovellistad = new ArrayList();
            try{
                sql = "SELECT cd_despesa, to_char(dt_despesa,'dd/MM/yyyy'), nm_nota, ds_descricao, nm_valor, nm_qtde, cd_presserv, cd_imovel, cd_usuario" +
                      "  FROM imovdesp" +
                      " WHERE cd_imovel = ?" +
                      "   AND cd_usuario = ?" +
                      " ORDER BY dt_despesa";                
                PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
                ps.setInt(1, i.getCd_imovel());
                ps.setInt(2, JPLogin.codloginuser);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    ImovelDespesa idespesa = new ImovelDespesa(
                            (Imovel)imovelr.getById(rs.getInt("cd_imovel")),
                            rs.getInt("cd_despesa"),
                            util.recebeData(rs.getString("to_char(dt_despesa,'dd/MM/yyyy')")),
                            rs.getString("nm_nota"),
                            rs.getString("ds_descricao"),
                            rs.getBigDecimal("nm_valor"),
                            rs.getInt("nm_qtde"),
                            (PrestadorServico)psr.getById(rs.getInt("cd_presserv")),
                            rs.getInt("cd_usuario"));
                    imovellistad.add(idespesa);
                }
                ps.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Despesas de Imoveis:\n" +
                        ex.getMessage(), "Imovel Despesa", JOptionPane.ERROR_MESSAGE);
            }
        return imovellistad;
    }
    
    /**
     * <p><strong>EN:</strong> Lists Property expenses within a custom date range.
     * Uses start/end date strings to constrain results for the specified Property.</p>
     *
     * <p><strong>IT:</strong> Elenca le spese dell’Immobile in un intervallo di date.
     * Usa stringhe di inizio/fine per limitare i risultati dell’Immobile selezionato.</p>
     *
     * <p><strong>PT-BR:</strong> Lista despesas do Imóvel por intervalo de datas.
     * Utiliza datas inicial/final (strings) para limitar os resultados do Imóvel.</p>
     */
    public ArrayList getListaImovelDespesa(Imovel i, String dt_inicio, String dt_final) {
        ArrayList imovellistad = new ArrayList();
            try{
                sql = "SELECT cd_despesa, to_char(dt_despesa,'dd/MM/yyyy'), nm_nota, ds_descricao, nm_valor, nm_qtde, cd_presserv, cd_imovel, cd_usuario" +
                      "  FROM imovdesp" +
                      " WHERE cd_imovel = ?" +
                      "   AND dt_despesa BETWEEN ? AND ?" +                         
                      "   AND cd_usuario = ?" +
                      " ORDER BY dt_despesa";                
                PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
                ps.setInt(1, i.getCd_imovel());
                ps.setString(2, dt_inicio);
                ps.setString(3, dt_final);                
                ps.setInt(4, JPLogin.codloginuser);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    ImovelDespesa idespesa = new ImovelDespesa(
                            (Imovel)imovelr.getById(rs.getInt("cd_imovel")),
                            rs.getInt("cd_despesa"),
                            util.recebeData(rs.getString("to_char(dt_despesa,'dd/MM/yyyy')")),
                            rs.getString("nm_nota"),
                            rs.getString("ds_descricao"),
                            rs.getBigDecimal("nm_valor"),
                            rs.getInt("nm_qtde"),
                            (PrestadorServico)psr.getById(rs.getInt("cd_presserv")),
                            rs.getInt("cd_usuario"));
                    imovellistad.add(idespesa);
                }
                ps.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Despesas de Imoveis:\n" +
                        ex.getMessage(), "Imovel Despesa", JOptionPane.ERROR_MESSAGE);
            }
        return imovellistad;
    }
    
    /**
     * <p><strong>EN:</strong> Gets a single Property expense by id.
     * Returns the expense with linked Property and Provider entities.</p>
     *
     * <p><strong>IT:</strong> Recupera una spesa dell’Immobile per id.
     * Restituisce la spesa con entità Immobile e Prestador collegate.</p>
     *
     * <p><strong>PT-BR:</strong> Obtém uma despesa de Imóvel pelo id.
     * Retorna a despesa com Imóvel e Prestador relacionados.</p>
     */
    public Object getByIdImovelDespesa(int id) {
        ImovelDespesa idespesa = null;
            try{
                sql = "SELECT cd_despesa, to_char(dt_despesa,'dd/MM/yyyy'), nm_nota, ds_descricao, nm_valor, nm_qtde, cd_presserv, cd_imovel, cd_usuario" +
                      "  FROM imovdesp" +
                      " WHERE cd_despesa = ?";                
                PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    idespesa = new ImovelDespesa(
                            (Imovel)imovelr.getById(rs.getInt("cd_imovel")),
                            rs.getInt("cd_despesa"),
                            util.recebeData(rs.getString("to_char(dt_despesa,'dd/MM/yyyy')")),
                            rs.getString("nm_nota"),
                            rs.getString("ds_descricao"),
                            rs.getBigDecimal("nm_valor"),
                            rs.getInt("nm_qtde"),
                            (PrestadorServico)psr.getById(rs.getInt("cd_presserv")),
                            rs.getInt("cd_usuario"));
                }
                ps.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro de getByIdImovelDespesa em Despesas de Veículos:\n" +
                        ex.getMessage(), "Imovel Despesa", JOptionPane.ERROR_MESSAGE);
            }
        return idespesa;
    }
    
    /**
     * <p><strong>EN:</strong> Sums total expenses (value × quantity) for the current month
     * over a domain type (Animal, Vehicle, or Property). Selects the proper table based on
     * the runtime class and returns zero when no results are found.</p>
     *
     * <p><strong>IT:</strong> Somma le spese totali (valore × quantità) del mese corrente
     * per un tipo di dominio (Animale, Veicolo o Immobile). Sceglie la tabella in base al tipo
     * a runtime e restituisce zero se non ci sono risultati.</p>
     *
     * <p><strong>PT-BR:</strong> Soma as despesas totais (valor × quantidade) do mês corrente
     * para um tipo (Animal, Veículo ou Imóvel). Seleciona a tabela conforme o tipo em execução
     * e retorna zero quando não houver resultados.</p>
     */
    public BigDecimal somaDespesa(Object o) {
        BigDecimal mdespesa = null;
            try{
                Animal a = new Animal();
                if(o.getClass().equals(a.getClass())){
                    sql = "SELECT sum(nm_valor * nm_qtde) AS nm_total" +
                          "  FROM animdesp" +
                          " WHERE dt_despesa BETWEEN (SELECT trunc(SYSDATE,'MM') FROM DUAL) AND (SELECT trunc(LAST_DAY(SYSDATE)) FROM DUAL)" +
                          "   AND cd_usuario = ?";                    
                }
                Veiculo v = new Veiculo();
                if(o.getClass().equals(v.getClass())){
                    sql = "SELECT sum(nm_valor * nm_qtde) AS nm_total" +
                          "  FROM veicdesp" +
                          " WHERE dt_despesa BETWEEN (SELECT trunc(SYSDATE,'MM') FROM DUAL) AND (SELECT trunc(LAST_DAY(SYSDATE)) FROM DUAL)" +
                          "   AND cd_usuario = ?";                         
                }
                Imovel i = new Imovel();
                if(o.getClass().equals(i.getClass())){
                    sql = "SELECT sum(nm_valor * nm_qtde) AS nm_total" +
                          "  FROM imovdesp" +
                          " WHERE dt_despesa BETWEEN (SELECT trunc(SYSDATE,'MM') FROM DUAL) AND (SELECT trunc(LAST_DAY(SYSDATE)) FROM DUAL)" +
                          "   AND cd_usuario = ?";                         
                }
                PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
                ps.setInt(1, JPLogin.codloginuser);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    mdespesa = rs.getBigDecimal("nm_total");
                }
                ps.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro de soma em Despesa:\n" +
                        ex.getMessage(), "Modulo Despesa", JOptionPane.ERROR_MESSAGE);
            }
            if(mdespesa == null){
                mdespesa = Utilidade.converter("0,00");
            }
        return mdespesa;
    }    
}
