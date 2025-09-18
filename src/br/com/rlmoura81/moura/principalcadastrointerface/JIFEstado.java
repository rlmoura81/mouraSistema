package br.com.rlmoura81.moura.principalcadastrointerface;

import br.com.rlmoura81.moura.principalcadastro.Estado;
import br.com.rlmoura81.moura.principalcadastro.EstadoRepository;
import br.com.rlmoura81.moura.principalcadastro.EstadoUtil;
import javax.swing.JOptionPane;

public class JIFEstado extends javax.swing.JInternalFrame {

    private static JIFEstado jifestado;
    
    /**
     * <p><strong>EN:</strong> Returns a singleton instance of the JIFEstado window.  
     * If the instance does not exist, it creates one and sets its title to "Estados".</p>
     *
     * <p><strong>IT:</strong> Restituisce un'istanza singleton della finestra JIFEstado.  
     * Se l'istanza non esiste, ne crea una e imposta il titolo su "Estados".</p>
     *
     * <p><strong>PT-BR:</strong> Retorna uma instância singleton da janela JIFEstado.  
     * Se a instância não existir, cria uma e define o título como "Estados".</p>
     */
    public static JIFEstado getInstancia(){
        if (jifestado == null){
            jifestado = new JIFEstado();
            jifestado.setTitle("Estados");
        } return jifestado;
    }
    
    Estado estado = new Estado();
    EstadoRepository estador = new EstadoRepository();
    EstadoUtil estadou = new EstadoUtil();
    
