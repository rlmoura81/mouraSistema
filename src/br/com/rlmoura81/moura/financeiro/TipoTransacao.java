package br.com.rlmoura81.moura.financeiro;

public class TipoTransacao {
        
    private int cd_tptrans;
    private String ds_tptrans;
    private GrupoTransacao gptrans;

    public int getCd_tptrans() {
        return cd_tptrans;
    }

    public void setCd_tptrans(int cd_tptrans) {
        this.cd_tptrans = cd_tptrans;
    }

    public String getDs_tptrans() {
        return ds_tptrans;
    }

    public void setDs_tptrans(String ds_tptrans) {
        this.ds_tptrans = ds_tptrans;
    }

    public GrupoTransacao getGptrans() {
        return gptrans;
    }

    public void setGptrans(GrupoTransacao gptrans) {
        this.gptrans = gptrans;
    }

    public TipoTransacao(int cd_tptrans, String ds_tptrans, GrupoTransacao gptrans) {
        this.cd_tptrans = cd_tptrans;
        this.ds_tptrans = ds_tptrans;
        this.gptrans = gptrans;
    }

    public TipoTransacao() {
    }

    @Override
    public String toString() {
        return ds_tptrans;
    }
}
