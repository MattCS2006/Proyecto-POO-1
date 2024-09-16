/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.ArrayList;
import java.util.List;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.Session;
import java.util.Properties;

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
    public void agregarEntregable(entregable entregable) {
        entregables.add(entregable);
    }

    private void enviarNotificacion(entregable entregable) {
        String to = cliente.getCorreo(); // Correo del cliente
        String from = "masanroje06@gmail.com"; // Correo del remitente
        String host = "smtp.gmail.com"; // Servidor de correo

        // Propiedades del sistema
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);

        // Obtener la sesión por defecto
        Session session = Session.getDefaultInstance(properties);

        try {
            // Crear un objeto MimeMessage por defecto
            MimeMessage message = new MimeMessage(session);

            // Asignar el remitente
            message.setFrom(new InternetAddress(from));

            // Asignar el destinatario
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Asignar el asunto del correo
            message.setSubject("Nuevo entregable recibido");

            // Asignar el cuerpo del mensaje
            message.setText("Se ha recibido un nuevo entregable: " + entregable.getNombre());

            // Enviar el mensaje
            Transport.send(message);
            System.out.println("Notificación enviada correctamente...");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
