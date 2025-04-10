package br.com.rlmoura81.moura.principalcadastrointerface;

import br.com.rlmoura81.moura.principalcadastro.Categoria;
import br.com.rlmoura81.moura.principalcadastro.CategoriaRepository;
import br.com.rlmoura81.moura.principalcadastro.CategoriaUtil;
import br.com.rlmoura81.moura.principalcadastro.Grupo;
import br.com.rlmoura81.moura.principalcadastro.GrupoUtil;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import javax.swing.JOptionPane;

public class JIFCategoria extends javax.swing.JInternalFrame {
    
    private static JIFCategoria jifcategoria;
    
    public static JIFCategoria getInstancia(){
        if (jifcategoria == null){
            jifcategoria = new JIFCategoria();
            jifcategoria.setTitle("Categorias");
        } return jifcategoria;
    }
    
    Categoria categoria = null;
    CategoriaRepository categoriar = new CategoriaRepository();
    CategoriaUtil categoriau = new CategoriaUtil();
    
    Grupo grupo = null;
    GrupoUtil grupou = new GrupoUtil();
    
    public JIFCategoria() {
        initComponents();

        jTFCategoria.requestFocus();       
        tabelaCategoria();
        
        grupou.jcGrupo(jCBGrupo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPGrid = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTCategoria = new javax.swing.JTable();
        jPCampos = new javax.swing.JPanel();
        jBSalvar = new javax.swing.JButton();
        jBAlterar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jTFCategoria = new javax.swing.JTextField();
        jLCategoria = new javax.swing.JLabel();
        jCBGrupo = new javax.swing.JComboBox<>();

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

        jPGrid.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTCategoriaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTCategoria);

        javax.swing.GroupLayout jPGridLayout = new javax.swing.GroupLayout(jPGrid);
        jPGrid.setLayout(jPGridLayout);
        jPGridLayout.setHorizontalGroup(
            jPGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPGridLayout.setVerticalGroup(
            jPGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPCampos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        jLCategoria.setText("Descrição da Categoria:");

        jCBGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBGrupoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPCamposLayout = new javax.swing.GroupLayout(jPCampos);
        jPCampos.setLayout(jPCamposLayout);
        jPCamposLayout.setHorizontalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addComponent(jBSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBExcluir))
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addComponent(jTFCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLCategoria))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPCamposLayout.setVerticalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalvar)
                    .addComponent(jBAlterar)
                    .addComponent(jBExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void limpaCampos(){
        jTFCategoria.setText(null);
        jCBGrupo.setSelectedIndex(0);
        jTFCategoria.requestFocus();
    }
    
    public boolean validaCampos(){
        if (jTFCategoria.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Campo em branco.", "Categoria", JOptionPane.INFORMATION_MESSAGE);
                jTFCategoria.requestFocus();
            return false;
        }
        return true;
    }
    
    private void tabelaCategoria() {
        categoriau.tabelaCategoria(jTCategoria);
    }    
    
    private void salvar(){
        categoria.setDs_Categoria(jTFCategoria.getText());
        categoria.setCd_usuario(JPLogin.codloginuser);
        categoria.setGrupo(grupo);
        categoriar.inserir(categoria);    
        categoria = null;
    }
    
    private void alterar(){
        categoria.setDs_Categoria(jTFCategoria.getText());
        categoria.setGrupo(grupo);
        categoria.setCd_usuario(JPLogin.codloginuser);
        categoriar.aterar(categoria);
        categoria = null;
    }
    
    private void excluir(){
        categoria.setCd_Categoria(categoria.getCd_Categoria());
        categoriar.excluir(categoria);
        categoria = null;
    }
    
    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if (validaCampos()) {
            salvar();
            limpaCampos();
            tabelaCategoria();
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jTCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTCategoriaMouseClicked
        categoria = (Categoria)categoriau.getSelectObject(jTCategoria);
        jTFCategoria.setText(categoria.getDs_Categoria());
        if(categoria.getGrupo() == null){
            jCBGrupo.setSelectedIndex(0);
        }else{
            jCBGrupo.getModel().setSelectedItem(categoria.getGrupo());
        }       
    }//GEN-LAST:event_jTCategoriaMouseClicked
    
    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        categoria = (Categoria)categoriau.getSelectObject(jTCategoria);
        if(categoria != null){
           alterar();
           limpaCampos();
           tabelaCategoria();
        }
    }//GEN-LAST:event_jBAlterarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        categoria = (Categoria)categoriau.getSelectObject(jTCategoria);
        if(categoria != null){
            excluir();
            limpaCampos();
            tabelaCategoria();
        }
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifcategoria = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jCBGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBGrupoActionPerformed
        if(jCBGrupo.getSelectedIndex() != 0){
            grupo = (Grupo)jCBGrupo.getSelectedItem();
        }else{
            grupo = null;
        }
    }//GEN-LAST:event_jCBGrupoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<String> jCBGrupo;
    private javax.swing.JLabel jLCategoria;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JPanel jPGrid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTCategoria;
    private javax.swing.JTextField jTFCategoria;
    // End of variables declaration//GEN-END:variables
}
