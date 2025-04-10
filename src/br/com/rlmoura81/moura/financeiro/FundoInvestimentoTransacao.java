package br.com.rlmoura81.moura.financeiro;

import java.math.BigDecimal;
import java.util.Calendar;

public class FundoInvestimentoTransacao {
    
    private int cd_fdinvesttrans;
    private BigDecimal vl_transacao;
    private Calendar dt_transacao;
    private GrupoTransacao gptrans;
    private FundoInvestimentoAplicacao fdinvestap;
    private Conta conta;
    private int cd_usuario;

    public int getCd_fdinvesttrans() {
        return cd_fdinvesttrans;
    }

    public void setCd_fdinvesttrans(int cd_fdinvesttrans) {
        this.cd_fdinvesttrans = cd_fdinvesttrans;
    }

    public BigDecimal getVl_transacao() {
        return vl_transacao;
    }

    public void setVl_transacao(BigDecimal vl_transacao) {
        this.vl_transacao = vl_transacao;
    }

    public Calendar getDt_transacao() {
        return dt_transacao;
    }

    public void setDt_transacao(Calendar dt_transacao) {
        this.dt_transacao = dt_transacao;
    }

    public GrupoTransacao getGptrans() {
        return gptrans;
    }

    public void setGptrans(GrupoTransacao gptrans) {
        this.gptrans = gptrans;
    }

    public FundoInvestimentoAplicacao getFdinvestap() {
        return fdinvestap;
    }

    public void setFdinvestap(FundoInvestimentoAplicacao fdinvestap) {
        this.fdinvestap = fdinvestap;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public FundoInvestimentoTransacao(int cd_fdinvesttrans, BigDecimal vl_transacao, Calendar dt_transacao, GrupoTransacao gptrans, FundoInvestimentoAplicacao fdinvestap, Conta conta, int cd_usuario) {
        this.cd_fdinvesttrans = cd_fdinvesttrans;
        this.vl_transacao = vl_transacao;
        this.dt_transacao = dt_transacao;
        this.gptrans = gptrans;
        this.fdinvestap = fdinvestap;
        this.conta = conta;
        this.cd_usuario = cd_usuario;
    }

    public FundoInvestimentoTransacao() {
    }

    @Override
    public String toString() {
        return "FundoInvestimentoTransacao{" + "cd_fdinvesttrans=" + cd_fdinvesttrans + ", vl_transacao=" + vl_transacao + ", dt_transacao=" + dt_transacao + ", gptrans=" + gptrans + ", fdinvestap=" + fdinvestap + ", conta=" + conta + ", cd_usuario=" + cd_usuario + '}';
    }
  
}
