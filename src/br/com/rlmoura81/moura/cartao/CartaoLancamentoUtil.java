package br.com.rlmoura81.moura.cartao;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CartaoLancamentoUtil {
    
    CartaoLancamento cartaolanc = new CartaoLancamento();
    CartaoLancamentoRepository cartaolancr = new CartaoLancamentoRepository();
    
    ArrayList lista = new ArrayList();
    
    public BigDecimal calculaValorFatura(int cd_cartao){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = cartaolancr.getLista(cd_cartao);
        for(int i=0; i < lista.size(); i++){
            cartaolanc = (CartaoLancamento)lista.get(i);
            resultado = resultado.add(cartaolanc.getNm_valor());
        }
        return resultado;
    }
    
    public void tabelaCartaoLancamento(JTable o, int cd_cartao){
        String[] nomeColuna = {"Data Despesa", "Descrição", "Valor", "Qtde Parcela", "Categoria"};
        lista = cartaolancr.getLista(cd_cartao);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        for(int i=0; i < lista.size(); i++){
            cartaolanc = (CartaoLancamento)lista.get(i);
            dadosArray[i][0] = Utilidade.formatoData.format(cartaolanc.getDt_despesa().getTime());
            dadosArray[i][1] = cartaolanc.getDs_despesa();
            dadosArray[i][2] = Utilidade.formatoValor.format(cartaolanc.getNm_valor());
            dadosArray[i][3] = cartaolanc.getNm_parcela();
            dadosArray[i][4] = cartaolanc.getCategoria();
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
            JOptionPane.showMessageDialog(null, "Selecione um lançamento da lista.", "Cartão Lançamento", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;    
    }     

}
