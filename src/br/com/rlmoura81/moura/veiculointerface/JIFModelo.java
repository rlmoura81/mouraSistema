package br.com.rlmoura81.moura.veiculointerface;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.veiculo.Marca;
import br.com.rlmoura81.moura.veiculo.MarcaUtil;
import br.com.rlmoura81.moura.veiculo.Modelo;
import br.com.rlmoura81.moura.veiculo.ModeloRepository;
import br.com.rlmoura81.moura.veiculo.ModeloUtil;
import javax.swing.JOptionPane;

public class JIFModelo extends javax.swing.JInternalFrame {
    
    private static JIFModelo jifmodelo;
    
    /**
     * <p><strong>EN:</strong> Returns the singleton instance of <code>JIFModelo</code>.
     * If no instance exists, it creates a new one and sets the window title to “Modelo de veiculos”.</p>
     *
     * <p><strong>IT:</strong> Restituisce l'istanza singleton di <code>JIFModelo</code>.
     * Se non esiste, ne crea una nuova e imposta il titolo della finestra su “Modelo de veiculos”.</p>
     *
     * <p><strong>PT-BR:</strong> Retorna a instância única de <code>JIFModelo</code>.
     * Se não existir, cria uma nova e define o título da janela como “Modelo de veículos”.</p>
     */
    public static JIFModelo getInstancia(){
        if(jifmodelo == null){
            jifmodelo = new JIFModelo();
            jifmodelo.setTitle("Modelo de veiculos");
        }return jifmodelo;
    }
    
    Marca marca = null;
    MarcaUtil marcau = new MarcaUtil();    
    Modelo modelo = new Modelo();
    ModeloRepository modelor = new ModeloRepository();
    ModeloUtil modelou = new ModeloUtil();
    
