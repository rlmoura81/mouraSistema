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
       
    /**
     * <p><strong>EN:</strong> Converts the subscription plan code to a label.
     * Returns “Mês” for <code>1</code>, “Ano” for <code>2</code>, or “-” for unknown codes.</p>
     *
     * <p><strong>IT:</strong> Converte il codice del piano di abbonamento in un’etichetta.
     * Restituisce “Mês” per <code>1</code>, “Ano” per <code>2</code> o “-” per codici sconosciuti.</p>
     *
     * <p><strong>PT-BR:</strong> Converte o código do plano de assinatura em rótulo.
     * Retorna “Mês” para <code>1</code>, “Ano” para <code>2</code> ou “-” para códigos desconhecidos.</p>
     */
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
        
    /**
     * <p><strong>EN:</strong> Builds the “Assinatura” table with all subscriptions.
     * Populates rows with service, login, password, value, plan (month/year), validity date, and provider.</p>
     *
     * <p><strong>IT:</strong> Compila la tabella “Assinatura” con tutti gli abbonamenti.
     * Riempie le righe con servizio, login, password, valore, piano (mese/anno), data di validità e fornitore.</p>
     *
     * <p><strong>PT-BR:</strong> Monta a tabela de “Assinatura” com todas as assinaturas.
     * Preenche as linhas com serviço, login, senha, valor, plano (mês/ano), validade e prestadora.</p>
     */
    public void tabelaAssinatura(JTable o){
        String[] nomeColuna = {"Serviço", "Login", "Senha", "Valor", "Plano", "Validade", "Empresa"};
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
            dadosArray[i][6] = assinatura.getEmpresa();
        }        
        DefaultTableModel tAssinatura = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tAssinatura);
    }
    
    /**
     * <p><strong>EN:</strong> Builds the “Assinatura” table filtered by service name.
     * Loads only subscriptions whose service matches the search term (case-insensitive).</p>
     *
     * <p><strong>IT:</strong> Compila la tabella “Assinatura” filtrando per nome del servizio.
     * Carica solo gli abbonamenti il cui servizio corrisponde al termine di ricerca (senza distinzione maiuscole/minuscole).</p>
     *
     * <p><strong>PT-BR:</strong> Monta a tabela de “Assinatura” filtrada pelo nome do serviço.
     * Carrega apenas assinaturas cujo serviço corresponde ao termo buscado (sem diferenciar maiúsculas/minúsculas).</p>
     */
    public void tabelaAssinatura(JTable o, String ds_servico){
        String[] nomeColuna = {"Serviço", "Login", "Senha", "Valor", "Plano", "Validade", "Empresa"};
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
            dadosArray[i][6] = assinatura.getEmpresa();
        }        
        DefaultTableModel tAssinatura = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tAssinatura);
    }
    
    /**
     * <p><strong>EN:</strong> Returns the object corresponding to the currently selected table row.
     * If no row is selected, shows an informational dialog and returns <code>null</code>.</p>
     *
     * <p><strong>IT:</strong> Restituisce l’oggetto corrispondente alla riga selezionata nella tabella.
     * Se nessuna riga è selezionata, mostra un messaggio informativo e restituisce <code>null</code>.</p>
     *
     * <p><strong>PT-BR:</strong> Retorna o objeto referente à linha atualmente selecionada na tabela.
     * Caso nenhuma linha esteja selecionada, exibe um aviso e retorna <code>null</code>.</p>
     */
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
    
}