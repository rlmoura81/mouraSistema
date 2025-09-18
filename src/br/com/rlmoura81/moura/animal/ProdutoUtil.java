package br.com.rlmoura81.moura.animal;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProdutoUtil {
    
    Produto produto = new Produto();
    ProdutoRepository produtor = new ProdutoRepository();    
    ArrayList lista = new ArrayList();
    
    /**
     * <p><strong>EN:</strong> Populates a JComboBox with the list of products, adding a default option at the beginning.</p>
     *
     * <p><strong>IT:</strong> Popola un JComboBox con l'elenco dei prodotti, aggiungendo un'opzione predefinita all'inizio.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche um JComboBox com a lista de produtos, adicionando uma opção padrão no início.</p>
     *
     * @param o EN: JComboBox to be populated | IT: JComboBox da popolare | PT-BR: JComboBox a ser preenchido
     * @since 1.0.0
     */
    public void jcProduto(JComboBox o) {
        ArrayList<Produto> listaproduto = produtor.getLista();
        Produto pZero = new Produto(0, "<Produto>", null, 0);
        o.addItem(pZero);
        for (Produto produto : listaproduto) {
            o.addItem(produto);
        }
    }

    /**
     * <p><strong>EN:</strong> Populates a JTable with the list of products, formatting name and weight into columns.</p>
     *
     * <p><strong>IT:</strong> Popola una JTable con l'elenco dei prodotti, formattando nome e peso nelle colonne.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche uma JTable com a lista de produtos, formatando nome e peso nas colunas.</p>
     *
     * @param o EN: JTable to be populated | IT: JTable da popolare | PT-BR: JTable a ser preenchida
     * @since 1.0.0
     */    
    public void tabelaProduto(JTable o){
        String[] nomeColuna = {"Produto", "Peso"};
        lista = produtor.getLista();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        
        for(int i=0; i < lista.size(); i++){
            produto = (Produto)lista.get(i);
            dadosArray[i][0] = produto.getDs_produto();
            dadosArray[i][1] = Utilidade.formatoValorTres.format(produto.getNm_peso());
        }
        DefaultTableModel tProduto = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tProduto);
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves the product corresponding to the selected row in the JTable.  
     * Displays an information dialog if no row is selected.</p>
     *
     * <p><strong>IT:</strong> Recupera il prodotto corrispondente alla riga selezionata nella JTable.  
     * Mostra una finestra di dialogo informativa se non viene selezionata alcuna riga.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera o produto correspondente à linha selecionada na JTable.  
     * Exibe uma mensagem informativa se nenhuma linha for selecionada.</p>
     *
     * @param o EN: JTable from which to retrieve the selected product | IT: JTable da cui recuperare il prodotto selezionato | PT-BR: JTable de onde recuperar o produto selecionado
     * @return EN: selected product or null if none is selected | IT: prodotto selezionato o null se nessuno è selezionato | PT-BR: produto selecionado ou null se nenhum for selecionado
     * @since 1.0.0
     */
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um produto da lista.", "Produto", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;    
    }     
}
