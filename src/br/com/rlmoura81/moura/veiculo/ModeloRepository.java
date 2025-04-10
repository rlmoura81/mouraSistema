package br.com.rlmoura81.moura.veiculo;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ModeloRepository implements IPadraoRepository{

    String sql = "";
    
    MarcaRepository marcar = new MarcaRepository();
    
    @Override
    public void inserir(Object o) {       
        Modelo m = (Modelo) o;
        try{
            sql = "INSERT INTO modelo (cd_modelo, ds_modelo, cd_marca, cd_usuario)" +
                  "     VALUES (sq_modelo.nextval, ?, ?, ?)";
            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, m.getDs_modelo());
            ps.setInt(2, m.getMarca().getCd_marca());
            ps.setInt(3, m.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Modelo", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Modelo", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void alterar(Object o) {       
        Modelo m = (Modelo) o;        
        try{
            sql = "UPDATE modelo " +
                  "   SET ds_modelo = ?, " +
                  "       cd_marca = ?, " +
                  "       cd_usuario = ? " +
                  " WHERE cd_modelo = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, m.getDs_modelo());
            ps.setInt(2, m.getMarca().getCd_marca());
            ps.setInt(3, m.getCd_usuario());
            ps.setInt(4, m.getCd_modelo());
            ps.execute();
            ps.close();
            JOptionPane.showConfirmDialog(null, "Alterado.", "Modelo", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Modelo", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void excluir(Object o) {        
        Modelo m = (Modelo) o;        
        try{
            sql = "DELETE FROM modelo " +
                  " WHERE cd_modelo = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, m.getCd_modelo());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido", "Modelo", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Modelo", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public ArrayList getLista() {
        ArrayList modelo = new ArrayList();
        try{
            sql = "SELECT cd_modelo, ds_modelo, cd_marca, cd_usuario" +
                  "  FROM modelo" + 
                  " ORDER BY ds_modelo";                  
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Modelo m = new Modelo(
                    rs.getInt("cd_modelo"),
                    rs.getString("ds_modelo"),
                    (Marca)marcar.getById(rs.getInt("cd_marca")),
                    rs.getInt("cd_usuario"));
                modelo.add(m);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de modelos:\n" +
                    ex.getMessage(), "Modelo", JOptionPane.ERROR_MESSAGE);
        }        
        return modelo;
    }

    @Override
    public Object getById(int id) {
        Modelo m = null;
        try{
            sql = "SELECT cd_modelo, ds_modelo, cd_marca, cd_usuario" +
                  "  FROM modelo " + 
                  " WHERE cd_modelo = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                m = new Modelo(
                    rs.getInt("cd_modelo"),
                    rs.getString("ds_modelo"),
                    (Marca)marcar.getById(rs.getInt("cd_marca")),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em modelo:\n" +
                    ex.getMessage(), "Modelo", JOptionPane.ERROR_MESSAGE);
        }
        return m;
    }    
}
