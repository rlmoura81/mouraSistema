package br.com.rlmoura81.moura.principalinterface;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class GerenciarInterface {
    
    private static JDesktopPane jdesktoppane;
    
    public GerenciarInterface(JDesktopPane jdesktoppane){        
        GerenciarInterface.jdesktoppane = jdesktoppane;        
    }
    
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
