package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AtivoSaldoUtil {    
    
    AtivoSaldo asaldo = new AtivoSaldo();
    AtivoSaldoRepository asaldor = new AtivoSaldoRepository();
    
    ArrayList lista = new ArrayList();

    public int atualizaSaldo(int trans, int nm_saldo, int nm_qtde){
        int resultado = 0;
        if(trans == 5){
            resultado = nm_saldo + nm_qtde;
        }
        if(trans == 6){
            resultado = nm_saldo - nm_qtde;
        }
        return resultado;       
    }
    
    public BigDecimal rendaTotal(int nm_qtde, BigDecimal vl_preco){
        BigDecimal resultado = null;
        resultado = vl_preco.multiply(new BigDecimal(nm_qtde));
        return resultado;
    }
    
    public void tabelaAtivoSaldo(JTable o, int cd_tpativo){
        String[] nomeColuna = {"Ativo", "Quantidade"};
        lista = asaldor.getLista(cd_tpativo);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        
        for(int i=0; i < lista.size(); i++){
            asaldo = (AtivoSaldo)lista.get(i);
            dadosArray[i][0] = asaldo.getAtivo();
            dadosArray[i][1] = Utilidade.formatoValor.format(asaldo.getNm_qtde());
        }
        DefaultTableModel tPoupap = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tPoupap);
    }

    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um item da lista.");
        }
        return selecionado;    
    }  
}
