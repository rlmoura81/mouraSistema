package br.com.rlmoura81.moura.rpg;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TarefaRepository implements IPadraoRepository{
    
    String sql = "";
    
    Utilidade util = new Utilidade();

    @Override
    public void inserir(Object o) {
        Tarefa t = (Tarefa) o;
        try{
            sql = "INSERT INTO tarefa(cd_tarefa, ds_tarefa, nm_valor, tp_tempo, cd_usuario)" +
                  " VALUES (sq_tarefa.nextval, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, t.getDs_tarefa());
            ps.setFloat(2, t.getNm_valor());
            ps.setInt(3, t.getTp_tempo());
            ps.setInt(4, t.getCd_usuario());
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao inserir:\n" +
                    ex.getMessage());            
        }
    }

    @Override
    public void alterar(Object o) {
        Tarefa t = (Tarefa) o;
        try{
            sql = "UPDATE tarefa SET ds_tarefa = ?, nm_valor = ?, tp_tempo = ?" +
                  " WHERE cd_tarefa = ? AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, t.getDs_tarefa());
            ps.setFloat(2, t.getNm_valor());
            ps.setInt(3, t.getTp_tempo());
            ps.setInt(4, t.getCd_tarefa());
            ps.setInt(5, t.getCd_usuario());
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage());            
        }
    }

    @Override
    public void excluir(Object o) {
        Tarefa t = (Tarefa) o;
        try{
            sql = "DELETE FROM tarefa WHERE cd_tarefa = ? AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, t.getCd_tarefa());
            ps.setInt(2, t.getCd_usuario());
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage());            
        }
    }

    @Override
    public ArrayList getLista() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public ArrayList getListaTarefa() {
        ArrayList tarefa = new ArrayList();
        try{
            sql = "SELECT cd_tarefa, ds_tarefa, nm_valor, tp_tempo, cd_usuario" +
                  "   FROM tarefa" +
                  "   WHERE cd_usuario = ?" +
                  "   ORDER BY ds_tarefa";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Tarefa t = new Tarefa(
                    rs.getInt("cd_tarefa"),
                    rs.getString("ds_tarefa"),    
                    rs.getFloat("nm_valor"),
                    rs.getInt("tp_tempo"),
                    rs.getInt("cd_usuario"));
                tarefa.add(t);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de tarefa:\n" +
                    ex.getMessage());
        }
        return tarefa;
    }

    @Override
    public Object getById(int id) {
        Tarefa t = null;
        try{
            sql = "SELECT cd_tarefa, ds_tarefa, nm_valor, tp_tempo, cd_usuario" +
                  "   FROM tarefa" +
                  "   WHERE cd_tarefa = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                t = new Tarefa(
                    rs.getInt("cd_tarefa"),
                    rs.getString("ds_tarefa"),    
                    rs.getFloat("nm_valor"),
                    rs.getInt("tp_tempo"),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em tarefa:\n" +
                    ex.getMessage());
        }
        return t;
    } 
    
}
