package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DespesaUtil {

    Despesa despesa = new Despesa();
    DespesaRepository despesar = new DespesaRepository();
    
    ArrayList lista = new ArrayList();
    
    public BigDecimal calculaDespesaTotal(){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = despesar.getLista();
        for(int i=0; i < lista.size(); i++){
            despesa = (Despesa)lista.get(i);
            resultado = resultado.add(despesa.getNm_valor());
        }
        return resultado;
    }
    
    public BigDecimal calculaDespesaGrupo(int cd_grupo){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = despesar.getLista(cd_grupo);
        for(int i=0; i < lista.size(); i++){
            despesa = (Despesa)lista.get(i);
            resultado = resultado.add(despesa.getNm_valor());
        }
        return resultado;
    }
    
    public void jcDespesa(JComboBox o){
        ArrayList<Despesa> lista = despesar.getLista();
        Despesa depZero = new Despesa(0, "<Despesas>", null, null, null, 0);
        o.addItem(depZero);
        for(Despesa despesa : lista){
            o.addItem(despesa);
        }
    }

    public void tabelaDespesa(JTable o) {
        String[] nomeColuna = {"Despesa", "Valor", "Prestadora Serviço", "Categoria"};
        lista = despesar.getLista();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];

        for (int i = 0; i < lista.size(); i++) {
            despesa = (Despesa) lista.get(i);
            dadosArray[i][0] = despesa.getDs_despesa();
            dadosArray[i][1] = Utilidade.formatoValor.format(despesa.getNm_valor());
            dadosArray[i][2] = despesa.getPresserv().getDs_presserv();
            dadosArray[i][3] = despesa.getCategoria().getDs_Categoria();
        }
        DefaultTableModel tDespesa = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tDespesa);
    }

    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecianda = o.getSelectedRow();
        if(linhaselecianda >= 0) {
            selecionado = lista.get(linhaselecianda);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma despesa");
        }
        return selecionado;
    }
}
