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

    public void jcTipoMidia(JComboBox o){ 
        ArrayList<TipoMidia> listatipomidia = tmr.getLista();
        TipoMidia tmZero = new TipoMidia(0, "<Tipo Mídia>");
        o.addItem(tmZero);
        for(TipoMidia tipoMidia : listatipomidia){
            o.addItem(tipoMidia);
        }
    }
    
    public void jcEditora(JComboBox o){
        ArrayList<Editora> listaeditora = editorar.getLista();
        Editora eZero = new Editora(0, "<Editora>", 0);
        o.addItem(eZero);
        for(Editora editora : listaeditora){
            o.addItem(editora);
        }
    }
    
    public void jcStatus(JComboBox o){
        ArrayList<Status> listastatus = str.getLista();
        Status stZero = new Status(0, "<Status>");
        o.addItem(stZero);
        for(Status status : listastatus){
            o.addItem(status);
        }
    }
    
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
    
    public void tabelaCatalogo(JTable o){
        String[] nomeColuna = {"Titulo", "Numero", "Volume", "Edicao", "Observação", "Editora", "Tipo", "Status"};
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
            dadosArray [i][7] = catalogo.getDs_observacao();
        }        
        DefaultTableModel tCatalogo = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tCatalogo);
    }
    
    public void tabelaCatalogo(JTable o, String ds_titulo){
        String[] nomeColuna = {"Titulo", "Numero", "Volume", "Edicao", "Leitura", "Editora", "Tipo", "Status"};
        lista = catalogor.getLista(ds_titulo);
        Object [][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for (int i = 0; i < lista.size(); i++){
            catalogo = (Catalogo)lista.get(i);
            dadosArray [i][0] = catalogo.getDs_titulo();
            dadosArray [i][1] = catalogo.getNm_numero();
            dadosArray [i][2] = catalogo.getNm_volume();
            dadosArray [i][3] = catalogo.getNm_edicao();
            dadosArray [i][4] = catalogo.getDs_observacao();
            dadosArray [i][5] = catalogo.getEditora();
            dadosArray [i][6] = catalogo.getTipomidia();
            dadosArray [i][7] = catalogo.getStatus();
        }
        DefaultTableModel tCatalogo = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tCatalogo);
    }
    
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
