package br.com.rlmoura81.moura.financeiro;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BancoUtil {
    
    Banco banco = new Banco();
    BancoRepository bancor = new BancoRepository();

    ArrayList lista = new ArrayList();
    
    public void jcBanco(JComboBox o){
        ArrayList<Banco> listabanco = bancor.getLista();
        Banco cZero = new Banco(0, "<Banco>", 0, 0);
        o.addItem(cZero);
        for(Banco banco : listabanco){
            o.addItem(banco);
        }
    }
    
    public void tabelaBanco(JTable o){
        String[] nomeColuna = {"Banco", "Numero"};
        lista = bancor.getLista();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        
        for(int i = 0; i < lista.size(); i++){
            banco = (Banco)lista.get(i);
            dadosArray[i][0] = banco.getDs_banco();
            dadosArray[i][1] = banco.getNm_banco();
        }
        DefaultTableModel tBanco = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tBanco);
    }
        
    public Object getSelectedObject(JTable o){        
        Object selecionado = null;
        int linhaSelecionada = o.getSelectedRow();
        if(linhaSelecionada >= 0){
            selecionado = lista.get(linhaSelecionada);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um item da lista.");
        }
        return selecionado;  
    }
}
