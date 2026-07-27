package DAO;

import CONEXION_DB.Conexion;
import CONTROLADOR.MarcaController;
import CONTROLADOR.SistemaOperativoController;
import MODELO.Celular;
import MODELO.Gama;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CelularDAO {

    private Conexion c = new Conexion();

    public void Create(Celular celular) {

        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO Celulares(id_marca, modelo, id_sistema_operativo, gama, precio, stock) values(?, ?, ?, ?, ?, ?)");
            ps.setInt(1, celular.getMarca().getId());
            ps.setString(2, celular.getModelo());
            ps.setInt(3, celular.getSis_ope().getId());
            ps.setString(4, String.valueOf(celular.getGama()));
            ps.setDouble(5, celular.getPrecio());
            ps.setInt(6, celular.getStock());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void Update(Celular celular){
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("UPDATE Celulares set id_marca=?, modelo=?, id_sistema_operativo=?, gama=?, precio=?, stock=? Where id = ?");
            ps.setInt(1, celular.getMarca().getId());
            ps.setString(2, celular.getModelo());
            ps.setInt(3, celular.getSis_ope().getId());
            ps.setString(4, String.valueOf(celular.getGama()));
            ps.setDouble(5, celular.getPrecio());
            ps.setInt(6, celular.getStock());
            ps.setInt(7, celular.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void Delete(Celular celular){
        int op = JOptionPane.showConfirmDialog(null, "Esta segur@ de eliminar a "+celular+"?");
        if(op == 0){
            try (Connection con = c.conectar()) {
                PreparedStatement ps = con.prepareStatement("Delete from Celulares where id=?");
                ps.setInt(1, celular.getId());
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }else{
            JOptionPane.showInternalMessageDialog(null, "Operacion cancelada");
        }
    }
    
    public ArrayList<Celular> listar(){
        ArrayList<Celular> celulares = new ArrayList<>();
        
        try (Connection con  = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("Select * from Celulares");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                MarcaController mc = new MarcaController();
                SistemaOperativoController sc = new SistemaOperativoController();
                celulares.add(new Celular(rs.getInt(1), mc.buscarMarca(rs.getInt(2)), rs.getString(3), sc.buscarSO(rs.getInt(4)), Gama.valueOf(rs.getString(5)), rs.getDouble(6), rs.getInt(7)));
            }
        } catch (SQLException e) {
        }
        
        return celulares;
    }
    
    public Celular buscar(int id){
        Celular celulares = null;
        
        try (Connection con  = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("Select * from Celulares where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                MarcaController mc = new MarcaController();
                SistemaOperativoController sc = new SistemaOperativoController();
                celulares = new Celular(rs.getInt(1), mc.buscarMarca(rs.getInt(2)), rs.getString(3), sc.buscarSO(rs.getInt(4)), Gama.valueOf(rs.getString(5)), rs.getDouble(6), rs.getInt(7));
            }else{
                System.out.println("Celular no encontrado...");
            }
        } catch (SQLException e) {
        }
        
        return celulares;
    }

}
