package br.com.rlmoura81.moura.cartao;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CartaoLancamentoFechamentoUtil {
    
    CartaoLancamentoFechamento cartaolancf = new CartaoLancamentoFechamento();
    CartaoLancamentoFechamentoRepository cartaolancfr = new CartaoLancamentoFechamentoRepository();
    
    ArrayList lista = new ArrayList();
    
    public BigDecimal calculaValorFatura(Calendar data, int cd_cartao){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = cartaolancfr.getLista(data, cd_cartao);
        for(int i=0; i < lista.size(); i++){
            cartaolancf = (CartaoLancamentoFechamento)lista.get(i);
            resultado = resultado.add(cartaolancf.getNm_valor());
        }
        return resultado;
    }
    
    public void jcDataFechamento(JComboBox o, int cd_cartao){
        ArrayList<CartaoLancamentoFechamento> lista = cartaolancfr.getLista(cd_cartao);
        CartaoLancamentoFechamento cbZero = new CartaoLancamentoFechamento(0, null);
        o.addItem(cbZero);
        for(CartaoLancamentoFechamento clf : lista){
            o.addItem(Utilidade.formatoData.format(clf.getDt_fechamento().getTime()));
        }
    }
    
    public void tabelaCartaoFechamento(JTable o, Calendar data, int cd_cartao){
        String[] nomeColuna = {"Data Despesa", "Descrição", "Valor", "Parcela", "Categoria"};
        lista = cartaolancfr.getLista(data, cd_cartao);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        
        for(int i=0; i < lista.size(); i++){
            cartaolancf = (CartaoLancamentoFechamento)lista.get(i);
            dadosArray[i][0] = Utilidade.formatoData.format(cartaolancf.getDt_despesa().getTime());
            dadosArray[i][1] = cartaolancf.getDs_despesa();
            dadosArray[i][2] = Utilidade.formatoValor.format(cartaolancf.getNm_valor());
            dadosArray[i][3] = cartaolancf.getNm_parcela();
            dadosArray[i][4] = cartaolancf.getCategoria();
        }
        DefaultTableModel tCartaoLanc = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tCartaoLanc);
    }    
    
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um lançamento da lista.", "Cartão Lançamento Fechamento", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;    
    }     
}
