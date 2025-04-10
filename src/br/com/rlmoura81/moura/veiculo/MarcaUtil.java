package br.com.rlmoura81.moura.veiculo;

import java.util.ArrayList;
import javax.swing.JComboBox;

public class MarcaUtil {
    
    MarcaRepository marcar = new MarcaRepository();
            
    public void jcMarca(JComboBox o){
        ArrayList<Marca> listamarca = marcar.getLista();
        Marca mZero = new Marca(0, "<Marca>");
        o.addItem(mZero);
        for(Marca marca : listamarca){
            o.addItem(marca);
        }
    }    
    
}
