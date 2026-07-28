package DAO;

import CONEXION_DB.Conexion;
import CONTROLADOR.CelularController;
import CONTROLADOR.ClienteController;
import MODELO.Celular;
import MODELO.Cliente;
import MODELO.Ventas;
import VISTA.Validaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class VentasDAO {
    private final Conexion c = new Conexion();
    private final ClienteController ccl = new ClienteController();
    private final CelularController cc = new CelularController();
    private final Validaciones v = new Validaciones();
    
    public void create(Ventas venta){
        try (Connection con = c.conectar()) {
            System.out.println("Modulo vender");
            PreparedStatement ps = con.prepareStatement("INSERT INTO Ventas(id_cliente, total) values (?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, venta.getCliente().getId());
            ps.setInt(2, 0);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                ps = con.prepareStatement("INSERT INTO Detalle_ventas(id_venta, id_celular) values(?, ?)");
                int idVenta = rs.getInt(1);
                double precio = 0;
                int cont = 0;
                do {
                    cc.listar();
                    cont = v.validarEntero("Ingrese el id del celular a agregar a la venta. Ingrese 0 para salir");
                    if (cont != 0) {
                        Celular cel = cc.buscar(cont);
                        ps.setInt(1, idVenta);
                        ps.setInt(2, cel.getId());
                        ps.executeUpdate();
                        precio += cel.getPrecio();
                    }
                } while (cont != 0);
                precio *= 1.19;
                ps = con.prepareStatement("Update Ventas set total=? WHERE id=?");
                ps.setDouble(1, precio);
                ps.setInt(2, idVenta);
                ps.executeUpdate();

            } else {
                System.out.println("Hubo un error inerperado");
            }
        } catch (SQLException e) {

            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void update(Ventas venta){
        try (Connection con = c.conectar()) {
            System.out.println("Modulo actualizar venta");
            PreparedStatement ps = con.prepareStatement("update Ventas set id_cliente=?, total=? where id=?", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, venta.getCliente().getId());
            ps.setInt(2, 0);
            ps.setInt(3, venta.getId());
            ps.executeUpdate();
        } catch (SQLException e) {

            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void delete(Ventas venta){
        int op = JOptionPane.showInternalConfirmDialog(null, "Desea eliminar la venta "+venta.getId()+" con un total de "+venta.getTotal()+"?");
        if(op == 0){
            try (Connection con = c.conectar()) {
                PreparedStatement ps1 = con.prepareStatement("DELETE FROM Detalle_ventas WHERE id_venta=?");
                ps1.setInt(1, venta.getId());
                PreparedStatement ps2 = con.prepareStatement("DELETE FROM Ventas where id=?");
                ps2.setInt(1, venta.getId());
                ps1.executeUpdate();
                ps2.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }else{
            JOptionPane.showInternalMessageDialog(null, "Operacion cancelada");
        }
    }
    
    public Ventas buscar(int id){
        try (Connection con = c.conectar()) {
            Ventas venta = null;
            PreparedStatement ps = con.prepareStatement("Select * from ventas where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Cliente cliente = ccl.buscar(rs.getInt(2));
                venta = new Ventas(rs.getInt(1), cliente, rs.getDouble(3));
            }
            return venta;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
}
