package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principalcadastro.Categoria;
import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MovimentoCaixaUtil {
    
    MovimentoCaixa movcx = new MovimentoCaixa();
    MovimentoCaixaRepository movcxr = new MovimentoCaixaRepository();    
    ArrayList lista = new ArrayList();

    /**
     * <p><strong>EN:</strong> Sums all credits for the current month of the given account.</p>
     *
     * <p><strong>IT:</strong> Somma tutti i crediti del mese corrente per il conto indicato.</p>
     *
     * <p><strong>PT-BR:</strong> Soma todos os créditos do mês corrente da conta informada.</p>
     *
     * @param cd_conta EN: account ID | IT: ID del conto | PT-BR: ID da conta
     * @return EN: total credit amount (BigDecimal) | IT: importo totale dei crediti (BigDecimal) | PT-BR: valor total de créditos (BigDecimal)
     * @since 1.0.0
     */
    public BigDecimal somaCredito(int cd_conta){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = movcxr.getListaMes(cd_conta);
        for(int i=0; i < lista.size(); i++){
            movcx = (MovimentoCaixa)lista.get(i);
            resultado = resultado.add(movcx.getVl_credito());
        }
        return resultado;
    }
    
    /**
     * <p><strong>EN:</strong> Sums all credits of the given account within a date range.</p>
     *
     * <p><strong>IT:</strong> Somma tutti i crediti del conto indicato in un intervallo di date.</p>
     *
     * <p><strong>PT-BR:</strong> Soma todos os créditos da conta informada em um período.</p>
     *
     * @param cd_conta EN: account ID | IT: ID del conto | PT-BR: ID da conta
     * @param dt_inicio EN: start date (dd/MM/yyyy) | IT: data di inizio (dd/MM/yyyy) | PT-BR: data inicial (dd/MM/yyyy)
     * @param dt_final EN: end date (dd/MM/yyyy) | IT: data di fine (dd/MM/yyyy) | PT-BR: data final (dd/MM/yyyy)
     * @return EN: total credit amount (BigDecimal) | IT: importo totale dei crediti (BigDecimal) | PT-BR: valor total de créditos (BigDecimal)
     * @since 1.0.0
     */
    public BigDecimal somaCredito(int cd_conta, String dt_inicio, String dt_final){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = movcxr.getLista(cd_conta, dt_inicio, dt_final);
        for(int i=0; i < lista.size(); i++){
            movcx = (MovimentoCaixa)lista.get(i);
            resultado = resultado.add(movcx.getVl_credito());
        }
        return resultado;
    }

    /**
     * <p><strong>EN:</strong> Sums all debits for the current month of the given account.</p>
     *
     * <p><strong>IT:</strong> Somma tutti i debiti del mese corrente per il conto indicato.</p>
     *
     * <p><strong>PT-BR:</strong> Soma todos os débitos do mês corrente da conta informada.</p>
     *
     * @param cd_conta EN: account ID | IT: ID del conto | PT-BR: ID da conta
     * @return EN: total debit amount (BigDecimal) | IT: importo totale dei debiti (BigDecimal) | PT-BR: valor total de débitos (BigDecimal)
     * @since 1.0.0
     */
    public BigDecimal somaDebito(int cd_conta){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = movcxr.getListaMes(cd_conta);
        for(int i=0; i < lista.size(); i++){
            movcx = (MovimentoCaixa)lista.get(i);
            resultado = resultado.add(movcx.getVl_debito());
        }
        return resultado;
    }
    
    /**
     * <p><strong>EN:</strong> Sums all debits of the given account within a date range.</p>
     *
     * <p><strong>IT:</strong> Somma tutti i debiti del conto indicato in un intervallo di date.</p>
     *
     * <p><strong>PT-BR:</strong> Soma todos os débitos da conta informada em um período.</p>
     *
     * @param cd_conta EN: account ID | IT: ID del conto | PT-BR: ID da conta
     * @param dt_inicio EN: start date (dd/MM/yyyy) | IT: data di inizio (dd/MM/yyyy) | PT-BR: data inicial (dd/MM/yyyy)
     * @param dt_final EN: end date (dd/MM/yyyy) | IT: data di fine (dd/MM/yyyy) | PT-BR: data final (dd/MM/yyyy)
     * @return EN: total debit amount (BigDecimal) | IT: importo totale dei debiti (BigDecimal) | PT-BR: valor total de débitos (BigDecimal)
     * @since 1.0.0
     */
    public BigDecimal somaDebito(int cd_conta, String dt_inicio, String dt_final){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = movcxr.getLista(cd_conta, dt_inicio, dt_final);
        for(int i=0; i < lista.size(); i++){
            movcx = (MovimentoCaixa)lista.get(i);
            resultado = resultado.add(movcx.getVl_debito());
        }
        return resultado;
    }
    
    /**
     * EM TESTE - ADICIONAR COMENTARIO
     * TRATA O A TEBELA DO MOVIMENTO CAIXA QUANDO A CATEGORIA E NULA
     * @param o
     * @return 
     */
    private String categoriaTrativaTabela(Object o){
        MovimentoCaixa mc = (MovimentoCaixa) o;
        String categoria;
        if(mc.getCategoria() == null){
            categoria = "-";
        }else{
            categoria = mc.getCategoria().getDs_Categoria();
        }
        return categoria;
    }
    
    /**
     * <p><strong>EN:</strong> Fills a JTable with current-month cash movements for the given account.</p>
     *
     * <p><strong>IT:</strong> Popola una JTable con i movimenti di cassa del mese corrente per il conto indicato.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche uma JTable com os movimentos de caixa do mês corrente da conta informada.</p>
     *
     * @param o EN: target JTable | IT: JTable di destinazione | PT-BR: JTable de destino
     * @param cd_conta EN: account ID | IT: ID del conto | PT-BR: ID da conta
     * @since 1.0.0
     */
    public void tablelaMovimentoCaixa(JTable o, int cd_conta){
        String[] nomeColuna = {"Data", "Descrição", "Documento", "Crédito", "Débito", "Transação", "Categoria"};
        lista = movcxr.getListaMes(cd_conta);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for(int i=0; i < lista.size(); i++){
            movcx = (MovimentoCaixa)lista.get(i);
            dadosArray[i][0] = Utilidade.formatoData.format(movcx.getDt_transacao().getTime());
            dadosArray[i][1] = movcx.getDs_descricao();
            dadosArray[i][2] = movcx.getNm_documento();
            dadosArray[i][3] = Utilidade.formatoValor.format(movcx.getVl_credito());
            dadosArray[i][4] = Utilidade.formatoValor.format(movcx.getVl_debito());
            dadosArray[i][5] = movcx.getTipotransacao().getDs_tptrans();
            dadosArray[i][6] = categoriaTrativaTabela(movcx);
        }
        DefaultTableModel tMovCaixa = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tMovCaixa);
    }
    
    /**
     * <p><strong>EN:</strong> Fills a JTable with cash movements for the given account and date range.</p>
     *
     * <p><strong>IT:</strong> Popola una JTable con i movimenti di cassa per il conto indicato e intervallo di date.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche uma JTable com os movimentos de caixa da conta informada em um período.</p>
     *
     * @param o EN: target JTable | IT: JTable di destinazione | PT-BR: JTable de destino
     * @param cd_conta EN: account ID | IT: ID del conto | PT-BR: ID da conta
     * @param dt_inicio EN: start date (dd/MM/yyyy) | IT: data di inizio (dd/MM/yyyy) | PT-BR: data inicial (dd/MM/yyyy)
     * @param dt_final EN: end date (dd/MM/yyyy) | IT: data di fine (dd/MM/yyyy) | PT-BR: data final (dd/MM/yyyy)
     * @since 1.0.0
     */
    public void tablelaMovimentoCaixa(JTable o, int cd_conta, String dt_inicio, String dt_final){
        String[] nomeColuna = {"Data", "Descrição", "Documento", "Crédito", "Débito", "Transação", "Categoria"};
        lista = movcxr.getLista(cd_conta, dt_inicio, dt_final);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for(int i=0; i < lista.size(); i++){
            movcx = (MovimentoCaixa)lista.get(i);
            dadosArray[i][0] = Utilidade.formatoData.format(movcx.getDt_transacao().getTime());
            dadosArray[i][1] = movcx.getDs_descricao();
            dadosArray[i][2] = movcx.getNm_documento();
            dadosArray[i][3] = Utilidade.formatoValor.format(movcx.getVl_credito());
            dadosArray[i][4] = Utilidade.formatoValor.format(movcx.getVl_debito());
            dadosArray[i][5] = movcx.getTipotransacao().getDs_tptrans();
            dadosArray[i][6] = movcx.getCategoria();
        }
        DefaultTableModel tMovCaixa = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tMovCaixa);
    }
    
    /**
     * <p><strong>EN:</strong> Returns the currently selected list item bound to the provided JTable.</p>
     *
     * <p><strong>IT:</strong> Restituisce l'elemento selezionato correntemente dalla JTable fornita.</p>
     *
     * <p><strong>PT-BR:</strong> Retorna o item atualmente selecionado na JTable informada.</p>
     *
     * @param o EN: source JTable | IT: JTable sorgente | PT-BR: JTable de origem
     * @return EN: selected object from the backing list, or null if none | IT: oggetto selezionato dalla lista sottostante, o null se assente | PT-BR: objeto selecionado da lista interna, ou null se nenhum
     * @since 1.0.0
     */
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma movimentação da lista.");
        }
        return selecionado;    
    }  

    /**
     * EM TESTE - COLOCAR COMENTARIO
     * SELECIONA OBJETO DA JTABLE
     * @param o
     * @return 
     */
    public Object getSelectObjectMovcx(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            int modelolinha = o.convertRowIndexToModel(linhaselecionada);
            selecionado = lista.get(modelolinha);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma movimentação da lista.");
        }
        return selecionado;    
    }  
    
    
    /**
     * <p><strong>EN:</strong> Sums all scheduled (future) credits for the given account.</p>
     *
     * <p><strong>IT:</strong> Somma tutti i crediti pianificati (futuri) per il conto indicato.</p>
     *
     * <p><strong>PT-BR:</strong> Soma todos os créditos programados (futuros) da conta informada.</p>
     *
     * @param cd_conta EN: account ID | IT: ID del conto | PT-BR: ID da conta
     * @return EN: total scheduled credit amount (BigDecimal) | IT: importo totale dei crediti pianificati (BigDecimal) | PT-BR: valor total de créditos programados (BigDecimal)
     * @since 1.0.0
     */   
    public BigDecimal somaCreditoLanc(int cd_conta){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = movcxr.getListaContaLanc(cd_conta);
        for(int i=0; i < lista.size(); i++){
            movcx = (MovimentoCaixa)lista.get(i);
            resultado = resultado.add(movcx.getVl_credito());
        }
        return resultado;
    }

    /**
     * <p><strong>EN:</strong> Sums all scheduled (future) debits for the given account.</p>
     *
     * <p><strong>IT:</strong> Somma tutti i debiti pianificati (futuri) per il conto indicato.</p>
     *
     * <p><strong>PT-BR:</strong> Soma todos os débitos programados (futuros) da conta informada.</p>
     *
     * @param cd_conta EN: account ID | IT: ID del conto | PT-BR: ID da conta
     * @return EN: total scheduled debit amount (BigDecimal) | IT: importo totale dei debiti pianificati (BigDecimal) | PT-BR: valor total de débitos programados (BigDecimal)
     * @since 1.0.0
     */
    public BigDecimal somaDebitoLanc(int cd_conta){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = movcxr.getListaContaLanc(cd_conta);
        for(int i=0; i < lista.size(); i++){
            movcx = (MovimentoCaixa)lista.get(i);
            resultado = resultado.add(movcx.getVl_debito());
        }
        return resultado;
    }
    
    /**
     * <p><strong>EN:</strong> Fills a JTable with scheduled (future) cash movements for the given account.</p>
     *
     * <p><strong>IT:</strong> Popola una JTable con i movimenti di cassa pianificati (futuri) per il conto indicato.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche uma JTable com os lançamentos de caixa programados (futuros) da conta informada.</p>
     *
     * @param o EN: target JTable | IT: JTable di destinazione | PT-BR: JTable de destino
     * @param cd_conta EN: account ID | IT: ID del conto | PT-BR: ID da conta
     * @since 1.0.0
     */
    public void tablelaMovimentoCaixaLanc(JTable o, int cd_conta){
        String[] nomeColuna = {"Data", "Descrição", "Documento", "Crédito", "Débito", "Transação", "Categoria"};
        lista = movcxr.getListaContaLanc(cd_conta);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for(int i=0; i < lista.size(); i++){
            movcx = (MovimentoCaixa)lista.get(i);
            dadosArray[i][0] = Utilidade.formatoData.format(movcx.getDt_transacao().getTime());
            dadosArray[i][1] = movcx.getDs_descricao();
            dadosArray[i][2] = movcx.getNm_documento();
            dadosArray[i][3] = Utilidade.formatoValor.format(movcx.getVl_credito());
            dadosArray[i][4] = Utilidade.formatoValor.format(movcx.getVl_debito());
            dadosArray[i][5] = movcx.getTipotransacao().getDs_tptrans();
            dadosArray[i][6] = movcx.getCategoria().getDs_Categoria();
        }
        DefaultTableModel tMovCaixa = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tMovCaixa);
    }
}
