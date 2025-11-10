package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DespesaUtil {

    Despesa despesa = new Despesa();
    DespesaRepository despesar = new DespesaRepository();    
    ArrayList lista = new ArrayList();
   
    /**
     * <p><strong>EN:</strong> Calculates the total amount of all expenses by summing the values returned from the repository.</p>
     * <p><strong>IT:</strong> Calcola l’importo totale di tutte le spese sommando i valori restituiti dal repository.</p>
     * <p><strong>PT-BR:</strong> Calcula o valor total de todas as despesas somando os valores retornados pelo repositório.</p>
     *
     * @return EN: total expenses amount | IT: importo totale delle spese | PT-BR: valor total das despesas
     */
    public BigDecimal calculaDespesaTotal(){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = despesar.getLista();
        for(int i=0; i < lista.size(); i++){
            despesa = (Despesa)lista.get(i);
            resultado = resultado.add(despesa.getNm_valor());
        }
        return resultado;
    }
    
    /**
     * <p><strong>EN:</strong> Calculates the total amount of expenses for a specific group by summing the values filtered by the group code.</p>
     * <p><strong>IT:</strong> Calcola l’importo totale delle spese per uno specifico gruppo sommando i valori filtrati per codice gruppo.</p>
     * <p><strong>PT-BR:</strong> Calcula o valor total das despesas de um grupo específico somando os valores filtrados pelo código do grupo.</p>
     *
     * @param cd_grupo EN: group code to filter expenses | IT: codice del gruppo per filtrare le spese | PT-BR: código do grupo para filtrar as despesas
     * @return EN: total expenses amount for the group | IT: importo totale delle spese del gruppo | PT-BR: valor total das despesas do grupo
     */
    public BigDecimal calculaDespesaGrupo(int cd_grupo){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = despesar.getLista(cd_grupo);
        for(int i=0; i < lista.size(); i++){
            despesa = (Despesa)lista.get(i);
            resultado = resultado.add(despesa.getNm_valor());
        }
        return resultado;
    }
    
    /**
     * <p><strong>EN:</strong> Fills the combo box with all available expenses, adding a placeholder item as the first option.</p>
     * <p><strong>IT:</strong> Popola la combo box con tutte le spese disponibili, aggiungendo un elemento segnaposto come prima opzione.</p>
     * <p><strong>PT-BR:</strong> Preenche a combo box com todas as despesas disponíveis, adicionando um item placeholder como primeira opção.</p>
     *
     * @param o EN: target combo box to load | IT: combo box di destinazione da caricare | PT-BR: combo box de destino para carregar
     */
    public void jcDespesa(JComboBox o){
        ArrayList<Despesa> lista = despesar.getLista();
        Despesa depZero = new Despesa(0, "<Despesas>", null, null, null, 0);
        o.addItem(depZero);
        for(Despesa despesa : lista){
            o.addItem(despesa);
        }
    }

    /**
     * <p><strong>EN:</strong> Builds a table model with expense description, amount, provider, and category, and applies it to the given table.</p>
     * <p><strong>IT:</strong> Crea un modello di tabella con descrizione spesa, importo, fornitore e categoria, applicandolo alla tabella indicata.</p>
     * <p><strong>PT-BR:</strong> Monta um modelo de tabela com descrição, valor, prestador e categoria e aplica na tabela informada.</p>
     *
     * @param o EN: target table to display the expenses | IT: tabella di destinazione per visualizzare le spese | PT-BR: tabela de destino para exibir as despesas
     */
    public void tabelaDespesa(JTable o) {
        String[] nomeColuna = {"Despesa", "Valor", "Prestadora Serviço", "Categoria"};
        lista = despesar.getLista();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];

        for (int i = 0; i < lista.size(); i++) {
            despesa = (Despesa) lista.get(i);
            dadosArray[i][0] = despesa.getDs_despesa();
            dadosArray[i][1] = Utilidade.formatoValor.format(despesa.getNm_valor());
            dadosArray[i][2] = despesa.getEmpresa().getDs_empresa();
            dadosArray[i][3] = despesa.getCategoria().getDs_Categoria();
        }
        DefaultTableModel tDespesa = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tDespesa);
    }

    /**
     * <p><strong>EN:</strong> Returns the expense object corresponding to the selected row in the table; shows an info message if nothing is selected.</p>
     * <p><strong>IT:</strong> Restituisce l’oggetto spesa corrispondente alla riga selezionata nella tabella; mostra un messaggio informativo se nulla è selezionato.</p>
     * <p><strong>PT-BR:</strong> Retorna o objeto de despesa referente à linha selecionada na tabela; exibe uma mensagem informativa se nada estiver selecionado.</p>
     *
     * @param o EN: source table to read the selection from | IT: tabella sorgente da cui leggere la selezione | PT-BR: tabela de origem para ler a seleção
     * @return EN: selected expense or null | IT: spesa selezionata o null | PT-BR: despesa selecionada ou null
     */
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecianda = o.getSelectedRow();
        if(linhaselecianda >= 0) {
            selecionado = lista.get(linhaselecianda);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma despesa");
        }
        return selecionado;
    }
}
