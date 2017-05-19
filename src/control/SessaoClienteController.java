/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Cliente;

/**
 *
 * @author Leo
 */
public class SessaoClienteController {
   private static SessaoClienteController instance = null;
   private Cliente cliente;
   
   private SessaoClienteController(){
   }
   public void setCliente(Cliente cliente){
      this.cliente = cliente;
   }
   
   public Cliente getCliente(){
       return cliente;
   }
   
   public static SessaoClienteController getInstance(){
         if(instance == null){
               instance = new SessaoClienteController();
         }
        return instance;
   }
}
