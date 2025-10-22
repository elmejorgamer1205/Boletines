import java.util.Arrays;

public class Ejercicio12 {
    public static void main(String[] args) {
        int[] burbuja = {1, 5, 9, -1, 3};
        metodoBurbuja(burbuja);
        System.out.println(Arrays.toString(burbuja));

    }

    public static void metodoBurbuja(int[] burbuja) {
        int num = burbuja.length;
        for (int i = 0; i < num - 1; i++) {
            for (int j = 0; j < num - i - 1; j++) {
                if (burbuja[j] > burbuja[j + 1]) {
                    int tem = burbuja[j];
                    burbuja[j] = burbuja[j + 1];
                    burbuja[j + 1] = tem;
                }
            }
        }
    }
}


