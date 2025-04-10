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
    
    public BigDecimal calculaDespesaTotalAni(Animal a){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = mdr.getListaAnimalDespesa(a);
        for(int i=0; i < lista.size(); i++){
            adespesa = (AnimalDespesa)lista.get(i);
            resultado = resultado.add(cf.calculoValorQtde(adespesa.getNm_valor(), adespesa.getNm_qtde()));
        }
        return resultado;
    }
    
    public BigDecimal calculaDespesaTotalAni(Animal a, String dt_inicio, String dt_final){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = mdr.getListaAnimalDespesa(a, dt_inicio, dt_final);
        for(int i=0; i < lista.size(); i++){
            adespesa = (AnimalDespesa)lista.get(i);
            resultado = resultado.add(cf.calculoValorQtde(adespesa.getNm_valor(), adespesa.getNm_qtde()));
        }
        return resultado;
    }
    
    public BigDecimal calculaDespesaTotalVeic(Veiculo v){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = mdr.getListaVeiculoDespesa(v);
        for(int i=0; i < lista.size(); i++){
            vdespesa = (VeiculoDespesa)lista.get(i);
            resultado = resultado.add(cf.calculoValorQtde(vdespesa.getNm_valor(), vdespesa.getNm_qtde()));
        }
        return resultado;
    } 
    
    public BigDecimal calculaDespesaTotalVeic(Veiculo v, String dt_inicio, String dt_final){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = mdr.getListaVeiculoDespesa(v, dt_inicio, dt_final);
        for(int i=0; i < lista.size(); i++){
            vdespesa = (VeiculoDespesa)lista.get(i);
            resultado = resultado.add(cf.calculoValorQtde(vdespesa.getNm_valor(), vdespesa.getNm_qtde()));
        }
        return resultado;
    } 

    public BigDecimal calculaDespesaTotalImov(Imovel im){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = mdr.getListaImovelDespesa(im);
        for(int i=0; i < lista.size(); i++){
            idespesa = (ImovelDespesa)lista.get(i);
            resultado = resultado.add(cf.calculoValorQtde(idespesa.getNm_valor(), idespesa.getNm_qtde()));
        }
        return resultado;
    }     
    
    public BigDecimal calculaDespesaTotalImov(Imovel im, String dt_inicio, String dt_final){
        BigDecimal resultado = Utilidade.converter("0,00");
        lista = mdr.getListaImovelDespesa(im, dt_inicio, dt_final);
        for(int i=0; i < lista.size(); i++){
            idespesa = (ImovelDespesa)lista.get(i);
            resultado = resultado.add(cf.calculoValorQtde(idespesa.getNm_valor(), idespesa.getNm_qtde()));
        }
        return resultado;
    }     
    
    public void tabelaDespesaAnimal(JTable o, Animal a){
        String[] nomeColuna = {"Data", "Nota", "Descrição", "Valor", "Qtde", "Total", "Prestador", "Produto"};
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
            dadosArray[i][6] = adespesa.getPresserv();
            dadosArray[i][7] = adespesa.getProduto();
        }        
        DefaultTableModel tAnimalDesp = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tAnimalDesp);
    }    

    public void tabelaDespesaAnimal(JTable o, Animal a, String dt_inicio, String dt_final){
        String[] nomeColuna = {"Data", "Nota", "Descrição", "Valor", "Qtde", "Total", "Prestador", "Produto"};
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
            dadosArray[i][6] = adespesa.getPresserv();
            dadosArray[i][7] = adespesa.getProduto();
        }        
        DefaultTableModel tAnimalDesp = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tAnimalDesp);
    }  
    
    public void tabelaDespesaVeiculo(JTable o, Veiculo v){
        String[] nomeColuna = {"Data", "Nota", "Descrição", "Valor", "Qtde", "Total", "Prestador"};
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
            dadosArray[i][6] = vdespesa.getPresserv();
        }        
        DefaultTableModel tVeiculoDesp = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tVeiculoDesp);
    }    

    public void tabelaDespesaVeiculo(JTable o, Veiculo v, String dt_inicio, String dt_final){
        String[] nomeColuna = {"Data", "Nota", "Descrição", "Valor", "Qtde", "Total", "Prestador"};
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
            dadosArray[i][6] = vdespesa.getPresserv();
        }        
        DefaultTableModel tVeiculoDesp = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tVeiculoDesp);
    } 
    
    public void tabelaDespesaImovel(JTable o, Imovel im){
        String[] nomeColuna = {"Data", "Nota", "Descrição", "Valor", "Qtde", "Prestador"};
        lista = mdr.getListaImovelDespesa(im);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for(int i=0; i < lista.size(); i++){
            idespesa = (ImovelDespesa)lista.get(i);
            dadosArray[i][0] = Utilidade.formatoData.format(idespesa.getDt_despesa().getTime());
            dadosArray[i][1] = idespesa.getNm_nota();
            dadosArray[i][2] = idespesa.getDs_descricao();
            dadosArray[i][3] = Utilidade.formatoValor.format(idespesa.getNm_valor());
            dadosArray[i][4] = idespesa.getNm_qtde();
            dadosArray[i][5] = idespesa.getPresserv();
        }
        DefaultTableModel tImovelDesp = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tImovelDesp);
    }   
    
    public void tabelaDespesaImovel(JTable o, Imovel im, String dt_inicio, String dt_final){
        String[] nomeColuna = {"Data", "Nota", "Descrição", "Valor", "Qtde", "Prestador"};
        lista = mdr.getListaImovelDespesa(im, dt_inicio, dt_final);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for(int i=0; i < lista.size(); i++){
            idespesa = (ImovelDespesa)lista.get(i);
            dadosArray[i][0] = Utilidade.formatoData.format(idespesa.getDt_despesa().getTime());
            dadosArray[i][1] = idespesa.getNm_nota();
            dadosArray[i][2] = idespesa.getDs_descricao();
            dadosArray[i][3] = Utilidade.formatoValor.format(idespesa.getNm_valor());
            dadosArray[i][4] = idespesa.getNm_qtde();
            dadosArray[i][5] = idespesa.getPresserv();
        }
        DefaultTableModel tImovelDesp = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tImovelDesp);
    }       
    
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
