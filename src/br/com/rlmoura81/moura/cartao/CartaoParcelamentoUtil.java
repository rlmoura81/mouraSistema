package br.com.rlmoura81.moura.cartao;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CartaoParcelamentoUtil {
    
    CartaoParcelamento cartaoparc = new CartaoParcelamento();
    CartaoParcelamentoRepository cartaoparcr = new CartaoParcelamentoRepository();    
    ArrayList lista = new ArrayList(); 
    
    /*
    * EM TESTE - COLOCAR COMENTARIO
    * DEFAULTCOMBOBOXMODEL - PARCELA
    */
    private void jcModelParcela(JComboBox<CartaoParcelamento> o){
        o.setRenderer(new DefaultListCellRenderer(){
                @Override
                public Component getListCellRendererComponent(
                    JList<?> list, 
                    Object value,
                    int index,
                    boolean isSelected,
                    boolean cellHasFocus){
                    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    if(value instanceof CartaoParcelamento){
                        CartaoParcelamento cp = (CartaoParcelamento) value;
                        if(cp.getCd_parcela() == 0){
                            setText("<Selecione>");
                        }else if(cp.getDs_despesa()!= null){
                            setText(cp.getDs_despesa());
                        }else{
                            setText("Sem parcela");
                        }
                    }else{
                        setText("");
                    }
                return this;
            }
        });
    }
    
    /*
    *EM TESTE - COLOCAR COMENTARIO
    *JCOMBOBOX PARCELA
    */
    public void jcParcela(JComboBox<CartaoParcelamento> o, int cd_cartao){
        List<CartaoParcelamento>lista = cartaoparcr.getListaParcela(cd_cartao);
        DefaultComboBoxModel<CartaoParcelamento> model = new DefaultComboBoxModel<>();
        model.addElement(new CartaoParcelamento(0, null, 0));
        if(lista != null && !lista.isEmpty()){
            for(CartaoParcelamento cp : lista){
                model.addElement(cp);
            }
        }
        o.setModel(model);
        jcModelParcela(o);
    }
 
    /**
     * <p><strong>EN:</strong> Populates a JTable with installment data (CartaoParcelamento) for the specified card,  
     * displaying details such as description, installment date, expense date, value, installment number, quantity, and category.</p>
     *
     * <p><strong>IT:</strong> Popola una JTable con i dati delle rate (CartaoParcelamento) per la carta specificata,  
     * mostrando dettagli come descrizione, data rata, data spesa, valore, numero rata, quantità e categoria.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche uma JTable com os dados das parcelas (CartaoParcelamento) para o cartão informado,  
     * exibindo detalhes como descrição, data da parcela, data da despesa, valor, número da parcela, quantidade e categoria.</p>
     *
     * @param o EN: JTable to be populated | IT: JTable da popolare | PT-BR: JTable a ser preenchida
     * @param cartao EN: card identifier | IT: identificatore della carta | PT-BR: identificador do cartão
     * @since 1.0.0
     */
    public void tabelaCartaoParcela(JTable o, int cartao){
        String[] nomeColuna = {"Descrição", "Data Parcela", "Data Despesa", "Valor", "Parcela", "Qtde Parcela", "Categoria"};
        lista = cartaoparcr.getLista(cartao);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for(int i=0; i < lista.size(); i++){
            cartaoparc = (CartaoParcelamento)lista.get(i);
            dadosArray[i][0] = cartaoparc.getDs_despesa();
            dadosArray[i][1] = Utilidade.formatoData.format(cartaoparc.getDt_parcela().getTime());
            dadosArray[i][2] = Utilidade.formatoData.format(cartaoparc.getDt_despesa().getTime());
            dadosArray[i][3] = Utilidade.formatoValor.format(cartaoparc.getNm_valor());
            dadosArray[i][4] = cartaoparc.getNm_parcelapag();
            dadosArray[i][5] = cartaoparc.getNm_parcela();
            dadosArray[i][6] = cartaoparc.getCategoria().getDs_Categoria();
        }
        DefaultTableModel tCartaoLanc = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tCartaoLanc);
    }   
    
    /**
     * TESTANDO - COLOCAR COMENTARIO
     * CARREGA TABELA DE CARTAO POR PARCELA
     */
    public void tabelaCartaoParcela(JTable o, int parcela, int cartao){
        String[] nomeColuna = {"Descrição", "Data Parcela", "Data Despesa", "Valor", "Parcela", "Qtde Parcela", "Categoria"};
        lista = cartaoparcr.getLista(parcela, cartao);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for(int i=0; i < lista.size(); i++){
            cartaoparc = (CartaoParcelamento)lista.get(i);
            dadosArray[i][0] = cartaoparc.getDs_despesa();
            dadosArray[i][1] = Utilidade.formatoData.format(cartaoparc.getDt_parcela().getTime());
            dadosArray[i][2] = Utilidade.formatoData.format(cartaoparc.getDt_despesa().getTime());
            dadosArray[i][3] = Utilidade.formatoValor.format(cartaoparc.getNm_valor());
            dadosArray[i][4] = cartaoparc.getNm_parcelapag();
            dadosArray[i][5] = cartaoparc.getNm_parcela();
            dadosArray[i][6] = cartaoparc.getCategoria().getDs_Categoria();
        }
        DefaultTableModel tCartaoLanc = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tCartaoLanc);
    }   
  
    /**
     * <p><strong>EN:</strong> Retrieves the object corresponding to the selected row in the JTable.  
     * If no row is selected, an information dialog is shown.</p>
     *
     * <p><strong>IT:</strong> Recupera l'oggetto corrispondente alla riga selezionata nella JTable.  
     * Se non viene selezionata alcuna riga, viene mostrata una finestra informativa.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera o objeto correspondente à linha selecionada na JTable.  
     * Se nenhuma linha for selecionada, é exibida uma mensagem informativa.</p>
     *
     * @param o EN: JTable from which to retrieve the selected object | IT: JTable da cui recuperare l'oggetto selezionato | PT-BR: JTable de onde recuperar o objeto selecionado
     * @return EN: selected object or null if none is selected | IT: oggetto selezionato o null se nessuno è selezionato | PT-BR: objeto selecionado ou null se nenhum for selecionado
     * @since 1.0.0
     */
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um item da lista.", "Cartão Parcelamento", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;    
    }      
}