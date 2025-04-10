package br.com.rlmoura81.moura.financeiro;

public class Ativo {
    
    private int cd_ativo;
    private String ds_ativo;
    private String ds_sgativo;
    private String nm_cnpj;
    private TipoAtivo tpativo;
    private int cd_usuario;

    public int getCd_ativo() {
        return cd_ativo;
    }

    public void setCd_ativo(int cd_ativo) {
        this.cd_ativo = cd_ativo;
    }

    public String getDs_ativo() {
        return ds_ativo;
    }

    public void setDs_ativo(String ds_ativo) {
        this.ds_ativo = ds_ativo;
    }

    public String getDs_sgativo() {
        return ds_sgativo;
    }

    public void setDs_sgativo(String ds_sgativo) {
        this.ds_sgativo = ds_sgativo;
    }

    public String getNm_cnpj() {
        return nm_cnpj;
    }

    public void setNm_cnpj(String nm_cnpj) {
        this.nm_cnpj = nm_cnpj;
    }

    public TipoAtivo getTpativo() {
        return tpativo;
    }

    public void setTpativo(TipoAtivo tpativo) {
        this.tpativo = tpativo;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public Ativo(int cd_ativo, String ds_ativo, String ds_sgativo, String nm_cnpj, TipoAtivo tpativo, int cd_usuario) {
        this.cd_ativo = cd_ativo;
        this.ds_ativo = ds_ativo;
        this.ds_sgativo = ds_sgativo;
        this.nm_cnpj = nm_cnpj;
        this.tpativo = tpativo;
        this.cd_usuario = cd_usuario;
    }

    public Ativo() {
    }
    
    @Override
    public String toString() {
        return ds_sgativo;
    }   
    
}
