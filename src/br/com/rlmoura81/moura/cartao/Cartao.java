package br.com.rlmoura81.moura.cartao;

import br.com.rlmoura81.moura.financeiro.Banco;
import java.math.BigDecimal;
import java.util.Calendar;

public class Cartao {
    
    private int cd_cartao;
    private String nm_cartao;
    private BigDecimal nm_limite;
    private Calendar dt_vencimento;
    private CartaoBandeira cartaobandeira;
    private Banco banco;
    private int cd_usuario;

    public int getCd_cartao() {
        return cd_cartao;
    }

    public void setCd_cartao(int cd_cartao) {
        this.cd_cartao = cd_cartao;
    }

    public String getNm_cartao() {
        return nm_cartao;
    }

    public void setNm_cartao(String nm_cartao) {
        this.nm_cartao = nm_cartao;
    }

    public BigDecimal getNm_limite() {
        return nm_limite;
    }

    public void setNm_limite(BigDecimal nm_limite) {
        this.nm_limite = nm_limite;
    }

    public Calendar getDt_vencimento() {
        return dt_vencimento;
    }

    public void setDt_vencimento(Calendar dt_vencimento) {
        this.dt_vencimento = dt_vencimento;
    }

    public CartaoBandeira getCartaobandeira() {
        return cartaobandeira;
    }

    public void setCartaobandeira(CartaoBandeira cartaobandeira) {
        this.cartaobandeira = cartaobandeira;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public Cartao(int cd_cartao, String nm_cartao, BigDecimal nm_limite, Calendar dt_vencimento, CartaoBandeira cartaobandeira, Banco banco, int cd_usuario) {
        this.cd_cartao = cd_cartao;
        this.nm_cartao = nm_cartao;
        this.nm_limite = nm_limite;
        this.dt_vencimento = dt_vencimento;
        this.cartaobandeira = cartaobandeira;
        this.banco = banco;
        this.cd_usuario = cd_usuario;
    }

    public Cartao() {
    }

    @Override
    public String toString() {
        return "Cartao{" + "cd_cartao=" + cd_cartao + ", nm_cartao=" + nm_cartao + ", nm_limite=" + nm_limite + ", dt_vencimento=" + dt_vencimento + ", cartaobandeira=" + cartaobandeira + ", banco=" + banco + ", cd_usuario=" + cd_usuario + '}';
    }
}
