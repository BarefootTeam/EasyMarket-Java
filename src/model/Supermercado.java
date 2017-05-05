package model;

/**
 *
 * @author Leo
 */
public class Supermercado {
    private Long Id;
    private String Nome;
    private String Cnpj;

    public Supermercado() {
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

    public String getCnpj() {
        return Cnpj;
    }

    public void setCnpj(String Cnpj) {
        this.Cnpj = Cnpj;
    }
    
    
    
}
