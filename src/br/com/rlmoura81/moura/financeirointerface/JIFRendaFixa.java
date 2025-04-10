package br.com.rlmoura81.moura.financeirointerface;

import br.com.rlmoura81.moura.financeiro.Indice;
import br.com.rlmoura81.moura.financeiro.IndiceUtil;
import br.com.rlmoura81.moura.financeiro.RendaFixa;
import br.com.rlmoura81.moura.financeiro.RendaFixaRepository;
import br.com.rlmoura81.moura.financeiro.RendaFixaUtil;
import br.com.rlmoura81.moura.financeiro.TipoAtivo;
import br.com.rlmoura81.moura.financeiro.TipoAtivoUtil;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import javax.swing.JOptionPane;

public class JIFRendaFixa extends javax.swing.JInternalFrame {

    private static JIFRendaFixa jifrendafixa;
    
    public static JIFRendaFixa getInstancia(){
        if(jifrendafixa == null){
            jifrendafixa = new JIFRendaFixa();
            jifrendafixa.setTitle("Renda Fixa.");
        }return jifrendafixa;
    }
    
    Indice indice = null;
    IndiceUtil indiceu = new IndiceUtil();
    
    TipoAtivo tpativo = null;
    TipoAtivoUtil tpativou = new TipoAtivoUtil();
    
    RendaFixa rendafixa = new RendaFixa();
    RendaFixaRepository rendafixar = new RendaFixaRepository();
    RendaFixaUtil rendafixau = new RendaFixaUtil();
    
    Utilidade util = new Utilidade();
    
