package br.com.rlmoura81.moura.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {
    private String url;
    private String user;
    private String password;
    private Connection con;

    public Conexao() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
        
    public Conexao(String url, String user, String password, Connection con) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.con = con;
    }
    
    //Abre conexao com o Banco Oracle;
    public Connection conectaBanco() throws SQLException, ClassNotFoundException{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        this.con = DriverManager.getConnection(url,user,password);
        this.con.setAutoCommit(false);
        return this.con;
    }
    
    //Fecha conexao com o Banco Oracle;
    public Connection fechaConexaoBanco() throws SQLException, ClassNotFoundException{
        if (this.con != null){
            this.con.close();
        }
        return this.con;
    }
    
    //Executa comando SQL no Banco;
    public ResultSet executaSql (String pSql) throws SQLException, ClassNotFoundException {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
//        Conexao cbd = new Conexao("jdbc:oracle:thin:@localhost:1521:xe", "moura", "moura", null);
//        Conexao cbd = new Conexao("jdbc:oracle:thin:@10.1.1.72:1521:xe", "moura", "moura", null);
//        Conexao cbd = new Conexao("jdbc:oracle:thin:@hgc09pw9160.sn.mynetname.net:9021:xe", "moura", "moura", null);
//        this.con = cbd.conectaBanco();          
        ps = this.con.prepareStatement(pSql);
        rs = ps.executeQuery();
        this.con.commit();
        return rs;
    }
}
