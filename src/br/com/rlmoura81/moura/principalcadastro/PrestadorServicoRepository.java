package br.com.rlmoura81.moura.principalcadastro;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PrestadorServicoRepository {

    String sql = "";
        
    /**
     * <p><strong>EN:</strong> Inserts a new Service Provider record into the database
     * using the fields from the provided {@code PrestadorServico} object.</p>
     *
     * <p><strong>IT:</strong> Inserisce un nuovo record di Fornitore di Servizi nel database
     * utilizzando i campi dell’oggetto {@code PrestadorServico} fornito.</p>
     *
     * <p><strong>PT-BR:</strong> Insere um novo registro de Prestador de Serviço no banco de dados
     * usando os campos do objeto {@code PrestadorServico} informado.</p>
     */
    public void inserir(Object o){
        PrestadorServico presserv = (PrestadorServico) o;
        try{
            sql = "INSERT INTO presserv (cd_presserv, ds_presserv, ds_razaosocial, nm_documento, cd_usuario)" +
                  "     VALUES (sq_presserv.nextval,?, ?, ?, ?)";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, presserv.getDs_presserv());
            ps.setString(2, presserv.getDs_razaosocial());
            ps.setString(3, presserv.getNm_documento());
            ps.setInt(4, presserv.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Prestador de Serviço", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Prestador de Serviço", JOptionPane.ERROR_MESSAGE);
        }    
    }
    
    /**
     * <p><strong>EN:</strong> Updates an existing Service Provider record in the database
     * matching the provided IDs, replacing its fields with those from the given object.</p>
     *
     * <p><strong>IT:</strong> Aggiorna un record esistente di Fornitore di Servizi nel database
     * corrispondente agli ID forniti, sostituendo i campi con quelli dell’oggetto passato.</p>
     *
     * <p><strong>PT-BR:</strong> Atualiza um registro existente de Prestador de Serviço no banco de dados
     * correspondente aos IDs informados, substituindo os campos pelos do objeto recebido.</p>
     */
    public void alterar(Object o){
        PrestadorServico presserv = (PrestadorServico) o;
        try{
            sql = "UPDATE presserv " +
                  "   SET ds_presserv = ?, " +
                  "       ds_razaosocial = ?, " +
                  "       nm_documento = ?" +
                  " WHERE cd_presserv = ? " +
                  "   AND cd_usuario = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, presserv.getDs_presserv());
            ps.setString(2, presserv.getDs_razaosocial());
            ps.setString(3, presserv.getNm_documento());
            ps.setInt(4, presserv.getCd_presserv());
            ps.setInt(5, presserv.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Prestador de Serviço", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Prestador de Serviço", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * <p><strong>EN:</strong> Deletes a Service Provider record from the database
     * identified by the given provider and user IDs.</p>
     *
     * <p><strong>IT:</strong> Elimina un record di Fornitore di Servizi dal database
     * identificato dagli ID del fornitore e dell’utente.</p>
     *
     * <p><strong>PT-BR:</strong> Exclui um registro de Prestador de Serviço do banco de dados
     * identificado pelos IDs do prestador e do usuário.</p>
     */
    public void excluir(Object o){
        PrestadorServico presserv = (PrestadorServico) o;
        try{
            sql = "DELETE FROM presserv " +
                  " WHERE cd_presserv = ? " +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, presserv.getCd_presserv());
            ps.setInt(2, presserv.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido", "Prestador de Serviço", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Prestador de Serviço", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves the list of all Service Providers for the current user,
     * ordered by provider name.</p>
     *
     * <p><strong>IT:</strong> Recupera l’elenco di tutti i Fornitori di Servizi dell’utente corrente,
     * ordinati per nome.</p>
     *
     * <p><strong>PT-BR:</strong> Retorna a lista de todos os Prestadores de Serviço do usuário atual,
     * ordenada pelo nome do prestador.</p>
     */
    public ArrayList getLista(){        
        ArrayList presservlista = new ArrayList();
        try{
            sql = "SELECT cd_presserv, ds_presserv, ds_razaosocial, nm_documento, cd_usuario" +
                  "  FROM presserv" +
                  " WHERE cd_usuario = ?" +
                  " ORDER BY ds_presserv";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();        
            while(rs.next()){          
                PrestadorServico presserv = new PrestadorServico(
                    rs.getInt("cd_presserv"),
                    rs.getString("ds_presserv"),
                    rs.getString("ds_razaosocial"),
                    rs.getString("nm_documento"),
                    rs.getInt("cd_usuario"));
                presservlista.add(presserv);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de prestadores de serviços:\n" +
                    ex.getMessage(), "Prestador de Serviço", JOptionPane.ERROR_MESSAGE);
        }
        return presservlista;
    }

    /**
     * <p><strong>EN:</strong> Retrieves the list of Service Providers linked to a specific Module,
     * filtered by the current user and ordered by provider name.</p>
     *
     * <p><strong>IT:</strong> Recupera l’elenco dei Fornitori di Servizi collegati a uno specifico Modulo,
     * filtrati per l’utente corrente e ordinati per nome.</p>
     *
     * <p><strong>PT-BR:</strong> Retorna a lista de Prestadores de Serviço vinculados a um Módulo específico,
     * filtrados pelo usuário atual e ordenados pelo nome.</p>
     */
    public ArrayList getLista(int cd_modulo){       
        ArrayList presservlista = new ArrayList();
        try{
            sql = "SELECT presserv.cd_presserv, ds_presserv, ds_razaosocial, nm_documento, presserv.cd_usuario" +
                  "  FROM presserv, modulo, presservmod" +
                  " WHERE presserv.cd_usuario = ?" +
                  "   AND modulo.cd_modulo = ?" +
                  "   AND modulo.cd_modulo = presservmod.cd_modulo" +
                  "   AND presserv.cd_presserv = presservmod.cd_presserv" +
                  " ORDER BY ds_presserv";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ps.setInt(2, cd_modulo);
            ResultSet rs = ps.executeQuery();        
            while(rs.next()){          
                PrestadorServico presserv = new PrestadorServico(
                    rs.getInt("cd_presserv"),
                    rs.getString("ds_presserv"),
                    rs.getString("ds_razaosocial"),
                    rs.getString("nm_documento"),
                    rs.getInt("cd_usuario"));
                presservlista.add(presserv);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de prestadores de serviços:\n" +
                    ex.getMessage(), "Prestador de Serviços", JOptionPane.ERROR_MESSAGE);
        }
        return presservlista;
    }
        
    /**
     * <p><strong>EN:</strong> Fetches a single Service Provider by its identifier, returning
     * a populated {@code PrestadorServico} instance when found.</p>
     *
     * <p><strong>IT:</strong> Recupera un singolo Fornitore di Servizi tramite il suo identificatore,
     * restituendo un’istanza {@code PrestadorServico} popolata se trovato.</p>
     *
     * <p><strong>PT-BR:</strong> Busca um único Prestador de Serviço pelo seu identificador,
     * retornando uma instância {@code PrestadorServico} preenchida quando encontrado.</p>
     */
    public Object getById(int id){
        PrestadorServico p = null;
        try {
            sql = "SELECT cd_presserv, ds_presserv, ds_razaosocial, nm_documento, cd_usuario"
                + "  FROM presserv"
                + " WHERE cd_presserv = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                PrestadorServico presserv = new PrestadorServico();
                presserv.setCd_presserv(rs.getInt("cd_presserv"));
                p = new PrestadorServico(
                    rs.getInt("cd_presserv"),
                    rs.getString("ds_presserv"),
                    rs.getString("ds_razaosocial"),
                    rs.getString("nm_documento"),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de getById em Prestador de Servico" +
                    ex.getMessage(), "Prestador de Serviços", JOptionPane.ERROR_MESSAGE);
        }        
        return p;        
    }
}