    public JIFEstado() {
        initComponents();

        estadou.tabelaEstado(jTEstado);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPCampos = new javax.swing.JPanel();
        jLSigla = new javax.swing.JLabel();
        jTFSigla = new javax.swing.JTextField();
        jBSalvar = new javax.swing.JButton();
        jBAlterar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jLEstado = new javax.swing.JLabel();
        jTFEstado = new javax.swing.JTextField();
        jPGrid = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTEstado = new javax.swing.JTable();

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

        JPCampos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLSigla.setText("Sigla:");

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

        jLEstado.setText("Estado:");

        javax.swing.GroupLayout JPCamposLayout = new javax.swing.GroupLayout(JPCampos);
        JPCampos.setLayout(JPCamposLayout);
        JPCamposLayout.setHorizontalGroup(
            JPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPCamposLayout.createSequentialGroup()
                        .addGroup(JPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLEstado)
                            .addComponent(jLSigla))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTFSigla)
                            .addComponent(jTFEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(JPCamposLayout.createSequentialGroup()
                        .addComponent(jBSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBExcluir)))
                .addContainerGap(192, Short.MAX_VALUE))
        );
        JPCamposLayout.setVerticalGroup(
            JPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLEstado)
                    .addComponent(jTFEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLSigla)
                    .addComponent(jTFSigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalvar)
                    .addComponent(jBAlterar)
                    .addComponent(jBExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPGrid.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTEstado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTEstadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTEstado);

        javax.swing.GroupLayout jPGridLayout = new javax.swing.GroupLayout(jPGrid);
        jPGrid.setLayout(jPGridLayout);
        jPGridLayout.setHorizontalGroup(
            jPGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPGridLayout.setVerticalGroup(
            jPGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
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
                    .addComponent(JPCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    /**
     * <p><strong>EN:</strong> Clears all fields in the State form.  
     * Resets text fields and sets focus back to the State field.</p>
     *
     * <p><strong>IT:</strong> Pulisce tutti i campi del modulo Stato.  
     * Reimposta i campi di testo e riporta il focus sul campo Stato.</p>
     *
     * <p><strong>PT-BR:</strong> Limpa todos os campos do formulário de Estado.  
     * Redefine os campos de texto e retorna o foco para o campo Estado.</p>
     */
    private void limpaCampos(){
        jTFEstado.setText(null);
        jTFSigla.setText(null);
        jTFEstado.requestFocus();
    }

    /**
     * <p><strong>EN:</strong> Validates the State form fields.  
     * Ensures that the State and Abbreviation fields are filled correctly  
     * and that the abbreviation does not exceed 2 characters.</p>
     *
     * <p><strong>IT:</strong> Valida i campi del modulo Stato.  
     * Verifica che i campi Stato e Sigla siano compilati correttamente  
     * e che la sigla non superi i 2 caratteri.</p>
     *
     * <p><strong>PT-BR:</strong> Valida os campos do formulário de Estado.  
     * Garante que os campos Estado e Sigla estejam preenchidos corretamente  
     * e que a sigla não ultrapasse 2 caracteres.</p>
     */
    private boolean validaCampos(){
        if(jTFEstado.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo em branco.", "Estado", JOptionPane.INFORMATION_MESSAGE);
            jTFEstado.requestFocus();
            return false;
        } 
        if(jTFSigla.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo em branco.", "Estado", JOptionPane.INFORMATION_MESSAGE);
            jTFSigla.requestFocus();
            return false;
        }
        if(jTFSigla.getText().length() > 2){
            JOptionPane.showMessageDialog(null, "Campo sigla invalido.", "Estado", JOptionPane.INFORMATION_MESSAGE);
            jTFSigla.requestFocus();
            return false;
        }
        return true;
    }
    
    /**
     * <p><strong>EN:</strong> Saves a new State record.  
     * Sets the State description and abbreviation, then inserts it into the database.</p>
     *
     * <p><strong>IT:</strong> Salva un nuovo record di Stato.  
     * Imposta la descrizione e la sigla dello Stato, quindi lo inserisce nel database.</p>
     *
     * <p><strong>PT-BR:</strong> Salva um novo registro de Estado.  
     * Define a descrição e a sigla do Estado e insere no banco de dados.</p>
     */
    private void salvar(){
        estado.setDs_estado(jTFEstado.getText());
        estado.setDs_siglaEstado(jTFSigla.getText());
        estador.inserir(estado);    
        estado = null;
    }
    
    /**
     * <p><strong>EN:</strong> Updates an existing State record.  
     * Modifies the description and abbreviation, then updates it in the database.</p>
     *
     * <p><strong>IT:</strong> Aggiorna un record esistente di Stato.  
     * Modifica la descrizione e la sigla, quindi lo aggiorna nel database.</p>
     *
     * <p><strong>PT-BR:</strong> Altera um registro existente de Estado.  
     * Atualiza a descrição e a sigla no banco de dados.</p>
     */
    private void alterar(){
            estado.setDs_estado(jTFEstado.getText());
            estado.setDs_siglaEstado(jTFSigla.getText());
            estador.alterar(estado);
            estado = null;
    }

    /**
     * <p><strong>EN:</strong> Deletes the selected State record from the database.  
     * Uses the State code as a reference to perform the removal.</p>
     *
     * <p><strong>IT:</strong> Elimina il record di Stato selezionato dal database.  
     * Utilizza il codice dello Stato come riferimento per la rimozione.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui o registro de Estado selecionado do banco de dados.  
     * Usa o código do Estado como referência para realizar a exclusão.</p>
     */
    private void excluir(){
        estado.setCd_estado(estado.getCd_estado());
        estador.excluir(estado);
        estado = null;
    }
    
    private void jTEstadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTEstadoMouseClicked
        estado = (Estado)estadou.getSelectObject(jTEstado);
        estado.setCd_estado(estado.getCd_estado());
        jTFEstado.setText(estado.getDs_estado());
        jTFSigla.setText(estado.getDs_siglaEstado());               
    }//GEN-LAST:event_jTEstadoMouseClicked
    
    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if (validaCampos()){
            salvar();
            limpaCampos();
            estadou.tabelaEstado(jTEstado);
        }             
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        estado = (Estado)estadou.getSelectObject(jTEstado);
        if(estado != null){
            alterar();
            estadou.tabelaEstado(jTEstado);
            limpaCampos();
        }
    }//GEN-LAST:event_jBAlterarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        estado = (Estado)estadou.getSelectObject(jTEstado);
        if(estado != null){
            excluir();
            estadou.tabelaEstado(jTEstado);
            limpaCampos();
        }
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifestado = null;
    }//GEN-LAST:event_formInternalFrameClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPCampos;
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JLabel jLEstado;
    private javax.swing.JLabel jLSigla;
    private javax.swing.JPanel jPGrid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTEstado;
    private javax.swing.JTextField jTFEstado;
    private javax.swing.JTextField jTFSigla;
    // End of variables declaration//GEN-END:variables
}
