## SRP

### PREGUNTA 1

EXPLICAR (billy)

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
<<<<<<< SRP_temporal
=======
La inicialización de los objetos Empleado (jessica y chalo) es similar al caso No Solid. Luego de manera similar se pasa estos objetos como argumentos del método estático `Client.showEmpDetail(Empleado)`. A diferencia del caso No Solid, los métodos a los que se llamará `Client.showEmpDetail(Empleado)` son `(new GeneradorIDEmpleado()).generateEmpId(emp.firstName))` y `(new SeniorityChecker()).checkSeniority(emp.experienceInYears))` para asignar e imprimir un ID del empleado y verificar si este es de tipo Senior o Junior respectivamente.
>>>>>>> master
