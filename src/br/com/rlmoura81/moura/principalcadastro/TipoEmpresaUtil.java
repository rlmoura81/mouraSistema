package br.com.rlmoura81.moura.principalcadastro;

import java.awt.Component;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JList;

public class TipoEmpresaUtil {    
    TipoEmpresaRepository tpempresar = new TipoEmpresaRepository();
    
    /*
    *EM TESTE - COLOCAR COMENTARIO
    *DEFAULTCOMBOBOXMODEL - TIPO DE EMPRESA
    */
    public void jcModelTpEmpresa(JComboBox<TipoEmpresa> o){
        o.setRenderer(new DefaultListCellRenderer(){
                @Override
                public Component getListCellRendererComponent(
                    JList<?> list, 
                    Object value,
                    int index,
                    boolean isSelected,
                    boolean cellHasFocus){
                    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    if(value instanceof TipoEmpresa){
                        TipoEmpresa tpemp = (TipoEmpresa) value;
                        if(tpemp.getCd_tpempresa() == 0){
                            setText("<Selecione>");
                        }else if(tpemp.getDs_tpempresa() != null){
                            setText(tpemp.getDs_tpempresa());
                        }else{
                            setText("Tipo Empresa");
                        }
                    }else{
                        setText("");
                    }
                return this;
            }
        });
    }
    
    /*
    *EM TESTE - COLOCAR COMENTARIO
    *JCOMBOBOX - TIPO EMPRESA
    */
    
    public void jcTpEmpresa(JComboBox<TipoEmpresa> o){
        List<TipoEmpresa> lista = tpempresar.getLista();
        DefaultComboBoxModel<TipoEmpresa> model = new DefaultComboBoxModel<>();
        model.addElement(new TipoEmpresa(0, null));
        if(lista != null && !lista.isEmpty()){
            for(TipoEmpresa tpempresa : lista){
                model.addElement(tpempresa);
            }            
        }
        o.setModel(model);
        jcModelTpEmpresa(o);
    }
}
