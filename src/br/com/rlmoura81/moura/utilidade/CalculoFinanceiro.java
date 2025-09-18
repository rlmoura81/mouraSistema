package br.com.rlmoura81.moura.utilidade;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculoFinanceiro {
    
    /**
     * <p><strong>EN:</strong> Calculates the total credit from dividends by multiplying quantity and amount.</p>
     * <p><strong>IT:</strong> Calcola il credito totale dei proventi moltiplicando quantità e importo.</p>
     * <p><strong>PT-BR:</strong> Calcula o crédito total de proventos multiplicando a quantidade pelo valor.</p>
     */
    public BigDecimal proventoCredito (Integer qtde, BigDecimal provento){
        BigDecimal num = new BigDecimal(qtde);
        BigDecimal resultado = num.multiply(provento);
        return resultado;
    } 
    
    /**
     * <p><strong>EN:</strong> Updates account balance based on transaction type (1 = credit, 2 = debit).</p>
     * <p><strong>IT:</strong> Aggiorna il saldo del conto in base al tipo di transazione (1 = credito, 2 = debito).</p>
     * <p><strong>PT-BR:</strong> Atualiza o saldo da conta conforme o tipo de transação (1 = crédito, 2 = débito).</p>
     */
    public BigDecimal saldoConta(int gptrans, BigDecimal saldo, BigDecimal valor){
        if(gptrans == 1){
            saldo = saldo.add(valor);
        }
        if(gptrans == 2){
            saldo = saldo.subtract(valor);
        }
        return saldo;
    }
    
    /**
     * <p><strong>EN:</strong> Updates account balance by replacing a previous transaction value with a new one.</p>
     * <p><strong>IT:</strong> Aggiorna il saldo del conto sostituendo il valore precedente della transazione con uno nuovo.</p>
     * <p><strong>PT-BR:</strong> Atualiza o saldo da conta substituindo um valor anterior por um novo.</p>
     */
    public BigDecimal saldoContaAtualizar(int gptrans, BigDecimal saldo, BigDecimal valor, BigDecimal valorAtual){
        if(gptrans == 1){
            saldo = (saldo.add(valor)).subtract(valorAtual);
        }
        if(gptrans == 2){
            saldo = (saldo.subtract(valor)).add(valorAtual);
        }
        return saldo;
    }
        
    /**
     * <p><strong>EN:</strong> Applies interest/earnings to the balance based on an index percentage.</p>
     * <p><strong>IT:</strong> Applica gli interessi/rendimenti al saldo in base a un indice percentuale.</p>
     * <p><strong>PT-BR:</strong> Aplica rendimento ao saldo com base em um índice percentual.</p>
     */
    public BigDecimal aplicaRendimento(BigDecimal saldo, BigDecimal indice){
        BigDecimal resultado = Utilidade.converter("0,00");
        resultado = ((saldo.multiply(indice)).divide(Utilidade.converter("100,00"))).add(saldo);
        return resultado;
    }
    
    /**
     * <p><strong>EN:</strong> Updates investment balance depending on transaction type (3 = deposit, 4 = withdrawal).</p>
     * <p><strong>IT:</strong> Aggiorna il saldo dell'investimento in base al tipo di transazione (3 = deposito, 4 = prelievo).</p>
     * <p><strong>PT-BR:</strong> Atualiza o saldo da aplicação conforme o tipo de transação (3 = depósito, 4 = saque).</p>
     */
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
    
    /**
     * <p><strong>EN:</strong> Calculates the percentage of a value relative to the total.</p>
     * <p><strong>IT:</strong> Calcola la percentuale di un valore rispetto al totale.</p>
     * <p><strong>PT-BR:</strong> Calcula a porcentagem de um valor em relação ao total.</p>
     */
    public BigDecimal calculaPorcentagem(BigDecimal total, BigDecimal valor){
        BigDecimal porcentagem = Utilidade.converter("0,00");
        porcentagem = (valor.divide(total, 5, RoundingMode.HALF_EVEN)).multiply(Utilidade.converter("100,00"));       
        return porcentagem;
    }
    
    /**
     * <p><strong>EN:</strong> Calculates the percentage variation between two values.</p>
     * <p><strong>IT:</strong> Calcola la variazione percentuale tra due valori.</p>
     * <p><strong>PT-BR:</strong> Calcula a variação percentual entre dois valores.</p>
     */
    public BigDecimal calculaPorcentageValores(BigDecimal valor1, BigDecimal valor2){
        BigDecimal porcentagem = Utilidade.converter("0,00");
        porcentagem = ((valor1.subtract(valor2)).divide(valor2, 5, RoundingMode.HALF_EVEN)).multiply(Utilidade.converter("100,00"));
        return porcentagem;
    }    
    
    /**
     * <p><strong>EN:</strong> Calculates the total value by multiplying unit price by quantity.</p>
     * <p><strong>IT:</strong> Calcola il valore totale moltiplicando il prezzo unitario per la quantità.</p>
     * <p><strong>PT-BR:</strong> Calcula o valor total multiplicando o preço unitário pela quantidade.</p>
     */
    public BigDecimal calculoValorQtde(BigDecimal valor, int qtde){
        BigDecimal resultado = null;
        resultado =  valor.multiply(BigDecimal.valueOf(qtde));
        return resultado;
    }
}
