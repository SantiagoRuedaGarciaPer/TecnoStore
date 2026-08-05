package DAO;

import CONEXION_DB.Conexion;
import CONTROLADOR.ClienteController;
import CONTROLADOR.VentasController;
import MODELO.Cliente;
import MODELO.Credito;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class CreditoDAO {
    private Conexion c = new Conexion();
    public void create(Credito credito){
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO Credito(id_cliente, id_venta, abonado) values (?, ?, ?, ?);");
            ps.setInt(1, credito.getCliente().getId());
            ps.setInt(2, credito.getVenta().getId());
            ps.setDouble(4, credito.getAbonado());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void update(Credito credito){
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("UPDATE Credito SET abonado=? WHERE id=?");
            ps.setDouble(1, credito.getAbonado());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<Credito> listar(){
        ArrayList<Credito> creditos = new ArrayList<>();
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("Select * from Credito");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ClienteController cc = new ClienteController();
                VentasController vc = new VentasController();
                creditos.add(new Credito(rs.getInt(1), cc.buscar(rs.getInt(2)), vc.buscar(rs.getInt(3)), rs.getDouble(4)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return creditos;
        
    }
    
    public Credito buscar(int id){
        Credito credito = null;
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("Select * from Credito Where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                ClienteController cc = new ClienteController();
                VentasController vc = new VentasController();
                credito = new Credito(rs.getInt(1), cc.buscar(rs.getInt(2)), vc.buscar(rs.getInt(3)), rs.getDouble(4));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return credito;
    }
}
