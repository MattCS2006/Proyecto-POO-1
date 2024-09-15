/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Proyecto_POO;

import clases.*;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author masan
 */
public class ProyectoPOO1RafaAndresSantiagoMattew {

    public static void main(String[] args) {
        login login = new login();
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
            System.out.println("1. Opcion de administrador 1");
            System.out.println("2. Opcion de administrador 2");
            System.out.println("3. Cerrar sesion");
            System.out.print("Seleccione una opcion: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1" ->
                    System.out.println("Ejecutando opcion de administrador 1...");
                // Lógica para la opción de administrador 1
                case "2" ->
                    System.out.println("Ejecutando opcion de administrador 2...");
                // Lógica para la opción de administrador 2
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
}
