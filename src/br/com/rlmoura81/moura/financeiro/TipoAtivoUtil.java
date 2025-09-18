package br.com.rlmoura81.moura.financeiro;

import java.util.ArrayList;
import javax.swing.JComboBox;

public class TipoAtivoUtil {
    
    TipoAtivoRepository tpativor = new TipoAtivoRepository();    

    /**
     * <p><strong>EN:</strong> Populates a JComboBox with all asset types.</p>
     * <p><strong>IT:</strong> Popola un JComboBox con tutti i tipi di attivo.</p>
     * <p><strong>PT-BR:</strong> Preenche um JComboBox com todos os tipos de ativo.</p>
     *
     * @param o EN: JComboBox to populate | IT: JComboBox da popolare | PT-BR: JComboBox a ser preenchido
     * @since 1.0.0
     */    
    public void jcTipoAtivo(JComboBox o){
        ArrayList<TipoAtivo> lista = tpativor.getLista();
        TipoAtivo tpaZero = new TipoAtivo(0, "<Tipo>");
        o.addItem(tpaZero);
        for(TipoAtivo tpa : lista){
            o.addItem(tpa);
        }
    }

    /**
     * <p><strong>EN:</strong> Populates a JComboBox with stock and REIT asset types (Ação/FII).</p>
     * <p><strong>IT:</strong> Popola un JComboBox con i tipi di attivo azionari e fondi immobiliari (Azione/FII).</p>
     * <p><strong>PT-BR:</strong> Preenche um JComboBox com os tipos de ativo Ação e FII.</p>
     *
     * @param o EN: JComboBox to populate | IT: JComboBox da popolare | PT-BR: JComboBox a ser preenchido
     * @since 1.0.0
     */
    public void jcTipoAtivoAcaoFii(JComboBox o){
        ArrayList<TipoAtivo> lista = tpativor.getListaTipoAtivoAcaoFII();
        TipoAtivo tpaZero = new TipoAtivo(0, "<Tipo>");
        o.addItem(tpaZero);
        for(TipoAtivo tpa : lista){
            o.addItem(tpa);
        }
    }
    
    /**
     * <p><strong>EN:</strong> Populates a JComboBox with fixed-income asset types (Renda Fixa).</p>
     * <p><strong>IT:</strong> Popola un JComboBox con i tipi di attivo a reddito fisso (Renda Fixa).</p>
     * <p><strong>PT-BR:</strong> Preenche um JComboBox com os tipos de ativo de Renda Fixa.</p>
     *
     * @param o EN: JComboBox to populate | IT: JComboBox da popolare | PT-BR: JComboBox a ser preenchido
     * @since 1.0.0
     */
    public void jcTipoAtivoRendaFixa(JComboBox o){
        ArrayList<TipoAtivo> lista = tpativor.getListaTipoRendaFixa();
        TipoAtivo tpaZero = new TipoAtivo(0, "<Tipo>");
        o.addItem(tpaZero);
        for(TipoAtivo tpa : lista){
            o.addItem(tpa);
        }
    }
}
