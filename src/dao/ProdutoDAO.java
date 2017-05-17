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
import java.util.List;
import javax.swing.JOptionPane;
import model.Produto;
import util.BDUtil;
import util.ConexaoPostGree;
import util.DateTimeUtil;

/**
 *
 * @author lucasm
 */
public class ProdutoDAO {
    
    private static ProdutoDAO produtoDAO;
    
    public static ProdutoDAO getInstance(){
        if(produtoDAO == null){
            produtoDAO = new ProdutoDAO();
        }
        return produtoDAO;
    }
    
//GetProduto
    private Produto getProduto(ResultSet rs) throws SQLException{
        Produto p = new Produto();
        p.setId(rs.getLong("id"));
        p.setNome(rs.getString("nome"));
        p.setCod(rs.getString("cod"));
        p.setDescricao(rs.getString("descricao"));
        p.setPrecoCusto(rs.getFloat("preco_custo"));
        p.setFoto(rs.getBytes("foto"));
        p.setSupermercado(SupermercadoDAO.getInstance().buscarPorID(rs.getLong("id_supermercado")));

        
        return p;
    }
    
    
    
//Metodo por ID
    public Produto buscarPorID(long id){
        String sql = " SELECT * FROM produto WHERE id = '"+ id+"'";
        
        Produto retorno = null;
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);
            
            while(rs.next()){
                retorno = getProduto(rs);
            }
            
            state.close();
            
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        
        return retorno;
    }
    
    
    //Metodo por Nome
    public ArrayList<Produto> buscarPorNome(String nome){
        String sql = " SELECT * FROM produto WHERE nome like '%"+ nome+"%'";
        
        ArrayList<Produto> retorno = new ArrayList<Produto>();
       
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                retorno.add(getProduto(rs));
            }

            state.close();

        } catch (SQLException ex) {
            System.err.println(ex);
        }
        
        return retorno;
    }
    
    
//Metodo buscar todos
    public ArrayList<Produto> buscarTodos(){
        String sql = "SELECT * FROM produto";
        
        ArrayList<Produto> retorno = new ArrayList<Produto>();
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);
            
            while(rs.next()){
                retorno.add(getProduto(rs));
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
    public boolean persistir(Produto produto){
        String sql;
        
        if(produto.getId() != null){
            sql = "UPDATE produto SET id_supermercado = ?, nome=?, cod=?, descricao=?, preco_custo=?, foto=? WHERE id = ?";
        }else{
            produto.setId(BDUtil.getProxID());
            sql = "INSERT INTO produto(id_supermercado,nome,cod,descricao,preco_custo,foto,id) VALUES(?,?,?,?,?,?,?)";
        }
        
        PreparedStatement state;
        try {
            state = ConexaoPostGree.getConexao().prepareStatement(sql);
            
            state.setLong(1, produto.getSupermercado().getId());
            state.setString(2, produto.getNome());
            state.setString(3, produto.getCod());
            state.setString(4, produto.getDescricao());
            state.setFloat(5, produto.getPrecoCusto());
            state.setBytes(6, produto.getFoto());
            state.setLong(7, produto.getId());
            
            state.executeUpdate();
            
            state.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu erro na persistencia: "+ e.getMessage());
            return false;
        }
        
        return true;
    }
    
/*Metodo polimorfismo deletar
*@param Supermercado OBJ
*@return Supermercado.getId()
*/
    public boolean deletar(Produto produto){
        return deletar(produto.getId());
    }
    
    
/*Metodo para deletar
* @param Long id
* @return boolean
*/
    public boolean deletar(Long id){
        String sql = "DELETE FROM produto WHERE id = ?";
        
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
     * Busca os alunos de acordo com o indice passado 
     *  { 0 - id, 1 - COD, 2 - nome }
     * @param indice
     * @param texto
     * @return Lista de Produto
     */
    public List<Produto> buscar(int indice, String texto) {

        String sql = "SELECT * FROM produto";

        if (!texto.equals("")) {
            if (indice == 0) { // COD
                sql += " WHERE upper(cod) = '" + texto.toUpperCase() + "'";
            } else if (indice == 1) { // NOME
                sql += " WHERE upper(nome) like '%" + texto.toUpperCase() + "%'";
            }
        }

        List<Produto> retorno = new ArrayList<Produto>();
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                retorno.add(getProduto(rs));
            }

            state.close();

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return retorno;

    }
 }
