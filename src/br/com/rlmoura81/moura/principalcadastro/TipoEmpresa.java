package br.com.rlmoura81.moura.principalcadastro;

public class TipoEmpresa {
    
    private Integer cd_tpempresa;
    private String ds_tpempresa;

    public Integer getCd_tpempresa() {
        return cd_tpempresa;
    }

    public void setCd_tpempresa(Integer cd_tpempresa) {
        this.cd_tpempresa = cd_tpempresa;
    }

    public String getDs_tpempresa() {
        return ds_tpempresa;
    }

    public void setDs_tpempresa(String ds_tpempresa) {
        this.ds_tpempresa = ds_tpempresa;
    }

    public TipoEmpresa(Integer cd_tpempresa, String ds_tpempresa) {
        this.cd_tpempresa = cd_tpempresa;
        this.ds_tpempresa = ds_tpempresa;
    }

    public TipoEmpresa() {
    }

    @Override
    public String toString() {
        return "TipoEmpresa{" + "cd_tpempresa=" + cd_tpempresa + ", ds_tpempresa=" + ds_tpempresa + '}';
    }

}
