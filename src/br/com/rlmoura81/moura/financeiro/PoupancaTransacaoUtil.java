package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PoupancaTransacaoUtil {
    
    PoupancaTransacao pouptr = new PoupancaTransacao();
    PoupancaTransacaoRepository pouptrr = new PoupancaTransacaoRepository();
    
    ArrayList lista = new ArrayList();
    
    public BigDecimal atualizaSaldo (int num, BigDecimal vl_saldo, BigDecimal vl_transacao){
        BigDecimal resultado = null;
        if(num == 0){
            resultado = (vl_saldo.add(vl_transacao));
        }
        if(num == 1){
            resultado = (vl_saldo.subtract(vl_transacao));
        }
        return resultado;
    }
    
    public void tabelaPoupancaTransacao(JTable o, int poupanca){
        String[] nomeColuna = {"Valor Transação", "Data Transação", "Transação"};
        lista = pouptrr.getLista();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        
        for(int i=0; i < lista.size(); i++){
            pouptr = (PoupancaTransacao)lista.get(i);
            dadosArray[i][0] = Utilidade.formatoValor.format(pouptr.getVl_transacao());
            dadosArray[i][1] = Utilidade.formatoData.format(pouptr.getDt_transacao().getTime());
            dadosArray[i][2] = pouptr.getGptrans();
        }
        DefaultTableModel tPoupap = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tPoupap);
    }

    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma aplicação da lista.");
        }
        return selecionado;    
    }
}
