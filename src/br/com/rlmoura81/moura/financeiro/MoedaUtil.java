package br.com.rlmoura81.moura.financeiro;

import java.util.ArrayList;
import javax.swing.JComboBox;

public class MoedaUtil {
    
    MoedaRepository moedar = new MoedaRepository();
        
    /**
     * <p><strong>EN:</strong> Populates the combo box with the list of currencies.</p>
     *
     * <p><strong>IT:</strong> Popola la combo box con l’elenco delle valute.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche o combo box com a lista de moedas.</p>
     *
     * @param o EN: combo box to populate | IT: combo box da popolare | PT-BR: combo box a ser preenchido
     * @since 1.0.0
     */
    public void jcMoeda(JComboBox o){
        ArrayList<Moeda> lista = moedar.getLista();
        Moeda mZero = new Moeda(0, "<Moeda>");
        o.addItem(mZero);
        for(Moeda moeda : lista){
            o.addItem(moeda);
        }
    }    
    
}
