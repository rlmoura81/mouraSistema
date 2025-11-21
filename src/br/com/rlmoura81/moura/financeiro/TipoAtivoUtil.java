package br.com.rlmoura81.moura.financeiro;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JList;

public class TipoAtivoUtil {
    
    TipoAtivoRepository tpativor = new TipoAtivoRepository();    

    /*
    * EM TESTE - COLOCAR COMENTARIO
    * DEFAULTCOMBOBOXMODEL - STATUS PAGAMENTO
    */
    private void jcModelTipoAtivo(JComboBox<TipoAtivo> o){
        o.setRenderer(new DefaultListCellRenderer(){
                @Override
                public Component getListCellRendererComponent(
                    JList<?> list, 
                    Object value,
                    int index,
                    boolean isSelected,
                    boolean cellHasFocus){
                    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    if(value instanceof TipoAtivo){
                        TipoAtivo tpa = (TipoAtivo) value;
                        if(tpa.getCd_tpativo()== 0){
                            setText("<Selecione>");
                        }else if(tpa.getDs_tpativo()!= null){
                            setText(tpa.getDs_tpativo());
                        }else{
                            setText("Sem Tipo Ativo");
                        }
                    }else{
                        setText("");
                    }
                return this;
            }
        });
    }
    
    /**
     * <p><strong>EN:</strong> Populates a JComboBox with all asset types.</p>
     * <p><strong>IT:</strong> Popola un JComboBox con tutti i tipi di attivo.</p>
     * <p><strong>PT-BR:</strong> Preenche um JComboBox com todos os tipos de ativo.</p>
     *
     * @param o EN: JComboBox to populate | IT: JComboBox da popolare | PT-BR: JComboBox a ser preenchido
     * @since 1.0.0
     */    
    public void jcTipoAtivo(JComboBox<TipoAtivo> o){
        List<TipoAtivo> lista = tpativor.getLista();
        DefaultComboBoxModel<TipoAtivo> model = new DefaultComboBoxModel<>();
        model.addElement(new TipoAtivo(0, null));
        if(lista != null && !lista.isEmpty()){
            for(TipoAtivo tpativo : lista){
                model.addElement(tpativo);
            }    
        }
        o.setModel(model);
        jcModelTipoAtivo(o);
    }

    /**
     * <p><strong>EN:</strong> Populates a JComboBox with stock and REIT asset types (Ação/FII).</p>
     * <p><strong>IT:</strong> Popola un JComboBox con i tipi di attivo azionari e fondi immobiliari (Azione/FII).</p>
     * <p><strong>PT-BR:</strong> Preenche um JComboBox com os tipos de ativo Ação e FII.</p>
     *
     * @param o EN: JComboBox to populate | IT: JComboBox da popolare | PT-BR: JComboBox a ser preenchido
     * @since 1.0.0
     */
    public void jcTipoAtivoAcaoFii(JComboBox<TipoAtivo> o){
        List<TipoAtivo> lista = tpativor.getListaTipoAtivoAcaoFII();
        DefaultComboBoxModel<TipoAtivo> model = new DefaultComboBoxModel<>();
        model.addElement(new TipoAtivo(0, null));
        if(lista != null && !lista.isEmpty()){
            for(TipoAtivo tpativo : lista){
                model.addElement(tpativo);
            }
        }
        o.setModel(model);
        jcModelTipoAtivo(o);
    }
    
    /**
     * <p><strong>EN:</strong> Populates a JComboBox with fixed-income asset types (Renda Fixa).</p>
     * <p><strong>IT:</strong> Popola un JComboBox con i tipi di attivo a reddito fisso (Renda Fixa).</p>
     * <p><strong>PT-BR:</strong> Preenche um JComboBox com os tipos de ativo de Renda Fixa.</p>
     *
     * @param o EN: JComboBox to populate | IT: JComboBox da popolare | PT-BR: JComboBox a ser preenchido
     * @since 1.0.0
     */
    public void jcTipoAtivoRendaFixa(JComboBox o){
        ArrayList<TipoAtivo> lista = tpativor.getListaTipoRendaFixa();
        DefaultComboBoxModel<TipoAtivo> model = new DefaultComboBoxModel<>();
        model.addElement(new TipoAtivo(0, null));
        if(lista != null && !lista.isEmpty()){
            for(TipoAtivo tpa : lista){
                model.addElement(tpa);
            }
        }
        o.setModel(model);
        jcModelTipoAtivo(o);
    }
}
