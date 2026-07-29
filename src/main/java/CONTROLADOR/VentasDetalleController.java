/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import DAO.VentasDetalleDAO;
import MODELO.VentasDetalle;
import java.util.ArrayList;

/**
 *
 * @author Santiago
 */
public class VentasDetalleController implements Controller{
    private VentasDetalleDAO vd = new VentasDetalleDAO();
    
    @Override
    public void crear() {
        System.out.println("No se puede crear un detalle venta desde 0, hagalo directamente con una nueva venta");
    }

    @Override
    public void actualizar() {
        System.out.println("No se puede actualizar los detalles de una venta por seguridad");
    }

    @Override
    public void eliminar() {
        System.out.println("Por seguridad no se puede eliminar un detalle venta si su venta aun existe");
    }

    @Override
    public void listar() {
        vd.listar();
    }
    
    public ArrayList<VentasDetalle> Retornarlistar() {
        return vd.listar();
    }

    @Override
    public void buscar() {
    }
    
}
