package br.com.rlmoura81.moura.principalcadastro;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CidadeUtil {
    
    Cidade cidade = new Cidade();
    CidadeRepository cidader = new CidadeRepository();    
    ArrayList lista = new ArrayList();
    
        /*
    * EM TESTE - COLOCAR COMENTARIO
    * DEFAULTCOMBOBOXMODEL - CIDADE
    */
    private void jcModelCidade(JComboBox<Cidade> o){
        o.setRenderer(new DefaultListCellRenderer(){
                @Override
                public Component getListCellRendererComponent(
                    JList<?> list, 
                    Object value,
                    int index,
                    boolean isSelected,
                    boolean cellHasFocus){
                    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    if(value instanceof Cidade){
                        Cidade cidade = (Cidade) value;
                        if(cidade.getCd_Cidade()== 0){
                            setText("<Selecione>");
                        }else if(cidade.getDs_Cidade()!= null){
                            setText(cidade.getDs_Cidade()+ " - " + cidade.getEstado().getDs_siglaEstado());
                        }else{
                            setText("Sem cidade");
                        }
                    }else{
                        setText("");
                    }
                return this;
            }
        });
    }
    
    /**
     * <p><strong>EN:</strong> Loads the City list into a ComboBox.
     * Adds a default option "&lt;Cidade&gt;" and appends all cities from the database.</p>
     *
     * <p><strong>IT:</strong> Carica l’elenco delle Città in una ComboBox.
     * Aggiunge un’opzione predefinita "&lt;Città&gt;" e inserisce tutte le città dal database.</p>
     *
     * <p><strong>PT-BR:</strong> Carrega a lista de Cidades em um ComboBox.
     * Adiciona a opção padrão "&lt;Cidade&gt;" e insere todas as cidades do banco de dados.</p>
     */
    public void jcCidade(JComboBox<Cidade> o){
        ArrayList<Cidade> lista =  cidader.getLista();
        DefaultComboBoxModel<Cidade> model = new DefaultComboBoxModel<>();
        model.addElement(new Cidade(0, "<Cidade>", null));
        if(lista != null && !lista.isEmpty()){
            for(Cidade cidade : lista){
                o.addItem(cidade);
            }
        }
        o.setModel(model);
        jcModelCidade(o);
    }
    
    /**
     * <p><strong>EN:</strong> Populates a JTable with City records.
     * Displays city name and associated State in table columns.</p>
     *
     * <p><strong>IT:</strong> Popola una JTable con i record delle Città.
     * Mostra il nome della città e lo Stato associato nelle colonne della tabella.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche uma JTable com os registros de Cidades.
     * Exibe o nome da cidade e o Estado associado nas colunas da tabela.</p>
     */
    public void tabelaCidade(JTable o){
        String[] nomeColuna = {"Cidade", "Estado"};
        lista = cidader.getLista();
        Object [][] dadosArray = new Object[lista.size()][nomeColuna.length];
        for(int i = 0; i < lista.size(); i++){
            cidade = (Cidade) lista.get(i);
            dadosArray[i][0] = cidade.getDs_Cidade();
            dadosArray[i][1] = cidade.getEstado().getDs_siglaEstado();
        }
        DefaultTableModel tCidade = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tCidade);
    }

    /**
     * <p><strong>EN:</strong> Retrieves the selected City object from a JTable.
     * Shows a message if no city is selected.</p>
     *
     * <p><strong>IT:</strong> Recupera l’oggetto Città selezionato da una JTable.
     * Mostra un messaggio se nessuna città è selezionata.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera o objeto Cidade selecionado de uma JTable.
     * Exibe uma mensagem caso nenhuma cidade seja selecionada.</p>
     */
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma cidade da lista.", "Cidade", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;    
    }    
}
