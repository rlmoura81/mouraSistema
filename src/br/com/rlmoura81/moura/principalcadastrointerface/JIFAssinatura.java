package br.com.rlmoura81.moura.principalcadastrointerface;

import br.com.rlmoura81.moura.principalcadastro.Assinatura;
import br.com.rlmoura81.moura.principalcadastro.AssinaturaRepository;
import br.com.rlmoura81.moura.principalcadastro.AssinaturaUtil;
import br.com.rlmoura81.moura.principalcadastro.PrestadorServico;
import br.com.rlmoura81.moura.principalcadastro.PrestadorServicoUtil;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class JIFAssinatura extends javax.swing.JInternalFrame {
    
    private static JIFAssinatura jifassinatura;
    
    public static JIFAssinatura getInstancia(){
        if(jifassinatura == null){
            jifassinatura = new JIFAssinatura();
            jifassinatura.setTitle("Assinaturas");
        }return jifassinatura;
    }
    
    Assinatura assinatura = null;
    AssinaturaRepository assinaturar = new AssinaturaRepository();
    AssinaturaUtil assinaturau = new AssinaturaUtil();
    
    PrestadorServico presserv = new PrestadorServico();
    PrestadorServicoUtil presservu = new PrestadorServicoUtil();
    
    Utilidade util = new Utilidade();

    public JIFAssinatura() {
        initComponents();
        
        jcPresserv();
        tabelaAssinatura();
        formataValor();
        formataData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bGTp_assinatura = new javax.swing.ButtonGroup();
        jPCampos = new javax.swing.JPanel();
        jLServico = new javax.swing.JLabel();
        jTFServico = new javax.swing.JTextField();
        jLLogin = new javax.swing.JLabel();
        jTFLogin = new javax.swing.JTextField();
        jLSenha = new javax.swing.JLabel();
        jTFSenha = new javax.swing.JTextField();
        jLValor = new javax.swing.JLabel();
        jFTFValor = new javax.swing.JFormattedTextField();
        jLDtValidade = new javax.swing.JLabel();
        jFTFDtValidade = new javax.swing.JFormattedTextField();
        jRBMensal = new javax.swing.JRadioButton();
        jRBAnual = new javax.swing.JRadioButton();
        jPBotoes = new javax.swing.JPanel();
        jBSalvar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jBPesquisar = new javax.swing.JButton();
        jPGrid = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAssinartura = new javax.swing.JTable();
        jPJCBox = new javax.swing.JPanel();
        jCBPresserv = new javax.swing.JComboBox<>();

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

        jLServico.setText("Serviço:");

        jLLogin.setText("Login\\ID:");

        jLSenha.setText("Senha:");

        jLValor.setText("Valor:");

        jLDtValidade.setText("Validade:");

        bGTp_assinatura.add(jRBMensal);
        jRBMensal.setText("Mensal");

        bGTp_assinatura.add(jRBAnual);
        jRBAnual.setText("Anual");

        javax.swing.GroupLayout jPCamposLayout = new javax.swing.GroupLayout(jPCampos);
        jPCampos.setLayout(jPCamposLayout);
        jPCamposLayout.setHorizontalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addComponent(jLServico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFServico, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLLogin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addComponent(jLValor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFTFValor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRBMensal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRBAnual)
                        .addGap(18, 18, 18)
                        .addComponent(jLDtValidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFTFDtValidade, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPCamposLayout.setVerticalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLServico)
                    .addComponent(jTFServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLLogin)
                    .addComponent(jTFLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLSenha))
                .addGap(18, 18, 18)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLDtValidade)
                        .addComponent(jFTFDtValidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLValor)
                        .addComponent(jFTFValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jRBMensal)
                        .addComponent(jRBAnual)))
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

        jBPesquisar.setText("Pesquisar");
        jBPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPesquisarActionPerformed(evt);
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
                .addGap(18, 18, 18)
                .addComponent(jBPesquisar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPBotoesLayout.setVerticalGroup(
            jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalvar)
                    .addComponent(jBExcluir)
                    .addComponent(jBPesquisar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPGrid.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTAssinartura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTAssinartura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTAssinarturaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTAssinartura);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPJCBox.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jCBPresserv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBPresservActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPJCBoxLayout = new javax.swing.GroupLayout(jPJCBox);
        jPJCBox.setLayout(jPJCBoxLayout);
        jPJCBoxLayout.setHorizontalGroup(
            jPJCBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPJCBoxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCBPresserv, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPJCBoxLayout.setVerticalGroup(
            jPJCBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPJCBoxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCBPresserv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPGrid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPJCBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPJCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcPresserv(){
        presservu.jcPresserv(jCBPresserv);
    }
    
    private void tabelaAssinatura(){
        assinaturau.tabelaAssinatura(jTAssinartura);
    }
    
    private void formataValor(){
        jFTFValor.setFormatterFactory(Utilidade.formataValorCampo(jFTFValor));
    }
    
    private void formataData(){
        util.formataDataCampo(jFTFDtValidade);
    }
    
    private void limpaCampos(){
        jCBPresserv.setSelectedIndex(0);
        jTFServico.setText(null);
        jTFLogin.setText(null);
        jTFSenha.setText(null);
        jFTFValor.setValue(null);
        bGTp_assinatura.clearSelection();
        jFTFDtValidade.setText(null);
    }
    
    private boolean validaCampos(){
        if(jTFServico.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo em branco.", "Assinatura", JOptionPane.INFORMATION_MESSAGE);
            jTFServico.requestFocus();
            return false;
        }
        if(jTFLogin.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo em branco.", "Assinatura", JOptionPane.ERROR_MESSAGE);
            jTFLogin.requestFocus();
            return false;
        }
        return true;
    }
    
    private void salvar(){
        if(jFTFValor.getText().isEmpty()){
            jFTFValor.setText("0,00");
        }
        if(assinatura == null){
            assinatura = new Assinatura();
            assinatura.setPresserv(presserv);
            assinatura.setDs_servico(jTFServico.getText());
            assinatura.setDs_login(jTFLogin.getText());
            assinatura.setDs_senha(jTFSenha.getText());
            assinatura.setNm_valor(Utilidade.converter(jFTFValor.getText()));
            if(jRBMensal.isSelected()){
                assinatura.setTp_assinatura(1);
            }
            if(jRBAnual.isSelected()){
                assinatura.setTp_assinatura(2);
            }
        if(util.validaDataCampo(jFTFDtValidade.getText()) == false){
            assinatura.setDt_validade(Calendar.getInstance());
        }else{
            assinatura.setDt_validade(util.recebeData(jFTFDtValidade.getText()));
        }
            assinatura.setCd_usuario(JPLogin.codloginuser);
            assinaturar.inserir(assinatura);    
            assinatura = null;
        }else{
            assinatura.setPresserv(presserv);
            assinatura.setDs_servico(jTFServico.getText());
            assinatura.setDs_login(jTFLogin.getText());
            assinatura.setDs_senha(jTFSenha.getText());
            assinatura.setNm_valor(Utilidade.converter(jFTFValor.getText()));
            if(jRBMensal.isSelected()){
                assinatura.setTp_assinatura(1);
            }
            if(jRBAnual.isSelected()){
                assinatura.setTp_assinatura(2);
            }
            assinatura.setDt_validade(util.recebeData(jFTFDtValidade.getText()));
            assinaturar.alterar(assinatura);
            assinatura = null;
        }
    }
    
    private void excluir(){
        assinatura.setCd_assinatura(assinatura.getCd_assinatura());
        assinatura.setCd_usuario(JPLogin.codloginuser);
        assinaturar.excluir(assinatura);
        assinatura = null;
    }
    
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifassinatura = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if(validaCampos()){
            salvar();
            limpaCampos();
            tabelaAssinatura();            
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        if((Assinatura)assinaturau.getSelectObject(jTAssinartura) != null){
            excluir();
            limpaCampos();
            tabelaAssinatura();            
        }
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jTAssinarturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTAssinarturaMouseClicked
        assinatura = (Assinatura)assinaturau.getSelectObject(jTAssinartura);
        if(assinatura.getPresserv() == null){
            jCBPresserv.setSelectedIndex(0);
        }else{
            jCBPresserv.getModel().setSelectedItem(assinatura.getPresserv());            
        }
        jTFServico.setText(assinatura.getDs_servico());
        jTFLogin.setText(assinatura.getDs_login());
        jTFSenha.setText(assinatura.getDs_senha());
        jFTFValor.setText(Utilidade.formatoValor.format(assinatura.getNm_valor()));
        if(assinatura.getTp_assinatura() == 1){
            jRBMensal.setSelected(true);
        }
        if(assinatura.getTp_assinatura() == 2){
            jRBAnual.setSelected(true);
        }
        jFTFDtValidade.setText(Utilidade.formatoData.format(assinatura.getDt_validade().getTime()));
    }//GEN-LAST:event_jTAssinarturaMouseClicked

    private void jBPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisarActionPerformed
        if(jTFServico.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo em branco.", "Pesquisa", JOptionPane.INFORMATION_MESSAGE);
            jTFServico.requestFocus();
            tabelaAssinatura();
        }else{
            assinatura = new Assinatura();
            assinatura.setDs_servico(jTFServico.getText());
            assinaturau.tabelaAssinatura(jTAssinartura, assinatura.getDs_servico());
        }
    }//GEN-LAST:event_jBPesquisarActionPerformed

    private void jCBPresservActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBPresservActionPerformed
        if(jCBPresserv.getSelectedIndex() != 0){
            presserv = (PrestadorServico)jCBPresserv.getSelectedItem();
            jTFServico.setText(presserv.getDs_presserv());
        }else{
            jTFServico.setText(null);
        }
    }//GEN-LAST:event_jCBPresservActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bGTp_assinatura;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBPesquisar;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<String> jCBPresserv;
    private javax.swing.JFormattedTextField jFTFDtValidade;
    private javax.swing.JFormattedTextField jFTFValor;
    private javax.swing.JLabel jLDtValidade;
    private javax.swing.JLabel jLLogin;
    private javax.swing.JLabel jLSenha;
    private javax.swing.JLabel jLServico;
    private javax.swing.JLabel jLValor;
    private javax.swing.JPanel jPBotoes;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JPanel jPGrid;
    private javax.swing.JPanel jPJCBox;
    private javax.swing.JRadioButton jRBAnual;
    private javax.swing.JRadioButton jRBMensal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTAssinartura;
    private javax.swing.JTextField jTFLogin;
    private javax.swing.JTextField jTFSenha;
    private javax.swing.JTextField jTFServico;
    // End of variables declaration//GEN-END:variables
}
