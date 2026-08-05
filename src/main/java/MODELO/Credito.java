package MODELO;


public class Credito {
    private int id;
    private Cliente cliente;
    private Ventas venta;
    private double abonado;

    public Credito(int id, Cliente cliente, Ventas venta, double abonado) {
        this.id = id;
        this.cliente = cliente;
        this.venta = venta;
        this.abonado = abonado;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }


    public Ventas getVenta() {
        return venta;
    }


    public double getAbonado() {
        return abonado;
    }

    public void setAbonado(double abonado) {
        this.abonado = abonado;
    }

    @Override
    public String toString() {
        return """
                        CREDITO
               Id                   %s
               Cliente              %s
               Venta                %s
               Total pagado         %s
               """.formatted(id, cliente, venta, abonado) ;
    }
    
    
    
    
    
    
}
