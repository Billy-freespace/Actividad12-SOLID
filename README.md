# Actividad12-SOLID - PC3 CC3S2

**Miembros del grupo:**
* Guillermo Borjas - 20090312A
* Hannu Portillo - 20185508K
* Gustavo Lozano - 20161317K

## Tabla de Contenidos
1. [SRP - Principio de Responsabilidad Unica](#srp)
2. [OCP - Principio Abierto y Cerrado](#ocp)
3. [LSP - Principio de sustitución de Liskov](#lsp)
4. [ISP - Principio de Segmentación de Interfaz](#isp)
5. [DIP - Principio de Inversión de Dependencia](#dip)

## SRP

### PREGUNTA 1

```txt
Demostracion sin SRP
Nombre del empleado: Abejita,Jessica
Este empleado tiene 7.5 años de experiencia.
El ID del empleado es: J917
Este empleado es un empleado senior

----

Nombre del empleado: Smart,Chalito
Este empleado tiene 3.2 años de experiencia.
El ID del empleado es: C303
Este empleado es un empleado junior
```

El método *main* de la clase **Cliente** inicializa creando 2 objetos Empleado (jessica y chalo), los cuales son usando como argumentos del método estático `Client.showEmpDetail(Empleado)`. Este método internamente llama a los métodos `Empleado.displayEmpDetail()` y `checkSeniority(double)`, `Empleado.checkSeniority(double)` y `Empleado.generateEmpId(String)` de su parámetro (objetos Empleado creados).

- Empleado.displayEmpDetail(): Imprime el nombre del empleado y su experiencia en años.
- Empleado.checkSeniority(double): Devuelve "senior" si el parámetro es menor de 5, o "junior" en caso contrario.
- Empleado.generateEmpId(String): Genera un ID de empleado concatenando la primera letra de su nombre y un número aleatorio de 3 dígitos.



### PREGUNTA 2

Problema:
- La clase **Empleado** tiene más de una responsabilidad (verifica si el empleado es Senior *checkSeniority* y de generar el **ID** del empleado *generateEmId*, además de encapsular el objeto Empleado).

Posibles razones del problema:
- Existe un fuerte acoplamiento entre la clase **Empleado** y sus clases clientes (debido a la multi reponsabilidad de la clase **Empleado**).



## PREGUNTA 3
* **ClienteSolidSRP**
```java
public class ClienteSolidSRP {  
    public static void main(String[] args) {  
        System.out.println("Demostracion de SRP");  
  
        Empleado jessica = new Empleado("Jessica", "Abejita", 7.5);  
        showEmpDetail(jessica);  
  
        System.out.println("\n*******\n");  
  
        Empleado chalo = new Empleado ("Chalito", "Smart", 3.2);  
        showEmpDetail(chalo);  
  
    }  
  
    private static void showEmpDetail(Empleado emp) {  
        emp.displayEmpDetail();  
        System.out.println("El ID del empleado es: "+ (new GeneradorIDEmpleado()).generateEmpId(emp.firstName));  
        System.out.println("Este empleado es un" + " empleado " +  
                (new SeniorityChecker()).checkSeniority(emp.experienceInYears));  
        }  
}
```
* GeneradorIDEmpleado
```java
public class GeneradorIDEmpleado {  
    String empId;  
    public String generateEmpId(String empFirstName){  
        int random = new Random().nextInt(1000);  
        empId = empFirstName.substring(0,1)+random;  
        return empId;  
    }  
}
```
* SeniorityChecker
```java
public class SeniorityChecker {  
    public String checkSeniority(double experienceInYears){  
        return  experienceInYears > 5 ?"senior":"junior";  
    }  
}
```

### PREGUNTA 4
```txt
Demostracion de SRP
Nombre del empleado: Abejita,Jessica
Este empleado tiene 7.5 años de experiencia.
El ID del empleado es: J677
Este empleado es un empleado senior

*******

Nombre del empleado: Smart,Chalito
Este empleado tiene 3.2 años de experiencia.
El ID del empleado es: C561
Este empleado es un empleado junior
```

La inicialización de los objetos Empleado (jessica y chalo) es similar al caso No Solid. Luego de manera similar se pasa estos objetos como argumentos del método estático `Client.showEmpDetail(Empleado)`. A diferencia del caso No Solid, los métodos a los que se llamará `Client.showEmpDetail(Empleado)` son `(new GeneradorIDEmpleado()).generateEmpId(emp.firstName))` y `(new SeniorityChecker()).checkSeniority(emp.experienceInYears))` para asignar e imprimir un ID del empleado y verificar si este es de tipo Senior o Junior respectivamente.  

  

## OCP

### PREGUNTA 5
No es correcto colocar displayResult() y evaluateDistinction() en la clase Estudiante porque se violaría el SRP.




### PREGUNTA 6

Primero se inicializa una lista de estudiantes con el método estático enrolledStudents, luego muestra todos los estudiantes, luego se crea un objeto del objeto del tipo DistinctionDecider que sirve para evaluar de cada estudiante y muestra a los estudiantes distinguidos según sus notas dependiendo del departamento que pertenecen.

```txt

Demostracion sin OCP

Resultados:

Nombre: Irene

Numero Regex: R1

Dept:Ciencia de la Computacion.

Marks:81.5

*******

Nombre: Jessica

Numero Regex: R2

Dept:Fisica

Marks:72.0

*******

Nombre: Chalo

Numero Regex: R3

Dept:Historia

Marks:71.0

*******

Nombre: Claudio

Numero Regex: R4

Dept:Literatura

Marks:66.5

*******

Distinciones:

R1 ha recibido una distincion en ciencias.

R3 ha recibido una distincion en artes.

  

Process finished with exit code 0

*******

  
```

  

### PREGUNTA 7

El problema es en la clase DistinctionDecider, en el método evaluateDistinction, ya que si queremos agregar otro departamento que tenga otro sistema de evaluación como el de comercio habría que modificar el código existente violando el principio OCP.

  
  

### PREGUNTA 8

```java

interface DistinctionDecider {

    public void evaluateDistinction(Estudiante estudiante);

}

```


### PREGUNTA 9

```java

public class ArtsDistinctionDecider implements DistinctionDecider{

    public void evaluateDistinction(Estudiante estudiante) {

        if (estudiante.score > 70) {

            System.out.println(estudiante.regNumber+" ha recibido una distincion en artes.");

        }
    }

}

  

```

```java

public class ScienceDistinctionDecider implements DistinctionDecider {

    public void evaluateDistinction(Estudiante estudiante) {

        if (estudiante.score > 80) {

            System.out.println(estudiante.regNumber+" ha recibido una distincion en ciencias.");

        }

    }

}

```
  

### PREGUNTA 10

```txt

Demostracion OCP

Resultados:

Nombre: Irene

Numero Reg: R1

Dept:Ciencia de la computacion.

Marks:81.5

  

Nombre: Jessica

Numero Reg: R2

Dept:Fisica

Marks:72.0

  

Nombre: Chalo

Numero Reg: R3

Dept:Historia

Marks:71.0

  

Nombre: Claudio

Numero Reg: R4

Dept:Literatura

Marks:66.5

  

Distinciones:

R1 ha recibido una distincion en ciencias.

R3 ha recibido una distincion en artes.

  

Process finished with exit code 0

```

  

```java

abstract class Estudiante {

    String name;

    String regNumber;

    double score;

    String department;

  

    public Estudiante(String name, String regNumber, double score) {

        this.name = name;

        this.regNumber = regNumber;

        this.score = score;

    }

  

    public String toString() {

        return ("Nombre: " + name + "\nNumero Reg: " + regNumber + "\nDept:" + department + "\nMarks:"

                + score + "\n");

    }

  

}

```

  

```java

public class ArteEstudiante extends Estudiante{

    public ArteEstudiante(String name, String regNumber, double score, String dept) {

        super(name, regNumber, score);

        department = dept;

    }

  

}

  

```

  

```java

public class CienciaEstudiante extends Estudiante{

    public CienciaEstudiante(String name, String regNumber, double score, String dept) {

        super(name, regNumber, score);

        department = dept;

    }

  

}

  

```

  

```java

interface DistinctionDecider {

    public void evaluateDistinction(Estudiante estudiante);

}

  

```

  

```java

public class ScienceDistinctionDecider implements DistinctionDecider {

    public void evaluateDistinction(Estudiante estudiante) {

  

        if (estudiante.score > 80) {

            System.out.println(estudiante.regNumber+" ha recibido una distincion en ciencias.");

        }

  

    }

}

  

```

  

```java

public class ArtsDistinctionDecider implements DistinctionDecider{

    public void evaluateDistinction(Estudiante estudiante) {

  

        if (estudiante.score > 70) {

            System.out.println(estudiante.regNumber+" ha recibido una distincion en artes.");

        }

  

    }

}

  

```

  

```java

public class ClienteSolidOCP {

    public static void main(String[] args) {

        System.out.println("Demostracion OCP");

        List<Estudiante> CienciasEstudiantes = enrollScienceStudents();

        List<Estudiante> ArtesEstudiantes = enrollArtsStudents();

  

        // Muestra todos los resultados.

        System.out.println("Resultados:");

  

        for (Estudiante estudiante : CienciasEstudiantes) {

            System.out.println(estudiante);

        }

        for (Estudiante estudiante : ArtesEstudiantes) {

            System.out.println(estudiante);

        }

  

        // Evalua las distinciones

  

        DistinctionDecider scienceDistinctionDecider = new ScienceDistinctionDecider();

        DistinctionDecider artsDistinctionDecider = new ArtsDistinctionDecider();

        System.out.println("Distinciones:");

        for (Estudiante estudiante : CienciasEstudiantes) {

            scienceDistinctionDecider.evaluateDistinction(estudiante);

        }

        for (Estudiante estudiante : ArtesEstudiantes) {

            artsDistinctionDecider.evaluateDistinction(estudiante);

        }

  

    }

  

    private static List<Estudiante> enrollScienceStudents() {

        Estudiante Irene = new CienciaEstudiante("Irene", "R1", 81.5,"Ciencia de la computacion.");

        Estudiante jessica = new CienciaEstudiante("Jessica", "R2", 72,"Fisica");

        List<Estudiante> CienciasEstudiantes = new ArrayList<Estudiante>();

        CienciasEstudiantes.add(Irene);

        CienciasEstudiantes.add(jessica);

        return CienciasEstudiantes;

    }

  

    private static List<Estudiante> enrollArtsStudents() {

        Estudiante chalo = new ArteEstudiante("Chalo", "R3", 71,"Historia");

        Estudiante claudio = new ArteEstudiante("Claudio", "R4", 66.5,"Literatura");

        List<Estudiante> ArtesEstudiantes = new ArrayList<Estudiante>();

        ArtesEstudiantes.add(chalo);

        ArtesEstudiantes.add(claudio);

        return ArtesEstudiantes;

    }

  
  

}

  

```

  

Primero creamos dos listas de objetos del tipo Estudiante según sean de ciencias o arte y luego inicializamos cada lista con uno de los dos métodos estáticos (enrollScienceStudents() o enrollArtsStudents()) según el departamento donde pertenezca el estudiante, luego mostramos los estudiantes y después creamos dos objetos ScienceDistinctionDecider() y ArtsDistinctionDecider() que evaluar de cada estudiante de ciencias y arte respectivamente, y muestra a los estudiantes distinguidos según sus notas dependiendo del departamento que pertenecen.  

  

### PREGUNTA 11
Las principales ventajas son que la clase estudiante solo se encarga de encapsular el objeto Estudiante, , al definir Estudiante como clase abstracta no nos preocupamos por modificar dicha clase si queremos agregar algún tipo de estudiante solo creamos subclases de Estudiante, asimismo al definir DistinctionDecider como interface no nos preocupamos por implementar su método evaluateDistinction(), según el tipo de estudiante realizaremos la implementación de la interface.  

  

## LSP  


### PREGUNTA 12
```txt
Demostracion sin LSP

  

Recuperando de Abejita, ultimos detalles de pagos.

------

Recuperando de Chalito, ultimos detalles de pagos.

------

------

Procesando de Abejita, la actual solicitud de pagos .

------

Procesando de Chalito, la actual solicitud de pagos .

------

------

```


Al comienzo se crea un objeto del tipo `PaymentHelper`, luego se crean 2 usuarios del tipo RegisteredUserPayment (que implementa la interfaz payment), por lo que se puede usar como parámetro del método addUser de la clase `PaymentHelper` (*principio LSP*). De forma similar también se crea un objeto del tipo `GuestUserPayment`, que también implementa la interfaz `Payment`, y se usa como paŕametro del método *addUser* de la clase `PaymentHelper`. 

Luego se llama al método *showPreviousPaymentInfo* que invoca el método *previousPaymentInfo* en cada uno de los objetos `Payment` almacenados en la lista que almacena el objeto helper (Dynamic Binding). De forma similar sucede con la llamada al método *processNewPayment*.

  

### PREGUNTA 13

Copiado el código de `GuestUserPayment` proporcionado



### PREGUNTA 14

```txt
Demostracion sin LSP

  

Recuperando de Abejita, ultimos detalles de pagos.

------

Recuperando de Chalito, ultimos detalles de pagos.

------

Exception in thread "main" java.lang.UnsupportedOperationException

    at NoSolid.LSP.GuestUserPayment.previousPaymentInfo(GuestUserPayment.java:11)

    at NoSolid.LSP.PaymentHelper.showPreviousPayments(PaymentHelper.java:14)

    at NoSolid.LSP.Cliente.main(Cliente.java:21)

```

  
La excepción lanzada es `java.lang.UnsupportedOperationException`. Una solución sería implementar este método (`GuestUserPayment.perviousPaymentInfo`) para evitar la excepción.

### PREGUNTA 15

`No se encontró ninguna sentencia if-else en el código entregado`

### PREGUNTA 16

Se creó la nueva interfaz `NewPayment`, se trasladó el método `newPayment()` a esta interfaz, se refactorizó el nombre de la interfaz `Payment` a `PreviousPayment`. Ahora ambas clases `GuestUserPayment` y `RegisteredUserPayment` implementan la interfaz `NewyPayment`, y sólo las clase `RegisteredUserPayment` implementa la interfaz `PreviousPayment`.

### PREGUNTA 17

Los cambios claves fueron:
- En la clase `PaymentHelper`, en vez de una sola lista ahora se manejan dos, una que guarda objetos de tipo `NewPayment` y otra de tipo `PreviousPayment`.
- Se Refactoriza el método `addUser()` a `addNewPayment()` que ahora toma como parámentro objetos de tipo `NewPayment` y los agrega a su lista correspondiente.
- Análogamente se crea el método `addPreviousPayment()`.
- El método `showPreviousPayments()`, ahora solo itera sobre la lista de tipo `PreviousPayment`.
- Análogamente el método `processNewPayments()`, itera sobre la lista de tipo `NewPayment`.

### PREGUNTA 18

```java

public class Cliente {
    public static void main(String[] args) {

        System.out.println("Demostracion LSP.\n");
        PaymentHelper helper = new PaymentHelper();

        // Instanciando dos usuarios registrados
        RegisteredUserPayment irene = new RegisteredUserPayment("Irene");
        RegisteredUserPayment claudio = new RegisteredUserPayment("Claudio");
        // Instanciando el pago de un usuario invitado
        GuestUserPayment guestUser1 = new GuestUserPayment();

        // Consolidando la informacion del pago anterior al helper
        helper.addPreviousPayment(irene);
        helper.addPreviousPayment(claudio);

        // Consolidando nuevas solicitudes de pago al helper
        helper.addNewPayment(irene);
        helper.addNewPayment(claudio);
        helper.addNewPayment(guestUser1);

        /*// Recupera todos los pagos anteriores de los usuarios registrados
        helper.showPreviousPayments();

        // Procesa todas las solicitudes de pago nuevos de todos los usuarios
        helper.processNewPayments();*/

        showAllPayments(helper);

    }

    private static void showAllPayments(PaymentHelper helper) {
        helper.showPreviousPayments();
        helper.processNewPayments();
    }
}

```

## ISP


### PREGUNTA 19

Se necesita cambiar una clase base o interfaz por las necesidades de las clases que implementan estas interfaces, pero esto a su vez implica implementar las nuevas funcionalidades en las clases que implementa esta interfaz.

  

### PREGUNTA 20

El problema es que al ser ImpresoraAvanzada una implementación de la interfaz Impresora el método sendFax() de aquella está sobrescrito, por lo que cualquier modificación el los argumentos o el tipo de retorno en el método sobrescrito exige que se haga las mismas modificaciones en la definición del método sendFax() en la interfaz (violando el principio OCP), lo cual a su vez exige que se realicen las mismas modificaciones de la interfaz en las demás implementaciones de esta.

  

### PREGUNTA 21

Debido a que la definición del método sendFax() de la interfaz no es utilizada realmente en la implementación ImpresoraBasica es necesario que dicho método se saque de la interfaz, para que se cumpla el principio ISP.

  

### PREGUNTA 22

No es conveniente, ya que obliga a la clase ImpresoraBasica implementar una funcionalidad innecesaria y obliga a que se redefina cada vez que cambie el método innecesario de la interfaz.

  

### PREGUNTA 23

Se tendría que trasladar el método sendFax de la interfaz Impresora a la interfaz Fax, y de esta forma se implementa la interfaz Fax solo a las clases que necesiten hacer uso de éste método.

  

### PREGUNTA 24

Añadiendo el código de ejemplo se puede comprobar que efectivamente al instanciar un objeto de tipo Impresora como ImpresoraBasica, lanza un error al llamar el método sendFax en tiempo de ejecución.

  

### PREGUNTA 25

Se usó la expresión: 
```java
impresoras.forEach(dispositivo -> dispositivo.printDocument());

```

  

### PREGUNTA 26
```txt

Demostracion sin ISP

La impresora avanzada imprime un documento.

La impresora avanzada envía un fax.

La impresora basica imprime un documento.

La impresora avanzada imprime un documento.

La impresora basica imprime un documento.

La impresora avanzada imprime un documento.

La impresora basica imprime un documento.

```
  

Tanto los objetos de tipo Impresora, instanciados como ImpresoraBasica o ImpresoraAvancada, no tienen problema en llamar al método printDocument, pero en el caso de ImpresoraBasica, el método sendFax arroja una excepción, por la que no se la puede llamar desde este objeto. Para ello habría que verificar de antemano que el objeto instanciado sea de tipo ImpresoraAvanzada para estar seguro de poder llamar al método sendFax.

  

### PREGUNTA 27
```txt

Demostracion ISP

La impresora basica imprime un documento.

La impresora avanzada imprime un documento.

La impresora avanzada envía un fax.

```
  

Ahora las clases solo implementan las interfaces necesarias, que contienen sólo los métodos útiles para cada clase. De esta manera también se evita tener que sobreescribir los métodos innecesarios cada vez que se haga algún cambio en la interfaz.

  

### PREGUNTA 28

Este método predeterminado es heredado por todas las clases que implementen esta interfaz, que al ya tener cuerpo, no es necesario sobreescribir el método en cada una de las clases que la implementan.

  

### PREGUNTA 29

Análogamente, como sucede con cualquier otro método de la interfaz, si alguna clase que implemente esta interfaz, no necesite de este método, habría que sobreescribirlo.

  

### PREGUNTA 30

En ese caso el método no realiza ninguna acción. Aún si el método no tiene cuerpo y no genere errores de codificación, seguiría siendo un método inútil (lo cual violaría el principio ISP), el cual podría crear confusión al esperar alguna funcionalidad de éste.  


## DIP


### PREGUNTA 31
```txt

A demo without DIP.

El id: E001 es guardado en la base de datos Oracle.

  

Process finished with exit code 0
```

  
Inicialmente se crea una instancia de `InterfazUsuario` y se llama al metodo `InterfazUsuario.saveEmployeeId(String)`, el cual internamente llama al metodo   `OracleDatabase.saveEmpInDatabase(String)`, con la finalidad de guardar el *ID* del empleado en una base de datos *Oracle*.

  

### PREGUNTA 32
El problema es que el objeto de la clase `InterfazUsuario` (*de la capa superior*) depende de la clase concreta `OracleDatabase` (*de la capa inferior*). Por lo que  al querer cambiar a otra *base de datos* se tendrá que modificar las capas superiores que dependen de estas.  
  

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

**BUSCAR CASO EXCEPCIONAL (FALTA)**

  

### PREGUNTA 36

Que permite cambiar el objeto `BaseDatos` definido en la clase `IntefazUsurio` en cualquier momento.
