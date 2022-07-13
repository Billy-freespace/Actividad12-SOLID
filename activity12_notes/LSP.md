## Principio de sustitución de Liskov - LSP

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
