package br.com.rlmoura81.moura.financeiro;

import java.util.Objects;

public class GrupoTransacao {
    
    private int cd_gptrans;
    private String ds_gptrans;

    public int getCd_gptrans() {
        return cd_gptrans;
    }

    public void setCd_gptrans(int cd_gptrans) {
        this.cd_gptrans = cd_gptrans;
    }

    public String getDs_gptrans() {
        return ds_gptrans;
    }

    public void setDs_gptrans(String ds_gptrans) {
        this.ds_gptrans = ds_gptrans;
    }

    public GrupoTransacao(int cd_gptrans, String ds_gptrans) {
        this.cd_gptrans = cd_gptrans;
        this.ds_gptrans = ds_gptrans;
    }

    public GrupoTransacao() {
    }

    @Override
    public String toString() {
        return ds_gptrans;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.cd_gptrans;
        hash = 59 * hash + Objects.hashCode(this.ds_gptrans);
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
        final GrupoTransacao other = (GrupoTransacao) obj;
        if (this.cd_gptrans != other.cd_gptrans) {
            return false;
        }
        if (!Objects.equals(this.ds_gptrans, other.ds_gptrans)) {
            return false;
        }
        return true;
    }
    
    
    
}
