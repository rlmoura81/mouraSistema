package br.com.rlmoura81.moura.financeiro;

import java.math.BigDecimal;
import java.util.Calendar;

public class Renda {
    
    private int cd_renda;
    private Calendar dt_renda;
    private String ds_renda;
    private BigDecimal nm_valor;
    private TipoRenda tprenda;
    private int cd_usuario;

    public int getCd_renda() {
        return cd_renda;
    }

    public void setCd_renda(int cd_renda) {
        this.cd_renda = cd_renda;
    }

    public Calendar getDt_renda() {
        return dt_renda;
    }

    public void setDt_renda(Calendar dt_renda) {
        this.dt_renda = dt_renda;
    }

    public String getDs_renda() {
        return ds_renda;
    }

    public void setDs_renda(String ds_renda) {
        this.ds_renda = ds_renda;
    }

    public BigDecimal getNm_valor() {
        return nm_valor;
    }

    public void setNm_valor(BigDecimal nm_valor) {
        this.nm_valor = nm_valor;
    }

    public TipoRenda getTprenda() {
        return tprenda;
    }

    public void setTprenda(TipoRenda tprenda) {
        this.tprenda = tprenda;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public Renda(int cd_renda, Calendar dt_renda, String ds_renda, BigDecimal nm_valor, TipoRenda tprenda, int cd_usuario) {
        this.cd_renda = cd_renda;
        this.dt_renda = dt_renda;
        this.ds_renda = ds_renda;
        this.nm_valor = nm_valor;
        this.tprenda = tprenda;
        this.cd_usuario = cd_usuario;
    }

    public Renda() {
    }

    @Override
    public String toString() {
        return "Renda{" + "cd_renda=" + cd_renda + ", dt_renda=" + dt_renda + ", ds_renda=" + ds_renda + ", nm_valor=" + nm_valor + ", tprenda=" + tprenda + ", cd_usuario=" + cd_usuario + '}';
    }

}
