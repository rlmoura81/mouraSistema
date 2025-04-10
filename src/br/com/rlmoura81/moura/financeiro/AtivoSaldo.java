package br.com.rlmoura81.moura.financeiro;

import java.util.Objects;


public class AtivoSaldo {
    
    private Ativo ativo;
    private int nm_qtde;
    private int cd_usuario;
    
    public Ativo getAtivo() {
        return ativo;
    }

    public void setAtivo(Ativo ativo) {
        this.ativo = ativo;
    }

    public int getNm_qtde() {
        return nm_qtde;
    }

    public void setNm_qtde(int nm_qtde) {
        this.nm_qtde = nm_qtde;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public AtivoSaldo(Ativo ativo, int nm_qtde, int cd_usuario) {
        this.ativo = ativo;
        this.nm_qtde = nm_qtde;
        this.cd_usuario = cd_usuario;
    }

    public AtivoSaldo() {
    }
    
    @Override
    public String toString() {
        return "AtivoSaldo{" + "ativo=" + ativo + ", nm_qtde=" + nm_qtde + ", cd_usuario=" + cd_usuario + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.ativo);
        hash = 79 * hash + this.nm_qtde;
        hash = 79 * hash + this.cd_usuario;
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
        final AtivoSaldo other = (AtivoSaldo) obj;
        if (this.nm_qtde != other.nm_qtde) {
            return false;
        }
        if (this.cd_usuario != other.cd_usuario) {
            return false;
        }
        if (!Objects.equals(this.ativo, other.ativo)) {
            return false;
        }
        return true;
    }

    
}
