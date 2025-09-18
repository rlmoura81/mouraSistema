package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FundoInvestimentoAplicacaoUtil {
    
    FundoInvestimentoAplicacao fia = new FundoInvestimentoAplicacao();
    FundoInvestimentoAplicacaoRepository fiar = new FundoInvestimentoAplicacaoRepository();    
    ArrayList lista = new ArrayList();
    
    /**
     * <p><strong>EN:</strong> Builds and displays the investment fund application table with balance values.</p>
     *
     * <p><strong>IT:</strong> Crea e visualizza la tabella delle applicazioni di fondi d'investimento con i valori del saldo.</p>
     *
     * <p><strong>PT-BR:</strong> Monta e exibe a tabela de aplicações de fundos de investimento com os valores de saldo.</p>
     *
     * @param o EN: table to display data | IT: tabella per visualizzare i dati | PT-BR: tabela para exibir os dados
     * @param num EN: account identifier used to filter applications | IT: identificatore del conto usato per filtrare le applicazioni | PT-BR: identificador da conta usado para filtrar as aplicações
     * @return EN: table populated with fund applications | IT: tabella popolata con le applicazioni di fondi | PT-BR: tabela preenchida com as aplicações de fundos
     * @since 1.0.0
     */
    public void tabelaFundoInvestimentoAplicacao(JTable o, int num){
        String[] nomeColuna = {"Fundo", "Saldo"};
        lista = fiar.getListaFundoInvest(num);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        
        for(int i=0; i < lista.size(); i++){
            fia = (FundoInvestimentoAplicacao)lista.get(i);
            dadosArray[i][0] = fia.getFdinvest();
            dadosArray[i][1] = Utilidade.formatoValor.format(fia.getVl_saldo());
        }
        DefaultTableModel tPoupap = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tPoupap);
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves the selected object from the investment fund application table.</p>
     *
     * <p><strong>IT:</strong> Recupera l'oggetto selezionato dalla tabella delle applicazioni di fondi d'investimento.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera o objeto selecionado da tabela de aplicações de fundos de investimento.</p>
     *
     * @param o EN: table containing the records | IT: tabella contenente i record | PT-BR: tabela que contém os registros
     * @return EN: selected object or <code>null</code> if none selected | IT: oggetto selezionato o <code>null</code> se nessuno è selezionato | PT-BR: objeto selecionado ou <code>null</code> se nenhum for selecionado
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
