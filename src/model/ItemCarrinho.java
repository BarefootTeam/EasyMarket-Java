package model;

/**
 *
 * @author Leo
 */
public class ItemCarrinho {
    private long Id;
    private Carrinho Carrinho;
    private Produto Produto;
    private float Valor;
    private int Quantidade;

    public ItemCarrinho() {
    }

    
    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public Carrinho getCarrinho() {
        return Carrinho;
    }

    public void setCarrinho(Carrinho Carrinho) {
        this.Carrinho = Carrinho;
    }

    public Produto getProduto() {
        return Produto;
    }

    public void setProduto(Produto Produto) {
        this.Produto = Produto;
    }

    public float getValor() {
        return Valor;
    }

    public void setValor(float Valor) {
        this.Valor = Valor;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }
    
    
}
