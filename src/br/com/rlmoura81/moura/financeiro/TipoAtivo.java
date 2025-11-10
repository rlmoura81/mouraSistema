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
        return "TipoAtivo{" + "cd_tpativo=" + cd_tpativo + ", ds_tpativo=" + ds_tpativo + '}';
    }    
}
