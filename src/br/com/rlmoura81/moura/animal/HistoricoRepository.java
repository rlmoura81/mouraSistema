package br.com.rlmoura81.moura.animal;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalcadastro.PrestadorServico;
import br.com.rlmoura81.moura.principalcadastro.PrestadorServicoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class HistoricoRepository implements IPadraoRepository{
    
    AnimalRepository animalr = new AnimalRepository();
    
    PrestadorServicoRepository presservr = new PrestadorServicoRepository();
        
    TipoRepository tipor = new TipoRepository();
    
    Utilidade util = new Utilidade();
    
    String sql = "";
    
    @Override
    public void inserir(Object o) {
        Historico h = (Historico) o;
        try{
            sql = "INSERT INTO historico (cd_historico, dt_historico, ds_historico, cd_presserv, cd_animal, cd_tipo, cd_usuario)" +
                  "     VALUES (sq_historico.nextval, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, Utilidade.formatoData.format(h.getDt_historico().getTime()));
            ps.setString(2, h.getDs_historico());
            ps.setInt(3, h.getPresserv().getCd_presserv());
            ps.setInt(4, h.getAnimal().getCd_animal());
            ps.setInt(5, h.getTipo().getCd_tipo());
            ps.setInt(6, h.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Historico", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao inserir:\n" +
                    ex.getMessage(), "Historico", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void alterar(Object o) {
        Historico h = (Historico) o;
        try{
            sql = "UPDATE historico " +
                  "   SET dt_historico = ?, " +
                  "       ds_historico = ?, " +
                  "       cd_presserv = ?, " +
                  "       cd_tipo = ?" +
                  " WHERE cd_historico = ? " +
                  "   AND cd_animal = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, Utilidade.formatoData.format(h.getDt_historico().getTime()));
            ps.setString(2, h.getDs_historico());
            ps.setInt(3, h.getPresserv().getCd_presserv());
            ps.setInt(4, h.getTipo().getCd_tipo());
            ps.setInt(5, h.getCd_historico());
            ps.setInt(6, h.getAnimal().getCd_animal());
            ps.setInt(7, h.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Historico", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Historico", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void excluir(Object o) {
        Historico h = (Historico) o;
        try{
            sql = "DELETE FROM historico " +
                  " WHERE cd_historico = ? " + 
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, h.getCd_historico());
            ps.setInt(2, h.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido", "Historico", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Historico", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public ArrayList getLista() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public ArrayList getLista(int cd_animal) {
        ArrayList historico = new ArrayList();
        try{
            sql = "SELECT cd_historico, to_char(dt_historico,'dd/MM/yyyy'), ds_historico, cd_presserv, cd_animal, cd_tipo, cd_usuario" +
                  "  FROM historico" +
                  " WHERE cd_animal = ? " +
                  "   AND cd_usuario = ?" +
                  " ORDER BY dt_historico";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_animal);
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Historico h = new Historico(
                    rs.getInt("cd_historico"),
                    util.recebeData(rs.getString("to_char(dt_historico,'dd/MM/yyyy')")),
                    rs.getString("ds_historico"),
                    (PrestadorServico)presservr.getById(rs.getInt("cd_presserv")),
                    (Animal)animalr.getById(rs.getInt("cd_animal")),
                    (Tipo)tipor.getById(rs.getInt("cd_tipo")),
                    rs.getInt("cd_usuario"));
                historico.add(h);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar o historico:\n" +
                    ex.getMessage(), "Historico", JOptionPane.ERROR_MESSAGE);
        }
        return historico;
    }

    @Override
    public Object getById(int id) {
        Historico h = null;
        try{
            sql = "SELECT cd_historico, to_char(dt_historico,'dd/MM/yyyy'), ds_historico, cd_presserv, cd_animal, cd_tipo, cd_usuario" +
                  "  FROM historico" +
                  " WHERE cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                h = new Historico(
                    rs.getInt("cd_historico"),
                    util.recebeData(rs.getString("to_char(dt_historico,'dd/MM/yyyy')")),
                    rs.getString("ds_historico"),
                    (PrestadorServico)presservr.getById(rs.getInt("cd_presserv")),
                    (Animal)animalr.getById(rs.getInt("cd_animal")),
                    (Tipo)tipor.getById(rs.getInt("cd_tipo")),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em Historico:\n" +
                    ex.getMessage(), "Historico", JOptionPane.ERROR_MESSAGE);
        }
        return h;
    }
}
