package br.com.rlmoura81.moura.financeiro;

import java.util.ArrayList;
import javax.swing.JComboBox;

public class TipoAtivoUtil {
    
    TipoAtivo tpativo = new TipoAtivo();
    TipoAtivoRepository tpativor = new TipoAtivoRepository();
    
    ArrayList lista = new ArrayList();
    
    public void jcTipoAtivo(JComboBox o){
        ArrayList<TipoAtivo> lista = tpativor.getLista();
        TipoAtivo tpaZero = new TipoAtivo(0, "<Tipo>");
        o.addItem(tpaZero);
        for(TipoAtivo tpa : lista){
            o.addItem(tpa);
        }
    }

    //Ativo por Ação ou FII
    public void jcTipoAtivoAcaoFii(JComboBox o){
        ArrayList<TipoAtivo> lista = tpativor.getListaTipoAtivoAcaoFII();
        TipoAtivo tpaZero = new TipoAtivo(0, "<Tipo>");
        o.addItem(tpaZero);
        for(TipoAtivo tpa : lista){
            o.addItem(tpa);
        }
    }
    
    public void jcTipoAtivoRendaFixa(JComboBox o){
        ArrayList<TipoAtivo> lista = tpativor.getListaTipoRendaFixa();
        TipoAtivo tpaZero = new TipoAtivo(0, "<Tipo>");
        o.addItem(tpaZero);
        for(TipoAtivo tpa : lista){
            o.addItem(tpa);
        }
    }
}
