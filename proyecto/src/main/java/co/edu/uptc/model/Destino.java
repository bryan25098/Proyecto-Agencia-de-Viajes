package co.edu.uptc.model;

public class Destino {
    private String codigo;
    private String nombre;
    private String pais;
    private double precioPersona;
    private int cuposDisponibles;
    
    public Destino(String codigo, String nombre, String pais, double precioPersona, int cuposDisponibles) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.pais = pais;
        this.precioPersona = precioPersona;
        this.cuposDisponibles = cuposDisponibles;
    }
    public Destino() {
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public double getPrecioPersona() {
        return precioPersona;
    }
    public void setPrecioPersona(double precioPersona) {
        this.precioPersona = precioPersona;
    }
    public int getCuposDisponibles() {
        return cuposDisponibles;
    }
    public void setCuposDisponibles(int cuposDisponibles) {
        this.cuposDisponibles = cuposDisponibles;
    }
    @Override
    public String toString() {
        return "Destino [codigo=" + codigo + ", nombre=" + nombre + ", pais=" + pais + ", precioPersona="
                + precioPersona + ", cuposDisponibles=" + cuposDisponibles + "]";
    }
    
    
}