    public JIFRendaFixa() {
        initComponents();
        
        jcAtivoRendaFixa();
        jcIndice();
        tabelaRendaFixa();
        formataValor();
        formatarData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPCampos = new javax.swing.JPanel();
        jCBTipoAtivo = new javax.swing.JComboBox<>();
        jLRendaFixa = new javax.swing.JLabel();
        jLValorAplicado = new javax.swing.JLabel();
        jLTaxa = new javax.swing.JLabel();
        jLDataVencimento = new javax.swing.JLabel();
        jTFRendaFixa = new javax.swing.JTextField();
        jFTFValorAplicado = new javax.swing.JFormattedTextField();
        jFTFTaxa = new javax.swing.JFormattedTextField();
        jFTFDataVencimento = new javax.swing.JFormattedTextField();
        jLDataAplicacao = new javax.swing.JLabel();
        jFTFDataAplicacao = new javax.swing.JFormattedTextField();
        jCBIndice = new javax.swing.JComboBox<>();
        jPBotoes = new javax.swing.JPanel();
        jBSalvar = new javax.swing.JButton();
        jBAlterar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jPGrid = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTRendaFixa = new javax.swing.JTable();

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

        jPCampos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jCBTipoAtivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBTipoAtivoActionPerformed(evt);
            }
        });

        jLRendaFixa.setText("Renda Fixa:");

        jLValorAplicado.setText("Valor Aplicado:");

        jLTaxa.setText("Taxa:");

        jLDataVencimento.setText("Data Vencimento:");

        jTFRendaFixa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFRendaFixaFocusLost(evt);
            }
        });

        jLDataAplicacao.setText("Data Aplicação:");

        jCBIndice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBIndiceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPCamposLayout = new javax.swing.GroupLayout(jPCampos);
        jPCampos.setLayout(jPCamposLayout);
        jPCamposLayout.setHorizontalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addComponent(jLRendaFixa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(293, 293, 293))
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPCamposLayout.createSequentialGroup()
                                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLDataAplicacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLDataVencimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFTFDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFTFDataAplicacao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPCamposLayout.createSequentialGroup()
                                .addComponent(jLTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jFTFTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCBIndice, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPCamposLayout.createSequentialGroup()
                                .addComponent(jLValorAplicado, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jFTFValorAplicado, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPCamposLayout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(jTFRendaFixa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 55, Short.MAX_VALUE))
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addComponent(jCBTipoAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPCamposLayout.setVerticalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCBTipoAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLRendaFixa)
                    .addComponent(jTFRendaFixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLValorAplicado)
                    .addComponent(jFTFValorAplicado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTaxa)
                    .addComponent(jFTFTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBIndice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLDataAplicacao)
                    .addComponent(jFTFDataAplicacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFTFDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLDataVencimento))
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

        jPGrid.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTRendaFixa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTRendaFixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTRendaFixaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTRendaFixa);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jcAtivoRendaFixa(){
        tpativou.jcTipoAtivoRendaFixa(jCBTipoAtivo);
    }
    
    private void jcIndice(){
        indiceu.jcIndice(jCBIndice);
    }
    
    private void formataValor() {
        jFTFValorAplicado.setFormatterFactory(Utilidade.formataValorCampo(ui));
        jFTFTaxa.setFormatterFactory(Utilidade.formataValorCampo(ui));
    }  
    
    private void formatarData(){
        util.formataDataCampo(jFTFDataAplicacao);
        util.formataDataCampo(jFTFDataVencimento);       
    }
    
    private void tabelaRendaFixa(){
        rendafixau.tabelaRendaFixa(jTRendaFixa);
    } 
    
    private void limparCampos(){
        jCBTipoAtivo.setSelectedIndex(0);
        jCBIndice.setSelectedIndex(0);
        jTFRendaFixa.setText(null);
        jFTFValorAplicado.setValue(null);
        jFTFTaxa.setValue(null);
        jFTFDataAplicacao.setText(null);
        jFTFDataVencimento.setText(null);
    }
    
    private boolean validaCampos(){
        if(tpativo == null){
            JOptionPane.showMessageDialog(null, "Selecione o tipo de ativo.", "Ativo", JOptionPane.INFORMATION_MESSAGE);
            jCBTipoAtivo.requestFocus();
            return false;
        }
        if(jTFRendaFixa.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Renda fixa em branco.", "Renda Fixa", JOptionPane.INFORMATION_MESSAGE);
            jTFRendaFixa.requestFocus();
            return false;
        }
        if(jFTFValorAplicado.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Valor aplicado em branco.", "Renda Fixa", JOptionPane.INFORMATION_MESSAGE);
            jFTFValorAplicado.requestFocus();
            return false;
        }
        if(jFTFTaxa.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Valor de rentabilidade em branco.", "Renda Fixa", JOptionPane.INFORMATION_MESSAGE);
            jFTFTaxa.requestFocus();
            return false;
        }
        if(indice == null){
            JOptionPane.showMessageDialog(null, "Selecione o índice.", "Índice", JOptionPane.INFORMATION_MESSAGE);
            jCBIndice.requestFocus();
            return false;
        }
        if(util.validaDataCampo(jFTFDataAplicacao.getText()) == false){
            jFTFDataAplicacao.requestFocus();
            return false;
        }
        if(util.validaDataCampo(jFTFDataVencimento.getText()) == false){
            jFTFDataVencimento.requestFocus();
            return false;
        }
        return true;
    }
    
    private void salvar(){
        rendafixa.setTipoativo(tpativo);
        rendafixa.setIndice(indice);
        rendafixa.setDs_rendafixa(jTFRendaFixa.getText());
        rendafixa.setVl_aplicado(Utilidade.converter(jFTFValorAplicado.getText()));
        rendafixa.setVl_taxa(Utilidade.converter(jFTFTaxa.getText()));
        rendafixa.setDt_aplicacao(util.recebeData(jFTFDataAplicacao.getText()));
        rendafixa.setDt_vencimento(util.recebeData(jFTFDataVencimento.getText()));
        rendafixa.setCd_usuario(JPLogin.codloginuser);
        rendafixar.inserir(rendafixa);
    }
    
    private void alterar(){
        rendafixa.setTipoativo(tpativo);
        rendafixa.setIndice(indice);
        rendafixa.setDs_rendafixa(jTFRendaFixa.getText());
        rendafixa.setVl_aplicado(Utilidade.converter(jFTFValorAplicado.getText()));
        rendafixa.setVl_taxa(Utilidade.converter(jFTFTaxa.getText()));
        rendafixa.setDt_aplicacao(util.recebeData(jFTFDataAplicacao.getText()));
        rendafixa.setDt_vencimento(util.recebeData(jFTFDataVencimento.getText()));
        rendafixar.alterar(rendafixa);        
    }
    
    private void excluir(){
        rendafixa.setCd_rendafixa(rendafixa.getCd_rendafixa());
        rendafixar.excluir(rendafixa);
    }
    
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifrendafixa = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jTFRendaFixaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFRendaFixaFocusLost
        jTFRendaFixa.setText(jTFRendaFixa.getText().toUpperCase());
    }//GEN-LAST:event_jTFRendaFixaFocusLost

    private void jCBTipoAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBTipoAtivoActionPerformed
        if(jCBTipoAtivo.getSelectedIndex() != 0){
            tpativo = (TipoAtivo)jCBTipoAtivo.getSelectedItem();
        }else{
            tpativo = null;
        }
    }//GEN-LAST:event_jCBTipoAtivoActionPerformed

    private void jTRendaFixaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTRendaFixaMouseClicked
        rendafixa = (RendaFixa)rendafixau.getSelectObject(jTRendaFixa);
        jCBTipoAtivo.getModel().setSelectedItem(rendafixa.getTipoativo());
        jCBIndice.getModel().setSelectedItem(rendafixa.getIndice());
        jTFRendaFixa.setText(rendafixa.getDs_rendafixa());
        jFTFValorAplicado.setText(Utilidade.formatoValor.format(rendafixa.getVl_aplicado()));
        jFTFTaxa.setText(Utilidade.formatoValor.format(rendafixa.getVl_taxa()));
        jFTFDataAplicacao.setText(Utilidade.formatoData.format(rendafixa.getDt_aplicacao().getTime()));
        jFTFDataVencimento.setText(Utilidade.formatoData.format(rendafixa.getDt_vencimento().getTime()));
    }//GEN-LAST:event_jTRendaFixaMouseClicked

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if(validaCampos()){
            salvar();
            limparCampos();
            tabelaRendaFixa();            
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        rendafixa = (RendaFixa)rendafixau.getSelectObject(jTRendaFixa);
        if(rendafixa != null){
            alterar();
            limparCampos();
            tabelaRendaFixa();            
        }
    }//GEN-LAST:event_jBAlterarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        rendafixa = (RendaFixa)rendafixau.getSelectObject(jTRendaFixa);
        if(rendafixa != null){
            excluir();
            limparCampos();
            tabelaRendaFixa();
        }
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jCBIndiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBIndiceActionPerformed
        if(jCBIndice.getSelectedIndex() != 0){
            indice = (Indice)jCBIndice.getSelectedItem();
        }else{
            indice = null;
        }
    }//GEN-LAST:event_jCBIndiceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<Indice> jCBIndice;
    private javax.swing.JComboBox<TipoAtivo> jCBTipoAtivo;
    private javax.swing.JFormattedTextField jFTFDataAplicacao;
    private javax.swing.JFormattedTextField jFTFDataVencimento;
    private javax.swing.JFormattedTextField jFTFTaxa;
    private javax.swing.JFormattedTextField jFTFValorAplicado;
    private javax.swing.JLabel jLDataAplicacao;
    private javax.swing.JLabel jLDataVencimento;
    private javax.swing.JLabel jLRendaFixa;
    private javax.swing.JLabel jLTaxa;
    private javax.swing.JLabel jLValorAplicado;
    private javax.swing.JPanel jPBotoes;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JPanel jPGrid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFRendaFixa;
    private javax.swing.JTable jTRendaFixa;
    // End of variables declaration//GEN-END:variables

}
