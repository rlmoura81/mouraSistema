package br.com.rlmoura81.moura.veiculo;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VeiculoUtil {
    
    Veiculo veiculo = new Veiculo();
    VeiculoRepository veiculor = new VeiculoRepository();
    CombustivelRepository combustivelr = new CombustivelRepository();    
    CoresRepository corr = new CoresRepository();    
    ArrayList lista = new ArrayList();
    
    /**
     * <p><strong>EN:</strong> Populates a <code>JComboBox</code> with all fuels.
     * Adds a default “&lt;Combustivel&gt;” placeholder, then appends items from the repository.</p>
     *
     * <p><strong>IT:</strong> Popola un <code>JComboBox</code> con tutti i carburanti.
     * Aggiunge il segnaposto “&lt;Combustivel&gt;” e poi inserisce gli elementi dal repository.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche um <code>JComboBox</code> com todos os combustíveis.
     * Adiciona o placeholder “&lt;Combustivel&gt;” e em seguida inclui os itens do repositório.</p>
     */
    public void jcCombusivel(JComboBox o){
        ArrayList<Combustivel> listacombustivel = combustivelr.getLista();
        Combustivel cZero = new Combustivel(0, "<Combustivel>");
        o.addItem(cZero);
        for(Combustivel combustivel : listacombustivel){
            o.addItem(combustivel);
        }
    }
    
    /**
     * <p><strong>EN:</strong> Populates a <code>JComboBox</code> with all colors.
     * Adds a default “&lt;Cor&gt;” placeholder, then appends items from the repository.</p>
     *
     * <p><strong>IT:</strong> Popola un <code>JComboBox</code> con tutti i colori.
     * Aggiunge il segnaposto “&lt;Cor&gt;” e poi inserisce gli elementi dal repository.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche um <code>JComboBox</code> com todas as cores.
     * Adiciona o placeholder “&lt;Cor&gt;” e depois inclui os itens do repositório.</p>
     */
    public void jcCor(JComboBox o){
        ArrayList<Cores> listacor = corr.getLista();
        Cores cZero = new Cores(0, "<Cor>");
        o.addItem(cZero);
        for(Cores cor : listacor){
            o.addItem(cor);
        }
    }
    
    /**
     * <p><strong>EN:</strong> Populates a <code>JComboBox</code> with all vehicles.
     * Adds a default item (RENAVAM/Plate placeholders) and then appends vehicles from the repository.</p>
     *
     * <p><strong>IT:</strong> Popola un <code>JComboBox</code> con tutti i veicoli.
     * Aggiunge un elemento predefinito (segnaposti RENAVAM/Targa) e poi inserisce i veicoli dal repository.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche um <code>JComboBox</code> com todos os veículos.
     * Adiciona um item padrão (placeholders RENAVAM/Placa) e depois inclui os veículos do repositório.</p>
     */
    public void jcVeiculo(JComboBox o) {
        ArrayList<Veiculo> listaveiculo = veiculor.getLista();
        Veiculo vZero = new Veiculo(0, 0, 0, "<Renavam>", "<Placa>", 0, null, null, null, 0);
        o.addItem(vZero);
        for (Veiculo veiculo : listaveiculo) {
            o.addItem(veiculo);
        }
    }
    
    /**
     * <p><strong>EN:</strong> Builds the vehicle table model and assigns it to a <code>JTable</code>.
     * Columns: Plate, Model, RENAVAM, Fuel, Power, Year Fab/Model, Color.</p>
     *
     * <p><strong>IT:</strong> Crea il modello di tabella dei veicoli e lo assegna a un <code>JTable</code>.
     * Colonne: Targa, Modello, RENAVAM, Carburante, Potenza, Anno Fab/Mod, Colore.</p>
     *
     * <p><strong>PT-BR:</strong> Monta o modelo da tabela de veículos e o atribui a um <code>JTable</code>.
     * Colunas: Placa, Modelo, RENAVAM, Combustível, Potência, Ano Fab/Mod, Cor.</p>
     */
    public void tabelaVeiculo(JTable o){
        String[] nomeColuna = {"Placa", "Modelo", "Renavam", "Combustivel", "Potencia", "Ano Fab / Mod", "Cor"};
        lista = veiculor.getLista();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for(int i=0; i < lista.size(); i++){
            veiculo = (Veiculo)lista.get(i);
            dadosArray[i][0] = veiculo.getNm_placa();
            dadosArray[i][1] = veiculo.getModelo();
            dadosArray[i][2] = veiculo.getNm_renavam();
            dadosArray[i][3] = veiculo.getCombustivel();
            dadosArray[i][4] = veiculo.getNm_potencia();
            dadosArray[i][5] = veiculo.getDt_anofab() + "/" + veiculo.getDt_anomod();
            dadosArray[i][6] = veiculo.getCor();
        }
        DefaultTableModel tVeiculo = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tVeiculo);
    }    

    /**
     * <p><strong>EN:</strong> Returns the object associated with the selected row in a <code>JTable</code>.
     * If no row is selected, shows an informational dialog and returns <code>null</code>.</p>
     *
     * <p><strong>IT:</strong> Restituisce l’oggetto associato alla riga selezionata in un <code>JTable</code>.
     * Se nessuna riga è selezionata, mostra un messaggio informativo e restituisce <code>null</code>.</p>
     *
     * <p><strong>PT-BR:</strong> Retorna o objeto referente à linha selecionada em um <code>JTable</code>.
     * Caso nenhuma linha esteja selecionada, exibe um aviso e retorna <code>null</code>.</p>
     */
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecinada = o.getSelectedRow();
        if(linhaselecinada >= 0){
            selecionado = lista.get(linhaselecinada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um veiculo da lista.", "Veiculo", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;
    }
}
