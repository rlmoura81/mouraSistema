package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class IndiceValorRepository implements IPadraoRepository{
    
    String sql = "";
    
    Utilidade util = new Utilidade();
    
    IndiceRepository indicer = new IndiceRepository();

    @Override
    public void inserir(Object o) {
        IndiceValor iv = (IndiceValor) o;
        
        try{
            sql = "INSERT INTO indicevalor (cd_indicevl, dt_vlatualizado, vl_mes, cd_indice, cd_usuario)" +
                  "     VALUES (sq_indicevl.nextval, ?, ?, ?, ?)";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, Utilidade.formatoData.format(iv.getDt_vlatualizado().getTime()));
            ps.setBigDecimal(2, iv.getVl_mes());
            ps.setInt(3, iv.getIndice().getCd_indice());
            ps.setInt(4, iv.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Índice Valor", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" + 
                    ex.getMessage(), "Índicie Valor", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void alterar(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Object o) {
        IndiceValor iv = (IndiceValor) o;
        try{
            sql = "DELETE FROM indicevalor " +
                  " WHERE cd_indicevl = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, iv.getCd_indicevl());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Índice Valor", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Índice Valor", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public ArrayList getLista() {
        ArrayList indicevalores = new ArrayList();
        try{
            sql = "SELECT cd_indicevl, to_char(dt_vlatualizado,'dd/MM/yyyy'), vl_mes, cd_indice, cd_usuario " +
                  "  FROM indicevalor " +
                  " ORDER BY cd_indice, dt_vlatualizado";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                IndiceValor iv = new IndiceValor(
                    rs.getInt("cd_indicevl"),
                    rs.getBigDecimal("vl_mes"),
                    util.recebeData(rs.getString("to_char(dt_vlatualizado,'dd/MM/yyyy')")),    
                    (Indice)indicer.getById(rs.getInt("cd_indice")),
                    rs.getInt("cd_usuario"));
                indicevalores.add(iv);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Indice de Valores:\n" +
                    ex.getMessage(), "Índice Valor", JOptionPane.ERROR_MESSAGE);
        }
        return indicevalores;
    }
    
    public ArrayList getLista(int cd_indice) {
        ArrayList indicevalores = new ArrayList();
        try{
            sql = "SELECT cd_indicevl, to_char(dt_vlatualizado,'dd/MM/yyyy'), vl_mes, cd_indice, cd_usuario " +
                  "   FROM indicevalor " +
                  "   WHERE cd_indice = ?" +
                  "   ORDER BY cd_indice, dt_vlatualizado";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_indice);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                IndiceValor iv = new IndiceValor(
                    rs.getInt("cd_indicevl"),
                    rs.getBigDecimal("vl_mes"),
                    util.recebeData(rs.getString("to_char(dt_vlatualizado,'dd/MM/yyyy')")),    
                    (Indice)indicer.getById(rs.getInt("cd_indice")),
                    rs.getInt("cd_usuario"));
                indicevalores.add(iv);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Indice de Valores:\n" +
                    ex.getMessage(), "Índice Valor", JOptionPane.ERROR_MESSAGE);
        }
        return indicevalores;
    }

    @Override
    public Object getById(int id) {
        IndiceValor iv = null;
        try{
            sql = "SELECT cd_indicevl, to_char(dt_vlatualizado,'dd/MM/yyyy'), vl_mes, cd_indice, cd_usuario " +
                  "  FROM indicevalor " +
                  " WHERE cd_indicevl = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                iv = new IndiceValor(
                rs.getInt("cd_indicevl"),
                rs.getBigDecimal("vl_mes"),
                util.recebeData(rs.getString("to_char(dt_vlatualizado,'dd/MM/yyyy')")),    
                (Indice)indicer.getById(rs.getInt("cd_indice")),
                rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em Indice de Valores:\n" +
                    ex.getMessage(), "Índice Valor", JOptionPane.ERROR_MESSAGE);
        }
        return iv;
    }
    
    public Object getValorIndice(int cd_indice) {
        IndiceValor iv = null;
        try{
            sql = "SELECT cd_indicevl, to_char(dt_vlatualizado,'dd/MM/yyyy'), vl_mes, cd_indice, cd_usuario " +
                  "  FROM indicevalor " +
                  " WHERE cd_indice = ?" + 
                  " ORDER BY dt_vlatualizado DESC";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_indice);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                iv = new IndiceValor(
                rs.getInt("cd_indicevl"),
                rs.getBigDecimal("vl_mes"),
                util.recebeData(rs.getString("to_char(dt_vlatualizado,'dd/MM/yyyy')")),    
                (Indice)indicer.getById(rs.getInt("cd_indice")),
                rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getByValorIndice em Indice de Valores:\n" +
                    ex.getMessage());
        }
        return iv;
    }
}    

