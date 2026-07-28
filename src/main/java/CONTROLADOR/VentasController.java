package CONTROLADOR;

import DAO.VentasDAO;
import MODELO.Cliente;
import MODELO.Ventas;
import VISTA.Validaciones;

public class VentasController implements Controller{
    private final Validaciones v = new Validaciones();
    private final VentasDAO vd = new VentasDAO();
    private final ClienteController ccl = new ClienteController();
    
    
    @Override
    public void crear() {
        ccl.listar();
        Cliente cliente = ccl.buscar(v.validarEntero("ingrese el id del cliente"));
        Ventas venta = new Ventas(0, cliente);
        vd.create(venta);
    }

    @Override
    public void actualizar() {
        listar();
        Ventas venta = buscar(v.validarEntero("ingrese el id de la venta a buscar")); 
        int op = v.validarEnteroRango("""
                                      Actualizar venta
                                      1. Actualizar cliente asignado
                                      2. Actualizar lista de celulares vendidos
                                      """, 2, 1);
        switch(op){
            case 1:
                ccl.listar();
                Cliente cliente = ccl.buscar(v.validarEntero("Ingrese el id del nuevo cliente asignado"));
                venta.setCliente(cliente);
        
        }
    }

    @Override
    public void eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }   
    @Override
    public void buscar(){
        System.out.println(vd.buscar(v.validarEntero("Ingrese el id a buscar")));
    }
    public Ventas buscar(int id){
        return vd.buscar(id);
    }
}
