package br.com.rlmoura81.moura.cartao;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CartaoParcelamentoUtil {
    
    CartaoParcelamento cartaoparc = new CartaoParcelamento();
    CartaoParcelamentoRepository cartaoparcr = new CartaoParcelamentoRepository();
    
    ArrayList lista = new ArrayList();    
    
    public void tabelaCartaoParcela(JTable o, int cartao){
        String[] nomeColuna = {"Descrição", "Data Parcela", "Data Despesa", "Valor", "Parcela", "Qtde Parcela", "Categoria"};
        lista = cartaoparcr.getLista(cartao);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for(int i=0; i < lista.size(); i++){
            cartaoparc = (CartaoParcelamento)lista.get(i);
            dadosArray[i][0] = cartaoparc.getDs_despesa();
            dadosArray[i][1] = Utilidade.formatoData.format(cartaoparc.getDt_parcela().getTime());
            dadosArray[i][2] = Utilidade.formatoData.format(cartaoparc.getDt_despesa().getTime());
            dadosArray[i][3] = Utilidade.formatoValor.format(cartaoparc.getNm_valor());
            dadosArray[i][4] = cartaoparc.getNm_parcelapag();
            dadosArray[i][5] = cartaoparc.getNm_parcela();
            dadosArray[i][6] = cartaoparc.getCategoria();
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
            JOptionPane.showMessageDialog(null, "Selecione um item da lista.", "Cartão Parcelamento", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;    
    }      
}