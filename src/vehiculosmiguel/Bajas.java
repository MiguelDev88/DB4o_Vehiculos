package vehiculosmiguel;
import Clases.*;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.io.*;


 // @author Miguel

public class Bajas {
    
    
    public static void bajas (ObjectContainer baseDatos,BufferedReader leer) throws IOException {
        
        byte op=1;
        Query consulta=baseDatos.query();
        ObjectSet resultado;
        C_Vehiculo vehiculo;
        String buscar;
        

        consulta.constrain(C_Vehiculo.class);
        System.out.println("Introducir matricula del vehiculo a borrar:");
        buscar=leer.readLine();
        consulta.descend("matricula").constrain(buscar);
        resultado=consulta.execute();

        if(resultado.isEmpty())
            System.out.println("\n - No se han encontrado Datos - \n");

        else
            while(resultado.hasNext()){

                vehiculo=(C_Vehiculo)resultado.next();

                if(Menu.menuConfirmar(leer)==1)
                {
                    baseDatos.delete(vehiculo);
                    baseDatos.commit();
                    System.out.println("\n - Vehiculo Eliminado - \n");
                }
                else
                    System.out.println("Operación Cancelada");
            }
                    
    }
}
    