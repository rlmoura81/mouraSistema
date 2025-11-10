package br.com.rlmoura81.moura.animalinterface;

import br.com.rlmoura81.moura.animal.Animal;
import br.com.rlmoura81.moura.animal.AnimalUtil;
import br.com.rlmoura81.moura.animal.Historico;
import br.com.rlmoura81.moura.animal.HistoricoRepository;
import br.com.rlmoura81.moura.animal.HistoricoUtil;
import br.com.rlmoura81.moura.animal.Tipo;
import br.com.rlmoura81.moura.animal.TipoUtil;
import br.com.rlmoura81.moura.principalcadastro.Empresa;
import br.com.rlmoura81.moura.principalcadastro.EmpresaUtil;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import javax.swing.JOptionPane;

public class JIFHistorico extends javax.swing.JInternalFrame {
    
    private static JIFHistorico jifhistorico;
    
    /**
     * <p><strong>EN:</strong> Returns the singleton instance of the JIFHistorico class.  
     * If no instance exists, a new one is created and initialized.</p>
     *
     * <p><strong>IT:</strong> Restituisce l'istanza singleton della classe JIFHistorico.  
     * Se non esiste alcuna istanza, ne viene creata e inizializzata una nuova.</p>
     *
     * <p><strong>PT-BR:</strong> Retorna a instância singleton da classe JIFHistorico.  
     * Se não existir nenhuma instância, uma nova é criada e inicializada.</p>
     *
     * @return EN: singleton instance of JIFHistorico | IT: istanza singleton di JIFHistorico | PT-BR: instância singleton de JIFHistorico
     * @since 1.0.0
     */    
    public static JIFHistorico getInstancia(){
        if(jifhistorico == null){
            jifhistorico = new JIFHistorico();
            jifhistorico.setTitle("Histórico");
        }return jifhistorico;
    }
    
    Historico historico = null;
    HistoricoRepository historicor = new HistoricoRepository();
    HistoricoUtil historicou = new HistoricoUtil();    
    Animal animal = null;
    AnimalUtil animalu = new AnimalUtil();    
    Empresa empresa = new Empresa();
    EmpresaUtil empresau = new EmpresaUtil();    
    Tipo tipo = new Tipo();
    TipoUtil tipou = new TipoUtil();    
    Utilidade util = new Utilidade();

