/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Proyecto_POO;

import clases.*;
import java.util.Scanner;

/**
 *
 * @author masan
 */
public class ProyectoPOO1RafaAndresSantiagoMattew {

    public static void main(String[] args) {
        login login = new login();
        try (Scanner scanner = new Scanner(System.in)) {

            // Crear algunos clientes de ejemplo
            cliente cliente1 = new cliente();
            cliente1.setId(1);
            cliente1.setNombre("Cliente 1");

            cliente cliente2 = new cliente();
            cliente2.setId(2);
            cliente2.setNombre("Cliente 2");

            // Agregar algunos usuarios y administradores
            login.addUser("user1", "password1", usuario.Rol.USUARIO, "", cliente1);
            login.addUser("admin1", "password2", usuario.Rol.ADMINISTRADOR, "87654321", null);

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
                            System.out.print("Ingrese el ID del cliente: ");
                            nuevoCliente.setId(scanner.nextInt());
                            scanner.nextLine(); // Consumir la nueva línea
                            System.out.print("Ingrese el nombre del cliente: ");
                            nuevoCliente.setNombre(scanner.nextLine());
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
                                mostrarMenuUsuario(scanner);
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

    private static void mostrarMenuUsuario(Scanner scanner) {
        boolean userRunning = true;
        while (userRunning) {
            System.out.println("Menu de Usuario:");
            System.out.println("1. Opcion de usuario 1");
            System.out.println("2. Opcion de usuario 2");
            System.out.println("3. Cerrar sesion");
            System.out.print("Seleccione una opcion: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1" ->
                    System.out.println("Ejecutando opcion de usuario 1...");
                // Lógica para la opción de usuario 1
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
