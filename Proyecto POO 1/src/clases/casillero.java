/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author masan
 */
public class casillero {

    private String counter;
    private cliente cliente;
    private boolean estado;
    private List<entregable> entregables;

    // Constructor
    public casillero() {
        this.entregables = new ArrayList<>();
    }

    public casillero(String counter, cliente cliente, boolean estado) {
        this.counter = counter;
        this.cliente = cliente;
        this.estado = estado;
        this.entregables = new ArrayList<>();
    }

    // Getters and Setters
    public String getCounter() {
        return counter;
    }

    public void setCounter(String counter) {
        this.counter = counter;
    }

    public cliente getCliente() {
        return cliente;
    }

    public void setCliente(cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<entregable> getEntregables() {
        return entregables;
    }

    public void setEntregables(List<entregable> entregables) {
        this.entregables = entregables;
    }

    //metodos
    // Método para agregar un paquete a la colección
    public void addEntregable(entregable entregable) {
        this.entregables.add(entregable);
    }
}
