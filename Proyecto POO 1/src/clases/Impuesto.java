/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Andres
 */
public class Impuesto {

    // Tarifa base para el cálculo de impuestos
    private static final double TARIFA_BASE = 0.02; 
    private static final double COSTO_ELECTRONICO = 2.0; 
    private static final double COSTO_FRAGIL = 2.0; 

    // Método para calcular el impuesto de un paquete
    public static double calcularImpuestoPaquete(paquete p) {
        double impuesto = p.getPeso() * TARIFA_BASE; 

        if (p.isContieneElectronico()) {
            impuesto += COSTO_ELECTRONICO;
        }

        if (p.isFragil()) {
            impuesto += COSTO_FRAGIL;
        }

        return impuesto;
    }

    public static double calcularImpuestoRevista(revista r) {
        double impuestoBase = 1.0;
        return impuestoBase;
    }

    public static double calcularImpuestoSobre(sobre s) {
        double impuesto = s.getPeso() * TARIFA_BASE;

        return impuesto;
    }

    public static double calcularImpuestoCasillero(casillero casillero) {
        double impuestoTotal = 0;

        for (entregable e : casillero.getEntregables()) {
            if (e instanceof paquete) {
                impuestoTotal += calcularImpuestoPaquete((paquete) e);
            } else if (e instanceof revista) {
                impuestoTotal += calcularImpuestoRevista((revista) e);
            } else if (e instanceof sobre) {
                impuestoTotal += calcularImpuestoSobre((sobre) e);
            }
        }

        return impuestoTotal;
    }
}
