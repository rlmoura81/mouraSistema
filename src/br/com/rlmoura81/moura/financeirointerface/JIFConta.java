package br.com.rlmoura81.moura.financeirointerface;

import br.com.rlmoura81.moura.financeiro.Banco;
import br.com.rlmoura81.moura.financeiro.BancoUtil;
import br.com.rlmoura81.moura.financeiro.Conta;
import br.com.rlmoura81.moura.financeiro.ContaRepository;
import br.com.rlmoura81.moura.financeiro.ContaSaldo;
import br.com.rlmoura81.moura.financeiro.ContaSaldoRepository;
import br.com.rlmoura81.moura.financeiro.ContaUtil;
import br.com.rlmoura81.moura.financeiro.TipoConta;
import br.com.rlmoura81.moura.financeiro.TipoContaUtil;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import javax.swing.JOptionPane;

public class JIFConta extends javax.swing.JInternalFrame {
    
    private static JIFConta jifconta;
    
    /**
     * <p><strong>EN:</strong> Returns the singleton instance of {@link JIFConta}.  
     * If no instance exists, a new one is created with the title "Contas".</p>
     *
     * <p><strong>IT:</strong> Restituisce l'istanza singleton di {@link JIFConta}.  
     * Se non esiste alcuna istanza, ne viene creata una nuova con il titolo "Contas".</p>
     *
     * <p><strong>PT-BR:</strong> Retorna a instância única de {@link JIFConta}.  
     * Caso ainda não exista, uma nova é criada com o título "Contas".</p>
     */
    public static JIFConta getInstancia(){
        if(jifconta == null){
            jifconta = new JIFConta();
            jifconta.setTitle("Contas.");
        } return jifconta;
    }  
    
    Conta conta = new Conta();
    ContaRepository contar = new ContaRepository();
    ContaUtil contau = new ContaUtil();
    
    ContaSaldo csaldo = new ContaSaldo();
    ContaSaldoRepository csaldor = new ContaSaldoRepository();
    
    Banco banco = null;
    BancoUtil bancou = new BancoUtil();
    
    TipoConta tipoconta = null;
    TipoContaUtil tipocontau = new TipoContaUtil();
    
