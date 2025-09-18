package br.com.rlmoura81.moura.principalcadastro;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GrupoUtil {
    
    Grupo grupo = new Grupo();
    GrupoRepository grupor = new GrupoRepository();    
    ArrayList lista = new ArrayList();
       
    /**
     * <p><strong>EN:</strong> Populates a ComboBox with the list of Groups from the database.
     * Adds a default option <code>&lt;Grupo&gt;</code> as the first entry.</p>
     *
     * <p><strong>IT:</strong> Popola una ComboBox con l’elenco dei Gruppi dal database.
     * Aggiunge l’opzione predefinita <code>&lt;Grupo&gt;</code> come primo elemento.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche uma ComboBox com a lista de Grupos do banco de dados.
     * Adiciona a opção padrão <code>&lt;Grupo&gt;</code> como primeiro item.</p>
     */
    public  void jcGrupo(JComboBox o){
        ArrayList<Grupo> listagrupo = grupor.getLista();
        Grupo cZero = new Grupo(0, "<Grupo>", 0);
        o.addItem(cZero);
        for(Grupo grupo : listagrupo){
            o.addItem(grupo);
        }
    } 
    
    /**
     * <p><strong>EN:</strong> Builds a JTable with the list of Groups.
     * Displays the Group name and its code in two columns.</p>
     *
     * <p><strong>IT:</strong> Costruisce una JTable con l’elenco dei Gruppi.
     * Mostra il nome del Gruppo e il suo codice in due colonne.</p>
     *
     * <p><strong>PT-BR:</strong> Monta uma JTable com a lista de Grupos.
     * Exibe o nome do Grupo e seu código em duas colunas.</p>
     */
    public void tabelaGrupo(JTable o) {
        String[] nomeColuna = {"Grupo", "Código"};
        lista = grupor.getLista();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        for (int i = 0; i < lista.size(); i++){
             grupo = (Grupo) lista.get(i);
             dadosArray[i][0] = grupo.getDs_grupo();
             dadosArray[i][1] = grupo.getCd_grupo();
            }
        DefaultTableModel tCategoria = new DefaultTableModel(dadosArray, nomeColuna); 
        o.setModel(tCategoria);
    }    
    
    /**
     * <p><strong>EN:</strong> Returns the object selected in the JTable of Groups.
     * Shows a warning message if no row is selected.</p>
     *
     * <p><strong>IT:</strong> Restituisce l’oggetto selezionato nella JTable dei Gruppi.
     * Mostra un messaggio di avviso se nessuna riga è selezionata.</p>
     *
     * <p><strong>PT-BR:</strong> Retorna o objeto selecionado na JTable de Grupos.
     * Exibe uma mensagem de aviso caso nenhuma linha esteja selecionada.</p>
     */
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um grupo da lista.", "Grupo", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;    
    }        
}
