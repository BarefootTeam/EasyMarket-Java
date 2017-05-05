package model;

/**
 *
 * @author Leo
 */
public class Usuario {
    private Long Id;
    private String Login;
    private String Senha;
    private String Nome;
    private String Cpf;
    private Supermercado Supermercado;

    public Usuario() {
    }

    public Supermercado getSupermercado() {
        return Supermercado;
    }

    public void setSupermercado(Supermercado Supermercado) {
        this.Supermercado = Supermercado;
    }
    

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }


    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }
    
    
}
