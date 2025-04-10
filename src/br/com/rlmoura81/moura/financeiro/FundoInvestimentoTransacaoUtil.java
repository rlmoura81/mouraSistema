package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FundoInvestimentoTransacaoUtil {
    
    FundoInvestimentoTransacao fit = new FundoInvestimentoTransacao();
    FundoInvestimentoTransacaoRepository fitr = new FundoInvestimentoTransacaoRepository();
    
    ArrayList lista = new ArrayList();
    Utilidade util = new Utilidade();
    
    public void tabelaFundoInvestimentoTransacao(JTable o, int fdinvestaplic, int conta){
        String[] nomeColuna = {"Valor", "Data", "Tipo"};
        lista = fitr.getListaFdInvestTrans(fdinvestaplic, conta);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        
        for(int i=0; i < lista.size(); i++){
            fit = (FundoInvestimentoTransacao)lista.get(i);
            dadosArray[i][0] = Utilidade.formatoValor.format(fit.getVl_transacao());
            dadosArray[i][1] = Utilidade.formatoData.format(fit.getDt_transacao().getTime());
            dadosArray[i][2] = fit.getGptrans();
        }
        DefaultTableModel tFdInvestTrans = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tFdInvestTrans);
    }
    
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um Fundo de Investimento da lista.");
        }
        return selecionado;    
    } 
    
}
