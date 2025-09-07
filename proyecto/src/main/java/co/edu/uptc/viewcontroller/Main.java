package co.edu.uptc.viewcontroller;

import co.edu.uptc.controller.ControlViajes;
import co.edu.uptc.model.Cliente;
import co.edu.uptc.model.Reservacion;

import java.util.List;
import co.edu.uptc.controller.*;
import java.util.Scanner;

public class Main {

    public static final ControlViajes control = new ControlViajes();

    public static void main(String[] args) {
        System.out.println("bienvenido a la agencia de viajes");
        boolean run = true;
        Scanner sc = new Scanner(System.in);
        while (run) {
            System.out.println("""
                    ingrese la opcion en la que desea ungresar
                    1)Gestion Clientes.
                    2)Gestion Destinos.
                    3)Gestion Reservas.
                    4)Reportes
                    5)Cambiar idioma(es/en)
                    6)Salir.
                    """);
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                boolean gestionClientes =true;
                while (gestionClientes) {
                    System.out.println("""
                            Bienvenido a Gestion de Clientes
                            Que desea realizar
                            1)Registrar
                            2)Consultar
                            3)Modificar
                            4)Eliminar
                            5)Regresar
                            """);
                    int opcion2 = sc.nextInt();
                    sc.nextLine();
                    switch (opcion2) {
                        case 1:// registar Clientes
                            System.out.println("ingrese el id del usuario");
                            String idUsu = sc.nextLine();
                            System.out.println("ingrese el nombre del usuario");
                            String nombre = sc.nextLine();
                            System.out.println("ingrese el correo del usuario");
                            String correo = sc.nextLine();
                            System.out.println("ingrese el telefono del usuario");
                            String telefono = sc.nextLine();
                            System.out.println("ingrese el tipo del usuario");
                            String tipoCliente = sc.nextLine();
                            control.registrarCliente(idUsu, nombre, correo, telefono, tipoCliente);
                            break;
                        case 2://buscar
                            System.out.println("ingrese el id del usuario");
                            String idCliBuscar = sc.nextLine();

                            Cliente cl = control.buscarIdCliente(idCliBuscar);
                            if(cl==null){
                                System.out.println("no se encontro el usuario con el id: "+idCliBuscar);
                            }else{
                                System.out.println(cl.toString());
                            }
                            break;
                        case 3://modificar
                        System.out.println("ingrese el id del usuario a modificar");
                        String idModificar = sc.nextLine();
                            System.out.println("""
                                    Que desea modificar del usuario
                                    1)Nombre
                                    2)Correo
                                    3)Telefono
                                    4)Tipo de usuario
                                    5)Regresar
                                    """);
                                    int opcion3= sc.nextInt();
                                    sc.nextLine();
                                    if (opcion3== 5) {
                                        
                                    }else if (opcion3 >0 && opcion3 <5) {
                                        System.out.println("ingresa la modificacion");
                                        String modificar= sc.nextLine();
                                    boolean cambioExitoso= control.cambiarAtributoCliente(idModificar, opcion3, modificar);
                                    if (cambioExitoso) {
                                        System.out.println("se cambio el atributo correctamente");
                                        System.out.println(control.buscarIdCliente(idModificar).toString());
                                    }else{
                                        System.out.println("ocurrio algun error");
                                    }
                                
                                    }
                            break;
                        case 4://eliminar
                                    System.out.println("ingrese el id del Cliente a eliminar:");
                                    String idEliminar=sc.nextLine();
                                    if(control.eliminarCliente(idEliminar)){
                                         System.out.println("se elminio el cliente con id :"+idEliminar);
                                    }else{
                                        System.out.println("ocurrio algun error");
                                    }

                            break;
                            case 5://menu gestion Clientes
                            System.out.println("volviendo al menu principal...");
                                    gestionClientes= false;
                            break;
                        default:
                            break;    
                }
                
                    }

                    break;
                case 2://gestion destinos

                    break;
                case 3://gestion Reservaciones

                    break;
                case 4://reportes

                    break;
                case 5://cambio de idioma

                    break;
                case 6://salir
                    System.out.println("regrese pronto");
                    run= false;
                    break;

                default:
                    System.out.println("opcion invalida,intente de nuevo");
            }

        }
    }
}