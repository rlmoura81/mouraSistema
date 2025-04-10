package br.com.rlmoura81.moura.financeiro;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ContaUtil {
    
    Conta conta = new Conta();
    ContaRepository contar = new ContaRepository();    
    
    ArrayList lista = new ArrayList();

    public void jcConta(JComboBox o){
        ArrayList<Conta> listaconta = contar.getLista();
        Conta contaZero = new Conta(0, "<Agencia>", "<Conta>", null, null, 0);
        o.addItem(contaZero);
        for(Conta conta : listaconta){
            o.addItem(conta);
        }
    }
    
    public void tabelaConta(JTable o){
        String[]nomeColuna = {"Banco", "Agencia", "Numero Conta", "Tipo"};
        lista = contar.getLista();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        
        for(int i = 0; i < lista.size(); i++){
            conta = (Conta)lista.get(i);
            dadosArray[i][0] = conta.getBanco().getDs_banco();
            dadosArray[i][1] = conta.getNm_agencia();
            dadosArray[i][2] = conta.getNm_conta();
            dadosArray[i][3] = conta.getTpconta().getDs_tpconta();
        }
        DefaultTableModel tConta = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tConta);
    }
    
    public Object getSelectedObject(JTable o){  
        Object selecionado = null;
        int linhaSelecionada = o.getSelectedRow();
        if(linhaSelecionada >= 0){
            selecionado = lista.get(linhaSelecionada);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma conta.");
        }
        return selecionado;  
    }
}
