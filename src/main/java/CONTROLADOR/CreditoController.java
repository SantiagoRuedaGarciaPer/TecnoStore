package CONTROLADOR;

import DAO.CreditoDAO;
import MODELO.Credito;
import MODELO.Ventas;
import VISTA.Validaciones;
import java.util.ArrayList;

public class CreditoController implements Controller {

    private VentasController vc = new VentasController();
    private Validaciones v = new Validaciones();
    private CreditoDAO crd = new CreditoDAO();
    2
    @Override
    public void crear() {
        try {
            Ventas venta = vc.buscar(v.validarEntero("Ingrese el id de la venta a hacer credito"));
            crear(venta);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void crear(Ventas venta){
        Credito credito = new Credito(0, venta.getCliente(), venta, 0);
        if(v.validarEnteroRango("""
                                Desea abonar algo al credito?
                                1. si
                                2. no
                                """, 2, 1) == 1){
            credito.setAbonado(v.validarDecimal("Ingrese el valor a abonar...\n"));
        }else{
            System.out.println("Continuando con 0 abono....");
        }
        crd.create(credito);
    }    
    
    @Override
    public void actualizar() {
        try {
            listar();
            Credito credito = buscar(v.validarEntero("Ingrese el id del credito a abonar"));
            credito.setAbonado(v.validarDecimal("Ingrese el valor a abonar\n"));
            crd.update(credito);
        
        } catch (Exception e) {
        }
    }

    @Override
    public void eliminar() {
        System.out.println("No se puede eliminar un credito");
    }

    @Override
    public void listar() {
        crd.listar().forEach(System.out::println);
    }
    public ArrayList<Credito> listarRetorno() {
        return crd.listar();
    }

    @Override
    public void buscar() {
        Credito credito = crd.buscar(v.validarEntero("Ingrese el id a buscar"));
        System.out.println(credito);
    }
    
    public Credito buscar(int id) {
        return crd.buscar(id);
    }

}
