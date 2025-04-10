package br.com.rlmoura81.moura.principalinterface;

import br.com.rlmoura81.moura.animal.Animal;
import br.com.rlmoura81.moura.animal.AnimalDespesa;
import br.com.rlmoura81.moura.animal.AnimalUtil;
import br.com.rlmoura81.moura.animal.Produto;
import br.com.rlmoura81.moura.animal.ProdutoUtil;
import br.com.rlmoura81.moura.imovel.Imovel;
import br.com.rlmoura81.moura.imovel.ImovelDespesa;
import br.com.rlmoura81.moura.imovel.ImovelUtil;
import br.com.rlmoura81.moura.principal.ModuloDespesaRepository;
import br.com.rlmoura81.moura.principal.ModuloDespesaUtil;
import br.com.rlmoura81.moura.principalcadastro.PrestadorServico;
import br.com.rlmoura81.moura.principalcadastro.PrestadorServicoUtil;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import br.com.rlmoura81.moura.veiculo.Veiculo;
import br.com.rlmoura81.moura.veiculo.VeiculoDespesa;
import br.com.rlmoura81.moura.veiculo.VeiculoUtil;
import java.math.BigDecimal;
import javax.swing.JOptionPane;

public class JIFModuloDespesa extends javax.swing.JInternalFrame {
    
    private static JIFModuloDespesa jifmodulodespesa;
    
    public static JIFModuloDespesa getInstancia(Object o){      
        Animal a = new Animal();        
        if(jifmodulodespesa == null | o.getClass().equals(a.getClass())){
            jifmodulodespesa = new JIFModuloDespesa(a);
            jifmodulodespesa.setTitle("Despesas - Animal");
        }
        Veiculo v = new Veiculo();
        if(jifmodulodespesa == null | o.getClass().equals(v.getClass())){
            jifmodulodespesa = new JIFModuloDespesa(v);
            jifmodulodespesa.setTitle("Despesas - Veículo");
        }
        Imovel i = new Imovel();
        if(jifmodulodespesa == null | o.getClass().equals(i.getClass())){
            jifmodulodespesa = new JIFModuloDespesa(i);
            jifmodulodespesa.setTitle("Despesas - Imóvel");
        }
        return jifmodulodespesa;
    }
    
    Animal animal = new Animal();
    AnimalUtil animalu = new AnimalUtil();
    
    AnimalDespesa animald = new AnimalDespesa();
    
    Produto produto = new Produto();
    ProdutoUtil produtou = new ProdutoUtil();

    Veiculo veiculo = new Veiculo();
    VeiculoUtil veiculou = new VeiculoUtil();
    
    VeiculoDespesa veiculod = new VeiculoDespesa();
    
    Imovel imovel = new Imovel();
    ImovelUtil imovelu = new ImovelUtil();
    
    ImovelDespesa imoveld = new ImovelDespesa();
    
    PrestadorServico presserv = new PrestadorServico();
    PrestadorServicoUtil presservu = new PrestadorServicoUtil();
    
    ModuloDespesaRepository modulodr = new ModuloDespesaRepository();
    ModuloDespesaUtil modulodu = new ModuloDespesaUtil();
    
    Utilidade util = new Utilidade();

    Object obj = null;
    
