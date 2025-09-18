package br.com.rlmoura81.moura.financeiro;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FundoInvestimentoUtil {
    
    FundoInvestimento fdinvest = new FundoInvestimento();
    FundoInvestimentoRepository fdinvestr = new FundoInvestimentoRepository();    
    ArrayList lista = new ArrayList();

    /**
     * <p><strong>EN:</strong> Populates a combo box with investment funds by ID.</p>
     *
     * <p><strong>IT:</strong> Popola una casella combinata con i fondi di investimento per ID.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche um combo box com fundos de investimento por ID.</p>
     *
     * @param o EN: combo box component | IT: componente casella combinata | PT-BR: componente combo box
     * @param fundo EN: investment fund ID used to filter results | IT: ID del fondo di investimento usato per filtrare i risultati | PT-BR: ID do fundo de investimento usado para filtrar os resultados
     * @since 1.0.0
     */
    public void jcFdInvest(JComboBox o, int fundo){
        ArrayList<FundoInvestimento> lista = fdinvestr.getListaFundoInvest(fundo);
        FundoInvestimento fiZero = new FundoInvestimento(0, "<Investimento>", null, 0);
        o.addItem(fiZero);
        for(FundoInvestimento fi : lista){
            o.addItem(fi);
        }
    }

    /**
     * <p><strong>EN:</strong> Populates a combo box with investment funds not linked to a specific account.</p>
     *
     * <p><strong>IT:</strong> Popola una casella combinata con fondi di investimento non collegati a un conto specifico.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche um combo box com fundos de investimento não vinculados a uma conta específica.</p>
     *
     * @param o EN: combo box component | IT: componente casella combinata | PT-BR: componente combo box
     * @param conta EN: account ID used as filter | IT: ID del conto usato come filtro | PT-BR: ID da conta usado como filtro
     * @since 1.0.0
     */
    public void jcFdInvestFiltro(JComboBox o, int conta){
        ArrayList<FundoInvestimento> lista = fdinvestr.getListaFundoInvestAplic(conta);
        FundoInvestimento fiZero = new FundoInvestimento(0, "<Tipo>", null, 0);
        o.addItem(fiZero);
        for(FundoInvestimento fi : lista){
            o.addItem(fi);
        }
    }
    
    /**
     * <p><strong>EN:</strong> Builds a table model with the list of investment funds.</p>
     *
     * <p><strong>IT:</strong> Crea un modello di tabella con l'elenco dei fondi di investimento.</p>
     *
     * <p><strong>PT-BR:</strong> Monta um modelo de tabela com a lista de fundos de investimento.</p>
     *
     * @param o EN: table component where data will be displayed | IT: componente tabella in cui verranno mostrati i dati | PT-BR: componente tabela onde os dados serão exibidos
     * @since 1.0.0
     */
    public void tabelaFundoInvestimento(JTable o){
        String[]nomeColuna = {"Fundo", "Tipo"};
        lista = fdinvestr.getLista();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for(int i = 0; i < lista.size(); i++){
            fdinvest = (FundoInvestimento) lista.get(i);
            dadosArray[i][0] = fdinvest.getGpfundo();
            dadosArray[i][1] = fdinvest.getDs_fdinvest();
        }
        DefaultTableModel tPoupanca = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tPoupanca);        
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves the selected investment fund from the table.</p>
     *
     * <p><strong>IT:</strong> Recupera il fondo di investimento selezionato dalla tabella.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera o fundo de investimento selecionado da tabela.</p>
     *
     * @param o EN: table component with selectable rows | IT: componente tabella con righe selezionabili | PT-BR: componente tabela com linhas selecionáveis
     * @return EN: selected investment fund object or null if no row is selected | IT: oggetto fondo selezionato o null se nessuna riga è selezionata | PT-BR: objeto fundo selecionado ou null se nenhuma linha estiver selecionada
     * @since 1.0.0
     */
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um fundo de investimento da lista.");
        }
        return selecionado;
    }  
    
}
