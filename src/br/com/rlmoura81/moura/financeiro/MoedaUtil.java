package br.com.rlmoura81.moura.financeiro;

import java.util.ArrayList;
import javax.swing.JComboBox;

public class MoedaUtil {
    
    MoedaRepository moedar = new MoedaRepository();
        
    public void jcMoeda(JComboBox o){
        ArrayList<Moeda> lista = moedar.getLista();
        Moeda mZero = new Moeda(0, "<Moeda>");
        o.addItem(mZero);
        for(Moeda moeda : lista){
            o.addItem(moeda);
        }
    }    
    
}
