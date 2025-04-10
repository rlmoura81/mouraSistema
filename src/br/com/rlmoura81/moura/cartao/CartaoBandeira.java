package br.com.rlmoura81.moura.cartao;

public class CartaoBandeira {
    
    private int cd_cartaobandeira;
    private String ds_cartaobandeira;

    public int getCd_cartaobandeira() {
        return cd_cartaobandeira;
    }

    public void setCd_cartaobandeira(int cd_cartaobandeira) {
        this.cd_cartaobandeira = cd_cartaobandeira;
    }

    public String getDs_cartaobandeira() {
        return ds_cartaobandeira;
    }

    public void setDs_cartaobandeira(String ds_cartaobandeira) {
        this.ds_cartaobandeira = ds_cartaobandeira;
    }

    public CartaoBandeira(int cd_cartaobandeira, String ds_cartaobandeira) {
        this.cd_cartaobandeira = cd_cartaobandeira;
        this.ds_cartaobandeira = ds_cartaobandeira;
    }

    public CartaoBandeira() {
    }

    @Override
    public String toString() {
        return ds_cartaobandeira;
    }

}
