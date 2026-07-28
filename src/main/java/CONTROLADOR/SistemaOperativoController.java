package CONTROLADOR;

import DAO.SistemaOperativoDAO;
import MODELO.Sistema_operativo;
import VISTA.Validaciones;

public class SistemaOperativoController implements Controller {

    private SistemaOperativoDAO sd = new SistemaOperativoDAO();
    private Validaciones v = new Validaciones();

    @Override
    public void crear() {
        System.out.println("No se pueden crear mas sistemas operativos");
    }

    @Override
    public void actualizar() {
        System.out.println("No se puede actualizar los sistemas operativos");
    }

    @Override
    public void eliminar() {
        System.out.println("No se puede eliminar un sistema operativo");
    }

    public Sistema_operativo buscarSO(int id) {
        return sd.Buscar(id);
    }

    @Override
    public void buscar() {
        System.out.println(sd.Buscar(v.validarEntero("ingrese el id a buscar")));
    }

    @Override
    public void listar() {
        sd.Listar().forEach(System.out::println);
    }
}
