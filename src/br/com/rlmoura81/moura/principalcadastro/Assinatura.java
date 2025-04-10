package br.com.rlmoura81.moura.principalcadastro;

import java.math.BigDecimal;
import java.util.Calendar;

public class Assinatura {
    
    private int cd_assinatura;
    private String ds_servico;
    private String ds_login;
    private String ds_senha;
    private BigDecimal nm_valor;
    private int tp_assinatura;
    private Calendar dt_validade;
    private PrestadorServico presserv;
    private int cd_usuario;

    public int getCd_assinatura() {
        return cd_assinatura;
    }

    public void setCd_assinatura(int cd_assinatura) {
        this.cd_assinatura = cd_assinatura;
    }

    public String getDs_servico() {
        return ds_servico;
    }

    public void setDs_servico(String ds_servico) {
        this.ds_servico = ds_servico;
    }

    public String getDs_login() {
        return ds_login;
    }

    public void setDs_login(String ds_login) {
        this.ds_login = ds_login;
    }

    public String getDs_senha() {
        return ds_senha;
    }

    public void setDs_senha(String ds_senha) {
        this.ds_senha = ds_senha;
    }

    public BigDecimal getNm_valor() {
        return nm_valor;
    }

    public void setNm_valor(BigDecimal nm_valor) {
        this.nm_valor = nm_valor;
    }

    public int getTp_assinatura() {
        return tp_assinatura;
    }

    public void setTp_assinatura(int tp_assinatura) {
        this.tp_assinatura = tp_assinatura;
    }

    public Calendar getDt_validade() {
        return dt_validade;
    }

    public void setDt_validade(Calendar dt_validade) {
        this.dt_validade = dt_validade;
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

    public Assinatura(int cd_assinatura, String ds_servico, String ds_login, String ds_senha, BigDecimal nm_valor, int tp_assinatura, Calendar dt_validade, PrestadorServico presserv, int cd_usuario) {
        this.cd_assinatura = cd_assinatura;
        this.ds_servico = ds_servico;
        this.ds_login = ds_login;
        this.ds_senha = ds_senha;
        this.nm_valor = nm_valor;
        this.tp_assinatura = tp_assinatura;
        this.dt_validade = dt_validade;
        this.presserv = presserv;
        this.cd_usuario = cd_usuario;
    }

    public Assinatura() {
    }

    @Override
    public String toString() {
        return "Assinatura{" + "cd_assinatura=" + cd_assinatura + ", ds_servico=" + ds_servico + ", ds_login=" + ds_login + ", ds_senha=" + ds_senha + ", nm_valor=" + nm_valor + ", tp_assinatura=" + tp_assinatura + ", dt_validade=" + dt_validade + ", presserv=" + presserv + ", cd_usuario=" + cd_usuario + '}';
    }
    
}
