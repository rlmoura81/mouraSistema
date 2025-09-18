package br.com.rlmoura81.moura.financeiro;

import java.util.ArrayList;
import javax.swing.JComboBox;

public class TipoTransacaoUtil {
    
    TipoTransacaoRepository tptransr = new TipoTransacaoRepository();    

    /**
     * <p><strong>EN:</strong> Populates a JComboBox with the complete list of transaction types (TipoTransacao).</p>
     * <p><strong>IT:</strong> Popola un JComboBox con l'elenco completo dei tipi di transazione (TipoTransacao).</p>
     * <p><strong>PT-BR:</strong> Preenche um JComboBox com a lista completa de tipos de transação (TipoTransacao).</p>
     *
     * @param o EN: JComboBox to populate |
     *          IT: JComboBox da popolare |
     *          PT-BR: JComboBox a ser preenchido
     */
    public void jcTpTransacao(JComboBox o){
        ArrayList<TipoTransacao> lista = tptransr.getLista();
        TipoTransacao tptZero = new TipoTransacao(0, "<Transação>", null);
        o.addItem(tptZero);
        for(TipoTransacao tpt : lista){
            o.addItem(tpt);
        }
    }

    /**
     * <p><strong>EN:</strong> Populates a JComboBox with transaction types (TipoTransacao) filtered by a specific transaction group.</p>
     * <p><strong>IT:</strong> Popola un JComboBox con i tipi di transazione (TipoTransacao) filtrati per un gruppo di transazioni specifico.</p>
     * <p><strong>PT-BR:</strong> Preenche um JComboBox com os tipos de transação (TipoTransacao) filtrados por um grupo específico de transações.</p>
     *
     * @param o EN: JComboBox to populate |
     *          IT: JComboBox da popolare |
     *          PT-BR: JComboBox a ser preenchido
     *
     * @param cd_gptrans EN: Transaction group ID used as filter |
     *                   IT: ID del gruppo di transazioni usato come filtro |
     *                   PT-BR: ID do grupo de transações usado como filtro
     */
    public void jcTpTransCredDeb(JComboBox o, int cd_gptrans){
        ArrayList<TipoTransacao> lista = tptransr.getLista(cd_gptrans);
        TipoTransacao tptZero = new TipoTransacao(0, "<Transação>", null);
        o.addItem(tptZero);
        for(TipoTransacao tpt : lista){
            o.addItem(tpt);
        }
    }    
}
