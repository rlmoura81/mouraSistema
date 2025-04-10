package br.com.rlmoura81.moura.financeiro;

import java.math.BigDecimal;
import java.util.Calendar;

public class FundoImobiliarioProvento {
    
    private int cd_fdimprov;
    private Ativo ativo;
    private Calendar dt_pagamento;
    private Calendar dt_precobase;
    private BigDecimal vl_provento;
    private BigDecimal vl_database;
    private TipoProvento tipoprovento;
    private int cd_usuario;
    
    public int getCd_fdimprov() {
        return cd_fdimprov;
    }

    public void setCd_fdimprov(int cd_fdimprov) {
        this.cd_fdimprov = cd_fdimprov;
    }

    public Ativo getAtivo() {
        return ativo;
    }

    public void setAtivo(Ativo ativo) {
        this.ativo = ativo;
    }

    public Calendar getDt_pagamento() {
        return dt_pagamento;
    }

    public void setDt_pagamento(Calendar dt_pagamento) {
        this.dt_pagamento = dt_pagamento;
    }

    public Calendar getDt_precobase() {
        return dt_precobase;
    }

    public void setDt_precobase(Calendar dt_precobase) {
        this.dt_precobase = dt_precobase;
    }

    public BigDecimal getVl_provento() {
        return vl_provento;
    }

    public void setVl_provento(BigDecimal vl_provento) {
        this.vl_provento = vl_provento;
    }

    public BigDecimal getVl_database() {
        return vl_database;
    }

    public void setVl_database(BigDecimal vl_database) {
        this.vl_database = vl_database;
    }

    public TipoProvento getTipoprovento() {
        return tipoprovento;
    }

    public void setTipoprovento(TipoProvento tipoprovento) {
        this.tipoprovento = tipoprovento;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public FundoImobiliarioProvento(int cd_fdimprov, Ativo ativo, Calendar dt_pagamento, Calendar dt_precobase, BigDecimal vl_provento, BigDecimal vl_database, TipoProvento tipoprovento, int cd_usuario) {
        this.cd_fdimprov = cd_fdimprov;
        this.ativo = ativo;
        this.dt_pagamento = dt_pagamento;
        this.dt_precobase = dt_precobase;
        this.vl_provento = vl_provento;
        this.vl_database = vl_database;
        this.tipoprovento = tipoprovento;
        this.cd_usuario = cd_usuario;
    }

    public FundoImobiliarioProvento() {
    }

    @Override
    public String toString() {
        return "FundoImobiliarioProvento{" + "cd_fdimprov=" + cd_fdimprov + ", ativo=" + ativo + ", dt_pagamento=" + dt_pagamento + ", dt_precobase=" + dt_precobase + ", vl_provento=" + vl_provento + ", vl_database=" + vl_database + ", tipoprovento=" + tipoprovento + ", cd_usuario=" + cd_usuario + '}';
    }

}
