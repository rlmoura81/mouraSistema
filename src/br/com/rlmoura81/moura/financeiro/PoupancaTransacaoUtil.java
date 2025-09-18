package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PoupancaTransacaoUtil {
    
    PoupancaTransacao pouptr = new PoupancaTransacao();
    PoupancaTransacaoRepository pouptrr = new PoupancaTransacaoRepository();    
    ArrayList lista = new ArrayList();
    
    /**
     * <p><strong>EN:</strong> Updates the savings balance based on the transaction type.</p>
     *
     * <p><strong>IT:</strong> Aggiorna il saldo del risparmio in base al tipo di transazione.</p>
     *
     * <p><strong>PT-BR:</strong> Atualiza o saldo da poupança conforme o tipo de transação.</p>
     *
     * @param num EN: 0 = add, 1 = subtract | IT: 0 = aggiungi, 1 = sottrai | PT-BR: 0 = soma, 1 = subtração
     * @param vl_saldo EN: current balance | IT: saldo attuale | PT-BR: saldo atual
     * @param vl_transacao EN: transaction value | IT: valore della transazione | PT-BR: valor da transação
     * @return EN: updated balance | IT: saldo aggiornato | PT-BR: saldo atualizado
     * @since 1.0.0
     */
    public BigDecimal atualizaSaldo (int num, BigDecimal vl_saldo, BigDecimal vl_transacao){
        BigDecimal resultado = null;
        if(num == 0){
            resultado = (vl_saldo.add(vl_transacao));
        }
        if(num == 1){
            resultado = (vl_saldo.subtract(vl_transacao));
        }
        return resultado;
    }
    
    /**
     * <p><strong>EN:</strong> Loads and displays savings transactions in a JTable.</p>
     *
     * <p><strong>IT:</strong> Carica e visualizza le transazioni di risparmio in una JTable.</p>
     *
     * <p><strong>PT-BR:</strong> Carrega e exibe as transações da poupança em uma JTable.</p>
     *
     * @param o EN: target JTable | IT: JTable di destinazione | PT-BR: JTable de destino
     * @param poupanca EN: savings account ID | IT: ID del conto di risparmio | PT-BR: ID da conta poupança
     * @since 1.0.0
     */
    public void tabelaPoupancaTransacao(JTable o, int poupanca){
        String[] nomeColuna = {"Valor Transação", "Data Transação", "Transação"};
        lista = pouptrr.getLista();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        
        for(int i=0; i < lista.size(); i++){
            pouptr = (PoupancaTransacao)lista.get(i);
            dadosArray[i][0] = Utilidade.formatoValor.format(pouptr.getVl_transacao());
            dadosArray[i][1] = Utilidade.formatoData.format(pouptr.getDt_transacao().getTime());
            dadosArray[i][2] = pouptr.getGptrans();
        }
        DefaultTableModel tPoupap = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tPoupap);
    }

    /**
     * <p><strong>EN:</strong> Retrieves the selected object from the JTable.</p>
     *
     * <p><strong>IT:</strong> Recupera l'oggetto selezionato dalla JTable.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera o objeto selecionado da JTable.</p>
     *
     * @param o EN: JTable component containing the selection | 
     *          IT: Componente JTable contenente la selezione | 
     *          PT-BR: Componente JTable contendo a seleção
     * @return EN: selected object from the list | IT: oggetto selezionato dalla lista | PT-BR: objeto selecionado da lista
     * @since 1.0.0
     */
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma aplicação da lista.");
        }
        return selecionado;    
    }
}
