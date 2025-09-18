package br.com.rlmoura81.moura.principal;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UsuarioUtil {
    
    Usuario user = new Usuario();
    UsuarioRepository userr = new UsuarioRepository();    
    ArrayList lista = new ArrayList();
    
    /**
     * <p><strong>EN:</strong> Builds and populates a table model of <code>Usuario</code> objects.
     * Displays user code, login, and linked person name in the given JTable.</p>
     *
     * <p><strong>IT:</strong> Costruisce e popola un modello di tabella con gli oggetti <code>Usuario</code>.
     * Mostra codice utente, login e nome della persona collegata nella JTable fornita.</p>
     *
     * <p><strong>PT-BR:</strong> Monta e preenche um modelo de tabela com os objetos <code>Usuario</code>.
     * Exibe código do usuário, login e nome da pessoa vinculada na JTable informada.</p>
     */
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
    
    /**
     * <p><strong>EN:</strong> Retrieves the currently selected <code>Usuario</code> from the JTable.
     * If no row is selected, shows an information dialog instructing the user to select one.</p>
     *
     * <p><strong>IT:</strong> Recupera l’<code>Usuario</code> attualmente selezionato dalla JTable.
     * Se nessuna riga è selezionata, mostra un messaggio informativo che invita a selezionarne una.</p>
     *
     * <p><strong>PT-BR:</strong> Retorna o <code>Usuario</code> atualmente selecionado na JTable.
     * Caso nenhuma linha esteja selecionada, exibe um aviso solicitando a seleção de um usuário.</p>
     */
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
