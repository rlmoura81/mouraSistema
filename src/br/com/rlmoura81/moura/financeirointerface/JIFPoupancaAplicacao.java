package br.com.rlmoura81.moura.financeirointerface;

import br.com.rlmoura81.moura.financeiro.Conta;
import br.com.rlmoura81.moura.financeiro.ContaUtil;
import br.com.rlmoura81.moura.financeiro.GrupoTransacao;
import br.com.rlmoura81.moura.financeiro.IndiceValor;
import br.com.rlmoura81.moura.financeiro.IndiceValorUtil;
import br.com.rlmoura81.moura.financeiro.Poupanca;
import br.com.rlmoura81.moura.financeiro.PoupancaAplicacao;
import br.com.rlmoura81.moura.financeiro.PoupancaAplicacaoUtil;
import br.com.rlmoura81.moura.financeiro.PoupancaAplicacaoRepository;
import br.com.rlmoura81.moura.financeiro.PoupancaRepository;
import br.com.rlmoura81.moura.financeiro.PoupancaTransacao;
import br.com.rlmoura81.moura.financeiro.PoupancaTransacaoRepository;
import br.com.rlmoura81.moura.financeiro.PoupancaTransacaoUtil;
import br.com.rlmoura81.moura.financeiro.PoupancaUtil;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class JIFPoupancaAplicacao extends javax.swing.JInternalFrame {
    
    private static JIFPoupancaAplicacao jifpoupaplic;
    
    /**
     * <p><strong>EN:</strong> Opens the {@link JIFPoupancaAplicacao} screen for savings applications.  
     * If no instance exists, it creates a new one, sets the title, and returns it.</p>
     *
     * <p><strong>IT:</strong> Apre la finestra {@link JIFPoupancaAplicacao} per le applicazioni di risparmio.  
     * Se non esiste alcuna istanza, ne crea una nuova, imposta il titolo e la restituisce.</p>
     *
     * <p><strong>PT-BR:</strong> Abre a tela {@link JIFPoupancaAplicacao} para aplicações de poupança.  
     * Caso não exista uma instância, cria uma nova, define o título e a retorna.</p>
     */
    public static JIFPoupancaAplicacao getInstancia(){
        if(jifpoupaplic == null){
            jifpoupaplic = new JIFPoupancaAplicacao();
            jifpoupaplic.setTitle("Poupança Aplicação");
        }return jifpoupaplic;
    }

    Conta conta = null;
    ContaUtil contau = new ContaUtil();
    
    GrupoTransacao gptrans = new GrupoTransacao();
    
    Poupanca poupanca = null;
    PoupancaRepository poupancar = new PoupancaRepository();
    PoupancaUtil poupancau = new PoupancaUtil();
    
    PoupancaAplicacao poupancaap = new PoupancaAplicacao();
    PoupancaAplicacaoRepository poupancaapr = new PoupancaAplicacaoRepository();
    PoupancaAplicacaoUtil poupancaapu = new PoupancaAplicacaoUtil();
    
    PoupancaTransacao pouptr = new PoupancaTransacao();
    PoupancaTransacaoRepository pouptrr = new PoupancaTransacaoRepository();
    PoupancaTransacaoUtil pouptru = new PoupancaTransacaoUtil();
    
    IndiceValor iv = new IndiceValor();
    IndiceValorUtil ivu = new IndiceValorUtil();
    
    Utilidade util = new Utilidade();

    public JIFPoupancaAplicacao() {
        initComponents();
        
        jcConta();
        formataValor();
        formataData();
        desativaCampos();
        
        jCBPoupanca.setEnabled(false);
                      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPPoupancaAplicacao = new javax.swing.JPanel();
        jCBConta = new javax.swing.JComboBox<>();
        jCBPoupanca = new javax.swing.JComboBox<>();
        jLSaldo = new javax.swing.JLabel();
        jPTransacaoCampos = new javax.swing.JPanel();
        jLDtTransacao = new javax.swing.JLabel();
        jFTFDtTransacao = new javax.swing.JFormattedTextField();
        jLValor = new javax.swing.JLabel();
        jFTFValorTransacao = new javax.swing.JFormattedTextField();
        jPBotoesTransacao = new javax.swing.JPanel();
        jBAplicar = new javax.swing.JButton();
        jBResgate = new javax.swing.JButton();
        jPSaldoMes = new javax.swing.JPanel();
        jLDtSaldoMes = new javax.swing.JLabel();
        jFTFDtSaldoMes = new javax.swing.JFormattedTextField();
        jLSaldoMes = new javax.swing.JLabel();
        jFTFSaldoMes = new javax.swing.JFormattedTextField();
        jPBotoesSaldo = new javax.swing.JPanel();
        jBSalvar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jPGrid = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTPoupancaAplicacao = new javax.swing.JTable();

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

        jPPoupancaAplicacao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jCBConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBContaActionPerformed(evt);
            }
        });

        jCBPoupanca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBPoupancaActionPerformed(evt);
            }
        });

        jLSaldo.setText("Saldo:");

        javax.swing.GroupLayout jPPoupancaAplicacaoLayout = new javax.swing.GroupLayout(jPPoupancaAplicacao);
        jPPoupancaAplicacao.setLayout(jPPoupancaAplicacaoLayout);
        jPPoupancaAplicacaoLayout.setHorizontalGroup(
            jPPoupancaAplicacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPoupancaAplicacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCBConta, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCBPoupanca, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLSaldo)
                .addContainerGap(104, Short.MAX_VALUE))
        );
        jPPoupancaAplicacaoLayout.setVerticalGroup(
            jPPoupancaAplicacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPoupancaAplicacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPPoupancaAplicacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBPoupanca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLSaldo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPTransacaoCampos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLDtTransacao.setText("Data:");

        jFTFDtTransacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFTFDtTransacaoFocusGained(evt);
            }
        });

        jLValor.setText("Valor:");

        javax.swing.GroupLayout jPTransacaoCamposLayout = new javax.swing.GroupLayout(jPTransacaoCampos);
        jPTransacaoCampos.setLayout(jPTransacaoCamposLayout);
        jPTransacaoCamposLayout.setHorizontalGroup(
            jPTransacaoCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPTransacaoCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPTransacaoCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLDtTransacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPTransacaoCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jFTFDtTransacao, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFTFValorTransacao, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPTransacaoCamposLayout.setVerticalGroup(
            jPTransacaoCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPTransacaoCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPTransacaoCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLDtTransacao)
                    .addComponent(jFTFDtTransacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPTransacaoCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLValor)
                    .addComponent(jFTFValorTransacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPBotoesTransacao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBAplicar.setText("Aplicar");
        jBAplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAplicarActionPerformed(evt);
            }
        });

        jBResgate.setText("Resgatar");
        jBResgate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBResgateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPBotoesTransacaoLayout = new javax.swing.GroupLayout(jPBotoesTransacao);
        jPBotoesTransacao.setLayout(jPBotoesTransacaoLayout);
        jPBotoesTransacaoLayout.setHorizontalGroup(
            jPBotoesTransacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotoesTransacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBAplicar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBResgate)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPBotoesTransacaoLayout.setVerticalGroup(
            jPBotoesTransacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotoesTransacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBotoesTransacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAplicar)
                    .addComponent(jBResgate))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPSaldoMes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLDtSaldoMes.setText("Data Saldo Mês:");

        jLSaldoMes.setText("Saldo do Mês:");

        javax.swing.GroupLayout jPSaldoMesLayout = new javax.swing.GroupLayout(jPSaldoMes);
        jPSaldoMes.setLayout(jPSaldoMesLayout);
        jPSaldoMesLayout.setHorizontalGroup(
            jPSaldoMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPSaldoMesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLDtSaldoMes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFDtSaldoMes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLSaldoMes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFSaldoMes, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPSaldoMesLayout.setVerticalGroup(
            jPSaldoMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPSaldoMesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPSaldoMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLDtSaldoMes)
                    .addComponent(jFTFDtSaldoMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLSaldoMes)
                    .addComponent(jFTFSaldoMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPBotoesSaldo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        javax.swing.GroupLayout jPBotoesSaldoLayout = new javax.swing.GroupLayout(jPBotoesSaldo);
        jPBotoesSaldo.setLayout(jPBotoesSaldoLayout);
        jPBotoesSaldoLayout.setHorizontalGroup(
            jPBotoesSaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotoesSaldoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBExcluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPBotoesSaldoLayout.setVerticalGroup(
            jPBotoesSaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotoesSaldoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBotoesSaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalvar)
                    .addComponent(jBExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPGrid.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTPoupancaAplicacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTPoupancaAplicacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTPoupancaAplicacaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTPoupancaAplicacao);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPPoupancaAplicacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPTransacaoCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPBotoesTransacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPSaldoMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPBotoesSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPPoupancaAplicacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPTransacaoCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPBotoesTransacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPSaldoMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPBotoesSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * <p><strong>EN:</strong> Populates the accounts combo box with available accounts.</p>
     * <p><strong>IT:</strong> Popola la combo box dei conti con i conti disponibili.</p>
     * <p><strong>PT-BR:</strong> Preenche o combo de contas com as contas disponíveis.</p>
     */
    private void jcConta(){
        contau.jcConta(jCBConta);
    }
    
    /**
     * <p><strong>EN:</strong> Reloads the savings combo box for the selected account, clearing previous items first.</p>
     * <p><strong>IT:</strong> Ricarica la combo box della poupança per il conto selezionato, svuotando prima gli elementi precedenti.</p>
     * <p><strong>PT-BR:</strong> Recarrega o combo de poupança para a conta selecionada, limpando os itens anteriores.</p>
     */
    private void jcPoupanca(){
        jCBPoupanca.removeAllItems();
        poupancau.jcPoupanca(jCBPoupanca, conta.getCd_conta());
    }
    
    /**
     * <p><strong>EN:</strong> Applies currency formatters to the transaction and monthly balance fields.</p>
     * <p><strong>IT:</strong> Applica i formattatori monetari ai campi di transazione e saldo mensile.</p>
     * <p><strong>PT-BR:</strong> Aplica formatadores monetários aos campos de transação e saldo do mês.</p>
     */
    private void formataValor(){
        jFTFValorTransacao.setFormatterFactory(Utilidade.formataValorCampo(ui));
        jFTFSaldoMes.setFormatterFactory(Utilidade.formataValorCampo(ui));        
    }
    
    /**
     * <p><strong>EN:</strong> Applies date masks/formatters to transaction and monthly balance date fields.</p>
     * <p><strong>IT:</strong> Applica maschere/formattatori di data ai campi di data di transazione e saldo mensile.</p>
     * <p><strong>PT-BR:</strong> Aplica máscaras/formatadores de data nos campos de data da transação e do saldo do mês.</p>
     */
    private void formataData(){
        util.formataDataCampo(jFTFDtTransacao);
        util.formataDataCampo(jFTFDtSaldoMes);
    }
    
    /**
     * <p><strong>EN:</strong> Fills the table with either savings transactions (tpoup = 0) or savings balances (tpoup = 1) for the given account.</p>
     * <p><strong>IT:</strong> Compila la tabella con le transazioni di risparmio (tpoup = 0) o i saldi (tpoup = 1) per il conto indicato.</p>
     * <p><strong>PT-BR:</strong> Preenche a tabela com transações da poupança (tpoup = 0) ou saldos (tpoup = 1) da conta informada.</p>
     */
    private void tabelaPoupanca(int tpoup, int poupanca){
        if(tpoup == 0){
            pouptru.tabelaPoupancaTransacao(jTPoupancaAplicacao, poupanca);
        }
        if(tpoup == 1){
            poupancaapu.tabelaPoupancaAplicacao(jTPoupancaAplicacao, poupanca);
        }  
    }
    
    /**
     * <p><strong>EN:</strong> Disables all input fields and action buttons related to savings application and monthly balance.</p>
     * <p><strong>IT:</strong> Disabilita tutti i campi di input e i pulsanti d’azione relativi all’applicazione e al saldo mensile.</p>
     * <p><strong>PT-BR:</strong> Desativa todos os campos e botões de ação ligados à aplicação e ao saldo do mês.</p>
     */
    private void desativaCampos(){
        jFTFDtTransacao.setEnabled(false);
        jFTFValorTransacao.setEnabled(false);
        jBAplicar.setEnabled(false);
        jBResgate.setEnabled(false);
        jFTFDtSaldoMes.setEnabled(false);
        jFTFSaldoMes.setEnabled(false);
        jBSalvar.setEnabled(false);
        jBExcluir.setEnabled(false);      
    }
    
    /**
     * <p><strong>EN:</strong> Enables input fields and action buttons for savings transactions and monthly balance.</p>
     * <p><strong>IT:</strong> Abilita i campi di input e i pulsanti d’azione per le transazioni e il saldo mensile della poupança.</p>
     * <p><strong>PT-BR:</strong> Ativa os campos e botões para transações e saldo do mês da poupança.</p>
     */
    private void ativaCampos(){
        jFTFDtTransacao.setEnabled(true);       
        jFTFValorTransacao.setEnabled(true);
        jBAplicar.setEnabled(true);
        jBResgate.setEnabled(true);
        jFTFDtSaldoMes.setEnabled(true);
        jFTFSaldoMes.setEnabled(true);
        jBSalvar.setEnabled(true);
    }
    
    /**
     * <p><strong>EN:</strong> Validates the monthly balance fields (date and value). Shows messages and focuses invalid fields.</p>
     * <p><strong>IT:</strong> Convalida i campi del saldo mensile (data e valore). Mostra messaggi e imposta il focus sui campi non validi.</p>
     * <p><strong>PT-BR:</strong> Valida os campos do saldo do mês (data e valor). Exibe mensagens e foca os campos inválidos.</p>
     */
    private boolean validaCamposSaldoMes(){
        if(util.validaDataCampo(jFTFDtSaldoMes.getText()) == false){
            jFTFDtSaldoMes.requestFocus();
            return false;
        }
        if(jFTFSaldoMes.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Valor em branco.", "Poupança Aplicação", JOptionPane.INFORMATION_MESSAGE);
            jFTFSaldoMes.requestFocus();
            return false;
        }
        return true;
    } 
    
    /**
     * <p><strong>EN:</strong> Saves the monthly balance entry for the selected savings account and updates the account balance.</p>
     * <p><strong>IT:</strong> Salva il saldo mensile per la poupança selezionata e aggiorna il saldo del conto.</p>
     * <p><strong>PT-BR:</strong> Salva o registro de saldo do mês para a poupança selecionada e atualiza o saldo da conta.</p>
     */
    private void salvar(){
        poupancaap.setDt_saldo(util.recebeData(jFTFDtSaldoMes.getText()));
        poupancaap.setVl_saldo(Utilidade.converter(jFTFSaldoMes.getText()));
        poupancaap.setPoupanca(poupanca);
        poupancaap.setCd_usuario(JPLogin.codloginuser);
        poupancaapr.inserir(poupancaap);        
        poupancar.atualizaSaldo(poupanca);
    }
    
    /**
     * <p><strong>EN:</strong> Validates the savings transaction fields (date and value). Shows messages and focuses invalid fields.</p>
     * <p><strong>IT:</strong> Convalida i campi della transazione di risparmio (data e importo). Mostra messaggi e imposta il focus sui campi non validi.</p>
     * <p><strong>PT-BR:</strong> Valida os campos da transação da poupança (data e valor). Exibe mensagens e foca os campos inválidos.</p>
     */
    private boolean validaCamposTransacao(){
        if(util.validaDataCampo(jFTFDtTransacao.getText()) == false){
            jFTFDtTransacao.requestFocus();
            return false;
        }
        if(jFTFValorTransacao.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Valor em branco.", "Poupança Aplicação", JOptionPane.INFORMATION_MESSAGE);
            jFTFValorTransacao.requestFocus();
            return false;
        }
        return true;
    }

    /**
     * <p><strong>EN:</strong> Checks if the savings account has enough balance for a withdrawal transaction.</p>
     * <p><strong>IT:</strong> Verifica se la poupança ha saldo sufficiente per un’operazione di prelievo.</p>
     * <p><strong>PT-BR:</strong> Verifica se a poupança possui saldo suficiente para a transação de resgate.</p>
     */
    private boolean validaSaldo(){
        pouptr.setVl_transacao(Utilidade.converter(jFTFValorTransacao.getText()));
        if(poupanca.getVl_saldo().compareTo(pouptr.getVl_transacao()) < 0){
                JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
                return false;
        }
        return true;
    }
    
    /**
     * <p><strong>EN:</strong> Updates the on-screen label with the current savings account balance.</p>
     * <p><strong>IT:</strong> Aggiorna l’etichetta a schermo con il saldo corrente della poupança.</p>
     * <p><strong>PT-BR:</strong> Atualiza o rótulo na tela com o saldo atual da poupança.</p>
     */   
    private void atualizaSaldoCampo(){      
        jLSaldo.setText("Saldo: " + Utilidade.formatoValor.format(poupanca.getVl_saldo()));
    }
    
    /**
     * <p><strong>EN:</strong> Executes a savings transaction (apply or redeem), updates the account balance, and records the transaction.</p>
     * <p><strong>IT:</strong> Esegue una transazione sulla poupança (applicazione o riscatto), aggiorna il saldo e registra l’operazione.</p>
     * <p><strong>PT-BR:</strong> Executa a transação da poupança (aplicar ou resgatar), atualiza o saldo e grava a movimentação.</p>
     */
    private void executaTransacao(int num){
        pouptr.setDt_transacao(util.recebeData(jFTFDtTransacao.getText()));
        pouptr.setVl_transacao(Utilidade.converter(jFTFValorTransacao.getText()));
        poupanca.setVl_saldo(pouptru.atualizaSaldo(num, poupanca.getVl_saldo(), pouptr.getVl_transacao()));
        pouptr.setPoupanca(poupanca);
        pouptr.setCd_usuario(JPLogin.codloginuser);
        poupancar.atualizaSaldo(poupanca);
        pouptrr.inserir(pouptr);
    }
    
    /**
     * <p><strong>EN:</strong> Clears all transaction and monthly balance input fields.</p>
     * <p><strong>IT:</strong> Pulisce tutti i campi di input della transazione e del saldo mensile.</p>
     * <p><strong>PT-BR:</strong> Limpa todos os campos de transação e de saldo do mês.</p>
     */
    private void limpaCampos(){
        jFTFDtTransacao.setText(null);
        jFTFValorTransacao.setValue(null);
        jFTFSaldoMes.setValue(null);
        jFTFDtSaldoMes.setText(null);
    }
             
    /**
     * <p><strong>EN:</strong> Deletes the selected monthly balance record for the savings account.</p>
     * <p><strong>IT:</strong> Elimina il record di saldo mensile selezionato della poupança.</p>
     * <p><strong>PT-BR:</strong> Exclui o registro de saldo do mês selecionado da poupança.</p>
     */
    private void excluir(){
        poupancaap.setCd_poupaplic(poupancaap.getCd_poupaplic());
        poupancaap.setPoupanca(poupanca);
        poupancaap.setCd_usuario(JPLogin.codloginuser);
        poupancaapr.excluir(poupancaap);
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves and stores the latest monthly index value used to update savings balances.</p>
     * <p><strong>IT:</strong> Recupera e memorizza l’ultimo valore dell’indice mensile usato per aggiornare i saldi della poupança.</p>
     * <p><strong>PT-BR:</strong> Obtém e armazena o último valor do índice mensal utilizado para atualizar os saldos da poupança.</p>
     */
    private void indiceValor(){
        iv.setVl_mes(ivu.indiceValor(3));
    }
    
    /**
     * <p><strong>EN:</strong> Recalculates the savings balance applying the current index value.</p>
     * <p><strong>IT:</strong> Ricalcola il saldo della poupança applicando il valore corrente dell’indice.</p>
     * <p><strong>PT-BR:</strong> Recalcula o saldo da poupança aplicando o valor atual do índice.</p>
     */
    private void calcularSaldo(){
        indiceValor();
        poupanca.setVl_saldo(poupancaapu.atualizaSaldoIndice(poupanca.getVl_saldo(), iv.getVl_mes()));
    }
    
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifpoupaplic = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jCBContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBContaActionPerformed
        conta = (Conta) jCBConta.getSelectedItem();
        if(conta != null){
            jCBPoupanca.setEnabled(true);
            jcPoupanca();
        }
    }//GEN-LAST:event_jCBContaActionPerformed

    private void jCBPoupancaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBPoupancaActionPerformed
        poupanca = (Poupanca)jCBPoupanca.getSelectedItem();
        if(jCBPoupanca.getSelectedIndex() == 0 | poupanca == null){
            jLSaldo.setText("Saldo:");
        }else{
            atualizaSaldoCampo();
            ativaCampos();
            limpaCampos();
            tabelaPoupanca(1, poupanca.getCd_poupanca());
            calcularSaldo();
            jFTFSaldoMes.setText(Utilidade.formatoValor.format(poupanca.getVl_saldo()));
        }    
    }//GEN-LAST:event_jCBPoupancaActionPerformed

    private void jBAplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAplicarActionPerformed
        if(validaCamposTransacao()){
            gptrans.setCd_gptrans(3);
            pouptr.setGptrans(gptrans);
            executaTransacao(0);
            atualizaSaldoCampo();
            limpaCampos();
            tabelaPoupanca(0, poupanca.getCd_poupanca());
        }
    }//GEN-LAST:event_jBAplicarActionPerformed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if(validaCamposSaldoMes()){
            salvar();
            atualizaSaldoCampo();
            limpaCampos();
            tabelaPoupanca(1, poupanca.getCd_poupanca());
            JOptionPane.showMessageDialog(null, "Salvo.");
        }
        
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jTPoupancaAplicacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTPoupancaAplicacaoMouseClicked
        jBExcluir.setEnabled(true);
        if(poupancaap != null){ 
            poupancaap = (PoupancaAplicacao)poupancaapu.getSelectObject(jTPoupancaAplicacao);
            jFTFDtSaldoMes.setText(Utilidade.formatoData.format(poupancaap.getDt_saldo().getTime()));
            jFTFSaldoMes.setText(Utilidade.formatoValor.format(poupancaap.getVl_saldo()));
        }
    }//GEN-LAST:event_jTPoupancaAplicacaoMouseClicked

    private void jBResgateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBResgateActionPerformed
        if(validaCamposTransacao()){
            if(validaSaldo()){
                gptrans.setCd_gptrans(4);
                pouptr.setGptrans(gptrans);
                executaTransacao(1);
                atualizaSaldoCampo();
                limpaCampos();
                tabelaPoupanca(0, poupanca.getCd_poupanca());
                JOptionPane.showMessageDialog(null, "Transação efetuada.");
            }
        }   
    }//GEN-LAST:event_jBResgateActionPerformed

    private void jFTFDtTransacaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTFDtTransacaoFocusGained
        Calendar instancia = Calendar.getInstance();
        jFTFDtTransacao.setText(Utilidade.formatoData.format(instancia.getTime()));
    }//GEN-LAST:event_jFTFDtTransacaoFocusGained

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        poupancaap = (PoupancaAplicacao)poupancaapu.getSelectObject(jTPoupancaAplicacao);        
        if(poupancaap != null){
            excluir();
            limpaCampos();      
            atualizaSaldoCampo();
            tabelaPoupanca(1, poupanca.getCd_poupanca());  
        }
    }//GEN-LAST:event_jBExcluirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAplicar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBResgate;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<Conta> jCBConta;
    private javax.swing.JComboBox<Poupanca> jCBPoupanca;
    private javax.swing.JFormattedTextField jFTFDtSaldoMes;
    private javax.swing.JFormattedTextField jFTFDtTransacao;
    private javax.swing.JFormattedTextField jFTFSaldoMes;
    private javax.swing.JFormattedTextField jFTFValorTransacao;
    private javax.swing.JLabel jLDtSaldoMes;
    private javax.swing.JLabel jLDtTransacao;
    private javax.swing.JLabel jLSaldo;
    private javax.swing.JLabel jLSaldoMes;
    private javax.swing.JLabel jLValor;
    private javax.swing.JPanel jPBotoesSaldo;
    private javax.swing.JPanel jPBotoesTransacao;
    private javax.swing.JPanel jPGrid;
    private javax.swing.JPanel jPPoupancaAplicacao;
    private javax.swing.JPanel jPSaldoMes;
    private javax.swing.JPanel jPTransacaoCampos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTPoupancaAplicacao;
    // End of variables declaration//GEN-END:variables
}
