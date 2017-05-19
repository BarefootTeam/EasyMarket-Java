/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.SupermercadoDAO;
import dao.UsuarioDAO;
import java.util.List;
import model.Supermercado;
import model.Usuario;

/**
 *
 * @author Leo
 */
public class UsuarioController {
    
    private static UsuarioController usuarioController;

    public static UsuarioController getInstance() {
        if (usuarioController == null) {
            usuarioController = new UsuarioController();
        }
        return usuarioController;
    }

    /**
     * Controler - Intermedia a visao e o modelo nos metodos
     * @param nome String
     * @return ArrayList<Usuario>
     */

    public boolean deletar(Long id) {
        return UsuarioDAO.getInstance().deletar(id);
    
    }

    public void persistir(Usuario usuario) {
        UsuarioDAO.getInstance().persistir(usuario);
    }

    public Usuario buscarID(Long id) {
        return UsuarioDAO.getInstance().buscarPorID(id);
    }
    
    //Metodo usado na autenticacao
    public Usuario Autenticacao(String login, String senha) {
        return UsuarioDAO.getInstance().Autenticacao(login,senha);
    }


    public List<Usuario> BuscarTodos() {
        return UsuarioDAO.getInstance().buscarTodos();
    }
    
    
    public List<Usuario> buscar(int indice, String texto) {
  
       return UsuarioDAO.getInstance().buscar(indice, texto);
    }
    
    //Busca dos mercados
    public List<Supermercado> BuscarTodosMercados(){
      return SupermercadoDAO.getInstance().buscarTodos();
    }
}
