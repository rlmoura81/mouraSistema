package br.com.rlmoura81.moura.cartao;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.awt.Component;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CartaoLancamentoFechamentoUtil {
    
    CartaoLancamentoFechamento cartaolancf = new CartaoLancamentoFechamento();
    CartaoLancamentoFechamentoRepository cartaolancfr = new CartaoLancamentoFechamentoRepository();    
    ArrayList lista = new ArrayList();
    List<CartaoLancamentoFechamento> listacartaolancf = new ArrayList<>();
   
    /**
     * <p><strong>EN:</strong> Calculates the total invoice amount for the given closing date and card.</p>
     *
     * <p><strong>IT:</strong> Calcola l'importo totale della fattura per la data di chiusura e la carta indicati.</p>
     *
     * <p><strong>PT-BR:</strong> Calcula o valor total da fatura para a data de fechamento e o cartão informados.</p>
     *
     * @param data EN: closing date to filter | IT: data di chiusura per filtrare | PT-BR: data de fechamento para filtrar
     * @param cd_cartao EN: card identifier | IT: identificatore della carta | PT-BR: identificador do cartão
     * @return EN: total amount as BigDecimal | IT: importo totale come BigDecimal | PT-BR: valor total como BigDecimal
     * @since 1.0.0
     */
    public BigDecimal calculaValorFatura(Calendar data, int cd_cartao){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = cartaolancfr.getLista(data, cd_cartao);
        for(int i=0; i < lista.size(); i++){
            cartaolancf = (CartaoLancamentoFechamento)lista.get(i);
            resultado = resultado.add(cartaolancf.getNm_valor());
        }
        return resultado;
    }

    /*
    * EM TESTE - COLOCAR COMENTARIO
    * DEFAULTCOMBOBOXMODEL - STATUS PAGAMENTO
    */
    
    public void jcModelStPagamento(JComboBox<CartaoLancamentoFechamento> o){
        o.setRenderer(new DefaultListCellRenderer(){
                @Override
                public Component getListCellRendererComponent(
                    JList<?> list, 
                    Object value,
                    int index,
                    boolean isSelected,
                    boolean cellHasFocus){
                    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    if(value instanceof CartaoLancamentoFechamento){
                        CartaoLancamentoFechamento clf = (CartaoLancamentoFechamento) value;
                        if(clf.getCd_cartaolancf() == 0){
                            setText("<Selecione>");
                        }else if(clf.getDt_fechamento() != null){
                            setText(Utilidade.formatoData.format(clf.getDt_fechamento().getTime()));
                        }else{
                            setText("Sem data");
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
    *JCOMBOBOX STATUS FECHAMENTO
    */
    
    public void jcStFechamento(JComboBox<CartaoLancamentoFechamento> o, int cd_cartao, int st_pagamento){
        List<CartaoLancamentoFechamento> lista = cartaolancfr.getListaStFechamento(cd_cartao, st_pagamento);        
        DefaultComboBoxModel<CartaoLancamentoFechamento> model = new DefaultComboBoxModel<>();
        model.addElement(new CartaoLancamentoFechamento(0, null, 0, null, 0));
        if(lista != null && !lista.isEmpty()){
            for(CartaoLancamentoFechamento clf : lista){
                model.addElement(clf);
            }             
        }       
        o.setModel(model);
        jcModelStPagamento(o);
    }
    
    /**
     * <p><strong>EN:</strong> Populates a JComboBox with the list of closing dates for the given card, adding a default option at the beginning.</p>
     *
     * <p><strong>IT:</strong> Popola un JComboBox con l'elenco delle date di chiusura per la carta indicata, aggiungendo un'opzione predefinita all'inizio.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche um JComboBox com a lista de datas de fechamento para o cartão informado, adicionando uma opção padrão no início.</p>
     *
     * @param o EN: JComboBox to be populated | IT: JComboBox da popolare | PT-BR: JComboBox a ser preenchido
     * @param cd_cartao EN: card identifier | IT: identificatore della carta | PT-BR: identificador do cartão
     * @since 1.0.0
     */    
    public void jcDataFechamento(JComboBox<CartaoLancamentoFechamento> o, int cd_cartao){
        ArrayList<CartaoLancamentoFechamento> lista = cartaolancfr.getListaFechamento(cd_cartao);
        CartaoLancamentoFechamento cbZero = new CartaoLancamentoFechamento(0, null, 0);
        o.addItem(cbZero);
        for(CartaoLancamentoFechamento clf : lista){
            o.addItem(clf);
        }
    }
     
    /**
     * <p><strong>EN:</strong> Populates a JTable with the card closing entries for the given date and card, formatting data into columns.</p>
     *
     * <p><strong>IT:</strong> Popola una JTable con le voci di chiusura carta per la data e la carta indicate, formattando i dati nelle colonne.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche uma JTable com os lançamentos de fechamento do cartão para a data e o cartão informados, formatando os dados nas colunas.</p>
     *
     * @param o EN: JTable to be populated | IT: JTable da popolare | PT-BR: JTable a ser preenchida
     * @param data EN: closing date to filter | IT: data di chiusura per filtrare | PT-BR: data de fechamento para filtrar
     * @param cd_cartao EN: card identifier | IT: identificatore della carta | PT-BR: identificador do cartão
     * @since 1.0.0
     */
    public void tabelaCartaoFechamento(JTable o, Calendar data, int cd_cartao){
        String[] nomeColuna = {"Data Despesa", "Descrição", "Valor", "Parcela", "Categoria"};
        lista = cartaolancfr.getLista(data, cd_cartao);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        
        for(int i=0; i < lista.size(); i++){
            cartaolancf = (CartaoLancamentoFechamento)lista.get(i);
            dadosArray[i][0] = Utilidade.formatoData.format(cartaolancf.getDt_despesa().getTime());
            dadosArray[i][1] = cartaolancf.getDs_despesa();
            dadosArray[i][2] = Utilidade.formatoValor.format(cartaolancf.getNm_valor());
            dadosArray[i][3] = cartaolancf.getNm_parcela();
            dadosArray[i][4] = cartaolancf.getCategoria();
        }
        DefaultTableModel tCartaoLanc = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tCartaoLanc);
    }    

    /**
     * <p><strong>EN:</strong> Retrieves the object corresponding to the selected row in the JTable.  
     * Displays an information dialog if no row is selected.</p>
     *
     * <p><strong>IT:</strong> Recupera l'oggetto corrispondente alla riga selezionata nella JTable.  
     * Mostra una finestra di dialogo informativa se non viene selezionata alcuna riga.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera o objeto correspondente à linha selecionada na JTable.  
     * Exibe uma mensagem informativa se nenhuma linha for selecionada.</p>
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
            JOptionPane.showMessageDialog(null, "Selecione um lançamento da lista.", "Cartão Lançamento Fechamento", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;    
    }     
}
