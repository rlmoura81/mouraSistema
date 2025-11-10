package br.com.rlmoura81.moura.financeiro;

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

public class AtivoUtil {
    
    TipoAtivoRepository tpativor = new TipoAtivoRepository();    
    Ativo ativo = new Ativo();
    AtivoRepository ativor = new AtivoRepository();    
    AcaoProvento acaoprov = new AcaoProvento();
    AcaoProventoRepository acaoprovr = new AcaoProventoRepository();    
    FundoImobiliarioProvento fip = new FundoImobiliarioProvento();
    FundoImobiliarioProventoRepository fipr = new FundoImobiliarioProventoRepository();    
    ArrayList lista = new ArrayList();
    
        /*
    * EM TESTE - COLOCAR COMENTARIO
    * DEFAULTCOMBOBOXMODEL - ATIVO
    */
    public void jcModelAtivo(JComboBox<Ativo> o){
        o.setRenderer(new DefaultListCellRenderer(){
                @Override
                public Component getListCellRendererComponent(
                    JList<?> list, 
                    Object value,
                    int index,
                    boolean isSelected,
                    boolean cellHasFocus){
                    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    if(value instanceof Ativo){
                        Ativo at = (Ativo) value;
                        if(at.getCd_ativo()== 0){
                            setText("<Selecione>");
                        }else if(at.getDs_sgativo()!= null){
                            setText(at.getDs_sgativo());
                        }else{
                            setText("Sem ativo");
                        }
                    }else{
                        setText("");
                    }
                return this;
            }
        });
    }
    
    /**
     * <p><strong>EN:</strong> Populates a JComboBox with stock assets (Ações): adds a placeholder and all items from the repository.</p>
     * <p><strong>IT:</strong> Popola un JComboBox con le azioni: aggiunge un segnaposto e tutti gli elementi dal repository.</p>
     * <p><strong>PT-BR:</strong> Preenche um JComboBox com ações: adiciona um placeholder e todos os itens do repositório.</p>
     *
     * @param o EN: target JComboBox | IT: JComboBox di destinazione | PT-BR: JComboBox de destino
     */
    public void jcAcao(JComboBox<Ativo> o){
        List<Ativo> lista = ativor.getListaAcao();
        DefaultComboBoxModel<Ativo> model = new DefaultComboBoxModel<>();
        model.addElement(new Ativo(0, null, null, null, null, 0));
        if(lista != null && !lista.isEmpty()){
            for(Ativo ativo : lista){
                model.addElement(ativo);
            }            
        }
        o.setModel(model);
        jcModelAtivo(o);
    }
    
    /**
     * <p><strong>EN:</strong> Populates a JComboBox with stock assets that currently have balance.</p>
     * <p><strong>IT:</strong> Popola un JComboBox con le azioni che hanno saldo disponibile.</p>
     * <p><strong>PT-BR:</strong> Preenche um JComboBox com ações que possuem saldo.</p>
     *
     * @param o EN: target JComboBox | IT: JComboBox di destinazione | PT-BR: JComboBox de destino
     */
    public void jcAcaoSaldo(JComboBox<Ativo> o){
        ArrayList<Ativo> lista = ativor.getListaAcaoSaldo();
        DefaultComboBoxModel<Ativo> model = new DefaultComboBoxModel<>();
        model.addElement(new Ativo(0, null, null, null, null, 0));
        if(lista != null && !lista.isEmpty()){
            for(Ativo ativo : lista){
                model.addElement(ativo);
            }            
        }
        o.setModel(model);
        jcModelAtivo(o);
    }
    
    /**
     * <p><strong>EN:</strong> Populates a JComboBox with stocks filtered by corporate action type (provento).</p>
     * <p><strong>IT:</strong> Popola un JComboBox con azioni filtrate per tipo di provento.</p>
     * <p><strong>PT-BR:</strong> Preenche um JComboBox com ações filtradas pelo tipo de provento.</p>
     *
     * @param o EN: target JComboBox | IT: JComboBox di destinazione | PT-BR: JComboBox de destino
     * @param num EN: benefit type ID (provento) | IT: ID del tipo di provento | PT-BR: ID do tipo de provento
     */
    public void jcAcaoProv(JComboBox o, int num){
        ArrayList<Ativo> lista = ativor.getListaAcaoProv(num);
        DefaultComboBoxModel<Ativo> model = new DefaultComboBoxModel<>();
        model.addElement(new Ativo(0, null, null, null, null, 0));
        if(lista != null && !lista.isEmpty()){
            for(Ativo ativo : lista){
                model.addElement(ativo);
            }            
        }
        o.setModel(model);
        jcModelAtivo(o);
    }
    
