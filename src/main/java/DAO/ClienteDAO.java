package DAO;

import CONEXION_DB.Conexion;
import MODELO.Cliente;
import MODELO.Tipo_identificacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ClienteDAO {
    private Conexion c = new Conexion();
    
    public void create(Cliente cliente){
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("""
                                                        INSERT INTO Clientes(nombre, tipo_identificacion, identificacion, correo, telefono) 
                                                        VALUES
                                                        (?, ?, ?, ?, ?)""");
            
            ps.setString(1, cliente.getNombre());
            ps.setString(2, String.valueOf(cliente.getTipo_identificacion()));
            ps.setString(3, cliente.getIdentificacion());
            ps.setString(4, cliente.getCorreo());
            ps.setInt(5, cliente.getTelefono());
            
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void update(Cliente cliente){
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("UPDATE Clientes SET Nombre=?, tipo_identificacion=?, identificacion=?, correo=?, telefono=? Where id=?");
            ps.setString(1, cliente.getNombre());
            ps.setString(2, String.valueOf(cliente.getTipo_identificacion()));
            ps.setString(3, cliente.getIdentificacion());
            ps.setString(4, cliente.getCorreo());
            ps.setInt(5, cliente.getTelefono());
            ps.setInt(6, cliente.getId());
            
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public void delete(Cliente cliente){
        int op = JOptionPane.showInternalConfirmDialog(null, "Seguro que desea eliminar a "+cliente+"?");
        if(op == 0){
            try (Connection con = c.conectar()) {
                PreparedStatement ps = con.prepareStatement("Delete from Cliente where id =?");
                ps.setInt(1, cliente.getId());
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }else{
            JOptionPane.showInternalMessageDialog(null, "Operacion cancelada");
        }
    }
    
    public Cliente buscar(int id){
        Cliente cliente = null;
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("Select * from Clientes Where id=?");
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                cliente = new Cliente(rs.getInt(1), rs.getString(2), Tipo_identificacion.valueOf(rs.getString(3)), rs.getString(4), rs.getString(5), rs.getInt(6));
            }else{
                System.out.println("Cliente no encontrado...");
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return cliente;
    }
    
    public ArrayList<Cliente> listar(){
        ArrayList<Cliente> clientes = new ArrayList<>();
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("Select * from Clientes");
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                clientes.add(new Cliente(rs.getInt(1), rs.getString(2), Tipo_identificacion.valueOf(rs.getString(3)), rs.getString(4), rs.getString(5), rs.getInt(6)));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return clientes;
    }
    
    
    
    
}
