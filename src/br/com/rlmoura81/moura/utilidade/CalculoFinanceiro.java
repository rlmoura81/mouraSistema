package br.com.rlmoura81.moura.utilidade;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculoFinanceiro {
    
    public BigDecimal proventoCredito (Integer qtde, BigDecimal provento){
        BigDecimal num = new BigDecimal(qtde);
        BigDecimal resultado = num.multiply(provento);
        return resultado;
    } 
    
    public BigDecimal saldoConta(int gptrans, BigDecimal saldo, BigDecimal valor){
        if(gptrans == 1){
            saldo = saldo.add(valor);
        }
        if(gptrans == 2){
            saldo = saldo.subtract(valor);
        }
        return saldo;
    }
    
    public BigDecimal saldoContaAtualizar(int gptrans, BigDecimal saldo, BigDecimal valor, BigDecimal valorAtual){
        if(gptrans == 1){
            saldo = (saldo.add(valor)).subtract(valorAtual);
        }
        if(gptrans == 2){
            saldo = (saldo.subtract(valor)).add(valorAtual);
        }
        return saldo;
    }
        
    public BigDecimal aplicaRendimento(BigDecimal saldo, BigDecimal indice){
        BigDecimal resultado = Utilidade.converter("0,00");
        resultado = ((saldo.multiply(indice)).divide(Utilidade.converter("100,00"))).add(saldo);
        return resultado;
    }
    
    //ATUALIZA SALDO APLICACAO;
    public BigDecimal atualizaSaldoAplicacao(int gptrans, BigDecimal saldo, BigDecimal transacao){
        BigDecimal resultado = null;
        if(gptrans == 3){
            resultado = (saldo.add(transacao));
        }
        if(gptrans == 4){
            resultado = (saldo.subtract(transacao));
        }
        return resultado;
    }
    
    public BigDecimal calculaPorcentagem(BigDecimal total, BigDecimal valor){
        BigDecimal porcentagem = Utilidade.converter("0,00");
        porcentagem = (valor.divide(total, 5, RoundingMode.HALF_EVEN)).multiply(Utilidade.converter("100,00"));       
        return porcentagem;
    }
    
    public BigDecimal calculaPorcentageValores(BigDecimal valor1, BigDecimal valor2){
        BigDecimal porcentagem = Utilidade.converter("0,00");
        porcentagem = ((valor1.subtract(valor2)).divide(valor2, 5, RoundingMode.HALF_EVEN)).multiply(Utilidade.converter("100,00"));
        return porcentagem;
    }    
    
    public BigDecimal calculoValorQtde(BigDecimal valor, int qtde){
        BigDecimal resultado = null;
        resultado =  valor.multiply(BigDecimal.valueOf(qtde));
        return resultado;
    }
}
