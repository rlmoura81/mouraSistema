package br.com.rlmoura81.moura.relatoriointerface;

import br.com.rlmoura81.moura.cartao.Cartao;
import br.com.rlmoura81.moura.cartao.CartaoLancamentoFechamentoUtil;
import br.com.rlmoura81.moura.cartao.CartaoLancamentoUtil;
import br.com.rlmoura81.moura.cartao.CartaoUtil;
import br.com.rlmoura81.moura.financeiro.Conta;
import br.com.rlmoura81.moura.financeiro.ContaUtil;
import br.com.rlmoura81.moura.financeiro.DespesaUtil;
import br.com.rlmoura81.moura.financeiro.RendaUtil;
import br.com.rlmoura81.moura.principalcadastro.Grupo;
import br.com.rlmoura81.moura.principalcadastro.GrupoUtil;
import br.com.rlmoura81.moura.relatorio.RelatorioFinanceiroCalculo;
import br.com.rlmoura81.moura.relatorio.RelatorioFinanceiroRepository;
import br.com.rlmoura81.moura.relatorio.RelatorioFinanceiroUtil;
import br.com.rlmoura81.moura.utilidade.CalculoFinanceiro;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.math.BigDecimal;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JIFRelatorioFinanceiro extends javax.swing.JInternalFrame {
    
    private static JIFRelatorioFinanceiro jifrelatoriofin;
        
    public static JIFRelatorioFinanceiro getInstancia(){
        if(jifrelatoriofin == null){
            jifrelatoriofin = new JIFRelatorioFinanceiro();
            jifrelatoriofin.setTitle("Relatorios Financeiros");
        }
        return jifrelatoriofin;
    }
    
    private String data;
    
    RelatorioFinanceiroUtil relatoriofinu = new RelatorioFinanceiroUtil();
    RelatorioFinanceiroCalculo relatoriofinc = new RelatorioFinanceiroCalculo();
    
    RendaUtil rendau = new RendaUtil();
    
    DespesaUtil despesau = new DespesaUtil();
    
    Conta conta = new Conta();
    ContaUtil contau = new ContaUtil();
    
    Cartao cartao = new Cartao();
    CartaoUtil cartaou = new CartaoUtil();
    
    CartaoLancamentoUtil cartaolancu = new CartaoLancamentoUtil();
            
    CartaoLancamentoFechamentoUtil cartaolancfu = new CartaoLancamentoFechamentoUtil();
       
    Grupo grupo = new Grupo();
    GrupoUtil grupou = new GrupoUtil();
    
    Utilidade util = new Utilidade();
    CalculoFinanceiro cf = new CalculoFinanceiro();

    public JIFRelatorioFinanceiro() {   
        initComponents();
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bGFinanceiro = new javax.swing.ButtonGroup();
        jPRelatorio = new javax.swing.JPanel();
        jTPRelatorio = new javax.swing.JTabbedPane();
        jPFinanceiro = new javax.swing.JPanel();
        jChkCredito = new javax.swing.JCheckBox();
        jChkDebito = new javax.swing.JCheckBox();
        jPCartao = new javax.swing.JPanel();
        jCBCartao = new javax.swing.JComboBox<>();
        jChkBFechada = new javax.swing.JCheckBox();
        jCBDtFechada = new javax.swing.JComboBox<>();
        jPCaixa = new javax.swing.JPanel();
        jChkBPeriodo = new javax.swing.JCheckBox();
        jFTFDTInicio = new javax.swing.JFormattedTextField();
        jFTFDTFinal = new javax.swing.JFormattedTextField();
        jCBConta = new javax.swing.JComboBox<>();
        jPRelatorioResumo = new javax.swing.JPanel();
        jLCartao = new javax.swing.JLabel();
        jLCaixa = new javax.swing.JLabel();
        jCBGrupo = new javax.swing.JComboBox<>();
        jLTotal = new javax.swing.JLabel();
        jPGridRelatorioAux = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTRelatorioAuxiliar = new javax.swing.JTable();
        jPCampos = new javax.swing.JPanel();
        jBGerar = new javax.swing.JButton();
        jLValor = new javax.swing.JLabel();
        jPGridRelatorioPrincipal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTRelatorioPrincipal = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(1000, 500));
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

        jPFinanceiro.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPFinanceiroComponentShown(evt);
            }
        });

        bGFinanceiro.add(jChkCredito);
        jChkCredito.setText("Credito");

        bGFinanceiro.add(jChkDebito);
        jChkDebito.setText("Debito");

        javax.swing.GroupLayout jPFinanceiroLayout = new javax.swing.GroupLayout(jPFinanceiro);
        jPFinanceiro.setLayout(jPFinanceiroLayout);
        jPFinanceiroLayout.setHorizontalGroup(
            jPFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFinanceiroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jChkCredito)
                    .addComponent(jChkDebito))
                .addContainerGap(351, Short.MAX_VALUE))
        );
        jPFinanceiroLayout.setVerticalGroup(
            jPFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFinanceiroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jChkCredito)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jChkDebito)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jTPRelatorio.addTab("Financeiro", jPFinanceiro);

        jPCartao.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPCartaoComponentShown(evt);
            }
        });

        jCBCartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBCartaoActionPerformed(evt);
            }
        });

        jChkBFechada.setText("Fechada");
        jChkBFechada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChkBFechadaActionPerformed(evt);
            }
        });

        jCBDtFechada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBDtFechadaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPCartaoLayout = new javax.swing.GroupLayout(jPCartao);
        jPCartao.setLayout(jPCartaoLayout);
        jPCartaoLayout.setHorizontalGroup(
            jPCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCartaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCBCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPCartaoLayout.createSequentialGroup()
                        .addComponent(jChkBFechada)
                        .addGap(18, 18, 18)
                        .addComponent(jCBDtFechada, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(163, Short.MAX_VALUE))
        );
        jPCartaoLayout.setVerticalGroup(
            jPCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCartaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCBCartao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jChkBFechada)
                    .addComponent(jCBDtFechada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jTPRelatorio.addTab("Cartão", jPCartao);

        jPCaixa.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPCaixaComponentShown(evt);
            }
        });

        jChkBPeriodo.setText("Periodo");
        jChkBPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChkBPeriodoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPCaixaLayout = new javax.swing.GroupLayout(jPCaixa);
        jPCaixa.setLayout(jPCaixaLayout);
        jPCaixaLayout.setHorizontalGroup(
            jPCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCaixaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jChkBPeriodo)
                    .addGroup(jPCaixaLayout.createSequentialGroup()
                        .addComponent(jFTFDTInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jFTFDTFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(201, Short.MAX_VALUE))
        );
        jPCaixaLayout.setVerticalGroup(
            jPCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCaixaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jChkBPeriodo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFTFDTInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFTFDTFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jTPRelatorio.addTab("Caixa", jPCaixa);

        jCBConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBContaActionPerformed(evt);
            }
        });

        jLCartao.setText("Cartão:");

        jLCaixa.setText("Caixa:");

        jCBGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBGrupoActionPerformed(evt);
            }
        });

        jLTotal.setText("Total:");

        javax.swing.GroupLayout jPRelatorioResumoLayout = new javax.swing.GroupLayout(jPRelatorioResumo);
        jPRelatorioResumo.setLayout(jPRelatorioResumoLayout);
        jPRelatorioResumoLayout.setHorizontalGroup(
            jPRelatorioResumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPRelatorioResumoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPRelatorioResumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLCartao)
                    .addComponent(jLCaixa)
                    .addComponent(jCBGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLTotal))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPRelatorioResumoLayout.setVerticalGroup(
            jPRelatorioResumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPRelatorioResumoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCBGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLCartao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLCaixa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLTotal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTRelatorioAuxiliar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTRelatorioAuxiliar);

        javax.swing.GroupLayout jPGridRelatorioAuxLayout = new javax.swing.GroupLayout(jPGridRelatorioAux);
        jPGridRelatorioAux.setLayout(jPGridRelatorioAuxLayout);
        jPGridRelatorioAuxLayout.setHorizontalGroup(
            jPGridRelatorioAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridRelatorioAuxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPGridRelatorioAuxLayout.setVerticalGroup(
            jPGridRelatorioAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridRelatorioAuxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPRelatorioLayout = new javax.swing.GroupLayout(jPRelatorio);
        jPRelatorio.setLayout(jPRelatorioLayout);
        jPRelatorioLayout.setHorizontalGroup(
            jPRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPRelatorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCBConta, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPRelatorioLayout.createSequentialGroup()
                        .addComponent(jTPRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPRelatorioResumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPGridRelatorioAux, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPRelatorioLayout.setVerticalGroup(
            jPRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPRelatorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPGridRelatorioAux, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPRelatorioLayout.createSequentialGroup()
                        .addComponent(jCBConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPRelatorioResumo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTPRelatorio))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBGerar.setText("Gerar");
        jBGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGerarActionPerformed(evt);
            }
        });

        jLValor.setText("Valor:");

        javax.swing.GroupLayout jPCamposLayout = new javax.swing.GroupLayout(jPCampos);
        jPCampos.setLayout(jPCamposLayout);
        jPCamposLayout.setHorizontalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBGerar)
                .addGap(18, 18, 18)
                .addComponent(jLValor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPCamposLayout.setVerticalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBGerar)
                    .addComponent(jLValor))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTRelatorioPrincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTRelatorioPrincipal.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTRelatorioPrincipalComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(jTRelatorioPrincipal);

        javax.swing.GroupLayout jPGridRelatorioPrincipalLayout = new javax.swing.GroupLayout(jPGridRelatorioPrincipal);
        jPGridRelatorioPrincipal.setLayout(jPGridRelatorioPrincipalLayout);
        jPGridRelatorioPrincipalLayout.setHorizontalGroup(
            jPGridRelatorioPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridRelatorioPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPGridRelatorioPrincipalLayout.setVerticalGroup(
            jPGridRelatorioPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPGridRelatorioPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPGridRelatorioPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPGridRelatorioPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jcConta(){
        contau.jcConta(jCBConta);
    }
    
    private void jcCartao(){
        if(this.cartao == null){
            cartaou.jcCartao(jCBCartao, conta.getBanco().getCd_banco());
        }else{
            jCBCartao.removeAllItems();
            cartaou.jcCartao(jCBCartao, conta.getBanco().getCd_banco());
        }
        campoChkCartao();        
    }
    
    private void jcGrupo(){
        if(this.grupo == null){
            grupou.jcGrupo(jCBGrupo);            
        }else{
            jCBGrupo.removeAllItems();
            grupou.jcGrupo(jCBGrupo);
        }
    }
    
    private void campoFinanceiroRel(){
        jChkCredito.setText("Crédito: " + Utilidade.formatoValor.format(rendau.calculaRendaTotal()));
        jChkDebito.setText("Débito: " + Utilidade.formatoValor.format(despesau.calculaDespesaTotal()));
    }
    
    private void campoCartaoRel(){
        if(jCBConta.isVisible() == true){
            if(conta.getCd_conta() == 0){
                jCBCartao.removeAllItems();
                jCBCartao.setEnabled(false);
                campoChkCartao();
                jLValor.setText("Valor:");
                relatoriofinu.tabelaRelatorioCartaoLanc(jTRelatorioPrincipal, 0, 0);
            }else{
                jCBCartao.setEnabled(true);
                jcCartao();
            }            
        }
        jCBGrupo.setSelectedIndex(0);
    }
    
    private void campoChkCartao(){
        if(this.cartao == null || cartao.getCd_cartao() == 0){
            jChkBFechada.setSelected(false);
            jChkBFechada.setEnabled(false);
        }else{
            jChkBFechada.setEnabled(true);
        }
        jcFechada();        
    }
    
    private void jcFechada(){
        if(this.cartao != null && jChkBFechada.isSelected() == true){
            jCBDtFechada.setEnabled(true);
            cartaolancfu.jcDataFechamento(jCBDtFechada, cartao.getCd_cartao());
        }else{
            jCBDtFechada.removeAllItems();
            jCBDtFechada.setEnabled(false);
            data = null;
        }
    }
    
    private void campoMovCxRel(){
        if(jCBConta.isVisible() == true){
            if((conta).getCd_conta() == 0){
                relatoriofinu.tabelaRelatorioConta(jTRelatorioPrincipal, 0, 0);
            }
            campoChkPeriodo();                
        }   
        jCBGrupo.setSelectedIndex(0);
    }
    
    private void campoChkPeriodo(){
        if(this.conta == null || conta.getCd_conta() == 0){
            jChkBPeriodo.setSelected(false);
            jChkBPeriodo.setEnabled(false);

        }else{
            jChkBPeriodo.setEnabled(true);
        }
        campoDtFiltro();
    }
    
    private void campoDtFiltro(){
        if(this.conta != null && jChkBPeriodo.isSelected() == true){
            jFTFDTInicio.setEnabled(true);
            jFTFDTFinal.setEnabled(true);
            util.formataDataCampo(jFTFDTInicio);
            util.formataDataCampo(jFTFDTFinal);  
            jFTFDTInicio.requestFocus();
        }else{
            jFTFDTInicio.setText(null);
            jFTFDTFinal.setText(null);
            jFTFDTInicio.setEnabled(false);
            jFTFDTFinal.setEnabled(false);            
        }
    }
    
    private void campoRelatorioGrupo(){
        if(grupo.getCd_grupo() != 0){
            BigDecimal vl_cartao = relatoriofinc.calculaValorCartao(this.cartao.getCd_cartao(), this.grupo.getCd_grupo());
            BigDecimal vl_caixa = relatoriofinc.calculaValorCaixa(this.grupo.getCd_grupo());
            jLCartao.setText("Cartão: " + Utilidade.formatoValor.format(vl_cartao));
            jLCaixa.setText("Caixa: " + Utilidade.formatoValor.format(vl_caixa));   
            jLTotal.setText("Total: " + Utilidade.formatoValor.format(vl_caixa.add(vl_cartao)));
        }
    }
    
    private void limpaCampoRelResumo(){
        BigDecimal vl_cartao = null;
        BigDecimal vl_caixa = null;
        jLCartao.setText("Cartão:");
        jLCaixa.setText("Caixa:");
        jLTotal.setText("Total:");
    }
    
    private void gerarRelatorio(){
        BigDecimal valor1;
        BigDecimal valor2;
        if(jTPRelatorio.getSelectedIndex() == 0){            
            if(jChkCredito.isSelected() == true){
                rendau.tabelaRenda(jTRelatorioPrincipal);
            }
            if(jChkDebito.isSelected() == true){
                if(jCBGrupo.getSelectedIndex() == 0){
                    despesau.tabelaDespesa(jTRelatorioPrincipal);                    
                }else{
                    campoRelatorioGrupo();
                    valor1 = despesau.calculaDespesaGrupo(grupo.getCd_grupo());
                    valor2 = relatoriofinc.calculaValorDespesa(grupo.getCd_grupo());
                    if(valor1.equals(0)){
                        jLValor.setText("Total: " + Utilidade.formatoValor.format(valor1));
                    }else{
                        jLValor.setText("Total: " + Utilidade.formatoValor.format(valor1) + " Consumo: " +
                                Utilidade.formatoValor.format(cf.calculaPorcentageValores(valor2, valor1)) + "%");                        
                    }
                    relatoriofinu.tabelaRelatorioDespesa(jTRelatorioPrincipal, grupo.getCd_grupo());
                }
            }
        }
        if(jTPRelatorio.getSelectedIndex() == 1){
            if(jChkBFechada.isSelected() == true){
                relatoriofinu.tabelaRelatorioCartaoFechamento(jTRelatorioPrincipal, cartao.getCd_cartao(), data);                 
                jLTotal.setText("Total: " + Utilidade.formatoValor.format(cartaolancfu.calculaValorFatura(util.recebeData(data), cartao.getCd_cartao())));
            }else{
                if(jCBGrupo.getSelectedIndex() == 0){   
                    jLValor.setText("Total: " + Utilidade.formatoValor.format(cartaolancu.calculaValorFatura(cartao.getCd_cartao())));
                }else{
                    campoRelatorioGrupo();
                    valor1 = cartaolancu.calculaValorFatura(cartao.getCd_cartao());
                    valor2 = relatoriofinc.calculaValorCartao(cartao.getCd_cartao(),grupo.getCd_grupo());
                    if(valor1.equals(0)){
                        jLValor.setText("Total: " + Utilidade.formatoValor.format(valor1));
                    }else{
                        jLValor.setText("Total: " + Utilidade.formatoValor.format(valor1) + " Consumo: " +
                            Utilidade.formatoValor.format(cf.calculaPorcentagem(valor1, valor2)) + "%");
                    }
                    
                }
                relatoriofinu.tabelaRelatorioCartaoLanc(jTRelatorioPrincipal, cartao.getCd_cartao(), grupo.getCd_grupo());                 
            }
        }        
        if(jTPRelatorio.getSelectedIndex() == 2){
            if(jChkBPeriodo.isSelected() == true){
                if(util.validaDataCampo(jFTFDTInicio.getText()) && util.validaDataCampo(jFTFDTFinal.getText())){
                    relatoriofinu.tabelaRelatorioContaPeriodo(jTRelatorioPrincipal, conta.getCd_conta(), jFTFDTInicio.getText(), jFTFDTFinal.getText());   
                    jLTotal.setText("Total: " 
                            + Utilidade.formatoValor.format(relatoriofinc.calcularValorCaixaPeriodo(conta.getCd_conta(), jFTFDTInicio.getText(), jFTFDTFinal.getText())));                }
            }else{
                if(jCBGrupo.getSelectedIndex() == 0){
                    jLValor.setText("Total: " + Utilidade.formatoValor.format(relatoriofinc.calcularValorContaCaixa(conta.getCd_conta())));                   
                }else{
                    campoRelatorioGrupo();
                    valor1 = relatoriofinc.calcularValorContaCaixa(conta.getCd_conta());
                    valor2 = relatoriofinc.calculaValorCaixa(grupo.getCd_grupo());
                    if(valor1.equals(0)){
                        jLValor.setText("Total: " + Utilidade.formatoValor.format(valor1));
                    }else{
                        jLValor.setText("Total: " + Utilidade.formatoValor.format(valor1) + " Consumo: " +
                            Utilidade.formatoValor.format(cf.calculaPorcentagem(valor1, valor2)) + "%");
                    }
                }
                relatoriofinu.tabelaRelatorioConta(jTRelatorioPrincipal, conta.getCd_conta(), grupo.getCd_grupo());
            }
        }
    }

    private boolean validaCampos(){
        if(jTPRelatorio.getSelectedIndex() == 0){

        }
        if(jTPRelatorio.getSelectedIndex() == 1){
            if((conta).getCd_conta() == 0 || (cartao).getCd_cartao() == 0){
                JOptionPane.showMessageDialog(null, "Campo em branco.");
                return false;
            }
            if(jChkBFechada.isSelected() == true &&  jCBDtFechada.getSelectedIndex() == 0){
                JOptionPane.showMessageDialog(null, "Data fechamento.");
                return false;
            }
        }
        if(jTPRelatorio.getSelectedIndex() == 2){
            if((conta).getCd_conta() == 0){
                JOptionPane.showMessageDialog(null, "Campo em branco.");
                return false;
            }
        }        
        return true;
    }
    
    private void limpaCampo(){
        jLValor.setText("Valor:");
        ((DefaultTableModel)jTRelatorioPrincipal.getModel()).setRowCount(0);
        limpaCampoRelResumo();
    }
    
    private void jBGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGerarActionPerformed
        if(validaCampos()){
            gerarRelatorio();
        }
    }//GEN-LAST:event_jBGerarActionPerformed

    private void jCBContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBContaActionPerformed
        conta = (Conta)jCBConta.getSelectedItem();
        campoCartaoRel();
        campoMovCxRel();
    }//GEN-LAST:event_jCBContaActionPerformed

    private void jCBCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBCartaoActionPerformed
        cartao = (Cartao)jCBCartao.getSelectedItem();
        campoChkCartao();
    }//GEN-LAST:event_jCBCartaoActionPerformed

    private void jChkBFechadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChkBFechadaActionPerformed
        campoChkCartao();
    }//GEN-LAST:event_jChkBFechadaActionPerformed

    private void jCBDtFechadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBDtFechadaActionPerformed
        if(jCBDtFechada.getSelectedIndex() > 0){
            data = jCBDtFechada.getSelectedItem().toString();            
        }
    }//GEN-LAST:event_jCBDtFechadaActionPerformed

    private void jPCartaoComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPCartaoComponentShown
        jCBConta.setVisible(true);
        if(jCBConta.getSelectedItem() == null){
            jcConta();
        }   
        campoCartaoRel();
        limpaCampo();    
        relatoriofinu.tabelaRelatorioCartaoLanc(jTRelatorioPrincipal, 0, 0);
    }//GEN-LAST:event_jPCartaoComponentShown

    private void jPCaixaComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPCaixaComponentShown
        jCBConta.setVisible(true);
        if(jCBConta.getSelectedItem() == null){
            jcConta();
        }
        campoMovCxRel();
        limpaCampo();
        relatoriofinu.tabelaRelatorioConta(jTRelatorioPrincipal, 0, 0);
    }//GEN-LAST:event_jPCaixaComponentShown

    private void jTRelatorioPrincipalComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTRelatorioPrincipalComponentShown
        jTRelatorioPrincipal.setAutoCreateRowSorter(true);
    }//GEN-LAST:event_jTRelatorioPrincipalComponentShown

    private void jPFinanceiroComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPFinanceiroComponentShown
        jCBConta.setVisible(false);      
        campoFinanceiroRel();
        limpaCampo();
        jcGrupo();
        relatoriofinu.tabelaRelatorioContasSaldo(jTRelatorioAuxiliar, 1); 
    }//GEN-LAST:event_jPFinanceiroComponentShown

    private void jChkBPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChkBPeriodoActionPerformed
        campoChkPeriodo();
    }//GEN-LAST:event_jChkBPeriodoActionPerformed

    private void jCBGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBGrupoActionPerformed
        grupo = (Grupo)jCBGrupo.getSelectedItem();
        if(jCBGrupo.getSelectedIndex() == 0){
            jLCartao.setText("Cartão:");
            jLCaixa.setText("Caixa:");
            jLTotal.setText("Total:");
        }
    }//GEN-LAST:event_jCBGrupoActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifrelatoriofin = null;
    }//GEN-LAST:event_formInternalFrameClosed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bGFinanceiro;
    private javax.swing.JButton jBGerar;
    private javax.swing.JComboBox<String> jCBCartao;
    private javax.swing.JComboBox<String> jCBConta;
    private javax.swing.JComboBox<String> jCBDtFechada;
    private javax.swing.JComboBox<String> jCBGrupo;
    private javax.swing.JCheckBox jChkBFechada;
    private javax.swing.JCheckBox jChkBPeriodo;
    private javax.swing.JCheckBox jChkCredito;
    private javax.swing.JCheckBox jChkDebito;
    private javax.swing.JFormattedTextField jFTFDTFinal;
    private javax.swing.JFormattedTextField jFTFDTInicio;
    private javax.swing.JLabel jLCaixa;
    private javax.swing.JLabel jLCartao;
    private javax.swing.JLabel jLTotal;
    private javax.swing.JLabel jLValor;
    private javax.swing.JPanel jPCaixa;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JPanel jPCartao;
    private javax.swing.JPanel jPFinanceiro;
    private javax.swing.JPanel jPGridRelatorioAux;
    private javax.swing.JPanel jPGridRelatorioPrincipal;
    private javax.swing.JPanel jPRelatorio;
    private javax.swing.JPanel jPRelatorioResumo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTPRelatorio;
    private javax.swing.JTable jTRelatorioAuxiliar;
    private javax.swing.JTable jTRelatorioPrincipal;
    // End of variables declaration//GEN-END:variables
}
