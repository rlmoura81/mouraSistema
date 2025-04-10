package br.com.rlmoura81.moura.animal;

import java.util.Calendar;

public class Animal {

    private int cd_animal;
    private String ds_nome;
    private Calendar dt_nasc;
    private String ds_sexo;
    private Raca raca;
    private int cd_usuario;

    public int getCd_animal() {
        return cd_animal;
    }

    public void setCd_animal(int cd_animal) {
        this.cd_animal = cd_animal;
    }

    public String getDs_nome() {
        return ds_nome;
    }

    public void setDs_nome(String ds_nome) {
        this.ds_nome = ds_nome;
    }

    public Calendar getDt_nasc() {
        return dt_nasc;
    }

    public void setDt_nasc(Calendar dt_nasc) {
        this.dt_nasc = dt_nasc;
    }

    public String getDs_sexo() {
        return ds_sexo;
    }

    public void setDs_sexo(String ds_sexo) {
        this.ds_sexo = ds_sexo;
    }

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public Animal(int cd_animal, String ds_nome, Calendar dt_nasc, String ds_sexo, Raca raca, int cd_usuario) {
        this.cd_animal = cd_animal;
        this.ds_nome = ds_nome;
        this.dt_nasc = dt_nasc;
        this.ds_sexo = ds_sexo;
        this.raca = raca;
        this.cd_usuario = cd_usuario;
    }

    public Animal() {
    }

    @Override
    public String toString() {
        return ds_nome;
    }

}
