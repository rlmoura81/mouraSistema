package br.com.rlmoura81.moura.financeiro;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BancoUtil {
    
    Banco banco = new Banco();
    BancoRepository bancor = new BancoRepository();
    ArrayList lista = new ArrayList();
    
    /*
    * EM TESTE - COLOCAR COMENTARIO
    * DEFAULTCOMBOBOXMODEL - BANCO
    */
    private void jcModelBanco(JComboBox<Banco> o){
        o.setRenderer(new DefaultListCellRenderer(){
                @Override
                public Component getListCellRendererComponent(
                    JList<?> list, 
                    Object value,
                    int index,
                    boolean isSelected,
                    boolean cellHasFocus){
                    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    if(value instanceof Banco){
                        Banco banco = (Banco) value;
                        if(banco.getCd_banco()== 0){
                            setText("<Selecione>");
                        }else if(banco.getDs_banco()!= null){
                            setText(banco.getDs_banco() + " - " + banco.getNm_banco());
                        }else{
                            setText("Sem banco");
                        }
                    }else{
                        setText("");
                    }
                return this;
            }
        });
    }
    
    /**
     * <p><strong>EN:</strong> Loads the bank list into a combo box. Adds a default option
     * ("&lt;Bank&gt;") before appending all available banks.</p>
     * <p><strong>IT:</strong> Carica l’elenco delle banche in una combo box. Aggiunge un’opzione
     * predefinita ("&lt;Banca&gt;") prima di inserire tutte le banche disponibili.</p>
     * <p><strong>PT-BR:</strong> Carrega a lista de bancos em um combo box. Adiciona uma opção
     * padrão ("&lt;Banco&gt;") antes de incluir todos os bancos disponíveis.</p>
     *
     * @param o EN: combo box to fill | IT: combo box da riempire | PT-BR: combo box a ser preenchido
     */
    public void jcBanco(JComboBox<Banco> o){
        ArrayList<Banco> lista = bancor.getLista();
        DefaultComboBoxModel<Banco> model = new DefaultComboBoxModel<>();
        model.addElement(new Banco(0, null, 0, 0));
        if(lista != null && !lista.isEmpty()){
            for(Banco banco : lista){
                model.addElement(banco);
            }            
        }
        o.setModel(model);
        jcModelBanco(o);
    }
    
    /**
     * <p><strong>EN:</strong> Populates a table with bank data. Displays the bank name and
     * its numeric code as columns.</p>
     * <p><strong>IT:</strong> Popola una tabella con i dati delle banche. Mostra il nome della banca
     * e il suo codice numerico come colonne.</p>
     * <p><strong>PT-BR:</strong> Preenche uma tabela com os dados dos bancos. Exibe o nome do banco
     * e o código numérico como colunas.</p>
     *
     * @param o EN: table to populate with banks | IT: tabella da popolare con banche | PT-BR: tabela a ser preenchida com bancos
     */
    public void tabelaBanco(JTable o){
        String[] nomeColuna = {"Banco", "Numero"};
        lista = bancor.getLista();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        
        for(int i = 0; i < lista.size(); i++){
            banco = (Banco)lista.get(i);
            dadosArray[i][0] = banco.getDs_banco();
            dadosArray[i][1] = banco.getNm_banco();
        }
        DefaultTableModel tBanco = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tBanco);
    }
     
    /**
     * <p><strong>EN:</strong> Retrieves the object currently selected in a table row.
     * If no row is selected, shows an alert message.</p>
     * <p><strong>IT:</strong> Recupera l’oggetto attualmente selezionato in una riga della tabella.
     * Se nessuna riga è selezionata, mostra un messaggio di avviso.</p>
     * <p><strong>PT-BR:</strong> Recupera o objeto atualmente selecionado em uma linha da tabela.
     * Caso nenhuma linha esteja selecionada, exibe uma mensagem de aviso.</p>
     *
     * @param o EN: table from which to get the selected item | IT: tabella da cui ottenere l’elemento selezionato | PT-BR: tabela de onde obter o item selecionado
     * @return EN: the selected object or null if none selected | IT: l’oggetto selezionato o null se nessuno selezionato | PT-BR: o objeto selecionado ou null se nenhum estiver selecionado
     */
    public Object getSelectedObject(JTable o){        
        Object selecionado = null;
        int linhaSelecionada = o.getSelectedRow();
        if(linhaSelecionada >= 0){
            selecionado = lista.get(linhaSelecionada);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um item da lista.");
        }
        return selecionado;  
    }
}
