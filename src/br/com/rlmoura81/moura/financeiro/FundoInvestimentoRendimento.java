package br.com.rlmoura81.moura.financeiro;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Objects;

public class FundoInvestimentoRendimento {
    
    private int cd_fdinvestrend;
    private BigDecimal vl_rendimento;
    private Calendar dt_rendimento;
    private FundoInvestimentoAplicacao fdinvap;
    private int cd_usuario;

    public int getCd_fdinvestrend() {
        return cd_fdinvestrend;
    }

    public void setCd_fdinvestrend(int cd_fdinvestrend) {
        this.cd_fdinvestrend = cd_fdinvestrend;
    }

    public BigDecimal getVl_rendimento() {
        return vl_rendimento;
    }

    public void setVl_rendimento(BigDecimal vl_rendimento) {
        this.vl_rendimento = vl_rendimento;
    }

    public Calendar getDt_rendimento() {
        return dt_rendimento;
    }

    public void setDt_rendimento(Calendar dt_rendimento) {
        this.dt_rendimento = dt_rendimento;
    }

    public FundoInvestimentoAplicacao getFdinvap() {
        return fdinvap;
    }

    public void setFdinvap(FundoInvestimentoAplicacao fdinvap) {
        this.fdinvap = fdinvap;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public FundoInvestimentoRendimento(int cd_fdinvestrend, BigDecimal vl_rendimento, Calendar dt_rendimento, FundoInvestimentoAplicacao fdinvap, int cd_usuario) {
        this.cd_fdinvestrend = cd_fdinvestrend;
        this.vl_rendimento = vl_rendimento;
        this.dt_rendimento = dt_rendimento;
        this.fdinvap = fdinvap;
        this.cd_usuario = cd_usuario;
    }

    public FundoInvestimentoRendimento() {
    }

    @Override
    public String toString() {
        return "FundoInvestimentoRendimento{" + "cd_fdinvestrend=" + cd_fdinvestrend + ", vl_rendimento=" + vl_rendimento + ", dt_rendimento=" + dt_rendimento + ", fdinvap=" + fdinvap + ", cd_usuario=" + cd_usuario + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.cd_fdinvestrend;
        hash = 47 * hash + Objects.hashCode(this.vl_rendimento);
        hash = 47 * hash + Objects.hashCode(this.dt_rendimento);
        hash = 47 * hash + Objects.hashCode(this.fdinvap);
        hash = 47 * hash + this.cd_usuario;
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
        final FundoInvestimentoRendimento other = (FundoInvestimentoRendimento) obj;
        if (this.cd_fdinvestrend != other.cd_fdinvestrend) {
            return false;
        }
        if (this.cd_usuario != other.cd_usuario) {
            return false;
        }
        if (!Objects.equals(this.vl_rendimento, other.vl_rendimento)) {
            return false;
        }
        if (!Objects.equals(this.dt_rendimento, other.dt_rendimento)) {
            return false;
        }
        if (!Objects.equals(this.fdinvap, other.fdinvap)) {
            return false;
        }
        return true;
    }
    
}
