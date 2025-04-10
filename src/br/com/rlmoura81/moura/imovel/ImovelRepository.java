package br.com.rlmoura81.moura.imovel;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalcadastro.Cidade;
import br.com.rlmoura81.moura.principalcadastro.CidadeRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ImovelRepository implements IPadraoRepository{
    
    String sql = "";
    
    TipoImovelRepository tpimovelr = new TipoImovelRepository();
    
    CidadeRepository cidader = new CidadeRepository();

    @Override
    public void inserir(Object o) {
        Imovel i = (Imovel) o;
        try{
            sql = "INSERT INTO imovel (cd_imovel, nm_matricula, nm_metragem, nm_valor, ds_descricao, cd_tpimovel, cd_cidade, cd_usuario)" +
                  "     VALUES (sq_imovel.nextval, ?, ?, ?, ?, ?, ?, ?)";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, i.getNm_matricula());
            ps.setBigDecimal(2, i.getNm_metragem());
            ps.setBigDecimal(3, i.getNm_valorMatricula());
            ps.setString(4, i.getDs_descricao());
            ps.setInt(5, i.getTpimovel().getCd_tpimovel());
            ps.setInt(6, i.getCidade().getCd_Cidade());
            ps.setInt(7, i.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Imovel", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Imovel", JOptionPane.ERROR_MESSAGE); 
        }
    }

    @Override
    public void alterar(Object o) {
        Imovel i = (Imovel) o;
        try{
            sql = "UPDATE imovel " +
                  "   SET nm_matricula = ?, " + 
                  "       nm_metragem = ?, " +
                  "       nm_valor = ?, " +
                  "       ds_descricao = ?, " +
                  "       cd_tpimovel = ?, " +
                  "       cd_cidade = ? " +
                  " WHERE cd_imovel = ? " +
                  "   AND cd_usuario = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, i.getNm_matricula());
            ps.setBigDecimal(2, i.getNm_metragem());
            ps.setBigDecimal(3, i.getNm_valorMatricula());
            ps.setString(4, i.getDs_descricao());
            ps.setInt(5, i.getTpimovel().getCd_tpimovel());
            ps.setInt(6, i.getCidade().getCd_Cidade());
            ps.setInt(7, i.getCd_imovel());
            ps.setInt(8, i.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Imovel", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Imovel", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void excluir(Object o) {
        Imovel i = (Imovel) o;
        try{
            sql = "DELETE FROM imovel " +
                  " WHERE cd_imovel = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, i.getCd_imovel());
            ps.setInt(2, i.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Imovel", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Imovel", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public ArrayList getLista() {
         ArrayList imovel = new ArrayList();
        try{
            sql = "SELECT cd_imovel, nm_matricula, nm_metragem, nm_valor, ds_descricao, cd_tpimovel, cd_cidade, cd_usuario" +
                  "  FROM imovel " + 
                  " WHERE cd_usuario = ?" +
                  " ORDER BY nm_matricula";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Imovel i = new Imovel(
                rs.getInt("cd_imovel"),
                rs.getString("nm_matricula"),
                rs.getBigDecimal("nm_metragem"),
                rs.getBigDecimal("nm_valor"),
                rs.getString("ds_descricao"),
                (TipoImovel)tpimovelr.getById(rs.getInt("cd_tpimovel")),
                (Cidade)cidader.getById(rs.getInt("cd_cidade")),
                rs.getInt("cd_usuario"));
                imovel.add(i);
            }
            ps.close();
        }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de imoveis:\n" +
                       ex.getMessage(), "Imovel", JOptionPane.ERROR_MESSAGE);
                    }
        return imovel;
    }

    @Override
    public Object getById(int id) {
        Imovel i = null;
        try{
            sql = "SELECT cd_imovel, nm_matricula, nm_metragem, nm_valor, ds_descricao, cd_tpimovel, cd_cidade, cd_usuario" +
                  "  FROM imovel " + 
                  " WHERE cd_imovel = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                i = new Imovel(
                    rs.getInt("cd_imovel"),
                    rs.getString("nm_matricula"),
                    rs.getBigDecimal("nm_metragem"),
                    rs.getBigDecimal("nm_valor"),
                    rs.getString("ds_descricao"),
                    (TipoImovel)tpimovelr.getById(rs.getInt("cd_tpimovel")),
                    (Cidade)cidader.getById(rs.getInt("cd_cidade")),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em imovel:\n" +
                    ex.getMessage(), "Imovel", JOptionPane.ERROR_MESSAGE);
        }
        return i;
    }
}
