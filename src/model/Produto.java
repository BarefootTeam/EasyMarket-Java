package model;

/**
 *
 * @author Leo
 */
public class Produto {
    private Long Id;
    private String Nome;
    private String Cod;
    private String Descricao;
    private float  precoCusto;
    private Supermercado Supermercado;
    private byte[] foto;

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    

    public Produto() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
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
