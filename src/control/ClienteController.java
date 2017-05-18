/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.ClienteDAO;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;

/**
 *
 * @author Leo
 */
public class ClienteController {
    
    
    private static ClienteController clienteController;

    public static ClienteController getInstance() {
        if (clienteController == null) {
            clienteController = new ClienteController();
        }
        return clienteController;
    }

    /**
     * Controler - Intermedia a visao e o modelo nos metodos
     * @param nome String
     * @return ArrayList<Aluno>
     */

    public boolean deletar(Long id) {
        return ClienteDAO.getInstance().deletar(id);
    
    }

    public void persistir(Cliente cliente) {
        ClienteDAO.getInstance().persistir(cliente);
    }

    public Cliente buscarID(Long id) {
   
        return ClienteDAO.getInstance().buscarPorID(id);
    }


    public List<Cliente> BuscarTodos() {
        return ClienteDAO.getInstance().buscarTodos();
    }
    
    
    public List<Cliente> buscar(int indice, String texto) {
  
        return ClienteDAO.getInstance().buscar(indice, texto);
    }
    
}
