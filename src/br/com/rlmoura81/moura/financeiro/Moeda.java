package br.com.rlmoura81.moura.financeiro;

public class Moeda {
    
    private int cd_moeda;
    private String ds_moeda;

    public int getCd_moeda() {
        return cd_moeda;
    }

    public void setCd_moeda(int cd_moeda) {
        this.cd_moeda = cd_moeda;
    }

    public String getDs_moeda() {
        return ds_moeda;
    }

    public void setDs_moeda(String ds_moeda) {
        this.ds_moeda = ds_moeda;
    }

    public Moeda(int cd_moeda, String ds_moeda) {
        this.cd_moeda = cd_moeda;
        this.ds_moeda = ds_moeda;
    }

    public Moeda() {
    }

    @Override
    public String toString() {
        return ds_moeda;
    }
    
}
