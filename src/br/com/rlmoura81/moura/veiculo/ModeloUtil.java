package br.com.rlmoura81.moura.veiculo;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ModeloUtil {
    
    Modelo modelo = new Modelo();
    ModeloRepository modelor = new ModeloRepository();
    
    ArrayList lista = new ArrayList();
    
    public void jcModelo(JComboBox o){
        ArrayList<Modelo> listamodelo = modelor.getLista();
        Modelo mZero = new Modelo(0, "<Modelo>", null, 0);
        o.addItem(mZero);
        for(Modelo m : listamodelo){
            o.addItem(m);
        }
    }    
    
    public void tabelaModelo(JTable o){
        String[] nomeColuna = {"Modelo", "Marca"};
        lista = modelor.getLista();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for (int i = 0; i < lista.size(); i++){
            modelo = (Modelo) lista.get(i);
            dadosArray[i][0] = modelo.getDs_modelo();
            dadosArray[i][1] = modelo.getMarca();
        }        
        DefaultTableModel tModelo = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tModelo);
    }
    
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione a marca na lista.", "Modelo", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;
    }    
}
