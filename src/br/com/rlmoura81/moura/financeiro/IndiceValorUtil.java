package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class IndiceValorUtil {
    
    IndiceValor indicevalor = new IndiceValor();
    IndiceValorRepository indicevalorr = new IndiceValorRepository();    
    ArrayList lista = new ArrayList();
    
    private final BigDecimal ano = Utilidade.converter("12");

    /**
     * <p><strong>EN:</strong> Calculates the annual average based on a monthly value.</p>
     *
     * <p><strong>IT:</strong> Calcola la media annuale in base a un valore mensile.</p>
     *
     * <p><strong>PT-BR:</strong> Calcula a média anual com base em um valor mensal.</p>
     *
     * @param vl_mes EN: monthly value | IT: valore mensile | PT-BR: valor mensal
     * @return EN: annual average | IT: media annuale | PT-BR: média anual
     * @since 1.0.0
     */
    public BigDecimal mediaMesAno (BigDecimal vl_mes){
        BigDecimal resultado;
        resultado = vl_mes.multiply(ano);
        return resultado;
    }
    
    /**
     * <p><strong>EN:</strong> Calculates the monthly average based on an annual value.</p>
     *
     * <p><strong>IT:</strong> Calcola la media mensile in base a un valore annuale.</p>
     *
     * <p><strong>PT-BR:</strong> Calcula a média mensal com base em um valor anual.</p>
     *
     * @param vl_ano EN: annual value | IT: valore annuale | PT-BR: valor anual
     * @return EN: monthly average | IT: media mensile | PT-BR: média mensal
     * @since 1.0.0
     */
    public BigDecimal mediaAnoMes (BigDecimal vl_ano){
        BigDecimal resultado;
        resultado = vl_ano.divide(ano, 2, RoundingMode.CEILING);
        return resultado;
    }
  
    /**
     * <p><strong>EN:</strong> Retrieves the monthly value of a given index.</p>
     *
     * <p><strong>IT:</strong> Recupera il valore mensile di un determinato indice.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera o valor mensal de um determinado índice.</p>
     *
     * @param num EN: index identifier | IT: identificatore indice | PT-BR: identificador do índice
     * @return EN: monthly index value | IT: valore mensile dell’indice | PT-BR: valor mensal do índice
     * @since 1.0.0
     */
    public BigDecimal indiceValor(int num){
        BigDecimal vl_indice;
        indicevalor = (IndiceValor)indicevalorr.getValorIndice(num);
        vl_indice = indicevalor.getVl_mes();
        return vl_indice;
    }
    
    /**
     * <p><strong>EN:</strong> Populates a JTable with index values for a given index.</p>
     *
     * <p><strong>IT:</strong> Popola una JTable con i valori indice per un determinato indice.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche uma JTable com os valores do índice para um determinado índice.</p>
     *
     * @param o EN: JTable component to be populated | IT: componente JTable da popolare | PT-BR: componente JTable a ser preenchido
     * @param cd_indice EN: index identifier | IT: identificatore indice | PT-BR: identificador do índice
     * @since 1.0.0
     */
    public void tabelaIndiceValor(JTable o, int cd_indice){
        String[] nomeColuna = {"Indice", "Data", "Mês"};
        lista = indicevalorr.getLista(cd_indice);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for(int i = 0; i < lista.size(); i++){
            indicevalor = (IndiceValor) lista.get(i);
            dadosArray[i][0] = indicevalor.getIndice();
            dadosArray[i][1] = Utilidade.formatoData.format(indicevalor.getDt_vlatualizado().getTime());
            dadosArray[i][2] = Utilidade.formatoValor.format(indicevalor.getVl_mes())+"%";
        }
        DefaultTableModel tIndiceValor = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tIndiceValor);
    }

    /**
     * <p><strong>EN:</strong> Retrieves the selected object from a JTable.</p>
     *
     * <p><strong>IT:</strong> Recupera l’oggetto selezionato da una JTable.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera o objeto selecionado de uma JTable.</p>
     *
     * @param o EN: JTable component | IT: componente JTable | PT-BR: componente JTable
     * @return EN: selected object or null if none | IT: oggetto selezionato o null se nessuno | PT-BR: objeto selecionado ou null se nenhum
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
