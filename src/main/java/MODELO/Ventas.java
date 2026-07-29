package MODELO;

import java.sql.Date;


public class Ventas {
    private int id;
    private Cliente cliente;
    private double total;
    private Date fecha;

    public Ventas(int id, Cliente cliente, double total, Date fecha) {
        this.id = id;
        this.cliente = cliente;
        this.total = total;
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
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

    @Override
    public String toString() {
       return """
              ID:           %s
              FECHA         %s
              TOTAL         %s
              CLIENTE       %s
              """.formatted(id, fecha, total, cliente);
    }
    
    
    
    
}
