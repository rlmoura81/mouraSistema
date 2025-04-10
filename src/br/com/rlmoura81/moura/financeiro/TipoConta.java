package br.com.rlmoura81.moura.financeiro;

public class TipoConta {
    
    private int cd_tpconta;
    private String ds_tpconta;

    public int getCd_tpconta() {
        return cd_tpconta;
    }

    public void setCd_tpconta(int cd_tpconta) {
        this.cd_tpconta = cd_tpconta;
    }

    public String getDs_tpconta() {
        return ds_tpconta;
    }

    public void setDs_tpconta(String ds_tpconta) {
        this.ds_tpconta = ds_tpconta;
    }

    public TipoConta(int cd_tpconta, String ds_tpconta) {
        this.cd_tpconta = cd_tpconta;
        this.ds_tpconta = ds_tpconta;
    }

    public TipoConta() {
    }

    @Override
    public String toString() {
        return ds_tpconta;
    }
    
}
