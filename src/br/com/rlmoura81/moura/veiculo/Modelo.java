package br.com.rlmoura81.moura.veiculo;

public class Modelo {
    
    private int cd_modelo;
    private String ds_modelo;
    private Marca marca;
    private int cd_usuario;

    public int getCd_modelo() {
        return cd_modelo;
    }

    public void setCd_modelo(int cd_modelo) {
        this.cd_modelo = cd_modelo;
    }

    public String getDs_modelo() {
        return ds_modelo;
    }

    public void setDs_modelo(String ds_modelo) {
        this.ds_modelo = ds_modelo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public Modelo(int cd_modelo, String ds_modelo, Marca marca, int cd_usuario) {
        this.cd_modelo = cd_modelo;
        this.ds_modelo = ds_modelo;
        this.marca = marca;
        this.cd_usuario = cd_usuario;
    }

    public Modelo() {
    }

    @Override
    public String toString() {
        return ds_modelo;
    }    
}
