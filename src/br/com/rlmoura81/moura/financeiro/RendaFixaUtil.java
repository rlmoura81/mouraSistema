package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RendaFixaUtil {
    
    RendaFixa rendafixa = new RendaFixa();
    RendaFixaRepository rendafixar = new RendaFixaRepository();    
    ArrayList lista = new ArrayList();

    /**
     * <p><strong>EN:</strong> Builds and loads the Fixed Income table with all records from the database.</p>
     * <p><strong>IT:</strong> Costruisce e carica la tabella dei Redditi Fissi con tutti i record dal database.</p>
     * <p><strong>PT-BR:</strong> Monta e carrega a tabela de Renda Fixa com todos os registros do banco de dados.</p>
     *
     * @param o EN: JTable to be filled with data |
     *          IT: JTable da riempire con i dati |
     *          PT-BR: JTable a ser preenchida com os dados
     * @since 1.0.0
     */
    public void tabelaRendaFixa(JTable o){
        String[]nomeColuna = {"Tipo", "Renda Fixa", "Valor Aplicado", "Taxa", "Data Aplicado", "Data de vencimento"};
        lista = rendafixar.getLista();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for(int i = 0; i < lista.size(); i++){
            rendafixa = (RendaFixa) lista.get(i);
            dadosArray[i][0] = rendafixa.getTipoativo();
            dadosArray[i][1] = rendafixa.getDs_rendafixa();
            dadosArray[i][2] = Utilidade.formatoValor.format(rendafixa.getVl_aplicado());
            dadosArray[i][3] = Utilidade.formatoValor.format(rendafixa.getVl_taxa()) + " + " + rendafixa.getIndice().getDs_indice();
            dadosArray[i][4] = Utilidade.formatoData.format(rendafixa.getDt_aplicacao().getTime());
            dadosArray[i][5] = Utilidade.formatoData.format(rendafixa.getDt_vencimento().getTime());
        }
        DefaultTableModel tRendaFixa = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tRendaFixa);
    }

    /**
     * <p><strong>EN:</strong> Returns the object selected from the Fixed Income table.</p>
     * <p><strong>IT:</strong> Restituisce l'oggetto selezionato dalla tabella dei Redditi Fissi.</p>
     * <p><strong>PT-BR:</strong> Retorna o objeto selecionado da tabela de Renda Fixa.</p>
     *
     * @param o EN: JTable with the selected row |
     *          IT: JTable con la riga selezionata |
     *          PT-BR: JTable com a linha selecionada
     * @return EN: Selected object or null if no row is selected |
     *         IT: Oggetto selezionato o null se nessuna riga è selezionata |
     *         PT-BR: Objeto selecionado ou null se nenhuma linha estiver selecionada
     * @since 1.0.0
     */
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma renda fixa da lista.");
        }
        return selecionado;
    }     
}
