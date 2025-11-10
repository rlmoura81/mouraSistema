package br.com.rlmoura81.moura.principalcadastro;

import java.util.Objects;

public class Estado {

    private Integer cd_Estado;
    private String ds_Estado;
    private String ds_SiglaEstado;
    
    public int getCd_estado (){
        return cd_Estado;
    }
    
    public void setCd_estado(Integer cd_Estado){
        this.cd_Estado = cd_Estado;
    }   
    
    public String getDs_estado (){
        return ds_Estado;
    }
    
    public void setDs_estado(String ds_Estado){
        this.ds_Estado = ds_Estado;
    }
    
    public String getDs_siglaEstado (){
        return ds_SiglaEstado;
    }
    
    public void setDs_siglaEstado (String ds_SiglaEstado){
        this.ds_SiglaEstado = ds_SiglaEstado;
    }

    public Estado(Integer cd_Estado, String ds_Estado, String ds_SiglaEstado) {
        this.cd_Estado = cd_Estado;
        this.ds_Estado = ds_Estado;
        this.ds_SiglaEstado = ds_SiglaEstado;
    }
    
    public Estado (){
        
    }

    @Override
    public String toString() {
        return ds_SiglaEstado;
    }     
}