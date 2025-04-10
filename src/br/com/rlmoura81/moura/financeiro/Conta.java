package br.com.rlmoura81.moura.financeiro;

public class Conta {
    private int cd_conta;
    private String nm_agencia;
    private String nm_conta;
    private Banco banco;
    private TipoConta tpconta;
    private int cd_usuario;

    public int getCd_conta() {
        return cd_conta;
    }

    public void setCd_conta(int cd_conta) {
        this.cd_conta = cd_conta;
    }

    public String getNm_agencia() {
        return nm_agencia;
    }

    public void setNm_agencia(String nm_agencia) {
        this.nm_agencia = nm_agencia;
    }

    public String getNm_conta() {
        return nm_conta;
    }

    public void setNm_conta(String nm_conta) {
        this.nm_conta = nm_conta;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public TipoConta getTpconta() {
        return tpconta;
    }

    public void setTpconta(TipoConta tpconta) {
        this.tpconta = tpconta;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public Conta(int cd_conta, String nm_agencia, String nm_conta, Banco banco, TipoConta tpconta, int cd_usuario) {
        this.cd_conta = cd_conta;
        this.nm_agencia = nm_agencia;
        this.nm_conta = nm_conta;
        this.banco = banco;
        this.tpconta = tpconta;
        this.cd_usuario = cd_usuario;
    }

    public Conta() {
    }

    @Override
    public String toString() {
        return nm_agencia + " / " + nm_conta + " - " + tpconta + " / " + banco;
    }
}
