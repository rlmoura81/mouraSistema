package br.com.rlmoura81.moura.animal;

import java.util.ArrayList;
import javax.swing.JComboBox;

public class EspecieUtil {
    
    EspecieRepository especier = new EspecieRepository();   

    public void jcEspecie(JComboBox o){
        ArrayList<Especie> listaespecie = especier.getLista();
        Especie esZero = new Especie(0, "<Especie>");
        o.addItem(esZero);
        for(Especie especie : listaespecie){
            o.addItem(especie);
        }        
    }    
}
