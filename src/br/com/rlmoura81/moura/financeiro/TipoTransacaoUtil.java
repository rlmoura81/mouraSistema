package br.com.rlmoura81.moura.financeiro;

import java.util.ArrayList;
import javax.swing.JComboBox;

public class TipoTransacaoUtil {
    
    TipoTransacaoRepository tptransr = new TipoTransacaoRepository();    

    public void jcTpTransacao(JComboBox o){
        ArrayList<TipoTransacao> lista = tptransr.getLista();
        TipoTransacao tptZero = new TipoTransacao(0, "<Transação>", null);
        o.addItem(tptZero);
        for(TipoTransacao tpt : lista){
            o.addItem(tpt);
        }
    }

    public void jcTpTransCredDeb(JComboBox o, int cd_gptrans){
        ArrayList<TipoTransacao> lista = tptransr.getLista(cd_gptrans);
        TipoTransacao tptZero = new TipoTransacao(0, "<Transação>", null);
        o.addItem(tptZero);
        for(TipoTransacao tpt : lista){
            o.addItem(tpt);
        }
    }    
}
