/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Usuario;

/**
 *
 * @author Leo
 */
public class SessaoUserController {
   private static SessaoUserController instance = null;
   private Usuario usuario;
   
   private SessaoUserController(){
   }
   public void setUsuario(Usuario usuario){
      this.usuario = usuario;
   }
   
   public Usuario getUsuario(){
       return usuario;
   }
   
   public static SessaoUserController getInstance(){
         if(instance == null){
               instance = new SessaoUserController();
         }
        return instance;
   }
}
