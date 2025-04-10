package br.com.rlmoura81.moura.financeiro;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FundoInvestimentoUtil {
    
    FundoInvestimento fdinvest = new FundoInvestimento();
    FundoInvestimentoRepository fdinvestr = new FundoInvestimentoRepository();
    
    ArrayList lista = new ArrayList();

    public void jcFdInvest(JComboBox o, int fundo){
        ArrayList<FundoInvestimento> lista = fdinvestr.getListaFundoInvest(fundo);
        FundoInvestimento fiZero = new FundoInvestimento(0, "<Investimento>", null, 0);
        o.addItem(fiZero);
        for(FundoInvestimento fi : lista){
            o.addItem(fi);
        }
    }

    public void jcFdInvestFiltro(JComboBox o, int conta){
        ArrayList<FundoInvestimento> lista = fdinvestr.getListaFundoInvestAplic(conta);
        FundoInvestimento fiZero = new FundoInvestimento(0, "<Tipo>", null, 0);
        o.addItem(fiZero);
        for(FundoInvestimento fi : lista){
            o.addItem(fi);
        }
    }
    
    public void tabelaFundoInvestimento(JTable o){
        String[]nomeColuna = {"Fundo", "Tipo"};
        lista = fdinvestr.getLista();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        
        for(int i = 0; i < lista.size(); i++){
            fdinvest = (FundoInvestimento) lista.get(i);
            dadosArray[i][0] = fdinvest.getGpfundo();
            dadosArray[i][1] = fdinvest.getDs_fdinvest();
        }
        DefaultTableModel tPoupanca = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tPoupanca);        
    }
    
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um fundo de investimento da lista.");
        }
        return selecionado;
    }  
    
}
