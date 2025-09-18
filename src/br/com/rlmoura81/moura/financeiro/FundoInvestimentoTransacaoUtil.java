package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FundoInvestimentoTransacaoUtil {
    
    FundoInvestimentoTransacao fit = new FundoInvestimentoTransacao();
    FundoInvestimentoTransacaoRepository fitr = new FundoInvestimentoTransacaoRepository();    
    ArrayList lista = new ArrayList();

    /**
     * <p><strong>EN:</strong> Builds a table model with fund investment transactions.</p>
     *
     * <p><strong>IT:</strong> Crea un modello di tabella con le transazioni di fondi di investimento.</p>
     *
     * <p><strong>PT-BR:</strong> Monta um modelo de tabela com as transações de fundos de investimento.</p>
     *
     * @param o EN: table component where data will be displayed | IT: componente tabella in cui verranno mostrati i dati | PT-BR: componente tabela onde os dados serão exibidos
     * @param fdinvestaplic EN: investment application ID | IT: ID dell'applicazione di investimento | PT-BR: ID da aplicação de investimento
     * @param conta EN: account ID | IT: ID del conto | PT-BR: ID da conta
     * @return EN: fills the JTable with investment transactions | IT: compila la JTable con le transazioni di investimento | PT-BR: preenche a JTable com as transações de investimento
     * @since 1.0.0
     */    
    public void tabelaFundoInvestimentoTransacao(JTable o, int fdinvestaplic, int conta){
        String[] nomeColuna = {"Valor", "Data", "Tipo"};
        lista = fitr.getListaFdInvestTrans(fdinvestaplic, conta);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        
        for(int i=0; i < lista.size(); i++){
            fit = (FundoInvestimentoTransacao)lista.get(i);
            dadosArray[i][0] = Utilidade.formatoValor.format(fit.getVl_transacao());
            dadosArray[i][1] = Utilidade.formatoData.format(fit.getDt_transacao().getTime());
            dadosArray[i][2] = fit.getGptrans();
        }
        DefaultTableModel tFdInvestTrans = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tFdInvestTrans);
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves the selected object from the investment transactions table.</p>
     *
     * <p><strong>IT:</strong> Recupera l'oggetto selezionato dalla tabella delle transazioni di investimento.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera o objeto selecionado da tabela de transações de investimento.</p>
     *
     * @param o EN: table component with selectable rows | IT: componente tabella con righe selezionabili | PT-BR: componente tabela com linhas selecionáveis
     * @return EN: selected object or null if no row is selected | IT: oggetto selezionato o null se nessuna riga è selezionata | PT-BR: objeto selecionado ou null se nenhuma linha estiver selecionada
     * @since 1.0.0
     */
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um Fundo de Investimento da lista.");
        }
        return selecionado;    
    } 
    
}
