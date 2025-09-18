package br.com.rlmoura81.moura.principalinterface;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class GerenciarInterface {
    
    private static JDesktopPane jdesktoppane;
    
    /**
     * <p><strong>EN:</strong> Initializes the interface manager with the main desktop pane.
     * Stores the JDesktopPane reference to control internal frames.</p>
     *
     * <p><strong>IT:</strong> Inizializza il gestore dell’interfaccia con il desktop principale.
     * Memorizza il riferimento a JDesktopPane per gestire i frame interni.</p>
     *
     * <p><strong>PT-BR:</strong> Inicializa o gerenciador de interface com o desktop principal.
     * Armazena a referência do JDesktopPane para controlar os frames internos.</p>
     */
    public GerenciarInterface(JDesktopPane jdesktoppane){        
        GerenciarInterface.jdesktoppane = jdesktoppane;        
    }
    
    /**
     * <p><strong>EN:</strong> Opens a JInternalFrame within the desktop pane.
     * If already visible, brings it to the front and requests focus; 
     * otherwise, adds and displays it.</p>
     *
     * <p><strong>IT:</strong> Apre un JInternalFrame all’interno del desktop pane.
     * Se è già visibile, lo porta in primo piano e richiede il focus;
     * altrimenti, lo aggiunge e lo mostra.</p>
     *
     * <p><strong>PT-BR:</strong> Abre um JInternalFrame dentro do desktop pane.
     * Se já estiver visível, traz para frente e foca; 
     * caso contrário, adiciona e exibe.</p>
     */
    public void abrirInterface(JInternalFrame jinternalframe){
        if(jinternalframe.isVisible()){
            jinternalframe.toFront();
            jinternalframe.requestFocus();
        } else {
            jdesktoppane.add(jinternalframe);
            jinternalframe.setVisible(true);
        }
    }
    
}
