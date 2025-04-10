package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MovimentoCaixaUtil {
    
    MovimentoCaixa movcx = new MovimentoCaixa();
    MovimentoCaixaRepository movcxr = new MovimentoCaixaRepository();
    
    ArrayList lista = new ArrayList();

    public BigDecimal somaCredito(int cd_conta){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = movcxr.getListaMes(cd_conta);
        for(int i=0; i < lista.size(); i++){
            movcx = (MovimentoCaixa)lista.get(i);
            resultado = resultado.add(movcx.getVl_credito());
        }
        return resultado;
    }
    
    public BigDecimal somaCredito(int cd_conta, String dt_inicio, String dt_final){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = movcxr.getLista(cd_conta, dt_inicio, dt_final);
        for(int i=0; i < lista.size(); i++){
            movcx = (MovimentoCaixa)lista.get(i);
            resultado = resultado.add(movcx.getVl_credito());
        }
        return resultado;
    }

    public BigDecimal somaDebito(int cd_conta){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = movcxr.getListaMes(cd_conta);
        for(int i=0; i < lista.size(); i++){
            movcx = (MovimentoCaixa)lista.get(i);
            resultado = resultado.add(movcx.getVl_debito());
        }
        return resultado;
    }
    
    public BigDecimal somaDebito(int cd_conta, String dt_inicio, String dt_final){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = movcxr.getLista(cd_conta, dt_inicio, dt_final);
        for(int i=0; i < lista.size(); i++){
            movcx = (MovimentoCaixa)lista.get(i);
            resultado = resultado.add(movcx.getVl_debito());
        }
        return resultado;
    }
    
    public void tablelaMovimentoCaixa(JTable o, int cd_conta){
        String[] nomeColuna = {"Data", "Descrição", "Documento", "Crédito", "Débito", "Transação", "Categoria"};
        lista = movcxr.getListaMes(cd_conta);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for(int i=0; i < lista.size(); i++){
            movcx = (MovimentoCaixa)lista.get(i);
            dadosArray[i][0] = Utilidade.formatoData.format(movcx.getDt_transacao().getTime());
            dadosArray[i][1] = movcx.getDs_descricao();
            dadosArray[i][2] = movcx.getNm_documento();
            dadosArray[i][3] = Utilidade.formatoValor.format(movcx.getVl_credito());
            dadosArray[i][4] = Utilidade.formatoValor.format(movcx.getVl_debito());
            dadosArray[i][5] = movcx.getTipotransacao().getDs_tptrans();
            dadosArray[i][6] = movcx.getCategoria();
        }
        DefaultTableModel tMovCaixa = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tMovCaixa);
    }
    
    public void tablelaMovimentoCaixa(JTable o, int cd_conta, String dt_inicio, String dt_final){
        String[] nomeColuna = {"Data", "Descrição", "Documento", "Crédito", "Débito", "Transação", "Categoria"};
        lista = movcxr.getLista(cd_conta, dt_inicio, dt_final);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for(int i=0; i < lista.size(); i++){
            movcx = (MovimentoCaixa)lista.get(i);
            dadosArray[i][0] = Utilidade.formatoData.format(movcx.getDt_transacao().getTime());
            dadosArray[i][1] = movcx.getDs_descricao();
            dadosArray[i][2] = movcx.getNm_documento();
            dadosArray[i][3] = Utilidade.formatoValor.format(movcx.getVl_credito());
            dadosArray[i][4] = Utilidade.formatoValor.format(movcx.getVl_debito());
            dadosArray[i][5] = movcx.getTipotransacao().getDs_tptrans();
            dadosArray[i][6] = movcx.getCategoria();
        }
        DefaultTableModel tMovCaixa = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tMovCaixa);
    }
    
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma movimentação da lista.");
        }
        return selecionado;    
    }  
    
//MOVIMENTO CAIXA LANCAMENTO    
    public BigDecimal somaCreditoLanc(int cd_conta){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = movcxr.getListaContaLanc(cd_conta);
        for(int i=0; i < lista.size(); i++){
            movcx = (MovimentoCaixa)lista.get(i);
            resultado = resultado.add(movcx.getVl_credito());
        }
        return resultado;
    }

    public BigDecimal somaDebitoLanc(int cd_conta){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = movcxr.getListaContaLanc(cd_conta);
        for(int i=0; i < lista.size(); i++){
            movcx = (MovimentoCaixa)lista.get(i);
            resultado = resultado.add(movcx.getVl_debito());
        }
        return resultado;
    }
    
    public void tablelaMovimentoCaixaLanc(JTable o, int cd_conta){
        String[] nomeColuna = {"Data", "Descrição", "Documento", "Crédito", "Débito", "Transação", "Categoria"};
        lista = movcxr.getListaContaLanc(cd_conta);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for(int i=0; i < lista.size(); i++){
            movcx = (MovimentoCaixa)lista.get(i);
            dadosArray[i][0] = Utilidade.formatoData.format(movcx.getDt_transacao().getTime());
            dadosArray[i][1] = movcx.getDs_descricao();
            dadosArray[i][2] = movcx.getNm_documento();
            dadosArray[i][3] = Utilidade.formatoValor.format(movcx.getVl_credito());
            dadosArray[i][4] = Utilidade.formatoValor.format(movcx.getVl_debito());
            dadosArray[i][5] = movcx.getTipotransacao().getDs_tptrans();
            dadosArray[i][6] = movcx.getCategoria();
        }
        DefaultTableModel tMovCaixa = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tMovCaixa);
    }
}
