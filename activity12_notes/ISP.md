## ISP

### PREGUNTA 19
```txt

Se necesita cambiar una clase base o interfaz por las necesidades de las clases que implementan estas interfaces, pero esto a su vez implica implementar las nuevas funcionalidades en las clases que implementa esta interfaz

```

  
  

### PREGUNTA 20
```txt

El problema es que al ser ImpresoraAvanzada una implementación de la interfaz Impresora el método sendFax() de aquella está sobrescrito, por lo que cualquier modificación el los argumentos o el tipo de retorno en el método sobrescrito exige que se haga las mismas modificaciones en la definición del método sendFax() en la interfaz (violando el principio OCP), lo cual a su vez exige que se realicen las mismas modificaciones de la interfaz en las demás implementaciones de esta.

  

```

  
### PREGUNTA 21
```txt

Debido a que la definición del método sendFax() de la interfaz no es utilizada realmente en la implementación ImpresoraBasica es necesario que dicho método se saque de la interfaz, para que se cumpla el principio ISP.

```

  

### PREGUNTA 22
```txt

No es conveniente, ya que obliga a la clase ImpresoraBasica implementar una funcionalidad innecesaria y obliga a que se redefina cada vez que cambie el método innecesario de la interfaz.

```

  

### PREGUNTA 23
```txt

Se tendría que trasladar el método sendFax de la interfaz Impresora a la interfaz Fax, y de esta forma se implementa la interfaz Fax solo a las clases que necesiten hacer uso de éste método.

```

  

### PREGUNTA 24
```txt

Añadiendo el código de ejemplo se puede comprobar que efectivamente al instanciar un objeto de tipo Impresora como ImpresoraBasica, lanza un error al llamar el método sendFax en tiempo de ejecución.

```

  

### PREGUNTA 25
```txt

Se usó la expresión: 

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

  

Tanto los objetos de tipo Impresora, instanciados como ImpresoraBasica o ImpresoraAvancada, no tienen problema en llamar al método printDocument, pero en el caso de ImpresoraBasica, el método sendFax arroja una excepción, por la que no se la puede llamar desde este objeto. Para ello habría que verificar de antemano que el objeto instanciado sea de tipo ImpresoraAvanzada para estar seguro de poder llamar al método sendFax.

```

  

### PREGUNTA 27
```txt

Demostracion ISP

La impresora basica imprime un documento.

La impresora avanzada imprime un documento.

La impresora avanzada envía un fax.

  

Ahora las clases solo implementan las interfaces necesarias, que contienen sólo los métodos útiles para cada clase. De esta manera también se evita tener que sobreescribir los métodos innecesarios cada vez que se haga algún cambio en la interfaz.

```

  

### PREGUNTA 28
```txt

Este método predeterminado es heredado por todas las clases que implementen esta interfaz, que al ya tener cuerpo, no es necesario sobreescribir el método en cada una de las clases que la implementan.

```

  

### PREGUNTA 29
```txt

Análogamente, como sucede con cualquier otro método de la interfaz, si alguna clase que implemente esta interfaz, no necesite de este método, habría que sobreescribirlo.

```

  
  
### PREGUNTA 30
```txt

En ese caso el método no realiza ninguna acción. Aún si el método no tiene cuerpo y no genere errores de codificación, seguiría siendo un método inútil (lo cual violaría el principio ISP), el cual podría crear confusión al esperar alguna funcionalidad de éste.

```