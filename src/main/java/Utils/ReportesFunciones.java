package Utils;

import CONEXION_DB.Conexion;
import CONTROLADOR.CelularController;
import CONTROLADOR.VentasController;
import MODELO.Celular;
import MODELO.Ventas;
import java.time.LocalDate;
import java.util.ArrayList;

public class ReportesFunciones {
    private Conexion c = new Conexion();
    private CelularController cc =  new CelularController();
    private VentasController vc = new VentasController();
    
    public ArrayList<Celular> lowStock(){
        return (ArrayList<Celular>) cc.listarRetorno().stream().filter( e -> e.getStock() < 5);
    }
    
    public ArrayList<Ventas> ventasMes(){
        return (ArrayList<Ventas>) vc.listarRetorno().stream().filter( e -> e.getFecha().getMonth() == LocalDate.now().getMonthValue() && e.getFecha().getYear() == LocalDate.now().getYear() );
    }
    
    public void masVendidos(){
        cc.masVendidos();
    }
}
