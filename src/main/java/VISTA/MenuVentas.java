package VISTA;

import CONTROLADOR.VentasController;

public class MenuVentas implements MenuInterface {

    private Validaciones v = new Validaciones();
    private VentasController vc = new VentasController();

    @Override
    public void menu() {
        int op = v.validarEnteroRango("""
                                      *********Menu ventas*********
                                      1. Registrar venta
                                      2. Eliminar Venta
                                      3. Actualizar Venta
                                      4. Buscar Venta
                                      5. Listar Ventas
                                      6. Salir
                                      """, 6, 1);
        switch (op) {
            case 1:
                vc.crear();
                break;
            case 2:
                vc.eliminar();
                break;
            case 3:
                vc.actualizar();
                break;
            case 4:
                vc.buscar();
                break;
            case 5:
                vc.listar();
                break;
            case 6:
                System.out.println("Volviendo al menu principal");
                break;
        }
    }

}
