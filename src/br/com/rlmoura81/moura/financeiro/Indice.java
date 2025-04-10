package br.com.rlmoura81.moura.financeiro;

import java.util.Objects;

public class Indice {
    
    private int cd_indice;
    private String ds_indice;

    public int getCd_indice() {
        return cd_indice;
    }

    public void setCd_indice(int cd_indice) {
        this.cd_indice = cd_indice;
    }

    public String getDs_indice() {
        return ds_indice;
    }

    public void setDs_indice(String ds_indice) {
        this.ds_indice = ds_indice;
    }

    public Indice(int cd_indice, String ds_indice) {
        this.cd_indice = cd_indice;
        this.ds_indice = ds_indice;
    }

    public Indice() {
    }

    @Override
    public String toString() {
        return ds_indice;
    }  
}
