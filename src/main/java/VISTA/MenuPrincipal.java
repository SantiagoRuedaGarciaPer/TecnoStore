package VISTA;


public class MenuPrincipal implements MenuInterface{
    private Validaciones v = new Validaciones();
    private MenuCelulares mc = new MenuCelulares();
    private MenuMarcas mm = new MenuMarcas();
    private MenuClientes mcl = new MenuClientes();
    private MenuSistemasOperativos mso = new MenuSistemasOperativos();
    private MenuVentas mv = new MenuVentas();
    private MenuReportes mr = new MenuReportes();
    private static MenuPrincipal menup;
    
    public static MenuPrincipal getInstance(){
        if (menup == null){
            menup = new MenuPrincipal();
        }
        return menup;
    }
    private MenuPrincipal(){
        
    }
    
    @Override
    public void menu(){
        int op = 0;
        do{
            op = v.validarEnteroRango("""
                                  ===============Menu principal=============
                                  1. Menu celulares
                                  2. Menu clientes
                                  3. Menu marcas
                                  4. Menu sistemas operativos
                                  5. Menu ventas
                                  6. Menu reportes
                                  7. Salir
                                  """, 6, 1);
            switch (op){
                case 1:
                    mc.menu();
                    break;
                case 2:
                    mcl.menu();
                    break;
                case 3:
                    mm.menu();
                    break;
                case 4:
                    mso.menu();
                    break;
                case 5:
                    mv.menu();
                    break;
                case 6:
                    mr.menu();
                    break;
                case 7:
                    System.out.println("Hasta luego.....");
                    break;
            }
        }while(op != 7);
    }
    
}
