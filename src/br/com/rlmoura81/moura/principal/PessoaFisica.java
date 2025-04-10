package br.com.rlmoura81.moura.principal;

import br.com.rlmoura81.moura.principalcadastro.Cidade;
import java.util.Calendar;

public class PessoaFisica {
    
    private Integer cd_Pessoa;
    private String ds_Nome;
    private Calendar dt_Nascimento;
    private String nm_Cpf;
    private String nm_Cnh;
    private String nm_Rg;
    private Cidade cidade;
    
    public int getCd_Pessoa() {
        return cd_Pessoa;
    }

    public void setCd_Pessoa(Integer cd_Pessoa) {
        this.cd_Pessoa = cd_Pessoa;
    }

    public String getDs_Nome() {
        return ds_Nome;
    }

    public void setDs_Nome(String ds_Nome) {
        this.ds_Nome = ds_Nome;
    }

    public Calendar getDt_Nascimento() {
        return dt_Nascimento;
    }

    public void setDt_Nascimento(Calendar dt_Nascimento) {
        this.dt_Nascimento = dt_Nascimento;
    }

    public String getNm_Cpf() {
        return nm_Cpf;
    }

    public void setNm_Cpf(String nm_Cpf) {
        this.nm_Cpf = nm_Cpf;
    }

    public String getNm_Rg() {
        return nm_Rg;
    }

    public void setNm_Rg(String nm_Rg) {
        this.nm_Rg = nm_Rg;
    }

    public String getNm_Cnh() {
        return nm_Cnh;
    }

    public void setNm_Cnh(String nm_Cnh) {
        this.nm_Cnh = nm_Cnh;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
             
    public PessoaFisica (){
        
    }

    public PessoaFisica(Integer cd_Pessoa, String ds_Nome, Calendar dt_Nascimento, String nm_Cpf, String nm_Cnh, String nm_Rg, Cidade cidade) {
        this.cd_Pessoa = cd_Pessoa;
        this.ds_Nome = ds_Nome;
        this.dt_Nascimento = dt_Nascimento;
        this.nm_Cpf = nm_Cpf;
        this.nm_Cnh = nm_Cnh;
        this.nm_Rg = nm_Rg;
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return ds_Nome;
    }
}
