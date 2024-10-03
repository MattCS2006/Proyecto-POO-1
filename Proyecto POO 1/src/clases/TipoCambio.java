package clases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TipoCambio {

    public double obtenerTipoCambioCompra(String xml) {
        return extraerValorDesdeXML(xml, "NUM_VALOR");
    }

    public double obtenerTipoCambioVenta(String xml) {
        return extraerValorDesdeXML(xml, "NUM_VALOR");
    }

    public String obtenerXmlTipoCambio() {
        try {
            LocalDate fechaActual = LocalDate.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaFormateada = fechaActual.format(formato);

            String urlStr = "https://gee.bccr.fi.cr/Indicadores/Suscripciones/WS/wsindicadoreseconomicos.asmx/ObtenerIndicadoresEconomicos?"
                    + "Indicador=317"
                    + "&FechaInicio=" + fechaFormateada
                    + "&FechaFinal=" + fechaFormateada
                    + "&Nombre=tuNombre"
                    + "&SubNiveles=N"
                    + "&CorreoElectronico=tuCorreo"
                    + "&Token=tuToken";

            return "<string xmlns=\"http://ws.sdde.bccr.fi.cr\"><Datos_de_INGC011_CAT_INDICADORECONOMIC><INGC011_CAT_INDICADORECONOMIC><COD_INDICADORINTERNO>317</COD_INDICADORINTERNO><DES_FECHA>" 
                + fechaFormateada 
                + "</DES_FECHA><NUM_VALOR>514.79000000</NUM_VALOR></INGC011_CAT_INDICADORECONOMIC></Datos_de_INGC011_CAT_INDICADORECONOMIC></string>";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private double extraerValorDesdeXML(String xml, String tag) {
        int inicio = xml.indexOf("<" + tag + ">") + tag.length() + 2;
        int fin = xml.indexOf("</" + tag + ">");
        return Double.parseDouble(xml.substring(inicio, fin));
    }
}
