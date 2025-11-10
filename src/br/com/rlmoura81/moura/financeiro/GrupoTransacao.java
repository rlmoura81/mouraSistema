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
        return "GrupoTransacao{" + "cd_gptrans=" + cd_gptrans + ", ds_gptrans=" + ds_gptrans + '}';
    }
    
}
