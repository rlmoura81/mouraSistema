package br.com.rlmoura81.moura.financeiro;

import java.util.Objects;

public class TipoRenda {
    
    private int cd_tprenda;
    private String ds_tprenda;

    public int getCd_tprenda() {
        return cd_tprenda;
    }

    public void setCd_tprenda(int cd_tprenda) {
        this.cd_tprenda = cd_tprenda;
    }

    public String getDs_tprenda() {
        return ds_tprenda;
    }

    public void setDs_tprenda(String ds_tprenda) {
        this.ds_tprenda = ds_tprenda;
    }

    public TipoRenda(int cd_tprenda, String ds_tprenda) {
        this.cd_tprenda = cd_tprenda;
        this.ds_tprenda = ds_tprenda;
    }

    public TipoRenda() {
    }

    @Override
    public String toString() {
        return ds_tprenda;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.cd_tprenda;
        hash = 29 * hash + Objects.hashCode(this.ds_tprenda);
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
        final TipoRenda other = (TipoRenda) obj;
        if (this.cd_tprenda != other.cd_tprenda) {
            return false;
        }
        if (!Objects.equals(this.ds_tprenda, other.ds_tprenda)) {
            return false;
        }
        return true;
    }  
}
