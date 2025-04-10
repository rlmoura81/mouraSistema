package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class NotaCorretagemRepository implements IPadraoRepository{
    
    String sql = "";
    
    ContaRepository contar = new ContaRepository();
    
    Utilidade util = new Utilidade();

    @Override
    public void inserir(Object o) {
        NotaCorretagem nc = (NotaCorretagem) o;
        try{
            sql = "INSERT INTO notacorretagem (cd_nota, nm_nota, dt_nota, cd_conta, cd_usuario)" + 
                  "     VALUES (sq_notacorretagem.nextval, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, nc.getNm_nota());
            ps.setString(2, Utilidade.formatoData.format(nc.getDt_nota().getTime()));
            ps.setInt(3, nc.getConta().getCd_conta());
            ps.setInt(4, nc.getCd_usuario());
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao inserir:\n" +
                    ex.getMessage());
        }
    }

    @Override
    public void alterar(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList getLista() {
        ArrayList notac = new ArrayList();
        try{
            sql = "SELECT cd_nota, nm_nota, to_char(dt_nota,'dd/MM/yyyy'), cd_conta, cd_usuario" +
                  "  FROM notacorretagem" + 
                  " WHERE cd_usuario = ?" +
                  " ORDER BY cd_nota DESC";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                NotaCorretagem nc = new NotaCorretagem(
                        rs.getInt("cd_nota"),
                        rs.getInt("nm_nota"),
                        util.recebeData(rs.getString("to_char(dt_nota,'dd/MM/yyyy')")),
                        (Conta)contar.getById(rs.getInt("cd_conta")),
                        rs.getInt("cd_usuario"));
                notac.add(nc);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Notas de Corretagens:\n" +
                    ex.getMessage());
        }
        return notac;
    }
    
    public ArrayList getLista(int cd_conta) {
        ArrayList notac = new ArrayList();
        try{
            sql = "SELECT cd_nota, nm_nota, to_char(dt_nota,'dd/MM/yyyy'), cd_conta, cd_usuario" +
                  "  FROM notacorretagem" + 
                  " WHERE cd_conta = ?" +
                  "   AND cd_usuario = ?" +
                  " ORDER BY cd_nota DESC";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_conta);
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                NotaCorretagem nc = new NotaCorretagem(
                        rs.getInt("cd_nota"),
                        rs.getInt("nm_nota"),
                        util.recebeData(rs.getString("to_char(dt_nota,'dd/MM/yyyy')")),
                        (Conta)contar.getById(rs.getInt("cd_conta")),
                        rs.getInt("cd_usuario"));
                notac.add(nc);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Notas de Corretagens:\n" +
                    ex.getMessage());
        }
        return notac;
    }

    @Override
    public Object getById(int id) {
        NotaCorretagem notac = null;
        try{
            sql = "SELECT cd_nota, nm_nota, to_char(dt_nota,'dd/MM/yyyy'), cd_conta, cd_usuario" +
                  "  FROM notacorretagem" + 
                  " WHERE cd_nota = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                notac = new NotaCorretagem(
                        rs.getInt("cd_nota"),
                        rs.getInt("nm_nota"),
                        util.recebeData(rs.getString("to_char(dt_nota,'dd/MM/yyyy')")),
                        (Conta)contar.getById(rs.getInt("cd_conta")),
                        rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em Notas de Corretagens:\n" +
                    ex.getMessage());
        }
        return notac;
    }
    
    public Object getByCodNota() {
        NotaCorretagem notac = null;
        try{
            sql = "SELECT cd_nota, nm_nota, to_char(dt_nota,'dd/MM/yyyy'), cd_conta, cd_usuario" +
                  "  FROM notacorretagem" +
                  " ORDER BY cd_nota DESC";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                notac = new NotaCorretagem(
                        rs.getInt("cd_nota"),
                        rs.getInt("nm_nota"),
                        util.recebeData(rs.getString("to_char(dt_nota,'dd/MM/yyyy')")),
                        (Conta)contar.getById(rs.getInt("cd_conta")),
                        rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getByCodNota em Notas de Corretagens:\n" +
                    ex.getMessage());
        }
        return notac;
    }    
}
