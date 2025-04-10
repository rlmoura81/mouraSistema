package br.com.rlmoura81.moura.principal;

import br.com.rlmoura81.moura.principalcadastro.Categoria;
import br.com.rlmoura81.moura.principalcadastro.CategoriaRepository;
import br.com.rlmoura81.moura.principalcadastro.PrestadorServico;
import br.com.rlmoura81.moura.principalcadastro.PrestadorServicoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ModuloAplicativoRepository {
    
    String sql = "";
    
    ModuloRepository modulor = new ModuloRepository();
    
    PrestadorServicoRepository presservr = new PrestadorServicoRepository();
    
    CategoriaRepository categoriar = new CategoriaRepository();
    
    public void inserirCatMod(Object o) {
        ModuloAplicativo modapp = (ModuloAplicativo) o;
        try{
            sql = "INSERT INTO catmod (cd_modulo, cd_categoria, cd_usuario)" +
                  "     VALUES (?, ?, ?)";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, modapp.getModulo().getCd_modulo());
            ps.setInt(2, modapp.getCategoria().getCd_Categoria());
            ps.setInt(3, modapp.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Categoria - Modulo", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Categoria - Modulo", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void inserirPresServMod(Object o) {
        ModuloAplicativo modapp = (ModuloAplicativo) o;
        try{
            sql = "INSERT INTO presservmod (cd_modulo, cd_presserv, cd_usuario)" +
                  "     VALUES (?, ?, ?)";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, modapp.getModulo().getCd_modulo());
            ps.setInt(2, modapp.getPresserv().getCd_presserv());
            ps.setInt(3, modapp.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Prestador de Serviço - Modulo", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Prestador de Serviço - Modulo", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ArrayList getListaCatMod() {
        ArrayList modapp = new ArrayList();
        try{
            sql = "SELECT modulo.cd_modulo, categoria.cd_categoria, catmod.cd_usuario" +
                  "  FROM modulo, categoria, catmod" +
                  " WHERE modulo.cd_modulo = catmod.cd_modulo" +
                  "   AND categoria.cd_categoria = catmod.cd_categoria" +
                  "   AND categoria.cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                ModuloAplicativo ma = new ModuloAplicativo(
                    (Modulo)modulor.getById(rs.getInt("cd_modulo")),
                    (Categoria)categoriar.getById(rs.getInt("cd_categoria")),                      
                    rs.getInt("cd_usuario"));
                modapp.add(ma);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de MódulosApp - Categoria:\n" +
                    ex.getMessage(), "Categoria - Modulo", JOptionPane.ERROR_MESSAGE);
        }
        return modapp;
    }
            
    public ArrayList getListaPresservMod() {
        ArrayList modapp = new ArrayList();
        try{
            sql = "SELECT modulo.cd_modulo, presserv.cd_presserv, presservmod.cd_usuario" +
                  "  FROM modulo, presserv, presservmod" +
                  " WHERE modulo.cd_modulo = presservmod.cd_modulo" +
                  "   AND presserv.cd_presserv = presservmod.cd_presserv" +
                  "   AND presserv.cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                ModuloAplicativo ma = new ModuloAplicativo(
                    (Modulo)modulor.getById(rs.getInt("cd_modulo")),
                    (PrestadorServico)presservr.getById(rs.getInt("cd_presserv")),                      
                    rs.getInt("cd_usuario"));
                modapp.add(ma);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de MódulosApp - PresServ:\n" +
                    ex.getMessage(), "Prestador de Serviço - Modulo", JOptionPane.ERROR_MESSAGE);
        }
        return modapp;
    }
    
    public ArrayList getListaPresServMod(int cd_modulo) {
        ArrayList modapp = new ArrayList();
        try{
            sql = "SELECT modulo.cd_modulo, presserv.cd_presserv, presservmod.cd_usuario" +
                  "  FROM modulo, presserv, presservmod" +
                  " WHERE modulo.cd_modulo = presservmod.cd_modulo" +
                  "   AND modulo.cd_modulo = ?" +
                  "   AND presserv.cd_presserv = presservmod.cd_presserv";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_modulo);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                ModuloAplicativo ma = new ModuloAplicativo(
                    (Modulo)modulor.getById(rs.getInt("cd_modulo")),
                    (PrestadorServico)presservr.getById(rs.getInt("cd_presserv")),                      
                    rs.getInt("cd_usuario"));
                modapp.add(ma);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de MódulosApp - PresServ:\n" +
                    ex.getMessage(), "Prestador de Serviço - Modulo", JOptionPane.ERROR_MESSAGE);
        }
        return modapp;
    }

    public Object getByIdCatMod(int id) {
        ModuloAplicativo modapp = null;
        try{
            sql = "SELECT modulo.cd_modulo, categoria.cd_categoria, catmod.cd_usuario" +
                  "  FROM modulo, categoria, catmod" +
                  " WHERE modulo.cd_modulo = catmod.cd_modulo" +
                  "   AND categoria.cd_categoria = catmod.cd_categoria" +
                  "   AND categoria.cd_categoria = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                ModuloAplicativo ma = new ModuloAplicativo(
                    (Modulo)modulor.getById(rs.getInt("cd_modulo")),
                    (Categoria)categoriar.getById(rs.getInt("cd_categoria")),                       
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em MódulosApp - Categoria:\n" +
                    ex.getMessage(), "Categoria - Modulo", JOptionPane.ERROR_MESSAGE);
        }
        return modapp;
    }
        
    public Object getByIdPresServMod(int id) {
        ModuloAplicativo modapp = null;
        try{
            sql = "SELECT presserv.cd_presserv, modulo.cd_modulo, presservmod.cd_usuario" +
                  "  FROM modulo, presserv, presservmod" +
                  " WHERE modulo.cd_modulo = presservmod.cd_modulo" +
                  "   AND presserv.cd_presserv = presservmod.cd_presserv" +
                  "   AND presserv.cd_presserv = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                ModuloAplicativo ma = new ModuloAplicativo(
                    (Modulo)modulor.getById(rs.getInt("cd_modulo")),
                    (PrestadorServico)presservr.getById(rs.getInt("cd_presserv")),                       
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em MódulosApp - PresServ:\n" +
                    ex.getMessage(), "Prestador de Serviço - Modulo", JOptionPane.ERROR_MESSAGE);
        }
        return modapp;
    }    
}
