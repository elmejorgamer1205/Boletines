import java.util.Arrays;

public class Ejercicio10 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 1, 2, 7, 8, 4, 6, 2, 5};
        System.out.println(Arrays.toString(arraySinDuplicados(array)));

    }

    public static int[] arraySinDuplicados(int[] array) {
        int posicion = 0;
        int[] arrayNuevo = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (contieneElemento(arrayNuevo, array[i])) {
                arrayNuevo[posicion] = array[i];
                posicion++;
            }
        }
        return arrayNuevo;
    }

    public static boolean contieneElemento(int[] array, int elementoABuscar) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == elementoABuscar) {
                return true;
            }
        }
        return false;
    }
}

