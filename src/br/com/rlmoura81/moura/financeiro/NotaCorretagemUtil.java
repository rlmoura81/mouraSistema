package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class NotaCorretagemUtil {
    
    NotaCorretagem nota = new NotaCorretagem();
    NotaCorretagemRepository notar = new NotaCorretagemRepository();
    
    ArrayList lista = new ArrayList();
    
    public void tabelaNotaCorretagem(JTable o, int cd_conta){
        String[] nomeColuna = {"Numero Nota", "Data"};
        lista = notar.getLista(cd_conta);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        
        for(int i=0; i < lista.size(); i++){
            nota = (NotaCorretagem)lista.get(i);
            dadosArray[i][0] = nota.getNm_nota();
            dadosArray[i][1] = Utilidade.formatoData.format(nota.getDt_nota().getTime());
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
