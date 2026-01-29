package br.com.rlmoura81.moura.principalcadastro;

public class Empresa {
    private int cd_empresa;
    private String ds_empresa;
    private String ds_razaosocial;
    private String nm_documento;
    private TipoEmpresa tpEmpresa;
    private int cd_usuario;

    public int getCd_empresa() {
        return cd_empresa;
    }

    public void setCd_empresa(int cd_empresa) {
        this.cd_empresa = cd_empresa;
    }

    public String getDs_empresa() {
        return ds_empresa;
    }

    public void setDs_empresa(String ds_empresa) {
        this.ds_empresa = ds_empresa;
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

    public TipoEmpresa getTpEmpresa() {
        return tpEmpresa;
    }

    public void setTpEmpresa(TipoEmpresa tpEmpresa) {
        this.tpEmpresa = tpEmpresa;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public Empresa(int cd_empresa, String ds_empresa, String ds_razaosocial, String nm_documento, TipoEmpresa tpEmpresa, int cd_usuario) {
        this.cd_empresa = cd_empresa;
        this.ds_empresa = ds_empresa;
        this.ds_razaosocial = ds_razaosocial;
        this.nm_documento = nm_documento;
        this.tpEmpresa = tpEmpresa;
        this.cd_usuario = cd_usuario;
    }

    public Empresa() {
    }

    @Override
    public String toString() {
        return "Empresa{" + "cd_empresa=" + cd_empresa + ", ds_empresa=" + ds_empresa + ", ds_razaosocial=" + ds_razaosocial + ", nm_documento=" + nm_documento + ", tpEmpresa=" + tpEmpresa + ", cd_usuario=" + cd_usuario + '}';
    }

}
