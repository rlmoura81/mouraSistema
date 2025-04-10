package br.com.rlmoura81.moura.rpg;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DiarioRepository implements IPadraoRepository{
    
    String sql = "";
    
    TarefaRepository tarefar = new TarefaRepository();
    
    Utilidade util = new Utilidade();

    @Override
    public void inserir(Object o) {
        Diario d = (Diario) o;
        try{
            sql = "INSERT INTO diario(dt_diario, nm_valor, cd_tarefa, cd_usuario)" +
                  " VALUES (?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, Utilidade.formatoData.format(d.getDt_diario().getTime()));
            ps.setFloat(2, d.getTarefa().getNm_valor());
            ps.setInt(3, d.getTarefa().getCd_tarefa());
            ps.setInt(4, d.getCd_usuario());
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao inserir:\n" +
                    ex.getMessage());            
        }
    }

    public void inserirDiarioMes(Object o) {
        Diario d = (Diario) o;
        try{
            sql = "INSERT INTO diariomes(dt_diario, nm_valor, cd_tarefa, cd_usuario)" +
                  "     (SELECT dt_diario, nm_valor, cd_tarefa, cd_usuario" +
                  "                      FROM diario" +
                  "                      WHERE cd_usuario = ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, d.getCd_usuario());
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao inserir:\n" +
                    ex.getMessage());            
        }
    }
        
    @Override
    public void alterar(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void alterar(Object o, String datan, String datac) {
        Diario d = (Diario) o;
        try{
            sql = "UPDATE diario SET dt_diario = ?, nm_valor = ?" +
                  " WHERE dt_diario = ? AND cd_tarefa = ? AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, datan);
            ps.setFloat(2, d.getTarefa().getNm_valor());
            ps.setString(3, datac);
            ps.setInt(4, d.getTarefa().getCd_tarefa());
            ps.setInt(5, d.getCd_usuario());
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage());            
        }
    }

    @Override
    public void excluir(Object o) {
        Diario d = (Diario) o;
        try{
            sql = "DELETE FROM diario WHERE dt_diario = ? AND cd_tarefa = ? AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, Utilidade.formatoData.format(d.getDt_diario().getTime()));
            ps.setInt(2, d.getTarefa().getCd_tarefa());
            ps.setInt(3, d.getCd_usuario());
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage());            
        }
    }
    
    public void excluirDiario(Object o) {
        Diario d = (Diario) o;
        try{
            sql = "DELETE FROM diario WHERE cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, d.getCd_usuario());
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
    
    public ArrayList getListaDiario() {
        ArrayList diario = new ArrayList();
        try{
            sql = "SELECT to_char(dt_diario,'dd/MM/yyyy'), diario.cd_tarefa, diario.cd_usuario" +
                  "   FROM diario, tarefa" + 
                  "   WHERE diario.cd_usuario = ?" + 
                  "     AND diario.cd_tarefa = tarefa.cd_tarefa" +
                  "   ORDER BY dt_diario, ds_tarefa";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Diario d = new Diario(
                        util.recebeData(rs.getString("to_char(dt_diario,'dd/MM/yyyy')")),
                        (Tarefa)tarefar.getById(rs.getInt("cd_tarefa")),
                        rs.getInt("cd_usuario"));
                diario.add(d);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de diario:\n" +
                    ex.getMessage());
        }
        return diario;
    }

    public ArrayList getListaDiarioDia(String data) {
        ArrayList diario = new ArrayList();
        try{
            sql = "SELECT to_char(dt_diario,'dd/MM/yyyy'), diario.cd_tarefa, diario.cd_usuario" +
                  "   FROM diario, tarefa" + 
                  "   WHERE dt_diario = ?" + 
                  "     AND diario.cd_tarefa = tarefa.cd_tarefa" +
                  "     AND diario.cd_usuario = ?" +
                  "   ORDER BY dt_diario, ds_tarefa";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, data);
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Diario d = new Diario(
                        util.recebeData(rs.getString("to_char(dt_diario,'dd/MM/yyyy')")),
                        (Tarefa)tarefar.getById(rs.getInt("cd_tarefa")),
                        rs.getInt("cd_usuario"));
                diario.add(d);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de diario:\n" +
                    ex.getMessage());
        }
        return diario;
    }
        
    public ArrayList getListaDiarioResumo() {
        ArrayList diario = new ArrayList();
        try{
            sql = "SELECT to_char(dt_diario,'dd/MM/yyyy'), sum(nm_valor)" +
                  "       FROM diario" +
                  "       WHERE cd_usuario = ?" +
                  "       GROUP BY dt_diario" +
                  "       ORDER BY dt_diario";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Diario d = new Diario(
                        util.recebeData(rs.getString("to_char(dt_diario,'dd/MM/yyyy')")),
                        rs.getFloat("sum(nm_valor)"));
                diario.add(d);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de diario resumo:\n" +
                    ex.getMessage());
        }
        return diario;
    }

    @Override
    public Object getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Object getById(String id) {
        System.out.println("--objeto vazio String id");
        Diario d = null;
        try{
            sql = "SELECT to_char(dt_diario,'dd/MM/yyyy'), cd_tarefa, cd_usuario" +
                  "   FROM diario" +
                  "   WHERE dt_diario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                d = new Diario(
                        util.recebeData(rs.getString("to_char(dt_diario,'dd/MM/yyyy')")),
                        (Tarefa)tarefar.getById(rs.getInt("cd_tarefa")),
                        rs.getInt("cd_usuario"));
            }
            ps.close();            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em diario:\n" +
                    ex.getMessage());
        }
        return d;
    }   
    
    public Object getByIdDia(String id) {
        System.out.println("--objeto vazio Dia String id");         
        Diario d = null;
        try{
            sql = "SELECT to_char(dt_diario,'dd/MM/yyyy'), sum(nm_valor)" +
                  "   FROM diario" +
                  "   WHERE dt_diario = ?" +
                  "   GROUP BY dt_diario";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                d = new Diario(
                        util.recebeData(rs.getString("to_char(dt_diario,'dd/MM/yyyy')")),
                        rs.getFloat("sum(nm_valor)"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getByIdDia em diario:\n" +
                    ex.getMessage());
        }
        return d;
    }

}