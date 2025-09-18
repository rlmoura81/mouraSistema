package br.com.rlmoura81.moura.cartao;

import java.util.ArrayList;
import javax.swing.JComboBox;

public class CartaoBandeiraUtil {
        
    CartaoBandeiraRepository cartaobandeirar = new CartaoBandeiraRepository();

    /**
     * <p><strong>EN:</strong> Populates a JComboBox with the list of card brands (CartaoBandeira), adding a default option at the beginning.</p>
     *
     * <p><strong>IT:</strong> Popola un JComboBox con l'elenco delle bandiere di carte (CartaoBandeira), aggiungendo un'opzione predefinita all'inizio.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche um JComboBox com a lista de bandeiras de cartão (CartaoBandeira), adicionando uma opção padrão no início.</p>
     *
     * @param o EN: JComboBox to be populated | IT: JComboBox da popolare | PT-BR: JComboBox a ser preenchido
     * @since 1.0.0
     */
    public void jcCartaBandeira(JComboBox o){
        ArrayList<CartaoBandeira> listacartabandeira = cartaobandeirar.getLista();
        CartaoBandeira cbZero = new CartaoBandeira(0, "<Bandeira>");
        o.addItem(cbZero);
        for(CartaoBandeira cb : listacartabandeira){
            o.addItem(cb);
        }
    }
}
