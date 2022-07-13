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

### PREGUNTA 2

La clase **Empleado** tiene multi responsabilidades (verifica si el empleado es Senior *checkSeniority* y generar el **ID** del empleado *generateEmId* y encapsula el objeto Empleado).

Posibles problemas:
* Fuerte acoplamiento entre la clase **Empleado** y sus clases clientes (debido a la multi reponsabilidad de la clase **Empleado**)


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