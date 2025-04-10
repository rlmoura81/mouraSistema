package br.com.rlmoura81.moura.principalcadastrointerface;

import br.com.rlmoura81.moura.principalcadastro.PrestadorServico;
import br.com.rlmoura81.moura.principalcadastro.PrestadorServicoRepository;
import br.com.rlmoura81.moura.principalcadastro.PrestadorServicoUtil;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class JIFPrestadorServico extends javax.swing.JInternalFrame {
    
    private static JIFPrestadorServico jifprestadorservico;

    public static JIFPrestadorServico getInstancia(){
        if(jifprestadorservico == null){
            jifprestadorservico = new JIFPrestadorServico();
            jifprestadorservico.setTitle("Prestadores de serviços");
            try {
                jifprestadorservico.setMaximum(true);
            } catch (PropertyVetoException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao abrir:\n" + ex.getMessage(), "Prestador de Serviço", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(JIFPrestadorServico.class.getName()).log(Level.SEVERE, null, ex);
            }
        } return jifprestadorservico;
    }
    
    PrestadorServico presserv = null;
    PrestadorServicoRepository presservr = new PrestadorServicoRepository();
    PrestadorServicoUtil presservu = new PrestadorServicoUtil();
    
    Utilidade util = new Utilidade();
        
    public JIFPrestadorServico() {
        initComponents();

        tabelaPresServ();        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bGModulo = new javax.swing.ButtonGroup();
        jPBotoes = new javax.swing.JPanel();
        jBSalvar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jPCampos = new javax.swing.JPanel();
        jLDocumento = new javax.swing.JLabel();
        jLRazaoSocial = new javax.swing.JLabel();
        jTFRazaoSocial = new javax.swing.JTextField();
        jLPrestadorServico = new javax.swing.JLabel();
        jTFPrestadorServico = new javax.swing.JTextField();
        jFTFDocumento = new javax.swing.JFormattedTextField();
        jPGrid = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTPrestadorServico = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
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

        jBSalvar.setText("Salvar");
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });

        jBExcluir.setText("Excluir");
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
                .addComponent(jBExcluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPBotoesLayout.setVerticalGroup(
            jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalvar)
                    .addComponent(jBExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPCampos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLDocumento.setText("Documento:");

        jLRazaoSocial.setText("Razao Social:");

        jLPrestadorServico.setText("Nome/NomeFantasia:");

        jFTFDocumento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFTFDocumentoFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPCamposLayout = new javax.swing.GroupLayout(jPCampos);
        jPCampos.setLayout(jPCamposLayout);
        jPCamposLayout.setHorizontalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLPrestadorServico)
                    .addComponent(jTFPrestadorServico, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                    .addComponent(jLRazaoSocial)
                    .addComponent(jTFRazaoSocial)
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addComponent(jLDocumento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFTFDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPCamposLayout.setVerticalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLDocumento)
                    .addComponent(jFTFDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLPrestadorServico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFPrestadorServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLRazaoSocial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPGrid.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTPrestadorServico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTPrestadorServico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTPrestadorServicoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTPrestadorServico);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jPBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private boolean validaCampos(){
        if(jFTFDocumento.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo em branco.", "Prestador de Serviço", JOptionPane.INFORMATION_MESSAGE);
            jFTFDocumento.requestFocus();
            return false;
        }
        if(jTFPrestadorServico.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo em branco.", "Prestador de Serviço", JOptionPane.INFORMATION_MESSAGE);
            jTFPrestadorServico.requestFocus();
            return false;
        }
        return true;
    }
    
    private void limpaCampos(){
        jFTFDocumento.setText(null);
        jFTFDocumento.setValue(null);
        jTFPrestadorServico.setText(null);
        jTFRazaoSocial.setText(null);
    }
    
    private void tabelaPresServ(){
        presservu.tabelaPresServ(jTPrestadorServico);
    }
    
    private void salvar(){
        if(presserv == null){
            presserv = new PrestadorServico();
            presserv.setNm_documento(Utilidade.retiraMascaraDocumento(jFTFDocumento.getText()));
            presserv.setDs_presserv(jTFPrestadorServico.getText());
            presserv.setDs_razaosocial(jTFRazaoSocial.getText());
            presserv.setCd_usuario(JPLogin.codloginuser);
            presservr.inserir(presserv);
            presserv = null;
        }else{
            presserv.setNm_documento(Utilidade.retiraMascaraDocumento(jFTFDocumento.getText()));
            presserv.setDs_presserv(jTFPrestadorServico.getText());
            presserv.setDs_razaosocial(jTFRazaoSocial.getText());
            presserv.setCd_usuario(JPLogin.codloginuser);
            presservr.alterar(presserv);
            presserv = null;
        }         
    }
    
    private void excluir(){
        presserv.setCd_presserv(presserv.getCd_presserv());
        presservr.excluir(presserv);
        presserv = null;
    }
    
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifprestadorservico = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if(validaCampos()){
            salvar();
            limpaCampos();
            tabelaPresServ();
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jTPrestadorServicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTPrestadorServicoMouseClicked
        presserv = (PrestadorServico)presservu.getSelectObject(jTPrestadorServico);        
        jFTFDocumento.setValue(Utilidade.retornaDocumentoFormatado(presserv.getNm_documento(), presserv.getNm_documento().length()));        
        jTFPrestadorServico.setText(presserv.getDs_presserv());
        jTFRazaoSocial.setText(presserv.getDs_razaosocial());
    }//GEN-LAST:event_jTPrestadorServicoMouseClicked
    
    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        presserv = (PrestadorServico)presservu.getSelectObject(jTPrestadorServico);
        if(presserv != null){
            excluir();
            limpaCampos();
            tabelaPresServ();
        }
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jFTFDocumentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTFDocumentoFocusLost
        if(!jFTFDocumento.getText().isEmpty()){
            if(jFTFDocumento.getText().length() == 11 | jFTFDocumento.getText().length() == 14){
                PrestadorServico ps = new PrestadorServico();
                ps.setNm_documento(jFTFDocumento.getText());
                util.formataDocumento(jFTFDocumento, jFTFDocumento.getText().length());
                jFTFDocumento.setText(ps.getNm_documento());
            }else{
                JOptionPane.showMessageDialog(null, "Documento inválido.", "Pretador de Serviço", JOptionPane.INFORMATION_MESSAGE);
                jFTFDocumento.requestFocus();
            }            
        }
    }//GEN-LAST:event_jFTFDocumentoFocusLost
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bGModulo;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JFormattedTextField jFTFDocumento;
    private javax.swing.JLabel jLDocumento;
    private javax.swing.JLabel jLPrestadorServico;
    private javax.swing.JLabel jLRazaoSocial;
    private javax.swing.JPanel jPBotoes;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JPanel jPGrid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFPrestadorServico;
    private javax.swing.JTextField jTFRazaoSocial;
    private javax.swing.JTable jTPrestadorServico;
    // End of variables declaration//GEN-END:variables
}
