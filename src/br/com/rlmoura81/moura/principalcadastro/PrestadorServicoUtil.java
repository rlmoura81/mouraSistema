package br.com.rlmoura81.moura.principalcadastro;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PrestadorServicoUtil {
    
    PrestadorServico presserv = new PrestadorServico();
    PrestadorServicoRepository presservr = new PrestadorServicoRepository();
    
    Utilidade util = new Utilidade();
    ArrayList lista = new ArrayList();

    public void jcPresserv(JComboBox o) {
        ArrayList<PrestadorServico> listapresserv = presservr.getLista();
        PrestadorServico psZero = new PrestadorServico(0, "<Prestador>", null, null, 0);
        o.addItem(psZero);
        for (PrestadorServico ps : listapresserv) {
            o.addItem(ps);
        }
    }
    
    public void jcPresserv(JComboBox o, int cd_modelo) {
        ArrayList<PrestadorServico> listapresserv = presservr.getLista(cd_modelo);
        PrestadorServico psZero = new PrestadorServico(0, "<Prestador>", null, null, 0);
        o.addItem(psZero);
        for (PrestadorServico ps : listapresserv) {
            o.addItem(ps);
        }
    }
    public void tabelaPresServ(JTable o){
        String[] nomeColuna = {"Nome/Nome Fantasia","Razao Social" , "Documento"};
        lista = presservr.getLista();
        Object [][] dadosArray = new Object[lista.size()][nomeColuna.length];
        for(int i = 0; i < lista.size(); i++){
            presserv = (PrestadorServico) lista.get(i);
            dadosArray[i][0] = presserv.getDs_presserv();
            dadosArray[i][1] = presserv.getDs_razaosocial();
            dadosArray[i][2] = Utilidade.retornaDocumentoFormatado(presserv.getNm_documento(), presserv.getNm_documento().length());
        }
        DefaultTableModel tPresServ = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tPresServ);
    }
    
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma prestadora de serviço da lista.", "Prestador Serviço", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;    
    }
}
