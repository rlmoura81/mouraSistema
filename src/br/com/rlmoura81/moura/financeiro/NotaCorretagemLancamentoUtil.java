package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class NotaCorretagemLancamentoUtil {
    
    NotaCorretagemLancamento notalanc = new NotaCorretagemLancamento();
    NotaCorretagemLancamentoRepository notalancr = new NotaCorretagemLancamentoRepository();        
    ArrayList lista = new ArrayList();

    /**
     * <p><strong>EN:</strong> Builds the brokerage note lines table for a given note ID.</p>
     *
     * <p><strong>IT:</strong> Costruisce la tabella delle righe della nota di intermediazione per un dato ID nota.</p>
     *
     * <p><strong>PT-BR:</strong> Monta a tabela de lançamentos da nota de corretagem para um ID de nota informado.</p>
     *
     * @param o EN: target JTable to populate | IT: JTable di destinazione da popolare | PT-BR: JTable de destino a ser preenchida
     * @param cd_nota EN: brokerage note ID used to filter entries | IT: ID della nota di intermediazione per filtrare le righe | PT-BR: ID da nota de corretagem para filtrar os lançamentos
     * @since 1.0.0
     */
    public void tabelaNotaCorretagemLancamento(JTable o, int cd_nota){
        String[] nomeColuna = {"Numero Nota", "Ativo", "Qtde", "Valor", "Transação"};
        lista = notalancr.getLista(cd_nota);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for(int i=0; i < lista.size(); i++){
            notalanc = (NotaCorretagemLancamento)lista.get(i);
            dadosArray[i][0] = notalanc.getNota().getNm_nota();
            dadosArray[i][1] = notalanc.getAtivo().getDs_ativo();
            dadosArray[i][2] = notalanc.getNm_qtde();
            dadosArray[i][3] = Utilidade.formatoValor.format(notalanc.getNm_valor());
            dadosArray[i][4] = notalanc.getGptrans().getDs_gptrans();
        }
        DefaultTableModel tPoupap = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tPoupap);
    }

    /**
     * <p><strong>EN:</strong> Returns the object corresponding to the selected table row.</p>
     *
     * <p><strong>IT:</strong> Restituisce l'oggetto corrispondente alla riga selezionata nella tabella.</p>
     *
     * <p><strong>PT-BR:</strong> Retorna o objeto correspondente à linha selecionada na tabela.</p>
     *
     * @param o EN: source JTable from which to read the selection | IT: JTable sorgente da cui leggere la selezione | PT-BR: JTable de origem de onde ler a seleção
     * @return EN: selected list item or null if none selected | IT: elemento selezionato o null se nessuno selezionato | PT-BR: item selecionado ou null se nada for selecionado
     * @since 1.0.0
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
