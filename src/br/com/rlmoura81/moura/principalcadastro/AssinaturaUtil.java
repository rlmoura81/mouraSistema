package br.com.rlmoura81.moura.principalcadastro;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AssinaturaUtil {
    
    Assinatura assinatura = new Assinatura();
    AssinaturaRepository assinaturar = new AssinaturaRepository();
    
    ArrayList lista = new ArrayList();
        
    public void tabelaAssinatura(JTable o){
        String[] nomeColuna = {"Serviço", "Login", "Senha", "Valor", "Plano", "Validade", "Prestadora"};
        lista = assinaturar.getLista();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        
        for(int i=0; i < lista.size(); i++){
            assinatura = (Assinatura)lista.get(i);
            dadosArray[i][0] = assinatura.getDs_servico();
            dadosArray[i][1] = assinatura.getDs_login();
            dadosArray[i][2] = assinatura.getDs_senha();
            dadosArray[i][3] = Utilidade.formatoValor.format(assinatura.getNm_valor());
            dadosArray[i][4] = planoAssinatura(assinatura.getTp_assinatura());
            dadosArray[i][5] = Utilidade.formatoData.format(assinatura.getDt_validade().getTime());
            dadosArray[i][6] = assinatura.getPresserv();
        }        
        DefaultTableModel tAssinatura = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tAssinatura);
    }
    
    public void tabelaAssinatura(JTable o, String ds_servico){
        String[] nomeColuna = {"Serviço", "Login", "Senha", "Valor", "Plano", "Validade", "Prestadora"};
        lista = assinaturar.getLista(ds_servico);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        
        for(int i=0; i < lista.size(); i++){
            assinatura = (Assinatura)lista.get(i);
            dadosArray[i][0] = assinatura.getDs_servico();
            dadosArray[i][1] = assinatura.getDs_login();
            dadosArray[i][2] = assinatura.getDs_senha();
            dadosArray[i][3] = Utilidade.formatoValor.format(assinatura.getNm_valor());
            dadosArray[i][4] = planoAssinatura(assinatura.getTp_assinatura());
            dadosArray[i][5] = Utilidade.formatoData.format(assinatura.getDt_validade().getTime());
            dadosArray[i][6] = assinatura.getPresserv();
        }        
        DefaultTableModel tAssinatura = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tAssinatura);
    }
    
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma assinatura da lista.", "Assinatura", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;
    } 
    
    private String planoAssinatura(int tpassinatura){
        String plano = "-";
        if(tpassinatura == 1){
            plano = "Mês";
        }
        if(tpassinatura == 2){
            plano = "Ano";
        }
        return plano;
    }
}