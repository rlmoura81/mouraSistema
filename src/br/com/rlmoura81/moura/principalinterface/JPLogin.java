package br.com.rlmoura81.moura.principalinterface;

import br.com.rlmoura81.moura.conexao.ConexaoPersistencia;
import br.com.rlmoura81.moura.principal.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class JPLogin extends javax.swing.JPanel {
        
        public static int codloginuser;
        public static String loginuser;        
        public static Connection conn = ConexaoPersistencia.getConnection();
        
        JFrame jfrm = new JFrame();      
        Usuario usuario = new Usuario();
        String sql = "";
        
    public JPLogin() {
        initComponents();
              
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(320, 160);
        jfrm.setLocationRelativeTo(null);
        jfrm.add(this);
        jfrm.setVisible(true);
        jfrm.setTitle("Moura Sistema");        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPLogin = new javax.swing.JPanel();
        jBAcesso = new javax.swing.JButton();
        jLLogin = new javax.swing.JLabel();
        jTLogin = new javax.swing.JTextField();
        jLSenha = new javax.swing.JLabel();
        jPFSenha = new javax.swing.JPasswordField();

        setMaximumSize(null);

        jPLogin.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBAcesso.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jBAcesso.setText("Acessar");
        jBAcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAcessoActionPerformed(evt);
            }
        });

        jLLogin.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLLogin.setText("Login:");

        jTLogin.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N

        jLSenha.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLSenha.setText("Senha:");

        jPFSenha.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPLoginLayout = new javax.swing.GroupLayout(jPLogin);
        jPLogin.setLayout(jPLoginLayout);
        jPLoginLayout.setHorizontalGroup(
            jPLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPLoginLayout.createSequentialGroup()
                        .addGroup(jPLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jPFSenha)))
                    .addComponent(jBAcesso))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPLoginLayout.setVerticalGroup(
            jPLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLLogin)
                    .addComponent(jTLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLSenha)
                    .addComponent(jPFSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBAcesso)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
        
    private void limpaCampos (){
        jTLogin.setText(null);
        jPFSenha.setText(null);
        jTLogin.requestFocus();
    }
    
    private boolean validaCampos(){
        if ((jTLogin.getText().isEmpty()) | (jPFSenha.getText().isEmpty())){
            JOptionPane.showMessageDialog(null, "Campos em brancos.", "Login", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }        
        return true;
    }
    
    private Object getUsuario(String login){
        try{
            sql = "SELECT usuario.cd_usuario, usuario.ds_login, usuario.ds_senha, pessoafisica.cd_pessoafisica" +
                  "  FROM usuario, pessoafisica" +
                  " WHERE usuario.cd_pessoafisica = pessoafisica.cd_pessoafisica" +
                  "   AND usuario.ds_login = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                usuario = new Usuario(
                    rs.getInt("cd_usuario"),
                    rs.getString("ds_login"),
                    rs.getString("ds_senha"),
                    null);
            }
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Usuário Invalido.", "Login", JOptionPane.INFORMATION_MESSAGE);
        }
        return usuario;
    }
    
    private boolean validaUsuario(){
            if (!jTLogin.getText().equals(usuario.getDs_login())){
                JOptionPane.showMessageDialog(null, "Usuario não existente", "Login",JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
            if (!jPFSenha.getText().equals(usuario.getDs_senha())) {
                JOptionPane.showMessageDialog(null, "Senha inválida", "Senha inválida",JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
            limpaCampos();
            return true;
    }
    
    private void abreMenuPrincipal(){
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
                public void run (){
                new JFPrincipal().setVisible(true);}
        });
    }
    
    private void jBAcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAcessoActionPerformed
        if(validaCampos()){
            usuario = (Usuario)getUsuario(jTLogin.getText());
            if(validaUsuario()){
                codloginuser = usuario.getCd_usuario();
                loginuser = usuario.getDs_login();  
                abreMenuPrincipal();
                jfrm.dispose();                
            }
        }                            
    }//GEN-LAST:event_jBAcessoActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAcesso;
    private javax.swing.JLabel jLLogin;
    private javax.swing.JLabel jLSenha;
    private javax.swing.JPasswordField jPFSenha;
    private javax.swing.JPanel jPLogin;
    private javax.swing.JTextField jTLogin;
    // End of variables declaration//GEN-END:variables
}

    //###COMANDO###
    /*    
    //Valida campos da tela.
            if ((jTLogin.getText().isEmpty()) | (jPFSenha.getText().isEmpty())){
                JOptionPane.showMessageDialog(null, "Campos em brancos!", "Erro de Login", JOptionPane.INFORMATION_MESSAGE);
                return;
                }
    */            
    /*
    //Valida conexao do usuario no banco.
            try {

                userValida.setDs_Login(jTLogin.getText());
                ResultSet rs = conn.executaSql("SELECT usuario.cd_usuario, usuario.ds_login, usuario.ds_Senha, pessoafisica.cd_pessoafisica FROM usuario, pessoafisica"
                                               + " WHERE usuario.cd_pessoafisica = pessoafisica.cd_pessoafisica"
                                               + " AND usuario.ds_login = '" + userValida.getDs_Login() + "'");
                rs.next();
                userValida.setCd_Usuario(rs.getInt(1));
                userValida.setDs_Login(rs.getString(2));
                userValida.setDs_Senha(rs.getString(3));
                    
            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Usuário Invalido");
                limpaCampos();
                return;
            }
    */
    /*
        //Valida usuario no banco.
            if (!jTLogin.getText().equals(userValida.getDs_Login())){
                JOptionPane.showMessageDialog(null, "Usuario Nao Existente", "Erro de Login",JOptionPane.INFORMATION_MESSAGE);
                limpaCampos();
                return;
            }
            if (!jPFSenha.getText().equals(userValida.getDs_Senha())) {
                JOptionPane.showMessageDialog(null, "Senha Inválida", "Senha Inválida",JOptionPane.ERROR_MESSAGE);
                return;
            }
    */
    /*
        //Carrega variaveis:
            codloginuser = userValida.getCd_Usuario();
            loginuser = userValida.getDs_Login();
            
        //Abre o Menu Principal do Sistema.
            java.awt.EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run () {
                        new JFPrincipal().setVisible(true);
                    }
                });
        
        //Fecha a tela de Login.
        jfrm.dispose();
    */
        //###COMANDO ORIGINAL - FINAL###