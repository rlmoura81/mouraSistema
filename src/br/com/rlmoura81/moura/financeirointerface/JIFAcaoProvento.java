package br.com.rlmoura81.moura.financeirointerface;

import br.com.rlmoura81.moura.financeiro.AcaoProvento;
import br.com.rlmoura81.moura.financeiro.AcaoProventoRepository;
import br.com.rlmoura81.moura.financeiro.Ativo;
import br.com.rlmoura81.moura.financeiro.AtivoUtil;
import br.com.rlmoura81.moura.financeiro.TipoProvento;
import br.com.rlmoura81.moura.financeiro.TipoProventoUtil;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import javax.swing.JOptionPane;

public class JIFAcaoProvento extends javax.swing.JInternalFrame {
    
    private static JIFAcaoProvento jifacaoprov;
    
    /**
     * <p><strong>EN:</strong> Returns the singleton instance of the JIFAcaoProvento window.
     * If it does not exist yet, it creates a new one and sets its title to "Ação Renda".</p>
     *
     * <p><strong>IT:</strong> Restituisce l'istanza singleton della finestra JIFAcaoProvento.
     * Se non esiste ancora, ne crea una nuova e imposta il titolo su "Ação Renda".</p>
     *
     * <p><strong>PT-BR:</strong> Retorna a instância singleton da janela JIFAcaoProvento.
     * Caso ainda não exista, cria uma nova e define o título como "Ação Renda".</p>
     *
     * @return EN: Instance of JIFAcaoProvento |
     *         IT: Istanza di JIFAcaoProvento |
     *         PT-BR: Instância de JIFAcaoProvento
     */
    public static JIFAcaoProvento getInstancia(){
        if(jifacaoprov == null){
            jifacaoprov = new JIFAcaoProvento();
            jifacaoprov.setTitle("Ação Renda.");
        }return jifacaoprov;
    }
    
    Ativo ativo = null;
    AtivoUtil ativou = new AtivoUtil();
    
    AcaoProvento acaoprov = new AcaoProvento();
    AcaoProventoRepository acaoprovr = new AcaoProventoRepository();
    
    TipoProvento tpprovento = null;
    TipoProventoUtil tpproventou = new TipoProventoUtil();
    
    Utilidade util = new Utilidade();

