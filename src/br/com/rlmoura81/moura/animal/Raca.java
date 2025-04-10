package br.com.rlmoura81.moura.animal;

public class Raca {
    
    private int cd_raca;
    private String ds_raca;
    private Especie especie;
    private int cd_usuario;

    public int getCd_raca() {
        return cd_raca;
    }

    public void setCd_raca(int cd_raca) {
        this.cd_raca = cd_raca;
    }

    public String getDs_raca() {
        return ds_raca;
    }

    public void setDs_raca(String ds_raca) {
        this.ds_raca = ds_raca;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public Raca(int cd_raca, String ds_raca, Especie especie, int cd_usuario) {
        this.cd_raca = cd_raca;
        this.ds_raca = ds_raca;
        this.especie = especie;
        this.cd_usuario = cd_usuario;
    }

    public Raca() {
    }

    @Override
    public String toString() {
        return ds_raca;
    }

}
