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
    
    public static JIFPessoaFisica getInstancia(){
        if (jifpessoafisica == null){
            jifpessoafisica = new JIFPessoaFisica();
            jifpessoafisica.setTitle("Pessoa Física");
        } return jifpessoafisica;
    }

    PessoaFisica pessoafisica = new PessoaFisica();
    PessoaFisicaRepository pessoafisicar = new PessoaFisicaRepository();
    PessoaFisicaUtil pessoafisicau = new PessoaFisicaUtil();
    
    Cidade cidade = null;
    CidadeUtil cidadeu = new CidadeUtil();
        
    Utilidade util = new Utilidade();
    
    public static int codpessoafisica;
    
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

    private void limpaCampos(){
        jTFNome.setText(null);
        jFTFDtNasc.setText(null);
        jCBCidadenatal.setSelectedIndex(0);
        jFTFDocumento.setText(null);
        jTFCnh.setText(null);
        jTFRg.setText(null);
        jTFNome.requestFocus();
    }
                
    private void formatarData() {
        util.formataDataCampo(jFTFDtNasc);
    }
    
    private void formataCampo(){
        util.formataDocumento(jFTFDocumento, 1);
    }
    
    private void jcCidade(){
        cidadeu.jcCidade(jCBCidadenatal);
    }
    
    private void tabelaPessoaFisica(){
        pessoafisicau.tabelaPessoaFisica(jTPessoaFisica);
    }
    
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
