package br.com.rlmoura81.moura.imovelinterface;

import br.com.rlmoura81.moura.imovel.Imovel;
import br.com.rlmoura81.moura.imovel.ImovelRepository;
import br.com.rlmoura81.moura.imovel.ImovelUtil;
import br.com.rlmoura81.moura.imovel.TipoImovel;
import br.com.rlmoura81.moura.imovel.TipoImovelUtil;
import br.com.rlmoura81.moura.principalcadastro.Cidade;
import br.com.rlmoura81.moura.principalcadastro.CidadeUtil;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import javax.swing.JOptionPane;

public class JIFImovel extends javax.swing.JInternalFrame {
    
    private static JIFImovel jifimovel;
    
    public static JIFImovel getInstancia(){
        if(jifimovel == null){
            jifimovel = new JIFImovel();
            jifimovel.setTitle("Imóveis");
        } return jifimovel;
    }

    public static int codIm;
    
    Imovel imovel = null;
    ImovelRepository imovelr = new ImovelRepository();
    ImovelUtil imovelu = new ImovelUtil();
    
    TipoImovel tipoimovel = null;
    TipoImovelUtil tipoimovelu = new TipoImovelUtil();
    
    Cidade cidade = null;
    CidadeUtil cidadeu = new CidadeUtil();
        
