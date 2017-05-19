package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Usuario;
import util.BDUtil;
import util.ConexaoPostGree;

/**
 *
 * @author Leo
 */
public class UsuarioDAO {
    
    private static UsuarioDAO usuarioDAO;
    
    public static UsuarioDAO getInstance(){
        if(usuarioDAO == null){
            usuarioDAO = new UsuarioDAO();
        }
        return usuarioDAO;
    }
    
    //GetSupermercado
    private Usuario getUsuario(ResultSet rs) throws SQLException{
        Usuario u = new Usuario();
        u.setId(rs.getLong("id"));
        u.setLogin(rs.getString("login"));
        u.setSenha(rs.getString("senha"));
        u.setNome(rs.getString("nome"));
        u.setCpf(rs.getString("cpf"));
        u.setSupermercado(SupermercadoDAO.getInstance().buscarPorID(rs.getLong("id_supermercado")));
        
        return u;
    }
    
    
    
    //Metodo por ID
    public Usuario buscarPorID(long id){
        String sql = " SELECT * FROM usuario"
                   + " WHERE id = '"+ id+"'";
        
        Usuario retorno = null;
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);
            
            
            while(rs.next()){
                retorno = getUsuario(rs);
            }
            
            state.close();
            
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        
        return retorno;
    }
    
    
    
    
    //Metodo buscar todos
    public ArrayList<Usuario> buscarTodos(){
        String sql = "SELECT * FROM usuario";
        
        ArrayList<Usuario> retorno = new ArrayList<Usuario>();
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);
            
            
            while(rs.next()){
                retorno.add(getUsuario(rs));
            }
            
            state.close();
            
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        
        return retorno;
    }
    
    
       
    
    
    /*Metodo de persistencia
    * @param Usuario
    * @return boolean
    */
    public boolean persistir(Usuario usuario){
        String sql;
        
        if(usuario.getId() != null){
            sql = "UPDATE usuario SET login=?, senha=?, nome=?, cpf=?, id_supermercado = ? WHERE id = ?";
        }else{
            usuario.setId(BDUtil.getProxID());
            sql = "INSERT INTO usuario(login,senha,nome,cpf,id_supermercado,id) VALUES(?,?,?,?,?,?)";
        }
        
        PreparedStatement state;
        try {
            state = ConexaoPostGree.getConexao().prepareStatement(sql);
            
            state.setString(1, usuario.getLogin());
            state.setString(2, usuario.getSenha());
            state.setString(3, usuario.getNome());
            state.setString(4, usuario.getCpf());
            state.setLong(5, usuario.getSupermercado().getId());
            state.setLong(6, usuario.getId());
            
            state.executeUpdate();
            
            state.close();            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu erro na persistencia");
            return false;
        }
        
        return true;
    }
    
    
    
    
     /*
    Metodo polimorfismo deletar
    @param Supermercado OBJ
    @return Supermercado.getId()
    */
    public boolean deletar(Usuario usuario){
        return deletar(usuario.getId());
    }
    
    
    /*Metodo para deletar
    * @param Long id
    * @return boolean
    */
    public boolean deletar(Long id){
        String sql = "DELETE FROM usuario WHERE id = ?";
        
        int total = 0;
        try {
            PreparedStatement state = ConexaoPostGree.getConexao().prepareStatement(sql);
            
            state.setLong(1, id);
            
            total = state.executeUpdate();
            
            state.close();            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu erro na deleção");
            return false;
        }
        
        return total > 0;
    }
    
    
    /**
     * Busca os usuarios de acordo com o indice passado 
     *  { 0 - login, 1 - CPF, 2 - NOME }
     * @param indice
     * @param texto
     * @return Lista de Produto
     */
    public List<Usuario> buscar(int indice, String texto) {

        String sql = "SELECT * FROM usuario";

        if (!texto.equals("")) {
            if (indice == 0) { // LOGIN
                sql += " WHERE upper(login) like '%" + texto.toUpperCase() + "%'";
            } else if (indice == 1) { // CPF
                sql += " WHERE cpf = '" + texto.toUpperCase() + "'";
            } else if (indice == 2) { // NOME
                sql += " WHERE upper(nome) like '%" + texto.toUpperCase() + "%'";
            }
        }

        List<Usuario> retorno = new ArrayList<Usuario>();
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                retorno.add(getUsuario(rs));
            }

            state.close();

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return retorno;

    }
}
