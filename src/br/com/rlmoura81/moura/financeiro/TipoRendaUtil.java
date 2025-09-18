package br.com.rlmoura81.moura.financeiro;

import java.util.ArrayList;
import javax.swing.JComboBox;

public class TipoRendaUtil {
    
    TipoRendaRepository tprendar = new TipoRendaRepository();
    
    /**
     * <p><strong>EN:</strong> Populates a JComboBox with income types (TipoRenda) retrieved from the database.</p>
     * <p><strong>IT:</strong> Popola un JComboBox con i tipi di reddito (TipoRenda) recuperati dal database.</p>
     * <p><strong>PT-BR:</strong> Preenche um JComboBox com os tipos de renda (TipoRenda) recuperados do banco de dados.</p> *
     * @param o EN: JComboBox component to be populated |
     *          IT: Componente JComboBox da popolare |
     *          PT-BR: Componente JComboBox a ser preenchido
     *
     * @since 1.0.0
     */    
    public void jcTpRenda(JComboBox o){
        ArrayList<TipoRenda> lista = tprendar.getLista();
        TipoRenda trZero = new TipoRenda(0, "<Renda>");
        o.addItem(trZero);
        for(TipoRenda tr : lista){
            o.addItem(tr);
        }
    } 
}
