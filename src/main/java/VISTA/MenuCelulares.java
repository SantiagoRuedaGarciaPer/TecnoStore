package VISTA;

import CONTROLADOR.CelularController;


public class MenuCelulares {
    private CelularController cc = new CelularController();
    private Validaciones v = new Validaciones();
    public void menu(){
        int op = 0;
        do{
            op = v.validarEnteroRango("""
                                      Menu Celulares
                                      1. Agregar celular
                                      2. Actualizar
                                      3. Eliminar
                                      4. Buscar
                                      5. Listar
                                      6. Salir
                                      """, 6, 1);
            switch (op){
                case 1:
                    cc.crear();
                    break;
                case 2:
                    cc.actualizar();
                    break;
                case 3:
                    cc.eliminar();
                    break;
                case 4:
                    cc.buscar();
                    break;
                case 5:
                    cc.listar();
                    break;
                case 6:
                    System.out.println("Volviendo al menu principal...");
                    break;
            }
        }while(op != 6);
    }
}
