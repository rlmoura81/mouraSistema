package br.com.rlmoura81.moura.financeiro;

import java.util.ArrayList;
import javax.swing.JComboBox;

public class TipoContaUtil {
    
    TipoContaRepository tipocontar = new TipoContaRepository(); 
        
    public void jcTpconta(JComboBox o){
        ArrayList<TipoConta> listatpconta = tipocontar.getLista();
        TipoConta tpcZero = new TipoConta(0, "<Tipo>");
        o.addItem(tpcZero);
        for(TipoConta tpc : listatpconta){
            o.addItem(tpc);
        }
    }    
}
