package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principalcadastro.Categoria;
import br.com.rlmoura81.moura.principalcadastro.Empresa;
import java.math.BigDecimal;

public class Despesa {
    private int cd_despesa;
    private String ds_despesa;
    private BigDecimal nm_valor;
    private Categoria categoria;
    private Empresa empresa;
    private int cd_usuario;

    public int getCd_despesa() {
        return cd_despesa;
    }

    public void setCd_despesa(int cd_despesa) {
        this.cd_despesa = cd_despesa;
    }

    public String getDs_despesa() {
        return ds_despesa;
    }

    public void setDs_despesa(String ds_despesa) {
        this.ds_despesa = ds_despesa;
    }

    public BigDecimal getNm_valor() {
        return nm_valor;
    }

    public void setNm_valor(BigDecimal nm_valor) {
        this.nm_valor = nm_valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public Despesa(int cd_despesa, String ds_despesa, BigDecimal nm_valor, Categoria categoria, Empresa empresa, int cd_usuario) {
        this.cd_despesa = cd_despesa;
        this.ds_despesa = ds_despesa;
        this.nm_valor = nm_valor;
        this.categoria = categoria;
        this.empresa = empresa;
        this.cd_usuario = cd_usuario;
    }

    public Despesa() {
    }

    @Override
    public String toString() {
        return ds_despesa;
    }
}
