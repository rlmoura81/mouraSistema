package br.com.rlmoura81.moura.animal;

import java.util.ArrayList;
import javax.swing.JComboBox;

public class TipoUtil {
    
    TipoRepository tipor = new TipoRepository();    
    
    public void jcTipo(JComboBox o){
        ArrayList<Tipo> lista = tipor.getLista();
        Tipo cZero = new Tipo(0, "<Tipo>");
        o.addItem(cZero);
        for(Tipo t : lista){
            o.addItem(t);
        }
    }    
}
