package Solid.SRP;

//static
//ClienteSolidSRP.method()
//instance.method()

//nos static
//ClienteSolidSRP.method() // NO SE PUEDE
//instance.method()

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
