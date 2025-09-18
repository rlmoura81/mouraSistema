package br.com.rlmoura81.moura.financeirointerface;

import br.com.rlmoura81.moura.financeiro.Conta;
import br.com.rlmoura81.moura.financeiro.ContaUtil;
import br.com.rlmoura81.moura.financeiro.Poupanca;
import br.com.rlmoura81.moura.financeiro.PoupancaRepository;
import br.com.rlmoura81.moura.financeiro.PoupancaUtil;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JIFPoupanca extends javax.swing.JInternalFrame {
    
    private static JIFPoupanca jifpoupanca;
    
    /**
     * <p><strong>EN:</strong> Returns the singleton instance of {@link JIFPoupanca}.  
     * If not yet created, instantiates the frame and sets its title to "Poupança".</p>
     *
     * <p><strong>IT:</strong> Restituisce l'istanza singleton di {@link JIFPoupanca}.  
     * Se non ancora creata, istanzia il frame e imposta il titolo su "Poupança".</p>
     *
     * <p><strong>PT-BR:</strong> Retorna a instância singleton de {@link JIFPoupanca}.  
     * Caso ainda não exista, cria o frame e define o título como "Poupança".</p>
     */
    public static JIFPoupanca getInstancia(){
        if(jifpoupanca == null){
            jifpoupanca = new JIFPoupanca();
            jifpoupanca.setTitle("Poupança");
        }return jifpoupanca;
    }
    
    Conta conta = null;
    ContaUtil contau = new ContaUtil();
    
    Poupanca poupanca = new Poupanca();
    PoupancaRepository poupancar = new PoupancaRepository();
    PoupancaUtil poupancau = new PoupancaUtil();
    

    public JIFPoupanca() {
        initComponents();
        
        jcConta();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPCampos = new javax.swing.JPanel();
        jCBConta = new javax.swing.JComboBox<>();
        jLVariacao = new javax.swing.JLabel();
        jTFVariacao = new javax.swing.JTextField();
        jPBotoes = new javax.swing.JPanel();
        jBSalvar = new javax.swing.JButton();
        jBAlterar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jPGrid = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTPoupanca = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(480, 330));
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

        jCBConta.setPreferredSize(new java.awt.Dimension(15, 22));
        jCBConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBContaActionPerformed(evt);
            }
        });

        jLVariacao.setText("Variação:");

        javax.swing.GroupLayout jPCamposLayout = new javax.swing.GroupLayout(jPCampos);
        jPCampos.setLayout(jPCamposLayout);
        jPCamposLayout.setHorizontalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCBConta, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addComponent(jLVariacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFVariacao, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPCamposLayout.setVerticalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCBConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFVariacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLVariacao))
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

        jTPoupanca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTPoupanca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTPoupancaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTPoupanca);

        javax.swing.GroupLayout jPGridLayout = new javax.swing.GroupLayout(jPGrid);
        jPGrid.setLayout(jPGridLayout);
        jPGridLayout.setHorizontalGroup(
            jPGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPGridLayout.setVerticalGroup(
            jPGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
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
                .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * <p><strong>EN:</strong> Populates the account combo box with available accounts.</p>
     * <p><strong>IT:</strong> Popola la combo box dei conti con i conti disponibili.</p>
     * <p><strong>PT-BR:</strong> Preenche o combo box de contas com as contas disponíveis.</p>
     */
    private void jcConta(){
        contau.jcConta(jCBConta);
    }
    
    /**
     * <p><strong>EN:</strong> Loads and displays savings accounts for the given account ID in the table.</p>
     * <p><strong>IT:</strong> Carica e visualizza i conti di risparmio per l'ID del conto fornito nella tabella.</p>
     * <p><strong>PT-BR:</strong> Carrega e exibe as poupanças do ID da conta informado na tabela.</p>
     */
    private void tabelaPoupanca(int num){
        poupancau.tabelaPoupanca(jTPoupanca, num);
    }
    
    /**
     * <p><strong>EN:</strong> Validates the required fields for savings account registration.</p>
     * <p><strong>IT:</strong> Convalida i campi obbligatori per la registrazione del conto di risparmio.</p>
     * <p><strong>PT-BR:</strong> Valida os campos obrigatórios para cadastro de poupança.</p>
     */
    private boolean validaCampos(){
        if(conta == null){
            JOptionPane.showMessageDialog(null, "Selecione a conta.", "Poupança", JOptionPane.INFORMATION_MESSAGE);
            jCBConta.requestFocus();
            return false;
        }
        if(jTFVariacao.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Digita a variação.", "Poupança", JOptionPane.INFORMATION_MESSAGE);
            jTFVariacao.requestFocus();
            return false;
        }
        return true;
    }
    
    /**
     * <p><strong>EN:</strong> Clears all input fields in the savings account form.</p>
     * <p><strong>IT:</strong> Pulisce tutti i campi di input nel modulo del conto di risparmio.</p>
     * <p><strong>PT-BR:</strong> Limpa todos os campos de entrada no formulário de poupança.</p>
     */
    private void limpaCampos(){
        jTFVariacao.setText(null);
    }
    
    /**
     * <p><strong>EN:</strong> Saves a new savings account with the entered data and initializes the balance with 0.00.</p>
     * <p><strong>IT:</strong> Salva un nuovo conto di risparmio con i dati inseriti e inizializza il saldo a 0,00.</p>
     * <p><strong>PT-BR:</strong> Salva uma nova poupança com os dados informados e inicializa o saldo em 0,00.</p>
     */
    private void salvar(){
        poupanca.setConta(conta);
        poupanca.setNm_variaca(jTFVariacao.getText());
        poupanca.setVl_saldo(Utilidade.converter("0,00"));
        poupanca.setCd_usuario(JPLogin.codloginuser);
        poupancar.inserir(poupanca);
    }
    
    /**
     * <p><strong>EN:</strong> Updates an existing savings account with the modified data.</p>
     * <p><strong>IT:</strong> Aggiorna un conto di risparmio esistente con i dati modificati.</p>
     * <p><strong>PT-BR:</strong> Altera uma poupança existente com os dados modificados.</p>
     */
    private void alterar(){
        poupanca.setConta(conta);
        poupanca.setNm_variaca(jTFVariacao.getText());
        poupancar.alterar(poupanca);
    }
    
    /**
     * <p><strong>EN:</strong> Deletes the selected savings account from the database.</p>
     * <p><strong>IT:</strong> Elimina il conto di risparmio selezionato dal database.</p>
     * <p><strong>PT-BR:</strong> Exclui a poupança selecionada do banco de dados.</p>
     */
    private void excluir(){
        poupanca.setCd_poupanca(poupanca.getCd_poupanca());
        poupancar.excluir(poupanca);
    }
    
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifpoupanca = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if(validaCampos()){
            salvar();
            limpaCampos();
            tabelaPoupanca(conta.getCd_conta());
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jTPoupancaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTPoupancaMouseClicked
        poupanca = (Poupanca)poupancau.getSelectObject(jTPoupanca);
        jTFVariacao.setText(poupanca.getNm_variaca());
    }//GEN-LAST:event_jTPoupancaMouseClicked

    private void jCBContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBContaActionPerformed
        if(jCBConta.getSelectedIndex() != 0){
            conta = (Conta)jCBConta.getSelectedItem();
            limpaCampos();
            tabelaPoupanca(conta.getCd_conta());
        }else{
            conta = null;
            ((DefaultTableModel)jTPoupanca.getModel()).setRowCount(0);
        }
    }//GEN-LAST:event_jCBContaActionPerformed

    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        poupanca = (Poupanca)poupancau.getSelectObject(jTPoupanca);
        if(poupanca != null){
            alterar();
            limpaCampos();
            tabelaPoupanca(conta.getCd_conta());
        }
    }//GEN-LAST:event_jBAlterarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        poupanca = (Poupanca)poupancau.getSelectObject(jTPoupanca);
        if(poupanca != null){
            excluir();
            limpaCampos();
            tabelaPoupanca(conta.getCd_conta());
        }
    }//GEN-LAST:event_jBExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<Conta> jCBConta;
    private javax.swing.JLabel jLVariacao;
    private javax.swing.JPanel jPBotoes;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JPanel jPGrid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFVariacao;
    private javax.swing.JTable jTPoupanca;
    // End of variables declaration//GEN-END:variables
}
