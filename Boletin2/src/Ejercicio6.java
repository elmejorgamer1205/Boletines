import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int alumnos;
        do {
            System.out.print("Introduce el número de alumnos (positivo): ");
            alumnos = sc.nextInt();
        } while (alumnos <= 0);
        int aprobados = 0;
        int suspensos = 0;
        for (int i = 1; i <= alumnos; i++) {
            double nota;
            do {
                System.out.print("Introduce la nota del examen del " + i + "º alumno (0-10): ");
                nota = sc.nextDouble();
            } while (nota < 0 || nota > 10);
            if (nota >= 5) {
                aprobados++;
            } else {
                suspensos++;
            }
        }
        System.out.println("El número de aprobados es " + aprobados +
                " y el porcentaje es " + (int) ((aprobados / (double) alumnos) * 100) + "%");
        System.out.println("El número de suspensos es " + suspensos +
                " y el porcentaje es " + (int) ((suspensos / (double) alumnos) * 100) + "%");
    }
}