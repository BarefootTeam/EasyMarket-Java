package model;

import java.util.Date;

/**
 *
 * @author Leo
 */
public class Carrinho {
    private Long Id;
    private boolean Status;
    private Date Data;
    private Usuario Usuario;

    public Carrinho() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date Data) {
        this.Data = Data;
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario Usuario) {
        this.Usuario = Usuario;
    }
    
    
    
}
