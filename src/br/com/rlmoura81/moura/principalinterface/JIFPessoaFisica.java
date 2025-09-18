package br.com.rlmoura81.moura.principalinterface;

import br.com.rlmoura81.moura.principalcadastro.Cidade;
import br.com.rlmoura81.moura.principal.PessoaFisica;
import br.com.rlmoura81.moura.principal.PessoaFisicaRepository;
import br.com.rlmoura81.moura.principal.PessoaFisicaUtil;
import br.com.rlmoura81.moura.principalcadastro.CidadeUtil;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import javax.swing.JOptionPane;

public class JIFPessoaFisica extends javax.swing.JInternalFrame {
    
    private static JIFPessoaFisica jifpessoafisica;
    
    /**
     * <p><strong>EN:</strong> Returns the singleton instance of the {@code JIFPessoaFisica} 
     * internal frame. If it does not exist, a new one is created and its title set to "Pessoa Física".</p>
     *
     * <p><strong>IT:</strong> Restituisce l'istanza singleton di {@code JIFPessoaFisica}. 
     * Se non esiste, ne viene creata una nuova e il titolo viene impostato su "Pessoa Física".</p>
     *
     * <p><strong>PT-BR:</strong> Retorna a instância única de {@code JIFPessoaFisica}. 
     * Se não existir, cria uma nova e define o título como "Pessoa Física".</p>
     *
     * @return EN: Unique instance of {@code JIFPessoaFisica}.  
     *         IT/PT-BR: Instância única de {@code JIFPessoaFisica}.
     */
    public static JIFPessoaFisica getInstancia(){
        if (jifpessoafisica == null){
            jifpessoafisica = new JIFPessoaFisica();
            jifpessoafisica.setTitle("Pessoa Física");
        } return jifpessoafisica;
    }

    public static int codpessoafisica;
    
    PessoaFisica pessoafisica = new PessoaFisica();
    PessoaFisicaRepository pessoafisicar = new PessoaFisicaRepository();
    PessoaFisicaUtil pessoafisicau = new PessoaFisicaUtil();    
    Cidade cidade = null;
    CidadeUtil cidadeu = new CidadeUtil();        
    Utilidade util = new Utilidade();
        
    public JIFPessoaFisica() {
        initComponents();
        
        formatarData();   
        formataCampo();       
        jcCidade();
        tabelaPessoaFisica();

        jBEndereco.setEnabled(false);
                                       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPGrid = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTPessoaFisica = new javax.swing.JTable();
        jPCampos = new javax.swing.JPanel();
        jTFRg = new javax.swing.JTextField();
        jLCnh = new javax.swing.JLabel();
        jFTFDtNasc = new javax.swing.JFormattedTextField();
        jTFCnh = new javax.swing.JTextField();
        jLCidadenatal = new javax.swing.JLabel();
        jCBCidadenatal = new javax.swing.JComboBox<>();
        jLNome = new javax.swing.JLabel();
        jTFNome = new javax.swing.JTextField();
        jLDtNasc = new javax.swing.JLabel();
        jLCpf = new javax.swing.JLabel();
        jLRg = new javax.swing.JLabel();
        jFTFDocumento = new javax.swing.JFormattedTextField();
        jPBotoes = new javax.swing.JPanel();
        jBEndereco = new javax.swing.JButton();
        jBSalvar = new javax.swing.JButton();
        jBAlterar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

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

        jPGrid.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTPessoaFisica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTPessoaFisica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTPessoaFisicaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTPessoaFisica);

