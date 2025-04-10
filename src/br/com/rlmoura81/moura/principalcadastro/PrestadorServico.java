package br.com.rlmoura81.moura.principalcadastro;

public class PrestadorServico {
    private int cd_presserv;
    private String ds_presserv;
    private String ds_razaosocial;
    private String nm_documento;
    private int cd_usuario;

    public int getCd_presserv() {
        return cd_presserv;
    }

    public void setCd_presserv(int cd_presserv) {
        this.cd_presserv = cd_presserv;
    }

    public String getDs_presserv() {
        return ds_presserv;
    }

    public void setDs_presserv(String ds_presserv) {
        this.ds_presserv = ds_presserv;
    }

    public String getDs_razaosocial() {
        return ds_razaosocial;
    }

    public void setDs_razaosocial(String ds_razaosocial) {
        this.ds_razaosocial = ds_razaosocial;
    }

    public String getNm_documento() {
        return nm_documento;
    }

    public void setNm_documento(String nm_documento) {
        this.nm_documento = nm_documento;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public PrestadorServico(int cd_presserv, String ds_presserv, String ds_razaosocial, String nm_documento, int cd_usuario) {
        this.cd_presserv = cd_presserv;
        this.ds_presserv = ds_presserv;
        this.ds_razaosocial = ds_razaosocial;
        this.nm_documento = nm_documento;
        this.cd_usuario = cd_usuario;
    }

    public PrestadorServico() {
    }
    
    @Override
    public String toString() {
        return ds_presserv;
    }
}
