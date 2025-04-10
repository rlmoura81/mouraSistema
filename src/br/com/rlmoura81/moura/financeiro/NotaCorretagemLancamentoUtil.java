package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class NotaCorretagemLancamentoUtil {
    
    NotaCorretagemLancamento notalanc = new NotaCorretagemLancamento();
    NotaCorretagemLancamentoRepository notalancr = new NotaCorretagemLancamentoRepository();
        
    ArrayList lista = new ArrayList();

    public void tabelaNotaCorretagemLancamento(JTable o, int cd_nota){
        String[] nomeColuna = {"Numero Nota", "Ativo", "Qtde", "Valor", "Transação"};
        lista = notalancr.getLista(cd_nota);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        
        for(int i=0; i < lista.size(); i++){
            notalanc = (NotaCorretagemLancamento)lista.get(i);
            dadosArray[i][0] = notalanc.getNota().getNm_nota();
            dadosArray[i][1] = notalanc.getAtivo();
            dadosArray[i][2] = notalanc.getNm_qtde();
            dadosArray[i][3] = Utilidade.formatoValor.format(notalanc.getNm_valor());
            dadosArray[i][4] = notalanc.getGptrans();
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
            JOptionPane.showMessageDialog(null, "Selecione um item da lista.");
        }
        return selecionado;    
    }
    
}
