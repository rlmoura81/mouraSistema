package br.com.rlmoura81.moura.financeiro;

import java.math.BigDecimal;

public class NotaCorretagemLancamento {

    private NotaCorretagem nota;
    private Ativo ativo;
    private int nm_qtde;
    private BigDecimal nm_valor;
    private GrupoTransacao gptrans;
    private int cd_usuario;

    public NotaCorretagem getNota() {
        return nota;
    }

    public void setNota(NotaCorretagem nota) {
        this.nota = nota;
    }

    public Ativo getAtivo() {
        return ativo;
    }

    public void setAtivo(Ativo ativo) {
        this.ativo = ativo;
    }

    public int getNm_qtde() {
        return nm_qtde;
    }

    public void setNm_qtde(int nm_qtde) {
        this.nm_qtde = nm_qtde;
    }

    public BigDecimal getNm_valor() {
        return nm_valor;
    }

    public void setNm_valor(BigDecimal nm_valor) {
        this.nm_valor = nm_valor;
    }

    public GrupoTransacao getGptrans() {
        return gptrans;
    }

    public void setGptrans(GrupoTransacao gptrans) {
        this.gptrans = gptrans;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public NotaCorretagemLancamento(NotaCorretagem nota, Ativo ativo, int nm_qtde, BigDecimal nm_valor, GrupoTransacao gptrans, int cd_usuario) {
        this.nota = nota;
        this.ativo = ativo;
        this.nm_qtde = nm_qtde;
        this.nm_valor = nm_valor;
        this.gptrans = gptrans;
        this.cd_usuario = cd_usuario;
    }

    public NotaCorretagemLancamento() {
    }

    @Override
    public String toString() {
        return "NotaCorretagemLancamento{" + "nota=" + nota + ", ativo=" + ativo + ", nm_qtde=" + nm_qtde + ", nm_valor=" + nm_valor + ", gptrans=" + gptrans + ", cd_usuario=" + cd_usuario + '}';
    }
    
}
