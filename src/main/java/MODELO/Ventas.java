package MODELO;


public class Ventas {
    private int id;
    private Cliente cliente;
    private double total;

    public Ventas(int id, Cliente cliente, double total) {
        this.id = id;
        this.cliente = cliente;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
}
