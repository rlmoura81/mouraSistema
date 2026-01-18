package br.com.rlmoura81.moura.principal;

import br.com.rlmoura81.moura.principalcadastro.Categoria;
import br.com.rlmoura81.moura.principalcadastro.CategoriaRepository;
import br.com.rlmoura81.moura.principalcadastro.Empresa;
import br.com.rlmoura81.moura.principalcadastro.EmpresaRepository;
import br.com.rlmoura81.moura.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ModuloAplicativoRepository {
    
    String sql = "";    
    ModuloRepository modulor = new ModuloRepository();    
    EmpresaRepository empresar = new EmpresaRepository();    
    CategoriaRepository categoriar = new CategoriaRepository();
    
    /**
     * <p><strong>EN:</strong> Inserts a Module–Category association (<code>catmod</code>) into the database.  
     * Reads module, category, and user from the provided {@link ModuloAplicativo} and executes an INSERT.  
     * Shows a success dialog on completion; otherwise shows an error dialog.</p>
     *
     * <p><strong>IT:</strong> Inserisce in database un’associazione Modulo–Categoria (<code>catmod</code>).  
     * Legge modulo, categoria e utente dal {@link ModuloAplicativo} fornito ed esegue un INSERT.  
     * Mostra un dialog di successo al termine; in caso contrario mostra un dialog di errore.</p>
     *
     * <p><strong>PT-BR:</strong> Insere no banco a associação Módulo–Categoria (<code>catmod</code>).  
     * Lê módulo, categoria e usuário do {@link ModuloAplicativo} informado e executa o INSERT.  
     * Exibe um diálogo de sucesso ao concluir; caso contrário exibe um diálogo de erro.</p>
     */
    public void inserirCatMod(Object o) {
        ModuloAplicativo modapp = (ModuloAplicativo) o;
        try{
            sql = "INSERT INTO catmod (cd_modulo, cd_categoria, cd_usuario)" +
                  "     VALUES (?, ?, ?)";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, modapp.getModulo().getCd_modulo());
            ps.setInt(2, modapp.getCategoria().getCd_Categoria());
            ps.setInt(3, modapp.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Categoria - Modulo", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Categoria - Modulo", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Inserts a Module–Service Provider association (<code>presservmod</code>) into the database.  
     * Uses module, service provider, and user from {@link ModuloAplicativo}, then executes an INSERT.  
     * Displays a success message or an error dialog if the operation fails.</p>
     *
     * <p><strong>IT:</strong> Inserisce in database un’associazione Modulo–Prestatore (<code>presservmod</code>).  
     * Usa modulo, prestatore e utente da {@link ModuloAplicativo}, poi esegue un INSERT.  
     * Mostra un messaggio di successo o un dialog di errore in caso di fallimento.</p>
     *
     * <p><strong>PT-BR:</strong> Insere no banco a associação Módulo–Prestador de Serviço (<code>presservmod</code>).  
     * Usa módulo, prestador e usuário do {@link ModuloAplicativo} e executa o INSERT.  
     * Exibe mensagem de sucesso ou diálogo de erro se falhar.</p>
     */
    public void inserirPresServMod(Object o) {
        ModuloAplicativo modapp = (ModuloAplicativo) o;
        try{
            sql = "INSERT INTO presservmod (cd_modulo, cd_presserv, cd_usuario)" +
                  "     VALUES (?, ?, ?)";            
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, modapp.getModulo().getCd_modulo());
            ps.setInt(2, modapp.getEmpresa().getCd_empresa());
            ps.setInt(3, modapp.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Empresa - Modulo", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Prestador de Serviço - Modulo", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Retrieves all Module–Category links visible to the current user.  
     * Performs a JOIN across <code>modulo</code>, <code>categoria</code>, and <code>catmod</code>, filtering by logged-in user.  
     * Returns a list of {@link ModuloAplicativo} with module and category hydrated.</p>
     *
     * <p><strong>IT:</strong> Recupera tutte le relazioni Modulo–Categoria visibili all’utente corrente.  
     * Esegue una JOIN tra <code>modulo</code>, <code>categoria</code> e <code>catmod</code>, filtrando per utente loggato.  
     * Restituisce una lista di {@link ModuloAplicativo} con modulo e categoria valorizzati.</p>
     *
     * <p><strong>PT-BR:</strong> Busca todos os vínculos Módulo–Categoria visíveis ao usuário atual.  
     * Executa JOIN entre <code>modulo</code>, <code>categoria</code> e <code>catmod</code>, filtrando pelo usuário logado.  
     * Retorna uma lista de {@link ModuloAplicativo} com módulo e categoria preenchidos.</p>
     */
    public ArrayList getListaCatMod() {
        ArrayList modapp = new ArrayList();
        try{
            sql = "SELECT modulo.cd_modulo, categoria.cd_categoria, catmod.cd_usuario" +
                  "  FROM modulo, categoria, catmod" +
                  " WHERE modulo.cd_modulo = catmod.cd_modulo" +
                  "   AND categoria.cd_categoria = catmod.cd_categoria" +
                  "   AND categoria.cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                ModuloAplicativo ma = new ModuloAplicativo(
                    (Modulo)modulor.getById(rs.getInt("cd_modulo")),
                    (Categoria)categoriar.getById(rs.getInt("cd_categoria")),                      
                    rs.getInt("cd_usuario"));
                modapp.add(ma);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de MódulosApp - Categoria:\n" +
                    ex.getMessage(), "Categoria - Modulo", JOptionPane.ERROR_MESSAGE);
        }
        return modapp;
    }
         
    /**
     * <p><strong>EN:</strong> Retrieves all Module–Service Provider links for the current user.  
     * Joins <code>modulo</code>, <code>presserv</code>, and <code>presservmod</code> filtered by the logged-in user.  
     * Returns a list of {@link ModuloAplicativo} with module and service provider objects.</p>
     *
     * <p><strong>IT:</strong> Recupera tutte le relazioni Modulo–Prestatore per l’utente corrente.  
     * Esegue JOIN tra <code>modulo</code>, <code>presserv</code> e <code>presservmod</code> filtrando per utente loggato.  
     * Restituisce una lista di {@link ModuloAplicativo} con modulo e prestatore valorizzati.</p>
     *
     * <p><strong>PT-BR:</strong> Retorna todos os vínculos Módulo–Prestador de Serviço do usuário atual.  
     * Faz JOIN entre <code>modulo</code>, <code>presserv</code> e <code>presservmod</code>, filtrando pelo usuário logado.  
     * Devolve uma lista de {@link ModuloAplicativo} com módulo e prestador preenchidos.</p>
     */
    public ArrayList getListaEmpresaMod() {
        ArrayList modapp = new ArrayList();
        try{
            sql = "SELECT modulo.cd_modulo, empresa.cd_empresa, empresamod.cd_usuario" +
                  "  FROM modulo, empresa, empresamod" +
                  " WHERE modulo.cd_modulo = empresamod.cd_modulo" +
                  "   AND empresa.cd_empresa = empresamod.cd_empresa" +
                  "   AND empresa.cd_usuario = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                ModuloAplicativo ma = new ModuloAplicativo(
                    (Modulo)modulor.getById(rs.getInt("cd_modulo")),
                    (Empresa)empresar.getById(rs.getInt("cd_empresa")),                      
                    rs.getInt("cd_usuario"));
                modapp.add(ma);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de MódulosApp - Empresa:\n" +
                    ex.getMessage(), "Empresa - Modulo", JOptionPane.ERROR_MESSAGE);
        }
        return modapp;
    }
    
    /**
     * <p><strong>EN:</strong> Retrieves Module–Service Provider links for a specific module.  
     * Filters by the given module id and joins <code>modulo</code>, <code>presserv</code>, and <code>presservmod</code>.  
     * Returns a list of {@link ModuloAplicativo} for that module.</p>
     *
     * <p><strong>IT:</strong> Recupera le relazioni Modulo–Prestatore per uno specifico modulo.  
     * Filtra per id modulo e unisce <code>modulo</code>, <code>presserv</code> e <code>presservmod</code>.  
     * Restituisce una lista di {@link ModuloAplicativo} per quel modulo.</p>
     *
     * <p><strong>PT-BR:</strong> Busca vínculos Módulo–Prestador para um módulo específico.  
     * Filtra pelo id do módulo e realiza JOIN entre <code>modulo</code>, <code>presserv</code> e <code>presservmod</code>.  
     * Retorna uma lista de {@link ModuloAplicativo} daquele módulo.</p>
     */
    public ArrayList getListaEmpresaMod(int cd_modulo) {
        ArrayList modapp = new ArrayList();
        try{
            sql = "SELECT modulo.cd_modulo, empresa.cd_empresa, empresamod.cd_usuario" +
                  "  FROM modulo, empresa, empresamod" +
                  " WHERE modulo.cd_modulo = empresamod.cd_modulo" +
                  "   AND modulo.cd_modulo = ?" +
                  "   AND empresa.cd_presserv = empresamod.cd_empresa";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, cd_modulo);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                ModuloAplicativo ma = new ModuloAplicativo(
                    (Modulo)modulor.getById(rs.getInt("cd_modulo")),
                    (Empresa)empresar.getById(rs.getInt("cd_empresa")),                      
                    rs.getInt("cd_usuario"));
                modapp.add(ma);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de MódulosApp - Empresa por Modulo:\n" +
                    ex.getMessage(), "Empresa - Modulo", JOptionPane.ERROR_MESSAGE);
        }
        return modapp;
    }

    /**
     * <p><strong>EN:</strong> Looks up a single Module–Category link by category id.  
     * Executes a JOIN across <code>modulo</code>, <code>categoria</code>, and <code>catmod</code>, filtered by category.  
     * Returns the matching {@link ModuloAplicativo} or <code>null</code> if not found.</p>
     *
     * <p><strong>IT:</strong> Cerca una singola relazione Modulo–Categoria tramite id categoria.  
     * Esegue una JOIN su <code>modulo</code>, <code>categoria</code> e <code>catmod</code>, filtrando per categoria.  
     * Restituisce il {@link ModuloAplicativo} trovato o <code>null</code> se assente.</p>
     *
     * <p><strong>PT-BR:</strong> Consulta um vínculo Módulo–Categoria pelo id da categoria.  
     * Faz JOIN entre <code>modulo</code>, <code>categoria</code> e <code>catmod</code>, filtrando pela categoria.  
     * Retorna o {@link ModuloAplicativo} correspondente ou <code>null</code> se não existir.</p>
     */
    public Object getByIdCatMod(int id) {
        ModuloAplicativo modapp = null;
        try{
            sql = "SELECT modulo.cd_modulo, categoria.cd_categoria, catmod.cd_usuario" +
                  "  FROM modulo, categoria, catmod" +
                  " WHERE modulo.cd_modulo = catmod.cd_modulo" +
                  "   AND categoria.cd_categoria = catmod.cd_categoria" +
                  "   AND categoria.cd_categoria = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                ModuloAplicativo ma = new ModuloAplicativo(
                    (Modulo)modulor.getById(rs.getInt("cd_modulo")),
                    (Categoria)categoriar.getById(rs.getInt("cd_categoria")),                       
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em MódulosApp - Categoria:\n" +
                    ex.getMessage(), "Categoria - Modulo", JOptionPane.ERROR_MESSAGE);
        }
        return modapp;
    }
        
    /**
     * <p><strong>EN:</strong> Looks up a single Module–Service Provider link by provider id.  
     * Joins <code>modulo</code>, <code>presserv</code>, and <code>presservmod</code>, filtered by the given provider id.  
     * Returns the corresponding {@link ModuloAplicativo} or <code>null</code> if not found.</p>
     *
     * <p><strong>IT:</strong> Cerca una relazione Modulo–Prestatore tramite id prestatore.  
     * Esegue JOIN tra <code>modulo</code>, <code>presserv</code> e <code>presservmod</code>, filtrando per id prestatore.  
     * Restituisce il relativo {@link ModuloAplicativo} o <code>null</code> se assente.</p>
     *
     * <p><strong>PT-BR:</strong> Consulta um vínculo Módulo–Prestador pelo id do prestador.  
     * Realiza JOIN entre <code>modulo</code>, <code>presserv</code> e <code>presservmod</code>, filtrando pelo id informado.  
     * Retorna o {@link ModuloAplicativo} correspondente ou <code>null</code> se não houver resultado.</p>
     */
    public Object getByIdPresServMod(int id) {
        ModuloAplicativo modapp = null;
        try{
            sql = "SELECT empresa.cd_empresa, modulo.cd_modulo, empresamod.cd_usuario" +
                  "  FROM modulo, empresa, empresamod" +
                  " WHERE modulo.cd_modulo = empresamod.cd_modulo" +
                  "   AND empresa.cd_empresa = empresamod.cd_empresa" +
                  "   AND empresa.cd_empresa = ?";
            PreparedStatement ps = JPLogin.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                ModuloAplicativo ma = new ModuloAplicativo(
                    (Modulo)modulor.getById(rs.getInt("cd_modulo")),
                    (Empresa)empresar.getById(rs.getInt("cd_empresa")),                       
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em MódulosApp - Empresa:\n" +
                    ex.getMessage(), "Empresa - Modulo", JOptionPane.ERROR_MESSAGE);
        }
        return modapp;
    }    
}
