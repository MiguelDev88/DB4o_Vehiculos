package Clases;


// @author Miguel

public class C_Coche extends C_Vehiculo {
    
    private String modelo;
    
    
    public C_Coche () {}
    
    public C_Coche (String matricula, String propietario, int precio, String modelo) {
        
        super(matricula,propietario,precio);
        this.modelo=modelo;
        
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public float impuesto() {
        
        return (float)(getPrecio()*0.90);
    }
    
}
