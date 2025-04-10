package br.com.rlmoura81.moura.veiculointerface;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.veiculo.Combustivel;
import br.com.rlmoura81.moura.veiculo.Cores;
import br.com.rlmoura81.moura.veiculo.Modelo;
import br.com.rlmoura81.moura.veiculo.ModeloUtil;
import br.com.rlmoura81.moura.veiculo.Veiculo;
import br.com.rlmoura81.moura.veiculo.VeiculoRepository;
import br.com.rlmoura81.moura.veiculo.VeiculoUtil;
import javax.swing.JOptionPane;

public class JIFVeiculo extends javax.swing.JInternalFrame {

    private static JIFVeiculo jifveiculo;
    
    public static JIFVeiculo getInstacia(){
        if(jifveiculo == null){
            jifveiculo = new JIFVeiculo();
            jifveiculo.setTitle("Veiculos");
        }return jifveiculo;
    }
    
    Modelo modelo = null;
    ModeloUtil modelou = new ModeloUtil();
    
    Combustivel combustivel = null;
    
    Cores cor = null;
    
    Veiculo veiculo = new Veiculo();
    VeiculoRepository veiculor = new VeiculoRepository();
    VeiculoUtil veiculou = new VeiculoUtil();
        
    public JIFVeiculo() {
        initComponents();
        
        tabelaVeiculo();
        jcModelo();
        jcCombustivel();
        jcCor();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPCampos = new javax.swing.JPanel();
        jPCamposBox = new javax.swing.JPanel();
        jCBModelo = new javax.swing.JComboBox<>();
        jCBCombustivel = new javax.swing.JComboBox<>();
        jCBCor = new javax.swing.JComboBox<>();
        jLModelo = new javax.swing.JLabel();
        jLCombustivel = new javax.swing.JLabel();
        jLCor = new javax.swing.JLabel();
        jLRenavam = new javax.swing.JLabel();
        jLPlaca = new javax.swing.JLabel();
        jLPotencia = new javax.swing.JLabel();
        jLAnoFabMod = new javax.swing.JLabel();
        jTFRenavam = new javax.swing.JTextField();
        jTFPlaca = new javax.swing.JTextField();
        jTFPotencia = new javax.swing.JTextField();
        jTFAnoFab = new javax.swing.JTextField();
        jTFAnoMod = new javax.swing.JTextField();
        jPBotoes = new javax.swing.JPanel();
        jBSalvar = new javax.swing.JButton();
        jBAlterar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jPGrid = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTVeiculos = new javax.swing.JTable();

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

        jCBModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBModeloActionPerformed(evt);
            }
        });

        jCBCombustivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBCombustivelActionPerformed(evt);
            }
        });

        jCBCor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBCorActionPerformed(evt);
            }
        });

        jLModelo.setText("Modelo:");

        jLCombustivel.setText("Combustivel:");

        jLCor.setText("Cor:");

        javax.swing.GroupLayout jPCamposBoxLayout = new javax.swing.GroupLayout(jPCamposBox);
        jPCamposBox.setLayout(jPCamposBoxLayout);
        jPCamposBoxLayout.setHorizontalGroup(
            jPCamposBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposBoxLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCBModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLModelo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPCamposBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCBCombustivel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLCombustivel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPCamposBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLCor)
                    .addComponent(jCBCor, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPCamposBoxLayout.setVerticalGroup(
            jPCamposBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposBoxLayout.createSequentialGroup()
                .addGroup(jPCamposBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLModelo)
                    .addComponent(jLCombustivel)
                    .addComponent(jLCor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPCamposBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBCombustivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLRenavam.setText("Renavam:");

        jLPlaca.setText("Placa:");

        jLPotencia.setText("Potencia:");

        jLAnoFabMod.setText("Ano Fab/Mod:");

        jTFRenavam.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFRenavamFocusLost(evt);
            }
        });

        jTFPlaca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFPlacaFocusLost(evt);
            }
        });

        jTFPotencia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFPotenciaFocusLost(evt);
            }
        });

        jTFAnoFab.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFAnoFabFocusLost(evt);
            }
        });

        jTFAnoMod.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFAnoModFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPCamposLayout = new javax.swing.GroupLayout(jPCampos);
        jPCampos.setLayout(jPCamposLayout);
        jPCamposLayout.setHorizontalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPCamposBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLAnoFabMod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLPotencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLPlaca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLRenavam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFRenavam, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFPotencia, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPCamposLayout.createSequentialGroup()
                                .addComponent(jTFAnoFab, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFAnoMod, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPCamposLayout.setVerticalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addComponent(jPCamposBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLRenavam)
                            .addComponent(jTFRenavam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLPlaca)
                            .addComponent(jTFPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLPotencia))
                    .addComponent(jTFPotencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLAnoFabMod)
                    .addComponent(jTFAnoFab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFAnoMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPBotoesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalvar)
                    .addComponent(jBAlterar)
                    .addComponent(jBExcluir))
                .addContainerGap())
        );

        jPGrid.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTVeiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTVeiculosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTVeiculos);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void tabelaVeiculo(){
        veiculou.tabelaVeiculo(jTVeiculos);
    }

    private void jcModelo(){
        modelou.jcModelo(jCBModelo);
    }
    
    private void jcCombustivel(){
       veiculou.jcCombusivel(jCBCombustivel);
    }
    
    private void jcCor(){
        veiculou.jcCor(jCBCor);
    }
        
    private boolean validaCampos(){
        if(modelo == null){
            JOptionPane.showMessageDialog(null, "Selecione o modelo.", "Modelo", JOptionPane.INFORMATION_MESSAGE);
            jCBModelo.requestFocus();
            return false;
        }
        if(combustivel == null){
            JOptionPane.showMessageDialog(null, "Selecione o combustivel.", "Combustivel", JOptionPane.INFORMATION_MESSAGE);
            jCBCombustivel.requestFocus();
            return false;
        }
        if(cor == null){
            JOptionPane.showMessageDialog(null, "Selecine a cor.", "Cores", JOptionPane.INFORMATION_MESSAGE);
            jCBCor.requestFocus();
            return false;
        }
        if(jTFRenavam.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Digite o renavam.", "Veiculo", JOptionPane.INFORMATION_MESSAGE);
            jTFRenavam.requestFocus();
            return false;
        }
        if(jTFPlaca.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Digite a placa.", "Veiculo", JOptionPane.INFORMATION_MESSAGE);
            jTFPlaca.requestFocus();
            return false;
        }
        if(jTFPotencia.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Digite a potencia.", "Veiculo", JOptionPane.INFORMATION_MESSAGE);
            jTFPotencia.requestFocus();
            return false;
        }
        if(jTFAnoFab.getText().isEmpty() | jTFAnoMod.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Digite o ano de fabricação e modelo.", "Veiculo", JOptionPane.INFORMATION_MESSAGE);
            jTFAnoFab.requestFocus();
            return false;
        }
        return true;
    }
    
    private void limpaCampos(){
        jCBModelo.setSelectedIndex(0);
        jCBCombustivel.setSelectedIndex(0);
        jCBCor.setSelectedIndex(0);
        jTFRenavam.setText(null);
        jTFPlaca.setText(null);
        jTFPotencia.setText(null);
        jTFAnoFab.setText(null);
        jTFAnoMod.setText(null);
    }
    
    private void salvar(){
        veiculo.setModelo(modelo);
        veiculo.setCombustivel(combustivel);
        veiculo.setCor(cor);
        veiculo.setNm_renavam(jTFRenavam.getText());
        veiculo.setNm_placa(jTFPlaca.getText());
        veiculo.setNm_potencia(Integer.parseInt(jTFPotencia.getText()));
        veiculo.setDt_anofab(Integer.parseInt(jTFAnoFab.getText()));
        veiculo.setDt_anomod(Integer.parseInt(jTFAnoMod.getText()));
        veiculo.setCd_usuario(JPLogin.codloginuser);
        veiculor.inserir(veiculo);
        veiculo = null;
    }
    
    private void alterar(){
        veiculo.setCd_veiculo(veiculo.getCd_veiculo());
        veiculo.setModelo(modelo);
        veiculo.setCombustivel(combustivel);
        veiculo.setCor(cor);
        veiculo.setNm_renavam(jTFRenavam.getText());
        veiculo.setNm_placa(jTFPlaca.getText());
        veiculo.setNm_potencia(Integer.parseInt(jTFPotencia.getText()));
        veiculo.setDt_anofab(Integer.parseInt(jTFAnoFab.getText()));
        veiculo.setDt_anomod(Integer.parseInt(jTFAnoMod.getText()));
        veiculor.alterar(veiculo);
        veiculo = null;
    }
    
    private void excluir(){
        veiculo.setCd_veiculo(veiculo.getCd_veiculo());
        veiculor.excluir(veiculo);
        veiculo = null;
    }
    
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifveiculo = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jTFPotenciaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFPotenciaFocusLost
        try{
            int i = Integer.parseInt(jTFPotencia.getText());
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Somente numeros.", "Veiculo", JOptionPane.ERROR_MESSAGE);
            jTFPotencia.requestFocus();
        }
    }//GEN-LAST:event_jTFPotenciaFocusLost

    private void jTFRenavamFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFRenavamFocusLost
        try{
            int i = Integer.parseInt(jTFRenavam.getText());
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Somente numeros.", "Veiculo", JOptionPane.ERROR_MESSAGE);
            jTFRenavam.requestFocus();
        }
    }//GEN-LAST:event_jTFRenavamFocusLost

    private void jTFPlacaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFPlacaFocusLost
        jTFPlaca.setText(jTFPlaca.getText().toUpperCase());
    }//GEN-LAST:event_jTFPlacaFocusLost

    private void jTFAnoFabFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFAnoFabFocusLost
        try{
            int i = Integer.parseInt(jTFAnoFab.getText());
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Somente numeros.", "Veiculo", JOptionPane.ERROR_MESSAGE);
            jTFAnoFab.requestFocus();
        }
    }//GEN-LAST:event_jTFAnoFabFocusLost

    private void jTFAnoModFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFAnoModFocusLost
        try{
            int i = Integer.parseInt(jTFAnoMod.getText());
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Somente numeros.", "Veiculo", JOptionPane.ERROR_MESSAGE);
            jTFAnoMod.requestFocus();
        }
    }//GEN-LAST:event_jTFAnoModFocusLost

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if(validaCampos()){
            salvar();
            limpaCampos();
            tabelaVeiculo();            
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        veiculo = (Veiculo)veiculou.getSelectObject(jTVeiculos);
        if(veiculo != null){
            alterar();
            limpaCampos();
            tabelaVeiculo();            
        }
    }//GEN-LAST:event_jBAlterarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        veiculo = (Veiculo)veiculou.getSelectObject(jTVeiculos);
        if(veiculo != null){
            excluir();
            limpaCampos();
            tabelaVeiculo();            
        }    
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jCBModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBModeloActionPerformed
        if(jCBModelo.getSelectedIndex() != 0){
            modelo = (Modelo)jCBModelo.getSelectedItem();
        }else{
            modelo = null;
        }
    }//GEN-LAST:event_jCBModeloActionPerformed

    private void jCBCombustivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBCombustivelActionPerformed
        if(jCBCombustivel.getSelectedIndex() != 0){
            combustivel = (Combustivel)jCBCombustivel.getSelectedItem();
        }else{
            combustivel = null;
        }
    }//GEN-LAST:event_jCBCombustivelActionPerformed

    private void jCBCorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBCorActionPerformed
        if(jCBCor.getSelectedIndex() != 0){
            cor = (Cores)jCBCor.getSelectedItem();
        }else{
            cor = null;
        }
    }//GEN-LAST:event_jCBCorActionPerformed

    private void jTVeiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTVeiculosMouseClicked
        veiculo = (Veiculo)veiculou.getSelectObject(jTVeiculos);
        jCBModelo.setSelectedItem(veiculo.getModelo());
        jCBCombustivel.setSelectedItem(veiculo.getCombustivel());
        jCBCor.setSelectedItem(veiculo.getCor());
        jTFRenavam.setText(veiculo.getNm_renavam());
        jTFPlaca.setText(veiculo.getNm_placa());
        jTFPotencia.setText(Integer.toString(veiculo.getNm_potencia()));
        jTFAnoFab.setText(Integer.toString(veiculo.getDt_anofab()));
        jTFAnoMod.setText(Integer.toString(veiculo.getDt_anomod()));
    }//GEN-LAST:event_jTVeiculosMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<Combustivel> jCBCombustivel;
    private javax.swing.JComboBox<Cores> jCBCor;
    private javax.swing.JComboBox<Modelo> jCBModelo;
    private javax.swing.JLabel jLAnoFabMod;
    private javax.swing.JLabel jLCombustivel;
    private javax.swing.JLabel jLCor;
    private javax.swing.JLabel jLModelo;
    private javax.swing.JLabel jLPlaca;
    private javax.swing.JLabel jLPotencia;
    private javax.swing.JLabel jLRenavam;
    private javax.swing.JPanel jPBotoes;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JPanel jPCamposBox;
    private javax.swing.JPanel jPGrid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFAnoFab;
    private javax.swing.JTextField jTFAnoMod;
    private javax.swing.JTextField jTFPlaca;
    private javax.swing.JTextField jTFPotencia;
    private javax.swing.JTextField jTFRenavam;
    private javax.swing.JTable jTVeiculos;
    // End of variables declaration//GEN-END:variables
}
