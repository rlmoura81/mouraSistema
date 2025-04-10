package br.com.rlmoura81.moura.principal;

import br.com.rlmoura81.moura.principalcadastro.Cidade;
import br.com.rlmoura81.moura.principalcadastro.CidadeRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PessoaFisicaRepository {
    
    String sql = "";
    
    CidadeRepository cidader = new CidadeRepository();
    
    Utilidade util = new Utilidade();
        
    public void inserir(Object o){        
        PessoaFisica pf = (PessoaFisica) o;              
        try{
            sql = "INSERT INTO pessoafisica (cd_pessoafisica, ds_nome, dt_nascimento, nm_cpf, nm_cnh, nm_rg, cd_cidade)" +
                  "     VALUES (sq_pessoafisica.nextval, ?, ?, ?, ?, ?, ?)";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, pf.getDs_Nome());
            ps.setString(2, Utilidade.formatoData.format(pf.getDt_Nascimento().getTime()));
            ps.setString(3, pf.getNm_Cpf());
            ps.setString(4, pf.getNm_Cnh());
            ps.setString(5, pf.getNm_Rg());
            ps.setInt(6, pf.getCidade().getCd_Cidade());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Pessoa Física", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Pessoa Física", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void alterar(Object o){        
        PessoaFisica pf = (PessoaFisica) o;               
        try{
            sql = "UPDATE pessoafisica " +
                  "   SET ds_nome = ?," +
                  "       dt_nascimento = ?, " +
                  "       nm_cpf = ?, " +
                  "       nm_cnh = ?, " +
                  "       nm_rg = ?, " +
                  "       cd_cidade = ? " +
                  " WHERE cd_pessoafisica = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, pf.getDs_Nome());
            ps.setString(2, Utilidade.formatoData.format(pf.getDt_Nascimento().getTime()));
            ps.setString(3, pf.getNm_Cpf());
            ps.setString(4, pf.getNm_Cnh());
            ps.setString(5, pf.getNm_Rg());
            ps.setInt(6, pf.getCidade().getCd_Cidade());
            ps.setInt(7, pf.getCd_Pessoa());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado.", "Pessoa Física", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Pessoa Física", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void excluir(Object o){        
        PessoaFisica pf = (PessoaFisica) o;        
        try{
            sql = "DELETE FROM pessoafisica " +
                  " WHERE cd_pessoafisica = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, pf.getCd_Pessoa());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido", "Pessia Física", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Pessoa Física", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ArrayList getListaPessoaFisica(){        
        ArrayList pessoasfisicas = new ArrayList();          
        try{
            sql = "SELECT cd_pessoafisica, ds_nome, to_char(dt_nascimento,'dd/MM/yyyy'), nm_cpf, nm_cnh, nm_rg, cd_cidade" +
                  "  FROM pessoafisica" +
                  " ORDER BY ds_nome";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){            
                PessoaFisica pf = new PessoaFisica(
                        rs.getInt("cd_pessoafisica"),
                        rs.getString("ds_nome"),
                        util.recebeData(rs.getString("to_char(dt_nascimento,'dd/MM/yyyy')")),
                        rs.getString("nm_cpf"),
                        rs.getString("nm_cnh"),
                        rs.getString("nm_rg"),
                        (Cidade)cidader.getById(rs.getInt("cd_cidade")));
                pessoasfisicas.add(pf);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de pessoas:\n" +
                    ex.getMessage(), "Pessoa Física", JOptionPane.ERROR_MESSAGE);
        }
        return pessoasfisicas;
    }
    
    public Object getById(int id){
        PessoaFisica pf = null;
        try{
            sql = "SELECT cd_pessoafisica, ds_nome, to_char(dt_nascimento,'dd/MM/yyyy'), nm_cpf, nm_rg, nm_cnh, cd_cidade" +
                  "  FROM pessoafisica" +
                  " WHERE cd_pessoafisica = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                pf = new PessoaFisica(
                    rs.getInt("cd_pessoafisica"),
                    rs.getString("ds_nome"),
                    util.recebeData(rs.getString("to_char(dt_nascimento,'dd/MM/yyyy')")),
                    rs.getString("nm_cpf"),
                    rs.getString("nm_rg"),
                    rs.getString("nm_cnh"),
                    (Cidade)cidader.getById(rs.getInt("cd_cidade")));
            }    
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em pessoa fisica:\n" + 
                    ex.getMessage(), "Pessoa Física", JOptionPane.ERROR_MESSAGE);
        }
        return pf;
    }
}
