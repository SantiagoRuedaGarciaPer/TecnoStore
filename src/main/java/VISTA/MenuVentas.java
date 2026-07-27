package VISTA;


public class MenuVentas {
    private Validaciones v = new Validaciones();
    public void menu(){
        int op = v.validarEnteroRango("""
                                      *********Menu ventas*********
                                      1. Registrar venta
                                      2. Eliminar Venta
                                      3. Actualizar Venta
                                      4. Buscar Venta
                                      5. Listar Ventas
                                      6. Salir
                                      """, 6, 1);
    }
}
