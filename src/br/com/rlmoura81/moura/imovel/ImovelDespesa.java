package br.com.rlmoura81.moura.imovel;

import br.com.rlmoura81.moura.principal.ModuloDespesa;
import br.com.rlmoura81.moura.principalcadastro.PrestadorServico;
import java.math.BigDecimal;
import java.util.Calendar;

public class ImovelDespesa extends ModuloDespesa{
    
    private Imovel imovel;

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public ImovelDespesa(Imovel imovel, int cd_despesa, Calendar dt_despesa, String nm_nota, String ds_descricao, BigDecimal nm_valor, int nm_qtde, PrestadorServico presserv, int cd_usuario) {
        super(cd_despesa, dt_despesa, nm_nota, ds_descricao, nm_valor, nm_qtde, presserv, cd_usuario);
        this.imovel = imovel;
    }

    public ImovelDespesa(Imovel imovel) {
        this.imovel = imovel;
    }

    public ImovelDespesa() {
    }

    @Override
    public String toString() {
        return "ImovelDespesa{" + "imovel=" + imovel + '}';
    }  
    
}
