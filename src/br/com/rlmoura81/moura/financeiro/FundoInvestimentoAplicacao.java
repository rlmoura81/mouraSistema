package br.com.rlmoura81.moura.financeiro;

import java.math.BigDecimal;
import java.util.Objects;

public class FundoInvestimentoAplicacao {
    
    private int cd_fdinvestaplic;
    private BigDecimal vl_saldo;
    private FundoInvestimento fdinvest;
    private Conta conta;
    private int cd_usuario;

    public int getCd_fdinvestaplic() {
        return cd_fdinvestaplic;
    }

    public void setCd_fdinvestaplic(int cd_fdinvestaplic) {
        this.cd_fdinvestaplic = cd_fdinvestaplic;
    }

    public BigDecimal getVl_saldo() {
        return vl_saldo;
    }

    public void setVl_saldo(BigDecimal vl_saldo) {
        this.vl_saldo = vl_saldo;
    }

    public FundoInvestimento getFdinvest() {
        return fdinvest;
    }

    public void setFdinvest(FundoInvestimento fdinvest) {
        this.fdinvest = fdinvest;
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

    public FundoInvestimentoAplicacao(int cd_fdinvestaplic, BigDecimal vl_saldo, FundoInvestimento fdinvest, Conta conta, int cd_usuario) {
        this.cd_fdinvestaplic = cd_fdinvestaplic;
        this.vl_saldo = vl_saldo;
        this.fdinvest = fdinvest;
        this.conta = conta;
        this.cd_usuario = cd_usuario;
    }

    public FundoInvestimentoAplicacao() {
    }

    @Override
    public String toString() {
        return "FundoInvestimentoAplicacao{" + "cd_fdinvestaplic=" + cd_fdinvestaplic + ", vl_saldo=" + vl_saldo + ", fdinvest=" + fdinvest + ", conta=" + conta + ", cd_usuario=" + cd_usuario + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.cd_fdinvestaplic;
        hash = 79 * hash + Objects.hashCode(this.vl_saldo);
        hash = 79 * hash + Objects.hashCode(this.fdinvest);
        hash = 79 * hash + Objects.hashCode(this.conta);
        hash = 79 * hash + this.cd_usuario;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FundoInvestimentoAplicacao other = (FundoInvestimentoAplicacao) obj;
        if (this.cd_fdinvestaplic != other.cd_fdinvestaplic) {
            return false;
        }
        if (this.cd_usuario != other.cd_usuario) {
            return false;
        }
        if (!Objects.equals(this.vl_saldo, other.vl_saldo)) {
            return false;
        }
        if (!Objects.equals(this.fdinvest, other.fdinvest)) {
            return false;
        }
        if (!Objects.equals(this.conta, other.conta)) {
            return false;
        }
        return true;
    }
            
}
