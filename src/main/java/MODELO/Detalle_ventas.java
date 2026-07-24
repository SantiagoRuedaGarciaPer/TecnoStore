package MODELO;

import java.util.ArrayList;


public class Detalle_ventas {
    private int id;
    private Ventas venta;
    private ArrayList<Celular> celulares;

    public Detalle_ventas(int id, Ventas venta, ArrayList<Celular> celulares) {
        this.id = id;
        this.venta = venta;
        this.celulares = celulares;
    }

    public int getId() {
        return id;
    }

    public Ventas getVenta() {
        return venta;
    }

    public void setVenta(Ventas venta) {
        this.venta = venta;
    }

    public ArrayList<Celular> getCelulares() {
        return celulares;
    }

    public void setCelulares(ArrayList<Celular> celulares) {
        this.celulares = celulares;
    }
    
    
}
