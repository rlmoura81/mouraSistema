package br.com.rlmoura81.moura.financeiro;

import java.math.BigDecimal;
import java.util.Objects;

public class Poupanca {
    
    private int cd_poupanca;
    private String nm_variaca;
    private BigDecimal vl_saldo;
    private Conta conta;
    private int cd_usuario;

    public int getCd_poupanca() {
        return cd_poupanca;
    }

    public void setCd_poupanca(int cd_poupanca) {
        this.cd_poupanca = cd_poupanca;
    }

    public String getNm_variaca() {
        return nm_variaca;
    }

    public void setNm_variaca(String nm_variaca) {
        this.nm_variaca = nm_variaca;
    }

    public BigDecimal getVl_saldo() {
        return vl_saldo;
    }

    public void setVl_saldo(BigDecimal vl_saldo) {
        this.vl_saldo = vl_saldo;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public Poupanca(int cd_poupanca, String nm_variaca, BigDecimal vl_saldo, Conta conta, int cd_usuario) {
        this.cd_poupanca = cd_poupanca;
        this.nm_variaca = nm_variaca;
        this.vl_saldo = vl_saldo;
        this.conta = conta;
        this.cd_usuario = cd_usuario;
    }

    public Poupanca() {
    }

    @Override
    public String toString() {
        return nm_variaca;
    }

}
