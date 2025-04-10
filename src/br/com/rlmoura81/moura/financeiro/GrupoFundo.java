package br.com.rlmoura81.moura.financeiro;

import java.util.Objects;

public class GrupoFundo {

    private int cd_gpfundo;
    private String ds_gpfundo;

    public int getCd_gpfundo() {
        return cd_gpfundo;
    }

    public void setCd_gpfundo(int cd_gpfundo) {
        this.cd_gpfundo = cd_gpfundo;
    }

    public String getDs_gpfundo() {
        return ds_gpfundo;
    }

    public void setDs_gpfundo(String ds_gpfundo) {
        this.ds_gpfundo = ds_gpfundo;
    }

    public GrupoFundo(int cd_gpfundo, String ds_gpfundo) {
        this.cd_gpfundo = cd_gpfundo;
        this.ds_gpfundo = ds_gpfundo;
    }

    public GrupoFundo() {
    }

    @Override
    public String toString() {
        return ds_gpfundo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.cd_gpfundo;
        hash = 37 * hash + Objects.hashCode(this.ds_gpfundo);
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
        final GrupoFundo other = (GrupoFundo) obj;
        if (this.cd_gpfundo != other.cd_gpfundo) {
            return false;
        }
        if (!Objects.equals(this.ds_gpfundo, other.ds_gpfundo)) {
            return false;
        }
        return true;
    }
    
    
}
