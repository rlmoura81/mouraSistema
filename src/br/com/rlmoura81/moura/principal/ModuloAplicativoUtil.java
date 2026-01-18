package br.com.rlmoura81.moura.principal;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ModuloAplicativoUtil {
    
    ModuloAplicativo modapp = new ModuloAplicativo();
    ModuloAplicativoRepository modappr = new ModuloAplicativoRepository();    
    ArrayList lista = new ArrayList();

    /**
     * <p><strong>EN:</strong> Populates a JTable with Module–Category associations.  
     * Fetches the list via <code>modappr.getListaCatMod()</code> and fills columns with
     * module and category objects.</p>
     *
     * <p><strong>IT:</strong> Popola una JTable con le associazioni Modulo–Categoria.  
     * Recupera la lista tramite <code>modappr.getListaCatMod()</code> e compila le colonne
     * con oggetti modulo e categoria.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche uma JTable com as associações Módulo–Categoria.  
     * Obtém a lista com <code>modappr.getListaCatMod()</code> e preenche as colunas
     * com os objetos módulo e categoria.</p>
     */
    public void tabelaModuloAppCategoria(JTable o){
        String[] nomeColuna = {"Modulo", "Categoria"};
        lista = modappr.getListaCatMod();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for(int i=0; i < lista.size(); i++){
            modapp = (ModuloAplicativo)lista.get(i);
            dadosArray[i][0] = modapp.getModulo();
            dadosArray[i][1] = modapp.getCategoria().getDs_Categoria();
        }
        DefaultTableModel tModApp = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tModApp);
    }
    
    /**
     * <p><strong>EN:</strong> Populates a JTable with Module–Service Provider associations.  
     * Calls <code>modappr.getListaPresservMod()</code> and loads the table with
     * module and provider objects.</p>
     *
     * <p><strong>IT:</strong> Popola una JTable con le associazioni Modulo–Prestatore di Servizio.  
     * Chiama <code>modappr.getListaPresservMod()</code> e carica la tabella con
     * modulo e prestatore.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche uma JTable com as associações Módulo–Prestador de Serviço.  
     * Usa <code>modappr.getListaPresservMod()</code> e carrega a tabela
     * com módulo e prestador.</p>
     */
    public void tabelaModuloAppEmpresa(JTable o){
        String[] nomeColuna = {"Modulo", "Empresa"};
        lista = modappr.getListaEmpresaMod();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for(int i=0; i < lista.size(); i++){
            modapp = (ModuloAplicativo)lista.get(i);
            dadosArray[i][0] = modapp.getModulo();
            dadosArray[i][1] = modapp.getEmpresa();
        }
        DefaultTableModel tModApp = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tModApp);
    }    
    
    /**
     * <p><strong>EN:</strong> Retrieves the currently selected object from a JTable.  
     * If a row is selected, returns the corresponding element from the internal list.  
     * Otherwise, shows a message dialog asking the user to select an item.</p>
     *
     * <p><strong>IT:</strong> Recupera l’oggetto attualmente selezionato da una JTable.  
     * Se è selezionata una riga, restituisce l’elemento corrispondente dalla lista interna.  
     * Altrimenti mostra un messaggio che invita a selezionare un elemento.</p>
     *
     * <p><strong>PT-BR:</strong> Retorna o objeto atualmente selecionado em uma JTable.  
     * Se houver uma linha selecionada, devolve o item correspondente da lista interna.  
     * Caso contrário, mostra um aviso pedindo para selecionar um item.</p>
     */
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um iten da lista.", "Modulo Aplicativo", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;    
    }     
}
