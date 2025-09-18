package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PoupancaAplicacaoUtil {
    
    PoupancaAplicacao poupap = new PoupancaAplicacao();
    PoupancaAplicacaoRepository poupapr = new PoupancaAplicacaoRepository();    
    ArrayList lista = new ArrayList();
    
    /**
     * <p><strong>EN:</strong> Updates the savings balance based on the index value.</p>
     *
     * <p><strong>IT:</strong> Aggiorna il saldo del risparmio in base al valore dell'indice.</p>
     *
     * <p><strong>PT-BR:</strong> Atualiza o saldo da poupança com base no valor do índice.</p>
     *
     * @param vl_saldo EN: current savings balance | IT: saldo attuale del risparmio | PT-BR: saldo atual da poupança
     * @param vl_indice EN: index value applied | IT: valore dell'indice applicato | PT-BR: valor do índice aplicado
     * @return EN: updated balance | IT: saldo aggiornato | PT-BR: saldo atualizado
     * @since 1.0.0
     */
    public BigDecimal atualizaSaldoIndice (BigDecimal vl_saldo, BigDecimal vl_indice){
        BigDecimal resultado = null;
        resultado = ((vl_saldo.multiply(vl_indice)).divide(Utilidade.converter("100,00"))).add(vl_saldo);
        return resultado;
    }
        
    /**
     * <p><strong>EN:</strong> Builds and populates a table with savings applications for the given savings account.</p>
     *
     * <p><strong>IT:</strong> Crea e popola una tabella con le applicazioni di risparmio per il conto di risparmio indicato.</p>
     *
     * <p><strong>PT-BR:</strong> Monta e preenche uma tabela com as aplicações de poupança da conta informada.</p>
     *
     * @param o EN: table to be populated | IT: tabella da popolare | PT-BR: tabela a ser preenchida
     * @param cd_poupanca EN: savings account ID | IT: ID del conto di risparmio | PT-BR: ID da conta de poupança
     * @since 1.0.0
     */
    public void tabelaPoupancaAplicacao(JTable o, int cd_poupanca){
        String[] nomeColuna = {"Saldo", "Data"};
        lista = poupapr.getLista(cd_poupanca);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        
        for(int i=0; i < lista.size(); i++){
            poupap = (PoupancaAplicacao)lista.get(i);
            dadosArray[i][0] = Utilidade.formatoValor.format(poupap.getVl_saldo());
            dadosArray[i][1] = Utilidade.formatoData.format(poupap.getDt_saldo().getTime());
        }
        DefaultTableModel tPoupap = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tPoupap);
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves the selected savings application from the table.</p>
     *
     * <p><strong>IT:</strong> Recupera l'applicazione di risparmio selezionata dalla tabella.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera a aplicação de poupança selecionada na tabela.</p>
     *
     * @param o EN: JTable component with the selection | IT: componente JTable con la selezione | PT-BR: componente JTable com a seleção
     * @return EN: selected savings application object | IT: oggetto dell'applicazione di risparmio selezionata | PT-BR: objeto da aplicação de poupança selecionada
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
