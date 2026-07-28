package CONTROLADOR;

import DAO.MarcaDAO;
import MODELO.Marca;
import VISTA.Validaciones;


public class MarcaController implements Controller{
    private MarcaDAO md = new MarcaDAO();
    private Validaciones v = new Validaciones();
    
    @Override
    public void crear(){
        String nombre = v.validarTexto("Ingrese el nombre de la marca");
        Marca marca = new Marca(0, nombre);
        md.create(marca);
    }
    
    @Override
    public void actualizar(){
        listar();
        Marca marca = md.Buscar(v.validarEntero("Ingrese el id de la marca a actualizar"));
        
        String nombre = v.validarTexto("\nIngrese el nuevo nombre de la marca");
        marca.setNombre(nombre);
        
        md.update(marca);
    }
    
    @Override
    public void eliminar(){
        listar();
        Marca marca = md.Buscar(v.validarEntero("Ingrese el id de la marca a eliminar"));
        md.delete(marca);
    }
    
    @Override
    public void buscar(){
        System.out.println(md.Buscar(v.validarEntero("Ingrese el id a buscar")));
    }
    
    public Marca buscarMarca(){
        return md.Buscar(v.validarEntero("Ingrese el id a buscar"));
    }
    
    public Marca buscarMarca(int id){
        return md.Buscar(id);
    }
    
    @Override
    public void listar(){
        md.Listar().forEach(System.out::println);
    }
    
}
