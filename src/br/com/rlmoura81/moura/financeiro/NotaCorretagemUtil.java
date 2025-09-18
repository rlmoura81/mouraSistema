package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class NotaCorretagemUtil {
    
    NotaCorretagem nota = new NotaCorretagem();
    NotaCorretagemRepository notar = new NotaCorretagemRepository();    
    ArrayList lista = new ArrayList();
    
    /**
     * <p><strong>EN:</strong> Builds and sets the table model for brokerage notes linked to a specific account.</p>
     *
     * <p><strong>IT:</strong> Crea e imposta il modello di tabella per le note di intermediazione collegate a un conto specifico.</p>
     *
     * <p><strong>PT-BR:</strong> Monta e define o modelo da tabela para as notas de corretagem vinculadas a uma conta específica.</p>
     *
     * @param o EN: table to populate (JTable) | IT: tabella da popolare (JTable) | PT-BR: tabela a ser preenchida (JTable)
     * @param cd_conta EN: account ID filter | IT: filtro ID del conto | PT-BR: filtro pelo ID da conta
     * @since 1.0.0
     */
    public void tabelaNotaCorretagem(JTable o, int cd_conta){
        String[] nomeColuna = {"Numero Nota", "Data"};
        lista = notar.getLista(cd_conta);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for(int i=0; i < lista.size(); i++){
            nota = (NotaCorretagem)lista.get(i);
            dadosArray[i][0] = nota.getNm_nota();
            dadosArray[i][1] = Utilidade.formatoData.format(nota.getDt_nota().getTime());
        }
        DefaultTableModel tPoupap = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tPoupap);
    }

    /**
     * <p><strong>EN:</strong> Retrieves the domain object from the selected row in the table.</p>
     *
     * <p><strong>IT:</strong> Recupera l'oggetto di dominio dalla riga selezionata nella tabella.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera o objeto de domínio da linha selecionada na tabela.</p>
     *
     * @param o EN: source table (JTable) | IT: tabella sorgente (JTable) | PT-BR: tabela de origem (JTable)
     * @return EN: selected object or null if none is selected | IT: oggetto selezionato o null se nessuna riga è selezionata | PT-BR: objeto selecionado ou null se nenhuma linha estiver selecionada
     * @since 1.0.0
     */
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um item da lista.");
        }
        return selecionado;    
    }    
    
}
