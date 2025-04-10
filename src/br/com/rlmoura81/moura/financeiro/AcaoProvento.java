package br.com.rlmoura81.moura.financeiro;

import java.math.BigDecimal;
import java.util.Calendar;

public class AcaoProvento {
    
    private int cd_acaoprov;
    private Ativo ativo;
    private Calendar dt_pagamento;
    private Calendar dt_precobase;
    private BigDecimal vl_provento;
    private BigDecimal vl_database;
    private TipoProvento tpprovento;
    private int cd_usuario;

    public int getCd_acaoprov() {
        return cd_acaoprov;
    }

    public void setCd_acaoprov(int cd_acaoprov) {
        this.cd_acaoprov = cd_acaoprov;
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

    public TipoProvento getTpprovento() {
        return tpprovento;
    }

    public void setTpprovento(TipoProvento tpprovento) {
        this.tpprovento = tpprovento;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public AcaoProvento(int cd_acaoprov, Ativo ativo, Calendar dt_pagamento, Calendar dt_precobase, BigDecimal vl_provento, BigDecimal vl_database, TipoProvento tpprovento, int cd_usuario) {
        this.cd_acaoprov = cd_acaoprov;
        this.ativo = ativo;
        this.dt_pagamento = dt_pagamento;
        this.dt_precobase = dt_precobase;
        this.vl_provento = vl_provento;
        this.vl_database = vl_database;
        this.tpprovento = tpprovento;
        this.cd_usuario = cd_usuario;
    }

    public AcaoProvento() {
    }

    @Override
    public String toString() {
        return "AcaoProvento{" + "cd_acaoprov=" + cd_acaoprov + ", ativo=" + ativo + ", dt_pagamento=" + dt_pagamento + ", dt_precobase=" + dt_precobase + ", vl_provento=" + vl_provento + ", vl_database=" + vl_database + ", tpprovento=" + tpprovento + ", cd_usuario=" + cd_usuario + '}';
    }   
    
}
