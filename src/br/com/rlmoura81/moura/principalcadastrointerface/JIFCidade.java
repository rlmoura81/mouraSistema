package br.com.rlmoura81.moura.principalcadastrointerface;

import br.com.rlmoura81.moura.principalcadastro.Cidade;
import br.com.rlmoura81.moura.principalcadastro.Estado;
import br.com.rlmoura81.moura.principalcadastro.CidadeRepository;
import br.com.rlmoura81.moura.principalcadastro.CidadeUtil;
import br.com.rlmoura81.moura.principalcadastro.EstadoUtil;
import javax.swing.JOptionPane;

public class JIFCidade extends javax.swing.JInternalFrame {
    
    private static JIFCidade jifcidade;
    
    public static JIFCidade getInstancia(){
        if (jifcidade == null){
            jifcidade = new JIFCidade();
            jifcidade.setTitle("Cidades");
        } return jifcidade;
    }

    Cidade cidade = null;
    CidadeRepository cidader = new CidadeRepository();
    CidadeUtil cidadeu = new CidadeUtil();
    
    Estado estado = null;
    EstadoUtil estadou = new EstadoUtil();
    
    public JIFCidade() {
        initComponents();        

        estadou.jcEstado(jCBEstado);
        tabelaCidade();        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLCidade = new javax.swing.JLabel();
        jCBEstado = new javax.swing.JComboBox<>();
        jLEstado = new javax.swing.JLabel();
        jBInserir = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jTFCidade = new javax.swing.JTextField();
        jBAlterar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTCidade = new javax.swing.JTable();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(420, 320));
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

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLCidade.setText("Cidade:");

        jCBEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBEstadoActionPerformed(evt);
            }
        });

        jLEstado.setText("Estado:");

        jBInserir.setText("Inserir");
        jBInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBInserirActionPerformed(evt);
            }
        });

        jBExcluir.setText("Excluir");
        jBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirActionPerformed(evt);
            }
        });

        jBAlterar.setText("Alterar");
        jBAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBInserir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBExcluir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLCidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLEstado)
                    .addComponent(jCBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCidade)
                    .addComponent(jTFCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBInserir)
                    .addComponent(jBAlterar)
                    .addComponent(jBExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTCidade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTCidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTCidadeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTCidade);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limpaCampos (){
        jCBEstado.setSelectedIndex(0);
        jTFCidade.setText(null);
        jTFCidade.requestFocus();
    }

    private void tabelaCidade(){
        cidadeu.tabelaCidade(jTCidade);
    }
    
    public boolean validaCampos(){
        if(estado == null){
            JOptionPane.showMessageDialog(null, "Escolha o estado.", "Estado", JOptionPane.INFORMATION_MESSAGE);
            jCBEstado.requestFocus();
            return false;
        }
        if (jTFCidade.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo em branco", "Cidade", JOptionPane.INFORMATION_MESSAGE);
            jTFCidade.requestFocus();
            return false;
        }
        return true;
    }
    
    private void salvar(){
        cidade.setEstado(estado);
        cidade.setDs_Cidade(jTFCidade.getText());
        cidader.inserir(cidade); 
        cidade = null;
    }
    
    private void alterar(){
        cidade.setDs_Cidade(jTFCidade.getText());
        cidade.setEstado(estado);           
        cidader.alterar(cidade);
        cidade = null;
    }
    
    private void excluir(){
        cidade.setCd_Cidade(cidade.getCd_Cidade());
        cidader.excluir(cidade);        
    }
    
    private void jBInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBInserirActionPerformed
        if (validaCampos()){
            salvar();
            limpaCampos();
            tabelaCidade();
        }    
    }//GEN-LAST:event_jBInserirActionPerformed

    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        cidade = (Cidade)cidadeu.getSelectObject(jTCidade);
        if(cidade != null){
            alterar();
            limpaCampos();
            tabelaCidade();
        }
    }//GEN-LAST:event_jBAlterarActionPerformed

    private void jCBEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBEstadoActionPerformed
        if(jCBEstado.getSelectedIndex() != 0){
            estado = (Estado)jCBEstado.getSelectedItem();
        }else{
            estado = null;
        }
    }//GEN-LAST:event_jCBEstadoActionPerformed

    private void jTCidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTCidadeMouseClicked
        cidade = (Cidade)cidadeu.getSelectObject(jTCidade);
        jTFCidade.setText(cidade.getDs_Cidade());
        jCBEstado.setSelectedItem(cidade.getEstado());
        cidade.setCd_Cidade(cidade.getCd_Cidade());                
    }//GEN-LAST:event_jTCidadeMouseClicked
        
    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        cidade = (Cidade)cidadeu.getSelectObject(jTCidade);
        if(cidade != null){
            excluir();
            limpaCampos();
            tabelaCidade();
        }
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifcidade = null;
    }//GEN-LAST:event_formInternalFrameClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBInserir;
    private javax.swing.JComboBox<Estado> jCBEstado;
    private javax.swing.JLabel jLCidade;
    private javax.swing.JLabel jLEstado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTCidade;
    private javax.swing.JTextField jTFCidade;
    // End of variables declaration//GEN-END:variables
}