    public JIFImovel() {
        initComponents();
        
        formataValor();
        jcTpimovel();
        jcCidade();
        tabelaImovel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPCampos = new javax.swing.JPanel();
        jLTpImovel = new javax.swing.JLabel();
        jCBTpImovel = new javax.swing.JComboBox<>();
        jLMatricula = new javax.swing.JLabel();
        jTFMatricula = new javax.swing.JTextField();
        jLMetragem = new javax.swing.JLabel();
        jLDescricao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTADescricao = new javax.swing.JTextArea();
        jLValorMatricula = new javax.swing.JLabel();
        jFTFMetragem = new javax.swing.JFormattedTextField();
        jFTFValor = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jCBCidade = new javax.swing.JComboBox<>();
        jPBotao = new javax.swing.JPanel();
        jBSalvar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jPGrid = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTImovel = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setToolTipText("");
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
        jPCampos.setPreferredSize(new java.awt.Dimension(375, 150));

        jLTpImovel.setText("Tipo:");

        jCBTpImovel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBTpImovelActionPerformed(evt);
            }
        });

        jLMatricula.setText("Matrícula:");

        jLMetragem.setText("Metragem:");

        jLDescricao.setText("Descrição:");

        jTADescricao.setColumns(20);
        jTADescricao.setRows(5);
        jScrollPane1.setViewportView(jTADescricao);

        jLValorMatricula.setText("Valor:");

        jLabel1.setText("Cidade:");

        jCBCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBCidadeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPCamposLayout = new javax.swing.GroupLayout(jPCampos);
        jPCampos.setLayout(jPCamposLayout);
        jPCamposLayout.setHorizontalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPCamposLayout.createSequentialGroup()
                                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLValorMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLMetragem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPCamposLayout.createSequentialGroup()
                                        .addComponent(jFTFValor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPCamposLayout.createSequentialGroup()
                                        .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTFMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jFTFMetragem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPCamposLayout.createSequentialGroup()
                                                .addComponent(jLTpImovel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jCBTpImovel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPCamposLayout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jCBCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPCamposLayout.setVerticalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLMatricula)
                            .addComponent(jTFMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLMetragem)
                            .addComponent(jFTFMetragem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLTpImovel)
                            .addComponent(jCBTpImovel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jCBCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLValorMatricula)
                    .addComponent(jFTFValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLDescricao)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPBotao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBSalvar.setText("Salvar");
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });

        jBExcluir.setText("Excluir");
        jBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPBotaoLayout = new javax.swing.GroupLayout(jPBotao);
        jPBotao.setLayout(jPBotaoLayout);
        jPBotaoLayout.setHorizontalGroup(
            jPBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBExcluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPBotaoLayout.setVerticalGroup(
            jPBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalvar)
                    .addComponent(jBExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPGrid.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTImovel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTImovel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTImovelMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTImovel);

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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPCampos, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                    .addComponent(jPGrid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPBotao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPBotao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private boolean validaCampos() {
        if(jTFMatricula.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Matrícula em branco.", "Imovel", JOptionPane.INFORMATION_MESSAGE);
            jTFMatricula.requestFocus();
            return false;
        }
        if(jFTFMetragem.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Metragem em branco.", "Imovel", JOptionPane.INFORMATION_MESSAGE);
            jFTFMetragem.requestFocus();
            return false;
        }
        if(jFTFValor.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Valor do imóvel em branco.", "Imovel", JOptionPane.INFORMATION_MESSAGE);
            jFTFValor.requestFocus();
            return false;
        }
        if(tipoimovel == null){
            JOptionPane.showMessageDialog(null, "Selecione o tipo de imóvel.", "Tipo", JOptionPane.INFORMATION_MESSAGE);
            jCBTpImovel.requestFocus();
            return false;
        }
        if(cidade == null){
            JOptionPane.showMessageDialog(null, "Selecione a cidade.", "Cidade", JOptionPane.INFORMATION_MESSAGE);
            jCBCidade.requestFocus();
            return false;
        }
        /*if(jTADescricao.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Descrição em branco.");
            jTADescricao.requestFocus();
            return false;
        }*/
        return true;
    }
    
    private void formataValor() {
        jFTFMetragem.setFormatterFactory(Utilidade.formataValorCampo(ui));
        jFTFValor.setFormatterFactory(Utilidade.formataValorCampo(ui));
    }
    
    private void jcTpimovel(){
        tipoimovelu.jcTpimovel(jCBTpImovel);
    }
    
    private void jcCidade(){
        cidadeu.jcCidade(jCBCidade);
    }
    
    private void limpaCampos(){
        jCBTpImovel.setSelectedIndex(0);
        jCBCidade.setSelectedIndex(0);
        jTFMatricula.setText(null);
        jFTFValor.setValue(null);
        jFTFMetragem.setValue(null);
        jTADescricao.setText(null);
        jBExcluir.setEnabled(false);
    }
    
    private void tabelaImovel(){
        imovelu.tabelaImovel(jTImovel);
    }
    
    private void salvar(){
        if(imovel == null){
            imovel = new Imovel();
            imovel.setTpimovel(tipoimovel);
            imovel.setCidade(cidade);
            imovel.setNm_matricula(jTFMatricula.getText());
            imovel.setNm_metragem(Utilidade.converter(jFTFMetragem.getText()));
            imovel.setNm_valorMatricula(Utilidade.converter(jFTFValor.getText()));        
            imovel.setDs_descricao(jTADescricao.getText());
            imovel.setCd_usuario(JPLogin.codloginuser);        
            imovelr.inserir(imovel);
            imovel = null;
        }else{
            imovel.setTpimovel(tipoimovel);
            imovel.setCidade(cidade);
            imovel.setNm_matricula(jTFMatricula.getText());
            imovel.setNm_metragem(Utilidade.converter(jFTFMetragem.getText()));
            imovel.setNm_valorMatricula(Utilidade.converter(jFTFValor.getText()));        
            imovel.setDs_descricao(jTADescricao.getText());
            imovel.setCd_usuario(JPLogin.codloginuser);        
            imovelr.alterar(imovel);    
            imovel = null;
        }
    }
    
    private void excluir(){
        imovel.setCd_imovel(imovel.getCd_imovel());
        imovel.setCd_usuario(imovel.getCd_usuario());
        imovelr.excluir(imovel);
    }

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if(validaCampos()){
            salvar();
            limpaCampos();
            tabelaImovel();                     
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        if((Imovel)imovelu.getSelectObject(jTImovel) != null){
            excluir();
            limpaCampos();
            tabelaImovel();    
        }        
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jCBTpImovelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBTpImovelActionPerformed
        if(jCBTpImovel.getSelectedIndex() != 0){
            tipoimovel = (TipoImovel) jCBTpImovel.getSelectedItem();
        }else{
            tipoimovel = null;
        }
    }//GEN-LAST:event_jCBTpImovelActionPerformed

    private void jTImovelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTImovelMouseClicked
        imovel = (Imovel)imovelu.getSelectObject(jTImovel);    
        imovel.setCd_imovel(imovel.getCd_imovel());
        jTFMatricula.setText(imovel.getNm_matricula());
        jCBTpImovel.getModel().setSelectedItem(imovel.getTpimovel());
        jCBCidade.getModel().setSelectedItem(imovel.getCidade());
        jFTFValor.setText(Utilidade.formatoValor.format(imovel.getNm_valorMatricula()));
        jFTFMetragem.setText(Utilidade.formatoValor.format(imovel.getNm_metragem()));
        jTADescricao.setText(imovel.getDs_descricao());
        imovel.setCd_usuario(imovel.getCd_usuario());        
        codIm = imovel.getCd_imovel();
    }//GEN-LAST:event_jTImovelMouseClicked
    
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifimovel = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jCBCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBCidadeActionPerformed
        if(jCBCidade.getSelectedIndex() != 0){
            cidade = (Cidade)jCBCidade.getSelectedItem();
        }else{
            cidade = null;
        }
    }//GEN-LAST:event_jCBCidadeActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<Cidade> jCBCidade;
    private javax.swing.JComboBox<TipoImovel> jCBTpImovel;
    private javax.swing.JFormattedTextField jFTFMetragem;
    private javax.swing.JFormattedTextField jFTFValor;
    private javax.swing.JLabel jLDescricao;
    private javax.swing.JLabel jLMatricula;
    private javax.swing.JLabel jLMetragem;
    private javax.swing.JLabel jLTpImovel;
    private javax.swing.JLabel jLValorMatricula;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPBotao;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JPanel jPGrid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTADescricao;
    private javax.swing.JTextField jTFMatricula;
    private javax.swing.JTable jTImovel;
    // End of variables declaration//GEN-END:variables
}
