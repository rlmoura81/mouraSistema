package br.com.rlmoura81.moura.animal;

public class Tipo {
    
    private int cd_tipo;
    private String ds_tipo;

    public int getCd_tipo() {
        return cd_tipo;
    }

    public void setCd_tipo(int cd_tipo) {
        this.cd_tipo = cd_tipo;
    }

    public String getDs_tipo() {
        return ds_tipo;
    }

    public void setDs_tipo(String ds_tipo) {
        this.ds_tipo = ds_tipo;
    }

    public Tipo(int cd_tipo, String ds_tipo) {
        this.cd_tipo = cd_tipo;
        this.ds_tipo = ds_tipo;
    }

    public Tipo() {
    }

    @Override
    public String toString() {
        return ds_tipo;
    }
        
}
