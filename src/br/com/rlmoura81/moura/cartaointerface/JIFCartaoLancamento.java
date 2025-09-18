package br.com.rlmoura81.moura.cartaointerface;

import br.com.rlmoura81.moura.financeiro.Banco;
import br.com.rlmoura81.moura.financeiro.BancoUtil;
import br.com.rlmoura81.moura.cartao.Cartao;
import br.com.rlmoura81.moura.cartao.CartaoLancamento;
import br.com.rlmoura81.moura.cartao.CartaoLancamentoFechamento;
import br.com.rlmoura81.moura.cartao.CartaoLancamentoFechamentoRepository;
import br.com.rlmoura81.moura.cartao.CartaoLancamentoFechamentoUtil;
import br.com.rlmoura81.moura.cartao.CartaoLancamentoRepository;
import br.com.rlmoura81.moura.cartao.CartaoLancamentoUtil;
import br.com.rlmoura81.moura.cartao.CartaoParcelamento;
import br.com.rlmoura81.moura.cartao.CartaoParcelamentoRepository;
import br.com.rlmoura81.moura.cartao.CartaoParcelamentoUtil;
import br.com.rlmoura81.moura.cartao.CartaoUtil;
import br.com.rlmoura81.moura.financeiro.Despesa;
import br.com.rlmoura81.moura.financeiro.DespesaUtil;
import br.com.rlmoura81.moura.principalcadastro.Categoria;
import br.com.rlmoura81.moura.principalcadastro.CategoriaUtil;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class JIFCartaoLancamento extends javax.swing.JInternalFrame {
    
    private static JIFCartaoLancamento jifcartaolancamento;
    
    /**
     * <p><strong>EN:</strong> Returns the singleton instance of the JIFCartaoLancamento internal frame.  
     * If the instance does not exist, it is created and initialized with the title "Cartão Lançamentos".</p>
     *
     * <p><strong>IT:</strong> Restituisce l'istanza singleton del frame interno JIFCartaoLancamento.  
     * Se l'istanza non esiste, viene creata e inizializzata con il titolo "Cartão Lançamentos".</p>
     *
     * <p><strong>PT-BR:</strong> Retorna a instância singleton do frame interno JIFCartaoLancamento.  
     * Caso a instância não exista, ela é criada e inicializada com o título "Cartão Lançamentos".</p>
     *
     * @return EN: unique instance of JIFCartaoLancamento | IT: istanza unica di JIFCartaoLancamento | PT-BR: instância única de JIFCartaoLancamento
     * @since 1.0.0
     */
    public static JIFCartaoLancamento getInstancia(){
        if(jifcartaolancamento == null){
            jifcartaolancamento = new JIFCartaoLancamento();
            jifcartaolancamento.setTitle("Cartão Lançamentos.");
        }return jifcartaolancamento;
    }
    
    Banco banco = new Banco();
    BancoUtil bancou = new BancoUtil();    
    Cartao cartao = null;
    CartaoUtil cartaou = new CartaoUtil();    
    Categoria categoria = null;
    CategoriaUtil categoriau = new CategoriaUtil();    
    Despesa despesa = new Despesa();
    DespesaUtil despesau = new DespesaUtil();    
    CartaoLancamento cartaolanc = new CartaoLancamento();
    CartaoLancamentoRepository cartaolancr = new CartaoLancamentoRepository();
    CartaoLancamentoUtil cartaolancu = new CartaoLancamentoUtil();    
    CartaoLancamentoFechamento cartaolancf = new CartaoLancamentoFechamento();
    CartaoLancamentoFechamentoRepository cartaolancfr = new CartaoLancamentoFechamentoRepository();
    CartaoLancamentoFechamentoUtil cartaolancfu = new CartaoLancamentoFechamentoUtil();        
    CartaoParcelamento cartaoparc = new CartaoParcelamento();
    CartaoParcelamentoRepository cartaoparcr = new CartaoParcelamentoRepository();
    CartaoParcelamentoUtil cartaoparcu = new CartaoParcelamentoUtil();    
    Utilidade util = new Utilidade();
        
    public JIFCartaoLancamento() {
        initComponents();
        
        jcBanco();
        jcCategoria();
        jcDespesa();
        formataData();
        formataValor();     

        jbBotaoFechamento();
        jChkBFaturasFechadas.setEnabled(false);
        jCBFaturasFechadas.setEnabled(false);
        
        jRBEmAberto.setEnabled(false);
        jBLancaParcela.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPPrincipal = new javax.swing.JPanel();
        jCBCartao = new javax.swing.JComboBox<>();
        jCBBanco = new javax.swing.JComboBox<>();
        jLVlFatura = new javax.swing.JLabel();
        jPDespesa = new javax.swing.JPanel();
        jCBDespesa = new javax.swing.JComboBox<>();
        jPParcela = new javax.swing.JPanel();
        jChkBParcela = new javax.swing.JCheckBox();
        jTFParcela = new javax.swing.JTextField();
        jRBEmAberto = new javax.swing.JRadioButton();
        jBLancaParcela = new javax.swing.JButton();
        jPGridTransacao = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTTransacao = new javax.swing.JTable();
        jPTransacaoCampo = new javax.swing.JPanel();
        jLData = new javax.swing.JLabel();
        jFTFData = new javax.swing.JFormattedTextField();
        jLDescricao = new javax.swing.JLabel();
        jTFDescricao = new javax.swing.JTextField();
        jLValor = new javax.swing.JLabel();
        jFTFValor = new javax.swing.JFormattedTextField();
        jCBCategoria = new javax.swing.JComboBox<>();
        jPTransacaoBotoes = new javax.swing.JPanel();
        jBSalvarTransacao = new javax.swing.JButton();
        jBAlterarTransacao = new javax.swing.JButton();
        jBExcluirTransacao = new javax.swing.JButton();
        jBFechamento = new javax.swing.JButton();
        jLDtFechamento = new javax.swing.JLabel();
        jFTFFechamento = new javax.swing.JFormattedTextField();
        jChkBFaturasFechadas = new javax.swing.JCheckBox();
        jCBFaturasFechadas = new javax.swing.JComboBox<>();

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

        jPPrincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jCBCartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBCartaoActionPerformed(evt);
            }
        });

        jCBBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBBancoActionPerformed(evt);
            }
        });

        jLVlFatura.setText("Valor Fatura:");

        javax.swing.GroupLayout jPPrincipalLayout = new javax.swing.GroupLayout(jPPrincipal);
        jPPrincipal.setLayout(jPPrincipalLayout);
        jPPrincipalLayout.setHorizontalGroup(
            jPPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCBBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCBCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLVlFatura)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPPrincipalLayout.setVerticalGroup(
            jPPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBCartao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLVlFatura))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPDespesa.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jCBDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBDespesaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPDespesaLayout = new javax.swing.GroupLayout(jPDespesa);
        jPDespesa.setLayout(jPDespesaLayout);
        jPDespesaLayout.setHorizontalGroup(
            jPDespesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDespesaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCBDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPDespesaLayout.setVerticalGroup(
            jPDespesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDespesaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCBDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPParcela.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jChkBParcela.setText("Parcelas:");
        jChkBParcela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChkBParcelaActionPerformed(evt);
            }
        });

        jTFParcela.setText("1");

        jRBEmAberto.setText("Em aberto");
        jRBEmAberto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBEmAbertoActionPerformed(evt);
            }
        });

        jBLancaParcela.setText("Lançar");
        jBLancaParcela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLancaParcelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPParcelaLayout = new javax.swing.GroupLayout(jPParcela);
        jPParcela.setLayout(jPParcelaLayout);
        jPParcelaLayout.setHorizontalGroup(
            jPParcelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPParcelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jChkBParcela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFParcela, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jRBEmAberto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBLancaParcela)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPParcelaLayout.setVerticalGroup(
            jPParcelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPParcelaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPParcelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChkBParcela)
                    .addComponent(jRBEmAberto)
                    .addComponent(jBLancaParcela))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPGridTransacao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTTransacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTTransacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTTransacaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTTransacao);

        javax.swing.GroupLayout jPGridTransacaoLayout = new javax.swing.GroupLayout(jPGridTransacao);
        jPGridTransacao.setLayout(jPGridTransacaoLayout);
        jPGridTransacaoLayout.setHorizontalGroup(
            jPGridTransacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridTransacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPGridTransacaoLayout.setVerticalGroup(
            jPGridTransacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridTransacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPTransacaoCampo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLData.setText("Data:");

        jLDescricao.setText("Descrição:");

        jLValor.setText("Valor:");

        jCBCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPTransacaoCampoLayout = new javax.swing.GroupLayout(jPTransacaoCampo);
        jPTransacaoCampo.setLayout(jPTransacaoCampoLayout);
        jPTransacaoCampoLayout.setHorizontalGroup(
            jPTransacaoCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPTransacaoCampoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFData, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLValor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFValor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPTransacaoCampoLayout.setVerticalGroup(
            jPTransacaoCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPTransacaoCampoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPTransacaoCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLData)
                    .addComponent(jLDescricao)
                    .addComponent(jTFDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFTFData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLValor)
                    .addComponent(jFTFValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPTransacaoBotoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPTransacaoBotoes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jBSalvarTransacao.setText("Salvar");
        jBSalvarTransacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarTransacaoActionPerformed(evt);
            }
        });

        jBAlterarTransacao.setText("Alterar");
        jBAlterarTransacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAlterarTransacaoActionPerformed(evt);
            }
        });

        jBExcluirTransacao.setText("Excluir");
        jBExcluirTransacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirTransacaoActionPerformed(evt);
            }
        });

        jBFechamento.setText("Fechar Fatura");
        jBFechamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFechamentoActionPerformed(evt);
            }
        });

        jLDtFechamento.setText("Data de fechamento:");

        jChkBFaturasFechadas.setText("Fechadas");
        jChkBFaturasFechadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jChkBFaturasFechadasMouseClicked(evt);
            }
        });

        jCBFaturasFechadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBFaturasFechadasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPTransacaoBotoesLayout = new javax.swing.GroupLayout(jPTransacaoBotoes);
        jPTransacaoBotoes.setLayout(jPTransacaoBotoesLayout);
        jPTransacaoBotoesLayout.setHorizontalGroup(
            jPTransacaoBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPTransacaoBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBSalvarTransacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBAlterarTransacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBExcluirTransacao)
                .addGap(195, 195, 195)
                .addComponent(jLDtFechamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFFechamento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBFechamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jChkBFaturasFechadas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCBFaturasFechadas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(167, Short.MAX_VALUE))
        );
        jPTransacaoBotoesLayout.setVerticalGroup(
            jPTransacaoBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPTransacaoBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPTransacaoBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalvarTransacao)
                    .addComponent(jBAlterarTransacao)
                    .addComponent(jBExcluirTransacao)
                    .addComponent(jBFechamento)
                    .addComponent(jFTFFechamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLDtFechamento)
                    .addComponent(jChkBFaturasFechadas)
                    .addComponent(jCBFaturasFechadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPDespesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPTransacaoBotoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPTransacaoCampo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPGridTransacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPParcela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPTransacaoCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPTransacaoBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPGridTransacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * <p><strong>EN:</strong> Applies date formatting to the expense and closing date fields.</p>
     *
     * <p><strong>IT:</strong> Applica la formattazione della data ai campi data spesa e data di chiusura.</p>
     *
     * <p><strong>PT-BR:</strong> Aplica a formatação de data aos campos de data da despesa e de fechamento.</p>
     *
     * @since 1.0.0
     */
    private void formataData(){
        util.formataDataCampo(jFTFData);    
        util.formataDataCampo(jFTFFechamento);
    }  

    /**
     * <p><strong>EN:</strong> Applies currency/amount formatting to the value input field.</p>
     *
     * <p><strong>IT:</strong> Applica la formattazione valuta/importo al campo del valore.</p>
     *
     * <p><strong>PT-BR:</strong> Aplica a formatação de moeda/valor ao campo de valor.</p>
     *
     * @since 1.0.0
     */
    private void formataValor() {        
        jFTFValor.setFormatterFactory(Utilidade.formataValorCampo(ui));
    }  

    /**
     * <p><strong>EN:</strong> Populates the bank JComboBox.</p>
     *
     * <p><strong>IT:</strong> Popola il JComboBox delle banche.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche o JComboBox dos bancos.</p>
     *
     * @since 1.0.0
     */
    private void jcBanco(){
        bancou.jcBanco(jCBBanco);
    }

    /**
     * <p><strong>EN:</strong> Clears and repopulates the card JComboBox with cards from the selected bank.</p>
     *
     * <p><strong>IT:</strong> Svuota e ripopola il JComboBox delle carte con le carte della banca selezionata.</p>
     *
     * <p><strong>PT-BR:</strong> Limpa e preenche novamente o JComboBox de cartões com os cartões do banco selecionado.</p>
     *
     * @since 1.0.0
     */    
    private void jcCartao(){
        jCBCartao.removeAllItems();
        cartaou.jcCartao(jCBCartao, banco.getCd_banco());
    }

    /**
     * <p><strong>EN:</strong> Populates the category JComboBox.</p>
     *
     * <p><strong>IT:</strong> Popola il JComboBox delle categorie.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche o JComboBox das categorias.</p>
     *
     * @since 1.0.0
     */    
    private void jcCategoria() {
        categoriau.jcCategoria(jCBCategoria);
    }

    /**
     * <p><strong>EN:</strong> Populates the expense JComboBox.</p>
     *
     * <p><strong>IT:</strong> Popola il JComboBox delle spese.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche o JComboBox das despesas.</p>
     *
     * @since 1.0.0
     */
    private void jcDespesa(){
        despesau.jcDespesa(jCBDespesa);
    }
 
    /**
     * <p><strong>EN:</strong> Enables or disables the invoice closing controls based on the existence of the user's last transaction.</p>
     *
     * <p><strong>IT:</strong> Abilita o disabilita i controlli di chiusura fattura in base all'esistenza dell'ultima transazione dell'utente.</p>
     *
     * <p><strong>PT-BR:</strong> Habilita ou desabilita os controles de fechamento da fatura conforme a existência do último lançamento do usuário.</p>
     *
     * @since 1.0.0
     */
    private void jbBotaoFechamento(){
        if((CartaoLancamento)cartaolancr.ultimoRegistro(cartaolanc.getCd_usuario()) == null){
            jFTFFechamento.setEnabled(false);
            jBFechamento.setEnabled(false);
            jBFechamento.setText("Fechar Fatura");
        }else{
            jFTFFechamento.setEnabled(true);
            jBFechamento.setEnabled(true);
        }
    }

    /**
     * <p><strong>EN:</strong> Enables or disables the 'launch installment' button depending on whether the user has installment records.</p>
     *
     * <p><strong>IT:</strong> Abilita o disabilita il pulsante per lanciare rate a seconda che l'utente abbia o meno rate registrate.</p>
     *
     * <p><strong>PT-BR:</strong> Habilita ou desabilita o botão de lançamento de parcelas conforme a existência de registros de parcelamento do usuário.</p>
     *
     * @since 1.0.0
     */    
    private void jbBotaoLancarParcela(){
        if((CartaoParcelamento)cartaoparcr.ultimoRegistro(cartaolanc.getCd_usuario()) == null){
            jBLancaParcela.setEnabled(false);
        }else{
            jBLancaParcela.setEnabled(true);
        }
    }
    
    /**
     * <p><strong>EN:</strong> Shows or hides transaction action controls depending on the selected filter (open vs. closed).</p>
     *
     * <p><strong>IT:</strong> Mostra o nasconde i controlli delle azioni di transazione in base al filtro selezionato (aperte vs chiuse).</p>
     *
     * <p><strong>PT-BR:</strong> Exibe ou oculta os controles de ação das transações conforme o filtro selecionado (em aberto vs. fechadas).</p>
     *
     * @since 1.0.0
     */    
    private void jbBotaoTransacoes(){
        if(jRBEmAberto.isSelected() == true){
            jPTransacaoBotoes.setVisible(false);
            jChkBParcela.setVisible(false);
        }else{
            jPTransacaoBotoes.setVisible(true);
            jChkBParcela.setVisible(true);
        }
    }
 
    /**
     * <p><strong>EN:</strong> Clears all form fields and resets selections to their defaults.</p>
     *
     * <p><strong>IT:</strong> Pulisce tutti i campi del modulo e ripristina le selezioni ai valori predefiniti.</p>
     *
     * <p><strong>PT-BR:</strong> Limpa todos os campos do formulário e redefine as seleções para o padrão.</p>
     *
     * @since 1.0.0
     */
    private void limpaCampos(){
        jFTFData.setText(null);
        jTFDescricao.setText(null);
        jFTFValor.setValue(null);
        jChkBParcela.setSelected(false);
        jTFParcela.setText("1");
        jCBCategoria.setSelectedIndex(0);        
        jCBDespesa.setSelectedIndex(0);
        jFTFFechamento.setText(null);
    }

    /**
     * <p><strong>EN:</strong> Validates required fields for a card transaction before saving or updating.  
     * Shows feedback messages on validation failures.</p>
     *
     * <p><strong>IT:</strong> Convalida i campi obbligatori di una transazione carta prima di salvare o aggiornare.  
     * Mostra messaggi in caso di errori di validazione.</p>
     *
     * <p><strong>PT-BR:</strong> Valida os campos obrigatórios de um lançamento de cartão antes de salvar ou atualizar.  
     * Exibe mensagens em caso de falhas de validação.</p>
     *
     * @return EN: true if all fields are valid, false otherwise | IT: true se tutti i campi sono validi, altrimenti false | PT-BR: true se todos os campos forem válidos, caso contrário false
     * @since 1.0.0
     */    
    private boolean validaCampos(){
        if(banco == null){
            JOptionPane.showMessageDialog(null, "Selecione o banco.", "Banco", JOptionPane.INFORMATION_MESSAGE);
            jCBBanco.requestFocus();
            return false;            
        }
        if(cartao == null){
            JOptionPane.showMessageDialog(null, "Selecione o cartão.", "Cartão", JOptionPane.INFORMATION_MESSAGE);
            jCBCartao.requestFocus();
            return false;
        }
        if(util.validaDataCampo(jFTFData.getText()) == false){
            jFTFData.requestFocus();
            return false;
        }
        if(jTFDescricao.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Descrição em branco.", "Cartão Lançamento", JOptionPane.INFORMATION_MESSAGE);
            jTFDescricao.requestFocus();
            return false;
        }
        if(jFTFValor.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Valor em branco.");
            jFTFValor.requestFocus();
            return false;
        }
        if(categoria == null){
            JOptionPane.showMessageDialog(null, "Selecione a categoria.", "Categoria", JOptionPane.INFORMATION_MESSAGE);
            jCBCategoria.requestFocus();
            return false;
        }
        if(jChkBParcela.isSelected() == true && jTFParcela.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Parcela em branco.");
            jTFParcela.requestFocus();
            return false;
        }
        if(jChkBParcela.isSelected() == true && Integer.valueOf(jTFParcela.getText()) <= 1){
            JOptionPane.showMessageDialog(null, "Parcela igual a 1.");
            jTFParcela.requestFocus();
            return false;
        }   
        return true;
    }

    /**
     * <p><strong>EN:</strong> Calculates and displays the current invoice total for the selected card.</p>
     *
     * <p><strong>IT:</strong> Calcola e mostra il totale corrente della fattura per la carta selezionata.</p>
     *
     * <p><strong>PT-BR:</strong> Calcula e exibe o total atual da fatura para o cartão selecionado.</p>
     *
     * @since 1.0.0
     */    
    private void valorFatura(){
        jLVlFatura.setText("Valor Fatura: " + Utilidade.formatoValor.format(cartaolancu.calculaValorFatura(cartao.getCd_cartao())));        
    }
 
    /**
     * <p><strong>EN:</strong> Creates and schedules installment records when the installment option is selected and quantity &gt; 1.  
     * Generates the first installment and triggers the calculation for subsequent ones.</p>
     *
     * <p><strong>IT:</strong> Crea e pianifica le rate quando l'opzione rate è selezionata e la quantità è &gt; 1.  
     * Genera la prima rata e avvia il calcolo delle successive.</p>
     *
     * <p><strong>PT-BR:</strong> Cria e agenda registros de parcelas quando a opção de parcelamento está marcada e a quantidade &gt; 1.  
     * Gera a primeira parcela e aciona o cálculo das demais.</p>
     *
     * @since 1.0.0
     */
    private void salvaParcela(){
        if(jChkBParcela.isSelected() == true && Integer.valueOf(jTFParcela.getText()) > 1){
            codigoParcela();
            cartaoparc.setDt_parcela(cartaolanc.getDt_despesa());
            cartaoparc.setNm_parcelapag(1);
            cartaoparc.setCd_cartaolanc(cartaolanc.getCd_cartaolanc());
            cartaoparc.setCartao(cartao);
            cartaoparc.setDespesa(despesa);
            cartaoparc.setDt_despesa(util.recebeData(jFTFData.getText()));
            cartaoparc.setDs_despesa(jTFDescricao.getText());
            cartaoparc.setNm_valor(Utilidade.converter(jFTFValor.getText()));
            cartaoparc.setCategoria(categoria);
            cartaoparc.setNm_parcela(Integer.parseInt(jTFParcela.getText()));
            cartaoparc.setCd_usuario(JPLogin.codloginuser);
            /*try {
                cartaoparcr.inserirParcela(cartaoparc);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Cartão Parcelamento", JOptionPane.ERROR_MESSAGE);
            }*/
            calculaParcela();
            JOptionPane.showMessageDialog(null, "Salvo Parcelamento.", "Cartão Parcelamento", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Determines the next installment code for the current user based on the last recorded installment.</p>
     *
     * <p><strong>IT:</strong> Determina il prossimo codice rata per l'utente corrente in base all'ultima rata registrata.</p>
     *
     * <p><strong>PT-BR:</strong> Define o próximo código de parcela do usuário atual com base na última parcela registrada.</p>
     *
     * @since 1.0.0
     */
    private void codigoParcela(){
        cartaoparc.setCd_usuario(JPLogin.codloginuser);
        if((CartaoParcelamento)cartaoparcr.ultimoRegistro(cartaoparc.getCd_usuario()) == null){
            cartaoparc.setCd_parcela(0);
        }else{
            cartaoparc = (CartaoParcelamento)cartaoparcr.ultimoRegistro(cartaoparc.getCd_usuario());
            cartaoparc.setCd_parcela(cartaoparc.getCd_parcela() + 1);
        }
    }

    /**
     * <p><strong>EN:</strong> Generates the remaining installments by incrementing the installment date month-by-month and persisting each record.</p>
     *
     * <p><strong>IT:</strong> Genera le rate rimanenti incrementando la data della rata mese per mese e salvando ogni record.</p>
     *
     * <p><strong>PT-BR:</strong> Gera as parcelas restantes incrementando a data da parcela mês a mês e persistindo cada registro.</p>
     *
     * @since 1.0.0
     */    
    private void calculaParcela(){
        cartaoparc.setDt_parcela(cartaolanc.getDt_despesa());
        for(int nmp = 2; nmp <= cartaoparc.getNm_parcela(); nmp++){
            cartaoparc.getDt_parcela().add(Calendar.MONTH, 1);
            cartaoparc.setNm_parcelapag(nmp);
            try {
                cartaoparcr.inserirParcela(cartaoparc);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Cartão Parcelamento - calculaParcela", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * <p><strong>EN:</strong> Computes the next transaction ID (cd_cartaolanc) for the current user based on the latest record.</p>
     *
     * <p><strong>IT:</strong> Calcola il prossimo ID di transazione (cd_cartaolanc) per l'utente corrente in base all'ultimo record.</p>
     *
     * <p><strong>PT-BR:</strong> Calcula o próximo ID de lançamento (cd_cartaolanc) para o usuário atual com base no último registro.</p>
     *
     * @since 1.0.0
     */    
    private void ultimoRegistro(){
        cartaolanc.setCd_usuario(JPLogin.codloginuser);
        if((CartaoLancamento)cartaolancr.ultimoRegistro(cartaolanc.getCd_usuario()) == null){
            cartaolanc.setCd_cartaolanc(0);
        }else{
            cartaolanc = (CartaoLancamento)cartaolancr.ultimoRegistro(cartaolanc.getCd_usuario());
            cartaolanc.setCd_cartaolanc(cartaolanc.getCd_cartaolanc() + 1);
        }
    }

    /**
     * <p><strong>EN:</strong> Creates and saves a new card transaction using the form data.  
     * Sets installment quantity according to the installment checkbox state.</p>
     *
     * <p><strong>IT:</strong> Crea e salva una nuova transazione carta utilizzando i dati del modulo.  
     * Imposta la quantità di rate in base allo stato della casella di spunta.</p>
     *
     * <p><strong>PT-BR:</strong> Cria e salva um novo lançamento de cartão com os dados do formulário.  
     * Define a quantidade de parcelas conforme o estado da opção de parcelamento.</p>
     *
     * @since 1.0.0
     */
    private void salvar(){
        ultimoRegistro();
        cartaolanc.setCartao(cartao);
        cartaolanc.setDespesa(despesa);
        cartaolanc.setDt_despesa(util.recebeData(jFTFData.getText()));
        cartaolanc.setDs_despesa(jTFDescricao.getText());
        cartaolanc.setNm_valor(Utilidade.converter(jFTFValor.getText()));
        cartaolanc.setCategoria(categoria);
        if(jChkBParcela.isSelected()){
            cartaolanc.setNm_parcela(1);
        }else{
            cartaolanc.setNm_parcela(Integer.parseInt(jTFParcela.getText()));           
        }
        cartaolanc.setCd_usuario(JPLogin.codloginuser);
        cartaolancr.inserir(cartaolanc);
        valorFatura();
    }

    /**
     * <p><strong>EN:</strong> Updates an existing card transaction with the modified form data and refreshes the invoice total.</p>
     *
     * <p><strong>IT:</strong> Aggiorna una transazione carta esistente con i dati modificati del modulo e aggiorna il totale della fattura.</p>
     *
     * <p><strong>PT-BR:</strong> Atualiza um lançamento de cartão existente com os dados alterados do formulário e atualiza o total da fatura.</p>
     *
     * @since 1.0.0
     */    
    private void alterar(){
        cartaolanc.setCartao(cartao);
        cartaolanc.setDespesa(despesa);
        cartaolanc.setDt_despesa(util.recebeData(jFTFData.getText()));
        cartaolanc.setDs_despesa(jTFDescricao.getText());
        cartaolanc.setNm_valor(Utilidade.converter(jFTFValor.getText()));
        cartaolanc.setCategoria(categoria);
        cartaolanc.setNm_parcela(Integer.parseInt(jTFParcela.getText()));
        cartaolanc.setCd_usuario(JPLogin.codloginuser);
        cartaolancr.alterar(cartaolanc);   
        valorFatura();
    }
 
    /**
     * <p><strong>EN:</strong> Deletes the selected card transaction and refreshes the invoice total.</p>
     *
     * <p><strong>IT:</strong> Elimina la transazione carta selezionata e aggiorna il totale della fattura.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui o lançamento de cartão selecionado e atualiza o total da fatura.</p>
     *
     * @since 1.0.0
     */
    private void excluir(){
        cartaolanc.setCd_cartaolanc(cartaolanc.getCd_cartaolanc());
        cartaolanc.setCartao(cartaolanc.getCartao());
        cartaolanc.setCd_usuario(cartaolanc.getCd_usuario());
        cartaolancr.excluir(cartaolanc);
        valorFatura();
    }
            
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifcartaolancamento = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jCBBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBBancoActionPerformed
        if(jCBBanco.getSelectedIndex() != 0){
            banco = (Banco)jCBBanco.getSelectedItem();
            jcCartao();
        }else{
            banco = null;
        }
    }//GEN-LAST:event_jCBBancoActionPerformed

    private void jCBDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBDespesaActionPerformed
        despesa = (Despesa)jCBDespesa.getSelectedItem();
        if(jCBDespesa.getSelectedIndex() != 0){
            jFTFData.setText(Utilidade.formatoData.format(Calendar.getInstance().getTime()));
            jTFDescricao.setText(despesa.getDs_despesa() + " - " + despesa.getPresserv());
            jFTFValor.setText(Utilidade.formatoValor.format(despesa.getNm_valor()));
            jCBCategoria.getModel().setSelectedItem(despesa.getCategoria());
        }
    }//GEN-LAST:event_jCBDespesaActionPerformed

    private void jBSalvarTransacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarTransacaoActionPerformed
        if(validaCampos()){            
            salvaParcela();
            salvar();
            limpaCampos();
            jRBEmAberto.setSelected(false);
            jbBotaoFechamento();
            cartaolancu.tabelaCartaoLancamento(jTTransacao, cartao.getCd_cartao());
        }
    }//GEN-LAST:event_jBSalvarTransacaoActionPerformed

    private void jCBCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBCategoriaActionPerformed
        if(jCBCategoria.getSelectedIndex() != 0){
            categoria = (Categoria)jCBCategoria.getSelectedItem();
        }else{
            categoria = null;
        }
    }//GEN-LAST:event_jCBCategoriaActionPerformed

    private void jTTransacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTTransacaoMouseClicked
        if(jChkBFaturasFechadas.isSelected() == false){
            if(jRBEmAberto.isSelected() == false){
                cartaolanc = (CartaoLancamento)cartaolancu.getSelectObject(jTTransacao);
                if(cartaolanc.getDespesa() == null){
                    jCBDespesa.setSelectedIndex(0);
                }else{
                    jCBDespesa.getModel().setSelectedItem(cartaolanc.getDespesa());            
                }
                jTFDescricao.setText(cartaolanc.getDs_despesa());
                jFTFData.setText(Utilidade.formatoData.format(cartaolanc.getDt_despesa().getTime()));
                jFTFValor.setText(Utilidade.formatoValor.format(cartaolanc.getNm_valor()));
                if(cartaolanc.getCategoria() == null){
                    jCBCategoria.setSelectedIndex(0);
                }else{
                    jCBCategoria.getModel().setSelectedItem(cartaolanc.getCategoria());                
                }
                jTFParcela.setText(Integer.toString(cartaolanc.getNm_parcela()));
                if(cartaolanc.getNm_parcela() == 1){
                    jChkBParcela.setSelected(false);
                }else{
                    jChkBParcela.setSelected(true);
                }            
            }else{
                cartaoparc = (CartaoParcelamento)cartaoparcu.getSelectObject(jTTransacao);
                if(cartaoparc.getDespesa() == null){
                    jCBDespesa.setSelectedIndex(0);
                }else{
                    jCBDespesa.getModel().setSelectedItem(cartaoparc.getDespesa());            
                }
                jTFDescricao.setText(cartaoparc.getDs_despesa());
                jFTFData.setText(Utilidade.formatoData.format(cartaoparc.getDt_parcela().getTime()));
                jFTFValor.setText(Utilidade.formatoValor.format(cartaoparc.getNm_valor()));
                jCBCategoria.getModel().setSelectedItem(cartaoparc.getCategoria());
                jTFParcela.setText(Integer.toString(cartaoparc.getNm_parcelapag()));
                jChkBParcela.setSelected(false);
            }            
        }
        
    }//GEN-LAST:event_jTTransacaoMouseClicked

    private void jBAlterarTransacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarTransacaoActionPerformed
        if(cartaolancu.getSelectObject(jTTransacao) != null){
            alterar();
            limpaCampos();
            cartaolancu.tabelaCartaoLancamento(jTTransacao, cartao.getCd_cartao());
        }
    }//GEN-LAST:event_jBAlterarTransacaoActionPerformed

    private void jBExcluirTransacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirTransacaoActionPerformed
        if(cartaolancu.getSelectObject(jTTransacao) != null){
            excluir();
            limpaCampos();
            jbBotaoFechamento();
            cartaolancu.tabelaCartaoLancamento(jTTransacao, cartao.getCd_cartao());         
        }
    }//GEN-LAST:event_jBExcluirTransacaoActionPerformed

    private void jBFechamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFechamentoActionPerformed
        cartaolanc.setCd_usuario(JPLogin.codloginuser);
        cartaolancf.setCd_usuario(JPLogin.codloginuser);
        cartaolanc.setCartao(cartao);
        if(jChkBFaturasFechadas.isSelected() == false){
            if(!util.validaDataCampo(jFTFFechamento.getText())){
                jFTFFechamento.requestFocus();
            }else{  
                if((CartaoLancamentoFechamento)cartaolancfr.ultimoRegistro(cartaolanc.getCd_usuario()) == null){
                    cartaolancf.setCd_cartaolancf(0);
                }else{
                    cartaolancf = (CartaoLancamentoFechamento)cartaolancfr.ultimoRegistro(cartaolanc.getCd_usuario());
                    cartaolancf.setCd_cartaolancf(cartaolancf.getCd_cartaolancf() + 1); 
                }
                cartaolancf.setDt_fechamento(util.recebeData(jFTFFechamento.getText()));
                cartaolancf.setCartao(cartao);
                try {
                    cartaolancfr.inserirFechamento(cartaolancf);
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Erro a fechar a fatura:\n" +
                            ex.getMessage(), "Cartão Lançamento Fechamento", JOptionPane.INFORMATION_MESSAGE);
                }
                try {
                    cartaolancfr.alterarFechamento(cartaolancf);
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Erro ao alterar fechamento:\n" +
                            ex.getMessage(), "Cartão Lançamento Fechamento", JOptionPane.ERROR_MESSAGE);
                }
                try {
                    cartaolancfr.excluirFechamento(cartaolanc);
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Erro ao excluir fechamento:\n" +
                            ex.getMessage(), "Cartão Lançamento Fechamento", JOptionPane.ERROR_MESSAGE);
                }
                JOptionPane.showMessageDialog(null, "Fatura fechada.", "Cartão Lançamento Fechamento", JOptionPane.INFORMATION_MESSAGE);
                limpaCampos();
                jbBotaoFechamento();
                cartaolancu.tabelaCartaoLancamento(jTTransacao, cartao.getCd_cartao());                
                jLVlFatura.setText("Valor Fatura: 0,00");
            }
        }
        if(jChkBFaturasFechadas.isSelected() == true){
            if(!util.validaDataCampo(jFTFFechamento.getText())){
                jFTFFechamento.requestFocus();
            }else{
                cartaolancf.setDt_fechamento(util.recebeData(jFTFFechamento.getText()));
                cartaolancf.setCartao(cartao);                
                cartaolancfu.tabelaCartaoFechamento(jTTransacao, cartaolancf.getDt_fechamento(), cartaolancf.getCartao().getCd_cartao());  
                jLVlFatura.setText("Valor Fatura: " + Utilidade.formatoValor.format(cartaolancfu.calculaValorFatura(cartaolancf.getDt_fechamento(), cartaolancf.getCartao().getCd_cartao()))); 
            }
        }
    }//GEN-LAST:event_jBFechamentoActionPerformed

    private void jCBCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBCartaoActionPerformed
        if(jCBCartao.getSelectedIndex() != 0){
            cartao = (Cartao)jCBCartao.getSelectedItem();
        }else{
            cartao = null;
        }
        if(cartao != null){
            cartaolancu.tabelaCartaoLancamento(jTTransacao, cartao.getCd_cartao());
            valorFatura();
            cartaolanc.setCd_usuario(cartao.getCd_usuario());
            jbBotaoFechamento();
            if(cartao.getCd_cartao() == 0){
                jFTFFechamento.setText(null);             
                jChkBFaturasFechadas.setSelected(false);
                jChkBFaturasFechadas.setEnabled(false);
                jCBFaturasFechadas.setEnabled(false);
                jCBFaturasFechadas.removeAllItems();
                jRBEmAberto.setSelected(false);
                jRBEmAberto.setEnabled(false);
            }else{
                jChkBFaturasFechadas.setEnabled(true);
                jRBEmAberto.setEnabled(true);
            }
        }
    }//GEN-LAST:event_jCBCartaoActionPerformed

    private void jChkBFaturasFechadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jChkBFaturasFechadasMouseClicked
        if(jChkBFaturasFechadas.isSelected() == true){
            jRBEmAberto.setSelected(false);
            jBFechamento.setText("Relatório");
            jBFechamento.setEnabled(true);
            jFTFFechamento.setEnabled(true);
            jCBFaturasFechadas.setEnabled(true);
            cartaolancfu.jcDataFechamento(jCBFaturasFechadas, cartao.getCd_cartao());
            jBSalvarTransacao.setEnabled(false);
            jBAlterarTransacao.setEnabled(false);
            jBExcluirTransacao.setEnabled(false);
            jFTFFechamento.setEnabled(false);
            cartaolancu.tabelaCartaoLancamento(jTTransacao, 0);
        }else{
            jbBotaoFechamento();
            jFTFFechamento.setText(null);
            jCBFaturasFechadas.setEnabled(false);
            jCBFaturasFechadas.removeAllItems();
            jBFechamento.setText("Fechar Fatura");
            cartaolancu.tabelaCartaoLancamento(jTTransacao, cartao.getCd_cartao());
            jLVlFatura.setText("Valor Fatura: " + Utilidade.formatoValor.format(cartaolancu.calculaValorFatura(cartao.getCd_cartao())));
            jBSalvarTransacao.setEnabled(true);
            jBAlterarTransacao.setEnabled(true);
            jBExcluirTransacao.setEnabled(true); 
            jFTFFechamento.setEnabled(true);
        }  
    }//GEN-LAST:event_jChkBFaturasFechadasMouseClicked

    private void jCBFaturasFechadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBFaturasFechadasActionPerformed
        if(jCBFaturasFechadas.isEnabled() == true){
            jFTFFechamento.setText(jCBFaturasFechadas.getSelectedItem().toString());             
        }
    }//GEN-LAST:event_jCBFaturasFechadasActionPerformed

    private void jChkBParcelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChkBParcelaActionPerformed
        if(!util.validaDataCampo(jFTFData.getText()) == false){
            cartaolanc.setDt_despesa(util.recebeData(jFTFData.getText()));            
        }
    }//GEN-LAST:event_jChkBParcelaActionPerformed

    private void jRBEmAbertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBEmAbertoActionPerformed
        if(jRBEmAberto.isSelected() == true){
            jChkBFaturasFechadas.setSelected(false);
            cartaoparcu.tabelaCartaoParcela(jTTransacao, cartao.getCd_cartao());
            jbBotaoLancarParcela();
        }else{
            cartaolancu.tabelaCartaoLancamento(jTTransacao, cartao.getCd_cartao());
            jBLancaParcela.setEnabled(false);
        }
        limpaCampos();
        jbBotaoTransacoes();
    }//GEN-LAST:event_jRBEmAbertoActionPerformed

    private void jBLancaParcelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLancaParcelaActionPerformed
        if((CartaoLancamento)cartaoparcu.getSelectObject(jTTransacao) != null){
            ultimoRegistro();
            cartaolanc.setCartao(cartao);
            cartaolanc.setDespesa(despesa);
            //cartaolanc.setDt_despesa(cartaoparc.getDt_parcela());
            cartaolanc.setDt_despesa(util.recebeData(jFTFData.getText()));
            cartaolanc.setDs_despesa(jTFDescricao.getText());
            cartaolanc.setNm_valor(Utilidade.converter(jFTFValor.getText()));
            cartaolanc.setCategoria(categoria);
            cartaolanc.setNm_parcela(cartaoparc.getNm_parcelapag());
            cartaolanc.setCd_usuario(JPLogin.codloginuser);     
            cartaolancr.inserir(cartaolanc);
            cartaolancu.tabelaCartaoLancamento(jTTransacao, cartao.getCd_cartao());
            limpaCampos();
            jRBEmAberto.setSelected(false);     
            jBLancaParcela.setEnabled(false);
            cartaoparcr.excluirParcelas(cartaoparc);
            valorFatura();
            jbBotaoTransacoes();            
        }
    }//GEN-LAST:event_jBLancaParcelaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterarTransacao;
    private javax.swing.JButton jBExcluirTransacao;
    private javax.swing.JButton jBFechamento;
    private javax.swing.JButton jBLancaParcela;
    private javax.swing.JButton jBSalvarTransacao;
    private javax.swing.JComboBox<Banco> jCBBanco;
    private javax.swing.JComboBox<Cartao> jCBCartao;
    private javax.swing.JComboBox<Categoria> jCBCategoria;
    private javax.swing.JComboBox<Despesa> jCBDespesa;
    private javax.swing.JComboBox<String> jCBFaturasFechadas;
    private javax.swing.JCheckBox jChkBFaturasFechadas;
    private javax.swing.JCheckBox jChkBParcela;
    private javax.swing.JFormattedTextField jFTFData;
    private javax.swing.JFormattedTextField jFTFFechamento;
    private javax.swing.JFormattedTextField jFTFValor;
    private javax.swing.JLabel jLData;
    private javax.swing.JLabel jLDescricao;
    private javax.swing.JLabel jLDtFechamento;
    private javax.swing.JLabel jLValor;
    private javax.swing.JLabel jLVlFatura;
    private javax.swing.JPanel jPDespesa;
    private javax.swing.JPanel jPGridTransacao;
    private javax.swing.JPanel jPParcela;
    private javax.swing.JPanel jPPrincipal;
    private javax.swing.JPanel jPTransacaoBotoes;
    private javax.swing.JPanel jPTransacaoCampo;
    private javax.swing.JRadioButton jRBEmAberto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFDescricao;
    private javax.swing.JTextField jTFParcela;
    private javax.swing.JTable jTTransacao;
    // End of variables declaration//GEN-END:variables
}
