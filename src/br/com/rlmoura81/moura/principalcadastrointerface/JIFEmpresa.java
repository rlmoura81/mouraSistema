package br.com.rlmoura81.moura.principalcadastrointerface;

import br.com.rlmoura81.moura.principalcadastro.Empresa;
import br.com.rlmoura81.moura.principalcadastro.EmpresaRepository;
import br.com.rlmoura81.moura.principalcadastro.EmpresaUtil;
import br.com.rlmoura81.moura.principalcadastro.TipoEmpresa;
import br.com.rlmoura81.moura.principalcadastro.TipoEmpresaUtil;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class JIFEmpresa extends javax.swing.JInternalFrame {
    
    private static JIFEmpresa jifempresa;

    /**
     * <p><strong>EN:</strong> Returns the singleton instance of the 
     * Prestador de Serviço internal frame.  
     * If it does not exist, it creates the instance, sets the title, 
     * and attempts to maximize the window.  
     * Handles exceptions by displaying an error message and logging the issue.</p>
     *
     * <p><strong>IT:</strong> Restituisce l’istanza singleton della 
     * finestra interna Prestador de Serviço.  
     * Se non esiste, crea l’istanza, imposta il titolo e prova a massimizzare la finestra.  
     * Gestisce le eccezioni mostrando un messaggio di errore e registrando il problema.</p>
     *
     * <p><strong>PT-BR:</strong> Retorna a instância singleton da 
     * janela interna Prestador de Serviço.  
     * Caso não exista, cria a instância, define o título e tenta maximizar a janela.  
     * Trata exceções exibindo uma mensagem de erro e registrando o problema.</p>
     */
    public static JIFEmpresa getInstancia(){
        if(jifempresa == null){
            jifempresa = new JIFEmpresa();
            jifempresa.setTitle("Empresa");
            try {
                jifempresa.setMaximum(true);
            } catch (PropertyVetoException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao abrir:\n" + ex.getMessage(), "Empresa", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(JIFEmpresa.class.getName()).log(Level.SEVERE, null, ex);
            }
        } return jifempresa;
    }
    
    Empresa empresa = null;
    EmpresaRepository empresar = new EmpresaRepository();
    EmpresaUtil empresau = new EmpresaUtil();    
    TipoEmpresa tpempresa = new TipoEmpresa();
    TipoEmpresaUtil tpempresau = new TipoEmpresaUtil();
    Utilidade util = new Utilidade();
        
    public JIFEmpresa() {
        initComponents();

        jcTipoEmpresa();
        tabelaEmpresa();        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bGModulo = new javax.swing.ButtonGroup();
        jPBotoes = new javax.swing.JPanel();
        jBSalvar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jPCampos = new javax.swing.JPanel();
        jLDocumento = new javax.swing.JLabel();
        jLRazaoSocial = new javax.swing.JLabel();
        jTFRazaoSocial = new javax.swing.JTextField();
        jLEmpresa = new javax.swing.JLabel();
        jTFEmpresa = new javax.swing.JTextField();
        jFTFDocumento = new javax.swing.JFormattedTextField();
        jCBTpEmpresa = new javax.swing.JComboBox<>();
        jPGrid = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTEmpresa = new javax.swing.JTable();

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

        jPCampos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLDocumento.setText("Documento:");

        jLRazaoSocial.setText("Razao Social:");

        jLEmpresa.setText("Nome/NomeFantasia:");

        jFTFDocumento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFTFDocumentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFTFDocumentoFocusLost(evt);
            }
        });

        jCBTpEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBTpEmpresaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPCamposLayout = new javax.swing.GroupLayout(jPCampos);
        jPCampos.setLayout(jPCamposLayout);
        jPCamposLayout.setHorizontalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLEmpresa)
                    .addComponent(jTFEmpresa)
                    .addComponent(jLRazaoSocial)
                    .addComponent(jTFRazaoSocial)
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addComponent(jLDocumento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFTFDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCBTpEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPCamposLayout.setVerticalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLDocumento)
                    .addComponent(jFTFDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBTpEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLEmpresa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLRazaoSocial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPGrid.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTEmpresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTEmpresaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTEmpresa);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
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
                    .addComponent(jPBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jPBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
    *EM TESTE - COLOCAR COMENTARIO
    *CARREGA A JCOMBOBOX COM A LISTA DE TIPO DE EMPRSA
    */
    private void jcTipoEmpresa(){
        tpempresau.jcTpEmpresa(jCBTpEmpresa);
    }
    /**
     * <p><strong>EN:</strong> Loads and displays the Service Providers list into the JTable.
     * Populates the table with name, company name, and document.</p>
     *
     * <p><strong>IT:</strong> Carica e visualizza l’elenco dei Fornitori di Servizi nella JTable.
     * Popola la tabella con nome, ragione sociale e documento.</p>
     *
     * <p><strong>PT-BR:</strong> Carrega e exibe a lista de Prestadores de Serviço no JTable.
     * Preenche a tabela com nome, razão social e documento.</p>
     */
    private void tabelaEmpresa(){
        empresau.tabelaEmpresa(jTEmpresa);
    }
    
    /**
     * <p><strong>EN:</strong> Validates mandatory fields for a Service Provider form.
     * Ensures that the document and provider name are not empty.</p>
     *
     * <p><strong>IT:</strong> Valida i campi obbligatori del modulo Fornitore di Servizi.
     * Verifica che il documento e il nome del fornitore non siano vuoti.</p>
     *
     * <p><strong>PT-BR:</strong> Valida os campos obrigatórios do formulário de Prestador de Serviço.
     * Garante que o documento e o nome do prestador não estejam em branco.</p>
     */
    private boolean validaCampos(){
        if(jFTFDocumento.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo em branco.", "Empresa", JOptionPane.INFORMATION_MESSAGE);
            jFTFDocumento.requestFocus();
            return false;
        }
        if(tpempresa == null){
            JOptionPane.showMessageDialog(null, "Selecione o tipo de empresa.", "Empresa", JOptionPane.INFORMATION_MESSAGE);
            jCBTpEmpresa.requestFocus();
            return false;            
        }
        if(jTFEmpresa.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo em branco.", "Empresa", JOptionPane.INFORMATION_MESSAGE);
            jTFEmpresa.requestFocus();
            return false;
        }
        return true;
    }
    
    /**
     * <p><strong>EN:</strong> Clears all input fields in the Service Provider form,
     * resetting the document, provider name, and company name.</p>
     *
     * <p><strong>IT:</strong> Pulisce tutti i campi di input del modulo Fornitore di Servizi,
     * reimpostando documento, nome del fornitore e ragione sociale.</p>
     *
     * <p><strong>PT-BR:</strong> Limpa todos os campos do formulário de Prestador de Serviço,
     * resetando documento, nome do prestador e razão social.</p>
     */
    private void limpaCampos(){
        jFTFDocumento.setText(null);
        jFTFDocumento.setValue(null);
        jCBTpEmpresa.setSelectedIndex(0);
        jTFEmpresa.setText(null);
        jTFRazaoSocial.setText(null);
    }
    
    /**
     * <p><strong>EN:</strong> Saves the Service Provider data.
     * If the object is new, it inserts it; otherwise, it updates the existing record.</p>
     *
     * <p><strong>IT:</strong> Salva i dati del Fornitore di Servizi.
     * Se l’oggetto è nuovo, lo inserisce; altrimenti aggiorna il record esistente.</p>
     *
     * <p><strong>PT-BR:</strong> Salva os dados do Prestador de Serviço.
     * Caso seja um novo objeto, insere; caso contrário, atualiza o registro existente.</p>
     */
    private void salvar(){
        if(empresa == null){
            empresa = new Empresa();
            empresa.setNm_documento(Utilidade.retiraMascaraDocumento(jFTFDocumento.getText()));
            empresa.setTpEmpresa(tpempresa);
            empresa.setDs_empresa(jTFEmpresa.getText());
            empresa.setDs_razaosocial(jTFRazaoSocial.getText());
            empresa.setCd_usuario(JPLogin.codloginuser);
            empresar.inserir(empresa);
        }else{
            empresa.setNm_documento(Utilidade.retiraMascaraDocumento(jFTFDocumento.getText()));
            empresa.setTpEmpresa(tpempresa);
            empresa.setDs_empresa(jTFEmpresa.getText());
            empresa.setDs_razaosocial(jTFRazaoSocial.getText());
            empresa.setCd_usuario(JPLogin.codloginuser);
            empresar.alterar(empresa);
        }         
    }
    
    /**
     * <p><strong>EN:</strong> Deletes the selected Service Provider
     * from the database based on its unique identifier.</p>
     *
     * <p><strong>IT:</strong> Elimina il Fornitore di Servizi selezionato
     * dal database in base al suo identificativo univoco.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui o Prestador de Serviço selecionado
     * do banco de dados com base em seu identificador único.</p>
     */
    private void excluir(){
        empresa.setCd_empresa(empresa.getCd_empresa());
        empresar.excluir(empresa);
        empresa = null;
    }
    
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifempresa = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if(validaCampos()){
            salvar();
            limpaCampos();
            tabelaEmpresa();
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jTEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTEmpresaMouseClicked
        empresa = (Empresa)empresau.getSelectObject(jTEmpresa);        
        jFTFDocumento.setValue(Utilidade.retornaDocumentoFormatado(empresa.getNm_documento(), empresa.getNm_documento().length()));    
        jCBTpEmpresa.getModel().setSelectedItem(empresa.getTpEmpresa());
        jTFEmpresa.setText(empresa.getDs_empresa());
        jTFRazaoSocial.setText(empresa.getDs_razaosocial());
    }//GEN-LAST:event_jTEmpresaMouseClicked
    
    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        empresa = (Empresa)empresau.getSelectObject(jTEmpresa);
        if(empresa != null){
            excluir();
            limpaCampos();
            tabelaEmpresa();
        }
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jFTFDocumentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTFDocumentoFocusLost
        if(!jFTFDocumento.getText().isEmpty()){
            String documento = Utilidade.retiraMascaraDocumento(jFTFDocumento.getText());
            if(util.validaDocumento(documento) == true){
                util.formataDocumento(jFTFDocumento, jFTFDocumento.getText().length());
                jFTFDocumento.setText(documento);                
            }else{
                JOptionPane.showMessageDialog(null, "Documento inválido.", "Empresa", JOptionPane.INFORMATION_MESSAGE);
                jFTFDocumento.requestFocus();
            }            
        }
    }//GEN-LAST:event_jFTFDocumentoFocusLost

    private void jCBTpEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBTpEmpresaActionPerformed
        if(jCBTpEmpresa.getSelectedIndex() != 0){
            tpempresa = (TipoEmpresa)jCBTpEmpresa.getSelectedItem();
        }else{
            tpempresa = null;
        }
    }//GEN-LAST:event_jCBTpEmpresaActionPerformed

    private void jFTFDocumentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTFDocumentoFocusGained
        util.posicionaCursorjFTFDocumento(jFTFDocumento);
    }//GEN-LAST:event_jFTFDocumentoFocusGained
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bGModulo;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<TipoEmpresa> jCBTpEmpresa;
    private javax.swing.JFormattedTextField jFTFDocumento;
    private javax.swing.JLabel jLDocumento;
    private javax.swing.JLabel jLEmpresa;
    private javax.swing.JLabel jLRazaoSocial;
    private javax.swing.JPanel jPBotoes;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JPanel jPGrid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTEmpresa;
    private javax.swing.JTextField jTFEmpresa;
    private javax.swing.JTextField jTFRazaoSocial;
    // End of variables declaration//GEN-END:variables
}
