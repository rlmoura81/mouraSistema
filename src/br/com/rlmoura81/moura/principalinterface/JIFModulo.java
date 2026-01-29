package br.com.rlmoura81.moura.principalinterface;

import br.com.rlmoura81.moura.principal.Modulo;
import br.com.rlmoura81.moura.principal.ModuloAplicativo;
import br.com.rlmoura81.moura.principal.ModuloAplicativoRepository;
import br.com.rlmoura81.moura.principal.ModuloAplicativoUtil;
import br.com.rlmoura81.moura.principal.ModuloUtil;
import br.com.rlmoura81.moura.principalcadastro.Categoria;
import br.com.rlmoura81.moura.principalcadastro.CategoriaUtil;
import br.com.rlmoura81.moura.principalcadastro.Empresa;
import br.com.rlmoura81.moura.principalcadastro.EmpresaUtil;
import javax.swing.JOptionPane;

public class JIFModulo extends javax.swing.JInternalFrame {
    
    private static JIFModulo jifmodulo;
    
    /**
     * <p><strong>EN:</strong> Provides a singleton instance of 
     * <code>JIFModulo</code>.  
     * Creates the internal frame if it does not exist and sets 
     * its title to <em>"Módulos."</em>.</p>
     *
     * <p><strong>IT:</strong> Restituisce un'istanza singleton di 
     * <code>JIFModulo</code>.  
     * Crea il frame interno se non esiste e imposta il titolo 
     * su <em>"Módulos."</em>.</p>
     *
     * <p><strong>PT-BR:</strong> Retorna uma instância singleton de 
     * <code>JIFModulo</code>.  
     * Cria o frame interno caso não exista e define o título como 
     * <em>"Módulos."</em>.</p>
     */
    public static JIFModulo getInstancia(){
        if(jifmodulo == null){
            jifmodulo = new JIFModulo();
            jifmodulo.setTitle("Módulos.");
        }return jifmodulo;
    }
    
    Modulo modulo = new Modulo();
    ModuloUtil modulou = new ModuloUtil();    
    ModuloAplicativo modapp = new ModuloAplicativo();
    ModuloAplicativoRepository modappr = new ModuloAplicativoRepository();
    ModuloAplicativoUtil modappu = new ModuloAplicativoUtil();    
    Categoria categoria = new Categoria();
    CategoriaUtil categoriau = new CategoriaUtil();    
    Empresa empresa = new Empresa();
    EmpresaUtil empresau = new EmpresaUtil();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bGModulo = new javax.swing.ButtonGroup();
        jPCampos = new javax.swing.JPanel();
        jCBModuloApp = new javax.swing.JComboBox();
        jBSalvar = new javax.swing.JButton();
        jCBModulo = new javax.swing.JComboBox<>();
        jBExcluir = new javax.swing.JButton();
        jPGrid = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTModulo = new javax.swing.JTable();
        jPBotoes = new javax.swing.JPanel();
        jRBCategoria = new javax.swing.JRadioButton();
        jRBEmpresa = new javax.swing.JRadioButton();

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

        jCBModuloApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBModuloAppActionPerformed(evt);
            }
        });

        jBSalvar.setText("Salvar");
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });

        jCBModulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBModuloActionPerformed(evt);
            }
        });

        jBExcluir.setText("Excluir");
        jBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPCamposLayout = new javax.swing.GroupLayout(jPCampos);
        jPCampos.setLayout(jPCamposLayout);
        jPCamposLayout.setHorizontalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCBModuloApp, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCBModulo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBExcluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPCamposLayout.setVerticalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBModuloApp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBSalvar)
                    .addComponent(jCBModulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPGrid.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTModulo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTModulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTModuloMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTModulo);

        javax.swing.GroupLayout jPGridLayout = new javax.swing.GroupLayout(jPGrid);
        jPGrid.setLayout(jPGridLayout);
        jPGridLayout.setHorizontalGroup(
            jPGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPGridLayout.setVerticalGroup(
            jPGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPBotoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bGModulo.add(jRBCategoria);
        jRBCategoria.setText("Categoria");
        jRBCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRBCategoriaMouseClicked(evt);
            }
        });

        bGModulo.add(jRBEmpresa);
        jRBEmpresa.setText("Empresa");
        jRBEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRBEmpresaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPBotoesLayout = new javax.swing.GroupLayout(jPBotoes);
        jPBotoes.setLayout(jPBotoesLayout);
        jPBotoesLayout.setHorizontalGroup(
            jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRBCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRBEmpresa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPBotoesLayout.setVerticalGroup(
            jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBCategoria)
                    .addComponent(jRBEmpresa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     public JIFModulo() {
        initComponents();
        
        jcModulo();
    }
    
     /**
     * <p><strong>EN:</strong> Populates the module combo box 
     * with available modules.</p>
     *
     * <p><strong>IT:</strong> Popola la casella combinata dei moduli 
     * con i moduli disponibili.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche o combo box de módulos 
     * com os módulos disponíveis.</p>
     */
    private void jcModulo(){
        modulou.jcModulo(jCBModulo);
    }
    
    /**
     * <p><strong>EN:</strong> Populates the combo box with categories 
     * from the database.</p>
     *
     * <p><strong>IT:</strong> Popola la casella combinata con le categorie 
     * dal database.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche o combo box com categorias 
     * vindas do banco de dados.</p>
     */
    private void jcCategoria(){
        categoriau.jcCategoria(jCBModuloApp);
    }
    
    /**
     * <p><strong>EN:</strong> Populates the combo box with service providers 
     * from the database.</p>
     *
     * <p><strong>IT:</strong> Popola la casella combinata con i prestatori di servizio 
     * dal database.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche o combo box com prestadores de serviço 
     * do banco de dados.</p>
     */
    private void jcEmpresa(){
        empresau.jcEmpresa(jCBModuloApp);
    }
    
    /**
     * <p><strong>EN:</strong> Updates the module-app combo box and 
     * refreshes the table depending on whether "Category" 
     * or "Service Provider" is selected.</p>
     *
     * <p><strong>IT:</strong> Aggiorna la casella combinata dei moduli-app 
     * e ricarica la tabella a seconda se è selezionata "Categoria" 
     * o "Prestatore di Servizio".</p>
     *
     * <p><strong>PT-BR:</strong> Atualiza o combo box de módulo-app 
     * e recarrega a tabela conforme a seleção de "Categoria" 
     * ou "Prestador de Serviço".</p>
     */
    private void jcModApp(){
        jCBModuloApp.removeAllItems();
        if(jRBCategoria.isSelected() == true){
            jcCategoria();
            modappu.tabelaModuloAppCategoria(jTModulo);            
        }
        if(jRBEmpresa.isSelected() == true){
            jcEmpresa();
            modappu.tabelaModuloAppEmpresa(jTModulo);            
        }
    }
    
    /**
     * <p><strong>EN:</strong> Validates that a module-app option 
     * and a module are selected before proceeding.</p>
     *
     * <p><strong>IT:</strong> Valida che siano selezionati un'opzione modulo-app 
     * e un modulo prima di continuare.</p>
     *
     * <p><strong>PT-BR:</strong> Valida se uma opção de módulo-app 
     * e um módulo foram selecionados antes de prosseguir.</p>
     */
    private boolean validaCampos(){
        if(jCBModuloApp.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Selecione uma opção.", "Modulo", JOptionPane.INFORMATION_MESSAGE);
            jCBModuloApp.requestFocus();
            return false;
        }
        if(jCBModulo.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Selecione um módulo.", "Modulo", JOptionPane.INFORMATION_MESSAGE);
            jCBModulo.requestFocus();
            return false;
        }
        return true;
    }
    
    /**
     * <p><strong>EN:</strong> Clears the form fields, resets 
     * the module-app combo box and radio button selections.</p>
     *
     * <p><strong>IT:</strong> Pulisce i campi del modulo, reimposta 
     * la casella combinata modulo-app e le selezioni dei pulsanti radio.</p>
     *
     * <p><strong>PT-BR:</strong> Limpa os campos do formulário, 
     * reseta o combo box de módulo-app e as seleções dos botões de opção.</p>
     */
    private void limpaCampos(){
        jCBModuloApp.setSelectedIndex(0);
        jCBModulo.setSelectedIndex(0);
    }
    
    /**
     * <p><strong>EN:</strong> Saves the selected relation.  
     * If "Category" is selected, links the category to the module.  
     * If "Service Provider" is selected, links the provider to the module.  
     * Updates the corresponding table afterwards.</p>
     *
     * <p><strong>IT:</strong> Salva la relazione selezionata.  
     * Se è selezionata "Categoria", associa la categoria al modulo.  
     * Se è selezionato "Prestatore di Servizio", associa il prestatore al modulo.  
     * Successivamente aggiorna la tabella corrispondente.</p>
     *
     * <p><strong>PT-BR:</strong> Salva a relação selecionada.  
     * Se "Categoria" estiver selecionado, vincula a categoria ao módulo.  
     * Se "Prestador de Serviço" estiver selecionado, vincula o prestador ao módulo.  
     * Em seguida, atualiza a tabela correspondente.</p>
     */
    private void salvar(){
        modapp.setCd_usuario(JPLogin.codloginuser);        
        if(jRBCategoria.isSelected()){
            modapp.setCategoria(categoria);
            modapp.setModulo(modulo);
            modappr.inserirCatMod(modapp);
            modappu.tabelaModuloAppCategoria(jTModulo);
        }
        if(jRBEmpresa.isSelected()){
            modapp.setEmpresa(empresa);
            modapp.setModulo(modulo);
            modappr.inserirEmpresaMod(modapp);
            modappu.tabelaModuloAppEmpresa(jTModulo);
        }
    }
    
    private void jRBCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRBCategoriaMouseClicked
        jcModApp();
    }//GEN-LAST:event_jRBCategoriaMouseClicked

    private void jRBEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRBEmpresaMouseClicked
        jcModApp();
    }//GEN-LAST:event_jRBEmpresaMouseClicked

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if(validaCampos()){
            salvar();
            limpaCampos();
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifmodulo = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jCBModuloAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBModuloAppActionPerformed
        try{
            categoria = (Categoria)jCBModuloApp.getSelectedItem();
        }catch(Exception ex){
            
        }
        try{
            empresa = (Empresa)jCBModuloApp.getSelectedItem();
        }catch(Exception ex){
            
        }
    }//GEN-LAST:event_jCBModuloAppActionPerformed

    private void jCBModuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBModuloActionPerformed
        if(jCBModulo.getSelectedIndex() != 0){
            modulo = (Modulo)jCBModulo.getSelectedItem();
        }else{
            modulo = null;
        }
    }//GEN-LAST:event_jCBModuloActionPerformed

    private void jTModuloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTModuloMouseClicked
        modapp = (ModuloAplicativo)modappu.getSelectObject(jTModulo);
        if(jRBCategoria.isSelected() == true){
            jCBModuloApp.getModel().setSelectedItem(modapp.getCategoria());
        }
        if(jRBEmpresa.isSelected() == true){
            jCBModuloApp.getModel().setSelectedItem(modapp.getEmpresa());
        }
        jCBModulo.getModel().setSelectedItem(modapp.getModulo());
    }//GEN-LAST:event_jTModuloMouseClicked

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        if(modapp != null){
            if(jRBCategoria.isSelected()){
                modapp.setCategoria(categoria);
                modapp.setModulo(modulo);
                modappr.deleteCatMod(modapp);
                modappu.tabelaModuloAppCategoria(jTModulo);
            }
            if(jRBEmpresa.isSelected()){
                modapp.setEmpresa(empresa);
                modapp.setModulo(modulo);
                modappr.deleteEmpresaMod(modapp);
                modappu.tabelaModuloAppEmpresa(jTModulo);
            }
        }
    }//GEN-LAST:event_jBExcluirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bGModulo;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<String> jCBModulo;
    private javax.swing.JComboBox jCBModuloApp;
    private javax.swing.JPanel jPBotoes;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JPanel jPGrid;
    private javax.swing.JRadioButton jRBCategoria;
    private javax.swing.JRadioButton jRBEmpresa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTModulo;
    // End of variables declaration//GEN-END:variables
}