    /**
     * <p><strong>EN:</strong> Populates a JComboBox with stocks that have balance and match the given corporate action type.</p>
     * <p><strong>IT:</strong> Popola un JComboBox con azioni con saldo che corrispondono al tipo di provento indicato.</p>
     * <p><strong>PT-BR:</strong> Preenche um JComboBox com ações com saldo que correspondem ao tipo de provento informado.</p>
     *
     * @param o EN: target JComboBox | IT: JComboBox di destinazione | PT-BR: JComboBox de destino
     * @param num EN: benefit type ID (provento) | IT: ID del tipo di provento | PT-BR: ID do tipo de provento
     */
    public void jcAcaoSaldoTpProv(JComboBox o, int num){
        ArrayList<Ativo> lista = ativor.getListaAcaoSaldoTpProv(num);
        DefaultComboBoxModel<Ativo> model = new DefaultComboBoxModel<>();
        model.addElement(new Ativo(0, null, null, null, null, 0));
        if(lista != null && !lista.isEmpty()){
            for(Ativo ativo : lista){
                model.addElement(ativo);
            }            
        }
        o.setModel(model);
        jcModelAtivo(o);
    }
    
    /**
     * <p><strong>EN:</strong> Populates a JComboBox with real estate funds (FII): adds a placeholder and all repository items.</p>
     * <p><strong>IT:</strong> Popola un JComboBox con i fondi immobiliari (FII): aggiunge un segnaposto e tutti gli elementi dal repository.</p>
     * <p><strong>PT-BR:</strong> Preenche um JComboBox com FIIs: adiciona um placeholder e todos os itens do repositório.</p>
     *
     * @param o EN: target JComboBox | IT: JComboBox di destinazione | PT-BR: JComboBox de destino
     */
    public void jcFundoImobiiario(JComboBox<Ativo> o){
        ArrayList<Ativo> lista = ativor.getListaFII();
        DefaultComboBoxModel<Ativo> model = new DefaultComboBoxModel<>();
        model.addElement(new Ativo(0, null, null, null, null, 0));
        if(lista != null && !lista.isEmpty()){
            for(Ativo ativo : lista){
                model.addElement(ativo);
            }            
        }
        o.setModel(model);
        jcModelAtivo(o);
    }
    
    /**
     * <p><strong>EN:</strong> Populates a JComboBox with FIIs that currently have balance.</p>
     * <p><strong>IT:</strong> Popola un JComboBox con FII che hanno saldo disponibile.</p>
     * <p><strong>PT-BR:</strong> Preenche um JComboBox com FIIs que possuem saldo.</p>
     *
     * @param o EN: target JComboBox | IT: JComboBox di destinazione | PT-BR: JComboBox de destino
     */
    public void jcFundoImobiiarioSaldo(JComboBox o){
        ArrayList<Ativo> lista = ativor.getListaFIISaldo();
        DefaultComboBoxModel<Ativo> model = new DefaultComboBoxModel<>();
        model.addElement(new Ativo(0, null, null, null, null, 0));
        if(lista != null && !lista.isEmpty()){
            for(Ativo ativo : lista){
                model.addElement(ativo);
            }            
        }
        o.setModel(model);
        jcModelAtivo(o);
    }

