package br.com.rlmoura81.moura.financeiro;

import java.util.ArrayList;
import javax.swing.JComboBox;

public class IndiceUtil {
    
    IndiceRepository indicer = new IndiceRepository();
        
    /**
     * <p><strong>EN:</strong> Populates a combo box with the list of indices, adding a default option.</p>
     *
     * <p><strong>IT:</strong> Popola una combo box con l'elenco degli indici, aggiungendo un'opzione predefinita.</p>
     *
     * <p><strong>PT-BR:</strong> Popula uma combo box com a lista de índices, adicionando uma opção padrão.</p>
     *
     * @param o EN: combo box to be populated | IT: combo box da popolare | PT-BR: combo box a ser populada
     * @since 1.0.0
     */
    public void jcIndice(JComboBox o){
        ArrayList<Indice> lista = indicer.getLista();
        Indice iZero = new Indice(0, "<Índice>");
        o.addItem(iZero);
        for(Indice indice : lista){
            o.addItem(indice);
        }
    }    
}
