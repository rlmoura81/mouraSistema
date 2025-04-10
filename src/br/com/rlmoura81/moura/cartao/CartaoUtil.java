package br.com.rlmoura81.moura.cartao;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class CartaoUtil {
        
    Cartao cartao = new Cartao();
    CartaoRepository cartaor = new CartaoRepository();
    
    ArrayList lista = new ArrayList();

    public void jcCartao(JComboBox o, int cd_banco){
        ArrayList<Cartao> listacartao = cartaor.getLista(cd_banco);
        Cartao cartaoZero = new Cartao(0, "<Cartão>", null, null, null, null, 0);
        o.addItem(cartaoZero);
        for(Cartao cartao : listacartao){
            o.addItem(cartao);
        }
    }
    
    public void tabelaCartao(JTable o, int cd_banco){
        String[] nomeColuna = {"Numero", "Limite", "Data Venc.", "Bandeira"};
        lista = cartaor.getLista(cd_banco);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        
        for(int i = 0; i < lista.size(); i++){
            cartao = (Cartao) lista.get(i);
            dadosArray[i][0] = cartao.getNm_cartao();
            dadosArray[i][1] = Utilidade.formatoValor.format(cartao.getNm_limite());
            dadosArray[i][2] = Utilidade.formatoData.format(cartao.getDt_vencimento().getTime());
            dadosArray[i][3] = cartao.getCartaobandeira();
        }
        DefaultTableModel tCartao = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tCartao);
    }
    
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um cartão da lista.", "Cartão", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;
    }

    //Valor Formato Numero Cartao
    public void formataNumCartao(Object o){
            try {
                MaskFormatter mascDoc = new MaskFormatter("####.####.####.####");
                mascDoc.setPlaceholderCharacter(' ');
                mascDoc.install((JFormattedTextField) o);            
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Verifique ParseException ao formatar campo do numero do cartão - " + ex.getMessage(),
                                              "Erro de sistema", JOptionPane.ERROR_MESSAGE);
            }
    }
    
    //Documento Converte - retira a mascara    
    public static String converterNumCartao(String numDoc){
        String numConv = numDoc.replace(".", "");
        return numConv;
    }
    
    //Cartao Valida Formato Campo
    public boolean validaNumCartao(String campodoc){
        if(campodoc.equals("    .    .    .    ")){
            JOptionPane.showMessageDialog(null, "Número do cartão em branco.");
            return false;
        }
        return true;
    }
}
