package br.com.rlmoura81.moura.imovel;

import br.com.rlmoura81.moura.principalcadastro.Cidade;
import java.math.BigDecimal;

public class Imovel {
    private int cd_imovel;
    private String nm_matricula;
    private BigDecimal nm_metragem;
    private BigDecimal nm_valorMatricula;
    private String ds_descricao;
    private TipoImovel tpimovel;
    private Cidade cidade;
    private int cd_usuario;

    public int getCd_imovel() {
        return cd_imovel;
    }

    public void setCd_imovel(int cd_imovel) {
        this.cd_imovel = cd_imovel;
    }

    public String getNm_matricula() {
        return nm_matricula;
    }

    public void setNm_matricula(String nm_matricula) {
        this.nm_matricula = nm_matricula;
    }

    public BigDecimal getNm_metragem() {
        return nm_metragem;
    }

    public void setNm_metragem(BigDecimal nm_metragem) {
        this.nm_metragem = nm_metragem;
    }
    
    public BigDecimal getNm_valorMatricula(){
        return nm_valorMatricula;
    }

    public void setNm_valorMatricula(BigDecimal nm_valorMatricula){
        this.nm_valorMatricula = nm_valorMatricula;
    }
    
    public String getDs_descricao() {
        return ds_descricao;
    }

    public void setDs_descricao(String ds_descricao) {
        this.ds_descricao = ds_descricao;
    }

    public TipoImovel getTpimovel() {
        return tpimovel;
    }

    public void setTpimovel(TipoImovel tpimovel) {
        this.tpimovel = tpimovel;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public Imovel(int cd_imovel, String nm_matricula, BigDecimal nm_metragem, BigDecimal nm_valorMatricula, String ds_descricao, TipoImovel tpimovel, Cidade cidade, int cd_usuario) {
        this.cd_imovel = cd_imovel;
        this.nm_matricula = nm_matricula;
        this.nm_metragem = nm_metragem;
        this.nm_valorMatricula = nm_valorMatricula;
        this.ds_descricao = ds_descricao;
        this.tpimovel = tpimovel;
        this.cidade = cidade;
        this.cd_usuario = cd_usuario;
    }

    public Imovel() {
    }

    @Override
    public String toString() {
        return "Imovel{" + "cd_imovel=" + cd_imovel + ", nm_matricula=" + nm_matricula + ", nm_metragem=" + nm_metragem + ", nm_valorMatricula=" + nm_valorMatricula + ", ds_descricao=" + ds_descricao + ", tpimovel=" + tpimovel + ", cidade=" + cidade + ", cd_usuario=" + cd_usuario + '}';
    }
    
}
