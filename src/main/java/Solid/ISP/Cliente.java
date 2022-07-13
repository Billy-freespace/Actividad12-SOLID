package Solid.ISP;

public class Cliente {
    public static void main(String[] args) {
        System.out.println("Demostracion ISP");

        Impresora impresora = new ImpresoraBasica();
        impresora.printDocument();
        impresora.fotoCopy();
        impresora = new ImpresoraAvanzada();
        impresora.printDocument();
        impresora.fotoCopy();

        DispositivoFax fax = new ImpresoraAvanzada();
        fax.sendFax();

    }
}
