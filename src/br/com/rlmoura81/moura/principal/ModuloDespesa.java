package br.com.rlmoura81.moura.principal;

import br.com.rlmoura81.moura.principalcadastro.PrestadorServico;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Objects;

public class ModuloDespesa {
    
    private int cd_despesa;
    private Calendar dt_despesa;
    private String nm_nota;
    private String ds_descricao;
    private BigDecimal nm_valor;
    private int nm_qtde;
    private PrestadorServico presserv;
    private int cd_usuario;

    public int getCd_despesa() {
        return cd_despesa;
    }

    public void setCd_despesa(int cd_despesa) {
        this.cd_despesa = cd_despesa;
    }

    public Calendar getDt_despesa() {
        return dt_despesa;
    }

    public void setDt_despesa(Calendar dt_despesa) {
        this.dt_despesa = dt_despesa;
    }

    public String getNm_nota() {
        return nm_nota;
    }

    public void setNm_nota(String nm_nota) {
        this.nm_nota = nm_nota;
    }

    public String getDs_descricao() {
        return ds_descricao;
    }

    public void setDs_descricao(String ds_descricao) {
        this.ds_descricao = ds_descricao;
    }

    public BigDecimal getNm_valor() {
        return nm_valor;
    }

    public void setNm_valor(BigDecimal nm_valor) {
        this.nm_valor = nm_valor;
    }

    public int getNm_qtde() {
        return nm_qtde;
    }

    public void setNm_qtde(int nm_qtde) {
        this.nm_qtde = nm_qtde;
    }

    public PrestadorServico getPresserv() {
        return presserv;
    }

    public void setPresserv(PrestadorServico presserv) {
        this.presserv = presserv;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public ModuloDespesa(int cd_despesa, Calendar dt_despesa, String nm_nota, String ds_descricao, BigDecimal nm_valor, int nm_qtde, PrestadorServico presserv, int cd_usuario) {
        this.cd_despesa = cd_despesa;
        this.dt_despesa = dt_despesa;
        this.nm_nota = nm_nota;
        this.ds_descricao = ds_descricao;
        this.nm_valor = nm_valor;
        this.nm_qtde = nm_qtde;
        this.presserv = presserv;
        this.cd_usuario = cd_usuario;
    }

    public ModuloDespesa(BigDecimal nm_valor) {
        this.nm_valor = nm_valor;
    }

    public ModuloDespesa() {
    }

    @Override
    public String toString() {
        return "ModuloDespesa{" + "cd_despesa=" + cd_despesa + ", dt_despesa=" + dt_despesa + ", nm_nota=" + nm_nota + ", ds_descricao=" + ds_descricao + ", nm_valor=" + nm_valor + ", nm_qtde=" + nm_qtde + ", presserv=" + presserv + ", cd_usuario=" + cd_usuario + '}';
    }
        
}
