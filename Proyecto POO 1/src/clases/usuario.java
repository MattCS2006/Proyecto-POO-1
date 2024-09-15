/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

public class usuario {

    public enum Rol {
        USUARIO,
        ADMINISTRADOR
    }

    private String username;
    private String password;
    private Rol rol;
    private cliente cliente;

    public usuario(String username, String password, Rol rol, cliente cliente) {
        this.username = username;
        this.password = password;
        this.rol = rol;
        this.cliente = cliente;
    }

    // Getters y Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public cliente getCliente() {
        return cliente;
    }

    public void setCliente(cliente cliente) {
        this.cliente = cliente;
    }

    //Metodos
    public void consultarEntregablesPendientes() {
        if (cliente != null) {
            System.out.println("Entregables pendientes en su casillero:");
            for (entregable entregable : cliente.getCasillero().getEntregables()) {
                System.out.println(entregable);
            }
        } else {
            System.out.println("No hay cliente asociado.");
        }
    }
}
