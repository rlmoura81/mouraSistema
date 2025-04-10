package br.com.rlmoura81.moura.financeiro;

import java.math.BigDecimal;

public class ContaSaldo {
    
    private Conta conta;
    private BigDecimal vl_saldo;
    private int cd_usuario;

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public BigDecimal getVl_saldo() {
        return vl_saldo;
    }

    public void setVl_saldo(BigDecimal vl_saldo) {
        this.vl_saldo = vl_saldo;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public ContaSaldo(Conta conta, BigDecimal vl_saldo, int cd_usuario) {
        this.conta = conta;
        this.vl_saldo = vl_saldo;
        this.cd_usuario = cd_usuario;
    }

    public ContaSaldo() {
    }

    @Override
    public String toString() {
        return "ContaSaldo{" + "conta=" + conta + ", vl_saldo=" + vl_saldo + ", cd_usuario=" + cd_usuario + '}';
    }

}
