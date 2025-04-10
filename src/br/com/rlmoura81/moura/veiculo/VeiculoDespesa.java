package br.com.rlmoura81.moura.veiculo;

import br.com.rlmoura81.moura.principal.ModuloDespesa;
import br.com.rlmoura81.moura.principalcadastro.PrestadorServico;
import java.math.BigDecimal;
import java.util.Calendar;

public class VeiculoDespesa extends ModuloDespesa{
    
    private Veiculo veiculo;

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public VeiculoDespesa(Veiculo veiculo, int cd_despesa, Calendar dt_despesa, String nm_nota, String ds_descricao, BigDecimal nm_valor, int nm_qtde, PrestadorServico presserv, int cd_usuario) {
        super(cd_despesa, dt_despesa, nm_nota, ds_descricao, nm_valor, nm_qtde, presserv, cd_usuario);
        this.veiculo = veiculo;
    }

    public VeiculoDespesa(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public VeiculoDespesa() {
    }
    
    @Override
    public String toString() {
        return "VeiculoDespesa{" + "veiculo=" + veiculo + '}';
    }

        
}
