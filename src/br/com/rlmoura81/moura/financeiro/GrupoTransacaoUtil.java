package br.com.rlmoura81.moura.financeiro;

import java.awt.Component;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JList;

public class GrupoTransacaoUtil {
    
    GrupoTransacaoRepository gptransr = new GrupoTransacaoRepository();
    
    /*
    * EM TESTE - COLOCAR COMENTARIO
    * DEFAULTCOMBOBOXMODEL - GRUPO TRANSACAO
    */
    private void jcModelGpTransacao(JComboBox<GrupoTransacao> o){
        o.setRenderer(new DefaultListCellRenderer(){
                @Override
                public Component getListCellRendererComponent(
                    JList<?> list, 
                    Object value,
                    int index,
                    boolean isSelected,
                    boolean cellHasFocus){
                    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    if(value instanceof GrupoTransacao){
                        GrupoTransacao gt = (GrupoTransacao) value;
                        if(gt.getCd_gptrans()== 0){
                            setText("<Selecione>");
                        }else if(gt.getDs_gptrans()!= null){
                            setText(gt.getDs_gptrans());
                        }else{
                            setText("Sem Grupo");
                        }
                    }else{
                        setText("");
                    }
                return this;
            }
        });
    }
    
    /**
     * <p><strong>EN:</strong> Populates a JComboBox with purchase and sale transaction groups.</p>
     *
     * <p><strong>IT:</strong> Popola un JComboBox con i gruppi di transazione di acquisto e vendita.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche um JComboBox com os grupos de transação de compra e venda.</p>
     *
     * @param o EN: JComboBox to be populated | IT: JComboBox da popolare | PT-BR: JComboBox a ser preenchido
     * @since 1.0.0
     */    
    public void jcGpTransacao(JComboBox<GrupoTransacao> o){
        List<GrupoTransacao> lista = gptransr.getListaCompraVenda();
        DefaultComboBoxModel<GrupoTransacao>model = new DefaultComboBoxModel<>();
        model.addElement(new GrupoTransacao(0, null));
        if(lista != null && !lista.isEmpty()){
            for(GrupoTransacao gptrans : lista){
                model.addElement(gptrans);
            }            
        }
        o.setModel(model);
        jcModelGpTransacao(o);
    }
    
}
