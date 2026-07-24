package CONTROLADOR;

import MODELO.Marca;
import VISTA.Validaciones;


public class MarcaController {
    private MarcaDAO md = new MarcaDAO();
    private Validaciones v = new Validaciones();
    
    public Marca buscar(){
        return md.Buscar(v.validarEntero("Ingrese el id a buscar"));
    }
    
    public Marca buscar(int id){
        return md.Buscar(id);
    }
    
}
