package br.com.rlmoura81.moura.rpginterface;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.rpg.Diario;
import br.com.rlmoura81.moura.rpg.DiarioRepository;
import br.com.rlmoura81.moura.rpg.DiarioUtil;
import br.com.rlmoura81.moura.rpg.Tarefa;
import br.com.rlmoura81.moura.rpg.TarefaRepository;
import br.com.rlmoura81.moura.rpg.TarefaUtil;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import javax.swing.JOptionPane;

public class JIFRpg extends javax.swing.JInternalFrame {
    
    private static JIFRpg jifrpg;
    
    public static JIFRpg getInstancia(){
        if(jifrpg == null){
            jifrpg = new JIFRpg();
            jifrpg.setTitle("Relatorio de Progresso e Ganhos.");
        }return jifrpg;
    }    
    
    Tarefa tarefa = new Tarefa();
    TarefaRepository tarefar = new TarefaRepository();
    TarefaUtil tarefau = new TarefaUtil();
    
    Diario diario = new Diario();
    DiarioRepository diarior = new DiarioRepository();
    DiarioUtil diariou = new DiarioUtil();

    Diario diariod = new Diario();
    DiarioRepository diariodr = new DiarioRepository();
    DiarioUtil diariodu = new DiarioUtil();
    
    Utilidade util = new Utilidade();
    
    public JIFRpg() {
        initComponents();
        
    }
    
    private void camposRpg(){
        diariodu.tabelaDiarioResumo(jTRelatorioResumo);
        if(jTPRpg.getSelectedIndex() == 0){
            util.formataDataCampo(jFTFData);
            diariou.tabelaDiario(jTRelatorio);
        }
        if(jTPRpg.getSelectedIndex() == 1){
            jFTFPonto.setFormatterFactory(Utilidade.formataValorCampo(ui));
            tarefau.tabelaTarefa(jTRelatorio);
        }  
    }
    
    private void validaTarefa(){
        if(jTPRpg.getSelectedIndex() == 0){
            jTFTarefa.setEnabled(false);
        }
        if(jTPRpg.getSelectedIndex() == 1){
            jTFTarefa.setEnabled(true);
        }
    }
    
    private boolean validarCampos(){
        if(jTPRpg.getSelectedIndex() == 0){
            if(jTFTarefa.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Selecione uma tarefa.");
                return false;
            }
            if(util.validaDataCampo(jFTFData.getText()) == false){
                return false;
            }
        }    
        if(jTPRpg.getSelectedIndex() == 1){
            if(jTFTarefa.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Campo em branco.");
                jTFTarefa.requestFocus();
                return false;
            }
            if(jFTFPonto.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Campo em branco.");
                jFTFPonto.requestFocus();
                return false;
            }
        }
        return true;
    }
    
    private void limparCampos(){
        jTFTarefa.setText(null);
        jFTFData.setText(null);
        jFTFPonto.setValue(null);
        jCBTipoTempo.setSelectedIndex(0);
        tarefa.setCd_tarefa(0);
        diario.setDt_diario(null);
    }
    
    private void salvar(){
        if(jTPRpg.getSelectedIndex() == 0){
            if(diario.getDt_diario() == null){
                diario.setTarefa(tarefa);
                diario.setDt_diario(util.recebeData(jFTFData.getText()));
                diario.setCd_usuario(JPLogin.codloginuser);
                diarior.inserir(diario);
               
            }else{
                diarior.alterar(diario, jFTFData.getText(), Utilidade.formatoData.format(diario.getDt_diario().getTime()));
            }
        }
        if(jTPRpg.getSelectedIndex() == 1){
            tarefa.setDs_tarefa(jTFTarefa.getText());
            tarefa.setNm_valor(Float.valueOf(jFTFPonto.getText().replace(",", ".")));
            tarefa.setTp_tempo(jCBTipoTempo.getSelectedIndex());
            tarefa.setCd_usuario(JPLogin.codloginuser);
            if(tarefa.getCd_tarefa() == 0){
                tarefar.inserir(tarefa);
            }else{
                tarefar.alterar(tarefa);
            }
        }
        camposRpg();
    }
    
