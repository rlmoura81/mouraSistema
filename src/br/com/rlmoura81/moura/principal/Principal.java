package br.com.rlmoura81.moura.principal;

import br.com.rlmoura81.moura.principalinterface.JFPrincipal;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

public class Principal {
    
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      
        SwingUtilities.invokeLater(new Runnable() {
            public void run () {
                new JPLogin();
            }
        });
    } 
}
