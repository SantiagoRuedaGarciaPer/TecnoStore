package DAO;

import CONEXION_DB.Conexion;
import MODELO.Marca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class MarcaDAO {
    private Conexion c = new Conexion();
    
    public void create(Marca marca){
        try (Connection con = c.conectar()){
            PreparedStatement st = con.prepareStatement("INSERT INTO Marcas(nombre) values(?)");
            st.setString(1, marca.getNombre());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void update(Marca marca){
        try (Connection con = c.conectar()){
            PreparedStatement ps = con.prepareStatement("UPDATE Marcas set Nombre=? WHERE id=?");
            ps.setString(1, marca.getNombre());
            ps.setInt(2, marca.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void delete(Marca marca){
        int op = JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar a "+marca.getNombre()+"?");
        if(op == 0){
            try (Connection con = c.conectar()) {
                PreparedStatement ps = con.prepareStatement("DELETE FROM Marcas WHERE id=?");
                ps.setInt(1, marca.getId());
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }else{
            JOptionPane.showInternalMessageDialog(null, "Operacion cancelada");
        }
    }
    
    public ArrayList<Marca> Listar(){
        ArrayList<Marca> marcas = new ArrayList<>();
        
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("Select * from Marcas");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                marcas.add(new Marca(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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
