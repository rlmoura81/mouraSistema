package br.com.rlmoura81.moura.financeiro;

import java.math.BigDecimal;
import java.util.Calendar;

public class PoupancaAplicacao {
    
    private int cd_poupaplic;
    private BigDecimal vl_saldo;
    private Calendar dt_saldo;
    private Poupanca poupanca;
    private int cd_usuario;

    public int getCd_poupaplic() {
        return cd_poupaplic;
    }

    public void setCd_poupaplic(int cd_poupaplic) {
        this.cd_poupaplic = cd_poupaplic;
    }

    public BigDecimal getVl_saldo() {
        return vl_saldo;
    }

    public void setVl_saldo(BigDecimal vl_saldo) {
        this.vl_saldo = vl_saldo;
    }

    public Calendar getDt_saldo() {
        return dt_saldo;
    }

    public void setDt_saldo(Calendar dt_saldo) {
        this.dt_saldo = dt_saldo;
    }

    public Poupanca getPoupanca() {
        return poupanca;
    }

    public void setPoupanca(Poupanca poupanca) {
        this.poupanca = poupanca;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public PoupancaAplicacao(int cd_poupaplic, BigDecimal vl_saldo, Calendar dt_saldo, Poupanca poupanca, int cd_usuario) {
        this.cd_poupaplic = cd_poupaplic;
        this.vl_saldo = vl_saldo;
        this.dt_saldo = dt_saldo;
        this.poupanca = poupanca;
        this.cd_usuario = cd_usuario;
    }

    public PoupancaAplicacao() {
    }

    @Override
    public String toString() {
        return "PoupancaAplicacao{" + "cd_poupaplic=" + cd_poupaplic + ", vl_saldo=" + vl_saldo + ", dt_saldo=" + dt_saldo + ", poupanca=" + poupanca + ", cd_usuario=" + cd_usuario + '}';
    }

}
