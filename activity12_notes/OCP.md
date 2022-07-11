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