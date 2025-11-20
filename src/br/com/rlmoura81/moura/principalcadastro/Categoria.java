package br.com.rlmoura81.moura.principalcadastro;

public class Categoria {
    
    private int cd_Categoria;
    private String ds_Categoria;
    private Grupo grupo;
    private int cd_usuario;
    
    public int getCd_Categoria(){
        return cd_Categoria;
    }
    
    public void setCd_Categoria(Integer cd_Categoria){
        this.cd_Categoria = cd_Categoria;
    }
    
    public String getDs_Categoria(){
        return ds_Categoria;
    }
    
    public void setDs_Categoria(String ds_Categoria){
        this.ds_Categoria = ds_Categoria;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public Categoria(Integer cd_Categoria, String ds_Categoria, Grupo grupo, int cd_usuario) {
        this.cd_Categoria = cd_Categoria;
        this.ds_Categoria = ds_Categoria;
        this.grupo = grupo;
        this.cd_usuario = cd_usuario;
    }

    public Categoria(){
        
    }

    @Override
    public String toString() {
        return "Categoria{" + "cd_Categoria=" + cd_Categoria + ", ds_Categoria=" + ds_Categoria + ", grupo=" + grupo + ", cd_usuario=" + cd_usuario + '}';
    }
        
}
