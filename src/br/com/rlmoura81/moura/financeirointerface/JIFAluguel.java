package br.com.rlmoura81.moura.financeirointerface;

import br.com.rlmoura81.moura.financeiro.Aluguel;
import br.com.rlmoura81.moura.financeiro.AluguelRepository;
import br.com.rlmoura81.moura.financeiro.AluguelUtil;
import br.com.rlmoura81.moura.imovel.Imovel;
import br.com.rlmoura81.moura.imovel.ImovelUtil;
import br.com.rlmoura81.moura.principalcadastro.Empresa;
import br.com.rlmoura81.moura.principalcadastro.EmpresaUtil;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import javax.swing.JOptionPane;

public class JIFAluguel extends javax.swing.JInternalFrame {
    
    private static JIFAluguel jifaluguel;
    
    /**
     * <p><strong>EN:</strong> Returns a singleton instance of {@link JIFAluguel}.  
     * If the instance does not exist, it is created, titled "Aluguel", and then returned.</p>
     *
     * <p><strong>IT:</strong> Restituisce un'istanza singleton di {@link JIFAluguel}.  
     * Se l'istanza non esiste, viene creata, titolata "Aluguel" e poi restituita.</p>
     *
     * <p><strong>PT-BR:</strong> Retorna uma instância singleton de {@link JIFAluguel}.  
     * Caso não exista, a instância é criada, recebe o título "Aluguel" e em seguida retornada.</p>
     *
     * @return the single instance of {@link JIFAluguel}
     */
    public static JIFAluguel getInstancia(){
        if(jifaluguel == null){
            jifaluguel = new JIFAluguel();
            jifaluguel.setTitle("Aluguel");
        }return jifaluguel;
    }

    Imovel imovel = null;
    ImovelUtil imovelu = new ImovelUtil();
    
    Empresa empresa = null;
    EmpresaUtil empresau = new EmpresaUtil();
    
    Aluguel aluguel = new Aluguel();
    AluguelRepository aluguelr = new AluguelRepository();
    AluguelUtil aluguelu = new AluguelUtil();
    
    Utilidade util = new Utilidade();
    
