package br.com.rlmoura81.moura.animal;

import br.com.rlmoura81.moura.principal.ModuloDespesa;
import br.com.rlmoura81.moura.principalcadastro.PrestadorServico;
import java.math.BigDecimal;
import java.util.Calendar;

public class AnimalDespesa extends ModuloDespesa{
    
    private Animal animal;
    private Produto produto;

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public AnimalDespesa(Animal animal, Produto produto, int cd_despesa, Calendar dt_despesa, String nm_nota, String ds_descricao, BigDecimal nm_valor, int nm_qtde, PrestadorServico presserv, int cd_usuario) {
        super(cd_despesa, dt_despesa, nm_nota, ds_descricao, nm_valor, nm_qtde, presserv, cd_usuario);
        this.animal = animal;
        this.produto = produto;
    }

    public AnimalDespesa(Animal animal, Produto produto) {
        this.animal = animal;
        this.produto = produto;
    }

    public AnimalDespesa() {
    }

    @Override
    public String toString() {
        return "AnimalDespesa{" + "animal=" + animal + ", produto=" + produto + '}';
    }
    
}
