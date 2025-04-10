package br.com.rlmoura81.moura.catalogo;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EditoraRepository implements IPadraoRepository{

    String sql = "";

    @Override
    public void inserir(Object o) {        
        Editora e = (Editora) o;        
        try {
            sql = "INSERT INTO editora (cd_editora, ds_nome, cd_usuario)" +
                  "     VALUES (sq_editora.nextval, ?, ?)";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, e.getDs_nome());
            ps.setInt(2, e.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Editora", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" + 
                    ex.getMessage(), "Editora", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void alterar(Object o) {        
        Editora e = (Editora) o;        
        try{
            sql = "UPDATE editora " +
                  "   SET ds_nome = ?, " +
                  "       cd_usuario = ?" +
                  " WHERE cd_editora = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, e.getDs_nome());
            ps.setInt(2, e.getCd_usuario());
            ps.setInt(3, e.getCd_editora());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado.", "Editora", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" + 
                    ex.getMessage(), "Editora", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    @Override
    public void excluir(Object o) {        
        Editora e = (Editora) o;        
        try{
            sql = "DELETE FROM editora " +
                  " WHERE cd_editora = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, e.getCd_editora());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Editora", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" + 
                    ex.getMessage(), "Editora", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public ArrayList getLista() {       
        ArrayList editoras = new ArrayList();        
        try{
            sql = "SELECT cd_editora, ds_nome, cd_usuario " +
                  "  FROM editora" +
                  " ORDER BY ds_nome";   
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Editora e = new Editora(
                rs.getInt("cd_editora"),
                rs.getString("ds_nome"),
                rs.getInt("cd_usuario"));
                editoras.add(e);
            }
            ps.close();
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de editoras:\n" + 
                    ex.getMessage(), "Editora", JOptionPane.ERROR_MESSAGE);
        }
        return editoras;
    }

    @Override
    public Object getById(int id) {        
        Editora e = null;        
        try {
            sql = "SELECT cd_editora, ds_nome, cd_usuario "+
                  "  FROM editora " +
                  " WHERE cd_editora = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                e = new Editora(
                    rs.getInt("cd_editora"),
                    rs.getString("ds_nome"),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em editora:\n" +
                    ex.getMessage(), "Editora", JOptionPane.ERROR_MESSAGE);
        } 
        return e;    
    }
}
