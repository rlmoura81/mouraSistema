package br.com.rlmoura81.moura.financeirointerface;

import br.com.rlmoura81.moura.financeiro.Ativo;
import br.com.rlmoura81.moura.financeiro.AtivoUtil;
import br.com.rlmoura81.moura.financeiro.FundoImobiliarioProvento;
import br.com.rlmoura81.moura.financeiro.FundoImobiliarioProventoRepository;
import br.com.rlmoura81.moura.financeiro.TipoProvento;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import javax.swing.JOptionPane;

public class JIFFundoImobiliarioProvento extends javax.swing.JInternalFrame {
    
    private static JIFFundoImobiliarioProvento jiffiiprov;
    
    /**
     * <p><strong>EN:</strong> Opens the {@link JIFFundoImobiliarioProvento} screen for real estate fund income.  
     * Creates a new instance if none exists, sets the title, and returns the reference.</p>
     *
     * <p><strong>IT:</strong> Apre la finestra {@link JIFFundoImobiliarioProvento} per i proventi di fondi immobiliari.  
     * Crea una nuova istanza se non esiste, imposta il titolo e restituisce il riferimento.</p>
     *
     * <p><strong>PT-BR:</strong> Abre a tela {@link JIFFundoImobiliarioProvento} para proventos de fundos imobiliários.  
     * Cria uma nova instância se não existir, define o título e retorna a referência.</p>
     */
    public static JIFFundoImobiliarioProvento getInstancia(){
        if(jiffiiprov == null){
            jiffiiprov = new JIFFundoImobiliarioProvento();
            jiffiiprov.setTitle("FII Provento.");
        }return jiffiiprov;
    }
    
    Ativo ativo = null;
    AtivoUtil ativou = new AtivoUtil();
    
    FundoImobiliarioProvento fiprovento = new FundoImobiliarioProvento();
    FundoImobiliarioProventoRepository fiproventor = new FundoImobiliarioProventoRepository();
    
    TipoProvento tpp = new TipoProvento();
    
    Utilidade util = new Utilidade();

