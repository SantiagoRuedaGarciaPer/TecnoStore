package CONTROLADOR;

import DAO.VentasDAO;
import MODELO.Cliente;
import MODELO.Ventas;
import VISTA.Validaciones;
import java.sql.Date;
import java.time.LocalDate;

public class VentasController implements Controller {

    private final Validaciones v = new Validaciones();
    private final VentasDAO vd = new VentasDAO();
    private final ClienteController ccl = new ClienteController();

    @Override
    public void crear() {
        ccl.listar();
        Cliente cliente = ccl.buscar(v.validarEntero("ingrese el id del cliente"));
        Ventas venta = new Ventas(0, cliente, 0, Date.valueOf(LocalDate.now()));
        vd.create(venta);
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
    @Override
    public void buscar(){
        System.out.println(vd.buscar(v.validarEntero("Ingrese el id a buscar")));
    }
    public Ventas buscar(int id){
        return vd.buscar(id);
    }
}
