public class Ejercicio2 {
    public static void main(String[] args){
        int[][] matriz = {{1,2,3}, {4,5,6}};
        System.out.println(sumaDeMatrices(matriz));

    }
    public static int sumaDeMatrices(int[][] matriz) {
        int suma = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                suma += matriz[i][j];
            }
        }
        return suma;
    }
}
