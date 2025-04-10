package br.com.rlmoura81.moura.veiculo;

public class Cores {
    
    private int cd_cor;
    private String ds_cor;

    public int getCd_cor() {
        return cd_cor;
    }

    public void setCd_cor(int cd_cor) {
        this.cd_cor = cd_cor;
    }

    public String getDs_cor() {
        return ds_cor;
    }

    public void setDs_cor(String ds_cor) {
        this.ds_cor = ds_cor;
    }

    public Cores(int cd_cor, String ds_cor) {
        this.cd_cor = cd_cor;
        this.ds_cor = ds_cor;
    }

    public Cores() {
    }

    @Override
    public String toString() {
        return ds_cor;
    }

}
