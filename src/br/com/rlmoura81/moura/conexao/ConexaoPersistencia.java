
package br.com.rlmoura81.moura.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoPersistencia {
    
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