    public JIFHistorico() {
        initComponents();
        
        jcHistorico();
        formataData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPCampos = new javax.swing.JPanel();
        jCBAnimal = new javax.swing.JComboBox<>();
        jCBPresserv = new javax.swing.JComboBox<>();
        jPCamposHistorico = new javax.swing.JPanel();
        jCBTipo = new javax.swing.JComboBox<>();
        jFTFDataHistorico = new javax.swing.JFormattedTextField();
        jTFDescricao = new javax.swing.JTextField();
        jLTipo = new javax.swing.JLabel();
        jLData = new javax.swing.JLabel();
        jLDescricao = new javax.swing.JLabel();
        jPGrid = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTHistorico = new javax.swing.JTable();
        jPBotoes = new javax.swing.JPanel();
        jBExcluir = new javax.swing.JButton();
        jBSalvar = new javax.swing.JButton();

        setClosable(true);
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

        jCBAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBAnimalActionPerformed(evt);
            }
        });

        jCBPresserv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBPresservActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPCamposLayout = new javax.swing.GroupLayout(jPCampos);
        jPCampos.setLayout(jPCamposLayout);
        jPCamposLayout.setHorizontalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCBAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCBPresserv, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPCamposLayout.setVerticalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBPresserv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPCamposHistorico.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jCBTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBTipoActionPerformed(evt);
            }
        });

        jLTipo.setText("Tipo:");

        jLData.setText("Data:");

        jLDescricao.setText("Descrição:");

        javax.swing.GroupLayout jPCamposHistoricoLayout = new javax.swing.GroupLayout(jPCamposHistorico);
        jPCamposHistorico.setLayout(jPCamposHistoricoLayout);
        jPCamposHistoricoLayout.setHorizontalGroup(
            jPCamposHistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposHistoricoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposHistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCBTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLTipo))
                .addGap(18, 18, 18)
                .addGroup(jPCamposHistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jFTFDataHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPCamposHistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLDescricao)
                    .addComponent(jTFDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPCamposHistoricoLayout.setVerticalGroup(
            jPCamposHistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPCamposHistoricoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPCamposHistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTipo)
                    .addComponent(jLData)
                    .addComponent(jLDescricao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPCamposHistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFTFDataHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPGrid.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTHistorico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTHistorico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTHistoricoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTHistorico);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPBotoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBExcluir.setText("Excluir");
        jBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirActionPerformed(evt);
            }
        });

        jBSalvar.setText("Salvar");
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPGrid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPCamposHistorico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPCamposHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * <p><strong>EN:</strong> Populates the JComboBoxes with animals, service providers, and types for the history form.</p>
     *
     * <p><strong>IT:</strong> Popola i JComboBox con animali, fornitori di servizi e tipi per il modulo dello storico.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche os JComboBox com animais, prestadores de serviço e tipos para o formulário de histórico.</p>
     *
     * @since 1.0.0
     */
    private void jcHistorico(){
        animalu.jcAnimal(jCBAnimal);
        empresau.jcEmpresa(jCBPresserv, 2);
        tipou.jcTipo(jCBTipo);
    }
    
    /**
     * <p><strong>EN:</strong> Populates the JTable with the history records of the selected animal.</p>
     *
     * <p><strong>IT:</strong> Popola la JTable con i record dello storico dell'animale selezionato.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche a JTable com os registros de histórico do animal selecionado.</p>
     *
     * @since 1.0.0
     */
    private void tabelaHistorico(){
        historicou.tabelaHistorico(jTHistorico, animal.getCd_animal());
    }
    
    /**
     * <p><strong>EN:</strong> Applies formatting to the date field in the history form.</p>
     *
     * <p><strong>IT:</strong> Applica la formattazione al campo data nel modulo dello storico.</p>
     *
     * <p><strong>PT-BR:</strong> Aplica a formatação ao campo de data no formulário de histórico.</p>
     *
     * @since 1.0.0
     */    
    private void formataData(){
        util.formataDataCampo(jFTFDataHistorico);
    }

    /**
     * <p><strong>EN:</strong> Clears all input fields in the history form.</p>
     *
     * <p><strong>IT:</strong> Pulisce tutti i campi di input nel modulo dello storico.</p>
     *
     * <p><strong>PT-BR:</strong> Limpa todos os campos de entrada no formulário de histórico.</p>
     *
     * @since 1.0.0
     */    
    private void limpaCampos(){
        jCBPresserv.setSelectedIndex(0);
        jCBTipo.setSelectedIndex(0);
        jFTFDataHistorico.setText(null);
        jTFDescricao.setText(null);
    }
    
    /**
     * <p><strong>EN:</strong> Validates the input fields in the history form before saving or updating a record.</p>
     *
     * <p><strong>IT:</strong> Convalida i campi di input nel modulo dello storico prima di salvare o aggiornare un record.</p>
     *
     * <p><strong>PT-BR:</strong> Valida os campos de entrada no formulário de histórico antes de salvar ou atualizar um registro.</p>
     *
     * @return EN: true if all fields are valid, false otherwise | IT: true se tutti i campi sono validi, false altrimenti | PT-BR: true se todos os campos forem válidos, false caso contrário
     * @since 1.0.0
     */    
    private boolean validaCampos(){
        if(animal == null){
            JOptionPane.showMessageDialog(null, "Selecione o animal.", "Animal", JOptionPane.INFORMATION_MESSAGE);
            jCBAnimal.requestFocus();
            return false;
        }
        if(util.validaDataCampo(jFTFDataHistorico.getText()) == false){
            jFTFDataHistorico.requestFocus();
            return false;
        }
        if(jTFDescricao.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo em branco.", "Animal", JOptionPane.INFORMATION_MESSAGE);
            jTFDescricao.requestFocus();
            return false;
        }
        return true;
    }

    /**
     * <p><strong>EN:</strong> Saves or updates a history record (Historico) based on the current form data.  
     * If no history exists, a new record is created; otherwise, the existing record is updated.</p>
     *
     * <p><strong>IT:</strong> Salva o aggiorna un record di storico (Historico) in base ai dati attuali del modulo.  
     * Se non esiste uno storico, viene creato un nuovo record; altrimenti, il record esistente viene aggiornato.</p>
     *
     * <p><strong>PT-BR:</strong> Salva ou atualiza um registro de histórico (Historico) com base nos dados atuais do formulário.  
     * Se não houver histórico, um novo registro é criado; caso contrário, o registro existente é atualizado.</p>
     *
     * @since 1.0.0
     */    
    private void salvar(){
        if(historico == null){
            historico = new Historico();
            historico.setAnimal(animal);
            historico.setEmpresa(empresa);
            historico.setTipo(tipo);
            historico.setDt_historico(util.recebeData(jFTFDataHistorico.getText()));
            historico.setDs_historico(jTFDescricao.getText());
            historico.setCd_usuario(JPLogin.codloginuser);
            historicor.inserir(historico);
            historico = null;
        }else{
            historico.setEmpresa(empresa);
            historico.setTipo(tipo);
            historico.setDt_historico(util.recebeData(jFTFDataHistorico.getText()));
            historico.setDs_historico(jTFDescricao.getText());
            historico.setCd_usuario(JPLogin.codloginuser);
            historicor.alterar(historico);
            historico = null;
        }
    }
    
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifhistorico = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if(validaCampos()){
            salvar();
            limpaCampos();
            tabelaHistorico();
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jCBAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBAnimalActionPerformed
        if(jCBAnimal.getSelectedIndex() != 0){
            animal = (Animal)jCBAnimal.getSelectedItem();
            tabelaHistorico();            
        }else{
            animal = null;
        }
    }//GEN-LAST:event_jCBAnimalActionPerformed

    private void jCBPresservActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBPresservActionPerformed
        if(jCBPresserv.getSelectedIndex() != 0){
            empresa = (Empresa)jCBPresserv.getSelectedItem();            
        }else{
            empresa = new Empresa();
        }
    }//GEN-LAST:event_jCBPresservActionPerformed

    private void jCBTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBTipoActionPerformed
        if(jCBTipo.getSelectedIndex() != 0){
            tipo = (Tipo)jCBTipo.getSelectedItem();            
        }else{
            tipo = null;
        }
    }//GEN-LAST:event_jCBTipoActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        if((Historico)historicou.getSelectObject(jTHistorico) != null){
            historicor.excluir(historico);
            limpaCampos();
            tabelaHistorico();
        }
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jTHistoricoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTHistoricoMouseClicked
        historico = (Historico)historicou.getSelectObject(jTHistorico);
        if(historico.getEmpresa()== null){
            jCBPresserv.setSelectedIndex(0);
        }else{
            jCBPresserv.getModel().setSelectedItem(historico.getEmpresa());            
        }
        jCBTipo.getModel().setSelectedItem(historico.getTipo());
        jFTFDataHistorico.setText(Utilidade.formatoData.format(historico.getDt_historico().getTime()));
        jTFDescricao.setText(historico.getDs_historico());
    }//GEN-LAST:event_jTHistoricoMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<String> jCBAnimal;
    private javax.swing.JComboBox<Empresa> jCBPresserv;
    private javax.swing.JComboBox<String> jCBTipo;
    private javax.swing.JFormattedTextField jFTFDataHistorico;
    private javax.swing.JLabel jLData;
    private javax.swing.JLabel jLDescricao;
    private javax.swing.JLabel jLTipo;
    private javax.swing.JPanel jPBotoes;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JPanel jPCamposHistorico;
    private javax.swing.JPanel jPGrid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFDescricao;
    private javax.swing.JTable jTHistorico;
    // End of variables declaration//GEN-END:variables
}
