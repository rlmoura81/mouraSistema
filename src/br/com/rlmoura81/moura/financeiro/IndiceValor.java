package br.com.rlmoura81.moura.financeiro;

import java.math.BigDecimal;
import java.util.Calendar;

public class IndiceValor {
    
    private int cd_indicevl;
    private BigDecimal vl_mes;
    private Calendar dt_vlatualizado;
    private Indice indice;
    private int cd_usuario;

    public int getCd_indicevl() {
        return cd_indicevl;
    }

    public void setCd_indicevl(int cd_indicevl) {
        this.cd_indicevl = cd_indicevl;
    }

    public BigDecimal getVl_mes() {
        return vl_mes;
    }

    public void setVl_mes(BigDecimal vl_mes) {
        this.vl_mes = vl_mes;
    }

    public Calendar getDt_vlatualizado() {
        return dt_vlatualizado;
    }

    public void setDt_vlatualizado(Calendar dt_vlatualizado) {
        this.dt_vlatualizado = dt_vlatualizado;
    }

    public Indice getIndice() {
        return indice;
    }

    public void setIndice(Indice indice) {
        this.indice = indice;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public IndiceValor(int cd_indicevl, BigDecimal vl_mes, Calendar dt_vlatualizado, Indice indice, int cd_usuario) {
        this.cd_indicevl = cd_indicevl;
        this.vl_mes = vl_mes;
        this.dt_vlatualizado = dt_vlatualizado;
        this.indice = indice;
        this.cd_usuario = cd_usuario;
    }

    public IndiceValor() {
    }

    @Override
    public String toString() {
        return "IndiceValor{" + "cd_indicevl=" + cd_indicevl + ", vl_mes=" + vl_mes + ", dt_vlatualizado=" + dt_vlatualizado + ", indice=" + indice + ", cd_usuario=" + cd_usuario + '}';
    }

}