    public JIFModelo() {
        initComponents();
        
        jcMarca();
        tabelaModelo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPCampos = new javax.swing.JPanel();
        jLModelo = new javax.swing.JLabel();
        jTFModelo = new javax.swing.JTextField();
        jBSalvar = new javax.swing.JButton();
        jBAlterar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jCBMarca = new javax.swing.JComboBox<>();
        jPGrid = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTModelo = new javax.swing.JTable();

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

        jPCampos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLModelo.setText("Modelo:");

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

        jCBMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBMarcaActionPerformed(evt);
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
                        .addComponent(jBSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBExcluir))
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addComponent(jLModelo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFModelo))
                    .addComponent(jCBMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPCamposLayout.setVerticalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jCBMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLModelo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalvar)
                    .addComponent(jBAlterar)
                    .addComponent(jBExcluir))
                .addContainerGap())
        );

        jPGrid.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTModelo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTModelo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTModeloMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTModelo);

        javax.swing.GroupLayout jPGridLayout = new javax.swing.GroupLayout(jPGrid);
        jPGrid.setLayout(jPGridLayout);
        jPGridLayout.setHorizontalGroup(
            jPGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPGridLayout.setVerticalGroup(
            jPGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
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
                    .addComponent(jPCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
     * <p><strong>EN:</strong> Loads the list of brands into the brand combo box.</p>
     * <p><strong>IT:</strong> Carica l'elenco delle marche nella combo box delle marche.</p>
     * <p><strong>PT-BR:</strong> Carrega a lista de marcas no combo box de marcas.</p>
     */
    private void jcMarca(){
        marcau.jcMarca(jCBMarca);
    }
    
    /**
     * <p><strong>EN:</strong> Loads all registered models into the model table.</p>
     * <p><strong>IT:</strong> Carica tutti i modelli registrati nella tabella dei modelli.</p>
     * <p><strong>PT-BR:</strong> Carrega todos os modelos cadastrados na tabela de modelos.</p>
     */
    private void tabelaModelo(){
        modelou.tabelaModelo(jTModelo);
    }
    
    /**
     * <p><strong>EN:</strong> Clears all input fields and resets the brand combo box.</p>
     * <p><strong>IT:</strong> Pulisce tutti i campi di input e reimposta la combo box delle marche.</p>
     * <p><strong>PT-BR:</strong> Limpa todos os campos de entrada e redefine o combo box da marca.</p>
     */
    private void limpaCampos(){
        jCBMarca.setSelectedIndex(0);
        jTFModelo.setText(null);
    }
    
    /**
     * <p><strong>EN:</strong> Validates the fields to ensure the brand and model name are filled in.</p>
     * <p><strong>IT:</strong> Valida i campi per garantire che la marca e il nome del modello siano compilati.</p>
     * <p><strong>PT-BR:</strong> Valida os campos para garantir que a marca e o nome do modelo estejam preenchidos.</p>
     */
    private boolean validaCampos(){
        if(marca == null){
            JOptionPane.showMessageDialog(null, "Selecione a marca do veiculo.", "Marca", JOptionPane.INFORMATION_MESSAGE);
            jCBMarca.requestFocus();
            return false;
        }
        if(jTFModelo.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo em branco.", "Modelo", JOptionPane.INFORMATION_MESSAGE);
            jTFModelo.requestFocus();
            return false;
        }
        return true;
    }
    
    /**
     * <p><strong>EN:</strong> Saves a new vehicle model linked to the selected brand and current user.</p>
     * <p><strong>IT:</strong> Salva un nuovo modello di veicolo collegato alla marca selezionata e all'utente corrente.</p>
     * <p><strong>PT-BR:</strong> Salva um novo modelo de veículo vinculado à marca selecionada e ao usuário atual.</p>
     */
    private void salvar(){
        modelo.setMarca(marca);
        modelo.setDs_modelo(jTFModelo.getText());
        modelo.setCd_usuario(JPLogin.codloginuser);
        modelor.inserir(modelo);
        modelo = null;
    }
    
    /**
     * <p><strong>EN:</strong> Updates the information of the selected vehicle model.</p>
     * <p><strong>IT:</strong> Aggiorna le informazioni del modello di veicolo selezionato.</p>
     * <p><strong>PT-BR:</strong> Atualiza as informações do modelo de veículo selecionado.</p>
     */
    private void alterar(){
        modelo.setMarca(marca);
        modelo.setDs_modelo(jTFModelo.getText());
        modelo.setCd_usuario(JPLogin.codloginuser);
        modelor.alterar(modelo);
        modelo = null;
    }
    
    /**
     * <p><strong>EN:</strong> Deletes the selected vehicle model from the database.</p>
     * <p><strong>IT:</strong> Elimina il modello di veicolo selezionato dal database.</p>
     * <p><strong>PT-BR:</strong> Exclui o modelo de veículo selecionado do banco de dados.</p>
     */
    private void excluir(){
        modelo.setCd_modelo(modelo.getCd_modelo());
        modelor.excluir(modelo);
        modelo = null;
    }
    
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifmodelo = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jTModeloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTModeloMouseClicked
        modelo = (Modelo)modelou.getSelectObject(jTModelo);
        jCBMarca.setSelectedItem(modelo.getMarca());
        jTFModelo.setText(modelo.getDs_modelo());
    }//GEN-LAST:event_jTModeloMouseClicked

    private void jCBMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBMarcaActionPerformed
        if(jCBMarca.getSelectedIndex() != 0){
            marca = (Marca)jCBMarca.getSelectedItem();
        }else{
            marca = null;
        }
    }//GEN-LAST:event_jCBMarcaActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        modelo = (Modelo)modelou.getSelectObject(jTModelo);
        if(modelo != null){
            excluir();
            limpaCampos();
            tabelaModelo();
        }
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        modelo = (Modelo)modelou.getSelectObject(jTModelo);
        if(modelo != null){
            alterar();
            limpaCampos();
            tabelaModelo();
        }
    }//GEN-LAST:event_jBAlterarActionPerformed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if(validaCampos()){
            salvar();
            limpaCampos();
            tabelaModelo();
        }
    }//GEN-LAST:event_jBSalvarActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<Marca> jCBMarca;
    private javax.swing.JLabel jLModelo;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JPanel jPGrid;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTFModelo;
    private javax.swing.JTable jTModelo;
    // End of variables declaration//GEN-END:variables
}
