/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author masan
 */
package clases;

public class revista extends entregable {

    public enum Tema {
        NEGOCIOS,
        MODA_BELLEZA,
        TECNOLOGIA,
        SALUD_MEDICINA,
        COCINA,
        OTRO
    }

    private String nombre;
    private boolean esCatalogo;
    private Tema tema;

    // Constructores
    public revista() {
        super();
    }

    public revista(String numeroReferencia, boolean estado, String descripcion, String remitente, String nombre, boolean esCatalogo, Tema tema) {
        super(numeroReferencia, estado, descripcion, remitente);
        this.nombre = nombre;
        this.esCatalogo = esCatalogo;
        this.tema = tema;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEsCatalogo() {
        return esCatalogo;
    }

    public void setEsCatalogo(boolean esCatalogo) {
        this.esCatalogo = esCatalogo;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }
}
