package br.com.rlmoura81.moura.animalinterface;

import br.com.rlmoura81.moura.animal.Produto;
import br.com.rlmoura81.moura.animal.ProdutoRepository;
import br.com.rlmoura81.moura.animal.ProdutoUtil;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import javax.swing.JOptionPane;

public class JIFProduto extends javax.swing.JInternalFrame {
    
    private static JIFProduto jifproduto;

    /**
     * <p><strong>EN:</strong> Returns the singleton instance of the JIFProduto class.  
     * If no instance exists, a new one is created and initialized.</p>
     *
     * <p><strong>IT:</strong> Restituisce l'istanza singleton della classe JIFProduto.  
     * Se non esiste alcuna istanza, ne viene creata e inizializzata una nuova.</p>
     *
     * <p><strong>PT-BR:</strong> Retorna a instância singleton da classe JIFProduto.  
     * Se não existir nenhuma instância, uma nova é criada e inicializada.</p>
     *
     * @return EN: singleton instance of JIFProduto | IT: istanza singleton di JIFProduto | PT-BR: instância singleton de JIFProduto
     * @since 1.0.0
     */    
    public static JIFProduto getInstancia(){
        if(jifproduto == null){
            jifproduto = new JIFProduto();
            jifproduto.setTitle("Produtos");
        }return jifproduto;
    }
    
    Produto produto = new Produto();
    ProdutoRepository produtor = new ProdutoRepository();
    ProdutoUtil produtou = new ProdutoUtil();
        
