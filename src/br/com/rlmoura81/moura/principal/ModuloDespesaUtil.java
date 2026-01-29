package br.com.rlmoura81.moura.principal;

import br.com.rlmoura81.moura.animal.Animal;
import br.com.rlmoura81.moura.animal.AnimalDespesa;
import br.com.rlmoura81.moura.imovel.Imovel;
import br.com.rlmoura81.moura.imovel.ImovelDespesa;
import br.com.rlmoura81.moura.utilidade.CalculoFinanceiro;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import br.com.rlmoura81.moura.veiculo.Veiculo;
import br.com.rlmoura81.moura.veiculo.VeiculoDespesa;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ModuloDespesaUtil {

    ModuloDespesaRepository mdr = new ModuloDespesaRepository();    
    AnimalDespesa adespesa = new AnimalDespesa();
    VeiculoDespesa vdespesa = new VeiculoDespesa();
    ImovelDespesa idespesa = new ImovelDespesa();    
    ArrayList lista = new ArrayList();        
    CalculoFinanceiro cf = new CalculoFinanceiro();
    
    /**
     * <p><strong>EN:</strong> Calculates the total Animal expenses for the current month.
     * Iterates over fetched Animal expenses and sums (value × quantity).</p>
     *
     * <p><strong>IT:</strong> Calcola il totale delle spese dell’Animale per il mese corrente.
     * Scorre le spese recuperate e somma (valore × quantità).</p>
     *
     * <p><strong>PT-BR:</strong> Calcula o total de despesas do Animal no mês atual.
     * Percorre as despesas buscadas e soma (valor × quantidade).</p>
     */
    public BigDecimal calculaDespesaTotalAni(Animal a){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = mdr.getListaAnimalDespesa(a);
        for(int i=0; i < lista.size(); i++){
            adespesa = (AnimalDespesa)lista.get(i);
            resultado = resultado.add(cf.calculoValorQtde(adespesa.getNm_valor(), adespesa.getNm_qtde()));
        }
        return resultado;
    }
    
    /**
     * <p><strong>EN:</strong> Calculates the total Animal expenses within a custom date range.
     * Loads expenses for the given Animal between the provided dates and sums (value × quantity).</p>
     *
     * <p><strong>IT:</strong> Calcola il totale delle spese dell’Animale in un intervallo di date.
     * Carica le spese dell’Animale tra le date fornite e somma (valore × quantità).</p>
     *
     * <p><strong>PT-BR:</strong> Calcula o total de despesas do Animal em um intervalo de datas.
     * Carrega as despesas do Animal entre as datas informadas e soma (valor × quantidade).</p>
     */
    public BigDecimal calculaDespesaTotalAni(Animal a, String dt_inicio, String dt_final){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = mdr.getListaAnimalDespesa(a, dt_inicio, dt_final);
        for(int i=0; i < lista.size(); i++){
            adespesa = (AnimalDespesa)lista.get(i);
            resultado = resultado.add(cf.calculoValorQtde(adespesa.getNm_valor(), adespesa.getNm_qtde()));
        }
        return resultado;
    }
    
    /**
     * <p><strong>EN:</strong> Calculates the total Vehicle expenses for the current month.
     * Iterates over Vehicle expenses and sums (value × quantity).</p>
     *
     * <p><strong>IT:</strong> Calcola il totale delle spese del Veicolo per il mese corrente.
     * Scorre le spese del Veicolo e somma (valore × quantità).</p>
     *
     * <p><strong>PT-BR:</strong> Calcula o total de despesas do Veículo no mês atual.
     * Percorre as despesas do Veículo e soma (valor × quantidade).</p>
     */
    public BigDecimal calculaDespesaTotalVeic(Veiculo v){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = mdr.getListaVeiculoDespesa(v);
        for(int i=0; i < lista.size(); i++){
            vdespesa = (VeiculoDespesa)lista.get(i);
            resultado = resultado.add(cf.calculoValorQtde(vdespesa.getNm_valor(), vdespesa.getNm_qtde()));
        }
        return resultado;
    } 
    
    /**
     * <p><strong>EN:</strong> Calculates the total Vehicle expenses within a custom date range.
     * Loads Vehicle expenses between start/end dates and sums (value × quantity).</p>
     *
     * <p><strong>IT:</strong> Calcola il totale delle spese del Veicolo in un intervallo di date.
     * Carica le spese tra data iniziale/finale e somma (valore × quantità).</p>
     *
     * <p><strong>PT-BR:</strong> Calcula o total de despesas do Veículo em um intervalo de datas.
     * Carrega as despesas entre as datas inicial/final e soma (valor × quantidade).</p>
     */
    public BigDecimal calculaDespesaTotalVeic(Veiculo v, String dt_inicio, String dt_final){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = mdr.getListaVeiculoDespesa(v, dt_inicio, dt_final);
        for(int i=0; i < lista.size(); i++){
            vdespesa = (VeiculoDespesa)lista.get(i);
            resultado = resultado.add(cf.calculoValorQtde(vdespesa.getNm_valor(), vdespesa.getNm_qtde()));
        }
        return resultado;
    } 

    /**
     * <p><strong>EN:</strong> Calculates the total Property (Real Estate) expenses for the current month.
     * Iterates over Property expenses and sums (value × quantity).</p>
     *
     * <p><strong>IT:</strong> Calcola il totale delle spese dell’Immobile per il mese corrente.
     * Scorre le spese e somma (valore × quantità).</p>
     *
     * <p><strong>PT-BR:</strong> Calcula o total de despesas do Imóvel no mês atual.
     * Percorre as despesas e soma (valor × quantidade).</p>
     */
    public BigDecimal calculaDespesaTotalImov(Imovel im){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = mdr.getListaImovelDespesa(im);
        for(int i=0; i < lista.size(); i++){
            idespesa = (ImovelDespesa)lista.get(i);
            resultado = resultado.add(cf.calculoValorQtde(idespesa.getNm_valor(), idespesa.getNm_qtde()));
        }
        return resultado;
    }     
    
    /**
     * <p><strong>EN:</strong> Calculates the total Property expenses within a custom date range.
     * Retrieves Property expenses between the provided dates and sums (value × quantity).</p>
     *
     * <p><strong>IT:</strong> Calcola il totale delle spese dell’Immobile in un intervallo di date.
     * Recupera le spese tra le date fornite e somma (valore × quantità).</p>
     *
     * <p><strong>PT-BR:</strong> Calcula o total de despesas do Imóvel em um intervalo de datas.
     * Recupera as despesas entre as datas informadas e soma (valor × quantidade).</p>
     */
    public BigDecimal calculaDespesaTotalImov(Imovel im, String dt_inicio, String dt_final){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = mdr.getListaImovelDespesa(im, dt_inicio, dt_final);
        for(int i=0; i < lista.size(); i++){
            idespesa = (ImovelDespesa)lista.get(i);
            resultado = resultado.add(cf.calculoValorQtde(idespesa.getNm_valor(), idespesa.getNm_qtde()));
        }
        return resultado;
    }     
    
    /**
     * <p><strong>EN:</strong> Populates a table with Animal expenses for the current month.
     * Formats date, unit value, and total (value × quantity), including Provider and Product.</p>
     *
     * <p><strong>IT:</strong> Compila una tabella con le spese dell’Animale del mese corrente.
     * Formattta data, valore unitario e totale (valore × quantità), includendo Fornitore e Prodotto.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche uma tabela com as despesas do Animal no mês atual.
     * Formata data, valor unitário e total (valor × quantidade), incluindo Prestador e Produto.</p>
     */
    public void tabelaDespesaAnimal(JTable o, Animal a){
        String[] nomeColuna = {"Data", "Nota", "Descrição", "Valor", "Qtde", "Total", "Empresa", "Produto"};
        lista = mdr.getListaAnimalDespesa(a);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for(int i=0; i < lista.size(); i++){
            adespesa = (AnimalDespesa)lista.get(i);
            dadosArray[i][0] = Utilidade.formatoData.format(adespesa.getDt_despesa().getTime());
            dadosArray[i][1] = adespesa.getNm_nota();
            dadosArray[i][2] = adespesa.getDs_descricao();
            dadosArray[i][3] = Utilidade.formatoValor.format(adespesa.getNm_valor());
            dadosArray[i][4] = adespesa.getNm_qtde();
            dadosArray[i][5] = Utilidade.formatoValor.format(cf.calculoValorQtde(adespesa.getNm_valor(), adespesa.getNm_qtde()));
            dadosArray[i][6] = adespesa.getEmpresa().getDs_empresa();
            dadosArray[i][7] = adespesa.getProduto();
        }        
        DefaultTableModel tAnimalDesp = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tAnimalDesp);
    }    

    /**
     * <p><strong>EN:</strong> Populates a table with Animal expenses filtered by date range.
     * Shows date, note, description, unit value, quantity, total, Provider, and Product.</p>
     *
     * <p><strong>IT:</strong> Compila una tabella con le spese dell’Animale filtrate per intervallo date.
     * Mostra data, nota, descrizione, valore, quantità, totale, Fornitore e Prodotto.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche uma tabela com as despesas do Animal por intervalo de datas.
     * Exibe data, nota, descrição, valor, quantidade, total, Prestador e Produto.</p>
     */
    public void tabelaDespesaAnimal(JTable o, Animal a, String dt_inicio, String dt_final){
        String[] nomeColuna = {"Data", "Nota", "Descrição", "Valor", "Qtde", "Total", "Empresa", "Produto"};
        lista = mdr.getListaAnimalDespesa(a, dt_inicio, dt_final);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for(int i=0; i < lista.size(); i++){
            adespesa = (AnimalDespesa)lista.get(i);
            dadosArray[i][0] = Utilidade.formatoData.format(adespesa.getDt_despesa().getTime());
            dadosArray[i][1] = adespesa.getNm_nota();
            dadosArray[i][2] = adespesa.getDs_descricao();
            dadosArray[i][3] = Utilidade.formatoValor.format(adespesa.getNm_valor());
            dadosArray[i][4] = adespesa.getNm_qtde();
            dadosArray[i][5] = Utilidade.formatoValor.format(cf.calculoValorQtde(adespesa.getNm_valor(), adespesa.getNm_qtde()));
            dadosArray[i][6] = adespesa.getEmpresa().getDs_empresa();
            dadosArray[i][7] = adespesa.getProduto();
        }        
        DefaultTableModel tAnimalDesp = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tAnimalDesp);
    }  
    
    /**
     * <p><strong>EN:</strong> Populates a table with Vehicle expenses for the current month.
     * Displays date, note, description, unit value, quantity, total, and Provider.</p>
     *
     * <p><strong>IT:</strong> Compila una tabella con le spese del Veicolo del mese corrente.
     * Mostra data, nota, descrizione, valore, quantità, totale e Fornitore.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche uma tabela com as despesas do Veículo no mês atual.
     * Exibe data, nota, descrição, valor, quantidade, total e Prestador.</p>
     */
    public void tabelaDespesaVeiculo(JTable o, Veiculo v){
        String[] nomeColuna = {"Data", "Nota", "Descrição", "Valor", "Qtde", "Total", "Empresa"};
        lista = mdr.getListaVeiculoDespesa(v);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for(int i=0; i < lista.size(); i++){
            vdespesa = (VeiculoDespesa)lista.get(i);
            dadosArray[i][0] = Utilidade.formatoData.format(vdespesa.getDt_despesa().getTime());
            dadosArray[i][1] = vdespesa.getNm_nota();
            dadosArray[i][2] = vdespesa.getDs_descricao();
            dadosArray[i][3] = Utilidade.formatoValor.format(vdespesa.getNm_valor());
            dadosArray[i][4] = vdespesa.getNm_qtde();
            dadosArray[i][5] = Utilidade.formatoValor.format(cf.calculoValorQtde(vdespesa.getNm_valor(), vdespesa.getNm_qtde()));
            dadosArray[i][6] = vdespesa.getEmpresa().getDs_empresa();
        }        
        DefaultTableModel tVeiculoDesp = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tVeiculoDesp);
    }    

    /**
     * <p><strong>EN:</strong> Populates a table with Vehicle expenses filtered by date range.
     * Displays date, note, description, unit value, quantity, total, and Provider.</p>
     *
     * <p><strong>IT:</strong> Compila una tabella con le spese del Veicolo per intervallo di date.
     * Mostra data, nota, descrizione, valore, quantità, totale e Fornitore.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche uma tabela com as despesas do Veículo por intervalo de datas.
     * Exibe data, nota, descrição, valor, quantidade, total e Prestador.</p>
     */
    public void tabelaDespesaVeiculo(JTable o, Veiculo v, String dt_inicio, String dt_final){
        String[] nomeColuna = {"Data", "Nota", "Descrição", "Valor", "Qtde", "Total", "Empresa"};
        lista = mdr.getListaVeiculoDespesa(v, dt_inicio, dt_final);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for(int i=0; i < lista.size(); i++){
            vdespesa = (VeiculoDespesa)lista.get(i);
            dadosArray[i][0] = Utilidade.formatoData.format(vdespesa.getDt_despesa().getTime());
            dadosArray[i][1] = vdespesa.getNm_nota();
            dadosArray[i][2] = vdespesa.getDs_descricao();
            dadosArray[i][3] = Utilidade.formatoValor.format(vdespesa.getNm_valor());
            dadosArray[i][4] = vdespesa.getNm_qtde();
            dadosArray[i][5] = Utilidade.formatoValor.format(cf.calculoValorQtde(vdespesa.getNm_valor(), vdespesa.getNm_qtde()));
            dadosArray[i][6] = vdespesa.getEmpresa();
        }        
        DefaultTableModel tVeiculoDesp = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tVeiculoDesp);
    } 
    
    /**
     * <p><strong>EN:</strong> Populates a table with Property (Real Estate) expenses for the current month.
     * Shows date, note, description, unit value, quantity, and Provider.</p>
     *
     * <p><strong>IT:</strong> Compila una tabella con le spese dell’Immobile del mese corrente.
     * Mostra data, nota, descrizione, valore, quantità e Fornitore.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche uma tabela com as despesas do Imóvel no mês atual.
     * Exibe data, nota, descrição, valor, quantidade e Prestador.</p>
     */
    public void tabelaDespesaImovel(JTable o, Imovel im){
        String[] nomeColuna = {"Data", "Nota", "Descrição", "Valor", "Qtde", "Empresa"};
        lista = mdr.getListaImovelDespesa(im);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for(int i=0; i < lista.size(); i++){
            idespesa = (ImovelDespesa)lista.get(i);
            dadosArray[i][0] = Utilidade.formatoData.format(idespesa.getDt_despesa().getTime());
            dadosArray[i][1] = idespesa.getNm_nota();
            dadosArray[i][2] = idespesa.getDs_descricao();
            dadosArray[i][3] = Utilidade.formatoValor.format(idespesa.getNm_valor());
            dadosArray[i][4] = idespesa.getNm_qtde();
            dadosArray[i][5] = idespesa.getEmpresa();
        }
        DefaultTableModel tImovelDesp = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tImovelDesp);
    }   
    
    /**
     * <p><strong>EN:</strong> Populates a table with Property expenses filtered by date range.
     * Shows date, note, description, unit value, quantity, and Provider.</p>
     *
     * <p><strong>IT:</strong> Compila una tabella con le spese dell’Immobile per intervallo di date.
     * Mostra data, nota, descrizione, valore, quantità e Fornitore.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche uma tabela com as despesas do Imóvel por intervalo de datas.
     * Exibe data, nota, descrição, valor, quantidade e Prestador.</p>
     */
    public void tabelaDespesaImovel(JTable o, Imovel im, String dt_inicio, String dt_final){
        String[] nomeColuna = {"Data", "Nota", "Descrição", "Valor", "Qtde", "Empresa"};
        lista = mdr.getListaImovelDespesa(im, dt_inicio, dt_final);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for(int i=0; i < lista.size(); i++){
            idespesa = (ImovelDespesa)lista.get(i);
            dadosArray[i][0] = Utilidade.formatoData.format(idespesa.getDt_despesa().getTime());
            dadosArray[i][1] = idespesa.getNm_nota();
            dadosArray[i][2] = idespesa.getDs_descricao();
            dadosArray[i][3] = Utilidade.formatoValor.format(idespesa.getNm_valor());
            dadosArray[i][4] = idespesa.getNm_qtde();
            dadosArray[i][5] = idespesa.getEmpresa();
        }
        DefaultTableModel tImovelDesp = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tImovelDesp);
    }       
    
    /**
     * <p><strong>EN:</strong> Returns the currently selected list item from the table.
     * If no row is selected, shows an informational dialog instructing the user to select an item.</p>
     *
     * <p><strong>IT:</strong> Restituisce l’elemento selezionato nella tabella.
     * Se nessuna riga è selezionata, mostra un messaggio informativo per selezionare un elemento.</p>
     *
     * <p><strong>PT-BR:</strong> Retorna o item selecionado na tabela.
     * Se nenhuma linha estiver selecionada, exibe uma mensagem informativa solicitando a seleção.</p>
     */
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma despesa da lista.", "Modulo Despesa", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;
    } 
}
