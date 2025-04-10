package br.com.rlmoura81.moura.principalinterface;

import br.com.rlmoura81.moura.principal.PessoaFisica;
import br.com.rlmoura81.moura.principal.PessoaFisicaUtil;
import br.com.rlmoura81.moura.principal.UsuarioRepository;
import br.com.rlmoura81.moura.principal.Usuario;
import br.com.rlmoura81.moura.principal.UsuarioUtil;
import javax.swing.JOptionPane;

public class JIFUsuario extends javax.swing.JInternalFrame {
    
    private static JIFUsuario jifusuario;
    
    public static JIFUsuario getInstancia(){
        if (jifusuario == null){
            jifusuario = new JIFUsuario();
            jifusuario.setTitle("Usuário");
        } return jifusuario;
    }

    Usuario user = new Usuario();
    UsuarioRepository userr= new UsuarioRepository();
    UsuarioUtil useru = new UsuarioUtil();
    
    PessoaFisica pessoa = null;
    PessoaFisicaUtil pessoau = new PessoaFisicaUtil();
        
    public JIFUsuario() {
        initComponents();                

        tabelaUsuario();
        jcPessoaFisica();   
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPCampos = new javax.swing.JPanel();
        jLUsuario = new javax.swing.JLabel();
        jCBUsuario = new javax.swing.JComboBox<>();
        jLLogin = new javax.swing.JLabel();
        jTFLogin = new javax.swing.JTextField();
        jLSenha = new javax.swing.JLabel();
        jLConfirmar = new javax.swing.JLabel();
        jPFSenha = new javax.swing.JPasswordField();
        jPFConfrimar = new javax.swing.JPasswordField();
        jLAcesso = new javax.swing.JLabel();
        jCBAcesso = new javax.swing.JComboBox<>();
        jPBotoes = new javax.swing.JPanel();
        jBSalvar = new javax.swing.JButton();
        jBAlterar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        JpGrid = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTUsuario = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(400, 400));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPCampos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLUsuario.setText("Usuario:");

        jCBUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBUsuarioActionPerformed(evt);
            }
        });

        jLLogin.setText("Login:");

        jLSenha.setText("Senha:");

        jLConfirmar.setText("Confirmar:");

        jLAcesso.setText("Acesso:");

        jCBAcesso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usuário", "Administrador" }));

        javax.swing.GroupLayout jPCamposLayout = new javax.swing.GroupLayout(jPCampos);
        jPCampos.setLayout(jPCamposLayout);
        jPCamposLayout.setHorizontalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLAcesso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLConfirmar, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLSenha))
                .addGap(18, 18, 18)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPFSenha)
                    .addComponent(jTFLogin)
                    .addComponent(jPFConfrimar)
                    .addComponent(jCBAcesso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCBUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPCamposLayout.setVerticalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLUsuario)
                    .addComponent(jCBUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLLogin)
                    .addComponent(jTFLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLSenha)
                    .addComponent(jPFSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPFConfrimar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLConfirmar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLAcesso))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPBotoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBSalvar.setText("Salvar");
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });

        jBAlterar.setText("Alterar");
        jBAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAlterarActionPerformed(evt);
            }
        });

        jBExcluir.setText("Exlcuir");
        jBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPBotoesLayout = new javax.swing.GroupLayout(jPBotoes);
        jPBotoes.setLayout(jPBotoesLayout);
        jPBotoesLayout.setHorizontalGroup(
            jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBExcluir)
                .addContainerGap(138, Short.MAX_VALUE))
        );
        jPBotoesLayout.setVerticalGroup(
            jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalvar)
                    .addComponent(jBAlterar)
                    .addComponent(jBExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JpGrid.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTUsuario);

        javax.swing.GroupLayout JpGridLayout = new javax.swing.GroupLayout(JpGrid);
        JpGrid.setLayout(JpGridLayout);
        JpGridLayout.setHorizontalGroup(
            JpGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        JpGridLayout.setVerticalGroup(
            JpGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JpGrid, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limpaCampos(){
        jCBUsuario.setSelectedIndex(0);
        jTFLogin.setText(null);
        jPFSenha.setText(null);
        jPFConfrimar.setText(null);
    }

    private boolean validaCampos(){        
        if (pessoa == null){
            JOptionPane.showMessageDialog(null, "Selecione o usuário", "Pessoa", JOptionPane.INFORMATION_MESSAGE);
            jCBUsuario.requestFocus();
            return false;
        }        
        if (jTFLogin.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Digite o login", "Usuário", JOptionPane.INFORMATION_MESSAGE);
            jTFLogin.requestFocus();
            return false;
        }        
        if (jPFSenha.getText().isEmpty() | jPFConfrimar.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Digite a senha e confirme.", "Usuario", JOptionPane.INFORMATION_MESSAGE);
            jPFSenha.setText(null);
            jPFSenha.requestFocus();
            jPFConfrimar.setText(null);
            return false;
        }        
        if (! jPFSenha.getText().equals(jPFConfrimar.getText())){
            JOptionPane.showMessageDialog(null, "Senha não confere", "Usuario", JOptionPane.INFORMATION_MESSAGE);
            jPFConfrimar.requestFocus();
        return false;
        }        
        return true;
    }
    
    private void jcPessoaFisica(){
        pessoau.jcPessoaFisica(jCBUsuario);
    }
    
    private void tabelaUsuario()  {
        useru.tabelaUsuario(jTUsuario);
    }
    
    private void salvar(){
        user.setPessoa(pessoa);
        user.setDs_login(jTFLogin.getText());
        user.setDs_senha(jPFSenha.getText());
        userr.inserir(user);   
        user = null;
    }
    
    private void alterar(){
        user.setPessoa(pessoa);
        user.setDs_login(jTFLogin.getText());
        user.setDs_senha(jPFSenha.getText());
        userr.alterar(user);  
        user = null;
    }
    
    private void excluir(){
        user.setCd_usuario(user.getCd_usuario());
        userr.excluir(user);
        user = null;
    }
    
    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if (validaCampos()) {
            salvar();
            limpaCampos();
            tabelaUsuario();
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jCBUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBUsuarioActionPerformed
        if(jCBUsuario.getSelectedIndex() != 0){
            pessoa = (PessoaFisica)jCBUsuario.getSelectedItem();
        }else{
            pessoa = null;
        }                        
    }//GEN-LAST:event_jCBUsuarioActionPerformed

    private void jTUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTUsuarioMouseClicked
        user = (Usuario)useru.getSelectObject(jTUsuario);
        user.setCd_usuario(user.getCd_usuario());
        jCBUsuario.getModel().setSelectedItem(user.getPessoa());
        jTFLogin.setText(user.getDs_login());        
    }//GEN-LAST:event_jTUsuarioMouseClicked

    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        if(validaCampos()){
            alterar();
            limpaCampos();
            tabelaUsuario();
        }   
    }//GEN-LAST:event_jBAlterarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        if(validaCampos()){
            excluir();
            limpaCampos();
            tabelaUsuario();            
        }        
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifusuario = null;
    }//GEN-LAST:event_formInternalFrameClosed
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JpGrid;
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<String> jCBAcesso;
    private javax.swing.JComboBox<PessoaFisica> jCBUsuario;
    private javax.swing.JLabel jLAcesso;
    private javax.swing.JLabel jLConfirmar;
    private javax.swing.JLabel jLLogin;
    private javax.swing.JLabel jLSenha;
    private javax.swing.JLabel jLUsuario;
    private javax.swing.JPanel jPBotoes;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JPasswordField jPFConfrimar;
    private javax.swing.JPasswordField jPFSenha;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFLogin;
    private javax.swing.JTable jTUsuario;
    // End of variables declaration//GEN-END:variables
}
