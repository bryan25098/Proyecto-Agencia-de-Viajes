package co.edu.uptc.service;

 
public class Validacion {
    public boolean validarDatosUsu(String id, String nombre, String correoElectronico, String telefono,
            String tipoCliente){
                if (soloNumero("id")) {
                    if (soloNumero("telefono")) {
                        return true;
                    }else{
                        return false;
                    }
                }
                return false;
    }
    public boolean soloNumero(String dato){
        return dato.matches("\\d+");
    }
}    