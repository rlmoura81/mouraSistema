package br.com.rlmoura81.moura.animalinterface;

import br.com.rlmoura81.moura.animal.Especie;
import br.com.rlmoura81.moura.animal.EspecieUtil;
import br.com.rlmoura81.moura.animal.Raca;
import br.com.rlmoura81.moura.animal.RacaRepository;
import br.com.rlmoura81.moura.animal.RacaUtil;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import javax.swing.JOptionPane;

public class JIFRaca extends javax.swing.JInternalFrame {
    
    private static JIFRaca jifraca;
    
    /**
     * <p><strong>EN:</strong> Returns the singleton instance of the JIFRaca class.  
     * If no instance exists, a new one is created and initialized.</p>
     *
     * <p><strong>IT:</strong> Restituisce l'istanza singleton della classe JIFRaca.  
     * Se non esiste alcuna istanza, ne viene creata e inizializzata una nuova.</p>
     *
     * <p><strong>PT-BR:</strong> Retorna a instância singleton da classe JIFRaca.  
     * Se não existir nenhuma instância, uma nova é criada e inicializada.</p>
     *
     * @return EN: singleton instance of JIFRaca | IT: istanza singleton di JIFRaca | PT-BR: instância singleton de JIFRaca
     * @since 1.0.0
     */    
    public static JIFRaca getInstancia(){
        if(jifraca == null){
            jifraca = new JIFRaca();
            jifraca.setTitle("Raças");
        }return jifraca;
    }

    Raca raca = new Raca();
    RacaRepository racar = new RacaRepository();
    RacaUtil racau = new RacaUtil();    
    Especie especie = null;
    EspecieUtil especieu = new EspecieUtil();    
        
