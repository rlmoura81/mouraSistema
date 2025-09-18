package br.com.rlmoura81.moura.veiculo;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ModeloUtil {
    
    Modelo modelo = new Modelo();
    ModeloRepository modelor = new ModeloRepository();    
    ArrayList lista = new ArrayList();
    
    /**
     * <p><strong>EN:</strong> Populates a <code>JComboBox</code> with all available <code>Modelo</code> items,
     * inserting a default placeholder entry (<code>"&lt;Modelo&gt;"</code>) at the first position.</p>
     *
     * <p><strong>IT:</strong> Popola un <code>JComboBox</code> con tutti i <code>Modelo</code> disponibili,
     * inserendo una voce segnaposto predefinita (<code>"&lt;Modelo&gt;"</code>) in prima posizione.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche um <code>JComboBox</code> com todos os itens de <code>Modelo</code>,
     * inserindo uma entrada padrão (<code>"&lt;Modelo&gt;"</code>) na primeira posição.</p>
     */
    public void jcModelo(JComboBox o){
        ArrayList<Modelo> listamodelo = modelor.getLista();
        Modelo mZero = new Modelo(0, "<Modelo>", null, 0);
        o.addItem(mZero);
        for(Modelo m : listamodelo){
            o.addItem(m);
        }
    }    
    
    /**
     * <p><strong>EN:</strong> Builds and assigns a table model to a <code>JTable</code> showing the list of models.
     * Columns: <em>Modelo</em> (model description) and <em>Marca</em> (associated brand).</p>
     *
     * <p><strong>IT:</strong> Crea e assegna un modello di tabella a un <code>JTable</code> con l’elenco dei modelli.
     * Colonne: <em>Modelo</em> (descrizione) e <em>Marca</em> (marchio associato).</p>
     *
     * <p><strong>PT-BR:</strong> Monta e atribui um modelo de tabela a um <code>JTable</code> com a lista de modelos.
     * Colunas: <em>Modelo</em> (descrição) e <em>Marca</em> (marca associada).</p>
     */
    public void tabelaModelo(JTable o){
        String[] nomeColuna = {"Modelo", "Marca"};
        lista = modelor.getLista();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for (int i = 0; i < lista.size(); i++){
            modelo = (Modelo) lista.get(i);
            dadosArray[i][0] = modelo.getDs_modelo();
            dadosArray[i][1] = modelo.getMarca();
        }        
        DefaultTableModel tModelo = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tModelo);
    }
    
    /**
     * <p><strong>EN:</strong> Returns the object corresponding to the currently selected row in the given
     * <code>JTable</code>. If no row is selected, shows an informational message and returns <code>null</code>.</p>
     *
     * <p><strong>IT:</strong> Restituisce l’oggetto corrispondente alla riga selezionata nel <code>JTable</code>.
     * Se nessuna riga è selezionata, mostra un messaggio informativo e restituisce <code>null</code>.</p>
     *
     * <p><strong>PT-BR:</strong> Retorna o objeto correspondente à linha selecionada no <code>JTable</code>.
     * Se nenhuma linha estiver selecionada, exibe uma mensagem informativa e retorna <code>null</code>.</p>
     */
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione a marca na lista.", "Modelo", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;
    }    
}
