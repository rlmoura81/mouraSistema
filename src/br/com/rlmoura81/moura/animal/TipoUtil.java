package br.com.rlmoura81.moura.animal;

import java.util.ArrayList;
import javax.swing.JComboBox;

public class TipoUtil {
    
    TipoRepository tipor = new TipoRepository();    
    
    /**
     * <p><strong>EN:</strong> Populates a JComboBox with the list of types (Tipo), adding a default option at the beginning.</p>
     *
     * <p><strong>IT:</strong> Popola un JComboBox con l'elenco dei tipi (Tipo), aggiungendo un'opzione predefinita all'inizio.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche um JComboBox com a lista de tipos (Tipo), adicionando uma opção padrão no início.</p>
     *
     * @param o EN: JComboBox to be populated | IT: JComboBox da popolare | PT-BR: JComboBox a ser preenchido
     * @since 1.0.0
     */
    public void jcTipo(JComboBox o){
        ArrayList<Tipo> lista = tipor.getLista();
        Tipo cZero = new Tipo(0, "<Tipo>");
        o.addItem(cZero);
        for(Tipo t : lista){
            o.addItem(t);
        }
    }    
}
