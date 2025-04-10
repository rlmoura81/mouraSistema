package br.com.rlmoura81.moura.cartao;

import br.com.rlmoura81.moura.financeiro.Despesa;
import br.com.rlmoura81.moura.principalcadastro.Categoria;
import java.math.BigDecimal;
import java.util.Calendar;

public class CartaoLancamentoFechamento extends CartaoLancamento{
        
    private int cd_cartaolancf;
    private Calendar dt_fechamento;

    public int getCd_cartaolancf() {
        return cd_cartaolancf;
    }

    public void setCd_cartaolancf(int cd_cartaolancf) {
        this.cd_cartaolancf = cd_cartaolancf;
    }

    public Calendar getDt_fechamento() {
        return dt_fechamento;
    }

    public void setDt_fechamento(Calendar dt_fechamento) {
        this.dt_fechamento = dt_fechamento;
    }

    public CartaoLancamentoFechamento(int cd_cartaolancf, Calendar dt_fechamento, int cd_cartaolanc, String ds_despesa, BigDecimal nm_valor, int nm_parcela, Calendar dt_despesa, Despesa despesa, Categoria categoria, Cartao cartao, int cd_usuario) {
        super(cd_cartaolanc, ds_despesa, nm_valor, nm_parcela, dt_despesa, despesa, categoria, cartao, cd_usuario);
        this.cd_cartaolancf = cd_cartaolancf;
        this.dt_fechamento = dt_fechamento;
    }

    public CartaoLancamentoFechamento(int cd_cartaolancf, Calendar dt_fechamento) {
        this.cd_cartaolancf = cd_cartaolancf;
        this.dt_fechamento = dt_fechamento;
    }

    public CartaoLancamentoFechamento() {
    }

    @Override
    public String toString() {
        return "Data Fechamento";
    }

}
