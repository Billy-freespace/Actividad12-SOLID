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


Al comienzo se crea un objeto del tipo PaymentHelper, luego se crean 2 usuarios del tipo RegisteredUserPayment (que implementa la interfaz payment), por lo que se puede como parámetro del método addUser de la clase PaymentHelper (principio LSP). De forma similar también se crea un objeto del tipo GuestUserPayment, que también impleneta la interfaz payment, y se usa como paŕametro del método addUser de la clase PaymentHelper. 

Luego se llama al método showPreviousPaymentInfo que invoca el método previousPaymentInfo en cada uno de los objetos Payment almacenados en la lista que almacena el objeto helper (Dynamic Binding). De forma similar sucede con la llamada al método processNewPayment.

  

### PREGUNTA 13

Copiado el código de GuestUserPayment



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

  
La excepción lanzada es java.lang.UnsupportedOperationException. Una solución sería implementar este método (GuestUserPayment.perviousPaymentInfo) para evitar la excepción