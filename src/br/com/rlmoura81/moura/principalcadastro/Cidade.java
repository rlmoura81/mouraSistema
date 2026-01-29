package br.com.rlmoura81.moura.principalcadastro;

public class Cidade {

    private Integer cd_Cidade;
    private String ds_Cidade;
    private Estado estado;
    
    public int getCd_Cidade() {
        return cd_Cidade;
    }

    public void setCd_Cidade(Integer cd_Cidade) {
        this.cd_Cidade = cd_Cidade;
    }

    public String getDs_Cidade() {
        return ds_Cidade;
    }

    public void setDs_Cidade(String ds_Cidade) {
        this.ds_Cidade = ds_Cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Cidade(Integer cd_Cidade, String ds_Cidade, Estado estado) {
        this.cd_Cidade = cd_Cidade;
        this.ds_Cidade = ds_Cidade;
        this.estado = estado;
    }
    
    public Cidade (){
        
    }

    @Override
    public String toString() {
        return "Cidade{" + "cd_Cidade=" + cd_Cidade + ", ds_Cidade=" + ds_Cidade + ", estado=" + estado + '}';
    }
    
}
