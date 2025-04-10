package br.com.rlmoura81.moura.financeirointerface;

import br.com.rlmoura81.moura.financeiro.AcaoProvento;
import br.com.rlmoura81.moura.financeiro.AcaoProventoRepository;
import br.com.rlmoura81.moura.financeiro.Aluguel;
import br.com.rlmoura81.moura.financeiro.AluguelUtil;
import br.com.rlmoura81.moura.financeiro.Ativo;
import br.com.rlmoura81.moura.financeiro.AtivoSaldo;
import br.com.rlmoura81.moura.financeiro.AtivoSaldoRepository;
import br.com.rlmoura81.moura.financeiro.AtivoUtil;
import br.com.rlmoura81.moura.financeiro.FundoImobiliarioProvento;
import br.com.rlmoura81.moura.financeiro.FundoImobiliarioProventoRepository;
import br.com.rlmoura81.moura.financeiro.Renda;
import br.com.rlmoura81.moura.financeiro.RendaRepository;
import br.com.rlmoura81.moura.financeiro.RendaUtil;
import br.com.rlmoura81.moura.financeiro.TipoAtivo;
import br.com.rlmoura81.moura.financeiro.TipoAtivoUtil;
import br.com.rlmoura81.moura.financeiro.TipoProvento;
import br.com.rlmoura81.moura.financeiro.TipoProventoUtil;
import br.com.rlmoura81.moura.financeiro.TipoRenda;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.CalculoFinanceiro;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.math.BigDecimal;
import javax.swing.JOptionPane;

public class JIFRenda extends javax.swing.JInternalFrame {
    
    private static JIFRenda jifcredito;
    
    public static JIFRenda getInstancia(){
        if(jifcredito == null){
            jifcredito = new JIFRenda();
            jifcredito.setTitle("Crédito");
        }
        return jifcredito;
    }
    
    private BigDecimal valor;
    
    Aluguel aluguel = null;
    AluguelUtil aluguelu = new AluguelUtil();
    
    TipoAtivo tpativo = new TipoAtivo();
    TipoAtivoUtil tpativou = new TipoAtivoUtil();
    
    Ativo ativo = new Ativo();
    AtivoUtil ativou = new AtivoUtil();
    
    AtivoSaldo asaldo = new AtivoSaldo();
    AtivoSaldoRepository asaldor = new AtivoSaldoRepository();
    
    TipoProvento tpprov = new TipoProvento();
    TipoProventoUtil tpprovu = new TipoProventoUtil();
    
    FundoImobiliarioProvento fdimprov = new FundoImobiliarioProvento();
    FundoImobiliarioProventoRepository fdimprovr = new FundoImobiliarioProventoRepository();
    
    AcaoProvento aprov = new AcaoProvento();
    AcaoProventoRepository aprovr = new AcaoProventoRepository();
    
    TipoRenda tprenda = new TipoRenda();
    
    Renda renda = new Renda();
    RendaRepository rendar = new RendaRepository();
    RendaUtil rendau = new RendaUtil();
        
    Utilidade util = new Utilidade();
    
    CalculoFinanceiro cf = new CalculoFinanceiro();
    
