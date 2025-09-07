package co.edu.uptc.model;

public class Cliente{
    private String idCliente;
    private String nombreCompleto;
    private String correo;
    private String telefono;
    private String tipoCliente;
    
    public Cliente(String idCliente, String nombreCompleto, String correo, String telefono, String tipoCliente) {
        this.idCliente = idCliente;
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.telefono = telefono;
        this.tipoCliente = tipoCliente;
    }
    public String getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getTipoCliente() {
        return tipoCliente;
    }
    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    public Cliente() {
    }
    @Override
    public String toString() {
        return "Cliente [idCliente=" + idCliente + ", nombreCompleto=" + nombreCompleto + ", correo=" + correo
                + ", telefono=" + telefono + ", tipoCliente=" + tipoCliente + "]";
    }
    
    

}