package VISTA;

import Utils.ReporteController;


public class MenuReportes implements MenuInterface {
    private Validaciones v = new Validaciones();
    private ReporteController rc = new ReporteController();
    
    @Override
    public void menu(){
        int op = v.validarEnteroRango("""
                                      Menu Reportes
                                      1.            Productos con bajo Stock
                                      2.            3 Productos mas vendidos
                                      3.            Ventas totales del mes
                                      4.            Generar archivo de reporte
                                      5.            Salir
                                      """, 5, 1);
        switch (op){
            case 1:
                rc.bajoStock();
                break;
            case 2:
                rc.masVendidos();
                break;
        case 3:
                break;
            case 4:
                rc.reporteArchivo();
                break;
            case 5:
                break;
        }
    }
}
