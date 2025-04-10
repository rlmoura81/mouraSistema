package br.com.rlmoura81.moura.principal;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ModuloAplicativoUtil {
    
    ModuloAplicativo modapp = new ModuloAplicativo();
    ModuloAplicativoRepository modappr = new ModuloAplicativoRepository();
    
    ArrayList lista = new ArrayList();

    public void tabelaModuloAppCategoria(JTable o){
        String[] nomeColuna = {"Modulo", "Categoria"};
        lista = modappr.getListaCatMod();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        
        for(int i=0; i < lista.size(); i++){
            modapp = (ModuloAplicativo)lista.get(i);
            dadosArray[i][0] = modapp.getModulo();
            dadosArray[i][1] = modapp.getCategoria();
        }
        DefaultTableModel tModApp = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tModApp);
    }
    
    public void tabelaModuloAppPresserv(JTable o){
        String[] nomeColuna = {"Modulo", "Prestador"};
        lista = modappr.getListaPresservMod();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        
        for(int i=0; i < lista.size(); i++){
            modapp = (ModuloAplicativo)lista.get(i);
            dadosArray[i][0] = modapp.getModulo();
            dadosArray[i][1] = modapp.getPresserv();
        }
        DefaultTableModel tModApp = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tModApp);
    }    
    
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um iten da lista.", "Modulo Aplicativo", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;    
    }     
}
