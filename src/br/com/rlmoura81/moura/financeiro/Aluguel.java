package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.imovel.Imovel;
import br.com.rlmoura81.moura.principalcadastro.PrestadorServico;
import java.math.BigDecimal;
import java.util.Calendar;

public class Aluguel {
    
    private int cd_aluguel;
    private String nm_contrato;
    private BigDecimal nm_vlaluguel;
    private BigDecimal nm_vladm;
    private int dt_deposito;
    private Calendar dt_contratovenc;
    private Imovel imovel;
    private PrestadorServico presserv;
    private int cd_usuario;

    public int getCd_aluguel() {
        return cd_aluguel;
    }

    public void setCd_aluguel(int cd_aluguel) {
        this.cd_aluguel = cd_aluguel;
    }

    public String getNm_contrato() {
        return nm_contrato;
    }

    public void setNm_contrato(String nm_contrato) {
        this.nm_contrato = nm_contrato;
    }

    public BigDecimal getNm_vlaluguel() {
        return nm_vlaluguel;
    }

    public void setNm_vlaluguel(BigDecimal nm_vlaluguel) {
        this.nm_vlaluguel = nm_vlaluguel;
    }

    public BigDecimal getNm_vladm() {
        return nm_vladm;
    }

    public void setNm_vladm(BigDecimal nm_vladm) {
        this.nm_vladm = nm_vladm;
    }

    public int getDt_deposito() {
        return dt_deposito;
    }

    public void setDt_deposito(int dt_deposito) {
        this.dt_deposito = dt_deposito;
    }

    public Calendar getDt_contratovenc() {
        return dt_contratovenc;
    }

    public void setDt_contratovenc(Calendar dt_contratovenc) {
        this.dt_contratovenc = dt_contratovenc;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
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

    public Aluguel(int cd_aluguel, String nm_contrato, BigDecimal nm_vlaluguel, BigDecimal nm_vladm, int dt_deposito, Calendar dt_contratovenc, Imovel imovel, PrestadorServico presserv, int cd_usuario) {
        this.cd_aluguel = cd_aluguel;
        this.nm_contrato = nm_contrato;
        this.nm_vlaluguel = nm_vlaluguel;
        this.nm_vladm = nm_vladm;
        this.dt_deposito = dt_deposito;
        this.dt_contratovenc = dt_contratovenc;
        this.imovel = imovel;
        this.presserv = presserv;
        this.cd_usuario = cd_usuario;
    }

    public Aluguel() {
    }

    @Override
    public String toString() {
        return nm_contrato;
    }

}
