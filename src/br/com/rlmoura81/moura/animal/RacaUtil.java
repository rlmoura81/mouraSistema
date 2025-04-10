package br.com.rlmoura81.moura.animal;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RacaUtil {
    
    Raca raca = new Raca();
    RacaRepository racar = new RacaRepository();
    
    ArrayList lista;
    
    public void tabelaRaca(JTable o){
        String[] nomeColuna = {"Raça", "Especie"};
        lista = racar.getLista();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        
        for(int i=0; i < lista.size(); i++){
            raca = (Raca)lista.get(i);
            dadosArray[i][0] = raca.getDs_raca();
            dadosArray[i][1] = raca.getEspecie();
        }
        
        DefaultTableModel tRaca = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tRaca);
    }
    
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma raça da lista.", "Raça", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;
    }
    
}
