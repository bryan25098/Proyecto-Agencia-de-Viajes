package co.edu.uptc.controller;

import co.edu.uptc.model.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.sql.ClientInfoStatus;
import java.io.*;
import java.util.List;

public class ControlViajes {

    private static final String PATHDESTINOS = "src\\main\\resources\\data\\destinos.json";
    private static final String PATHCLIENTES = "src\\main\\resources\\data\\clientes.json";
    private static final String PATHRESERVACIONES = "src\\main\\resources\\data\\reservaciones.json";

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // Genérico
    private static <T> List<T> leerArchivo(String filepath, Class<T> clase) {
        try (Reader reader = new FileReader(filepath)) {
            Type tipoLista = TypeToken.getParameterized(List.class, clase).getType();
            return gson.fromJson(reader, tipoLista);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static <T> void subirArchivo(String filepath, List<T> datos) {
        try (Writer wt = new FileWriter(filepath)) {
            gson.toJson(datos, wt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    

    public List<Cliente> getClientes() {
        return leerArchivo(PATHCLIENTES, Cliente.class);
    }

    public List<Destino> getDestinos() {
        return leerArchivo(PATHDESTINOS, Destino.class);
    }

    public List<Reservacion> getReservaciones() {
        return leerArchivo(PATHRESERVACIONES, Reservacion.class);
    }

    public static Cliente buscarIdCliente(String id) {
        List<Cliente> clientes = leerArchivo(PATHCLIENTES, Cliente.class);
        return clientes.stream().filter(n -> n.getIdCliente().equals(id)).findFirst().orElse(null);
    }

    public static Destino buscarCodigoDes(String cod) {
        List<Destino> destinos = leerArchivo(PATHDESTINOS, Destino.class);
        return destinos.stream().filter(n -> n.getCodigo().equals(cod)).findFirst().orElse(null);
    }
    /*
     * public static Reservacion buscarReserva(String reser){
     * List<Reservacion> reservaciones = leerArchivo(PATHRESERVACIONES,
     * Reservacion.class);
     * return reservaciones.stream().filter(n->
     * n.getIdCliente().equals(id)).findFirst().orElse(null);
     * }
     */

    public static void registrarCliente(String idCliente, String nombreCompleto, String correo, String telefono,
            String tipoCliente) {
        List<Cliente> clientes = leerArchivo(PATHCLIENTES, Cliente.class);
        if (clientes.stream().noneMatch(n -> n.getIdCliente().equals(idCliente))) {
            clientes.add(new Cliente(idCliente, nombreCompleto, correo, telefono, tipoCliente));
            subirArchivo(PATHCLIENTES, clientes);
        }

    }

    public static void registrarDestino(String codigo, String nombre, String pais, double precioPersona,
            int cuposDisponibles) {
        List<Destino> destinos = leerArchivo(PATHDESTINOS, Destino.class);
        if (destinos.stream().noneMatch(n -> n.getCodigo().equals(codigo))) {
            destinos.add(new Destino(codigo, nombre, pais, precioPersona, cuposDisponibles));
            subirArchivo(PATHDESTINOS, destinos);
        }
    }   
    public static boolean eliminarCliente(String id){
        List<Cliente> clientes = leerArchivo(PATHDESTINOS, Cliente.class);
        CLiente cl= buscarIdCliente(id);
        if (cl== null) {
            return false;
        }else{
        clientes.remove(cl);
        subirArchivo(PATHCLIENTES,clientes);

        return true;
        }
        return false;
    }

    public boolean cambiarAtributoCliente(String id,int opcion,String cambio){
        List<Cliente> clientes = leerArchivo(PATHCLIENTES, Cliente.class);
        Cliente cl = clientes.stream().filter(n-> n.getIdCliente().equals(id)).findFirst().orElse(null);
        if(cl== null){
            return false;
        }else{
            switch(opcion){
                case 1:
                    cl.setNombreCompleto(cambio);
                    
                    return true;
                    break;
                    case 2:
                        cl.setCorreo(cambio);
                    return true;
                    break;
                    case 3:
                        cl.setTelefono(cambio);
                    return true;
                    break;
                    case 4:
                        cl.setTipoCliente(cambio);
                    return true;
                    break;
            }
            subirArchivo(PATHCLIENTES,clientes);
        }
    }

}
