package br.com.rlmoura81.moura.financeirointerface;

import br.com.rlmoura81.moura.financeiro.FundoInvestimento;
import br.com.rlmoura81.moura.financeiro.FundoInvestimentoRepository;
import br.com.rlmoura81.moura.financeiro.FundoInvestimentoUtil;
import br.com.rlmoura81.moura.financeiro.GrupoFundo;
import br.com.rlmoura81.moura.financeiro.GrupoFundoRepository;
import br.com.rlmoura81.moura.financeiro.GrupoFundoUtil;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import javax.swing.JOptionPane;

public class JIFFundoInvestimento extends javax.swing.JInternalFrame {
    
    private static JIFFundoInvestimento jiffdinvestimento;
    
    public static JIFFundoInvestimento getInstancia(){
        if(jiffdinvestimento == null){
            jiffdinvestimento = new JIFFundoInvestimento();
            jiffdinvestimento.setTitle("Fundos de Investimentos");
        }return jiffdinvestimento;
    }
       
    FundoInvestimento fdinvest = new FundoInvestimento();
    FundoInvestimentoRepository fdinvestr = new FundoInvestimentoRepository();
    FundoInvestimentoUtil fdinvestu = new FundoInvestimentoUtil();
    
    GrupoFundo gpfundo = new GrupoFundo();
    GrupoFundoRepository gpfundor = new GrupoFundoRepository();
    GrupoFundoUtil gpfundou = new GrupoFundoUtil();

    public JIFFundoInvestimento() {
        initComponents();
        
        jcGpFundo();
        tabelaFundoInvestimento();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPCampos = new javax.swing.JPanel();
        jCBGpFundo = new javax.swing.JComboBox<>();
        jLFundo = new javax.swing.JLabel();
        jTFFundo = new javax.swing.JTextField();
        jPBotoes = new javax.swing.JPanel();
        jBSalvar = new javax.swing.JButton();
        jBAlterar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jPGrid = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTFdInvestimento = new javax.swing.JTable();

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

        jCBGpFundo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBGpFundoActionPerformed(evt);
            }
        });

        jLFundo.setText("Fundo:");

        javax.swing.GroupLayout jPCamposLayout = new javax.swing.GroupLayout(jPCampos);
        jPCampos.setLayout(jPCamposLayout);
        jPCamposLayout.setHorizontalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCBGpFundo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLFundo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFFundo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPCamposLayout.setVerticalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBGpFundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLFundo)
                    .addComponent(jTFFundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        jTFdInvestimento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTFdInvestimento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTFdInvestimentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTFdInvestimento);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCBGpFundoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBGpFundoActionPerformed
        gpfundo = (GrupoFundo)jCBGpFundo.getSelectedItem();
    }//GEN-LAST:event_jCBGpFundoActionPerformed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if(validaCampos()){
            salvar();
            limpaCampos();
            tabelaFundoInvestimento();
            JOptionPane.showMessageDialog(null, "Salvo.");
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        fdinvest = (FundoInvestimento)fdinvestu.getSelectObject(jTFdInvestimento);
        if(validaCampos()){
            alterar();
            limpaCampos();
            tabelaFundoInvestimento();
            JOptionPane.showMessageDialog(null, "Alterado.");
        }
    }//GEN-LAST:event_jBAlterarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        fdinvest = (FundoInvestimento)fdinvestu.getSelectObject(jTFdInvestimento);
        if(validaCampos()){
            excluir();
            limpaCampos();
            tabelaFundoInvestimento();
            JOptionPane.showMessageDialog(null, "Excluido.");
        }
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jiffdinvestimento = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jTFdInvestimentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFdInvestimentoMouseClicked
        fdinvest = (FundoInvestimento)fdinvestu.getSelectObject(jTFdInvestimento);
        jCBGpFundo.setSelectedItem(fdinvest.getGpfundo());
        jTFFundo.setText(fdinvest.getDs_fdinvest());
    }//GEN-LAST:event_jTFdInvestimentoMouseClicked

    private void tabelaFundoInvestimento(){
        fdinvestu.tabelaFundoInvestimento(jTFdInvestimento);
    }    
    private void jcGpFundo(){
        gpfundou.jcGpFundo(jCBGpFundo);
    }
    
    private boolean validaCampos(){
        if(((GrupoFundo)jCBGpFundo.getSelectedItem()).getCd_gpfundo() == 0){
            JOptionPane.showMessageDialog(null, "Selecione o Tipo de Fundo.");
            jCBGpFundo.requestFocus();
            return false;
        }
        if(jTFFundo.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Digite o nome do fundo.");
            jTFFundo.requestFocus();
            return false;
        }
        return true;
    }
    
    private void limpaCampos(){
        jCBGpFundo.setSelectedIndex(0);
        jTFFundo.setText(null);
    }
    
    private void salvar(){
        fdinvest.setGpfundo(gpfundo);
        fdinvest.setDs_fdinvest(jTFFundo.getText());
        fdinvest.setCd_usuario(JPLogin.codloginuser);
        fdinvestr.inserir(fdinvest);
    }
    
    private void alterar(){
        fdinvest.setGpfundo(gpfundo);
        fdinvest.setDs_fdinvest(jTFFundo.getText());
        fdinvest.setCd_usuario(JPLogin.codloginuser);
        fdinvestr.alterar(fdinvest);
    }
    
    private void excluir(){
        fdinvest.setCd_fdinvest(fdinvest.getCd_fdinvest());
        fdinvestr.excluir(fdinvest);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<GrupoFundo> jCBGpFundo;
    private javax.swing.JLabel jLFundo;
    private javax.swing.JPanel jPBotoes;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JPanel jPGrid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFFundo;
    private javax.swing.JTable jTFdInvestimento;
    // End of variables declaration//GEN-END:variables
}
