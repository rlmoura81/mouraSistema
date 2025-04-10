package br.com.rlmoura81.moura.principal;

import java.util.ArrayList;
import javax.swing.JComboBox;

public class ModuloUtil {
    
    ModuloRepository modulor = new ModuloRepository();
        
    public void jcModulo(JComboBox o){
        ArrayList<Modulo> lista = modulor.getLista();
        Modulo mZero = new Modulo(0, "<Módulo>");
        o.addItem(mZero);
        for(Modulo modulo : lista){
            o.addItem(modulo);
        }
    }    
    
}
