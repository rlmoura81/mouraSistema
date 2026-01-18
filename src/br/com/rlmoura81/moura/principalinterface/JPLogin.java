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
        jfrm.setSize(300, 180);
        jfrm.setLocationRelativeTo(null);
        jfrm.add(this);
        jfrm.setVisible(true);
        jfrm.setTitle("Moura Sistema");        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPCampos = new javax.swing.JPanel();
        jLLogin = new javax.swing.JLabel();
        jTLogin = new javax.swing.JTextField();
        jPFSenha = new javax.swing.JPasswordField();
        jLSenha = new javax.swing.JLabel();
        jPBotao = new javax.swing.JPanel();
        jBAcesso = new javax.swing.JButton();

        setMaximumSize(null);

        jPCampos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLLogin.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLLogin.setText("Login:");

        jTLogin.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N

        jPFSenha.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N

        jLSenha.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLSenha.setText("Senha:");

        javax.swing.GroupLayout jPCamposLayout = new javax.swing.GroupLayout(jPCampos);
        jPCampos.setLayout(jPCamposLayout);
        jPCamposLayout.setHorizontalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLLogin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTLogin)
                    .addComponent(jPFSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPCamposLayout.setVerticalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLLogin)
                    .addComponent(jTLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLSenha)
                    .addComponent(jPFSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPBotao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBAcesso.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jBAcesso.setText("Acessar");
        jBAcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAcessoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPBotaoLayout = new javax.swing.GroupLayout(jPBotao);
        jPBotao.setLayout(jPBotaoLayout);
        jPBotaoLayout.setHorizontalGroup(
            jPBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBAcesso)
                .addContainerGap(181, Short.MAX_VALUE))
        );
        jPBotaoLayout.setVerticalGroup(
            jPBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBAcesso)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPBotao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPBotao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
        
    /**
     * <p><strong>EN:</strong> Clears the login and password fields, setting focus on the login field.</p>
     * <p><strong>IT:</strong> Pulisce i campi di login e password, impostando il focus sul campo login.</p>
     * <p><strong>PT-BR:</strong> Limpa os campos de login e senha, posicionando o foco no campo de login.</p>
     */
    private void limpaCampos (){
        jTLogin.setText(null);
        jPFSenha.setText(null);
        jTLogin.requestFocus();
    }
    
    /**
     * <p><strong>EN:</strong> Validates if login and password fields are filled.</p>
     * <p><strong>IT:</strong> Convalida se i campi di login e password sono compilati.</p>
     * <p><strong>PT-BR:</strong> Valida se os campos de login e senha estão preenchidos.</p>
     */
    private boolean validaCampos(){
        if ((jTLogin.getText().isEmpty()) | (jPFSenha.getText().isEmpty())){
            JOptionPane.showMessageDialog(null, "Campos em brancos.", "Login", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }        
        return true;
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves a user from the database by login. 
     * If found, initializes a Usuario object with the user data.</p>
     * <p><strong>IT:</strong> Recupera un utente dal database tramite login. 
     * Se trovato, inizializza un oggetto Usuario con i dati dell'utente.</p>
     * <p><strong>PT-BR:</strong> Recupera um usuário do banco de dados pelo login. 
     * Caso encontrado, inicializa um objeto Usuario com os dados do usuário.</p>
     */
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
    
    /**
     * <p><strong>EN:</strong> Validates if the provided login and password match the retrieved user object.</p>
     * <p><strong>IT:</strong> Convalida se login e password forniti corrispondono all'oggetto utente recuperato.</p>
     * <p><strong>PT-BR:</strong> Valida se o login e a senha informados conferem com o objeto usuário recuperado.</p>
     */
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
    
    /**
     * <p><strong>EN:</strong> Opens the main application menu (JFPrincipal) in the Event Dispatch Thread.</p>
     * <p><strong>IT:</strong> Apre il menu principale dell'applicazione (JFPrincipal) nel thread di gestione eventi.</p>
     * <p><strong>PT-BR:</strong> Abre o menu principal da aplicação (JFPrincipal) na Event Dispatch Thread.</p>
     */
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
    private javax.swing.JPanel jPBotao;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JPasswordField jPFSenha;
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