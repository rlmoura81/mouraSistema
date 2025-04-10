package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RendaUtil {
    
    Renda renda = new Renda();
    RendaRepository rendar = new RendaRepository();
    
    ArrayList lista = new ArrayList();
    
    public BigDecimal calculaRendaTotal(){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = rendar.getLista();
        for(int i=0; i < lista.size(); i++){
            renda = (Renda)lista.get(i);
            resultado = resultado.add(renda.getNm_valor());
        }
        return resultado;
    }
    
    public BigDecimal calculaProventoTotal(int nm_qtde, BigDecimal vl_provento){
        BigDecimal resultado = Utilidade.converter("0,00");
        resultado = vl_provento.multiply(BigDecimal.valueOf(nm_qtde));
        return resultado;
    }
    
    public void jcRenda(JComboBox o){
        ArrayList<Renda> listarenda = rendar.getLista();
        Renda rZero = new Renda(0, null, "<Renda>", null, null, 0);
        o.addItem(rZero);
        for(Renda renda : listarenda){
            o.addItem(renda);
        }
    } 

    public void jcRendaMes(JComboBox o, Object dtInicial, Object dtFinal){
        ArrayList<Renda> listarenda = rendar.getLista(dtInicial, dtFinal);
        Renda rZero = new Renda(0, null, "<Renda>", null, null, 0);
        o.addItem(rZero);
        for(Renda renda : listarenda){
            o.addItem(renda);
        }
    } 
    
    public void tabelaRenda(JTable o) {
        String[] nomeColuna = {"Data", "Despesa", "Valor", "Tipo"};
        lista = rendar.getLista();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];

        for (int i = 0; i < lista.size(); i++) {
            renda = (Renda) lista.get(i);
            dadosArray[i][0] = Utilidade.formatoData.format(renda.getDt_renda().getTime());
            dadosArray[i][1] = renda.getDs_renda();
            dadosArray[i][2] = Utilidade.formatoValor.format(renda.getNm_valor());
            dadosArray[i][3] = renda.getTprenda().getDs_tprenda();
        }
        DefaultTableModel tRenda = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tRenda);
    }
    
    public void tabelaRendaFiltro(JTable o, int num) {
        String[] nomeColuna = {"Data", "Despesa", "Valor", "Tipo"};
        lista = rendar.getLista(num);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];

        for (int i = 0; i < lista.size(); i++) {
            renda = (Renda) lista.get(i);
            dadosArray[i][0] = Utilidade.formatoData.format(renda.getDt_renda().getTime());
            dadosArray[i][1] = renda.getDs_renda();
            dadosArray[i][2] = Utilidade.formatoValor.format(renda.getNm_valor());
            dadosArray[i][3] = renda.getTprenda().getDs_tprenda();
        }
        DefaultTableModel tRenda = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tRenda);
    }
    
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecianda = o.getSelectedRow();
        if(linhaselecianda >= 0) {
            selecionado = lista.get(linhaselecianda);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma renda da lista.");
        }
        return selecionado;
    }
}