    public JIFAcaoProvento() {
        initComponents();
        
        jcAcao();
        jcTpProvento();        
        formataValor();
        formatarData();        
        tabelaAcaoProv();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPAtivo = new javax.swing.JPanel();
        jCBAtivo = new javax.swing.JComboBox<>();
        jPCampos = new javax.swing.JPanel();
        jLDtPagamento = new javax.swing.JLabel();
        jFTFDtPagamento = new javax.swing.JFormattedTextField();
        jLVlRecebido = new javax.swing.JLabel();
        jFTFRendimentoPago = new javax.swing.JFormattedTextField();
        jLDtPrecoBase = new javax.swing.JLabel();
        jFTFDtPrecoBase = new javax.swing.JFormattedTextField();
        jLVlPrecoBase = new javax.swing.JLabel();
        jFTFPrecoDtBase = new javax.swing.JFormattedTextField();
        jCBTpProvento = new javax.swing.JComboBox<>();
        jPBotoes = new javax.swing.JPanel();
        jBSalvar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jPGrid = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAcaoProv = new javax.swing.JTable();

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

        jPAtivo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jCBAtivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBAtivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPAtivoLayout = new javax.swing.GroupLayout(jPAtivo);
        jPAtivo.setLayout(jPAtivoLayout);
        jPAtivoLayout.setHorizontalGroup(
            jPAtivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPAtivoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCBAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPAtivoLayout.setVerticalGroup(
            jPAtivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPAtivoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCBAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPCampos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLDtPagamento.setText("Data Pagamento:");

        jLVlRecebido.setText("Rendimento Pago:");

        jLDtPrecoBase.setText("Data Preço Base:");

        jLVlPrecoBase.setText("Preço Data Base:");

        jCBTpProvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBTpProventoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPCamposLayout = new javax.swing.GroupLayout(jPCampos);
        jPCampos.setLayout(jPCamposLayout);
        jPCamposLayout.setHorizontalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCBTpProvento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLVlRecebido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLVlPrecoBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPCamposLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jFTFPrecoDtBase, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPCamposLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jFTFRendimentoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLDtPrecoBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLDtPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFTFDtPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFTFDtPrecoBase, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPCamposLayout.setVerticalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCBTpProvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLDtPagamento)
                    .addComponent(jFTFDtPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLVlRecebido)
                    .addComponent(jFTFRendimentoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLVlPrecoBase)
                    .addComponent(jFTFPrecoDtBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLDtPrecoBase)
                    .addComponent(jFTFDtPrecoBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        javax.swing.GroupLayout jPBotoesLayout = new javax.swing.GroupLayout(jPBotoes);
        jPBotoes.setLayout(jPBotoesLayout);
        jPBotoesLayout.setHorizontalGroup(
            jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBSalvar)
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
                    .addComponent(jBExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPGrid.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTAcaoProv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTAcaoProv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTAcaoProvMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTAcaoProv);

        javax.swing.GroupLayout jPGridLayout = new javax.swing.GroupLayout(jPGrid);
        jPGrid.setLayout(jPGridLayout);
        jPGridLayout.setHorizontalGroup(
            jPGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPGridLayout.setVerticalGroup(
            jPGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPAtivo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPCampos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPBotoes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    /**
     * <p><strong>EN:</strong> Initializes the combo box with the available stocks.  
     * Delegates the population of the {@link JComboBox} to the helper class.</p>
     *
     * <p><strong>IT:</strong> Inizializza la combo box con le azioni disponibili.  
     * Delega il popolamento della {@link JComboBox} alla classe di supporto.</p>
     *
     * <p><strong>PT-BR:</strong> Inicializa o combo box com as ações disponíveis.  
     * A responsabilidade de preencher o {@link JComboBox} é delegada à classe auxiliar.</p>
     */
    private void jcAcao(){
        ativou.jcAcao(jCBAtivo);
    }
    
    /**
     * <p><strong>EN:</strong> Initializes the combo box with the available income types (Proventos).  
     * Uses a helper to populate the {@link JComboBox} with options.</p>
     *
     * <p><strong>IT:</strong> Inizializza la combo box con i tipi di provento disponibili.  
     * Utilizza un helper per popolare la {@link JComboBox} con le opzioni.</p>
     *
     * <p><strong>PT-BR:</strong> Inicializa o combo box com os tipos de provento disponíveis.  
     * Usa um helper para preencher o {@link JComboBox} com as opções.</p>
     */
    private void jcTpProvento(){
        tpproventou.jcTpProvento(jCBTpProvento);
    }
    
    /**
     * <p><strong>EN:</strong> Applies numeric formatters to the value fields.  
     * Ensures correct formatting for monetary inputs.</p>
     *
     * <p><strong>IT:</strong> Applica i formattatori numerici ai campi valore.  
     * Garantisce la corretta formattazione degli input monetari.</p>
     *
     * <p><strong>PT-BR:</strong> Aplica formatadores numéricos aos campos de valor.  
     * Garante a formatação correta para entradas monetárias.</p>
     */
    private void formataValor() {        
        jFTFRendimentoPago.setFormatterFactory(Utilidade.formataValorCampo(ui));
        jFTFPrecoDtBase.setFormatterFactory(Utilidade.formataValorCampo(ui));
    } 
    
    /**
     * <p><strong>EN:</strong> Applies date formatting rules to the date fields.  
     * Ensures that date inputs follow the correct format.</p>
     *
     * <p><strong>IT:</strong> Applica le regole di formattazione della data ai campi data.  
     * Garantisce che gli input di data seguano il formato corretto.</p>
     *
     * <p><strong>PT-BR:</strong> Aplica as regras de formatação de data nos campos de data.  
     * Garante que as entradas de data sigam o formato correto.</p>
     */
    private void formatarData(){
        util.formataDataCampo(jFTFDtPagamento);
        util.formataDataCampo(jFTFDtPrecoBase);
    } 
   
    /**
     * <p><strong>EN:</strong> Validates all form fields before saving.  
     * Displays messages if any required field is invalid.</p>
     *
     * <p><strong>IT:</strong> Valida tutti i campi del modulo prima di salvare.  
     * Mostra messaggi se un campo richiesto non è valido.</p>
     *
     * <p><strong>PT-BR:</strong> Valida todos os campos do formulário antes de salvar.  
     * Exibe mensagens se algum campo obrigatório estiver inválido.</p>
     *
     * @return {@code true} if all fields are valid, otherwise {@code false}.
     */
    private boolean validaCampos(){        
        if(ativo == null){
            JOptionPane.showMessageDialog(null, "Selecione a Ação.", "Ação", JOptionPane.INFORMATION_MESSAGE);
            jCBAtivo.requestFocus();
            return false;
        }
        
        if(tpprovento == null){
            JOptionPane.showMessageDialog(null, "Selecione o tipo de provento.", "Tipo Provento", JOptionPane.INFORMATION_MESSAGE);
            jCBTpProvento.requestFocus();
            return false;
        }
        
        if(jFTFRendimentoPago.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Informe o valor de rendimento.", "Ação", JOptionPane.INFORMATION_MESSAGE);
            jFTFRendimentoPago.requestFocus();
            return false;
        }
        if(jFTFPrecoDtBase.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Informe o valor de preço da data base.", "Ação", JOptionPane.INFORMATION_MESSAGE);
            jFTFPrecoDtBase.requestFocus();
            return false;
        }
        if(util.validaDataCampo(jFTFDtPagamento.getText()) == false){
            jFTFDtPagamento.requestFocus();
            return false;
        }
        if(util.validaDataCampo(jFTFDtPrecoBase.getText()) == false){
            jFTFDtPrecoBase.requestFocus();
            return false;
        }
        return true;
    }
    
    /**
     * <p><strong>EN:</strong> Clears all input fields in the form.  
     * Resets combo boxes and formatted text fields.</p>
     *
     * <p><strong>IT:</strong> Pulisce tutti i campi del modulo.  
     * Reimposta le combo box e i campi formattati.</p>
     *
     * <p><strong>PT-BR:</strong> Limpa todos os campos do formulário.  
     * Redefine os combos e os campos formatados.</p>
     */
    private void limpaCampos(){
        jCBAtivo.setSelectedIndex(0);
        jCBTpProvento.setSelectedIndex(0);
        jFTFRendimentoPago.setValue(null);
        jFTFDtPagamento.setText(null);
        jFTFPrecoDtBase.setValue(null);
        jFTFDtPrecoBase.setText(null);
    }
    
    /**
     * <p><strong>EN:</strong> Loads and displays the stock income data in the table.  
     * Delegates the table filling to the helper class.</p>
     *
     * <p><strong>IT:</strong> Carica e visualizza i proventi azionari nella tabella.  
     * Delega il riempimento della tabella alla classe di supporto.</p>
     *
     * <p><strong>PT-BR:</strong> Carrega e exibe os proventos da ação na tabela.  
     * A responsabilidade de preencher a tabela é delegada à classe auxiliar.</p>
     */
    private void tabelaAcaoProv(){
        ativou.tabelaAcaoProv(jTAcaoProv);
    }
    
    /**
     * <p><strong>EN:</strong> Saves the stock income record into the database.  
     * Collects form values, converts them, and persists the object.</p>
     *
     * <p><strong>IT:</strong> Salva il record del provento azionario nel database.  
     * Raccoglie i valori del modulo, li converte e persiste l'oggetto.</p>
     *
     * <p><strong>PT-BR:</strong> Salva o registro de provento da ação no banco de dados.  
     * Coleta os valores do formulário, converte-os e persiste o objeto.</p>
     */
    private void salvar(){
        acaoprov.setAtivo(ativo);
        acaoprov.setVl_provento(Utilidade.converter(jFTFRendimentoPago.getText()));
        acaoprov.setDt_pagamento(util.recebeData(jFTFDtPagamento.getText()));
        acaoprov.setVl_database(Utilidade.converter(jFTFPrecoDtBase.getText()));
        acaoprov.setDt_precobase(util.recebeData(jFTFDtPrecoBase.getText()));
        acaoprov.setTpprovento(tpprovento);
        acaoprov.setCd_usuario(JPLogin.codloginuser);
        acaoprovr.inserir(acaoprov);
    }
    
    /**
     * <p><strong>EN:</strong> Deletes the selected stock income record from the database.  
     * Uses the current record ID to perform the removal.</p>
     *
     * <p><strong>IT:</strong> Elimina il record selezionato dei proventi azionari dal database.  
     * Utilizza l'ID del record corrente per eseguire la rimozione.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui o registro de provento da ação selecionado do banco de dados.  
     * Usa o ID do registro atual para executar a exclusão.</p>
     */
    private void excluir(){
        acaoprov.setCd_acaoprov(acaoprov.getCd_acaoprov());
        acaoprovr.excluir(acaoprov);
    } 
        
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifacaoprov = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jCBAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBAtivoActionPerformed
        if(jCBAtivo.getSelectedIndex() != 0){
            ativo = (Ativo)jCBAtivo.getSelectedItem();
        }else{
            ativo = null;
        }
    }//GEN-LAST:event_jCBAtivoActionPerformed

    private void jCBTpProventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBTpProventoActionPerformed
        if(jCBTpProvento.getSelectedIndex() != 0){
            tpprovento = (TipoProvento)jCBTpProvento.getSelectedItem();
        }else{
            tpprovento = null;
        }
    }//GEN-LAST:event_jCBTpProventoActionPerformed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if(validaCampos()){
            salvar();
            limpaCampos();
            tabelaAcaoProv();            
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        acaoprov = (AcaoProvento)ativou.getSelectObject(jTAcaoProv);
        if(acaoprov != null){
            excluir();
            limpaCampos();
            tabelaAcaoProv();            
        }        
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jTAcaoProvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTAcaoProvMouseClicked
        acaoprov = (AcaoProvento)ativou.getSelectObject(jTAcaoProv);
        jCBAtivo.getModel().setSelectedItem(acaoprov.getAtivo());
        jCBTpProvento.getModel().setSelectedItem(acaoprov.getTpprovento());
        jFTFDtPagamento.setText(Utilidade.formatoData.format(acaoprov.getDt_pagamento().getTime()));
        jFTFRendimentoPago.setText(Utilidade.formatoValor.format(acaoprov.getVl_provento()));
        jFTFDtPrecoBase.setText(Utilidade.formatoData.format(acaoprov.getDt_precobase().getTime()));
        jFTFPrecoDtBase.setText(Utilidade.formatoValor.format(acaoprov.getVl_database()));        
    }//GEN-LAST:event_jTAcaoProvMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<Ativo> jCBAtivo;
    private javax.swing.JComboBox<TipoProvento> jCBTpProvento;
    private javax.swing.JFormattedTextField jFTFDtPagamento;
    private javax.swing.JFormattedTextField jFTFDtPrecoBase;
    private javax.swing.JFormattedTextField jFTFPrecoDtBase;
    private javax.swing.JFormattedTextField jFTFRendimentoPago;
    private javax.swing.JLabel jLDtPagamento;
    private javax.swing.JLabel jLDtPrecoBase;
    private javax.swing.JLabel jLVlPrecoBase;
    private javax.swing.JLabel jLVlRecebido;
    private javax.swing.JPanel jPAtivo;
    private javax.swing.JPanel jPBotoes;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JPanel jPGrid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTAcaoProv;
    // End of variables declaration//GEN-END:variables
}
