package br.com.rlmoura81.moura.catalogointerface;

import br.com.rlmoura81.moura.catalogo.Catalogo;
import br.com.rlmoura81.moura.catalogo.CatalogoRepository;
import br.com.rlmoura81.moura.catalogo.CatalogoUtil;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class JIFCatalogo extends javax.swing.JInternalFrame {
    
    private static JIFCatalogo jifcatalogo;
    
    public static JIFCatalogo getInstancia(){
        if(jifcatalogo == null){
            jifcatalogo = new JIFCatalogo();
            jifcatalogo.setTitle("Catálogo");
            try {
                jifcatalogo.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(JIFCatalogo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } return jifcatalogo;
    }
        
    Catalogo catalogo;
    CatalogoRepository catalogor = new CatalogoRepository();
    CatalogoUtil catalogou = new CatalogoUtil();

    public JIFCatalogo() {
        initComponents();        
        catalogou.tabelaCatalogo(jTCatalogo);               
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPBotoes = new javax.swing.JPanel();
        jBAlterar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jBPesquisar = new javax.swing.JButton();
        jBNovo = new javax.swing.JButton();
        jTFPesquisar = new javax.swing.JTextField();
        jPGrid = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTCatalogo = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
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

        jPBotoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBAlterar.setText("Alterar");
        jBAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAlterarActionPerformed(evt);
            }
        });

        jBExcluir.setText("Excluir");
        jBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirActionPerformed(evt);
            }
        });

        jBPesquisar.setText("Pesquisar");
        jBPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPesquisarActionPerformed(evt);
            }
        });

        jBNovo.setText("Novo");
        jBNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPBotoesLayout = new javax.swing.GroupLayout(jPBotoes);
        jPBotoes.setLayout(jPBotoesLayout);
        jPBotoesLayout.setHorizontalGroup(
            jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPBotoesLayout.setVerticalGroup(
            jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBNovo)
                    .addComponent(jBAlterar)
                    .addComponent(jBExcluir)
                    .addComponent(jBPesquisar)
                    .addComponent(jTFPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPGrid.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTCatalogo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTCatalogo);

        javax.swing.GroupLayout jPGridLayout = new javax.swing.GroupLayout(jPGrid);
        jPGrid.setLayout(jPGridLayout);
        jPGridLayout.setHorizontalGroup(
            jPGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPGridLayout.setVerticalGroup(
            jPGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void telaCatalogoCadastro(){
        JIFCatalogoCadastro telacatalogocad = new JIFCatalogoCadastro();
        getParent().add(telacatalogocad);
        telacatalogocad.setVisible(true);
        dispose();
    }
    
    private void jBNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNovoActionPerformed
        JIFCatalogoCadastro telacatalogocad = new JIFCatalogoCadastro();
        getParent().add(telacatalogocad);
        telacatalogocad.setTitle("Catálogo - Novo");
        telacatalogocad.setVisible(true);
        dispose();
    }//GEN-LAST:event_jBNovoActionPerformed

    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        catalogo = (Catalogo)catalogou.getSelectedObject(jTCatalogo);
        if(catalogo != null){
            JIFCatalogoCadastro telacatalogoalt = new JIFCatalogoCadastro(catalogo);
            getParent().add(telacatalogoalt);
            telacatalogoalt.setTitle("Catálogo - Alteração");
            telacatalogoalt.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jBAlterarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        catalogo = (Catalogo)catalogou.getSelectedObject(jTCatalogo);
        if(catalogo != null){
            catalogor.excluir(catalogo);
            catalogou.tabelaCatalogo(jTCatalogo);
            dispose();
        } 
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jBPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisarActionPerformed
        if(jTFPesquisar.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Digite para fazer a pesquisa.", "Pesquisar", JOptionPane.INFORMATION_MESSAGE);
            jTFPesquisar.requestFocus();
            catalogou.tabelaCatalogo(jTCatalogo);
        }else{
            jTFPesquisar.setText(null);
            catalogou.tabelaCatalogo(jTCatalogo, jTFPesquisar.getText());
        }
    }//GEN-LAST:event_jBPesquisarActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifcatalogo = null;
    }//GEN-LAST:event_formInternalFrameClosed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBNovo;
    private javax.swing.JButton jBPesquisar;
    private javax.swing.JPanel jPBotoes;
    private javax.swing.JPanel jPGrid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTCatalogo;
    private javax.swing.JTextField jTFPesquisar;
    // End of variables declaration//GEN-END:variables
}
