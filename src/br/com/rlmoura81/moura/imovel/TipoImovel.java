package br.com.rlmoura81.moura.imovel;

public class TipoImovel {
    
    private int cd_tpimovel;
    private String ds_tpimovel;

    public int getCd_tpimovel() {
        return cd_tpimovel;
    }

    public void setCd_tpimovel(int cd_tpimovel) {
        this.cd_tpimovel = cd_tpimovel;
    }

    public String getDs_tpimovel() {
        return ds_tpimovel;
    }

    public void setDs_tpimovel(String ds_tpimovel) {
        this.ds_tpimovel = ds_tpimovel;
    }

    public TipoImovel(int cd_tpimovel, String ds_tpimovel) {
        this.cd_tpimovel = cd_tpimovel;
        this.ds_tpimovel = ds_tpimovel;
    }

    public TipoImovel() {
    }

    @Override
    public String toString() {
        return ds_tpimovel;
    }
}
