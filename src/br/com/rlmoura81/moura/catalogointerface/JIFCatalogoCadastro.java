package br.com.rlmoura81.moura.catalogointerface;

import br.com.rlmoura81.moura.catalogo.Catalogo;
import br.com.rlmoura81.moura.catalogo.CatalogoRepository;
import br.com.rlmoura81.moura.catalogo.CatalogoUtil;
import br.com.rlmoura81.moura.catalogo.Editora;
import br.com.rlmoura81.moura.catalogo.Status;
import br.com.rlmoura81.moura.catalogo.TipoMidia;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.beans.PropertyVetoException;
import javax.swing.JOptionPane;

public class JIFCatalogoCadastro extends javax.swing.JInternalFrame {
    
    Catalogo catalogo = null;
    CatalogoRepository catalogor = new CatalogoRepository();
    CatalogoUtil catalogou = new CatalogoUtil();
        
    TipoMidia tipomidia = null;
    Editora editora = null;
    Status status = null;

    public JIFCatalogoCadastro() {
        initComponents();
        
        jcCatalogo();
        
    }
    
    public JIFCatalogoCadastro(Catalogo catalogo){
        initComponents();

        jcCatalogo();
        
        this.catalogo = catalogo;
        jCBTipoMidia.setSelectedItem(catalogo.getTipomidia());
        jTFTitulo.setText(catalogo.getDs_titulo());
        jTFNumero.setText(Integer.toString(catalogo.getNm_numero()));
        jTFVolume.setText(Integer.toString(catalogo.getNm_volume()));
        jTFEdicao.setText(Integer.toString(catalogo.getNm_edicao()));
        jCBEditora.setSelectedItem(catalogo.getEditora());
        jCBStatus.setSelectedItem(catalogo.getStatus());
        jTAObservacao.setText(catalogo.getDs_observacao());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPCampo = new javax.swing.JPanel();
        jLTipoMidia = new javax.swing.JLabel();
        jCBTipoMidia = new javax.swing.JComboBox<>();
        jCBEditora = new javax.swing.JComboBox<>();
        jLEditora = new javax.swing.JLabel();
        jLTitulo = new javax.swing.JLabel();
        jTFTitulo = new javax.swing.JTextField();
        jLNumero = new javax.swing.JLabel();
        jTFNumero = new javax.swing.JTextField();
        jTFVolume = new javax.swing.JTextField();
        jLVolume = new javax.swing.JLabel();
        jLStatus = new javax.swing.JLabel();
        jLEdicao = new javax.swing.JLabel();
        jTFEdicao = new javax.swing.JTextField();
        jCBStatus = new javax.swing.JComboBox<>();
        jLObservacao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAObservacao = new javax.swing.JTextArea();
        jPBotoes = new javax.swing.JPanel();
        jBSalvar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();

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

        jPCampo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLTipoMidia.setText("Tipo de Midia:");

        jCBTipoMidia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBTipoMidiaActionPerformed(evt);
            }
        });

        jCBEditora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBEditoraActionPerformed(evt);
            }
        });

        jLEditora.setText("Editora:");

        jLTitulo.setText("Titulo:");

        jLNumero.setText("Numero:");

        jLVolume.setText("Volume:");

        jLStatus.setText("Status:");

        jLEdicao.setText("Edição:");

        jCBStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBStatusActionPerformed(evt);
            }
        });

        jLObservacao.setText("Observação:");

        jTAObservacao.setColumns(20);
        jTAObservacao.setRows(5);
        jScrollPane1.setViewportView(jTAObservacao);

        javax.swing.GroupLayout jPCampoLayout = new javax.swing.GroupLayout(jPCampo);
        jPCampo.setLayout(jPCampoLayout);
        jPCampoLayout.setHorizontalGroup(
            jPCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCampoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPCampoLayout.createSequentialGroup()
                        .addGroup(jPCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLStatus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLEditora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPCampoLayout.createSequentialGroup()
                                .addGroup(jPCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jCBEditora, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPCampoLayout.createSequentialGroup()
                                            .addComponent(jTFNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLVolume)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jTFVolume, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLEdicao)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jTFEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jCBStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 111, Short.MAX_VALUE))
                            .addComponent(jTFTitulo)))
                    .addGroup(jPCampoLayout.createSequentialGroup()
                        .addGroup(jPCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPCampoLayout.createSequentialGroup()
                                .addComponent(jLTipoMidia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCBTipoMidia, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLObservacao))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPCampoLayout.setVerticalGroup(
            jPCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCampoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTipoMidia)
                    .addComponent(jCBTipoMidia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTitulo)
                    .addComponent(jTFTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNumero)
                    .addComponent(jTFNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFVolume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLVolume)
                    .addComponent(jLEdicao)
                    .addComponent(jTFEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLEditora)
                    .addComponent(jCBEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLObservacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jPBotoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBSalvar.setText("Salvar");
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });

        jBCancelar.setText("Cancelar");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
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
                .addComponent(jBCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPBotoesLayout.setVerticalGroup(
            jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalvar)
                    .addComponent(jBCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPCampo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcCatalogo(){
        catalogou.jcTipoMidia(jCBTipoMidia);
        catalogou.jcEditora(jCBEditora);
        catalogou.jcStatus(jCBStatus);
    }
    
    private boolean validaCampos(){
        if(tipomidia == null){
            JOptionPane.showMessageDialog(null, "Selecione a midia.", "Midia", JOptionPane.INFORMATION_MESSAGE);
            jCBTipoMidia.requestFocus();
            return false;
        }
        if(jTFTitulo.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo em branco.", "Catalogo", JOptionPane.INFORMATION_MESSAGE);
            jTFTitulo.requestFocus();
            return false;
        }
        if(jTFNumero.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo em branco.", "Catalogo", JOptionPane.INFORMATION_MESSAGE);
            jTFNumero.requestFocus();
            return false;
        }
        if(jTFVolume.getText().isEmpty()){
            jTFVolume.setText("1");
        }
        if(jTFEdicao.getText().isEmpty()){
            jTFEdicao.setText("1");
        }
        if(editora == null){
            JOptionPane.showMessageDialog(null, "Selecione a editora.", "Editora", JOptionPane.INFORMATION_MESSAGE);
            jCBEditora.requestFocus();
            return false;
        }
        if(status == null){
            JOptionPane.showMessageDialog(null, "Selecione o status.", "Status", JOptionPane.INFORMATION_MESSAGE);
            jCBStatus.requestFocus();
            return false;
        }

        try{
            int num = Integer.parseInt(jTFNumero.getText());
        } catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Somente numeros.", "Erro", JOptionPane.ERROR_MESSAGE);
            jTFNumero.requestFocus();
            return false;
        }
        try{
            int num = Integer.parseInt(jTFEdicao.getText());
        } catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Somente numeros.", "Erro", JOptionPane.ERROR_MESSAGE);
            jTFEdicao.requestFocus();
            return false;
        }
        
        return true;
    }
    
    private void limpaCampos(){
        jCBTipoMidia.setSelectedIndex(0);
        jCBEditora.setSelectedIndex(0);
        jTFTitulo.setText(null);
        jTFNumero.setText(null);
        jTFVolume.setText(null);
        jTFEdicao.setText(null);
        jTAObservacao.setText(null);
        jCBStatus.setSelectedIndex(0);
    }
        
    public void salvar(){        
        if(catalogo == null){
            catalogo = new Catalogo();
            catalogo.setTipomidia(tipomidia);
            catalogo.setEditora(editora);
            catalogo.setDs_titulo(jTFTitulo.getText().trim());
            catalogo.setNm_numero(Integer.parseInt(jTFNumero.getText()));
            catalogo.setNm_volume(Integer.parseInt(jTFVolume.getText()));
            catalogo.setNm_edicao(Integer.parseInt(jTFEdicao.getText()));
            catalogo.setStatus(status);
            catalogo.setDs_observacao(jTAObservacao.getText());
            catalogo.setCd_usuario(JPLogin.codloginuser);
            catalogor.inserir(catalogo);
        } else {
            catalogo.setTipomidia(tipomidia);
            catalogo.setEditora(editora);
            catalogo.setDs_titulo(jTFTitulo.getText());
            catalogo.setNm_numero(Integer.parseInt(jTFNumero.getText()));
            catalogo.setNm_volume(Integer.parseInt(jTFVolume.getText()));
            catalogo.setNm_edicao(Integer.parseInt(jTFEdicao.getText()));
            catalogo.setStatus(status);
            catalogo.setDs_observacao(jTAObservacao.getText());
            catalogo.setCd_usuario(JPLogin.codloginuser);
            catalogor.alterar(catalogo);
        }
    }
    
    private void telaCatalogo(){
        try {
            JIFCatalogo telacatalogo = new JIFCatalogo();
            getParent().add(telacatalogo);
            telacatalogo.setMaximum(true);
            telacatalogo.setVisible(true);
            dispose(); 
        } catch (PropertyVetoException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar tela de catálogo:\n" +
                    ex.getMessage(), "Catalogo", JOptionPane.ERROR_MESSAGE);
        }
    }
        
    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if(validaCampos()){
            salvar();
            telaCatalogo();
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jCBTipoMidiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBTipoMidiaActionPerformed
        if(jCBTipoMidia.getSelectedIndex() != 0){
            tipomidia = (TipoMidia) jCBTipoMidia.getSelectedItem();            
        }else{
            tipomidia = null;
        }    
    }//GEN-LAST:event_jCBTipoMidiaActionPerformed

    private void jCBEditoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBEditoraActionPerformed
        if(jCBEditora.getSelectedIndex() != 0){
            editora = (Editora) jCBEditora.getSelectedItem();
        }else{
            editora = null;
        }
    }//GEN-LAST:event_jCBEditoraActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        telaCatalogo();
        dispose();
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        limpaCampos();
    }//GEN-LAST:event_formInternalFrameClosed

    private void jCBStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBStatusActionPerformed
        if(jCBStatus.getSelectedIndex() != 0){
            status = (Status) jCBStatus.getSelectedItem();
        }else{
            status = null;
        }
    }//GEN-LAST:event_jCBStatusActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<Editora> jCBEditora;
    private javax.swing.JComboBox<Status> jCBStatus;
    private javax.swing.JComboBox<TipoMidia> jCBTipoMidia;
    private javax.swing.JLabel jLEdicao;
    private javax.swing.JLabel jLEditora;
    private javax.swing.JLabel jLNumero;
    private javax.swing.JLabel jLObservacao;
    private javax.swing.JLabel jLStatus;
    private javax.swing.JLabel jLTipoMidia;
    private javax.swing.JLabel jLTitulo;
    private javax.swing.JLabel jLVolume;
    private javax.swing.JPanel jPBotoes;
    private javax.swing.JPanel jPCampo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTAObservacao;
    private javax.swing.JTextField jTFEdicao;
    private javax.swing.JTextField jTFNumero;
    private javax.swing.JTextField jTFTitulo;
    private javax.swing.JTextField jTFVolume;
    // End of variables declaration//GEN-END:variables
}
