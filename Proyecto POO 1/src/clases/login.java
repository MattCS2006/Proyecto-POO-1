/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author masan
 */
public class login {

    public final Map<String, usuario> users;

    private static final String CLAVE_ADMIN = "87654321";

    public login() {
        users = new HashMap<>();
        }

    // Método para agregar un usuario
    public boolean addUser(String username, String password, usuario.Rol rol, String claveAdminInput, cliente cliente) {
        if (rol == usuario.Rol.ADMINISTRADOR) {
            if (!CLAVE_ADMIN.equals(claveAdminInput)) {
                return false; // Clave de administrador incorrecta
            }
            cliente = null; // Los administradores no tienen cliente asociado
        }
        users.put(username, new usuario(username, password, rol, cliente));
        return true;
    }

    // Método para autenticar un usuario
    public usuario authenticate(String username, String password) {
        if (users.containsKey(username) && users.get(username).getPassword().equals(password)) {
            return users.get(username);
        }
        return null;
    }

    public void mostrarUsuarios() {
        System.out.println("Lista de clientes: ");
        for (Map.Entry<String, usuario> entry : users.entrySet()) {
            usuario user = entry.getValue();
            
            if (user.getRol() == usuario.Rol.USUARIO) {
                System.out.println("Usuario: " + user.getUsername());
                
                cliente clienteAsociado = user.getCliente();
                if (clienteAsociado != null) {
                    System.out.println("Cliente asociado - Nombre: " + clienteAsociado.getNombre() +
                                       ", Correo: " + clienteAsociado.getCorreo());
                }
            }
        }
    }

    public void mostrarInformacionClientePorId(String username) {
        // Verificar si el usuario existe
        if (users.containsKey(username)) {
            usuario user = users.get(username);
    
            // Verificar si el rol del usuario es CLIENTE
            if (user.getRol() == usuario.Rol.USUARIO) {
                cliente clienteAsociado = user.getCliente();
                
                // Mostrar la información del cliente asociado
                if (clienteAsociado != null) {
                    System.out.println("Información del cliente:");
                    System.out.println("Nombre: " + clienteAsociado.getNombre());
                    System.out.println("Correo: " + clienteAsociado.getCorreo());
                    System.out.println("Teléfono: " + clienteAsociado.getTelefono());
                    System.out.println("Dirección: " + clienteAsociado.getDireccion());
                    System.out.println("Sexo: " + clienteAsociado.getSexo());
                    System.out.println("Fecha de Nacimiento: " + clienteAsociado.getFechaNacimiento().getTime());
                    // Aquí puedes mostrar más información del casillero si lo tienes en la clase cliente
                } else {
                    System.out.println("El usuario no tiene un cliente asociado.");
                }
            } else {
                System.out.println("El usuario con username " + username + " no tiene rol de CLIENTE.");
            }
        } else {
            System.out.println("No se encontró un usuario con el username: " + username);
        }
    }
}
