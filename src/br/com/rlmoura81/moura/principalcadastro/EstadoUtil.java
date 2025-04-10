package br.com.rlmoura81.moura.principalcadastro;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EstadoUtil {
    
    Estado estado = new Estado();
    EstadoRepository estador = new EstadoRepository();
    
    ArrayList lista = new ArrayList();    
        
    public void jcEstado(JComboBox o){        
        ArrayList<Estado> listaestado = estador.getLista();
        Estado eZero = new Estado(0, null, "<UF>");
        o.addItem(eZero);
        for(Estado estado : listaestado){
            o.addItem(estado);
        }      
    }
    
    public void tabelaEstado(JTable o){        
        String[] nomeColuna = {"Estado", "Sigla"};
        lista = estador.getLista();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        for(int i = 0; i < lista.size(); i++){
            estado = (Estado) lista.get(i);
            dadosArray[i][0] = estado.getDs_estado();
            dadosArray[i][1] = estado.getDs_siglaEstado();            
        }
        DefaultTableModel tEstado = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tEstado);    
    }
    
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaSelecionada = o.getSelectedRow();
        if(linhaSelecionada >= 0){
            selecionado = lista.get(linhaSelecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um estado da lista.", "Estado", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;
    }
}
