/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Rafael
 */
public class counter {

    private String nombre;
    private String cedula;
    private String direccion;
    private int cantidad_casilleros;
    private int ultimo_casillero = 1000;
    private estado_casillero estado;
    private ArrayList<casillero> casilleros = new ArrayList();
    private ArrayList<cliente> clientes = new ArrayList();

    /**
     *
     */
    public counter() {

    }

    /**
     *
     * @param nombre
     * @param cedula
     * @param direccion
     * @param cantidad_casilleros
     */
    public counter(String nombre, String cedula, String direccion, int cantidad_casilleros) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.cantidad_casilleros = cantidad_casilleros;

    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getCantidad_casilleros() {
        return cantidad_casilleros;
    }

    public int getUltimo_casillero() {
        return ultimo_casillero;
    }

    public estado_casillero getEstado() {
        return estado;
    }

    public ArrayList<casillero> getCasilleros() {
        return casilleros;
    }

    public ArrayList<cliente> getClientes() {
        return clientes;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCantidad_casilleros(int cantidad_casilleros) {
        this.cantidad_casilleros = cantidad_casilleros;
    }

    public void setUltimo_casillero(int ultimo_casillero) {
        this.ultimo_casillero = ultimo_casillero;
    }

    public void setEstado(estado_casillero estado) {
        this.estado = estado;
    }

    public void setCasilleros(ArrayList<casillero> casilleros) {
        this.casilleros = casilleros;
    }

    public void setClientes(ArrayList<cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public String toString() {
        return "counter{" + "nombre=" + nombre + ", cedula=" + cedula + ", direccion=" + direccion + ", cantidad_casilleros=" + cantidad_casilleros + ", ultimo_casillero=" + ultimo_casillero + ", estado=" + estado + ", casilleros=" + casilleros + ", clientes=" + clientes + '}';
    }

    public String agregar_cliente(int id, String nombre, String correo, String telefono, String direccion, tipo_sexo sexo, Calendar fechaNacimiento) {
        for (cliente cli : clientes) {
            if (cli.getId() == id) {
                return "ERROR. EL ID DEL CLIENTE YA EXISTE. ";

            } else if (!telefono.matches("\\d+") || telefono.length() != 8) {
                return "ERROR. EL TELEFONO NO TIENE EL FORMATO CORRECTO. ";
            } else if (false) {
                return "ERROR. EL CORREO NO ES VALIDO";
            }
        }
        cliente cli = new cliente(id, nombre, correo, telefono, direccion, sexo, fechaNacimiento);
        clientes.add(cli);

        return null;
    }

    /*
    public void mostrarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            for (cliente c : clientes) {
                System.out.println("ID: " + c.getId());
                System.out.println("Nombre: " + c.getNombre());
                System.out.println("Correo: " + c.getCorreo());
                System.out.println("Teléfono: " + c.getTelefono());
                System.out.println("Dirección: " + c.getDireccion());
                System.out.println("Sexo: " + c.getSexo());
                System.out.println("Fecha de Nacimiento: " + c.getFechaNacimiento());
                System.out.println("Casillero: " + c.getCasillero());
                System.out.println("---------------------------------");
            }
        }
    }
        */
}
