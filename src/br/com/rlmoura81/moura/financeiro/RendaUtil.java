package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.awt.Component;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RendaUtil {
    
    Renda renda = new Renda();
    RendaRepository rendar = new RendaRepository();    
    ArrayList lista = new ArrayList();
    
    /**
     * <p><strong>EN:</strong> Calculates the total amount of all income records.</p>
     * <p><strong>IT:</strong> Calcola l'importo totale di tutti i record di reddito.</p>
     * <p><strong>PT-BR:</strong> Calcula o valor total de todas as rendas.</p>
     *
     * @return EN: total income as BigDecimal | IT: totale del reddito come BigDecimal | PT-BR: total de rendas como BigDecimal
     * @since 1.0.0
     */
    public BigDecimal calculaRendaTotal(){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = rendar.getLista();
        for(int i=0; i < lista.size(); i++){
            renda = (Renda)lista.get(i);
            resultado = resultado.add(renda.getNm_valor());
        }
        return resultado;
    }
    
    /**
     * <p><strong>EN:</strong> Calculates the total proceeds by multiplying the unit proceeds by the quantity.</p>
     * <p><strong>IT:</strong> Calcola il provento totale moltiplicando il provento unitario per la quantità.</p>
     * <p><strong>PT-BR:</strong> Calcula o provento total multiplicando o provento unitário pela quantidade.</p>
     *
     * @param nm_qtde EN: quantity of units | IT: quantità di unità | PT-BR: quantidade de unidades
     * @param vl_provento EN: unit proceeds value | IT: valore del provento unitario | PT-BR: valor do provento unitário
     * @return EN: total proceeds amount | IT: importo totale dei proventi | PT-BR: valor total do provento
     * @since 1.0.0
     */
    public BigDecimal calculaProventoTotal(int nm_qtde, BigDecimal vl_provento){
        BigDecimal resultado = Utilidade.converter("0,00");
        resultado = vl_provento.multiply(BigDecimal.valueOf(nm_qtde));
        return resultado;
    }

    /*
    * EM TESTE - COLOCAR COMENTARIO
    * DEFAULTCOMBOBOXMODEL - RENDA
    */
    private void jcModelRenda(JComboBox<Renda> o){
        o.setRenderer(new DefaultListCellRenderer(){
                @Override
                public Component getListCellRendererComponent(
                    JList<?> list, 
                    Object value,
                    int index,
                    boolean isSelected,
                    boolean cellHasFocus){
                    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    if(value instanceof Renda){
                        Renda r = (Renda) value;
                        if(r.getCd_renda()== 0){
                            setText("<Selecione>");
                        }else if(r.getDs_renda()!= null){
                            setText(r.getDs_renda());
                        }else{
                            setText("Sem renda");
                        }
                    }else{
                        setText("");
                    }
                return this;
            }
        });
    }
    
    /**
     * <p><strong>EN:</strong> Populates a combo box with all income records, adding a default placeholder first.</p>
     * <p><strong>IT:</strong> Popola una combo box con tutti i record di reddito, aggiungendo prima un segnaposto predefinito.</p>
     * <p><strong>PT-BR:</strong> Preenche um combo box com todas as rendas, adicionando primeiro um item padrão.</p>
     *
     * @param o EN: target combo box to populate | IT: combo box di destinazione da popolare | PT-BR: combo box de destino a ser preenchido
     * @since 1.0.0
     */
    public void jcRenda(JComboBox<Renda> o){
        ArrayList<Renda> lista = rendar.getLista();
        DefaultComboBoxModel<Renda> model = new DefaultComboBoxModel<>();
        model.addElement(new Renda(0, null, "<Renda>", null, null, 0));
        if(lista != null && !lista.isEmpty()){
            for(Renda renda : lista){
                model.addElement(renda);
            }
        } 
        o.setModel(model);
        jcModelRenda(o);
    }    

    /**
     * <p><strong>EN:</strong> Populates a combo box with income records filtered by a date range, adding a default placeholder first.</p>
     * <p><strong>IT:</strong> Popola una combo box con i record di reddito filtrati per intervallo di date, aggiungendo prima un segnaposto predefinito.</p>
     * <p><strong>PT-BR:</strong> Preenche um combo box com rendas filtradas por intervalo de datas, adicionando primeiro um item padrão.</p>
     *
     * @param o EN: target combo box to populate | IT: combo box di destinazione da popolare | PT-BR: combo box de destino a ser preenchido
     * @param dtInicial EN: start date (inclusive) | IT: data iniziale (inclusiva) | PT-BR: data inicial (inclusiva)
     * @param dtFinal EN: end date (inclusive) | IT: data finale (inclusiva) | PT-BR: data final (inclusiva)
     * @since 1.0.0
     */
    public void jcRendaMes(JComboBox<Renda> o, Object dtInicial, Object dtFinal){
        ArrayList<Renda> lista = rendar.getLista(dtInicial, dtFinal);
        DefaultComboBoxModel<Renda> model = new DefaultComboBoxModel<>();
        model.addElement(new Renda(0, null, "<Renda>", null, null, 0));
        if(lista != null && !lista.isEmpty()){
            for(Renda renda : lista){
                model.addElement(renda);
            }            
        }
        o.setModel(model);
        jcModelRenda(o);
    } 
    
    /**
     * <p><strong>EN:</strong> Builds and applies a table model with all income records.</p>
     * <p><strong>IT:</strong> Crea e applica un modello di tabella con tutti i record di reddito.</p>
     * <p><strong>PT-BR:</strong> Monta e aplica um modelo de tabela com todas as rendas.</p>
     *
     * @param o EN: target table to receive the model | IT: tabella di destinazione che riceve il modello | PT-BR: tabela de destino que receberá o modelo
     * @since 1.0.0
     */
    public void tabelaRenda(JTable o) {
        String[] nomeColuna = {"Data", "Despesa", "Valor", "Tipo"};
        lista = rendar.getLista();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        for (int i = 0; i < lista.size(); i++) {
            renda = (Renda) lista.get(i);
            dadosArray[i][0] = Utilidade.formatoData.format(renda.getDt_renda().getTime());
            dadosArray[i][1] = renda.getDs_renda();
            dadosArray[i][2] = Utilidade.formatoValor.format(renda.getNm_valor());
            dadosArray[i][3] = renda.getTprenda().getDs_tprenda();
        }
        DefaultTableModel tRenda = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tRenda);
    }
    
    /**
     * <p><strong>EN:</strong> Builds and applies a table model with income records filtered by income type.</p>
     * <p><strong>IT:</strong> Crea e applica un modello di tabella con i record di reddito filtrati per tipo.</p>
     * <p><strong>PT-BR:</strong> Monta e aplica um modelo de tabela com rendas filtradas por tipo.</p>
     *
     * @param o EN: target table to receive the model | IT: tabella di destinazione che riceve il modello | PT-BR: tabela de destino que receberá o modelo
     * @param num EN: income type ID filter | IT: ID del tipo di reddito | PT-BR: ID do tipo de renda
     * @since 1.0.0
     */
    public void tabelaRendaFiltro(JTable o, int num) {
        String[] nomeColuna = {"Data", "Despesa", "Valor", "Tipo"};
        lista = rendar.getLista(num);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        for (int i = 0; i < lista.size(); i++) {
            renda = (Renda) lista.get(i);
            dadosArray[i][0] = Utilidade.formatoData.format(renda.getDt_renda().getTime());
            dadosArray[i][1] = renda.getDs_renda();
            dadosArray[i][2] = Utilidade.formatoValor.format(renda.getNm_valor());
            dadosArray[i][3] = renda.getTprenda().getDs_tprenda();
        }
        DefaultTableModel tRenda = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tRenda);
    }
    
    /**
     * <p><strong>EN:</strong> Returns the object associated with the currently selected table row.</p>
     * <p><strong>IT:</strong> Restituisce l'oggetto associato alla riga attualmente selezionata della tabella.</p>
     * <p><strong>PT-BR:</strong> Retorna o objeto associado à linha atualmente selecionada na tabela.</p>
     *
     * @param o EN: source table from which to read the selected row | IT: tabella sorgente da cui leggere la riga selezionata | PT-BR: tabela de origem da qual ler a linha selecionada
     * @return EN: selected domain object, or null if nothing is selected | IT: oggetto di dominio selezionato, o null se nulla è selezionato | PT-BR: objeto de domínio selecionado, ou null se nada estiver selecionado
     * @since 1.0.0
     */
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecianda = o.getSelectedRow();
        if(linhaselecianda >= 0) {
            selecionado = lista.get(linhaselecianda);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma renda da lista.");
        }
        return selecionado;
    }
}
