public class Ejercicio3 {
    public static void main(String[] args) {
        int[][] matriz = {{1, 3, 5}, {0, 2, 7}};
        ImprimirEnUnaSolaLinia(matriz);
    }

    public static void ImprimirEnUnaSolaLinia(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j]+" ");
            }
        }
    }
}
