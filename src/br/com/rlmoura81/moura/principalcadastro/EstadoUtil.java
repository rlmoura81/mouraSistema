package br.com.rlmoura81.moura.principalcadastro;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EstadoUtil {
    
    Estado estado = new Estado();
    EstadoRepository estador = new EstadoRepository();    
    ArrayList lista = new ArrayList();    
        
    /**
     * <p><strong>EN:</strong> Populates the JComboBox with a list of States.
     * Adds a default placeholder option ("&lt;UF&gt;") followed by all registered States.</p>
     *
     * <p><strong>IT:</strong> Popola la JComboBox con un elenco di Stati.
     * Aggiunge un’opzione predefinita ("&lt;UF&gt;") seguita da tutti gli Stati registrati.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche o JComboBox com a lista de Estados.
     * Adiciona uma opção padrão ("&lt;UF&gt;") seguida por todos os Estados cadastrados.</p>
     */
    public void jcEstado(JComboBox o){        
        ArrayList<Estado> listaestado = estador.getLista();
        Estado eZero = new Estado(0, null, "<UF>");
        o.addItem(eZero);
        for(Estado estado : listaestado){
            o.addItem(estado);
        }      
    }
    
    /**
     * <p><strong>EN:</strong> Builds and assigns a table model (JTable) displaying the States.
     * The table includes the columns "State" and "Abbreviation".</p>
     *
     * <p><strong>IT:</strong> Crea e assegna un modello di tabella (JTable) che mostra gli Stati.
     * La tabella include le colonne "Stato" e "Sigla".</p>
     *
     * <p><strong>PT-BR:</strong> Monta e atribui um modelo de tabela (JTable) exibindo os Estados.
     * A tabela contém as colunas "Estado" e "Sigla".</p>
     */
    public void tabelaEstado(JTable o){        
        String[] nomeColuna = {"Estado", "Sigla"};
        lista = estador.getLista();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        for(int i = 0; i < lista.size(); i++){
            estado = (Estado) lista.get(i);
            dadosArray[i][0] = estado.getDs_estado();
            dadosArray[i][1] = estado.getDs_siglaEstado();            
        }
        DefaultTableModel tEstado = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tEstado);    
    }
    
    /**
     * <p><strong>EN:</strong> Returns the selected State object from the JTable.
     * If no row is selected, shows a message and returns null.</p>
     *
     * <p><strong>IT:</strong> Restituisce l’oggetto Stato selezionato dalla JTable.
     * Se nessuna riga è selezionata, mostra un messaggio e restituisce null.</p>
     *
     * <p><strong>PT-BR:</strong> Retorna o objeto Estado selecionado da JTable.
     * Caso nenhuma linha seja selecionada, exibe uma mensagem e retorna null.</p>
     */
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaSelecionada = o.getSelectedRow();
        if(linhaSelecionada >= 0){
            selecionado = lista.get(linhaSelecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um estado da lista.", "Estado", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;
    }
}
