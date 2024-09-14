/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author masan
 */
public class sobre extends entregable {

    public enum TipoSobre {
        AEREO,
        MANILA
    }

    public enum Contenido {
        DOCUMENTACION,
        OTRO
    }

    private TipoSobre tipo;
    private Contenido contenido;
    private double peso;

    // Constructores
    public sobre() {
        super();
    }

    public sobre(String numeroReferencia, boolean estado, String descripcion, String remitente, TipoSobre tipo, Contenido contenido, double peso) {
        super(numeroReferencia, estado, descripcion, remitente);
        this.tipo = tipo;
        this.contenido = contenido;
        this.peso = peso;
    }

    // Getters y Setters
    public TipoSobre getTipo() {
        return tipo;
    }

    public void setTipo(TipoSobre tipo) {
        this.tipo = tipo;
    }

    public Contenido getContenido() {
        return contenido;
    }

    public void setContenido(Contenido contenido) {
        this.contenido = contenido;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
