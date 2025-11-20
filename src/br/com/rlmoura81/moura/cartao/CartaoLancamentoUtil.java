package br.com.rlmoura81.moura.cartao;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CartaoLancamentoUtil {
    
    CartaoLancamento cartaolanc = new CartaoLancamento();
    CartaoLancamentoRepository cartaolancr = new CartaoLancamentoRepository();    
    ArrayList lista = new ArrayList();

    /**
     * <p><strong>EN:</strong> Calculates the total invoice amount for the specified card by summing all its transactions.</p>
     *
     * <p><strong>IT:</strong> Calcola l'importo totale della fattura per la carta specificata sommando tutte le sue transazioni.</p>
     *
     * <p><strong>PT-BR:</strong> Calcula o valor total da fatura para o cartão informado somando todos os seus lançamentos.</p>
     *
     * @param cd_cartao EN: card identifier | IT: identificatore della carta | PT-BR: identificador do cartão
     * @return EN: total amount as BigDecimal | IT: importo totale come BigDecimal | PT-BR: valor total como BigDecimal
     * @since 1.0.0
     */    
    public BigDecimal calculaValorFatura(int cd_cartao){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = cartaolancr.getLista(cd_cartao);
        for(int i=0; i < lista.size(); i++){
            cartaolanc = (CartaoLancamento)lista.get(i);
            resultado = resultado.add(cartaolanc.getNm_valor());
        }
        return resultado;
    }

    /**
     * <p><strong>EN:</strong> Populates a JTable with the card transactions (CartaoLancamento) for the specified card, formatting them into columns.</p>
     *
     * <p><strong>IT:</strong> Popola una JTable con le transazioni della carta (CartaoLancamento) per la carta specificata, formattandole in colonne.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche uma JTable com os lançamentos de cartão (CartaoLancamento) do cartão informado, formatando-os em colunas.</p>
     *
     * @param o EN: JTable to be populated | IT: JTable da popolare | PT-BR: JTable a ser preenchida
     * @param cd_cartao EN: card identifier | IT: identificatore della carta | PT-BR: identificador do cartão
     * @since 1.0.0
     */    
    public void tabelaCartaoLancamento(JTable o, int cd_cartao){
        String[] nomeColuna = {"Data Despesa", "Descrição", "Valor", "Qtde Parcela", "Categoria"};
        lista = cartaolancr.getLista(cd_cartao);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        for(int i=0; i < lista.size(); i++){
            cartaolanc = (CartaoLancamento)lista.get(i);
            dadosArray[i][0] = Utilidade.formatoData.format(cartaolanc.getDt_despesa().getTime());
            dadosArray[i][1] = cartaolanc.getDs_despesa();
            dadosArray[i][2] = Utilidade.formatoValor.format(cartaolanc.getNm_valor());
            dadosArray[i][3] = cartaolanc.getNm_parcela();
            dadosArray[i][4] = cartaolanc.getCategoria().getDs_Categoria();
        }
        DefaultTableModel tCartaoLanc = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tCartaoLanc);
    }

    /**
     * <p><strong>EN:</strong> Retrieves the object corresponding to the selected row in the JTable.  
     * Displays an information dialog if no row is selected.</p>
     *
     * <p><strong>IT:</strong> Recupera l'oggetto corrispondente alla riga selezionata nella JTable.  
     * Mostra una finestra di dialogo informativa se non viene selezionata alcuna riga.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera o objeto correspondente à linha selecionada na JTable.  
     * Exibe uma mensagem informativa se nenhuma linha for selecionada.</p>
     *
     * @param o EN: JTable from which to retrieve the selected object | IT: JTable da cui recuperare l'oggetto selezionato | PT-BR: JTable de onde recuperar o objeto selecionado
     * @return EN: selected object or null if none is selected | IT: oggetto selezionato o null se nessuno è selezionato | PT-BR: objeto selecionado ou null se nenhum for selecionado
     * @since 1.0.0
     */
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um lançamento da lista.", "Cartão Lançamento", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;    
    }     

}
