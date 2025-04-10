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
       
    public  void jcCategoria(JComboBox o){
        ArrayList<Categoria> listacategoria = categoriar.getLista();
        Categoria cZero = new Categoria(0, "<Categoria>", null, 0);
        o.addItem(cZero);
        for(Categoria categoria : listacategoria){
            o.addItem(categoria);
        }
    } 
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