    public JIFModuloDespesa(Object o) {
        initComponents();

        obj = o;
        
        desativaBotoes();
        
        if(o.getClass().equals(animal.getClass())){
            jcAnimal();
            jcPresserv(2);
            jCBProduto.setVisible(true);
            produtou.jcProduto(jCBProduto);
            jLTotal.setText("Total mês: " + Utilidade.formatoValor.format(modulodr.somaDespesa(animal)));
        }    
        if(o.getClass().equals(veiculo.getClass())){
            jcVeiculo();
            jcPresserv(3);
            jCBProduto.setVisible(false);
            jLTotal.setText("Total mês: " + Utilidade.formatoValor.format(modulodr.somaDespesa(veiculo)));
        }   
        if(o.getClass().equals(imovel.getClass())){
            jcImovel();
            jcPresserv(4);
            jCBProduto.setVisible(false);
            jLTotal.setText("Total mês: " + Utilidade.formatoValor.format(modulodr.somaDespesa(imovel)));
        }
        formataData();
        formataValor();
        jBSalvar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPVeiculo = new javax.swing.JPanel();
        jCBModuloDespesa = new javax.swing.JComboBox<>();
        jCBPresserv = new javax.swing.JComboBox<>();
        jCBProduto = new javax.swing.JComboBox<>();
        jPCampos = new javax.swing.JPanel();
        jLNota = new javax.swing.JLabel();
        jTFNota = new javax.swing.JTextField();
        jLData = new javax.swing.JLabel();
        jFTFData = new javax.swing.JFormattedTextField();
        jLValor = new javax.swing.JLabel();
        jFTFValor = new javax.swing.JFormattedTextField();
        jLQtde = new javax.swing.JLabel();
        jTFQtde = new javax.swing.JTextField();
        jLDescricao = new javax.swing.JLabel();
        jTFDescricao = new javax.swing.JTextField();
        jLNotaTotal = new javax.swing.JLabel();
        jPBotoes = new javax.swing.JPanel();
        jBSalvar = new javax.swing.JButton();
        jBAlterar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jFTFDataInicial = new javax.swing.JFormattedTextField();
        jFTFDataFinal = new javax.swing.JFormattedTextField();
        jBPesquisar = new javax.swing.JButton();
        jLTotal = new javax.swing.JLabel();
        jPGrid = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTDespesa = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

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

        jPVeiculo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jCBModuloDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBModuloDespesaActionPerformed(evt);
            }
        });

        jCBPresserv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBPresservActionPerformed(evt);
            }
        });

        jCBProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPVeiculoLayout = new javax.swing.GroupLayout(jPVeiculo);
        jPVeiculo.setLayout(jPVeiculoLayout);
        jPVeiculoLayout.setHorizontalGroup(
            jPVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPVeiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCBModuloDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCBPresserv, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCBProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPVeiculoLayout.setVerticalGroup(
            jPVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPVeiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBModuloDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBPresserv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPCampos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLNota.setText("Nota:");

        jLData.setText("Data:");

        jLValor.setText("Valor:");

        jLQtde.setText("Qtde:");

        jTFQtde.setText("1");
        jTFQtde.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFQtdeFocusLost(evt);
            }
        });

        jLDescricao.setText("Descrição:");

        jLNotaTotal.setText("Total:");

        javax.swing.GroupLayout jPCamposLayout = new javax.swing.GroupLayout(jPCampos);
        jPCampos.setLayout(jPCamposLayout);
        jPCamposLayout.setHorizontalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addComponent(jLNota)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFNota, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFTFData, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLValor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFTFValor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addComponent(jLDescricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFDescricao)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLQtde)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFQtde, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLNotaTotal)
                .addContainerGap(138, Short.MAX_VALUE))
        );
        jPCamposLayout.setVerticalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLValor)
                        .addComponent(jFTFValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLQtde)
                        .addComponent(jTFQtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLNotaTotal))
                    .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLNota)
                        .addComponent(jTFNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLData)
                        .addComponent(jFTFData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLDescricao)
                    .addComponent(jTFDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jBPesquisar.setText("Pesquisar");
        jBPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPesquisarActionPerformed(evt);
            }
        });

        jLTotal.setText("Total:");

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
                .addGap(18, 18, 18)
                .addComponent(jFTFDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBPesquisar)
                .addGap(18, 18, 18)
                .addComponent(jLTotal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPBotoesLayout.setVerticalGroup(
            jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalvar)
                    .addComponent(jBAlterar)
                    .addComponent(jBExcluir)
                    .addComponent(jFTFDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFTFDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBPesquisar)
                    .addComponent(jLTotal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPGrid.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTDespesa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTDespesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTDespesaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTDespesa);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPVeiculo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPCampos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPBotoes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void desativaBotoes(){
        jBAlterar.setEnabled(false);
        jBExcluir.setEnabled(false);
    }
    
    private void ativaBotoes(){
        jBAlterar.setEnabled(true);
        jBExcluir.setEnabled(true);
    }
    
    private void jcAnimal(){
        animalu.jcAnimal(jCBModuloDespesa);
    }
        
    private void jcVeiculo(){
        veiculou.jcVeiculo(jCBModuloDespesa);
    }
    
    private void jcImovel(){
        imovelu.jcImovel(jCBModuloDespesa);
    }
    
    private void jcPresserv(int num){
        presservu.jcPresserv(jCBPresserv, num);
    }
    
    private void tabelaDespesa(Object o){
        if(o.getClass().equals(animal.getClass())){
            modulodu.tabelaDespesaAnimal(jTDespesa, animal);              
        }
        if(o.getClass().equals(veiculo.getClass())){
            modulodu.tabelaDespesaVeiculo(jTDespesa, veiculo);
        }
        if(o.getClass().equals(imovel.getClass())){
            modulodu.tabelaDespesaImovel(jTDespesa, imovel);
        }
        if(jCBModuloDespesa.getSelectedIndex() != 0){
            calculaTotalMes(o);            
        }
    }
    
    private void formataValor(){
        jFTFValor.setFormatterFactory(Utilidade.formataValorCampo(ui));
    }
    
    private void formataData(){
        util.formataDataCampo(jFTFData);
        util.formataDataCampo(jFTFDataInicial);
        util.formataDataCampo(jFTFDataFinal);
    }
    
    private boolean validaCampos(){
        if(util.validaDataCampo(jFTFData.getText()) == false){
            jFTFData.requestFocus();
            return false;
        }
        if(jFTFValor.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Valor em branco.", "Despesa", JOptionPane.INFORMATION_MESSAGE);
            jFTFValor.requestFocus();
            return false;
        }
        if(jTFDescricao.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Descrição em branco.", "Despesa", JOptionPane.INFORMATION_MESSAGE);
            jTFDescricao.requestFocus();
            return false;
        }
        return true;
    }
    
    private void limpaCampos(){
        jCBPresserv.setSelectedIndex(0);
        jTFNota.setText(null);
        jFTFData.setText(null);
        jFTFValor.setValue(null);
        jTFQtde.setText("1");
        jLNotaTotal.setText("Total: ");
        jTFDescricao.setText(null);
        if(jCBProduto.isVisible()){
            jCBProduto.setSelectedIndex(0);
        }
    }
    
    private void salvar(){
        if(obj.getClass().equals(animal.getClass())){
            animald.setAnimal(animal);
            animald.setPresserv(presserv);
            animald.setProduto(produto);
            animald.setNm_nota(jTFNota.getText());
            animald.setDt_despesa(util.recebeData(jFTFData.getText()));
            animald.setNm_valor(Utilidade.converter(jFTFValor.getText()));
            animald.setNm_qtde(Integer.parseInt(jTFQtde.getText()));
            animald.setDs_descricao(jTFDescricao.getText());
            animald.setCd_usuario(JPLogin.codloginuser);
            modulodr.inserir(animald);
        }
        if(obj.getClass().equals(veiculo.getClass())){
            veiculod.setVeiculo(veiculo);
            veiculod.setPresserv(presserv);
            veiculod.setNm_nota(jTFNota.getText());
            veiculod.setDt_despesa(util.recebeData(jFTFData.getText()));
            veiculod.setNm_valor(Utilidade.converter(jFTFValor.getText()));
            veiculod.setNm_qtde(Integer.parseInt(jTFQtde.getText()));
            veiculod.setDs_descricao(jTFDescricao.getText());
            veiculod.setCd_usuario(JPLogin.codloginuser);
            modulodr.inserir(veiculod);
        }
        if(obj.getClass().equals(imovel.getClass())){
            imoveld.setImovel(imovel);
            imoveld.setPresserv(presserv);
            imoveld.setNm_nota(jTFNota.getText());
            imoveld.setDt_despesa(util.recebeData(jFTFData.getText()));
            imoveld.setNm_valor(Utilidade.converter(jFTFValor.getText()));
            imoveld.setNm_qtde(Integer.parseInt(jTFQtde.getText()));
            imoveld.setDs_descricao(jTFDescricao.getText());
            imoveld.setCd_usuario(JPLogin.codloginuser);
            modulodr.inserir(imoveld);
        }
    }
    
    private void alterar(){
        if(obj.getClass().equals(animal.getClass())){
            animald.setAnimal(animal);
            animald.setPresserv(presserv);
            animald.setProduto(produto);
            animald.setNm_nota(jTFNota.getText());
            animald.setDt_despesa(util.recebeData(jFTFData.getText()));
            animald.setNm_valor(Utilidade.converter(jFTFValor.getText()));
            animald.setNm_qtde(Integer.parseInt(jTFQtde.getText()));
            animald.setDs_descricao(jTFDescricao.getText());
            animald.setCd_usuario(JPLogin.codloginuser);
            modulodr.alterar(animald);
        }
        if(obj.getClass().equals(veiculo.getClass())){
            veiculod.setVeiculo(veiculo);
            veiculod.setPresserv(presserv);
            veiculod.setNm_nota(jTFNota.getText());
            veiculod.setDt_despesa(util.recebeData(jFTFData.getText()));
            veiculod.setNm_valor(Utilidade.converter(jFTFValor.getText()));
            veiculod.setNm_qtde(Integer.parseInt(jTFQtde.getText()));
            veiculod.setDs_descricao(jTFDescricao.getText());
            veiculod.setCd_usuario(JPLogin.codloginuser);
            modulodr.alterar(veiculod);
        }
        if(obj.getClass().equals(imovel.getClass())){
            imoveld.setImovel(imovel);
            imoveld.setPresserv(presserv);
            imoveld.setNm_nota(jTFNota.getText());
            imoveld.setDt_despesa(util.recebeData(jFTFData.getText()));
            imoveld.setNm_valor(Utilidade.converter(jFTFValor.getText()));
            imoveld.setNm_qtde(Integer.parseInt(jTFQtde.getText()));
            imoveld.setDs_descricao(jTFDescricao.getText());
            imoveld.setCd_usuario(JPLogin.codloginuser);
            modulodr.alterar(imoveld);
        }        
    }
    
    private void excluir(){
        if(obj.getClass().equals(animal.getClass())){
            animald.setCd_despesa(animald.getCd_despesa());
            animald.setAnimal(animal);
            animald.setCd_usuario(JPLogin.codloginuser);
            modulodr.excluir(animald);
        }
        if(obj.getClass().equals(veiculo.getClass())){
            veiculod.setCd_despesa(veiculod.getCd_despesa());
            veiculod.setVeiculo(veiculo);
            veiculod.setCd_usuario(JPLogin.codloginuser);
            modulodr.excluir(veiculod);
        }
        if(obj.getClass().equals(imovel.getClass())){
            imoveld.setCd_despesa(imoveld.getCd_despesa());
            imoveld.setImovel(imovel);
            imoveld.setCd_usuario(JPLogin.codloginuser);
            modulodr.excluir(imoveld);
        }         
    }
    
    private void calculaValor(){
        BigDecimal valor = Utilidade.converter(jFTFValor.getText());
        BigDecimal qtde = Utilidade.converter(jTFQtde.getText());
        BigDecimal total = valor.multiply(qtde);
        jLNotaTotal.setText("Total: " + Utilidade.formatoValor.format(total));
    }
    
    private void calculaTotalMes(Object o){
        if(o.getClass().equals(animal.getClass())){
            jLTotal.setText("Total mês: " + Utilidade.formatoValor.format(modulodu.calculaDespesaTotalAni(animal)));            
        }
        if(o.getClass().equals(veiculo.getClass())){
            jLTotal.setText("Total mês: " + Utilidade.formatoValor.format(modulodu.calculaDespesaTotalVeic(veiculo)));
        }
        if(o.getClass().equals(imovel.getClass())){
            jLTotal.setText("Total mês: " + Utilidade.formatoValor.format(modulodu.calculaDespesaTotalImov(imovel)));
        }
    } 
    
    private void calculaTotalMes(Object o,String dt_inicio, String dt_final){
        if(o.getClass().equals(animal.getClass())){
            jLTotal.setText("Total mês: " + Utilidade.formatoValor.format(modulodu.calculaDespesaTotalAni(animal, dt_inicio, dt_final)));            
        }
        if(o.getClass().equals(veiculo.getClass())){
            jLTotal.setText("Total mês: " + Utilidade.formatoValor.format(modulodu.calculaDespesaTotalVeic(veiculo, dt_inicio, dt_final)));
        }
        if(o.getClass().equals(imovel.getClass())){
            jLTotal.setText("Total mês: " + Utilidade.formatoValor.format(modulodu.calculaDespesaTotalImov(imovel, dt_inicio, dt_final)));
        }
    }
    
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifmodulodespesa = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if(validaCampos()){
            salvar();
            limpaCampos();
            tabelaDespesa(obj);
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        alterar();
        limpaCampos();
        tabelaDespesa(obj);
    }//GEN-LAST:event_jBAlterarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        excluir();
        limpaCampos();
        tabelaDespesa(obj);
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jCBModuloDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBModuloDespesaActionPerformed
        if(obj.getClass().equals(animal.getClass())){
            animal = (Animal)jCBModuloDespesa.getSelectedItem();
            jLTotal.setText("Total mês: " + Utilidade.formatoValor.format(modulodr.somaDespesa(animal)));
            tabelaDespesa(animal);
            jBSalvar.setEnabled(true);
        }
        if(obj.getClass().equals(veiculo.getClass())){
            veiculo = (Veiculo)jCBModuloDespesa.getSelectedItem();
            jLTotal.setText("Total mês: " + Utilidade.formatoValor.format(modulodr.somaDespesa(veiculo)));
            tabelaDespesa(veiculo);
            jBSalvar.setEnabled(true);
        }
        if(obj.getClass().equals(imovel.getClass())){
            imovel = (Imovel)jCBModuloDespesa.getSelectedItem();
            jLTotal.setText("Total mês: " + Utilidade.formatoValor.format(modulodr.somaDespesa(imovel)));
            tabelaDespesa(imovel);
            jBSalvar.setEnabled(true);
        }
    }//GEN-LAST:event_jCBModuloDespesaActionPerformed

    private void jCBPresservActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBPresservActionPerformed
        if(jCBPresserv.getSelectedIndex() != 0){
            presserv = (PrestadorServico)jCBPresserv.getSelectedItem();
        }else{
            presserv.setCd_presserv(0);
        }
    }//GEN-LAST:event_jCBPresservActionPerformed

    private void jCBProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBProdutoActionPerformed
        if(jCBProduto.getSelectedIndex() != 0){
            produto = (Produto)jCBProduto.getSelectedItem();            
            jTFDescricao.setText(produto.getDs_produto());
        }else{
            produto.setCd_produto(0);
        }        
    }//GEN-LAST:event_jCBProdutoActionPerformed

    private void jTDespesaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTDespesaMouseClicked
        if(obj.getClass().equals(animal.getClass())){
            animald = (AnimalDespesa)modulodu.getSelectObject(jTDespesa);
            jCBModuloDespesa.setSelectedItem(animald.getAnimal());
            if(animald.getPresserv() == null){
                jCBPresserv.setSelectedIndex(0);
            }else{
                jCBPresserv.getModel().setSelectedItem(animald.getPresserv());
            }
            jTFNota.setText(animald.getNm_nota());
            jFTFData.setText(Utilidade.formatoData.format(animald.getDt_despesa().getTime()));
            jFTFValor.setText(Utilidade.formatoValor.format(animald.getNm_valor()));
            jTFQtde.setText(Integer.toString(animald.getNm_qtde()));
            jTFDescricao.setText(animald.getDs_descricao());
            if(animald.getProduto() == null){
                jCBProduto.setSelectedIndex(0);
            }else{
                jCBProduto.setSelectedItem(animald.getProduto());
            }
        }
        if(obj.getClass().equals(veiculo.getClass())){
            veiculod = (VeiculoDespesa)modulodu.getSelectObject(jTDespesa);
            jCBModuloDespesa.setSelectedItem(veiculod.getVeiculo());
            if(veiculod.getPresserv() == null){
                jCBPresserv.setSelectedIndex(0);
            }else{
                jCBPresserv.setSelectedItem(veiculod.getPresserv());
            }
            jTFNota.setText(veiculod.getNm_nota());
            jFTFData.setText(Utilidade.formatoData.format(veiculod.getDt_despesa().getTime()));
            jFTFValor.setText(Utilidade.formatoValor.format(veiculod.getNm_valor()));
            jTFQtde.setText(Integer.toString(veiculod.getNm_qtde()));
            jTFDescricao.setText(veiculod.getDs_descricao());
        }        
        if(obj.getClass().equals(imovel.getClass())){
            imoveld = (ImovelDespesa)modulodu.getSelectObject(jTDespesa);
            jCBModuloDespesa.setSelectedItem(imoveld.getImovel());
            if(imoveld.getPresserv() == null){
                jCBPresserv.setSelectedIndex(0);
            }else{
                jCBPresserv.setSelectedItem(imoveld.getPresserv());
            }
            jTFNota.setText(imoveld.getNm_nota());
            jFTFData.setText(Utilidade.formatoData.format(imoveld.getDt_despesa().getTime()));
            jFTFValor.setText(Utilidade.formatoValor.format(imoveld.getNm_valor()));
            jTFQtde.setText(Integer.toString(imoveld.getNm_qtde()));
            jTFDescricao.setText(imoveld.getDs_descricao());
        }    
        calculaValor();
        ativaBotoes();
    }//GEN-LAST:event_jTDespesaMouseClicked

    private void jTFQtdeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFQtdeFocusLost
        if(!jFTFValor.getText().isEmpty() && !jTFQtde.getText().isEmpty()){
            calculaValor();
        }
    }//GEN-LAST:event_jTFQtdeFocusLost

    private void jBPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisarActionPerformed
        if(util.validaDataCampo(jFTFDataInicial.getText()) && util.validaDataCampo(jFTFDataFinal.getText())){
            if(obj.getClass().equals(animal.getClass())){
                modulodu.tabelaDespesaAnimal(jTDespesa, animal, jFTFDataInicial.getText(), jFTFDataFinal.getText());                
                calculaTotalMes(animal, jFTFDataInicial.getText(), jFTFDataFinal.getText());
            }
            if(obj.getClass().equals(veiculo.getClass())){
                modulodu.tabelaDespesaVeiculo(jTDespesa, veiculo, jFTFDataInicial.getText(), jFTFDataFinal.getText());
                calculaTotalMes(veiculo, jFTFDataInicial.getText(), jFTFDataFinal.getText());
            }
            if(obj.getClass().equals(imovel.getClass())){
                modulodu.tabelaDespesaImovel(jTDespesa, imovel, jFTFDataInicial.getText(), jFTFDataFinal.getText());
                calculaTotalMes(imovel, jFTFDataInicial.getText(), jFTFDataFinal.getText());                
            }
        }     
    }//GEN-LAST:event_jBPesquisarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBPesquisar;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<String> jCBModuloDespesa;
    private javax.swing.JComboBox<String> jCBPresserv;
    private javax.swing.JComboBox<String> jCBProduto;
    private javax.swing.JFormattedTextField jFTFData;
    private javax.swing.JFormattedTextField jFTFDataFinal;
    private javax.swing.JFormattedTextField jFTFDataInicial;
    private javax.swing.JFormattedTextField jFTFValor;
    private javax.swing.JLabel jLData;
    private javax.swing.JLabel jLDescricao;
    private javax.swing.JLabel jLNota;
    private javax.swing.JLabel jLNotaTotal;
    private javax.swing.JLabel jLQtde;
    private javax.swing.JLabel jLTotal;
    private javax.swing.JLabel jLValor;
    private javax.swing.JPanel jPBotoes;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JPanel jPGrid;
    private javax.swing.JPanel jPVeiculo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTDespesa;
    private javax.swing.JTextField jTFDescricao;
    private javax.swing.JTextField jTFNota;
    private javax.swing.JTextField jTFQtde;
    // End of variables declaration//GEN-END:variables
}
