package br.com.rlmoura81.moura.cartao;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.awt.Component;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class CartaoUtil {
        
    Cartao cartao = new Cartao();
    CartaoRepository cartaor = new CartaoRepository();    
    ArrayList lista = new ArrayList();

        /*
    * EM TESTE - COLOCAR COMENTARIO
    * DEFAULTCOMBOBOXMODEL - CARTAO
    */    
    public void jcModelCartao(JComboBox<Cartao> o){
        o.setRenderer(new DefaultListCellRenderer(){
                @Override
                public Component getListCellRendererComponent(
                    JList<?> list, 
                    Object value,
                    int index,
                    boolean isSelected,
                    boolean cellHasFocus){
                    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    if(value instanceof Cartao){
                        Cartao cartao = (Cartao) value;
                        if(cartao.getCd_cartao() == 0){
                            setText("<Selecione>");
                        }else if(cartao.getNm_cartao() != null){
                            setText(cartao.getNm_cartao());
                        }else{
                            setText("Sem cartao");
                        }
                    }else{
                        setText("");
                    }
                return this;
            }
        });
    }
    
    /**
     * <p><strong>EN:</strong> Populates a JComboBox with the list of cards for the specified bank, adding a default option at the beginning.</p>
     *
     * <p><strong>IT:</strong> Popola un JComboBox con l'elenco delle carte per la banca specificata, aggiungendo un'opzione predefinita all'inizio.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche um JComboBox com a lista de cartões do banco informado, adicionando uma opção padrão no início.</p>
     *
     * @param o EN: JComboBox to be populated | IT: JComboBox da popolare | PT-BR: JComboBox a ser preenchido
     * @param cd_banco EN: bank identifier | IT: identificatore della banca | PT-BR: identificador do banco
     * @since 1.0.0
     */
    public void jcCartao(JComboBox<Cartao> o, int cd_banco){
        List<Cartao> lista = cartaor.getLista(cd_banco);
        DefaultComboBoxModel<Cartao> model = new DefaultComboBoxModel<>();
        model.addElement(new Cartao(0, "<Cartão>", null, null, null, null, 0));
        if(lista != null && !lista.isEmpty()){
            for(Cartao cartao : lista){
                model.addElement(cartao);
            }            
        }
        o.setModel(model);
        jcModelCartao(o);
    }

    /**
     * <p><strong>EN:</strong> Populates a JTable with the cards of the specified bank, formatting number, limit, due date, and brand.</p>
     *
     * <p><strong>IT:</strong> Popola una JTable con le carte della banca specificata, formattando numero, limite, scadenza e bandiera.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche uma JTable com os cartões do banco informado, formatando número, limite, vencimento e bandeira.</p>
     *
     * @param o EN: JTable to be populated | IT: JTable da popolare | PT-BR: JTable a ser preenchida
     * @param cd_banco EN: bank identifier | IT: identificatore della banca | PT-BR: identificador do banco
     * @since 1.0.0
     */    
    public void tabelaCartao(JTable o, int cd_banco){
        String[] nomeColuna = {"Numero", "Limite", "Data Venc.", "Bandeira"};
        lista = cartaor.getLista(cd_banco);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        
        for(int i = 0; i < lista.size(); i++){
            cartao = (Cartao) lista.get(i);
            dadosArray[i][0] = cartao.getNm_cartao();
            dadosArray[i][1] = Utilidade.formatoValor.format(cartao.getNm_limite());
            dadosArray[i][2] = Utilidade.formatoData.format(cartao.getDt_vencimento().getTime());
            dadosArray[i][3] = cartao.getCartaobandeira();
        }
        DefaultTableModel tCartao = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tCartao);
    }
 
    /**
     * <p><strong>EN:</strong> Retrieves the object corresponding to the selected row in the JTable.  
     * Displays an information dialog if no row is selected.</p>
     *
     * <p><strong>IT:</strong> Recupera l'oggetto corrispondente alla riga selezionata nella JTable.  
     * Mostra una finestra informativa se non viene selezionata alcuna riga.</p>
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
            JOptionPane.showMessageDialog(null, "Selecione um cartão da lista.", "Cartão", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;
    }

    /**
     * <p><strong>EN:</strong> Applies a numeric mask to the card number input field (####.####.####.####).</p>
     *
     * <p><strong>IT:</strong> Applica una maschera numerica al campo del numero della carta (####.####.####.####).</p>
     *
     * <p><strong>PT-BR:</strong> Aplica uma máscara numérica ao campo do número do cartão (####.####.####.####).</p>
     *
     * @param o EN: JFormattedTextField to receive the mask | IT: JFormattedTextField a cui applicare la maschera | PT-BR: JFormattedTextField que receberá a máscara
     * @since 1.0.0
     */
    public void formataNumCartao(Object o){
            try {
                MaskFormatter mascDoc = new MaskFormatter("####.####.####.####");
                mascDoc.setPlaceholderCharacter(' ');
                mascDoc.install((JFormattedTextField) o);            
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Verifique ParseException ao formatar campo do numero do cartão - " + ex.getMessage(),
                                              "Erro de sistema", JOptionPane.ERROR_MESSAGE);
            }
    }
    
    /**
     * <p><strong>EN:</strong> Converts the masked card number to a plain numeric string by removing separators.</p>
     *
     * <p><strong>IT:</strong> Converte il numero della carta mascherato in una stringa numerica rimuovendo i separatori.</p>
     *
     * <p><strong>PT-BR:</strong> Converte o número do cartão mascarado para uma string numérica removendo os separadores.</p>
     *
     * @param numDoc EN: masked card number | IT: numero della carta con maschera | PT-BR: número do cartão com máscara
     * @return EN: unmasked numeric string | IT: stringa numerica senza maschera | PT-BR: string numérica sem máscara
     * @since 1.0.0
     */   
    public static String converterNumCartao(String numDoc){
        String numConv = numDoc.replace(".", "");
        return numConv;
    }
    
    /**
     * <p><strong>EN:</strong> Validates the card number field format and checks if it is not blank.</p>
     *
     * <p><strong>IT:</strong> Valida il formato del campo numero carta e verifica che non sia vuoto.</p>
     *
     * <p><strong>PT-BR:</strong> Valida o formato do campo número do cartão e verifica se não está em branco.</p>
     *
     * @param campodoc EN: masked card number value from the field | IT: valore del numero carta mascherato dal campo | PT-BR: valor do número do cartão mascarado do campo
     * @return EN: true if the field contains a value, false otherwise | IT: true se il campo contiene un valore, altrimenti false | PT-BR: true se o campo contém um valor, caso contrário false
     * @since 1.0.0
     */
    public boolean validaNumCartao(String campodoc){
        if(campodoc.equals("    .    .    .    ")){
            JOptionPane.showMessageDialog(null, "Número do cartão em branco.");
            return false;
        }
        return true;
    }
}