    private void excluir(){
        if(jTPRpg.getSelectedIndex() == 0){
            if((Diario)diariou.getSelectObject(jTRelatorio) != null){
                diarior.excluir(diario);
            }
            diariou.tabelaDiario(jTRelatorio);            
        }
        if(jTPRpg.getSelectedIndex() == 1){
            if((Tarefa)tarefau.getSelectObject(jTRelatorio)!= null){
                tarefar.excluir(tarefa);
            }
            tarefau.tabelaTarefa(jTRelatorio);
        }
        diariodu.tabelaDiarioResumo(jTRelatorioResumo);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPGrid = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTRelatorio = new javax.swing.JTable();
        jPBotoes = new javax.swing.JPanel();
        jBSalvar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jBFechaMes = new javax.swing.JButton();
        jTPRpg = new javax.swing.JTabbedPane();
        jPData = new javax.swing.JPanel();
        jLData = new javax.swing.JLabel();
        jFTFData = new javax.swing.JFormattedTextField();
        jPTarefa = new javax.swing.JPanel();
        jLPonto = new javax.swing.JLabel();
        jFTFPonto = new javax.swing.JFormattedTextField();
        jCBTipoTempo = new javax.swing.JComboBox<>();
        jPCampotarefa = new javax.swing.JPanel();
        jLTarefa = new javax.swing.JLabel();
        jTFTarefa = new javax.swing.JTextField();
        jPGridRelResumo = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTRelatorioResumo = new javax.swing.JTable();

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

        jTRelatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTRelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTRelatorioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTRelatorio);

        javax.swing.GroupLayout jPGridLayout = new javax.swing.GroupLayout(jPGrid);
        jPGrid.setLayout(jPGridLayout);
        jPGridLayout.setHorizontalGroup(
            jPGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 965, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPGridLayout.setVerticalGroup(
            jPGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addContainerGap())
        );

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

