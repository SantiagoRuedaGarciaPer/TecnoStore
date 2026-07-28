package VISTA;

import CONTROLADOR.SistemaOperativoController;


public class MenuSistemasOperativos {
    private SistemaOperativoController cc = new SistemaOperativoController();
    private Validaciones v = new Validaciones();

    public void menu() {
        int op = 0;
        do {
            op = v.validarEnteroRango("""
                                      Menu Sistemas Operativos
                                      1. Buscar
                                      2. Listar
                                      3. Salir
                                      """, 6, 1);
            switch (op) {
                case 1:
                    cc.buscar();
                    break;
                case 2:
                    cc.listar();
                    break;
                case 3:
                    System.out.println("Volviendo al menu principal...");
                    break;
            }
        } while (op != 3);
    }
}
