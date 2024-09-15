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

    private Map<String, usuario> users;
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
}
