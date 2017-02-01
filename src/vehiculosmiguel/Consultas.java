package vehiculosmiguel;
import Clases.*;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.io.*;


 // @author Miguel

public class Consultas { 
    
    public static void consultas (ObjectContainer baseDatos, BufferedReader leer) throws IOException {
        
        byte op=1;
        
        while(op!=0){
            
            op=Menu.menuConsultas(leer);
        
            switch(op){
                case 1:
                    consultaPropietario(baseDatos, leer);
                    break;
                case 2:
                    consultaMatricula(baseDatos, leer);
                    break;
                case 3:
                    verTodo(baseDatos);
                    break;
            }
        }
        
    }
    
    public static void consultaPropietario (ObjectContainer baseDatos, BufferedReader leer) throws IOException {
        
        Query consulta=baseDatos.query();
        ObjectSet resultado;
        String nombre;

        consulta.constrain(C_Vehiculo.class);
        System.out.println("Introducir nombre del Propietario:");
        nombre=leer.readLine();
        consulta.descend("propietario").constrain(nombre);
        resultado=consulta.execute();
        Visualizar.visualizar(resultado);

        
    }
    
    public static void consultaMatricula (ObjectContainer baseDatos, BufferedReader leer) throws IOException {
        
        String matricula;
        ObjectSet resultado;
        C_Vehiculo coche;
        C_Vehiculo camion;
        
        
        System.out.println("Introduce la matricula a buscar: ");
        matricula=leer.readLine();
    
        coche=new C_Coche (matricula,null,0,null);

        resultado=baseDatos.queryByExample(coche);
        
        if(resultado.isEmpty())
        {
            camion=new C_Camion (matricula,null,0,0);
            resultado=baseDatos.queryByExample(camion);
        }
            
        Visualizar.visualizar(resultado);
        
    }
    
    public static boolean consultaExiste (ObjectContainer baseDatos, C_Vehiculo vehiculo) {
        
        Query consulta=baseDatos.query();
        ObjectSet resultado;
        boolean e;

        consulta.constrain(C_Vehiculo.class);
        consulta.descend("matricula").constrain(vehiculo.getMatricula());
        resultado=consulta.execute();
        
        if(resultado.isEmpty())
            e=false;
        else 
            e=true;
        
        return e;
    }
    
    public static void verTodo(ObjectContainer baseDatos) {
        
        ObjectSet resultado;
        
        System.out.println(" --- COCHES REGISTRADOS");
        C_Coche coche=new C_Coche();
        resultado=baseDatos.queryByExample(coche);
        Visualizar.visualizar(resultado);
        
        System.out.println("\n --- CAMIONES REGISTRADOS");
        C_Camion camion=new C_Camion();
        resultado=baseDatos.queryByExample(camion);
        Visualizar.visualizar(resultado);
       
    }
      
}
