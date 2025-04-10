package br.com.rlmoura81.moura.principalcadastro;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CidadeUtil {
    
    Cidade cidade = new Cidade();
    CidadeRepository cidader = new CidadeRepository();
    
    ArrayList lista = new ArrayList();
    
    public void jcCidade(JComboBox o){
        ArrayList<Cidade> listacidade =  cidader.getLista();
        Cidade cZero = new Cidade(0, "<Cidade>", null);
        o.addItem(cZero);
        for(Cidade cidade : listacidade){
            o.addItem(cidade);
        }
    }
    
    public void tabelaCidade(JTable o){
        String[] nomeColuna = {"Cidade", "Estado"};
        lista = cidader.getLista();
        Object [][] dadosArray = new Object[lista.size()][nomeColuna.length];
        for(int i = 0; i < lista.size(); i++){
            cidade = (Cidade) lista.get(i);
            dadosArray[i][0] = cidade.getDs_Cidade();
            dadosArray[i][1] = cidade.getEstado();
        }
        DefaultTableModel tCidade = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tCidade);
    }

    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma cidade da lista.", "Cidade", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;    
    }    
}
