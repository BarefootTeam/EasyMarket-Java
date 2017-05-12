package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Supermercado;
import util.BDUtil;
import util.ConexaoPostGree;

/**
 *
 * @author Leo
 */
public class SupermercadoDAO {

    private static SupermercadoDAO supermercadoDAO;
    
    public static SupermercadoDAO getInstance(){
        if(supermercadoDAO == null){
            supermercadoDAO = new SupermercadoDAO();
        }
        return supermercadoDAO;
    }
    
    //GetSupermercado
    private Supermercado getSuperMercado(ResultSet rs) throws SQLException{
        Supermercado i = new Supermercado();
        i.setId(rs.getLong("id"));
        i.setNome(rs.getString("nome"));
        i.setCnpj(rs.getString("cnpj"));
        
        return i;
    }
    
    
    
    //Metodo por ID
    public Supermercado buscarPorID(long id){
        String sql = " SELECT * FROM supermercado"
                   + " WHERE id = '"+ id+"'";
        
        Supermercado retorno = null;
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);
            
            
            while(rs.next()){
                retorno = getSuperMercado(rs);
            }
            
            state.close();
            
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        
        return retorno;
    }
    
    
    
    
    //Metodo buscar todos
    public ArrayList<Supermercado> buscarTodos(){
        String sql = "SELECT * FROM supermercado";
        
        ArrayList<Supermercado> retorno = new ArrayList<Supermercado>();
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);
            
            
            while(rs.next()){
                retorno.add(getSuperMercado(rs));
            }
            
            state.close();
            
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        
        return retorno;
    }
    
    
       
    
    
    /*Metodo de persistencia
    * @param Supermercado
    * @return boolean
    */
    public boolean persistir(Supermercado supermercado){
        String sql;
        
        if(supermercado.getId() != null){
            sql = "UPDATE supermercado SET nome=?, cnpj=? WHERE id = ?";
        }else{
            supermercado.setId(BDUtil.getProxID());
            sql = "INSERT INTO supermercado(nome,cnpj,id) VALUES(?,?,?)";
        }
        
        PreparedStatement state;
        try {
            state = ConexaoPostGree.getConexao().prepareStatement(sql);
            
            state.setString(1, supermercado.getNome());
            state.setString(2, supermercado.getCnpj());
            state.setLong(3, supermercado.getId());
            
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
    public boolean deletar(Supermercado supermercado){
        return deletar(supermercado.getId());
    }
    
    
    /*Metodo para deletar
    * @param Long id
    * @return boolean
    */
    public boolean deletar(Long id){
        String sql = "DELETE FROM supermercado WHERE id = ?";
        
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
}
