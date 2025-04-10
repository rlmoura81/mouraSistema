package br.com.rlmoura81.moura.financeiro;

import java.math.BigDecimal;
import java.util.Calendar;

public class RendaFixa {
    
    private int cd_rendafixa;
    private String ds_rendafixa;
    private BigDecimal vl_aplicado;
    private BigDecimal vl_taxa;
    private Calendar dt_aplicacao;
    private Calendar dt_vencimento;
    private Indice indice;
    private TipoAtivo tipoativo;
    private int cd_usuario;

    public int getCd_rendafixa() {
        return cd_rendafixa;
    }

    public void setCd_rendafixa(int cd_rendafixa) {
        this.cd_rendafixa = cd_rendafixa;
    }

    public String getDs_rendafixa() {
        return ds_rendafixa;
    }

    public void setDs_rendafixa(String ds_rendafixa) {
        this.ds_rendafixa = ds_rendafixa;
    }

    public BigDecimal getVl_aplicado() {
        return vl_aplicado;
    }

    public void setVl_aplicado(BigDecimal vl_aplicado) {
        this.vl_aplicado = vl_aplicado;
    }

    public BigDecimal getVl_taxa() {
        return vl_taxa;
    }

    public void setVl_taxa(BigDecimal vl_taxa) {
        this.vl_taxa = vl_taxa;
    }

    public Calendar getDt_aplicacao() {
        return dt_aplicacao;
    }

    public void setDt_aplicacao(Calendar dt_aplicacao) {
        this.dt_aplicacao = dt_aplicacao;
    }

    public Calendar getDt_vencimento() {
        return dt_vencimento;
    }

    public void setDt_vencimento(Calendar dt_vencimento) {
        this.dt_vencimento = dt_vencimento;
    }

    public Indice getIndice() {
        return indice;
    }

    public void setIndice(Indice indice) {
        this.indice = indice;
    }
    
    public TipoAtivo getTipoativo() {
        return tipoativo;
    }

    public void setTipoativo(TipoAtivo tipoativo) {
        this.tipoativo = tipoativo;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public RendaFixa(int cd_rendafixa, String ds_rendafixa, BigDecimal vl_aplicado, BigDecimal vl_taxa, Calendar dt_aplicacao, Calendar dt_vencimento, Indice indice, TipoAtivo tipoativo, int cd_usuario) {
        this.cd_rendafixa = cd_rendafixa;
        this.ds_rendafixa = ds_rendafixa;
        this.vl_aplicado = vl_aplicado;
        this.vl_taxa = vl_taxa;
        this.dt_aplicacao = dt_aplicacao;
        this.dt_vencimento = dt_vencimento;
        this.indice = indice;
        this.tipoativo = tipoativo;
        this.cd_usuario = cd_usuario;
    }

    public RendaFixa() {
    }


    @Override
    public String toString() {
        return ds_rendafixa;
    }

}
