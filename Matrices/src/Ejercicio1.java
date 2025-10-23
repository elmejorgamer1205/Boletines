public class Ejercicio1 {
    public static void main(String[] args) {
        int[][] matriz = {{1, -2, 3, 4, 5}, {1, 2, 3, 4, 5}};
        if (comprobarNegeativos(matriz)) {
            System.out.print("En la matriz si hay un valor negativo");
        } else
            System.out.print("En la matriz no hay un valor negativo");


    }

    public static boolean comprobarNegeativos(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] < 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
