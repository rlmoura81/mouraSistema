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
import br.com.rlmoura81.moura.utilidade.CalculoFinanceiro;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.math.BigDecimal;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class JIFMovimentoCaixa extends javax.swing.JInternalFrame {

    private static JIFMovimentoCaixa jifmovcx;
    
    public static JIFMovimentoCaixa getInstancia(){
        if(jifmovcx == null){
            jifmovcx = new JIFMovimentoCaixa();
            jifmovcx.setTitle("Movimento Caixa.");
        }
        return jifmovcx;
    }
    
    Conta conta = null;
    ContaUtil contau = new ContaUtil();
    
    ContaSaldo csaldo = new ContaSaldo();
    ContaSaldoRepository csaldor = new ContaSaldoRepository();
    
    Categoria categoria = new Categoria();
    CategoriaUtil categoriau = new CategoriaUtil();
    
    Renda renda = null;
    RendaUtil rendau = new RendaUtil();
    
    Despesa despesa = new Despesa();
    DespesaUtil despesau = new DespesaUtil();
    
    GrupoTransacao gptrans = new GrupoTransacao();
    
    TipoTransacao tptrans = null;
    TipoTransacaoUtil tptransu = new TipoTransacaoUtil();
    
    MovimentoCaixa movcx = null;
    MovimentoCaixa movcx2 = null;
    MovimentoCaixaRepository movcxr = new MovimentoCaixaRepository();
    MovimentoCaixaUtil movcxu = new MovimentoCaixaUtil();
    
    Utilidade util = new Utilidade();
    CalculoFinanceiro cf = new CalculoFinanceiro();
    
    public JIFMovimentoCaixa() {
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
        jLSaldoMesAnterior = new javax.swing.JLabel();
        jPTransacao = new javax.swing.JPanel();
        jCBRenda = new javax.swing.JComboBox<>();
        jChkBCredito = new javax.swing.JCheckBox();
        jCBDespesa = new javax.swing.JComboBox<>();
        jChkBDebito = new javax.swing.JCheckBox();
        jPBotoes = new javax.swing.JPanel();
        jBExcluir = new javax.swing.JButton();
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
        jPGrid = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTLancamento = new javax.swing.JTable();
        JPCamposResumo = new javax.swing.JPanel();
        jLCredito = new javax.swing.JLabel();
        jLDebito = new javax.swing.JLabel();
        jLTotal = new javax.swing.JLabel();
        jPPesquisa = new javax.swing.JPanel();
        jLDataInicio = new javax.swing.JLabel();
        jFTFDataInicio = new javax.swing.JFormattedTextField();
        jLDataFinal = new javax.swing.JLabel();
        jFTFDataFinal = new javax.swing.JFormattedTextField();
        jBPesquisar = new javax.swing.JButton();

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

        jLSaldoMesAnterior.setText("Mês anterior:");

        javax.swing.GroupLayout jPContaLayout = new javax.swing.GroupLayout(jPConta);
        jPConta.setLayout(jPContaLayout);
        jPContaLayout.setHorizontalGroup(
            jPContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPContaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCBConta, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLSaldo)
                .addGap(18, 18, 18)
                .addComponent(jLSaldoMesAnterior)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPContaLayout.setVerticalGroup(
            jPContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPContaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLSaldo)
                    .addComponent(jLSaldoMesAnterior))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jPBotoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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
                .addComponent(jBExcluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPBotoesLayout.setVerticalGroup(
            jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBExcluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(36, Short.MAX_VALUE))
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
                    .addComponent(jFTFData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        jTLancamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTLancamentoMouseClicked(evt);
            }
        });
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );

        JPCamposResumo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLCredito.setText("Crédito:");

        jLDebito.setText("Débito:");

        jLTotal.setText("Total:");

        javax.swing.GroupLayout JPCamposResumoLayout = new javax.swing.GroupLayout(JPCamposResumo);
        JPCamposResumo.setLayout(JPCamposResumoLayout);
        JPCamposResumoLayout.setHorizontalGroup(
            JPCamposResumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPCamposResumoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLCredito)
                .addGap(18, 18, 18)
                .addComponent(jLDebito)
                .addGap(18, 18, 18)
                .addComponent(jLTotal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPCamposResumoLayout.setVerticalGroup(
            JPCamposResumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPCamposResumoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPCamposResumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCredito)
                    .addComponent(jLDebito)
                    .addComponent(jLTotal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPPesquisa.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLDataInicio.setText("Data Inicio:");

        jLDataFinal.setText("Data Final:");

        jBPesquisar.setText("Pesquisar");
        jBPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPPesquisaLayout = new javax.swing.GroupLayout(jPPesquisa);
        jPPesquisa.setLayout(jPPesquisaLayout);
        jPPesquisaLayout.setHorizontalGroup(
            jPPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLDataInicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLDataFinal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBPesquisar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPPesquisaLayout.setVerticalGroup(
            jPPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLDataInicio)
                    .addComponent(jFTFDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLDataFinal)
                    .addComponent(jFTFDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBPesquisar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPBotoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JPCamposResumo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPConta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPTransacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPTransacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPCamposResumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void formatarData(){
        util.formataDataCampo(jFTFDataInicio);
        util.formataDataCampo(jFTFDataFinal);
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
        if(jCBRenda.isEnabled()){
            jCBRenda.setSelectedIndex(0);
            jCBRenda.setEnabled(false);
        }
        if(jCBDespesa.isEnabled()){
            jCBDespesa.setSelectedIndex(0);
            jCBDespesa.setEnabled(false);
        }
        campoGpTransacao();
        jFTFData.setText(null);
        jTFDescricao.setText(null);
        jTFDocumento.setText(null);
        jFTFValor.setValue(null);
        jCBTpTransacao.setSelectedIndex(0);
        jCBCategoria.setSelectedIndex(0);        
        despesa = (Despesa)jCBDespesa.getSelectedItem();
        renda = (Renda)jCBRenda.getSelectedItem();
        movcx = null;
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
        campoPesquisa();
    }
    
    private void campoPesquisa(){
        if(conta == null){
            jFTFDataInicio.setText(null);
            jFTFDataInicio.setEnabled(false);
            jFTFDataFinal.setText(null);
            jFTFDataFinal.setEnabled(false);
            jBPesquisar.setEnabled(false);
        }else{
            jFTFDataInicio.setEnabled(true);
            jFTFDataFinal.setEnabled(true);
            jBPesquisar.setEnabled(true);            
        }
    }
    
    private boolean validaCampos(){
        if(conta == null){
            JOptionPane.showMessageDialog(null, "Selecione a conta.", "Conta", JOptionPane.INFORMATION_MESSAGE);
            jCBConta.requestFocus();
            return false;
        }
        if(jChkBCredito.isSelected() == false && jChkBDebito.isSelected() == false){
            JOptionPane.showMessageDialog(null, "Selecione a transação.", "Movimento Caixa", JOptionPane.INFORMATION_MESSAGE);
            jChkBCredito.requestFocus();
            return false;
        }
        if(util.validaDataCampo(jFTFData.getText()) == false){
            jFTFData.requestFocus();
            return false;
        }
        if(jTFDescricao.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Descrição em branco.", "Moveimento Caixa", JOptionPane.INFORMATION_MESSAGE);
            jTFDescricao.requestFocus();
            return false;
        }
        if(jFTFValor.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Valor em branco.");
            jFTFValor.requestFocus();
            return false;
        }
        if(tptrans == null){
            JOptionPane.showMessageDialog(null, "Selecione o tipo de transação.", "Tipo Transação", JOptionPane.INFORMATION_MESSAGE);
            jCBTpTransacao.requestFocus();
            return false;
        }
        return true;
    }
    
    private void salvar(){
        if(movcx == null){
            movcx = new MovimentoCaixa();
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
            movcxr.inserir(movcx);   
        }else{      
            movcx.setDt_transacao(util.recebeData(jFTFData.getText()));
            movcx.setDs_descricao(jTFDescricao.getText());
            if(gptrans.getCd_gptrans() == 1){
                movcx.setRenda(renda);
                movcx.setDespesa(despesa);
                movcx.setVl_credito(Utilidade.converter(jFTFValor.getText()));
                movcx.setVl_debito(null);
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
            movcxr.alterar(movcx);  
        }     
    }

    private void saldoConta(){
        if(movcx2 == null){
            movcx2 = new MovimentoCaixa();
            movcx2.setVl_credito(Utilidade.converter("0,00"));
            movcx2.setVl_debito(Utilidade.converter("0,00"));
        }
        if(movcx.getTipotransacao().getGptrans().getCd_gptrans() == 1){
            if(!Utilidade.formatoValor.format(movcx.getVl_credito()).equals(Utilidade.formatoValor.format(movcx2.getVl_credito()))){
                csaldo.setVl_saldo(cf.saldoConta(gptrans.getCd_gptrans(), csaldo.getVl_saldo(), movcx.getVl_credito()));
                csaldor.alterar(csaldo);
            }
        }
        if(movcx.getTipotransacao().getGptrans().getCd_gptrans() == 2){
            if(!Utilidade.formatoValor.format(movcx.getVl_debito()).equals(Utilidade.formatoValor.format(movcx2.getVl_debito()))){
                csaldo.setVl_saldo(cf.saldoConta(gptrans.getCd_gptrans(), csaldo.getVl_saldo(), movcx.getVl_debito()));
                csaldor.alterar(csaldo);
            }
        }
        movcx2 = null;
        jLSaldo.setText("Saldo: " + Utilidade.formatoValor.format(csaldo.getVl_saldo()));   
    }
    
    private void saldoMesAnterior(){
        MovimentoCaixa saldoMesAnterior = new MovimentoCaixa();
        saldoMesAnterior = (MovimentoCaixa)movcxr.getSaldoMesAnterior(conta.getCd_conta());
        if(saldoMesAnterior.getVl_total() != null){
            jLSaldoMesAnterior.setText("Mês anterior: " + Utilidade.formatoValor.format(saldoMesAnterior.getVl_total()));            
        }else{
            jLSaldoMesAnterior.setText("Mês anterior: " + Utilidade.formatoValor.format(csaldo.getVl_saldo()));     
        }
    }

    private void calculaValoresMes(){
        BigDecimal credito = movcxu.somaCredito(conta.getCd_conta());
        BigDecimal debito = movcxu.somaDebito(conta.getCd_conta());   
        BigDecimal total = credito.subtract(debito);                

        jLCredito.setText("Crédito: " + Utilidade.formatoValor.format(credito));
        jLDebito.setText("Débito: " + Utilidade.formatoValor.format(debito));
        jLTotal.setText("Total: " + Utilidade.formatoValor.format(total));
    }
    
    private void calculaValoresPesquisa(){
        BigDecimal credito = movcxu.somaCredito(conta.getCd_conta(), jFTFDataInicio.getText(), jFTFDataFinal.getText());
        BigDecimal debito = movcxu.somaDebito(conta.getCd_conta(), jFTFDataInicio.getText(), jFTFDataFinal.getText());   
        BigDecimal total = credito.subtract(debito);                

        jLCredito.setText("Crédito: " + Utilidade.formatoValor.format(credito));
        jLDebito.setText("Débito: " + Utilidade.formatoValor.format(debito));
        jLTotal.setText("Total: " + Utilidade.formatoValor.format(total));
    }
    
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifmovcx = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jCBContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBContaActionPerformed
        if(jCBConta.getSelectedIndex() != 0){
            conta = (Conta)jCBConta.getSelectedItem();
            csaldo = (ContaSaldo)csaldor.getContaSaldo(conta.getCd_conta());
            jLSaldo.setText("Saldo: " + Utilidade.formatoValor.format(csaldo.getVl_saldo()));
            saldoMesAnterior();
            movcxu.tablelaMovimentoCaixa(jTLancamento, conta.getCd_conta());
            calculaValoresMes();
            limpaCampos();   
            jBPesquisar.setEnabled(true);
        }else{
            conta = null;
            movcxu.tablelaMovimentoCaixa(jTLancamento, 0);
            jLSaldo.setText("Saldo: ");
            jLSaldo.setText("Mês anterior: ");
        }   
        campoGpTransacao();        
    }//GEN-LAST:event_jCBContaActionPerformed

    private void jCBDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBDespesaActionPerformed
        if(jCBDespesa.getSelectedIndex() != 0){
            despesa = (Despesa)jCBDespesa.getSelectedItem();
            jFTFData.setText(Utilidade.formatoData.format(Calendar.getInstance().getTime()));
            jTFDescricao.setText(despesa.getPresserv() + " " + despesa.getDs_despesa());
            jFTFValor.setText(Utilidade.formatoValor.format(despesa.getNm_valor()));
            jCBCategoria.getModel().setSelectedItem(despesa.getCategoria());            
        }
    }//GEN-LAST:event_jCBDespesaActionPerformed

    private void jCBCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBCategoriaActionPerformed
        if(jCBCategoria.getSelectedIndex() != 0){
            categoria = (Categoria)jCBCategoria.getSelectedItem();
        }else{
            categoria = new Categoria();
            categoria.setCd_Categoria(0);
        }
    }//GEN-LAST:event_jCBCategoriaActionPerformed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if(validaCampos()){
            salvar();          
            saldoConta();
            limpaCampos();
            movcxu.tablelaMovimentoCaixa(jTLancamento, conta.getCd_conta());
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jChkBCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChkBCreditoActionPerformed
        campoGpTransacao();
        gptrans.setCd_gptrans(1);
        jcTpTrans();
    }//GEN-LAST:event_jChkBCreditoActionPerformed

    private void jChkBDebitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChkBDebitoActionPerformed
        campoGpTransacao();
        gptrans.setCd_gptrans(2);
        jcTpTrans();
    }//GEN-LAST:event_jChkBDebitoActionPerformed

    private void jCBTpTransacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBTpTransacaoActionPerformed
        if(jCBTpTransacao.getSelectedIndex() != 0){
            tptrans = (TipoTransacao)jCBTpTransacao.getSelectedItem();
        }else{
            tptrans = null;
        }
    }//GEN-LAST:event_jCBTpTransacaoActionPerformed

    private void jCBRendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBRendaActionPerformed
        if(jCBRenda.getSelectedIndex() != 0){
            renda = (Renda)jCBRenda.getSelectedItem();
            jFTFData.setText(Utilidade.formatoData.format(Calendar.getInstance().getTime()));
            jTFDescricao.setText(renda.getDs_renda());
            jFTFValor.setText(Utilidade.formatoValor.format(renda.getNm_valor()));            
        }
    }//GEN-LAST:event_jCBRendaActionPerformed

    private void jTLancamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTLancamentoMouseClicked
        movcx = (MovimentoCaixa)movcxu.getSelectObject(jTLancamento);
        if(movcx.getTipotransacao().getGptrans().getCd_gptrans() == 1){
            gptrans.setCd_gptrans(1);
            jChkBCredito.getModel().setSelected(true);
            jCBRenda.setEnabled(true);
            if(movcx.getRenda() != null){
                jCBRenda.getModel().setSelectedItem(movcx.getRenda());                
            }else{
                jCBRenda.setSelectedIndex(0);
            }
            jcTpTrans();
            jCBTpTransacao.getModel().setSelectedItem(movcx.getTipotransacao());            
            jFTFValor.setText(Utilidade.formatoValor.format(movcx.getVl_credito()));
        }
        if(movcx.getTipotransacao().getGptrans().getCd_gptrans() == 2){
            gptrans.setCd_gptrans(2);
            jChkBDebito.getModel().setSelected(true);
            jCBDespesa.setEnabled(true);
            if(movcx.getDespesa()!= null){
                jCBDespesa.getModel().setSelectedItem(movcx.getDespesa());                
            }else{
                jCBDespesa.setSelectedIndex(0);
            }
            jcTpTrans();            
            jCBTpTransacao.getModel().setSelectedItem(movcx.getTipotransacao());
            jFTFValor.setText(Utilidade.formatoValor.format(movcx.getVl_debito()));
        }
        jFTFData.setText(Utilidade.formatoData.format(movcx.getDt_transacao().getTime()));
        jTFDescricao.setText(movcx.getDs_descricao());
        jTFDocumento.setText(movcx.getNm_documento());        
        if(movcx.getCategoria() == null){
            jCBCategoria.setSelectedIndex(0);
        }else{
            jCBCategoria.getModel().setSelectedItem(movcx.getCategoria());            
        }
         
        if(movcx != null){
            movcx2 = new MovimentoCaixa();
            movcx2.setTipotransacao(movcx.getTipotransacao());
            movcx2.setRenda(movcx.getRenda());
            movcx2.setVl_credito(movcx.getVl_credito());
            movcx2.setDespesa(movcx.getDespesa());
            movcx2.setVl_debito(movcx.getVl_debito());
            movcx2.setDt_transacao(movcx.getDt_transacao());
            movcx2.setDs_descricao(movcx.getDs_descricao());
            movcx2.setNm_documento(movcx.getNm_documento());
            movcx2.setCategoria(movcx.getCategoria());            
        }else{
            movcx2 = null;
        }        
        campoGpTransacao();

    }//GEN-LAST:event_jTLancamentoMouseClicked

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        if((MovimentoCaixa)movcxu.getSelectObject(jTLancamento) != null){
            if(movcx.getTipotransacao().getGptrans().getCd_gptrans() == 1){
                gptrans.setCd_gptrans(2);
                csaldo.setVl_saldo(cf.saldoConta(gptrans.getCd_gptrans(), csaldo.getVl_saldo(), movcx.getVl_credito()));
            }
            if(movcx.getTipotransacao().getGptrans().getCd_gptrans() == 2){
                gptrans.setCd_gptrans(1);
                csaldo.setVl_saldo(cf.saldoConta(gptrans.getCd_gptrans(), csaldo.getVl_saldo(), movcx.getVl_debito()));
            }    
            csaldor.alterar(csaldo);
            movcxr.excluir(movcx);
            movcx2 = null;
            limpaCampos();
            jLSaldo.setText("Saldo: " + Utilidade.formatoValor.format(csaldo.getVl_saldo()));
            movcxu.tablelaMovimentoCaixa(jTLancamento, conta.getCd_conta());
        }        
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jBPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisarActionPerformed
        if(util.validaDataCampo(jFTFDataInicio.getText()) && util.validaDataCampo(jFTFDataFinal.getText())){
            movcxu.tablelaMovimentoCaixa(jTLancamento, conta.getCd_conta(), jFTFDataInicio.getText(), jFTFDataFinal.getText());
            calculaValoresPesquisa();
        }
    }//GEN-LAST:event_jBPesquisarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPCamposResumo;
    private javax.swing.ButtonGroup bGTransacao;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBPesquisar;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<Categoria> jCBCategoria;
    private javax.swing.JComboBox<Conta> jCBConta;
    private javax.swing.JComboBox<Despesa> jCBDespesa;
    private javax.swing.JComboBox<String> jCBRenda;
    private javax.swing.JComboBox<TipoTransacao> jCBTpTransacao;
    private javax.swing.JCheckBox jChkBCredito;
    private javax.swing.JCheckBox jChkBDebito;
    private javax.swing.JFormattedTextField jFTFData;
    private javax.swing.JFormattedTextField jFTFDataFinal;
    private javax.swing.JFormattedTextField jFTFDataInicio;
    private javax.swing.JFormattedTextField jFTFValor;
    private javax.swing.JLabel jLCredito;
    private javax.swing.JLabel jLData;
    private javax.swing.JLabel jLDataFinal;
    private javax.swing.JLabel jLDataInicio;
    private javax.swing.JLabel jLDebito;
    private javax.swing.JLabel jLDescricao;
    private javax.swing.JLabel jLDocumento;
    private javax.swing.JLabel jLSaldo;
    private javax.swing.JLabel jLSaldoMesAnterior;
    private javax.swing.JLabel jLTotal;
    private javax.swing.JLabel jLValor;
    private javax.swing.JPanel jPBotoes;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JPanel jPConta;
    private javax.swing.JPanel jPGrid;
    private javax.swing.JPanel jPPesquisa;
    private javax.swing.JPanel jPTransacao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFDescricao;
    private javax.swing.JTextField jTFDocumento;
    private javax.swing.JTable jTLancamento;
    // End of variables declaration//GEN-END:variables
}
