package br.com.rlmoura81.moura.financeirointerface;

import br.com.rlmoura81.moura.financeiro.Indice;
import br.com.rlmoura81.moura.financeiro.IndiceUtil;
import br.com.rlmoura81.moura.financeiro.IndiceValor;
import br.com.rlmoura81.moura.financeiro.IndiceValorRepository;
import br.com.rlmoura81.moura.financeiro.IndiceValorUtil;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JIFIndiceValor extends javax.swing.JInternalFrame {
    
    private static JIFIndiceValor jifindice;
    
    /**
     * <p><strong>EN:</strong> Returns the singleton instance of {@link JIFIndiceValor}.  
     * If no instance exists, a new one is created and initialized with the title "Índice - valores".</p>
     *
     * <p><strong>IT:</strong> Restituisce l'istanza singleton di {@link JIFIndiceValor}.  
     * Se non esiste alcuna istanza, ne viene creata una nuova con il titolo "Índice - valores".</p>
     *
     * <p><strong>PT-BR:</strong> Retorna a instância única de {@link JIFIndiceValor}.  
     * Caso não exista, uma nova é criada e inicializada com o título "Índice - valores".</p>
     */
    public static JIFIndiceValor getInstancia(){
        if(jifindice == null){
            jifindice = new JIFIndiceValor();
            jifindice.setTitle("Índice - valores");
        }
        return jifindice;
    }
    
    IndiceValor indicevalor = new IndiceValor();
    IndiceValorRepository indicevalorr = new IndiceValorRepository();
    IndiceValorUtil indicevaloru = new IndiceValorUtil();

    Indice indice = null;
    IndiceUtil indiceu = new IndiceUtil();
    
    Utilidade util = new Utilidade();
    
    public JIFIndiceValor() {
        initComponents();
        
        jcIndice();
        formataData();
        formataValor();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bGPeriodo = new javax.swing.ButtonGroup();
        jPCampos = new javax.swing.JPanel();
        jCBIndice = new javax.swing.JComboBox<>();
        jFTFData = new javax.swing.JFormattedTextField();
        jLData = new javax.swing.JLabel();
        jRBMes = new javax.swing.JRadioButton();
        jRBAno = new javax.swing.JRadioButton();
        jLValor = new javax.swing.JLabel();
        jFTFValor = new javax.swing.JFormattedTextField();
        jPBotoes = new javax.swing.JPanel();
        jBSalvar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jPResumo = new javax.swing.JPanel();
        jLAno = new javax.swing.JLabel();
        jLMes = new javax.swing.JLabel();
        jPGrid = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTIndiceValor = new javax.swing.JTable();

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

        jCBIndice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBIndiceActionPerformed(evt);
            }
        });

        jLData.setText("Data:");

        bGPeriodo.add(jRBMes);
        jRBMes.setText("Mês");
        jRBMes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRBMesMouseClicked(evt);
            }
        });

        bGPeriodo.add(jRBAno);
        jRBAno.setText("Ano");
        jRBAno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRBAnoMouseClicked(evt);
            }
        });

        jLValor.setText("Valor %:");

        javax.swing.GroupLayout jPCamposLayout = new javax.swing.GroupLayout(jPCampos);
        jPCampos.setLayout(jPCamposLayout);
        jPCamposLayout.setHorizontalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCBIndice, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addComponent(jLData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFTFData, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLValor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFTFValor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRBMes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRBAno)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPCamposLayout.setVerticalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCBIndice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLData)
                    .addComponent(jFTFData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRBMes)
                    .addComponent(jRBAno)
                    .addComponent(jLValor)
                    .addComponent(jFTFValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jPResumo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLAno.setText("Ano:");

        jLMes.setText("Mês:");

        javax.swing.GroupLayout jPResumoLayout = new javax.swing.GroupLayout(jPResumo);
        jPResumo.setLayout(jPResumoLayout);
        jPResumoLayout.setHorizontalGroup(
            jPResumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPResumoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPResumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLAno)
                    .addComponent(jLMes))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPResumoLayout.setVerticalGroup(
            jPResumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPResumoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLMes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLAno)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPGrid.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTIndiceValor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTIndiceValor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTIndiceValorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTIndiceValor);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
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
                    .addComponent(jPBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPResumo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPResumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * <p><strong>EN:</strong> Loads index options into the {@link JComboBox} component.</p>
     * <p><strong>IT:</strong> Carica le opzioni dell’indice nel componente {@link JComboBox}.</p>
     * <p><strong>PT-BR:</strong> Carrega as opções de índice no componente {@link JComboBox}.</p>
     */
    private void jcIndice(){
        indiceu.jcIndice(jCBIndice);
    }
    
    /**
     * <p><strong>EN:</strong> Applies date formatting to the date input field.</p>
     * <p><strong>IT:</strong> Applica la formattazione della data al campo di input della data.</p>
     * <p><strong>PT-BR:</strong> Aplica a formatação de data no campo de entrada.</p>
     */
    private void formataData(){
        util.formataDataCampo(jFTFData);
    }
    
    /**
     * <p><strong>EN:</strong> Applies numeric formatting to the value input field.</p>
     * <p><strong>IT:</strong> Applica la formattazione numerica al campo di input del valore.</p>
     * <p><strong>PT-BR:</strong> Aplica a formatação numérica no campo de valor.</p>
     */
    private void formataValor(){        
        jFTFValor.setFormatterFactory(Utilidade.formataValorCampo(ui));
    }
        
    /**
     * <p><strong>EN:</strong> Populates the table with index values related to the selected index.</p>
     * <p><strong>IT:</strong> Popola la tabella con i valori dell’indice relativi all’indice selezionato.</p>
     * <p><strong>PT-BR:</strong> Preenche a tabela com os valores do índice relacionado ao índice selecionado.</p>
     */
    private void tabelaIndiceValor(){
        indicevaloru.tabelaIndiceValor(jTIndiceValor, indice.getCd_indice());
    }
        
    /**
     * <p><strong>EN:</strong> Validates form fields before saving or updating index values.</p>
     * <p><strong>IT:</strong> Valida i campi del modulo prima di salvare o aggiornare i valori dell’indice.</p>
     * <p><strong>PT-BR:</strong> Valida os campos do formulário antes de salvar ou atualizar os valores do índice.</p>
     */
    private boolean validaCampos(){
        if(indice == null){
            JOptionPane.showMessageDialog(null, "Selecione o Índice.", "Índice", JOptionPane.INFORMATION_MESSAGE);
            jCBIndice.requestFocus();
            return false;
        }
        if(util.validaDataCampo(jFTFData.getText()) == false){
            jFTFData.requestFocus();
            return false;
        }
        if(jFTFValor.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Informe o valor.");
            jFTFValor.requestFocus();
            return false;
        }
        if(jRBMes.isSelected() == false & jRBAno.isSelected() == false){
            JOptionPane.showMessageDialog(null, "Selecione o mês ou ano.");
            return false;
        }
        return true;
    }
    
    /**
     * <p><strong>EN:</strong> Clears all form fields and resets labels to their default state.</p>
     * <p><strong>IT:</strong> Pulisce tutti i campi del modulo e reimposta le etichette allo stato predefinito.</p>
     * <p><strong>PT-BR:</strong> Limpa todos os campos do formulário e redefine os rótulos para o estado padrão.</p>
     */
    private void limpaCampos(){
        jFTFData.setText(null);
        jFTFValor.setValue(null);
        bGPeriodo.clearSelection();
        jLMes.setText("Mês:");
        jLAno.setText("Ano:");
    }
    
    /**
     * <p><strong>EN:</strong> Saves a new index value with the current form data into the database.</p>
     * <p><strong>IT:</strong> Salva un nuovo valore di indice con i dati correnti del modulo nel database.</p>
     * <p><strong>PT-BR:</strong> Salva um novo valor de índice com os dados atuais do formulário no banco de dados.</p>
     */
    private void salvar(){
        indicevalor.setIndice(indice);
        indicevalor.setDt_vlatualizado(util.recebeData(jFTFData.getText()));
        indicevalor.setVl_mes(Utilidade.converter(jFTFValor.getText()));
        indicevalor.setCd_usuario(JPLogin.codloginuser);
        indicevalorr.inserir(indicevalor);
    }
    
    /**
     * <p><strong>EN:</strong> Deletes the selected index value from the database.</p>
     * <p><strong>IT:</strong> Elimina il valore dell’indice selezionato dal database.</p>
     * <p><strong>PT-BR:</strong> Exclui o valor do índice selecionado do banco de dados.</p>
     */
    private void excluir(){
        indicevalor.setCd_indicevl(indicevalor.getCd_indicevl());
        indicevalorr.excluir(indicevalor);
    }
    
    /**
     * <p><strong>EN:</strong> Performs the calculation of averages (monthly/yearly) and updates the UI labels.</p>
     * <p><strong>IT:</strong> Esegue il calcolo delle medie (mensili/annuali) e aggiorna le etichette dell’interfaccia.</p>
     * <p><strong>PT-BR:</strong> Realiza o cálculo das médias (mensal/anual) e atualiza os rótulos da interface.</p>
     */
    private void calculoMedia(){
        indicevalor.setVl_mes(Utilidade.converter(jFTFValor.getText()));
        if(jRBMes.isSelected() == true){
            jLMes.setText("Mês: " + jFTFValor.getText() + "%");
            jLAno.setText("Ano: " + Utilidade.formatoValor.format(indicevaloru.mediaMesAno(indicevalor.getVl_mes())) + "%");
        }
        if(jRBAno.isSelected() == true){
            jLMes.setText("Mês: " + Utilidade.formatoValor.format(indicevaloru.mediaAnoMes(indicevalor.getVl_mes())) + "%");
            jLAno.setText("Ano: " + jFTFValor.getText() + "%");
        }
    }
    
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifindice = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if(validaCampos()){
            salvar();
            limpaCampos();
            tabelaIndiceValor();
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jCBIndiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBIndiceActionPerformed
        if(jCBIndice.getSelectedIndex() != 0){
            indice = (Indice)jCBIndice.getSelectedItem();
            limpaCampos();
            tabelaIndiceValor();
        }else{
            indice = null;
            limpaCampos();
            ((DefaultTableModel)jTIndiceValor.getModel()).setRowCount(0);
        }
    }//GEN-LAST:event_jCBIndiceActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        indicevalor = (IndiceValor)indicevaloru.getSelectObject(jTIndiceValor);
        if(indicevalor != null){
            excluir();
            limpaCampos();
            tabelaIndiceValor();
        }
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jTIndiceValorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTIndiceValorMouseClicked
        indicevalor = (IndiceValor)indicevaloru.getSelectObject(jTIndiceValor);
        jFTFData.setText(Utilidade.formatoData.format(indicevalor.getDt_vlatualizado().getTime()));
        jFTFValor.setText(Utilidade.formatoValor.format(indicevalor.getVl_mes()));
        jRBMes.setSelected(true);
        calculoMedia();
    }//GEN-LAST:event_jTIndiceValorMouseClicked

    private void jRBMesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRBMesMouseClicked
        calculoMedia();
    }//GEN-LAST:event_jRBMesMouseClicked

    private void jRBAnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRBAnoMouseClicked
        calculoMedia();
    }//GEN-LAST:event_jRBAnoMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bGPeriodo;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<Indice> jCBIndice;
    private javax.swing.JFormattedTextField jFTFData;
    private javax.swing.JFormattedTextField jFTFValor;
    private javax.swing.JLabel jLAno;
    private javax.swing.JLabel jLData;
    private javax.swing.JLabel jLMes;
    private javax.swing.JLabel jLValor;
    private javax.swing.JPanel jPBotoes;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JPanel jPGrid;
    private javax.swing.JPanel jPResumo;
    private javax.swing.JRadioButton jRBAno;
    private javax.swing.JRadioButton jRBMes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTIndiceValor;
    // End of variables declaration//GEN-END:variables
}
