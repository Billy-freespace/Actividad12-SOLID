## DIP

### PREGUNTA 31
```txt

A demo without DIP.

El id: E001 es guardado en la base de datos Oracle.

  

Process finished with exit code 0

```

  
Inicialmente se crea una instancia de InterfazUsuario y se llama al metodo InterfazUsuario.saveEmployeeId(String), el cual internamente llama al metodo   OracleDatabase.saveEmpInDatabase(String), con la finalidad de guardar el ID del empleado en una base de datos Oracle.

  

### PREGUNTA 32
El problema es que el objeto de la clase InterfazUsuario (de la capa superior) depende de la clase concreta OracleDatabase (de la capa inferior). Por lo que  al querer cambiar a otra base de datos se tendrá que modificar las capas superiores que dependen de estas.

  
  

### PREGUNTA 33

  

```java

interface BaseDatos {

    public void saveEmpIdInDatabase(String empId);

}

  

```

  

```java

class OracleDatabase implements BaseDatos {

    @Override

    public void saveEmpIdInDatabase(String empId) {

        System.out.println("El id: " + empId + " es guardado en la base de datos Oracle.");

    }

}

  
  

```

  

### PREGUNTA 34

-   InterfazUsuario.java

```java

class InterfazUsuario {

    BaseDatos db;

  

    public InterfazUsuario(BaseDatos database) {

        db = database;

    }

  

    public void saveEmployeeId(String empId) {

        db.saveEmpIdInDatabase(empId);

    }

  

    public void setDatabase(BaseDatos database){ db = database;}

}

```

-   BaseDatos.java

```java

interface BaseDatos {

    public void saveEmpIdInDatabase(String empId);

}

```

-   OracleDataBase.java

```java

class OracleDatabase implements BaseDatos {

    public void saveEmpIdInDatabase(String empId) {

        System.out.println("El id: " + empId + " es guardado en la base de datos Oracle.");

    }

}

```

-   MySQLDatabase.java

```java

class MySQLDatabase implements BaseDatos {

    public void saveEmpIdInDatabase(String empId) {

        System.out.println("El id: " + empId + " es guardado en la base de datos MYSQL.");

    }

}

```

-   Cliente.java

```java

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

```

  

### PREGUNTA 35

BUSCAR CASO EXCEPCIONAL

  

### PREGUNTA 36
Que permite cambiar el objeto BaseDatos definido en la clase IntefazUsurio en cualquier momento