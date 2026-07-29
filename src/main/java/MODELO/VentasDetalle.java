package MODELO;

public class VentasDetalle {
    private int id;
    private Ventas venta;
    private Celular celular;

    public VentasDetalle(int id, Ventas venta, Celular celular) {
        this.id = id;
        this.venta = venta;
        this.celular = celular;
    }

    public Ventas getVenta() {
        return venta;
    }

    public Celular getCelular() {
        return celular;
    }     

    public int getId() {
        return id;
    }
    
    
}
