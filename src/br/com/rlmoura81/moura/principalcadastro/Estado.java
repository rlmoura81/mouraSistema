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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.cd_Estado);
        hash = 89 * hash + Objects.hashCode(this.ds_Estado);
        hash = 89 * hash + Objects.hashCode(this.ds_SiglaEstado);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estado other = (Estado) obj;
        if (!Objects.equals(this.ds_Estado, other.ds_Estado)) {
            return false;
        }
        if (!Objects.equals(this.ds_SiglaEstado, other.ds_SiglaEstado)) {
            return false;
        }
        if (!Objects.equals(this.cd_Estado, other.cd_Estado)) {
            return false;
        }
        return true;
    }
}