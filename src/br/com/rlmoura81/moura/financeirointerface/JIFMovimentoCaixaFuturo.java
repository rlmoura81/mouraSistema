package br.com.rlmoura81.moura.financeirointerface;

import br.com.rlmoura81.moura.financeiro.Conta;
import br.com.rlmoura81.moura.financeiro.ContaSaldo;
import br.com.rlmoura81.moura.financeiro.ContaSaldoRepository;
import br.com.rlmoura81.moura.financeiro.ContaUtil;
import br.com.rlmoura81.moura.financeiro.Despesa;
import br.com.rlmoura81.moura.financeiro.DespesaUtil;
import br.com.rlmoura81.moura.financeiro.GrupoTransacao;
import br.com.rlmoura81.moura.financeiro.MovimentoCaixa;
import br.com.rlmoura81.moura.financeiro.MovimentoCaixaRepository;
import br.com.rlmoura81.moura.financeiro.MovimentoCaixaUtil;
import br.com.rlmoura81.moura.financeiro.Renda;
import br.com.rlmoura81.moura.financeiro.RendaUtil;
import br.com.rlmoura81.moura.financeiro.TipoTransacao;
import br.com.rlmoura81.moura.financeiro.TipoTransacaoUtil;
import br.com.rlmoura81.moura.principalcadastro.Categoria;
import br.com.rlmoura81.moura.principalcadastro.CategoriaUtil;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.math.BigDecimal;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class JIFMovimentoCaixaFuturo extends javax.swing.JInternalFrame {

    private static JIFMovimentoCaixaFuturo jifmovcxf;
    
    public static JIFMovimentoCaixaFuturo getInstancia(){
        if(jifmovcxf == null){
            jifmovcxf = new JIFMovimentoCaixaFuturo();
            jifmovcxf.setTitle("Movimento Caixa Lançamentos Futuros.");
        }
        return jifmovcxf;
    }
    
    Conta conta = null;
    ContaUtil contau = new ContaUtil();
    
    ContaSaldo csaldo = new ContaSaldo();
    ContaSaldoRepository csaldor = new ContaSaldoRepository();
    
    Categoria categoria = new Categoria();
    CategoriaUtil categoriau = new CategoriaUtil();
    
    Renda renda = new Renda();
    RendaUtil rendau = new RendaUtil();
    
    Despesa despesa = new Despesa();
    DespesaUtil despesau = new DespesaUtil();
    
    GrupoTransacao gptrans = new GrupoTransacao();
    
    TipoTransacao tptrans = new TipoTransacao();
    TipoTransacaoUtil tptransu = new TipoTransacaoUtil();
    
    MovimentoCaixa movcx = new MovimentoCaixa();
    MovimentoCaixaRepository movcxr = new MovimentoCaixaRepository();
    MovimentoCaixaUtil movcxu = new MovimentoCaixaUtil();
    
    Utilidade util = new Utilidade();
    
    public JIFMovimentoCaixaFuturo() {
        initComponents();
        
        formataValor();
        formatarData();
        
        jcConta();
        jcCategoria();
        jcRenda();
        jcDespesa();
        jcTpTrans();
        
        campoGpTransacao();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bGTransacao = new javax.swing.ButtonGroup();
        jPConta = new javax.swing.JPanel();
        jCBConta = new javax.swing.JComboBox<>();
        jLSaldo = new javax.swing.JLabel();
        jPTransacao = new javax.swing.JPanel();
        jCBRenda = new javax.swing.JComboBox<>();
        jChkBCredito = new javax.swing.JCheckBox();
        jCBDespesa = new javax.swing.JComboBox<>();
        jChkBDebito = new javax.swing.JCheckBox();
        jPCamposLanc = new javax.swing.JPanel();
        jLCredito = new javax.swing.JLabel();
        jLDebito = new javax.swing.JLabel();
        jLTotalCredDeb = new javax.swing.JLabel();
        jLSaldoFinal = new javax.swing.JLabel();
        jPCampos = new javax.swing.JPanel();
        jLData = new javax.swing.JLabel();
        jLDescricao = new javax.swing.JLabel();
        jTFDescricao = new javax.swing.JTextField();
        jLDocumento = new javax.swing.JLabel();
        jTFDocumento = new javax.swing.JTextField();
        jFTFValor = new javax.swing.JFormattedTextField();
        jLValor = new javax.swing.JLabel();
        jCBCategoria = new javax.swing.JComboBox<>();
        jBSalvar = new javax.swing.JButton();
        jCBTpTransacao = new javax.swing.JComboBox<>();
        jFTFData = new javax.swing.JFormattedTextField();
        jBExcluir = new javax.swing.JButton();
        jPGrid = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTLancamento = new javax.swing.JTable();
        jPLancFuturo = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTLancamentoFuturo = new javax.swing.JTable();

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

        jPConta.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jCBConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBContaActionPerformed(evt);
            }
        });

        jLSaldo.setText("Saldo:");

        javax.swing.GroupLayout jPContaLayout = new javax.swing.GroupLayout(jPConta);
        jPConta.setLayout(jPContaLayout);
        jPContaLayout.setHorizontalGroup(
            jPContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPContaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCBConta, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLSaldo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPContaLayout.setVerticalGroup(
            jPContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPContaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLSaldo))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPTransacao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jCBRenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBRendaActionPerformed(evt);
            }
        });

        bGTransacao.add(jChkBCredito);
        jChkBCredito.setText("Crédito:");
        jChkBCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChkBCreditoActionPerformed(evt);
            }
        });

        jCBDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBDespesaActionPerformed(evt);
            }
        });

        bGTransacao.add(jChkBDebito);
        jChkBDebito.setText("Débito:");
        jChkBDebito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChkBDebitoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPTransacaoLayout = new javax.swing.GroupLayout(jPTransacao);
        jPTransacao.setLayout(jPTransacaoLayout);
        jPTransacaoLayout.setHorizontalGroup(
            jPTransacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPTransacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPTransacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jChkBDebito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jChkBCredito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPTransacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCBDespesa, 0, 411, Short.MAX_VALUE)
                    .addComponent(jCBRenda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPTransacaoLayout.setVerticalGroup(
            jPTransacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPTransacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPTransacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jChkBCredito)
                    .addComponent(jCBRenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPTransacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jChkBDebito)
                    .addComponent(jCBDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPCamposLanc.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLCredito.setText("Crédito:");

        jLDebito.setText("Débito:");

        jLTotalCredDeb.setText("Total:");

        jLSaldoFinal.setText("Saldo Final:");

        javax.swing.GroupLayout jPCamposLancLayout = new javax.swing.GroupLayout(jPCamposLanc);
        jPCamposLanc.setLayout(jPCamposLancLayout);
        jPCamposLancLayout.setHorizontalGroup(
            jPCamposLancLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLancLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLCredito)
                .addGap(18, 18, 18)
                .addComponent(jLDebito)
                .addGap(18, 18, 18)
                .addComponent(jLTotalCredDeb)
                .addGap(18, 18, 18)
                .addComponent(jLSaldoFinal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPCamposLancLayout.setVerticalGroup(
            jPCamposLancLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLancLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLancLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCredito)
                    .addComponent(jLDebito)
                    .addComponent(jLTotalCredDeb)
                    .addComponent(jLSaldoFinal))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPCampos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLData.setText("Data:");

        jLDescricao.setText("Descrição:");

        jLDocumento.setText("Documento:");

        jFTFValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));

        jLValor.setText("Valor:");

        jCBCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBCategoriaActionPerformed(evt);
            }
        });

        jBSalvar.setText("Salvar");
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });

        jCBTpTransacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBTpTransacaoActionPerformed(evt);
            }
        });

        jBExcluir.setText("Excluir");
        jBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPCamposLayout = new javax.swing.GroupLayout(jPCampos);
        jPCampos.setLayout(jPCamposLayout);
        jPCamposLayout.setHorizontalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFData, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLDocumento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLValor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFValor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCBTpTransacao, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBExcluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPCamposLayout.setVerticalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLData)
                    .addComponent(jLDescricao)
                    .addComponent(jTFDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLDocumento)
                    .addComponent(jTFDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFTFValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLValor)
                    .addComponent(jCBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBSalvar)
                    .addComponent(jCBTpTransacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFTFData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPGrid.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTLancamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTLancamento);

        javax.swing.GroupLayout jPGridLayout = new javax.swing.GroupLayout(jPGrid);
        jPGrid.setLayout(jPGridLayout);
        jPGridLayout.setHorizontalGroup(
            jPGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPGridLayout.setVerticalGroup(
            jPGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPLancFuturo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTLancamentoFuturo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTLancamentoFuturo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTLancamentoFuturoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTLancamentoFuturo);

        javax.swing.GroupLayout jPLancFuturoLayout = new javax.swing.GroupLayout(jPLancFuturo);
        jPLancFuturo.setLayout(jPLancFuturoLayout);
        jPLancFuturoLayout.setHorizontalGroup(
            jPLancFuturoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPLancFuturoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPLancFuturoLayout.setVerticalGroup(
            jPLancFuturoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPLancFuturoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPConta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPCamposLanc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPTransacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPLancFuturo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPTransacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPGrid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPCamposLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPLancFuturo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formatarData(){
        util.formataDataCampo(jFTFData);       
    }
    
    private void formataValor() {
        jFTFValor.setFormatterFactory(Utilidade.formataValorCampo(ui));
    }

    private void jcConta(){
        contau.jcConta(jCBConta);
    }
    
    private void jcCategoria() {
        categoriau.jcCategoria(jCBCategoria);
    } 
    
    private void jcRenda(){
        rendau.jcRenda(jCBRenda);
    }
    private void jcDespesa(){
        despesau.jcDespesa(jCBDespesa);
    }
    
    private void jcTpTrans(){
        jCBTpTransacao.removeAllItems();
        tptransu.jcTpTransCredDeb(jCBTpTransacao, gptrans.getCd_gptrans());
    }
    
    private void limpaCampos(){
        bGTransacao.clearSelection();
        jCBRenda.setSelectedIndex(0);
        jCBDespesa.setSelectedIndex(0);
        jFTFData.setText(null);
        jTFDescricao.setText(null);
        jTFDocumento.setText(null);
        jFTFValor.setValue(null);
        jCBTpTransacao.setSelectedIndex(0);
        jCBCategoria.setSelectedIndex(0);
        movcx.setCd_movcx(0);
        despesa = (Despesa)jCBDespesa.getSelectedItem();
        renda = (Renda)jCBRenda.getSelectedItem();
    }
    
    private void campoGpTransacao(){
        if(conta != null){
            jChkBCredito.setEnabled(true);
            jChkBDebito.setEnabled(true);
            if(jChkBCredito.isSelected() == true){
                jCBRenda.setEnabled(true);
                jChkBDebito.setSelected(false);
                jCBDespesa.setSelectedIndex(0);
                jCBDespesa.setEnabled(false);
            }
            if(jChkBDebito.isSelected() == true){
                jCBDespesa.setEnabled(true);
                jChkBCredito.setSelected(false);
                jCBRenda.setSelectedIndex(0);
                jCBRenda.setEnabled(false);
            }            
        }else{
            bGTransacao.clearSelection();
            jChkBCredito.setEnabled(false);
            jCBRenda.setEnabled(false);           
            jChkBDebito.setEnabled(false);
            jCBDespesa.setEnabled(false);
        }
    }
    
    private boolean validaCampos(){
        if(((Conta)jCBConta.getSelectedItem()).getCd_conta() == 0){
            JOptionPane.showMessageDialog(null, "Selecione a conta.");
            jCBConta.requestFocus();
            return false;
        }
        if(jChkBCredito.isSelected() == false && jChkBDebito.isSelected() == false){
            JOptionPane.showMessageDialog(null, "Selecione a transação.");
            jChkBCredito.requestFocus();
            return false;
        }
        if(util.validaDataCampo(jFTFData.getText()) == false){
            jFTFData.requestFocus();
            return false;
        }
        if(jTFDescricao.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Descrição em branco.");
            jTFDescricao.requestFocus();
            return false;
        }
        if(jFTFValor.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Valor em branco.");
            jFTFValor.requestFocus();
            return false;
        }
        if(((TipoTransacao)jCBTpTransacao.getSelectedItem()).getCd_tptrans() == 0){
            JOptionPane.showMessageDialog(null, "Selecione o tipo de transação.");
            jCBTpTransacao.requestFocus();
            return false;
        }
        return true;
    }
    
    private void ultimoRegistro(){
        movcx.setCd_usuario(JPLogin.codloginuser);
        if((MovimentoCaixa)movcxr.ultimoRegistroLanc(movcx.getCd_usuario()) == null){
            movcx.setCd_movcx(1);
        }else{
            movcx = (MovimentoCaixa)movcxr.ultimoRegistroLanc(movcx.getCd_usuario());
            movcx.setCd_movcx(movcx.getCd_movcx() + 1);
        }
    }
    
    private void salvar(){           
        if(movcx.getCd_movcx() == 0){
            ultimoRegistro();
            movcx.setConta(conta);        
            movcx.setDt_transacao(util.recebeData(jFTFData.getText()));
            movcx.setDs_descricao(jTFDescricao.getText());
            if(gptrans.getCd_gptrans() == 1){
                movcx.setRenda(renda);
                movcx.setDespesa(despesa);
                movcx.setVl_debito(null);
                movcx.setVl_credito(Utilidade.converter(jFTFValor.getText()));
            }
            if(gptrans.getCd_gptrans() == 2){
                movcx.setDespesa(despesa);
                movcx.setRenda(renda);
                movcx.setVl_credito(null);
                movcx.setVl_debito(Utilidade.converter(jFTFValor.getText()));
            }
            movcx.setNm_documento(jTFDocumento.getText());
            movcx.setTipotransacao(tptrans);
            movcx.setCategoria(categoria);
            movcx.setCd_usuario(JPLogin.codloginuser);
            movcxr.inserirLanc(movcx);
        }else{
            movcx.setConta(conta);        
            movcx.setDt_transacao(util.recebeData(jFTFData.getText()));
            movcx.setDs_descricao(jTFDescricao.getText());
            if(gptrans.getCd_gptrans() == 1){
                movcx.setRenda(renda);
                movcx.setDespesa(despesa);
                movcx.setVl_debito(null);
                movcx.setVl_credito(Utilidade.converter(jFTFValor.getText()));
            }
            if(gptrans.getCd_gptrans() == 2){
                movcx.setDespesa(despesa);
                movcx.setRenda(renda);
                movcx.setVl_credito(null);
                movcx.setVl_debito(Utilidade.converter(jFTFValor.getText()));
            }
            movcx.setNm_documento(jTFDocumento.getText());
            movcx.setTipotransacao(tptrans);
            movcx.setCategoria(categoria);
            movcx.setCd_usuario(JPLogin.codloginuser);
            movcxr.alterarLanc(movcx);
        }
    }
    
    private void excluir(){
        movcxr.excluirLanc(movcx);
    }
   
    private void calculaValores(){
        BigDecimal credito = movcxu.somaCreditoLanc(conta.getCd_conta());
        BigDecimal debito = movcxu.somaDebitoLanc(conta.getCd_conta());
        BigDecimal total = credito.subtract(debito);
        BigDecimal saldo = csaldo.getVl_saldo();
        BigDecimal saldof = saldo.add(total);
        
        jLCredito.setText("Crédito: " + Utilidade.formatoValor.format(credito));
        jLDebito.setText("Débito: " + Utilidade.formatoValor.format(debito));
        jLTotalCredDeb.setText("Total: " + Utilidade.formatoValor.format(total));
        jLSaldoFinal.setText("Saldo Final: " + Utilidade.formatoValor.format(saldof));
    }
    
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifmovcxf = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jCBContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBContaActionPerformed
        if(jCBConta.getSelectedIndex() != 0){
            conta = (Conta)jCBConta.getSelectedItem();
            csaldo = (ContaSaldo)csaldor.getContaSaldo(conta.getCd_conta());
            jLSaldo.setText("Saldo: " + Utilidade.formatoValor.format(csaldo.getVl_saldo()));
            movcxu.tablelaMovimentoCaixa(jTLancamento, conta.getCd_conta());
            movcxu.tablelaMovimentoCaixaLanc(jTLancamentoFuturo, conta.getCd_conta());
            calculaValores();
            limpaCampos();
        }else{
            conta = null;
            movcxu.tablelaMovimentoCaixa(jTLancamento, 0);
            movcxu.tablelaMovimentoCaixaLanc(jTLancamentoFuturo, 0);
            jLSaldo.setText("Saldo: 0,00");  
            jLSaldoFinal.setText("Saldo Final: 0,00");
        }
        campoGpTransacao();
    }//GEN-LAST:event_jCBContaActionPerformed

    private void jCBDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBDespesaActionPerformed
        if(jCBDespesa.getSelectedIndex() != 0){
            despesa = (Despesa)jCBDespesa.getSelectedItem();
            jFTFData.setText(Utilidade.formatoData.format(Calendar.getInstance().getTime()));
            jTFDescricao.setText(despesa.getPresserv() + " " + despesa.getDs_despesa());
            jFTFValor.setText(Utilidade.formatoValor.format(despesa.getNm_valor()));
            jCBCategoria.setSelectedItem(despesa.getCategoria());            
        }
    }//GEN-LAST:event_jCBDespesaActionPerformed

    private void jCBCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBCategoriaActionPerformed
        categoria = (Categoria)jCBCategoria.getSelectedItem();
    }//GEN-LAST:event_jCBCategoriaActionPerformed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if(validaCampos()){
            salvar();
            calculaValores();
            movcxu.tablelaMovimentoCaixa(jTLancamento, conta.getCd_conta());
            movcxu.tablelaMovimentoCaixaLanc(jTLancamentoFuturo, conta.getCd_conta());
            limpaCampos();
            campoGpTransacao();
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jChkBCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChkBCreditoActionPerformed
        gptrans.setCd_gptrans(1);
        campoGpTransacao();
        jcTpTrans();
    }//GEN-LAST:event_jChkBCreditoActionPerformed

    private void jChkBDebitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChkBDebitoActionPerformed
        gptrans.setCd_gptrans(2);
        campoGpTransacao();
        jcTpTrans();
    }//GEN-LAST:event_jChkBDebitoActionPerformed

    private void jCBTpTransacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBTpTransacaoActionPerformed
        tptrans = (TipoTransacao)jCBTpTransacao.getSelectedItem();
    }//GEN-LAST:event_jCBTpTransacaoActionPerformed

    private void jCBRendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBRendaActionPerformed
        if(jCBRenda.getSelectedIndex() != 0){
            renda = (Renda)jCBRenda.getSelectedItem();
            jFTFData.setText(Utilidade.formatoData.format(Calendar.getInstance().getTime()));
            jTFDescricao.setText(renda.getDs_renda());
            jFTFValor.setText(Utilidade.formatoValor.format(renda.getNm_valor()));            
        }
    }//GEN-LAST:event_jCBRendaActionPerformed

    private void jTLancamentoFuturoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTLancamentoFuturoMouseClicked
        movcx = (MovimentoCaixa)movcxu.getSelectObject(jTLancamentoFuturo);       
        jFTFData.setText(Utilidade.formatoData.format(movcx.getDt_transacao().getTime()));
        jTFDescricao.setText(movcx.getDs_descricao());
        jTFDocumento.setText(movcx.getNm_documento());
        if(movcx.getTipotransacao().getGptrans().getCd_gptrans() == 1){
            jFTFValor.setText(Utilidade.formatoValor.format(movcx.getVl_credito()));
            gptrans.setCd_gptrans(1);
            jChkBCredito.getModel().setSelected(true);
            jcTpTrans();
            jCBTpTransacao.getModel().setSelectedItem(movcx.getTipotransacao());            
        }
        if(movcx.getTipotransacao().getGptrans().getCd_gptrans() == 2){
            jFTFValor.setText(Utilidade.formatoValor.format(movcx.getVl_debito()));
            gptrans.setCd_gptrans(2);
            jChkBDebito.getModel().setSelected(true);
            jcTpTrans();            
            jCBTpTransacao.getModel().setSelectedItem(movcx.getTipotransacao());
        }
        if(movcx.getCategoria() == null){
            jCBCategoria.setSelectedIndex(0);
        }else{
            jCBCategoria.getModel().setSelectedItem(movcx.getCategoria());            
        }
    }//GEN-LAST:event_jTLancamentoFuturoMouseClicked

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        if((MovimentoCaixa)movcxu.getSelectObject(jTLancamentoFuturo) != null){
            excluir();
            calculaValores();
            movcxu.tablelaMovimentoCaixaLanc(jTLancamentoFuturo, conta.getCd_conta());
            limpaCampos();
            campoGpTransacao();
        }
    }//GEN-LAST:event_jBExcluirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bGTransacao;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<Categoria> jCBCategoria;
    private javax.swing.JComboBox<Conta> jCBConta;
    private javax.swing.JComboBox<Despesa> jCBDespesa;
    private javax.swing.JComboBox<String> jCBRenda;
    private javax.swing.JComboBox<TipoTransacao> jCBTpTransacao;
    private javax.swing.JCheckBox jChkBCredito;
    private javax.swing.JCheckBox jChkBDebito;
    private javax.swing.JFormattedTextField jFTFData;
    private javax.swing.JFormattedTextField jFTFValor;
    private javax.swing.JLabel jLCredito;
    private javax.swing.JLabel jLData;
    private javax.swing.JLabel jLDebito;
    private javax.swing.JLabel jLDescricao;
    private javax.swing.JLabel jLDocumento;
    private javax.swing.JLabel jLSaldo;
    private javax.swing.JLabel jLSaldoFinal;
    private javax.swing.JLabel jLTotalCredDeb;
    private javax.swing.JLabel jLValor;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JPanel jPCamposLanc;
    private javax.swing.JPanel jPConta;
    private javax.swing.JPanel jPGrid;
    private javax.swing.JPanel jPLancFuturo;
    private javax.swing.JPanel jPTransacao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTFDescricao;
    private javax.swing.JTextField jTFDocumento;
    private javax.swing.JTable jTLancamento;
    private javax.swing.JTable jTLancamentoFuturo;
    // End of variables declaration//GEN-END:variables
}
