
package br.com.rlmoura81.moura.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoPersistencia {
    
    /**
     * <p><strong>EN:</strong> Opens and returns a connection to the Oracle database.  
     * Uses the Oracle JDBC driver and the configured connection string.  
     * In case of an error, a dialog with the exception message is shown.</p>
     *
     * <p><strong>IT:</strong> Apre e restituisce una connessione al database Oracle.  
     * Utilizza il driver JDBC Oracle e la stringa di connessione configurata.  
     * In caso di errore, viene mostrata una finestra di dialogo con il messaggio di eccezione.</p>
     *
     * <p><strong>PT-BR:</strong> Abre e retorna uma conexão com o banco de dados Oracle.  
     * Utiliza o driver JDBC da Oracle e a string de conexão configurada.  
     * Em caso de erro, exibe uma janela de diálogo com a mensagem da exceção.</p>
     *
     * @return Connection object if successful, or null if the connection fails.
     */
    public static Connection getConnection() {
        Connection con = null;
        try {            
            String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";            
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Class.forName(JDBC_DRIVER);            
              con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","moura","moura"); 
//              con = DriverManager.getConnection("jdbc:oracle:thin:@10.1.1.72:1521:xe","moura","moura");                     
//              con = DriverManager.getConnection("jdbc:oracle:thin:@hgc09pw9160.sn.mynetname.net:9021:xe","moura","moura"); 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco:\n" + 
                    ex.getMessage());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco:\n" + 
                    ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco:\n" + 
                    ex.getMessage());
        }
        return con;        
    }
}
