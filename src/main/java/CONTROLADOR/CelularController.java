package CONTROLADOR;

import DAO.CelularDAO;
import MODELO.Celular;
import MODELO.Gama;
import MODELO.Marca;
import MODELO.Sistema_operativo;
import VISTA.Validaciones;
import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.stream.Stream;


public class CelularController implements Controller{
    private CelularDAO cd = new CelularDAO();
    private Validaciones v = new Validaciones();
    private MarcaController mc = new MarcaController();
    private SistemaOperativoController sc = new SistemaOperativoController();
    
    @Override
    public void crear(){
        mc.listar();
        Marca marca = mc.buscarMarca();
        
        String modelo = v.validarTexto("Ingrese el modelo");
        
        sc.listar();
        Sistema_operativo sistema = sc.buscarSO(v.validarEntero("Ingrese el id del sistema operativo"));
        
        Gama gama = Gama.valueOf(v.validarTexto("ingrese la gama (Alta/Media/Baja/  || Respetar mayusculas)")); 
        
        Double precio = v.validarDecimal("Ingrese el precio");
        int stock = v.validarEntero("Ingrese el stock");
        
        Celular cel = new Celular(0, marca, modelo, sistema, gama, precio, stock);
        cd.Create(cel);
        
    }
    
    @Override
    public void actualizar(){
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
                Marca marca = mc.buscarMarca(v.validarEntero("Ingrese el id de la marca"));
                cel.setMarca(marca);
                break;
            case 2:
                String modelo = v.validarTexto("Ingrese el modelo");
                cel.setModelo(modelo);
                break;
            case 3:
                sc.listar();
                Sistema_operativo sistema = sc.buscarSO(v.validarEntero("Ingrese el id del sistema operativo"));
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
    
    @Override
    public void eliminar(){
        listar();
        Celular cel = cd.buscar(v.validarEntero("Ingrese el id del celular a eliminar"));
        cd.Delete(cel);
        
    }
    
    @Override
    public void listar(){
        cd.listar().forEach(System.out::println);
    }
    
    public ArrayList<Celular> listarRetorno(){
        return cd.listar();
    }
    
    @Override
    public void buscar(){
        Celular cel = cd.buscar(v.validarEntero("ingrese el id a buscar"));
        System.out.println(cel);
    }
    
    public Celular buscar(int id){
        Celular cel = cd.buscar(v.validarEntero("ingrese el id a buscar"));
        return cel;
    }
    
    public void masVendidos(){
        Stream.of(cd.getMasVendidos()).forEach(System.out::println);
    }
    
}
