/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.SupermercadoDAO;
import java.util.List;
import model.Supermercado;

/**
 *
 * @author Leo
 */
public class SupermercadoController {
    
    private static SupermercadoController supermercadoController;

    public static SupermercadoController getInstance() {
        if (supermercadoController == null) {
            supermercadoController = new SupermercadoController();
        }
        return supermercadoController;
    }

    public boolean deletar(Long id) {
        return SupermercadoDAO.getInstance().deletar(id);
    
    }

    public void persistir(Supermercado supermercado) {
        SupermercadoDAO.getInstance().persistir(supermercado);
    }

    public Supermercado buscarID(Long id) {
   
        return SupermercadoDAO.getInstance().buscarPorID(id);
    }
    
    
    public List<Supermercado> buscar(int indice, String texto) {
  
       return SupermercadoDAO.getInstance().buscar(indice, texto);
    }
    
    public List<Supermercado> BuscarTodos() {
        return SupermercadoDAO.getInstance().buscarTodos();
    }
    
}
