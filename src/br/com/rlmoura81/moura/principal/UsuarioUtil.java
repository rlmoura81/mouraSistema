package br.com.rlmoura81.moura.principal;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UsuarioUtil {
    
    Usuario user = new Usuario();
    UsuarioRepository userr = new UsuarioRepository();
    
    ArrayList lista = new ArrayList();
    
    public void tabelaUsuario(JTable o)  {
        String[] nomeColuna = {"Codigo", "Login", "Nome"};
        lista = userr.getLista();
        Object [][] dadosArray = new Object[lista.size()][nomeColuna.length];

        for (int i = 0; i < lista.size(); i++){
            user = (Usuario) userr.getLista().get(i);
            dadosArray[i][0] = user.getCd_usuario();
            dadosArray[i][1] = user.getDs_login();
            dadosArray[i][2] = user.getPessoa();
        }
        DefaultTableModel tUsuario = new DefaultTableModel(dadosArray,nomeColuna);
        o.setModel(tUsuario);        
    }
    
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecionada = o.getSelectedRow();
        if(linhaselecionada >= 0){
            selecionado = lista.get(linhaselecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione o usuário.", "Usuário", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;
    }
}
