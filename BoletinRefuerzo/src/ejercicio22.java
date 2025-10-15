import java.util.Scanner;

public class ejercicio22 {
    public static void main(String[] args) {
        //Creo un escaner para preguntar al usuario el número binario que quiere hacer la conversión
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba su número binario: ");
        int decimal = 0;
        int exponente = 0;
        //Creo un String para recoger el numero binario del usuario y lo convierta a cadena de texto
        String numBinario = sc.nextLine();
        for (int i = 0; i < numBinario.length(); i++) {
            char charBinario = numBinario.charAt(i);
            if (charBinario != '0' && charBinario != '1') {
                System.out.println("introduce solo los dígitos 1 y 0 para la conversión");
                numBinario = sc.nextLine();
            }
        }
        int valor = numBinario.charAt(numBinario.length() - 1) - '0';//resto de la división entre el caracter y el 0
        while (numBinario.length() > 0) {
            decimal += valor * Math.pow(2, exponente);
            exponente++;
            numBinario = numBinario.substring(0, numBinario.length() - 1);
            if (numBinario.length() > 0) {
                valor = numBinario.charAt(numBinario.length() - 1) - '0';
            }

        }
        System.out.println("El número binario " + numBinario + " en decimal es: " + decimal);

    }

}

