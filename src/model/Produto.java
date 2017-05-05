package model;

/**
 *
 * @author Leo
 */
public class Produto {
    private long Id;
    private String Nome;
    private String Cod;
    private String Descricao;
    private float  precoCusto;
    private Supermercado Supermercado;

    public Produto() {
    }

    
    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCod() {
        return Cod;
    }

    public void setCod(String Cod) {
        this.Cod = Cod;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public float getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(float precoCusto) {
        this.precoCusto = precoCusto;
    }

    public Supermercado getSupermercado() {
        return Supermercado;
    }

    public void setSupermercado(Supermercado Supermercado) {
        this.Supermercado = Supermercado;
    }
    
    
    
}
