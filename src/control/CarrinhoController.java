/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.CarrinhoDAO;
import java.util.ArrayList;
import java.util.List;
import model.Carrinho;

/**
 *
 * @author Leo
 */
public class CarrinhoController {
    
    private static CarrinhoController carrinhoController;

    public static CarrinhoController getInstance() {
        if (carrinhoController == null) {
            carrinhoController = new CarrinhoController();
        }
        return carrinhoController;
    }


    public boolean deletar(Long id) {
        return CarrinhoDAO.getInstance().deletar(id);
    
    }

    public void persistir(Carrinho carrinho) {
        CarrinhoDAO.getInstance().persistir(carrinho);
    }

    public Carrinho buscarID(Long id) {
   
        return CarrinhoDAO.getInstance().buscarPorID(id);
    }
    
    public Carrinho getLastCarrinho() {
   
        return CarrinhoDAO.getInstance().getLastCarrinho();
    }

    public List<Carrinho> BuscarTodos() {
        return CarrinhoDAO.getInstance().buscarTodos();
    }
}
