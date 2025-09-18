package br.com.rlmoura81.moura.financeiro;

import java.util.ArrayList;
import javax.swing.JComboBox;

public class TipoProventoUtil {
    
    TipoProventoRepository tpr = new TipoProventoRepository();    

    /**
     * <p><strong>EN:</strong> Populates a JComboBox with the complete list of income types.</p>
     * <p><strong>IT:</strong> Popola un JComboBox con l’elenco completo dei tipi di provento.</p>
     * <p><strong>PT-BR:</strong> Preenche um JComboBox com a lista completa de tipos de provento.</p>
     *
     * @param o EN: JComboBox to populate | IT: JComboBox da popolare | PT-BR: JComboBox a ser preenchido
     * @since 1.0.0
     */
    public void jcTpProvento(JComboBox o){
        ArrayList<TipoProvento> lista = tpr.getLista();
        TipoProvento tppZero = new TipoProvento(0, "<Tipo>");
        o.addItem(tppZero);
        for(TipoProvento tpp : lista){
            o.addItem(tpp);
        }
    }
    
    /**
     * <p><strong>EN:</strong> Populates a JComboBox with income types related to stocks.</p>
     * <p><strong>IT:</strong> Popola un JComboBox con i tipi di provento relativi alle azioni.</p>
     * <p><strong>PT-BR:</strong> Preenche um JComboBox com os tipos de provento vinculados às ações.</p>
     *
     * @param o EN: JComboBox to populate | IT: JComboBox da popolare | PT-BR: JComboBox a ser preenchido
     * @since 1.0.0
     */
    public void jcTpProventoAcao(JComboBox o){
        ArrayList<TipoProvento> lista = tpr.getListaTpProvAcao();
        TipoProvento tppZero = new TipoProvento(0, "<Tipo>");
        o.addItem(tppZero);
        for(TipoProvento tpp : lista){
            o.addItem(tpp);
        }
    }
    
    /**
     * <p><strong>EN:</strong> Populates a combo box with income types linked to FIIs (Real Estate Investment Funds).</p>
     * <p><strong>IT:</strong> Popola una combo box con i tipi di provento collegati ai fondi immobiliari (FII).</p>
     * <p><strong>PT-BR:</strong> Preenche um combo box com os tipos de provento vinculados aos FIIs.</p>
     *
     * @param o EN: ComboBox to populate | IT: ComboBox da popolare | PT-BR: ComboBox a ser preenchido
     * @since 1.0.0
     */
    public void jcTpProventoFII(JComboBox o){
        ArrayList<TipoProvento> lista = tpr.getListaTpProvFII();
        TipoProvento tppZero = new TipoProvento(0, "<Tipo>");
        o.addItem(tppZero);
        for(TipoProvento tpp : lista){
            o.addItem(tpp);
        }
    }
}
