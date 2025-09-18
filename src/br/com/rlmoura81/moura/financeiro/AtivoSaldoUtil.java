package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AtivoSaldoUtil {    
    
    AtivoSaldo asaldo = new AtivoSaldo();
    AtivoSaldoRepository asaldor = new AtivoSaldoRepository();    
    ArrayList lista = new ArrayList();

    /**
     * <p><strong>EN:</strong> Computes the updated balance based on the transaction type
     * (5 = add quantity; 6 = subtract quantity).</p>
     * <p><strong>IT:</strong> Calcola il saldo aggiornato in base al tipo di transazione
     * (5 = aggiunge quantità; 6 = sottrae quantità).</p>
     * <p><strong>PT-BR:</strong> Calcula o saldo atualizado conforme o tipo de transação
     * (5 = soma quantidade; 6 = subtrai quantidade).</p>
     *
     * @param trans EN: transaction code (5 add, 6 subtract) | IT: codice transazione (5 aggiunge, 6 sottrae) | PT-BR: código da transação (5 soma, 6 subtrai)
     * @param nm_saldo EN: current balance | IT: saldo attuale | PT-BR: saldo atual
     * @param nm_qtde EN: quantity to apply | IT: quantità da applicare | PT-BR: quantidade a aplicar
     * @return EN: updated balance | IT: saldo aggiornato | PT-BR: saldo atualizado
     */
    public int atualizaSaldo(int trans, int nm_saldo, int nm_qtde){
        int resultado = 0;
        if(trans == 5){
            resultado = nm_saldo + nm_qtde;
        }
        if(trans == 6){
            resultado = nm_saldo - nm_qtde;
        }
        return resultado;       
    }
    
    /**
     * <p><strong>EN:</strong> Calculates total income by multiplying the unit price by the quantity.</p>
     * <p><strong>IT:</strong> Calcola il reddito totale moltiplicando il prezzo unitario per la quantità.</p>
     * <p><strong>PT-BR:</strong> Calcula a renda total multiplicando o preço unitário pela quantidade.</p>
     *
     * @param nm_qtde EN: quantity | IT: quantità | PT-BR: quantidade
     * @param vl_preco EN: unit price | IT: prezzo unitario | PT-BR: preço unitário
     * @return EN: total income (quantity × unit price) | IT: reddito totale (quantità × prezzo unitario) | PT-BR: renda total (quantidade × preço unitário)
     */
    public BigDecimal rendaTotal(int nm_qtde, BigDecimal vl_preco){
        BigDecimal resultado = null;
        resultado = vl_preco.multiply(new BigDecimal(nm_qtde));
        return resultado;
    }
    
    /**
     * <p><strong>EN:</strong> Fills a JTable with asset balances filtered by asset type.
     * Columns: Asset, Quantity. Uses a repository list and formats the quantity.</p>
     * <p><strong>IT:</strong> Popola una JTable con i saldi degli attivi filtrati per tipo di attivo.
     * Colonne: Attivo, Quantità. Usa l’elenco del repository e formatta la quantità.</p>
     * <p><strong>PT-BR:</strong> Preenche uma JTable com saldos de ativos filtrados por tipo de ativo.
     * Colunas: Ativo, Quantidade. Usa a lista do repositório e formata a quantidade.</p>
     *
     * @param o EN: target JTable to populate | IT: JTable di destinazione da popolare | PT-BR: JTable de destino a ser preenchida
     * @param cd_tpativo EN: asset type ID filter | IT: ID del tipo di attivo | PT-BR: ID do tipo de ativo
     */
    public void tabelaAtivoSaldo(JTable o, int cd_tpativo){
        String[] nomeColuna = {"Ativo", "Quantidade"};
        lista = asaldor.getLista(cd_tpativo);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        
        for(int i=0; i < lista.size(); i++){
            asaldo = (AtivoSaldo)lista.get(i);
            dadosArray[i][0] = asaldo.getAtivo();
            dadosArray[i][1] = Utilidade.formatoValor.format(asaldo.getNm_qtde());
        }
        DefaultTableModel tPoupap = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tPoupap);
    }

    /**
     * <p><strong>EN:</strong> Returns the object corresponding to the currently selected row in the JTable,
     * or shows an information message if nothing is selected.</p>
     * <p><strong>IT:</strong> Restituisce l’oggetto corrispondente alla riga selezionata nella JTable,
     * oppure mostra un messaggio informativo se nulla è selezionato.</p>
     * <p><strong>PT-BR:</strong> Retorna o objeto correspondente à linha selecionada na JTable,
     * ou exibe uma mensagem informativa se nada estiver selecionado.</p>
     *
     * @param o EN: JTable from which to read the selection | IT: JTable da cui leggere la selezione | PT-BR: JTable da qual ler a seleção
     * @return EN: selected list item or null | IT: elemento selezionato della lista o null | PT-BR: item selecionado da lista ou null
     */
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um item da lista.");
        }
        return selecionado;    
    }  
}