    public JIFRenda() {
        initComponents();
        
        formataValor();        
        jcAluguel();
        jcTpAtivo();
        formatarData();
        tabelaRenda();
        camposRenda();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPCampos = new javax.swing.JPanel();
        jLDescricao = new javax.swing.JLabel();
        jTFDescricao = new javax.swing.JTextField();
        jLValor = new javax.swing.JLabel();
        jFTFValor = new javax.swing.JFormattedTextField();
        jBConfirmar = new javax.swing.JButton();
        jLData = new javax.swing.JLabel();
        jFTFData = new javax.swing.JFormattedTextField();
        jPBotoes = new javax.swing.JPanel();
        jBExcluir = new javax.swing.JButton();
        jPGrid = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTRenda = new javax.swing.JTable();
        jTPRenda = new javax.swing.JTabbedPane();
        jPRenda = new javax.swing.JPanel();
        jPAluguel = new javax.swing.JPanel();
        jCBAluguel = new javax.swing.JComboBox<>();
        jLValorAluguel = new javax.swing.JLabel();
        jLDescontoAluguel = new javax.swing.JLabel();
        jFTFDescontoAluguel = new javax.swing.JFormattedTextField();
        jPAtivo = new javax.swing.JPanel();
        jCBTpAtivo = new javax.swing.JComboBox<>();
        jCBAtivo = new javax.swing.JComboBox<>();
        jCBTpProvento = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
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

        jPCampos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLDescricao.setText("Descrição:");

        jLValor.setText("Valor:");

        jBConfirmar.setText("Confirmar");
        jBConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConfirmarActionPerformed(evt);
            }
        });

        jLData.setText("Data:");

        javax.swing.GroupLayout jPCamposLayout = new javax.swing.GroupLayout(jPCampos);
        jPCampos.setLayout(jPCamposLayout);
        jPCamposLayout.setHorizontalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFData, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLValor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFValor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBConfirmar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPCamposLayout.setVerticalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLDescricao)
                    .addComponent(jTFDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLValor)
                    .addComponent(jFTFValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBConfirmar)
                    .addComponent(jLData)
                    .addComponent(jFTFData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
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

        jPGrid.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTRenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTRenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTRendaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTRenda);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTPRenda.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTPRenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTPRendaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPRendaLayout = new javax.swing.GroupLayout(jPRenda);
        jPRenda.setLayout(jPRendaLayout);
        jPRendaLayout.setHorizontalGroup(
            jPRendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1140, Short.MAX_VALUE)
        );
        jPRendaLayout.setVerticalGroup(
            jPRendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jTPRenda.addTab("Renda", jPRenda);

        jCBAluguel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBAluguelActionPerformed(evt);
            }
        });

        jLValorAluguel.setText("Valor:");

        jLDescontoAluguel.setText("Desconto:");

        jFTFDescontoAluguel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFTFDescontoAluguelFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPAluguelLayout = new javax.swing.GroupLayout(jPAluguel);
        jPAluguel.setLayout(jPAluguelLayout);
        jPAluguelLayout.setHorizontalGroup(
            jPAluguelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPAluguelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPAluguelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPAluguelLayout.createSequentialGroup()
                        .addComponent(jLDescontoAluguel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFTFDescontoAluguel))
                    .addComponent(jCBAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLValorAluguel)
                .addContainerGap(886, Short.MAX_VALUE))
        );
        jPAluguelLayout.setVerticalGroup(
            jPAluguelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPAluguelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPAluguelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLValorAluguel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPAluguelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLDescontoAluguel)
                    .addComponent(jFTFDescontoAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jTPRenda.addTab("Aluguel", jPAluguel);

        jCBTpAtivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBTpAtivoActionPerformed(evt);
            }
        });

        jCBAtivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBAtivoActionPerformed(evt);
            }
        });

        jCBTpProvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBTpProventoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPAtivoLayout = new javax.swing.GroupLayout(jPAtivo);
        jPAtivo.setLayout(jPAtivoLayout);
        jPAtivoLayout.setHorizontalGroup(
            jPAtivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPAtivoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCBTpAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCBTpProvento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCBAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(622, Short.MAX_VALUE))
        );
        jPAtivoLayout.setVerticalGroup(
            jPAtivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPAtivoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPAtivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBTpAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBTpProvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jTPRenda.addTab("Ativos", jPAtivo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPCampos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTPRenda, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPGrid, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTPRenda, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
            
    private void formatarData(){
        util.formataDataCampo(jFTFData);
    }
    
    private void formataValor(){
        jFTFDescontoAluguel.setFormatterFactory(Utilidade.formataValorCampo(ui));
        jFTFValor.setFormatterFactory(Utilidade.formataValorCampo(ui));
    }
    
    private void jcAluguel(){
        aluguelu.jcAluguel(jCBAluguel);
    }
    
    private void jcTpAtivo(){
        tpativou.jcTipoAtivoAcaoFii(jCBTpAtivo);
    }

    private void  jcTpProvento(){
        jCBTpProvento.removeAllItems();
        if(tpativo.getCd_tpativo() == 1){
            tpprovu.jcTpProventoAcao(jCBTpProvento);
        }
        if(tpativo.getCd_tpativo() == 2){
            tpprovu.jcTpProventoFII(jCBTpProvento);
        }
    }
    
    private void jcAtivo(){
        jCBAtivo.removeAllItems();
        if(tpativo != null && tpprov != null && tpativo.getCd_tpativo() == 1){
            ativou.jcAcaoSaldoTpProv(jCBAtivo, tpprov.getCd_tpprovento());
        }    
        if(tpativo != null && tpprov != null && tpativo.getCd_tpativo() == 2){
            ativou.jcFundoImobiiarioSaldoTpProv(jCBAtivo, tpprov.getCd_tpprovento());
        }
    }

    private void tabelaRenda(){
        rendau.tabelaRenda(jTRenda);
    }
    
    private void limpaCampos(){
        jFTFData.setText(null);
        jTFDescricao.setText(null);
        jFTFValor.setValue(null);
    }

    private void limpaCamposAluguel(){
        jCBAluguel.setSelectedIndex(0);
        jLValorAluguel.setText("Valor:");
        jFTFDescontoAluguel.setValue(null);
    }
    
    private void limpaCamposAtivo(){        
        jCBAtivo.removeAllItems();  
        jCBTpProvento.removeAllItems(); 
        jCBTpAtivo.setSelectedIndex(0);
    }
        
    private boolean validaAluguel(){
        if(aluguel == null){
            JOptionPane.showMessageDialog(null, "Selecione o aluguel.", "Aluguel", JOptionPane.INFORMATION_MESSAGE);
            jCBAluguel.requestFocus();
            return false;
        }
        return true;
    }
    
    private boolean validaAtivo(){
        if(tpativo == null){
            JOptionPane.showMessageDialog(null, "Selecione o tipo de ativo.", "Tipo de ativo", JOptionPane.INFORMATION_MESSAGE);
            jCBTpAtivo.requestFocus();
            return false;
        }
        if(ativo == null){
            JOptionPane.showMessageDialog(null, "Selecione o ativo.", "Ativo", JOptionPane.INFORMATION_MESSAGE);
            jCBAtivo.requestFocus();
            return false;
        }
        if(tpprov == null){
            JOptionPane.showMessageDialog(null, "Selecione o provento.", "Tipo de provento", JOptionPane.INFORMATION_MESSAGE);
            jCBTpProvento.requestFocus();
            return false;
        }
        return true;
    }
    
    private void camposRenda(){
        if(jTPRenda.getSelectedIndex() == 0){
            jLData.setVisible(false);
            jFTFData.setVisible(false);
            jLDescricao.setVisible(false);
            jTFDescricao.setVisible(false);
            jLValor.setVisible(false);
            jFTFValor.setVisible(false);
            jBConfirmar.setVisible(false);
            jPCampos.setVisible(false);
            
            jBExcluir.setVisible(false);
            jPBotoes.setVisible(false);
        }else{
            jLData.setVisible(true);
            jFTFData.setVisible(true);
            jLDescricao.setVisible(true);
            jTFDescricao.setVisible(true);
            jLValor.setVisible(true);
            jFTFValor.setVisible(true);
            jBConfirmar.setVisible(true);
            jPCampos.setVisible(true); 
            
            jBExcluir.setVisible(true);
            jPBotoes.setVisible(true);            
        }
    }

    private void camposAtivo(){
        if(jCBTpAtivo.getSelectedIndex() == 0){
            jCBAtivo.removeAllItems();
            jCBAtivo.setVisible(false);
            jCBTpProvento.removeAllItems();
            jCBTpProvento.setVisible(false);
        }else{
            jCBTpProvento.setVisible(true);
            jCBAtivo.setVisible(true);
        }
    }
    
    private void salvar(){
        if(jTPRenda.getSelectedIndex() == 1){
            tprenda.setCd_tprenda(1);
        }
        if(jTPRenda.getSelectedIndex() == 2){
            tprenda.setCd_tprenda(2);
        }
        renda.setTprenda(tprenda);
        renda.setDt_renda(util.recebeData(jFTFData.getText()));
        renda.setDs_renda(jTFDescricao.getText());
        renda.setNm_valor(Utilidade.converter(jFTFValor.getText()));
        renda.setCd_usuario(JPLogin.codloginuser);
        rendar.inserir(renda);
    }
    
    private void excluir(){
        renda.setCd_renda(renda.getCd_renda());
        rendar.excluir(renda);
    }
    
    private void jCBAluguelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBAluguelActionPerformed
        if(jCBAluguel.getSelectedIndex() != 0){
            aluguel = (Aluguel)jCBAluguel.getSelectedItem();
            valor = aluguelu.valorLiquido(aluguel.getNm_vlaluguel(), aluguel.getNm_vladm());
            jLValorAluguel.setText("Valor: " + Utilidade.formatoValor.format(valor));
            jFTFDescontoAluguel.setText("0,00");   
            jFTFData.setValue(util.concatenaData(aluguel.getDt_deposito()));            
            jTFDescricao.setText(aluguel.getImovel().getDs_descricao() + " - " + aluguel.getPresserv());
            jFTFValor.setText(Utilidade.formatoValor.format(valor));
        }else{
            aluguel = null;
        }
    }//GEN-LAST:event_jCBAluguelActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifcredito = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jFTFDescontoAluguelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTFDescontoAluguelFocusLost
        jFTFValor.setText(Utilidade.formatoValor.format(aluguelu.valorDesconto(valor, Utilidade.converter(jFTFDescontoAluguel.getText()))));
    }//GEN-LAST:event_jFTFDescontoAluguelFocusLost

    private void jBConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConfirmarActionPerformed
        if(jTPRenda.getSelectedIndex() == 1){
            if(validaAluguel()){
                salvar();
                limpaCamposAluguel();
                limpaCampos();
                rendau.tabelaRendaFiltro(jTRenda, 1);
            }
        }
        if(jTPRenda.getSelectedIndex() == 2){
            if(validaAtivo()){
                salvar();
                limpaCamposAtivo();
                limpaCampos();
                jCBTpAtivo.setSelectedIndex(0);
                rendau.tabelaRendaFiltro(jTRenda, 2);
            }
        }
    }//GEN-LAST:event_jBConfirmarActionPerformed

    private void jTRendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTRendaMouseClicked
        if(jTPRenda.getSelectedIndex() != 0){
            renda = (Renda)rendau.getSelectObject(jTRenda);
            if(renda.getTprenda().getCd_tprenda() == 1){
                jTPRenda.setSelectedIndex(1);
            }
            if(renda.getTprenda().getCd_tprenda() == 2){
                jTPRenda.setSelectedIndex(2);
            }
            renda.setCd_renda(renda.getCd_renda());
            jFTFData.setText(Utilidade.formatoData.format(renda.getDt_renda().getTime()));
            jTFDescricao.setText(renda.getDs_renda());
            jFTFValor.setText(Utilidade.formatoValor.format(renda.getNm_valor()));
            renda.setCd_usuario(renda.getCd_usuario());            
        }
    }//GEN-LAST:event_jTRendaMouseClicked

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        renda = (Renda)rendau.getSelectObject(jTRenda);
        if(renda != null){
            excluir();
            limpaCampos();
            limpaCamposAluguel();
            limpaCamposAtivo();
            if(jTPRenda.getSelectedIndex() == 1){
                rendau.tabelaRendaFiltro(jTRenda, 1);
            }
            if(jTPRenda.getSelectedIndex() == 2){
                rendau.tabelaRendaFiltro(jTRenda, 2);
            }
        }
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jTPRendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTPRendaMouseClicked
        if(jTPRenda.getSelectedIndex() == 0){
            rendau.tabelaRenda(jTRenda);
            limpaCampos();
            limpaCamposAluguel();
            limpaCamposAtivo();
        }
        if(jTPRenda.getSelectedIndex() == 1){
            rendau.tabelaRendaFiltro(jTRenda, 1);
            limpaCampos();
            limpaCamposAtivo();
        }
        if(jTPRenda.getSelectedIndex() == 2){
            rendau.tabelaRendaFiltro(jTRenda, 2);
            limpaCampos();
            limpaCamposAluguel();
        }
        camposRenda();
    }//GEN-LAST:event_jTPRendaMouseClicked

    private void jCBTpProventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBTpProventoActionPerformed
        if(jCBTpProvento.isVisible() == true && jCBTpProvento.getSelectedIndex() != 0){
            tpprov = (TipoProvento)jCBTpProvento.getSelectedItem();
            jcAtivo();
        }else{
            tpprov = null;
        }
    }//GEN-LAST:event_jCBTpProventoActionPerformed

    private void jCBAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBAtivoActionPerformed
        if(jCBAtivo.getSelectedItem() != null && jCBAtivo.getSelectedIndex() != 0){
            if(tpativo.getCd_tpativo() == 1){
                ativo = (Ativo)jCBAtivo.getSelectedItem();
                asaldo = (AtivoSaldo)asaldor.getById(ativo.getCd_ativo());
                aprov = (AcaoProvento)aprovr.getByIdProvento(ativo.getCd_ativo());
                jFTFData.setText(Utilidade.formatoData.format(aprov.getDt_pagamento().getTime()));
                jTFDescricao.setText(tpprov.getDs_tpprovento() + " " + ativo.getDs_ativo());
                jFTFValor.setText(Utilidade.formatoValor.format(rendau.calculaProventoTotal(asaldo.getNm_qtde(), aprov.getVl_provento())));                
            }
            if(tpativo.getCd_tpativo() == 2){
                ativo = (Ativo)jCBAtivo.getSelectedItem();
                asaldo = (AtivoSaldo)asaldor.getById(ativo.getCd_ativo());
                fdimprov = (FundoImobiliarioProvento)fdimprovr.getByIdProvento(ativo.getCd_ativo());
                jFTFData.setText(Utilidade.formatoData.format(fdimprov.getDt_pagamento().getTime()));
                jTFDescricao.setText(tpprov.getDs_tpprovento() + " " + ativo.getDs_ativo());
                jFTFValor.setText(Utilidade.formatoValor.format(rendau.calculaProventoTotal(asaldo.getNm_qtde(), fdimprov.getVl_provento())));                 
            }
        }        
    }//GEN-LAST:event_jCBAtivoActionPerformed

    private void jCBTpAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBTpAtivoActionPerformed
        camposAtivo();
        if(jCBTpAtivo.getSelectedIndex() != 0){
            tpativo = (TipoAtivo)jCBTpAtivo.getSelectedItem();
            jcTpProvento();
        }else{
            tpativo = null;
        }      
    }//GEN-LAST:event_jCBTpAtivoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBConfirmar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JComboBox<Aluguel> jCBAluguel;
    private javax.swing.JComboBox<Ativo> jCBAtivo;
    private javax.swing.JComboBox<TipoAtivo> jCBTpAtivo;
    private javax.swing.JComboBox<TipoProvento> jCBTpProvento;
    private javax.swing.JFormattedTextField jFTFData;
    private javax.swing.JFormattedTextField jFTFDescontoAluguel;
    private javax.swing.JFormattedTextField jFTFValor;
    private javax.swing.JLabel jLData;
    private javax.swing.JLabel jLDescontoAluguel;
    private javax.swing.JLabel jLDescricao;
    private javax.swing.JLabel jLValor;
    private javax.swing.JLabel jLValorAluguel;
    private javax.swing.JPanel jPAluguel;
    private javax.swing.JPanel jPAtivo;
    private javax.swing.JPanel jPBotoes;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JPanel jPGrid;
    private javax.swing.JPanel jPRenda;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFDescricao;
    private javax.swing.JTabbedPane jTPRenda;
    private javax.swing.JTable jTRenda;
    // End of variables declaration//GEN-END:variables
}
