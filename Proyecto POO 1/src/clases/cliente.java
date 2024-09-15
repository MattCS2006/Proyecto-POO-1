/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.Calendar;

/**
 *
 * @author masan
 */
public class cliente {

    private int id;
    private String nombre;
    private String correo;
    private String telefono;
    private String direccion;
    private tipo_sexo sexo;
    private Calendar fechaNacimiento;
    private casillero casillero;

    // Constructores
    public cliente() {
    }

    public cliente(int id, String nombre, String correo, String telefono, String direccion, tipo_sexo sexo, Calendar fechaNacimiento, casillero casillero) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.casillero = casillero;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public tipo_sexo getSexo() {
        return sexo;
    }

    public void setSexo(tipo_sexo sexo) {
        this.sexo = sexo;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public casillero getCasillero() {
        return casillero;
    }

    public void setCasillero(casillero casillero) {
        this.casillero = casillero;
    }
}
