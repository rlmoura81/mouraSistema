package br.com.rlmoura81.moura.imovel;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ImovelUtil {
    
    Imovel imovel = new Imovel();
    ImovelRepository imovelr = new ImovelRepository();
    
    ArrayList lista = new ArrayList();
    
    public void jcImovel(JComboBox o){
        ArrayList<Imovel> listaimovel = imovelr.getLista();
        Imovel iZero = new Imovel(0, "<Imovel>", null, null, null, null, null, 0);
        o.addItem(iZero);
        for(Imovel imovel : listaimovel){
            o.addItem(imovel);
        }
    }
    
    public void tabelaImovel(JTable o){
        String[] nomeColuna = {"Matricula", "Metragem", "Valor Matricula", "Cidade", "Descrição"};
        lista = imovelr.getLista();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        
        for (int i = 0; i < lista.size(); i++){
            imovel = (Imovel) lista.get(i);
            dadosArray[i][0] = imovel.getNm_matricula();
            dadosArray[i][1] = Utilidade.formatoValor.format(imovel.getNm_metragem());
            dadosArray[i][2] = Utilidade.formatoValor.format(imovel.getNm_valorMatricula());
            dadosArray[i][3] = imovel.getCidade();
            dadosArray[i][4] = imovel.getDs_descricao();
        }
        DefaultTableModel tImovel = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tImovel);
    }
    
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecinada = o.getSelectedRow();
        if(linhaselecinada >= 0){
            selecionado = lista.get(linhaselecinada);
        }else{
            JOptionPane.showMessageDialog(null,"Selecione um imovel da lista.", "Imóvel", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;
    }
}
