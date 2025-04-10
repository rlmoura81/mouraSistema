package br.com.rlmoura81.moura.rpg;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DiarioUtil {
    
    Diario diario = new Diario();
    DiarioRepository diarior = new DiarioRepository();
    
    ArrayList lista = new ArrayList();
    
    Utilidade util = new Utilidade();
    
    public void tabelaDiario(JTable o){
        String []nomeColuna = {"Data", "Tarefa", "Ponto"};
        lista = diarior.getListaDiario();
        Object[][]dadosArray = new Object[lista.size()][nomeColuna.length];
        for(int i=0; i < lista.size(); i++){
            diario = (Diario)lista.get(i);
            dadosArray[i][0] = Utilidade.formatoData.format(diario.getDt_diario().getTime());
            dadosArray[i][1] = diario.getTarefa().getDs_tarefa();
            dadosArray[i][2] = diario.getTarefa().getNm_valor();
        }
        DefaultTableModel tDiario = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tDiario);
    }

    public void tabelaDiario(JTable o, String data){
        String []nomeColuna = {"Data", "Tarefa", "Ponto"};
        lista = diarior.getListaDiarioDia(data);
        Object[][]dadosArray = new Object[lista.size()][nomeColuna.length];
        for(int i=0; i < lista.size(); i++){
            diario = (Diario)lista.get(i);
            dadosArray[i][0] = Utilidade.formatoData.format(diario.getDt_diario().getTime());
            dadosArray[i][1] = diario.getTarefa().getDs_tarefa();
            dadosArray[i][2] = diario.getTarefa().getNm_valor();
        }
        DefaultTableModel tDiario = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tDiario);
    }
    
    public void tabelaDiarioResumo(JTable o){
        String []nomeColuna = {"Data", "Total"};
        lista = diarior.getListaDiarioResumo();
        Object[][]dadosArray = new Object[lista.size()][nomeColuna.length];
        for(int i=0; i < lista.size(); i++){
            diario = (Diario)lista.get(i);
            dadosArray[i][0] = Utilidade.formatoData.format(diario.getDt_diario().getTime());
            dadosArray[i][1] = diario.getNm_valor();
        }
        DefaultTableModel tDiarioResumo = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tDiarioResumo);
    }    
    
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaSelecionada = o.getSelectedRow();
        if(linhaSelecionada >= 0){
            selecionado = lista.get(linhaSelecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma data da lista.");
        }
        return selecionado;
    }      
}