        javax.swing.GroupLayout jPGridLayout = new javax.swing.GroupLayout(jPGrid);
        jPGrid.setLayout(jPGridLayout);
        jPGridLayout.setHorizontalGroup(
            jPGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPGridLayout.setVerticalGroup(
            jPGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPCampos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLCnh.setText("C.N.H.:");

        jLCidadenatal.setText("Cidade Natal:");

        jCBCidadenatal.setToolTipText("");
        jCBCidadenatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBCidadenatalActionPerformed(evt);
            }
        });

        jLNome.setText("Nome:");

        jLDtNasc.setText("Data Nascimento:");

        jLCpf.setText("CPF:");

        jLRg.setText("R.G.:");

        javax.swing.GroupLayout jPCamposLayout = new javax.swing.GroupLayout(jPCampos);
        jPCampos.setLayout(jPCamposLayout);
        jPCamposLayout.setHorizontalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addComponent(jLCnh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFCnh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLRg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLCpf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFRg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFTFDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addComponent(jLDtNasc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFTFDtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addComponent(jLCidadenatal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBCidadenatal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
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
                    .addComponent(jLCpf)
                    .addComponent(jFTFDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLRg)
                    .addComponent(jTFRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCnh)
                    .addComponent(jTFCnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLCidadenatal)
                            .addComponent(jCBCidadenatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFTFDtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLDtNasc))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPBotoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBEndereco.setText("Endereço");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBEndereco)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPBotoesLayout.setVerticalGroup(
            jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalvar)
                    .addComponent(jBAlterar)
                    .addComponent(jBExcluir)
                    .addComponent(jBEndereco))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPCampos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * <p><strong>EN:</strong> Clears all input fields of the "Pessoa Física" form 
     * and resets focus to the name field.</p>
     *
     * <p><strong>IT:</strong> Pulisce tutti i campi del modulo "Pessoa Física" 
     * e reimposta il focus sul campo nome.</p>
     *
     * <p><strong>PT-BR:</strong> Limpa todos os campos do formulário "Pessoa Física" 
     * e reposiciona o foco no campo nome.</p>
     */
    private void limpaCampos(){
        jTFNome.setText(null);
        jFTFDtNasc.setText(null);
        jCBCidadenatal.setSelectedIndex(0);
        jFTFDocumento.setText(null);
        jTFCnh.setText(null);
        jTFRg.setText(null);
        jTFNome.requestFocus();
    }
            
    /**
     * <p><strong>EN:</strong> Applies a date formatter to the date of birth field.</p>
     *
     * <p><strong>IT:</strong> Applica un formattatore di data al campo della data di nascita.</p>
     *
     * <p><strong>PT-BR:</strong> Aplica um formatador de data ao campo de data de nascimento.</p>
     */    
    private void formatarData() {
        util.formataDataCampo(jFTFDtNasc);
    }
    
    /**
     * <p><strong>EN:</strong> Formats the document field to accept CPF input.</p>
     * <p><strong>IT:</strong> Format il campo documento per accettare l'inserimento del CPF.</p>
     * <p><strong>PT-BR:</strong> Formata o campo de documento para aceitar a entrada de CPF.</p>
     */
    private void formataCampo(){
        util.formataDocumento(jFTFDocumento, 1);
    }
    
    /**
     * <p><strong>EN:</strong> Loads and fills the City combo box with available records.</p>
     * <p><strong>IT:</strong> Carica e popola la casella combinata delle Città con i record disponibili.</p>
     * <p><strong>PT-BR:</strong> Carrega e preenche o combo box de Cidade com os registros disponíveis.</p>
     */
    private void jcCidade(){
        cidadeu.jcCidade(jCBCidadenatal);
    }
    
    /**
     * <p><strong>EN:</strong> Populates the Person table with the list of registered individuals.</p>
     * <p><strong>IT:</strong> Popola la tabella delle Persone con l'elenco degli individui registrati.</p>
     * <p><strong>PT-BR:</strong> Preenche a tabela de Pessoas Físicas com a lista de indivíduos cadastrados.</p>
     */
    private void tabelaPessoaFisica(){
        pessoafisicau.tabelaPessoaFisica(jTPessoaFisica);
    }
    
    /**
     * <p><strong>EN:</strong> Validates if all required fields are filled correctly (Name, Date of Birth, and City).</p>
     * <p><strong>IT:</strong> Convalida se tutti i campi obbligatori sono compilati correttamente (Nome, Data di nascita e Città).</p>
     * <p><strong>PT-BR:</strong> Valida se todos os campos obrigatórios estão preenchidos corretamente (Nome, Data de Nascimento e Cidade).</p>
     */
    private boolean validaCampos(){
        if (jTFNome.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Nome obrigatorio.", "Pessoa Física", JOptionPane.INFORMATION_MESSAGE);
            jTFNome.requestFocus();
            return false;
        }
        if (util.validaDataCampo(jFTFDtNasc.getText()) == false){
            jFTFDtNasc.requestFocus();
            return false;
        }
        if (cidade == null){
            JOptionPane.showMessageDialog(null, "Selecione a cidade natal.", "Pessoa Física", JOptionPane.INFORMATION_MESSAGE);
            jCBCidadenatal.requestFocus();
            return false;
        }
        return true;
    }
    
    /**
     * <p><strong>EN:</strong> Saves a new Person record with the form data into the database.</p>
     * <p><strong>IT:</strong> Salva un nuovo record di Persona con i dati del modulo nel database.</p>
     * <p><strong>PT-BR:</strong> Salva um novo registro de Pessoa Física com os dados do formulário no banco de dados.</p>
     */
    private void salvar(){
        pessoafisica.setDs_Nome(jTFNome.getText());
        pessoafisica.setNm_Cpf(Utilidade.retiraMascaraDocumento(jFTFDocumento.getText()));
        pessoafisica.setNm_Cnh(jTFCnh.getText());
        pessoafisica.setNm_Rg(jTFRg.getText());
        pessoafisica.setDt_Nascimento(util.recebeData(jFTFDtNasc.getText()));
        pessoafisica.setCidade(cidade);
        pessoafisicar.inserir(pessoafisica);      
        pessoafisica = null;
    }
   
    /**
     * <p><strong>EN:</strong> Updates the selected Person record with the new data provided in the form.</p>
     * <p><strong>IT:</strong> Aggiorna il record della Persona selezionata con i nuovi dati forniti nel modulo.</p>
     * <p><strong>PT-BR:</strong> Atualiza o registro da Pessoa Física selecionada com os novos dados fornecidos no formulário.</p>
     */
    private void alterar(){
        pessoafisica.setDs_Nome(jTFNome.getText());
        pessoafisica.setDt_Nascimento(util.recebeData(jFTFDtNasc.getText()));
        pessoafisica.setCidade(cidade);
        pessoafisica.setNm_Cpf(Utilidade.retiraMascaraDocumento(jFTFDocumento.getText()));
        pessoafisica.setNm_Cnh(jTFCnh.getText());
        pessoafisica.setNm_Rg(jTFRg.getText());
        pessoafisicar.alterar(pessoafisica);
        pessoafisica = null;
    }
    
    /**
     * <p><strong>EN:</strong> Deletes the selected Person record from the database.</p>
     * <p><strong>IT:</strong> Elimina il record della Persona selezionata dal database.</p>
     * <p><strong>PT-BR:</strong> Exclui o registro da Pessoa Física selecionada do banco de dados.</p>
     */
    private void excluir(){
        pessoafisica.setCd_Pessoa(pessoafisica.getCd_Pessoa());
        pessoafisicar.excluir(pessoafisica);        
    }
    
    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if (validaCampos()){
            salvar();
            limpaCampos();
            tabelaPessoaFisica();
        }   
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jCBCidadenatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBCidadenatalActionPerformed
        if(jCBCidadenatal.getSelectedIndex() != 0){
            cidade = (Cidade)jCBCidadenatal.getSelectedItem();
        }else{
            cidade = null;
        }
    }//GEN-LAST:event_jCBCidadenatalActionPerformed

    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        if((PessoaFisica)pessoafisicau.getSelectObject(jTPessoaFisica) != null){
            alterar();
            limpaCampos();
            tabelaPessoaFisica();
        }
    }//GEN-LAST:event_jBAlterarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        if((PessoaFisica)pessoafisicau.getSelectObject(jTPessoaFisica) != null){
            excluir();
            tabelaPessoaFisica();
            limpaCampos();
        }        
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jTPessoaFisicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTPessoaFisicaMouseClicked
        pessoafisica = (PessoaFisica)pessoafisicau.getSelectObject(jTPessoaFisica);
        codpessoafisica = pessoafisica.getCd_Pessoa();        
        pessoafisica.setCd_Pessoa(pessoafisica.getCd_Pessoa());
        jTFNome.setText(pessoafisica.getDs_Nome());
        jFTFDtNasc.setText(Utilidade.formatoData.format(pessoafisica.getDt_Nascimento().getTime()));
        jCBCidadenatal.setSelectedItem(pessoafisica.getCidade());
        jFTFDocumento.setText(pessoafisica.getNm_Cpf());
        jTFCnh.setText(pessoafisica.getNm_Cnh());
        jTFRg.setText(pessoafisica.getNm_Rg());  
    }//GEN-LAST:event_jTPessoaFisicaMouseClicked

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifpessoafisica = null;
    }//GEN-LAST:event_formInternalFrameClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBEndereco;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<Cidade> jCBCidadenatal;
    private javax.swing.JFormattedTextField jFTFDocumento;
    private javax.swing.JFormattedTextField jFTFDtNasc;
    private javax.swing.JLabel jLCidadenatal;
    private javax.swing.JLabel jLCnh;
    private javax.swing.JLabel jLCpf;
    private javax.swing.JLabel jLDtNasc;
    private javax.swing.JLabel jLNome;
    private javax.swing.JLabel jLRg;
    private javax.swing.JPanel jPBotoes;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JPanel jPGrid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTFCnh;
    private javax.swing.JTextField jTFNome;
    private javax.swing.JTextField jTFRg;
    private javax.swing.JTable jTPessoaFisica;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
