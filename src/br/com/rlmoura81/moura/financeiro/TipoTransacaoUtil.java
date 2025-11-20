package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principalcadastro.Categoria;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JList;

public class TipoTransacaoUtil {
    
    TipoTransacaoRepository tptransr = new TipoTransacaoRepository();    

        /*
    * EM TESTE - COLOCAR COMENTARIO
    * DEFAULTCOMBOBOXMODEL - TIPO TRANSACAO
    */
    private void jcModelTipoTransacao(JComboBox<TipoTransacao> o){
        o.setRenderer(new DefaultListCellRenderer(){
                @Override
                public Component getListCellRendererComponent(
                    JList<?> list, 
                    Object value,
                    int index,
                    boolean isSelected,
                    boolean cellHasFocus){
                    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    if(value instanceof TipoTransacao){
                        TipoTransacao tt = (TipoTransacao) value;
                        if(tt.getCd_tptrans()== 0){
                            setText("<Selecione>");
                        }else if(tt.getDs_tptrans()!= null){
                            setText(tt.getDs_tptrans());
                        }else{
                            setText("Sem Tipo de Transacao");
                        }
                    }else{
                        setText("");
                    }
                return this;
            }
        });
    }
    
    /**
     * <p><strong>EN:</strong> Populates a JComboBox with the complete list of transaction types (TipoTransacao).</p>
     * <p><strong>IT:</strong> Popola un JComboBox con l'elenco completo dei tipi di transazione (TipoTransacao).</p>
     * <p><strong>PT-BR:</strong> Preenche um JComboBox com a lista completa de tipos de transação (TipoTransacao).</p>
     *
     * @param o EN: JComboBox to populate |
     *          IT: JComboBox da popolare |
     *          PT-BR: JComboBox a ser preenchido
     */
    public void jcTpTransacao(JComboBox<TipoTransacao> o){
        ArrayList<TipoTransacao> lista = tptransr.getLista();
        DefaultComboBoxModel<TipoTransacao> model = new DefaultComboBoxModel<>();
        model.addElement(new TipoTransacao(0, "<Transação>", null));
        if(lista != null && !lista.isEmpty()){
            for(TipoTransacao tpt : lista){
                model.addElement(tpt);
            }            
        }
        o.setModel(model);
        jcModelTipoTransacao(o);
    }

    /**
     * <p><strong>EN:</strong> Populates a JComboBox with transaction types (TipoTransacao) filtered by a specific transaction group.</p>
     * <p><strong>IT:</strong> Popola un JComboBox con i tipi di transazione (TipoTransacao) filtrati per un gruppo di transazioni specifico.</p>
     * <p><strong>PT-BR:</strong> Preenche um JComboBox com os tipos de transação (TipoTransacao) filtrados por um grupo específico de transações.</p>
     *
     * @param o EN: JComboBox to populate |
     *          IT: JComboBox da popolare |
     *          PT-BR: JComboBox a ser preenchido
     *
     * @param cd_gptrans EN: Transaction group ID used as filter |
     *                   IT: ID del gruppo di transazioni usato come filtro |
     *                   PT-BR: ID do grupo de transações usado como filtro
     */
    public void jcTpTransCredDeb(JComboBox<TipoTransacao> o, int cd_gptrans){
        ArrayList<TipoTransacao> lista = tptransr.getLista(cd_gptrans);
        DefaultComboBoxModel<TipoTransacao> model = new DefaultComboBoxModel<>();
        model.addElement(new TipoTransacao(0, "<Transação>", null));
        if(lista != null && !lista.isEmpty()){
            for(TipoTransacao tpt : lista){
                model.addElement(tpt);
            }            
        }
        o.setModel(model);
        jcModelTipoTransacao(o);
    }    
}
