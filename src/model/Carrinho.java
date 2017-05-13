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
    private Cliente Cliente;
    
    public Carrinho() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public boolean getStatus() {
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

    public Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(Cliente Cliente) {
        this.Cliente = Cliente;
    }

    
    
    
}
