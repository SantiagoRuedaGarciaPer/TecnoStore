package DAO;

import CONEXION_DB.Conexion;
import MODELO.Sistema_operativo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class SistemaOperativoDAO {
    private Conexion c = new Conexion();
    
    public ArrayList<Sistema_operativo> Listar(){
        ArrayList<Sistema_operativo> sistemasOperativos = new ArrayList<>();
        
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("Select * from Sistemas_operativos");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                sistemasOperativos.add(new Sistema_operativo(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return sistemasOperativos;
    }
    
    public Sistema_operativo Buscar(int id){
        Sistema_operativo sistemaOperativo = null;
        
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("Select * from Sistemas_operativos where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                sistemaOperativo = new Sistema_operativo(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return sistemaOperativo;
    }
    
    
}
