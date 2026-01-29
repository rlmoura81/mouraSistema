package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.awt.Component;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AluguelUtil {
        
    Aluguel aluguel = new Aluguel();
    AluguelRepository aluguelr = new AluguelRepository();    
    ArrayList lista = new ArrayList();
    
    /**
     * <p><strong>EN:</strong> Calculates the net amount from a gross value and a percentage discount.  
     * If the discount is null, it is treated as 0%.</p>
     *
     * <p><strong>IT:</strong> Calcola l'importo netto a partire da un valore lordo e da uno sconto percentuale.  
     * Se lo sconto è null, viene considerato 0%.</p>
     *
     * <p><strong>PT-BR:</strong> Calcula o valor líquido a partir de um valor bruto e de um desconto percentual.  
     * Se o desconto for nulo, considera 0%.</p>
     *
     * @param vl_bruto EN: gross amount | IT: importo lordo | PT-BR: valor bruto
     * @param vl_desc  EN: discount percentage | IT: percentuale di sconto | PT-BR: percentual de desconto
     * @return EN: net amount after discount | IT: importo netto dopo lo sconto | PT-BR: valor líquido após o desconto
     */
    public BigDecimal valorLiquido(BigDecimal vl_bruto, BigDecimal vl_desc){
        BigDecimal resultado;
        if(vl_desc == null){
            vl_desc = Utilidade.converter("0,00");
        }
        resultado = vl_bruto.subtract((vl_bruto.multiply(vl_desc)).divide(Utilidade.converter("100,00")));
        return resultado;
    }
    
    /**
     * <p><strong>EN:</strong> Computes the difference between a value and a discount amount (absolute subtraction).</p>
     *
     * <p><strong>IT:</strong> Calcola la differenza tra un valore e un importo di sconto (sottrazione assoluta).</p>
     *
     * <p><strong>PT-BR:</strong> Calcula a diferença entre um valor e um valor de desconto (subtração absoluta).</p>
     *
     * @param valor    EN: original amount | IT: importo originale | PT-BR: valor original
     * @param desconto EN: discount amount | IT: importo dello sconto | PT-BR: valor do desconto
     * @return EN: resulting amount | IT: importo risultante | PT-BR: valor resultante
     */
    public BigDecimal valorDesconto(BigDecimal valor, BigDecimal desconto){
        BigDecimal resultado;
        resultado = valor.subtract(desconto);
        return resultado;
    }

        /*
    * EM TESTE - COLOCAR COMENTARIO
    * DEFAULTCOMBOBOXMODEL - ALUGUEL
    */
    private void jcModelAluguel(JComboBox<Aluguel> o){
        o.setRenderer(new DefaultListCellRenderer(){
                @Override
                public Component getListCellRendererComponent(
                    JList<?> list, 
                    Object value,
                    int index,
                    boolean isSelected,
                    boolean cellHasFocus){
                    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    if(value instanceof Aluguel){
                        Aluguel a = (Aluguel) value;
                        if(a.getCd_aluguel()== 0){
                            setText("<Selecione>");
                        }else if(a.getNm_contrato()!= null){
                            setText(a.getNm_contrato());
                        }else{
                            setText("Sem ativo");
                        }
                    }else{
                        setText("");
                    }
                return this;
            }
        });
    }
    
    /**
     * <p><strong>EN:</strong> Populates a JComboBox with the rental list, adding a default "Aluguel" option first.</p>
     *
     * <p><strong>IT:</strong> Popola un JComboBox con l'elenco degli affitti, aggiungendo prima l'opzione predefinita "Aluguel".</p>
     *
     * <p><strong>PT-BR:</strong> Preenche um JComboBox com a lista de aluguéis, adicionando antes a opção padrão "Aluguel".</p>
     *
     * @param o EN: JComboBox to be populated | IT: JComboBox da popolare | PT-BR: JComboBox a ser preenchido
     */
    public void jcAluguel(JComboBox<Aluguel> o){
        ArrayList<Aluguel> lista = aluguelr.getListaContratoVencimento();
        DefaultComboBoxModel<Aluguel> model = new DefaultComboBoxModel<>();
        model.addElement(new Aluguel(0, "Aluguel", null, null, 0, null, null, null, 0));
        if(lista != null && !lista.isEmpty()){
            for(Aluguel aluguel : lista){
                model.addElement(aluguel);
            }            
        }
        o.setModel(model);
        jcModelAluguel(o);
    }
 
    /**
     * <p><strong>EN:</strong> Populates a JTable with rental data: contract, property, rent value, admin fee, deposit day, and due date.</p>
     *
     * <p><strong>IT:</strong> Popola una JTable con i dati degli affitti: contratto, immobile, canone, tassa amministrativa, giorno del deposito e scadenza.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche uma JTable com dados de aluguel: contrato, imóvel, valor do aluguel, taxa adm., dia de depósito e vencimento.</p>
     *
     * @param o EN: JTable to be populated | IT: JTable da popolare | PT-BR: JTable a ser preenchida
     */
    public void tabelaAluguel(JTable o){
        String[]nomeColuna = {"Contrato", "Imovel", "Valor do aluguel", "Taxa de Adm.", "Dia de deposito", "Contrato vence"};
        lista = aluguelr.getLista();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for(int i = 0; i < lista.size(); i++){
            aluguel = (Aluguel) lista.get(i);
            dadosArray[i][0] = aluguel.getNm_contrato();
            dadosArray[i][1] = aluguel.getImovel().getDs_descricao();
            dadosArray[i][2] = Utilidade.formatoValor.format(aluguel.getNm_vlaluguel());
            dadosArray[i][3] = Utilidade.formatoValor.format(aluguel.getNm_vladm());
            dadosArray[i][4] = aluguel.getDt_deposito();
            dadosArray[i][5] = Utilidade.formatoData.format(aluguel.getDt_contratovenc().getTime());
        }
        DefaultTableModel tAluguel = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tAluguel);
    }
    
    /**
     * <p><strong>EN:</strong> Returns the object corresponding to the selected row in the table;  
     * shows an information dialog if no row is selected.</p>
     *
     * <p><strong>IT:</strong> Restituisce l'oggetto corrispondente alla riga selezionata nella tabella;  
     * mostra una finestra informativa se nessuna riga è selezionata.</p>
     *
     * <p><strong>PT-BR:</strong> Retorna o objeto correspondente à linha selecionada na tabela;  
     * exibe uma mensagem informativa se nenhuma linha estiver selecionada.</p>
     *
     * @param o EN: source JTable | IT: JTable di origine | PT-BR: JTable de origem
     * @return EN: selected object or null | IT: oggetto selezionato o null | PT-BR: objeto selecionado ou null
     */    
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um aluguel da lista.");
        }
        return selecionado;
    }    
}
