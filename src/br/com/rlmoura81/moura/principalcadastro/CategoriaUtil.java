package br.com.rlmoura81.moura.principalcadastro;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CategoriaUtil {
        
    Categoria categoria = new Categoria();
    CategoriaRepository categoriar = new CategoriaRepository();    
    ArrayList lista = new ArrayList();
       
    /**
     * <p><strong>EN:</strong> Populates a combo box with a list of Categories.
     * Adds a default placeholder (“&lt;Categoria&gt;”) followed by all categories from the repository.</p>
     *
     * <p><strong>IT:</strong> Popola una combo box con l’elenco delle Categorie.
     * Aggiunge un segnaposto (“&lt;Categoria&gt;”) seguito da tutte le categorie dal repository.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche um combo box com a lista de Categorias.
     * Adiciona um item padrão (“&lt;Categoria&gt;”) seguido de todas as categorias do repositório.</p>
     */
    public  void jcCategoria(JComboBox o){
        ArrayList<Categoria> listacategoria = categoriar.getLista();
        Categoria cZero = new Categoria(0, "<Categoria>", null, 0);
        o.addItem(cZero);
        for(Categoria categoria : listacategoria){
            o.addItem(categoria);
        }
    } 
    
    /**
     * <p><strong>EN:</strong> Displays Categories in a JTable.
     * Builds a table model with two columns (“Categoria”, “Grupo”) and fills it with data from the repository.</p>
     *
     * <p><strong>IT:</strong> Mostra le Categorie in una JTable.
     * Crea un modello di tabella con due colonne (“Categoria”, “Gruppo”) e lo popola con i dati dal repository.</p>
     *
     * <p><strong>PT-BR:</strong> Exibe as Categorias em uma JTable.
     * Cria um modelo de tabela com duas colunas (“Categoria”, “Grupo”) e o preenche com dados do repositório.</p>
     */
    public void tabelaCategoria(JTable o) {
        String[] nomeColuna = {"Categoria", "Grupo"};
        lista = categoriar.getLista();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        for (int i = 0; i < lista.size(); i++){
             categoria = (Categoria) lista.get(i);
             dadosArray[i][0] = categoria.getDs_Categoria();
             dadosArray[i][1] = categoria.getGrupo();
            }
        DefaultTableModel tCategoria = new DefaultTableModel(dadosArray, nomeColuna); 
        o.setModel(tCategoria);
    }    
    
    /**
     * <p><strong>EN:</strong> Returns the selected Category object from a JTable.
     * If no row is selected, shows an informational dialog prompting the user to select a category.</p>
     *
     * <p><strong>IT:</strong> Restituisce l’oggetto Categoria selezionato da una JTable.
     * Se nessuna riga è selezionata, mostra un dialogo informativo chiedendo di selezionare una categoria.</p>
     *
     * <p><strong>PT-BR:</strong> Retorna o objeto Categoria selecionado de uma JTable.
     * Se nenhuma linha for selecionada, exibe um diálogo informativo solicitando a escolha de uma categoria.</p>
     */
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma categoria da lista.", "Categoria", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;    
    }    
}
