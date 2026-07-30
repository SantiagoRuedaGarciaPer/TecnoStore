/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import CONEXION_DB.Conexion;
import CONTROLADOR.CelularController;
import CONTROLADOR.ClienteController;
import CONTROLADOR.VentasController;
import MODELO.Celular;
import MODELO.Ventas;
import MODELO.VentasDetalle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Santiago
 */
public class VentasDetalleDAO {
    private final Conexion c = new Conexion();
    private final VentasController vc = new VentasController();
    private final ClienteController ccl = new ClienteController();
    private final CelularController cc = new CelularController();
    
    public ArrayList<VentasDetalle> listar(){
        ArrayList<VentasDetalle> detallesVenta = new ArrayList<>();
        
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("Select * from Detalles_venta");  
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Celular cel = cc.buscar(rs.getInt(3));
                Ventas venta = vc.buscar(rs.getInt(2));
                detallesVenta.add(new VentasDetalle(rs.getInt(1), venta, cel));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return detallesVenta;
    }
    
}
