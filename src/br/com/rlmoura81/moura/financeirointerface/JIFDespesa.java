package br.com.rlmoura81.moura.financeirointerface;

import br.com.rlmoura81.moura.financeiro.Despesa;
import br.com.rlmoura81.moura.financeiro.DespesaRepository;
import br.com.rlmoura81.moura.financeiro.DespesaUtil;
import br.com.rlmoura81.moura.principalcadastro.Categoria;
import br.com.rlmoura81.moura.principalcadastro.CategoriaUtil;
import br.com.rlmoura81.moura.principalcadastro.Empresa;
import br.com.rlmoura81.moura.principalcadastro.EmpresaUtil;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.beans.PropertyVetoException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

public class JIFDespesa extends javax.swing.JInternalFrame {

    private static JIFDespesa jifdespesa;

    /**
     * <p><strong>EN:</strong> Returns the singleton instance of {@link JIFDespesa}.  
     * If it does not exist, creates a new instance, sets the title to "Despesas",  
     * and maximizes the window. Handles possible {@link PropertyVetoException} when maximizing.</p>
     *
     * <p><strong>IT:</strong> Restituisce l'istanza singleton di {@link JIFDespesa}.  
     * Se non esiste, crea una nuova istanza, imposta il titolo su "Despesas"  
     * e massimizza la finestra. Gestisce la possibile {@link PropertyVetoException} durante la massimizzazione.</p>
     *
     * <p><strong>PT-BR:</strong> Retorna a instância singleton de {@link JIFDespesa}.  
     * Caso não exista, cria uma nova instância, define o título como "Despesas"  
     * e maximiza a janela. Trata a possível {@link PropertyVetoException} ao maximizar.</p>
     */
    public static JIFDespesa getInstancia() {
        if (jifdespesa == null) {
            jifdespesa = new JIFDespesa();
            jifdespesa.setTitle("Despesas");
            try {
                jifdespesa.setMaximum(true);
            } catch (PropertyVetoException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao abrir:\n" + ex.getMessage(), "Despesas", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(JIFDespesa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return jifdespesa;
    }

    Despesa despesa = null;
    Despesa despesames = null;
    Despesa despesaano = null;
    DespesaRepository despesar = new DespesaRepository();
    DespesaUtil despesau = new DespesaUtil();

    Empresa empresa = null;
    EmpresaUtil empresau = new EmpresaUtil();
    
    Categoria categoria = null;
    CategoriaUtil categoriau = new CategoriaUtil();
    Utilidade util = new Utilidade();

    public JIFDespesa() {
        initComponents();
        
        formataValor();
        jbAnual();
        jcEmpresa();
        jcCategoria();
        tabelaDespesa();
        calculaValorTotal();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPCampos = new javax.swing.JPanel();
        jCBPrestador = new javax.swing.JComboBox<>();
        jFTFValor = new javax.swing.JFormattedTextField();
        jLDespesa = new javax.swing.JLabel();
        jTFDespesa = new javax.swing.JTextField();
        jLValor = new javax.swing.JLabel();
        jLCategoria = new javax.swing.JLabel();
        jCBCategoria = new javax.swing.JComboBox<>();
        jLPrestador = new javax.swing.JLabel();
        jChkBAnual = new javax.swing.JCheckBox();
        jLVencimento = new javax.swing.JLabel();
        jFTFDtVencimento = new javax.swing.JFormattedTextField();
        jLValorMes = new javax.swing.JLabel();
        jPResumo = new javax.swing.JPanel();
        jLTotal = new javax.swing.JLabel();
        jLMensal = new javax.swing.JLabel();
        jLAnual = new javax.swing.JLabel();
        jPBotoes = new javax.swing.JPanel();
        jBSalvar = new javax.swing.JButton();
        jBAlterar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jPGridDespesaMes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTDespesaMes = new javax.swing.JTable();
        jPGridDespesaAno = new javax.swing.JPanel();
        jPGirdDespesaAno = new javax.swing.JScrollPane();
        jTDespesaAno = new javax.swing.JTable();

        setClosable(true);
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

        jCBPrestador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBPrestadorActionPerformed(evt);
            }
        });

        jFTFValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        jFTFValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFTFValorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFTFValorFocusLost(evt);
            }
        });

        jLDespesa.setText("Despesa:");

        jLValor.setText("Valor:");

        jLCategoria.setText("Categoria:");

        jCBCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBCategoriaActionPerformed(evt);
            }
        });

        jLPrestador.setText("Prestador:");

        jChkBAnual.setText("Anual");
        jChkBAnual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChkBAnualActionPerformed(evt);
            }
        });

        jLVencimento.setText("Vencimento:");

        jFTFDtVencimento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFTFDtVencimentoFocusGained(evt);
            }
        });

        jLValorMes.setText("Mes: 0,00");

        jPResumo.setBorder(javax.swing.BorderFactory.createTitledBorder("Resumo"));

        jLTotal.setText("Total:");

        jLMensal.setText("Mensal:");

        jLAnual.setText("Anual:");

        javax.swing.GroupLayout jPResumoLayout = new javax.swing.GroupLayout(jPResumo);
        jPResumo.setLayout(jPResumoLayout);
        jPResumoLayout.setHorizontalGroup(
            jPResumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPResumoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPResumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLTotal)
                    .addComponent(jLMensal)
                    .addComponent(jLAnual))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPResumoLayout.setVerticalGroup(
            jPResumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPResumoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLMensal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLAnual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLTotal)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPCamposLayout = new javax.swing.GroupLayout(jPCampos);
        jPCampos.setLayout(jPCamposLayout);
        jPCamposLayout.setHorizontalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLDespesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLValor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLCategoria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(jLPrestador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPCamposLayout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jCBPrestador, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPCamposLayout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(jCBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPCamposLayout.createSequentialGroup()
                            .addGap(13, 13, 13)
                            .addComponent(jFTFValor, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)
                            .addComponent(jLValorMes)
                            .addGap(18, 18, 18)
                            .addComponent(jLVencimento)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jFTFDtVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTFDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jChkBAnual)))
                .addGap(18, 18, 18)
                .addComponent(jPResumo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPCamposLayout.setVerticalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLDespesa)
                            .addComponent(jTFDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jChkBAnual))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLValor)
                            .addComponent(jFTFValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLVencimento)
                            .addComponent(jFTFDtVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLValorMes))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCBPrestador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLPrestador))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLCategoria)
                            .addComponent(jCBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPResumo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPBotoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        javax.swing.GroupLayout jPBotoesLayout = new javax.swing.GroupLayout(jPBotoes);
        jPBotoes.setLayout(jPBotoesLayout);
        jPBotoesLayout.setHorizontalGroup(
            jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBExcluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPBotoesLayout.setVerticalGroup(
            jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalvar)
                    .addComponent(jBAlterar)
                    .addComponent(jBExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPGridDespesaMes.setBorder(javax.swing.BorderFactory.createTitledBorder("Despesa Mensal"));

        jTDespesaMes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTDespesaMes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTDespesaMesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTDespesaMes);

        javax.swing.GroupLayout jPGridDespesaMesLayout = new javax.swing.GroupLayout(jPGridDespesaMes);
        jPGridDespesaMes.setLayout(jPGridDespesaMesLayout);
        jPGridDespesaMesLayout.setHorizontalGroup(
            jPGridDespesaMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridDespesaMesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPGridDespesaMesLayout.setVerticalGroup(
            jPGridDespesaMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridDespesaMesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPGridDespesaAno.setBorder(javax.swing.BorderFactory.createTitledBorder("Despesa Anual"));

        jTDespesaAno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTDespesaAno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTDespesaAnoMouseClicked(evt);
            }
        });
        jPGirdDespesaAno.setViewportView(jTDespesaAno);

        javax.swing.GroupLayout jPGridDespesaAnoLayout = new javax.swing.GroupLayout(jPGridDespesaAno);
        jPGridDespesaAno.setLayout(jPGridDespesaAnoLayout);
        jPGridDespesaAnoLayout.setHorizontalGroup(
            jPGridDespesaAnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridDespesaAnoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPGirdDespesaAno)
                .addContainerGap())
        );
        jPGridDespesaAnoLayout.setVerticalGroup(
            jPGridDespesaAnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridDespesaAnoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPGirdDespesaAno, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPGridDespesaMes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPCampos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPGridDespesaAno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPGridDespesaMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPGridDespesaAno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /*
    *EM TESTE - COLOCAR COMENTARIO
    *CAMPO DE DESPESA ANUAL
    */
    
    private void jbAnual(){
        if(jChkBAnual.isSelected() == true){
            jLValorMes.setVisible(true);
            jLVencimento.setVisible(true);
            jFTFDtVencimento.setVisible(true);
            formataData();
        }else{
            jLValorMes.setVisible(false);
            jLVencimento.setVisible(false);
            jFTFDtVencimento.setText(null);
            jFTFDtVencimento.setVisible(false);            
        }   
    }
    
    /*
    *EM TESTE - COLCOCAR COMENTARIO
    *VALIDA DE PRECISA OU NAO SELECIONAR O PLANO ANUAL
    */
    private void validaChckPlano(){
        if(despesa.getTp_plano() == 0){
            jChkBAnual.setSelected(false);
        }
        if(despesa.getTp_plano() == 1){
            jChkBAnual.setSelected(true);
            jbAnual();
        }
    }    
    
    /*
    *EM TESTE - COLCOCAR COMENTARIO
    *SALVA O TIPO DE PLANO NA DESPESA SE MENSAL OU ANUAL
    */
    
    private void salvarTpPlano(){
        if(jChkBAnual.isSelected() == false){
            despesa.setTp_plano(0);
            despesa.setDt_validade(util.recebeData("01/01/1920"));
        }
        if(jChkBAnual.isSelected() == true){
            despesa.setTp_plano(1);
            despesa.setDt_validade(util.recebeData(jFTFDtVencimento.getText()));
        }
    }
    
    /*
    *EM TESTE - COLCOCAR COMENTARIO
    *COMPORTAMENTO DE SELECIONAR O ITEM DAS TABLES
    */
    
    private void selecinaJTable(){
        jTDespesaMes.getSelectionModel().addListSelectionListener(t -> {
            if (t.getValueIsAdjusting()) return;
            if (jTDespesaMes.getSelectedRow() != -1) {
                SwingUtilities.invokeLater(() -> jTDespesaAno.clearSelection());
            }
        });
        jTDespesaAno.getSelectionModel().addListSelectionListener(t -> {
            if (t.getValueIsAdjusting()) return;
            if (jTDespesaAno.getSelectedRow() != -1) {
                SwingUtilities.invokeLater(() -> jTDespesaMes.clearSelection());
            }
        });        
    }
    
    
    /**
     * <p><strong>EN:</strong> Formats the expense value field with the predefined numeric mask.</p>
     * <p><strong>IT:</strong> Formatta il campo valore della spesa con la maschera numerica predefinita.</p>
     * <p><strong>PT-BR:</strong> Formata o campo de valor da despesa com a máscara numérica predefinida.</p>
     */
    private void formataValor() {
        jFTFValor.setFormatterFactory(Utilidade.formataValorCampo(ui));
        jFTFValor.setText("0,00");
    }
    
    /*
    *EM TESTE - COLOCAR COMENTARIO
    *FORMATA DATA
    */
    private void formataData(){
        util.formataDataCampo(jFTFDtVencimento);
    }
    
    /*
    *EM TESTE - COLOCAR COMENTARIO
    *CALCULA VALOR ANUAL
    */
    
    private String calculaValorMesAno(String valor){
        BigDecimal vl = Utilidade.converter(valor);
        if(jChkBAnual.isSelected() == true && vl != null){            
            vl = vl.divide(Utilidade.converter("12"), 2, RoundingMode.HALF_EVEN);
            valor = Utilidade.formatoValor.format(vl);
        }else{
            valor = "0,00";
        }
        return valor;
    }

    /**
     * <p><strong>EN:</strong> Validates the mandatory fields of the expense form, ensuring that  
     * the description, value, provider, and category are filled correctly.</p>
     * <p><strong>IT:</strong> Valida i campi obbligatori del modulo di spesa, assicurando che  
     * la descrizione, il valore, il fornitore e la categoria siano compilati correttamente.</p>
     * <p><strong>PT-BR:</strong> Valida os campos obrigatórios do formulário de despesa, garantindo que  
     * a descrição, valor, prestador e categoria estejam preenchidos corretamente.</p>
     */
    private boolean validaCampos() {
        if (jTFDespesa.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo em branco.", "Despesa", JOptionPane.INFORMATION_MESSAGE);
            jTFDespesa.requestFocus();
            return false;
        }
        if (jFTFValor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Valor em branco.", "Despesa", JOptionPane.INFORMATION_MESSAGE);
            jFTFValor.requestFocus();
            return false;
        }
        if(jFTFDtVencimento.isVisible() == true && util.validaDataCampo(jFTFDtVencimento.getText()) == false){
            jFTFDtVencimento.requestFocus();
            return false;
        }
        if (empresa == null) {
            JOptionPane.showMessageDialog(null, "Selecione o prestador.", "Prestador de Serviço.", JOptionPane.INFORMATION_MESSAGE);
            jCBPrestador.requestFocus();
            return false;
        }
        if (categoria == null) {
            JOptionPane.showMessageDialog(null, "Selecione a categoria.", "Categoria", JOptionPane.INFORMATION_MESSAGE);
            jCBCategoria.requestFocus();
            return false;
        }
        return true;
    }

    /**
     * <p><strong>EN:</strong> Loads the category options into the combo box.</p>
     * <p><strong>IT:</strong> Carica le opzioni di categoria nella combo box.</p>
     * <p><strong>PT-BR:</strong> Carrega as opções de categoria no combo box.</p>
     */
    private void jcCategoria() {
        categoriau.jcCategoria(jCBCategoria);
    }

    /**
     * <p><strong>EN:</strong> Loads the service provider options into the combo box.</p>
     * <p><strong>IT:</strong> Carica le opzioni del fornitore di servizi nella combo box.</p>
     * <p><strong>PT-BR:</strong> Carrega as opções de prestador de serviço no combo box.</p>
     */
    private void jcEmpresa() {
        empresau.jcEmpresa(jCBPrestador);
    }

    /**
     * <p><strong>EN:</strong> Fills the expense table with the registered data.</p>
     * <p><strong>IT:</strong> Compila la tabella delle spese con i dati registrati.</p>
     * <p><strong>PT-BR:</strong> Preenche a tabela de despesas com os dados cadastrados.</p>
     */
    private void tabelaDespesa() {
        jTDespesaMes.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTDespesaAno.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        despesau.tabelaDespesaMes(jTDespesaMes);
        despesau.tabelaDespesaAno(jTDespesaAno);
    }

    /**
     * <p><strong>EN:</strong> Clears all input fields in the expense form.</p>
     * <p><strong>IT:</strong> Pulisce tutti i campi di input del modulo di spesa.</p>
     * <p><strong>PT-BR:</strong> Limpa todos os campos de entrada do formulário de despesa.</p>
     */
    private void limpaCampos(){
        jTFDespesa.setText(null);
        jFTFValor.setValue(null);
        jCBPrestador.setSelectedIndex(0);
        jCBCategoria.setSelectedIndex(0);
        jChkBAnual.setSelected(false);
        jbAnual();
    }
    
    /**
     * <p><strong>EN:</strong> Calculates the total value of all registered expenses  
     * and updates the total label.</p>
     * <p><strong>IT:</strong> Calcola il valore totale di tutte le spese registrate  
     * e aggiorna l'etichetta del totale.</p>
     * <p><strong>PT-BR:</strong> Calcula o valor total de todas as despesas registradas  
     * e atualiza o rótulo do total.</p>
     */
    private void calculaValorTotal(){
        jLMensal.setText("Mes: " + Utilidade.formatoValor.format(despesau.calculaDespesaTotalDoMes()));
        jLAnual.setText("Ano: " + Utilidade.formatoValor.format(despesau.calculaDespesaTotalAno()));
        jLTotal.setText("Total: " + Utilidade.formatoValor.format(despesau.calculaDespesaTotal()));
    }
    
    /**
     * <p><strong>EN:</strong> Saves a new expense record with the filled form data.</p>
     * <p><strong>IT:</strong> Salva un nuovo record di spesa con i dati compilati nel modulo.</p>
     * <p><strong>PT-BR:</strong> Salva um novo registro de despesa com os dados preenchidos no formulário.</p>
     */
    private void salvar() {
        despesa = new Despesa();
        despesa.setDs_despesa(jTFDespesa.getText());
        despesa.setNm_valor(Utilidade.converter(jFTFValor.getText()));
        salvarTpPlano();
        despesa.setEmpresa(empresa);
        despesa.setCategoria(categoria);
        despesa.setCd_usuario(JPLogin.codloginuser);
        despesar.inserir(despesa);
        despesa = null;
    }
    
    /**
     * <p><strong>EN:</strong> Updates an existing expense record with the current form data.</p>
     * <p><strong>IT:</strong> Aggiorna un record di spesa esistente con i dati attuali del modulo.</p>
     * <p><strong>PT-BR:</strong> Atualiza um registro de despesa existente com os dados atuais do formulário.</p>
     */
    private void alterar(){
        despesa.setDs_despesa(jTFDespesa.getText());
        despesa.setNm_valor(Utilidade.converter(jFTFValor.getText()));
        salvarTpPlano();
        despesa.setEmpresa(empresa);
        despesa.setCategoria(categoria);
        despesar.alterar(despesa);
    }

    /**
     * <p><strong>EN:</strong> Deletes the selected expense record from the database.</p>
     * <p><strong>IT:</strong> Elimina il record di spesa selezionato dal database.</p>
     * <p><strong>PT-BR:</strong> Exclui o registro de despesa selecionado do banco de dados.</p>
     */
    private void excluir(){
        despesa.setCd_despesa(despesa.getCd_despesa());
        despesar.excluir(despesa);
    }
    
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifdespesa = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if (validaCampos()) {
            salvar();
            calculaValorTotal();
            limpaCampos();
            tabelaDespesa();
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jCBPrestadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBPrestadorActionPerformed
        if(jCBPrestador.getSelectedIndex() != 0){
            empresa = (Empresa) jCBPrestador.getSelectedItem();
        }else{
            empresa = null;
        }
    }//GEN-LAST:event_jCBPrestadorActionPerformed

    private void jCBCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBCategoriaActionPerformed
        if(jCBCategoria.getSelectedIndex() != 0){
            categoria = (Categoria) jCBCategoria.getSelectedItem();
        }else{
            categoria = null;
        }
    }//GEN-LAST:event_jCBCategoriaActionPerformed

    private void jTDespesaMesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTDespesaMesMouseClicked
        selecinaJTable();
        despesa = (Despesa)despesau.getSelectDespesa(jTDespesaMes);
        despesames = despesa;
        despesames.setCd_despesa(despesames.getCd_despesa());
        jTFDespesa.setText(despesames.getDs_despesa());
        jFTFValor.setText(Utilidade.formatoValor.format(despesames.getNm_valor()));
        validaChckPlano();
        jCBPrestador.getModel().setSelectedItem(despesames.getEmpresa());
        jCBCategoria.getModel().setSelectedItem(despesames.getCategoria());
    }//GEN-LAST:event_jTDespesaMesMouseClicked
    
    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        Despesa dm = new Despesa();
        dm = (Despesa)despesau.getSelectDespesa(jTDespesaMes);
        if(dm != null){
            despesa = dm;    
        }
        Despesa da = new Despesa();
        da = (Despesa)despesau.getSelectDespesa(jTDespesaAno);
        if(da != null){
            despesa = da;
        }        
        if(despesa != null){
            if(validaCampos()){
                alterar();    
                calculaValorTotal();
                limpaCampos();
                tabelaDespesa();                
            }
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma despesa");
        }
        dm = null;
        da = null;
        despesa = null;
    }//GEN-LAST:event_jBAlterarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        Despesa dm = new Despesa();
        dm = (Despesa)despesau.getSelectDespesa(jTDespesaMes);
        if(dm != null){
            despesa = dm;    
        }
        Despesa da = new Despesa();
        da = (Despesa)despesau.getSelectDespesa(jTDespesaAno);
        if(da != null){
            despesa = da;
        }    
        if(despesa != null){
            excluir();
            calculaValorTotal();
            limpaCampos();
            tabelaDespesa();
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma despesa");
        }
        dm = null;
        da = null;
        despesa = null;
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jFTFDtVencimentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTFDtVencimentoFocusGained
        util.posicionaCursorjFTFData(jFTFDtVencimento);
    }//GEN-LAST:event_jFTFDtVencimentoFocusGained

    private void jChkBAnualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChkBAnualActionPerformed
        jbAnual();
    }//GEN-LAST:event_jChkBAnualActionPerformed

    private void jFTFValorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTFValorFocusLost
        jLValorMes.setText("Mes: " + calculaValorMesAno(jFTFValor.getText()));
    }//GEN-LAST:event_jFTFValorFocusLost

    private void jTDespesaAnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTDespesaAnoMouseClicked
        selecinaJTable();
        despesa = (Despesa)despesau.getSelectDespesa(jTDespesaAno);
        despesaano = despesa;
        despesaano.setCd_despesa(despesaano.getCd_despesa());
        jTFDespesa.setText(despesaano.getDs_despesa());
        jFTFValor.setText(Utilidade.formatoValor.format(despesaano.getNm_valor()));
        validaChckPlano();
        jLValorMes.setText("Mes: " + calculaValorMesAno(jFTFValor.getText()));
        jFTFDtVencimento.setText(Utilidade.formatoData.format(despesaano.getDt_validade().getTime()));
        jCBPrestador.getModel().setSelectedItem(despesaano.getEmpresa());
        jCBCategoria.getModel().setSelectedItem(despesaano.getCategoria());
    }//GEN-LAST:event_jTDespesaAnoMouseClicked

    private void jFTFValorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTFValorFocusGained
        util.posicionaCursorjFTFValor(jFTFValor);
    }//GEN-LAST:event_jFTFValorFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<Categoria> jCBCategoria;
    private javax.swing.JComboBox<Empresa> jCBPrestador;
    private javax.swing.JCheckBox jChkBAnual;
    private javax.swing.JFormattedTextField jFTFDtVencimento;
    private javax.swing.JFormattedTextField jFTFValor;
    private javax.swing.JLabel jLAnual;
    private javax.swing.JLabel jLCategoria;
    private javax.swing.JLabel jLDespesa;
    private javax.swing.JLabel jLMensal;
    private javax.swing.JLabel jLPrestador;
    private javax.swing.JLabel jLTotal;
    private javax.swing.JLabel jLValor;
    private javax.swing.JLabel jLValorMes;
    private javax.swing.JLabel jLVencimento;
    private javax.swing.JPanel jPBotoes;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JScrollPane jPGirdDespesaAno;
    private javax.swing.JPanel jPGridDespesaAno;
    private javax.swing.JPanel jPGridDespesaMes;
    private javax.swing.JPanel jPResumo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTDespesaAno;
    private javax.swing.JTable jTDespesaMes;
    private javax.swing.JTextField jTFDespesa;
    // End of variables declaration//GEN-END:variables
}
