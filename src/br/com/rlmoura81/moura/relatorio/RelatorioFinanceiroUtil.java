package br.com.rlmoura81.moura.relatorio;

import br.com.rlmoura81.moura.cartao.CartaoLancamentoFechamentoUtil;
import br.com.rlmoura81.moura.cartao.CartaoLancamentoUtil;
import br.com.rlmoura81.moura.utilidade.CalculoFinanceiro;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RelatorioFinanceiroUtil {
    
    
    CartaoLancamentoUtil cartaolancu = new CartaoLancamentoUtil();
    
    CartaoLancamentoFechamentoUtil cartaolancfu = new CartaoLancamentoFechamentoUtil();
            
    RelatorioFinanceiro relatoriofin = new RelatorioFinanceiro();
    RelatorioFinanceiroRepository relatoriofinr = new RelatorioFinanceiroRepository();
    RelatorioFinanceiroCalculo relatoriofinc = new RelatorioFinanceiroCalculo();
    
    ArrayList lista = new ArrayList();
    Utilidade util = new Utilidade();
    CalculoFinanceiro cf = new CalculoFinanceiro();

    public void tabelaRelatorioContasSaldo(JTable o, int tpconta) {
        String[] nomeColuna = {"Conta", "Saldo", "Crédito", "Débito"};
        lista = relatoriofinr.getRelatorioContasSaldo(tpconta);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];

        for (int i=0; i < lista.size(); i++) {
            relatoriofin = (RelatorioFinanceiro)lista.get(i);
            dadosArray[i][0] = relatoriofin.getConta();
            dadosArray[i][1] = Utilidade.formatoValor.format(relatoriofin.getContasaldo().getVl_saldo());
            dadosArray[i][2] = Utilidade.formatoValor.format(relatoriofin.getVl_credito());
            dadosArray[i][3] = Utilidade.formatoValor.format(relatoriofin.getVl_debito());
        }
        DefaultTableModel tRelatorio = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tRelatorio); 
    } 
    
    public void tabelaRelatorioDespesa(JTable o, int grupo) {
        String[] nomeColuna = {"Descrição", "Valor", "Debito", "%Consumo", "%"};
        lista = relatoriofinr.getRelatorioDespesaGrupo(grupo);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];

        for (int i=0; i < lista.size(); i++) {
            relatoriofin = (RelatorioFinanceiro)lista.get(i);
            dadosArray[i][0] = relatoriofin.getDespesa();
            dadosArray[i][1] = Utilidade.formatoValor.format(relatoriofin.getNm_valor());
            dadosArray[i][2] = Utilidade.formatoValor.format(relatoriofin.getVl_debito());
            dadosArray[i][3] = Utilidade.formatoValor.format(cf.calculaPorcentagem(relatoriofinc.calculaValorDespesa(grupo), relatoriofin.getVl_debito()));
            dadosArray[i][4] = Utilidade.formatoValor.format(cf.calculaPorcentageValores(relatoriofin.getVl_debito(), relatoriofin.getNm_valor()));
        }
        DefaultTableModel tRelatorio = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tRelatorio);
    }  
    
    public void tabelaRelatorioCartaoLanc(JTable o, int cartao, int grupo) {
        if(grupo == 0){
            lista = relatoriofinr.getRelatorioCartaoLanc(cartao);            
        }else{
            lista = relatoriofinr.getRelatorioCartaoLancGrupo(cartao, grupo);
        }
        String[] nomeColuna = {"Categoria", "Valor", "%"};
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];

        for (int i=0; i < lista.size(); i++) {
            relatoriofin = (RelatorioFinanceiro)lista.get(i);
            dadosArray[i][0] = relatoriofin.getCategoria();
            dadosArray[i][1] = Utilidade.formatoValor.format(relatoriofin.getNm_valor());
            if(grupo == 0){
                dadosArray[i][2] = Utilidade.formatoValor.format(cf.calculaPorcentagem(cartaolancu.calculaValorFatura(cartao), relatoriofin.getNm_valor()));                
            }else{
                dadosArray[i][2] = Utilidade.formatoValor.format(cf.calculaPorcentagem(relatoriofinc.calculaValorCartao(cartao, grupo), relatoriofin.getNm_valor()));
            }
        }
        DefaultTableModel tRelatorio = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tRelatorio);
    }  
    
    public void tabelaRelatorioCartaoFechamento(JTable o, int cartao, String data) {
        String[] nomeColuna = {"Categoria", "Valor", "%"};
        lista = relatoriofinr.getRelatorioCartaoFechamento(cartao, data);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];

        for (int i=0; i < lista.size(); i++) {
            relatoriofin = (RelatorioFinanceiro)lista.get(i);
            dadosArray[i][0] = relatoriofin.getCategoria();
            dadosArray[i][1] = Utilidade.formatoValor.format(relatoriofin.getNm_valor());
            dadosArray[i][2] = Utilidade.formatoValor.format(cf.calculaPorcentagem(cartaolancfu.calculaValorFatura(util.recebeData(data), cartao), relatoriofin.getNm_valor()));
        }
        DefaultTableModel tRelatorio = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tRelatorio);
    }
    
    public void tabelaRelatorioConta(JTable o, int conta, int grupo) {
        if(grupo == 0){
            lista = relatoriofinr.getRelatorioConta(conta);
        }else{
            lista = relatoriofinr.getRelatorioContaGrupo(grupo);
        }
        String[] nomeColuna = {"Categoria", "Valor", "%"};
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];

        for (int i=0; i < lista.size(); i++) {
            relatoriofin = (RelatorioFinanceiro)lista.get(i);
            dadosArray[i][0] = relatoriofin.getCategoria();
            dadosArray[i][1] = Utilidade.formatoValor.format(relatoriofin.getNm_valor());
            if(grupo == 0){
                dadosArray[i][2] = Utilidade.formatoValor.format(cf.calculaPorcentagem(relatoriofinc.calcularValorContaCaixa(conta), relatoriofin.getNm_valor()));                
            }else{
                dadosArray[i][2] = Utilidade.formatoValor.format(cf.calculaPorcentagem(relatoriofinc.calculaValorCaixa(grupo), relatoriofin.getNm_valor()));
            }
        }
        DefaultTableModel tRelatorio = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tRelatorio);
    }    
    
    public void tabelaRelatorioContaPeriodo(JTable o, int conta, String datainicial, String datafinal) {
        String[] nomeColuna = {"Categoria", "Valor", "%"};
        lista = relatoriofinr.getRelatorioContaPeriodo(conta, datainicial, datafinal);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];

        for (int i=0; i < lista.size(); i++) {
            relatoriofin = (RelatorioFinanceiro)lista.get(i);
            dadosArray[i][0] = relatoriofin.getCategoria();
            dadosArray[i][1] = Utilidade.formatoValor.format(relatoriofin.getNm_valor());
            dadosArray[i][2] = Utilidade.formatoValor.format(cf.calculaPorcentagem(relatoriofinc.calcularValorCaixaPeriodo(conta, datainicial, datafinal), relatoriofin.getNm_valor()));
        }
        DefaultTableModel tRelatorio = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tRelatorio);
    }
    
}
