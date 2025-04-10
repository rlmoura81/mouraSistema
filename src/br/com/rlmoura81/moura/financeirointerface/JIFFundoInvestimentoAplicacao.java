package br.com.rlmoura81.moura.financeirointerface;

import br.com.rlmoura81.moura.financeiro.Conta;
import br.com.rlmoura81.moura.financeiro.ContaRepository;
import br.com.rlmoura81.moura.financeiro.ContaUtil;
import br.com.rlmoura81.moura.financeiro.FundoInvestimento;
import br.com.rlmoura81.moura.financeiro.FundoInvestimentoAplicacao;
import br.com.rlmoura81.moura.financeiro.FundoInvestimentoAplicacaoRepository;
import br.com.rlmoura81.moura.financeiro.FundoInvestimentoAplicacaoUtil;
import br.com.rlmoura81.moura.financeiro.FundoInvestimentoRendimento;
import br.com.rlmoura81.moura.financeiro.FundoInvestimentoRendimentoRepository;
import br.com.rlmoura81.moura.financeiro.FundoInvestimentoRendimentoUtil;
import br.com.rlmoura81.moura.financeiro.FundoInvestimentoRepository;
import br.com.rlmoura81.moura.financeiro.FundoInvestimentoTransacao;
import br.com.rlmoura81.moura.financeiro.FundoInvestimentoTransacaoRepository;
import br.com.rlmoura81.moura.financeiro.FundoInvestimentoTransacaoUtil;
import br.com.rlmoura81.moura.financeiro.FundoInvestimentoUtil;
import br.com.rlmoura81.moura.financeiro.GrupoTransacao;
import br.com.rlmoura81.moura.financeiro.GrupoTransacaoRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.CalculoFinanceiro;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import javax.swing.JOptionPane;

public class JIFFundoInvestimentoAplicacao extends javax.swing.JInternalFrame {
    
    private static JIFFundoInvestimentoAplicacao jiffdinvestaplic;
    
    public static JIFFundoInvestimentoAplicacao getInstancia(){
        if(jiffdinvestaplic == null){
            jiffdinvestaplic = new JIFFundoInvestimentoAplicacao();
            jiffdinvestaplic.setTitle("Aplicação de Fundos de Investimentos.");
        }
        return jiffdinvestaplic;
    }
    
    Conta conta = new Conta();
    ContaRepository contar = new ContaRepository();
    ContaUtil contau = new ContaUtil();
    
    FundoInvestimento fdinvest = new FundoInvestimento();
    FundoInvestimentoRepository fdinvestr = new FundoInvestimentoRepository();
    FundoInvestimentoUtil fdinvestu = new FundoInvestimentoUtil();
    
    FundoInvestimentoAplicacao fia = new FundoInvestimentoAplicacao();
    FundoInvestimentoAplicacaoRepository fiar = new FundoInvestimentoAplicacaoRepository();
    FundoInvestimentoAplicacaoUtil fiau =  new FundoInvestimentoAplicacaoUtil();
    
    FundoInvestimentoTransacao fit = new FundoInvestimentoTransacao();
    FundoInvestimentoTransacaoRepository fitr = new FundoInvestimentoTransacaoRepository();
    FundoInvestimentoTransacaoUtil fitu = new FundoInvestimentoTransacaoUtil();
    
    FundoInvestimentoRendimento fir = new FundoInvestimentoRendimento();
    FundoInvestimentoRendimentoRepository firr = new FundoInvestimentoRendimentoRepository();
    FundoInvestimentoRendimentoUtil firu = new FundoInvestimentoRendimentoUtil();
    
    GrupoTransacao gptrans = new GrupoTransacao();
    GrupoTransacaoRepository gptransr = new GrupoTransacaoRepository();
    
    Utilidade util = new Utilidade();
    CalculoFinanceiro cf = new CalculoFinanceiro();

