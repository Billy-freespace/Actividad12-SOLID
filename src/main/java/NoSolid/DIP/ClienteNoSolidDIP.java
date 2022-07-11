package NoSolid.DIP;

public class ClienteNoSolidDIP {
    public static void main(String[] args) {
        System.out.println("A demo without DIP.");
        InterfazUsuario usuario = new InterfazUsuario();
        usuario.saveEmployeeId("E001");

    }
}
