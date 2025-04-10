package br.com.rlmoura81.moura.catalogo;

import java.util.Objects;

public class Status {
    
    private int cd_status;
    private String ds_status;

    public int getCd_status() {
        return cd_status;
    }

    public void setCd_status(int cd_status) {
        this.cd_status = cd_status;
    }

    public String getDs_status() {
        return ds_status;
    }

    public void setDs_status(String ds_status) {
        this.ds_status = ds_status;
    }

    public Status(int cd_status, String ds_status) {
        this.cd_status = cd_status;
        this.ds_status = ds_status;
    }

    public Status() {
    }

    @Override
    public String toString() {
        return ds_status;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.cd_status;
        hash = 97 * hash + Objects.hashCode(this.ds_status);
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
        final Status other = (Status) obj;
        if (this.cd_status != other.cd_status) {
            return false;
        }
        if (!Objects.equals(this.ds_status, other.ds_status)) {
            return false;
        }
        return true;
    }
        
}
