package VISTA;

import CONTROLADOR.CreditoController;


public class MenuCreditos implements MenuInterface {

    private CreditoController crd = new CreditoController();
    private Validaciones v = new Validaciones();
    
    @Override
    public void menu(){
        int op = 0;
        do{
            op = v.validarEnteroRango("""
                                      Menu Creditos
                                      1. Abonar
                                      2. Buscar
                                      3. Listar
                                      4. Salir
                                      """, 4, 1);
            switch (op){
                case 1:
                    crd.actualizar();
                    break;
                case 2:
                    crd.buscar();
                    break;
                case 3:
                    crd.listar();
                    break;
                case 4:
                    System.out.println("Volviendo al menu principal...");
                    break;
            }
        }while(op != 4);
    }

}
