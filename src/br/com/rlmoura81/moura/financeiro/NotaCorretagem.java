package br.com.rlmoura81.moura.financeiro;

import java.util.Calendar;

public class NotaCorretagem {

    private int cd_nota;
    private int nm_nota;
    private Calendar dt_nota;
    private Conta conta;
    private int cd_usuario;

    public int getCd_nota() {
        return cd_nota;
    }

    public void setCd_nota(int cd_nota) {
        this.cd_nota = cd_nota;
    }

    public int getNm_nota() {
        return nm_nota;
    }

    public void setNm_nota(int nm_nota) {
        this.nm_nota = nm_nota;
    }

    public Calendar getDt_nota() {
        return dt_nota;
    }

    public void setDt_nota(Calendar dt_nota) {
        this.dt_nota = dt_nota;
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

    public NotaCorretagem(int cd_nota, int nm_nota, Calendar dt_nota, Conta conta, int cd_usuario) {
        this.cd_nota = cd_nota;
        this.nm_nota = nm_nota;
        this.dt_nota = dt_nota;
        this.conta = conta;
        this.cd_usuario = cd_usuario;
    }

    public NotaCorretagem() {
    }

    @Override
    public String toString() {
        return "NotaCorretagem{" + "cd_nota=" + cd_nota + ", nm_nota=" + nm_nota + ", dt_nota=" + dt_nota + ", conta=" + conta + ", cd_usuario=" + cd_usuario + '}';
    }
    
}