    public JIFProduto() {
        initComponents();

        formataValor();
        tabelaProduto();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPCampos = new javax.swing.JPanel();
        jLDescricao = new javax.swing.JLabel();
        jTFDescricao = new javax.swing.JTextField();
        jLPeso = new javax.swing.JLabel();
        jFTFPeso = new javax.swing.JFormattedTextField();
        jPBotoes = new javax.swing.JPanel();
        jBSalvar = new javax.swing.JButton();
        jBAlterar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jPGrid = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTProduto = new javax.swing.JTable();

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

        jLDescricao.setText("Descrição:");

        jLPeso.setText("Peso (Kg):");

        javax.swing.GroupLayout jPCamposLayout = new javax.swing.GroupLayout(jPCampos);
        jPCampos.setLayout(jPCamposLayout);
        jPCamposLayout.setHorizontalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addComponent(jLDescricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addComponent(jLPeso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFTFPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(174, Short.MAX_VALUE))
        );
        jPCamposLayout.setVerticalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLDescricao)
                    .addComponent(jTFDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLPeso)
                    .addComponent(jFTFPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPBotoesLayout = new javax.swing.GroupLayout(jPBotoes);
        jPBotoes.setLayout(jPBotoesLayout);
        jPBotoesLayout.setHorizontalGroup(
            jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBAlterar)
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
                    .addComponent(jBAlterar)
                    .addComponent(jBExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPGrid.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTProduto);

        javax.swing.GroupLayout jPGridLayout = new javax.swing.GroupLayout(jPGrid);
        jPGrid.setLayout(jPGridLayout);
        jPGridLayout.setHorizontalGroup(
            jPGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPGridLayout.setVerticalGroup(
            jPGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
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
                    .addComponent(jPCampos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPBotoes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * <p><strong>EN:</strong> Applies formatting to the weight input field.</p>
     *
     * <p><strong>IT:</strong> Applica la formattazione al campo di input del peso.</p>
     *
     * <p><strong>PT-BR:</strong> Aplica a formatação ao campo de entrada do peso.</p>
     *
     * @since 1.0.0
     */   
    private void formataValor(){
        jFTFPeso.setFormatterFactory(Utilidade.formataValorCampoTres(ui));
    }

    /**
     * <p><strong>EN:</strong> Populates the JTable with the list of products.</p>
     *
     * <p><strong>IT:</strong> Popola la JTable con l'elenco dei prodotti.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche a JTable com a lista de produtos.</p>
     *
     * @since 1.0.0
     */    
    private void tabelaProduto(){
        produtou.tabelaProduto(jTProduto);
    }

    /**
     * <p><strong>EN:</strong> Validates the form fields before saving or updating a product record.</p>
     *
     * <p><strong>IT:</strong> Convalida i campi del modulo prima di salvare o aggiornare un record di prodotto.</p>
     *
     * <p><strong>PT-BR:</strong> Valida os campos do formulário antes de salvar ou atualizar um registro de produto.</p>
     *
     * @return EN: true if all fields are valid, false otherwise | IT: true se tutti i campi sono validi, false altrimenti | PT-BR: true se todos os campos forem válidos, false caso contrário
     * @since 1.0.0
     */    
    private boolean validaCampos(){
        if(jTFDescricao.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campos em branco.", "Produto", JOptionPane.INFORMATION_MESSAGE);
            jTFDescricao.requestFocus();
            return false;
        }
        if(jFTFPeso.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Peso em branco.", "Produto", JOptionPane.INFORMATION_MESSAGE);
            jFTFPeso.requestFocus();
            return false;
        }
        return true;
    }

    /**
     * <p><strong>EN:</strong> Clears all product form fields.</p>
     *
     * <p><strong>IT:</strong> Pulisce tutti i campi del modulo prodotto.</p>
     *
     * <p><strong>PT-BR:</strong> Limpa todos os campos do formulário de produto.</p>
     *
     * @since 1.0.0
     */    
    private void limpaCampos(){
        jTFDescricao.setText(null);
        jFTFPeso.setValue(null);
    }

    /**
     * <p><strong>EN:</strong> Saves a new product record to the database using the form data.</p>
     *
     * <p><strong>IT:</strong> Salva un nuovo record di prodotto nel database utilizzando i dati del modulo.</p>
     *
     * <p><strong>PT-BR:</strong> Salva um novo registro de produto no banco de dados utilizando os dados do formulário.</p>
     *
     * @since 1.0.0
     */    
    private void salvar(){
        produto.setDs_produto(jTFDescricao.getText());
        produto.setNm_peso(Utilidade.converter(jFTFPeso.getText()));
        produto.setCd_usuario(JPLogin.codloginuser);
        produtor.inserir(produto);
    }

    /**
     * <p><strong>EN:</strong> Updates an existing product record in the database using the form data.</p>
     *
     * <p><strong>IT:</strong> Aggiorna un record di prodotto esistente nel database utilizzando i dati del modulo.</p>
     *
     * <p><strong>PT-BR:</strong> Atualiza um registro de produto existente no banco de dados utilizando os dados do formulário.</p>
     *
     * @since 1.0.0
     */    
    private void alterar(){
        produto.setDs_produto(jTFDescricao.getText());
        produto.setNm_peso(Utilidade.converter(jFTFPeso.getText()));
        produto.setCd_usuario(JPLogin.codloginuser);
        produtor.alterar(produto);
    }

    /**
     * <p><strong>EN:</strong> Deletes the current product record from the database.</p>
     *
     * <p><strong>IT:</strong> Elimina il record corrente del prodotto dal database.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui o registro atual do produto no banco de dados.</p>
     *
     * @since 1.0.0
     */    
    private void excluir(){
        produto.setCd_produto(produto.getCd_produto());
        produtor.excluir(produto);
    }
    
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifproduto = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if(validaCampos()){
            salvar();
            limpaCampos();
            tabelaProduto();            
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        if(validaCampos()){
            alterar();
            limpaCampos();
            tabelaProduto();            
        }
    }//GEN-LAST:event_jBAlterarActionPerformed

    private void jTProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProdutoMouseClicked
        produto = (Produto)produtou.getSelectObject(jTProduto);
        jTFDescricao.setText(produto.getDs_produto());
        jFTFPeso.setText(Utilidade.formatoValorTres.format(produto.getNm_peso()));
    }//GEN-LAST:event_jTProdutoMouseClicked

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        if(validaCampos()){
            excluir();
            limpaCampos();
            tabelaProduto();            
        }
    }//GEN-LAST:event_jBExcluirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JFormattedTextField jFTFPeso;
    private javax.swing.JLabel jLDescricao;
    private javax.swing.JLabel jLPeso;
    private javax.swing.JPanel jPBotoes;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JPanel jPGrid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFDescricao;
    private javax.swing.JTable jTProduto;
    // End of variables declaration//GEN-END:variables
}
