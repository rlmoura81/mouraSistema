package br.com.rlmoura81.moura.rpg;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TarefaUtil {
    
    Tarefa tarefa = new Tarefa();
    TarefaRepository tarefar = new TarefaRepository();
    
    ArrayList lista = new ArrayList();
    
    Utilidade util = new Utilidade();
    
    public void tabelaTarefa(JTable o){
        String []nomeColuna = {"Tarefa", "Ponto", "Tipo"};
        lista = tarefar.getListaTarefa();
        Object[][]dadosArray = new Object[lista.size()][nomeColuna.length];
        for(int i=0; i < lista.size(); i++){
            tarefa = (Tarefa)lista.get(i);
            dadosArray[i][0] = tarefa.getDs_tarefa();
            dadosArray[i][1] = tarefa.getNm_valor();
            dadosArray[i][2] = tarefa.getTp_tempo();
        }
        DefaultTableModel tCurso = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tCurso);
    }
    
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaSelecionada = o.getSelectedRow();
        if(linhaSelecionada >= 0){
            selecionado = lista.get(linhaSelecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma tarefa da lista.");
        }
        return selecionado;
    }    
}
