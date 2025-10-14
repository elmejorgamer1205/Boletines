import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //La cantidad de espacios que deseamos que tenga el array
        System.out.print("Cuantos numeros desea que tenga el array: ");

        int numElementos = sc.nextInt();


        //Si pedimos un numero negativo lo trasforma en positivo
        if (numElementos < 0) {

            numElementos = -numElementos;

            System.out.println("El numero no debe ser negativo el error se ha autocorregido a " + numElementos);

        }


        //El array que vamos a rellenar
        int[] numeros = new int[numElementos];

        //Esta parte se va a dedicar a rellenar el array
        for (int i = 0; i < numElementos; i++) {

            System.out.print("Introduzca el numero " + (i + 1) + ": ");

            numeros[i] = sc.nextInt();

        }

        //Busca el número más grande y pequeño
        int valorMayor = numeros[0];

        int valorMenor = numeros[0];

        for (int a = 1; a < numElementos; a++) {

            if (numeros[a] > valorMayor) {
                valorMayor = numeros[a];
            }
            if (numeros[a] < valorMenor) {
                valorMenor = numeros[a];
            }

        }

        //Cuenta cuantas veces en el array el número mayor y menor
        int contMayor = 0;
        int contMenor = 0;

        for (int numero : numeros) {

            if (numero == valorMayor) {
                contMayor++;
            }

            if (numero == valorMenor) {
                contMenor++;
            }

        }

        //suma todos los numeros dentro del array
        int sumadeArrays = 0;

        for (int numero : numeros) {
            sumadeArrays += numero;
        }

        //Este se encarga de dar la media dentro del array
        double media = (double) sumadeArrays / numElementos;

        //Muestra los resultados
        System.out.println("El mayor número introducido es " + valorMayor);

        if (contMayor > 1) {

            System.out.println("El numero mayor se repite " + contMayor + " veces");

        }

        System.out.println("El menor número introducido es " + valorMenor);

        if (contMenor > 1) {

            System.out.println("El numero menor se repite " + contMenor + " veces");

        }

        System.out.println("La media de los números introducidos es: " + media);

    }