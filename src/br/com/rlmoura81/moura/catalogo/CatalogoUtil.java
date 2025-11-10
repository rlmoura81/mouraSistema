package br.com.rlmoura81.moura.catalogo;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CatalogoUtil {
    
    Catalogo catalogo = new Catalogo();
    CatalogoRepository catalogor = new CatalogoRepository();
    TipoMidiaRepository tmr = new TipoMidiaRepository();    
    Editora editora = new Editora();
    EditoraRepository editorar = new EditoraRepository();    
    StatusRepository str = new StatusRepository();    
    ArrayList lista = new ArrayList();

    /**
     * <p><strong>EN:</strong> Populates a JComboBox with the list of media types (TipoMidia), adding a default option first.</p>
     *
     * <p><strong>IT:</strong> Popola un JComboBox con l'elenco dei tipi di media (TipoMidia), aggiungendo prima un'opzione predefinita.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche um JComboBox com a lista de tipos de mídia (TipoMidia), adicionando antes uma opção padrão.</p>
     *
     * @param o EN: JComboBox to be populated | IT: JComboBox da popolare | PT-BR: JComboBox a ser preenchido
     * @since 1.0.0
     */
    public void jcTipoMidia(JComboBox o){ 
        ArrayList<TipoMidia> listatipomidia = tmr.getLista();
        TipoMidia tmZero = new TipoMidia(0, "<Tipo Mídia>");
        o.addItem(tmZero);
        for(TipoMidia tipoMidia : listatipomidia){
            o.addItem(tipoMidia);
        }
    }
    
    /**
     * <p><strong>EN:</strong> Populates a JComboBox with the list of publishers (Editora), adding a default option first.</p>
     *
     * <p><strong>IT:</strong> Popola un JComboBox con l'elenco degli editori (Editora), aggiungendo prima un'opzione predefinita.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche um JComboBox com a lista de editoras (Editora), adicionando antes uma opção padrão.</p>
     *
     * @param o EN: JComboBox to be populated | IT: JComboBox da popolare | PT-BR: JComboBox a ser preenchido
     * @since 1.0.0
     */
    public void jcEditora(JComboBox o){
        ArrayList<Editora> listaeditora = editorar.getLista();
        Editora eZero = new Editora(0, "<Editora>", 0);
        o.addItem(eZero);
        for(Editora editora : listaeditora){
            o.addItem(editora);
        }
    }
   
    /**
     * <p><strong>EN:</strong> Populates a JComboBox with the list of statuses (Status), adding a default option first.</p>
     *
     * <p><strong>IT:</strong> Popola un JComboBox con l'elenco degli stati (Status), aggiungendo prima un'opzione predefinita.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche um JComboBox com a lista de status (Status), adicionando antes uma opção padrão.</p>
     *
     * @param o EN: JComboBox to be populated | IT: JComboBox da popolare | PT-BR: JComboBox a ser preenchido
     * @since 1.0.0
     */
    public void jcStatus(JComboBox o){
        ArrayList<Status> listastatus = str.getLista();
        Status stZero = new Status(0, "<Status>");
        o.addItem(stZero);
        for(Status status : listastatus){
            o.addItem(status);
        }
    }
    
    /**
     * <p><strong>EN:</strong> Populates a JTable with publishers (Editora), displaying their names.</p>
     *
     * <p><strong>IT:</strong> Popola una JTable con gli editori (Editora), mostrando i loro nomi.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche uma JTable com as editoras (Editora), exibindo seus nomes.</p>
     *
     * @param o EN: JTable to be populated | IT: JTable da popolare | PT-BR: JTable a ser preenchida
     * @since 1.0.0
     */
    public void tabelaEditora(JTable o){        
        String[] nomeColuna = {"nome"};
        lista = editorar.getLista();
        Object [][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for (int i=0; i < lista.size(); i++){
            editora = (Editora)lista.get(i);
            dadosArray[i][0] = editora.getDs_nome();
        }        
        DefaultTableModel tEditora = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tEditora);        
    }

    //EM TESTE - COLOCAR COMENTARIO
    public String StLeitura(int st_leitura){
        String stLeitura = "";
        if(catalogo.getSt_leitura() == 0){
            stLeitura = "Ler";
        }
        if(catalogo.getSt_leitura() == 1){
            stLeitura = "Lendo";
        }
        if(catalogo.getSt_leitura() == 2){
            stLeitura = "Lido";
        }
        return stLeitura;
    }
    
    /**
     * <p><strong>EN:</strong> Populates a JTable with catalog items, including title, number, volume, edition, status, publisher, type, and notes.</p>
     *
     * <p><strong>IT:</strong> Popola una JTable con gli elementi di catalogo, inclusi titolo, numero, volume, edizione, stato, editore, tipo e note.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche uma JTable com itens do catálogo, incluindo título, número, volume, edição, status, editora, tipo e observações.</p>
     *
     * @param o EN: JTable to be populated | IT: JTable da popolare | PT-BR: JTable a ser preenchida
     * @since 1.0.0
     */
    public void tabelaCatalogo(JTable o){
        String[] nomeColuna = {"Titulo", "Numero", "Volume", "Edicao", "Status", "Editora", "Tipo", "Leitura", "Observação"};
        lista = catalogor.getLista();
        Object [][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for (int i = 0; i < lista.size(); i++){
            catalogo = (Catalogo)lista.get(i);
            dadosArray [i][0] = catalogo.getDs_titulo();
            dadosArray [i][1] = catalogo.getNm_numero();
            dadosArray [i][2] = catalogo.getNm_volume();
            dadosArray [i][3] = catalogo.getNm_edicao();
            dadosArray [i][4] = catalogo.getStatus();
            dadosArray [i][5] = catalogo.getEditora();
            dadosArray [i][6] = catalogo.getTipomidia();
            dadosArray [i][7] = StLeitura(catalogo.getSt_leitura());
            dadosArray [i][8] = catalogo.getDs_observacao();
        }        
        DefaultTableModel tCatalogo = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tCatalogo);
    }
    
    /**
     * <p><strong>EN:</strong> Populates a JTable with catalog items filtered by title, showing title, number, volume, edition, notes, publisher, type, and status.</p>
     *
     * <p><strong>IT:</strong> Popola una JTable con gli elementi di catalogo filtrati per titolo, mostrando titolo, numero, volume, edizione, note, editore, tipo e stato.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche uma JTable com itens do catálogo filtrados por título, exibindo título, número, volume, edição, observações, editora, tipo e status.</p>
     *
     * @param o EN: JTable to be populated | IT: JTable da popolare | PT-BR: JTable a ser preenchida
     * @param ds_titulo EN: title fragment used to filter results | IT: porzione di titolo usata per filtrare i risultati | PT-BR: trecho do título usado para filtrar os resultados
     * @since 1.0.0
     */
    public void tabelaCatalogo(JTable o, String ds_titulo){
        String[] nomeColuna = {"Titulo", "Numero", "Volume", "Edicao", "Status", "Editora", "Tipo", "Leitura", "Observação"};
        lista = catalogor.getLista(ds_titulo);
        Object [][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for (int i = 0; i < lista.size(); i++){
            catalogo = (Catalogo)lista.get(i);
            dadosArray [i][0] = catalogo.getDs_titulo();
            dadosArray [i][1] = catalogo.getNm_numero();
            dadosArray [i][2] = catalogo.getNm_volume();
            dadosArray [i][3] = catalogo.getNm_edicao();
            dadosArray [i][4] = catalogo.getStatus();
            dadosArray [i][5] = catalogo.getEditora();
            dadosArray [i][6] = catalogo.getTipomidia();
            dadosArray [i][7] = catalogo.getSt_leitura();
            dadosArray [i][8] = catalogo.getDs_observacao();
        }
        DefaultTableModel tCatalogo = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tCatalogo);
    }
        
    /**
     * <p><strong>EN:</strong> Retrieves the object corresponding to the selected row in the JTable.  
     * Shows an information dialog if no row is selected.</p>
     *
     * <p><strong>IT:</strong> Recupera l'oggetto corrispondente alla riga selezionata nella JTable.  
     * Mostra una finestra informativa se non viene selezionata alcuna riga.</p>
     *
     * <p><strong>PT-BR:</strong> Recupera o objeto correspondente à linha selecionada na JTable.  
     * Exibe uma mensagem informativa se nenhuma linha for selecionada.</p>
     *
     * @param o EN: JTable from which to retrieve the selected object | IT: JTable da cui recuperare l'oggetto selezionato | PT-BR: JTable de onde recuperar o objeto selecionado
     * @return EN: selected object or null if none is selected | IT: oggetto selezionato o null se nessuno è selezionato | PT-BR: objeto selecionado ou null se nenhum for selecionado
     * @since 1.0.0
     */
    public Object getSelectedObject(JTable o){        
        Object selecionado = null;
        int linhaSelecionada = o.getSelectedRow();
        if(linhaSelecionada >= 0){
            selecionado = lista.get(linhaSelecionada);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um item da lista.", "Catálogo", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;  
    }    
}
