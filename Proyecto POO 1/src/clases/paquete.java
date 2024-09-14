/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author masan
 */
package clases;

public class paquete extends entregable {

    private boolean contieneElectronico;
    private boolean fragil;
    private double peso;

    // Constructores
    public paquete() {
        super();
    }

    public paquete(String numeroReferencia, boolean estado, String descripcion, String remitente, boolean contieneElectronico, boolean fragil, double peso) {
        super(numeroReferencia, estado, descripcion, remitente);
        this.contieneElectronico = contieneElectronico;
        this.fragil = fragil;
        this.peso = peso;
    }

    // Getters y Setters
    public boolean isContieneElectronico() {
        return contieneElectronico;
    }

    public void setContieneElectronico(boolean contieneElectronico) {
        this.contieneElectronico = contieneElectronico;
    }

    public boolean isFragil() {
        return fragil;
    }

    public void setFragil(boolean fragil) {
        this.fragil = fragil;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
