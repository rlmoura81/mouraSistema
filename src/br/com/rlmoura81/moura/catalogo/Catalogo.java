package br.com.rlmoura81.moura.catalogo;

public class Catalogo {

    private int cd_catalogo;
    private String ds_titulo;
    private int nm_numero;
    private int nm_volume;
    private int nm_edicao;
    private String ds_observacao;
    private TipoMidia tipomidia;
    private Editora editora;
    private Status status;
    private int cd_usuario;

    public int getCd_catalogo() {
        return cd_catalogo;
    }

    public void setCd_catalogo(int cd_catalogo) {
        this.cd_catalogo = cd_catalogo;
    }

    public String getDs_titulo() {
        return ds_titulo;
    }

    public void setDs_titulo(String ds_titulo) {
        this.ds_titulo = ds_titulo;
    }

    public int getNm_numero() {
        return nm_numero;
    }

    public void setNm_numero(int nm_numero) {
        this.nm_numero = nm_numero;
    }

    public int getNm_volume() {
        return nm_volume;
    }

    public void setNm_volume(int nm_volume) {
        this.nm_volume = nm_volume;
    }

    public int getNm_edicao() {
        return nm_edicao;
    }

    public void setNm_edicao(int nm_edicao) {
        this.nm_edicao = nm_edicao;
    }

    public String getDs_observacao() {
        return ds_observacao;
    }

    public void setDs_observacao(String ds_observacao) {
        this.ds_observacao = ds_observacao;
    }

    public TipoMidia getTipomidia() {
        return tipomidia;
    }

    public void setTipomidia(TipoMidia tipomidia) {
        this.tipomidia = tipomidia;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public Catalogo(int cd_catalogo, String ds_titulo, int nm_numero, int nm_volume, int nm_edicao, String ds_observacao, TipoMidia tipomidia, Editora editora, Status status, int cd_usuario) {
        this.cd_catalogo = cd_catalogo;
        this.ds_titulo = ds_titulo;
        this.nm_numero = nm_numero;
        this.nm_volume = nm_volume;
        this.nm_edicao = nm_edicao;
        this.ds_observacao = ds_observacao;
        this.tipomidia = tipomidia;
        this.editora = editora;
        this.status = status;
        this.cd_usuario = cd_usuario;
    }

    public Catalogo() {
    }

    @Override
    public String toString() {
        return ds_titulo;
    }

}
