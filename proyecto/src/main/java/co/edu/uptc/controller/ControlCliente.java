package co.edu.uptc.controller;

import java.util.List;

import co.edu.uptc.model.Cliente;
import co.edu.uptc.service.Validacion;
import co.edu.uptc.persistence.*;

public class ControlCliente {
     private static final Validacion val = new Validacion();
     private static final ManipuladorArchivos man= new ManipuladorArchivos();
    private static final String PATHCLIENTES = "src\\main\\resources\\data\\clientes.json";

    public List<Cliente> getClientes() {
        return man.leerArchivo(PATHCLIENTES, Cliente.class);
    }
      

    public static Cliente buscarIdCliente(String id) {
        List<Cliente> clientes = man.leerArchivo(PATHCLIENTES, Cliente.class);
        return clientes.stream().filter(n -> n.getIdCliente().equals(id)).findFirst().orElse(null);
    }
     public static void registrarCliente(String idCliente, String nombreCompleto, String correo, String telefono,
            String tipoCliente) {
        List<Cliente> clientes = man.leerArchivo(PATHCLIENTES, Cliente.class);
        if (val.validarDatosUsu(idCliente, nombreCompleto, correo, telefono, tipoCliente)) {
            if (clientes.stream().noneMatch(n -> n.getIdCliente().equals(idCliente))) {
                clientes.add(new Cliente(idCliente, nombreCompleto, correo, telefono, tipoCliente));
                man.subirArchivo(PATHCLIENTES, clientes);
            }
        }
    }
     public static boolean eliminarCliente(String id) {
        List<Cliente> clientes = man.leerArchivo(PATHCLIENTES, Cliente.class);
        Cliente cl = buscarIdCliente(id);
        if (cl == null) {
            return false;
        } else {
            clientes.remove(cl);
            man.subirArchivo(PATHCLIENTES, clientes);

            return true;
        }
    }

    public boolean cambiarAtributoCliente(String id, int opcion, String cambio) {
        List<Cliente> clientes = man.leerArchivo(PATHCLIENTES, Cliente.class);
        Cliente cl = clientes.stream().filter(n -> n.getIdCliente().equals(id)).findFirst().orElse(null);
        if (cl == null) {
            return false;
        } else {
            switch (opcion) {
                case 1:
                    cl.setNombreCompleto(cambio);

                    return true;
                case 2:
                    cl.setCorreo(cambio);
                    return true;
                case 3:
                    cl.setTelefono(cambio);
                    return true;
                case 4:
                    cl.setTipoCliente(cambio);
                    return true;
            }
            man.subirArchivo(PATHCLIENTES, clientes);
        }
        return false;
    }

}



