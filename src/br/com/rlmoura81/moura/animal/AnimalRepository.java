package br.com.rlmoura81.moura.animal;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AnimalRepository implements IPadraoRepository{

    String sql = "";

    RacaRepository rar = new RacaRepository();
    
    Utilidade util = new Utilidade();
    
    @Override
    public void inserir(Object o) {    
        Animal a = (Animal) o;        
        try{
            sql = "INSERT INTO animal (cd_animal, ds_nome, dt_nasc, ds_sexo, cd_raca, cd_usuario)" +
                  "     VALUES (sq_animal.nextval, ?, ?, ?, ?, ?)";            
                PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
                ps.setString(1, a.getDs_nome());
                ps.setString(2, Utilidade.formatoData.format(a.getDt_nasc().getTime()));
                ps.setString(3, a.getDs_sexo());
                ps.setInt(4, a.getRaca().getCd_raca());
                ps.setInt(5, a.getCd_usuario());
                ps.execute();
                ps.close();
                JOptionPane.showMessageDialog(null, "Salvo.", "Animal", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Animal", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void alterar(Object o) {    
        Animal a = (Animal) o;              
        try{
            sql = "UPDATE animal " +
                  "   SET ds_nome = ?, " +
                  "       dt_nasc = ?, " +
                  "       ds_sexo = ?, " +  
                  "       cd_raca = ?" +
                  " WHERE cd_animal = ? " +
                  "   AND cd_usuario = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, a.getDs_nome());
            ps.setString(2, Utilidade.formatoData.format(a.getDt_nasc()));
            ps.setString(3, a.getDs_sexo());
            ps.setInt(4, a.getRaca().getCd_raca());
            ps.setInt(5, a.getCd_animal());
            ps.setInt(6, a.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado.", "Animal", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Animal", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void excluir(Object o) {    
        Animal a = (Animal) o;        
        try{
            sql = "DELETE FROM animal "   +
                  " WHERE cd_animal = ? " +
                  "   AND cd_usuario = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, a.getCd_animal());
            ps.setInt(2, a.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Animal", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Animal", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public ArrayList getLista() {        
        ArrayList animais = new ArrayList();        
        try{
            sql = "SELECT cd_animal, ds_nome, to_char(dt_nasc,'dd/MM/yyyy'), ds_sexo, cd_raca, cd_usuario" +
                  "  FROM animal" +
                  " WHERE cd_usuario = ?" +
                  " ORDER BY ds_nome";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while (rs.next()){
                Animal a = new Animal(
                    rs.getInt("cd_animal"),
                    rs.getString("ds_nome"),
                    util.recebeData(rs.getString("to_char(dt_nasc,'dd/MM/yyyy')")),
                    rs.getString("ds_sexo"),
                    (Raca)rar.getById(rs.getInt("cd_raca")),
                    rs.getInt("cd_usuario"));
                animais.add(a);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de animais:\n" +
                    ex.getMessage(), "Animal", JOptionPane.ERROR_MESSAGE);
        }
        return animais;
    }

    @Override
    public Object getById(int id) {        
        Animal a = null;        
        try{
            sql = "SELECT cd_animal, ds_nome, to_char(dt_nasc,'dd/MM/yyyy'), ds_sexo, cd_raca, cd_usuario" +
                  "  FROM animal" +
                  " WHERE cd_animal = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                a = new Animal(
                    rs.getInt("cd_animal"),
                    rs.getString("ds_nome"),
                    util.recebeData(rs.getString("to_char(dt_nasc,'dd/MM/yyyy')")),
                    rs.getString("ds_sexo"),
                    (Raca)rar.getById(rs.getInt("cd_raca")),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em animal:\n"  +  
                    ex.getMessage(), "Animal", JOptionPane.ERROR_MESSAGE);
        }
        return a;
    }
    
}
