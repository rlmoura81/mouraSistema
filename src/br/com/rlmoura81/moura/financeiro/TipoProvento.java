package br.com.rlmoura81.moura.financeiro;

import java.util.Objects;

public class TipoProvento {
    
    private int cd_tpprovento;
    private String ds_tpprovento;

    public int getCd_tpprovento() {
        return cd_tpprovento;
    }

    public void setCd_tpprovento(int cd_tpprovento) {
        this.cd_tpprovento = cd_tpprovento;
    }

    public String getDs_tpprovento() {
        return ds_tpprovento;
    }

    public void setDs_tpprovento(String ds_tpprovento) {
        this.ds_tpprovento = ds_tpprovento;
    }

    public TipoProvento(int cd_tpprovneto, String ds_tpprovento) {
        this.cd_tpprovento = cd_tpprovneto;
        this.ds_tpprovento = ds_tpprovento;
    }

    public TipoProvento() {
    }

    @Override
    public String toString() {
        return ds_tpprovento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.cd_tpprovento;
        hash = 11 * hash + Objects.hashCode(this.ds_tpprovento);
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
        final TipoProvento other = (TipoProvento) obj;
        if (this.cd_tpprovento != other.cd_tpprovento) {
            return false;
        }
        if (!Objects.equals(this.ds_tpprovento, other.ds_tpprovento)) {
            return false;
        }
        return true;
    }        
}
