package Clases;


// @author Miguel

public class C_Camion extends C_Vehiculo {
    
    private float potencia;
    
    
    public C_Camion () {}
    
    public C_Camion (String matricula, String propietario, int precio, float potencia) {
        
        super(matricula,propietario,precio);
        this.potencia=potencia;
        
    }

    public float getPotencia() {
        return potencia;
    }

    public void setPotencia(float potencia) {
        this.potencia = potencia;
    }
    
    public float impuesto() {
        
        return (float)(getPrecio()*1.20);

    }

}
    