    public JIFFundoImobiliarioProvento() {
        initComponents();
        
        jcFundoImobiiario();
        formataValor();
        formatarData();
        tabelaFiProv();
        tpp.setCd_tpprovento(1); //codigo de "Rendimentos de Clientes" - padrão para FII;
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPAtivo = new javax.swing.JPanel();
        jCBAtivo = new javax.swing.JComboBox<>();
        jPCampo = new javax.swing.JPanel();
        jLRendimentoPago = new javax.swing.JLabel();
        jLDtPagamento = new javax.swing.JLabel();
        jFTFDtPagamento = new javax.swing.JFormattedTextField();
        jLPrecoDtBase = new javax.swing.JLabel();
        jFTFRendimentoPago = new javax.swing.JFormattedTextField();
        jFTFPrecoDtBase = new javax.swing.JFormattedTextField();
        jLDtPrecoBase = new javax.swing.JLabel();
        jFTFDtPrecoBase = new javax.swing.JFormattedTextField();
        jPBotoes = new javax.swing.JPanel();
        jBSalvar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jPGrid = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTFiProv = new javax.swing.JTable();

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

        jPCampo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLRendimentoPago.setText("Rendimento Pago:");

        jLDtPagamento.setText("Data Pagamento:");

        jLPrecoDtBase.setText("Preço Data Base:");

        jLDtPrecoBase.setText("Data Preço Base:");

        javax.swing.GroupLayout jPCampoLayout = new javax.swing.GroupLayout(jPCampo);
        jPCampo.setLayout(jPCampoLayout);
        jPCampoLayout.setHorizontalGroup(
            jPCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCampoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLPrecoDtBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLRendimentoPago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPCampoLayout.createSequentialGroup()
                        .addComponent(jFTFRendimentoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLDtPagamento))
                    .addGroup(jPCampoLayout.createSequentialGroup()
                        .addComponent(jFTFPrecoDtBase, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLDtPrecoBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jFTFDtPrecoBase, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFTFDtPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPCampoLayout.setVerticalGroup(
            jPCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCampoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLRendimentoPago)
                    .addComponent(jLDtPagamento)
                    .addComponent(jFTFDtPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFTFRendimentoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLPrecoDtBase)
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

        jTFiProv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTFiProv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTFiProvMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTFiProv);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
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
                    .addComponent(jPBotoes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPCampo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPAtivo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * <p><strong>EN:</strong> Loads the real estate fund (FII) list into the combo box.  
     * Calls the utility method to populate {@code jCBAtivo} with available options.</p>
     *
     * <p><strong>IT:</strong> Carica l'elenco dei fondi immobiliari (FII) nella combo box.  
     * Richiama il metodo di utilità per popolare {@code jCBAtivo} con le opzioni disponibili.</p>
     *
     * <p><strong>PT-BR:</strong> Carrega a lista de fundos imobiliários (FII) no combo box.  
     * Chama o método utilitário para preencher {@code jCBAtivo} com as opções disponíveis.</p>
     */
    private void jcFundoImobiiario(){
        ativou.jcFundoImobiiario(jCBAtivo);
    }
    
    /**
     * <p><strong>EN:</strong> Formats the numeric fields to accept monetary values.  
     * Applies masks and format rules to {@code jFTFRendimentoPago} and {@code jFTFPrecoDtBase}.</p>
     *
     * <p><strong>IT:</strong> Formattta i campi numerici per accettare valori monetari.  
     * Applica maschere e regole di formato a {@code jFTFRendimentoPago} e {@code jFTFPrecoDtBase}.</p>
     *
     * <p><strong>PT-BR:</strong> Formata os campos numéricos para aceitar valores monetários.  
     * Aplica máscaras e regras de formatação em {@code jFTFRendimentoPago} e {@code jFTFPrecoDtBase}.</p>
     */
    private void formataValor() {        
        jFTFRendimentoPago.setFormatterFactory(Utilidade.formataValorCampo(ui));
        jFTFPrecoDtBase.setFormatterFactory(Utilidade.formataValorCampo(ui));
    }  

    /**
     * <p><strong>EN:</strong> Formats the date fields to ensure valid date input.  
     * Configures {@code jFTFDtPagamento} and {@code jFTFDtPrecoBase} with date masks.</p>
     *
     * <p><strong>IT:</strong> Formattta i campi data per garantire un input valido.  
     * Configura {@code jFTFDtPagamento} e {@code jFTFDtPrecoBase} con maschere di data.</p>
     *
     * <p><strong>PT-BR:</strong> Formata os campos de data para garantir entradas válidas.  
     * Configura {@code jFTFDtPagamento} e {@code jFTFDtPrecoBase} com máscaras de data.</p>
     */
    private void formatarData(){
        util.formataDataCampo(jFTFDtPagamento);
        util.formataDataCampo(jFTFDtPrecoBase);
    } 

    /**
     * <p><strong>EN:</strong> Validates the fields before saving a real estate fund income record.  
     * Ensures that the fund, payment value, base price, and dates are properly filled in.</p>
     *
     * <p><strong>IT:</strong> Convalida i campi prima di salvare un record di provento immobiliare.  
     * Verifica che il fondo, l'importo del pagamento, il prezzo base e le date siano compilati correttamente.</p>
     *
     * <p><strong>PT-BR:</strong> Valida os campos antes de salvar um provento de fundo imobiliário.  
     * Garante que o fundo, valor de pagamento, preço base e datas estejam corretamente preenchidos.</p>
     */
    private boolean validaCampos(){        
        if(ativo == null){
            JOptionPane.showMessageDialog(null, "Selecione o FII.", "Fundo Investimento Imobiliário", JOptionPane.INFORMATION_MESSAGE);
            jCBAtivo.requestFocus();
            return false;
        }
        if(jFTFRendimentoPago.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Informe o valor de rendimento.", "Fundo Investimento Imobiliário", JOptionPane.INFORMATION_MESSAGE);
            jFTFRendimentoPago.requestFocus();
            return false;
        }
        if(jFTFPrecoDtBase.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Informe o valor de preço da data base.", "Fundo Investimento Imobiliário", JOptionPane.INFORMATION_MESSAGE);
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
     * <p><strong>EN:</strong> Clears all fields on the FII income screen.  
     * Resets combo box selections and input fields to their default state.</p>
     *
     * <p><strong>IT:</strong> Pulisce tutti i campi nella schermata dei proventi FII.  
     * Reimposta le selezioni delle combo box e i campi di input allo stato predefinito.</p>
     *
     * <p><strong>PT-BR:</strong> Limpa todos os campos da tela de provento FII.  
     * Reseta as seleções das combo box e os campos de entrada para o estado padrão.</p>
     */
    private void limpaCampos(){
        jCBAtivo.setSelectedIndex(0);
        jFTFRendimentoPago.setValue(null);
        jFTFDtPagamento.setText(null);
        jFTFPrecoDtBase.setValue(null);
        jFTFDtPrecoBase.setText(null);
    }
    
    /**
     * <p><strong>EN:</strong> Loads the table of FII incomes.  
     * Retrieves the registered records and displays them in {@code jTFiProv}.</p>
     *
     * <p><strong>IT:</strong> Carica la tabella dei proventi FII.  
     * Recupera i record registrati e li visualizza in {@code jTFiProv}.</p>
     *
     * <p><strong>PT-BR:</strong> Carrega a tabela de proventos FII.  
     * Recupera os registros cadastrados e exibe em {@code jTFiProv}.</p>
     */
    private void tabelaFiProv(){
        ativou.tabelaFiProv(jTFiProv);
    }
    
    /**
     * <p><strong>EN:</strong> Saves a new FII income record.  
     * Sets the selected fund, income value, base price, and dates, then persists the record.</p>
     *
     * <p><strong>IT:</strong> Salva un nuovo record di provento FII.  
     * Imposta il fondo selezionato, l'importo, il prezzo base e le date, quindi registra il record.</p>
     *
     * <p><strong>PT-BR:</strong> Salva um novo registro de provento FII.  
     * Define o fundo selecionado, valor do rendimento, preço base e datas, e então persiste o registro.</p>
     */
    private void salvar(){
        fiprovento.setAtivo(ativo);
        fiprovento.setVl_provento(Utilidade.converter(jFTFRendimentoPago.getText()));
        fiprovento.setDt_pagamento(util.recebeData(jFTFDtPagamento.getText()));
        fiprovento.setVl_database(Utilidade.converter(jFTFPrecoDtBase.getText()));
        fiprovento.setDt_precobase(util.recebeData(jFTFDtPrecoBase.getText()));
        fiprovento.setTipoprovento(tpp);
        fiprovento.setCd_usuario(JPLogin.codloginuser);
        fiproventor.inserir(fiprovento);
    }
    
    /**
     * <p><strong>EN:</strong> Deletes the selected FII income record.  
     * Uses the current {@code fiprovento} object and removes it from the database.</p>
     *
     * <p><strong>IT:</strong> Elimina il record di provento FII selezionato.  
     * Utilizza l'oggetto {@code fiprovento} corrente e lo rimuove dal database.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui o registro de provento FII selecionado.  
     * Usa o objeto {@code fiprovento} atual e remove do banco de dados.</p>
     */
    private void excluir(){
        fiprovento.setCd_fdimprov(fiprovento.getCd_fdimprov());
        fiproventor.excluir(fiprovento);
    }
    
    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if(validaCampos()){
            salvar();
            limpaCampos();
            tabelaFiProv();            
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jCBAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBAtivoActionPerformed
        if(jCBAtivo.getSelectedIndex() != 0){
            ativo = (Ativo)jCBAtivo.getSelectedItem();
        }else{
            ativo = null;
        }
    }//GEN-LAST:event_jCBAtivoActionPerformed

    private void jTFiProvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFiProvMouseClicked
        fiprovento = (FundoImobiliarioProvento)ativou.getSelectObject(jTFiProv);
        jCBAtivo.getModel().setSelectedItem(fiprovento.getAtivo());
        jFTFDtPagamento.setText(Utilidade.formatoData.format(fiprovento.getDt_pagamento().getTime()));
        jFTFRendimentoPago.setText(Utilidade.formatoValor.format(fiprovento.getVl_provento()));
        jFTFDtPrecoBase.setText(Utilidade.formatoData.format(fiprovento.getDt_precobase().getTime()));
        jFTFPrecoDtBase.setText(Utilidade.formatoValor.format(fiprovento.getVl_database()));
        
    }//GEN-LAST:event_jTFiProvMouseClicked

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        fiprovento = (FundoImobiliarioProvento)ativou.getSelectObject(jTFiProv);
        if(fiprovento != null){
            excluir();
            tabelaFiProv();
            limpaCampos();
        }        
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jiffiiprov = null;
    }//GEN-LAST:event_formInternalFrameClosed
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<Ativo> jCBAtivo;
    private javax.swing.JFormattedTextField jFTFDtPagamento;
    private javax.swing.JFormattedTextField jFTFDtPrecoBase;
    private javax.swing.JFormattedTextField jFTFPrecoDtBase;
    private javax.swing.JFormattedTextField jFTFRendimentoPago;
    private javax.swing.JLabel jLDtPagamento;
    private javax.swing.JLabel jLDtPrecoBase;
    private javax.swing.JLabel jLPrecoDtBase;
    private javax.swing.JLabel jLRendimentoPago;
    private javax.swing.JPanel jPAtivo;
    private javax.swing.JPanel jPBotoes;
    private javax.swing.JPanel jPCampo;
    private javax.swing.JPanel jPGrid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTFiProv;
    // End of variables declaration//GEN-END:variables
}
