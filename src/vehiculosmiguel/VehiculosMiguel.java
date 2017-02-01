package vehiculosmiguel;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import java.io.InputStreamReader;
import java.io.*;


 // @author Miguel

public class VehiculosMiguel {

    
    public static void main(String[] args) throws IOException {
        
        BufferedReader leer=new BufferedReader (new InputStreamReader(System.in));
        ObjectContainer baseDatos=Db4oEmbedded.openFile("BBDD_Vehiculos");
        byte op=0;
        
        do{
            try{
                op=Menu.menuPrincipal(leer);

                switch(op) {
                    case 1:
                        Altas.altas(baseDatos, leer);
                        break;
                    case 2:
                        Bajas.bajas(baseDatos, leer);
                        break;
                    case 3:
                        Modificar.modificar(baseDatos, leer);
                        break;
                    case 4:
                        Consultas.consultas(baseDatos, leer);
                        break;
                    case 0:
                        System.out.println("--- FIN DEL PROGRAMA ---");
                        baseDatos.close();
                        System.exit(0);
                        break;
                }

            }catch (Exception e){
                System.out.println(e.getMessage());
                }
            
            }while(op!=0);
        
    }
    
}
