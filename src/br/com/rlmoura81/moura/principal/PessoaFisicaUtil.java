package br.com.rlmoura81.moura.principal;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PessoaFisicaUtil {
    
    PessoaFisica pessoafisica = new PessoaFisica();
    PessoaFisicaRepository pessoafisicar = new PessoaFisicaRepository();    
    ArrayList lista = new ArrayList();
    
    /**
     * <p><strong>EN:</strong> Populates a <code>JComboBox</code> with people options.
     * Adds a default “&lt;Selecionar&gt;” item and then appends all <code>PessoaFisica</code> entries retrieved from the repository.</p>
     *
     * <p><strong>IT:</strong> Riempie un <code>JComboBox</code> con le opzioni di persone.
     * Aggiunge l’elemento predefinito “&lt;Selecionar&gt;” e quindi inserisce tutte le <code>PessoaFisica</code> recuperate dal repository.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche um <code>JComboBox</code> com opções de pessoas.
     * Adiciona o item padrão “&lt;Selecionar&gt;” e em seguida inclui todas as <code>PessoaFisica</code> obtidas do repositório.</p>
     */
    public void jcPessoaFisica(JComboBox o){      
        ArrayList<PessoaFisica> listapf = pessoafisicar.getListaPessoaFisica();
        PessoaFisica pfZero = new PessoaFisica(0, "<Selecionar>", null, null, null, null, null);
        o.addItem(pfZero);
        for(PessoaFisica pessoa : listapf){
            o.addItem(pessoa);
        }
    }
    
    /**
     * <p><strong>EN:</strong> Builds the table model for <code>PessoaFisica</code>.
     * Loads people from the repository and fills columns: Name, Birth Date, CPF, CNH, RG, and City; then assigns the model to the provided <code>JTable</code>.</p>
     *
     * <p><strong>IT:</strong> Crea il modello di tabella per <code>PessoaFisica</code>.
     * Carica le persone dal repository e compila le colonne: Nome, Data di Nascita, CPF, CNH, RG e Città; quindi applica il modello alla <code>JTable</code> fornita.</p>
     *
     * <p><strong>PT-BR:</strong> Monta o modelo da tabela de <code>PessoaFisica</code>.
     * Carrega as pessoas do repositório e preenche as colunas: Nome, Data de Nascimento, CPF, CNH, RG e Cidade; em seguida define o modelo na <code>JTable</code> informada.</p>
     */
    public void tabelaPessoaFisica(JTable o){
        String[] nomeColuna = {"Nome", "Data Nascimento", "CPF", "CNH", "RG", "Cidade"};
        lista = pessoafisicar.getListaPessoaFisica();
        Object [][] dadosArray = new Object[lista.size()][nomeColuna.length];
        for(int i = 0; i < lista.size(); i++){
            pessoafisica = (PessoaFisica) lista.get(i);
            dadosArray [i][0] = pessoafisica.getDs_Nome();
            dadosArray [i][1] = Utilidade.formatoData.format(pessoafisica.getDt_Nascimento().getTime());
            dadosArray [i][2] = pessoafisica.getNm_Cpf();
            dadosArray [i][3] = pessoafisica.getNm_Cnh();
            dadosArray [i][4] = pessoafisica.getNm_Rg();
            dadosArray [i][5] = pessoafisica.getCidade();          
        }        
        DefaultTableModel tPessoaFisica = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tPessoaFisica);
    }
    
    /**
     * <p><strong>EN:</strong> Returns the selected list object from the <code>JTable</code>.
     * Uses the selected row index to fetch the corresponding item from the backing list; shows an info message if nothing is selected.</p>
     *
     * <p><strong>IT:</strong> Restituisce l’oggetto selezionato dalla <code>JTable</code>.
     * Usa l’indice della riga selezionata per recuperare l’elemento corrispondente dalla lista; mostra un messaggio se nulla è selezionato.</p>
     *
     * <p><strong>PT-BR:</strong> Retorna o objeto selecionado da <code>JTable</code>.
     * Usa o índice da linha selecionada para obter o item correspondente da lista; exibe uma mensagem informativa se nada estiver selecionado.</p>
     */
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma pessoa da lista.", "Pessoa Física", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;    
    }      
    
}
