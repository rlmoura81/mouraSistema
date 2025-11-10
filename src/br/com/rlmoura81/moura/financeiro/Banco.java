package br.com.rlmoura81.moura.financeiro;

import java.util.Objects;

public class Banco {
    private int cd_banco;
    private String ds_banco;
    private int nm_banco;
    private int cd_usuario;

    public int getCd_banco() {
        return cd_banco;
    }

    public void setCd_banco(int cd_banco) {
        this.cd_banco = cd_banco;
    }

    public String getDs_banco() {
        return ds_banco;
    }

    public void setDs_banco(String ds_banco) {
        this.ds_banco = ds_banco;
    }

    public int getNm_banco() {
        return nm_banco;
    }

    public void setNm_banco(int nm_banco) {
        this.nm_banco = nm_banco;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public Banco(int cd_banco, String ds_banco, int nm_banco, int cd_usuario) {
        this.cd_banco = cd_banco;
        this.ds_banco = ds_banco;
        this.nm_banco = nm_banco;
        this.cd_usuario = cd_usuario;
    }

    public Banco() {
    }

    @Override
    public String toString() {
        return "Banco{" + "cd_banco=" + cd_banco + ", ds_banco=" + ds_banco + ", nm_banco=" + nm_banco + ", cd_usuario=" + cd_usuario + '}';
    }

}
