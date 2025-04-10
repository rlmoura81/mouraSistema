package br.com.rlmoura81.moura.financeiro;

import java.util.ArrayList;
import javax.swing.JComboBox;

public class TipoRendaUtil {
    
    TipoRenda tprenda = new TipoRenda();
    TipoRendaRepository tprendar = new TipoRendaRepository();
    
    ArrayList lista = new ArrayList();
    
    public void jcTpRenda(JComboBox o){
        ArrayList<TipoRenda> lista = tprendar.getLista();
        TipoRenda trZero = new TipoRenda(0, "<Renda>");
        o.addItem(trZero);
        for(TipoRenda tr : lista){
            o.addItem(tr);
        }
    } 
}
