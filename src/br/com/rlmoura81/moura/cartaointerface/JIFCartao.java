package br.com.rlmoura81.moura.cartaointerface;

import br.com.rlmoura81.moura.financeiro.Banco;
import br.com.rlmoura81.moura.financeiro.BancoUtil;
import br.com.rlmoura81.moura.cartao.Cartao;
import br.com.rlmoura81.moura.cartao.CartaoBandeira;
import br.com.rlmoura81.moura.cartao.CartaoBandeiraUtil;
import br.com.rlmoura81.moura.cartao.CartaoRepository;
import br.com.rlmoura81.moura.cartao.CartaoUtil;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JIFCartao extends javax.swing.JInternalFrame {
    
    private static JIFCartao jifcartao;
    
    public static JIFCartao getInstancia(){
        if(jifcartao == null){
            jifcartao = new JIFCartao();
            jifcartao.setTitle("Cartões.");
        }return jifcartao;
    }
    
    Cartao cartao = new Cartao();
    CartaoRepository cartaor = new CartaoRepository();
    CartaoUtil cartaou = new CartaoUtil();
    
    CartaoBandeira cartaobandeira = null;
    CartaoBandeiraUtil cartaobandeirau = new CartaoBandeiraUtil();
    
    Banco banco = null;
    BancoUtil bancou = new BancoUtil();
    
    Utilidade util = new Utilidade();

    public JIFCartao() {
        initComponents();
        
        bancou.jcBanco(jCBBanco);
        jcCartaBandeira();
        formataCampo();
        formataData();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPCampos = new javax.swing.JPanel();
        jLBandeira = new javax.swing.JLabel();
        jCBBandeira = new javax.swing.JComboBox<>();
        jLNumero = new javax.swing.JLabel();
        jLLimite = new javax.swing.JLabel();
        jFTFLimite = new javax.swing.JFormattedTextField();
        jLData = new javax.swing.JLabel();
        jFTFData = new javax.swing.JFormattedTextField();
        jLBanco = new javax.swing.JLabel();
        jCBBanco = new javax.swing.JComboBox<>();
        jFTFNumCartao = new javax.swing.JFormattedTextField();
        jPBotoes = new javax.swing.JPanel();
        jBSalvar = new javax.swing.JButton();
        jBAlterar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jPGrid = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTCartao = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(500, 400));
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

        jLBandeira.setText("Bandeira:");

        jCBBandeira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBBandeiraActionPerformed(evt);
            }
        });

        jLNumero.setText("Numero:");

        jLLimite.setText("Limite:");

        jFTFLimite.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        jLData.setText("Data:");

        jLBanco.setText("Conta:");

        jCBBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBBancoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPCamposLayout = new javax.swing.GroupLayout(jPCampos);
        jPCampos.setLayout(jPCamposLayout);
        jPCamposLayout.setHorizontalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLBandeira, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLLimite, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLNumero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLBanco, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCBBandeira, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFTFLimite, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFTFData, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFTFNumCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPCamposLayout.setVerticalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLBanco)
                    .addComponent(jCBBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLBandeira)
                    .addComponent(jCBBandeira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNumero)
                    .addComponent(jFTFNumCartao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFTFLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLLimite))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLData)
                    .addComponent(jFTFData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPBotoesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalvar)
                    .addComponent(jBAlterar)
                    .addComponent(jBExcluir))
                .addContainerGap())
        );

        jPGrid.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTCartao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTCartao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTCartaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTCartao);

        javax.swing.GroupLayout jPGridLayout = new javax.swing.GroupLayout(jPGrid);
        jPGrid.setLayout(jPGridLayout);
        jPGridLayout.setHorizontalGroup(
            jPGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPGridLayout.setVerticalGroup(
            jPGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPGrid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPCampos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcCartaBandeira(){
        cartaobandeirau.jcCartaBandeira(jCBBandeira);
    }
    
    private void formataCampo(){
        jFTFLimite.setFormatterFactory(Utilidade.formataValorCampo(ui));
        cartaou.formataNumCartao(jFTFNumCartao);
    }
    
    private void formataData(){
        util.formataDataCampo(jFTFData);
    }
    
    private boolean validaCampos(){
        if(banco == null){
            JOptionPane.showMessageDialog(null, "Selecione o banco.", "Banco", JOptionPane.INFORMATION_MESSAGE);
            jCBBanco.requestFocus();
            return false;
        }
        if(cartaobandeira == null){
            JOptionPane.showMessageDialog(null, "Selecione a bandeira do cartão.", "Cartão Bandeira", JOptionPane.INFORMATION_MESSAGE);
            jCBBandeira.requestFocus();
            return false;
        }
        if(cartaou.validaNumCartao(jFTFNumCartao.getText()) == false){
            jFTFNumCartao.requestFocus();
            return false;
        }
        if(jFTFLimite.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Digite o valor de limite do cartão.", "Cartão", JOptionPane.INFORMATION_MESSAGE);
            jFTFLimite.requestFocus();
            return false;
        }
        if(util.validaDataCampo(jFTFData.getText()) == false){
            jFTFData.requestFocus();
            return false;
        }
        return true;
    }
    
    private void limpaCampos(){
        jCBBandeira.setSelectedIndex(0);
        jFTFNumCartao.setText(null);
        jFTFLimite.setValue(null);
        jFTFData.setText(null);
    }
    
    private void tabelaCartao(int banco){
        cartaou.tabelaCartao(jTCartao, banco);
    }
            
    private void salvar(){
        cartao.setBanco(banco);
        cartao.setCartaobandeira(cartaobandeira);
        cartao.setNm_cartao(CartaoUtil.converterNumCartao(jFTFNumCartao.getText()));
        cartao.setNm_limite(Utilidade.converter(jFTFLimite.getText()));
        cartao.setDt_vencimento(util.recebeData(jFTFData.getText()));
        cartao.setCd_usuario(JPLogin.codloginuser);
        cartaor.inserir(cartao);
    }
    
    private void alterar(){
        cartao.setBanco(banco);
        cartao.setCartaobandeira(cartaobandeira);
        cartao.setNm_cartao(CartaoUtil.converterNumCartao(jFTFNumCartao.getText()));
        cartao.setNm_limite(Utilidade.converter(jFTFLimite.getText()));
        cartao.setDt_vencimento(util.recebeData(jFTFData.getText()));
        cartao.setCd_usuario(JPLogin.codloginuser);
        cartaor.alterar(cartao);
    }
    
    private void excluir(){
        cartao.setCd_cartao(cartao.getCd_cartao());
        cartaor.excluir(cartao);
    }
    
    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if(validaCampos()){
            salvar();
            limpaCampos();
            tabelaCartao(banco.getCd_banco());            
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        cartao = (Cartao)cartaou.getSelectObject(jTCartao);
        if(cartao != null){
            alterar();
            limpaCampos();
            tabelaCartao(banco.getCd_banco());            
        }
    }//GEN-LAST:event_jBAlterarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        cartao = (Cartao)cartaou.getSelectObject(jTCartao);
        if(cartao != null){
            excluir();
            limpaCampos();
            tabelaCartao(banco.getCd_banco());            
        }
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jCBBandeiraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBBandeiraActionPerformed
        if(jCBBandeira.getSelectedIndex() != 0){
            cartaobandeira = (CartaoBandeira) jCBBandeira.getSelectedItem();
        }else{
            cartaobandeira = null;
        }        
    }//GEN-LAST:event_jCBBandeiraActionPerformed

    private void jTCartaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTCartaoMouseClicked
        cartao = (Cartao)cartaou.getSelectObject(jTCartao);
        jCBBandeira.getModel().setSelectedItem(cartao.getCartaobandeira());
        jFTFNumCartao.setText(cartao.getNm_cartao());        
        jFTFLimite.setText(Utilidade.formatoValor.format(cartao.getNm_limite()));        
        jFTFData.setText(Utilidade.formatoData.format(cartao.getDt_vencimento().getTime()));        
    }//GEN-LAST:event_jTCartaoMouseClicked

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifcartao = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jCBBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBBancoActionPerformed
        if(jCBBanco.getSelectedIndex() != 0){
            banco = (Banco) jCBBanco.getSelectedItem();
            tabelaCartao(banco.getCd_banco());
        }else{
            banco = null;
            ((DefaultTableModel)jTCartao.getModel()).setRowCount(0);
        }        
    }//GEN-LAST:event_jCBBancoActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<Banco> jCBBanco;
    private javax.swing.JComboBox<CartaoBandeira> jCBBandeira;
    private javax.swing.JFormattedTextField jFTFData;
    private javax.swing.JFormattedTextField jFTFLimite;
    private javax.swing.JFormattedTextField jFTFNumCartao;
    private javax.swing.JLabel jLBanco;
    private javax.swing.JLabel jLBandeira;
    private javax.swing.JLabel jLData;
    private javax.swing.JLabel jLLimite;
    private javax.swing.JLabel jLNumero;
    private javax.swing.JPanel jPBotoes;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JPanel jPGrid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTCartao;
    // End of variables declaration//GEN-END:variables
}
