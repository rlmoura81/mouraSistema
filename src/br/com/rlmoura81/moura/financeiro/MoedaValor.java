package br.com.rlmoura81.moura.financeiro;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Objects;

public class MoedaValor {
    
    private int cd_moedavl;
    private BigDecimal vl_moeda;
    private Calendar dt_valor;
    private Moeda moeda;
    private int cd_usuario;

    public int getCd_moedavl() {
        return cd_moedavl;
    }

    public void setCd_moedavl(int cd_moedavl) {
        this.cd_moedavl = cd_moedavl;
    }

    public BigDecimal getVl_moeda() {
        return vl_moeda;
    }

    public void setVl_moeda(BigDecimal vl_moeda) {
        this.vl_moeda = vl_moeda;
    }

    public Calendar getDt_valor() {
        return dt_valor;
    }

    public void setDt_valor(Calendar dt_valor) {
        this.dt_valor = dt_valor;
    }

    public Moeda getMoeda() {
        return moeda;
    }

    public void setMoeda(Moeda moeda) {
        this.moeda = moeda;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public MoedaValor(int cd_moedavl, BigDecimal vl_moeda, Calendar dt_valor, Moeda moeda, int cd_usuario) {
        this.cd_moedavl = cd_moedavl;
        this.vl_moeda = vl_moeda;
        this.dt_valor = dt_valor;
        this.moeda = moeda;
        this.cd_usuario = cd_usuario;
    }

    public MoedaValor() {
    }

    @Override
    public String toString() {
        return "MoedaValor{" + "cd_moedavl=" + cd_moedavl + ", vl_moeda=" + vl_moeda + ", dt_valor=" + dt_valor + ", moeda=" + moeda + ", cd_usuario=" + cd_usuario + '}';
    }
   
}
