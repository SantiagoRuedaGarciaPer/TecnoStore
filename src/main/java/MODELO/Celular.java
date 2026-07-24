package MODELO;


public class Celular {
    private int id;
    private Marca marca;
    private String modelo;
    private Sistema_operativo sis_ope;
    private Gama gama;
    private double precio;
    private int stock;

    public Celular(int id, Marca marca, String modelo, Sistema_operativo sis_ope, Gama gama, double precio, int stock) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.sis_ope = sis_ope;
        this.gama = gama;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Sistema_operativo getSis_ope() {
        return sis_ope;
    }

    public void setSis_ope(Sistema_operativo sis_ope) {
        this.sis_ope = sis_ope;
    }

    public Gama getGama() {
        return gama;
    }

    public void setGama(Gama gama) {
        this.gama = gama;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return """
                        CELULAR
               Marca:               %s
               Modelo:              %s
               Precio:              %s
               Gama:                %s
               """.formatted(marca.getNombre(), modelo, precio, gama);
    }
    
    
    
    
}