    public JIFRaca() {
        initComponents();
        
        especieu.jcEspecie(jCBEspecie);
        racau.tabelaRaca(jTRaca);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPGrid = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTRaca = new javax.swing.JTable();
        jPBotoes = new javax.swing.JPanel();
        jBSalvar = new javax.swing.JButton();
        jBAlterar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jLRaca = new javax.swing.JLabel();
        jTFRaca = new javax.swing.JTextField();
        jCBEspecie = new javax.swing.JComboBox<>();
        jLEspecie = new javax.swing.JLabel();

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

        jPGrid.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTRaca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTRaca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTRacaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTRaca);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addContainerGap())
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

        jLRaca.setText("Raça:");

        jCBEspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBEspecieActionPerformed(evt);
            }
        });

        jLEspecie.setText("Especie:");

        javax.swing.GroupLayout jPBotoesLayout = new javax.swing.GroupLayout(jPBotoes);
        jPBotoes.setLayout(jPBotoesLayout);
        jPBotoesLayout.setHorizontalGroup(
            jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPBotoesLayout.createSequentialGroup()
                        .addComponent(jBSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBExcluir)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPBotoesLayout.createSequentialGroup()
                        .addGroup(jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLRaca)
                            .addComponent(jLEspecie))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBEspecie, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTFRaca))))
                .addContainerGap())
        );
        jPBotoesLayout.setVerticalGroup(
            jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPBotoesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLEspecie))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLRaca)
                    .addComponent(jTFRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalvar)
                    .addComponent(jBAlterar)
                    .addComponent(jBExcluir))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * <p><strong>EN:</strong> Validates the form fields before saving or updating a breed (Raca).</p>
     *
     * <p><strong>IT:</strong> Convalida i campi del modulo prima di salvare o aggiornare una razza (Raca).</p>
     *
     * <p><strong>PT-BR:</strong> Valida os campos do formulário antes de salvar ou atualizar uma raça (Raca).</p>
     *
     * @return EN: true if all fields are valid, false otherwise | IT: true se tutti i campi sono validi, false altrimenti | PT-BR: true se todos os campos forem válidos, false caso contrário
     * @since 1.0.0
     */
    private boolean validaCampos(){
        if(especie == null){
            JOptionPane.showMessageDialog(null, "Selecione a especie.", "Especie", JOptionPane.INFORMATION_MESSAGE);
            jCBEspecie.requestFocus();
            return false;
        }
        if (jTFRaca.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Digite a raça.", "Raça", JOptionPane.INFORMATION_MESSAGE);
            jTFRaca.requestFocus();
            return false;
        }
        return true;
    }
    
    /**
     * <p><strong>EN:</strong> Clears all input fields in the breed (Raca) form.</p>
     *
     * <p><strong>IT:</strong> Pulisce tutti i campi di input nel modulo razza (Raca).</p>
     *
     * <p><strong>PT-BR:</strong> Limpa todos os campos de entrada no formulário de raça (Raca).</p>
     *
     * @since 1.0.0
     */    
    private void limpaCampos(){
        jCBEspecie.setSelectedIndex(0);
        jTFRaca.setText(null);
    }

    /**
     * <p><strong>EN:</strong> Saves a new breed (Raca) record to the database using the form data.</p>
     *
     * <p><strong>IT:</strong> Salva un nuovo record di razza (Raca) nel database utilizzando i dati del modulo.</p>
     *
     * <p><strong>PT-BR:</strong> Salva um novo registro de raça (Raca) no banco de dados utilizando os dados do formulário.</p>
     *
     * @since 1.0.0
     */    
    private void salvar(){
        raca.setEspecie(especie);
        raca.setDs_raca(jTFRaca.getText());
        raca.setCd_usuario(JPLogin.codloginuser);
        racar.inserir(raca);
    }

    /**
     * <p><strong>EN:</strong> Updates an existing breed (Raca) record in the database using the form data.</p>
     *
     * <p><strong>IT:</strong> Aggiorna un record di razza (Raca) esistente nel database utilizzando i dati del modulo.</p>
     *
     * <p><strong>PT-BR:</strong> Atualiza um registro de raça (Raca) existente no banco de dados utilizando os dados do formulário.</p>
     *
     * @since 1.0.0
     */    
    private void alterar(){
        raca.setEspecie(especie);
        raca.setDs_raca(jTFRaca.getText());
        raca.setCd_usuario(JPLogin.codloginuser);
        racar.alterar(raca);
    }

    /**
     * <p><strong>EN:</strong> Deletes the current breed (Raca) record from the database.</p>
     *
     * <p><strong>IT:</strong> Elimina il record corrente della razza (Raca) dal database.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui o registro atual da raça (Raca) no banco de dados.</p>
     *
     * @since 1.0.0
     */    
    private void excluir(){
        raca.setCd_raca(raca.getCd_raca());
        racar.excluir(raca);
    }
    
    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if(validaCampos()){
            salvar();
            limpaCampos();
            racau.tabelaRaca(jTRaca);
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jCBEspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBEspecieActionPerformed
        if(jCBEspecie.getSelectedIndex() != 0){
            especie = (Especie) jCBEspecie.getSelectedItem();            
        }else{
            especie = null;
        }
    }//GEN-LAST:event_jCBEspecieActionPerformed

    private void jTRacaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTRacaMouseClicked
        raca = (Raca)racau.getSelectObject(jTRaca);
        jCBEspecie.getModel().setSelectedItem(raca.getEspecie());
        jTFRaca.setText(raca.getDs_raca());
    }//GEN-LAST:event_jTRacaMouseClicked

    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        raca = (Raca)racau.getSelectObject(jTRaca);
        if(raca != null){
            alterar();
            limpaCampos();             
            racau.tabelaRaca(jTRaca);          
        }    
    }//GEN-LAST:event_jBAlterarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        raca = (Raca)racau.getSelectObject(jTRaca);
        if(raca != null){
            excluir();
            limpaCampos();
            racau.tabelaRaca(jTRaca);
        }    
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifraca = null;
    }//GEN-LAST:event_formInternalFrameClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<Especie> jCBEspecie;
    private javax.swing.JLabel jLEspecie;
    private javax.swing.JLabel jLRaca;
    private javax.swing.JPanel jPBotoes;
    private javax.swing.JPanel jPGrid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFRaca;
    private javax.swing.JTable jTRaca;
    // End of variables declaration//GEN-END:variables
}
