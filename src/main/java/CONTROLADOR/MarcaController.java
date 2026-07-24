package CONTROLADOR;

import DAO.MarcaDAO;
import MODELO.Marca;
import VISTA.Validaciones;


public class MarcaController {
    private MarcaDAO md = new MarcaDAO();
    private Validaciones v = new Validaciones();
    
    public void crear(){
        String nombre = v.validarTexto("Ingrese el nombre de la marca");
        Marca marca = new Marca(0, nombre);
        md.create(marca);
    }
    
    
    
    
    public Marca buscar(){
        return md.Buscar(v.validarEntero("Ingrese el id a buscar"));
    }
    
    public Marca buscar(int id){
        return md.Buscar(id);
    }
    
    public void listar(){
        md.Listar().forEach(System.out::println);
    }
    
}
