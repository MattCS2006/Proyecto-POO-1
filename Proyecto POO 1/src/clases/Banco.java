package clases;

public class Banco {
    
    private final TipoCambio tipoCambio;

    // Constructor
    public Banco() {
        this.tipoCambio = new TipoCambio(); // Inicializamos la clase TipoCambio
    }

    public double convertirColonesADolares(double montoEnColones) {
        String xmlTipoCambio = tipoCambio.obtenerXmlTipoCambio();

        double tipoCompra = tipoCambio.obtenerTipoCambioCompra(xmlTipoCambio);

        return montoEnColones / tipoCompra;
    }

    public double convertirDolaresAColones(double montoEnDolares) {
        String xmlTipoCambio = tipoCambio.obtenerXmlTipoCambio();

        double tipoVenta = tipoCambio.obtenerTipoCambioVenta(xmlTipoCambio);

        return montoEnDolares * tipoVenta;
    }

    public static void main(String[] args) {
        Banco banco = new Banco();
        
        double montoColones = 100000; // Monto en colones
        double montoDolares = banco.convertirColonesADolares(montoColones);
        System.out.println("Monto en dólares: " + montoDolares);
        
        double montoEnDolares = 200;
        double montoColonesConvertido = banco.convertirDolaresAColones(montoEnDolares);
        System.out.println("Monto en colones: " + montoColonesConvertido);
    }
}
