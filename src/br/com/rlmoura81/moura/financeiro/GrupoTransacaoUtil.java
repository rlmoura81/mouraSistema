package br.com.rlmoura81.moura.financeiro;

import java.util.ArrayList;
import javax.swing.JComboBox;

public class GrupoTransacaoUtil {
    
    GrupoTransacao gptrans = new GrupoTransacao();
    GrupoTransacaoRepository gptransr = new GrupoTransacaoRepository();
    
    ArrayList lista = new ArrayList();
    
    public void jcGpTransCompraVenda(JComboBox o){
        ArrayList<GrupoTransacao> lista = gptransr.getListaCompraVenda();
        GrupoTransacao gptZero = new GrupoTransacao(0, "<Transação>");
        o.addItem(gptZero);
        for(GrupoTransacao gpt : lista){
            o.addItem(gpt);
        }
    }
    
}
