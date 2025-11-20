package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.awt.Component;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JList;
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
     * EM TESTE - COLOCAR COMENTARIO
     * CALCULA A DESPESA TOTAL POR MES
    */
    public BigDecimal calculaDespesaTotalMes(){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = despesar.getLista();
        for(int i=0; i < lista.size(); i++){
            despesa = (Despesa)lista.get(i);
            resultado = resultado.add(despesa.getNm_valor());
        }
        return resultado;
    }

    /**
     * EM TESTE - COLOCAR COMENTARIO
     * CALCULA A DESPESA TOTAL DO MES
    */
    public BigDecimal calculaDespesaTotalDoMes(){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = despesar.getListaPlano(0);
        for(int i=0; i < lista.size(); i++){
            despesa = (Despesa)lista.get(i);
            resultado = resultado.add(despesa.getNm_valor());
        }
        return resultado;
    }

        /**
     * EM TESTE - COLOCAR COMENTARIO
     * CALCULA A DESPESA TOTAL DO MES
    */
    public BigDecimal calculaDespesaTotalAno(){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = despesar.getListaPlano(1);
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
    
        /*
    *EM TESTE - COLOCAR COMENTARIO
    *CALCULA VALOR ANUAL
    */
    
    private BigDecimal calculaValorMesAno(BigDecimal valor){
        valor = valor.divide(Utilidade.converter("12"), 2, RoundingMode.HALF_EVEN);
        return valor;
    }
    
    /*
    * EM TESTE - COLOCAR COMENTARIO
    * DEFAULTCOMBOBOXMODEL - DESPESA
    */
    private void jcModelDespesa(JComboBox<Despesa> o){
        o.setRenderer(new DefaultListCellRenderer(){
                @Override
                public Component getListCellRendererComponent(
                    JList<?> list, 
                    Object value,
                    int index,
                    boolean isSelected,
                    boolean cellHasFocus){
                    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    if(value instanceof Despesa){
                        Despesa d = (Despesa) value;
                        if(d.getCd_despesa()== 0){
                            setText("<Selecione>");
                        }else if(d.getDs_despesa()!= null){
                            setText(d.getDs_despesa());
                        }else{
                            setText("Sem despesa");
                        }
                    }else{
                        setText("");
                    }
                return this;
            }
        });
    }
    
    /**
     * <p><strong>EN:</strong> Fills the combo box with all available expenses, adding a placeholder item as the first option.</p>
     * <p><strong>IT:</strong> Popola la combo box con tutte le spese disponibili, aggiungendo un elemento segnaposto come prima opzione.</p>
     * <p><strong>PT-BR:</strong> Preenche a combo box com todas as despesas disponíveis, adicionando um item placeholder como primeira opção.</p>
     *
     * @param o EN: target combo box to load | IT: combo box di destinazione da caricare | PT-BR: combo box de destino para carregar
     */
    public void jcDespesa(JComboBox<Despesa> o){
        List<Despesa> lista = despesar.getLista();
        DefaultComboBoxModel<Despesa> model = new DefaultComboBoxModel<>();
        model.addElement(new Despesa(0, "<Despesas>", null, null, 0, null, null, 0));
        if(lista != null && !lista.isEmpty()){
            for(Despesa despesa : lista){
                model.addElement(despesa);
            }            
        }
        o.setModel(model);
        jcModelDespesa(o);
    }

    /**
     * <p><strong>EN:</strong> Builds a table model with expense description, amount, provider, and category, and applies it to the given table.</p>
     * <p><strong>IT:</strong> Crea un modello di tabella con descrizione spesa, importo, fornitore e categoria, applicandolo alla tabella indicata.</p>
     * <p><strong>PT-BR:</strong> Monta um modelo de tabela com descrição, valor, prestador e categoria e aplica na tabela informada.</p>
     *
     * @param o EN: target table to display the expenses | IT: tabella di destinazione per visualizzare le spese | PT-BR: tabela de destino para exibir as despesas
     */
    public void tabelaDespesaMes(JTable o) {
        List<Despesa> listames = new java.util.ArrayList<>();
        String[] nomeColuna = {"Despesa", "Valor", "Prestadora Serviço", "Categoria"};
        listames = despesar.getListaPlano(0);
        Object[][] dadosArray = new Object[listames.size()][nomeColuna.length];
        for (int i = 0; i < listames.size(); i++) {
            Despesa despesa = listames.get(i);
            dadosArray[i][0] = despesa.getDs_despesa();
            dadosArray[i][1] = Utilidade.formatoValor.format(despesa.getNm_valor());
            dadosArray[i][2] = despesa.getEmpresa().getDs_empresa();
            dadosArray[i][3] = despesa.getCategoria().getDs_Categoria();
        }
        DefaultTableModel tDespesa = new DefaultTableModel(dadosArray, nomeColuna){
            @Override
            public boolean isCellEditable(int row, int column){return false;}
        };
        o.putClientProperty("listaDespesa", listames);
        o.setSelectionModel(new DefaultListSelectionModel());
        o.setModel(tDespesa);
    }

    /**
     * EM TESTE - COLOCAR COMENTARIO
     * CARREGA A TABELA DE DESPSA POR ANO
     * @param o 
     */
    public void tabelaDespesaAno(JTable o) {
        List<Despesa> listaano = new java.util.ArrayList<>();
        String[] nomeColuna = {"Despesa", "Valor", "Custo Mes", "Vencimento", "Prestadora Serviço", "Categoria"};
        listaano = despesar.getListaPlano(1);
        Object[][] dadosArray = new Object[listaano.size()][nomeColuna.length];
        for (int i = 0; i < listaano.size(); i++) {
            Despesa despesa = listaano.get(i);
            dadosArray[i][0] = despesa.getDs_despesa();
            dadosArray[i][1] = Utilidade.formatoValor.format(despesa.getNm_valor());
            dadosArray[i][2] = Utilidade.formatoValor.format(calculaValorMesAno(despesa.getNm_valor()));
            dadosArray[i][3] = Utilidade.formatoData.format(despesa.getDt_validade().getTime());
            dadosArray[i][4] = despesa.getEmpresa().getDs_empresa();
            dadosArray[i][5] = despesa.getCategoria().getDs_Categoria();
        }
        DefaultTableModel tDespesa = new DefaultTableModel(dadosArray, nomeColuna){
            @Override
            public boolean isCellEditable(int row, int column){return false;}
        };
        o.putClientProperty("listaDespesa", listaano);
        o.setSelectionModel(new DefaultListSelectionModel());
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
    
    /**
     * EM TESTE - COLOCAR COMENTARIO
     * SELECIONA A DESPSA
     * @param o
     * @return 
     */
    
    public Object getSelectDespesa(JTable o){
        if (o == null) 
            return null;
        int viewRow = o.getSelectedRow();
        if (viewRow == -1) 
            return null;
        int modelRow = o.convertRowIndexToModel(viewRow);
        List<Despesa> lista = (List<Despesa>) o.getClientProperty("listaDespesa");
        if (lista == null) {
            return null;
        }
        if (modelRow < 0 || modelRow >= lista.size()) 
            return null;
    return lista.get(modelRow);
    }
}
