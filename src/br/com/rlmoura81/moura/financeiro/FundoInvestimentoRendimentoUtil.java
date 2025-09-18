package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FundoInvestimentoRendimentoUtil {
    
    FundoInvestimentoRendimento fir = new FundoInvestimentoRendimento();
    FundoInvestimentoRendimentoRepository firr = new FundoInvestimentoRendimentoRepository();        
    ArrayList lista = new ArrayList();

    /**
     * <p><strong>EN:</strong> Populates a table with yields from investment funds for a given application.</p>
     *
     * <p><strong>IT:</strong> Popola una tabella con i rendimenti dei fondi d’investimento per una specifica applicazione.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche uma tabela com os rendimentos dos fundos de investimento para uma determinada aplicação.</p>
     *
     * @param o EN: table to be filled | IT: tabella da popolare | PT-BR: tabela a ser preenchida
     * @param num EN: identifier of the investment application | IT: identificatore dell'applicazione di investimento | PT-BR: identificador da aplicação de investimento
     * @return EN: no direct return; updates table model | IT: nessun valore restituito; aggiorna il modello della tabella | PT-BR: sem retorno direto; atualiza o modelo da tabela
     * @since 1.0.0
     */    
    public void tabelaFundoInvestimentoRendimento(JTable o, int num){
        String[] nomeColuna = {"Data", "Rendimento"};
        lista = firr.getListaRendimento(num);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for(int i=0; i < lista.size(); i++){
            fir = (FundoInvestimentoRendimento)lista.get(i);
            dadosArray[i][0] = Utilidade.formatoData.format(fir.getDt_rendimento().getTime());
            dadosArray[i][1] = Utilidade.formatoValor.format(fir.getVl_rendimento());
        }
        DefaultTableModel tFdInvestRend = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tFdInvestRend);
    }
        
    /**
     * <p><strong>EN:</strong> Retrieves the selected yield object from the table.</p>
     *
     * <p><strong>IT:</strong> Recupera l’oggetto rendimento selezionato dalla tabella.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera o objeto rendimento selecionado da tabela.</p>
     *
     * @param o EN: table with selectable items | IT: tabella con elementi selezionabili | PT-BR: tabela com itens selecionáveis
     * @return EN: selected object or null if none selected | IT: oggetto selezionato o null se non selezionato | PT-BR: objeto selecionado ou null se nenhum selecionado
     * @since 1.0.0
     */
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um rendimento da lista.");
        }
        return selecionado;    
    }
}
