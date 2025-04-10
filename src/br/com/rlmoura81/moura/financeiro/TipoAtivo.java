package br.com.rlmoura81.moura.financeiro;

import java.util.Objects;

public class TipoAtivo {
    
    private int cd_tpativo;
    private String ds_tpativo; 

    public int getCd_tpativo() {
        return cd_tpativo;
    }

    public void setCd_tpativo(int cd_tpativo) {
        this.cd_tpativo = cd_tpativo;
    }

    public String getDs_tpativo() {
        return ds_tpativo;
    }

    public void setDs_tpativo(String ds_tpativo) {
        this.ds_tpativo = ds_tpativo;
    }

    public TipoAtivo(int cd_tpativo, String ds_tpativo) {
        this.cd_tpativo = cd_tpativo;
        this.ds_tpativo = ds_tpativo;
    }

    public TipoAtivo() {
    }

    @Override
    public String toString() {
        return ds_tpativo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.cd_tpativo;
        hash = 11 * hash + Objects.hashCode(this.ds_tpativo);
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
        final TipoAtivo other = (TipoAtivo) obj;
        if (this.cd_tpativo != other.cd_tpativo) {
            return false;
        }
        if (!Objects.equals(this.ds_tpativo, other.ds_tpativo)) {
            return false;
        }
        return true;
    }
    
    
}
