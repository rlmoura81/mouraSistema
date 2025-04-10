package br.com.rlmoura81.moura.financeirointerface;

import br.com.rlmoura81.moura.financeiro.Moeda;
import br.com.rlmoura81.moura.financeiro.MoedaUtil;
import br.com.rlmoura81.moura.financeiro.MoedaValor;
import br.com.rlmoura81.moura.financeiro.MoedaValorRepository;
import br.com.rlmoura81.moura.financeiro.MoedaValorUtil;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import javax.swing.JOptionPane;

public class JIFMoedaValor extends javax.swing.JInternalFrame {
    
    private static JIFMoedaValor jifmoeda;
    
    public static JIFMoedaValor getInstancia(){
        if(jifmoeda == null){
            jifmoeda = new JIFMoedaValor();
            jifmoeda.setTitle("Moeda - cotação");
        }
        return jifmoeda;
    }
    
    MoedaValor moedavalor = new MoedaValor();
    MoedaValorRepository moedavalorr = new MoedaValorRepository();
    MoedaValorUtil moedavaloru = new MoedaValorUtil();
    
    Moeda moeda = null;
    MoedaUtil moedau = new MoedaUtil();

    Utilidade util = new Utilidade();
    
    public JIFMoedaValor() {
        initComponents();
        
        formataCampo();
        formataData();
        jcMoeda();
        tabelaCotacao();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPMoeda = new javax.swing.JPanel();
        jCBMoeda = new javax.swing.JComboBox<>();
        jPCampos = new javax.swing.JPanel();
        jLData = new javax.swing.JLabel();
        jFTFData = new javax.swing.JFormattedTextField();
        jLValor = new javax.swing.JLabel();
        jFTFValor = new javax.swing.JFormattedTextField();
        jPBotoes = new javax.swing.JPanel();
        jBSalvar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jBAlterar = new javax.swing.JButton();
        jPGrid = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTMoedaValor = new javax.swing.JTable();

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

        jPMoeda.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jCBMoeda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBMoedaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPMoedaLayout = new javax.swing.GroupLayout(jPMoeda);
        jPMoeda.setLayout(jPMoedaLayout);
        jPMoedaLayout.setHorizontalGroup(
            jPMoedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPMoedaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCBMoeda, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPMoedaLayout.setVerticalGroup(
            jPMoedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPMoedaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCBMoeda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPCampos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLData.setText("Data:");

        jLValor.setText("Valor:");

        javax.swing.GroupLayout jPCamposLayout = new javax.swing.GroupLayout(jPCampos);
        jPCampos.setLayout(jPCamposLayout);
        jPCamposLayout.setHorizontalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFData, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLValor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFValor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
        );
        jPCamposLayout.setVerticalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLData)
                    .addComponent(jFTFData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLValor)
                    .addComponent(jFTFValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        jBAlterar.setText("Alterar");
        jBAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAlterarActionPerformed(evt);
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
                    .addComponent(jBExcluir)
                    .addComponent(jBAlterar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPGrid.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTMoedaValor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTMoedaValor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTMoedaValorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTMoedaValor);

        javax.swing.GroupLayout jPGridLayout = new javax.swing.GroupLayout(jPGrid);
        jPGrid.setLayout(jPGridLayout);
        jPGridLayout.setHorizontalGroup(
            jPGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPGridLayout.setVerticalGroup(
            jPGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPMoeda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPMoeda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formataData(){
        util.formataDataCampo(jFTFData);
    }
    
    private void formataCampo(){
        jFTFValor.setFormatterFactory(Utilidade.formataValorCampoTres(ui));
    }
    
    private void jcMoeda(){
        moedau.jcMoeda(jCBMoeda);
    }
    
    private void tabelaCotacao(){
        moedavaloru.tabelaIndiceValor(jTMoedaValor);
    }
    
    private boolean validaCampos(){
        if(moeda == null){
            JOptionPane.showMessageDialog(null, "Selecione a moeda.", "Moeda", JOptionPane.INFORMATION_MESSAGE);
            jCBMoeda.requestFocus();
            return false;
        }
        if(util.validaDataCampo(jFTFData.getText()) == false){
            jFTFData.requestFocus();
            return false;
        }
        if(jFTFValor.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Informe o valor.", "Moeda Valor", JOptionPane.INFORMATION_MESSAGE);
            jFTFValor.requestFocus();
            return false;
        }
        return true;
    }
    
    private void limpaCampos(){
        jCBMoeda.setSelectedIndex(0);
        jFTFData.setText(null);
        jFTFValor.setValue(null);
    }
    
    private void salvar(){
        moedavalor.setMoeda(moeda);
        moedavalor.setDt_valor(util.recebeData(jFTFData.getText()));
        moedavalor.setVl_moeda(Utilidade.converter(jFTFValor.getText()));
        moedavalor.setCd_usuario(JPLogin.codloginuser);
        moedavalorr.inserir(moedavalor);
    }
    
    private void alterar(){
        moedavalor.setMoeda(moeda);
        moedavalor.setDt_valor(util.recebeData(jFTFData.getText()));
        moedavalor.setVl_moeda(Utilidade.converter(jFTFValor.getText()));
        moedavalor.setCd_usuario(JPLogin.codloginuser);
        moedavalorr.alterar(moedavalor);
    }
    
    private void excluir(){
        moedavalor.setCd_moedavl(moedavalor.getCd_moedavl());
        moedavalorr.excluir(moedavalor);
    }
    
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifmoeda = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jCBMoedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBMoedaActionPerformed
        if(jCBMoeda.getSelectedIndex() != 0){
            moeda = (Moeda)jCBMoeda.getSelectedItem();
        }else{
            moeda = null;
        }
    }//GEN-LAST:event_jCBMoedaActionPerformed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if(validaCampos()){
            salvar();
            limpaCampos();
            tabelaCotacao();            
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        moedavalor = (MoedaValor)moedavaloru.getSelectObject(jTMoedaValor);
        if(moedavalor != null){
            excluir();
            limpaCampos();
            tabelaCotacao();            
        }
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jTMoedaValorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTMoedaValorMouseClicked
        moedavalor = (MoedaValor)moedavaloru.getSelectObject(jTMoedaValor);
        jCBMoeda.getModel().setSelectedItem(moedavalor.getMoeda());
        jFTFData.setText(Utilidade.formatoData.format(moedavalor.getDt_valor().getTime()));
        jFTFValor.setText(Utilidade.formatoValorTres.format(moedavalor.getVl_moeda()));
    }//GEN-LAST:event_jTMoedaValorMouseClicked

    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        moedavalor = (MoedaValor)moedavaloru.getSelectObject(jTMoedaValor);
        if(moedavalor != null){
            alterar();
            limpaCampos();
            tabelaCotacao();            
        }
    }//GEN-LAST:event_jBAlterarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<Moeda> jCBMoeda;
    private javax.swing.JFormattedTextField jFTFData;
    private javax.swing.JFormattedTextField jFTFValor;
    private javax.swing.JLabel jLData;
    private javax.swing.JLabel jLValor;
    private javax.swing.JPanel jPBotoes;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JPanel jPGrid;
    private javax.swing.JPanel jPMoeda;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTMoedaValor;
    // End of variables declaration//GEN-END:variables
}
