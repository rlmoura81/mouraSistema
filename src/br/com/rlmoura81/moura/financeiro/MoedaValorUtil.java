package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MoedaValorUtil {
    
    MoedaValor moedavalor = new MoedaValor();
    MoedaValorRepository moedavalorr = new MoedaValorRepository();
    
    ArrayList lista = new ArrayList();

    public void tabelaIndiceValor(JTable o){
        String[] nomeColuna = {"Moeda", "Valor", "Data"};
        lista = moedavalorr.getLista();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        
        for(int i = 0; i < lista.size(); i++){
            moedavalor = (MoedaValor) lista.get(i);
            dadosArray[i][0] = moedavalor.getMoeda();
            dadosArray[i][1] = Utilidade.formatoValorTres.format(moedavalor.getVl_moeda());
            dadosArray[i][2] = Utilidade.formatoData.format(moedavalor.getDt_valor().getTime());
        }
        DefaultTableModel tIndiceValor = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tIndiceValor);
    }

    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um valor da lista.");
        }
        return selecionado;
    }     
}
