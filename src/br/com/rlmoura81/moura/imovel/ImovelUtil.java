package br.com.rlmoura81.moura.imovel;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ImovelUtil {
    
    Imovel imovel = new Imovel();
    ImovelRepository imovelr = new ImovelRepository();    
    ArrayList lista = new ArrayList();

    /*
    * EM TESTE - COLOCAR COMENTARIO
    * DEFAULTCOMBOBOXMODEL - IMOVEL
    */
    private void jcModelImovel(JComboBox<Imovel> o){
        o.setRenderer(new DefaultListCellRenderer(){
                @Override
                public Component getListCellRendererComponent(
                    JList<?> list, 
                    Object value,
                    int index,
                    boolean isSelected,
                    boolean cellHasFocus){
                    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    if(value instanceof Imovel){
                        Imovel imovel = (Imovel) value;
                        if(imovel.getCd_imovel()== 0){
                            setText("<Selecione>");
                        }else if(imovel.getDs_descricao()!= null){
                            setText(imovel.getDs_descricao()+ " - " + imovel.getNm_matricula());
                        }else{
                            setText("Sem imovel");
                        }
                    }else{
                        setText("");
                    }
                return this;
            }
        });
    }
    
    /**
     * <p><strong>EN:</strong> Populates a {@link javax.swing.JComboBox} with {@link Imovel} options.
     * Adds a default "<Imovel>" placeholder (id = 0) and then appends all items returned by
     * <code>imovelr.getLista()</code>.</p>
     *
     * <p><strong>IT:</strong> Popola un {@link javax.swing.JComboBox} con le opzioni di {@link Imovel}.
     * Aggiunge il segnaposto "<Imovel>" (id = 0) e poi inserisce tutti gli elementi restituiti da
     * <code>imovelr.getLista()</code>.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche um {@link javax.swing.JComboBox} com opções de {@link Imovel}.
     * Adiciona o placeholder "<Imovel>" (id = 0) e, em seguida, insere todos os itens retornados por
     * <code>imovelr.getLista()</code>.</p>
     */
    public void jcImovel(JComboBox<Imovel> o){
        ArrayList<Imovel> lista = imovelr.getLista();
        DefaultComboBoxModel<Imovel>model = new DefaultComboBoxModel<>();
        model.addElement(new Imovel(0, "<Imovel>", null, null, null, null, null, 0));
        if(lista != null && !lista.isEmpty()){
            for(Imovel imovel : lista){
                model.addElement(imovel);
            }
        }
        o.setModel(model);
        jcModelImovel(o);
    }
    
    /**
     * <p><strong>EN:</strong> Renders a list of {@link Imovel} in a {@link javax.swing.JTable} using a
     * {@link javax.swing.table.DefaultTableModel}. Columns: matrícula, size (formatted), registration value
     * (formatted), city, and description.</p>
     *
     * <p><strong>IT:</strong> Visualizza un elenco di {@link Imovel} in una {@link javax.swing.JTable}
     * usando {@link javax.swing.table.DefaultTableModel}. Colonne: matricola, metratura (formattata),
     * valore di registrazione (formattato), città e descrizione.</p>
     *
     * <p><strong>PT-BR:</strong> Exibe a lista de {@link Imovel} em uma {@link javax.swing.JTable}
     * usando {@link javax.swing.table.DefaultTableModel}. Colunas: matrícula, metragem (formatada),
     * valor da matrícula (formatado), cidade e descrição.</p>
     */
    public void tabelaImovel(JTable o){
        String[] nomeColuna = {"Matricula", "Metragem", "Valor Matricula", "Cidade", "Descrição"};
        lista = imovelr.getLista();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for (int i = 0; i < lista.size(); i++){
            imovel = (Imovel) lista.get(i);
            dadosArray[i][0] = imovel.getNm_matricula();
            dadosArray[i][1] = Utilidade.formatoValor.format(imovel.getNm_metragem());
            dadosArray[i][2] = Utilidade.formatoValor.format(imovel.getNm_valorMatricula());
            dadosArray[i][3] = imovel.getCidade();
            dadosArray[i][4] = imovel.getDs_descricao();
        }
        DefaultTableModel tImovel = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tImovel);
    }
    
    /**
     * <p><strong>EN:</strong> Returns the domain object corresponding to the currently
     * selected row in the {@link JTable}. If no row is selected, shows an informational
     * dialog and returns <code>null</code>.</p>
     *
     * <p><strong>IT:</strong> Restituisce l’oggetto di dominio corrispondente alla riga
     * selezionata nella {@link JTable}. Se nessuna riga è selezionata, mostra un messaggio
     * informativo e restituisce <code>null</code>.</p>
     *
     * <p><strong>PT-BR:</strong> Retorna o objeto de domínio referente à linha selecionada
     * na {@link JTable}. Se nenhuma linha estiver selecionada, exibe um aviso informativo
     * e retorna <code>null</code>.</p>
     */
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecinada = o.getSelectedRow();
        if(linhaselecinada >= 0){
            selecionado = lista.get(linhaselecinada);
        }else{
            JOptionPane.showMessageDialog(null,"Selecione um imovel da lista.", "Imóvel", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;
    }
}