    public JIFAluguel() {
        initComponents();
        
        jcImovel();
        jcImobiliaria();
        tabelaAluguel();
        formataValor();
        formatarData();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPCampos = new javax.swing.JPanel();
        jCBImovel = new javax.swing.JComboBox<>();
        jCBImobiliaria = new javax.swing.JComboBox();
        jLContrato = new javax.swing.JLabel();
        jLValorAluguel = new javax.swing.JLabel();
        jLTaxaAdm = new javax.swing.JLabel();
        jLDataDeposito = new javax.swing.JLabel();
        jLVencContrato = new javax.swing.JLabel();
        jTFContrato = new javax.swing.JTextField();
        jFTFValorAlguel = new javax.swing.JFormattedTextField();
        jFTFTaxaAdm = new javax.swing.JFormattedTextField();
        jTFDataAluguel = new javax.swing.JTextField();
        jFTFVencContrato = new javax.swing.JFormattedTextField();
        jLVlLiquido = new javax.swing.JLabel();
        jPBotoes = new javax.swing.JPanel();
        jBSalvar = new javax.swing.JButton();
        jBAlterar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jPGrid = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAluguel = new javax.swing.JTable();

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

        jCBImovel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBImovelActionPerformed(evt);
            }
        });

        jCBImobiliaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBImobiliariaActionPerformed(evt);
            }
        });

        jLContrato.setText("Contrato:");

        jLValorAluguel.setText("Valor:");

        jLTaxaAdm.setText("Taxa Adm:");

        jLDataDeposito.setText("Data de Deposito:");

        jLVencContrato.setText("Vencimento Contrato:");

        jTFContrato.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFContratoFocusLost(evt);
            }
        });

        jFTFTaxaAdm.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFTFTaxaAdmFocusLost(evt);
            }
        });

        jTFDataAluguel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFDataAluguelFocusLost(evt);
            }
        });

        jLVlLiquido.setText("Valor Líquido:");

        javax.swing.GroupLayout jPCamposLayout = new javax.swing.GroupLayout(jPCampos);
        jPCampos.setLayout(jPCamposLayout);
        jPCamposLayout.setHorizontalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPCamposLayout.createSequentialGroup()
                                .addComponent(jLContrato)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jFTFVencContrato, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLVencContrato, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(13, 13, 13)
                        .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLVlLiquido)
                            .addGroup(jPCamposLayout.createSequentialGroup()
                                .addComponent(jLValorAluguel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFTFValorAlguel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLDataDeposito)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFDataAluguel, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLTaxaAdm)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFTFTaxaAdm, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                                .addGap(299, 299, 299))))
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addComponent(jCBImovel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBImobiliaria, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(299, 299, 299))))
        );
        jPCamposLayout.setVerticalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBImovel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBImobiliaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLContrato)
                    .addComponent(jTFContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLValorAluguel)
                    .addComponent(jFTFValorAlguel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLTaxaAdm)
                    .addComponent(jFTFTaxaAdm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLDataDeposito)
                    .addComponent(jTFDataAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLVencContrato)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFTFVencContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLVlLiquido))
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

        jTAluguel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTAluguel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTAluguelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTAluguel);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPGrid, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPCampos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    /**
     * <p><strong>EN:</strong> Populates the property combo box with available properties.</p>
     * <p><strong>IT:</strong> Popola la combo box degli immobili con le proprietà disponibili.</p>
     * <p><strong>PT-BR:</strong> Preenche o combo box de imóveis com os disponíveis.</p>
     */
    private void jcImovel(){
        imovelu.jcImovel(jCBImovel);
    }
    
    /**
     * <p><strong>EN:</strong> Populates the real estate agency combo box using the service layer.</p>
     * <p><strong>IT:</strong> Popola la combo box delle agenzie immobiliari utilizzando il livello di servizio.</p>
     * <p><strong>PT-BR:</strong> Preenche o combo box de imobiliárias utilizando a camada de serviço.</p>
     */
    private void jcImobiliaria(){
        empresau.jcEmpresa(jCBImobiliaria, 4);
        
    }
    
    /**
    * <p><strong>EN:</strong> Applies numeric formatters to rental and administrative fee fields.</p>
    * <p><strong>IT:</strong> Applica i formattatori numerici ai campi di affitto e tassa amministrativa.</p>
    * <p><strong>PT-BR:</strong> Aplica formatadores numéricos nos campos de aluguel e taxa administrativa.</p>
    */
    private void formataValor() {
        jFTFValorAlguel.setFormatterFactory(Utilidade.formataValorCampo(ui));
        jFTFTaxaAdm.setFormatterFactory(Utilidade.formataValorCampo(ui));
    }  
    
    /**
     * <p><strong>EN:</strong> Formats the contract expiration date field.</p>
     * <p><strong>IT:</strong> Format il campo della data di scadenza del contratto.</p>
     * <p><strong>PT-BR:</strong> Formata o campo da data de vencimento do contrato.</p>
     */
    private void formatarData(){
        util.formataDataCampo(jFTFVencContrato);    
    }
    
    /**
     * <p><strong>EN:</strong> Loads and displays the rental records in the rental table.</p>
     * <p><strong>IT:</strong> Carica e visualizza i record degli affitti nella tabella degli affitti.</p>
     * <p><strong>PT-BR:</strong> Carrega e exibe os registros de aluguel na tabela de aluguéis.</p>
     */
    private void tabelaAluguel(){
        aluguelu.tabelaAluguel(jTAluguel);
    }
    
    /**
     * <p><strong>EN:</strong> Saves a new rental record with the current form data.</p>
     * <p><strong>IT:</strong> Salva un nuovo record di affitto con i dati correnti del modulo.</p>
     * <p><strong>PT-BR:</strong> Salva um novo registro de aluguel com os dados atuais do formulário.</p>
     */
    private void salvar(){
        aluguel.setImovel(imovel);
        aluguel.setEmpresa(empresa);
        aluguel.setNm_contrato(jTFContrato.getText());
        aluguel.setNm_vlaluguel(Utilidade.converter(jFTFValorAlguel.getText()));
        aluguel.setDt_deposito(Integer.parseInt(jTFDataAluguel.getText()));
        aluguel.setNm_vladm(Utilidade.converter(jFTFTaxaAdm.getText()));
        aluguel.setDt_contratovenc(util.recebeData(jFTFVencContrato.getText()));
        aluguel.setCd_usuario(JPLogin.codloginuser);
        aluguelr.inserir(aluguel);
    }
    
    /**
     * <p><strong>EN:</strong> Updates an existing rental record with the current form data.</p>
     * <p><strong>IT:</strong> Aggiorna un record di affitto esistente con i dati correnti del modulo.</p>
     * <p><strong>PT-BR:</strong> Atualiza um registro de aluguel existente com os dados atuais do formulário.</p>
     */
    private void alterar(){
        aluguel.setImovel(imovel);
        aluguel.setEmpresa(empresa);
        aluguel.setNm_contrato(jTFContrato.getText());
        aluguel.setNm_vlaluguel(Utilidade.converter(jFTFValorAlguel.getText()));
        aluguel.setDt_deposito(Integer.parseInt(jTFDataAluguel.getText()));
        aluguel.setNm_vladm(Utilidade.converter(jFTFTaxaAdm.getText()));
        aluguel.setDt_contratovenc(util.recebeData(jFTFVencContrato.getText()));
        aluguelr.alterar(aluguel);        
    }
    
    /**
     * <p><strong>EN:</strong> Deletes the currently selected rental record.</p>
     * <p><strong>IT:</strong> Elimina il record di affitto attualmente selezionato.</p>
     * <p><strong>PT-BR:</strong> Exclui o registro de aluguel atualmente selecionado.</p>
     */
    private void excluir(){
        aluguel.setCd_aluguel(aluguel.getCd_aluguel());
        aluguelr.excluir(aluguel);
    }
    
    /**
     * <p><strong>EN:</strong> Validates required rental fields before saving or updating.</p>
     * <p><strong>IT:</strong> Convalida i campi obbligatori dell'affitto prima di salvare o aggiornare.</p>
     * <p><strong>PT-BR:</strong> Valida os campos obrigatórios do aluguel antes de salvar ou atualizar.</p>
     *
     * @return true if all fields are valid; false otherwise
     */
    private boolean validaCampos(){
        if(imovel == null){
            JOptionPane.showMessageDialog(null, "Selecione o imovel.", "Imovel", JOptionPane.INFORMATION_MESSAGE);
            jCBImovel.requestFocus();
            return false;
        }
        if(empresa == null){
            JOptionPane.showMessageDialog(null, "Selecione o prestador.", "Imovel", JOptionPane.INFORMATION_MESSAGE);
            jCBImovel.requestFocus();
            return false;
        }
        if(jTFDataAluguel.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Dia de pagamento em branco.", "Aluguel", JOptionPane.INFORMATION_MESSAGE);
            jTFDataAluguel.requestFocus();
            return false;
        }
        if(jFTFValorAlguel.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Valor do aluguel em branco.", "Aluguel", JOptionPane.INFORMATION_MESSAGE);
            jFTFValorAlguel.requestFocus();
            return false;
        }
        if(util.validaDataCampo(jFTFVencContrato.getText()) == false){
            jFTFVencContrato.requestFocus();
            return false;
        }
        return true;
    }
    
    /**
     * <p><strong>EN:</strong> Clears all fields in the rental form.</p>
     * <p><strong>IT:</strong> Pulisce tutti i campi nel modulo di affitto.</p>
     * <p><strong>PT-BR:</strong> Limpa todos os campos do formulário de aluguel.</p>
     */
    private void limpaCampos(){
        jCBImovel.setSelectedIndex(0);
        jCBImobiliaria.setSelectedIndex(0);
        jTFContrato.setText(null);
        jFTFValorAlguel.setValue(null);
        jTFDataAluguel.setText(null);
        jFTFTaxaAdm.setValue(null);
        jFTFVencContrato.setText(null);
        jLVlLiquido.setText("Valor Líquido: ");
    }
    
    /**
     * <p><strong>EN:</strong> Calculates the net rental value after administrative fee deduction and updates the display label.</p>
     * <p><strong>IT:</strong> Calcola il valore netto dell'affitto dopo la detrazione della tassa amministrativa e aggiorna l'etichetta di visualizzazione.</p>
     * <p><strong>PT-BR:</strong> Calcula o valor líquido do aluguel após a taxa administrativa e atualiza o rótulo exibido.</p>
     */
    private void calculaAlguelTx(){
        aluguel.setNm_vlaluguel(Utilidade.converter(jFTFValorAlguel.getText()));
        aluguel.setNm_vladm(Utilidade.converter(jFTFTaxaAdm.getText()));
        jLVlLiquido.setText("Valor Líquido: " + Utilidade.formatoValor.format(aluguelu.valorLiquido(aluguel.getNm_vlaluguel(), aluguel.getNm_vladm())));
    }
    
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifaluguel = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jTFContratoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFContratoFocusLost
        jTFContrato.setText(jTFContrato.getText());
    }//GEN-LAST:event_jTFContratoFocusLost

    private void jTFDataAluguelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFDataAluguelFocusLost
        try{
            int i = Integer.parseInt(jTFDataAluguel.getText());
            if(i > 31 | i <= 0){
                JOptionPane.showMessageDialog(null, "Dia inválido.");
                jTFDataAluguel.requestFocus();
            }
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Somente numeros.");
            jTFDataAluguel.requestFocus();     
        }
    }//GEN-LAST:event_jTFDataAluguelFocusLost

    private void jCBImovelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBImovelActionPerformed
        if(jCBImovel.getSelectedIndex() != 0){
            imovel = (Imovel)jCBImovel.getSelectedItem();
        }else{
            imovel = null;
        }
    }//GEN-LAST:event_jCBImovelActionPerformed

    private void jCBImobiliariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBImobiliariaActionPerformed
        if(jCBImobiliaria.getSelectedIndex() != 0){
            empresa = (Empresa)jCBImobiliaria.getSelectedItem();
        }else{
            empresa = null;
        }
    }//GEN-LAST:event_jCBImobiliariaActionPerformed

    private void jTAluguelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTAluguelMouseClicked
        aluguel = (Aluguel)aluguelu.getSelectObject(jTAluguel);
        jCBImovel.getModel().setSelectedItem(aluguel.getImovel());
        jCBImobiliaria.getModel().setSelectedItem(aluguel.getEmpresa());
        jTFContrato.setText(aluguel.getNm_contrato());
        jFTFValorAlguel.setText(Utilidade.formatoValor.format(aluguel.getNm_vlaluguel()));
        jTFDataAluguel.setText(Integer.toString(aluguel.getDt_deposito()));
        jFTFTaxaAdm.setText(Utilidade.formatoValor.format(aluguel.getNm_vladm()));
        jFTFVencContrato.setText(Utilidade.formatoData.format(aluguel.getDt_contratovenc().getTime()));
        calculaAlguelTx();
    }//GEN-LAST:event_jTAluguelMouseClicked

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if(validaCampos()){
            salvar();
            limpaCampos();
            tabelaAluguel();
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        aluguel = (Aluguel)aluguelu.getSelectObject(jTAluguel);
        if(aluguel != null){
            alterar();
            limpaCampos();
            tabelaAluguel();
        }
    }//GEN-LAST:event_jBAlterarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        aluguel = (Aluguel)aluguelu.getSelectObject(jTAluguel);
        if(aluguel != null){
            excluir();
            limpaCampos();
            tabelaAluguel();
        }
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jFTFTaxaAdmFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTFTaxaAdmFocusLost
        if(jFTFTaxaAdm.getText().isEmpty()){
            jFTFTaxaAdm.setText("0,00");
        }
        calculaAlguelTx();
    }//GEN-LAST:event_jFTFTaxaAdmFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox jCBImobiliaria;
    private javax.swing.JComboBox<Imovel> jCBImovel;
    private javax.swing.JFormattedTextField jFTFTaxaAdm;
    private javax.swing.JFormattedTextField jFTFValorAlguel;
    private javax.swing.JFormattedTextField jFTFVencContrato;
    private javax.swing.JLabel jLContrato;
    private javax.swing.JLabel jLDataDeposito;
    private javax.swing.JLabel jLTaxaAdm;
    private javax.swing.JLabel jLValorAluguel;
    private javax.swing.JLabel jLVencContrato;
    private javax.swing.JLabel jLVlLiquido;
    private javax.swing.JPanel jPBotoes;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JPanel jPGrid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTAluguel;
    private javax.swing.JTextField jTFContrato;
    private javax.swing.JTextField jTFDataAluguel;
    // End of variables declaration//GEN-END:variables
}
