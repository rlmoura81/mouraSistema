package br.com.rlmoura81.moura.principal;

public class Modulo {
    
    private int cd_modulo;
    private String ds_modulo;

    public int getCd_modulo() {
        return cd_modulo;
    }

    public void setCd_modulo(int cd_modulo) {
        this.cd_modulo = cd_modulo;
    }

    public String getDs_modulo() {
        return ds_modulo;
    }

    public void setDs_modulo(String ds_modulo) {
        this.ds_modulo = ds_modulo;
    }

    public Modulo(int cd_modulo, String ds_modulo) {
        this.cd_modulo = cd_modulo;
        this.ds_modulo = ds_modulo;
    }

    public Modulo() {
    }
    
    @Override
    public String toString() {
        return ds_modulo;
    }

}
