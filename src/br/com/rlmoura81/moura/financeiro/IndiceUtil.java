package br.com.rlmoura81.moura.financeiro;

import java.util.ArrayList;
import javax.swing.JComboBox;

public class IndiceUtil {
    
    IndiceRepository indicer = new IndiceRepository();
        
    public void jcIndice(JComboBox o){
        ArrayList<Indice> lista = indicer.getLista();
        Indice iZero = new Indice(0, "<Índice>");
        o.addItem(iZero);
        for(Indice indice : lista){
            o.addItem(indice);
        }
    }    
}
