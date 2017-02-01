package Clases;


// @author Miguel

public abstract class C_Vehiculo {
    
    private String matricula;
    private String propietario;
    private int precio;
    
    
    public C_Vehiculo () {}
    
    public C_Vehiculo (String matricula, String propietario, int precio) {
        
        this.matricula=matricula;
        this.propietario=propietario;
        this.precio=precio;
        
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    public abstract float impuesto();
    
}
