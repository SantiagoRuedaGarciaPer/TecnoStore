package CONTROLADOR;

import DAO.VentasDAO;
import MODELO.Cliente;
import MODELO.Ventas;
import VISTA.Validaciones;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;

public class VentasController implements Controller {

    private  Validaciones v = new Validaciones();
    private VentasDAO vd = new VentasDAO();
    private  ClienteController ccl = new ClienteController();
    private CreditoController ccr = new CreditoController();
    
    @Override
    public void crear() {
        ccl.listar();
        Cliente cliente = ccl.buscar(v.validarEntero("ingrese el id del cliente"));
        Ventas venta = new Ventas(0, cliente, 0, Timestamp.from(Instant.MIN));
        vd.create(venta);
        if(validarCredito()){
            ccr.crear();
        }    
        
    }

    @Override
    public void actualizar() {
        listar();
        Ventas venta = buscar(v.validarEntero("ingrese el id de la venta a buscar"));
        
        ccl.listar();
        Cliente cliente = ccl.buscar(v.validarEntero("Ingrese el id del nuevo cliente asignado"));
        venta.setCliente(cliente);
        vd.update(venta);

    }
    

    @Override
        public void eliminar() {
        listar();
        Ventas venta = buscar(v.validarEntero("ingrese el id de la venta a eliminar"));
        vd.delete(venta);
    }

    @Override
    public void listar() {
        vd.listar().forEach(System.out::println);
    }
    
    public ArrayList<Ventas> listarRetorno() {
        return vd.listar();
    }   
    
    @Override
    public void buscar(){
        System.out.println(vd.buscar(v.validarEntero("Ingrese el id a buscar")));
    }
    public Ventas buscar(int id){
        return vd.buscar(id);
        
    }
    
    public boolean validarCredito(){
        int op = v.validarEnteroRango("""
                               Desea pagar a credito?
                               1. Si
                               2. no""", 2, 1);
        if(op == 1){
            return true;
        }else{
            return false;
        }
    }
}
