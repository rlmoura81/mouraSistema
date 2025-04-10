package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principal.IPadraoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class NotaCorretagemLancamentoRepository implements IPadraoRepository{

    String sql = "";
    
    NotaCorretagemRepository notar = new NotaCorretagemRepository();
    
    AtivoRepository ativor = new AtivoRepository();
    
    GrupoTransacaoRepository gptransr = new GrupoTransacaoRepository();
        
    @Override
    public void inserir(Object o) {
        NotaCorretagemLancamento notalanc = (NotaCorretagemLancamento) o;
        try{
            sql = "INSERT INTO notalanc (cd_nota, cd_ativo, nm_qtde, nm_valor, cd_gptrans, cd_usuario)" +
                  "     VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, notalanc.getNota().getCd_nota());
            ps.setInt(2, notalanc.getAtivo().getCd_ativo());
            ps.setInt(3, notalanc.getNm_qtde());
            ps.setBigDecimal(4, notalanc.getNm_valor());
            ps.setInt(5, notalanc.getGptrans().getCd_gptrans());
            ps.setInt(6, notalanc.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Nota Corretagem Lançamento", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Nota Corretagem Lançamento", JOptionPane.ERROR_MESSAGE);
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
        ArrayList notalanc = new ArrayList();
        try{
            sql = "SELECT cd_nota, cd_ativo, nm_qtde, nm_valor, cd_gptrans, cd_usuario" +
                  "  FROM notalanc" + 
                  " WHERE cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                NotaCorretagemLancamento ncl = new NotaCorretagemLancamento(
                        (NotaCorretagem)notar.getById(rs.getInt("cd_nota")),
                        (Ativo)ativor.getById(rs.getInt("cd_ativo")),
                        rs.getInt("nm_qtde"),
                        rs.getBigDecimal("nm_valor"),
                        (GrupoTransacao)gptransr.getById(rs.getInt("cd_gptrans")),
                        rs.getInt("cd_usuario"));
                notalanc.add(ncl);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Notas de Corretagem Lançadas:\n" +
                    ex.getMessage(), "Nota Corretagem Lançamento", JOptionPane.ERROR_MESSAGE);
        }
        return notalanc;
    }
    
    public ArrayList getLista(int cd_nota) {
        ArrayList notalanc = new ArrayList();
        try{
            sql = "SELECT cd_nota, cd_ativo, nm_qtde, nm_valor, cd_gptrans, cd_usuario" +
                  "  FROM notalanc" + 
                  " WHERE cd_nota = ?" +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_nota);
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                NotaCorretagemLancamento ncl = new NotaCorretagemLancamento(
                        (NotaCorretagem)notar.getById(rs.getInt("cd_nota")),
                        (Ativo)ativor.getById(rs.getInt("cd_ativo")),
                        rs.getInt("nm_qtde"),
                        rs.getBigDecimal("nm_valor"),
                        (GrupoTransacao)gptransr.getById(rs.getInt("cd_gptrans")),
                        rs.getInt("cd_usuario"));
                notalanc.add(ncl);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Notas de Corretagem Lançadas:\n" +
                    ex.getMessage(), "Nota Corretagem Lançamento", JOptionPane.ERROR_MESSAGE);
        }
        return notalanc;
    }    

    @Override
    public Object getById(int id) {
        NotaCorretagemLancamento notalanc = null;
        try{
            sql = "SELECT cd_nota, cd_ativo, nm_qtde, nm_valor, cd_gptrans, cd_usuario" +
                  "  FROM notalanc" + 
                  " WHERE cd_nota = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                notalanc = new NotaCorretagemLancamento(
                        (NotaCorretagem)notar.getById(rs.getInt("cd_nota")),
                        (Ativo)ativor.getById(rs.getInt("cd_ativo")),
                        rs.getInt("nm_qtde"),
                        rs.getBigDecimal("nm_valor"),
                        (GrupoTransacao)gptransr.getById(rs.getInt("cd_gptrans")),
                        rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em Notas de Corretagem Lançadas:\n" +
                    ex.getMessage(), "Nota Corretagem Lançamento", JOptionPane.ERROR_MESSAGE);
        }
        return notalanc;
    }
    
}
