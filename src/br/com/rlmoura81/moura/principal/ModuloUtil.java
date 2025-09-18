package br.com.rlmoura81.moura.principal;

import java.util.ArrayList;
import javax.swing.JComboBox;

public class ModuloUtil {
    
    ModuloRepository modulor = new ModuloRepository();
        
    /**
     * <p><strong>EN:</strong> Populates the combo box with available modules.
     * Fetches the list of modules from the repository, adds a default placeholder entry,
     * and then inserts all retrieved Modulo objects into the JComboBox.</p>
     *
     * <p><strong>IT:</strong> Popola la combo box con i moduli disponibili.
     * Recupera l’elenco dei moduli dal repository, aggiunge una voce predefinita
     * e successivamente inserisce tutti gli oggetti Modulo nel JComboBox.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche a combo box com os módulos disponíveis.
     * Busca a lista de módulos no repositório, adiciona uma entrada padrão
     * e em seguida insere todos os objetos Modulo no JComboBox.</p>
     */
    public void jcModulo(JComboBox o){
        ArrayList<Modulo> lista = modulor.getLista();
        Modulo mZero = new Modulo(0, "<Módulo>");
        o.addItem(mZero);
        for(Modulo modulo : lista){
            o.addItem(modulo);
        }
    }    
    
}