    /**
     * <p><strong>EN:</strong> Populates a JComboBox with FIIs filtered by benefit type (provento).</p>
     * <p><strong>IT:</strong> Popola un JComboBox con FII filtrati per tipo di provento.</p>
     * <p><strong>PT-BR:</strong> Preenche um JComboBox com FIIs filtrados por tipo de provento.</p>
     *
     * @param o EN: target JComboBox | IT: JComboBox di destinazione | PT-BR: JComboBox de destino
     * @param num EN: benefit type ID (provento) | IT: ID del tipo di provento | PT-BR: ID do tipo de provento
     */
    public void jcFundoImobiiarioProv(JComboBox o, int num){
        ArrayList<Ativo> lista = ativor.getListaFIIProv(num);
        DefaultComboBoxModel<Ativo> model = new DefaultComboBoxModel<>();
        model.addElement(new Ativo(0, null, null, null, null, 0));
        if(lista != null && !lista.isEmpty()){
            for(Ativo ativo : lista){
                model.addElement(ativo);
            }            
        }
        o.setModel(model);
        jcModelAtivo(o);
    }
    
    /**
     * <p><strong>EN:</strong> Populates a JComboBox with FIIs that have balance and match the given benefit type.</p>
     * <p><strong>IT:</strong> Popola un JComboBox con FII con saldo che corrispondono al tipo di provento indicato.</p>
     * <p><strong>PT-BR:</strong> Preenche um JComboBox com FIIs com saldo que correspondem ao tipo de provento informado.</p>
     *
     * @param o EN: target JComboBox | IT: JComboBox di destinazione | PT-BR: JComboBox de destino
     * @param num EN: benefit type ID (provento) | IT: ID del tipo di provento | PT-BR: ID do tipo de provento
     */
    public void jcFundoImobiiarioSaldoTpProv(JComboBox o, int num){
        ArrayList<Ativo> lista = ativor.getListaFIISaldoTpProv(num);
        DefaultComboBoxModel<Ativo> model = new DefaultComboBoxModel<>();
        model.addElement(new Ativo(0, null, null, null, null, 0));
        if(lista != null && !lista.isEmpty()){
            for(Ativo ativo : lista){
                model.addElement(ativo);
            }            
        }
        o.setModel(model);
        jcModelAtivo(o);
    }
    
    /**
     * <p><strong>EN:</strong> Populates a JComboBox with fixed-income asset types.</p>
     * <p><strong>IT:</strong> Popola un JComboBox con i tipi di attivo a reddito fisso.</p>
     * <p><strong>PT-BR:</strong> Preenche um JComboBox com tipos de ativos de renda fixa.</p>
     *
     * @param o EN: target JComboBox | IT: JComboBox di destinazione | PT-BR: JComboBox de destino
     */    
    public void jcAtivoRendaFixa(JComboBox o){
        ArrayList<Ativo> lista = ativor.getLista();
        DefaultComboBoxModel<Ativo> model = new DefaultComboBoxModel<>();
        model.addElement(new Ativo(0, null, null, null, null, 0));
        if(lista != null && !lista.isEmpty()){
            for(Ativo ativo : lista){
                model.addElement(ativo);
            }            
        }
        o.setModel(model);
        jcModelAtivo(o);
    }
    