    public JIFFundoInvestimentoAplicacao() {
        initComponents();
        
        jcConta();
        formataCampos();
        desativaCampos();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPPrincipal = new javax.swing.JPanel();
        jCBConta = new javax.swing.JComboBox<>();
        jCBFundoInvestimento = new javax.swing.JComboBox<>();
        jPCamposTransacao = new javax.swing.JPanel();
        jLDtTransacao = new javax.swing.JLabel();
        jFTFDtTransacao = new javax.swing.JFormattedTextField();
        jLVlTransacao = new javax.swing.JLabel();
        jFTFVlTransacao = new javax.swing.JFormattedTextField();
        jBAplicar = new javax.swing.JButton();
        jBResgate = new javax.swing.JButton();
        jPCamposRentabilidade = new javax.swing.JPanel();
        jLRentabilidade = new javax.swing.JLabel();
        jFTFRentabilidade = new javax.swing.JFormattedTextField();
        jLData = new javax.swing.JLabel();
        jBSalvar = new javax.swing.JButton();
        jBAlterar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jFTFDtRentabilidade = new javax.swing.JFormattedTextField();
        jChBRendimento = new javax.swing.JCheckBox();
        jPGridFdInvestAplic = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTFdInvestAplic = new javax.swing.JTable();
        jPGridFdInvestTrans = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTFdInvestTrans = new javax.swing.JTable();

        setClosable(true);
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

        jCBConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBContaActionPerformed(evt);
            }
        });

        jCBFundoInvestimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBFundoInvestimentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPPrincipalLayout = new javax.swing.GroupLayout(jPPrincipal);
        jPPrincipal.setLayout(jPPrincipalLayout);
        jPPrincipalLayout.setHorizontalGroup(
            jPPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCBConta, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCBFundoInvestimento, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPPrincipalLayout.setVerticalGroup(
            jPPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBFundoInvestimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLDtTransacao.setText("Data:");

        jLVlTransacao.setText("Valor:");

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

        javax.swing.GroupLayout jPCamposTransacaoLayout = new javax.swing.GroupLayout(jPCamposTransacao);
        jPCamposTransacao.setLayout(jPCamposTransacaoLayout);
        jPCamposTransacaoLayout.setHorizontalGroup(
            jPCamposTransacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposTransacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposTransacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPCamposTransacaoLayout.createSequentialGroup()
                        .addComponent(jLDtTransacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFTFDtTransacao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLVlTransacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFTFVlTransacao, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPCamposTransacaoLayout.createSequentialGroup()
                        .addComponent(jBAplicar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBResgate)))
                .addContainerGap(661, Short.MAX_VALUE))
        );
        jPCamposTransacaoLayout.setVerticalGroup(
            jPCamposTransacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposTransacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposTransacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLDtTransacao)
                    .addComponent(jFTFDtTransacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLVlTransacao)
                    .addComponent(jFTFVlTransacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPCamposTransacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAplicar)
                    .addComponent(jBResgate))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLRentabilidade.setText("Rentabilidade:");

        jFTFRentabilidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFTFRentabilidadeFocusLost(evt);
            }
        });

        jLData.setText("Data:");

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

        jChBRendimento.setText("Rendimentos");
        jChBRendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChBRendimentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPCamposRentabilidadeLayout = new javax.swing.GroupLayout(jPCamposRentabilidade);
        jPCamposRentabilidade.setLayout(jPCamposRentabilidadeLayout);
        jPCamposRentabilidadeLayout.setHorizontalGroup(
            jPCamposRentabilidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposRentabilidadeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposRentabilidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPCamposRentabilidadeLayout.createSequentialGroup()
                        .addComponent(jBSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBExcluir)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPCamposRentabilidadeLayout.createSequentialGroup()
                        .addComponent(jLRentabilidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFTFRentabilidade, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFTFDtRentabilidade, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jChBRendimento)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPCamposRentabilidadeLayout.setVerticalGroup(
            jPCamposRentabilidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposRentabilidadeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposRentabilidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLRentabilidade)
                    .addComponent(jFTFRentabilidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLData)
                    .addComponent(jFTFDtRentabilidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChBRendimento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPCamposRentabilidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalvar)
                    .addComponent(jBAlterar)
                    .addComponent(jBExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTFdInvestAplic.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTFdInvestAplic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTFdInvestAplicMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTFdInvestAplic);

        javax.swing.GroupLayout jPGridFdInvestAplicLayout = new javax.swing.GroupLayout(jPGridFdInvestAplic);
        jPGridFdInvestAplic.setLayout(jPGridFdInvestAplicLayout);
        jPGridFdInvestAplicLayout.setHorizontalGroup(
            jPGridFdInvestAplicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridFdInvestAplicLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPGridFdInvestAplicLayout.setVerticalGroup(
            jPGridFdInvestAplicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridFdInvestAplicLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))
        );

        jTFdInvestTrans.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTFdInvestTrans);

        javax.swing.GroupLayout jPGridFdInvestTransLayout = new javax.swing.GroupLayout(jPGridFdInvestTrans);
        jPGridFdInvestTrans.setLayout(jPGridFdInvestTransLayout);
        jPGridFdInvestTransLayout.setHorizontalGroup(
            jPGridFdInvestTransLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridFdInvestTransLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPGridFdInvestTransLayout.setVerticalGroup(
            jPGridFdInvestTransLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridFdInvestTransLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPPrincipal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPCamposTransacao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPCamposRentabilidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPGridFdInvestAplic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPGridFdInvestTrans, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPCamposTransacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPCamposRentabilidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPGridFdInvestAplic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPGridFdInvestTrans, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jcConta(){
        contau.jcConta(jCBConta);
    }
    
    private void jcFdInvest(int fundo){
        fdinvestu.jcFdInvest(jCBFundoInvestimento, fundo);
    }
    
    private void jcFdInvestFiltro(){
        jCBFundoInvestimento.removeAllItems();
        fdinvestu.jcFdInvestFiltro(jCBFundoInvestimento, conta.getCd_conta());
    }
    
    private void tabelaFundoInvestimentoAplic(int num){
        fiau.tabelaFundoInvestimentoAplicacao(jTFdInvestAplic, num);
    }
    
    private void tabelaFundoInvestimentoTrans(int fdinvestaplic, int conta){
        fitu.tabelaFundoInvestimentoTransacao(jTFdInvestTrans, fdinvestaplic, conta);
    }
    
    private void formataCampos(){
        util.formataDataCampo(jFTFDtTransacao);
        jFTFVlTransacao.setFormatterFactory(Utilidade.formataValorCampo(ui));
        jFTFRentabilidade.setFormatterFactory(Utilidade.formataValorCampoTres(ui));
        util.formataDataCampo(jFTFDtRentabilidade);
    }
    
    private void desativaCampos(){
        jCBFundoInvestimento.setEnabled(false);
        jFTFDtTransacao.setEnabled(false);
        jFTFVlTransacao.setEnabled(false);
        jBAplicar.setEnabled(false);
        jBResgate.setEnabled(false);
        
        jFTFRentabilidade.setEnabled(false);
        jFTFDtRentabilidade.setEnabled(false);
        jChBRendimento.setEnabled(false);
        jBSalvar.setEnabled(false);
        jBAlterar.setEnabled(false);
        jBExcluir.setEnabled(false);
    }
    
    private void ativaCampos(){
        jCBFundoInvestimento.setEnabled(true);
        jFTFDtTransacao.setEnabled(true);
        jFTFVlTransacao.setEnabled(true);
        jBAplicar.setEnabled(true);
        
        jFTFRentabilidade.setEnabled(true);
        jFTFDtRentabilidade.setEnabled(true);
        jChBRendimento.setEnabled(true);
        jBSalvar.setEnabled(true);

    }
    
    private boolean validaCamposTransacao(){
        if(((FundoInvestimento)jCBFundoInvestimento.getSelectedItem()).getCd_fdinvest() == 0){
            JOptionPane.showMessageDialog(null, "Selecione o fundo de investimento.");
            jCBFundoInvestimento.requestFocus();
            return false;
        }
        if(util.validaDataCampo(jFTFDtTransacao.getText()) == false){
            jFTFDtTransacao.requestFocus();
            return false;
        }
        if(jFTFVlTransacao.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Informe o valor.");
            jFTFVlTransacao.requestFocus();
            return false;
        }
        return true;
    }
    
    private boolean validaCamposRendimento(){
        if(fia.getFdinvest() == null){
            JOptionPane.showMessageDialog(null, "Selecione um fundo de investimento da lista.");
            jTFdInvestAplic.requestFocus();
            return false;
        }
        if(((FundoInvestimento)jCBFundoInvestimento.getSelectedItem()).getCd_fdinvest() == 0){
            JOptionPane.showMessageDialog(null, "Selecione o fundo de investimento.");
            jCBFundoInvestimento.requestFocus();
            return false;
        }        
        if(jFTFRentabilidade.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Informe o valor de rendimento.");
            jFTFRentabilidade.requestFocus();
            return false;
        }
        if(util.validaDataCampo(jFTFDtRentabilidade.getText()) == false){
            jFTFDtRentabilidade.requestFocus();
            return false;
        }
        return true;
    }
    
    private void limpaCampos(){
        jcFdInvestFiltro();
        jFTFDtTransacao.setText(null);
        jFTFVlTransacao.setValue(null);        
        jFTFRentabilidade.setValue(null);
        jFTFDtRentabilidade.setText(null);
        tabelaFundoInvestimentoTrans(0, 0);
        fia.setCd_fdinvestaplic(0);
    }
    
    private void executaTransacao(){
        if(fia.getCd_fdinvestaplic() == 0){            
            fia.setConta(conta);
            fia.setFdinvest(fdinvest);
            fia.setVl_saldo(Utilidade.converter(jFTFVlTransacao.getText()));
            fia.setCd_usuario(JPLogin.codloginuser);
            fiar.inserir(fia);
            fia = (FundoInvestimentoAplicacao)fiar.ultimoRegistro();
            fia.setCd_fdinvestaplic(fia.getCd_fdinvestaplic());
        }else{
            fit.setVl_transacao(Utilidade.converter(jFTFVlTransacao.getText()));
            fia.setVl_saldo(cf.atualizaSaldoAplicacao(gptrans.getCd_gptrans(), fia.getVl_saldo(), fit.getVl_transacao()));
            fiar.atualizaSaldo(fia);
        }
    }
    
    private boolean validaSaldo(){
        if(fia.getVl_saldo().compareTo(Utilidade.converter(jFTFVlTransacao.getText())) < 0){
            JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
            return false;
        }
        return true;
    }
    
    private void salvaTransacao(){
        fit.setDt_transacao(util.recebeData(jFTFDtTransacao.getText()));
        fit.setVl_transacao(Utilidade.converter(jFTFVlTransacao.getText()));
        fit.setGptrans(gptrans);
        fit.setFdinvestap(fia);
        fit.setConta(conta);
        fit.setCd_usuario(JPLogin.codloginuser);
        fitr.inserir(fit);
    }
    
    private void salvaRendimento(){
        fir.setDt_rendimento(util.recebeData(jFTFDtRentabilidade.getText()));
        fir.setFdinvap(fia);
        fir.setCd_usuario(JPLogin.codloginuser);
        firr.inserir(fir);
    }
    
    private void aplicaRendimento(){
        fia.setCd_fdinvestaplic(fia.getCd_fdinvestaplic());
        fia.setCd_usuario(JPLogin.codloginuser);
        fiar.atualizaSaldo(fia);        
    }
    
    private void jCBContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBContaActionPerformed
        conta = (Conta)jCBConta.getSelectedItem();
        if(conta.getCd_conta() != 0){
            tabelaFundoInvestimentoAplic(conta.getCd_conta());
            jcFdInvestFiltro();
            firu.tabelaFundoInvestimentoRendimento(jTFdInvestTrans, 0);
            limpaCampos();
        }
        ativaCampos();
    }//GEN-LAST:event_jCBContaActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jiffdinvestaplic = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jBAplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAplicarActionPerformed
        if(validaCamposTransacao()){
            gptrans.setCd_gptrans(3);
            fit.setGptrans(gptrans);
            executaTransacao();
            salvaTransacao();
            tabelaFundoInvestimentoAplic(conta.getCd_conta());
            tabelaFundoInvestimentoTrans(fia.getCd_fdinvestaplic(), conta.getCd_conta());
            limpaCampos();
            jBResgate.setEnabled(false);          
            JOptionPane.showMessageDialog(null, "Transação executada.");
        }
    }//GEN-LAST:event_jBAplicarActionPerformed

    private void jCBFundoInvestimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBFundoInvestimentoActionPerformed
        fdinvest = (FundoInvestimento)jCBFundoInvestimento.getSelectedItem();
    }//GEN-LAST:event_jCBFundoInvestimentoActionPerformed

    private void jTFdInvestAplicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFdInvestAplicMouseClicked
        fia = (FundoInvestimentoAplicacao)fiau.getSelectObject(jTFdInvestAplic);
        jBResgate.setEnabled(true);
        jCBFundoInvestimento.removeAllItems();
        jcFdInvest(fia.getFdinvest().getCd_fdinvest());
        jCBFundoInvestimento.setSelectedItem(fia.getFdinvest());
        tabelaFundoInvestimentoTrans(fia.getCd_fdinvestaplic(), fia.getConta().getCd_conta());
        if(jChBRendimento.isSelected() == true){
            firu.tabelaFundoInvestimentoRendimento(jTFdInvestTrans, fia.getFdinvest().getCd_fdinvest());
        }
    }//GEN-LAST:event_jTFdInvestAplicMouseClicked

    private void jBResgateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBResgateActionPerformed
        if(validaCamposTransacao()&& validaSaldo()){
            gptrans.setCd_gptrans(4);
            fit.setGptrans(gptrans);
            executaTransacao();
            salvaTransacao();
            tabelaFundoInvestimentoAplic(conta.getCd_conta());
            tabelaFundoInvestimentoTrans(fdinvest.getCd_fdinvest(), conta.getCd_conta());
            limpaCampos();
            jBResgate.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Transação executada.");
        }
    }//GEN-LAST:event_jBResgateActionPerformed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if(validaCamposRendimento()){
            salvaRendimento();
            aplicaRendimento();
            tabelaFundoInvestimentoAplic(conta.getCd_conta());
            firu.tabelaFundoInvestimentoRendimento(jTFdInvestTrans, fia.getFdinvest().getCd_fdinvest());
            jChBRendimento.setEnabled(true);
            limpaCampos();
            JOptionPane.showMessageDialog(null, "Salvo.");
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jFTFRentabilidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTFRentabilidadeFocusLost
        fir.setVl_rendimento(Utilidade.converter(jFTFRentabilidade.getText()));
        if(fir.getVl_rendimento() != null){
            fia.setVl_saldo(cf.aplicaRendimento(fia.getVl_saldo(), fir.getVl_rendimento()));
        }
    }//GEN-LAST:event_jFTFRentabilidadeFocusLost

    private void jChBRendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChBRendimentoActionPerformed
        if(fia.getFdinvest() != null){
            firu.tabelaFundoInvestimentoRendimento(jTFdInvestTrans, fia.getFdinvest().getCd_fdinvest());
        }
        if(jChBRendimento.isSelected() == false){
            tabelaFundoInvestimentoTrans(fia.getCd_fdinvestaplic(), fia.getConta().getCd_conta());
        }
    }//GEN-LAST:event_jChBRendimentoActionPerformed

    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
    }//GEN-LAST:event_jBAlterarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
    }//GEN-LAST:event_jBExcluirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBAplicar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBResgate;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<Conta> jCBConta;
    private javax.swing.JComboBox<FundoInvestimento> jCBFundoInvestimento;
    private javax.swing.JCheckBox jChBRendimento;
    private javax.swing.JFormattedTextField jFTFDtRentabilidade;
    private javax.swing.JFormattedTextField jFTFDtTransacao;
    private javax.swing.JFormattedTextField jFTFRentabilidade;
    private javax.swing.JFormattedTextField jFTFVlTransacao;
    private javax.swing.JLabel jLData;
    private javax.swing.JLabel jLDtTransacao;
    private javax.swing.JLabel jLRentabilidade;
    private javax.swing.JLabel jLVlTransacao;
    private javax.swing.JPanel jPCamposRentabilidade;
    private javax.swing.JPanel jPCamposTransacao;
    private javax.swing.JPanel jPGridFdInvestAplic;
    private javax.swing.JPanel jPGridFdInvestTrans;
    private javax.swing.JPanel jPPrincipal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTFdInvestAplic;
    private javax.swing.JTable jTFdInvestTrans;
    // End of variables declaration//GEN-END:variables
}
