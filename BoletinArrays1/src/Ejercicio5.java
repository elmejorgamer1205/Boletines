import java.util.Random;

public class Ejercicio5 {
    public static void main() {

    }
    public static int[] generaArrayAleatorio(int tamaño){
        int [] array = new int[tamaño];
        Random numAleatorio = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = numAleatorio.nextInt(1000);
        }
        return array;
    }
}

