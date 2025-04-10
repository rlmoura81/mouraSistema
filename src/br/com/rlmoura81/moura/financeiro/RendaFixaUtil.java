package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RendaFixaUtil {
    
    RendaFixa rendafixa = new RendaFixa();
    RendaFixaRepository rendafixar = new RendaFixaRepository();
    
    ArrayList lista = new ArrayList();

    public void tabelaRendaFixa(JTable o){
        String[]nomeColuna = {"Tipo", "Renda Fixa", "Valor Aplicado", "Taxa", "Data Aplicado", "Data de vencimento"};
        lista = rendafixar.getLista();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for(int i = 0; i < lista.size(); i++){
            rendafixa = (RendaFixa) lista.get(i);
            dadosArray[i][0] = rendafixa.getTipoativo();
            dadosArray[i][1] = rendafixa.getDs_rendafixa();
            dadosArray[i][2] = Utilidade.formatoValor.format(rendafixa.getVl_aplicado());
            dadosArray[i][3] = Utilidade.formatoValor.format(rendafixa.getVl_taxa()) + " + " + rendafixa.getIndice().getDs_indice();
            dadosArray[i][4] = Utilidade.formatoData.format(rendafixa.getDt_aplicacao().getTime());
            dadosArray[i][5] = Utilidade.formatoData.format(rendafixa.getDt_vencimento().getTime());
        }
        DefaultTableModel tRendaFixa = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tRendaFixa);
    }

    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma renda fixa da lista.");
        }
        return selecionado;
    }     
}
