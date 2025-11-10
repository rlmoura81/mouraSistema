package br.com.rlmoura81.moura.principalcadastro;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EmpresaRepository {

    String sql = "";
    TipoEmpresaRepository tpempresar = new TipoEmpresaRepository();
        
    /**
     * <p><strong>EN:</strong> Inserts a new Service Provider record into the database
     * using the fields from the provided {@code Empresa} object.</p>
     *
     * <p><strong>IT:</strong> Inserisce un nuovo record di Fornitore di Servizi nel database
     * utilizzando i campi dell’oggetto {@code Empresa} fornito.</p>
     *
     * <p><strong>PT-BR:</strong> Insere um novo registro de Prestador de Serviço no banco de dados
     * usando os campos do objeto {@code Empresa} informado.</p>
     */
    public void inserir(Object o){
        Empresa empresa = (Empresa) o;
        try{
            sql = "INSERT INTO empresa (cd_empresa, ds_empresa, ds_razaosocial, nm_documento, cd_tpempresa, cd_usuario)" +
                  "     VALUES (sq_empresa.nextval, ?, ?, ?, ?, ?)";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, empresa.getDs_empresa());
            ps.setString(2, empresa.getDs_razaosocial());
            ps.setString(3, empresa.getNm_documento());
            ps.setInt(4, empresa.getTpEmpresa().getCd_tpempresa());
            ps.setInt(5, empresa.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Empresa", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Empresa", JOptionPane.ERROR_MESSAGE);
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
        Empresa empresa = (Empresa) o;
        try{
            sql = "UPDATE empresa " +
                  "   SET ds_empresa = ?, " +
                  "       ds_razaosocial = ?, " +
                  "       nm_documento = ?," +
                  "       cd_tpempresa = ?," + 
                  "       cd_usuario = ?" +
                  " WHERE cd_empresa = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setString(1, empresa.getDs_empresa());
            ps.setString(2, empresa.getDs_razaosocial());
            ps.setString(3, empresa.getNm_documento());
            ps.setInt(4, empresa.getTpEmpresa().getCd_tpempresa());
            ps.setInt(5, empresa.getCd_usuario());
            ps.setInt(6, empresa.getCd_empresa());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Empresa", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Empresa", JOptionPane.ERROR_MESSAGE);
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
        Empresa empresa = (Empresa) o;
        try{
            sql = "DELETE FROM empresa " +
                  " WHERE cd_empresa = ? ";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, empresa.getCd_empresa());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido", "Empresa", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Empresa", JOptionPane.ERROR_MESSAGE);
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
        ArrayList empresal = new ArrayList();
        try{
            sql = "SELECT cd_empresa, ds_empresa, ds_razaosocial, nm_documento, cd_tpempresa, cd_usuario" +
                  "  FROM empresa" +
                  " ORDER BY ds_empresa";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();        
            while(rs.next()){          
                Empresa empresa = new Empresa(
                    rs.getInt("cd_empresa"),
                    rs.getString("ds_empresa"),
                    rs.getString("ds_razaosocial"),
                    rs.getString("nm_documento"),
                    (TipoEmpresa)tpempresar.getById(rs.getInt("cd_tpempresa")),
                    rs.getInt("cd_usuario"));
                empresal.add(empresa);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Empresas:\n" +
                    ex.getMessage(), "Empresa", JOptionPane.ERROR_MESSAGE);
        }
        return empresal;
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
        ArrayList empresal = new ArrayList();
        try{
            sql = "SELECT empresa.cd_empresa, ds_empresa, ds_razaosocial, nm_documento, cd_tpempresa, empresa.cd_usuario" +
                  "  FROM empresa, modulo, empresamod" +
                  " WHERE empresa.cd_usuario = ?" +
                  "   AND modulo.cd_modulo = ?" +
                  "   AND modulo.cd_modulo = empresamod.cd_modulo" +
                  "   AND empresa.cd_empresa = empresamod.cd_empresa" +
                  " ORDER BY ds_empresa";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ps.setInt(2, cd_modulo);
            ResultSet rs = ps.executeQuery();        
            while(rs.next()){          
                Empresa empresa = new Empresa(
                    rs.getInt("cd_empresa"),
                    rs.getString("ds_empresa"),
                    rs.getString("ds_razaosocial"),
                    rs.getString("nm_documento"),
                    (TipoEmpresa)tpempresar.getById(rs.getInt("cd_tpempresa")),
                    rs.getInt("cd_usuario"));
                empresal.add(empresa);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de Empresas:\n" +
                    ex.getMessage(), "Empresa", JOptionPane.ERROR_MESSAGE);
        }
        return empresal;
    }
        
    /**
     * <p><strong>EN:</strong> Fetches a single Service Provider by its identifier, returning
     * a populated {@code Empresa} instance when found.</p>
     *
     * <p><strong>IT:</strong> Recupera un singolo Fornitore di Servizi tramite il suo identificatore,
     * restituendo un’istanza {@code Empresa} popolata se trovato.</p>
     *
     * <p><strong>PT-BR:</strong> Busca um único Prestador de Serviço pelo seu identificador,
     * retornando uma instância {@code Empresa} preenchida quando encontrado.</p>
     */
    public Object getById(int id){
        Empresa empresa = null;
        try {
            sql = "SELECT cd_empresa, ds_empresa, ds_razaosocial, nm_documento, cd_tpempresa, cd_usuario"
                + "  FROM empresa"
                + " WHERE cd_empresa = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                empresa = new Empresa(
                    rs.getInt("cd_empresa"),
                    rs.getString("ds_empresa"),
                    rs.getString("ds_razaosocial"),
                    rs.getString("nm_documento"),
                    (TipoEmpresa)tpempresar.getById(rs.getInt("cd_tpempresa")),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de getById em Empresa" +
                    ex.getMessage(), "Empresa", JOptionPane.ERROR_MESSAGE);
        }        
        return empresa;        
    }
}
