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
    
    /**
     * <p><strong>EN:</strong> Returns the singleton instance of {@link JIFMovimentoCaixa}.  
     * If no instance exists, a new one is created and titled "Movimento Caixa".</p>
     *
     * <p><strong>IT:</strong> Restituisce l'istanza singleton di {@link JIFMovimentoCaixa}.  
     * Se non esiste alcuna istanza, ne viene creata una nuova con il titolo "Movimento Caixa".</p>
     *
     * <p><strong>PT-BR:</strong> Retorna a instância singleton de {@link JIFMovimentoCaixa}.  
     * Caso não exista uma instância, uma nova é criada com o título "Movimento Caixa".</p>
     */
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
    
    Renda renda = new Renda();
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

        jcConta();
        jcRenda();
        jcDespesa();
        jcTpTrans();
        jcCategoria();
        formatarData(); 
        formataValor();           
        camposMovimentoCaixaBanco();        
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
        jBSalvar = new javax.swing.JButton();
        jBNovo = new javax.swing.JButton();
        jPCampos = new javax.swing.JPanel();
        jLData = new javax.swing.JLabel();
        jLDescricao = new javax.swing.JLabel();
        jTFDescricao = new javax.swing.JTextField();
        jLDocumento = new javax.swing.JLabel();
        jTFDocumento = new javax.swing.JTextField();
        jFTFValor = new javax.swing.JFormattedTextField();
        jLValor = new javax.swing.JLabel();
        jCBCategoria = new javax.swing.JComboBox<>();
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
                .addContainerGap(540, Short.MAX_VALUE))
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
        jChkBCredito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jChkBCreditoMouseClicked(evt);
            }
        });

        jCBDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBDespesaActionPerformed(evt);
            }
        });

        bGTransacao.add(jChkBDebito);
        jChkBDebito.setText("Débito:");
        jChkBDebito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jChkBDebitoMouseClicked(evt);
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

        jBSalvar.setText("Salvar");
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });

        jBNovo.setText("Novo");
        jBNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNovoActionPerformed(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBNovo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPBotoesLayout.setVerticalGroup(
            jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPBotoesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBExcluir)
                    .addComponent(jBSalvar)
                    .addComponent(jBNovo))
                .addContainerGap())
        );

        jPCampos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLData.setText("Data:");

        jLDescricao.setText("Descrição:");

        jLDocumento.setText("Documento:");

        jFTFValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        jFTFValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFTFValorFocusGained(evt);
            }
        });

        jLValor.setText("Valor:");

        jCBCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBCategoriaActionPerformed(evt);
            }
        });

        jCBTpTransacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBTpTransacaoActionPerformed(evt);
            }
        });

        jFTFData.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFTFDataFocusGained(evt);
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
                .addComponent(jCBTpTransacao, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jCBTpTransacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFTFData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
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

        jFTFDataInicio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFTFDataInicioFocusGained(evt);
            }
        });

        jLDataFinal.setText("Data Final:");

        jFTFDataFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFTFDataFinalFocusGained(evt);
            }
        });

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
    
    /**
     * <p><strong>EN:</strong> Applies date masks and input formatting to the start, end, and transaction date fields.</p>
     * <p><strong>IT:</strong> Applica maschere e formattazione delle date ai campi data iniziale, finale e della transazione.</p>
     * <p><strong>PT-BR:</strong> Aplica máscaras e formatação de data nos campos de data inicial, final e da transação.</p>
     */
    private void formatarData(){
        util.formataDataCampo(jFTFData);   
        util.formataDataCampo(jFTFDataInicio);
        util.formataDataCampo(jFTFDataFinal);
    
    }
    
    /**
     * <p><strong>EN:</strong> Configures the currency formatter for the value input field.</p>
     * <p><strong>IT:</strong> Configura il formattatore di valuta per il campo di inserimento del valore.</p>
     * <p><strong>PT-BR:</strong> Configura o formatador monetário para o campo de valor.</p>
     */
    private void formataValor() {
        jFTFValor.setFormatterFactory(Utilidade.formataValorCampo(ui));
        util.insereTxtPadraoValor(jFTFValor);
    }
    
    /**
     * <p><strong>EN:</strong> Populates the account combo box with available accounts.</p>
     * <p><strong>IT:</strong> Popola la casella combinata dei conti con i conti disponibili.</p>
     * <p><strong>PT-BR:</strong> Preenche o combo de contas com as contas disponíveis.</p>
     */
    private void jcConta(){
        contau.jcConta(jCBConta);
    }
    
    /**
     * <p><strong>EN:</strong> Populates the category combo box with available categories.</p>
     * <p><strong>IT:</strong> Popola la casella combinata delle categorie con le categorie disponibili.</p>
     * <p><strong>PT-BR:</strong> Preenche o combo de categorias com as opções disponíveis.</p>
     */
    private void jcCategoria() {
        categoriau.jcCategoria(jCBCategoria);
    } 
    
    /**
     * <p><strong>EN:</strong> Populates the income combo box with recorded incomes.</p>
     * <p><strong>IT:</strong> Popola la casella combinata dei redditi con i redditi registrati.</p>
     * <p><strong>PT-BR:</strong> Preenche o combo de rendas com as rendas cadastradas.</p>
     */
    private void jcRenda(){
        rendau.jcRenda(jCBRenda); 
    }
    
    /**
     * <p><strong>EN:</strong> Populates the expense combo box with recorded expenses.</p>
     * <p><strong>IT:</strong> Popola la casella combinata delle spese con le spese registrate.</p>
     * <p><strong>PT-BR:</strong> Preenche o combo de despesas com as despesas cadastradas.</p>
     */
    private void jcDespesa(){
        despesau.jcDespesa(jCBDespesa);
    }
   
    /**
     * <p><strong>EN:</strong> Refreshes the transaction type combo box according to the selected transaction group (credit/debit).</p>
     * <p><strong>IT:</strong> Aggiorna la casella del tipo di transazione in base al gruppo selezionato (credito/debito).</p>
     * <p><strong>PT-BR:</strong> Atualiza o combo de tipo de transação conforme o grupo selecionado (crédito/débito).</p>
     */
    private void jcTpTrans(){
        if(gptrans.getCd_gptrans() == 1){
            tptransu.jcTpTransCredDeb(jCBTpTransacao, gptrans.getCd_gptrans());
        }
        if(gptrans.getCd_gptrans() == 2){
            tptransu.jcTpTransCredDeb(jCBTpTransacao,gptrans.getCd_gptrans());
        }
        jCBTpTransacao.setEnabled(true);
    }
    
    /**
     * EM TESTE - ADICIONAR COMENTARIO
     * COMPORTAMENTO DO FORMULARIO
     */
    private void camposMovimentoCaixaBanco(){
        if(jCBConta.getSelectedIndex() != 0){
            conta = (Conta)jCBConta.getSelectedItem();
            csaldo = (ContaSaldo)csaldor.getContaSaldo(conta.getCd_conta());
            jLSaldo.setText("Saldo: " + Utilidade.formatoValor.format(csaldo.getVl_saldo()));
            saldoMesAnterior();
            calculaValoresMes();
            jChkBCredito.setEnabled(true);
            jChkBDebito.setEnabled(true);
            movcxu.tablelaMovimentoCaixa(jTLancamento, conta.getCd_conta());
            jBPesquisar.setEnabled(true);
            if(movcx != null){
                movcx = null;
            }
        }else{
            conta = null;
            jLSaldo.setText("Saldo: 0,00");
            jLSaldo.setText("Mês anterior: 0,00");
            bGTransacao.clearSelection();
            jChkBCredito.setEnabled(false);
            jCBRenda.setEnabled(false);
            jCBRenda.setSelectedIndex(0);
            jChkBDebito.setEnabled(false);
            jCBDespesa.setEnabled(false);
            jCBDespesa.setSelectedIndex(0);
            jCBTpTransacao.setEnabled(false);
            jCBTpTransacao.removeAllItems();
            camposLancamento();
            jCBCategoria.setEnabled(false);
            movcxu.tablelaMovimentoCaixa(jTLancamento, 0);
        }
    }

    /**
     * EM TESTE - ADICIONAR COMENTARIO
     * COMPORTAMENTO DO CAMPOS DO GRUPO DE TRANSACAO
     */
    private void camposGrupoDeTransacao(){
        if(jChkBCredito.isSelected() == true){
            jCBRenda.setEnabled(true);
            jCBDespesa.setSelectedIndex(0);
            jCBDespesa.setEnabled(false);
        }
        if(jChkBDebito.isSelected() == true){
            jCBDespesa.setEnabled(true);
            jCBRenda.setSelectedIndex(0);
            jCBRenda.setEnabled(false);
        }
        camposLancamento();
        jCBCategoria.setEnabled(true);
    }   
    
    /**
     * EM TESTE - ADICIONAR COMENTARIO
     * LIMPA AS SELECOES DO GRUPO DE CHK BOS APOS TRANSACAO NO BANCO
     */
    private void camposGrupoDeTransacaoAposTranscaoBanco(){
        jCBRenda.setSelectedIndex(0);
        jCBRenda.setEnabled(false);
        jCBDespesa.setSelectedIndex(0);
        jCBDespesa.setEnabled(false);
        bGTransacao.clearSelection();
        jCBTpTransacao.removeAllItems();
        jCBTpTransacao.setEnabled(false);
    }
    
    /**
     * EM TESTE - ADICIONAR COMENTARIO
     * LIMPA OS CAMPOS REFERENTES AO LANCAMENTO
     */
    private void camposLancamento(){
        jFTFData.setText(null);
        jTFDescricao.setText(null);
        jTFDocumento.setText(null);
        jFTFValor.setValue(null);
        jCBCategoria.setSelectedIndex(0);
    }
    
    /**
     * <p><strong>EN:</strong> Toggles the search date fields and button based on whether an account is selected.</p>
     * <p><strong>IT:</strong> Attiva/disattiva i campi data di ricerca e il pulsante in base alla selezione del conto.</p>
     * <p><strong>PT-BR:</strong> Ativa/desativa os campos de data de pesquisa e o botão conforme a seleção da conta.</p>
     */
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
    
    /**
     * <p><strong>EN:</strong> Validates required inputs for creating/updating a cash movement (account, group, date, description, value, and type).</p>
     * <p><strong>IT:</strong> Convalida gli input obbligatori per creare/aggiornare un movimento di cassa (conto, gruppo, data, descrizione, valore e tipo).</p>
     * <p><strong>PT-BR:</strong> Valida os campos obrigatórios para criar/atualizar um movimento de caixa (conta, grupo, data, descrição, valor e tipo).</p>
     */
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
    
    /**
     * <p><strong>EN:</strong> Creates or updates a cash movement record based on the selected group (credit/debit) and form data.</p>
     * <p><strong>IT:</strong> Crea o aggiorna un movimento di cassa in base al gruppo selezionato (credito/debito) e ai dati del modulo.</p>
     * <p><strong>PT-BR:</strong> Cria ou atualiza um registro de movimento de caixa conforme o grupo selecionado (crédito/débito) e os dados do formulário.</p>
     */
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
                movcx.setDespesa(despesa = new Despesa());
                movcx.setVl_credito(Utilidade.converter(jFTFValor.getText()));
                movcx.setVl_debito(null);
            }
            if(gptrans.getCd_gptrans() == 2){
                movcx.setDespesa(despesa);
                movcx.setRenda(renda = new Renda());
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

    /**
     * <p><strong>EN:</strong> Updates the account balance according to the movement values, handling new and edited records.</p>
     * <p><strong>IT:</strong> Aggiorna il saldo del conto in base ai valori del movimento, gestendo nuovi record e modifiche.</p>
     * <p><strong>PT-BR:</strong> Atualiza o saldo da conta conforme os valores do movimento, tratando inclusão e edição.</p>
     */
    private void saldoConta(){
        if(movcx2 == null){
            movcx2 = new MovimentoCaixa();
            movcx2.setVl_credito(Utilidade.converter("0,00"));
            movcx2.setVl_debito(Utilidade.converter("0,00"));
            
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
        }else{
            if(movcx.getTipotransacao().getGptrans().getCd_gptrans() == 1){
                if(!Utilidade.formatoValor.format(movcx.getVl_credito()).equals(Utilidade.formatoValor.format(movcx2.getVl_credito()))){
                    csaldo.setVl_saldo(cf.saldoContaAtualizar(gptrans.getCd_gptrans(), csaldo.getVl_saldo(), movcx.getVl_credito(), movcx2.getVl_credito()));
                    csaldor.alterar(csaldo);
                }
            }
            if(movcx.getTipotransacao().getGptrans().getCd_gptrans() == 2){
                if(!Utilidade.formatoValor.format(movcx.getVl_debito()).equals(Utilidade.formatoValor.format(movcx2.getVl_debito()))){
                    csaldo.setVl_saldo(cf.saldoContaAtualizar(gptrans.getCd_gptrans(), csaldo.getVl_saldo(), movcx.getVl_debito(), movcx2.getVl_debito()));
                    csaldor.alterar(csaldo);
                }
            }            
        }    
        movcx = null;
        movcx2 = null;
        jLSaldo.setText("Saldo: " + Utilidade.formatoValor.format(csaldo.getVl_saldo()));   
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves and displays the previous month's balance for the selected account.</p>
     * <p><strong>IT:</strong> Recupera e visualizza il saldo del mese precedente per il conto selezionato.</p>
     * <p><strong>PT-BR:</strong> Obtém e exibe o saldo do mês anterior da conta selecionada.</p>
     */
    private void saldoMesAnterior(){
        MovimentoCaixa saldoMesAnterior = new MovimentoCaixa();
        saldoMesAnterior = (MovimentoCaixa)movcxr.getSaldoMesAnterior(conta.getCd_conta());
        if(saldoMesAnterior.getVl_total() != null){
            jLSaldoMesAnterior.setText("Mês anterior: " + Utilidade.formatoValor.format(saldoMesAnterior.getVl_total()));            
        }else{
            jLSaldoMesAnterior.setText("Mês anterior: " + Utilidade.formatoValor.format(csaldo.getVl_saldo()));     
        }
    }

    /**
     * <p><strong>EN:</strong> Calculates and displays the current month's totals (credit, debit, and net) for the selected account.</p>
     * <p><strong>IT:</strong> Calcola e mostra i totali del mese corrente (credito, debito e netto) per il conto selezionato.</p>
     * <p><strong>PT-BR:</strong> Calcula e exibe os totais do mês (crédito, débito e líquido) da conta selecionada.</p>
     */
    private void calculaValoresMes(){
        BigDecimal credito = movcxu.somaCredito(conta.getCd_conta());
        BigDecimal debito = movcxu.somaDebito(conta.getCd_conta());   
        BigDecimal total = credito.subtract(debito);                

        jLCredito.setText("Crédito: " + Utilidade.formatoValor.format(credito));
        jLDebito.setText("Débito: " + Utilidade.formatoValor.format(debito));
        jLTotal.setText("Total: " + Utilidade.formatoValor.format(total));
    }
    
    /**
     * <p><strong>EN:</strong> Calculates and displays totals (credit, debit, and net) for the selected account within the chosen date range.</p>
     * <p><strong>IT:</strong> Calcola e mostra i totali (credito, debito e netto) per il conto selezionato nel periodo indicato.</p>
     * <p><strong>PT-BR:</strong> Calcula e exibe os totais (crédito, débito e líquido) da conta selecionada no intervalo informado.</p>
     */
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
        camposMovimentoCaixaBanco();
    }//GEN-LAST:event_jCBContaActionPerformed

    private void jCBDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBDespesaActionPerformed
        if(jCBDespesa.getSelectedIndex() != 0){
            despesa = (Despesa)jCBDespesa.getModel().getSelectedItem();
            jFTFData.setText(Utilidade.formatoData.format(Calendar.getInstance().getTime()));
            jTFDescricao.setText(despesa.getEmpresa().getDs_empresa() + " - " + despesa.getDs_despesa());
            jFTFValor.setText(Utilidade.formatoValor.format(despesa.getNm_valor()));
            jCBCategoria.getModel().setSelectedItem(despesa.getCategoria());       
            jcTpTrans();
        }
    }//GEN-LAST:event_jCBDespesaActionPerformed

    private void jCBCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBCategoriaActionPerformed
        if(jCBCategoria.getSelectedIndex() != 0){
            categoria = (Categoria)jCBCategoria.getSelectedItem();
        }else{
            categoria = new Categoria();
        }
    }//GEN-LAST:event_jCBCategoriaActionPerformed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if(validaCampos()){
            salvar();          
            saldoConta();
            camposLancamento();
            camposGrupoDeTransacaoAposTranscaoBanco();
            movcxu.tablelaMovimentoCaixa(jTLancamento, conta.getCd_conta());
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jCBTpTransacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBTpTransacaoActionPerformed
        if(jCBTpTransacao.getSelectedIndex() != 0){
            tptrans = (TipoTransacao)jCBTpTransacao.getSelectedItem();
        }else{
            tptrans = null;
        }
    }//GEN-LAST:event_jCBTpTransacaoActionPerformed

    private void jCBRendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBRendaActionPerformed
        if(jCBRenda.getSelectedIndex() != 0){
            renda = (Renda)jCBRenda.getModel().getSelectedItem();
            jFTFData.setText(Utilidade.formatoData.format(Calendar.getInstance().getTime()));
            jTFDescricao.setText(renda.getDs_renda());
            jFTFValor.setText(Utilidade.formatoValor.format(renda.getNm_valor()));   
            jcTpTrans();
        }
    }//GEN-LAST:event_jCBRendaActionPerformed

    private void jTLancamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTLancamentoMouseClicked
        movcx = (MovimentoCaixa)movcxu.getSelectObjectMovcx(jTLancamento);
        if(movcx.getTipotransacao().getGptrans().getCd_gptrans() == 1){
            gptrans.setCd_gptrans(1);
            jChkBCredito.setSelected(true);
            jChkBDebito.setSelected(false);
            jCBRenda.setEnabled(true);
            jCBDespesa.setEnabled(false);
            jCBDespesa.setSelectedIndex(0);
            if(movcx.getRenda() != null){
                jCBRenda.getModel().setSelectedItem(movcx.getRenda());                
            }else{
                jCBRenda.setSelectedIndex(0);
            }            
            jFTFValor.setText(Utilidade.formatoValor.format(movcx.getVl_credito()));
        }else
        if(movcx.getTipotransacao().getGptrans().getCd_gptrans() == 2){
            gptrans.setCd_gptrans(2);
            jChkBDebito.setSelected(true);
            jChkBCredito.setSelected(false);
            jCBDespesa.setEnabled(true);
            jCBRenda.setEnabled(false);
            jCBRenda.setSelectedIndex(0);
            if(movcx.getDespesa()!= null){
                jCBDespesa.getModel().setSelectedItem(movcx.getDespesa());                
            }else{
                jCBDespesa.setSelectedIndex(0);
            }           
            jFTFValor.setText(Utilidade.formatoValor.format(movcx.getVl_debito()));
        }
        jFTFData.setText(Utilidade.formatoData.format(movcx.getDt_transacao().getTime()));
        jTFDescricao.setText(movcx.getDs_descricao());
        jTFDocumento.setText(movcx.getNm_documento());        
        jCBTpTransacao.getModel().setSelectedItem(movcx.getTipotransacao());
        jCBCategoria.setEnabled(true);
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
            movcx = null;
            movcx2 = null;
            jLSaldo.setText("Saldo: " + Utilidade.formatoValor.format(csaldo.getVl_saldo()));
            movcxu.tablelaMovimentoCaixa(jTLancamento, conta.getCd_conta());
        }     
        camposLancamento();
        camposGrupoDeTransacaoAposTranscaoBanco();
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jBPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisarActionPerformed
        if(jFTFDataFinal.getText().equals("  /  /    ")){
            jFTFDataFinal.setText(Utilidade.formatoData.format(Calendar.getInstance().getTime()));
        }
        if(util.validaDataCampo(jFTFDataInicio.getText()) && util.validaDataCampo(jFTFDataFinal.getText())){
            movcxu.tablelaMovimentoCaixa(jTLancamento, conta.getCd_conta(), jFTFDataInicio.getText(), jFTFDataFinal.getText());
            calculaValoresPesquisa();
        }
    }//GEN-LAST:event_jBPesquisarActionPerformed

    private void jFTFValorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTFValorFocusGained
        util.posicionaCursorjFTFValor(jFTFValor);
    }//GEN-LAST:event_jFTFValorFocusGained

    private void jFTFDataFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTFDataFocusGained
        util.posicionaCursorjFTFData(jFTFData);
    }//GEN-LAST:event_jFTFDataFocusGained

    private void jFTFDataInicioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTFDataInicioFocusGained
        util.posicionaCursorjFTFData(jFTFDataInicio);
    }//GEN-LAST:event_jFTFDataInicioFocusGained

    private void jFTFDataFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTFDataFinalFocusGained
        util.posicionaCursorjFTFData(jFTFDataFinal);
    }//GEN-LAST:event_jFTFDataFinalFocusGained

    private void jChkBCreditoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jChkBCreditoMouseClicked
        camposGrupoDeTransacao();
        gptrans.setCd_gptrans(1);
        jcTpTrans();
    }//GEN-LAST:event_jChkBCreditoMouseClicked

    private void jChkBDebitoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jChkBDebitoMouseClicked
        camposGrupoDeTransacao();
        gptrans.setCd_gptrans(2);
        jcTpTrans();
    }//GEN-LAST:event_jChkBDebitoMouseClicked

    private void jBNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNovoActionPerformed
        jCBConta.setSelectedIndex(0);
    }//GEN-LAST:event_jBNovoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPCamposResumo;
    private javax.swing.ButtonGroup bGTransacao;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBNovo;
    private javax.swing.JButton jBPesquisar;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<Categoria> jCBCategoria;
    private javax.swing.JComboBox<Conta> jCBConta;
    private javax.swing.JComboBox<Despesa> jCBDespesa;
    private javax.swing.JComboBox<Renda> jCBRenda;
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
