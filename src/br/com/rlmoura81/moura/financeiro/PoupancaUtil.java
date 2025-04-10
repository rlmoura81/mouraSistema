package br.com.rlmoura81.moura.financeiro;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PoupancaUtil {
    
    Poupanca poupanca = new Poupanca();
    PoupancaRepository poupancar = new PoupancaRepository();
    
    ArrayList lista = new ArrayList();
    
    public void jcPoupanca(JComboBox o, int cd_conta){
        ArrayList<Poupanca> listapoupanca = poupancar.getLista(cd_conta);
        Poupanca poupZero = new Poupanca(0, "<Variação>", null, null, 0);
        o.addItem(poupZero);
        for(Poupanca p : listapoupanca){
            o.addItem(p);
        }
    }
    
    public void tabelaPoupanca(JTable o, int cd_conta){
        String[]nomeColuna = {"Variação", "Agencia/Conta/Banco"};
        lista = poupancar.getLista(cd_conta);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        
        for(int i = 0; i < lista.size(); i++){
            poupanca = (Poupanca) lista.get(i);
            dadosArray[i][0] = poupanca.getNm_variaca();
            dadosArray[i][1] = poupanca.getConta();
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
            JOptionPane.showMessageDialog(null, "Selecione uma poupança da lista.");
        }
        return selecionado;
    }  
}
