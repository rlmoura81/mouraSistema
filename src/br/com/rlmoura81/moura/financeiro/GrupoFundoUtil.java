package br.com.rlmoura81.moura.financeiro;

import java.util.ArrayList;
import javax.swing.JComboBox;

public class GrupoFundoUtil {
    
    GrupoFundoRepository gpfundor = new GrupoFundoRepository();        

    /**
     * <p><strong>EN:</strong> Populates a combo box with investment fund groups.</p>
     *
     * <p><strong>IT:</strong> Popola una combo box con i gruppi di fondi di investimento.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche uma combo box com os grupos de fundos de investimento.</p>
     *
     * @param o EN: combo box to be filled | IT: combo box da riempire | PT-BR: combo box a ser preenchida
     * @since 1.0.0
     */
    public void jcGpFundo(JComboBox o){
        ArrayList<GrupoFundo> lista = gpfundor.getLista();
        GrupoFundo gfZero = new GrupoFundo(0, "<Grupo>");
        o.addItem(gfZero);
        for(GrupoFundo gf : lista){
            o.addItem(gf);
        }
    } 
}
