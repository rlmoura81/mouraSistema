package br.com.rlmoura81.moura.financeirointerface;

import br.com.rlmoura81.moura.financeiro.Banco;
import br.com.rlmoura81.moura.financeiro.BancoRepository;
import br.com.rlmoura81.moura.financeiro.BancoUtil;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import javax.swing.JOptionPane;

public class JIFBanco extends javax.swing.JInternalFrame {

    private static JIFBanco jifbanco;
    
    /**
     * <p><strong>EN:</strong> Returns the instance of {@link JIFBanco}.  
     * If it does not exist, a new instance is created and initialized with the title "Bancos".</p>
     *
     * <p><strong>IT:</strong> Restituisce l'istanza di {@link JIFBanco}.  
     * Se non esiste, viene creata una nuova istanza e inizializzata con il titolo "Bancos".</p>
     *
     * <p><strong>PT-BR:</strong> Retorna a instância de {@link JIFBanco}.  
     * Caso não exista, uma nova instância é criada e inicializada com o título "Bancos".</p>
     */
    public static JIFBanco getInstancia(){
        if(jifbanco == null){
            jifbanco = new JIFBanco();
            jifbanco.setTitle("Bancos");
        } return jifbanco;
    }
    
    Banco banco = new Banco();
    BancoRepository bancor = new BancoRepository();
    BancoUtil bancou = new BancoUtil();
        
