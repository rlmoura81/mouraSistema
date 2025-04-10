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
