package br.com.rlmoura81.moura.financeiro;

import java.util.ArrayList;
import javax.swing.JComboBox;

public class GrupoFundoUtil {
    
    GrupoFundo gpfundo = new GrupoFundo();
    GrupoFundoRepository gpfundor = new GrupoFundoRepository();
        
    ArrayList lista = new ArrayList();

    public void jcGpFundo(JComboBox o){
        ArrayList<GrupoFundo> lista = gpfundor.getLista();
        GrupoFundo gfZero = new GrupoFundo(0, "<Grupo>");
        o.addItem(gfZero);
        for(GrupoFundo gf : lista){
            o.addItem(gf);
        }
    } 
}
