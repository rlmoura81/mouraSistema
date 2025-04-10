package br.com.rlmoura81.moura.veiculo;

public class Veiculo {
    
    private int cd_veiculo;
    private int dt_anofab;
    private int dt_anomod;
    private String nm_renavam;
    private String nm_placa;
    private int nm_potencia;
    private Combustivel combustivel;
    private Cores cor;
    private Modelo modelo;
    private int cd_usuario;

    public int getCd_veiculo() {
        return cd_veiculo;
    }

    public void setCd_veiculo(int cd_veiculo) {
        this.cd_veiculo = cd_veiculo;
    }

    public int getDt_anofab() {
        return dt_anofab;
    }

    public void setDt_anofab(int dt_anofab) {
        this.dt_anofab = dt_anofab;
    }

    public int getDt_anomod() {
        return dt_anomod;
    }

    public void setDt_anomod(int dt_anomod) {
        this.dt_anomod = dt_anomod;
    }

    public String getNm_renavam() {
        return nm_renavam;
    }

    public void setNm_renavam(String nm_renavam) {
        this.nm_renavam = nm_renavam;
    }

    public String getNm_placa() {
        return nm_placa;
    }

    public void setNm_placa(String nm_placa) {
        this.nm_placa = nm_placa;
    }

    public int getNm_potencia() {
        return nm_potencia;
    }

    public void setNm_potencia(int nm_potencia) {
        this.nm_potencia = nm_potencia;
    }

    public Combustivel getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(Combustivel combustivel) {
        this.combustivel = combustivel;
    }

    public Cores getCor() {
        return cor;
    }

    public void setCor(Cores cor) {
        this.cor = cor;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public Veiculo(int cd_veiculo, int dt_anofab, int dt_anomod, String nm_renavam, String nm_placa, int nm_potencia, Combustivel combustivel, Cores cor, Modelo modelo, int cd_usuario) {
        this.cd_veiculo = cd_veiculo;
        this.dt_anofab = dt_anofab;
        this.dt_anomod = dt_anomod;
        this.nm_renavam = nm_renavam;
        this.nm_placa = nm_placa;
        this.nm_potencia = nm_potencia;
        this.combustivel = combustivel;
        this.cor = cor;
        this.modelo = modelo;
        this.cd_usuario = cd_usuario;
    }

    public Veiculo() {
    }

    @Override
    public String toString() {
        return nm_placa;
    }

}
