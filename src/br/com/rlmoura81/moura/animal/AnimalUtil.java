package br.com.rlmoura81.moura.animal;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AnimalUtil {
    
    RacaRepository racar = new RacaRepository();    
    Animal animal = new Animal();
    AnimalRepository animalr = new AnimalRepository();    
    ArrayList lista = new ArrayList();
    
    /**
     * <p><strong>EN:</strong> Populates a JComboBox with the list of breeds (Raca), adding a default option at the beginning.</p>
     *
     * <p><strong>IT:</strong> Popola un JComboBox con l'elenco delle razze (Raca), aggiungendo un'opzione predefinita all'inizio.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche um JComboBox com a lista de raças (Raca), adicionando uma opção padrão no início.</p>
     *
     * @param o EN: JComboBox to be populated | IT: JComboBox da popolare | PT-BR: JComboBox a ser preenchido
     * @since 1.0.0
     */
   
    public void jcRaca(JComboBox o){
        ArrayList<Raca> listaraca = racar.getLista();
        Raca rZero = new Raca(0, "<Raça>", null, 0);
        o.addItem(rZero);
        for(Raca raca : listaraca){
            o.addItem(raca);
        }
    }
    
    /**
     * <p><strong>EN:</strong> Populates a JComboBox with the list of animals, adding a default option at the beginning.</p>
     *
     * <p><strong>IT:</strong> Popola un JComboBox con l'elenco degli animali, aggiungendo un'opzione predefinita all'inizio.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche um JComboBox com a lista de animais, adicionando uma opção padrão no início.</p>
     *
     * @param o EN: JComboBox to be populated | IT: JComboBox da popolare | PT-BR: JComboBox a ser preenchido
     * @since 1.0.0
     */
    public void jcAnimal(JComboBox o){
        ArrayList<Animal> listaanimal = animalr.getLista();
        Animal aZero = new Animal(0, "<Animal>", null, null, null, 0);
        o.addItem(aZero);
        for(Animal a : listaanimal){
            o.addItem(a);
        }
    }
    
    /**
     * <p><strong>EN:</strong> Populates a JTable with the list of animals, formatting the data into columns.</p>
     *
     * <p><strong>IT:</strong> Popola una JTable con l'elenco degli animali, formattando i dati nelle colonne.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche uma JTable com a lista de animais, formatando os dados nas colunas.</p>
     *
     * @param o EN: JTable to be populated | IT: JTable da popolare | PT-BR: JTable a ser preenchida
     * @since 1.0.0
     */
    public void tabelaAnimal(JTable o){
        String[] nomeColuna = {"Nome", "Data Nasc.", "Sexo", "Raça/Especie"};
        lista = animalr.getLista();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        
        for(int i=0; i < lista.size(); i++){
            animal = (Animal)lista.get(i);
            dadosArray[i][0] = animal.getDs_nome();
            dadosArray[i][1] = Utilidade.formatoData.format(animal.getDt_nasc().getTime());
            dadosArray[i][2] = animal.getDs_sexo();
            dadosArray[i][3] = animal.getRaca();
        }
        
        DefaultTableModel tAnimal = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tAnimal);
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves the object corresponding to the selected row in the JTable.  
     * Displays an information dialog if no row is selected.</p>
     *
     * <p><strong>IT:</strong> Recupera l'oggetto corrispondente alla riga selezionata nella JTable.  
     * Mostra una finestra di dialogo informativa se non viene selezionata alcuna riga.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera o objeto correspondente à linha selecionada na JTable.  
     * Exibe uma janela de informação se nenhuma linha for selecionada.</p>
     *
     * @param o EN: JTable from which to retrieve the selected object | IT: JTable da cui recuperare l'oggetto selezionato | PT-BR: JTable de onde recuperar o objeto selecionado
     * @return EN: selected object or null if none is selected | IT: oggetto selezionato o null se nessuno è selezionato | PT-BR: objeto selecionado ou null se nenhum for selecionado
     * @since
     */    
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um animal da lista.", 
                    "Animal", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;    
    }    
}
