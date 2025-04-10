package br.com.rlmoura81.moura.rpg;

public class Tarefa {
    
    private int cd_tarefa;
    private String ds_tarefa;
    private float nm_valor;
    private int tp_tempo;
    private int cd_usuario;

    public int getCd_tarefa() {
        return cd_tarefa;
    }

    public void setCd_tarefa(int cd_tarefa) {
        this.cd_tarefa = cd_tarefa;
    }

    public String getDs_tarefa() {
        return ds_tarefa;
    }

    public void setDs_tarefa(String ds_tarefa) {
        this.ds_tarefa = ds_tarefa;
    }

    public float getNm_valor() {
        return nm_valor;
    }

    public void setNm_valor(float nm_valor) {
        this.nm_valor = nm_valor;
    }

    public int getTp_tempo() {
        return tp_tempo;
    }

    public void setTp_tempo(int tp_tempo) {
        this.tp_tempo = tp_tempo;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public Tarefa(int cd_tarefa, String ds_tarefa, float nm_valor, int tp_tempo, int cd_usuario) {
        this.cd_tarefa = cd_tarefa;
        this.ds_tarefa = ds_tarefa;
        this.nm_valor = nm_valor;
        this.tp_tempo = tp_tempo;
        this.cd_usuario = cd_usuario;
    }

    public Tarefa() {
    }

    @Override
    public String toString() {
        return "Tarefa{" + "cd_tarefa=" + cd_tarefa + ", ds_tarefa=" + ds_tarefa + ", nm_valor=" + nm_valor + ", tp_tempo=" + tp_tempo + ", cd_usuario=" + cd_usuario + '}';
    }
    
        
}
