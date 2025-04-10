package br.com.rlmoura81.moura.animal;

import br.com.rlmoura81.moura.principalcadastro.PrestadorServico;
import java.util.Calendar;

public class Historico {
    
    private int cd_historico;
    private Calendar dt_historico;
    private String ds_historico;
    private PrestadorServico presserv;
    private Animal animal;
    private Tipo tipo;
    private int cd_usuario;

    public int getCd_historico() {
        return cd_historico;
    }

    public void setCd_historico(int cd_historico) {
        this.cd_historico = cd_historico;
    }

    public Calendar getDt_historico() {
        return dt_historico;
    }

    public void setDt_historico(Calendar dt_historico) {
        this.dt_historico = dt_historico;
    }

    public String getDs_historico() {
        return ds_historico;
    }

    public void setDs_historico(String ds_historico) {
        this.ds_historico = ds_historico;
    }

    public PrestadorServico getPresserv() {
        return presserv;
    }

    public void setPresserv(PrestadorServico presserv) {
        this.presserv = presserv;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public Historico(int cd_historico, Calendar dt_historico, String ds_historico, PrestadorServico presserv, Animal animal, Tipo tipo, int cd_usuario) {
        this.cd_historico = cd_historico;
        this.dt_historico = dt_historico;
        this.ds_historico = ds_historico;
        this.presserv = presserv;
        this.animal = animal;
        this.tipo = tipo;
        this.cd_usuario = cd_usuario;
    }

    public Historico() {
    }

    @Override
    public String toString() {
        return "Historico{" + "cd_historico=" + cd_historico + ", dt_historico=" + dt_historico + ", ds_historico=" + ds_historico + ", presserv=" + presserv + ", animal=" + animal + ", tipo=" + tipo + ", cd_usuario=" + cd_usuario + '}';
    }
    
    
}
