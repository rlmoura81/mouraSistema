package br.com.rlmoura81.moura.relatorio;

import br.com.rlmoura81.moura.financeiro.Conta;
import br.com.rlmoura81.moura.financeiro.ContaSaldo;
import br.com.rlmoura81.moura.financeiro.Despesa;
import br.com.rlmoura81.moura.principalcadastro.Categoria;
import java.math.BigDecimal;

public class RelatorioFinanceiro {
    
    private Categoria categoria;
    private BigDecimal nm_valor;
    private Conta conta;
    private ContaSaldo contasaldo;
    private BigDecimal vl_credito;
    private BigDecimal vl_debito;   
    private String ds_descricao;  
    private Despesa despesa;    
    
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getNm_valor() {
        return nm_valor;
    }

    public void setNm_valor(BigDecimal nm_valor) {
        this.nm_valor = nm_valor;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public ContaSaldo getContasaldo() {
        return contasaldo;
    }

    public void setContasaldo(ContaSaldo contasaldo) {
        this.contasaldo = contasaldo;
    }

    public BigDecimal getVl_credito() {
        return vl_credito;
    }

    public void setVl_credito(BigDecimal vl_credito) {
        this.vl_credito = vl_credito;
    }

    public BigDecimal getVl_debito() {
        return vl_debito;
    }

    public void setVl_debito(BigDecimal vl_debito) {
        this.vl_debito = vl_debito;
    }

    public String getDs_descricao() {
        return ds_descricao;
    }

    public void setDs_descricao(String ds_descricao) {
        this.ds_descricao = ds_descricao;
    }

    public Despesa getDespesa() {
        return despesa;
    }

    public void setDespesa(Despesa despesa) {
        this.despesa = despesa;
    }

    public RelatorioFinanceiro(Conta conta, ContaSaldo contasaldo, BigDecimal vl_credito, BigDecimal vl_debito) {
        this.conta = conta;
        this.contasaldo = contasaldo;
        this.vl_credito = vl_credito;
        this.vl_debito = vl_debito;
    }

    public RelatorioFinanceiro(Categoria categoria, BigDecimal nm_valor) {
        this.categoria = categoria;
        this.nm_valor = nm_valor;
    }

    public RelatorioFinanceiro(BigDecimal vl_debito, BigDecimal nm_valor, Despesa despesa) {
        this.vl_debito = vl_debito;
        this.nm_valor = nm_valor;
        this.despesa = despesa;
    }

    public RelatorioFinanceiro() {
    }
    
}
