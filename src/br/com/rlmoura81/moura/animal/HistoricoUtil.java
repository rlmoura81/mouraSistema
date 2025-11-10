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
   
    /**
     * <p><strong>EN:</strong> Populates a JTable with the history records (Historico) of a given animal, formatting data into columns.</p>
     *
     * <p><strong>IT:</strong> Popola una JTable con i record di storico (Historico) di un determinato animale, formattando i dati nelle colonne.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche uma JTable com os registros de histórico (Historico) de um determinado animal, formatando os dados em colunas.</p>
     *
     * @param o EN: JTable to be populated | IT: JTable da popolare | PT-BR: JTable a ser preenchida
     * @param cd_animal EN: animal identifier whose history will be displayed | IT: identificatore dell'animale di cui mostrare lo storico | PT-BR: identificador do animal cujo histórico será exibido
     * @since 1.0.0
     */
    public void tabelaHistorico(JTable o, int cd_animal){
        String[] nomeColuna = {"Data", "Historico", "Tipo", "Prestador"};
        lista = historicor.getLista(cd_animal);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        
        for(int i = 0; i < lista.size(); i++){
            historico = (Historico)lista.get(i);
            dadosArray[i][0] = Utilidade.formatoData.format(historico.getDt_historico().getTime());
            dadosArray[i][1] = historico.getDs_historico();
            dadosArray[i][2] = historico.getTipo();
            dadosArray[i][3] = historico.getEmpresa();
        }
        DefaultTableModel tHistorico = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tHistorico);
    }
   
    /**
     * <p><strong>EN:</strong> Retrieves the object corresponding to the selected row in the JTable.  
     * Displays an information dialog if no row is selected.</p>
     *
     * <p><strong>IT:</strong> Recupera l'oggetto corrispondente alla riga selezionata nella JTable.  
     * Mostra una finestra di dialogo informativa se non viene selezionata alcuna riga.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera o objeto correspondente à linha selecionada na JTable.  
     * Exibe uma mensagem informativa se nenhuma linha for selecionada.</p>
     *
     * @param o EN: JTable from which to retrieve the selected object | IT: JTable da cui recuperare l'oggetto selezionato | PT-BR: JTable de onde recuperar o objeto selecionado
     * @return EN: selected object or null if none is selected | IT: oggetto selezionato o null se nessuno è selezionato | PT-BR: objeto selecionado ou null se nenhum for selecionado
     * @since 1.0.0
     */
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
