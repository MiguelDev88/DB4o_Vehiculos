package vehiculosmiguel;
import java.io.BufferedReader;
import java.io.IOException;


// @author Miguel
 
public class Menu {
    
    public static byte menuPrincipal (BufferedReader leer) throws IOException {
        
        byte op;
        
        
        System.out.println("\n Seleccione Opción:"
                + "\n1.Altas"
                + "\n2.Bajas"
                + "\n3.Modificar"
                + "\n4.Consultas"
                + "\n0.Finalizar");
        op=Byte.parseByte(leer.readLine());
        
        return op;
        
    }
    
    public static byte menuAltas (BufferedReader leer) throws IOException {
        
        byte op;
        
        
        System.out.println("\n ¿Qué desea dar de Alta?"
                + "\n1.Coche"
                + "\n2.Camión"
                + "\n0.Finalizar");
        op=Byte.parseByte(leer.readLine());
        
        return op;
        
    }
    
    public static byte menuBajas (BufferedReader leer) throws IOException {
        
        byte op;
        
        
        System.out.println("\n ¿Qué desea dar de Baja?"
                + "\n1.Coche"
                + "\n2.Camión"
                + "\n0.Finalizar");
        op=Byte.parseByte(leer.readLine());
        
        return op;
        
    }
    
    public static byte menuModificar (BufferedReader leer) throws IOException {
        
        byte op;
        
        
        System.out.println("\n ¿Qué desea Modificar?"
                + "\n1.Coche"
                + "\n2.Camión"
                + "\n0.Finalizar");
        op=Byte.parseByte(leer.readLine());
        
        return op;
        
    }
    
    public static byte menuConsultas (BufferedReader leer) throws IOException {
        
        byte op;
        
        
        System.out.println("\n ¿Qué desea Consultar?"
                + "\n1.Vehiculos por Propietario"
                + "\n2.Vehiculo por matrícula"
                + "\n3.Ver Todo"
                + "\n0.Finalizar");
        op=Byte.parseByte(leer.readLine());
        
        return op;
        
    }
    
    public static byte menuConfirmar (BufferedReader leer) throws IOException {
        
        byte op;
        
        
        System.out.println("¿Seguro que desea eliminar este registro?"
                + "\n1.SI"
                + "\n2.NO");
        
        op=Byte.parseByte(leer.readLine());
        
        return op;
    }
    
}
