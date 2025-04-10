package br.com.rlmoura81.moura.imovel;

import java.util.ArrayList;
import javax.swing.JComboBox;

public class TipoImovelUtil {
    
    TipoImovelRepository tpir = new TipoImovelRepository();
        
    public void jcTpimovel(JComboBox o){
        ArrayList<TipoImovel> listatpimovel = tpir.getLista();
        TipoImovel tpiZero = new TipoImovel(0, "<Tipo>");
        o.addItem(tpiZero);
        for(TipoImovel tpi : listatpimovel){
            o.addItem(tpi);
        }
    }
}
