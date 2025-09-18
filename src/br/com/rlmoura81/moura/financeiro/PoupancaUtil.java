package br.com.rlmoura81.moura.financeiro;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PoupancaUtil {
    
    Poupanca poupanca = new Poupanca();
    PoupancaRepository poupancar = new PoupancaRepository();    
    ArrayList lista = new ArrayList();
    
    /**
     * <p><strong>EN:</strong> Populates a JComboBox with savings accounts for a given account.</p>
     *
     * <p><strong>IT:</strong> Popola un JComboBox con i conti di risparmio per un determinato conto.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche um JComboBox com as poupanças de uma determinada conta.</p>
     *
     * @param o EN: JComboBox to populate | IT: JComboBox da popolare | PT-BR: JComboBox a ser preenchido
     * @param cd_conta EN: account ID | IT: ID del conto | PT-BR: ID da conta
     * @since 1.0.0
     */
    public void jcPoupanca(JComboBox o, int cd_conta){
        ArrayList<Poupanca> listapoupanca = poupancar.getLista(cd_conta);
        Poupanca poupZero = new Poupanca(0, "<Variação>", null, null, 0);
        o.addItem(poupZero);
        for(Poupanca p : listapoupanca){
            o.addItem(p);
        }
    }
    
    /**
     * <p><strong>EN:</strong> Builds and populates a JTable with savings account information.</p>
     *
     * <p><strong>IT:</strong> Crea e popola una JTable con le informazioni dei conti di risparmio.</p>
     *
     * <p><strong>PT-BR:</strong> Monta e preenche uma JTable com as informações das poupanças.</p>
     *
     * @param o EN: JTable component to display the data | 
     *          IT: Componente JTable per visualizzare i dati | 
     *          PT-BR: Componente JTable para exibir os dados
     * @param cd_conta EN: account ID | IT: ID del conto | PT-BR: ID da conta
     * @since 1.0.0
     */
    public void tabelaPoupanca(JTable o, int cd_conta){
        String[]nomeColuna = {"Variação", "Agencia/Conta/Banco"};
        lista = poupancar.getLista(cd_conta);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        
        for(int i = 0; i < lista.size(); i++){
            poupanca = (Poupanca) lista.get(i);
            dadosArray[i][0] = poupanca.getNm_variaca();
            dadosArray[i][1] = poupanca.getConta();
        }
        DefaultTableModel tPoupanca = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tPoupanca);        
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves the selected savings account from the JTable.</p>
     *
     * <p><strong>IT:</strong> Recupera il conto di risparmio selezionato dalla JTable.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera a poupança selecionada da JTable.</p>
     *
     * @param o EN: JTable containing the selection | 
     *          IT: JTable contenente la selezione | 
     *          PT-BR: JTable contendo a seleção
     * @return EN: selected savings account | IT: conto di risparmio selezionato | PT-BR: poupança selecionada
     * @since 1.0.0
     */
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma poupança da lista.");
        }
        return selecionado;
    }  
}
