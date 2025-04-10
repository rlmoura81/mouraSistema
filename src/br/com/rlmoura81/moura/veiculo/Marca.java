package br.com.rlmoura81.moura.veiculo;

public class Marca {
    
    private int cd_marca;
    private String ds_marca;

    public int getCd_marca() {
        return cd_marca;
    }

    public void setCd_marca(int cd_marca) {
        this.cd_marca = cd_marca;
    }

    public String getDs_marca() {
        return ds_marca;
    }

    public void setDs_marca(String ds_marca) {
        this.ds_marca = ds_marca;
    }

    public Marca(int cd_marca, String ds_marca) {
        this.cd_marca = cd_marca;
        this.ds_marca = ds_marca;
    }

    public Marca() {
    }

    @Override
    public String toString() {
        return ds_marca;
    }
}
