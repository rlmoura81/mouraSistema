package br.com.rlmoura81.moura.financeiro;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ContaUtil {
    
    Conta conta = new Conta();
    ContaRepository contar = new ContaRepository();        
    ArrayList lista = new ArrayList();

    /*
    * EM TESTE - COLOCAR COMENTARIO
    * DEFAULTCOMBOBOXMODEL - CONTA
    */
    private void jcModelConta(JComboBox<Conta> o){
        o.setRenderer(new DefaultListCellRenderer(){
                @Override
                public Component getListCellRendererComponent(
                    JList<?> list, 
                    Object value,
                    int index,
                    boolean isSelected,
                    boolean cellHasFocus){
                    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    if(value instanceof Conta){
                        Conta c = (Conta) value;
                        if(c.getCd_conta()== 0){
                            setText("<Selecione>");
                        }else if(c.getNm_conta()!= null){
                            setText(c.getBanco().getDs_banco() + " - " + c.getNm_conta() + " / " + c.getTpconta().getDs_tpconta());
                        }else{
                            setText("Sem conta");
                        }
                    }else{
                        setText("");
                    }
                return this;
            }
        });
    }
    
    /**
     * <p><strong>EN:</strong> Populates a combo box with all accounts, inserting a default placeholder item first.</p>
     * <p><strong>IT:</strong> Popola una combo box con tutti i conti, inserendo prima un elemento segnaposto predefinito.</p>
     * <p><strong>PT-BR:</strong> Preenche um combo box com todas as contas, inserindo primeiro um item padrão de placeholder.</p>
     *
     * @param o EN: combo box to populate | IT: combo box da popolare | PT-BR: combo box a ser preenchido
     */
    public void jcConta(JComboBox<Conta> o){
        List<Conta> lista = contar.getLista();
        DefaultComboBoxModel<Conta> model = new DefaultComboBoxModel<>();
        model.addElement(new Conta(0, null, null, null, null, 0));
        if(lista != null && !lista.isEmpty()){
            for(Conta conta : lista){
                model.addElement(conta);
            }            
        }
        o.setModel(model);
        jcModelConta(o);
    }
    
    /**
     * <p><strong>EN:</strong> Builds a table model for accounts (Bank, Agency, Account Number, Type) and assigns it to the provided table.</p>
     * <p><strong>IT:</strong> Crea un modello di tabella per i conti (Banca, Agenzia, Numero Conto, Tipo) e lo assegna alla tabella fornita.</p>
     * <p><strong>PT-BR:</strong> Monta um modelo de tabela para contas (Banco, Agência, Número da Conta, Tipo) e o aplica na tabela informada.</p>
     *
     * @param o EN: table to receive the account model | IT: tabella su cui applicare il modello | PT-BR: tabela que receberá o modelo
     */
    public void tabelaConta(JTable o){
        String[]nomeColuna = {"Banco", "Agencia", "Numero Conta", "Tipo"};
        lista = contar.getLista();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for(int i = 0; i < lista.size(); i++){
            conta = (Conta)lista.get(i);
            dadosArray[i][0] = conta.getBanco().getDs_banco();
            dadosArray[i][1] = conta.getNm_agencia();
            dadosArray[i][2] = conta.getNm_conta();
            dadosArray[i][3] = conta.getTpconta().getDs_tpconta();
        }
        DefaultTableModel tConta = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tConta);
    }
    
    /**
     * <p><strong>EN:</strong> Returns the object corresponding to the currently selected row in the accounts table, or null if none is selected (a message is shown).</p>
     * <p><strong>IT:</strong> Restituisce l’oggetto corrispondente alla riga selezionata nella tabella dei conti, oppure null se nessuna riga è selezionata (viene mostrato un messaggio).</p>
     * <p><strong>PT-BR:</strong> Retorna o objeto correspondente à linha selecionada na tabela de contas ou null se nenhuma estiver selecionada (uma mensagem é exibida).</p>
     *
     * @param o EN: table from which to read the selected row | IT: tabella da cui leggere la riga selezionata | PT-BR: tabela de onde ler a linha selecionada
     * @return EN: selected account object or null | IT: oggetto conto selezionato o null | PT-BR: objeto de conta selecionado ou null
     */
    public Object getSelectedObject(JTable o){  
        Object selecionado = null;
        int linhaSelecionada = o.getSelectedRow();
        if(linhaSelecionada >= 0){
            selecionado = lista.get(linhaSelecionada);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma conta.");
        }
        return selecionado;  
    }
}
