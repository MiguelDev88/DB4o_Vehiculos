package vehiculosmiguel;
import Clases.*;
import com.db4o.ObjectSet;

 
// @author Miguel
 
public class Visualizar {
    
    public static void visualizar (ObjectSet resultado) {
        
        C_Vehiculo vehiculo;
        
        if(resultado.isEmpty())
            System.out.println("\n\n --- No hay datos que mostrar --- \n\n");
        
        else
        {
            System.out.println("\n\n --- Resultado de la consulta: --- ");
        
            while(resultado.hasNext())
            {
                vehiculo=(C_Vehiculo)resultado.next();  
                System.out.println("-----------------------------------------------------------------------------");
                System.out.printf("     MATRICULA      PROPIETARIO     PRECIO      TIPO     ");
                if(vehiculo instanceof C_Coche)
                {
                    System.out.printf("    MODELO  %n  %12s %16s %10d€ %10s %10s",vehiculo.getMatricula(),vehiculo.getPropietario()
                                                                               ,vehiculo.getPrecio(),"Coche",((C_Coche) vehiculo).getModelo());
                }
                else
                {
                    System.out.printf("    POTENCIA  %n  %12s %16s %10d€ %10s %10s",vehiculo.getMatricula(),vehiculo.getPropietario()
                                                                             ,vehiculo.getPrecio(),"Camion",((C_Camion) vehiculo).getPotencia());
                }
                System.out.println("\n-----------------------------------------------------------------------------");
            }
        }
           
    }
    
    public static void verVehiculo (C_Vehiculo vehiculo) {
        
        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("     MATRICULA      PROPIETARIO     PRECIO      TIPO     ");
        if(vehiculo instanceof C_Coche)
        {
            System.out.printf("    MODELO  %n  %12s %16s %10d€ %10s %10s",vehiculo.getMatricula(),vehiculo.getPropietario()
                                                                       ,vehiculo.getPrecio(),"Coche",((C_Coche) vehiculo).getModelo());
        }
        else
        {
            System.out.printf("    POTENCIA  %n  %12s %16s %10d€ %10s %10s",vehiculo.getMatricula(),vehiculo.getPropietario()
                                                                     ,vehiculo.getPrecio(),"Camion",((C_Camion) vehiculo).getPotencia());
        }
        System.out.println("\n-----------------------------------------------------------------------------");
        
    }
    
}
