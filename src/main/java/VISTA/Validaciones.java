package VISTA;

import java.util.Scanner;


public class Validaciones {

    public int validarEntero(String mensaje){
        int dato = 0;
            do{
                try {
                System.out.println(mensaje);
                dato = new Scanner(System.in).nextInt();
            } catch (Exception e) {
                System.out.println("Error de ingreso de datos");
            }
        }while(dato < 1);
        return dato;
    }
    public int validarEnteroRango(String mensaje, int maximo, int minimo){
        int dato = 0;
            do{
                try {
                System.out.println(mensaje);
                dato = new Scanner(System.in).nextInt();
            } catch (Exception e) {
                System.out.println("Error de ingreso de datos");
            }
        }while(dato < minimo || dato > maximo);
        return dato;
    }
    
    public double validarDecimal(String mensaje){
        double dato = 0;
            do{
                try {
                System.out.println(mensaje);
                dato = new Scanner(System.in).nextDouble();
            } catch (Exception e) {
                System.out.println("Error de ingreso de datos");
            }
        }while(dato <1);
        return dato;
    }
    
    public double validarDecimalRango(String mensaje, double maximo, double minimo){
        double dato = 0;
            do{
                try {
                System.out.println(mensaje);
                dato = new Scanner(System.in).nextDouble();
            } catch (Exception e) {
                System.out.println("Error de ingreso de datos");
            }
        }while(dato < minimo || dato > maximo);
        return dato;
    }
    
    public String validarTexto(String mensaje){
        String dato ="";
        do{
            try {
                System.out.println(mensaje);
                dato = new Scanner(System.in).nextLine();
            } catch (Exception e) {
                System.out.println("Error de ingreso de datos");
            }
        }while(dato == null || dato.isBlank());
        return dato;
    }
    
}
