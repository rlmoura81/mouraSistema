package br.com.rlmoura81.moura.veiculo;

public class Combustivel {
    
    private int cd_combustivel;
    private String ds_combustivel;

    public int getCd_combustivel() {
        return cd_combustivel;
    }

    public void setCd_combustivel(int cd_combustivel) {
        this.cd_combustivel = cd_combustivel;
    }

    public String getDs_combustivel() {
        return ds_combustivel;
    }

    public void setDs_combustivel(String ds_combustivel) {
        this.ds_combustivel = ds_combustivel;
    }

    public Combustivel(int cd_combustivel, String ds_combustivel) {
        this.cd_combustivel = cd_combustivel;
        this.ds_combustivel = ds_combustivel;
    }

    public Combustivel() {
    }

    @Override
    public String toString() {
        return ds_combustivel;
    }
 
}
