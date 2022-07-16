package Solid.ISP;

interface Impresora {
    void printDocument();

    default void fotoCopy() {
        System.out.println("Imprimiendo fotocopia");
    }
}
