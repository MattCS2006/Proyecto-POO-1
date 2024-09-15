/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author masan
 */
public class entregable {

    private String numeroReferencia;
    private boolean estado;
    private String descripcion;
    private String remitente;

    // Constructores
    public entregable() {
    }

    public entregable(String numeroReferencia, boolean estado, String descripcion, String remitente) {
        this.numeroReferencia = numeroReferencia;
        this.estado = estado;
        this.descripcion = descripcion;
        this.remitente = remitente;
    }

    // Getters y Setters
    public String getNumeroReferencia() {
        return numeroReferencia;
    }

    public void setNumeroReferencia(String numeroReferencia) {
        this.numeroReferencia = numeroReferencia;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    //Metodos
}
