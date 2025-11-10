package br.com.rlmoura81.moura.financeiro;

import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TipoAtivoRepository{

    String sql = "";

    /**
     * <p><strong>EN:</strong> Retrieves all asset types ordered by description.</p>
     * <p><strong>IT:</strong> Recupera tutti i tipi di attivo ordinati per descrizione.</p>
     * <p><strong>PT-BR:</strong> Recupera todos os tipos de ativo ordenados pela descrição.</p>
     *
     * @return EN: list of all asset types | IT: elenco di tutti i tipi di attivo | PT-BR: lista de todos os tipos de ativo
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco de dados
     * @since 1.0.0
     */
    public ArrayList<TipoAtivo> getLista() {
        ArrayList<TipoAtivo> tpativo = new ArrayList();
        try{
            sql = "SELECT cd_tpativo, ds_tpativo " +
                  "  FROM tpativo " +
                  " ORDER BY ds_tpativo";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                TipoAtivo tpa = new TipoAtivo(
                    rs.getInt("cd_tpativo"),
                    rs.getString("ds_tpativo"));
                tpativo.add(tpa);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de tipo de ativos:\n" + 
                    ex.getMessage());
        }
        return tpativo;
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves only fixed-income asset types (IDs 3 and 4), ordered by description.</p>
     * <p><strong>IT:</strong> Recupera solo i tipi di attivo a reddito fisso (ID 3 e 4), ordinati per descrizione.</p>
     * <p><strong>PT-BR:</strong> Recupera apenas os tipos de ativo de renda fixa (IDs 3 e 4), ordenados pela descrição.</p>
     *
     * @return EN: list of fixed-income asset types | IT: elenco dei tipi di attivo a reddito fisso | PT-BR: lista de tipos de ativo de renda fixa
     * @since 1.0.0
     */
    public ArrayList<TipoAtivo> getListaTipoRendaFixa() {
        ArrayList<TipoAtivo> tpativo = new ArrayList();
        try{
            sql = "SELECT cd_tpativo, ds_tpativo " +
                  "  FROM tpativo" +
                  " WHERE cd_tpativo = 3 OR cd_tpativo = 4" +
                  " ORDER BY ds_tpativo";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                TipoAtivo tpa = new TipoAtivo(
                    rs.getInt("cd_tpativo"),
                    rs.getString("ds_tpativo"));
                tpativo.add(tpa);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de tipo de ativos - Renda Fixa:\n" + 
                    ex.getMessage());
        }
        return tpativo;
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves only stock and REIT/real-estate fund asset types (IDs 1 and 2), ordered by description.</p>
     * <p><strong>IT:</strong> Recupera solo i tipi di attivo azionari e fondi immobiliari (ID 1 e 2), ordinati per descrizione.</p>
     * <p><strong>PT-BR:</strong> Recupera apenas os tipos de ativo de Ação e FII (IDs 1 e 2), ordenados pela descrição.</p>
     *
     * @return EN: list of stock/REIT asset types | IT: elenco dei tipi di attivo azionari/immobiliari | PT-BR: lista de tipos de ativo de Ação/FII
     * @since 1.0.0
     */
    public ArrayList<TipoAtivo> getListaTipoAtivoAcaoFII() {
        ArrayList<TipoAtivo> tpativo = new ArrayList<>();
        try{
            sql = "SELECT cd_tpativo, ds_tpativo " +
                  "  FROM tpativo" +
                  " WHERE cd_tpativo = 1 OR cd_tpativo = 2" +
                  " ORDER BY ds_tpativo";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                TipoAtivo tpa = new TipoAtivo(
                    rs.getInt("cd_tpativo"),
                    rs.getString("ds_tpativo"));
                tpativo.add(tpa);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de tipo de ativos - Acao/FII:\n" + 
                    ex.getMessage());
        }
        return tpativo;
    }

    /**
     * <p><strong>EN:</strong> Retrieves a single asset type by its identifier.</p>
     * <p><strong>IT:</strong> Recupera un singolo tipo di attivo tramite il suo identificatore.</p>
     * <p><strong>PT-BR:</strong> Recupera um único tipo de ativo pelo seu identificador.</p>
     *
     * @param id EN: asset type ID to search | IT: ID del tipo di attivo da cercare | PT-BR: ID do tipo de ativo a pesquisar
     * @return EN: asset type object if found, otherwise null | IT: oggetto del tipo di attivo se trovato, altrimenti null | PT-BR: objeto do tipo de ativo se encontrado, caso contrário null
     * @throws SQLException EN: if a database access error occurs | IT: se si verifica un errore di accesso al database | PT-BR: se ocorrer erro de acesso ao banco de dados
     * @since 1.0.0
     */
    public Object getById(int id) {
        TipoAtivo tpativo = null;
        try{
            sql = "SELECT cd_tpativo, ds_tpativo " +
                  "  FROM tpativo " +
                  " WHERE cd_tpativo = ?";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                tpativo = new TipoAtivo(
                    rs.getInt("cd_tpativo"),
                    rs.getString("ds_tpativo"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em tipo de ativos:\n" + 
                    ex.getMessage());
        }
        return tpativo;
    }
}
