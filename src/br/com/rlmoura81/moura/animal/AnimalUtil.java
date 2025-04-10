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
    
    public void jcRaca(JComboBox o){
        ArrayList<Raca> listaraca = racar.getLista();
        Raca rZero = new Raca(0, "<Raça>", null, 0);
        o.addItem(rZero);
        for(Raca raca : listaraca){
            o.addItem(raca);
        }
    }
    
    public void jcAnimal(JComboBox o){
        ArrayList<Animal> listaanimal = animalr.getLista();
        Animal aZero = new Animal(0, "<Animal>", null, null, null, 0);
        o.addItem(aZero);
        for(Animal a : listaanimal){
            o.addItem(a);
        }
    }
    
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
