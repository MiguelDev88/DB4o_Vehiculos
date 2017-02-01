package vehiculosmiguel;
import Clases.*;
import com.db4o.ObjectContainer;
import java.io.*;


 // @author Miguel

public class Altas {
    
    
    public static void altas (ObjectContainer baseDatos,BufferedReader leer) throws IOException {
        
        byte op=1;
        C_Vehiculo vehiculo;
        
        while(op!=0){
            
            op=Menu.menuAltas(leer);
        
            switch(op){
                case 1:
                    
                    vehiculo=nuevoCoche(leer);
                    if(Consultas.consultaExiste(baseDatos, vehiculo))
                        System.out.println("Vehiculo ya registrado");
                    
                    else
                    {
                        baseDatos.store(vehiculo);
                        baseDatos.commit();
                    }
                    break;
                case 2:
                   vehiculo=nuevoCamion(leer);
                   
                   if(Consultas.consultaExiste(baseDatos, vehiculo))
                        System.out.println("Vehiculo ya registrado");
                    
                    else
                    {
                        baseDatos.store(vehiculo);
                        baseDatos.commit();
                    }
                    break;
            }
        }
        
    }
    
    public static C_Vehiculo nuevoCoche (BufferedReader leer) throws IOException {
        
        String matricula,propietario,modelo;
        int precio;
        C_Vehiculo vehiculo;
        
        
        System.out.println("Introducir matricula");
        matricula=leer.readLine();
        System.out.println("Introducir propietario:");
        propietario=leer.readLine();
        System.out.println("Introducir precio");
        precio=Integer.parseInt(leer.readLine());
        System.out.println("Introducir modelo:");
        modelo=leer.readLine();
        

        vehiculo= new C_Coche(matricula,propietario,precio,modelo);
        
        return vehiculo;

    }
    
    public static C_Vehiculo nuevoCamion (BufferedReader leer) throws IOException {
        
        String matricula,propietario;
        int precio;
        float potencia;
        C_Vehiculo vehiculo;
        
        
        System.out.println("Introducir matricula");
        matricula=leer.readLine();
        System.out.println("Introducir propietario:");
        propietario=leer.readLine();
        System.out.println("Introducir precio");
        precio=Integer.parseInt(leer.readLine());
        System.out.println("Introducir potencia:");
        potencia=Float.parseFloat(leer.readLine());
        
        
        vehiculo= new C_Camion(matricula,propietario,precio,potencia);
        
        return vehiculo;
        
    }

}
