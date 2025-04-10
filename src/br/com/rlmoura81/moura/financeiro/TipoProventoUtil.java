package br.com.rlmoura81.moura.financeiro;

import java.util.ArrayList;
import javax.swing.JComboBox;

public class TipoProventoUtil {
    
    TipoProvento tp = new TipoProvento();
    TipoProventoRepository tpr = new TipoProventoRepository();
    
    ArrayList lista = new ArrayList();

    public void jcTpProvento(JComboBox o){
        ArrayList<TipoProvento> lista = tpr.getLista();
        TipoProvento tppZero = new TipoProvento(0, "<Tipo>");
        o.addItem(tppZero);
        for(TipoProvento tpp : lista){
            o.addItem(tpp);
        }
    }
    
    public void jcTpProventoAcao(JComboBox o){
        ArrayList<TipoProvento> lista = tpr.getListaTpProvAcao();
        TipoProvento tppZero = new TipoProvento(0, "<Tipo>");
        o.addItem(tppZero);
        for(TipoProvento tpp : lista){
            o.addItem(tpp);
        }
    }
    
    public void jcTpProventoFII(JComboBox o){
        ArrayList<TipoProvento> lista = tpr.getListaTpProvFII();
        TipoProvento tppZero = new TipoProvento(0, "<Tipo>");
        o.addItem(tppZero);
        for(TipoProvento tpp : lista){
            o.addItem(tpp);
        }
    }
}
