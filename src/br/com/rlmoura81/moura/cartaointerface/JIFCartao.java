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
    
    /**
     * <p><strong>EN:</strong> Returns the singleton instance of the JIFCartao internal frame.  
     * If the instance does not exist, it is created and initialized with the title "Cartões".</p>
     *
     * <p><strong>IT:</strong> Restituisce l'istanza singleton del frame interno JIFCartao.  
     * Se l'istanza non esiste, viene creata e inizializzata con il titolo "Cartões".</p>
     *
     * <p><strong>PT-BR:</strong> Retorna a instância singleton do frame interno JIFCartao.  
     * Caso a instância não exista, ela é criada e inicializada com o título "Cartões".</p>
     *
     * @return EN: unique instance of JIFCartao | IT: istanza unica di JIFCartao | PT-BR: instância única de JIFCartao
     * @since 1.0.0
     */
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

    /**
     * <p><strong>EN:</strong> Populates the card brand JComboBox using the utility class.</p>
     *
     * <p><strong>IT:</strong> Popola il JComboBox delle bandiere di carta utilizzando la classe di utilità.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche o JComboBox das bandeiras do cartão utilizando a classe utilitária.</p>
     *
     * @since 1.0.0
     */
    private void jcCartaBandeira(){
        cartaobandeirau.jcCartaBandeira(jCBBandeira);
    }

    /**
     * <p><strong>EN:</strong> Formats the card limit field and applies a numeric mask to the card number field.</p>
     *
     * <p><strong>IT:</strong> Formattta il campo del limite della carta e applica una maschera numerica al campo del numero della carta.</p>
     *
     * <p><strong>PT-BR:</strong> Formata o campo do limite do cartão e aplica uma máscara numérica ao campo do número do cartão.</p>
     *
     * @since 1.0.0
     */    
    private void formataCampo(){
        jFTFLimite.setFormatterFactory(Utilidade.formataValorCampo(ui));
        cartaou.formataNumCartao(jFTFNumCartao);
    }

    /**
     * <p><strong>EN:</strong> Formats the card expiration date field with the proper date mask.</p>
     *
     * <p><strong>IT:</strong> Formattta il campo della data di scadenza della carta con la maschera corretta.</p>
     *
     * <p><strong>PT-BR:</strong> Formata o campo de validade do cartão com a máscara de data apropriada.</p>
     *
     * @since 1.0.0
     */    
    private void formataData(){
        util.formataDataCampo(jFTFData);
    }

    /**
     * <p><strong>EN:</strong> Validates all required fields for a card before saving or updating.  
     * Displays messages if any validation fails.</p>
     *
     * <p><strong>IT:</strong> Valida tutti i campi obbligatori di una carta prima di salvare o aggiornare.  
     * Mostra messaggi se una validazione fallisce.</p>
     *
     * <p><strong>PT-BR:</strong> Valida todos os campos obrigatórios de um cartão antes de salvar ou atualizar.  
     * Exibe mensagens caso alguma validação falhe.</p>
     *
     * @return EN: true if all fields are valid, false otherwise | IT: true se tutti i campi sono validi, altrimenti false | PT-BR: true se todos os campos forem válidos, caso contrário false
     * @since 1.0.0
     */    
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

    /**
     * <p><strong>EN:</strong> Clears all card input fields and resets JComboBox selections.</p>
     *
     * <p><strong>IT:</strong> Pulisce tutti i campi di input della carta e reimposta le selezioni dei JComboBox.</p>
     *
     * <p><strong>PT-BR:</strong> Limpa todos os campos de entrada do cartão e reinicia as seleções dos JComboBox.</p>
     *
     * @since 1.0.0
     */    
    private void limpaCampos(){
        jCBBandeira.setSelectedIndex(0);
        jFTFNumCartao.setText(null);
        jFTFLimite.setValue(null);
        jFTFData.setText(null);
    }

    /**
     * <p><strong>EN:</strong> Loads and displays the cards of a specific bank in a JTable.</p>
     *
     * <p><strong>IT:</strong> Carica e visualizza le carte di una banca specifica in una JTable.</p>
     *
     * <p><strong>PT-BR:</strong> Carrega e exibe os cartões de um banco específico em uma JTable.</p>
     *
     * @param banco EN: bank identifier | IT: identificatore della banca | PT-BR: identificador do banco
     * @since 1.0.0
     */    
    private void tabelaCartao(int banco){
        cartaou.tabelaCartao(jTCartao, banco);
    }

    /**
     * <p><strong>EN:</strong> Creates and saves a new card (Cartao) with the form data.</p>
     *
     * <p><strong>IT:</strong> Crea e salva una nuova carta (Cartao) con i dati del form.</p>
     *
     * <p><strong>PT-BR:</strong> Cria e salva um novo cartão (Cartao) com os dados do formulário.</p>
     *
     * @since 1.0.0
     */
    private void salvar(){
        cartao.setBanco(banco);
        cartao.setCartaobandeira(cartaobandeira);
        cartao.setNm_cartao(CartaoUtil.converterNumCartao(jFTFNumCartao.getText()));
        cartao.setNm_limite(Utilidade.converter(jFTFLimite.getText()));
        cartao.setDt_vencimento(util.recebeData(jFTFData.getText()));
        cartao.setCd_usuario(JPLogin.codloginuser);
        cartaor.inserir(cartao);
    }

    /**
     * <p><strong>EN:</strong> Updates an existing card (Cartao) with the modified form data.</p>
     *
     * <p><strong>IT:</strong> Aggiorna una carta (Cartao) esistente con i dati modificati del form.</p>
     *
     * <p><strong>PT-BR:</strong> Atualiza um cartão (Cartao) existente com os dados alterados do formulário.</p>
     *
     * @since 1.0.0
     */    
    private void alterar(){
        cartao.setBanco(banco);
        cartao.setCartaobandeira(cartaobandeira);
        cartao.setNm_cartao(CartaoUtil.converterNumCartao(jFTFNumCartao.getText()));
        cartao.setNm_limite(Utilidade.converter(jFTFLimite.getText()));
        cartao.setDt_vencimento(util.recebeData(jFTFData.getText()));
        cartao.setCd_usuario(JPLogin.codloginuser);
        cartaor.alterar(cartao);
    }

    /**
     * <p><strong>EN:</strong> Deletes the selected card (Cartao) from the database.</p>
     *
     * <p><strong>IT:</strong> Elimina la carta (Cartao) selezionata dal database.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui o cartão (Cartao) selecionado do banco de dados.</p>
     *
     * @since 1.0.0
     */    
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
