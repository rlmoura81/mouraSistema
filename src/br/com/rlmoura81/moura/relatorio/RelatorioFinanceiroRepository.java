package br.com.rlmoura81.moura.relatorio;

import br.com.rlmoura81.moura.financeiro.Conta;
import br.com.rlmoura81.moura.financeiro.ContaRepository;
import br.com.rlmoura81.moura.financeiro.ContaSaldo;
import br.com.rlmoura81.moura.financeiro.ContaSaldoRepository;
import br.com.rlmoura81.moura.financeiro.Despesa;
import br.com.rlmoura81.moura.financeiro.DespesaRepository;
import br.com.rlmoura81.moura.principalcadastro.Categoria;
import br.com.rlmoura81.moura.principalcadastro.CategoriaRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class RelatorioFinanceiroRepository {
    
    String sql = "";
    
    CategoriaRepository categoriar = new CategoriaRepository();  
    DespesaRepository despesar = new DespesaRepository();
    
    ContaRepository contar = new ContaRepository();
    ContaSaldoRepository contasaldor = new ContaSaldoRepository();

        public ArrayList getRelatorioContasSaldo(int tpconta){
        ArrayList relatorio = new ArrayList();
        try{
            sql = "SELECT  conta.cd_conta, sum(nvl(vl_credito,'0,00')), sum(nvl(vl_debito,'0,00'))" +
                  "       FROM conta, contasaldo, tipoconta, movcx" +
                  "       WHERE conta.cd_conta = contasaldo.cd_conta" +
                  "         AND conta.cd_conta = tipoconta.cd_tpconta" +
                  "         AND conta.cd_tpconta = ?" +
                  "         AND conta.cd_conta = movcx.cd_conta" +
                  "         AND dt_transacao BETWEEN (SELECT trunc(SYSDATE,'MM') FROM DUAL) AND (SELECT trunc(LAST_DAY(SYSDATE)) FROM DUAL)" +
                  "         AND conta.cd_usuario = ?" +
                  "       GROUP BY conta.cd_conta, contasaldo.cd_conta";
            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, tpconta);
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                RelatorioFinanceiro r = new RelatorioFinanceiro(
                        (Conta)contar.getById(rs.getInt("cd_conta")),
                        (ContaSaldo)contasaldor.getById(rs.getInt("cd_conta")), 
                        rs.getBigDecimal("sum(nvl(vl_credito,'0,00'))"), 
                        rs.getBigDecimal("sum(nvl(vl_debito,'0,00'))"));
                relatorio.add(r);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro no relatorio de contas - saldo atual / credito e debito:\n" +
                    "ID: RELFIN000001\n" +
                    ex.getMessage());
        }
        return relatorio;
    } 
        
    public ArrayList getRelatorioDespesaGrupo(int grupo){
        ArrayList relatorio = new ArrayList();
        try{
            sql = "SELECT movcx.cd_despesa, vl_debito, nm_valor" +
                  "       FROM movcx, grupo, categoria, despesa" +
                  "       WHERE categoria.cd_grupo = grupo.cd_grupo" +
                  "         AND categoria.cd_grupo = ?" +
                  "         AND despesa.cd_categoria = categoria.cd_categoria" +
                  "         AND movcx.cd_despesa = despesa.cd_despesa" +   
                  "         AND movcx.cd_categoria = categoria.cd_categoria" +
                  "         AND dt_transacao BETWEEN (SELECT trunc(SYSDATE,'MM') FROM DUAL) AND (SELECT trunc(LAST_DAY(SYSDATE)) FROM DUAL)\n" +
                  "         AND movcx.cd_usuario = ?";
            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, grupo);
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                RelatorioFinanceiro r = new RelatorioFinanceiro(
                        rs.getBigDecimal("vl_debito"),
                        rs.getBigDecimal("nm_valor"),
                        (Despesa)despesar.getById(rs.getInt("cd_despesa")));
                relatorio.add(r);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro no relatorio de despesa no caixa:\n" +
                    "ID: RELFIN000002\n" +
                    ex.getMessage());
        }
        return relatorio;
    }
        
    public ArrayList getRelatorioCartaoLanc(int cartao){
        ArrayList relatorio = new ArrayList();
        try{
            sql = "SELECT categoria.cd_categoria, SUM(nm_valor)" +
                  "       FROM cartaolanc, categoria" +
                  "       WHERE cd_cartao = ?" +
                  "         AND cartaolanc.cd_categoria = categoria.cd_categoria" +
                  "         AND cartaolanc.cd_usuario = ?" +
                  "       GROUP BY categoria.cd_categoria, ds_categoria" +
                  "       ORDER BY ds_categoria";
            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cartao);
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                RelatorioFinanceiro r = new RelatorioFinanceiro(
                        (Categoria)categoriar.getById(rs.getInt("cd_categoria")), 
                        rs.getBigDecimal("SUM(nm_valor)"));
                relatorio.add(r);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro no relatorio de cartão:\n" +
                    "ID: RELFIN000003\n" +
                    ex.getMessage());
        }
        return relatorio;
    }    
    
    public ArrayList getRelatorioCartaoLancGrupo(int cartao, int grupo){
        ArrayList relatorio = new ArrayList();
        try{
            sql = "SELECT categoria.cd_categoria, sum(nm_valor)" +
                  "       FROM cartaolanc, cartao, grupo, categoria" +
                  "       WHERE cartao.cd_cartao = ?" +
                  "         AND cartao.cd_cartao = cartaolanc.cd_cartao" + 
                  "         AND categoria.cd_grupo = grupo.cd_grupo" +
                  "         AND grupo.cd_grupo = ?" +
                  "         AND categoria.cd_categoria = cartaolanc.cd_categoria" +
                  "         AND categoria.cd_usuario = ?" +
                  "       GROUP BY categoria.cd_categoria";
            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cartao);
            ps.setInt(2, grupo);
            ps.setInt(3, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                RelatorioFinanceiro r = new RelatorioFinanceiro(
                        (Categoria)categoriar.getById(rs.getInt("cd_categoria")), 
                        rs.getBigDecimal("sum(nm_valor)"));
                relatorio.add(r);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro no relatorio de Categoria-Grupo-Cartao:\n" +
                    "ID: RELFIN000004\n" +
                    ex.getMessage());
        }
        return relatorio;
    }

    public ArrayList getRelatorioCartaoFechamento(int cartao, String datafechamento){
        ArrayList relatorio = new ArrayList();
        try{
            sql = "SELECT categoria.cd_categoria, SUM(nm_valor)" +
                  "       FROM cartaolancf, categoria" +
                  "       WHERE cd_cartao = ?" +
                  "         AND dt_fechamento = ?" +
                  "         AND cartaolancf.cd_categoria = categoria.cd_categoria" +
                  "         AND cartaolancf.cd_usuario = ?" +
                  "       GROUP BY categoria.cd_categoria, ds_categoria" +
                  "       ORDER BY ds_categoria";
            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cartao);
            ps.setString(2, datafechamento);
            ps.setInt(3, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                RelatorioFinanceiro r = new RelatorioFinanceiro(
                        (Categoria)categoriar.getById(rs.getInt("cd_categoria")), 
                        rs.getBigDecimal("SUM(nm_valor)"));
                relatorio.add(r);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro no relatorio de cartão fechamento:\n" +
                    "ID: RELFIN000004-FECHAMENTO\n" +                    
                    ex.getMessage());
        }
        return relatorio;
    }
    
    public ArrayList getRelatorioConta(int conta){
        ArrayList relatorio = new ArrayList();
        try{
            sql = "SELECT categoria.cd_categoria, sum(vl_debito)" +
                  "       FROM movcx, categoria" +
                  "       WHERE cd_conta = ?" +
                  "         AND dt_transacao BETWEEN (SELECT trunc(SYSDATE,'MM') FROM DUAL) AND (SELECT trunc(LAST_DAY(SYSDATE)) FROM DUAL)" +
                  "         AND movcx.cd_categoria = categoria.cd_categoria" +  
                  "         AND movcx.cd_usuario = ?" +
                  "       GROUP BY categoria.cd_categoria, ds_categoria" +
                  "       ORDER BY ds_categoria";
            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, conta);
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                RelatorioFinanceiro r = new RelatorioFinanceiro(
                        (Categoria)categoriar.getById(rs.getInt("cd_categoria")), 
                        rs.getBigDecimal("sum(vl_debito)"));
                relatorio.add(r);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro no relatorio de movimento caixa:\n" +
                    "ID RELFIN000005\n" +
                    ex.getMessage());
        }
        return relatorio;
    }

    public ArrayList getRelatorioContaPeriodo(int conta, String datainicial, String datafinal){
        ArrayList relatorio = new ArrayList();
        try{
            sql = "SELECT categoria.cd_categoria, sum(nvl(vl_credito,'0,00')), sum(nvl(vl_debito,'0,00'))" +
                  "       FROM movcx, categoria" +
                  "       WHERE cd_conta = ?" +
                  "         AND dt_transacao BETWEEN ? AND ?" +
                  "         AND movcx.cd_categoria = categoria.cd_categoria" +  
                  "         AND movcx.cd_usuario = ?" +
                  "       GROUP BY categoria.cd_categoria, ds_categoria" +
                  "       ORDER BY ds_categoria";
            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, conta);
            ps.setString(2, datainicial);
            ps.setString(3, datafinal);
            ps.setInt(4, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                RelatorioFinanceiro r = new RelatorioFinanceiro(
                        (Categoria)categoriar.getById(rs.getInt("cd_categoria")), 
                        rs.getBigDecimal("SUM(nvl(vl_debito,'0,00'))"));
                relatorio.add(r);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro no relatorio de movimento caixa por periodo:\n" + 
                    "ID RELFIN000005-PERIODO\n" +
                    ex.getMessage());
        }
        return relatorio;
    }       
        
    public ArrayList getRelatorioContaGrupo(int grupo){
        ArrayList relatorio = new ArrayList();
        try{
            sql = "SELECT categoria.cd_categoria, sum(vl_debito)" +
                  "       FROM movcx, grupo, categoria" +
                  "       WHERE categoria.cd_grupo = grupo.cd_grupo" +
                  "         AND grupo.cd_grupo = ?" +
                  "         AND categoria.cd_categoria = movcx.cd_categoria" +
                  "         AND categoria.cd_usuario = ?" +
                  "         AND dt_transacao BETWEEN (SELECT trunc(SYSDATE,'MM') FROM DUAL) AND (SELECT trunc(LAST_DAY(SYSDATE)) FROM DUAL)" +  
                  "       GROUP BY categoria.cd_categoria";
            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, grupo);
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                RelatorioFinanceiro r = new RelatorioFinanceiro(
                        (Categoria)categoriar.getById(rs.getInt("cd_categoria")), 
                        rs.getBigDecimal("sum(vl_debito)"));
                relatorio.add(r);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro no relatorio de Categoria-Grupo-Caixa:\n" + 
                    "ID: RELFIN000006\n" +
                    ex.getMessage());
        }
        return relatorio;
    }               
}