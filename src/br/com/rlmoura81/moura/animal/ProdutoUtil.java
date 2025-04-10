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
    
    public void jcProduto(JComboBox o) {
        ArrayList<Produto> listaproduto = produtor.getLista();
        Produto pZero = new Produto(0, "<Produto>", null, 0);
        o.addItem(pZero);
        for (Produto produto : listaproduto) {
            o.addItem(produto);
        }
    }
    
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
