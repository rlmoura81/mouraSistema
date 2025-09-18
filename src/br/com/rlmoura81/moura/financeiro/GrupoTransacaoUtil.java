package br.com.rlmoura81.moura.financeiro;

import java.util.ArrayList;
import javax.swing.JComboBox;

public class GrupoTransacaoUtil {
    
    GrupoTransacaoRepository gptransr = new GrupoTransacaoRepository();
    
    /**
     * <p><strong>EN:</strong> Populates a JComboBox with purchase and sale transaction groups.</p>
     *
     * <p><strong>IT:</strong> Popola un JComboBox con i gruppi di transazione di acquisto e vendita.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche um JComboBox com os grupos de transação de compra e venda.</p>
     *
     * @param o EN: JComboBox to be populated | IT: JComboBox da popolare | PT-BR: JComboBox a ser preenchido
     * @since 1.0.0
     */    
    public void jcGpTransCompraVenda(JComboBox o){
        ArrayList<GrupoTransacao> lista = gptransr.getListaCompraVenda();
        GrupoTransacao gptZero = new GrupoTransacao(0, "<Transação>");
        o.addItem(gptZero);
        for(GrupoTransacao gpt : lista){
            o.addItem(gpt);
        }
    }
    
}
