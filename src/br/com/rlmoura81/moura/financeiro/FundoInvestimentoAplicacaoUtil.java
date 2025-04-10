package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FundoInvestimentoAplicacaoUtil {
    
    FundoInvestimentoAplicacao fia = new FundoInvestimentoAplicacao();
    FundoInvestimentoAplicacaoRepository fiar = new FundoInvestimentoAplicacaoRepository();
    
    ArrayList lista = new ArrayList();
    Utilidade util = new Utilidade();
    
    public void tabelaFundoInvestimentoAplicacao(JTable o, int num){
        String[] nomeColuna = {"Fundo", "Saldo"};
        lista = fiar.getListaFundoInvest(num);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        
        for(int i=0; i < lista.size(); i++){
            fia = (FundoInvestimentoAplicacao)lista.get(i);
            dadosArray[i][0] = fia.getFdinvest();
            dadosArray[i][1] = Utilidade.formatoValor.format(fia.getVl_saldo());
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
