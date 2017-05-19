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
import model.Cliente;
import util.BDUtil;
import util.ConexaoPostGree;

/**
 *
 * @author Leo
 */
public class ClienteDAO {

    private static ClienteDAO clienteDAO;
    
    public static ClienteDAO getInstance(){
        if(clienteDAO == null){
            clienteDAO = new ClienteDAO();
        }
        return clienteDAO;
    }
    
    //GetSupermercado
    private Cliente getCliente(ResultSet rs) throws SQLException{
        Cliente c = new Cliente();
        c.setId(rs.getLong("id"));
        c.setNome(rs.getString("nome"));
        c.setCpf(rs.getString("cpf"));
        
        return c;
    }
    
    
    
    //Metodo por ID
    public Cliente buscarPorID(long id){
        String sql = " SELECT * FROM cliente"
                   + " WHERE id = '"+ id+"'";
        
        Cliente retorno = null;
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);
            
            
            while(rs.next()){
                retorno = getCliente(rs);
            }
            
            state.close();
            
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        
        return retorno;
    }
    
    
    //Metodo por CPF
    public Cliente buscarCPF(String cpf){
        String sql = " SELECT * FROM cliente"
                   + " WHERE cpf = '"+ cpf+"'";
        
        Cliente retorno = null;
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);
            
            
            while(rs.next()){
                retorno = getCliente(rs);
            }
            
            state.close();
            
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        
        return retorno;
    }
    
    
    
    
    //Metodo buscar todos
    public ArrayList<Cliente> buscarTodos(){
        String sql = "SELECT * FROM cliente";
        
        ArrayList<Cliente> retorno = new ArrayList<Cliente>();
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);
            
            
            while(rs.next()){
                retorno.add(getCliente(rs));
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
    public boolean persistir(Cliente cliente){
        String sql;
        
        if(cliente.getId() != null){
            sql = "UPDATE cliente SET nome=?, cpf=? WHERE id = ?";
        }else{
            cliente.setId(BDUtil.getProxID());
            sql = "INSERT INTO cliente(nome,cpf,id) VALUES(?,?,?)";
        }
        
        PreparedStatement state;
        try {
            state = ConexaoPostGree.getConexao().prepareStatement(sql);
            
            state.setString(1, cliente.getNome());
            state.setString(2, cliente.getCpf());
            state.setLong(3, cliente.getId());
            
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
    @param Cliente OBJ
    @return Cliente.getId()
    */
    public boolean deletar(Cliente cliente){
        return deletar(cliente.getId());
    }
    
    
    /*Metodo para deletar
    * @param Long id
    * @return boolean
    */
    public boolean deletar(Long id){
        String sql = "DELETE FROM cliente WHERE id = ?";
        
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
     * Busca os cliente de acordo com o indice passado 
     *  { 0 - Nome, 1 - CPF }
     * @param indice
     * @param texto
     * @return Lista de Produto
     */
    public List<Cliente> buscar(int indice, String texto) {

        String sql = "SELECT * FROM cliente";

        if (!texto.equals("")) {
            if (indice == 0) { // NOME
                sql += " WHERE upper(nome) like '%" + texto.toUpperCase() + "%'";
            } else if (indice == 1) { // CPF
                sql += " WHERE cpf = '" + texto.toUpperCase() + "'";
            }
        }

        List<Cliente> retorno = new ArrayList<Cliente>();
        try {
            Statement state = ConexaoPostGree.getConexao().createStatement();
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                retorno.add(getCliente(rs));
            }

            state.close();

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return retorno;

    }
}