    public JIFBanco() {
        initComponents();
        
        tabelaBanco();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPCampos = new javax.swing.JPanel();
        jTFNumero = new javax.swing.JTextField();
        jLNome = new javax.swing.JLabel();
        jTFNome = new javax.swing.JTextField();
        jBSalvar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jBAlterar = new javax.swing.JButton();
        jLNumero = new javax.swing.JLabel();
        jPGrid = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTBanco = new javax.swing.JTable();

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

        jLNome.setText("Nome:");

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

        jLNumero.setText("Numero:");

        javax.swing.GroupLayout jPCamposLayout = new javax.swing.GroupLayout(jPCampos);
        jPCampos.setLayout(jPCamposLayout);
        jPCamposLayout.setHorizontalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addComponent(jBSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBExcluir))
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLNumero)
                            .addComponent(jLNome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPCamposLayout.setVerticalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNome)
                    .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNumero)
                    .addComponent(jTFNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalvar)
                    .addComponent(jBExcluir)
                    .addComponent(jBAlterar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPGrid.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTBanco.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTBanco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTBancoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTBanco);

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
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * <p><strong>EN:</strong> Loads the list of banks into the table component.  
     * Calls the service method to populate {@code jTBanco} with registered banks.</p>
     *
     * <p><strong>IT:</strong> Carica l'elenco delle banche nella tabella.  
     * Richiama il metodo di servizio per popolare {@code jTBanco} con le banche registrate.</p>
     *
     * <p><strong>PT-BR:</strong> Carrega a lista de bancos na tabela.  
     * Chama o método de serviço para preencher {@code jTBanco} com os bancos cadastrados.</p>
     */
    private void tabelaBanco(){
        bancou.tabelaBanco(jTBanco);
    }
    
    /**
     * <p><strong>EN:</strong> Validates the mandatory fields for the bank form.  
     * Ensures that name and number fields are not empty before saving or updating.</p>
     *
     * <p><strong>IT:</strong> Convalida i campi obbligatori del modulo della banca.  
     * Garantisce che i campi nome e numero non siano vuoti prima di salvare o aggiornare.</p>
     *
     * <p><strong>PT-BR:</strong> Valida os campos obrigatórios do formulário de banco.  
     * Garante que os campos nome e número não estejam em branco antes de salvar ou alterar.</p>
     */
    private boolean validaCampos(){
        if(jTFNome.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo em branco.", "Banco", JOptionPane.INFORMATION_MESSAGE);
            jTFNome.requestFocus();
            return false;
        }
        if(jTFNumero.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo em branco.", "Banco", JOptionPane.INFORMATION_MESSAGE);
            jTFNumero.requestFocus();
            return false;
        }
        return true;
    }
    
    /**
     * <p><strong>EN:</strong> Clears all input fields from the bank form.  
     * Resets the name and number fields to empty values.</p>
     *
     * <p><strong>IT:</strong> Pulisce tutti i campi di input del modulo banca.  
     * Reimposta i campi nome e numero ai valori vuoti.</p>
     *
     * <p><strong>PT-BR:</strong> Limpa todos os campos de entrada do formulário de banco.  
     * Reinicia os campos nome e número para valores vazios.</p>
     */
    private void limpaCampos(){
        jTFNome.setText(null);
        jTFNumero.setText(null);
    }
        
    /**
     * <p><strong>EN:</strong> Saves a new bank record.  
     * Captures the form data, sets the attributes in the {@code Banco} object,  
     * and sends it to the repository for persistence.</p>
     *
     * <p><strong>IT:</strong> Salva un nuovo record di banca.  
     * Acquisisce i dati del modulo, imposta gli attributi nell'oggetto {@code Banco}  
     * e li invia al repository per la persistenza.</p>
     *
     * <p><strong>PT-BR:</strong> Salva um novo registro de banco.  
     * Captura os dados do formulário, define os atributos no objeto {@code Banco}  
     * e envia para o repositório para persistência.</p>
     */
    private void salvar(){
        banco.setDs_banco(jTFNome.getText().toUpperCase());
        banco.setNm_banco(Integer.parseInt(jTFNumero.getText()));
        banco.setCd_usuario(JPLogin.codloginuser);
        bancor.inserir(banco);
    }
    
    /**
     * <p><strong>EN:</strong> Updates the data of an existing bank.  
     * Retrieves the values from the form and updates the bank object,  
     * then calls the repository to persist the changes.</p>
     *
     * <p><strong>IT:</strong> Aggiorna i dati di una banca esistente.  
     * Recupera i valori dal modulo e aggiorna l'oggetto banca,  
     * quindi richiama il repository per salvare le modifiche.</p>
     *
     * <p><strong>PT-BR:</strong> Atualiza os dados de um banco existente.  
     * Recupera os valores do formulário e atualiza o objeto banco,  
     * em seguida chama o repositório para salvar as alterações.</p>
     */
    private void alterar(){
        banco.setDs_banco(jTFNome.getText().toUpperCase());
        banco.setNm_banco(Integer.parseInt(jTFNumero.getText()));
        banco.setCd_usuario(JPLogin.codloginuser);
        bancor.alterar(banco);
    }
    
    /**
     * <p><strong>EN:</strong> Deletes the currently selected bank.  
     * Uses the bank ID to remove the record from the repository and clears the form fields.</p>
     *
     * <p><strong>IT:</strong> Elimina la banca attualmente selezionata.  
     * Utilizza l'ID della banca per rimuovere il record dal repository e pulisce i campi del modulo.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui o banco atualmente selecionado.  
     * Utiliza o ID do banco para remover o registro do repositório e limpa os campos do formulário.</p>
     */
    private void excluir(){
        banco.setCd_banco(banco.getCd_banco());
        bancor.excluir(banco);
        limpaCampos();
    }
    
    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if(validaCampos()){
            salvar();
            limpaCampos();
            tabelaBanco();            
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifbanco = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jTBancoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTBancoMouseClicked
        banco = (Banco)bancou.getSelectedObject(jTBanco);
        jTFNome.setText(banco.getDs_banco());
        jTFNumero.setText(Integer.toString(banco.getNm_banco()));
    }//GEN-LAST:event_jTBancoMouseClicked

    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        banco = (Banco)bancou.getSelectedObject(jTBanco);
        if(banco != null){
            alterar();
            limpaCampos();
            tabelaBanco();  
        }      
    }//GEN-LAST:event_jBAlterarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        banco = (Banco)bancou.getSelectedObject(jTBanco);
        if(banco != null){
            excluir();
            limpaCampos();
            tabelaBanco();
        }
    }//GEN-LAST:event_jBExcluirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JLabel jLNome;
    private javax.swing.JLabel jLNumero;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JPanel jPGrid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTBanco;
    private javax.swing.JTextField jTFNome;
    private javax.swing.JTextField jTFNumero;
    // End of variables declaration//GEN-END:variables
}
