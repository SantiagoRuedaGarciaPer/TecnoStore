package Utils;

public class ReporteController {
    private ReportesFunciones rf = new ReportesFunciones();
    private ReporteArchivo ra = new ReporteArchivo();
    
    public void bajoStock(){
        rf.lowStock().forEach(System.out::println);
    }
    
    public void ventasMes(){
        rf.ventasMes().forEach(System.out::println);
    }
    
    public void masVendidos(){
        rf.masVendidos();
    }
    
    public void reporteArchivo(){
        ra.getReporteArchivo();
    }
    
}
