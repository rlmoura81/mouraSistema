package br.com.rlmoura81.moura.financeiro;

import java.math.BigDecimal;
import java.util.Calendar;

public class PoupancaTransacao {
    
    private int cd_poupaplic;
    private BigDecimal vl_transacao;
    private Calendar dt_transacao;
    private GrupoTransacao gptrans;
    private Poupanca poupanca;
    private int cd_usuario;

    public int getCd_poupaplic() {
        return cd_poupaplic;
    }

    public void setCd_poupaplic(int cd_poupaplic) {
        this.cd_poupaplic = cd_poupaplic;
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

    public Poupanca getPoupanca() {
        return poupanca;
    }

    public void setPoupanca(Poupanca poupanca) {
        this.poupanca = poupanca;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public PoupancaTransacao(int cd_poupaplic, BigDecimal vl_transacao, Calendar dt_transacao, GrupoTransacao gptrans, Poupanca poupanca, int cd_usuario) {
        this.cd_poupaplic = cd_poupaplic;
        this.vl_transacao = vl_transacao;
        this.dt_transacao = dt_transacao;
        this.gptrans = gptrans;
        this.poupanca = poupanca;
        this.cd_usuario = cd_usuario;
    }

    public PoupancaTransacao() {
    }

    @Override
    public String toString() {
        return "PoupancaTransacao{" + "cd_poupaplic=" + cd_poupaplic + ", vl_transacao=" + vl_transacao + ", dt_transacao=" + dt_transacao + ", gptrans=" + gptrans + ", poupanca=" + poupanca + ", cd_usuario=" + cd_usuario + '}';
    }

}
