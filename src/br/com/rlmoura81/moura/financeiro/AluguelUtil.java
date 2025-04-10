package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AluguelUtil {
        
    Aluguel aluguel = new Aluguel();
    AluguelRepository aluguelr = new AluguelRepository();
    
    ArrayList lista = new ArrayList();
    
    public BigDecimal valorLiquido(BigDecimal vl_bruto, BigDecimal vl_desc){
        BigDecimal resultado;
        if(vl_desc == null){
            vl_desc = Utilidade.converter("0,00");
        }
        resultado = vl_bruto.subtract((vl_bruto.multiply(vl_desc)).divide(Utilidade.converter("100,00")));
        return resultado;
    }
    
    public BigDecimal valorDesconto(BigDecimal valor, BigDecimal desconto){
        BigDecimal resultado;
        resultado = valor.subtract(desconto);
        return resultado;
    }

    public void jcAluguel(JComboBox o){
        ArrayList<Aluguel> listaaluguel = aluguelr.getLista();
        Aluguel aZero = new Aluguel(0, "Aluguel", null, null, 0, null, null, null, 0);
        o.addItem(aZero);
        for(Aluguel a : listaaluguel){
            o.addItem(a);
        }
    }
    public void tabelaAluguel(JTable o){
        String[]nomeColuna = {"Contrato", "Imovel", "Valor do aluguel", "Taxa de Adm.", "Dia de deposito", "Contrato vence"};
        lista = aluguelr.getLista();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        
        for(int i = 0; i < lista.size(); i++){
            aluguel = (Aluguel) lista.get(i);
            dadosArray[i][0] = aluguel.getNm_contrato();
            dadosArray[i][1] = aluguel.getImovel();
            dadosArray[i][2] = Utilidade.formatoValor.format(aluguel.getNm_vlaluguel());
            dadosArray[i][3] = Utilidade.formatoValor.format(aluguel.getNm_vladm());
            dadosArray[i][4] = aluguel.getDt_deposito();
            dadosArray[i][5] = Utilidade.formatoData.format(aluguel.getDt_contratovenc().getTime());
        }
        DefaultTableModel tAluguel = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tAluguel);
    }
    
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um aluguel da lista.");
        }
        return selecionado;
    }    
}
