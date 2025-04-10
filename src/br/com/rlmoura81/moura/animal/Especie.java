package br.com.rlmoura81.moura.animal;

public class Especie {

    private int cd_especie;
    private String ds_especie;

    public int getCd_especie() {
        return cd_especie;
    }

    public void setCd_especie(int cd_especie) {
        this.cd_especie = cd_especie;
    }

    public String getDs_especie() {
        return ds_especie;
    }

    public void setDs_especie(String ds_especie) {
        this.ds_especie = ds_especie;
    }

    public Especie(int cd_especie, String ds_especie) {
        this.cd_especie = cd_especie;
        this.ds_especie = ds_especie;
    }

    public Especie(){
    }

    @Override
    public String toString() {
        return ds_especie;
    }

}
