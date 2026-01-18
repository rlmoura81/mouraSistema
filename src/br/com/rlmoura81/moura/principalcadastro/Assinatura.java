package br.com.rlmoura81.moura.principalcadastro;

import java.math.BigDecimal;
import java.util.Calendar;

public class Assinatura {
    
    private int cd_assinatura;
    private String ds_servico;
    private String ds_login;
    private String ds_senha;
    private Empresa empresa;
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

    public Assinatura(int cd_assinatura, String ds_servico, String ds_login, String ds_senha, Empresa empresa, int cd_usuario) {
        this.cd_assinatura = cd_assinatura;
        this.ds_servico = ds_servico;
        this.ds_login = ds_login;
        this.ds_senha = ds_senha;
        this.empresa = empresa;
        this.cd_usuario = cd_usuario;
    }

    public Assinatura() {
    }

    @Override
    public String toString() {
        return "Assinatura{" + "cd_assinatura=" + cd_assinatura + ", ds_servico=" + ds_servico + ", ds_login=" + ds_login + ", ds_senha=" + ds_senha + ", empresa=" + empresa + ", cd_usuario=" + cd_usuario + '}';
    }
    
}
