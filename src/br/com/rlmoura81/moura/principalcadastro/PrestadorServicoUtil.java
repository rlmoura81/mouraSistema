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
    ArrayList lista = new ArrayList();

    /**
     * <p><strong>EN:</strong> Populates a {@code JComboBox} with the list of Service Providers,
     * adding a default placeholder entry ("&lt;Prestador&gt;") at the first position.</p>
     *
     * <p><strong>IT:</strong> Popola un {@code JComboBox} con l’elenco dei Fornitori di Servizi,
     * aggiungendo una voce predefinita ("&lt;Prestador&gt;") come prima posizione.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche um {@code JComboBox} com a lista de Prestadores de Serviço,
     * adicionando uma entrada padrão ("&lt;Prestador&gt;") na primeira posição.</p>
     */
    public void jcPresserv(JComboBox o) {
        ArrayList<PrestadorServico> listapresserv = presservr.getLista();
        PrestadorServico psZero = new PrestadorServico(0, "<Prestador>", null, null, 0);
        o.addItem(psZero);
        for (PrestadorServico ps : listapresserv) {
            o.addItem(ps);
        }
    }
    
    /**
     * <p><strong>EN:</strong> Populates a {@code JComboBox} with Service Providers filtered by a Module ID,
     * adding a default placeholder entry ("&lt;Prestador&gt;").</p>
     *
     * <p><strong>IT:</strong> Popola un {@code JComboBox} con i Fornitori di Servizi filtrati per ID Modulo,
     * aggiungendo una voce predefinita ("&lt;Prestador&gt;").</p>
     *
     * <p><strong>PT-BR:</strong> Preenche um {@code JComboBox} com Prestadores de Serviço filtrados por ID de Módulo,
     * adicionando uma entrada padrão ("&lt;Prestador&gt;").</p>
     */
    public void jcPresserv(JComboBox o, int cd_modelo) {
        ArrayList<PrestadorServico> listapresserv = presservr.getLista(cd_modelo);
        PrestadorServico psZero = new PrestadorServico(0, "<Prestador>", null, null, 0);
        o.addItem(psZero);
        for (PrestadorServico ps : listapresserv) {
            o.addItem(ps);
        }
    }
    
    /**
     * <p><strong>EN:</strong> Builds a table model for a {@code JTable} containing
     * Service Providers, showing Trade Name, Corporate Name, and formatted Document.</p>
     *
     * <p><strong>IT:</strong> Crea un modello di tabella per un {@code JTable} contenente
     * i Fornitori di Servizi, mostrando Nome/Fantasia, Ragione Sociale e Documento formattato.</p>
     *
     * <p><strong>PT-BR:</strong> Monta um modelo de tabela para um {@code JTable} contendo
     * Prestadores de Serviço, exibindo Nome/Nome Fantasia, Razão Social e Documento formatado.</p>
     */
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
    
    /**
     * <p><strong>EN:</strong> Retrieves the object corresponding to the currently
     * selected row in the {@code JTable}, or prompts the user if none is selected.</p>
     *
     * <p><strong>IT:</strong> Recupera l’oggetto corrispondente alla riga attualmente
     * selezionata nel {@code JTable}, oppure mostra un avviso se nessuna è selezionata.</p>
     *
     * <p><strong>PT-BR:</strong> Retorna o objeto correspondente à linha atualmente
     * selecionada no {@code JTable}, ou exibe um aviso se nenhuma estiver selecionada.</p>
     */
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
