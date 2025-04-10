package br.com.rlmoura81.moura.animal;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class HistoricoUtil {

    Historico historico = new Historico();
    HistoricoRepository historicor = new HistoricoRepository();
    
    ArrayList lista = new ArrayList();
    
    public void tabelaHistorico(JTable o, int cd_animal){
        String[] nomeColuna = {"Data", "Historico", "Tipo", "Prestador"};
        lista = historicor.getLista(cd_animal);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        
        for(int i = 0; i < lista.size(); i++){
            historico = (Historico)lista.get(i);
            dadosArray[i][0] = Utilidade.formatoData.format(historico.getDt_historico().getTime());
            dadosArray[i][1] = historico.getDs_historico();
            dadosArray[i][2] = historico.getTipo();
            dadosArray[i][3] = historico.getPresserv();
        }
        DefaultTableModel tHistorico = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tHistorico);
    }
    
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaSelecionada = o.getSelectedRow();
        if(linhaSelecionada >= 0){
            selecionado = lista.get(linhaSelecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um item da lista.", "Histórico", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;
    } 
}
