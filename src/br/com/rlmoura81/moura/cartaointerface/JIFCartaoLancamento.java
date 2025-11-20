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
    
    Banco banco = null;
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
        jcDespesa();
        jcCampos();
        formataData();
        formataValor();  
        jcCategoria();
        jcBotoesTransacoes();   
        jcParcela();
        jcFechamento();
        
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
        jCBParcela = new javax.swing.JComboBox<>();
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
        jPFechamento = new javax.swing.JPanel();
        jBFechamento = new javax.swing.JButton();
        jLDtFechamento = new javax.swing.JLabel();
        jFTFDtFechamento = new javax.swing.JFormattedTextField();
        jChkBFaturasFechadas = new javax.swing.JCheckBox();
        jCBStPagamento = new javax.swing.JComboBox<>();
        jCBFaturasFechadas = new javax.swing.JComboBox<>();
        jBPagar = new javax.swing.JButton();

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

        jCBParcela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBParcelaActionPerformed(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCBParcela, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jBLancaParcela)
                    .addComponent(jCBParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPTransacaoCampo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLData.setText("Data:");

        jFTFData.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFTFDataFocusGained(evt);
            }
        });

        jLDescricao.setText("Descrição:");

        jLValor.setText("Valor:");

        jFTFValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFTFValorFocusGained(evt);
            }
        });

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPTransacaoBotoesLayout.setVerticalGroup(
            jPTransacaoBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPTransacaoBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPTransacaoBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAlterarTransacao)
                    .addComponent(jBExcluirTransacao)
                    .addComponent(jBSalvarTransacao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPFechamento.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBFechamento.setText("Fechar Fatura");
        jBFechamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFechamentoActionPerformed(evt);
            }
        });

        jLDtFechamento.setText("Data de fechamento:");

        jFTFDtFechamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFTFDtFechamentoFocusGained(evt);
            }
        });

        jChkBFaturasFechadas.setText("Fechadas");
        jChkBFaturasFechadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jChkBFaturasFechadasMouseClicked(evt);
            }
        });

        jCBStPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Em aberta", "Paga", "Atrasada" }));
        jCBStPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBStPagamentoActionPerformed(evt);
            }
        });

        jCBFaturasFechadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBFaturasFechadasActionPerformed(evt);
            }
        });

        jBPagar.setText("Pagar");
        jBPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPFechamentoLayout = new javax.swing.GroupLayout(jPFechamento);
        jPFechamento.setLayout(jPFechamentoLayout);
        jPFechamentoLayout.setHorizontalGroup(
            jPFechamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFechamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBFechamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLDtFechamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFDtFechamento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jChkBFaturasFechadas)
                .addGap(18, 18, 18)
                .addComponent(jCBStPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCBFaturasFechadas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBPagar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPFechamentoLayout.setVerticalGroup(
            jPFechamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFechamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPFechamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBFechamento)
                    .addComponent(jLDtFechamento)
                    .addComponent(jFTFDtFechamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChkBFaturasFechadas)
                    .addComponent(jCBFaturasFechadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBStPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBPagar))
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
                    .addComponent(jPParcela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPFechamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPFechamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        util.formataDataCampo(jFTFDtFechamento);
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
        util.insereTxtPadraoValor(jFTFValor);
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
        jcCartao();
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
        if(banco != null){
            jCBCartao.setEnabled(true);
            jCBCartao.removeAllItems();
            cartaou.jcCartao(jCBCartao, banco.getCd_banco());              
        }else{
            jCBCartao.removeAllItems();
            jCBCartao.setEnabled(false);
            cartao = null;
        }

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
        if(cartao != null){
            jCBCategoria.setEnabled(true);
            categoriau.jcCategoria(jCBCategoria);            
        }else{
            jCBCategoria.setEnabled(false);
        }

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
        if(cartao != null){
            jCBDespesa.setEnabled(true);
            despesau.jcDespesa(jCBDespesa);
        }else{
            jCBDespesa.setEnabled(false);
        }
    }
    
    /*
    * EM TESTE - COLOCAR COMENTARIO
    */
 
    private void jcCampos(){
        if(cartao != null){
            jFTFData.setEnabled(true);
            jTFDescricao.setEnabled(true);
            jFTFValor.setEnabled(true);
        }else{
            jFTFData.setText(null);            
            jFTFData.setEnabled(false);
            jTFDescricao.setText(null);
            jTFDescricao.setEnabled(false);
            jFTFValor.setValue(null);            
            jFTFValor.setEnabled(false);  
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
    
    /*
    *TESTANDO - COLOCAR COMENTARIO
    *JCOMBOBOX PARCELA
    */
    private void jcParcela(){
        if(cartao != null){
            jChkBParcela.setEnabled(true);
            jTFParcela.setEnabled(true);
            if(jRBEmAberto.isVisible() == true){
                if(jRBEmAberto.isSelected() == true){
                    jCBParcela.setEnabled(true);
                    cartaoparcu.jcParcela(jCBParcela, cartao.getCd_cartao());
                }else{
                    cartaoparcu.jcParcela(jCBParcela,cartao.getCd_cartao());
                    jCBParcela.setEnabled(false);
                    jBLancaParcela.setEnabled(false);
                }
            }
        }else{            
            jChkBParcela.setEnabled(false);
            jTFParcela.setText("1");
            jTFParcela.setEnabled(false);
            jCBParcela.removeAllItems();
            jCBParcela.setEnabled(false);
            jRBEmAberto.setEnabled(false);
            jBLancaParcela.setEnabled(false);
        }    
    }
    
    /*
    * EM TESTE - COLOCAR COMENTARIO
    */
    
    private void jcBotoesTransacoes(){
        if(cartao != null){
            jBSalvarTransacao.setEnabled(true);
            jBAlterarTransacao.setEnabled(true);
            jBExcluirTransacao.setEnabled(true);
        }else{
            jBSalvarTransacao.setEnabled(false);
            jBAlterarTransacao.setEnabled(false);
            jBExcluirTransacao.setEnabled(false);            
        }
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
    
    private void jcFechamento(){
        if(banco == null){
            jBFechamento.setEnabled(false);
            jBFechamento.setText("Fechar Fatura");
            jFTFDtFechamento.setEnabled(false);
            jChkBFaturasFechadas.setSelected(false);
            jChkBFaturasFechadas.setEnabled(false);
            jCBStPagamento.setEnabled(false);
            jCBFaturasFechadas.setEnabled(false);
        }else{
            jFTFDtFechamento.setEnabled(true);
            jBFechamento.setEnabled(true);
        }
        jbPagar();
        
        /*
        if((CartaoLancamento)cartaolancr.ultimoRegistro(cartaolanc.getCd_usuario()) == null){
            jFTFFechamento.setEnabled(false);
            jBFechamento.setEnabled(false);
            jBFechamento.setText("Fechar Fatura");
            jCBFaturasFechadas.setEnabled(false);
            jCBStPagamento.setEnabled(false);
        }else{
            jFTFFechamento.setEnabled(true);
            jBFechamento.setEnabled(true);
        }
        */
    }
    
    /*
    *EM TESTE - COLOCAR COMENTARIO
    *VALIDA ST_PAGAMENTO
    */
    
    private void jcStPagamento(){
        if(jCBStPagamento.isEnabled() == true){
            cartaolancfu.jcStFechamento(jCBFaturasFechadas, cartao.getCd_cartao(), jCBStPagamento.getSelectedIndex());
        }
        jbPagar();
    }

    /*
    *EM TESTE - COLOCAR COMENTARIO
    *FUNCAO PARA PAGAR FATURA EM ABERTO
    */
    
    private void jbPagar(){
        if(jCBStPagamento.getSelectedIndex() == 0 && jCBFaturasFechadas.isEnabled() == true && jCBFaturasFechadas.getSelectedIndex() != 0){
            jBPagar.setEnabled(true);
        }else{
            jBPagar.setEnabled(false);
            jFTFDtFechamento.setText(null);
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
        }else{
            jPTransacaoBotoes.setVisible(true);
        }
    }
    
    private void jpFechamento(){
        if(jRBEmAberto.isSelected() == true){
            jPFechamento.setVisible(false);
            jChkBParcela.setVisible(false);
        }else{
            jPFechamento.setVisible(true);
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
        jFTFDtFechamento.setText(null);
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
        if(cartao != null){
            jLVlFatura.setText("Valor Fatura: " + Utilidade.formatoValor.format(cartaolancu.calculaValorFatura(cartao.getCd_cartao())));    
        }else{
            jLVlFatura.setText("Valor Fatura:");
        }       
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
            jcCartao();
        }
    }//GEN-LAST:event_jCBBancoActionPerformed

    private void jCBDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBDespesaActionPerformed
        despesa = (Despesa)jCBDespesa.getSelectedItem();
        if(jCBDespesa.getSelectedIndex() != 0){
            jFTFData.setText(Utilidade.formatoData.format(Calendar.getInstance().getTime()));
            jTFDescricao.setText(despesa.getDs_despesa() + " - " + despesa.getEmpresa());
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
            jcFechamento();
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
            jcFechamento();
            cartaolancu.tabelaCartaoLancamento(jTTransacao, cartao.getCd_cartao());         
        }
    }//GEN-LAST:event_jBExcluirTransacaoActionPerformed

    private void jBFechamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFechamentoActionPerformed
        cartaolanc.setCd_usuario(JPLogin.codloginuser);
        cartaolancf.setCd_usuario(JPLogin.codloginuser);
        cartaolanc.setCartao(cartao);
        if(jChkBFaturasFechadas.isSelected() == false){
            if(!util.validaDataCampo(jFTFDtFechamento.getText())){
                jFTFDtFechamento.requestFocus();
            }else{  
                if((CartaoLancamentoFechamento)cartaolancfr.ultimoRegistro(cartaolanc.getCd_usuario()) == null){
                    cartaolancf.setCd_cartaolancf(0);
                }else{
                    cartaolancf = (CartaoLancamentoFechamento)cartaolancfr.ultimoRegistro(cartaolanc.getCd_usuario());
                    cartaolancf.setCd_cartaolancf(cartaolancf.getCd_cartaolancf() + 1); 
                }
                cartaolancf.setDt_fechamento(util.recebeData(jFTFDtFechamento.getText()));
                cartaolancf.setCartao(cartao);
                try {
                    cartaolancfr.inserirFechamento(cartaolancf);
                    cartaolancf.setSt_pagamento(0);
                    cartaolancfr.inserirFechamentoSt(cartaolancf);
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
                jcFechamento();
                cartaolancu.tabelaCartaoLancamento(jTTransacao, cartao.getCd_cartao());                
                jLVlFatura.setText("Valor Fatura: 0,00");
            }
        }
        if(jChkBFaturasFechadas.isSelected() == true){
            if(!util.validaDataCampo(jFTFDtFechamento.getText())){
                jFTFDtFechamento.requestFocus();
            }else{
                cartaolancf.setDt_fechamento(util.recebeData(jFTFDtFechamento.getText()));
                cartaolancf.setCartao(cartao);                
                cartaolancfu.tabelaCartaoFechamento(jTTransacao, cartaolancf.getDt_fechamento(), cartaolancf.getCartao().getCd_cartao());  
                jLVlFatura.setText("Valor Fatura: " + Utilidade.formatoValor.format(cartaolancfu.calculaValorFatura(cartaolancf.getDt_fechamento(), cartaolancf.getCartao().getCd_cartao()))); 
            }
        }
    }//GEN-LAST:event_jBFechamentoActionPerformed

    private void jCBCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBCartaoActionPerformed
        if(jCBCartao.getSelectedIndex() != 0){
            cartao = (Cartao)jCBCartao.getSelectedItem();
            valorFatura();
            jcDespesa();
            jcCampos();
            jcCategoria();
            jcParcela();
            jcBotoesTransacoes(); 
            jcFechamento();            
            if(cartao != null){
                cartaolancu.tabelaCartaoLancamento(jTTransacao, cartao.getCd_cartao());
                valorFatura();
                cartaolanc.setCd_usuario(cartao.getCd_usuario());
                jcFechamento();
                if(cartao.getCd_cartao() == 0){
                    jFTFDtFechamento.setText(null);             
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
        }else{
            cartao = null;
        }
    }//GEN-LAST:event_jCBCartaoActionPerformed

    private void jChkBFaturasFechadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jChkBFaturasFechadasMouseClicked
        if(jChkBFaturasFechadas.isSelected() == true){
            jRBEmAberto.setSelected(false);
            jBFechamento.setText("Relatório");
            jBFechamento.setEnabled(true);
            jFTFDtFechamento.setEnabled(true);
            jCBStPagamento.setEnabled(true);
            jcStPagamento();
            jCBFaturasFechadas.setEnabled(true);            
            jBSalvarTransacao.setEnabled(false);
            jBAlterarTransacao.setEnabled(false);
            jBExcluirTransacao.setEnabled(false);
            jFTFDtFechamento.setEnabled(false);
            cartaolancu.tabelaCartaoLancamento(jTTransacao, 0);
        }else{
            jcFechamento();
            jFTFDtFechamento.setText(null);
            jCBFaturasFechadas.setEnabled(false);
            jCBFaturasFechadas.removeAllItems();
            jCBStPagamento.setSelectedIndex(0);
            jCBStPagamento.setEnabled(false);
            jBFechamento.setText("Fechar Fatura");
            cartaolancu.tabelaCartaoLancamento(jTTransacao, cartao.getCd_cartao());
            jLVlFatura.setText("Valor Fatura: " + Utilidade.formatoValor.format(cartaolancu.calculaValorFatura(cartao.getCd_cartao())));
            jBSalvarTransacao.setEnabled(true);
            jBAlterarTransacao.setEnabled(true);
            jBExcluirTransacao.setEnabled(true); 
            jFTFDtFechamento.setEnabled(true);
        }  
    }//GEN-LAST:event_jChkBFaturasFechadasMouseClicked

    private void jCBFaturasFechadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBFaturasFechadasActionPerformed
        if(jCBFaturasFechadas.isEnabled() == true){
            cartaolancf = (CartaoLancamentoFechamento) jCBFaturasFechadas.getSelectedItem();
            if(cartaolancf.getCartao() == null){                  
                cartaolancf.setCartao(cartao);  
                if(cartaolancf.getDt_fechamento() != null){
                    jFTFDtFechamento.setText(Utilidade.formatoData.format(cartaolancf.getDt_fechamento().getTime())); 
                }else{
                    jFTFDtFechamento.setText(null);
                }    
            } 
            jbPagar();
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
        jpFechamento();
        jcParcela();
    }//GEN-LAST:event_jRBEmAbertoActionPerformed

    private void jBLancaParcelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLancaParcelaActionPerformed
        if((CartaoLancamento)cartaoparcu.getSelectObject(jTTransacao) != null){
            ultimoRegistro();
            cartaolanc.setCartao(cartao);
            cartaolanc.setDespesa(despesa);
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
            jcParcela();
            valorFatura();
            jbBotaoTransacoes();
            jpFechamento();
        }
    }//GEN-LAST:event_jBLancaParcelaActionPerformed

    private void jCBParcelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBParcelaActionPerformed
        if(jCBParcela.getSelectedIndex() != 0){
            cartaoparc = (CartaoParcelamento)jCBParcela.getSelectedItem();
            if(cartaoparc != null){
                cartaoparcu.tabelaCartaoParcela(jTTransacao, cartaoparc.getCd_parcela(), cartao.getCd_cartao());   
            }
        }        
    }//GEN-LAST:event_jCBParcelaActionPerformed

    private void jCBStPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBStPagamentoActionPerformed
        jcStPagamento();
    }//GEN-LAST:event_jCBStPagamentoActionPerformed

    private void jBPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPagarActionPerformed
        cartaolancfr.alterarStPagamento(cartaolancf);
        jcStPagamento();
    }//GEN-LAST:event_jBPagarActionPerformed

    private void jFTFDataFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTFDataFocusGained
        util.posicionaCursojFTFData(jFTFData);
    }//GEN-LAST:event_jFTFDataFocusGained

    private void jFTFDtFechamentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTFDtFechamentoFocusGained
        util.posicionaCursojFTFData(jFTFDtFechamento);
    }//GEN-LAST:event_jFTFDtFechamentoFocusGained

    private void jFTFValorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTFValorFocusGained
        util.posicionaCursojFTFValor(jFTFValor);
    }//GEN-LAST:event_jFTFValorFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterarTransacao;
    private javax.swing.JButton jBExcluirTransacao;
    private javax.swing.JButton jBFechamento;
    private javax.swing.JButton jBLancaParcela;
    private javax.swing.JButton jBPagar;
    private javax.swing.JButton jBSalvarTransacao;
    private javax.swing.JComboBox<Banco> jCBBanco;
    private javax.swing.JComboBox<Cartao> jCBCartao;
    private javax.swing.JComboBox<Categoria> jCBCategoria;
    private javax.swing.JComboBox<Despesa> jCBDespesa;
    private javax.swing.JComboBox<CartaoLancamentoFechamento> jCBFaturasFechadas;
    private javax.swing.JComboBox<CartaoParcelamento> jCBParcela;
    private javax.swing.JComboBox<String> jCBStPagamento;
    private javax.swing.JCheckBox jChkBFaturasFechadas;
    private javax.swing.JCheckBox jChkBParcela;
    private javax.swing.JFormattedTextField jFTFData;
    private javax.swing.JFormattedTextField jFTFDtFechamento;
    private javax.swing.JFormattedTextField jFTFValor;
    private javax.swing.JLabel jLData;
    private javax.swing.JLabel jLDescricao;
    private javax.swing.JLabel jLDtFechamento;
    private javax.swing.JLabel jLValor;
    private javax.swing.JLabel jLVlFatura;
    private javax.swing.JPanel jPDespesa;
    private javax.swing.JPanel jPFechamento;
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
