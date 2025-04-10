package br.com.rlmoura81.moura.principal;

import java.util.ArrayList;

public interface IPadraoRepository {

    public void inserir(Object o);
    
    public void alterar(Object o);
    
    public void excluir(Object o);
    
    public ArrayList getLista();
    
    public Object getById(int id);
    
}