    /**
     * <p><strong>EN:</strong> Fills a JTable with assets (columns: Ticker, Asset, CNPJ, Type) using repository data.</p>
     * <p><strong>IT:</strong> Popola una JTable con gli attivi (colonne: Ticker, Attivo, CNPJ, Tipo) usando i dati del repository.</p>
     * <p><strong>PT-BR:</strong> Preenche uma JTable com ativos (colunas: Sigla, Ativo, CNPJ, Tipo) usando dados do repositório.</p>
     *
     * @param o EN: target JTable | IT: JTable di destinazione | PT-BR: JTable de destino
     */    
    public void tabelaAtivo(JTable o){
        String[] nomeColuna = {"Sigla", "Ativo", "CNPJ", "Tipo"};
        lista = ativor.getLista();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for(int i = 0; i < lista.size(); i++){
            ativo = (Ativo) lista.get(i);
            dadosArray[i][0] = ativo.getDs_sgativo();
            dadosArray[i][1] = ativo.getDs_ativo();
            dadosArray[i][2] = ativo.getNm_cnpj();
            dadosArray[i][3] = ativo.getTpativo().getDs_tpativo();
        }
        DefaultTableModel tAtivo = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tAtivo);
    }
    
    /**
     * <p><strong>EN:</strong> Fills a JTable with stock corporate actions (proventos).
     * Columns: Stock, Payment Date, Benefit Value, Base Price Date, Base Price Value, Benefit Type.</p>
     * <p><strong>IT:</strong> Popola una JTable con i proventi azionari.
     * Colonne: Azione, Data Pagamento, Valore Provento, Data Prezzo Base, Valore Prezzo Base, Tipo Provento.</p>
     * <p><strong>PT-BR:</strong> Preenche uma JTable com proventos de ações.
     * Colunas: Ação, Data Pagamento, Valor Provento, Data Preço Base, Valor Preço Base, Tipo Provento.</p>
     *
     * @param o EN: target JTable | IT: JTable di destinazione | PT-BR: JTable de destino
     */    
    public void tabelaAcaoProv(JTable o){
        String[] nomeColuna = {"Ação", "Data Pagamento", "Valor Provento", "Data Preço Base", "Valor Preço Base", "Provento"};
        lista = acaoprovr.getLista();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for(int i=0; i < lista.size(); i++){
            acaoprov = (AcaoProvento)lista.get(i);
            dadosArray[i][0] = acaoprov.getAtivo().getDs_sgativo();
            dadosArray[i][1] = Utilidade.formatoData.format(acaoprov.getDt_pagamento().getTime());
            dadosArray[i][2] = Utilidade.formatoValor.format(acaoprov.getVl_provento());
            dadosArray[i][3] = Utilidade.formatoData.format(acaoprov.getDt_precobase().getTime());
            dadosArray[i][4] = Utilidade.formatoValor.format(acaoprov.getVl_database());
            dadosArray[i][5] = acaoprov.getTpprovento().getDs_tpprovento();
        }        
        DefaultTableModel tAcaoprov = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tAcaoprov);
    }        
    
    /**
     * <p><strong>EN:</strong> Fills a JTable with FII corporate actions (proventos).
     * Columns: FII, Payment Date, Benefit Value, Base Price Date, Base Price Value.</p>
     * <p><strong>IT:</strong> Popola una JTable con i proventi dei FII.
     * Colonne: FII, Data Pagamento, Valore Provento, Data Prezzo Base, Valore Prezzo Base.</p>
     * <p><strong>PT-BR:</strong> Preenche uma JTable com proventos de FIIs.
     * Colunas: FII, Data Pagamento, Valor Provento, Data Preço Base, Valor Preço Base.</p>
     *
     * @param o EN: target JTable | IT: JTable di destinazione | PT-BR: JTable de destino
     */
    public void tabelaFiProv(JTable o){
        String[] nomeColuna = {"FII", "Data Pagamento", "Valor Provento", "Data Preço Base", "Valor Preço Base"};
        lista = fipr.getLista();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for(int i=0; i < lista.size(); i++){
            fip = (FundoImobiliarioProvento)lista.get(i);
            dadosArray[i][0] = fip.getAtivo().getDs_sgativo();
            dadosArray[i][1] = Utilidade.formatoData.format(fip.getDt_pagamento().getTime());
            dadosArray[i][2] = Utilidade.formatoValor.format(fip.getVl_provento());
            dadosArray[i][3] = Utilidade.formatoData.format(fip.getDt_precobase().getTime());
            dadosArray[i][4] = Utilidade.formatoValor.format(fip.getVl_database());
        }        
        DefaultTableModel tFiprov = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tFiprov);
    }

    /**
     * <p><strong>EN:</strong> Returns the object mapped to the selected row in the JTable,
     * or shows an information message if no row is selected.</p>
     * <p><strong>IT:</strong> Restituisce l’oggetto mappato alla riga selezionata nella JTable,
     * oppure mostra un messaggio informativo se nessuna riga è selezionata.</p>
     * <p><strong>PT-BR:</strong> Retorna o objeto mapeado para a linha selecionada na JTable,
     * ou exibe uma mensagem informativa se nenhuma linha estiver selecionada.</p>
     *
     * @param o EN: JTable to read selection from | IT: JTable da cui leggere la selezione | PT-BR: JTable da qual ler a seleção
     * @return EN: selected item or null | IT: elemento selezionato o null | PT-BR: item selecionado ou null
     */
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um intem da lista.");
        }
        return selecionado;    
    }      
}
