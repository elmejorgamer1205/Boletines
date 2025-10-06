import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce a: ");
        double a = sc.nextDouble();
        System.out.print("Introduce b: ");
        double b = sc.nextDouble();
        System.out.print("Introduce c: ");
        double c = sc.nextDouble();
        double discriminante = b * b - 4 * a * c;
        if (a == 0) {
            System.out.println("No es una ecuación de segundo grado.");
        } else if (discriminante > 0) {
            double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            System.out.println("Tiene dos soluciones: x1 = " + x1 + ", x2 = " + x2);
        } else if (discriminante == 0) {
            double x = -b / (2 * a);
            System.out.println("Tiene una solución doble: x = " + x);
        } else {
            System.out.println("No tiene soluciones reales.");
        }
        sc.close();
    }
}
