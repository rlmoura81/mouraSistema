package br.com.rlmoura81.moura.relatorio;

import br.com.rlmoura81.moura.principalcadastro.Grupo;
import br.com.rlmoura81.moura.principalcadastro.GrupoRepository;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;

public class ResumoUtil {
    
    String texto = "";
    ArrayList lista;
    Calendar data = Calendar.getInstance();
    
    RelatorioFinanceiroCalculo relatoriofinc = new RelatorioFinanceiroCalculo();
    
    Grupo grupo = new Grupo();
    GrupoRepository grupor = new GrupoRepository();
    
    public String textoAreaRelatorio(){
        BigDecimal vldespb = relatoriofinc.calculaValorCaixa(2);
        BigDecimal vldespe = relatoriofinc.calculaValorCaixa(6).add(relatoriofinc.calculaValorCartao(1, 6));
        BigDecimal vlalim = relatoriofinc.calculaValorCartao(2, 1);
        BigDecimal vltotalb = vldespb.add(vldespe.add(vlalim));
        BigDecimal vlimposto = null;
        texto = ("RESUMO: " + Utilidade.formatoData.format(data.getTime()) + "\n" +
                 "Despesa Básica: " + Utilidade.formatoValor.format(vldespb) + "\n" +
                 "Despesa Extra : " + Utilidade.formatoValor.format(vldespe) + "\n" +
                 "Alimentação : " + Utilidade.formatoValor.format(vlalim) + "\n" +
                 "Total : " + Utilidade.formatoValor.format(vltotalb));
        return texto;
    }     
}
