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
    
    public void jcPessoaFisica(JComboBox o){      
        ArrayList<PessoaFisica> listapf = pessoafisicar.getListaPessoaFisica();
        PessoaFisica pfZero = new PessoaFisica(0, "<Selecionar>", null, null, null, null, null);
        o.addItem(pfZero);
        for(PessoaFisica pessoa : listapf){
            o.addItem(pessoa);
        }
    }
    
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
