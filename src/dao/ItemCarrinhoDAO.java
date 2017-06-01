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
import model.ItemCarrinho;
import util.BDUtil;
import util.ConexaoPostGree;

/**
 *
 * @author Leo
 */
public class ItemCarrinhoDAO {
    
    private static ItemCarrinhoDAO itemCarrinhoDAO;
    
    public static ItemCarrinhoDAO getInstance(){
        if(itemCarrinhoDAO == null){
            itemCarrinhoDAO = new ItemCarrinhoDAO();
        }
        return itemCarrinhoDAO;
    }
    
    //GetSupermercado
    private ItemCarrinho getItemCarrinho(ResultSet rs) throws SQLException{
        ItemCarrinho i = new ItemCarrinho();
        i.setId(rs.getLong("id"));
        i.setCarrinho(CarrinhoDAO.getInstance().buscarPorID(rs.getLong("id_carrinho")));
        i.setProduto(ProdutoDAO.getInstance().buscarPorID(rs.getLong("id_produto")));
        i.setValor(rs.getFloat("valor"));
        i.setQuantidade(rs.getInt("quantidade"));
        
        return i;
    }
    
    
    
    //Metodo por ID
    public ItemCarrinho buscarPorID(long id){
        String sql = " SELECT * FROM itens_carrinho"
                   + " WHERE id = '"+ id+"'";
        
        ItemCarrinho retorno = null;
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);
            
            
            while(rs.next()){
                retorno = getItemCarrinho(rs);
            }
            
            state.close();
            
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        
        return retorno;
    }
    
    
    
    
    //Metodo buscar todos
    public ArrayList<ItemCarrinho> buscarTodos(){
        String sql = "SELECT * FROM itens_carrinho";
        
        ArrayList<ItemCarrinho> retorno = new ArrayList<ItemCarrinho>();
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);
            
            
            while(rs.next()){
                retorno.add(getItemCarrinho(rs));
            }
            
            state.close();
            
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        
        return retorno;
    }
    
    
    //Busca por carrinho
    //Metodo buscar todos
    public ArrayList<ItemCarrinho> buscaPorCarrinho(Long id_carrinho){
        String sql = "SELECT * FROM itens_carrinho WHERE id_carrinho = "+id_carrinho;
        
        ArrayList<ItemCarrinho> retorno = new ArrayList<ItemCarrinho>();
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);
            
            
            while(rs.next()){
                retorno.add(getItemCarrinho(rs));
            }
            
            state.close();
            
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        
        return retorno;
    }
    
    
       
    
    
    /*Metodo de persistencia
    * @param Cliente
    * @return boolean
    */
    public boolean persistir(ItemCarrinho itemCarrinho){
        String sql;
        
        if(itemCarrinho.getId() != null){
            sql = "UPDATE itens_carrinho SET id_produto=?,id_carrinho=?,valor=?,quantidade=? WHERE id = ?";
        }else{
            itemCarrinho.setId(BDUtil.getProxID());
            sql = "INSERT INTO itens_carrinho(id_produto,id_carrinho,valor,quantidade,id) VALUES(?,?,?,?,?)";
        }
        
        PreparedStatement state;
        try {
            state = ConexaoPostGree.getConexao().prepareStatement(sql);
            
            state.setLong(1, itemCarrinho.getProduto().getId());
            state.setLong(2, itemCarrinho.getCarrinho().getId());
            state.setFloat(3, itemCarrinho.getValor());
            state.setInt(4, itemCarrinho.getQuantidade());
            state.setLong(5, itemCarrinho.getId());
            
            state.executeUpdate();
            
            state.close();            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu erro na persistencia" + e.getMessage());
            return false;
        }
        
        return true;
    }
    
    
    
    
     /*
    Metodo polimorfismo deletar
    @param Cliente OBJ
    @return Cliente.getId()
    */
    public boolean deletar(ItemCarrinho itemCarrinho){
        return deletar(itemCarrinho.getId());
    }
    
    
    /*Metodo para deletar
    * @param Long id
    * @return boolean
    */
    public boolean deletar(Long id){
        String sql = "DELETE FROM itemCarrinho WHERE id = ?";
        
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
