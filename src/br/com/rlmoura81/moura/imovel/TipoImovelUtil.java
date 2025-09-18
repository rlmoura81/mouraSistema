package br.com.rlmoura81.moura.imovel;

import java.util.ArrayList;
import javax.swing.JComboBox;

public class TipoImovelUtil {
    
    TipoImovelRepository tpir = new TipoImovelRepository();
        
    /**
     * <p><strong>EN:</strong> Loads property types ({@link TipoImovel}) into a {@link JComboBox}.  
     * Adds a default placeholder option <code>&lt;Tipo&gt;</code> followed by the list of property types from the repository.</p>
     *
     * <p><strong>IT:</strong> Carica i tipi di immobile ({@link TipoImovel}) in un {@link JComboBox}.  
     * Aggiunge un’opzione predefinita <code>&lt;Tipo&gt;</code> seguita dall’elenco dei tipi di immobile dal repository.</p>
     *
     * <p><strong>PT-BR:</strong> Carrega os tipos de imóvel ({@link TipoImovel}) em um {@link JComboBox}.  
     * Adiciona a opção padrão <code>&lt;Tipo&gt;</code> seguida da lista de tipos de imóvel obtida do repositório.</p>
     */
    public void jcTpimovel(JComboBox o){
        ArrayList<TipoImovel> listatpimovel = tpir.getLista();
        TipoImovel tpiZero = new TipoImovel(0, "<Tipo>");
        o.addItem(tpiZero);
        for(TipoImovel tpi : listatpimovel){
            o.addItem(tpi);
        }
    }
}
