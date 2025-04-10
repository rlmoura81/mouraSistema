package br.com.rlmoura81.moura.animalinterface;

import br.com.rlmoura81.moura.animal.Animal;
import br.com.rlmoura81.moura.animal.AnimalRepository;
import br.com.rlmoura81.moura.animal.AnimalUtil;
import br.com.rlmoura81.moura.animal.Raca;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import javax.swing.JOptionPane;

public class JIFAnimal extends javax.swing.JInternalFrame {
    
    private static JIFAnimal jifanimal;
    
    public static JIFAnimal getInstancia(){
        if(jifanimal == null){
            jifanimal = new JIFAnimal();
            jifanimal.setTitle("Animais");
        }return jifanimal;
    }
    
    Animal animal = new Animal();
    AnimalRepository animalr = new AnimalRepository();
    AnimalUtil animalu = new AnimalUtil();
    
    Raca raca = null;
    
    Utilidade util = new Utilidade();
    
    public JIFAnimal() {
        initComponents();
        
        formataData();
        animalu.jcRaca(jCBRaca);
        animalu.tabelaAnimal(jTAnimal);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPGrid = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAnimal = new javax.swing.JTable();
        jPCampos = new javax.swing.JPanel();
        jLNome = new javax.swing.JLabel();
        jTFNome = new javax.swing.JTextField();
        jLData = new javax.swing.JLabel();
        jFTFData = new javax.swing.JFormattedTextField();
        jCBRaca = new javax.swing.JComboBox<>();
        jLSexo = new javax.swing.JLabel();
        jCBSexo = new javax.swing.JComboBox<>();
        jPButoes = new javax.swing.JPanel();
        jBSalvar = new javax.swing.JButton();
        jBAlterar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();

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

        jPGrid.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTAnimal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTAnimal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTAnimalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTAnimal);

        javax.swing.GroupLayout jPGridLayout = new javax.swing.GroupLayout(jPGrid);
        jPGrid.setLayout(jPGridLayout);
        jPGridLayout.setHorizontalGroup(
            jPGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPGridLayout.setVerticalGroup(
            jPGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
        );

        jPCampos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLNome.setText("Nome:");

        jLData.setText("Data:");

        jCBRaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBRacaActionPerformed(evt);
            }
        });

        jLSexo.setText("Sexo:");

        jCBSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Selecionar>", "Feminino", "Masculino" }));
        jCBSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBSexoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPCamposLayout = new javax.swing.GroupLayout(jPCampos);
        jPCampos.setLayout(jPCamposLayout);
        jPCamposLayout.setHorizontalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLData, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLNome))
                .addGap(28, 28, 28)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTFNome)
                    .addComponent(jFTFData)
                    .addComponent(jCBRaca, 0, 158, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLSexo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCBSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPCamposLayout.setVerticalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNome)
                    .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLData)
                    .addComponent(jFTFData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLSexo)
                    .addComponent(jCBSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPButoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        javax.swing.GroupLayout jPButoesLayout = new javax.swing.GroupLayout(jPButoes);
        jPButoes.setLayout(jPButoesLayout);
        jPButoesLayout.setHorizontalGroup(
            jPButoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPButoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBExcluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPButoesLayout.setVerticalGroup(
            jPButoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPButoesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPButoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalvar)
                    .addComponent(jBAlterar)
                    .addComponent(jBExcluir))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPButoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPGrid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPButoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void formataData(){
        util.formataDataCampo(jFTFData);        
    }
   
    private boolean validaCampos(){
        if(jTFNome.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo vazio.", "Animal", JOptionPane.INFORMATION_MESSAGE);
            jTFNome.requestFocus();
            return false;
        }
        if(util.validaDataCampo(jFTFData.getText()) == false){
            jFTFData.requestFocus();
            return false;
        }
        if(raca == null){
            JOptionPane.showMessageDialog(null, "Selecione a raça.", "Raça", JOptionPane.INFORMATION_MESSAGE);
            jCBRaca.requestFocus();
            return false;
        }
        if(jCBSexo.getSelectedItem().equals("<Selecionar>")){
            JOptionPane.showMessageDialog(null, "Selecione o sexo.", "Animal", JOptionPane.INFORMATION_MESSAGE);
            jCBSexo.requestFocus();
            return false;
        }
        return true;
    }
    
    private void limpaCampos(){
        jTFNome.setText(null);
        jFTFData.setText(null);
        jCBSexo.setSelectedIndex(0);
        jCBRaca.setSelectedIndex(0);
    }
    
    private void salvar() {
        animal.setDs_nome(jTFNome.getText());
        animal.setDt_nasc(util.recebeData(jFTFData.getText()));
        animal.setRaca(raca);
        animal.setCd_usuario(JPLogin.codloginuser);
        animalr.inserir(animal);
    }
    
    private void alterar(){
        animal.setDs_nome(jTFNome.getText());
        animal.setDt_nasc(util.recebeData(jFTFData.getText()));
        animal.setRaca(raca);
        animal.setCd_usuario(JPLogin.codloginuser);
        animalr.alterar(animal);
    }
    
    private void excluir(){
        animal.setCd_animal(animal.getCd_animal());
        animalr.excluir(animal);
    }
    
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifanimal = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if(validaCampos()){
            salvar();
            limpaCampos();
            animalu.tabelaAnimal(jTAnimal);
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jTAnimalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTAnimalMouseClicked
        animal = (Animal)animalu.getSelectObject(jTAnimal);
        jTFNome.setText(animal.getDs_nome());
        jFTFData.setText(Utilidade.formatoData.format(animal.getDt_nasc().getTime()));        
        jCBSexo.setSelectedItem(animal.getDs_sexo());
        jCBRaca.setSelectedItem(animal.getRaca());
    }//GEN-LAST:event_jTAnimalMouseClicked

    private void jCBRacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBRacaActionPerformed
        if(jCBRaca.getSelectedIndex() != 0){
            raca = (Raca) jCBRaca.getSelectedItem();            
        }else{
            raca = null;
        }
    }//GEN-LAST:event_jCBRacaActionPerformed

    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        animal = (Animal)animalu.getSelectObject(jTAnimal);
        if(animal != null){
            alterar();
            limpaCampos();
            animalu.tabelaAnimal(jTAnimal);            
        }
    }//GEN-LAST:event_jBAlterarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        animal = (Animal)animalu.getSelectObject(jTAnimal);
        if(animal != null){
            excluir();
            limpaCampos();
            animalu.tabelaAnimal(jTAnimal);            
        }
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jCBSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBSexoActionPerformed
        animal.setDs_sexo(jCBSexo.getSelectedItem().toString());
    }//GEN-LAST:event_jCBSexoActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<Raca> jCBRaca;
    private javax.swing.JComboBox<String> jCBSexo;
    private javax.swing.JFormattedTextField jFTFData;
    private javax.swing.JLabel jLData;
    private javax.swing.JLabel jLNome;
    private javax.swing.JLabel jLSexo;
    private javax.swing.JPanel jPButoes;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JPanel jPGrid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTAnimal;
    private javax.swing.JTextField jTFNome;
    // End of variables declaration//GEN-END:variables
}
