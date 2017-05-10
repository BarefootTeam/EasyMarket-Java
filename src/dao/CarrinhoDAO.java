/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Carrinho;
import util.BDUtil;
import util.ConexaoPostGree;

/**
 *
 * @author lucasm
 */
public class CarrinhoDAO {
    
    private static CarrinhoDAO carrinhoDAO;
    
    public static CarrinhoDAO getInstance(){
        if(carrinhoDAO == null){
            carrinhoDAO = new CarrinhoDAO();
        }
        return carrinhoDAO;
    }
    
 //GetProduto
    private Carrinho getCarrinho(ResultSet rs) throws SQLException{

        Carrinho c = new Carrinho();
        c.setId(rs.getLong("id"));
        c.setStatus(rs.getBoolean("status"));
        c.setData(rs.getDate("data"));
        
        return c;
    }

 //Metodo por ID
    public Carrinho buscarPorID(long id){
        String sql = " SELECT * FROM carrinho WHERE id = '"+ id+"'";
        
        Carrinho retorno = null;
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);
            
            while(rs.next()){
                retorno = getCarrinho(rs);
            }
            
            state.close();
            
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        
        return retorno;
    }

//Metodo buscar todos
    public ArrayList<Carrinho> buscarTodos(){
        String sql = "SELECT * FROM carrinho";
        
        ArrayList<Carrinho> retorno = new ArrayList<Carrinho>();
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);
            
            while(rs.next()){
                retorno.add(getCarrinho(rs));
            }
            
            state.close();
            
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        
        return retorno;
    }

/*Metodo de persistencia
* @param Produto
* @return boolean
*/
    public boolean persistir(Carrinho carrinho){
        String sql;
        
        if(carrinho.getId() != null){
            sql = "UPDATE carrinho SET status=?, data=? WHERE id = ?";
        }else{
            carrinho.setId(BDUtil.getProxID());
            sql = "INSERT INTO carrinho(status,data) VALUES(?,?)";
        }
        
        PreparedStatement state;
        try {
            state = ConexaoPostGree.getConexao().prepareStatement(sql);
            
            state.setString(1, carrinho.isStatus());
            state.setString(2, carrinho.getData());
            state.setLong(3, carrinho.getId());
            
            state.executeUpdate();
            
            state.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu erro na persistencia");
            return false;
        }
        
        return true;
    }

/*Metodo polimorfismo deletar
*@param Supermercado OBJ
*@return Supermercado.getId()
*/
    public boolean deletar(Carrinho carrinho){
        return deletar(carrinho.getId());
    }
    
    
/*Metodo para deletar
* @param Long id
* @return boolean
*/
    public boolean deletar(Long id){
        String sql = "DELETE FROM carrinho WHERE id = ?";
        
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
