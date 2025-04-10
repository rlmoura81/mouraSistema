package br.com.rlmoura81.moura.cartao;

import java.util.ArrayList;
import javax.swing.JComboBox;

public class CartaoBandeiraUtil {
        
    CartaoBandeiraRepository cartaobandeirar = new CartaoBandeiraRepository();
        
    public void jcCartaBandeira(JComboBox o){
        ArrayList<CartaoBandeira> listacartabandeira = cartaobandeirar.getLista();
        CartaoBandeira cbZero = new CartaoBandeira(0, "<Bandeira>");
        o.addItem(cbZero);
        for(CartaoBandeira cb : listacartabandeira){
            o.addItem(cb);
        }
    }
}
