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
