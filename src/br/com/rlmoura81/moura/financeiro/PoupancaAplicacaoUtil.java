package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PoupancaAplicacaoUtil {
    
    PoupancaAplicacao poupap = new PoupancaAplicacao();
    PoupancaAplicacaoRepository poupapr = new PoupancaAplicacaoRepository();
    
    ArrayList lista = new ArrayList();
    
    public BigDecimal atualizaSaldoIndice (BigDecimal vl_saldo, BigDecimal vl_indice){
        BigDecimal resultado = null;
        resultado = ((vl_saldo.multiply(vl_indice)).divide(Utilidade.converter("100,00"))).add(vl_saldo);
        return resultado;
    }
        
    public void tabelaPoupancaAplicacao(JTable o, int cd_poupanca){
        String[] nomeColuna = {"Saldo", "Data"};
        lista = poupapr.getLista(cd_poupanca);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        
        for(int i=0; i < lista.size(); i++){
            poupap = (PoupancaAplicacao)lista.get(i);
            dadosArray[i][0] = Utilidade.formatoValor.format(poupap.getVl_saldo());
            dadosArray[i][1] = Utilidade.formatoData.format(poupap.getDt_saldo().getTime());
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
