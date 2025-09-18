package br.com.rlmoura81.moura.catalogointerface;

import br.com.rlmoura81.moura.catalogo.CatalogoUtil;
import br.com.rlmoura81.moura.catalogo.Editora;
import br.com.rlmoura81.moura.catalogo.EditoraRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import javax.swing.JOptionPane;

public class JIFEditora extends javax.swing.JInternalFrame {
    
    private static JIFEditora jifeditora;
    
    /**
     * <p><strong>EN:</strong> Returns the single instance of {@link JIFEditora}.  
     * If the instance does not exist, it creates a new one, sets its title, 
     * and returns it (Singleton pattern for internal frames).</p>
     *
     * <p><strong>IT:</strong> Restituisce l'unica istanza di {@link JIFEditora}.  
     * Se l'istanza non esiste, ne crea una nuova, imposta il titolo 
     * e la restituisce (pattern Singleton per internal frame).</p>
     *
     * <p><strong>PT-BR:</strong> Retorna a única instância de {@link JIFEditora}.  
     * Se a instância não existir, cria uma nova, define o título 
     * e a retorna (padrão Singleton para internal frames).</p>
     */  
    public static JIFEditora getInstacia(){
        if(jifeditora == null){
            jifeditora = new JIFEditora();
            jifeditora.setTitle("Editora");
        } return jifeditora;        
    }

    Editora editora = new Editora();
    EditoraRepository editorar = new EditoraRepository();    
    CatalogoUtil catalogou = new CatalogoUtil();    
    
    public JIFEditora() {
        initComponents();
        
        desativaBotoes();
        catalogou.tabelaEditora(jTEditora);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPGrid = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTEditora = new javax.swing.JTable();
        jPCampos = new javax.swing.JPanel();
        jLNome = new javax.swing.JLabel();
        jTFNome = new javax.swing.JTextField();
        jBSalvar = new javax.swing.JButton();
        jBAlterar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();

        setClosable(true);
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

        jPGrid.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTEditora.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTEditora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTEditoraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTEditora);

        javax.swing.GroupLayout jPGridLayout = new javax.swing.GroupLayout(jPGrid);
        jPGrid.setLayout(jPGridLayout);
        jPGridLayout.setHorizontalGroup(
            jPGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPGridLayout.setVerticalGroup(
            jPGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPCampos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLNome.setText("Nome:");

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
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addComponent(jLNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFNome))
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addComponent(jBSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBExcluir)))
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
                    .addComponent(jBSalvar)
                    .addComponent(jBAlterar)
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
                    .addComponent(jPCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPGrid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPGrid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * <p><strong>EN:</strong> Disables the "Update" and "Delete" buttons.</p>
     * <p><strong>IT:</strong> Disattiva i pulsanti "Modifica" e "Elimina".</p>
     * <p><strong>PT-BR:</strong> Desativa os botões "Alterar" e "Excluir".</p>
     */    
    private void desativaBotoes(){
        jBAlterar.setEnabled(false);
        jBExcluir.setEnabled(false);
    }
    
    /**
     * <p><strong>EN:</strong> Enables the "Update" and "Delete" buttons.</p>
     * <p><strong>IT:</strong> Attiva i pulsanti "Modifica" e "Elimina".</p>
     * <p><strong>PT-BR:</strong> Ativa os botões "Alterar" e "Excluir".</p>
     */
    private void ativaBotoes(){
        jBAlterar.setEnabled(true);
        jBExcluir.setEnabled(true);
    }
 
    /**
     * <p><strong>EN:</strong> Validates the "name" field of the publisher form.  
     * If it is empty, shows a warning message and requests focus.</p>
     *
     * <p><strong>IT:</strong> Valida il campo "nome" del modulo dell'editore.  
     * Se è vuoto, mostra un messaggio di avviso e richiede il focus.</p>
     *
     * <p><strong>PT-BR:</strong> Valida o campo "nome" do formulário da editora.  
     * Se estiver vazio, exibe uma mensagem de aviso e solicita o foco.</p>
     *
     * @return true if the field is valid, false otherwise.
     */
    private boolean validaCampo(){
        if(jTFNome.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Digite o nome da editora.", "Editora", JOptionPane.INFORMATION_MESSAGE);
            jTFNome.requestFocus();
            return false;
        } return true;
    }
    
    /**
     * <p><strong>EN:</strong> Clears the "name" field of the form.</p>
     * <p><strong>IT:</strong> Pulisce il campo "nome" del modulo.</p>
     * <p><strong>PT-BR:</strong> Limpa o campo "nome" do formulário.</p>
     */
    private void limpaCampo(){
        jTFNome.setText(null);
    }

    /**
     * <p><strong>EN:</strong> Saves a new publisher using the entered name 
     * and the current logged-in user.</p>
     *
     * <p><strong>IT:</strong> Salva un nuovo editore utilizzando il nome inserito 
     * e l'utente attualmente connesso.</p>
     *
     * <p><strong>PT-BR:</strong> Salva uma nova editora utilizando o nome informado 
     * e o usuário atualmente logado.</p>
     */    
    private void salvar(){
        editora.setDs_nome(jTFNome.getText());
        editora.setCd_usuario(JPLogin.codloginuser);
        editorar.inserir(editora);
    }

    /**
     * <p><strong>EN:</strong> Updates the selected publisher with the new name 
     * and the current logged-in user.</p>
     *
     * <p><strong>IT:</strong> Aggiorna l'editore selezionato con il nuovo nome 
     * e l'utente attualmente connesso.</p>
     *
     * <p><strong>PT-BR:</strong> Altera a editora selecionada com o novo nome 
     * e o usuário atualmente logado.</p>
     */    
    private void alterar(){
        editora.setCd_editora(editora.getCd_editora());
        editora.setDs_nome(jTFNome.getText());
        editora.setCd_usuario(JPLogin.codloginuser);
        editorar.alterar(editora);
        jTFNome.setText(null);
    }
 
    /**
     * <p><strong>EN:</strong> Deletes the selected publisher from the system.</p>
     * <p><strong>IT:</strong> Elimina l'editore selezionato dal sistema.</p>
     * <p><strong>PT-BR:</strong> Exclui a editora selecionada do sistema.</p>
     */
    private void excluir(){
        editora.setCd_editora(editora.getCd_editora());
        editorar.excluir(editora);
        jTFNome.setText(null);
    }
    
    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if(validaCampo()){
            salvar();
            jTFNome.setText(null);
            catalogou.tabelaEditora(jTEditora);
        }        
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jTEditoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTEditoraMouseClicked
        editora = (Editora)catalogou.getSelectedObject(jTEditora);
        jTFNome.setText(editora.getDs_nome());
        ativaBotoes();
    }//GEN-LAST:event_jTEditoraMouseClicked

    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        alterar();
        jTFNome.setText(null);
        desativaBotoes();
        catalogou.tabelaEditora(jTEditora);        
    }//GEN-LAST:event_jBAlterarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        excluir();
        jTFNome.setText(null);
        desativaBotoes();
        catalogou.tabelaEditora(jTEditora);        
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifeditora = null;
    }//GEN-LAST:event_formInternalFrameClosed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JLabel jLNome;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JPanel jPGrid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTEditora;
    private javax.swing.JTextField jTFNome;
    // End of variables declaration//GEN-END:variables
}
