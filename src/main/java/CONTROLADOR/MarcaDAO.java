package CONTROLADOR;

import MODELO.Marca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class MarcaDAO {
    private Conexion c = new Conexion();
    
    
    
    
    
    
    
    public ArrayList<Marca> Listar(){
        ArrayList<Marca> marcas = new ArrayList<>();
        
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("Select * from Marcas");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                marcas.add(new Marca(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException e) {
        }
        
        return marcas;
    }
    
    public Marca Buscar(int id){
        Marca marca = null;
        
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("Select * from Marcas where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                marca = new Marca(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return marca;
    }
}
