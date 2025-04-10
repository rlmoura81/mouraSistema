package br.com.rlmoura81.moura.animal;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class RacaRepository implements IPadraoRepository{

    String sql = "";
    
    EspecieRepository especier = new EspecieRepository();

    @Override
    public void inserir(Object o) {        
        Raca r = (Raca) o;        
        try{
            sql = "INSERT INTO raca (cd_raca, ds_raca, cd_especie, cd_usuario)" +
                  "     VALUES (sq_raca.nextval, ?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, r.getDs_raca());
            ps.setInt(2, r.getEspecie().getCd_especie());
            ps.setInt(3, r.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Raça", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Raça", JOptionPane.ERROR);
        }
    }

    @Override
    public void alterar(Object o) {        
        Raca r = (Raca) o;        
        try{
            sql = "UPDATE raca " +
                  "   SET ds_raca = ?, " +
                  "       cd_especie = ?," +
                  "       cd_usuario = ?" + 
                  " WHERE cd_raca = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, r.getDs_raca());
            ps.setInt(2, r.getEspecie().getCd_especie());
            ps.setInt(3, r.getCd_usuario());
            ps.setInt(4, r.getCd_raca());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado.", "Raça", JOptionPane.INFORMATION_MESSAGE);            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Raça", JOptionPane.ERROR);
        }
    }
                
    @Override
    public void excluir(Object o) {        
        Raca r = (Raca) o;         
        try{
            sql = "DELETE FROM raca " +
                  " WHERE cd_raca = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, r.getCd_raca());
            ps.execute();        
            JOptionPane.showMessageDialog(null, "Excluido.", "Raça", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){    
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Raça", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public ArrayList getLista() {        
        ArrayList racas = new ArrayList();        
        try{
            sql = "SELECT cd_raca, ds_raca, cd_especie, cd_usuario" + 
                  "  FROM raca" +
                  " ORDER BY ds_raca";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while (rs.next()){
                Raca r = new Raca(
                    rs.getInt("cd_raca"),
                    rs.getString("ds_raca"),
                    (Especie)especier.getById(rs.getInt("cd_especie")),
                    rs.getInt("cd_usuario"));
                racas.add(r);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Raça:\n" +
                    ex.getMessage(), "Raça", JOptionPane.ERROR_MESSAGE);
        }
        return racas;
    }

    @Override
    public Object getById(int id) {        
        Raca r = null;        
        try{
            sql = "SELECT cd_raca, ds_raca, cd_especie, cd_usuario " +
                  "  FROM raca " +
                  " WHERE cd_raca = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                r = new Raca(
                    rs.getInt("cd_raca"),
                    rs.getString("ds_raca"),
                    (Especie)especier.getById(rs.getInt("cd_especie")),
                    rs.getInt("cd_usuario")
                );
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em Raça:\n" + 
            ex.getMessage(), "Raça", JOptionPane.ERROR_MESSAGE);
        }
        return r;
    }
    
}
