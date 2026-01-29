package br.com.rlmoura81.moura.principalcadastro;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EmpresaUtil {
    
    Empresa empresa = new Empresa();
    EmpresaRepository empresar = new EmpresaRepository();    
    ArrayList lista = new ArrayList();
    
    /*
    *EM TESTE - COLOCAR COMENTARIO
    *DEFAULTCOMBOBOXMODEL - EMPRESA
    */
    private void jcModelEmpresa(JComboBox<Empresa> o){
        o.setRenderer(new DefaultListCellRenderer(){
                @Override
                public Component getListCellRendererComponent(
                    JList<?> list, 
                    Object value,
                    int index,
                    boolean isSelected,
                    boolean cellHasFocus){
                    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    if(value instanceof Empresa){
                        Empresa emp = (Empresa) value;
                        if(emp.getCd_empresa()== 0){
                            setText("<Selecione>");
                        }else if(emp.getDs_empresa()!= null){
                            setText(emp.getDs_empresa());
                        }else{
                            setText("Empresa");
                        }
                    }else{
                        setText("");
                    }
                return this;
            }
        });
    }

    /**
     * <p><strong>EN:</strong> Populates a {@code JComboBox} with the list of Service Providers,
     * adding a default placeholder entry ("&lt;Prestador&gt;") at the first position.</p>
     *
     * <p><strong>IT:</strong> Popola un {@code JComboBox} con l’elenco dei Fornitori di Servizi,
     * aggiungendo una voce predefinita ("&lt;Prestador&gt;") come prima posizione.</p>
     * <p><strong>PT-BR:</strong> Preenche um {@code JComboBox} com a lista de Prestadores de Serviço,
     * adicionando uma entrada padrão ("&lt;Prestador&gt;") na primeira posição.</p>
     * @param o
     */
    public void jcEmpresa(JComboBox<Empresa> o) {
        List<Empresa> lista = empresar.getLista(); 
        DefaultComboBoxModel<Empresa> model = new DefaultComboBoxModel<>();
        model.addElement(new Empresa(0, null, null, null, null, 0));
        if(lista !=  null && !lista.isEmpty()){
            for (Empresa emp : lista) {
                model.addElement(emp);
            }            
        }
        o.setModel(model);
        jcModelEmpresa(o);
    }
    
    /**
     * <p><strong>EN:</strong> Populates a {@code JComboBox} with Service Providers filtered by a Module ID,
     * adding a default placeholder entry ("&lt;Prestador&gt;").</p>
     *
     * <p><strong>IT:</strong> Popola un {@code JComboBox} con i Fornitori di Servizi filtrati per ID Modulo,
     * aggiungendo una voce predefinita ("&lt;Prestador&gt;").</p>
     *
     * <p><strong>PT-BR:</strong> Preenche um {@code JComboBox} com Prestadores de Serviço filtrados por ID de Módulo,
     * adicionando uma entrada padrão ("&lt;Prestador&gt;").</p>
     */
        public void jcEmpresa(JComboBox<Empresa> o, int cd_modulo) {
        List<Empresa> lista = empresar.getLista(cd_modulo); 
        DefaultComboBoxModel<Empresa> model = new DefaultComboBoxModel<>();
        model.addElement(new Empresa(0, null, null, null, null, 0));
        if(lista !=  null && !lista.isEmpty()){
            for (Empresa emp : lista) {
                model.addElement(emp);
            }            
        }
        o.setModel(model);
        jcModelEmpresa(o);
    }
    
    /**
     * <p><strong>EN:</strong> Builds a table model for a {@code JTable} containing
     * Service Providers, showing Trade Name, Corporate Name, and formatted Document.</p>
     *
     * <p><strong>IT:</strong> Crea un modello di tabella per un {@code JTable} contenente
     * i Fornitori di Servizi, mostrando Nome/Fantasia, Ragione Sociale e Documento formattato.</p>
     *
     * <p><strong>PT-BR:</strong> Monta um modelo de tabela para um {@code JTable} contendo
     * Prestadores de Serviço, exibindo Nome/Nome Fantasia, Razão Social e Documento formatado.</p>
     */
    public void tabelaEmpresa(JTable o){
        String[] nomeColuna = {"Nome/Nome Fantasia","Razao Social" , "Documento", "Tipo"};
        lista = empresar.getLista();
        Object [][] dadosArray = new Object[lista.size()][nomeColuna.length];
        for(int i = 0; i < lista.size(); i++){
            empresa = (Empresa) lista.get(i);
            dadosArray[i][0] = empresa.getDs_empresa();
            dadosArray[i][1] = empresa.getDs_razaosocial();
            dadosArray[i][2] = Utilidade.retornaDocumentoFormatado(empresa.getNm_documento(), empresa.getNm_documento().length());
            dadosArray[i][3] = empresa.getTpEmpresa().getDs_tpempresa();
        }
        DefaultTableModel tEmpresa = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tEmpresa);
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves the object corresponding to the currently
     * selected row in the {@code JTable}, or prompts the user if none is selected.</p>
     *
     * <p><strong>IT:</strong> Recupera l’oggetto corrispondente alla riga attualmente
     * selezionata nel {@code JTable}, oppure mostra un avviso se nessuna è selezionata.</p>
     *
     * <p><strong>PT-BR:</strong> Retorna o objeto correspondente à linha atualmente
     * selecionada no {@code JTable}, ou exibe um aviso se nenhuma estiver selecionada.</p>
     */
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma empresa da lista.", "Empresa", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;    
    }
}
