package model;

/**
 *
 * @author Leo
 */
public class Supermercado {
    private long Id;
    private String Nome;
    private String Cnpj;

    public Supermercado() {
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

    public String getCnpj() {
        return Cnpj;
    }

    public void setCnpj(String Cnpj) {
        this.Cnpj = Cnpj;
    }
    
    
    
}
