package br.com.rlmoura81.moura.financeirointerface;

import br.com.rlmoura81.moura.financeiro.Ativo;
import br.com.rlmoura81.moura.financeiro.AtivoSaldo;
import br.com.rlmoura81.moura.financeiro.AtivoSaldoRepository;
import br.com.rlmoura81.moura.financeiro.AtivoSaldoUtil;
import br.com.rlmoura81.moura.financeiro.AtivoUtil;
import br.com.rlmoura81.moura.financeiro.Conta;
import br.com.rlmoura81.moura.financeiro.ContaUtil;
import br.com.rlmoura81.moura.financeiro.GrupoTransacao;
import br.com.rlmoura81.moura.financeiro.GrupoTransacaoUtil;
import br.com.rlmoura81.moura.financeiro.NotaCorretagem;
import br.com.rlmoura81.moura.financeiro.NotaCorretagemLancamento;
import br.com.rlmoura81.moura.financeiro.NotaCorretagemLancamentoRepository;
import br.com.rlmoura81.moura.financeiro.NotaCorretagemLancamentoUtil;
import br.com.rlmoura81.moura.financeiro.NotaCorretagemRepository;
import br.com.rlmoura81.moura.financeiro.NotaCorretagemUtil;
import br.com.rlmoura81.moura.financeiro.TipoAtivo;
import br.com.rlmoura81.moura.financeiro.TipoAtivoUtil;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JIFNotaCorretagem extends javax.swing.JInternalFrame {
    
    private static JIFNotaCorretagem jifnotacorretagem;
    
    public static JIFNotaCorretagem getInstancia(){
        if(jifnotacorretagem == null){
            jifnotacorretagem = new JIFNotaCorretagem();
            jifnotacorretagem.setTitle("Nota de Corretagem.");
        }return jifnotacorretagem;
    }
    
    NotaCorretagem nota = new NotaCorretagem();
    NotaCorretagemRepository notar = new NotaCorretagemRepository();
    NotaCorretagemUtil notau = new NotaCorretagemUtil();
    
    NotaCorretagemLancamento notalanc = null;
    NotaCorretagemLancamentoRepository notalancr = new NotaCorretagemLancamentoRepository();
    NotaCorretagemLancamentoUtil notalancu = new NotaCorretagemLancamentoUtil();
    
    Conta conta = null;
    ContaUtil contau = new ContaUtil();
    
    TipoAtivo tpativo = null;
    TipoAtivoUtil tpativou = new TipoAtivoUtil();
    
    Ativo ativo = new Ativo();
    AtivoUtil ativou = new AtivoUtil();
    
    GrupoTransacao gptrans = null;
    GrupoTransacaoUtil gptransu = new GrupoTransacaoUtil();

    AtivoSaldo asaldo = new AtivoSaldo();
    AtivoSaldoRepository asaldor = new AtivoSaldoRepository();
    AtivoSaldoUtil asaldou = new AtivoSaldoUtil();
    
    Utilidade util = new Utilidade();

    public JIFNotaCorretagem() {
        initComponents();
        
        formataData();
        formataValor(); 
        jcConta();
        camposNotaCorretagem();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPGridNotaLancamento = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTNotaLancamento = new javax.swing.JTable();
        jPBotoesNota = new javax.swing.JPanel();
        jBFinalizar = new javax.swing.JButton();
        jBNovo = new javax.swing.JButton();
        jPrincipal = new javax.swing.JPanel();
        jCBAtivo = new javax.swing.JComboBox<>();
        jLQtde = new javax.swing.JLabel();
        jLPreco = new javax.swing.JLabel();
        jFTFPreco = new javax.swing.JFormattedTextField();
        jBSalvar = new javax.swing.JButton();
        jCBTpAtivo = new javax.swing.JComboBox<>();
        jTFQtde = new javax.swing.JTextField();
        jCBGpTransacao = new javax.swing.JComboBox<>();
        jPConta = new javax.swing.JPanel();
        jCBConta = new javax.swing.JComboBox<>();
        jPNotaCorretagem = new javax.swing.JPanel();
        jLData = new javax.swing.JLabel();
        jFTFData = new javax.swing.JFormattedTextField();
        jLNumNota = new javax.swing.JLabel();
        jTFNumNota = new javax.swing.JTextField();
        jPGridNota = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTNota = new javax.swing.JTable();

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

        jPGridNotaLancamento.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTNotaLancamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTNotaLancamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTNotaLancamentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTNotaLancamento);

        javax.swing.GroupLayout jPGridNotaLancamentoLayout = new javax.swing.GroupLayout(jPGridNotaLancamento);
        jPGridNotaLancamento.setLayout(jPGridNotaLancamentoLayout);
        jPGridNotaLancamentoLayout.setHorizontalGroup(
            jPGridNotaLancamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridNotaLancamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPGridNotaLancamentoLayout.setVerticalGroup(
            jPGridNotaLancamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridNotaLancamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPBotoesNota.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBFinalizar.setText("Finalizar");
        jBFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFinalizarActionPerformed(evt);
            }
        });

        jBNovo.setText("Novo");
        jBNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPBotoesNotaLayout = new javax.swing.GroupLayout(jPBotoesNota);
        jPBotoesNota.setLayout(jPBotoesNotaLayout);
        jPBotoesNotaLayout.setHorizontalGroup(
            jPBotoesNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotoesNotaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBFinalizar)
                .addGap(18, 18, 18)
                .addComponent(jBNovo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPBotoesNotaLayout.setVerticalGroup(
            jPBotoesNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotoesNotaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBotoesNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBFinalizar)
                    .addComponent(jBNovo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPrincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jCBAtivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBAtivoActionPerformed(evt);
            }
        });

        jLQtde.setText("Quantidade:");

        jLPreco.setText("Preço:");

        jBSalvar.setText("Salvar");
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });

        jCBTpAtivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBTpAtivoActionPerformed(evt);
            }
        });

        jCBGpTransacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBGpTransacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPrincipalLayout = new javax.swing.GroupLayout(jPrincipal);
        jPrincipal.setLayout(jPrincipalLayout);
        jPrincipalLayout.setHorizontalGroup(
            jPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPrincipalLayout.createSequentialGroup()
                        .addComponent(jLQtde)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFQtde))
                    .addComponent(jCBTpAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPrincipalLayout.createSequentialGroup()
                        .addComponent(jLPreco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFTFPreco))
                    .addComponent(jCBAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBSalvar)
                    .addComponent(jCBGpTransacao, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 6, Short.MAX_VALUE))
        );
        jPrincipalLayout.setVerticalGroup(
            jPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBTpAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBGpTransacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLQtde)
                    .addComponent(jTFQtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLPreco)
                    .addComponent(jFTFPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBSalvar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPConta.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jCBConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBContaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPContaLayout = new javax.swing.GroupLayout(jPConta);
        jPConta.setLayout(jPContaLayout);
        jPContaLayout.setHorizontalGroup(
            jPContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPContaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCBConta, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPContaLayout.setVerticalGroup(
            jPContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPContaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCBConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPNotaCorretagem.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLData.setText("Data:");

        jFTFData.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFTFDataFocusLost(evt);
            }
        });

        jLNumNota.setText("Nº Nota:");

        jTFNumNota.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFNumNotaFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPNotaCorretagemLayout = new javax.swing.GroupLayout(jPNotaCorretagem);
        jPNotaCorretagem.setLayout(jPNotaCorretagemLayout);
        jPNotaCorretagemLayout.setHorizontalGroup(
            jPNotaCorretagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPNotaCorretagemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFData, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLNumNota)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFNumNota, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPNotaCorretagemLayout.setVerticalGroup(
            jPNotaCorretagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPNotaCorretagemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPNotaCorretagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLData)
                    .addComponent(jFTFData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLNumNota)
                    .addComponent(jTFNumNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPGridNota.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTNota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTNota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTNotaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTNota);

        javax.swing.GroupLayout jPGridNotaLayout = new javax.swing.GroupLayout(jPGridNota);
        jPGridNota.setLayout(jPGridNotaLayout);
        jPGridNotaLayout.setHorizontalGroup(
            jPGridNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridNotaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPGridNotaLayout.setVerticalGroup(
            jPGridNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridNotaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPGridNota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPConta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPNotaCorretagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPGridNotaLancamento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPBotoesNota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPNotaCorretagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPGridNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPBotoesNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPGridNotaLancamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void camposNotaCorretagem(){
        if(jCBConta.getSelectedIndex() == 0 && conta == null){
            jFTFData.setEnabled(false);
            jTFNumNota.setEnabled(false);
            ((DefaultTableModel)jTNota.getModel()).setRowCount(0);
        }else{
            jFTFData.setEnabled(true);
            jTFNumNota.setEnabled(true);       
        }
        camposNotaLancamento();
    }
    
    private void camposNotaLancamento(){
        if(conta != null && !jFTFData.getText().equals("  /  /    ") && !jTFNumNota.getText().isEmpty()){
            jcTipoAtivo();
            jCBTpAtivo.setEnabled(true);
            jCBAtivo.setEnabled(true);
            jCBGpTransacao.setEnabled(true);
            jTFQtde.setEnabled(true);
            jFTFPreco.setEnabled(true);
            jBSalvar.setEnabled(true);
            limpaNotaLancCampos();
        }else{
            jCBTpAtivo.removeAllItems();
            jCBTpAtivo.setEnabled(false);
            jCBAtivo.removeAllItems();
            jCBAtivo.setEnabled(false);
            jCBGpTransacao.removeAllItems();
            jCBGpTransacao.setEnabled(false);
            jTFQtde.setText(null);
            jTFQtde.setEnabled(false);
            jFTFPreco.setValue(null);
            jFTFPreco.setEnabled(false);
            jBSalvar.setEnabled(false);
            ((DefaultTableModel)jTNotaLancamento.getModel()).setRowCount(0);
        }
        btFinalizar();
        btNovo();
    }
    
    private void btFinalizar(){
        if(nota != null && notalanc != null){
            jBFinalizar.setEnabled(true);
        }else{
            jBFinalizar.setEnabled(false);
        }
    }
    
    private void btNovo(){
        if(nota != null && jTNotaLancamento.getModel().getRowCount() != 0){
            jBNovo.setEnabled(true);
            jFTFData.setEnabled(false);
            jTFNumNota.setEnabled(false);
        }else{
            jBNovo.setEnabled(false);
            jFTFData.setEnabled(true);
            jTFNumNota.setEnabled(true);
        }
    }
        
    private void jcConta(){
        contau.jcConta(jCBConta);         
    }
    
    private void jcTipoAtivo(){
        jCBTpAtivo.removeAllItems();
        tpativou.jcTipoAtivoAcaoFii(jCBTpAtivo);
    }
    
    private void jcGpTrans(){
        jCBGpTransacao.removeAllItems();
        gptransu.jcGpTransCompraVenda(jCBGpTransacao);
    }
    
    private void jcAtivo(){
        jCBAtivo.removeAllItems();
        if(tpativo != null && jCBTpAtivo.getSelectedIndex() != 0){
            if(tpativo.getCd_tpativo() == 1){
                ativou.jcAcao(jCBAtivo);
            }    
            if(tpativo.getCd_tpativo() == 2){
                ativou.jcFundoImobiiario(jCBAtivo);
            }   
        }
    }    
    
    private void formataData(){
        util.formataDataCampo(jFTFData);      
    }   
    
    private void formataValor() {        
        jFTFPreco.setFormatterFactory(Utilidade.formataValorCampo(ui));
    }
    
    private void tabelaNotaCorretagemLancamento(){
        notalancu.tabelaNotaCorretagemLancamento(jTNotaLancamento, nota.getCd_nota());
    }

    private boolean validaCampos(){
        if(tpativo == null){
            JOptionPane.showMessageDialog(null, "Selecione o tipo do ativo.", "Tipo Ativo", JOptionPane.INFORMATION_MESSAGE);
            jCBTpAtivo.requestFocus();
            return false;
        }
        if(ativo == null){
            JOptionPane.showMessageDialog(null, "Selecione o ativo.", "Ativo", JOptionPane.INFORMATION_MESSAGE);
            jCBAtivo.requestFocus();
            return false;
        }
        if(gptrans == null){
            JOptionPane.showMessageDialog(null, "Selecione a transação.", "Transação", JOptionPane.INFORMATION_MESSAGE);            
            jCBGpTransacao.requestFocus();
            return false;
        }
        if(jTFQtde.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Quantidade em branco.", "Nota Corretagem", JOptionPane.INFORMATION_MESSAGE);
            jTFQtde.requestFocus();
            return false;
        }
        if(jFTFPreco.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Valor em branco.", "Nota Corretagem", JOptionPane.INFORMATION_MESSAGE);
            jFTFPreco.requestFocus();
            return false;
        }
        return true;
    }
    
    private void notaLancCampos(){
        notalanc = new NotaCorretagemLancamento();
        notalanc.setNota(nota);        
        notalanc.setAtivo(ativo);
        notalanc.setGptrans(gptrans);        
        notalanc.setNm_qtde(Integer.parseInt(jTFQtde.getText()));
        notalanc.setNm_valor(Utilidade.converter(jFTFPreco.getText()));
        notalanc.setCd_usuario(nota.getCd_usuario());
        notalancr.inserir(notalanc);
    }
    
    private void limpaNotaLancCampos(){
        if(jCBTpAtivo.isEnabled() == true){
            jCBTpAtivo.setSelectedIndex(0);
        }
        jTFQtde.setText(null);
        jFTFPreco.setValue(null);
    }
    
    private void notaCampos(){
        nota.setConta(conta);
        nota.setDt_nota(util.recebeData(jFTFData.getText()));
        nota.setNm_nota(Integer.parseInt(jTFNumNota.getText()));
        nota.setCd_usuario(JPLogin.codloginuser);
        notar.inserir(nota);
    }
    
    private void limpaNotaCampos(){
        jFTFData.setText(null);
        jTFNumNota.setText(null);
        limpaNotaLancCampos();
        nota = null;
    }
    
    private void transacaoAtivo(){
        if(asaldo == null){
            asaldo = new AtivoSaldo();
            asaldo.setAtivo(ativo);
            asaldo.setNm_qtde(Integer.parseInt(jTFQtde.getText()));
            asaldo.setCd_usuario(JPLogin.codloginuser);
            asaldor.inserir(asaldo);
        }else{
            asaldo.setAtivo(ativo);
            asaldo.setNm_qtde(asaldou.atualizaSaldo(gptrans.getCd_gptrans(), asaldo.getNm_qtde(), notalanc.getNm_qtde()));
            asaldo.setCd_usuario(JPLogin.codloginuser);
            asaldor.alterar(asaldo);
        }
        asaldo = null;
    }
    
    private void jCBContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBContaActionPerformed
        if(jCBConta.getSelectedIndex() != 0){
            conta = (Conta)jCBConta.getSelectedItem();
            notau.tabelaNotaCorretagem(jTNota, conta.getCd_conta());
            ((DefaultTableModel)jTNotaLancamento.getModel()).setNumRows(0);
        }else{
            conta = null;
        }
        camposNotaCorretagem();
    }//GEN-LAST:event_jCBContaActionPerformed

    private void jCBTpAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBTpAtivoActionPerformed
        if(jCBTpAtivo.getSelectedIndex() != 0){
            tpativo = (TipoAtivo)jCBTpAtivo.getSelectedItem();
            jcAtivo();
        }else{
            tpativo = null;
            jCBAtivo.removeAllItems();
        }
    }//GEN-LAST:event_jCBTpAtivoActionPerformed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if(validaCampos()){
            if(nota.getCd_nota() == 0){
                notaCampos();
                nota = (NotaCorretagem)notar.getByCodNota();             
                notaLancCampos();
                transacaoAtivo();
                tabelaNotaCorretagemLancamento();
            }else{
                notaLancCampos();
                transacaoAtivo();
                tabelaNotaCorretagemLancamento();
            }
            limpaNotaLancCampos();
            btFinalizar();
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jBFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFinalizarActionPerformed
        tabelaNotaCorretagemLancamento();
        notau.tabelaNotaCorretagem(jTNota, conta.getCd_conta());
        ((DefaultTableModel)jTNotaLancamento.getModel()).setRowCount(0);
        limpaNotaCampos();
        limpaNotaLancCampos();
        camposNotaCorretagem();
        notalanc = null;
        btFinalizar();
        JOptionPane.showMessageDialog(null, "Nota de Corretagem lançada.");
    }//GEN-LAST:event_jBFinalizarActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifnotacorretagem = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jCBAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBAtivoActionPerformed
        if(jCBAtivo.getSelectedIndex() != 0){
            ativo = (Ativo)jCBAtivo.getSelectedItem();
            jcGpTrans();
        }else{
            ativo = null;
            jCBGpTransacao.removeAllItems();
        }
        if(jCBTpAtivo.getSelectedIndex() != 0 && ativo != null){
            asaldo = (AtivoSaldo)asaldor.getById(ativo.getCd_ativo());
        }else{
            asaldo = null;
        }
    }//GEN-LAST:event_jCBAtivoActionPerformed

    private void jCBGpTransacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBGpTransacaoActionPerformed
        if(jCBGpTransacao.getSelectedIndex() != 0){
            gptrans = (GrupoTransacao)jCBGpTransacao.getSelectedItem();
        }else{
            gptrans = null;
        }
    }//GEN-LAST:event_jCBGpTransacaoActionPerformed

    private void jTNotaLancamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTNotaLancamentoMouseClicked
        notalanc = (NotaCorretagemLancamento)notalancu.getSelectObject(jTNotaLancamento);
        jCBTpAtivo.getModel().setSelectedItem(notalanc.getAtivo().getTpativo());
        jCBGpTransacao.getModel().setSelectedItem(notalanc.getGptrans());
        jCBAtivo.getModel().setSelectedItem(notalanc.getAtivo());
        jTFQtde.setText(Utilidade.formatoValor.format(notalanc.getNm_qtde()));
        jFTFPreco.setText(Utilidade.formatoValor.format(notalanc.getNm_valor()));
    }//GEN-LAST:event_jTNotaLancamentoMouseClicked

    private void jTNotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTNotaMouseClicked
        nota = (NotaCorretagem)notau.getSelectObject(jTNota);
        jFTFData.setText(Utilidade.formatoData.format(nota.getDt_nota().getTime()));
        jTFNumNota.setText(String.valueOf(nota.getNm_nota()));
        notalancu.tabelaNotaCorretagemLancamento(jTNotaLancamento, nota.getCd_nota());
        btNovo();
    }//GEN-LAST:event_jTNotaMouseClicked

    private void jBNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNovoActionPerformed
        limpaNotaCampos();
        jCBConta.setSelectedIndex(0);
    }//GEN-LAST:event_jBNovoActionPerformed

    private void jFTFDataFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTFDataFocusLost
        camposNotaCorretagem();
    }//GEN-LAST:event_jFTFDataFocusLost

    private void jTFNumNotaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFNumNotaFocusLost
        camposNotaCorretagem();
    }//GEN-LAST:event_jTFNumNotaFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBFinalizar;
    private javax.swing.JButton jBNovo;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<Ativo> jCBAtivo;
    private javax.swing.JComboBox<Conta> jCBConta;
    private javax.swing.JComboBox<GrupoTransacao> jCBGpTransacao;
    private javax.swing.JComboBox<TipoAtivo> jCBTpAtivo;
    private javax.swing.JFormattedTextField jFTFData;
    private javax.swing.JFormattedTextField jFTFPreco;
    private javax.swing.JLabel jLData;
    private javax.swing.JLabel jLNumNota;
    private javax.swing.JLabel jLPreco;
    private javax.swing.JLabel jLQtde;
    private javax.swing.JPanel jPBotoesNota;
    private javax.swing.JPanel jPConta;
    private javax.swing.JPanel jPGridNota;
    private javax.swing.JPanel jPGridNotaLancamento;
    private javax.swing.JPanel jPNotaCorretagem;
    private javax.swing.JPanel jPrincipal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTFNumNota;
    private javax.swing.JTextField jTFQtde;
    private javax.swing.JTable jTNota;
    private javax.swing.JTable jTNotaLancamento;
    // End of variables declaration//GEN-END:variables
}
