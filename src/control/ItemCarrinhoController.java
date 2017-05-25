/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.ItemCarrinhoDAO;
import model.ItemCarrinho;

/**
 *
 * @author Leo
 */
public class ItemCarrinhoController {
    
    private static ItemCarrinhoController itemCarrinhoController;

    public static ItemCarrinhoController getInstance() {
        if (itemCarrinhoController == null) {
            itemCarrinhoController = new ItemCarrinhoController();
        }
        return itemCarrinhoController;
    }
    
    public void persistir(ItemCarrinho item) {
        ItemCarrinhoDAO.getInstance().persistir(item);
    }
}
