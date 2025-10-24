public class Ejercicio8 {
    //hecho por carlos y ayuda de alvaro. y corregido por el maestro
    public static void main(String[] args) {
        int[][] matriz1 = {{1, 2}, {4, 6}};
        int[][] matriz2 = {{4, 1}, {1, 0}};
        for (int i = 0; i < sumaDeMatrices(matriz1, matriz2).length; i++) {
            for (int j = 0; j < sumaDeMatrices(matriz1, matriz2)[i].length; j++) {
                System.out.print("[" + sumaDeMatrices(matriz1, matriz2)[i][j] + "]");
            }
            System.out.println();
        }
    }

    public static int[][] sumaDeMatrices(int[][] matriz1, int[][] matriz2) {
        int[][] error = {{-1}};
        if (Ejercicio7.comprobacionTamaño(matriz1, matriz2)) {
            int[][] suma = new int[matriz1.length][matriz1[0].length];
            for (int i = 0; i < matriz1.length; i++) {
                for (int j = 0; j < matriz1[i].length; j++) {
                    suma[i][j] = matriz1[i][j] + matriz2[i][j];
                }
            }
            return suma;
        }
        return error;
    }
}
