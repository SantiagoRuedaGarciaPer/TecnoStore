package Utils;

import CONTROLADOR.VentasDetalleController;
import MODELO.Cliente;
import MODELO.Ventas;
import MODELO.VentasDetalle;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReporteArchivo {
    private VentasDetalleController vc = new VentasDetalleController();
    
    
    public void getReporteArchivo(){
        ArrayList<VentasDetalle> detalles = vc.Retornarlistar();
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("reporte_ventas.txt"))) {
            
            int ventaActual = 0;
            for (VentasDetalle detalle : detalles){
                Ventas venta = detalle.getVenta();
                
                // Divide la venta. Si el id de la venta es diference del id de venta actual(que inicia en 0)
                // imprime la linea ===================
                // Necesario para dividir las ventas, puesto que una venta tiene varios detalles
                if(venta.getId() != ventaActual ){
                    bw.write("=============================");
                    bw.newLine();
                    ventaActual = venta.getId();
                    bw.write(venta.toString());
                    bw.newLine();
                    bw.write("Celulares: ");
                }
                bw.newLine();
                bw.write(detalle.getCelular().toString());
                
                
            }
            
            
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }catch (Exception e) {
                
        }
        
    }   
}
