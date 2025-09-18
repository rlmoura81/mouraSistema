package br.com.rlmoura81.moura.animal;

import java.util.ArrayList;
import javax.swing.JComboBox;

public class EspecieUtil {
    
    EspecieRepository especier = new EspecieRepository();   

    /**
     * <p><strong>EN:</strong> Populates a JComboBox with the list of species, adding a default option at the beginning.</p>
     *
     * <p><strong>IT:</strong> Popola un JComboBox con l'elenco delle specie, aggiungendo un'opzione predefinita all'inizio.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche um JComboBox com a lista de espécies, adicionando uma opção padrão no início.</p>
     *
     * @param o EN: JComboBox to be populated | IT: JComboBox da popolare | PT-BR: JComboBox a ser preenchido
     * @since 1.0.0
     */
    public void jcEspecie(JComboBox o){
        ArrayList<Especie> listaespecie = especier.getLista();
        Especie esZero = new Especie(0, "<Especie>");
        o.addItem(esZero);
        for(Especie especie : listaespecie){
            o.addItem(especie);
        }        
    }    
}
