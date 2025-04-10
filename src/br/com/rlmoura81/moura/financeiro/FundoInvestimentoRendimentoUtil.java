package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FundoInvestimentoRendimentoUtil {
    
    FundoInvestimentoRendimento fir = new FundoInvestimentoRendimento();
    FundoInvestimentoRendimentoRepository firr = new FundoInvestimentoRendimentoRepository();
        
    ArrayList lista = new ArrayList();
    Utilidade util = new Utilidade();
    
    public void tabelaFundoInvestimentoRendimento(JTable o, int num){
        String[] nomeColuna = {"Data", "Rendimento"};
        lista = firr.getListaRendimento(num);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        
        for(int i=0; i < lista.size(); i++){
            fir = (FundoInvestimentoRendimento)lista.get(i);
            dadosArray[i][0] = Utilidade.formatoData.format(fir.getDt_rendimento().getTime());
            dadosArray[i][1] = Utilidade.formatoValor.format(fir.getVl_rendimento());
        }
        DefaultTableModel tFdInvestRend = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tFdInvestRend);
    }
        
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um rendimento da lista.");
        }
        return selecionado;    
    }
}
