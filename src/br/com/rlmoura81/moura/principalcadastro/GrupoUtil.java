package br.com.rlmoura81.moura.principalcadastro;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GrupoUtil {
    
    Grupo grupo = new Grupo();
    GrupoRepository grupor = new GrupoRepository();
    
    ArrayList lista = new ArrayList();
       
    public  void jcGrupo(JComboBox o){
        ArrayList<Grupo> listagrupo = grupor.getLista();
        Grupo cZero = new Grupo(0, "<Grupo>", 0);
        o.addItem(cZero);
        for(Grupo grupo : listagrupo){
            o.addItem(grupo);
        }
    } 
    public void tabelaGrupo(JTable o) {
        String[] nomeColuna = {"Grupo", "Código"};
        lista = grupor.getLista();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        for (int i = 0; i < lista.size(); i++){
             grupo = (Grupo) lista.get(i);
             dadosArray[i][0] = grupo.getDs_grupo();
             dadosArray[i][1] = grupo.getCd_grupo();
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
            JOptionPane.showMessageDialog(null, "Selecione um grupo da lista.", "Grupo", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;    
    }        
}
