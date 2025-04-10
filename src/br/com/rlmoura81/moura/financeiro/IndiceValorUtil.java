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

    //Média Mes Ano
    public BigDecimal mediaMesAno (BigDecimal vl_mes){
        BigDecimal resultado;
        resultado = vl_mes.multiply(ano);
        return resultado;
    }
    
    //Média Ano Mes
    public BigDecimal mediaAnoMes (BigDecimal vl_ano){
        BigDecimal resultado;
        resultado = vl_ano.divide(ano, 2, RoundingMode.CEILING);
        return resultado;
    }
    
    public BigDecimal indiceValor(int num){
        BigDecimal vl_indice;
        indicevalor = (IndiceValor)indicevalorr.getValorIndice(num);
        vl_indice = indicevalor.getVl_mes();
        return vl_indice;
    }
    
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
