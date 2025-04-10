package br.com.rlmoura81.moura.animal;

import java.math.BigDecimal;

public class Produto {
    
    private int cd_produto;
    private String ds_produto;
    private BigDecimal nm_peso;
    private int cd_usuario;

    public int getCd_produto() {
        return cd_produto;
    }

    public void setCd_produto(int cd_produto) {
        this.cd_produto = cd_produto;
    }

    public String getDs_produto() {
        return ds_produto;
    }

    public void setDs_produto(String ds_produto) {
        this.ds_produto = ds_produto;
    }

    public BigDecimal getNm_peso() {
        return nm_peso;
    }

    public void setNm_peso(BigDecimal nm_peso) {
        this.nm_peso = nm_peso;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public Produto(int cd_produto, String ds_produto, BigDecimal nm_peso, int cd_usuario) {
        this.cd_produto = cd_produto;
        this.ds_produto = ds_produto;
        this.nm_peso = nm_peso;
        this.cd_usuario = cd_usuario;
    }

    public Produto() {
    }

    @Override
    public String toString() {
        return ds_produto;
    }

}
