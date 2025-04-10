package br.com.rlmoura81.moura.catalogo;

public class Editora {
    
    private int cd_editora;
    private String ds_nome;
    private int cd_usuario;

    public int getCd_editora() {
        return cd_editora;
    }

    public void setCd_editora(int cd_editora) {
        this.cd_editora = cd_editora;
    }

    public String getDs_nome() {
        return ds_nome;
    }

    public void setDs_nome(String ds_nome) {
        this.ds_nome = ds_nome;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public Editora(int cd_editora, String ds_nome, int cd_usuario) {
        this.cd_editora = cd_editora;
        this.ds_nome = ds_nome;
        this.cd_usuario = cd_usuario;
    }

    public Editora() {
    }

    @Override
    public String toString() {
        return ds_nome;
    }

}