    public JIFConta() {
        initComponents();
        
        banco = null;
        jcTpconta();
        jcBanco();
        tabelaConta();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPCampos = new javax.swing.JPanel();
        jLListaBanco = new javax.swing.JLabel();
        jCBBanco = new javax.swing.JComboBox<>();
        jLAgencia = new javax.swing.JLabel();
        jTFAgencia = new javax.swing.JTextField();
        jLNumeroConta = new javax.swing.JLabel();
        jTFNumeroConta = new javax.swing.JTextField();
        jLTipo = new javax.swing.JLabel();
        jCBTipoConta = new javax.swing.JComboBox<>();
        jPBotoes = new javax.swing.JPanel();
        jBSalvar = new javax.swing.JButton();
        jBAlterar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jPGrid = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTConta = new javax.swing.JTable();

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

        jLListaBanco.setText("Lista de Bancos:");

        jCBBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBBancoActionPerformed(evt);
            }
        });

        jLAgencia.setText("Agência:");

        jLNumeroConta.setText("Numero Conta:");

        jLTipo.setText("Tipo:");

        jCBTipoConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBTipoContaActionPerformed(evt);
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
                        .addComponent(jLAgencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLNumeroConta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFNumeroConta, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLTipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBTipoConta, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addComponent(jLListaBanco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPCamposLayout.setVerticalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLListaBanco)
                    .addComponent(jCBBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLTipo)
                        .addComponent(jCBTipoConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLAgencia)
                        .addComponent(jTFAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLNumeroConta)
                        .addComponent(jTFNumeroConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        jTConta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTConta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTContaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTConta);

        javax.swing.GroupLayout jPGridLayout = new javax.swing.GroupLayout(jPGrid);
        jPGrid.setLayout(jPGridLayout);
        jPGridLayout.setHorizontalGroup(
            jPGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPGridLayout.setVerticalGroup(
            jPGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPBotoes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * <p><strong>EN:</strong> Validates the account form fields.  
     * Ensures that bank, agency, account number, and account type are filled/selected.</p>
     *
     * <p><strong>IT:</strong> Convalida i campi del modulo conto.  
     * Verifica che banca, agenzia, numero di conto e tipo di conto siano compilati/selezionati.</p>
     *
     * <p><strong>PT-BR:</strong> Valida os campos do formulário de conta.  
     * Garante que banco, agência, número da conta e tipo de conta estejam preenchidos/selecionados.</p>
     */
    private boolean validaCampo(){
        if(banco == null){
            JOptionPane.showMessageDialog(null, "Selecione o banco.", "Banco", JOptionPane.INFORMATION_MESSAGE);
            jCBBanco.requestFocus();
            return false;
        }
        if(jTFAgencia.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo em branco.", "Conta", JOptionPane.INFORMATION_MESSAGE);
            jTFAgencia.requestFocus();
            return false;
        }
        if(jTFNumeroConta.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo em branco.", "Conta", JOptionPane.INFORMATION_MESSAGE);
            jTFNumeroConta.requestFocus();
            return false;
        }
        if(tipoconta == null){
            JOptionPane.showMessageDialog(null, "Selecione o tipo da conta.", "Tipo de conta", JOptionPane.INFORMATION_MESSAGE);
            jCBTipoConta.requestFocus();
            return false;
        }
        return true;
    }
    
    /**
     * <p><strong>EN:</strong> Clears all account form fields, resetting selections and inputs.</p>
     *
     * <p><strong>IT:</strong> Pulisce tutti i campi del modulo conto, resettando selezioni e input.</p>
     *
     * <p><strong>PT-BR:</strong> Limpa todos os campos do formulário de conta, redefinindo seleções e entradas.</p>
     */
    private void limpaCampos(){
        jCBBanco.setSelectedIndex(0);
        jTFAgencia.setText(null);
        jTFNumeroConta.setText(null);
        jCBTipoConta.setSelectedIndex(0);
    }
    
    /**
     * <p><strong>EN:</strong> Loads and displays the list of accounts in the table.</p>
     *
     * <p><strong>IT:</strong> Carica e visualizza l'elenco dei conti nella tabella.</p>
     *
     * <p><strong>PT-BR:</strong> Carrega e exibe a lista de contas na tabela.</p>
     */
    private void tabelaConta(){
        contau.tabelaConta(jTConta);
    }
    
    /**
     * <p><strong>EN:</strong> Populates the combo box with the list of banks.</p>
     *
     * <p><strong>IT:</strong> Popola la casella combinata con l'elenco delle banche.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche o combo box com a lista de bancos.</p>
     */
    private void jcBanco(){
        bancou.jcBanco(jCBBanco);
    }
    
    /**
     * <p><strong>EN:</strong> Populates the combo box with the list of account types.</p>
     *
     * <p><strong>IT:</strong> Popola la casella combinata con l'elenco dei tipi di conto.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche o combo box com a lista de tipos de conta.</p>
     */    
    private void jcTpconta(){
        tipocontau.jcTpconta(jCBTipoConta);
    }
   
    /**
     * <p><strong>EN:</strong> Saves a new account to the database using the form data.</p>
     *
     * <p><strong>IT:</strong> Salva un nuovo conto nel database utilizzando i dati del modulo.</p>
     *
     * <p><strong>PT-BR:</strong> Salva uma nova conta no banco de dados usando os dados do formulário.</p>
     */
    private void salvar(){
        conta.setBanco(banco);
        conta.setNm_agencia(jTFAgencia.getText());
        conta.setNm_conta(jTFNumeroConta.getText());
        conta.setTpconta(tipoconta);
        conta.setCd_usuario(JPLogin.codloginuser);
        contar.inserir(conta);
    }
    
    /**
     * <p><strong>EN:</strong> Initializes the account balance with zero and saves it to the database.</p>
     *
     * <p><strong>IT:</strong> Inizializza il saldo del conto con zero e lo salva nel database.</p>
     *
     * <p><strong>PT-BR:</strong> Inicializa o saldo da conta com zero e salva no banco de dados.</p>
     */
    private void salvarSaldo(){
        csaldo.setConta(conta);
        csaldo.setVl_saldo(Utilidade.converter("0,00"));
        csaldo.setCd_usuario(conta.getCd_usuario());
        csaldor.inserir(csaldo);
    }
    
    /**
     * <p><strong>EN:</strong> Updates an existing account with the modified form data.</p>
     *
     * <p><strong>IT:</strong> Aggiorna un conto esistente con i dati modificati del modulo.</p>
     *
     * <p><strong>PT-BR:</strong> Atualiza uma conta existente com os dados modificados do formulário.</p>
     */
    private void alterar(){
        conta.setBanco(conta.getBanco());
        conta.setNm_agencia(jTFAgencia.getText());
        conta.setNm_conta(jTFNumeroConta.getText());
        conta.setTpconta(tipoconta);
        conta.setCd_usuario(JPLogin.codloginuser);
        contar.alterar(conta);
    }
    
    /**
     * <p><strong>EN:</strong> Deletes the selected account and its associated balance from the database.</p>
     *
     * <p><strong>IT:</strong> Elimina il conto selezionato e il saldo associato dal database.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui a conta selecionada e seu saldo associado do banco de dados.</p>
     */
    private void excluir(){
        csaldor.excluir(csaldo);
        contar.excluir(conta);
    }
    
    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if(validaCampo()){
            salvar();   
            conta = (Conta)contar.getByIdConta(JPLogin.codloginuser);
            salvarSaldo();            
            limpaCampos();
            tabelaConta();
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifconta = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jTContaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTContaMouseClicked
        conta = (Conta)contau.getSelectedObject(jTConta);
        jCBBanco.setSelectedItem(conta.getBanco());
        jTFAgencia.setText(conta.getNm_agencia());
        jTFNumeroConta.setText(conta.getNm_conta());
        jCBTipoConta.getModel().setSelectedItem(conta.getTpconta());
        csaldo = (ContaSaldo)csaldor.getContaSaldo(conta.getCd_conta());
    }//GEN-LAST:event_jTContaMouseClicked

    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        conta = (Conta)contau.getSelectedObject(jTConta);
        if(conta != null){
            alterar();
            limpaCampos();
            tabelaConta();
        }
    }//GEN-LAST:event_jBAlterarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        conta = (Conta)contau.getSelectedObject(jTConta);
        if(conta != null){
            excluir();
            limpaCampos();
            tabelaConta();
        }
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jCBTipoContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBTipoContaActionPerformed
        if(jCBTipoConta.getSelectedIndex() != 0){
            tipoconta = (TipoConta)jCBTipoConta.getSelectedItem();
        }else{
            tipoconta = null;
        }
    }//GEN-LAST:event_jCBTipoContaActionPerformed

    private void jCBBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBBancoActionPerformed
        if(jCBBanco.getSelectedIndex() != 0){
            banco = (Banco)jCBBanco.getSelectedItem();
        }else{
            banco = null;
        }
    }//GEN-LAST:event_jCBBancoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<Banco> jCBBanco;
    private javax.swing.JComboBox<TipoConta> jCBTipoConta;
    private javax.swing.JLabel jLAgencia;
    private javax.swing.JLabel jLListaBanco;
    private javax.swing.JLabel jLNumeroConta;
    private javax.swing.JLabel jLTipo;
    private javax.swing.JPanel jPBotoes;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JPanel jPGrid;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTConta;
    private javax.swing.JTextField jTFAgencia;
    private javax.swing.JTextField jTFNumeroConta;
    // End of variables declaration//GEN-END:variables
}
