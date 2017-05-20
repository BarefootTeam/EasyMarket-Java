/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.ProdutoDAO;
import dao.SupermercadoDAO;
import java.util.ArrayList;
import java.util.List;
import model.Produto;
import model.Supermercado;

/**
 *
 * @author Leo
 */
public class ProdutoController {
    
    private static ProdutoController produtoController;

    public static ProdutoController getInstance() {
        if (produtoController == null) {
            produtoController = new ProdutoController();
        }
        return produtoController;
    }

    /**
     * Controler - Intermedia a visao e o modelo nos metodos
     * @param nome String
     * @return ArrayList<Aluno>
     */
    public ArrayList<Produto> buscarPorNome(String nome){
        return ProdutoDAO.getInstance().buscarPorNome(nome);
    }

    public boolean deletar(Long id) {
        return ProdutoDAO.getInstance().deletar(id);
    
    }

    public void persistir(Produto produto) {
        ProdutoDAO.getInstance().persistir(produto);
    }

    public Produto buscarID(Long id) {
   
        return ProdutoDAO.getInstance().buscarPorID(id);
    }
    
    public Produto buscarCOD(String cod) {
   
        return ProdutoDAO.getInstance().buscarPorCOD(cod);
    }


    public List<Produto> BuscarTodos() {
        return ProdutoDAO.getInstance().buscarTodos();
    }
    
    
    public List<Produto> buscar(int indice, String texto) {
  
        return ProdutoDAO.getInstance().buscar(indice, texto);
    }
    
    //Busca dos mercados
    public List<Supermercado> BuscarTodosMercados(){
      return SupermercadoDAO.getInstance().buscarTodos();
    }

}
