package br.com.rlmoura81.moura.veiculo;

import java.util.ArrayList;
import javax.swing.JComboBox;

public class MarcaUtil {
    
    MarcaRepository marcar = new MarcaRepository();
           
    /**
     * <p><strong>EN:</strong> Populates a <code>JComboBox</code> with brand records.  
     * The first item is a default placeholder ("&lt;Marca&gt;"), followed by the list of brands retrieved from the database.</p>
     *
     * <p><strong>IT:</strong> Popola un <code>JComboBox</code> con i record dei marchi.  
     * Il primo elemento è un segnaposto predefinito ("&lt;Marca&gt;"), seguito dall'elenco dei marchi recuperati dal database.</p>
     *
     * <p><strong>PT-BR:</strong> Preenche um <code>JComboBox</code> com os registros de marcas.  
     * O primeiro item é um marcador padrão ("&lt;Marca&gt;"), seguido da lista de marcas recuperadas do banco de dados.</p>
     */
    public void jcMarca(JComboBox o){
        ArrayList<Marca> listamarca = marcar.getLista();
        Marca mZero = new Marca(0, "<Marca>");
        o.addItem(mZero);
        for(Marca marca : listamarca){
            o.addItem(marca);
        }
    }    
    
}
