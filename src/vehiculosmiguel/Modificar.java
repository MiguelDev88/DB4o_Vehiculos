package vehiculosmiguel;
import Clases.*;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.io.*;


 // @author Miguel

public class Modificar {
    
    public static void modificar (ObjectContainer baseDatos,BufferedReader leer) throws IOException {
        
        Query consulta=baseDatos.query();
        ObjectSet resultado;
        C_Vehiculo vehiculo;
        String buscar;
        

        consulta.constrain(C_Vehiculo.class);
        System.out.println("Introducir matricula del vehiculo a modificar:");
        buscar=leer.readLine();
        consulta.descend("matricula").constrain(buscar);
        resultado=consulta.execute();
        if(resultado.isEmpty())
            System.out.println("\n - No se han encontrado Datos - \n");

        else
            while(resultado.hasNext()){

                vehiculo=(C_Vehiculo)resultado.next();

                if(vehiculo instanceof C_Camion)
                {
                    modificarCamion(baseDatos, vehiculo, leer);
                    baseDatos.ext().deactivate(vehiculo);
                }
                else
                {
                    modificarCoche(baseDatos, vehiculo, leer);
                    baseDatos.ext().deactivate(vehiculo);
                }
                
            }
                 
    }
    
    
    public static void modificarCoche (ObjectContainer baseDatos, C_Vehiculo coche, BufferedReader leer) throws IOException {
         
        String propietario, modelo;
        int precio;
        byte op=1;
        
                
        while(op!=0){
            
            Visualizar.verVehiculo(coche);
            
            System.out.println("¿Qué desea modificar?"
                    + "\n1.Propietario"
                    + "\n2.Precio"
                    + "\n3.Modelo"
                    + "\n4.Guardar Cambios"
                    + "\n0.Cancelar");
            op=Byte.parseByte(leer.readLine());

            switch(op){
                case 1:
                    System.out.println("Introducir nuevo Propietario:");
                    propietario=leer.readLine();
                    coche.setPropietario(propietario);
                    System.out.println("Propietario Modificado");
                    break;
                case 2:
                    System.out.println("Introducir nuevo Precio:");
                    precio=Integer.parseInt(leer.readLine());
                    coche.setPrecio(precio);
                    System.out.println("Precio Modificado");
                    break;
                case 3:
                    System.out.println("Introducir nuevo Modelo:");
                    modelo=leer.readLine();
                    ((C_Coche)coche).setModelo(modelo);
                    System.out.println("Modelo Modificado");
                    break;  
                case 4:
                    baseDatos.store(coche);
                    baseDatos.commit();
                    op=0;
                    break;
                case 0:
                    System.out.println("\n - Operación Cancelada - \n");
                    break;
            }
        }
            
    }
    
    public static void modificarCamion (ObjectContainer baseDatos, C_Vehiculo camion, BufferedReader leer) throws IOException {
         
        String propietario;
        float potencia;
        int precio;
        byte op=1;
        
        while(op!=0){

            Visualizar.verVehiculo(camion);
            
            System.out.println("¿Qué desea modificar?"
                    + "\n1.Propietario"
                    + "\n2.Precio"
                    + "\n3.Potencia"
                    + "\n4.Guardar Cambios"
                    + "\n0.Cancelar");
            op=Byte.parseByte(leer.readLine());
            
            switch(op){
                case 1:
                    System.out.println("Introducir nuevo Propietario:");
                    propietario=leer.readLine();
                    camion.setPropietario(propietario);
                    System.out.println("Propietario Modificado");
                    break;
                case 2:
                    System.out.println("Introducir nuevo Precio:");
                    precio=Integer.parseInt(leer.readLine());
                    camion.setPrecio(precio);
                    System.out.println("Precio Modificado");
                    break;
                case 3:
                    System.out.println("Introducir nueva Potencia:");
                    potencia=Float.parseFloat(leer.readLine());
                    ((C_Camion)camion).setPotencia(potencia);
                    System.out.println("Potencia Modificado");
                    break;   
                case 4:
                    baseDatos.store(camion);
                    baseDatos.commit();
                    op=0;
                    break;
                case 0:
                    System.out.println("\n - Operación Cancelada - \n");
                    break;
            }    
        }
    }
    
}
