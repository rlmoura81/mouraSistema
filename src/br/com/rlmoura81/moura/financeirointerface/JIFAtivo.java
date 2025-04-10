package br.com.rlmoura81.moura.financeirointerface;

import br.com.rlmoura81.moura.financeiro.Ativo;
import br.com.rlmoura81.moura.financeiro.AtivoRepository;
import br.com.rlmoura81.moura.financeiro.AtivoUtil;
import br.com.rlmoura81.moura.financeiro.TipoAtivo;
import br.com.rlmoura81.moura.financeiro.TipoAtivoUtil;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import javax.swing.JOptionPane;

public class JIFAtivo extends javax.swing.JInternalFrame {
    
    private static JIFAtivo jifativo;
    
    public static JIFAtivo getInstancia(){
        if(jifativo == null){
            jifativo = new JIFAtivo();
            jifativo.setTitle("Ativos");
        }
        return jifativo;
    }

    TipoAtivo tpativo = null;
    TipoAtivoUtil tpativou = new TipoAtivoUtil();
    
    Ativo ativo = new Ativo();
    AtivoRepository ativor = new AtivoRepository();
    AtivoUtil ativou = new AtivoUtil();
    
    Utilidade util = new Utilidade();
        
    public JIFAtivo() {
        initComponents();
        
        jcTipoAtivo();
        formataCampo();
        tabelaAtivo();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPCampos = new javax.swing.JPanel();
        jLAtivo = new javax.swing.JLabel();
        jLSigla = new javax.swing.JLabel();
        jLCnpj = new javax.swing.JLabel();
        jLTipo = new javax.swing.JLabel();
        jTFAtivo = new javax.swing.JTextField();
        jTFSigla = new javax.swing.JTextField();
        jCBTipoAtivo = new javax.swing.JComboBox<>();
        jFTFDocumento = new javax.swing.JFormattedTextField();
        jPBotoes = new javax.swing.JPanel();
        jBSalvar = new javax.swing.JButton();
        jBAlterar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jPAtivo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAtivo = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
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

        jLAtivo.setText("Ativo:");

        jLSigla.setText("Sigla:");

        jLCnpj.setText("CNPJ:");

        jLTipo.setText("Tipo:");

        jCBTipoAtivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBTipoAtivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPCamposLayout = new javax.swing.GroupLayout(jPCampos);
        jPCampos.setLayout(jPCamposLayout);
        jPCamposLayout.setHorizontalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLAtivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLSigla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLCnpj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTFAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFSigla, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBTipoAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFTFDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPCamposLayout.setVerticalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLAtivo)
                    .addComponent(jTFAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLSigla)
                    .addComponent(jTFSigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCnpj)
                    .addComponent(jFTFDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBTipoAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLTipo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jBAlterar)
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
                    .addComponent(jBAlterar)
                    .addComponent(jBExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPAtivo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTAtivo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTAtivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTAtivoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTAtivo);

        javax.swing.GroupLayout jPAtivoLayout = new javax.swing.GroupLayout(jPAtivo);
        jPAtivo.setLayout(jPAtivoLayout);
        jPAtivoLayout.setHorizontalGroup(
            jPAtivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPAtivoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        jPAtivoLayout.setVerticalGroup(
            jPAtivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPAtivoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPAtivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPCampos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPBotoes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPAtivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jcTipoAtivo(){
        tpativou.jcTipoAtivo(jCBTipoAtivo);
    }
    
    private void tabelaAtivo(){
        ativou.tabelaAtivo(jTAtivo);
    }
    
    private void formataCampo(){
        util.formataDocumento(jFTFDocumento, 2);
    }
    
    private boolean validaCampos(){
        if(jTFAtivo.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo em branco.", "Ativo.", JOptionPane.INFORMATION_MESSAGE);
            jTFAtivo.requestFocus();
            return false;
        }
        if(jTFSigla.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo em branco.", "Ativo.", JOptionPane.INFORMATION_MESSAGE);
            jTFSigla.requestFocus();
            return false;
        }
        if(tpativo == null){
            JOptionPane.showMessageDialog(null, "Selecione o tipo.", "Tipo de Ativo", JOptionPane.INFORMATION_MESSAGE);
            jCBTipoAtivo.requestFocus();
            return false;
        }
        return true;
    }
    
    private void limpaCampos(){
        jTFAtivo.setText(null);
        jTFSigla.setText(null);
        jFTFDocumento.setText(null);
        jCBTipoAtivo.setSelectedIndex(0);
    }
        
    private void salvar(){
        ativo.setDs_ativo(jTFAtivo.getText());
        ativo.setDs_sgativo(jTFSigla.getText());
        ativo.setNm_cnpj(Utilidade.retiraMascaraDocumento(jFTFDocumento.getText()));
        ativo.setTpativo(tpativo);
        ativo.setCd_usuario(JPLogin.codloginuser);
        ativor.inserir(ativo);
    }
    
    private void alterar(){
        ativo.setDs_ativo(jTFAtivo.getText());
        ativo.setDs_sgativo(jTFSigla.getText());
        ativo.setNm_cnpj(Utilidade.retiraMascaraDocumento(jFTFDocumento.getText()));
        ativo.setTpativo(tpativo);
        ativo.setCd_usuario(JPLogin.codloginuser);
        ativor.alterar(ativo);
    }
    
    private void excluir(){
        ativo.setCd_ativo(ativo.getCd_ativo());
        ativor.excluir(ativo);
    }
    
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifativo = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jCBTipoAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBTipoAtivoActionPerformed
        if(jCBTipoAtivo.getSelectedIndex() != 0){
            tpativo = (TipoAtivo)jCBTipoAtivo.getSelectedItem();
        }else{
            tpativo = null;
        }
    }//GEN-LAST:event_jCBTipoAtivoActionPerformed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if(validaCampos()){
            salvar();
            limpaCampos();
            tabelaAtivo();
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        ativo = (Ativo)ativou.getSelectObject(jTAtivo);
        if(ativo != null){
            alterar();            
            limpaCampos();
            tabelaAtivo();
        }
    }//GEN-LAST:event_jBAlterarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        ativo = (Ativo)ativou.getSelectObject(jTAtivo);
        if(ativo != null){
            excluir();            
            limpaCampos();
            tabelaAtivo();
        }
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jTAtivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTAtivoMouseClicked
        ativo = (Ativo)ativou.getSelectObject(jTAtivo);        
        ativo.setCd_ativo(ativo.getCd_ativo());
        jTFAtivo.setText(ativo.getDs_ativo());
        jTFSigla.setText(ativo.getDs_sgativo());
        jFTFDocumento.setText(ativo.getNm_cnpj());
        jCBTipoAtivo.getModel().setSelectedItem(ativo.getTpativo());        
    }//GEN-LAST:event_jTAtivoMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<TipoAtivo> jCBTipoAtivo;
    private javax.swing.JFormattedTextField jFTFDocumento;
    private javax.swing.JLabel jLAtivo;
    private javax.swing.JLabel jLCnpj;
    private javax.swing.JLabel jLSigla;
    private javax.swing.JLabel jLTipo;
    private javax.swing.JPanel jPAtivo;
    private javax.swing.JPanel jPBotoes;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTAtivo;
    private javax.swing.JTextField jTFAtivo;
    private javax.swing.JTextField jTFSigla;
    // End of variables declaration//GEN-END:variables
}
