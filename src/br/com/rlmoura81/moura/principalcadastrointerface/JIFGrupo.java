package br.com.rlmoura81.moura.principalcadastrointerface;

import br.com.rlmoura81.moura.principalcadastro.Grupo;
import br.com.rlmoura81.moura.principalcadastro.GrupoRepository;
import br.com.rlmoura81.moura.principalcadastro.GrupoUtil;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import javax.swing.JOptionPane;

public class JIFGrupo extends javax.swing.JInternalFrame {
    
    private static JIFGrupo jifgrupo;
    
    /**
     * <p><strong>EN:</strong> Provides a singleton instance of the Group window.  
     * If no instance exists, it creates a new one and sets its title to "Group".</p>
     *
     * <p><strong>IT:</strong> Restituisce un’istanza singleton della finestra Gruppo.  
     * Se non esiste alcuna istanza, ne crea una nuova e imposta il titolo su "Gruppo".</p>
     *
     * <p><strong>PT-BR:</strong> Retorna uma instância única da janela Grupo.  
     * Caso ainda não exista, cria uma nova e define o título como "Grupo".</p>
     */
    public static JIFGrupo getInstancia(){
        if (jifgrupo == null){
            jifgrupo = new JIFGrupo();
            jifgrupo.setTitle("Grupo");
        } return jifgrupo;
    }
    
    Grupo grupo = null;
    GrupoRepository grupor = new GrupoRepository();
    GrupoUtil grupou = new GrupoUtil();
        
    public JIFGrupo() {
        initComponents();

        jTFGrupo.requestFocus();       
        tabelaCategoria();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPCampos = new javax.swing.JPanel();
        jLGrupo = new javax.swing.JLabel();
        jTFGrupo = new javax.swing.JTextField();
        jBSalvar = new javax.swing.JButton();
        jBAlterar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jPGrid = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTGrupo = new javax.swing.JTable();

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

        jLGrupo.setText("Descrição do Grupo:");

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

        javax.swing.GroupLayout jPCamposLayout = new javax.swing.GroupLayout(jPCampos);
        jPCampos.setLayout(jPCamposLayout);
        jPCamposLayout.setHorizontalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTFGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLGrupo)
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addComponent(jBSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBExcluir)))
                .addContainerGap(208, Short.MAX_VALUE))
        );
        jPCamposLayout.setVerticalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLGrupo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalvar)
                    .addComponent(jBAlterar)
                    .addComponent(jBExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPGrid.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTGrupo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTGrupo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTGrupoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTGrupo);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
     * <p><strong>EN:</strong> Clears all fields of the Group form.  
     * Resets the input and places focus back on the text field.</p>
     *
     * <p><strong>IT:</strong> Pulisce tutti i campi del modulo Gruppo.  
     * Reimposta l’input e riporta il focus sul campo di testo.</p>
     *
     * <p><strong>PT-BR:</strong> Limpa todos os campos do formulário de Grupo.  
     * Restaura o campo vazio e retorna o foco para o campo de texto.</p>
     */
    private void limpaCampos(){
        jTFGrupo.setText(null);
        jTFGrupo.requestFocus();
    }
    
    /**
     * <p><strong>EN:</strong> Validates Group form fields.  
     * Ensures that the text field is not empty before proceeding.</p>
     *
     * <p><strong>IT:</strong> Valida i campi del modulo Gruppo.  
     * Verifica che il campo di testo non sia vuoto prima di procedere.</p>
     *
     * <p><strong>PT-BR:</strong> Valida os campos do formulário de Grupo.  
     * Garante que o campo de texto não esteja vazio antes de continuar.</p>
     */
    public boolean validaCampos(){
        if (jTFGrupo.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Campo em branco.", "Grupo", JOptionPane.INFORMATION_MESSAGE);
                jTFGrupo.requestFocus();
            return false;
        }
        return true;
    }
    
    /**
     * <p><strong>EN:</strong> Loads and displays the list of Groups in the table.  
     * Delegates rendering to the Group utility class.</p>
     *
     * <p><strong>IT:</strong> Carica e mostra l’elenco dei Gruppi nella tabella.  
     * Delega il rendering alla classe di utilità Gruppo.</p>
     *
     * <p><strong>PT-BR:</strong> Carrega e exibe a lista de Grupos na tabela.  
     * Delega a renderização para a classe utilitária de Grupo.</p>
     */
    private void tabelaCategoria() {
        grupou.tabelaGrupo(jTGrupo);
    }    
    
    /**
     * <p><strong>EN:</strong> Saves a new Group in the database.  
     * Captures data from the form, associates the current user, and persists the record.</p>
     *
     * <p><strong>IT:</strong> Salva un nuovo Gruppo nel database.  
     * Recupera i dati dal modulo, associa l’utente corrente e registra il record.</p>
     *
     * <p><strong>PT-BR:</strong> Salva um novo Grupo no banco de dados.  
     * Captura os dados do formulário, associa ao usuário atual e persiste o registro.</p>
     */
    private void salvar(){
        grupo.setDs_grupo(jTFGrupo.getText());
        grupo.setCd_usuario(JPLogin.codloginuser);
        grupor.inserir(grupo);     
        grupo = null;
    }
    
    /**
     * <p><strong>EN:</strong> Updates an existing Group in the database.  
     * Applies the new field values and saves the changes.</p>
     *
     * <p><strong>IT:</strong> Aggiorna un Gruppo esistente nel database.  
     * Applica i nuovi valori dei campi e salva le modifiche.</p>
     *
     * <p><strong>PT-BR:</strong> Altera um Grupo existente no banco de dados.  
     * Aplica os novos valores dos campos e salva as alterações.</p>
     */
    private void alterar(){
        grupo.setDs_grupo(jTFGrupo.getText());
        grupo.setCd_usuario(JPLogin.codloginuser);
        grupor.aterar(grupo);
        grupo = null;
    }
    
    /**
     * <p><strong>EN:</strong> Deletes the selected Group from the database.  
     * Uses the current Group identifier to remove the record permanently.</p>
     *
     * <p><strong>IT:</strong> Elimina il Gruppo selezionato dal database.  
     * Utilizza l’identificatore del Gruppo corrente per rimuovere definitivamente il record.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui o Grupo selecionado do banco de dados.  
     * Usa o identificador do Grupo atual para remover o registro de forma permanente.</p>
     */
    private void excluir(){
        grupo.setCd_grupo(grupo.getCd_grupo());
        grupor.excluir(grupo);
        grupo = null;        
    }
    
    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if (validaCampos()) {
            salvar();
            limpaCampos();
            tabelaCategoria();
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jTGrupoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTGrupoMouseClicked
        grupo = (Grupo)grupou.getSelectObject(jTGrupo);
        jTFGrupo.setText(grupo.getDs_grupo()); 
    }//GEN-LAST:event_jTGrupoMouseClicked
    
    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        grupo = (Grupo)grupou.getSelectObject(jTGrupo);
        if(grupo != null){
            alterar();
            limpaCampos();
            tabelaCategoria();
        }     
    }//GEN-LAST:event_jBAlterarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        grupo = (Grupo)grupou.getSelectObject(jTGrupo);
        if(grupo != null){
            excluir();
            limpaCampos();
            tabelaCategoria();
        }
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifgrupo = null;
    }//GEN-LAST:event_formInternalFrameClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JLabel jLGrupo;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JPanel jPGrid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFGrupo;
    private javax.swing.JTable jTGrupo;
    // End of variables declaration//GEN-END:variables
}
