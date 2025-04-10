package br.com.rlmoura81.moura.rpg;

import java.util.Calendar;

public class Diario {
    
    private Calendar dt_diario;
    private float nm_valor;
    private Tarefa tarefa;
    private int cd_usuario;

    public Calendar getDt_diario() {
        return dt_diario;
    }

    public void setDt_diario(Calendar dt_diario) {
        this.dt_diario = dt_diario;
    }

    public float getNm_valor() {
        return nm_valor;
    }

    public void setNm_valor(float nm_valor) {
        this.nm_valor = nm_valor;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public Diario(Calendar dt_diario, Tarefa tarefa, int cd_usuario) {
        this.dt_diario = dt_diario;
        this.tarefa = tarefa;
        this.cd_usuario = cd_usuario;
    }

    public Diario(Calendar dt_diario, float nm_valor) {
        this.dt_diario = dt_diario;
        this.nm_valor = nm_valor;
    }  

    public Diario() {
    }

    @Override
    public String toString() {
        return "Diario{" + "dt_diario=" + dt_diario + ", tarefa=" + tarefa + ", cd_usuario=" + cd_usuario + '}';
    }
    
}
