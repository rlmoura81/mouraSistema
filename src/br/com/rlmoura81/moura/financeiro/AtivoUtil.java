package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.utilidade.Utilidade;
import java.util.ArrayList;
import javax.swing.JComboBox;
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
    
    public void jcAcao(JComboBox o){
        ArrayList<Ativo> listaacao = ativor.getListaAcao();
        Ativo atvZero = new Ativo(0, null, "<Ação>", null, null, 0);
        o.addItem(atvZero);
        for(Ativo atv : listaacao){
            o.addItem(atv);
        }
    }
    
    public void jcAcaoSaldo(JComboBox o){
        ArrayList<Ativo> listaacaosaldo = ativor.getListaAcaoSaldo();
        Ativo atvZero = new Ativo(0, null, "<Ação>", null, null, 0);
        o.addItem(atvZero);
        for(Ativo atv : listaacaosaldo){
            o.addItem(atv);
        }
    }
    
    public void jcAcaoProv(JComboBox o, int num){
        ArrayList<Ativo> listaativo = ativor.getListaAcaoProv(num);
        Ativo atvZero = new Ativo(0, null, "<Ação>", null, null, 0);
        o.addItem(atvZero);
        for(Ativo atv : listaativo){
            o.addItem(atv);
        }
    }
    
    public void jcAcaoSaldoTpProv(JComboBox o, int num){
        ArrayList<Ativo> listaacaosaldo = ativor.getListaAcaoSaldoTpProv(num);
        Ativo atvZero = new Ativo(0, null, "<Ação>", null, null, 0);
        o.addItem(atvZero);
        for(Ativo atv : listaacaosaldo){
            o.addItem(atv);
        }
    }
    
    public void jcFundoImobiiario(JComboBox o){
        ArrayList<Ativo> listafi = ativor.getListaFII();
        Ativo atvZero = new Ativo(0, null, "<FII>", null, null, 0);
        o.addItem(atvZero);
        for(Ativo atv : listafi){
            o.addItem(atv);
        }
    }
    
    public void jcFundoImobiiarioSaldo(JComboBox o){
        ArrayList<Ativo> listafisalvo = ativor.getListaFIISaldo();
        Ativo atvZero = new Ativo(0, null, "<FII>", null, null, 0);
        o.addItem(atvZero);
        for(Ativo atv : listafisalvo){
            o.addItem(atv);
        }
    }
    
    public void jcFundoImobiiarioProv(JComboBox o, int num){
        ArrayList<Ativo> listafiprov = ativor.getListaFIIProv(num);
        Ativo atvZero = new Ativo(0, null, "<FII>", null, null, 0);
        o.addItem(atvZero);
        for(Ativo atv : listafiprov){
            o.addItem(atv);
        }
    }
    
    public void jcFundoImobiiarioSaldoTpProv(JComboBox o, int num){
        ArrayList<Ativo> listafisaldo = ativor.getListaFIISaldoTpProv(num);
        Ativo atvZero = new Ativo(0, null, "<FII>", null, null, 0);
        o.addItem(atvZero);
        for(Ativo atv : listafisaldo){
            o.addItem(atv);
        }
    }
    
    public void jcAtivoRendaFixa(JComboBox o){
        ArrayList<TipoAtivo> listaativorenda = tpativor.getListaTipoRendaFixa();
        TipoAtivo tpaZero = new TipoAtivo(0, "<Tipo de Ativo>");
        o.addItem(tpaZero);
        for(TipoAtivo tpa : listaativorenda){
            o.addItem(tpa);
        }
    }
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
