package br.com.rlmoura81.moura.financeiro;

import java.util.Objects;

public class FundoInvestimento {
    
    private int cd_fdinvest;
    private String ds_fdinvest;
    private GrupoFundo gpfundo;
    private int cd_usuario;

    public int getCd_fdinvest() {
        return cd_fdinvest;
    }

    public void setCd_fdinvest(int cd_fdinvest) {
        this.cd_fdinvest = cd_fdinvest;
    }

    public String getDs_fdinvest() {
        return ds_fdinvest;
    }

    public void setDs_fdinvest(String ds_fdinvest) {
        this.ds_fdinvest = ds_fdinvest;
    }

    public GrupoFundo getGpfundo() {
        return gpfundo;
    }

    public void setGpfundo(GrupoFundo gpfundo) {
        this.gpfundo = gpfundo;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public FundoInvestimento(int cd_fdinvest, String ds_fdinvest, GrupoFundo gpfundo, int cd_usuario) {
        this.cd_fdinvest = cd_fdinvest;
        this.ds_fdinvest = ds_fdinvest;
        this.gpfundo = gpfundo;
        this.cd_usuario = cd_usuario;
    }

    public FundoInvestimento() {
    }

    @Override
    public String toString() {
        return ds_fdinvest;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.cd_fdinvest;
        hash = 47 * hash + Objects.hashCode(this.ds_fdinvest);
        hash = 47 * hash + Objects.hashCode(this.gpfundo);
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
        final FundoInvestimento other = (FundoInvestimento) obj;
        if (this.cd_fdinvest != other.cd_fdinvest) {
            return false;
        }
        if (this.cd_usuario != other.cd_usuario) {
            return false;
        }
        if (!Objects.equals(this.ds_fdinvest, other.ds_fdinvest)) {
            return false;
        }
        if (!Objects.equals(this.gpfundo, other.gpfundo)) {
            return false;
        }
        return true;
    }    
}
