package MODELO;


public class Cliente {
    private int id;
    private String nombre;
    private Tipo_identificacion tipo_identificacion;
    private String identificacion;
    private String correo;
    private int telefono;

    public Cliente(int id, String nombre, Tipo_identificacion tipo_identificacion, String identificacion, String correo, int telefono) {
        this.id = id;
        this.nombre = nombre;
        this.tipo_identificacion = tipo_identificacion;
        this.identificacion = identificacion;
        this.correo = correo;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tipo_identificacion getTipo_identificacion() {
        return tipo_identificacion;
    }

    public void setTipo_identificacion(Tipo_identificacion tipo_identificacion) {
        this.tipo_identificacion = tipo_identificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return """
               ID:                      %s
               NOMBRE:                  %s
               CORREO:                  %s
               TIPO IDENTIFICACION      %s
               IDENTIFICACION           %s
               TELEFONO                 %s
               """.formatted(id, nombre, correo, String.valueOf(tipo_identificacion), identificacion, telefono);
    }
    
    
    
    
}
