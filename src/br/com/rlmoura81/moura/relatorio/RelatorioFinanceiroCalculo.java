package br.com.rlmoura81.moura.relatorio;

import br.com.rlmoura81.moura.utilidade.CalculoFinanceiro;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.math.BigDecimal;
import java.util.ArrayList;

public class RelatorioFinanceiroCalculo {
            
    RelatorioFinanceiro relatoriofin = new RelatorioFinanceiro();
    RelatorioFinanceiroRepository relatoriofinr = new RelatorioFinanceiroRepository();
    
    CalculoFinanceiro cf = new CalculoFinanceiro();
    
    ArrayList lista = new ArrayList();
    
    public BigDecimal calculaValorDespesa(int grupo){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = relatoriofinr.getRelatorioDespesaGrupo(grupo);
        for(int i=0; i < lista.size(); i++){
            relatoriofin = (RelatorioFinanceiro)lista.get(i);
            resultado = resultado.add(relatoriofin.getVl_debito());
        }
        return resultado;
    }     
    
    public BigDecimal calculaValorCartao(int conta, int grupo){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = relatoriofinr.getRelatorioCartaoLancGrupo(conta, grupo);
        for(int i=0; i < lista.size(); i++){
            relatoriofin = (RelatorioFinanceiro)lista.get(i);
            resultado = resultado.add(relatoriofin.getNm_valor());
        }
        return resultado;
    }
    
    public BigDecimal calcularValorContaCaixa(int conta){        
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = relatoriofinr.getRelatorioConta(conta);
        for(int i=0; i < lista.size(); i++){
            relatoriofin = (RelatorioFinanceiro)lista.get(i);
            resultado = resultado.add(relatoriofin.getNm_valor());
        }
        return resultado;
    }

    public BigDecimal calcularValorCaixaPeriodo(int conta, String datainicial, String datafinal){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = relatoriofinr.getRelatorioContaPeriodo(conta, datainicial, datafinal);
        for(int i=0; i < lista.size(); i++){
            relatoriofin = (RelatorioFinanceiro)lista.get(i);
            resultado = resultado.add(relatoriofin.getNm_valor());
        }
        return resultado;
    }

    public BigDecimal calculaValorCaixa(int grupo){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = relatoriofinr.getRelatorioContaGrupo(grupo);
        for(int i=0; i < lista.size(); i++){
            relatoriofin = (RelatorioFinanceiro)lista.get(i);
            resultado = resultado.add(relatoriofin.getNm_valor());
        }
        return resultado;
    }

}