        jBFechaMes.setText("Fecha Mês");
        jBFechaMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFechaMesActionPerformed(evt);
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
                .addComponent(jBExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBFechaMes)
                .addContainerGap())
        );
        jPBotoesLayout.setVerticalGroup(
            jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalvar)
                    .addComponent(jBExcluir)
                    .addComponent(jBFechaMes))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPData.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPDataComponentShown(evt);
            }
        });

        jLData.setText("Data:");

        javax.swing.GroupLayout jPDataLayout = new javax.swing.GroupLayout(jPData);
        jPData.setLayout(jPDataLayout);
        jPDataLayout.setHorizontalGroup(
            jPDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFData, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(223, Short.MAX_VALUE))
        );
        jPDataLayout.setVerticalGroup(
            jPDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLData)
                    .addComponent(jFTFData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jTPRpg.addTab("Diario", jPData);

        jPTarefa.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPTarefaComponentShown(evt);
            }
        });

        jLPonto.setText("Ponto:");

        jCBTipoTempo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Diaria", "Diaria - Bonus", "Semanal", "Semanal - Bonus" }));

        javax.swing.GroupLayout jPTarefaLayout = new javax.swing.GroupLayout(jPTarefa);
        jPTarefa.setLayout(jPTarefaLayout);
        jPTarefaLayout.setHorizontalGroup(
            jPTarefaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPTarefaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLPonto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFPonto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCBTipoTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPTarefaLayout.setVerticalGroup(
            jPTarefaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPTarefaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPTarefaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFTFPonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBTipoTempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLPonto))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jTPRpg.addTab("Tarefas", jPTarefa);

        jLTarefa.setText("Tarefa:");

        javax.swing.GroupLayout jPCampotarefaLayout = new javax.swing.GroupLayout(jPCampotarefa);
        jPCampotarefa.setLayout(jPCampotarefaLayout);
        jPCampotarefaLayout.setHorizontalGroup(
            jPCampotarefaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCampotarefaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLTarefa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPCampotarefaLayout.setVerticalGroup(
            jPCampotarefaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCampotarefaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCampotarefaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTarefa)
                    .addComponent(jTFTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTRelatorioResumo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTRelatorioResumo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTRelatorioResumoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTRelatorioResumo);

        javax.swing.GroupLayout jPGridRelResumoLayout = new javax.swing.GroupLayout(jPGridRelResumo);
        jPGridRelResumo.setLayout(jPGridRelResumoLayout);
        jPGridRelResumoLayout.setHorizontalGroup(
            jPGridRelResumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridRelResumoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPGridRelResumoLayout.setVerticalGroup(
            jPGridRelResumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridRelResumoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPCampotarefa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTPRpg))
                        .addGap(18, 18, 18)
                        .addComponent(jPGridRelResumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPCampotarefa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTPRpg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPGridRelResumo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifrpg = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jPDataComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPDataComponentShown
        validaTarefa();
        camposRpg();
    }//GEN-LAST:event_jPDataComponentShown

    private void jPTarefaComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPTarefaComponentShown
        validaTarefa();
        camposRpg();
    }//GEN-LAST:event_jPTarefaComponentShown

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if(validarCampos()){
            salvar();
            limparCampos();
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jTRelatorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTRelatorioMouseClicked
        if(jTPRpg.getSelectedIndex() == 0){
            diario = (Diario)diariou.getSelectObject(jTRelatorio);
            jFTFData.setText(Utilidade.formatoData.format(diario.getDt_diario().getTime()));
            jTFTarefa.setText(diario.getTarefa().getDs_tarefa());    
        }
        if(jTPRpg.getSelectedIndex() == 1){        
            tarefa = (Tarefa)tarefau.getSelectObject(jTRelatorio);
            jTFTarefa.setText(tarefa.getDs_tarefa());    
            jFTFPonto.setText(Float.toString(tarefa.getNm_valor()).replace(".", ","));
            jCBTipoTempo.setSelectedIndex(tarefa.getTp_tempo());
        }
    }//GEN-LAST:event_jTRelatorioMouseClicked

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        excluir();
        limparCampos();
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jTRelatorioResumoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTRelatorioResumoMouseClicked
        diariod = (Diario)diariodu.getSelectObject(jTRelatorioResumo);
        jFTFData.setText(Utilidade.formatoData.format(diariod.getDt_diario().getTime()));
        diariou.tabelaDiario(jTRelatorio, Utilidade.formatoData.format(diariod.getDt_diario().getTime()));
    }//GEN-LAST:event_jTRelatorioResumoMouseClicked

    private void jBFechaMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFechaMesActionPerformed
        diario.setCd_usuario(JPLogin.codloginuser);
        diariodr.inserirDiarioMes(diario);
        diariodr.excluirDiario(diario);
        diariodu.tabelaDiario(jTRelatorio);
        diariodu.tabelaDiarioResumo(jTRelatorioResumo);
        JOptionPane.showMessageDialog(null, "Fechado Diário do Mês.");
    }//GEN-LAST:event_jBFechaMesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBFechaMes;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<String> jCBTipoTempo;
    private javax.swing.JFormattedTextField jFTFData;
    private javax.swing.JFormattedTextField jFTFPonto;
    private javax.swing.JLabel jLData;
    private javax.swing.JLabel jLPonto;
    private javax.swing.JLabel jLTarefa;
    private javax.swing.JPanel jPBotoes;
    private javax.swing.JPanel jPCampotarefa;
    private javax.swing.JPanel jPData;
    private javax.swing.JPanel jPGrid;
    private javax.swing.JPanel jPGridRelResumo;
    private javax.swing.JPanel jPTarefa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTFTarefa;
    private javax.swing.JTabbedPane jTPRpg;
    private javax.swing.JTable jTRelatorio;
    private javax.swing.JTable jTRelatorioResumo;
    // End of variables declaration//GEN-END:variables
}
