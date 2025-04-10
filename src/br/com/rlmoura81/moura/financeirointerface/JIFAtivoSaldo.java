package br.com.rlmoura81.moura.financeirointerface;

import br.com.rlmoura81.moura.financeiro.AtivoSaldoUtil;

public class JIFAtivoSaldo extends javax.swing.JInternalFrame {

    private static JIFAtivoSaldo jifativosaldo;
    
    public static int tpativo;
    
    public static JIFAtivoSaldo getInstancia(int num){
        if(jifativosaldo == null | num == 0 ){
            JIFAtivoSaldo.tpativo = 1;  
            jifativosaldo = new JIFAtivoSaldo();
            jifativosaldo.setTitle("Saldo de ativos - Ação");          
        }
        if(jifativosaldo == null | num == 1 ){
            JIFAtivoSaldo.tpativo = 2;
            jifativosaldo = new JIFAtivoSaldo();
            jifativosaldo.setTitle("Saldo de ativos - FII");
        }return jifativosaldo;
    }
    
    AtivoSaldoUtil asaldou = new AtivoSaldoUtil();
        
    public JIFAtivoSaldo() {
        initComponents();
        
        tabelaAtivoSaldo();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPGrid = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAtivoSaldo = new javax.swing.JTable();

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

        jPGrid.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTAtivoSaldo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTAtivoSaldo);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifativosaldo = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void tabelaAtivoSaldo(){
        asaldou.tabelaAtivoSaldo(jTAtivoSaldo, tpativo); 
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPGrid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTAtivoSaldo;
    // End of variables declaration//GEN-END:variables

}
