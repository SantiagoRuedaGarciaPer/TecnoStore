package CONTROLADOR;

import DAO.ClienteDAO;
import MODELO.Cliente;
import MODELO.Tipo_identificacion;
import VISTA.Validaciones;


public class ClienteController implements Controller {
    private final ClienteDAO cd = new ClienteDAO();
    private final Validaciones v = new Validaciones();
    
    @Override
    public void crear(){
        System.out.println("===============Modulo creacion cliente==========");
        String nombre = v.validarTexto("Ingrese el nombre");
        
        int op = v.validarEnteroRango("""
                                                Ingrese el tipo de identificacion
                                                1. Cedula
                                                2. TargetaIdentidad
                                                3. Pasaporte""", 3, 1);
        
        Tipo_identificacion ti = (op == 1) ? Tipo_identificacion.Cedula : (op == 2) ? Tipo_identificacion.TargetaIdentidad : (op == 3) ? Tipo_identificacion.Pasaporte : null;
        
        String identificacion = v.validarTexto("Ingrese la identificacion");
        String correo = v.validarTexto("Ingrese el correo");
        int telefono = v.validarEntero("ingrese el telefono");
        
        Cliente c = new Cliente(0, nombre, ti, identificacion, correo, telefono);
        cd.create(c);
    }
    
    @Override
    public void actualizar(){
        System.out.println("====================Modulo Actualizar Clientes====================");
        Cliente cliente = cd.buscar(v.validarEntero("Ingrese el id del cliente a actualizar"));
        
        
        int op = v.validarEnteroRango("""
                                Ingrese la opcion a actualizar
                                 1. Nombre
                                 2. Tipo de identificacion
                                 3. identificacion
                                 4. correo
                                 5. telefono""", 5, 1);
        switch (op) {
            case 1:
                String nombre = v.validarTexto("ingrese el nuevo nombre");
                cliente.setNombre(nombre);
                break;
            case 2:
                
                int op1 = v.validarEnteroRango("""
                                                        Ingrese el tipo de identificacion
                                                        1. Cedula
                                                        2. TargetaIdentidad
                                                        3. Pasaporte""", 3, 1);
                Tipo_identificacion ti = (op1 == 1) ? Tipo_identificacion.Cedula : (op1 == 2) ? Tipo_identificacion.TargetaIdentidad : (op1 == 3) ? Tipo_identificacion.Pasaporte : null;
                cliente.setTipo_identificacion(ti);
                break;
            case 3:
                String identificacion = v.validarTexto("ingrese la nueva identificacion");
                cliente.setIdentificacion(identificacion);
                break;
            case 4:
                String correo = v.validarTexto("Ingrese el nuevo correo");
                cliente.setCorreo(correo);
                break;
            case 5:
                int telefono = v.validarEntero("ingrese el nuevo telefono");
                cliente.setTelefono(telefono);
                break;
        }
        cd.update(cliente);
    }
    
    @Override
    public void eliminar(){
        Cliente cliente = cd.buscar(v.validarEntero("ingrese el id del cliente a eliminar"));
        cd.delete(cliente);
    }

    @Override
    public void listar(){
        cd.listar().forEach(System.out::println);
    }
    
    @Override
    public void buscar(){
        int id = v.validarEntero("ingrese el id a buscar");
        Cliente c = cd.buscar(id);
        System.out.println(c);
    }
    public Cliente buscar(int id){
        Cliente c = cd.buscar(id);
        return c;
    }
}
