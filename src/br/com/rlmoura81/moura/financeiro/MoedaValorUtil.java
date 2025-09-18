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

    /**
     * <p><strong>EN:</strong> Fills a JTable with currency value records (currency, value, and date).</p>
     *
     * <p><strong>IT:</strong> Compila una JTable con i record dei valori delle valute (valuta, valore e data).</p>
     *
     * <p><strong>PT-BR:</strong> Preenche uma JTable com registros de valores de moedas (moeda, valor e data).</p>
     *
     * @param o EN: JTable to populate | IT: JTable da popolare | PT-BR: JTable a ser preenchida
     * @since 1.0.0
     */
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

    /**
     * <p><strong>EN:</strong> Retrieves the selected object from the JTable.</p>
     *
     * <p><strong>IT:</strong> Recupera l'oggetto selezionato dalla JTable.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera o objeto selecionado da JTable.</p>
     *
     * @param o EN: JTable with selectable rows | IT: JTable con righe selezionabili | PT-BR: JTable com linhas selecionáveis
     * @return EN: selected object or null if none is selected | IT: oggetto selezionato o null se nessuno è selezionato | PT-BR: objeto selecionado ou null se nenhum for selecionado
     * @since 1.0.0
     */
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
