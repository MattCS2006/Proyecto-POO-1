/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Proyecto_POO;

import clases.*;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author masan
 */
public class ProyectoPOO1RafaAndresSantiagoMattew {
    
    public static final Map<String, counter> counters = new HashMap<>();
    public static final Map<Integer, cliente> clientes = new HashMap<>();
    static login login = new login();
    
    public static void main(String[] args) {

        //Map<String, counter> counters = new HashMap<>();
        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                System.out.println("Bienvenido al sistema de login");
                System.out.print("Desea registrarse, iniciar sesion o salir?: ");
                System.out.print("\n1. Registrarse\n2. Iniciar sesion\n3. Salir\n");
                System.out.print("Ingrese su accion: ");
                String action = scanner.nextLine();

                switch (action) {
                    case "1" -> {
                        System.out.print("Ingrese su nombre de usuario: ");
                        String username = scanner.nextLine();
                        System.out.print("Ingrese su contraseña: ");
                        String password = scanner.nextLine();
                        System.out.print("Ingrese su rol (usuario/admin): ");
                        String rolInput = scanner.nextLine();
                        usuario.Rol rol = rolInput.equalsIgnoreCase("admin") ? usuario.Rol.ADMINISTRADOR : usuario.Rol.USUARIO;

                        String claveAdminInput = "";
                        cliente nuevoCliente = null;
                        if (rol == usuario.Rol.ADMINISTRADOR) {
                            System.out.print("Ingrese la clave de administrador: ");
                            claveAdminInput = scanner.nextLine();
                        } else {
                            // Crear un nuevo cliente para el usuario
                            nuevoCliente = new cliente();
                            Random random = new Random();
                            nuevoCliente.setId(random.nextInt(1000)); // Asignar un ID aleatorio

                            System.out.print("Ingrese su nombre: ");
                            nuevoCliente.setNombre(scanner.nextLine());
                            System.out.print("Ingrese su correo: ");
                            nuevoCliente.setCorreo(scanner.nextLine());
                            System.out.print("Ingrese su telefono: ");
                            nuevoCliente.setTelefono(scanner.nextLine());
                            System.out.print("Ingrese su direccion: ");
                            nuevoCliente.setDireccion(scanner.nextLine());
                            System.out.print("Ingrese su sexo (M/F/NE): ");
                            String sexoInput = scanner.nextLine();
                            tipo_sexo sexo;
                            if (sexoInput.equalsIgnoreCase("M")) {
                                sexo = tipo_sexo.MASCULINO;
                            } else if (sexoInput.equalsIgnoreCase("F")) {
                                sexo = tipo_sexo.FEMENINO;
                            } else {
                                sexo = tipo_sexo.NOESPECIFICADO;
                            }
                            nuevoCliente.setSexo(sexo);
                            System.out.print("Ingrese su fecha de nacimiento (yyyy-mm-dd): ");
                            String[] fechaNacimientoInput = scanner.nextLine().split("-");
                            Calendar fechaNacimiento = Calendar.getInstance();
                            fechaNacimiento.set(Integer.parseInt(fechaNacimientoInput[0]), Integer.parseInt(fechaNacimientoInput[1]) - 1, Integer.parseInt(fechaNacimientoInput[2]));
                            nuevoCliente.setFechaNacimiento(fechaNacimiento);

                            // Asignar un casillero al cliente
                            nuevoCliente.setCasillero(new casillero());
                        }

                        if (login.addUser(username, password, rol, claveAdminInput, nuevoCliente)) {
                            System.out.println("Registro exitoso. Puede iniciar sesion ahora.");
                        } else {
                            System.out.println("Clave de administrador incorrecta. Registro fallido.");
                        }
                    }
                    case "2" -> {
                        System.out.print("Ingrese su nombre de usuario: ");
                        String loginUsername = scanner.nextLine();
                        System.out.print("Ingrese su contraseña: ");
                        String loginPassword = scanner.nextLine();

                        usuario usuario = login.authenticate(loginUsername, loginPassword);
                        if (usuario != null) {
                            System.out.println("Login exitoso. Bienvenido " + usuario.getUsername() + "!");
                            if (usuario.getRol() == clases.usuario.Rol.ADMINISTRADOR) {
                                System.out.println("Usted ha iniciado sesion como administrador.");
                                mostrarMenuAdministrador(scanner);
                            } else {
                                System.out.println("Usted ha iniciado sesion como usuario.");
                                System.out.println("Cliente asociado: " + usuario.getCliente().getNombre());
                                mostrarMenuUsuario(scanner, usuario);
                            }
                        } else {
                            System.out.println("Nombre de usuario o contraseña incorrectos.");
                        }
                    }
                    case "3" -> {
                        running = false;
                        System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    }
                    default ->
                        System.out.println("Accion no reconocida.");
                }
            }
        }
    }

    private static void mostrarMenuAdministrador(Scanner scanner) {
        boolean adminRunning = true;
        while (adminRunning) {
            System.out.println("Menu de Administrador:");
            System.out.println("1. Crear counter");
            System.out.println("2. Gestionar Clientes");
            System.out.println("3. Cerrar sesion");
            System.out.print("Seleccione una opcion: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1" -> {
                    counter nuevoCounter = null;
                    nuevoCounter = new counter();
                    System.out.println("Ejecutando opcion de Creacion de counter");
                    System.out.println("Ingrese el nombre del Counter: ");
                    String nombre = scanner.nextLine();

                    System.out.println("Ingrese la cedula del Counter: ");
                    String cedula = scanner.nextLine();

                    System.out.println("Ingrese la direccion del Counter: ");
                    String direccion = scanner.nextLine();

                    System.out.println("Ingrese la cantidad de casilleros del Counter: ");
                    int cantCasilleros = scanner.nextInt();
                    
                    if (counters.containsKey(cedula) == false) {
                        counters.put(cedula, new counter(nombre, cedula, direccion, cantCasilleros));
                        System.out.println("Counter agregado con éxito.");
                    } else {
                        System.out.println("Counter con esa cédula ya existe.");
                    }
                    nuevoCounter.toString();
                }
                case "2" -> {
                    System.out.println("Ejecutando opcion de Gestion de Clientes");
                    menuGestionClientes(scanner);
                }
                case "3" -> {
                    adminRunning = false;
                    System.out.println("Cerrando sesion de administrador...");
                }
                default ->
                    System.out.println("Opcion no reconocida.");
            }
        }
    }

    private static void mostrarMenuUsuario(Scanner scanner, usuario usuario) {
        boolean userRunning = true;
        while (userRunning) {
            System.out.println("Menu de Usuario:");
            System.out.println("1. Consultar entregables pendientes");
            System.out.println("2. Opcion de usuario 2");
            System.out.println("3. Cerrar sesion");
            System.out.print("Seleccione una opcion: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1" -> {
                    System.out.println("Consultando entregables pendientes...");
                    usuario.consultarEntregablesPendientes();
                    break;
                }
                case "2" ->
                    System.out.println("Ejecutando opcion de usuario 2...");
                // Lógica para la opción de usuario 2
                case "3" -> {
                    userRunning = false;
                    System.out.println("Cerrando sesion de usuario...");
                }
                default ->
                    System.out.println("Opcion no reconocida.");
            }
        }
    }

    private static void menuGestionClientes(Scanner scanner) {
        boolean adminRunning = true;
        while(adminRunning) {
            System.out.println("Menu de Gestion de Clientes:");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Modificar Cliente");
            System.out.println("3. Eliminar Cliente");
            System.out.println("4. Consultar Clientes");
            System.out.print("Seleccione una opcion: ");
            String opcion = scanner.nextLine();
            switch (opcion) {
                case "1" -> {

                    Random random = new Random();

                    int ID = random.nextInt(1000); // Asignar un ID aleatorio
                    System.out.print("Ingrese el nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el correo: ");
                    String correo = scanner.nextLine();
                    System.out.print("Ingrese el telefono: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Ingrese la direccion: ");
                    String direccion = scanner.nextLine();
                    System.out.print("Ingrese su sexo (M/F/NE): ");
                    String sexoInput = scanner.nextLine();
                    tipo_sexo sexo;
                    if (sexoInput.equalsIgnoreCase("M")) {
                        sexo = tipo_sexo.MASCULINO;
                    } else if (sexoInput.equalsIgnoreCase("F")) {
                        sexo = tipo_sexo.FEMENINO;
                    } else {
                        sexo = tipo_sexo.NOESPECIFICADO;
                    }
                    System.out.print("Ingrese su fecha de nacimiento (yyyy-mm-dd): ");
                    String[] fechaNacimientoInput = scanner.nextLine().split("-");
                    Calendar fechaNacimiento = Calendar.getInstance();
                    fechaNacimiento.set(Integer.parseInt(fechaNacimientoInput[0]), Integer.parseInt(fechaNacimientoInput[1]) - 1, Integer.parseInt(fechaNacimientoInput[2]));

                    // Asignar un casillero al cliente
                    casillero casillero = new casillero();

                if (!clientes.containsKey(ID)) {
                    clientes.put(ID, new cliente(ID, nombre, correo, telefono, direccion, sexo, fechaNacimiento, casillero));
                    System.out.println("Registro exitoso. Puede iniciar sesion ahora.");
                } else {
                    System.out.println("Cliente con ese ID ya existente");
                }    
            }        
                case "2" -> {
                    System.out.println("Ejecutando la opcion de Modificacion de Cliente");
                    System.out.println("Ingrese el username del Cliente");
                    String username = scanner.nextLine();
                    if (!login.users.containsKey(username)) {
                        System.out.println("Cliente inexistente");
                    } else {
                        usuario usuario = login.users.get(username);
                        cliente cliente = usuario.getCliente();
                        System.out.println("Qué deseas modificar?");
                        System.out.println("1. Modificar Nombre");
                        System.out.println("2. Modificar Correo");
                        System.out.println("3. Modificar Telefono");
                        System.out.println("4. Modificar Direccion");
                        String opcion2 = scanner.nextLine();
                        switch (opcion2) {
                            case "1" -> {
                                System.out.println("Ingrese el nuevo Nombre");
                                String nuevoNombre = scanner.nextLine();
                                cliente.setNombre(nuevoNombre);
                            }
                            case "2" -> {
                                System.out.println("Ingrese el nuevo Correo");
                                String nuevoCorreo = scanner.nextLine();
                                cliente.setCorreo(nuevoCorreo);
                            }
                            case "3" -> {
                                System.out.println("Ingrese el nuevo Telefono");
                                String nuevoTelefono = scanner.nextLine();
                                cliente.setTelefono(nuevoTelefono);
                            }
                            case "4" -> {
                                System.out.println("Ingrese la nueva Direccion");
                                String nuevoDireccion = scanner.nextLine();
                                cliente.setDireccion(nuevoDireccion);
                            }
                        }
                    }
                }
                case "3" -> {
                    System.out.println("Ejecutando la opcion de Eliminacion del Cliente");
                }
                case "4" -> {
                    System.out.println("Ejecutando la opcion de Consultar Cliente");
                    System.out.println("Qué deseas Consultar?");
                    System.out.println("1. Ver todos los Clientes");
                    System.out.println("2. Buscar Cliente");
                    System.out.println("3. Gestionar Articulos");
                    String opcion2 = scanner.nextLine();
                    switch (opcion2) {
                        case "1" -> {
                            login.mostrarUsuarios();
                        }
                        case "2" -> {
                            System.out.println("Ingrese el username del cliente que desea consultar");
                            String username = scanner.nextLine();
                            login.mostrarInformacionClientePorId(username);
                        }
                        case "3" ->{

                        }
                    }
                }
            }
        }
    }
}
