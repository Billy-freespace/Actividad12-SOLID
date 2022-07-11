package Solid.DIP;

public class Cliente {
    public static void main(String[] args) {
        System.out.println("Demostracion con DIP");

        BaseDatos database;
        InterfazUsuario interfazUsuario;

        // Usando Oracle
        database = new OracleDatabase();
        interfazUsuario = new InterfazUsuario(database);
        interfazUsuario.saveEmployeeId("E001");

        // Usando Mysql
        database = new MySQLDatabase();
        interfazUsuario = new InterfazUsuario(database);
        interfazUsuario.saveEmployeeId("E001");

        // Cambiando la base de datos objetivo
        //usuario = new InterfazUsuario(new OracleDatabase());
       //...completa


    }
}