package br.com.rlmoura81.moura.cartao;

import br.com.rlmoura81.moura.financeiro.Despesa;
import br.com.rlmoura81.moura.principalcadastro.Categoria;
import java.math.BigDecimal;
import java.util.Calendar;

public class CartaoLancamento {
    
    private int cd_cartaolanc;
    private String ds_despesa;
    private BigDecimal nm_valor;
    private int nm_parcela;
    private Calendar dt_despesa;
    private Despesa despesa;
    private Categoria categoria;
    private Cartao cartao;
    private int cd_usuario;

    public int getCd_cartaolanc() {
        return cd_cartaolanc;
    }

    public void setCd_cartaolanc(int cd_cartaolanc) {
        this.cd_cartaolanc = cd_cartaolanc;
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

    public int getNm_parcela() {
        return nm_parcela;
    }

    public void setNm_parcela(int nm_parcela) {
        this.nm_parcela = nm_parcela;
    }

    public Calendar getDt_despesa() {
        return dt_despesa;
    }

    public void setDt_despesa(Calendar dt_despesa) {
        this.dt_despesa = dt_despesa;
    }

    public Despesa getDespesa() {
        return despesa;
    }

    public void setDespesa(Despesa despesa) {
        this.despesa = despesa;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public CartaoLancamento(int cd_cartaolanc, String ds_despesa, BigDecimal nm_valor, int nm_parcela, Calendar dt_despesa, Despesa despesa, Categoria categoria, Cartao cartao, int cd_usuario) {
        this.cd_cartaolanc = cd_cartaolanc;
        this.ds_despesa = ds_despesa;
        this.nm_valor = nm_valor;
        this.nm_parcela = nm_parcela;
        this.dt_despesa = dt_despesa;
        this.despesa = despesa;
        this.categoria = categoria;
        this.cartao = cartao;
        this.cd_usuario = cd_usuario;
    }

    public CartaoLancamento() {
    }

    @Override
    public String toString() {
        return "CartaoLancamento{" + "cd_cartaolanc=" + cd_cartaolanc + ", ds_despesa=" + ds_despesa + ", nm_valor=" + nm_valor + ", nm_parcela=" + nm_parcela + ", dt_despesa=" + dt_despesa + ", despesa=" + despesa + ", categoria=" + categoria + ", cartao=" + cartao + ", cd_usuario=" + cd_usuario + '}';
    }
    
}
