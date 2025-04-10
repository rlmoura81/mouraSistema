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
