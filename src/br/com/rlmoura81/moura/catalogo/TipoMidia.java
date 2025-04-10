package br.com.rlmoura81.moura.catalogo;

import java.util.Objects;

public class TipoMidia {
    
    private int cd_midia;
    private String ds_midia;

    public int getCd_midia() {
        return cd_midia;
    }

    public void setCd_midia(int cd_midia) {
        this.cd_midia = cd_midia;
    }

    public String getDs_midia() {
        return ds_midia;
    }

    public void setDs_midia(String ds_midia) {
        this.ds_midia = ds_midia;
    }

    public TipoMidia(int cd_midia, String ds_midia) {
        this.cd_midia = cd_midia;
        this.ds_midia = ds_midia;
    }

    public TipoMidia() {
    }
    
    @Override
    public String toString() {
        return ds_midia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.cd_midia;
        hash = 41 * hash + Objects.hashCode(this.ds_midia);
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
        final TipoMidia other = (TipoMidia) obj;
        if (this.cd_midia != other.cd_midia) {
            return false;
        }
        if (!Objects.equals(this.ds_midia, other.ds_midia)) {
            return false;
        }
        return true;
    }

}
