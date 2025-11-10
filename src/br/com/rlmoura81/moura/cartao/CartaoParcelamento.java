package br.com.rlmoura81.moura.cartao;

import br.com.rlmoura81.moura.financeiro.Despesa;
import br.com.rlmoura81.moura.principalcadastro.Categoria;
import java.math.BigDecimal;
import java.util.Calendar;

public class CartaoParcelamento extends CartaoLancamento{
    
    private int cd_parcela;
    private Calendar dt_parcela;
    private int nm_parcelapag;

    public int getCd_parcela() {
        return cd_parcela;
    }

    public void setCd_parcela(int cd_parcela) {
        this.cd_parcela = cd_parcela;
    }

    public Calendar getDt_parcela() {
        return dt_parcela;
    }

    public void setDt_parcela(Calendar dt_parcela) {
        this.dt_parcela = dt_parcela;
    }

    public int getNm_parcelapag() {
        return nm_parcelapag;
    }

    public void setNm_parcelapag(int nm_parcelapag) {
        this.nm_parcelapag = nm_parcelapag;
    }

    public CartaoParcelamento(int cd_parcela, Calendar dt_parcela, int nm_parcelapag, int cd_cartaolanc, String ds_despesa, BigDecimal nm_valor, int nm_parcela, Calendar dt_despesa, Despesa despesa, Categoria categoria, Cartao cartao, int cd_usuario) {
        super(cd_cartaolanc, ds_despesa, nm_valor, nm_parcela, dt_despesa, despesa, categoria, cartao, cd_usuario);
        this.cd_parcela = cd_parcela;
        this.dt_parcela = dt_parcela;
        this.nm_parcelapag = nm_parcelapag;
    }

    public CartaoParcelamento(int cd_parcela, Calendar dt_parcela, int nm_parcelapag) {
        this.cd_parcela = cd_parcela;
        this.dt_parcela = dt_parcela;
        this.nm_parcelapag = nm_parcelapag;
    }

    public CartaoParcelamento(int cd_parcela, String ds_despesa){
        this.cd_parcela = cd_parcela;
        this.ds_despesa = ds_despesa;
    }
    
    public CartaoParcelamento() {
    }

    @Override
    /*public String toString() {
        return "CartaoParcelamento{" + "cd_parcela=" + cd_parcela + ", dt_parcela=" + dt_parcela + ", nm_parcelapag=" + nm_parcelapag + '}';
    }*/

    public String toString() {
        return ds_despesa;
    }
}
