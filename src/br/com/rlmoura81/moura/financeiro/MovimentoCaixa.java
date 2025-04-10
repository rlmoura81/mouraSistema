package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principalcadastro.Categoria;
import java.math.BigDecimal;
import java.util.Calendar;

public class MovimentoCaixa {
    
    private int cd_movcx;
    private Calendar dt_transacao;
    private String ds_descricao;
    private BigDecimal vl_credito;
    private BigDecimal vl_debito;
    private String nm_documento;
    private Renda renda;
    private Despesa despesa;
    private Categoria categoria;
    private TipoTransacao tipotransacao;
    private Conta conta;
    private int cd_usuario;

    public int getCd_movcx() {
        return cd_movcx;
    }

    public void setCd_movcx(int cd_movcx) {
        this.cd_movcx = cd_movcx;
    }

    public Calendar getDt_transacao() {
        return dt_transacao;
    }

    public void setDt_transacao(Calendar dt_transacao) {
        this.dt_transacao = dt_transacao;
    }

    public String getDs_descricao() {
        return ds_descricao;
    }

    public void setDs_descricao(String ds_descricao) {
        this.ds_descricao = ds_descricao;
    }

    public BigDecimal getVl_credito() {
        return vl_credito;
    }

    public void setVl_credito(BigDecimal vl_credito) {
        this.vl_credito = vl_credito;
    }

    public BigDecimal getVl_debito() {
        return vl_debito;
    }

    public void setVl_debito(BigDecimal vl_debito) {
        this.vl_debito = vl_debito;
    }

    public String getNm_documento() {
        return nm_documento;
    }

    public void setNm_documento(String nm_documento) {
        this.nm_documento = nm_documento;
    }

    public Renda getRenda() {
        return renda;
    }

    public void setRenda(Renda renda) {
        this.renda = renda;
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

    public TipoTransacao getTipotransacao() {
        return tipotransacao;
    }

    public void setTipotransacao(TipoTransacao tipotransacao) {
        this.tipotransacao = tipotransacao;
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

    public MovimentoCaixa(int cd_movcx, Calendar dt_transacao, String ds_descricao, BigDecimal vl_credito, BigDecimal vl_debito, String nm_documento, Renda renda, Despesa despesa, Categoria categoria, TipoTransacao tipotransacao, Conta conta, int cd_usuario) {
        this.cd_movcx = cd_movcx;
        this.dt_transacao = dt_transacao;
        this.ds_descricao = ds_descricao;
        this.vl_credito = vl_credito;
        this.vl_debito = vl_debito;
        this.nm_documento = nm_documento;
        this.renda = renda;
        this.despesa = despesa;
        this.categoria = categoria;
        this.tipotransacao = tipotransacao;
        this.conta = conta;
        this.cd_usuario = cd_usuario;
    }

    public MovimentoCaixa() {
    }

    @Override
    public String toString() {
        return "MovimentoCaixa{" + "cd_movcx=" + cd_movcx + ", dt_transacao=" + dt_transacao + ", ds_descricao=" + ds_descricao + ", vl_credito=" + vl_credito + ", vl_debito=" + vl_debito + ", nm_documento=" + nm_documento + ", renda=" + renda + ", despesa=" + despesa + ", categoria=" + categoria + ", tipotransacao=" + tipotransacao + ", conta=" + conta + ", cd_usuario=" + cd_usuario + '}';
    }
    
    private BigDecimal vl_total;

    public BigDecimal getVl_total() {
        return vl_total;
    }

    public void setVl_total(BigDecimal vl_total) {
        this.vl_total = vl_total;
    }

    public MovimentoCaixa(BigDecimal vl_credito, BigDecimal vl_debito, BigDecimal vl_total) {
        this.vl_credito = vl_credito;
        this.vl_debito = vl_debito;
        this.vl_total = vl_total;
    }
            
}
