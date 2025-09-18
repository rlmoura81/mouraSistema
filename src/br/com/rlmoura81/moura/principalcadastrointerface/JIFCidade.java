package br.com.rlmoura81.moura.principalcadastrointerface;

import br.com.rlmoura81.moura.principalcadastro.Cidade;
import br.com.rlmoura81.moura.principalcadastro.Estado;
import br.com.rlmoura81.moura.principalcadastro.CidadeRepository;
import br.com.rlmoura81.moura.principalcadastro.CidadeUtil;
import br.com.rlmoura81.moura.principalcadastro.EstadoUtil;
import javax.swing.JOptionPane;

public class JIFCidade extends javax.swing.JInternalFrame {
    
    private static JIFCidade jifcidade;
    
    /**
     * <p><strong>EN:</strong> Provides a singleton instance of the City internal frame.  
     * If the instance does not exist, it creates a new one and sets its title.</p>
     *
     * <p><strong>IT:</strong> Restituisce un'istanza singleton della finestra interna Città.  
     * Se l'istanza non esiste, ne crea una nuova e imposta il titolo.</p>
     *
     * <p><strong>PT-BR:</strong> Retorna uma instância singleton da janela interna Cidade.  
     * Caso a instância não exista, cria uma nova e define o título.</p>
     */
    public static JIFCidade getInstancia(){
        if (jifcidade == null){
            jifcidade = new JIFCidade();
            jifcidade.setTitle("Cidades");
        } return jifcidade;
    }

    Cidade cidade = null;
    CidadeRepository cidader = new CidadeRepository();
    CidadeUtil cidadeu = new CidadeUtil();    
    Estado estado = null;
    EstadoUtil estadou = new EstadoUtil();
    
    public JIFCidade() {
        initComponents();        

        estadou.jcEstado(jCBEstado);
        tabelaCidade();        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPCampo = new javax.swing.JPanel();
        jLCidade = new javax.swing.JLabel();
        jCBEstado = new javax.swing.JComboBox<>();
        jLEstado = new javax.swing.JLabel();
        jBInserir = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jTFCidade = new javax.swing.JTextField();
        jBAlterar = new javax.swing.JButton();
        jPGrid = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTCidade = new javax.swing.JTable();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(420, 320));
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

        jPCampo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLCidade.setText("Cidade:");

        jCBEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBEstadoActionPerformed(evt);
            }
        });

        jLEstado.setText("Estado:");

        jBInserir.setText("Inserir");
        jBInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBInserirActionPerformed(evt);
            }
        });

        jBExcluir.setText("Excluir");
        jBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirActionPerformed(evt);
            }
        });

        jBAlterar.setText("Alterar");
        jBAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPCampoLayout = new javax.swing.GroupLayout(jPCampo);
        jPCampo.setLayout(jPCampoLayout);
        jPCampoLayout.setHorizontalGroup(
            jPCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCampoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPCampoLayout.createSequentialGroup()
                        .addComponent(jLEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPCampoLayout.createSequentialGroup()
                        .addComponent(jBInserir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBExcluir))
                    .addGroup(jPCampoLayout.createSequentialGroup()
                        .addComponent(jLCidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPCampoLayout.setVerticalGroup(
            jPCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCampoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLEstado)
                    .addComponent(jCBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCidade)
                    .addComponent(jTFCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBInserir)
                    .addComponent(jBAlterar)
                    .addComponent(jBExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPGrid.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTCidade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTCidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTCidadeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTCidade);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
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
                    .addComponent(jPCampo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * <p><strong>EN:</strong> Clears all input fields related to City.  
     * Resets the State combo box, clears the City text field, and sets focus.</p>
     *
     * <p><strong>IT:</strong> Pulisce tutti i campi di input relativi alla Città.  
     * Reimposta la combo Stato, cancella il campo Città e imposta il focus.</p>
     *
     * <p><strong>PT-BR:</strong> Limpa todos os campos de entrada da Cidade.  
     * Reseta o combo de Estado, limpa o campo de Cidade e coloca o foco.</p>
     */
    private void limpaCampos (){
        jCBEstado.setSelectedIndex(0);
        jTFCidade.setText(null);
        jTFCidade.requestFocus();
    }

    /**
     * <p><strong>EN:</strong> Populates the City table with data from the repository.  
     * Loads all cities into the table model for visualization.</p>
     *
     * <p><strong>IT:</strong> Popola la tabella delle Città con i dati del repository.  
     * Carica tutte le città nel modello della tabella per la visualizzazione.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche a tabela de Cidades com os dados do repositório.  
     * Carrega todas as cidades no modelo da tabela para exibição.</p>
     */
    private void tabelaCidade(){
        cidadeu.tabelaCidade(jTCidade);
    }
    
    /**
     * <p><strong>EN:</strong> Validates City form fields before saving or updating.  
     * Ensures a State is selected and the City field is not empty.</p>
     *
     * <p><strong>IT:</strong> Valida i campi del modulo Città prima di salvare o aggiornare.  
     * Controlla che uno Stato sia selezionato e che il campo Città non sia vuoto.</p>
     *
     * <p><strong>PT-BR:</strong> Valida os campos do formulário de Cidade antes de salvar ou alterar.  
     * Verifica se um Estado foi selecionado e se o campo Cidade não está vazio.</p>
     */
    public boolean validaCampos(){
        if(estado == null){
            JOptionPane.showMessageDialog(null, "Escolha o estado.", "Estado", JOptionPane.INFORMATION_MESSAGE);
            jCBEstado.requestFocus();
            return false;
        }
        if (jTFCidade.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo em branco", "Cidade", JOptionPane.INFORMATION_MESSAGE);
            jTFCidade.requestFocus();
            return false;
        }
        return true;
    }
    
    /**
     * <p><strong>EN:</strong> Saves a new City into the database.  
     * Associates the City with the selected State and persists the record.</p>
     *
     * <p><strong>IT:</strong> Salva una nuova Città nel database.  
     * Associa la Città allo Stato selezionato e persiste il record.</p>
     *
     * <p><strong>PT-BR:</strong> Salva uma nova Cidade no banco de dados.  
     * Associa a Cidade ao Estado selecionado e persiste o registro.</p>
     */
    private void salvar(){
        cidade.setEstado(estado);
        cidade.setDs_Cidade(jTFCidade.getText());
        cidader.inserir(cidade); 
        cidade = null;
    }
    
    /**
     * <p><strong>EN:</strong> Updates an existing City in the database.  
     * Modifies the City name and its associated State.</p>
     *
     * <p><strong>IT:</strong> Aggiorna una Città esistente nel database.  
     * Modifica il nome della Città e lo Stato associato.</p>
     *
     * <p><strong>PT-BR:</strong> Altera uma Cidade existente no banco de dados.  
     * Atualiza o nome da Cidade e o Estado vinculado.</p>
     */
    private void alterar(){
        cidade.setDs_Cidade(jTFCidade.getText());
        cidade.setEstado(estado);           
        cidader.alterar(cidade);
        cidade = null;
    }
    
    /**
     * <p><strong>EN:</strong> Deletes a City from the database.  
     * Uses the City’s ID to identify and remove the record.</p>
     *
     * <p><strong>IT:</strong> Elimina una Città dal database.  
     * Utilizza l’ID della Città per identificare e rimuovere il record.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui uma Cidade do banco de dados.  
     * Utiliza o ID da Cidade para identificar e remover o registro.</p>
     */
    private void excluir(){
        cidade.setCd_Cidade(cidade.getCd_Cidade());
        cidader.excluir(cidade);        
    }
    
    private void jBInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBInserirActionPerformed
        if (validaCampos()){
            salvar();
            limpaCampos();
            tabelaCidade();
        }    
    }//GEN-LAST:event_jBInserirActionPerformed

    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        cidade = (Cidade)cidadeu.getSelectObject(jTCidade);
        if(cidade != null){
            alterar();
            limpaCampos();
            tabelaCidade();
        }
    }//GEN-LAST:event_jBAlterarActionPerformed

    private void jCBEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBEstadoActionPerformed
        if(jCBEstado.getSelectedIndex() != 0){
            estado = (Estado)jCBEstado.getSelectedItem();
        }else{
            estado = null;
        }
    }//GEN-LAST:event_jCBEstadoActionPerformed

    private void jTCidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTCidadeMouseClicked
        cidade = (Cidade)cidadeu.getSelectObject(jTCidade);
        jTFCidade.setText(cidade.getDs_Cidade());
        jCBEstado.setSelectedItem(cidade.getEstado());
        cidade.setCd_Cidade(cidade.getCd_Cidade());                
    }//GEN-LAST:event_jTCidadeMouseClicked
        
    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        cidade = (Cidade)cidadeu.getSelectObject(jTCidade);
        if(cidade != null){
            excluir();
            limpaCampos();
            tabelaCidade();
        }
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifcidade = null;
    }//GEN-LAST:event_formInternalFrameClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBInserir;
    private javax.swing.JComboBox<Estado> jCBEstado;
    private javax.swing.JLabel jLCidade;
    private javax.swing.JLabel jLEstado;
    private javax.swing.JPanel jPCampo;
    private javax.swing.JPanel jPGrid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTCidade;
    private javax.swing.JTextField jTFCidade;
    // End of variables declaration//GEN-END:variables
}
