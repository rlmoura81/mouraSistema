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
