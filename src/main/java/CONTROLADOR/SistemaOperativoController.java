package CONTROLADOR;

import MODELO.Sistema_operativo;
import VISTA.Validaciones;


public class SistemaOperativoController {
    private SistemaOperativoDAO sd = new SistemaOperativoDAO();
    private Validaciones v = new Validaciones();
    
    public Sistema_operativo buscar(){
        return sd.Buscar(v.validarEntero("Ingrese el id a buscar"));
    }
    
    public Sistema_operativo buscar(int id){
        return sd.Buscar(id);
    }
}
