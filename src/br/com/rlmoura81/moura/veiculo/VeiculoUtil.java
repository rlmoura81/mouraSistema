package br.com.rlmoura81.moura.veiculo;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VeiculoUtil {
    
    Veiculo veiculo = new Veiculo();
    VeiculoRepository veiculor = new VeiculoRepository();

    CombustivelRepository combustivelr = new CombustivelRepository();
    
    CoresRepository corr = new CoresRepository();
    
    ArrayList lista = new ArrayList();
    
    public void jcCombusivel(JComboBox o){
        ArrayList<Combustivel> listacombustivel = combustivelr.getLista();
        Combustivel cZero = new Combustivel(0, "<Combustivel>");
        o.addItem(cZero);
        for(Combustivel combustivel : listacombustivel){
            o.addItem(combustivel);
        }
    }
    
    public void jcCor(JComboBox o){
        ArrayList<Cores> listacor = corr.getLista();
        Cores cZero = new Cores(0, "<Cor>");
        o.addItem(cZero);
        for(Cores cor : listacor){
            o.addItem(cor);
        }
    }
    
    public void jcVeiculo(JComboBox o) {
        ArrayList<Veiculo> listaveiculo = veiculor.getLista();
        Veiculo vZero = new Veiculo(0, 0, 0, "<Renavam>", "<Placa>", 0, null, null, null, 0);
        o.addItem(vZero);
        for (Veiculo veiculo : listaveiculo) {
            o.addItem(veiculo);
        }
    }
    
    public void tabelaVeiculo(JTable o){
        String[] nomeColuna = {"Placa", "Modelo", "Renavam", "Combustivel", "Potencia", "Ano Fab / Mod", "Cor"};
        lista = veiculor.getLista();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        
        for(int i=0; i < lista.size(); i++){
            veiculo = (Veiculo)lista.get(i);
            dadosArray[i][0] = veiculo.getNm_placa();
            dadosArray[i][1] = veiculo.getModelo();
            dadosArray[i][2] = veiculo.getNm_renavam();
            dadosArray[i][3] = veiculo.getCombustivel();
            dadosArray[i][4] = veiculo.getNm_potencia();
            dadosArray[i][5] = veiculo.getDt_anofab() + "/" + veiculo.getDt_anomod();
            dadosArray[i][6] = veiculo.getCor();
        }
        DefaultTableModel tVeiculo = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tVeiculo);
    }    

        public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecinada = o.getSelectedRow();
        if(linhaselecinada >= 0){
            selecionado = lista.get(linhaselecinada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um veiculo da lista.", "Veiculo", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;
    }
}
