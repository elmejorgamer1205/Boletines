public class Ejercicio11 {
    public static void main(String[] args) {
        int[][] matriz1 = {{5, 8, 9, 0}, {4, 7, 5, 2}, {1, 7, 3, 2}};
        int[][] matriz2 = {{2, 3, 7, 1}, {2, 5, 7, 4}, {0, 9, 8, 5}};
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[i].length; j++) {
                System.out.print("[" + matriz1[i][j] + "]" + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < matriz2.length; i++) {
            for (int j = 0; j < matriz2[i].length; j++) {
                System.out.print("[" + matriz2[i][j] + "]" + " ");
            }
            System.out.println();
        }
        if (comprobarInverso(matriz1, matriz2)) {
            System.out.println("La matriz es inversa");
        } else {
            System.out.println("La matriz no es inversa");
        }
    }

    public static boolean comprobarInverso(int[][] matriz1, int[][] matriz2) {
        if (matriz1.length != matriz2.length || matriz1[0].length != matriz2[0].length) {
            return false;
        }
        int filas = matriz1.length;
        int columnas = matriz1[0].length;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz1[i][j] != matriz2[filas - 1 - i][columnas - 1 - j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

