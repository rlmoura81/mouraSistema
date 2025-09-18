package br.com.rlmoura81.moura.animal;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RacaUtil {
    
    Raca raca = new Raca();
    RacaRepository racar = new RacaRepository();    
    ArrayList lista;
   
    /**
     * <p><strong>EN:</strong> Populates a JTable with the list of breeds (Raca), displaying breed and species in columns.</p>
     *
     * <p><strong>IT:</strong> Popola una JTable con l'elenco delle razze (Raca), mostrando razza e specie nelle colonne.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche uma JTable com a lista de raças (Raca), exibindo raça e espécie nas colunas.</p>
     *
     * @param o EN: JTable to be populated | IT: JTable da popolare | PT-BR: JTable a ser preenchida
     * @since 1.0.0
     */
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

    /**
     * <p><strong>EN:</strong> Retrieves the breed (Raca) corresponding to the selected row in the JTable.  
     * Displays an information dialog if no row is selected.</p>
     *
     * <p><strong>IT:</strong> Recupera la razza (Raca) corrispondente alla riga selezionata nella JTable.  
     * Mostra una finestra di dialogo informativa se non viene selezionata alcuna riga.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera a raça (Raca) correspondente à linha selecionada na JTable.  
     * Exibe uma mensagem informativa se nenhuma linha for selecionada.</p>
     *
     * @param o EN: JTable from which to retrieve the selected breed | IT: JTable da cui recuperare la razza selezionata | PT-BR: JTable de onde recuperar a raça selecionada
     * @return EN: selected Raca object or null if none is selected | IT: oggetto Raca selezionato o null se nessuno è selezionato | PT-BR: objeto Raca selecionado ou null se nenhum for selecionado
     * @since 1.0.0
     */    
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
