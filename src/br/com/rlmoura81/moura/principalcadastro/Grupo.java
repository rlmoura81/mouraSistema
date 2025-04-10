package br.com.rlmoura81.moura.principalcadastro;

public class Grupo {

    private int cd_grupo;
    private String ds_grupo;
    private int cd_usuario;

    public int getCd_grupo() {
        return cd_grupo;
    }

    public void setCd_grupo(int cd_grupo) {
        this.cd_grupo = cd_grupo;
    }

    public String getDs_grupo() {
        return ds_grupo;
    }

    public void setDs_grupo(String ds_grupo) {
        this.ds_grupo = ds_grupo;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public Grupo(int cd_grupo, String ds_grupo, int cd_usuario) {
        this.cd_grupo = cd_grupo;
        this.ds_grupo = ds_grupo;
        this.cd_usuario = cd_usuario;
    }

    public Grupo() {
    }

    @Override
    public String toString() {
        return ds_grupo;
    }    
    
}
