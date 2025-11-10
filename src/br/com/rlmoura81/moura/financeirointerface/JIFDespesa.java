package br.com.rlmoura81.moura.financeirointerface;

import br.com.rlmoura81.moura.financeiro.Despesa;
import br.com.rlmoura81.moura.financeiro.DespesaRepository;
import br.com.rlmoura81.moura.financeiro.DespesaUtil;
import br.com.rlmoura81.moura.principalcadastro.Categoria;
import br.com.rlmoura81.moura.principalcadastro.CategoriaUtil;
import br.com.rlmoura81.moura.principalcadastro.Empresa;
import br.com.rlmoura81.moura.principalcadastro.EmpresaUtil;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class JIFDespesa extends javax.swing.JInternalFrame {

    private static JIFDespesa jifdespesa;

    /**
     * <p><strong>EN:</strong> Returns the singleton instance of {@link JIFDespesa}.  
     * If it does not exist, creates a new instance, sets the title to "Despesas",  
     * and maximizes the window. Handles possible {@link PropertyVetoException} when maximizing.</p>
     *
     * <p><strong>IT:</strong> Restituisce l'istanza singleton di {@link JIFDespesa}.  
     * Se non esiste, crea una nuova istanza, imposta il titolo su "Despesas"  
     * e massimizza la finestra. Gestisce la possibile {@link PropertyVetoException} durante la massimizzazione.</p>
     *
     * <p><strong>PT-BR:</strong> Retorna a instância singleton de {@link JIFDespesa}.  
     * Caso não exista, cria uma nova instância, define o título como "Despesas"  
     * e maximiza a janela. Trata a possível {@link PropertyVetoException} ao maximizar.</p>
     */
    public static JIFDespesa getInstancia() {
        if (jifdespesa == null) {
            jifdespesa = new JIFDespesa();
            jifdespesa.setTitle("Despesas");
            try {
                jifdespesa.setMaximum(true);
            } catch (PropertyVetoException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao abrir:\n" + ex.getMessage(), "Despesas", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(JIFDespesa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return jifdespesa;
    }

    Despesa despesa = null;
    DespesaRepository despesar = new DespesaRepository();
    DespesaUtil despesau = new DespesaUtil();

    Empresa empresa = null;
    EmpresaUtil empresau = new EmpresaUtil();
    
    Categoria categoria = null;
    CategoriaUtil categoriau = new CategoriaUtil();

    public JIFDespesa() {
        initComponents();
        
        formataValor();
        jcCategoria();
        jcEmpresa();
        tabelaDespesa();
        calculaValorTotal();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPCampos = new javax.swing.JPanel();
        jCBPrestador = new javax.swing.JComboBox<>();
        jBSalvar = new javax.swing.JButton();
        jBAlterar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jFTFValor = new javax.swing.JFormattedTextField();
        jLDespesa = new javax.swing.JLabel();
        jLTotal = new javax.swing.JLabel();
        jTFDespesa = new javax.swing.JTextField();
        jLValor = new javax.swing.JLabel();
        jLCategoria = new javax.swing.JLabel();
        jCBCategoria = new javax.swing.JComboBox<>();
        jLPrestador = new javax.swing.JLabel();
        jPGrid = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTDespesa = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
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

        jCBPrestador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBPrestadorActionPerformed(evt);
            }
        });

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

        jFTFValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));

        jLDespesa.setText("Despesa:");

        jLTotal.setText("Total:");

        jLValor.setText("Valor:");

        jLCategoria.setText("Categoria:");

        jCBCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBCategoriaActionPerformed(evt);
            }
        });

        jLPrestador.setText("Prestador:");

        javax.swing.GroupLayout jPCamposLayout = new javax.swing.GroupLayout(jPCampos);
        jPCampos.setLayout(jPCamposLayout);
        jPCamposLayout.setHorizontalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addComponent(jBSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBExcluir))
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLDespesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLPrestador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBPrestador, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFTFValor, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPCamposLayout.createSequentialGroup()
                                .addComponent(jTFDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLTotal)))))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPCamposLayout.setVerticalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLDespesa)
                    .addComponent(jTFDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLValor)
                    .addComponent(jFTFValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBPrestador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLPrestador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCategoria)
                    .addComponent(jCBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalvar)
                    .addComponent(jBAlterar)
                    .addComponent(jBExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPGrid.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTDespesa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTDespesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTDespesaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTDespesa);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
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
     * <p><strong>EN:</strong> Formats the expense value field with the predefined numeric mask.</p>
     * <p><strong>IT:</strong> Formatta il campo valore della spesa con la maschera numerica predefinita.</p>
     * <p><strong>PT-BR:</strong> Formata o campo de valor da despesa com a máscara numérica predefinida.</p>
     */
    private void formataValor() {
        jFTFValor.setFormatterFactory(Utilidade.formataValorCampo(ui));
    }

    /**
     * <p><strong>EN:</strong> Validates the mandatory fields of the expense form, ensuring that  
     * the description, value, provider, and category are filled correctly.</p>
     * <p><strong>IT:</strong> Valida i campi obbligatori del modulo di spesa, assicurando che  
     * la descrizione, il valore, il fornitore e la categoria siano compilati correttamente.</p>
     * <p><strong>PT-BR:</strong> Valida os campos obrigatórios do formulário de despesa, garantindo que  
     * a descrição, valor, prestador e categoria estejam preenchidos corretamente.</p>
     */
    private boolean validaCampos() {
        if (jTFDespesa.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo em branco.", "Despesa", JOptionPane.INFORMATION_MESSAGE);
            jTFDespesa.requestFocus();
            return false;
        }
        if (jFTFValor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Valor em branco.", "Despesa", JOptionPane.INFORMATION_MESSAGE);
            jFTFValor.requestFocus();
            return false;
        }

        if (empresa == null) {
            JOptionPane.showMessageDialog(null, "Selecione o prestador.", "Prestador de Serviço.", JOptionPane.INFORMATION_MESSAGE);
            jCBPrestador.requestFocus();
            return false;
        }
        if (categoria == null) {
            JOptionPane.showMessageDialog(null, "Selecione a categoria.", "Categoria", JOptionPane.INFORMATION_MESSAGE);
            jCBCategoria.requestFocus();
            return false;
        }
        return true;
    }

    /**
     * <p><strong>EN:</strong> Loads the category options into the combo box.</p>
     * <p><strong>IT:</strong> Carica le opzioni di categoria nella combo box.</p>
     * <p><strong>PT-BR:</strong> Carrega as opções de categoria no combo box.</p>
     */
    private void jcCategoria() {
        categoriau.jcCategoria(jCBCategoria);
    }

    /**
     * <p><strong>EN:</strong> Loads the service provider options into the combo box.</p>
     * <p><strong>IT:</strong> Carica le opzioni del fornitore di servizi nella combo box.</p>
     * <p><strong>PT-BR:</strong> Carrega as opções de prestador de serviço no combo box.</p>
     */
    private void jcEmpresa() {
        empresau.jcEmpresa(jCBPrestador);
    }

    /**
     * <p><strong>EN:</strong> Fills the expense table with the registered data.</p>
     * <p><strong>IT:</strong> Compila la tabella delle spese con i dati registrati.</p>
     * <p><strong>PT-BR:</strong> Preenche a tabela de despesas com os dados cadastrados.</p>
     */
    private void tabelaDespesa() {
        despesau.tabelaDespesa(jTDespesa);
    }

    /**
     * <p><strong>EN:</strong> Clears all input fields in the expense form.</p>
     * <p><strong>IT:</strong> Pulisce tutti i campi di input del modulo di spesa.</p>
     * <p><strong>PT-BR:</strong> Limpa todos os campos de entrada do formulário de despesa.</p>
     */
    private void limpaCampos(){
        jTFDespesa.setText(null);
        jFTFValor.setValue(null);
        jCBPrestador.setSelectedIndex(0);
        jCBCategoria.setSelectedIndex(0);
    }
    
    /**
     * <p><strong>EN:</strong> Calculates the total value of all registered expenses  
     * and updates the total label.</p>
     * <p><strong>IT:</strong> Calcola il valore totale di tutte le spese registrate  
     * e aggiorna l'etichetta del totale.</p>
     * <p><strong>PT-BR:</strong> Calcula o valor total de todas as despesas registradas  
     * e atualiza o rótulo do total.</p>
     */
    private void calculaValorTotal(){
        jLTotal.setText("Total: " + Utilidade.formatoValor.format(despesau.calculaDespesaTotal()));
    }
    
    /**
     * <p><strong>EN:</strong> Saves a new expense record with the filled form data.</p>
     * <p><strong>IT:</strong> Salva un nuovo record di spesa con i dati compilati nel modulo.</p>
     * <p><strong>PT-BR:</strong> Salva um novo registro de despesa com os dados preenchidos no formulário.</p>
     */
    private void salvar() {
        despesa = new Despesa();
        despesa.setDs_despesa(jTFDespesa.getText());
        despesa.setNm_valor(Utilidade.converter(jFTFValor.getText()));
        despesa.setEmpresa(empresa);
        despesa.setCategoria(categoria);
        despesa.setCd_usuario(JPLogin.codloginuser);
        despesar.inserir(despesa);
        despesa = null;
    }
    
    /**
     * <p><strong>EN:</strong> Updates an existing expense record with the current form data.</p>
     * <p><strong>IT:</strong> Aggiorna un record di spesa esistente con i dati attuali del modulo.</p>
     * <p><strong>PT-BR:</strong> Atualiza um registro de despesa existente com os dados atuais do formulário.</p>
     */
    private void alterar(){
        despesa.setDs_despesa(jTFDespesa.getText());
        despesa.setNm_valor(Utilidade.converter(jFTFValor.getText()));
        despesa.setEmpresa(empresa);
        despesa.setCategoria(categoria);
        despesar.alterar(despesa);
    }

    /**
     * <p><strong>EN:</strong> Deletes the selected expense record from the database.</p>
     * <p><strong>IT:</strong> Elimina il record di spesa selezionato dal database.</p>
     * <p><strong>PT-BR:</strong> Exclui o registro de despesa selecionado do banco de dados.</p>
     */
    private void excluir(){
        despesa.setCd_despesa(despesa.getCd_despesa());
        despesar.excluir(despesa);
    }
    
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifdespesa = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if (validaCampos()) {
            salvar();
            calculaValorTotal();
            limpaCampos();
            tabelaDespesa();
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jCBPrestadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBPrestadorActionPerformed
        if(jCBPrestador.getSelectedIndex() != 0){
            empresa = (Empresa) jCBPrestador.getSelectedItem();
        }else{
            empresa = null;
        }
    }//GEN-LAST:event_jCBPrestadorActionPerformed

    private void jCBCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBCategoriaActionPerformed
        if(jCBCategoria.getSelectedIndex() != 0){
            categoria = (Categoria) jCBCategoria.getSelectedItem();
        }else{
            categoria = null;
        }
    }//GEN-LAST:event_jCBCategoriaActionPerformed

    private void jTDespesaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTDespesaMouseClicked
        despesa = (Despesa)despesau.getSelectObject(jTDespesa);
        despesa.setCd_despesa(despesa.getCd_despesa());
        jTFDespesa.setText(despesa.getDs_despesa());
        jFTFValor.setText(Utilidade.formatoValor.format(despesa.getNm_valor()));
        jCBPrestador.getModel().setSelectedItem(despesa.getEmpresa());
        jCBCategoria.getModel().setSelectedItem(despesa.getCategoria());
    }//GEN-LAST:event_jTDespesaMouseClicked
    
    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        despesa = (Despesa)despesau.getSelectObject(jTDespesa);
        if(despesa != null){
            alterar();    
            calculaValorTotal();
            limpaCampos();
            tabelaDespesa();
        }
    }//GEN-LAST:event_jBAlterarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        despesa = (Despesa)despesau.getSelectObject(jTDespesa);
        if(despesa != null){
            excluir();
            calculaValorTotal();
            limpaCampos();
            tabelaDespesa();
        }
    }//GEN-LAST:event_jBExcluirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<Categoria> jCBCategoria;
    private javax.swing.JComboBox<Empresa> jCBPrestador;
    private javax.swing.JFormattedTextField jFTFValor;
    private javax.swing.JLabel jLCategoria;
    private javax.swing.JLabel jLDespesa;
    private javax.swing.JLabel jLPrestador;
    private javax.swing.JLabel jLTotal;
    private javax.swing.JLabel jLValor;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JPanel jPGrid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTDespesa;
    private javax.swing.JTextField jTFDespesa;
    // End of variables declaration//GEN-END:variables
}
