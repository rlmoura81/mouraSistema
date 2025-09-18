package br.com.rlmoura81.moura.financeiro;

import java.util.ArrayList;
import javax.swing.JComboBox;

public class TipoContaUtil {
    
    TipoContaRepository tipocontar = new TipoContaRepository(); 
        
    /**
     * <p><strong>EN:</strong> Populates a combo box with the list of account types.</p>
     * <p><strong>IT:</strong> Popola una combo box con l’elenco dei tipi di conto.</p>
     * <p><strong>PT-BR:</strong> Preenche um combo box com a lista de tipos de conta.</p>
     *
     * @param o EN: Combo box to be populated | IT: Combo box da popolare | PT-BR: Combo box a ser preenchido
     * @since 1.0.0
     */
    public void jcTpconta(JComboBox o){
        ArrayList<TipoConta> listatpconta = tipocontar.getLista();
        TipoConta tpcZero = new TipoConta(0, "<Tipo>");
        o.addItem(tpcZero);
        for(TipoConta tpc : listatpconta){
            o.addItem(tpc);
        }
    }    
}
