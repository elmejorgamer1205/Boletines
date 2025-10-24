public class Ejercicio5{
    public static void main(String[] args) {
        int[][] matriz = {{1, 3, 5}, {0, 2, 7}};
        ImprimirEnUnaSolaLinia(matriz);
    }

    public static void ImprimirEnUnaSolaLinia(int[][] matriz) {
        for (int j = 0; j < matriz[0].length; j++) {
            for (int i = 0; i < matriz.length; i++) {
                System.out.print(matriz[i][j] + " ");
            }
        }
    }
}

