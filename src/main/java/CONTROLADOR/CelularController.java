package CONTROLADOR;

import MODELO.Celular;
import MODELO.Gama;
import MODELO.Marca;
import MODELO.Sistema_operativo;
import VISTA.Validaciones;


public class CelularController {
    private CelularDAO cd = new CelularDAO();
    private Validaciones v = new Validaciones();
    private MarcaController mc = new MarcaController();
    private SistemaOperativoController sc = new SistemaOperativoController();
    
    public void create(){
        mc.listar();
        Marca marca = mc.buscar(v.validarEntero("Ingrese el id de la marca"));
        
        String modelo = v.validarTexto("Ingrese el modelo");
        
        sc.listar();
        Sistema_operativo sistema = sc.buscar(v.validarEntero("Ingrese el id del sistema operativo"));
        
        Gama gama = Gama.valueOf(v.validarTexto("ingrese la gama (Alta/Media/Baja/  || Respetar mayusculas)")); 
        
        Double precio = v.validarDecimal("Ingrese el precio");
        int stock = v.validarEntero("Ingrese el stock");
        
        Celular cel = new Celular(0, marca, modelo, sistema, gama, precio, stock);
        cd.Create(cel);
        
    }
    
    public void update(){
        listar();
        Celular cel = cd.buscar(v.validarEntero("ingrese el celular a actualizar"));
        int op = v.validarEntero("""
                            Digite la opcion a actualizar
                           1.   Marca
                           2.   Modelo
                           3.   Sistema Operativo
                           4.   Gama
                           5.   Precio
                           6.   Stock
                           7.   Salir
                           """);
        switch (op){
            case 1:
                mc.listar();
                Marca marca = mc.buscar(v.validarEntero("Ingrese el id de la marca"));
                cel.setMarca(marca);
                break;
            case 2:
                String modelo = v.validarTexto("Ingrese el modelo");
                cel.setModelo(modelo);
                break;
            case 3:
                sc.listar();
                Sistema_operativo sistema = sc.buscar(v.validarEntero("Ingrese el id del sistema operativo"));
                cel.setSis_ope(sistema);
                break;
            case 4:
                Gama gama = Gama.valueOf(v.validarTexto("ingrese la gama (Alta/Media/Baja/  || Respetar mayusculas)")); 
                cel.setGama(gama);
                break;
            case 5:
                Double precio = v.validarDecimal("Ingrese el precio");
                cel.setPrecio(precio); 
                break;
            case 6:
                int stock = v.validarEntero("Ingrese el stock");
                cel.setStock(stock);
                break;
            case 7:
                System.out.println("Operacion cancelada");
                break;
        }
    }
    
    public void delete(){
        listar();
        Celular cel = cd.buscar(v.validarEntero("Ingrese el id del celular a eliminar"));
        cd.Delete(cel);
        
    }
    
    public Celular buscar(int id){
        Celular cel = cd.buscar(id);
        return cel;
    }
    
    public void listar(){
        cd.listar().forEach(System.out::println);
    }
    
}
